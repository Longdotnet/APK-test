package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzadg {
    protected final zzada zza;
    protected final zzadf zzb;
    protected zzadc zzc;
    private final int zzd;

    public zzadg(zzadd zzaddVar, zzadf zzadfVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzadfVar;
        this.zzd = i;
        this.zza = new zzada(zzaddVar, j, 0L, j3, j4, j5, j6);
    }

    public static final int zzf(zzadw zzadwVar, long j, zzaer zzaerVar) {
        if (j == zzadwVar.zzf()) {
            return 0;
        }
        zzaerVar.zza = j;
        return 1;
    }

    public static final boolean zzg(zzadw zzadwVar, long j) {
        long jZzf = j - zzadwVar.zzf();
        if (jZzf < 0 || jZzf > 262144) {
            return false;
        }
        zzadwVar.zzk((int) jZzf);
        return true;
    }

    public final int zza(zzadw zzadwVar, zzaer zzaerVar) {
        while (true) {
            zzadc zzadcVar = this.zzc;
            zzdd.zzb(zzadcVar);
            long j = zzadcVar.zzf;
            long j2 = zzadcVar.zzg;
            long j3 = zzadcVar.zzh;
            if (j2 - j <= this.zzd) {
                zzc(false, j);
                return zzf(zzadwVar, j, zzaerVar);
            }
            if (!zzg(zzadwVar, j3)) {
                return zzf(zzadwVar, j3, zzaerVar);
            }
            zzadwVar.zzj();
            zzade zzadeVarZza = this.zzb.zza(zzadwVar, zzadcVar.zzb);
            int i = zzadeVarZza.zzb;
            if (i == -3) {
                zzc(false, j3);
                return zzf(zzadwVar, j3, zzaerVar);
            }
            if (i == -2) {
                zzadc.zzh(zzadcVar, zzadeVarZza.zzc, zzadeVarZza.zzd);
            } else {
                if (i != -1) {
                    zzg(zzadwVar, zzadeVarZza.zzd);
                    zzc(true, zzadeVarZza.zzd);
                    return zzf(zzadwVar, zzadeVarZza.zzd, zzaerVar);
                }
                zzadc.zzg(zzadcVar, zzadeVarZza.zzc, zzadeVarZza.zzd);
            }
        }
    }

    public final zzaeu zzb() {
        return this.zza;
    }

    public final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        zzadc zzadcVar = this.zzc;
        if (zzadcVar == null || zzadcVar.zza != j) {
            zzada zzadaVar = this.zza;
            this.zzc = new zzadc(j, zzadaVar.zzf(j), 0L, zzadaVar.zzc, zzadaVar.zzd, zzadaVar.zze, zzadaVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
