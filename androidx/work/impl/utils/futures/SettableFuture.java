package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class SettableFuture extends AbstractFuture {
    public final boolean set(Object obj) {
        if (obj == null) {
            obj = AbstractFuture.NULL;
        }
        if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, obj)) {
            return false;
        }
        AbstractFuture.complete(this);
        return true;
    }

    public final boolean setException(Throwable th) {
        if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, new AbstractFuture.Failure(th))) {
            return false;
        }
        AbstractFuture.complete(this);
        return true;
    }

    public final boolean setFuture(ListenableFuture listenableFuture) {
        AbstractFuture.Failure failure;
        listenableFuture.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!AbstractFuture.ATOMIC_HELPER.casValue(this, null, AbstractFuture.getFutureValue(listenableFuture))) {
                    return false;
                }
                AbstractFuture.complete(this);
            } else {
                AbstractFuture.SetFuture setFuture = new AbstractFuture.SetFuture(this, listenableFuture);
                if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, setFuture)) {
                    try {
                        listenableFuture.addListener(setFuture, DirectExecutor.INSTANCE);
                    } catch (Throwable th) {
                        try {
                            failure = new AbstractFuture.Failure(th);
                        } catch (Throwable unused) {
                            failure = AbstractFuture.Failure.FALLBACK_INSTANCE;
                        }
                        AbstractFuture.ATOMIC_HELPER.casValue(this, setFuture, failure);
                    }
                } else {
                    obj = this.value;
                }
            }
            return true;
        }
        if (!(obj instanceof AbstractFuture.Cancellation)) {
            return false;
        }
        listenableFuture.cancel(((AbstractFuture.Cancellation) obj).wasInterrupted);
        return false;
    }
}
