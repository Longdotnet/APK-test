package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    public final WeakReference zag;
    public final zacz zah;
    public ResultTransform zaa = null;
    public zada zab = null;
    public volatile ResultCallbacks zac = null;
    public PendingResult zad = null;
    public final Object zae = new Object();
    public Status zaf = null;
    public boolean zai = false;

    public zada(WeakReference weakReference) {
        zzah.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        this.zah = new zacz(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    public static final void zan(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        synchronized (this.zae) {
            try {
                if (!result.getStatus().isSuccess()) {
                    zaj(result.getStatus());
                    zan(result);
                } else if (this.zaa != null) {
                    zaco.zaa().submit(new zacy(this, result));
                } else {
                    if ((this.zac == null || ((GoogleApiClient) this.zag.get()) == null) ? false : true) {
                        ResultCallbacks resultCallbacks = this.zac;
                        zzah.checkNotNull(resultCallbacks);
                        resultCallbacks.onSuccess(result);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zada zadaVar;
        synchronized (this.zae) {
            zzah.checkState(this.zaa == null, "Cannot call then() twice.");
            zzah.checkState(this.zac == null, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zadaVar = new zada(this.zag);
            this.zab = zadaVar;
            zak();
        }
        return zadaVar;
    }

    public final void zai(PendingResult pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zak();
        }
    }

    public final void zaj(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zal(status);
        }
    }

    public final void zak() {
        if (this.zaa == null && this.zac == null) {
            return;
        }
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
        if (!this.zai && this.zaa != null && googleApiClient != null) {
            googleApiClient.zao(this);
            this.zai = true;
        }
        Status status = this.zaf;
        if (status != null) {
            zal(status);
            return;
        }
        PendingResult pendingResult = this.zad;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    public final void zal(Status status) {
        synchronized (this.zae) {
            try {
                ResultTransform resultTransform = this.zaa;
                if (resultTransform != null) {
                    Status statusOnFailure = resultTransform.onFailure(status);
                    zzah.checkNotNull(statusOnFailure, "onFailure must not return null");
                    zada zadaVar = this.zab;
                    zzah.checkNotNull(zadaVar);
                    zadaVar.zaj(statusOnFailure);
                } else {
                    if ((this.zac == null || ((GoogleApiClient) this.zag.get()) == null) ? false : true) {
                        ResultCallbacks resultCallbacks = this.zac;
                        zzah.checkNotNull(resultCallbacks);
                        resultCallbacks.onFailure(status);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zae) {
            zzah.checkState(this.zac == null, "Cannot call andFinally() twice.");
            zzah.checkState(this.zaa == null, PZmDzEagKNdW.nsjqcnMZB);
            this.zac = resultCallbacks;
            zak();
        }
    }
}
