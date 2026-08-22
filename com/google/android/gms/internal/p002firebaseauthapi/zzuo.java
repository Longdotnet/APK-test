package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: loaded from: classes.dex */
final class zzuo implements zzyg {
    final /* synthetic */ zzup zza;

    public zzuo(zzup zzupVar) {
        this.zza = zzupVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyf
    public final void zza(String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzzj zzzjVar = (zzzj) obj;
        zzzy zzzyVar = new zzzy(zzzjVar.zzc(), zzzjVar.zzb(), Long.valueOf(zzaaa.zza(zzzjVar.zzb())), "Bearer");
        zzup zzupVar = this.zza;
        zzupVar.zzc.zzO(zzzyVar, null, null, Boolean.FALSE, null, zzupVar.zzb, this);
    }
}
