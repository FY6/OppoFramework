package android.accessibilityservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class AccessibilityServiceInfo implements Parcelable {
    public static final int CAPABILITY_CAN_CONTROL_MAGNIFICATION = 16;
    public static final int CAPABILITY_CAN_PERFORM_GESTURES = 32;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final Creator<AccessibilityServiceInfo> CREATOR = null;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_AUDIBLE = 4;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FEEDBACK_GENERIC = 16;
    public static final int FEEDBACK_HAPTIC = 2;
    public static final int FEEDBACK_SPOKEN = 1;
    public static final int FEEDBACK_VISUAL = 8;
    public static final int FLAG_FORCE_DIRECT_BOOT_AWARE = 65536;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    public static final int FLAG_RETRIEVE_INTERACTIVE_WINDOWS = 64;
    private static final String TAG_ACCESSIBILITY_SERVICE = "accessibility-service";
    private static final SparseArray<CapabilityInfo> sAvailableCapabilityInfos = null;
    public int eventTypes;
    public int feedbackType;
    public int flags;
    private int mCapabilities;
    private int mDescriptionResId;
    private String mId;
    private String mNonLocalizedDescription;
    private ResolveInfo mResolveInfo;
    private String mSettingsActivityName;
    public long notificationTimeout;
    public String[] packageNames;

    public static final class CapabilityInfo {
        public final int capability;
        public final int descResId;
        public final int titleResId;

        public CapabilityInfo(int capability, int titleResId, int descResId) {
            this.capability = capability;
            this.titleResId = titleResId;
            this.descResId = descResId;
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: android.accessibilityservice.AccessibilityServiceInfo.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 9 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: android.accessibilityservice.AccessibilityServiceInfo.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.accessibilityservice.AccessibilityServiceInfo.<clinit>():void");
    }

    public AccessibilityServiceInfo(ResolveInfo resolveInfo, Context context) throws XmlPullParserException, IOException {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        this.mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        this.mResolveInfo = resolveInfo;
        XmlResourceParser xmlResourceParser = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            xmlResourceParser = serviceInfo.loadXmlMetaData(packageManager, AccessibilityService.SERVICE_META_DATA);
            if (xmlResourceParser == null) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return;
            }
            int type = 0;
            while (type != 1 && type != 2) {
                type = xmlResourceParser.next();
            }
            if (TAG_ACCESSIBILITY_SERVICE.equals(xmlResourceParser.getName())) {
                TypedArray asAttributes = packageManager.getResourcesForApplication(serviceInfo.applicationInfo).obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.AccessibilityService);
                this.eventTypes = asAttributes.getInt(2, 0);
                String packageNamez = asAttributes.getString(3);
                if (packageNamez != null) {
                    this.packageNames = packageNamez.split("(\\s)*,(\\s)*");
                }
                this.feedbackType = asAttributes.getInt(4, 0);
                this.notificationTimeout = (long) asAttributes.getInt(5, 0);
                this.flags = asAttributes.getInt(6, 0);
                this.mSettingsActivityName = asAttributes.getString(1);
                if (asAttributes.getBoolean(7, false)) {
                    this.mCapabilities |= 1;
                }
                if (asAttributes.getBoolean(8, false)) {
                    this.mCapabilities |= 2;
                }
                if (asAttributes.getBoolean(9, false)) {
                    this.mCapabilities |= 4;
                }
                if (asAttributes.getBoolean(10, false)) {
                    this.mCapabilities |= 8;
                }
                if (asAttributes.getBoolean(11, false)) {
                    this.mCapabilities |= 16;
                }
                if (asAttributes.getBoolean(12, false)) {
                    this.mCapabilities |= 32;
                }
                TypedValue peekedValue = asAttributes.peekValue(0);
                if (peekedValue != null) {
                    this.mDescriptionResId = peekedValue.resourceId;
                    CharSequence nonLocalizedDescription = peekedValue.coerceToString();
                    if (nonLocalizedDescription != null) {
                        this.mNonLocalizedDescription = nonLocalizedDescription.toString().trim();
                    }
                }
                asAttributes.recycle();
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return;
            }
            throw new XmlPullParserException("Meta-data does not start withaccessibility-service tag");
        } catch (NameNotFoundException e) {
            throw new XmlPullParserException("Unable to create context for: " + serviceInfo.packageName);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public void updateDynamicallyConfigurableProperties(AccessibilityServiceInfo other) {
        this.eventTypes = other.eventTypes;
        this.packageNames = other.packageNames;
        this.feedbackType = other.feedbackType;
        this.notificationTimeout = other.notificationTimeout;
        this.flags = other.flags;
    }

    public void setComponentName(ComponentName component) {
        this.mId = component.flattenToShortString();
    }

    public String getId() {
        return this.mId;
    }

    public ResolveInfo getResolveInfo() {
        return this.mResolveInfo;
    }

    public String getSettingsActivityName() {
        return this.mSettingsActivityName;
    }

    public boolean getCanRetrieveWindowContent() {
        return (this.mCapabilities & 1) != 0;
    }

    public int getCapabilities() {
        return this.mCapabilities;
    }

    public void setCapabilities(int capabilities) {
        this.mCapabilities = capabilities;
    }

    public String getDescription() {
        return this.mNonLocalizedDescription;
    }

    public String loadDescription(PackageManager packageManager) {
        if (this.mDescriptionResId == 0) {
            return this.mNonLocalizedDescription;
        }
        ServiceInfo serviceInfo = this.mResolveInfo.serviceInfo;
        CharSequence description = packageManager.getText(serviceInfo.packageName, this.mDescriptionResId, serviceInfo.applicationInfo);
        if (description != null) {
            return description.toString().trim();
        }
        return null;
    }

    public boolean isDirectBootAware() {
        if ((this.flags & 65536) == 0) {
            return this.mResolveInfo.serviceInfo.directBootAware;
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flagz) {
        parcel.writeInt(this.eventTypes);
        parcel.writeStringArray(this.packageNames);
        parcel.writeInt(this.feedbackType);
        parcel.writeLong(this.notificationTimeout);
        parcel.writeInt(this.flags);
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mResolveInfo, 0);
        parcel.writeString(this.mSettingsActivityName);
        parcel.writeInt(this.mCapabilities);
        parcel.writeInt(this.mDescriptionResId);
        parcel.writeString(this.mNonLocalizedDescription);
    }

    private void initFromParcel(Parcel parcel) {
        this.eventTypes = parcel.readInt();
        this.packageNames = parcel.readStringArray();
        this.feedbackType = parcel.readInt();
        this.notificationTimeout = parcel.readLong();
        this.flags = parcel.readInt();
        this.mId = parcel.readString();
        this.mResolveInfo = (ResolveInfo) parcel.readParcelable(null);
        this.mSettingsActivityName = parcel.readString();
        this.mCapabilities = parcel.readInt();
        this.mDescriptionResId = parcel.readInt();
        this.mNonLocalizedDescription = parcel.readString();
    }

    public int hashCode() {
        return (this.mId == null ? 0 : this.mId.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityServiceInfo other = (AccessibilityServiceInfo) obj;
        if (this.mId == null) {
            if (other.mId != null) {
                return false;
            }
        } else if (!this.mId.equals(other.mId)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        appendEventTypes(stringBuilder, this.eventTypes);
        stringBuilder.append(", ");
        appendPackageNames(stringBuilder, this.packageNames);
        stringBuilder.append(", ");
        appendFeedbackTypes(stringBuilder, this.feedbackType);
        stringBuilder.append(", ");
        stringBuilder.append("notificationTimeout: ").append(this.notificationTimeout);
        stringBuilder.append(", ");
        appendFlags(stringBuilder, this.flags);
        stringBuilder.append(", ");
        stringBuilder.append("id: ").append(this.mId);
        stringBuilder.append(", ");
        stringBuilder.append("resolveInfo: ").append(this.mResolveInfo);
        stringBuilder.append(", ");
        stringBuilder.append("settingsActivityName: ").append(this.mSettingsActivityName);
        stringBuilder.append(", ");
        appendCapabilities(stringBuilder, this.mCapabilities);
        return stringBuilder.toString();
    }

    private static void appendFeedbackTypes(StringBuilder stringBuilder, int feedbackTypes) {
        stringBuilder.append("feedbackTypes:");
        stringBuilder.append("[");
        while (feedbackTypes != 0) {
            int feedbackTypeBit = 1 << Integer.numberOfTrailingZeros(feedbackTypes);
            stringBuilder.append(feedbackTypeToString(feedbackTypeBit));
            feedbackTypes &= ~feedbackTypeBit;
            if (feedbackTypes != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    private static void appendPackageNames(StringBuilder stringBuilder, String[] packageNames) {
        stringBuilder.append("packageNames:");
        stringBuilder.append("[");
        if (packageNames != null) {
            int packageNameCount = packageNames.length;
            for (int i = 0; i < packageNameCount; i++) {
                stringBuilder.append(packageNames[i]);
                if (i < packageNameCount - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.append("]");
    }

    private static void appendEventTypes(StringBuilder stringBuilder, int eventTypes) {
        stringBuilder.append("eventTypes:");
        stringBuilder.append("[");
        while (eventTypes != 0) {
            int eventTypeBit = 1 << Integer.numberOfTrailingZeros(eventTypes);
            stringBuilder.append(AccessibilityEvent.eventTypeToString(eventTypeBit));
            eventTypes &= ~eventTypeBit;
            if (eventTypes != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    private static void appendFlags(StringBuilder stringBuilder, int flags) {
        stringBuilder.append("flags:");
        stringBuilder.append("[");
        while (flags != 0) {
            int flagBit = 1 << Integer.numberOfTrailingZeros(flags);
            stringBuilder.append(flagToString(flagBit));
            flags &= ~flagBit;
            if (flags != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    private static void appendCapabilities(StringBuilder stringBuilder, int capabilities) {
        stringBuilder.append("capabilities:");
        stringBuilder.append("[");
        while (capabilities != 0) {
            int capabilityBit = 1 << Integer.numberOfTrailingZeros(capabilities);
            stringBuilder.append(capabilityToString(capabilityBit));
            capabilities &= ~capabilityBit;
            if (capabilities != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    public static String feedbackTypeToString(int feedbackType) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (feedbackType != 0) {
            int feedbackTypeFlag = 1 << Integer.numberOfTrailingZeros(feedbackType);
            feedbackType &= ~feedbackTypeFlag;
            switch (feedbackTypeFlag) {
                case 1:
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append("FEEDBACK_SPOKEN");
                    break;
                case 2:
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append("FEEDBACK_HAPTIC");
                    break;
                case 4:
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append("FEEDBACK_GENERIC");
                    break;
                case 32:
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append("FEEDBACK_BRAILLE");
                    break;
                default:
                    break;
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static String flagToString(int flag) {
        switch (flag) {
            case 1:
                return "DEFAULT";
            case 2:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case 4:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case 8:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 16:
                return "FLAG_REPORT_VIEW_IDS";
            case 32:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            case 64:
                return "FLAG_RETRIEVE_INTERACTIVE_WINDOWS";
            default:
                return null;
        }
    }

    public static String capabilityToString(int capability) {
        switch (capability) {
            case 1:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case 2:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case 4:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 8:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
            case 16:
                return "CAPABILITY_CAN_CONTROL_MAGNIFICATION";
            case 32:
                return "CAPABILITY_CAN_PERFORM_GESTURES";
            default:
                return "UNKNOWN";
        }
    }

    public List<CapabilityInfo> getCapabilityInfos() {
        if (this.mCapabilities == 0) {
            return Collections.emptyList();
        }
        int capabilities = this.mCapabilities;
        List<CapabilityInfo> capabilityInfos = new ArrayList();
        while (capabilities != 0) {
            int capabilityBit = 1 << Integer.numberOfTrailingZeros(capabilities);
            capabilities &= ~capabilityBit;
            CapabilityInfo capabilityInfo = (CapabilityInfo) sAvailableCapabilityInfos.get(capabilityBit);
            if (capabilityInfo != null) {
                capabilityInfos.add(capabilityInfo);
            }
        }
        return capabilityInfos;
    }
}
