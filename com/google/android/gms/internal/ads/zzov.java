package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzov {
    final /* synthetic */ zzow zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzvh zze;
    private boolean zzf;
    private boolean zzg;

    public zzov(zzow zzowVar, String str, int i, zzvh zzvhVar) {
        Objects.requireNonNull(zzowVar);
        this.zza = zzowVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzvhVar == null ? -1L : zzvhVar.zzd;
        if (zzvhVar == null || !zzvhVar.zzb()) {
            return;
        }
        this.zze = zzvhVar;
    }

    public final void zzg(int i, zzvh zzvhVar) {
        if (this.zzd == -1 && i == this.zzc && zzvhVar != null) {
            zzow zzowVar = this.zza;
            long j = zzvhVar.zzd;
            if (j >= zzowVar.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzvh zzvhVar) {
        if (zzvhVar == null) {
            return i == this.zzc;
        }
        zzvh zzvhVar2 = this.zze;
        if (zzvhVar2 == null) {
            return !zzvhVar.zzb() && zzvhVar.zzd == this.zzd;
        }
        return zzvhVar.zzd == zzvhVar2.zzd && zzvhVar.zzb == zzvhVar2.zzb && zzvhVar.zzc == zzvhVar2.zzc;
    }

    public final boolean zzk(zzmp zzmpVar) {
        zzvh zzvhVar = zzmpVar.zzd;
        if (zzvhVar == null) {
            return this.zzc != zzmpVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        long j2 = zzvhVar.zzd;
        if (j2 > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbl zzblVar = zzmpVar.zzb;
        int iZza = zzblVar.zza(zzvhVar.zza);
        int iZza2 = zzblVar.zza(this.zze.zza);
        zzvh zzvhVar2 = this.zze;
        if (j2 < zzvhVar2.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zzvhVar.zzb()) {
            int i = zzvhVar.zze;
            return i == -1 || i > zzvhVar2.zzb;
        }
        int i2 = zzvhVar.zzb;
        int i3 = zzvhVar.zzc;
        int i4 = zzvhVar2.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzvhVar2.zzc;
        }
        return true;
    }

    public final boolean zzl(zzbl zzblVar, zzbl zzblVar2) {
        int i = this.zzc;
        if (i < zzblVar.zzc()) {
            zzow zzowVar = this.zza;
            zzblVar.zze(i, zzowVar.zzc, 0L);
            int i2 = zzowVar.zzc.zzn;
            while (true) {
                if (i2 > zzowVar.zzc.zzo) {
                    i = -1;
                    break;
                }
                int iZza = zzblVar2.zza(zzblVar.zzf(i2));
                if (iZza != -1) {
                    i = zzblVar2.zzd(iZza, zzowVar.zzd, false).zzc;
                    break;
                }
                i2++;
            }
        } else if (i >= zzblVar2.zzc()) {
            i = -1;
            break;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzvh zzvhVar = this.zze;
        return zzvhVar == null || zzblVar2.zza(zzvhVar.zza) != -1;
    }
}
