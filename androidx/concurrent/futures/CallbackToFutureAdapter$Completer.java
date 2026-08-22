package androidx.concurrent.futures;

import androidx.work.impl.utils.futures.AbstractFuture;

/* JADX INFO: loaded from: classes.dex */
public final class CallbackToFutureAdapter$Completer {
    public boolean attemptedSetting;
    public ResolvableFuture cancellationFuture;
    public CallbackToFutureAdapter$SafeFuture future;
    public Object tag;

    public final void finalize() {
        ResolvableFuture resolvableFuture;
        CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = this.future;
        if (callbackToFutureAdapter$SafeFuture != null) {
            CallbackToFutureAdapter$SafeFuture.AnonymousClass1 anonymousClass1 = callbackToFutureAdapter$SafeFuture.delegate;
            if (!anonymousClass1.isDone()) {
                anonymousClass1.setException(new AbstractFuture.Failure.AnonymousClass1("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag, 2));
            }
        }
        if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
            return;
        }
        resolvableFuture.set(null);
    }
}
