package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal zaa = new zaq();
    public static final /* synthetic */ int zad = 0;
    private zas resultGuardian;
    protected final CallbackHandler zab;
    protected final WeakReference zac;
    private final Object zae;
    private final CountDownLatch zaf;
    private final ArrayList zag;
    private ResultCallback zah;
    private final AtomicReference zai;
    private Result zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private ICancelToken zao;
    private volatile zada zap;
    private boolean zaq;

    @Deprecated
    public BasePendingResult(Looper looper) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        this.zab = new CallbackHandler(looper);
        this.zac = new WeakReference(null);
    }

    public static void zal(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        zzah.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    statusListener.onComplete(this.zak);
                } else {
                    this.zag.add(statusListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @ResultIgnorabilityUnspecified
    public final R await() {
        zzah.checkNotMainThread("await must not be called on the UI thread");
        zzah.checkState(!this.zal, "Result has already been consumed");
        zzah.checkState(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        zzah.checkState(isReady(), "Result is not ready.");
        return (R) zaa();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zae) {
            try {
                if (!this.zam && !this.zal) {
                    zal(this.zaj);
                    this.zam = true;
                    zab(createFailedResult(Status.RESULT_CANCELED));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract R createFailedResult(Status status);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            try {
                if (!isReady()) {
                    setResult(createFailedResult(status));
                    this.zan = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        boolean z;
        synchronized (this.zae) {
            z = this.zam;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zae) {
        }
    }

    public final void setResult(R r) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(r);
                    return;
                }
                isReady();
                zzah.checkState(!isReady(), "Results have already been set");
                zzah.checkState(!this.zal, "Result has already been consumed");
                zab(r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.zae) {
            try {
                if (resultCallback == null) {
                    this.zah = null;
                    return;
                }
                boolean z = true;
                zzah.checkState(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z = false;
                }
                zzah.checkState(z, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.zaa(resultCallback, zaa());
                } else {
                    this.zah = resultCallback;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Result zaa() {
        Result result;
        synchronized (this.zae) {
            zzah.checkState(!this.zal, "Result has already been consumed.");
            zzah.checkState(isReady(), "Result is not ready.");
            result = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        zadb zadbVar = (zadb) this.zai.getAndSet(null);
        if (zadbVar != null) {
            zadbVar.zaa.zab.remove(this);
        }
        zzah.checkNotNull(result);
        return result;
    }

    public final void zab(Result result) {
        this.zaj = result;
        this.zak = result.getStatus();
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            ResultCallback resultCallback = this.zah;
            if (resultCallback != null) {
                this.zab.removeMessages(2);
                this.zab.zaa(resultCallback, zaa());
            } else if (this.zaj instanceof Releasable) {
                this.resultGuardian = new zas(this);
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((PendingResult.StatusListener) arrayList.get(i)).onComplete(this.zak);
        }
        this.zag.clear();
    }

    public final void zak() {
        boolean z = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z = false;
        }
        this.zaq = z;
    }

    public final boolean zam() {
        boolean zIsCanceled;
        synchronized (this.zae) {
            try {
                if (((GoogleApiClient) this.zac.get()) == null || !this.zaq) {
                    cancel();
                }
                zIsCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsCanceled;
    }

    public final void zan(zadb zadbVar) {
        this.zai.set(zadbVar);
    }

    /* JADX INFO: loaded from: classes.dex */
    public static class CallbackHandler<R extends Result> extends com.google.android.gms.internal.base.zau {
        public CallbackHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    Log.wtf("BasePendingResult", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Don't know how to handle message: "), new Exception());
                    return;
                } else {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
                    return;
                }
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.onResult(result);
            } catch (RuntimeException e) {
                BasePendingResult.zal(result);
                throw e;
            }
        }

        public final void zaa(ResultCallback resultCallback, Result result) {
            int i = BasePendingResult.zad;
            zzah.checkNotNull(resultCallback);
            sendMessage(obtainMessage(1, new Pair(resultCallback, result)));
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> transformedResultThen;
        zzah.checkState(!this.zal, nYVxXTZQ.eZNBWpEynIS);
        synchronized (this.zae) {
            try {
                zzah.checkState(this.zap == null, "Cannot call then() twice.");
                zzah.checkState(this.zah == null, "Cannot call then() if callbacks are set.");
                zzah.checkState(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new zada(this.zac);
                transformedResultThen = this.zap.then(resultTransform);
                if (isReady()) {
                    this.zab.zaa(this.zap, zaa());
                } else {
                    this.zah = this.zap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return transformedResultThen;
    }

    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        this.zab = new CallbackHandler(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zac = new WeakReference(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @ResultIgnorabilityUnspecified
    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            zzah.checkNotMainThread(oKjScaD.ZZNoOogshYELDjd);
        }
        zzah.checkState(!this.zal, "Result has already been consumed.");
        zzah.checkState(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        zzah.checkState(isReady(), "Result is not ready.");
        return (R) zaa();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (resultCallback == null) {
                    this.zah = null;
                    return;
                }
                boolean z = true;
                zzah.checkState(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z = false;
                }
                zzah.checkState(z, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.zaa(resultCallback, zaa());
                } else {
                    this.zah = resultCallback;
                    CallbackHandler callbackHandler = this.zab;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public BasePendingResult(CallbackHandler<R> callbackHandler) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList();
        this.zai = new AtomicReference();
        this.zaq = false;
        zzah.checkNotNull(callbackHandler, ygoi.QApEyzVPVeWNAnw);
        this.zab = callbackHandler;
        this.zac = new WeakReference(null);
    }
}
