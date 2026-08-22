package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzekc extends com.google.android.gms.ads.internal.client.zzbp {
    private final zzelj zza;

    public zzekc(Context context, zzche zzcheVar, zzfcu zzfcuVar, zzdje zzdjeVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        zzell zzellVar = new zzell(zzdjeVar, zzcheVar.zzi());
        zzellVar.zze(zzbkVar);
        this.zza = new zzelj(new zzelv(zzcheVar, context, zzellVar, zzfcuVar), zzfcuVar.zzN());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zze() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzg(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zza.zzd(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzm zzmVar, int i) {
        this.zza.zzd(zzmVar, i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized boolean zzi() {
        return this.zza.zze();
    }
}
