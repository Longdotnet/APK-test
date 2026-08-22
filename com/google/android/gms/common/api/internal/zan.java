package com.google.android.gms.common.api.internal;

import android.app.AlertDialog;

/* JADX INFO: loaded from: classes.dex */
final class zan extends zabw {
    public final /* synthetic */ AlertDialog zaa;
    public final /* synthetic */ zao zab;

    public zan(zao zaoVar, AlertDialog alertDialog) {
        this.zab = zaoVar;
        this.zaa = alertDialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zap zapVar = this.zab.zaa;
        zapVar.zab.set(null);
        zapVar.zac();
        AlertDialog alertDialog = this.zaa;
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
}
