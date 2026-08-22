package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
abstract class zzakh {
    private zzafb zzb;
    private zzady zzc;
    private zzakc zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzaka zza = new zzaka();
    private zzake zzj = new zzake();

    public abstract long zza(zzen zzenVar);

    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzake();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    public abstract boolean zzc(zzen zzenVar, long j, zzake zzakeVar);

    public final int zze(zzadw zzadwVar, zzaer zzaerVar) {
        zzdd.zzb(this.zzb);
        String str = zzex.zza;
        int i = this.zzh;
        if (i == 0) {
            while (true) {
                zzaka zzakaVar = this.zza;
                if (!zzakaVar.zze(zzadwVar)) {
                    this.zzh = 3;
                    return -1;
                }
                long jZzf = zzadwVar.zzf();
                long j = this.zzf;
                this.zzk = jZzf - j;
                if (zzc(zzakaVar.zza(), j, this.zzj)) {
                    this.zzf = zzadwVar.zzf();
                } else {
                    zzz zzzVar = this.zzj.zza;
                    this.zzi = zzzVar.zzH;
                    if (!this.zzm) {
                        this.zzb.zzm(zzzVar);
                        this.zzm = true;
                    }
                    zzakc zzakcVar = this.zzj.zzb;
                    if (zzakcVar != null) {
                        this.zzd = zzakcVar;
                    } else if (zzadwVar.zzd() == -1) {
                        this.zzd = new zzakf(null);
                    } else {
                        zzakb zzakbVarZzb = zzakaVar.zzb();
                        this.zzd = new zzajw(this, this.zzf, zzadwVar.zzd(), zzakbVarZzb.zzd + zzakbVarZzb.zze, zzakbVarZzb.zzb, (zzakbVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    zzakaVar.zzd();
                }
            }
        } else {
            if (i == 1) {
                zzadwVar.zzk((int) this.zzf);
                this.zzh = 2;
                return 0;
            }
            if (i != 2) {
                return -1;
            }
            long jZzd = this.zzd.zzd(zzadwVar);
            if (jZzd >= 0) {
                zzaerVar.zza = jZzd;
                return 1;
            }
            if (jZzd < -1) {
                zzi(-(jZzd + 2));
            }
            if (!this.zzl) {
                zzaeu zzaeuVarZze = this.zzd.zze();
                zzdd.zzb(zzaeuVarZze);
                this.zzc.zzP(zzaeuVarZze);
                this.zzb.zzl(zzaeuVarZze.zza());
                this.zzl = true;
            }
            if (this.zzk <= 0 && !this.zza.zze(zzadwVar)) {
                this.zzh = 3;
                return -1;
            }
            this.zzk = 0L;
            zzen zzenVarZza = this.zza.zza();
            long jZza = zza(zzenVarZza);
            if (jZza >= 0) {
                long j2 = this.zzg;
                if (j2 + jZza >= this.zze) {
                    long jZzf2 = zzf(j2);
                    this.zzb.zzr(zzenVarZza, zzenVarZza.zzd());
                    this.zzb.zzt(jZzf2, 1, zzenVarZza.zzd(), 0, null);
                    this.zze = -1L;
                }
            }
            this.zzg += jZza;
        }
        return 0;
    }

    public final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    public final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    public final void zzh(zzady zzadyVar, zzafb zzafbVar) {
        this.zzc = zzadyVar;
        this.zzb = zzafbVar;
        zzb(true);
    }

    public void zzi(long j) {
        this.zzg = j;
    }

    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            long jZzg = zzg(j2);
            this.zze = jZzg;
            zzakc zzakcVar = this.zzd;
            String str = zzex.zza;
            zzakcVar.zzg(jZzg);
            this.zzh = 2;
        }
    }
}
