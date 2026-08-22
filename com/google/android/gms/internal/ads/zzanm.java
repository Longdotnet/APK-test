package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzanm implements zzamz {
    private String zzf;
    private zzafb zzg;
    private boolean zzj;
    private int zzl;
    private int zzm;
    private int zzo;
    private int zzp;
    private int zzt;
    private boolean zzv;
    private final String zza = "video/mp2t";
    private int zze = 0;
    private final zzen zzb = new zzen(new byte[15], 2);
    private final zzem zzc = new zzem();
    private final zzen zzd = new zzen();
    private final zzann zzq = new zzann();
    private int zzr = -2147483647;
    private int zzs = -1;
    private long zzu = -1;
    private boolean zzk = true;
    private boolean zzn = true;
    private double zzh = -9.223372036854776E18d;
    private double zzi = -9.223372036854776E18d;

    public zzanm(String str) {
    }

    private static final void zzf(zzen zzenVar, zzen zzenVar2, boolean z) {
        int iZzc = zzenVar.zzc();
        int iMin = Math.min(zzenVar.zza(), zzenVar2.zza());
        zzenVar.zzH(zzenVar2.zzN(), zzenVar2.zzc(), iMin);
        zzenVar2.zzM(iMin);
        if (z) {
            zzenVar.zzL(iZzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) throws zzaz {
        int i;
        int iZzd;
        zzdd.zzb(this.zzg);
        while (zzenVar.zza() > 0) {
            int i2 = this.zze;
            if (i2 == 0) {
                int i3 = this.zzl;
                if ((i3 & 2) != 0) {
                    if ((i3 & 4) == 0) {
                        while (zzenVar.zza() > 0) {
                            int i4 = this.zzm << 8;
                            this.zzm = i4;
                            int iZzm = i4 | zzenVar.zzm();
                            this.zzm = iZzm;
                            if ((iZzm & 16777215) == 12583333) {
                                zzenVar.zzL(zzenVar.zzc() - 3);
                                this.zzm = 0;
                            }
                        }
                    }
                    this.zze = 1;
                    break;
                }
                zzenVar.zzL(zzenVar.zzd());
            } else if (i2 != 1) {
                zzann zzannVar = this.zzq;
                int i5 = zzannVar.zza;
                if (i5 == 1 || i5 == 17) {
                    zzf(zzenVar, this.zzd, true);
                }
                int iMin = Math.min(zzenVar.zza(), zzannVar.zzc - this.zzo);
                this.zzg.zzr(zzenVar, iMin);
                int i6 = this.zzo + iMin;
                this.zzo = i6;
                if (i6 == zzannVar.zzc) {
                    int i7 = zzannVar.zza;
                    if (i7 == 1) {
                        byte[] bArrZzN = this.zzd.zzN();
                        zzano zzanoVarZza = zzanq.zza(new zzem(bArrZzN, bArrZzN.length));
                        this.zzr = zzanoVarZza.zzb;
                        this.zzs = zzanoVarZza.zzc;
                        long j = this.zzu;
                        long j2 = zzannVar.zzb;
                        if (j != j2) {
                            this.zzu = j2;
                            int i8 = zzanoVarZza.zza;
                            String strConcat = i8 != -1 ? "mhm1".concat(String.format(".%02X", Integer.valueOf(i8))) : "mhm1";
                            byte[] bArr = zzanoVarZza.zzd;
                            zzfyq zzfyqVarZzp = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfyqVarZzp = zzfyq.zzp(zzex.zzb, bArr);
                            }
                            zzx zzxVar = new zzx();
                            zzxVar.zzS(this.zzf);
                            zzxVar.zzG(this.zza);
                            zzxVar.zzah("audio/mhm1");
                            zzxVar.zzai(this.zzr);
                            zzxVar.zzE(strConcat);
                            zzxVar.zzT(zzfyqVarZzp);
                            this.zzg.zzm(zzxVar.zzan());
                        }
                        this.zzv = true;
                    } else if (i7 == 17) {
                        byte[] bArrZzN2 = this.zzd.zzN();
                        zzem zzemVar = new zzem(bArrZzN2, bArrZzN2.length);
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(2);
                            iZzd = zzemVar.zzd(13);
                        } else {
                            iZzd = 0;
                        }
                        this.zzt = iZzd;
                    } else if (i7 == 2) {
                        if (this.zzv) {
                            this.zzk = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i9 = this.zzs - this.zzt;
                        double d = this.zzr;
                        long jRound = Math.round(this.zzh);
                        if (this.zzj) {
                            this.zzj = false;
                            this.zzh = this.zzi;
                        } else {
                            this.zzh += (((double) i9) * 1000000.0d) / d;
                        }
                        this.zzg.zzt(jRound, i, this.zzp, 0, null);
                        this.zzv = false;
                        this.zzt = 0;
                        this.zzp = 0;
                    }
                    this.zze = 1;
                }
            } else {
                zzen zzenVar2 = this.zzb;
                zzf(zzenVar, zzenVar2, false);
                if (zzenVar2.zza() == 0) {
                    zzem zzemVar2 = this.zzc;
                    int iZzd2 = zzenVar2.zzd();
                    zzemVar2.zzk(zzenVar2.zzN(), iZzd2);
                    zzann zzannVar2 = this.zzq;
                    if (zzanq.zzb(zzemVar2, zzannVar2)) {
                        this.zzo = 0;
                        this.zzp = zzannVar2.zzc + iZzd2 + this.zzp;
                        zzenVar2.zzL(0);
                        this.zzg.zzr(zzenVar2, zzenVar2.zzd());
                        zzenVar2.zzI(2);
                        this.zzd.zzI(zzannVar2.zzc);
                        this.zzn = true;
                        this.zze = 2;
                    } else if (zzenVar2.zzd() < 15) {
                        zzenVar2.zzK(zzenVar2.zzd() + 1);
                    }
                }
                this.zzn = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzf = zzaonVar.zzb();
        this.zzg = zzadyVar.zzw(zzaonVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzl = i;
        if (!this.zzk && (this.zzp != 0 || !this.zzn)) {
            this.zzj = true;
        }
        if (j != -9223372036854775807L) {
            double d = j;
            if (this.zzj) {
                this.zzi = d;
            } else {
                this.zzh = d;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zze = 0;
        this.zzm = 0;
        this.zzb.zzI(2);
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = -2147483647;
        this.zzs = -1;
        this.zzt = 0;
        this.zzu = -1L;
        this.zzv = false;
        this.zzj = false;
        this.zzn = true;
        this.zzk = true;
        this.zzh = -9.223372036854776E18d;
        this.zzi = -9.223372036854776E18d;
    }
}
