package com.android.server.updates;

import android.content.Context;
import android.content.Intent;
import android.os.SystemProperties;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Base64;
import android.util.Slog;
import com.android.server.LocationManagerService;
import com.android.server.pm.CompatibilityHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import libcore.io.IoUtils;

public class SELinuxPolicyInstallReceiver extends ConfigUpdateInstallReceiver {
    private static final String TAG = "SELinuxPolicyInstallReceiver";
    private static final String fileContextsPath = "file_contexts.bin";
    private static final String macPermissionsPath = "mac_permissions.xml";
    private static final String propertyContextsPath = "property_contexts";
    private static final String seappContextsPath = "seapp_contexts";
    private static final String sepolicyPath = "sepolicy";
    private static final String serviceContextsPath = "service_contexts";
    private static final String versionPath = "selinux_version";

    public SELinuxPolicyInstallReceiver() {
        super("/data/security/bundle", "sepolicy_bundle", "metadata/", CompatibilityHelper.VERSION_NAME);
    }

    private int readInt(BufferedInputStream reader) throws IOException {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value = (value << 8) | reader.read();
        }
        return value;
    }

    private int[] readChunkLengths(BufferedInputStream bundle) throws IOException {
        return new int[]{readInt(bundle), readInt(bundle), readInt(bundle), readInt(bundle), readInt(bundle), readInt(bundle), readInt(bundle)};
    }

    private void installFile(File destination, BufferedInputStream stream, int length) throws IOException {
        byte[] chunk = new byte[length];
        stream.read(chunk, 0, length);
        writeUpdate(this.updateDir, destination, Base64.decode(chunk, 0));
    }

    private void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        fileOrDirectory.delete();
    }

    private void unpackBundle() throws IOException {
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(this.updateContent));
        File tmp = new File(this.updateDir.getParentFile(), "tmp");
        try {
            int[] chunkLengths = readChunkLengths(stream);
            deleteRecursive(tmp);
            tmp.mkdirs();
            installFile(new File(tmp, versionPath), stream, chunkLengths[0]);
            installFile(new File(tmp, macPermissionsPath), stream, chunkLengths[1]);
            installFile(new File(tmp, seappContextsPath), stream, chunkLengths[2]);
            installFile(new File(tmp, propertyContextsPath), stream, chunkLengths[3]);
            installFile(new File(tmp, fileContextsPath), stream, chunkLengths[4]);
            installFile(new File(tmp, sepolicyPath), stream, chunkLengths[5]);
            installFile(new File(tmp, serviceContextsPath), stream, chunkLengths[6]);
        } finally {
            IoUtils.closeQuietly(stream);
        }
    }

    private void applyUpdate() throws IOException, ErrnoException {
        Slog.i(TAG, "Applying SELinux policy");
        File backup = new File(this.updateDir.getParentFile(), "backup");
        File current = new File(this.updateDir.getParentFile(), "current");
        File tmp = new File(this.updateDir.getParentFile(), "tmp");
        if (current.exists()) {
            deleteRecursive(backup);
            Os.rename(current.getPath(), backup.getPath());
        }
        try {
            Os.rename(tmp.getPath(), current.getPath());
            SystemProperties.set("selinux.reload_policy", LocationManagerService.OPPO_FAKE_LOCATOIN_SWITCH_ON);
        } catch (ErrnoException e) {
            Slog.e(TAG, "Could not update selinux policy: ", e);
            if (backup.exists()) {
                Os.rename(backup.getPath(), current.getPath());
            }
        }
    }

    protected void postInstall(Context context, Intent intent) {
        try {
            unpackBundle();
            applyUpdate();
        } catch (IllegalArgumentException e) {
            Slog.e(TAG, "SELinux policy update malformed: ", e);
        } catch (IOException e2) {
            Slog.e(TAG, "Could not update selinux policy: ", e2);
        } catch (ErrnoException e3) {
            Slog.e(TAG, "Could not update selinux policy: ", e3);
        }
    }
}
