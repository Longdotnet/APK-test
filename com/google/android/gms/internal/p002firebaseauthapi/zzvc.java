package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: loaded from: classes.dex */
final class zzvc implements zzyg {
    final /* synthetic */ String zza;
    final /* synthetic */ zzxa zzb;
    final /* synthetic */ zzvf zzc;

    public zzvc(zzvf zzvfVar, String str, zzxa zzxaVar) {
        this.zzc = zzvfVar;
        this.zza = str;
        this.zzb = zzxaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyf
    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzzy zzzyVar = (zzzy) obj;
        String strZze = zzzyVar.zze();
        zzaao zzaaoVar = new zzaao();
        zzaaoVar.zze(strZze);
        zzaaoVar.zzg(this.zza);
        zzvf.zze(this.zzc, this.zzb, zzzyVar, zzaaoVar, this);
    }
}
