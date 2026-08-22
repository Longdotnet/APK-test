package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzgr extends zzgp<zzgq, zzgq> {
    @Override // com.google.android.gms.internal.auth.zzgp
    public final /* bridge */ /* synthetic */ zzgq zza(Object obj) {
        return ((zzeq) obj).zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzgp
    public final /* bridge */ /* synthetic */ zzgq zzb(zzgq zzgqVar, zzgq zzgqVar2) {
        zzgq zzgqVar3 = zzgqVar2;
        return zzgqVar3.equals(zzgq.zza()) ? zzgqVar : zzgq.zzb(zzgqVar, zzgqVar3);
    }

    @Override // com.google.android.gms.internal.auth.zzgp
    public final /* bridge */ /* synthetic */ zzgq zzc() {
        return zzgq.zzc();
    }

    @Override // com.google.android.gms.internal.auth.zzgp
    public final /* bridge */ /* synthetic */ void zzd(zzgq zzgqVar, int i, long j) {
        zzgqVar.zzf(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.auth.zzgp
    public final void zze(Object obj) {
        ((zzeq) obj).zzc.zzd();
    }

    @Override // com.google.android.gms.internal.auth.zzgp
    public final /* bridge */ /* synthetic */ void zzf(Object obj, zzgq zzgqVar) {
        ((zzeq) obj).zzc = zzgqVar;
    }
}
