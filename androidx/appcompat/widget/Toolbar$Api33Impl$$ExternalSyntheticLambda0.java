package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Toolbar$Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Toolbar$Api33Impl$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public final void onBackInvoked() {
        switch (this.$r8$classId) {
            case 0:
                ((Runnable) this.f$0).run();
                break;
            case 1:
                Function0 onBackInvoked = (Function0) this.f$0;
                Intrinsics.checkNotNullParameter(onBackInvoked, "$onBackInvoked");
                onBackInvoked.invoke();
                break;
            default:
                ((AppCompatDelegateImpl) this.f$0).onBackPressed();
                break;
        }
    }
}
