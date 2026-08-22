package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzaoy {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};
    private static final byte[] zzc = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static Pair zza(zzadw zzadwVar) throws zzaz {
        zzadwVar.zzj();
        zzaox zzaoxVarZzd = zzd(1684108385, zzadwVar, new zzen(8));
        zzadwVar.zzk(8);
        return Pair.create(Long.valueOf(zzadwVar.zzf()), Long.valueOf(zzaoxVarZzd.zzb));
    }

    public static zzaow zzb(zzadw zzadwVar) throws zzaz {
        byte[] bArr;
        int i;
        zzen zzenVar = new zzen(16);
        long j = zzd(1718449184, zzadwVar, zzenVar).zzb;
        zzdd.zzf(j >= 16);
        zzadwVar.zzh(zzenVar.zzN(), 0, 16);
        zzenVar.zzL(0);
        int iZzk = zzenVar.zzk();
        int iZzk2 = zzenVar.zzk();
        int iZzj = zzenVar.zzj();
        int iZzj2 = zzenVar.zzj();
        int iZzk3 = zzenVar.zzk();
        int iZzk4 = zzenVar.zzk();
        int i2 = ((int) j) - 16;
        if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            zzadwVar.zzh(bArr2, 0, i2);
            if (iZzk != 65534) {
                i = iZzk;
                bArr = bArr2;
            } else if (i2 == 24) {
                zzen zzenVar2 = new zzen(bArr2);
                zzenVar2.zzk();
                int iZzk5 = zzenVar2.zzk();
                if (iZzk5 != 0 && iZzk5 != iZzk4) {
                    throw zzaz.zzc("validBits ( " + iZzk5 + ")  != bitsPerSample( " + iZzk4 + ") are not supported");
                }
                int iZzj3 = zzenVar2.zzj();
                if ((iZzj3 >> 18) != 0) {
                    throw zzaz.zzc("invalid channel mask " + iZzj3);
                }
                if (iZzj3 != 0 && Integer.bitCount(iZzj3) != iZzk2) {
                    throw zzaz.zzc("invalid number of channels (" + Integer.bitCount(iZzj3) + ") in channel mask " + iZzj3);
                }
                iZzk = zzenVar2.zzk();
                byte[] bArr3 = new byte[14];
                zzenVar2.zzH(bArr3, 0, 14);
                if (!Arrays.equals(bArr3, zzb) && !Arrays.equals(bArr3, zzc)) {
                    throw zzaz.zzc("invalid wav format extension guid");
                }
                i = iZzk;
                bArr = bArr2;
            } else {
                bArr = bArr2;
                i = 65534;
            }
        } else {
            bArr = zzex.zzb;
            i = iZzk;
        }
        zzadwVar.zzk((int) (zzadwVar.zze() - zzadwVar.zzf()));
        return new zzaow(i, iZzk2, iZzj, iZzj2, iZzk3, iZzk4, bArr);
    }

    public static boolean zzc(zzadw zzadwVar) {
        zzen zzenVar = new zzen(8);
        int i = zzaox.zza(zzadwVar, zzenVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        zzadwVar.zzh(zzenVar.zzN(), 0, 4);
        zzenVar.zzL(0);
        int iZzg = zzenVar.zzg();
        if (iZzg == 1463899717) {
            return true;
        }
        zzea.zzc("WavHeaderReader", "Unsupported form type: " + iZzg);
        return false;
    }

    private static zzaox zzd(int i, zzadw zzadwVar, zzen zzenVar) throws zzaz {
        zzaox zzaoxVarZza = zzaox.zza(zzadwVar, zzenVar);
        while (true) {
            int i2 = zzaoxVarZza.zza;
            if (i2 == i) {
                return zzaoxVarZza;
            }
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(i2, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j = zzaoxVarZza.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                throw zzaz.zzc("Chunk is too large (~2GB+) to skip; id: " + i2);
            }
            zzadwVar.zzk((int) j2);
            zzaoxVarZza = zzaox.zza(zzadwVar, zzenVar);
        }
    }
}
