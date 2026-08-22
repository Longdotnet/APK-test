package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {
    public final WeakReference zaa;

    public zaar(zaaw zaawVar) {
        this.zaa = new WeakReference(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zaaw zaawVar = (zaaw) this.zaa.get();
        if (zaawVar == null) {
            return;
        }
        zaaq zaaqVar = new zaaq(zaawVar, zaawVar, zakVar);
        zabh zabhVar = zaawVar.zaa.zam;
        zabhVar.sendMessage(zabhVar.obtainMessage(1, zaaqVar));
    }
}
