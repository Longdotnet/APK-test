package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zzah;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {
    public final WeakReference zaa;
    public final Api zab;
    public final boolean zac;

    public zaal(zaaw zaawVar, Api api, boolean z) {
        this.zaa = new WeakReference(zaawVar);
        this.zab = api;
        this.zac = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zaaw zaawVar = (zaaw) this.zaa.get();
        if (zaawVar == null) {
            return;
        }
        zzah.checkState(Looper.myLooper() == zaawVar.zaa.zag.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        Lock lock = zaawVar.zab;
        lock.lock();
        try {
            if (zaawVar.zaG(0)) {
                if (!connectionResult.isSuccess()) {
                    zaawVar.zaE(connectionResult, this.zab, this.zac);
                }
                if (zaawVar.zaH()) {
                    zaawVar.zaF();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
