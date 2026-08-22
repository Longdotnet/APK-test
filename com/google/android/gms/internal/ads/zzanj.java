package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzanj implements zzamz {
    private zzafb zzc;
    private boolean zzd;
    private int zzf;
    private int zzg;
    private final String zza = "video/mp2t";
    private final zzen zzb = new zzen(10);
    private long zze = -9223372036854775807L;

    public zzanj(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        zzdd.zzb(this.zzc);
        if (this.zzd) {
            int iZza = zzenVar.zza();
            int i = this.zzg;
            if (i < 10) {
                int iMin = Math.min(iZza, 10 - i);
                byte[] bArrZzN = zzenVar.zzN();
                int iZzc = zzenVar.zzc();
                zzen zzenVar2 = this.zzb;
                System.arraycopy(bArrZzN, iZzc, zzenVar2.zzN(), this.zzg, iMin);
                if (this.zzg + iMin == 10) {
                    zzenVar2.zzL(0);
                    if (zzenVar2.zzm() != 73 || zzenVar2.zzm() != 68 || zzenVar2.zzm() != 51) {
                        zzea.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzd = false;
                        return;
                    } else {
                        zzenVar2.zzM(3);
                        this.zzf = zzenVar2.zzl() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZza, this.zzf - this.zzg);
            this.zzc.zzr(zzenVar, iMin2);
            this.zzg += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 5);
        this.zzc = zzafbVarZzw;
        zzx zzxVar = new zzx();
        zzxVar.zzS(zzaonVar.zzb());
        zzxVar.zzG(this.zza);
        zzxVar.zzah("application/id3");
        zzafbVarZzw.zzm(zzxVar.zzan());
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
        int i;
        zzdd.zzb(this.zzc);
        if (this.zzd && (i = this.zzf) != 0 && this.zzg == i) {
            zzdd.zzf(this.zze != -9223372036854775807L);
            this.zzc.zzt(this.zze, 1, this.zzf, 0, null);
            this.zzd = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zze = j;
        this.zzf = 0;
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzd = false;
        this.zze = -9223372036854775807L;
    }
}
