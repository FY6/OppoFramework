package android.app;

import com.android.internal.graphics.palette.Palette.Swatch;
import java.util.Comparator;
import java.util.function.Predicate;

final /* synthetic */ class -$Lambda$xNlQtks0cIOkqsInCE_AAmZWgcY implements Comparator {
    public static final /* synthetic */ -$Lambda$xNlQtks0cIOkqsInCE_AAmZWgcY $INST$0 = new -$Lambda$xNlQtks0cIOkqsInCE_AAmZWgcY();

    /* renamed from: android.app.-$Lambda$xNlQtks0cIOkqsInCE_AAmZWgcY$1 */
    final /* synthetic */ class AnonymousClass1 implements Predicate {
        /* renamed from: -$f0 */
        private final /* synthetic */ float f48-$f0;

        private final /* synthetic */ boolean $m$0(Object arg0) {
            return WallpaperColors.m18lambda$-android_app_WallpaperColors_6256(this.f48-$f0, (Swatch) arg0);
        }

        public /* synthetic */ AnonymousClass1(float f) {
            this.f48-$f0 = f;
        }

        public final boolean test(Object obj) {
            return $m$0(obj);
        }
    }

    private /* synthetic */ -$Lambda$xNlQtks0cIOkqsInCE_AAmZWgcY() {
    }

    public final int compare(Object obj, Object obj2) {
        return $m$0(obj, obj2);
    }
}
