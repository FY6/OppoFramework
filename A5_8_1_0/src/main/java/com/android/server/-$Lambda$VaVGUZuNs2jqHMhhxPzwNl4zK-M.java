package com.android.server;

final /* synthetic */ class -$Lambda$VaVGUZuNs2jqHMhhxPzwNl4zK-M implements Runnable {
    private final /* synthetic */ byte $id;
    /* renamed from: -$f0 */
    private final /* synthetic */ Object f51-$f0;

    private final /* synthetic */ void $m$0() {
        ((CommonTimeManagementService) this.f51-$f0).lambda$-com_android_server_CommonTimeManagementService_4910();
    }

    private final /* synthetic */ void $m$1() {
        ((CommonTimeManagementService) this.f51-$f0).lambda$-com_android_server_CommonTimeManagementService_4984();
    }

    private final /* synthetic */ void $m$2() {
        ((ConnectivityService) this.f51-$f0).lambda$-com_android_server_ConnectivityService_37477();
    }

    private final /* synthetic */ void $m$3() {
        ((PersistentDataBlockService) this.f51-$f0).m2lambda$-com_android_server_PersistentDataBlockService_5033();
    }

    private final /* synthetic */ void $m$4() {
        ((UiModeManagerService) this.f51-$f0).m32lambda$-com_android_server_UiModeManagerService_9177();
    }

    public /* synthetic */ -$Lambda$VaVGUZuNs2jqHMhhxPzwNl4zK-M(byte b, Object obj) {
        this.$id = b;
        this.f51-$f0 = obj;
    }

    public final void run() {
        switch (this.$id) {
            case (byte) 0:
                $m$0();
                return;
            case (byte) 1:
                $m$1();
                return;
            case (byte) 2:
                $m$2();
                return;
            case (byte) 3:
                $m$3();
                return;
            case (byte) 4:
                $m$4();
                return;
            default:
                throw new AssertionError();
        }
    }
}
