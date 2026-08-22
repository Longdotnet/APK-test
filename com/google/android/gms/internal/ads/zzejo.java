package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzejo {
    private final zzdgf zza;

    public zzejo(zzdgf zzdgfVar) {
        this.zza = zzdgfVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfcn zzfcnVar, zzfca zzfcaVar, View view, zzejk zzejkVar) {
        zzejm zzejmVar = new zzejm(this, new zzejl(this, zzfcaVar));
        zzdfc zzdfcVarZzd = this.zza.zzd(new zzcrq(zzfcnVar, zzfcaVar, null), zzejmVar);
        zzejkVar.zzd(new zzejn(this, zzdfcVarZzd));
        return zzdfcVarZzd.zzg();
    }
}
