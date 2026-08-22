package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdty extends zzbxb {
    final /* synthetic */ zzdua zza;

    public zzdty(zzdua zzduaVar) {
        Objects.requireNonNull(zzduaVar);
        this.zza = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zze(int i) {
        zzdua zzduaVar = this.zza;
        zzduaVar.zzb.zzm(zzduaVar.zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdua zzduaVar = this.zza;
        zzduaVar.zzb.zzm(zzduaVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzg() {
        zzdua zzduaVar = this.zza;
        zzduaVar.zzb.zzp(zzduaVar.zza);
    }
}
