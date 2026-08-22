package com.facebook.login;

import androidx.activity.result.ActivityResult;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookSdk;
import com.facebook.internal.Validate;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.IncompleteStateBox;

/* JADX INFO: loaded from: classes.dex */
public final class LoginFragment$getLoginMethodHandlerCallback$1 extends Lambda implements Function1 {
    public final /* synthetic */ Object $activity;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginFragment$getLoginMethodHandlerCallback$1(Object obj, Object obj2, int i) {
        super(1);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$activity = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Incomplete incomplete;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$activity;
        Object obj3 = this.this$0;
        switch (this.$r8$classId) {
            case 0:
                ActivityResult result = (ActivityResult) obj;
                Intrinsics.checkNotNullParameter(result, "result");
                int i = result.resultCode;
                if (i == -1) {
                    LoginClient loginClient = ((LoginFragment) obj3).getLoginClient();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    Validate.sdkInitialized();
                    loginClient.onActivityResult(FacebookSdk.callbackRequestCodeOffset, i, result.data);
                } else {
                    ((FragmentActivity) obj2).finish();
                }
                return unit;
            default:
                Throwable th = (Throwable) obj;
                CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = (CallbackToFutureAdapter$Completer) obj3;
                if (th == null) {
                    Object state$kotlinx_coroutines_core = ((DeferredCoroutine) obj2).getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core instanceof Incomplete) {
                        throw new IllegalStateException("This job has not completed yet");
                    }
                    if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                        throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                    }
                    IncompleteStateBox incompleteStateBox = state$kotlinx_coroutines_core instanceof IncompleteStateBox ? (IncompleteStateBox) state$kotlinx_coroutines_core : null;
                    if (incompleteStateBox != null && (incomplete = incompleteStateBox.state) != null) {
                        state$kotlinx_coroutines_core = incomplete;
                    }
                    callbackToFutureAdapter$Completer.attemptedSetting = true;
                    CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = callbackToFutureAdapter$Completer.future;
                    if (callbackToFutureAdapter$SafeFuture != null) {
                        CallbackToFutureAdapter$SafeFuture.AnonymousClass1 anonymousClass1 = callbackToFutureAdapter$SafeFuture.delegate;
                        anonymousClass1.getClass();
                        if (state$kotlinx_coroutines_core == null) {
                            state$kotlinx_coroutines_core = AbstractResolvableFuture.NULL;
                        }
                        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(anonymousClass1, null, state$kotlinx_coroutines_core)) {
                            AbstractResolvableFuture.complete(anonymousClass1);
                            callbackToFutureAdapter$Completer.tag = null;
                            callbackToFutureAdapter$Completer.future = null;
                            callbackToFutureAdapter$Completer.cancellationFuture = null;
                        }
                    }
                } else if (th instanceof CancellationException) {
                    callbackToFutureAdapter$Completer.attemptedSetting = true;
                    CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture2 = callbackToFutureAdapter$Completer.future;
                    if (callbackToFutureAdapter$SafeFuture2 != null && callbackToFutureAdapter$SafeFuture2.delegate.cancel(true)) {
                        callbackToFutureAdapter$Completer.tag = null;
                        callbackToFutureAdapter$Completer.future = null;
                        callbackToFutureAdapter$Completer.cancellationFuture = null;
                    }
                } else {
                    callbackToFutureAdapter$Completer.attemptedSetting = true;
                    CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture3 = callbackToFutureAdapter$Completer.future;
                    if (callbackToFutureAdapter$SafeFuture3 != null && callbackToFutureAdapter$SafeFuture3.delegate.setException(th)) {
                        callbackToFutureAdapter$Completer.tag = null;
                        callbackToFutureAdapter$Completer.future = null;
                        callbackToFutureAdapter$Completer.cancellationFuture = null;
                    }
                }
                return unit;
        }
    }
}
