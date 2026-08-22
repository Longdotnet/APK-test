package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zaaj implements zabf {
    public final zabi zaa;
    public boolean zab = false;

    public zaaj(zabi zabiVar) {
        this.zaa = zabiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zab(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = this.zaa;
        try {
            zadc zadcVar = zabiVar.zag.zai;
            zadcVar.zab.add(apiMethodImpl);
            apiMethodImpl.zan(zadcVar.zac);
            zabe zabeVar = zabiVar.zag;
            Api.Client client = (Api.Client) zabeVar.zac.get(apiMethodImpl.getClientKey());
            zzah.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !zabiVar.zab.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.run(client);
            } else {
                apiMethodImpl.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            zaah zaahVar = new zaah(this, this);
            zabh zabhVar = zabiVar.zam;
            zabhVar.sendMessage(zabhVar.obtainMessage(1, zaahVar));
        }
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
        if (this.zab) {
            this.zab = false;
            zaai zaaiVar = new zaai(this, this);
            zabh zabhVar = this.zaa.zam;
            zabhVar.sendMessage(zabhVar.obtainMessage(1, zaaiVar));
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
        zabi zabiVar = this.zaa;
        zabiVar.zak(null);
        zabiVar.zah.zac(i, this.zab);
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        if (this.zab) {
            return false;
        }
        HashSet hashSet = this.zaa.zag.zah;
        if (hashSet == null || hashSet.isEmpty()) {
            this.zaa.zak(null);
            return true;
        }
        this.zab = true;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((zada) it.next()).zac = null;
        }
        return false;
    }
}
