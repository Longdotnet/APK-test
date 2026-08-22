package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Window window;
        View viewPeekDecorView;
        switch (this.$r8$classId) {
            case 0:
                ComponentActivity componentActivity = (ComponentActivity) this.f$0;
                if (event == Lifecycle.Event.ON_STOP && (window = componentActivity.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                ComponentActivity.$r8$lambda$ibk6u1HK7J3AWKL_Wn934v2UVI8((ComponentActivity) this.f$0, lifecycleOwner, event);
                break;
            default:
                SavedStateRegistry this$0 = (SavedStateRegistry) this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (event == Lifecycle.Event.ON_START) {
                    this$0.isAllowingSavingState = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    this$0.isAllowingSavingState = false;
                }
                break;
        }
    }
}
