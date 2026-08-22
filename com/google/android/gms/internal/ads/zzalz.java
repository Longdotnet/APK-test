package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class zzalz {
    private boolean zzb;
    private boolean zzc;
    private int[] zzd;
    private int zze;
    private int zzf;
    private Rect zzg;
    private final int[] zza = new int[4];
    private int zzh = -1;
    private int zzi = -1;

    private static int zze(int[] iArr, int i) {
        if (i >= iArr.length) {
            i = 0;
        }
        return iArr[i];
    }

    private static int zzf(int i, int i2) {
        return (i & 16777215) | ((i2 * 17) << 24);
    }

    private final void zzg(zzem zzemVar, boolean z, Rect rect, int[] iArr) {
        int i;
        int i2;
        int i3 = !z ? 1 : 0;
        int iWidth = rect.width();
        int i4 = i3 * iWidth;
        int iHeight = rect.height();
        while (true) {
            int i5 = 0;
            do {
                int i6 = 1;
                int iZzd = 0;
                while (true) {
                    if (iZzd >= i6 || i6 > 64) {
                        i = iZzd & 3;
                        if (iZzd >= 4) {
                            i2 = iZzd >> 2;
                            break;
                        } else {
                            i2 = iWidth;
                            break;
                        }
                    }
                    if (zzemVar.zza() < 4) {
                        i = -1;
                        i2 = 0;
                        break;
                    } else {
                        iZzd = (iZzd << 4) | zzemVar.zzd(4);
                        i6 <<= 2;
                    }
                }
                int iMin = Math.min(i2, iWidth - i5);
                if (iMin > 0) {
                    int i7 = i4 + iMin;
                    Arrays.fill(iArr, i4, i7, this.zza[i]);
                    i5 += iMin;
                    i4 = i7;
                }
            } while (i5 < iWidth);
            i3 += 2;
            if (i3 >= iHeight) {
                return;
            }
            i4 = i3 * iWidth;
            zzemVar.zzf();
        }
    }

    public final zzcu zza(zzen zzenVar) {
        Rect rect;
        if (this.zzd == null || !this.zzb || !this.zzc || (rect = this.zzg) == null || this.zzh == -1 || this.zzi == -1 || rect.width() < 2 || this.zzg.height() < 2) {
            return null;
        }
        Rect rect2 = this.zzg;
        int[] iArr = new int[rect2.height() * rect2.width()];
        zzem zzemVar = new zzem();
        zzenVar.zzL(this.zzh);
        zzemVar.zzj(zzenVar);
        zzg(zzemVar, true, rect2, iArr);
        zzenVar.zzL(this.zzi);
        zzemVar.zzj(zzenVar);
        zzg(zzemVar, false, rect2, iArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzc(bitmapCreateBitmap);
        zzcsVar.zzh(rect2.left / this.zze);
        zzcsVar.zzi(0);
        zzcsVar.zze(rect2.top / this.zzf, 0);
        zzcsVar.zzf(0);
        zzcsVar.zzk(rect2.width() / this.zze);
        zzcsVar.zzd(rect2.height() / this.zzf);
        return zzcsVar.zzq();
    }

    public final void zzb(String str) {
        int i;
        String strTrim = str.trim();
        String str2 = zzex.zza;
        for (String str3 : strTrim.split("\\r?\\n", -1)) {
            if (str3.startsWith("palette: ")) {
                String[] strArrSplit = str3.substring(9).split(",", -1);
                this.zzd = new int[strArrSplit.length];
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    int[] iArr = this.zzd;
                    try {
                        i = Integer.parseInt(strArrSplit[i2].trim(), 16);
                    } catch (RuntimeException unused) {
                        i = 0;
                    }
                    iArr[i2] = i;
                }
            } else if (str3.startsWith(ZRqOdXiy.cQCCKqxUAqzLq)) {
                String[] strArrSplit2 = str3.substring(6).trim().split("x", -1);
                if (strArrSplit2.length == 2) {
                    try {
                        this.zze = Integer.parseInt(strArrSplit2[0]);
                        this.zzf = Integer.parseInt(strArrSplit2[1]);
                        this.zzb = true;
                    } catch (RuntimeException e) {
                        zzea.zzg("VobsubParser", "Parsing IDX failed", e);
                    }
                }
            }
        }
    }

    public final void zzc(zzen zzenVar) {
        int[] iArr = this.zzd;
        if (iArr == null || !this.zzb) {
            return;
        }
        zzenVar.zzM(zzenVar.zzq() - 2);
        int iZzq = zzenVar.zzq();
        while (zzenVar.zzc() < iZzq && zzenVar.zza() > 0) {
            switch (zzenVar.zzm()) {
                case 0:
                case 1:
                case 2:
                    break;
                case 3:
                    if (zzenVar.zza() < 2) {
                        return;
                    }
                    int iZzm = zzenVar.zzm();
                    int iZzm2 = zzenVar.zzm();
                    int[] iArr2 = this.zza;
                    iArr2[3] = zze(iArr, iZzm >> 4);
                    iArr2[2] = zze(iArr, iZzm & 15);
                    iArr2[1] = zze(iArr, iZzm2 >> 4);
                    iArr2[0] = zze(iArr, iZzm2 & 15);
                    this.zzc = true;
                    break;
                case 4:
                    if (zzenVar.zza() < 2 || !this.zzc) {
                        return;
                    }
                    int iZzm3 = zzenVar.zzm();
                    int iZzm4 = zzenVar.zzm();
                    int[] iArr3 = this.zza;
                    iArr3[3] = zzf(iArr3[3], iZzm3 >> 4);
                    iArr3[2] = zzf(iArr3[2], iZzm3 & 15);
                    iArr3[1] = zzf(iArr3[1], iZzm4 >> 4);
                    iArr3[0] = zzf(iArr3[0], iZzm4 & 15);
                    break;
                case 5:
                    if (zzenVar.zza() < 6) {
                        return;
                    }
                    int iZzm5 = zzenVar.zzm();
                    int iZzm6 = zzenVar.zzm();
                    int i = iZzm6 >> 4;
                    int iZzm7 = ((iZzm6 & 15) << 8) | zzenVar.zzm();
                    int iZzm8 = zzenVar.zzm();
                    int iZzm9 = zzenVar.zzm();
                    this.zzg = new Rect((iZzm5 << 4) | i, (iZzm8 << 4) | (iZzm9 >> 4), iZzm7 + 1, (((iZzm9 & 15) << 8) | zzenVar.zzm()) + 1);
                    break;
                case 6:
                    if (zzenVar.zza() < 4) {
                        return;
                    }
                    this.zzh = zzenVar.zzq();
                    this.zzi = zzenVar.zzq();
                    break;
                default:
                    return;
            }
        }
    }

    public final void zzd() {
        this.zzc = false;
        this.zzg = null;
        this.zzh = -1;
        this.zzi = -1;
    }
}
