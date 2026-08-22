package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class zaz implements zabz {
    public final /* synthetic */ zaaa zaa;

    public /* synthetic */ zaz(zaaa zaaaVar) {
        this.zaa = zaaaVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        zaaa zaaaVar = this.zaa;
        zaaaVar.zam.lock();
        try {
            zaaaVar.zak = connectionResult;
            zaaa.zap(zaaaVar);
        } finally {
            zaaaVar.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        zaaa zaaaVar = this.zaa;
        zaaaVar.zam.lock();
        try {
            zaaaVar.zak = ConnectionResult.RESULT_SUCCESS;
            zaaa.zap(zaaaVar);
        } finally {
            zaaaVar.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i, boolean z) {
        zaaa zaaaVar = this.zaa;
        Lock lock = zaaaVar.zam;
        Lock lock2 = zaaaVar.zam;
        lock.lock();
        try {
            if (zaaaVar.zal) {
                zaaaVar.zal = false;
                zaaaVar.zab.zac(i, z);
                zaaaVar.zak = null;
                zaaaVar.zaj = null;
            } else {
                zaaaVar.zal = true;
                zaaaVar.zad.onConnectionSuspended(i);
            }
        } finally {
            lock2.unlock();
        }
    }
}
