package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzamt implements zzamz {
    private final zzem zza;
    private final zzen zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private String zzf;
    private zzafb zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private zzz zzl;
    private int zzm;
    private long zzn;

    public zzamt(String str, int i, String str2) {
        zzem zzemVar = new zzem(new byte[16], 16);
        this.zza = zzemVar;
        this.zzb = new zzen(zzemVar.zza);
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        zzdd.zzb(this.zzg);
        while (zzenVar.zza() > 0) {
            int i = this.zzh;
            if (i == 0) {
                while (true) {
                    if (zzenVar.zza() > 0) {
                        if (this.zzj) {
                            int iZzm = zzenVar.zzm();
                            this.zzj = iZzm == 172;
                            if (iZzm != 64) {
                                if (iZzm == 65) {
                                    iZzm = 65;
                                }
                            }
                            this.zzh = 1;
                            zzen zzenVar2 = this.zzb;
                            zzenVar2.zzN()[0] = -84;
                            zzenVar2.zzN()[1] = iZzm == 65 ? (byte) 65 : (byte) 64;
                            this.zzi = 2;
                        } else {
                            this.zzj = zzenVar.zzm() == 172;
                        }
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(zzenVar.zza(), this.zzm - this.zzi);
                this.zzg.zzr(zzenVar, iMin);
                int i2 = this.zzi + iMin;
                this.zzi = i2;
                if (i2 == this.zzm) {
                    zzdd.zzf(this.zzn != -9223372036854775807L);
                    this.zzg.zzt(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzk;
                    this.zzh = 0;
                }
            } else {
                zzen zzenVar3 = this.zzb;
                byte[] bArrZzN = zzenVar3.zzN();
                int iMin2 = Math.min(zzenVar.zza(), 16 - this.zzi);
                zzenVar.zzH(bArrZzN, this.zzi, iMin2);
                int i3 = this.zzi + iMin2;
                this.zzi = i3;
                if (i3 == 16) {
                    zzem zzemVar = this.zza;
                    zzemVar.zzl(0);
                    zzacw zzacwVarZzb = zzacy.zzb(zzemVar);
                    zzz zzzVar = this.zzl;
                    if (zzzVar == null || zzzVar.zzG != 2 || zzacwVarZzb.zza != zzzVar.zzH || !"audio/ac4".equals(zzzVar.zzo)) {
                        zzx zzxVar = new zzx();
                        zzxVar.zzS(this.zzf);
                        zzxVar.zzG(this.zze);
                        zzxVar.zzah("audio/ac4");
                        zzxVar.zzD(2);
                        zzxVar.zzai(zzacwVarZzb.zza);
                        zzxVar.zzW(this.zzc);
                        zzxVar.zzaf(this.zzd);
                        zzz zzzVarZzan = zzxVar.zzan();
                        this.zzl = zzzVarZzan;
                        this.zzg.zzm(zzzVarZzan);
                    }
                    this.zzm = zzacwVarZzb.zzb;
                    this.zzk = (((long) zzacwVarZzb.zzc) * 1000000) / ((long) this.zzl.zzH);
                    zzenVar3.zzL(0);
                    this.zzg.zzr(zzenVar3, 16);
                    this.zzh = 2;
                }
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
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = -9223372036854775807L;
    }
}
