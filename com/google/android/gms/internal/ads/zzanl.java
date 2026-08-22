package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzanl implements zzamz {
    private final zzen zza;
    private final zzaen zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private zzafb zzf;
    private String zzg;
    private int zzh = 0;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzanl(String str, int i, String str2) {
        zzen zzenVar = new zzen(4);
        this.zza = zzenVar;
        zzenVar.zzN()[0] = -1;
        this.zzb = new zzaen();
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        zzdd.zzb(this.zzf);
        while (zzenVar.zza() > 0) {
            int i = this.zzh;
            if (i == 0) {
                byte[] bArrZzN = zzenVar.zzN();
                int iZzc = zzenVar.zzc();
                int iZzd = zzenVar.zzd();
                while (true) {
                    if (iZzc >= iZzd) {
                        zzenVar.zzL(iZzd);
                        break;
                    }
                    int i2 = iZzc + 1;
                    byte b = bArrZzN[iZzc];
                    boolean z = (b & 255) == 255;
                    boolean z2 = this.zzk && (b & 224) == 224;
                    this.zzk = z;
                    if (z2) {
                        zzenVar.zzL(i2);
                        this.zzk = false;
                        this.zza.zzN()[1] = bArrZzN[iZzc];
                        this.zzi = 2;
                        this.zzh = 1;
                        break;
                    }
                    iZzc = i2;
                }
            } else if (i != 1) {
                int iMin = Math.min(zzenVar.zza(), this.zzm - this.zzi);
                this.zzf.zzr(zzenVar, iMin);
                int i3 = this.zzi + iMin;
                this.zzi = i3;
                if (i3 >= this.zzm) {
                    zzdd.zzf(this.zzn != -9223372036854775807L);
                    this.zzf.zzt(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzl;
                    this.zzi = 0;
                    this.zzh = 0;
                }
            } else {
                int iMin2 = Math.min(zzenVar.zza(), 4 - this.zzi);
                zzen zzenVar2 = this.zza;
                zzenVar.zzH(zzenVar2.zzN(), this.zzi, iMin2);
                int i4 = this.zzi + iMin2;
                this.zzi = i4;
                if (i4 >= 4) {
                    zzenVar2.zzL(0);
                    zzaen zzaenVar = this.zzb;
                    if (zzaenVar.zza(zzenVar2.zzg())) {
                        this.zzm = zzaenVar.zzc;
                        if (!this.zzj) {
                            this.zzl = (((long) zzaenVar.zzg) * 1000000) / ((long) zzaenVar.zzd);
                            zzx zzxVar = new zzx();
                            zzxVar.zzS(this.zzg);
                            zzxVar.zzG(this.zze);
                            zzxVar.zzah(zzaenVar.zzb);
                            zzxVar.zzX(4096);
                            zzxVar.zzD(zzaenVar.zze);
                            zzxVar.zzai(zzaenVar.zzd);
                            zzxVar.zzW(this.zzc);
                            zzxVar.zzaf(this.zzd);
                            this.zzf.zzm(zzxVar.zzan());
                            this.zzj = true;
                        }
                        zzenVar2.zzL(0);
                        this.zzf.zzr(zzenVar2, 4);
                        this.zzh = 2;
                    } else {
                        this.zzi = 0;
                        this.zzh = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzg = zzaonVar.zzb();
        this.zzf = zzadyVar.zzw(zzaonVar.zza(), 1);
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
        this.zzk = false;
        this.zzn = -9223372036854775807L;
    }
}
