package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadh {
    public static void zza(long j, zzen zzenVar, zzafb[] zzafbVarArr) {
        int iZzg;
        while (true) {
            if (zzenVar.zza() <= 1) {
                return;
            }
            int iZzc = zzc(zzenVar);
            int iZzc2 = zzc(zzenVar);
            int iZzc3 = zzenVar.zzc() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzenVar.zza()) {
                zzea.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzc3 = zzenVar.zzd();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzm = zzenVar.zzm();
                int iZzq = zzenVar.zzq();
                if (iZzq == 49) {
                    iZzg = zzenVar.zzg();
                    iZzq = 49;
                } else {
                    iZzg = 0;
                }
                int iZzm2 = zzenVar.zzm();
                if (iZzq == 47) {
                    zzenVar.zzM(1);
                    iZzq = 47;
                }
                boolean z = iZzm == 181 && (iZzq == 49 || iZzq == 47) && iZzm2 == 3;
                if (iZzq == 49) {
                    z &= iZzg == 1195456820;
                }
                if (z) {
                    zzb(j, zzenVar, zzafbVarArr);
                }
            }
            zzenVar.zzL(iZzc3);
        }
    }

    public static void zzb(long j, zzen zzenVar, zzafb[] zzafbVarArr) {
        int iZzm = zzenVar.zzm();
        if ((iZzm & 64) != 0) {
            int i = iZzm & 31;
            zzenVar.zzM(1);
            int iZzc = zzenVar.zzc();
            for (zzafb zzafbVar : zzafbVarArr) {
                int i2 = i * 3;
                zzenVar.zzL(iZzc);
                zzafbVar.zzr(zzenVar, i2);
                zzdd.zzf(j != -9223372036854775807L);
                zzafbVar.zzt(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzen zzenVar) {
        int i = 0;
        while (zzenVar.zza() != 0) {
            int iZzm = zzenVar.zzm();
            i += iZzm;
            if (iZzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
