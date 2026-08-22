package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: loaded from: classes.dex */
final class zzuz implements zzyg {
    final /* synthetic */ zzxa zza;
    final /* synthetic */ zzvf zzb;

    public zzuz(zzvf zzvfVar, zzxa zzxaVar) {
        this.zzb = zzvfVar;
        this.zza = zzxaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyf
    public final void zza(String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaar zzaarVar = (zzaar) obj;
        this.zzb.zzO(new zzzy(zzaarVar.zzd(), zzaarVar.zzc(), Long.valueOf(zzaarVar.zzb()), "Bearer"), null, null, Boolean.TRUE, null, this.zza, this);
    }
}
