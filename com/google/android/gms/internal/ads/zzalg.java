package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzalg {
    private final zzen zza = new zzen();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    public static /* bridge */ /* synthetic */ void zzb(zzalg zzalgVar, zzen zzenVar, int i) {
        int iZzo;
        if (i < 4) {
            return;
        }
        zzenVar.zzM(3);
        int i2 = i - 4;
        if ((zzenVar.zzm() & 128) != 0) {
            if (i2 < 7 || (iZzo = zzenVar.zzo()) < 4) {
                return;
            }
            zzalgVar.zzh = zzenVar.zzq();
            zzalgVar.zzi = zzenVar.zzq();
            zzalgVar.zza.zzI(iZzo - 4);
            i2 = i - 11;
        }
        zzen zzenVar2 = zzalgVar.zza;
        int iZzc = zzenVar2.zzc();
        int iZzd = zzenVar2.zzd();
        if (iZzc >= iZzd || i2 <= 0) {
            return;
        }
        int iMin = Math.min(i2, iZzd - iZzc);
        zzenVar.zzH(zzenVar2.zzN(), iZzc, iMin);
        zzenVar2.zzL(iZzc + iMin);
    }

    public static /* bridge */ /* synthetic */ void zzc(zzalg zzalgVar, zzen zzenVar, int i) {
        if (i < 19) {
            return;
        }
        zzalgVar.zzd = zzenVar.zzq();
        zzalgVar.zze = zzenVar.zzq();
        zzenVar.zzM(11);
        zzalgVar.zzf = zzenVar.zzq();
        zzalgVar.zzg = zzenVar.zzq();
    }

    public static /* bridge */ /* synthetic */ void zzd(zzalg zzalgVar, zzen zzenVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzenVar.zzM(2);
        int[] iArr = zzalgVar.zzb;
        Arrays.fill(iArr, 0);
        int i2 = i / 5;
        for (int i3 = 0; i3 < i2; i3++) {
            int iZzm = zzenVar.zzm();
            int iZzm2 = zzenVar.zzm();
            int iZzm3 = zzenVar.zzm();
            int iZzm4 = zzenVar.zzm();
            double d = iZzm2;
            int iZzm5 = zzenVar.zzm() << 24;
            String str = zzex.zza;
            double d2 = iZzm3 - 128;
            double d3 = iZzm4 - 128;
            iArr[iZzm] = (Math.max(0, Math.min((int) ((1.402d * d2) + d), 255)) << 16) | iZzm5 | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) ((d3 * 1.772d) + d), 255));
        }
        zzalgVar.zzc = true;
    }

    public final zzcu zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzen zzenVar = this.zza;
        if (zzenVar.zzd() == 0 || zzenVar.zzc() != zzenVar.zzd() || !this.zzc) {
            return null;
        }
        zzenVar.zzL(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iZzm = zzenVar.zzm();
            if (iZzm != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[iZzm];
            } else {
                int iZzm2 = zzenVar.zzm();
                if (iZzm2 != 0) {
                    int iZzm3 = iZzm2 & 63;
                    if ((iZzm2 & 64) != 0) {
                        iZzm3 = (iZzm3 << 8) | zzenVar.zzm();
                    }
                    i = iZzm3 + i3;
                    Arrays.fill(iArr, i3, i, (iZzm2 & 128) == 0 ? this.zzb[0] : this.zzb[zzenVar.zzm()]);
                }
            }
            i3 = i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzc(bitmapCreateBitmap);
        zzcsVar.zzh(this.zzf / this.zzd);
        zzcsVar.zzi(0);
        zzcsVar.zze(this.zzg / this.zze, 0);
        zzcsVar.zzf(0);
        zzcsVar.zzk(this.zzh / this.zzd);
        zzcsVar.zzd(this.zzi / this.zze);
        return zzcsVar.zzq();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzI(0);
        this.zzc = false;
    }
}
