package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaob implements zzaoo {
    private final zzaoa zza;
    private final zzen zzb = new zzen(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzaob(zzaoa zzaoaVar) {
        this.zza = zzaoaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zza(zzen zzenVar, int i) {
        int iZzc;
        int i2 = i & 1;
        if (i2 != 0) {
            iZzc = zzenVar.zzc() + zzenVar.zzm();
        } else {
            iZzc = -1;
        }
        if (this.zzf) {
            if (i2 == 0) {
                return;
            }
            this.zzf = false;
            zzenVar.zzL(iZzc);
            this.zzd = 0;
        }
        while (zzenVar.zza() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int iZzm = zzenVar.zzm();
                    zzenVar.zzL(zzenVar.zzc() - 1);
                    if (iZzm == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int iMin = Math.min(zzenVar.zza(), 3 - this.zzd);
                zzen zzenVar2 = this.zzb;
                zzenVar.zzH(zzenVar2.zzN(), this.zzd, iMin);
                int i4 = this.zzd + iMin;
                this.zzd = i4;
                if (i4 == 3) {
                    zzenVar2.zzL(0);
                    zzenVar2.zzK(3);
                    zzenVar2.zzM(1);
                    int iZzm2 = zzenVar2.zzm();
                    boolean z = (iZzm2 & 128) != 0;
                    int iZzm3 = zzenVar2.zzm();
                    this.zze = z;
                    this.zzc = (((iZzm2 & 15) << 8) | iZzm3) + 3;
                    int iZzb = zzenVar2.zzb();
                    int i5 = this.zzc;
                    if (iZzb < i5) {
                        int iZzb2 = zzenVar2.zzb();
                        zzenVar2.zzF(Math.min(4098, Math.max(i5, iZzb2 + iZzb2)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzenVar.zza(), this.zzc - this.zzd);
                zzen zzenVar3 = this.zzb;
                zzenVar.zzH(zzenVar3.zzN(), this.zzd, iMin2);
                int i6 = this.zzd + iMin2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        zzenVar3.zzK(i7);
                    } else {
                        if (zzex.zzf(zzenVar3.zzN(), 0, i7, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        zzenVar3.zzK(this.zzc - 4);
                    }
                    zzenVar3.zzL(0);
                    this.zza.zza(zzenVar3);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
        this.zza.zzb(zzeuVar, zzadyVar, zzaonVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzc() {
        this.zzf = true;
    }
}
