package androidx.activity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda0(ComponentActivity componentActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ComponentActivity this$0 = this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.invalidateMenu();
                return;
            default:
                ComponentActivity this$1 = this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                try {
                    super/*android.app.Activity*/.onBackPressed();
                    return;
                } catch (IllegalStateException e) {
                    if (!Intrinsics.areEqual(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e;
                    }
                    return;
                } catch (NullPointerException e2) {
                    if (!Intrinsics.areEqual(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                        throw e2;
                    }
                    return;
                }
        }
    }
}
