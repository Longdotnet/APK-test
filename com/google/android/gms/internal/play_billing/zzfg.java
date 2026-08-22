package com.google.android.gms.internal.play_billing;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfg {
    private static final zzfg zza = new zzfg(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzfg(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzfg zzc() {
        return zza;
    }

    public static zzfg zze(zzfg zzfgVar, zzfg zzfgVar2) {
        int i = zzfgVar.zzb + zzfgVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzfgVar.zzc, i);
        System.arraycopy(zzfgVar2.zzc, 0, iArrCopyOf, zzfgVar.zzb, zzfgVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzfgVar.zzd, i);
        System.arraycopy(zzfgVar2.zzd, 0, objArrCopyOf, zzfgVar.zzb, zzfgVar2.zzb);
        return new zzfg(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzfg zzf() {
        return new zzfg(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfgVar = (zzfg) obj;
        int i = this.zzb;
        if (i == zzfgVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzfgVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzfgVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, 31, i3, 31);
        Object[] objArr = this.zzd;
        int i5 = this.zzb;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + objArr[i6].hashCode();
        }
        return iM + iHashCode;
    }

    public final int zza() {
        int iZzw;
        int iZzx;
        int iZzw2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzw3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int i6 = i4 << 3;
                        zzbq zzbqVar = (zzbq) this.zzd[i2];
                        int iZzw4 = zzby.zzw(i6);
                        int iZzd = zzbqVar.zzd();
                        iZzw3 = zzby.zzw(iZzd) + iZzd + iZzw4 + iZzw3;
                    } else if (i5 == 3) {
                        int iZzw5 = zzby.zzw(i4 << 3);
                        iZzw = iZzw5 + iZzw5;
                        iZzx = ((zzfg) this.zzd[i2]).zza();
                    } else {
                        if (i5 != 5) {
                            throw new IllegalStateException(zzdc.zza());
                        }
                        ((Integer) this.zzd[i2]).getClass();
                        iZzw2 = zzby.zzw(i4 << 3) + 4;
                    }
                } else {
                    ((Long) this.zzd[i2]).getClass();
                    iZzw2 = zzby.zzw(i4 << 3) + 8;
                }
                iZzw3 = iZzw2 + iZzw3;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzw = zzby.zzw(i7);
                iZzx = zzby.zzx(jLongValue);
            }
            iZzw3 = iZzx + iZzw + iZzw3;
        }
        this.zze = iZzw3;
        return iZzw3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM$3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzbq zzbqVar = (zzbq) this.zzd[i2];
            int iZzw = zzby.zzw(8);
            int iZzw2 = zzby.zzw(i3) + zzby.zzw(16);
            int iZzw3 = zzby.zzw(24);
            int iZzd = zzbqVar.zzd();
            iM$3 += iZzw + iZzw + iZzw2 + BarcodeFormat$EnumUnboxingLocalUtility.m$3(iZzd, iZzd, iZzw3);
        }
        this.zze = iM$3;
        return iM$3;
    }

    public final zzfg zzd(zzfg zzfgVar) {
        if (zzfgVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzfgVar.zzb;
        zzm(i);
        System.arraycopy(zzfgVar.zzc, 0, this.zzc, this.zzb, zzfgVar.zzb);
        System.arraycopy(zzfgVar.zzd, 0, this.zzd, this.zzb, zzfgVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzee.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzfx zzfxVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzfxVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzfx zzfxVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzfxVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzfxVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzfxVar.zzd(i4, (zzbq) obj);
                } else if (i3 == 3) {
                    zzfxVar.zzF(i4);
                    ((zzfg) obj).zzl(zzfxVar);
                    zzfxVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzdc.zza());
                    }
                    zzfxVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    private zzfg() {
        this(0, new int[8], new Object[8], true);
    }
}
