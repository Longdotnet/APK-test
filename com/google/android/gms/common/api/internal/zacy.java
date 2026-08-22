package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
final class zacy implements Runnable {
    public final /* synthetic */ Result zaa;
    public final /* synthetic */ zada zab;

    public zacy(zada zadaVar, Result result) {
        this.zab = zadaVar;
        this.zaa = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result result = this.zaa;
        zada zadaVar = this.zab;
        try {
            ThreadLocal threadLocal = BasePendingResult.zaa;
            threadLocal.set(Boolean.TRUE);
            ResultTransform resultTransform = zadaVar.zaa;
            zzah.checkNotNull(resultTransform);
            PendingResult pendingResultOnSuccess = resultTransform.onSuccess(result);
            zacz zaczVar = zadaVar.zah;
            zaczVar.sendMessage(zaczVar.obtainMessage(0, pendingResultOnSuccess));
            threadLocal.set(Boolean.FALSE);
            zada.zan(result);
            if (((GoogleApiClient) zadaVar.zag.get()) != null) {
            }
        } catch (RuntimeException e) {
            zacz zaczVar2 = zadaVar.zah;
            zaczVar2.sendMessage(zaczVar2.obtainMessage(1, e));
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(result);
            if (((GoogleApiClient) zadaVar.zag.get()) != null) {
            }
        } finally {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(result);
            GoogleApiClient googleApiClient = (GoogleApiClient) zadaVar.zag.get();
            if (googleApiClient != null) {
                googleApiClient.zap(zadaVar);
            }
        }
    }
}
