package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzkq {
    public zzls zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    private boolean zze;

    public zzkq(zzls zzlsVar) {
        this.zza = zzlsVar;
    }

    public final void zza(int i) {
        this.zze = 1 == ((this.zze ? 1 : 0) | i);
        this.zzb += i;
    }

    public final void zzb(zzls zzlsVar) {
        this.zze |= this.zza != zzlsVar;
        this.zza = zzlsVar;
    }

    public final void zzc(int i) {
        if (this.zzc && this.zzd != 5) {
            zzdd.zzd(i == 5);
            return;
        }
        this.zze = true;
        this.zzc = true;
        this.zzd = i;
    }
}
