package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzalf implements zzakt {
    private static final byte[] zza = {0, 7, 8, 15};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzaky zzg;
    private final zzakx zzh;
    private final zzale zzi;
    private Bitmap zzj;

    public zzalf(List list) {
        zzen zzenVar = new zzen((byte[]) list.get(0));
        int iZzq = zzenVar.zzq();
        int iZzq2 = zzenVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzaky(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakx(0, zzg(), zzh(), zzi());
        this.zzi = new zzale(iZzq, iZzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakx zzc(zzem zzemVar, int i) {
        int[] iArr;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i2 = 8;
        int iZzd5 = zzemVar.zzd(8);
        zzemVar.zzn(8);
        int[] iArrZzg = zzg();
        int[] iArrZzh = zzh();
        int[] iArrZzi = zzi();
        int i3 = i - 2;
        while (i3 > 0) {
            int iZzd6 = zzemVar.zzd(i2);
            int iZzd7 = zzemVar.zzd(i2);
            if ((iZzd7 & 128) != 0) {
                iArr = iArrZzg;
            } else {
                iArr = (iZzd7 & 64) != 0 ? iArrZzh : iArrZzi;
            }
            if ((iZzd7 & 1) != 0) {
                iZzd3 = zzemVar.zzd(i2);
                iZzd4 = zzemVar.zzd(i2);
                iZzd = zzemVar.zzd(i2);
                iZzd2 = zzemVar.zzd(i2);
                i3 -= 6;
            } else {
                int iZzd8 = zzemVar.zzd(6) << 2;
                int iZzd9 = zzemVar.zzd(4) << 4;
                i3 -= 4;
                iZzd = zzemVar.zzd(4) << 4;
                iZzd2 = zzemVar.zzd(2) << 6;
                iZzd3 = iZzd8;
                iZzd4 = iZzd9;
            }
            if (iZzd3 == 0) {
                iZzd2 = 255;
            }
            if (iZzd3 == 0) {
                iZzd = 0;
            }
            if (iZzd3 == 0) {
                iZzd4 = 0;
            }
            double d = iZzd3;
            String str = zzex.zza;
            double d2 = iZzd4 - 128;
            double d3 = iZzd - 128;
            iArr[iZzd6] = zzb((byte) (255 - (iZzd2 & 255)), Math.max(0, Math.min((int) ((1.402d * d2) + d), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) ((d3 * 1.772d) + d), 255)));
            iZzd5 = iZzd5;
            i2 = 8;
        }
        return new zzakx(iZzd5, iArrZzg, iArrZzh, iArrZzi);
    }

    private static zzakz zzd(zzem zzemVar) {
        byte[] bArr;
        int iZzd = zzemVar.zzd(16);
        zzemVar.zzn(4);
        int iZzd2 = zzemVar.zzd(2);
        boolean zZzp = zzemVar.zzp();
        zzemVar.zzn(1);
        byte[] bArr2 = zzex.zzb;
        if (iZzd2 != 1) {
            if (iZzd2 == 0) {
                int iZzd3 = zzemVar.zzd(16);
                int iZzd4 = zzemVar.zzd(16);
                if (iZzd3 > 0) {
                    bArr2 = new byte[iZzd3];
                    zzemVar.zzi(bArr2, 0, iZzd3);
                }
                if (iZzd4 > 0) {
                    bArr = new byte[iZzd4];
                    zzemVar.zzi(bArr, 0, iZzd4);
                }
            }
            return new zzakz(iZzd, zZzp, bArr2, bArr);
        }
        zzemVar.zzn(zzemVar.zzd(8) * 16);
        bArr = bArr2;
        return new zzakz(iZzd, zZzp, bArr2, bArr);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0219  */
    /* JADX WARN: Code duplicated, block: B:119:0x0228 A[LOOP:3: B:88:0x0172->B:119:0x0228, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0222 A[SYNTHETIC] */
    private static void zze(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        char c;
        char c2;
        int iZzd;
        int i4;
        int iZzd2;
        int iZzd3;
        int i5;
        int i6;
        int iZzd4;
        zzem zzemVar = new zzem(bArr, bArr.length);
        int i7 = i2;
        int i8 = i3;
        byte[] bArrZzf = null;
        byte[] bArrZzf2 = null;
        byte[] bArrZzf3 = null;
        while (zzemVar.zza() != 0) {
            int i9 = 8;
            int iZzd5 = zzemVar.zzd(8);
            if (iZzd5 != 240) {
                int i10 = 4;
                int i11 = 1;
                int i12 = 2;
                switch (iZzd5) {
                    case 16:
                        int i13 = 1;
                        if (i == 3) {
                            if (bArrZzf == null) {
                                bArr3 = zzb;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrZzf;
                            }
                        } else if (i != 2) {
                            bArr2 = null;
                        } else if (bArrZzf3 == null) {
                            bArr3 = zza;
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArrZzf3;
                        }
                        int i14 = i7;
                        int i15 = 0;
                        while (true) {
                            int iZzd6 = zzemVar.zzd(2);
                            if (iZzd6 != 0) {
                                iZzd = i13;
                            } else {
                                if (zzemVar.zzp()) {
                                    iZzd = zzemVar.zzd(3) + 3;
                                    iZzd6 = zzemVar.zzd(2);
                                } else {
                                    if (zzemVar.zzp()) {
                                        iZzd = i13;
                                        iZzd6 = 0;
                                    } else {
                                        int iZzd7 = zzemVar.zzd(2);
                                        if (iZzd7 == 0) {
                                            c = 4;
                                            c2 = '\b';
                                            i15 = i13;
                                            iZzd6 = 0;
                                            iZzd = 0;
                                        } else if (iZzd7 == i13) {
                                            c = 4;
                                            c2 = '\b';
                                            i15 = i15;
                                            iZzd = 2;
                                            iZzd6 = 0;
                                        } else if (iZzd7 == 2) {
                                            c = 4;
                                            c2 = '\b';
                                            iZzd = zzemVar.zzd(4) + 12;
                                            iZzd6 = zzemVar.zzd(2);
                                            i15 = i15;
                                        } else if (iZzd7 != 3) {
                                            iZzd6 = 0;
                                            iZzd = 0;
                                        } else {
                                            c2 = '\b';
                                            iZzd = zzemVar.zzd(8) + 29;
                                            iZzd6 = zzemVar.zzd(2);
                                            i15 = i15;
                                            c = 4;
                                        }
                                    }
                                    c = 4;
                                    c2 = '\b';
                                }
                                if (iZzd == 0 && paint != null) {
                                    int i16 = i8 + 1;
                                    float f = i8;
                                    if (bArr2 != 0) {
                                        iZzd6 = bArr2[iZzd6];
                                    }
                                    paint.setColor(iArr[iZzd6]);
                                    canvas.drawRect(i14, f, i14 + iZzd, i16, paint);
                                }
                                i14 += iZzd;
                                if (i15 != 0) {
                                    zzemVar.zzf();
                                    i7 = i14;
                                } else {
                                    i15 = i15;
                                    i13 = 1;
                                }
                            }
                            c = 4;
                            c2 = '\b';
                            if (iZzd == 0) {
                            }
                            i14 += iZzd;
                            if (i15 != 0) {
                                zzemVar.zzf();
                                i7 = i14;
                            } else {
                                i15 = i15;
                                i13 = 1;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrZzf2 == null ? zzc : bArrZzf2 : null;
                        int i17 = i7;
                        boolean z = false;
                        while (true) {
                            int iZzd8 = zzemVar.zzd(i10);
                            if (iZzd8 != 0) {
                                i4 = 1;
                                z = z;
                            } else if (zzemVar.zzp()) {
                                if (zzemVar.zzp()) {
                                    int iZzd9 = zzemVar.zzd(i12);
                                    if (iZzd9 == 0) {
                                        i4 = 1;
                                    } else if (iZzd9 == 1) {
                                        i4 = i12;
                                    } else if (iZzd9 == i12) {
                                        iZzd2 = zzemVar.zzd(i10) + 9;
                                        iZzd3 = zzemVar.zzd(i10);
                                    } else if (iZzd9 != 3) {
                                        z = z;
                                        iZzd8 = 0;
                                        i4 = 0;
                                    } else {
                                        iZzd2 = zzemVar.zzd(i9) + 25;
                                        iZzd3 = zzemVar.zzd(i10);
                                    }
                                    iZzd8 = 0;
                                } else {
                                    iZzd2 = zzemVar.zzd(i12) + i10;
                                    iZzd3 = zzemVar.zzd(i10);
                                }
                                z = z;
                                i4 = iZzd2;
                                iZzd8 = iZzd3;
                            } else {
                                int iZzd10 = zzemVar.zzd(3);
                                if (iZzd10 != 0) {
                                    i4 = iZzd10 + 2;
                                    iZzd8 = 0;
                                } else {
                                    z = true;
                                    iZzd8 = 0;
                                    i4 = 0;
                                }
                            }
                            if (i4 == 0 || paint == null) {
                                i5 = i12;
                            } else {
                                int i18 = i8 + 1;
                                float f2 = i8;
                                if (bArr4 != 0) {
                                    iZzd8 = bArr4[iZzd8];
                                }
                                paint.setColor(iArr[iZzd8]);
                                i5 = 2;
                                canvas.drawRect(i17, f2, i17 + i4, i18, paint);
                            }
                            i17 += i4;
                            if (z) {
                                zzemVar.zzf();
                                i7 = i17;
                            } else {
                                i12 = i5;
                                z = z;
                                i10 = 4;
                                i9 = 8;
                            }
                            break;
                        }
                        break;
                    case 18:
                        int i19 = i7;
                        int i20 = 0;
                        while (true) {
                            int iZzd11 = zzemVar.zzd(8);
                            if (iZzd11 != 0) {
                                i6 = i20;
                                iZzd4 = i11;
                            } else if (zzemVar.zzp()) {
                                i6 = i20;
                                iZzd4 = zzemVar.zzd(7);
                                iZzd11 = zzemVar.zzd(8);
                            } else {
                                int iZzd12 = zzemVar.zzd(7);
                                if (iZzd12 != 0) {
                                    i6 = i20;
                                    iZzd4 = iZzd12;
                                    iZzd11 = 0;
                                } else {
                                    i6 = i11;
                                    iZzd11 = 0;
                                    iZzd4 = 0;
                                }
                            }
                            if (iZzd4 != 0 && paint != null) {
                                paint.setColor(iArr[iZzd11]);
                                canvas.drawRect(i19, i8, i19 + iZzd4, i8 + 1, paint);
                            }
                            i19 += iZzd4;
                            if (i6 != 0) {
                                i7 = i19;
                            } else {
                                i11 = i11;
                                i20 = i6;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iZzd5) {
                            case 32:
                                bArrZzf3 = zzf(4, 4, zzemVar);
                                break;
                            case 33:
                                bArrZzf = zzf(4, 8, zzemVar);
                                break;
                            case 34:
                                bArrZzf2 = zzf(16, 8, zzemVar);
                                break;
                        }
                        break;
                }
            } else {
                i8 += 2;
                i7 = i2;
            }
        }
    }

    private static byte[] zzf(int i, int i2, zzem zzemVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzemVar.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 127, i3 != 0 ? 127 : 0, i2 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzb(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzb(127, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzakl zzaklVar;
        char c;
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        zzalc zzalcVar;
        int i6;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i7;
        int iZzd5;
        zzem zzemVar = new zzem(bArr, i + i2);
        zzemVar.zzl(i);
        while (zzemVar.zza() >= 48 && zzemVar.zzd(8) == 15) {
            zzale zzaleVar = this.zzi;
            int iZzd6 = zzemVar.zzd(8);
            int iZzd7 = zzemVar.zzd(16);
            int iZzd8 = zzemVar.zzd(16);
            int iZzb = zzemVar.zzb() + iZzd8;
            if (iZzd8 * 8 > zzemVar.zza()) {
                zzea.zzf("DvbParser", "Data field length exceeds limit");
                zzemVar.zzn(zzemVar.zza());
            } else {
                switch (iZzd6) {
                    case 16:
                        if (iZzd7 == zzaleVar.zza) {
                            zzala zzalaVar = zzaleVar.zzi;
                            int iZzd9 = zzemVar.zzd(8);
                            int iZzd10 = zzemVar.zzd(4);
                            int iZzd11 = zzemVar.zzd(2);
                            zzemVar.zzn(2);
                            SparseArray sparseArray = new SparseArray();
                            for (int i8 = iZzd8 - 2; i8 > 0; i8 -= 6) {
                                int iZzd12 = zzemVar.zzd(8);
                                zzemVar.zzn(8);
                                sparseArray.put(iZzd12, new zzalb(zzemVar.zzd(16), zzemVar.zzd(16)));
                            }
                            zzala zzalaVar2 = new zzala(iZzd9, iZzd10, iZzd11, sparseArray);
                            if (zzalaVar2.zzb != 0) {
                                zzaleVar.zzi = zzalaVar2;
                                zzaleVar.zzc.clear();
                                zzaleVar.zzd.clear();
                                zzaleVar.zze.clear();
                            } else if (zzalaVar != null) {
                                if (zzalaVar.zza != zzalaVar2.zza) {
                                    zzaleVar.zzi = zzalaVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzala zzalaVar3 = zzaleVar.zzi;
                        if (iZzd7 == zzaleVar.zza && zzalaVar3 != null) {
                            int iZzd13 = zzemVar.zzd(8);
                            zzemVar.zzn(4);
                            boolean zZzp = zzemVar.zzp();
                            zzemVar.zzn(3);
                            int iZzd14 = zzemVar.zzd(16);
                            int iZzd15 = zzemVar.zzd(16);
                            int iZzd16 = zzemVar.zzd(3);
                            int iZzd17 = zzemVar.zzd(3);
                            zzemVar.zzn(2);
                            int iZzd18 = zzemVar.zzd(8);
                            int iZzd19 = zzemVar.zzd(8);
                            int iZzd20 = zzemVar.zzd(4);
                            int iZzd21 = zzemVar.zzd(2);
                            zzemVar.zzn(2);
                            int i9 = iZzd8 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while (i9 > 0) {
                                int iZzd22 = zzemVar.zzd(16);
                                int iZzd23 = zzemVar.zzd(2);
                                int iZzd24 = zzemVar.zzd(2);
                                int iZzd25 = zzemVar.zzd(12);
                                zzemVar.zzn(4);
                                int iZzd26 = zzemVar.zzd(12);
                                int i10 = i9 - 6;
                                if (iZzd23 == 1) {
                                    i9 -= 8;
                                    i6 = iZzd23;
                                    iZzd = zzemVar.zzd(8);
                                    iZzd2 = zzemVar.zzd(8);
                                } else if (iZzd23 == 2) {
                                    iZzd23 = 2;
                                    i9 -= 8;
                                    i6 = iZzd23;
                                    iZzd = zzemVar.zzd(8);
                                    iZzd2 = zzemVar.zzd(8);
                                } else {
                                    i6 = iZzd23;
                                    i9 = i10;
                                    iZzd = 0;
                                    iZzd2 = 0;
                                }
                                sparseArray2.put(iZzd22, new zzald(i6, iZzd24, iZzd25, iZzd26, iZzd, iZzd2));
                            }
                            zzalc zzalcVar2 = new zzalc(iZzd13, zZzp, iZzd14, iZzd15, iZzd16, iZzd17, iZzd18, iZzd19, iZzd20, iZzd21, sparseArray2);
                            if (zzalaVar3.zzb == 0 && (zzalcVar = (zzalc) zzaleVar.zzc.get(zzalcVar2.zza)) != null) {
                                int i11 = 0;
                                while (true) {
                                    SparseArray sparseArray3 = zzalcVar.zzj;
                                    if (i11 < sparseArray3.size()) {
                                        zzalcVar2.zzj.put(sparseArray3.keyAt(i11), (zzald) sparseArray3.valueAt(i11));
                                        i11++;
                                    }
                                }
                            }
                            zzaleVar.zzc.put(zzalcVar2.zza, zzalcVar2);
                        }
                        break;
                    case 18:
                        if (iZzd7 == zzaleVar.zza) {
                            zzakx zzakxVarZzc = zzc(zzemVar, iZzd8);
                            zzaleVar.zzd.put(zzakxVarZzc.zza, zzakxVarZzc);
                        } else if (iZzd7 == zzaleVar.zzb) {
                            zzakx zzakxVarZzc2 = zzc(zzemVar, iZzd8);
                            zzaleVar.zzf.put(zzakxVarZzc2.zza, zzakxVarZzc2);
                        }
                        break;
                    case 19:
                        if (iZzd7 == zzaleVar.zza) {
                            zzakz zzakzVarZzd = zzd(zzemVar);
                            zzaleVar.zze.put(zzakzVarZzd.zza, zzakzVarZzd);
                        } else if (iZzd7 == zzaleVar.zzb) {
                            zzakz zzakzVarZzd2 = zzd(zzemVar);
                            zzaleVar.zzg.put(zzakzVarZzd2.zza, zzakzVarZzd2);
                        }
                        break;
                    case 20:
                        if (iZzd7 == zzaleVar.zza) {
                            zzemVar.zzn(4);
                            boolean zZzp2 = zzemVar.zzp();
                            zzemVar.zzn(3);
                            int iZzd27 = zzemVar.zzd(16);
                            int iZzd28 = zzemVar.zzd(16);
                            if (zZzp2) {
                                int iZzd29 = zzemVar.zzd(16);
                                iZzd3 = zzemVar.zzd(16);
                                iZzd5 = zzemVar.zzd(16);
                                iZzd4 = zzemVar.zzd(16);
                                i7 = iZzd29;
                            } else {
                                iZzd3 = iZzd27;
                                iZzd4 = iZzd28;
                                i7 = 0;
                                iZzd5 = 0;
                            }
                            zzaleVar.zzh = new zzaky(iZzd27, iZzd28, i7, iZzd3, iZzd5, iZzd4);
                        }
                        break;
                }
                zzemVar.zzo(iZzb - zzemVar.zzb());
            }
        }
        zzale zzaleVar2 = this.zzi;
        zzala zzalaVar4 = zzaleVar2.zzi;
        if (zzalaVar4 == null) {
            zzaklVar = new zzakl(zzfyq.zzn(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzaky zzakyVar = zzaleVar2.zzh;
            if (zzakyVar == null) {
                zzakyVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakyVar.zza + 1 != bitmap.getWidth() || zzakyVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzakyVar.zza + 1, zzakyVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzalaVar4.zzc;
            int i12 = 0;
            while (i12 < sparseArray4.size()) {
                Canvas canvas = this.zzf;
                canvas.save();
                zzalb zzalbVar = (zzalb) sparseArray4.valueAt(i12);
                zzalc zzalcVar3 = (zzalc) zzaleVar2.zzc.get(sparseArray4.keyAt(i12));
                int i13 = zzalbVar.zza + zzakyVar.zzc;
                int i14 = zzalbVar.zzb + zzakyVar.zze;
                int i15 = zzalcVar3.zzc;
                int i16 = i13 + i15;
                int iMin = Math.min(i16, zzakyVar.zzd);
                int i17 = zzalcVar3.zzd;
                int i18 = i14 + i17;
                canvas.clipRect(i13, i14, iMin, Math.min(i18, zzakyVar.zzf));
                int i19 = zzalcVar3.zzf;
                zzakx zzakxVar = (zzakx) zzaleVar2.zzd.get(i19);
                if (zzakxVar == null && (zzakxVar = (zzakx) zzaleVar2.zzf.get(i19)) == null) {
                    zzakxVar = this.zzh;
                }
                SparseArray sparseArray5 = zzalcVar3.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i20 = i16;
                int i21 = 0;
                while (i21 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i21);
                    SparseArray sparseArray7 = sparseArray5;
                    zzald zzaldVar = (zzald) sparseArray5.valueAt(i21);
                    int i22 = i15;
                    zzakz zzakzVar = (zzakz) zzaleVar2.zze.get(iKeyAt);
                    if (zzakzVar == null) {
                        zzakzVar = (zzakz) zzaleVar2.zzg.get(iKeyAt);
                    }
                    if (zzakzVar != null) {
                        Paint paint = zzakzVar.zzb ? null : this.zzd;
                        int i23 = zzalcVar3.zze;
                        int i24 = zzaldVar.zza + i13;
                        int i25 = zzaldVar.zzb + i14;
                        int i26 = i13;
                        int[] iArr = i23 == 3 ? zzakxVar.zzd : i23 == 2 ? zzakxVar.zzc : zzakxVar.zzb;
                        i5 = i22;
                        i4 = i26;
                        zze(zzakzVar.zzc, iArr, i23, i24, i25, paint, canvas);
                        zze(zzakzVar.zzd, iArr, i23, i24, i25 + 1, paint, canvas);
                    } else {
                        i4 = i13;
                        i5 = i22;
                    }
                    i21++;
                    i13 = i4;
                    zzalcVar3 = zzalcVar3;
                    i20 = i20;
                    sparseArray5 = sparseArray7;
                    zzaleVar2 = zzaleVar2;
                    i12 = i12;
                    arrayList = arrayList;
                    zzakyVar = zzakyVar;
                    i17 = i17;
                    i15 = i5;
                }
                zzale zzaleVar3 = zzaleVar2;
                zzaky zzakyVar2 = zzakyVar;
                int i27 = i17;
                int i28 = i12;
                ArrayList arrayList2 = arrayList;
                int i29 = i15;
                int i30 = i13;
                zzalc zzalcVar4 = zzalcVar3;
                int i31 = i20;
                float f = i14;
                float f2 = i30;
                if (zzalcVar4.zzb) {
                    int i32 = zzalcVar4.zze;
                    if (i32 == 3) {
                        i3 = zzakxVar.zzd[zzalcVar4.zzg];
                        c3 = 2;
                    } else {
                        c3 = 2;
                        i3 = i32 == 2 ? zzakxVar.zzc[zzalcVar4.zzh] : zzakxVar.zzb[zzalcVar4.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i3);
                    float f3 = i18;
                    float f4 = i31;
                    c = c3;
                    c2 = 3;
                    canvas.drawRect(f2, f, f4, f3, paint2);
                } else {
                    c = 2;
                    c2 = 3;
                }
                zzcs zzcsVar = new zzcs();
                zzcsVar.zzc(Bitmap.createBitmap(this.zzj, i30, i14, i29, i27));
                zzakyVar = zzakyVar2;
                float f5 = zzakyVar.zza;
                zzcsVar.zzh(f2 / f5);
                zzcsVar.zzi(0);
                float f6 = zzakyVar.zzb;
                zzcsVar.zze(f / f6, 0);
                zzcsVar.zzf(0);
                zzcsVar.zzk(i29 / f5);
                zzcsVar.zzd(i27 / f6);
                arrayList2.add(zzcsVar.zzq());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                sparseArray4 = sparseArray6;
                arrayList = arrayList2;
                i12 = i28 + 1;
                zzaleVar2 = zzaleVar3;
            }
            zzaklVar = new zzakl(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdnVar.zza(zzaklVar);
    }
}
