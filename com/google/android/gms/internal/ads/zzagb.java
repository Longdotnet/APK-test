package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
final class zzagb extends zzagf {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzagb(zzafb zzafbVar) {
        super(zzafbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final boolean zza(zzen zzenVar) throws zzage {
        if (this.zzc) {
            zzenVar.zzM(1);
        } else {
            int iZzm = zzenVar.zzm();
            int i = iZzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzm >> 2) & 3];
                zzx zzxVar = new zzx();
                zzxVar.zzG("video/x-flv");
                zzxVar.zzah("audio/mpeg");
                zzxVar.zzD(1);
                zzxVar.zzai(i2);
                this.zza.zzm(zzxVar.zzan());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzx zzxVar2 = new zzx();
                zzxVar2.zzG("video/x-flv");
                zzxVar2.zzah(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzxVar2.zzD(1);
                zzxVar2.zzai(8000);
                this.zza.zzm(zzxVar2.zzan());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzage(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Audio format not supported: "));
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final boolean zzb(zzen zzenVar, long j) {
        if (this.zze == 2) {
            int iZza = zzenVar.zza();
            zzafb zzafbVar = this.zza;
            zzafbVar.zzr(zzenVar, iZza);
            zzafbVar.zzt(j, 1, iZza, 0, null);
            return true;
        }
        int iZzm = zzenVar.zzm();
        if (iZzm != 0 || this.zzd) {
            if (this.zze == 10 && iZzm != 1) {
                return false;
            }
            int iZza2 = zzenVar.zza();
            zzafb zzafbVar2 = this.zza;
            zzafbVar2.zzr(zzenVar, iZza2);
            zzafbVar2.zzt(j, 1, iZza2, 0, null);
            return true;
        }
        int iZza3 = zzenVar.zza();
        byte[] bArr = new byte[iZza3];
        zzenVar.zzH(bArr, 0, iZza3);
        zzacp zzacpVarZza = zzacr.zza(bArr);
        zzx zzxVar = new zzx();
        zzxVar.zzG("video/x-flv");
        zzxVar.zzah("audio/mp4a-latm");
        zzxVar.zzE(zzacpVarZza.zzc);
        zzxVar.zzD(zzacpVarZza.zzb);
        zzxVar.zzai(zzacpVarZza.zza);
        zzxVar.zzT(Collections.singletonList(bArr));
        this.zza.zzm(zzxVar.zzan());
        this.zzd = true;
        return false;
    }
}
