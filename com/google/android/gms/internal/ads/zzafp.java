package com.google.android.gms.internal.ads;

import com.google.android.gms.auth.IJ.gZrKCJ;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
final class zzafp implements zzafj {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzafp(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
    }

    public static zzafp zzd(zzen zzenVar) {
        int iZzi = zzenVar.zzi();
        zzenVar.zzM(12);
        int iZzi2 = zzenVar.zzi();
        int iZzi3 = zzenVar.zzi();
        int iZzi4 = zzenVar.zzi();
        zzenVar.zzM(4);
        int iZzi5 = zzenVar.zzi();
        int iZzi6 = zzenVar.zzi();
        zzenVar.zzM(4);
        return new zzafp(iZzi, iZzi2, iZzi3, iZzi4, iZzi5, iZzi6, zzenVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final int zza() {
        return 1752331379;
    }

    public final long zzc() {
        return zzex.zzu(this.zzd, ((long) this.zzb) * 1000000, this.zzc, RoundingMode.DOWN);
    }

    public final int zzb() {
        int i = this.zza;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        zzea.zzf(gZrKCJ.tScPGsSLNzLNXt, "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i))));
        return -1;
    }
}
