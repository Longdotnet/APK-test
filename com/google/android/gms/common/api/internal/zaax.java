package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zaax implements zabf {
    public final zabi zaa;

    public zaax(zabi zabiVar) {
        this.zaa = zabiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
        zabi zabiVar = this.zaa;
        Iterator it = zabiVar.zaa.values().iterator();
        while (it.hasNext()) {
            ((Api.Client) it.next()).disconnect();
        }
        zabiVar.zag.zad = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
        zabi zabiVar = this.zaa;
        zabiVar.zai.lock();
        try {
            zabiVar.zan = new zaaw(zabiVar, zabiVar.zac, zabiVar.zad, zabiVar.zal, zabiVar.zae, zabiVar.zai, zabiVar.zak);
            zabiVar.zan.zad();
            zabiVar.zaj.signalAll();
        } finally {
            zabiVar.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zag(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zai(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        return true;
    }
}
