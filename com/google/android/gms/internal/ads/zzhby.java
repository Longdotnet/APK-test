package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzhby {
    private static final zzhby zza = new zzhby(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhby(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhby zzc() {
        return zza;
    }

    public static zzhby zze(zzhby zzhbyVar, zzhby zzhbyVar2) {
        int i = zzhbyVar.zzb + zzhbyVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhbyVar.zzc, i);
        System.arraycopy(zzhbyVar2.zzc, 0, iArrCopyOf, zzhbyVar.zzb, zzhbyVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhbyVar.zzd, i);
        System.arraycopy(zzhbyVar2.zzd, 0, objArrCopyOf, zzhbyVar.zzb, zzhbyVar2.zzb);
        return new zzhby(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzhby zzf() {
        return new zzhby();
    }

    private final void zzn(int i) {
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
        if (obj == null || !(obj instanceof zzhby)) {
            return false;
        }
        zzhby zzhbyVar = (zzhby) obj;
        int i = this.zzb;
        if (i == zzhbyVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhbyVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzhbyVar.zzd;
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
        int iZzD;
        int iZzE;
        int iZzD2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzD3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int i6 = i4 << 3;
                        zzgxz zzgxzVar = (zzgxz) this.zzd[i2];
                        int iZzD4 = zzgym.zzD(i6);
                        int iZzd = zzgxzVar.zzd();
                        iZzD3 = zzgym.zzD(iZzd) + iZzd + iZzD4 + iZzD3;
                    } else if (i5 == 3) {
                        int iZzD5 = zzgym.zzD(i4 << 3);
                        iZzD = iZzD5 + iZzD5;
                        iZzE = ((zzhby) this.zzd[i2]).zza();
                    } else {
                        if (i5 != 5) {
                            throw new IllegalStateException(new zzgzv("Protocol message tag had invalid wire type."));
                        }
                        ((Integer) this.zzd[i2]).getClass();
                        iZzD2 = zzgym.zzD(i4 << 3) + 4;
                    }
                } else {
                    ((Long) this.zzd[i2]).getClass();
                    iZzD2 = zzgym.zzD(i4 << 3) + 8;
                }
                iZzD3 = iZzD2 + iZzD3;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzD = zzgym.zzD(i7);
                iZzE = zzgym.zzE(jLongValue);
            }
            iZzD3 = iZzE + iZzD + iZzD3;
        }
        this.zze = iZzD3;
        return iZzD3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iM = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzgxz zzgxzVar = (zzgxz) this.zzd[i2];
            int iZzD = zzgym.zzD(8);
            int iZzD2 = zzgym.zzD(i3) + zzgym.zzD(16);
            int iZzD3 = zzgym.zzD(24);
            int iZzd = zzgxzVar.zzd();
            iM += iZzD + iZzD + iZzD2 + BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd, iZzd, iZzD3);
        }
        this.zze = iM;
        return iM;
    }

    public final zzhby zzd(zzhby zzhbyVar) {
        if (zzhbyVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhbyVar.zzb;
        zzn(i);
        System.arraycopy(zzhbyVar.zzc, 0, this.zzc, this.zzb, zzhbyVar.zzb);
        System.arraycopy(zzhbyVar.zzd, 0, this.zzd, this.zzb, zzhbyVar.zzb);
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
            zzhau.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzj(int i, Object obj) {
        zzg();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzhcm zzhcmVar) {
        for (int i = 0; i < this.zzb; i++) {
            zzhcmVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzhcm zzhcmVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhcmVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhcmVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhcmVar.zzd(i4, (zzgxz) obj);
                } else if (i3 == 3) {
                    zzhcmVar.zzF(i4);
                    ((zzhby) obj).zzl(zzhcmVar);
                    zzhcmVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zzgzv("Protocol message tag had invalid wire type."));
                    }
                    zzhcmVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final boolean zzm(int i, zzgyf zzgyfVar) throws zzgzv {
        int iZzl;
        zzg();
        int i2 = i & 7;
        if (i2 == 0) {
            zzj(i, Long.valueOf(zzgyfVar.zzo()));
            return true;
        }
        if (i2 == 1) {
            zzj(i, Long.valueOf(zzgyfVar.zzn()));
            return true;
        }
        if (i2 == 2) {
            zzj(i, zzgyfVar.zzv());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                zzgyfVar.zzy(0);
                return false;
            }
            if (i2 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            zzj(i, Integer.valueOf(zzgyfVar.zzf()));
            return true;
        }
        zzhby zzhbyVar = new zzhby();
        do {
            iZzl = zzgyfVar.zzl();
            if (iZzl == 0) {
                break;
            }
        } while (zzhbyVar.zzm(iZzl, zzgyfVar));
        zzgyfVar.zzy(4 | ((i >>> 3) << 3));
        zzj(i, zzhbyVar);
        return true;
    }

    private zzhby() {
        this(0, new int[8], new Object[8], true);
    }
}
