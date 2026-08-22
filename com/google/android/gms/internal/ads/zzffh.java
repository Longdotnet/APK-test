package com.google.android.gms.internal.ads;

import androidx.core.text.jp.CyjpdoedCdLTIO;

/* JADX INFO: loaded from: classes2.dex */
final class zzffh {
    private final long zza;
    private long zzc;
    private final zzffg zzb = new zzffg();
    private int zzd = 0;
    private int zze = 0;
    private int zzf = 0;

    public zzffh() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zza = jCurrentTimeMillis;
        this.zzc = jCurrentTimeMillis;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final zzffg zzd() {
        zzffg zzffgVar = this.zzb;
        zzffg zzffgVarClone = zzffgVar.clone();
        zzffgVar.zza = false;
        zzffgVar.zzb = 0;
        return zzffgVarClone;
    }

    public final void zzf() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzc = System.currentTimeMillis();
        this.zzd++;
    }

    public final void zzg() {
        this.zzf++;
        this.zzb.zzb++;
    }

    public final void zzh() {
        this.zze++;
        this.zzb.zza = true;
    }

    public final String zze() {
        return "Created: " + this.zza + " Last accessed: " + this.zzc + CyjpdoedCdLTIO.faijY + this.zzd + "\nEntries retrieved: Valid: " + this.zze + " Stale: " + this.zzf;
    }
}
