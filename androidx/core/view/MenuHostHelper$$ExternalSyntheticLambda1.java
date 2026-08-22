package androidx.core.view;

import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.$r8$classId) {
            case 0:
                Lifecycle.Event event2 = Lifecycle.Event.ON_DESTROY;
                MenuHostHelper menuHostHelper = (MenuHostHelper) this.f$0;
                if (event != event2) {
                    menuHostHelper.getClass();
                } else {
                    menuHostHelper.removeMenuProvider((MenuProvider) this.f$1);
                }
                break;
            default:
                OnBackPressedDispatcher dispatcher = (OnBackPressedDispatcher) this.f$0;
                Intrinsics.checkNotNullParameter(dispatcher, "$dispatcher");
                ComponentActivity this$0 = (ComponentActivity) this.f$1;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (event == Lifecycle.Event.ON_CREATE) {
                    OnBackInvokedDispatcher invoker = ComponentActivity.Api33Impl.INSTANCE.getOnBackInvokedDispatcher(this$0);
                    Intrinsics.checkNotNullParameter(invoker, "invoker");
                    dispatcher.invokedDispatcher = invoker;
                    dispatcher.updateBackInvokedCallbackState(dispatcher.hasEnabledCallbacks);
                }
                break;
        }
    }
}
