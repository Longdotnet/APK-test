package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzagg extends zzagf {
    private final zzen zzb;
    private final zzen zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzagg(zzafb zzafbVar) {
        super(zzafbVar);
        this.zzb = new zzen(zzfv.zza);
        this.zzc = new zzen(4);
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final boolean zza(zzen zzenVar) throws zzage {
        int iZzm = zzenVar.zzm();
        int i = iZzm >> 4;
        int i2 = iZzm & 15;
        if (i2 != 7) {
            throw new zzage(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "Video format not supported: "));
        }
        this.zzg = i;
        return i != 5;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final boolean zzb(zzen zzenVar, long j) {
        int i;
        int iZzm = zzenVar.zzm();
        long jZzh = zzenVar.zzh();
        if (iZzm == 0) {
            if (!this.zze) {
                zzen zzenVar2 = new zzen(new byte[zzenVar.zza()]);
                zzenVar.zzH(zzenVar2.zzN(), 0, zzenVar.zza());
                zzacz zzaczVarZza = zzacz.zza(zzenVar2);
                this.zzd = zzaczVarZza.zzb;
                zzx zzxVar = new zzx();
                zzxVar.zzG("video/x-flv");
                zzxVar.zzah("video/avc");
                zzxVar.zzE(zzaczVarZza.zzl);
                zzxVar.zzam(zzaczVarZza.zzc);
                zzxVar.zzQ(zzaczVarZza.zzd);
                zzxVar.zzad(zzaczVarZza.zzk);
                zzxVar.zzT(zzaczVarZza.zza);
                this.zza.zzm(zzxVar.zzan());
                this.zze = true;
                return false;
            }
        } else if (iZzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            zzen zzenVar3 = this.zzc;
            byte[] bArrZzN = zzenVar3.zzN();
            bArrZzN[0] = 0;
            bArrZzN[1] = 0;
            bArrZzN[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzenVar.zza() > 0) {
                zzenVar.zzH(zzenVar3.zzN(), i3, this.zzd);
                zzenVar3.zzL(0);
                zzen zzenVar4 = this.zzb;
                int iZzp = zzenVar3.zzp();
                zzenVar4.zzL(0);
                zzafb zzafbVar = this.zza;
                zzafbVar.zzr(zzenVar4, 4);
                zzafbVar.zzr(zzenVar, iZzp);
                i4 = i4 + 4 + iZzp;
            }
            this.zza.zzt((jZzh * 1000) + j, i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
