package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhg implements zzddi, zzcwo, zzddm {
    private final zzfhu zza;
    private final zzfhj zzb;

    public zzfhg(Context context, zzfhu zzfhuVar) {
        this.zza = zzfhuVar;
        this.zzb = zzfhi.zza(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzb() {
        if (((Boolean) zzbex.zzd.zze()).booleanValue()) {
            zzfhu zzfhuVar = this.zza;
            zzfhj zzfhjVar = this.zzb;
            zzfhjVar.zzg(true);
            zzfhuVar.zza(zzfhjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzddi
    public final void zzj() {
        if (((Boolean) zzbex.zzd.zze()).booleanValue()) {
            this.zzb.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwo
    public final void zzs(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbex.zzd.zze()).booleanValue()) {
            zzfhu zzfhuVar = this.zza;
            zzfhj zzfhjVar = this.zzb;
            zzfhjVar.zzc(zzeVar.zza().toString());
            zzfhjVar.zzg(false);
            zzfhuVar.zza(zzfhjVar);
        }
    }
}
