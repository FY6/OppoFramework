package java.io;

import dalvik.system.BlockGuard;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
class UnixFileSystem extends FileSystem {
    private ExpiringCache cache;
    private final char colon;
    private final String javaHome;
    private ExpiringCache javaHomePrefixCache;
    private final char slash;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.io.UnixFileSystem.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.io.UnixFileSystem.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.UnixFileSystem.<clinit>():void");
    }

    private native String canonicalize0(String str) throws IOException;

    private native boolean checkAccess0(File file, int i);

    private native boolean createDirectory0(File file);

    private native boolean createFileExclusively0(String str) throws IOException;

    private native boolean delete0(File file);

    private native int getBooleanAttributes0(String str);

    private native long getLastModifiedTime0(File file);

    private native long getLength0(File file);

    private native long getSpace0(File file, int i);

    private static native void initIDs();

    private native String[] list0(File file);

    private native boolean rename0(File file, File file2);

    private native boolean setLastModifiedTime0(File file, long j);

    private native boolean setPermission0(File file, int i, boolean z, boolean z2);

    private native boolean setReadOnly0(File file);

    public UnixFileSystem() {
        this.cache = new ExpiringCache();
        this.javaHomePrefixCache = new ExpiringCache();
        this.slash = ((String) AccessController.doPrivileged(new GetPropertyAction("file.separator"))).charAt(0);
        this.colon = ((String) AccessController.doPrivileged(new GetPropertyAction("path.separator"))).charAt(0);
        this.javaHome = (String) AccessController.doPrivileged(new GetPropertyAction("java.home"));
    }

    public char getSeparator() {
        return this.slash;
    }

    public char getPathSeparator() {
        return this.colon;
    }

    public String normalize(String pathname) {
        int index;
        int n = pathname.length();
        char[] normalized = pathname.toCharArray();
        char prevChar = 0;
        int i = 0;
        int index2 = 0;
        while (i < n) {
            char current = normalized[i];
            if (current == '/' && prevChar == '/') {
                index = index2;
            } else {
                index = index2 + 1;
                normalized[index2] = current;
            }
            prevChar = current;
            i++;
            index2 = index;
        }
        if (prevChar != '/' || n <= 1) {
            index = index2;
        } else {
            index = index2 - 1;
        }
        return index != n ? new String(normalized, 0, index) : pathname;
    }

    public int prefixLength(String pathname) {
        int i = 0;
        if (pathname.length() == 0) {
            return 0;
        }
        if (pathname.charAt(0) == '/') {
            i = 1;
        }
        return i;
    }

    public String resolve(String parent, String child) {
        if (child.isEmpty() || child.equals("/")) {
            return parent;
        }
        if (child.charAt(0) == '/') {
            if (parent.equals("/")) {
                return child;
            }
            return parent + child;
        } else if (parent.equals("/")) {
            return parent + child;
        } else {
            return parent + '/' + child;
        }
    }

    public String getDefaultParent() {
        return "/";
    }

    public String fromURIPath(String path) {
        String p = path;
        if (!path.endsWith("/") || path.length() <= 1) {
            return p;
        }
        return path.substring(0, path.length() - 1);
    }

    public boolean isAbsolute(File f) {
        return f.getPrefixLength() != 0;
    }

    public String resolve(File f) {
        if (isAbsolute(f)) {
            return f.getPath();
        }
        return resolve(System.getProperty("user.dir"), f.getPath());
    }

    public String canonicalize(String path) throws IOException {
        if (!useCanonCaches) {
            return canonicalize0(path);
        }
        String res = this.cache.get(path);
        if (res == null) {
            String resDir;
            String dir = null;
            if (useCanonPrefixCache) {
                dir = parentOrNull(path);
                if (dir != null) {
                    resDir = this.javaHomePrefixCache.get(dir);
                    if (resDir != null) {
                        String filename = path.substring(dir.length() + 1);
                        res = resDir + this.slash + filename;
                        this.cache.put(dir + this.slash + filename, res);
                    }
                }
            }
            if (res == null) {
                BlockGuard.getThreadPolicy().onReadFromDisk();
                res = canonicalize0(path);
                this.cache.put(path, res);
                if (useCanonPrefixCache && dir != null && dir.startsWith(this.javaHome)) {
                    resDir = parentOrNull(res);
                    if (resDir != null && resDir.equals(dir)) {
                        File f = new File(res);
                        if (f.exists() && !f.isDirectory()) {
                            this.javaHomePrefixCache.put(dir, resDir);
                        }
                    }
                }
            }
        }
        return res;
    }

    static String parentOrNull(String path) {
        if (path == null) {
            return null;
        }
        char sep = File.separatorChar;
        int last = path.length() - 1;
        int idx = last;
        int adjacentDots = 0;
        int nonDotCount = 0;
        while (idx > 0) {
            char c = path.charAt(idx);
            if (c == '.') {
                adjacentDots++;
                if (adjacentDots >= 2) {
                    return null;
                }
            } else if (c != sep) {
                nonDotCount++;
                adjacentDots = 0;
            } else if ((adjacentDots == 1 && nonDotCount == 0) || idx == 0 || idx >= last - 1 || path.charAt(idx - 1) == sep) {
                return null;
            } else {
                return path.substring(0, idx);
            }
            idx--;
        }
        return null;
    }

    public int getBooleanAttributes(File f) {
        boolean hidden;
        int i = 0;
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int rv = getBooleanAttributes0(f.getPath());
        String name = f.getName();
        if (name.length() <= 0 || name.charAt(0) != '.') {
            hidden = false;
        } else {
            hidden = true;
        }
        if (hidden) {
            i = 8;
        }
        return i | rv;
    }

    public boolean checkAccess(File f, int access) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return checkAccess0(f, access);
    }

    public long getLastModifiedTime(File f) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return getLastModifiedTime0(f);
    }

    public long getLength(File f) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return getLength0(f);
    }

    public boolean setPermission(File f, int access, boolean enable, boolean owneronly) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return setPermission0(f, access, enable, owneronly);
    }

    public boolean createFileExclusively(String path) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return createFileExclusively0(path);
    }

    public boolean delete(File f) {
        this.cache.clear();
        this.javaHomePrefixCache.clear();
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return delete0(f);
    }

    public String[] list(File f) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return list0(f);
    }

    public boolean createDirectory(File f) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return createDirectory0(f);
    }

    public boolean rename(File f1, File f2) {
        this.cache.clear();
        this.javaHomePrefixCache.clear();
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return rename0(f1, f2);
    }

    public boolean setLastModifiedTime(File f, long time) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return setLastModifiedTime0(f, time);
    }

    public boolean setReadOnly(File f) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return setReadOnly0(f);
    }

    public File[] listRoots() {
        try {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkRead("/");
            }
            File[] fileArr = new File[1];
            fileArr[0] = new File("/");
            return fileArr;
        } catch (SecurityException e) {
            return new File[0];
        }
    }

    public long getSpace(File f, int t) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return getSpace0(f, t);
    }

    public int compare(File f1, File f2) {
        return f1.getPath().compareTo(f2.getPath());
    }

    public int hashCode(File f) {
        return f.getPath().hashCode() ^ 1234321;
    }
}
