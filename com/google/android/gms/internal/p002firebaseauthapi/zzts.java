package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzts implements zzyg {
    final /* synthetic */ zzyf zza;
    final /* synthetic */ zzxa zzb;
    final /* synthetic */ zzzy zzc;
    final /* synthetic */ zzaao zzd;
    final /* synthetic */ zzvf zze;

    public zzts(zzvf zzvfVar, zzyf zzyfVar, zzxa zzxaVar, zzzy zzzyVar, zzaao zzaaoVar) {
        this.zze = zzvfVar;
        this.zza = zzyfVar;
        this.zzb = zzxaVar;
        this.zzc = zzzyVar;
        this.zzd = zzaaoVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyf
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzyg
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listZzb = ((zzzp) obj).zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzvf.zzf(this.zze, this.zzb, this.zzc, (zzzr) listZzb.get(0), this.zzd, this.zza);
        }
    }
}
