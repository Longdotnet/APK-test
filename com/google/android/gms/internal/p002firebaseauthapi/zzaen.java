package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.protobuf.DescriptorProtos;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.Jbo.ygoi;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class zzaen<T> implements zzaew<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzafx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaek zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzady zzn;
    private final zzafn zzo;
    private final zzact zzp;
    private final zzaep zzq;
    private final zzaef zzr;

    private zzaen(int[] iArr, Object[] objArr, int i, int i2, zzaek zzaekVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzaep zzaepVar, zzady zzadyVar, zzafn zzafnVar, zzact zzactVar, zzaef zzaefVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzaekVar instanceof zzadf;
        this.zzj = z;
        boolean z3 = false;
        if (zzactVar != null && zzactVar.zzh(zzaekVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzq = zzaepVar;
        this.zzn = zzadyVar;
        this.zzo = zzafnVar;
        this.zzp = zzactVar;
        this.zzg = zzaekVar;
        this.zzr = zzaefVar;
    }

    private final int zzA(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzB(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzC(int i) {
        return this.zzc[i + 1];
    }

    private static long zzD(Object obj, long j) {
        return ((Long) zzafx.zzf(obj, j)).longValue();
    }

    private final zzadj zzE(int i) {
        int i2 = i / 3;
        return (zzadj) this.zzd[i2 + i2 + 1];
    }

    private final zzaew zzF(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzaew zzaewVar = (zzaew) this.zzd[i3];
        if (zzaewVar != null) {
            return zzaewVar;
        }
        zzaew zzaewVarZzb = zzaes.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzaewVarZzb;
        return zzaewVarZzb;
    }

    private final Object zzG(Object obj, int i, Object obj2, zzafn zzafnVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzf = zzafx.zzf(obj, zzC(i) & 1048575);
        if (objZzf == null || zzE(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzH(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzI(Object obj, int i) {
        zzaew zzaewVarZzF = zzF(i);
        long jZzC = zzC(i) & 1048575;
        if (!zzV(obj, i)) {
            return zzaewVarZzF.zze();
        }
        Object object = zzb.getObject(obj, jZzC);
        if (zzY(object)) {
            return object;
        }
        Object objZze = zzaewVarZzF.zze();
        if (object != null) {
            zzaewVarZzF.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzJ(Object obj, int i, int i2) {
        zzaew zzaewVarZzF = zzF(i2);
        if (!zzZ(obj, i, i2)) {
            return zzaewVarZzF.zze();
        }
        Object object = zzb.getObject(obj, zzC(i2) & 1048575);
        if (zzY(object)) {
            return object;
        }
        Object objZze = zzaewVarZzF.zze();
        if (object != null) {
            zzaewVarZzF.zzg(objZze, object);
        }
        return objZze;
    }

    private static void zzL(Object obj) {
        if (!zzY(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzM(Object obj, Object obj2, int i) {
        if (zzV(obj2, i)) {
            long jZzC = zzC(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, jZzC);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzaew zzaewVarZzF = zzF(i);
            if (!zzV(obj, i)) {
                if (zzY(object)) {
                    Object objZze = zzaewVarZzF.zze();
                    zzaewVarZzF.zzg(objZze, object);
                    unsafe.putObject(obj, jZzC, objZze);
                } else {
                    unsafe.putObject(obj, jZzC, object);
                }
                zzP(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jZzC);
            if (!zzY(object2)) {
                Object objZze2 = zzaewVarZzF.zze();
                zzaewVarZzF.zzg(objZze2, object2);
                unsafe.putObject(obj, jZzC, objZze2);
                object2 = objZze2;
            }
            zzaewVarZzF.zzg(object2, object);
        }
    }

    private final void zzO(Object obj, int i, zzaev zzaevVar) {
        if (zzU(i)) {
            zzafx.zzs(obj, i & 1048575, zzaevVar.zzs());
        } else if (this.zzi) {
            zzafx.zzs(obj, i & 1048575, zzaevVar.zzr());
        } else {
            zzafx.zzs(obj, i & 1048575, zzaevVar.zzp());
        }
    }

    private final void zzP(Object obj, int i) {
        int iZzz = zzz(i);
        long j = 1048575 & iZzz;
        if (j == 1048575) {
            return;
        }
        zzafx.zzq(obj, j, (1 << (iZzz >>> 20)) | zzafx.zzc(obj, j));
    }

    private final void zzQ(Object obj, int i, int i2) {
        zzafx.zzq(obj, zzz(i2) & 1048575, i);
    }

    private final void zzR(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzC(i) & 1048575, obj2);
        zzP(obj, i);
    }

    private final void zzS(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzC(i2) & 1048575, obj2);
        zzQ(obj, i, i2);
    }

    private final boolean zzT(Object obj, Object obj2, int i) {
        return zzV(obj, i) == zzV(obj2, i);
    }

    private static boolean zzU(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzV(Object obj, int i) {
        int iZzz = zzz(i);
        long j = iZzz & 1048575;
        if (j != 1048575) {
            return (zzafx.zzc(obj, j) & (1 << (iZzz >>> 20))) != 0;
        }
        int iZzC = zzC(i);
        long j2 = iZzC & 1048575;
        switch (zzB(iZzC)) {
            case 0:
                return Double.doubleToRawLongBits(zzafx.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzafx.zzb(obj, j2)) != 0;
            case 2:
                return zzafx.zzd(obj, j2) != 0;
            case 3:
                return zzafx.zzd(obj, j2) != 0;
            case 4:
                return zzafx.zzc(obj, j2) != 0;
            case 5:
                return zzafx.zzd(obj, j2) != 0;
            case 6:
                return zzafx.zzc(obj, j2) != 0;
            case 7:
                return zzafx.zzw(obj, j2);
            case 8:
                Object objZzf = zzafx.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzacc) {
                    return !zzacc.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzafx.zzf(obj, j2) != null;
            case 10:
                return !zzacc.zzb.equals(zzafx.zzf(obj, j2));
            case 11:
                return zzafx.zzc(obj, j2) != 0;
            case 12:
                return zzafx.zzc(obj, j2) != 0;
            case 13:
                return zzafx.zzc(obj, j2) != 0;
            case 14:
                return zzafx.zzd(obj, j2) != 0;
            case 15:
                return zzafx.zzc(obj, j2) != 0;
            case 16:
                return zzafx.zzd(obj, j2) != 0;
            case 17:
                return zzafx.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzW(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzV(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzX(Object obj, int i, zzaew zzaewVar) {
        return zzaewVar.zzk(zzafx.zzf(obj, i & 1048575));
    }

    private static boolean zzY(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzadf) {
            return ((zzadf) obj).zzK();
        }
        return true;
    }

    private final boolean zzZ(Object obj, int i, int i2) {
        return zzafx.zzc(obj, (long) (zzz(i2) & 1048575)) == i;
    }

    private static boolean zzaa(Object obj, long j) {
        return ((Boolean) zzafx.zzf(obj, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void zzab(Object obj, zzaco zzacoVar) {
        int i;
        boolean z;
        if (this.zzh) {
            this.zzp.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iZzC = zzC(i4);
            int[] iArr = this.zzc;
            int i6 = iArr[i4];
            int iZzB = zzB(iZzC);
            if (iZzB <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzC & i2;
            switch (iZzB) {
                case 0:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzf(i6, zzafx.zza(obj, j));
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzo(i6, zzafx.zzb(obj, j));
                    }
                    break;
                case 2:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzt(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzJ(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzr(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzm(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzk(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzb(i6, zzafx.zzw(obj, j));
                    }
                    break;
                case 8:
                    if ((i5 & i) != 0) {
                        zzad(i6, unsafe.getObject(obj, j), zzacoVar);
                    }
                    break;
                case 9:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzv(i6, unsafe.getObject(obj, j), zzF(i4));
                    }
                    break;
                case 10:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzd(i6, (zzacc) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzH(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzi(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzw(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzy(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzA(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzC(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if ((i5 & i) != 0) {
                        zzacoVar.zzq(i6, unsafe.getObject(obj, j), zzF(i4));
                    }
                    break;
                case 18:
                    zzaey.zzL(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 19:
                    zzaey.zzP(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 20:
                    zzaey.zzS(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 21:
                    zzaey.zzaa(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 22:
                    zzaey.zzR(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    zzaey.zzO(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 24:
                    zzaey.zzN(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 25:
                    zzaey.zzJ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 26:
                    zzaey.zzY(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar);
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    zzaey.zzT(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, zzF(i4));
                    break;
                case 28:
                    zzaey.zzK(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar);
                    break;
                case 29:
                    z = false;
                    zzaey.zzZ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 30:
                    z = false;
                    zzaey.zzM(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    z = false;
                    zzaey.zzU(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 32:
                    z = false;
                    zzaey.zzV(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 33:
                    z = false;
                    zzaey.zzW(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case 34:
                    z = false;
                    zzaey.zzX(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, false);
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    zzaey.zzL(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    zzaey.zzP(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    zzaey.zzS(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 38:
                    zzaey.zzaa(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    zzaey.zzR(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    zzaey.zzO(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    zzaey.zzN(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 42:
                    zzaey.zzJ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 43:
                    zzaey.zzZ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    zzaey.zzM(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    zzaey.zzU(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 46:
                    zzaey.zzV(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 47:
                    zzaey.zzW(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 48:
                    zzaey.zzX(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, true);
                    break;
                case 49:
                    zzaey.zzQ(this.zzc[i4], (List) unsafe.getObject(obj, j), zzacoVar, zzF(i4));
                    break;
                case 50:
                    zzac(zzacoVar, i6, unsafe.getObject(obj, j), i4);
                    break;
                case 51:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzf(i6, zzo(obj, j));
                    }
                    break;
                case 52:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzo(i6, zzp(obj, j));
                    }
                    break;
                case 53:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzt(i6, zzD(obj, j));
                    }
                    break;
                case 54:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzJ(i6, zzD(obj, j));
                    }
                    break;
                case 55:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzr(i6, zzs(obj, j));
                    }
                    break;
                case 56:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzm(i6, zzD(obj, j));
                    }
                    break;
                case 57:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzk(i6, zzs(obj, j));
                    }
                    break;
                case 58:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzb(i6, zzaa(obj, j));
                    }
                    break;
                case 59:
                    if (zzZ(obj, i6, i4)) {
                        zzad(i6, unsafe.getObject(obj, j), zzacoVar);
                    }
                    break;
                case 60:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzv(i6, unsafe.getObject(obj, j), zzF(i4));
                    }
                    break;
                case 61:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzd(i6, (zzacc) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzH(i6, zzs(obj, j));
                    }
                    break;
                case 63:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzi(i6, zzs(obj, j));
                    }
                    break;
                case 64:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzw(i6, zzs(obj, j));
                    }
                    break;
                case 65:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzy(i6, zzD(obj, j));
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzA(i6, zzs(obj, j));
                    }
                    break;
                case 67:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzC(i6, zzD(obj, j));
                    }
                    break;
                case 68:
                    if (zzZ(obj, i6, i4)) {
                        zzacoVar.zzq(i6, unsafe.getObject(obj, j), zzF(i4));
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        zzafn zzafnVar = this.zzo;
        zzafnVar.zzr(zzafnVar.zzd(obj), zzacoVar);
    }

    private final void zzac(zzaco zzacoVar, int i, Object obj, int i2) {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzad(int i, Object obj, zzaco zzacoVar) {
        if (obj instanceof String) {
            zzacoVar.zzF(i, (String) obj);
        } else {
            zzacoVar.zzd(i, (zzacc) obj);
        }
    }

    public static zzafo zzd(Object obj) {
        zzadf zzadfVar = (zzadf) obj;
        zzafo zzafoVar = zzadfVar.zzc;
        if (zzafoVar != zzafo.zzc()) {
            return zzafoVar;
        }
        zzafo zzafoVarZzf = zzafo.zzf();
        zzadfVar.zzc = zzafoVarZzf;
        return zzafoVarZzf;
    }

    public static zzaen zzl(Class cls, zzaeh zzaehVar, zzaep zzaepVar, zzady zzadyVar, zzafn zzafnVar, zzact zzactVar, zzaef zzaefVar) {
        if (zzaehVar instanceof zzaeu) {
            return zzm((zzaeu) zzaehVar, zzaepVar, zzadyVar, zzafnVar, zzactVar, zzaefVar);
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:128:0x027b  */
    /* JADX WARN: Code duplicated, block: B:130:0x027f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0332  */
    /* JADX WARN: Code duplicated, block: B:180:0x0381  */
    /* JADX WARN: Code duplicated, block: B:183:0x038a  */
    public static zzaen zzm(zzaeu zzaeuVar, zzaep zzaepVar, zzady zzadyVar, zzafn zzafnVar, zzact zzactVar, zzaef zzaefVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Object[] objArr;
        int i20;
        int i21;
        Field fieldZzK;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldZzK2;
        int i26;
        Object obj2;
        Field fieldZzK3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        boolean z = zzaeuVar.zzc() == 2;
        String strZzd = zzaeuVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (strZzd.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt4 = strZzd.charAt(i);
        if (iCharAt4 >= 55296) {
            int i33 = iCharAt4 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                cCharAt13 = strZzd.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            iCharAt4 = i33 | (cCharAt13 << i34);
            i32 = i30;
        }
        if (iCharAt4 == 0) {
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i4 = 0;
            iCharAt3 = 0;
            i2 = 0;
            iArr = zza;
            i3 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt5 = strZzd.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i13 = i35 + 1;
                    cCharAt8 = strZzd.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i13;
                }
                iCharAt5 = i36 | (cCharAt8 << i37);
                i35 = i13;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strZzd.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i12 = i38 + 1;
                    cCharAt7 = strZzd.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i12;
                }
                iCharAt6 = i39 | (cCharAt7 << i40);
                i38 = i12;
            }
            int i41 = i38 + 1;
            iCharAt = strZzd.charAt(i38);
            if (iCharAt >= 55296) {
                int i42 = iCharAt & 8191;
                int i43 = 13;
                while (true) {
                    i11 = i41 + 1;
                    cCharAt6 = strZzd.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i11;
                }
                iCharAt = i42 | (cCharAt6 << i43);
                i41 = i11;
            }
            int i44 = i41 + 1;
            int iCharAt7 = strZzd.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i10 = i44 + 1;
                    cCharAt5 = strZzd.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i10;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i10;
            }
            int i47 = i44 + 1;
            iCharAt2 = strZzd.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i9 = i47 + 1;
                    cCharAt4 = strZzd.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i9;
                }
                iCharAt2 = i48 | (cCharAt4 << i49);
                i47 = i9;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strZzd.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i8 = i50 + 1;
                    cCharAt3 = strZzd.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i8;
                }
                iCharAt8 = i51 | (cCharAt3 << i52);
                i50 = i8;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strZzd.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = 13;
                while (true) {
                    i7 = i53 + 1;
                    cCharAt2 = strZzd.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i7;
                }
                iCharAt9 = i54 | (cCharAt2 << i55);
                i53 = i7;
            }
            int i56 = i53 + 1;
            iCharAt3 = strZzd.charAt(i53);
            if (iCharAt3 >= 55296) {
                int i57 = iCharAt3 & 8191;
                int i58 = 13;
                while (true) {
                    i6 = i56 + 1;
                    cCharAt = strZzd.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i56 = i6;
                }
                iCharAt3 = i57 | (cCharAt << i58);
                i56 = i6;
            }
            iArr = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i2 = iCharAt5 + iCharAt5 + iCharAt6;
            i3 = iCharAt5;
            i32 = i56;
            int i59 = iCharAt8;
            i4 = iCharAt7;
            i5 = i59;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzaeuVar.zze();
        Class<?> cls = zzaeuVar.zza().getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 + iCharAt2];
        int i60 = iCharAt3 + i5;
        int i61 = iCharAt3;
        int i62 = i60;
        int i63 = 0;
        int i64 = 0;
        while (i32 < length) {
            int i65 = i32 + 1;
            int iCharAt10 = strZzd.charAt(i32);
            if (iCharAt10 >= c) {
                int i66 = iCharAt10 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i29 = i67 + 1;
                    cCharAt12 = strZzd.charAt(i67);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i66 |= (cCharAt12 & 8191) << i68;
                    i68 += 13;
                    i67 = i29;
                }
                iCharAt10 = i66 | (cCharAt12 << i68);
                i14 = i29;
            } else {
                i14 = i65;
            }
            int i69 = i14 + 1;
            int iCharAt11 = strZzd.charAt(i14);
            if (iCharAt11 >= c) {
                int i70 = iCharAt11 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i28 = i71 + 1;
                    cCharAt11 = strZzd.charAt(i71);
                    i15 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt11 & 8191) << i72;
                    i72 += 13;
                    i71 = i28;
                    length = i15;
                }
                iCharAt11 = i70 | (cCharAt11 << i72);
                i16 = i28;
            } else {
                i15 = length;
                i16 = i69;
            }
            int i73 = iCharAt11 & 255;
            int i74 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i63;
                i64++;
            }
            if (i73 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i76 = iCharAt12 & 8191;
                    int i77 = i75;
                    int i78 = 13;
                    while (true) {
                        i27 = i77 + 1;
                        cCharAt10 = strZzd.charAt(i77);
                        i18 = i4;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i76 |= (cCharAt10 & 8191) << i78;
                        i78 += 13;
                        i77 = i27;
                        i4 = i18;
                    }
                    iCharAt12 = i76 | (cCharAt10 << i78);
                    i23 = i27;
                } else {
                    i18 = i4;
                    i23 = i75;
                }
                int i79 = i73 - 51;
                int i80 = i23;
                if (i79 == 9 || i79 == 17) {
                    int i81 = i63 / 3;
                    i24 = i2 + 1;
                    objArr2[i81 + i81 + 1] = objArrZze[i2];
                } else {
                    if (i79 == 12 && !z) {
                        int i82 = i63 / 3;
                        i24 = i2 + 1;
                        objArr2[i82 + i82 + 1] = objArrZze[i2];
                    }
                    i25 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i25];
                    if (obj instanceof Field) {
                        fieldZzK2 = (Field) obj;
                    } else {
                        fieldZzK2 = zzK(cls, (String) obj);
                        objArrZze[i25] = fieldZzK2;
                    }
                    iArr2 = iArr3;
                    i17 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzK2);
                    i26 = i25 + 1;
                    obj2 = objArrZze[i26];
                    if (obj2 instanceof Field) {
                        fieldZzK3 = (Field) obj2;
                    } else {
                        fieldZzK3 = zzK(cls, (String) obj2);
                        objArrZze[i26] = fieldZzK3;
                    }
                    objArr = objArr2;
                    i19 = i2;
                    i20 = i80;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzK3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = 0;
                }
                i2 = i24;
                i25 = iCharAt12 + iCharAt12;
                obj = objArrZze[i25];
                if (obj instanceof Field) {
                    fieldZzK2 = (Field) obj;
                } else {
                    fieldZzK2 = zzK(cls, (String) obj);
                    objArrZze[i25] = fieldZzK2;
                }
                iArr2 = iArr3;
                i17 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzK2);
                i26 = i25 + 1;
                obj2 = objArrZze[i26];
                if (obj2 instanceof Field) {
                    fieldZzK3 = (Field) obj2;
                } else {
                    fieldZzK3 = zzK(cls, (String) obj2);
                    objArrZze[i26] = fieldZzK3;
                }
                objArr = objArr2;
                i19 = i2;
                i20 = i80;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzK3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = 0;
            } else {
                iArr2 = iArr3;
                i17 = iCharAt;
                i18 = i4;
                int i83 = i2 + 1;
                Field fieldZzK4 = zzK(cls, (String) objArrZze[i2]);
                if (i73 == 9 || i73 == 17) {
                    int i84 = i63 / 3;
                    objArr2[i84 + i84 + 1] = fieldZzK4.getType();
                } else {
                    if (i73 == 27 || i73 == 49) {
                        int i85 = i63 / 3;
                        i22 = i2 + 2;
                        objArr2[i85 + i85 + 1] = objArrZze[i83];
                    } else if (i73 == 12 || i73 == 30 || i73 == 44) {
                        if (!z) {
                            int i86 = i63 / 3;
                            i22 = i2 + 2;
                            objArr2[i86 + i86 + 1] = objArrZze[i83];
                        }
                    } else if (i73 == 50) {
                        int i87 = i61 + 1;
                        iArr[i61] = i63;
                        int i88 = i63 / 3;
                        int i89 = i88 + i88;
                        int i90 = i2 + 2;
                        objArr2[i89] = objArrZze[i83];
                        if ((iCharAt11 & 2048) != 0) {
                            i83 = i2 + 3;
                            objArr2[i89 + 1] = objArrZze[i90];
                            i61 = i87;
                        } else {
                            i61 = i87;
                            i19 = i90;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzK4);
                        iObjectFieldOffset2 = 1048575;
                        objArr = objArr2;
                        if ((iCharAt11 & 4096) == 4096 || i73 > 17) {
                            i20 = i16;
                            i21 = 0;
                        } else {
                            int i91 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i92 = iCharAt13 & 8191;
                                int i93 = 13;
                                while (true) {
                                    i20 = i91 + 1;
                                    cCharAt9 = strZzd.charAt(i91);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i92 |= (cCharAt9 & 8191) << i93;
                                    i93 += 13;
                                    i91 = i20;
                                }
                                iCharAt13 = i92 | (cCharAt9 << i93);
                            } else {
                                i20 = i91;
                            }
                            int i94 = (iCharAt13 / 32) + i3 + i3;
                            Object obj3 = objArrZze[i94];
                            if (obj3 instanceof Field) {
                                fieldZzK = (Field) obj3;
                            } else {
                                fieldZzK = zzK(cls, (String) obj3);
                                objArrZze[i94] = fieldZzK;
                            }
                            i21 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzK);
                        }
                        if (i73 >= 18 && i73 <= 49) {
                            iArr[i62] = iObjectFieldOffset;
                            i62++;
                        }
                    }
                    i19 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzK4);
                    iObjectFieldOffset2 = 1048575;
                    objArr = objArr2;
                    if ((iCharAt11 & 4096) == 4096) {
                        i20 = i16;
                        i21 = 0;
                    } else {
                        i20 = i16;
                        i21 = 0;
                    }
                    if (i73 >= 18) {
                        iArr[i62] = iObjectFieldOffset;
                        i62++;
                    }
                }
                i19 = i83;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzK4);
                iObjectFieldOffset2 = 1048575;
                objArr = objArr2;
                if ((iCharAt11 & 4096) == 4096) {
                    i20 = i16;
                    i21 = 0;
                } else {
                    i20 = i16;
                    i21 = 0;
                }
                if (i73 >= 18) {
                    iArr[i62] = iObjectFieldOffset;
                    i62++;
                }
            }
            int i95 = i63 + 1;
            iArr2[i63] = iCharAt10;
            int i96 = i63 + 2;
            iArr2[i95] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i73 << 20) | iObjectFieldOffset;
            i63 += 3;
            iArr2[i96] = (i21 << 20) | iObjectFieldOffset2;
            iCharAt = i17;
            iCharAt3 = i74;
            i32 = i20;
            length = i15;
            objArr2 = objArr;
            i2 = i19;
            iArr3 = iArr2;
            i4 = i18;
            c = 55296;
        }
        return new zzaen(iArr3, objArr2, iCharAt, i4, zzaeuVar.zza(), z, false, iArr, iCharAt3, i60, zzaepVar, zzadyVar, zzafnVar, zzactVar, zzaefVar, null);
    }

    private static double zzo(Object obj, long j) {
        return ((Double) zzafx.zzf(obj, j)).doubleValue();
    }

    private static float zzp(Object obj, long j) {
        return ((Float) zzafx.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzq(Object obj) {
        int i;
        int iZzE;
        int iZzF;
        int iZzF2;
        int iZzE2;
        int iZzy;
        int iZzo;
        int iZzu;
        boolean z;
        int iZzd;
        int iZzE3;
        int iZzF3;
        int iZzF4;
        int iZzE4;
        int iZzy2;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int iM$1 = 0;
        int i5 = 0;
        while (i4 < this.zzc.length) {
            int iZzC = zzC(i4);
            int[] iArr = this.zzc;
            int i6 = iArr[i4];
            int iZzB = zzB(iZzC);
            if (iZzB <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            long j = iZzC & i2;
            switch (iZzB) {
                case 0:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 8, iM$1);
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 4, iM$1);
                    }
                    break;
                case 2:
                    if ((i5 & i) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzE = zzacn.zzE(i6 << 3);
                        iZzF = zzacn.zzF(j2);
                        iZzF2 = iZzF + iZzE;
                        iM$1 += iZzF2;
                    }
                    break;
                case 3:
                    if ((i5 & i) != 0) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzE = zzacn.zzE(i6 << 3);
                        iZzF = zzacn.zzF(j3);
                        iZzF2 = iZzF + iZzE;
                        iM$1 += iZzF2;
                    }
                    break;
                case 4:
                    if ((i5 & i) != 0) {
                        int i9 = unsafe.getInt(obj, j);
                        iZzE2 = zzacn.zzE(i6 << 3);
                        iZzy = zzacn.zzy(i9);
                        iZzF2 = iZzy + iZzE2;
                        iM$1 += iZzF2;
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 8, iM$1);
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 4, iM$1);
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 1, iM$1);
                    }
                    break;
                case 8:
                    if ((i5 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (!(object instanceof zzacc)) {
                            iZzE2 = zzacn.zzE(i6 << 3);
                            iZzy = zzacn.zzC((String) object);
                            iZzF2 = iZzy + iZzE2;
                            iM$1 += iZzF2;
                        } else {
                            int iZzE5 = zzacn.zzE(i6 << 3);
                            int iZzd2 = ((zzacc) object).zzd();
                            iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd2, iZzd2, iZzE5, iM$1);
                        }
                    }
                    break;
                case 9:
                    if ((i5 & i) != 0) {
                        iZzo = zzaey.zzo(i6, unsafe.getObject(obj, j), zzF(i4));
                        iM$1 += iZzo;
                    }
                    break;
                case 10:
                    if ((i5 & i) != 0) {
                        zzacc zzaccVar = (zzacc) unsafe.getObject(obj, j);
                        int iZzE6 = zzacn.zzE(i6 << 3);
                        int iZzd3 = zzaccVar.zzd();
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd3, iZzd3, iZzE6, iM$1);
                    }
                    break;
                case 11:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(unsafe.getInt(obj, j), zzacn.zzE(i6 << 3), iM$1);
                    }
                    break;
                case 12:
                    if ((i5 & i) != 0) {
                        int i10 = unsafe.getInt(obj, j);
                        iZzE2 = zzacn.zzE(i6 << 3);
                        iZzy = zzacn.zzy(i10);
                        iZzF2 = iZzy + iZzE2;
                        iM$1 += iZzF2;
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 4, iM$1);
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 8, iM$1);
                    }
                    break;
                case 15:
                    if ((i5 & i) != 0) {
                        int i11 = unsafe.getInt(obj, j);
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1((i11 >> 31) ^ (i11 + i11), zzacn.zzE(i6 << 3), iM$1);
                    }
                    break;
                case 16:
                    if ((i & i5) != 0) {
                        long j4 = unsafe.getLong(obj, j);
                        iZzF2 = zzacn.zzF((j4 >> 63) ^ (j4 + j4)) + zzacn.zzE(i6 << 3);
                        iM$1 += iZzF2;
                    }
                    break;
                case 17:
                    if ((i5 & i) != 0) {
                        iZzF2 = zzacn.zzx(i6, (zzaek) unsafe.getObject(obj, j), zzF(i4));
                        iM$1 += iZzF2;
                    }
                    break;
                case 18:
                    iZzo = zzaey.zzh(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 19:
                    iZzo = zzaey.zzf(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 20:
                    iZzo = zzaey.zzm(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 21:
                    iZzo = zzaey.zzx(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 22:
                    iZzo = zzaey.zzk(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iZzo = zzaey.zzh(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 24:
                    iZzo = zzaey.zzf(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 25:
                    iZzo = zzaey.zza(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 26:
                    iZzu = zzaey.zzu(i6, (List) unsafe.getObject(obj, j));
                    iM$1 += iZzu;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iZzu = zzaey.zzp(i6, (List) unsafe.getObject(obj, j), zzF(i4));
                    iM$1 += iZzu;
                    break;
                case 28:
                    iZzu = zzaey.zzc(i6, (List) unsafe.getObject(obj, j));
                    iM$1 += iZzu;
                    break;
                case 29:
                    iZzu = zzaey.zzv(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzu;
                    break;
                case 30:
                    z = false;
                    iZzd = zzaey.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzd;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    z = false;
                    iZzd = zzaey.zzf(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzd;
                    break;
                case 32:
                    z = false;
                    iZzd = zzaey.zzh(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzd;
                    break;
                case 33:
                    z = false;
                    iZzd = zzaey.zzq(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzd;
                    break;
                case 34:
                    z = false;
                    iZzd = zzaey.zzs(i6, (List) unsafe.getObject(obj, j), false);
                    iM$1 += iZzd;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    int iZzi = zzaey.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzi, zzacn.zzD(i6), iZzi, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    int iZzg = zzaey.zzg((List) unsafe.getObject(obj, j));
                    if (iZzg > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzg, zzacn.zzD(i6), iZzg, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    int iZzn = zzaey.zzn((List) unsafe.getObject(obj, j));
                    if (iZzn > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzn, zzacn.zzD(i6), iZzn, iM$1);
                    }
                    break;
                case 38:
                    int iZzy3 = zzaey.zzy((List) unsafe.getObject(obj, j));
                    if (iZzy3 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzy3, zzacn.zzD(i6), iZzy3, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    int iZzl = zzaey.zzl((List) unsafe.getObject(obj, j));
                    if (iZzl > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzl, zzacn.zzD(i6), iZzl, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    int iZzi2 = zzaey.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi2 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzi2, zzacn.zzD(i6), iZzi2, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    int iZzg2 = zzaey.zzg((List) unsafe.getObject(obj, j));
                    if (iZzg2 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzg2, zzacn.zzD(i6), iZzg2, iM$1);
                    }
                    break;
                case 42:
                    int iZzb = zzaey.zzb((List) unsafe.getObject(obj, j));
                    if (iZzb > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzb, zzacn.zzD(i6), iZzb, iM$1);
                    }
                    break;
                case 43:
                    int iZzw = zzaey.zzw((List) unsafe.getObject(obj, j));
                    if (iZzw > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzw, zzacn.zzD(i6), iZzw, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    int iZze = zzaey.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZze, zzacn.zzD(i6), iZze, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    int iZzg3 = zzaey.zzg((List) unsafe.getObject(obj, j));
                    if (iZzg3 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzg3, zzacn.zzD(i6), iZzg3, iM$1);
                    }
                    break;
                case 46:
                    int iZzi3 = zzaey.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi3 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzi3, zzacn.zzD(i6), iZzi3, iM$1);
                    }
                    break;
                case 47:
                    int iZzr = zzaey.zzr((List) unsafe.getObject(obj, j));
                    if (iZzr > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzr, zzacn.zzD(i6), iZzr, iM$1);
                    }
                    break;
                case 48:
                    int iZzt = zzaey.zzt((List) unsafe.getObject(obj, j));
                    if (iZzt > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzt, zzacn.zzD(i6), iZzt, iM$1);
                    }
                    break;
                case 49:
                    iZzu = zzaey.zzj(i6, (List) unsafe.getObject(obj, j), zzF(i4));
                    iM$1 += iZzu;
                    break;
                case 50:
                    zzaef.zza(i6, unsafe.getObject(obj, j), zzH(i4));
                    break;
                case 51:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 8, iM$1);
                    }
                    break;
                case 52:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 4, iM$1);
                    }
                    break;
                case 53:
                    if (zzZ(obj, i6, i4)) {
                        long jZzD = zzD(obj, j);
                        iZzE3 = zzacn.zzE(i6 << 3);
                        iZzF3 = zzacn.zzF(jZzD);
                        iZzF4 = iZzF3 + iZzE3;
                        iM$1 += iZzF4;
                    }
                    break;
                case 54:
                    if (zzZ(obj, i6, i4)) {
                        long jZzD2 = zzD(obj, j);
                        iZzE3 = zzacn.zzE(i6 << 3);
                        iZzF3 = zzacn.zzF(jZzD2);
                        iZzF4 = iZzF3 + iZzE3;
                        iM$1 += iZzF4;
                    }
                    break;
                case 55:
                    if (zzZ(obj, i6, i4)) {
                        int iZzs = zzs(obj, j);
                        iZzE4 = zzacn.zzE(i6 << 3);
                        iZzy2 = zzacn.zzy(iZzs);
                        iZzF4 = iZzy2 + iZzE4;
                        iM$1 += iZzF4;
                    }
                    break;
                case 56:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 8, iM$1);
                    }
                    break;
                case 57:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 4, iM$1);
                    }
                    break;
                case 58:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 1, iM$1);
                    }
                    break;
                case 59:
                    if (zzZ(obj, i6, i4)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzacc) {
                            int iZzE7 = zzacn.zzE(i6 << 3);
                            int iZzd4 = ((zzacc) object2).zzd();
                            iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd4, iZzd4, iZzE7, iM$1);
                        } else {
                            iZzE4 = zzacn.zzE(i6 << 3);
                            iZzy2 = zzacn.zzC((String) object2);
                            iZzF4 = iZzy2 + iZzE4;
                            iM$1 += iZzF4;
                        }
                    }
                    break;
                case 60:
                    if (zzZ(obj, i6, i4)) {
                        iZzu = zzaey.zzo(i6, unsafe.getObject(obj, j), zzF(i4));
                        iM$1 += iZzu;
                    }
                    break;
                case 61:
                    if (zzZ(obj, i6, i4)) {
                        zzacc zzaccVar2 = (zzacc) unsafe.getObject(obj, j);
                        int iZzE8 = zzacn.zzE(i6 << 3);
                        int iZzd5 = zzaccVar2.zzd();
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd5, iZzd5, iZzE8, iM$1);
                    }
                    break;
                case 62:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(zzs(obj, j), zzacn.zzE(i6 << 3), iM$1);
                    }
                    break;
                case 63:
                    if (zzZ(obj, i6, i4)) {
                        int iZzs2 = zzs(obj, j);
                        iZzE4 = zzacn.zzE(i6 << 3);
                        iZzy2 = zzacn.zzy(iZzs2);
                        iZzF4 = iZzy2 + iZzE4;
                        iM$1 += iZzF4;
                    }
                    break;
                case 64:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 4, iM$1);
                    }
                    break;
                case 65:
                    if (zzZ(obj, i6, i4)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i6 << 3, 8, iM$1);
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzZ(obj, i6, i4)) {
                        int iZzs3 = zzs(obj, j);
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1((iZzs3 >> 31) ^ (iZzs3 + iZzs3), zzacn.zzE(i6 << 3), iM$1);
                    }
                    break;
                case 67:
                    if (zzZ(obj, i6, i4)) {
                        long jZzD3 = zzD(obj, j);
                        iZzF4 = zzacn.zzF((jZzD3 >> 63) ^ (jZzD3 + jZzD3)) + zzacn.zzE(i6 << 3);
                        iM$1 += iZzF4;
                    }
                    break;
                case 68:
                    if (zzZ(obj, i6, i4)) {
                        iZzF4 = zzacn.zzx(i6, (zzaek) unsafe.getObject(obj, j), zzF(i4));
                        iM$1 += iZzF4;
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        zzafn zzafnVar = this.zzo;
        int iZza = iM$1 + zzafnVar.zza(zzafnVar.zzd(obj));
        if (!this.zzh) {
            return iZza;
        }
        this.zzp.zza(obj);
        throw null;
    }

    private final int zzr(Object obj) {
        int iZzE;
        int iZzF;
        int iZzE2;
        int iZzy;
        int iZzo;
        int iZzx;
        Unsafe unsafe = zzb;
        int iM$1 = 0;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzC = zzC(i);
            int iZzB = zzB(iZzC);
            int i2 = this.zzc[i];
            long j = iZzC & 1048575;
            if (iZzB >= zzacy.zzJ.zza() && iZzB <= zzacy.zzW.zza()) {
                int i3 = this.zzc[i + 2];
            }
            switch (iZzB) {
                case 0:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 8, iM$1);
                    }
                    break;
                case 1:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 4, iM$1);
                    }
                    break;
                case 2:
                    if (zzV(obj, i)) {
                        long jZzd = zzafx.zzd(obj, j);
                        iZzE = zzacn.zzE(i2 << 3);
                        iZzF = zzacn.zzF(jZzd);
                        iZzx = iZzF + iZzE;
                        iM$1 += iZzx;
                    }
                    break;
                case 3:
                    if (zzV(obj, i)) {
                        long jZzd2 = zzafx.zzd(obj, j);
                        iZzE = zzacn.zzE(i2 << 3);
                        iZzF = zzacn.zzF(jZzd2);
                        iZzx = iZzF + iZzE;
                        iM$1 += iZzx;
                    }
                    break;
                case 4:
                    if (zzV(obj, i)) {
                        int iZzc = zzafx.zzc(obj, j);
                        iZzE2 = zzacn.zzE(i2 << 3);
                        iZzy = zzacn.zzy(iZzc);
                        iZzx = iZzy + iZzE2;
                        iM$1 += iZzx;
                    }
                    break;
                case 5:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 8, iM$1);
                    }
                    break;
                case 6:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 4, iM$1);
                    }
                    break;
                case 7:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 1, iM$1);
                    }
                    break;
                case 8:
                    if (zzV(obj, i)) {
                        Object objZzf = zzafx.zzf(obj, j);
                        if (objZzf instanceof zzacc) {
                            int iZzE3 = zzacn.zzE(i2 << 3);
                            int iZzd = ((zzacc) objZzf).zzd();
                            iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd, iZzd, iZzE3, iM$1);
                        } else {
                            iZzE2 = zzacn.zzE(i2 << 3);
                            iZzy = zzacn.zzC((String) objZzf);
                            iZzx = iZzy + iZzE2;
                            iM$1 += iZzx;
                        }
                    }
                    break;
                case 9:
                    if (zzV(obj, i)) {
                        iZzo = zzaey.zzo(i2, zzafx.zzf(obj, j), zzF(i));
                        iM$1 += iZzo;
                    }
                    break;
                case 10:
                    if (zzV(obj, i)) {
                        zzacc zzaccVar = (zzacc) zzafx.zzf(obj, j);
                        int iZzE4 = zzacn.zzE(i2 << 3);
                        int iZzd2 = zzaccVar.zzd();
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd2, iZzd2, iZzE4, iM$1);
                    }
                    break;
                case 11:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(zzafx.zzc(obj, j), zzacn.zzE(i2 << 3), iM$1);
                    }
                    break;
                case 12:
                    if (zzV(obj, i)) {
                        int iZzc2 = zzafx.zzc(obj, j);
                        iZzE2 = zzacn.zzE(i2 << 3);
                        iZzy = zzacn.zzy(iZzc2);
                        iZzx = iZzy + iZzE2;
                        iM$1 += iZzx;
                    }
                    break;
                case 13:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 4, iM$1);
                    }
                    break;
                case 14:
                    if (zzV(obj, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 8, iM$1);
                    }
                    break;
                case 15:
                    if (zzV(obj, i)) {
                        int iZzc3 = zzafx.zzc(obj, j);
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1((iZzc3 >> 31) ^ (iZzc3 + iZzc3), zzacn.zzE(i2 << 3), iM$1);
                    }
                    break;
                case 16:
                    if (zzV(obj, i)) {
                        long jZzd3 = zzafx.zzd(obj, j);
                        iZzE = zzacn.zzE(i2 << 3);
                        iZzF = zzacn.zzF((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        iZzx = iZzF + iZzE;
                        iM$1 += iZzx;
                    }
                    break;
                case 17:
                    if (zzV(obj, i)) {
                        iZzx = zzacn.zzx(i2, (zzaek) zzafx.zzf(obj, j), zzF(i));
                        iM$1 += iZzx;
                    }
                    break;
                case 18:
                    iZzo = zzaey.zzh(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 19:
                    iZzo = zzaey.zzf(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 20:
                    iZzo = zzaey.zzm(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 21:
                    iZzo = zzaey.zzx(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 22:
                    iZzo = zzaey.zzk(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iZzo = zzaey.zzh(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 24:
                    iZzo = zzaey.zzf(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 25:
                    iZzo = zzaey.zza(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 26:
                    iZzo = zzaey.zzu(i2, (List) zzafx.zzf(obj, j));
                    iM$1 += iZzo;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iZzo = zzaey.zzp(i2, (List) zzafx.zzf(obj, j), zzF(i));
                    iM$1 += iZzo;
                    break;
                case 28:
                    iZzo = zzaey.zzc(i2, (List) zzafx.zzf(obj, j));
                    iM$1 += iZzo;
                    break;
                case 29:
                    iZzo = zzaey.zzv(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 30:
                    iZzo = zzaey.zzd(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    iZzo = zzaey.zzf(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 32:
                    iZzo = zzaey.zzh(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 33:
                    iZzo = zzaey.zzq(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case 34:
                    iZzo = zzaey.zzs(i2, (List) zzafx.zzf(obj, j), false);
                    iM$1 += iZzo;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    int iZzi = zzaey.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzi, zzacn.zzD(i2), iZzi, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    int iZzg = zzaey.zzg((List) unsafe.getObject(obj, j));
                    if (iZzg > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzg, zzacn.zzD(i2), iZzg, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    int iZzn = zzaey.zzn((List) unsafe.getObject(obj, j));
                    if (iZzn > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzn, zzacn.zzD(i2), iZzn, iM$1);
                    }
                    break;
                case 38:
                    int iZzy2 = zzaey.zzy((List) unsafe.getObject(obj, j));
                    if (iZzy2 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzy2, zzacn.zzD(i2), iZzy2, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    int iZzl = zzaey.zzl((List) unsafe.getObject(obj, j));
                    if (iZzl > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzl, zzacn.zzD(i2), iZzl, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    int iZzi2 = zzaey.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi2 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzi2, zzacn.zzD(i2), iZzi2, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    int iZzg2 = zzaey.zzg((List) unsafe.getObject(obj, j));
                    if (iZzg2 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzg2, zzacn.zzD(i2), iZzg2, iM$1);
                    }
                    break;
                case 42:
                    int iZzb = zzaey.zzb((List) unsafe.getObject(obj, j));
                    if (iZzb > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzb, zzacn.zzD(i2), iZzb, iM$1);
                    }
                    break;
                case 43:
                    int iZzw = zzaey.zzw((List) unsafe.getObject(obj, j));
                    if (iZzw > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzw, zzacn.zzD(i2), iZzw, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    int iZze = zzaey.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZze, zzacn.zzD(i2), iZze, iM$1);
                    }
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    int iZzg3 = zzaey.zzg((List) unsafe.getObject(obj, j));
                    if (iZzg3 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzg3, zzacn.zzD(i2), iZzg3, iM$1);
                    }
                    break;
                case 46:
                    int iZzi3 = zzaey.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi3 > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzi3, zzacn.zzD(i2), iZzi3, iM$1);
                    }
                    break;
                case 47:
                    int iZzr = zzaey.zzr((List) unsafe.getObject(obj, j));
                    if (iZzr > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzr, zzacn.zzD(i2), iZzr, iM$1);
                    }
                    break;
                case 48:
                    int iZzt = zzaey.zzt((List) unsafe.getObject(obj, j));
                    if (iZzt > 0) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzt, zzacn.zzD(i2), iZzt, iM$1);
                    }
                    break;
                case 49:
                    iZzo = zzaey.zzj(i2, (List) zzafx.zzf(obj, j), zzF(i));
                    iM$1 += iZzo;
                    break;
                case 50:
                    zzaef.zza(i2, zzafx.zzf(obj, j), zzH(i));
                    break;
                case 51:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 8, iM$1);
                    }
                    break;
                case 52:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 4, iM$1);
                    }
                    break;
                case 53:
                    if (zzZ(obj, i2, i)) {
                        long jZzD = zzD(obj, j);
                        iZzE = zzacn.zzE(i2 << 3);
                        iZzF = zzacn.zzF(jZzD);
                        iZzx = iZzF + iZzE;
                        iM$1 += iZzx;
                    }
                    break;
                case 54:
                    if (zzZ(obj, i2, i)) {
                        long jZzD2 = zzD(obj, j);
                        iZzE = zzacn.zzE(i2 << 3);
                        iZzF = zzacn.zzF(jZzD2);
                        iZzx = iZzF + iZzE;
                        iM$1 += iZzx;
                    }
                    break;
                case 55:
                    if (zzZ(obj, i2, i)) {
                        int iZzs = zzs(obj, j);
                        iZzE2 = zzacn.zzE(i2 << 3);
                        iZzy = zzacn.zzy(iZzs);
                        iZzx = iZzy + iZzE2;
                        iM$1 += iZzx;
                    }
                    break;
                case 56:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 8, iM$1);
                    }
                    break;
                case 57:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 4, iM$1);
                    }
                    break;
                case 58:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 1, iM$1);
                    }
                    break;
                case 59:
                    if (zzZ(obj, i2, i)) {
                        Object objZzf2 = zzafx.zzf(obj, j);
                        if (objZzf2 instanceof zzacc) {
                            int iZzE5 = zzacn.zzE(i2 << 3);
                            int iZzd3 = ((zzacc) objZzf2).zzd();
                            iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd3, iZzd3, iZzE5, iM$1);
                        } else {
                            iZzE2 = zzacn.zzE(i2 << 3);
                            iZzy = zzacn.zzC((String) objZzf2);
                            iZzx = iZzy + iZzE2;
                            iM$1 += iZzx;
                        }
                    }
                    break;
                case 60:
                    if (zzZ(obj, i2, i)) {
                        iZzo = zzaey.zzo(i2, zzafx.zzf(obj, j), zzF(i));
                        iM$1 += iZzo;
                    }
                    break;
                case 61:
                    if (zzZ(obj, i2, i)) {
                        zzacc zzaccVar2 = (zzacc) zzafx.zzf(obj, j);
                        int iZzE6 = zzacn.zzE(i2 << 3);
                        int iZzd4 = zzaccVar2.zzd();
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m(iZzd4, iZzd4, iZzE6, iM$1);
                    }
                    break;
                case 62:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(zzs(obj, j), zzacn.zzE(i2 << 3), iM$1);
                    }
                    break;
                case 63:
                    if (zzZ(obj, i2, i)) {
                        int iZzs2 = zzs(obj, j);
                        iZzE2 = zzacn.zzE(i2 << 3);
                        iZzy = zzacn.zzy(iZzs2);
                        iZzx = iZzy + iZzE2;
                        iM$1 += iZzx;
                    }
                    break;
                case 64:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 4, iM$1);
                    }
                    break;
                case 65:
                    if (zzZ(obj, i2, i)) {
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1(i2 << 3, 8, iM$1);
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzZ(obj, i2, i)) {
                        int iZzs3 = zzs(obj, j);
                        iM$1 = BarcodeFormat$EnumUnboxingLocalUtility.m$1((iZzs3 >> 31) ^ (iZzs3 + iZzs3), zzacn.zzE(i2 << 3), iM$1);
                    }
                    break;
                case 67:
                    if (zzZ(obj, i2, i)) {
                        long jZzD3 = zzD(obj, j);
                        iZzE = zzacn.zzE(i2 << 3);
                        iZzF = zzacn.zzF((jZzD3 >> 63) ^ (jZzD3 + jZzD3));
                        iZzx = iZzF + iZzE;
                        iM$1 += iZzx;
                    }
                    break;
                case 68:
                    if (zzZ(obj, i2, i)) {
                        iZzx = zzacn.zzx(i2, (zzaek) zzafx.zzf(obj, j), zzF(i));
                        iM$1 += iZzx;
                    }
                    break;
            }
        }
        zzafn zzafnVar = this.zzo;
        return iM$1 + zzafnVar.zza(zzafnVar.zzd(obj));
    }

    private static int zzs(Object obj, long j) {
        return ((Integer) zzafx.zzf(obj, j)).intValue();
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzabp zzabpVar) {
        Unsafe unsafe = zzb;
        Object objZzH = zzH(i3);
        Object object = unsafe.getObject(obj, j);
        if (zzaef.zzb(object)) {
            zzaee zzaeeVarZzb = zzaee.zza().zzb();
            zzaef.zzc(zzaeeVarZzb, object);
            unsafe.putObject(obj, j, zzaeeVarZzb);
        }
        throw null;
    }

    private final int zzu(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzabp zzabpVar) throws zzadn {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzabq.zzp(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzabq.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzabq.zzm(bArr, i, zzabpVar);
                unsafe.putObject(obj, j, Long.valueOf(zzabpVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzabq.zzj(bArr, i, zzabpVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzabpVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzabq.zzp(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzabq.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzabq.zzm(bArr, i, zzabpVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzabpVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzabq.zzj(bArr, i, zzabpVar);
                int i9 = zzabpVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzagc.zzf(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzadn.zzd();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzadl.zzb));
                    iZzj2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                Object objZzJ = zzJ(obj, i4, i8);
                int iZzo = zzabq.zzo(objZzJ, zzF(i8), bArr, i, i2, zzabpVar);
                zzS(obj, i4, i8, objZzJ);
                return iZzo;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzabq.zza(bArr, i, zzabpVar);
                unsafe.putObject(obj, j, zzabpVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzabq.zzj(bArr, i, zzabpVar);
                int i10 = zzabpVar.zza;
                zzadj zzadjVarZzE = zzE(i8);
                if (zzadjVarZzE == null || zzadjVarZzE.zza()) {
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    zzd(obj).zzj(i3, Long.valueOf(i10));
                }
                return iZzj3;
            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzabq.zzj(bArr, i, zzabpVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzacg.zzs(zzabpVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzabq.zzm(bArr, i, zzabpVar);
                unsafe.putObject(obj, j, Long.valueOf(zzacg.zzt(zzabpVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                Object objZzJ2 = zzJ(obj, i4, i8);
                int iZzn = zzabq.zzn(objZzJ2, zzF(i8), bArr, i, i2, (i3 & (-8)) | 4, zzabpVar);
                zzS(obj, i4, i8, objZzJ2);
                return iZzn;
            default:
                return i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x029d A[PHI: r0 r18 r19 r26 r27 r28
  0x029d: PHI (r0v21 int) = (r0v16 int), (r0v19 int), (r0v23 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r18v4 int) = (r18v2 int), (r18v2 int), (r18v5 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r19v4 int) = (r19v2 int), (r19v2 int), (r19v5 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r27v3 int) = (r27v1 int), (r27v1 int), (r27v4 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x029d: PHI (r28v6 sun.misc.Unsafe) = (r28v4 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x02b5 A[PHI: r0 r18 r19 r26 r27 r28
  0x02b5: PHI (r0v20 int) = (r0v16 int), (r0v19 int), (r0v23 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b5: PHI (r18v3 int) = (r18v2 int), (r18v2 int), (r18v5 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b5: PHI (r19v3 int) = (r19v2 int), (r19v2 int), (r19v5 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b5: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b5: PHI (r27v2 int) = (r27v1 int), (r27v1 int), (r27v4 int) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]
  0x02b5: PHI (r28v5 sun.misc.Unsafe) = (r28v4 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe), (r28v7 sun.misc.Unsafe) binds: [B:114:0x0306, B:110:0x02e6, B:100:0x029b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0087. Please report as an issue. */
    private final int zzv(Object obj, byte[] bArr, int i, int i2, zzabp zzabpVar) throws zzadn {
        int i3;
        int iZzk;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iZza;
        int iZzm;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        zzabpVar = zzabpVar;
        zzL(obj);
        Unsafe unsafe2 = zzb;
        int i14 = 1048575;
        int i15 = -1;
        int iZzi = i;
        int i16 = -1;
        int i17 = 1048575;
        int i18 = 0;
        int i19 = 0;
        while (iZzi < i2) {
            int i20 = iZzi + 1;
            byte b = bArr[iZzi];
            if (b < 0) {
                iZzk = zzabq.zzk(b, bArr, i20, zzabpVar);
                i3 = zzabpVar.zza;
            } else {
                i3 = b;
                iZzk = i20;
            }
            int i21 = i3 >>> 3;
            int i22 = i3 & 7;
            int iZzy = i21 > i16 ? this.zzy(i21, i18 / 3) : this.zzx(i21);
            if (iZzy == i15) {
                i4 = iZzk;
                i5 = i21;
                i6 = i15;
                unsafe = unsafe2;
                i7 = 0;
            } else {
                int[] iArr = this.zzc;
                int i23 = iArr[iZzy + 1];
                int iZzB = zzB(i23);
                long j = i23 & i14;
                if (iZzB <= 17) {
                    int i24 = iArr[iZzy + 2];
                    int i25 = 1 << (i24 >>> 20);
                    int i26 = 1048575;
                    int i27 = i24 & 1048575;
                    if (i27 != i17) {
                        if (i17 != 1048575) {
                            unsafe2.putInt(obj, i17, i19);
                            i26 = 1048575;
                        }
                        if (i27 != i26) {
                            i19 = unsafe2.getInt(obj, i27);
                        }
                        i17 = i27;
                    }
                    switch (iZzB) {
                        case 0:
                            i5 = i21;
                            i8 = iZzy;
                            i12 = iZzk;
                            i13 = i19;
                            if (i22 == 1) {
                                zzafx.zzo(obj, j, Double.longBitsToDouble(zzabq.zzp(bArr, i12)));
                                iZzi = i12 + 8;
                                i19 = i13 | i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 1:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            i12 = iZzk;
                            i13 = i19;
                            if (i22 == 5) {
                                zzafx.zzp(obj, j, Float.intBitsToFloat(zzabq.zzb(bArr, i12)));
                                iZzi = i12 + 4;
                                i19 = i13 | i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 2:
                        case 3:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            i12 = iZzk;
                            i13 = i19;
                            if (i22 != 0) {
                                i19 = i13;
                                unsafe = unsafe2;
                                i7 = i8;
                                i4 = i12;
                                i6 = -1;
                            } else {
                                iZzm = zzabq.zzm(bArr, i12, zzabpVar);
                                unsafe2.putLong(obj, j, zzabpVar.zzb);
                                i19 = i13 | i25;
                                i18 = i8;
                                iZzi = iZzm;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                                i2 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            i12 = iZzk;
                            i13 = i19;
                            if (i22 == 0) {
                                iZzi = zzabq.zzj(bArr, i12, zzabpVar);
                                unsafe2.putInt(obj, j, zzabpVar.zza);
                                i19 = i13 | i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 5:
                        case 14:
                            i5 = i21;
                            i8 = iZzy;
                            i13 = i19;
                            if (i22 == 1) {
                                i12 = iZzk;
                                unsafe2.putLong(obj, j, zzabq.zzp(bArr, iZzk));
                                iZzi = i12 + 8;
                                i19 = i13 | i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 6:
                        case 13:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            i13 = i19;
                            if (i22 == 5) {
                                unsafe2.putInt(obj, j, zzabq.zzb(bArr, iZzk));
                                iZzi = iZzk + 4;
                                i19 = i13 | i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 7:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            i13 = i19;
                            if (i22 == 0) {
                                int iZzm2 = zzabq.zzm(bArr, iZzk, zzabpVar);
                                zzafx.zzm(obj, j, zzabpVar.zzb != 0);
                                i19 = i13 | i25;
                                iZzi = iZzm2;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 8:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            i13 = i19;
                            if (i22 == 2) {
                                iZzi = (536870912 & i23) == 0 ? zzabq.zzg(bArr, iZzk, zzabpVar) : zzabq.zzh(bArr, iZzk, zzabpVar);
                                unsafe2.putObject(obj, j, zzabpVar.zzc);
                                i19 = i13 | i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 9:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            if (i22 == 2) {
                                Object objZzI = this.zzI(obj, i8);
                                iZzi = zzabq.zzo(objZzI, this.zzF(i8), bArr, iZzk, i2, zzabpVar);
                                this.zzR(obj, i8, objZzI);
                                i19 |= i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i13 = i19;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 10:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            if (i22 == 2) {
                                iZza = zzabq.zza(bArr, iZzk, zzabpVar);
                                unsafe2.putObject(obj, j, zzabpVar.zzc);
                                i19 |= i25;
                                iZzi = iZza;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i13 = i19;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 12:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            if (i22 == 0) {
                                iZza = zzabq.zzj(bArr, iZzk, zzabpVar);
                                unsafe2.putInt(obj, j, zzabpVar.zza);
                                i19 |= i25;
                                iZzi = iZza;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i13 = i19;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 15:
                            i5 = i21;
                            zzabpVar = zzabpVar;
                            i8 = iZzy;
                            if (i22 == 0) {
                                iZzi = zzabq.zzj(bArr, iZzk, zzabpVar);
                                unsafe2.putInt(obj, j, zzacg.zzs(zzabpVar.zza));
                                i19 |= i25;
                                i18 = i8;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                            }
                            i12 = iZzk;
                            i13 = i19;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                        case 16:
                            if (i22 != 0) {
                                i5 = i21;
                                i8 = iZzy;
                                i12 = iZzk;
                                i13 = i19;
                                i19 = i13;
                                unsafe = unsafe2;
                                i7 = i8;
                                i4 = i12;
                                i6 = -1;
                            } else {
                                zzabpVar = zzabpVar;
                                iZzm = zzabq.zzm(bArr, iZzk, zzabpVar);
                                i8 = iZzy;
                                i5 = i21;
                                unsafe2.putLong(obj, j, zzacg.zzt(zzabpVar.zzb));
                                i19 |= i25;
                                i18 = i8;
                                iZzi = iZzm;
                                i16 = i5;
                                i15 = -1;
                                i14 = 1048575;
                                i2 = i2;
                            }
                            break;
                        default:
                            i5 = i21;
                            i8 = iZzy;
                            i12 = iZzk;
                            i13 = i19;
                            i19 = i13;
                            unsafe = unsafe2;
                            i7 = i8;
                            i4 = i12;
                            i6 = -1;
                            break;
                    }
                } else {
                    i5 = i21;
                    int i28 = i19;
                    zzabpVar = zzabpVar;
                    i8 = iZzy;
                    if (iZzB != 27) {
                        if (iZzB <= 49) {
                            int i29 = iZzk;
                            i10 = i17;
                            i11 = i28;
                            i6 = -1;
                            unsafe = unsafe2;
                            i7 = i8;
                            iZzi = zzw(obj, bArr, iZzk, i2, i3, i5, i22, i8, i23, iZzB, j, zzabpVar);
                            if (iZzi != i29) {
                                i15 = i6;
                                i18 = i7;
                                i16 = i5;
                                i17 = i10;
                                i19 = i11;
                            } else {
                                i4 = iZzi;
                                i17 = i10;
                                i19 = i11;
                            }
                            unsafe2 = unsafe;
                        } else {
                            i9 = iZzk;
                            i10 = i17;
                            i11 = i28;
                            unsafe = unsafe2;
                            i7 = i8;
                            i6 = -1;
                            if (iZzB == 50) {
                                if (i22 == 2) {
                                    iZzi = zzt(obj, bArr, i9, i2, i7, j, zzabpVar);
                                    if (iZzi != i9) {
                                        i15 = i6;
                                        i18 = i7;
                                        i16 = i5;
                                        i17 = i10;
                                        i19 = i11;
                                    } else {
                                        i4 = iZzi;
                                    }
                                    unsafe2 = unsafe;
                                }
                                i17 = i10;
                                i19 = i11;
                            } else {
                                iZzi = zzu(obj, bArr, i9, i2, i3, i5, i22, i23, iZzB, j, i7, zzabpVar);
                                if (iZzi != i9) {
                                    i15 = i6;
                                    i18 = i7;
                                    i16 = i5;
                                    i17 = i10;
                                    i19 = i11;
                                } else {
                                    i4 = iZzi;
                                    i17 = i10;
                                    i19 = i11;
                                }
                                unsafe2 = unsafe;
                            }
                        }
                        i14 = 1048575;
                    } else if (i22 == 2) {
                        zzadk zzadkVarZzd = (zzadk) unsafe2.getObject(obj, j);
                        if (!zzadkVarZzd.zzc()) {
                            int size = zzadkVarZzd.size();
                            zzadkVarZzd = zzadkVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj, j, zzadkVarZzd);
                        }
                        iZzi = zzabq.zze(this.zzF(i8), i3, bArr, iZzk, i2, zzadkVarZzd, zzabpVar);
                        i19 = i28;
                        i18 = i8;
                        i16 = i5;
                        i15 = -1;
                        i14 = 1048575;
                    } else {
                        i9 = iZzk;
                        i10 = i17;
                        i11 = i28;
                        unsafe = unsafe2;
                        i7 = i8;
                        i6 = -1;
                    }
                    i4 = i9;
                    i17 = i10;
                    i19 = i11;
                }
            }
            iZzi = zzabq.zzi(i3, bArr, i4, i2, zzd(obj), zzabpVar);
            i15 = i6;
            i18 = i7;
            i16 = i5;
            unsafe2 = unsafe;
            i14 = 1048575;
        }
        int i30 = i19;
        Unsafe unsafe3 = unsafe2;
        if (i17 != i14) {
            unsafe3.putInt(obj, i17, i30);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzadn.zzg();
    }

    private final int zzw(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzabp zzabpVar) throws zzadn {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzadk zzadkVarZzd = (zzadk) unsafe.getObject(obj, j2);
        if (!zzadkVarZzd.zzc()) {
            int size = zzadkVarZzd.size();
            zzadkVarZzd = zzadkVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzadkVarZzd);
        }
        switch (i7) {
            case 18:
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                if (i5 == 2) {
                    zzacp zzacpVar = (zzacp) zzadkVarZzd;
                    int iZzj3 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i12 = zzabpVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zzacpVar.zze(Double.longBitsToDouble(zzabq.zzp(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 1) {
                    zzacp zzacpVar2 = (zzacp) zzadkVarZzd;
                    zzacpVar2.zze(Double.longBitsToDouble(zzabq.zzp(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzabq.zzj(bArr, i8, zzabpVar);
                            if (i3 == zzabpVar.zza) {
                                zzacpVar2.zze(Double.longBitsToDouble(zzabq.zzp(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                if (i5 == 2) {
                    zzacz zzaczVar = (zzacz) zzadkVarZzd;
                    int iZzj4 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i13 = zzabpVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzaczVar.zze(Float.intBitsToFloat(zzabq.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 5) {
                    zzacz zzaczVar2 = (zzacz) zzadkVarZzd;
                    zzaczVar2.zze(Float.intBitsToFloat(zzabq.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzabq.zzj(bArr, i9, zzabpVar);
                            if (i3 == zzabpVar.zza) {
                                zzaczVar2.zze(Float.intBitsToFloat(zzabq.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZzj2;
            case 20:
            case 21:
            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
                if (i5 == 2) {
                    zzadz zzadzVar = (zzadz) zzadkVarZzd;
                    int iZzj5 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i14 = zzabpVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzabq.zzm(bArr, iZzj5, zzabpVar);
                        zzadzVar.zzf(zzabpVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 0) {
                    zzadz zzadzVar2 = (zzadz) zzadkVarZzd;
                    int iZzm = zzabq.zzm(bArr, iZzj2, zzabpVar);
                    zzadzVar2.zzf(zzabpVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzabq.zzj(bArr, iZzm, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzabq.zzm(bArr, iZzj6, zzabpVar);
                        zzadzVar2.zzf(zzabpVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case 43:
                if (i5 == 2) {
                    return zzabq.zzf(bArr, iZzj2, zzadkVarZzd, zzabpVar);
                }
                if (i5 == 0) {
                    return zzabq.zzl(i3, bArr, i, i2, zzadkVarZzd, zzabpVar);
                }
                return iZzj2;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 32:
            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 46:
                if (i5 == 2) {
                    zzadz zzadzVar3 = (zzadz) zzadkVarZzd;
                    int iZzj7 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i15 = zzabpVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzadzVar3.zzf(zzabq.zzp(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 1) {
                    zzadz zzadzVar4 = (zzadz) zzadkVarZzd;
                    zzadzVar4.zzf(zzabq.zzp(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzabq.zzj(bArr, i10, zzabpVar);
                            if (i3 == zzabpVar.zza) {
                                zzadzVar4.zzf(zzabq.zzp(bArr, iZzj2));
                            }
                        }
                    }
                    return i10;
                }
                return iZzj2;
            case 24:
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                if (i5 == 2) {
                    zzadg zzadgVar = (zzadg) zzadkVarZzd;
                    int iZzj8 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i16 = zzabpVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzadgVar.zzf(zzabq.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 5) {
                    zzadg zzadgVar2 = (zzadg) zzadkVarZzd;
                    zzadgVar2.zzf(zzabq.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzabq.zzj(bArr, i11, zzabpVar);
                            if (i3 == zzabpVar.zza) {
                                zzadgVar2.zzf(zzabq.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzabr zzabrVar = (zzabr) zzadkVarZzd;
                    iZzj = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i17 = zzabpVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzabq.zzm(bArr, iZzj, zzabpVar);
                        zzabrVar.zze(zzabpVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzadn.zzi();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzabr zzabrVar2 = (zzabr) zzadkVarZzd;
                    int iZzm2 = zzabq.zzm(bArr, iZzj2, zzabpVar);
                    zzabrVar2.zze(zzabpVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzabq.zzj(bArr, iZzm2, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzabq.zzm(bArr, iZzj9, zzabpVar);
                        zzabrVar2.zze(zzabpVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                        int i18 = zzabpVar.zza;
                        if (i18 < 0) {
                            throw zzadn.zzf();
                        }
                        if (i18 == 0) {
                            zzadkVarZzd.add("");
                        } else {
                            zzadkVarZzd.add(new String(bArr, iZzj10, i18, zzadl.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzabq.zzj(bArr, iZzj10, zzabpVar);
                            if (i3 != zzabpVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzabq.zzj(bArr, iZzj11, zzabpVar);
                            int i19 = zzabpVar.zza;
                            if (i19 < 0) {
                                throw zzadn.zzf();
                            }
                            if (i19 == 0) {
                                zzadkVarZzd.add("");
                            } else {
                                zzadkVarZzd.add(new String(bArr, iZzj10, i19, zzadl.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i20 = zzabpVar.zza;
                    if (i20 < 0) {
                        throw zzadn.zzf();
                    }
                    if (i20 == 0) {
                        zzadkVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzagc.zzf(bArr, iZzj12, i21)) {
                            throw zzadn.zzd();
                        }
                        zzadkVarZzd.add(new String(bArr, iZzj12, i20, zzadl.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzabq.zzj(bArr, iZzj12, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzabq.zzj(bArr, iZzj13, zzabpVar);
                        int i22 = zzabpVar.zza;
                        if (i22 < 0) {
                            throw zzadn.zzf();
                        }
                        if (i22 == 0) {
                            zzadkVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzagc.zzf(bArr, iZzj12, i23)) {
                                throw zzadn.zzd();
                            }
                            zzadkVarZzd.add(new String(bArr, iZzj12, i22, zzadl.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                if (i5 == 2) {
                    return zzabq.zze(zzF(i6), i3, bArr, i, i2, zzadkVarZzd, zzabpVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i24 = zzabpVar.zza;
                    if (i24 < 0) {
                        throw zzadn.zzf();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzadn.zzi();
                    }
                    if (i24 == 0) {
                        zzadkVarZzd.add(zzacc.zzb);
                    } else {
                        zzadkVarZzd.add(zzacc.zzo(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzabq.zzj(bArr, iZzj14, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzabq.zzj(bArr, iZzj15, zzabpVar);
                        int i25 = zzabpVar.zza;
                        if (i25 < 0) {
                            throw zzadn.zzf();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzadn.zzi();
                        }
                        if (i25 == 0) {
                            zzadkVarZzd.add(zzacc.zzb);
                        } else {
                            zzadkVarZzd.add(zzacc.zzo(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                return iZzj2;
            case 30:
            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzj = zzabq.zzl(i3, bArr, i, i2, zzadkVarZzd, zzabpVar);
                    }
                    return iZzj2;
                }
                iZzj = zzabq.zzf(bArr, iZzj2, zzadkVarZzd, zzabpVar);
                zzaey.zzC(obj, i4, zzadkVarZzd, zzE(i6), null, this.zzo);
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzadg zzadgVar3 = (zzadg) zzadkVarZzd;
                    int iZzj16 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i26 = zzabpVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzabq.zzj(bArr, iZzj16, zzabpVar);
                        zzadgVar3.zzf(zzacg.zzs(zzabpVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 0) {
                    zzadg zzadgVar4 = (zzadg) zzadkVarZzd;
                    int iZzj17 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    zzadgVar4.zzf(zzacg.zzs(zzabpVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzabq.zzj(bArr, iZzj17, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzabq.zzj(bArr, iZzj18, zzabpVar);
                        zzadgVar4.zzf(zzacg.zzs(zzabpVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzadz zzadzVar5 = (zzadz) zzadkVarZzd;
                    int iZzj19 = zzabq.zzj(bArr, iZzj2, zzabpVar);
                    int i27 = zzabpVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzabq.zzm(bArr, iZzj19, zzabpVar);
                        zzadzVar5.zzf(zzacg.zzt(zzabpVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzadn.zzi();
                }
                if (i5 == 0) {
                    zzadz zzadzVar6 = (zzadz) zzadkVarZzd;
                    int iZzm3 = zzabq.zzm(bArr, iZzj2, zzabpVar);
                    zzadzVar6.zzf(zzacg.zzt(zzabpVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzabq.zzj(bArr, iZzm3, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzabq.zzm(bArr, iZzj20, zzabpVar);
                        zzadzVar6.zzf(zzacg.zzt(zzabpVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzaew zzaewVarZzF = zzF(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzabq.zzc(zzaewVarZzF, bArr, i, i2, i28, zzabpVar);
                    zzadkVarZzd.add(zzabpVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzabq.zzj(bArr, iZzc, zzabpVar);
                        if (i3 != zzabpVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzabq.zzc(zzaewVarZzF, bArr, iZzj21, i2, i28, zzabpVar);
                        zzadkVarZzd.add(zzabpVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzx(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, 0);
    }

    private final int zzy(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, i2);
    }

    private final int zzz(int i) {
        return this.zzc[i + 2];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final int zza(Object obj) {
        return this.zzj ? zzr(obj) : zzq(obj);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final int zzb(Object obj) {
        int i;
        int iZzc;
        int i2;
        int iZzc2;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzC = zzC(i4);
            int i5 = this.zzc[i4];
            long j = 1048575 & iZzC;
            int iHashCode = 37;
            switch (zzB(iZzC)) {
                case 0:
                    i = i3 * 53;
                    iZzc = zzadl.zzc(Double.doubleToLongBits(zzafx.zza(obj, j)));
                    i3 = iZzc + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iZzc = Float.floatToIntBits(zzafx.zzb(obj, j));
                    i3 = iZzc + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iZzc = zzadl.zzc(zzafx.zzd(obj, j));
                    i3 = iZzc + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iZzc = zzadl.zzc(zzafx.zzd(obj, j));
                    i3 = iZzc + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    iZzc2 = zzafx.zzc(obj, j);
                    i3 = i2 + iZzc2;
                    break;
                case 5:
                    i = i3 * 53;
                    iZzc = zzadl.zzc(zzafx.zzd(obj, j));
                    i3 = iZzc + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    iZzc2 = zzafx.zzc(obj, j);
                    i3 = i2 + iZzc2;
                    break;
                case 7:
                    i = i3 * 53;
                    iZzc = zzadl.zza(zzafx.zzw(obj, j));
                    i3 = iZzc + i;
                    break;
                case 8:
                    i = i3 * 53;
                    iZzc = ((String) zzafx.zzf(obj, j)).hashCode();
                    i3 = iZzc + i;
                    break;
                case 9:
                    Object objZzf = zzafx.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iZzc = zzafx.zzf(obj, j).hashCode();
                    i3 = iZzc + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iZzc2 = zzafx.zzc(obj, j);
                    i3 = i2 + iZzc2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iZzc2 = zzafx.zzc(obj, j);
                    i3 = i2 + iZzc2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iZzc2 = zzafx.zzc(obj, j);
                    i3 = i2 + iZzc2;
                    break;
                case 14:
                    i = i3 * 53;
                    iZzc = zzadl.zzc(zzafx.zzd(obj, j));
                    i3 = iZzc + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    iZzc2 = zzafx.zzc(obj, j);
                    i3 = i2 + iZzc2;
                    break;
                case 16:
                    i = i3 * 53;
                    iZzc = zzadl.zzc(zzafx.zzd(obj, j));
                    i3 = iZzc + i;
                    break;
                case 17:
                    Object objZzf2 = zzafx.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                case 24:
                case 25:
                case 26:
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                case 28:
                case 29:
                case 30:
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                case 32:
                case 33:
                case 34:
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                case 38:
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                case 42:
                case 43:
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    iZzc = zzafx.zzf(obj, j).hashCode();
                    i3 = iZzc + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iZzc = zzafx.zzf(obj, j).hashCode();
                    i3 = iZzc + i;
                    break;
                case 51:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zzc(Double.doubleToLongBits(zzo(obj, j)));
                        i3 = iZzc + i;
                    }
                    break;
                case 52:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = Float.floatToIntBits(zzp(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 53:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zzc(zzD(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 54:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zzc(zzD(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 55:
                    if (zzZ(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzs(obj, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 56:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zzc(zzD(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 57:
                    if (zzZ(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzs(obj, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 58:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zza(zzaa(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 59:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = ((String) zzafx.zzf(obj, j)).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
                case 60:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzafx.zzf(obj, j).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
                case 61:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzafx.zzf(obj, j).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
                case 62:
                    if (zzZ(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzs(obj, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 63:
                    if (zzZ(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzs(obj, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 64:
                    if (zzZ(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzs(obj, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 65:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zzc(zzD(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzZ(obj, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzs(obj, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 67:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzadl.zzc(zzD(obj, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 68:
                    if (zzZ(obj, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzafx.zzf(obj, j).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.zzo.zzd(obj).hashCode() + (i3 * 53);
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzp.zza(obj);
        throw null;
    }

    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzabp zzabpVar) throws zzadn {
        Unsafe unsafe;
        Object obj2;
        zzaen<T> zzaenVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        zzabp zzabpVar2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        zzaen<T> zzaenVar2 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        i2 = i2;
        int i19 = i3;
        zzabp zzabpVar3 = zzabpVar;
        zzL(obj);
        Unsafe unsafe2 = zzb;
        int iZzi = i;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = 1048575;
        while (true) {
            if (iZzi < i2) {
                int i25 = iZzi + 1;
                byte b = bArr2[iZzi];
                if (b < 0) {
                    int iZzk = zzabq.zzk(b, bArr2, i25, zzabpVar3);
                    i8 = zzabpVar3.zza;
                    i25 = iZzk;
                } else {
                    i8 = b;
                }
                int i26 = i8 >>> 3;
                int i27 = i8 & 7;
                int iZzy = i26 > i23 ? zzaenVar2.zzy(i26, i21 / 3) : zzaenVar2.zzx(i26);
                if (iZzy == -1) {
                    i9 = i26;
                    i5 = i8;
                    i10 = i22;
                    unsafe = unsafe2;
                    i3 = i19;
                    i11 = 0;
                    i12 = i25;
                } else {
                    int[] iArr = zzaenVar2.zzc;
                    int i28 = iArr[iZzy + 1];
                    int iZzB = zzB(i28);
                    int i29 = i25;
                    long j = i28 & 1048575;
                    int i30 = i8;
                    if (iZzB <= 17) {
                        int i31 = iArr[iZzy + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = i31 & 1048575;
                        if (i33 != i24) {
                            if (i24 != 1048575) {
                                unsafe2.putInt(obj3, i24, i22);
                            }
                            i24 = i33;
                            i10 = unsafe2.getInt(obj3, i33);
                        } else {
                            i10 = i22;
                            i24 = i24;
                        }
                        switch (iZzB) {
                            case 0:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                bArr2 = bArr;
                                if (i27 == 1) {
                                    zzafx.zzo(obj3, j, Double.longBitsToDouble(zzabq.zzp(bArr2, i15)));
                                    iZzi = i15 + 8;
                                    i22 = i10 | i32;
                                    i23 = i13;
                                    i21 = i14;
                                    i20 = i30;
                                    i19 = i3;
                                } else {
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 1:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                bArr2 = bArr;
                                if (i27 == 5) {
                                    zzafx.zzp(obj3, j, Float.intBitsToFloat(zzabq.zzb(bArr2, i15)));
                                    iZzi = i15 + 4;
                                    i22 = i10 | i32;
                                    i23 = i13;
                                    i21 = i14;
                                    i20 = i30;
                                    i19 = i3;
                                } else {
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 2:
                            case 3:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                bArr2 = bArr;
                                if (i27 == 0) {
                                    int iZzm = zzabq.zzm(bArr2, i15, zzabpVar3);
                                    unsafe2.putLong(obj, j, zzabpVar3.zzb);
                                    i22 = i10 | i32;
                                    iZzi = iZzm;
                                    i23 = i13;
                                    i21 = i14;
                                    i20 = i30;
                                    i19 = i3;
                                } else {
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 4:
                            case 11:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                bArr2 = bArr;
                                if (i27 == 0) {
                                    iZzi = zzabq.zzj(bArr2, i15, zzabpVar3);
                                    unsafe2.putInt(obj3, j, zzabpVar3.zza);
                                    i22 = i10 | i32;
                                    i23 = i13;
                                    i21 = i14;
                                    i20 = i30;
                                    i19 = i3;
                                } else {
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 5:
                            case 14:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i16 = i30;
                                bArr2 = bArr;
                                if (i27 == 1) {
                                    i30 = i16;
                                    unsafe2.putLong(obj, j, zzabq.zzp(bArr2, i15));
                                    iZzi = i15 + 8;
                                    i22 = i10 | i32;
                                    i23 = i13;
                                    i21 = i14;
                                    i20 = i30;
                                    i19 = i3;
                                } else {
                                    i30 = i16;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 6:
                            case 13:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i16 = i30;
                                bArr2 = bArr;
                                if (i27 == 5) {
                                    unsafe2.putInt(obj3, j, zzabq.zzb(bArr2, i15));
                                    iZzi = i15 + 4;
                                    i23 = i13;
                                    i21 = i14;
                                    i24 = i24;
                                    i2 = i2;
                                    i19 = i3;
                                    int i34 = i16;
                                    i22 = i10 | i32;
                                    i20 = i34;
                                } else {
                                    i30 = i16;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 7:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i16 = i30;
                                bArr2 = bArr;
                                if (i27 == 0) {
                                    iZzi = zzabq.zzm(bArr2, i15, zzabpVar3);
                                    zzafx.zzm(obj3, j, zzabpVar3.zzb != 0);
                                    i23 = i13;
                                    i21 = i14;
                                    i24 = i24;
                                    i2 = i2;
                                    i19 = i3;
                                    int i35 = i16;
                                    i22 = i10 | i32;
                                    i20 = i35;
                                } else {
                                    i30 = i16;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 8:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i16 = i30;
                                bArr2 = bArr;
                                if (i27 == 2) {
                                    iZzi = (536870912 & i28) == 0 ? zzabq.zzg(bArr2, i15, zzabpVar3) : zzabq.zzh(bArr2, i15, zzabpVar3);
                                    unsafe2.putObject(obj3, j, zzabpVar3.zzc);
                                    i23 = i13;
                                    i21 = i14;
                                    i24 = i24;
                                    i2 = i2;
                                    i19 = i3;
                                    int i36 = i16;
                                    i22 = i10 | i32;
                                    i20 = i36;
                                } else {
                                    i30 = i16;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i17 = i30;
                                if (i27 == 2) {
                                    Object objZzI = zzaenVar2.zzI(obj3, i14);
                                    iZzi = zzabq.zzo(objZzI, zzaenVar2.zzF(i14), bArr, i15, i2, zzabpVar);
                                    zzaenVar2.zzR(obj3, i14, objZzI);
                                    i22 = i10 | i32;
                                    i20 = i17;
                                    i23 = i13;
                                    i21 = i14;
                                    i19 = i3;
                                } else {
                                    i30 = i17;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 10:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i17 = i30;
                                bArr2 = bArr;
                                if (i27 == 2) {
                                    iZzi = zzabq.zza(bArr2, i15, zzabpVar3);
                                    unsafe2.putObject(obj3, j, zzabpVar3.zzc);
                                    i22 = i10 | i32;
                                    i20 = i17;
                                    i23 = i13;
                                    i21 = i14;
                                    i19 = i3;
                                } else {
                                    i30 = i17;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 12:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i17 = i30;
                                bArr2 = bArr;
                                if (i27 == 0) {
                                    iZzi = zzabq.zzj(bArr2, i15, zzabpVar3);
                                    int i37 = zzabpVar3.zza;
                                    zzadj zzadjVarZzE = zzaenVar2.zzE(i14);
                                    if (zzadjVarZzE == null || zzadjVarZzE.zza()) {
                                        unsafe2.putInt(obj3, j, i37);
                                        i22 = i10 | i32;
                                        i20 = i17;
                                        i23 = i13;
                                        i21 = i14;
                                    } else {
                                        zzd(obj).zzj(i17, Long.valueOf(i37));
                                        i20 = i17;
                                        i23 = i13;
                                        i21 = i14;
                                        i22 = i10;
                                    }
                                    i19 = i3;
                                } else {
                                    i30 = i17;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 15:
                                i13 = i26;
                                i14 = iZzy;
                                i15 = i29;
                                i17 = i30;
                                bArr2 = bArr;
                                if (i27 == 0) {
                                    iZzi = zzabq.zzj(bArr2, i15, zzabpVar3);
                                    unsafe2.putInt(obj3, j, zzacg.zzs(zzabpVar3.zza));
                                    i22 = i10 | i32;
                                    i20 = i17;
                                    i23 = i13;
                                    i21 = i14;
                                    i19 = i3;
                                } else {
                                    i30 = i17;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            case 16:
                                i13 = i26;
                                i15 = i29;
                                i17 = i30;
                                if (i27 == 0) {
                                    bArr2 = bArr;
                                    int iZzm2 = zzabq.zzm(bArr2, i15, zzabpVar3);
                                    i14 = iZzy;
                                    unsafe2.putLong(obj, j, zzacg.zzt(zzabpVar3.zzb));
                                    i22 = i10 | i32;
                                    iZzi = iZzm2;
                                    i20 = i17;
                                    i23 = i13;
                                    i21 = i14;
                                    i19 = i3;
                                } else {
                                    i14 = iZzy;
                                    i30 = i17;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                            default:
                                if (i27 == 3) {
                                    Object objZzI2 = zzaenVar2.zzI(obj3, iZzy);
                                    iZzi = zzabq.zzn(objZzI2, zzaenVar2.zzF(iZzy), bArr, i29, i2, (i26 << 3) | 4, zzabpVar);
                                    zzaenVar2.zzR(obj3, iZzy, objZzI2);
                                    i22 = i10 | i32;
                                    i21 = iZzy;
                                    i23 = i26;
                                    i20 = i30;
                                    bArr2 = bArr;
                                    i19 = i3;
                                } else {
                                    i13 = i26;
                                    i15 = i29;
                                    i14 = iZzy;
                                    i12 = i15;
                                    unsafe = unsafe2;
                                    i9 = i13;
                                    i11 = i14;
                                    i5 = i30;
                                    i24 = i24;
                                }
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (iZzB != 27) {
                            i10 = i22;
                            i24 = i24;
                            if (iZzB <= 49) {
                                i9 = i26;
                                unsafe = unsafe2;
                                i11 = iZzy;
                                iZzi = zzw(obj, bArr, i29, i2, i30, i9, i27, iZzy, i28, iZzB, j, zzabpVar);
                                if (iZzi != i29) {
                                    zzaenVar2 = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    i23 = i9;
                                    i2 = i2;
                                    i19 = i3;
                                    zzabpVar3 = zzabpVar;
                                    i21 = i11;
                                    i20 = i30;
                                    i22 = i10;
                                    i24 = i24;
                                    unsafe2 = unsafe;
                                } else {
                                    i12 = iZzi;
                                    i5 = i30;
                                    i24 = i24;
                                }
                            } else {
                                i18 = i29;
                                i9 = i26;
                                unsafe = unsafe2;
                                i11 = iZzy;
                                if (iZzB != 50) {
                                    iZzi = zzu(obj, bArr, i18, i2, i30, i9, i27, i28, iZzB, j, i11, zzabpVar);
                                    if (iZzi != i18) {
                                        zzaenVar2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i23 = i9;
                                        i2 = i2;
                                        i19 = i3;
                                        zzabpVar3 = zzabpVar;
                                        i21 = i11;
                                        i20 = i30;
                                        i22 = i10;
                                        i24 = i24;
                                        unsafe2 = unsafe;
                                    } else {
                                        i12 = iZzi;
                                        i5 = i30;
                                        i24 = i24;
                                    }
                                } else if (i27 == 2) {
                                    iZzi = zzt(obj, bArr, i18, i2, i11, j, zzabpVar);
                                    if (iZzi != i18) {
                                        zzaenVar2 = this;
                                        obj3 = obj;
                                        bArr2 = bArr;
                                        i23 = i9;
                                        i2 = i2;
                                        i19 = i3;
                                        zzabpVar3 = zzabpVar;
                                        i21 = i11;
                                        i20 = i30;
                                        i22 = i10;
                                        i24 = i24;
                                        unsafe2 = unsafe;
                                    } else {
                                        i12 = iZzi;
                                        i5 = i30;
                                        i24 = i24;
                                    }
                                } else {
                                    i12 = i18;
                                    i5 = i30;
                                    i24 = i24;
                                }
                            }
                        } else if (i27 == 2) {
                            zzadk zzadkVarZzd = (zzadk) unsafe2.getObject(obj3, j);
                            if (!zzadkVarZzd.zzc()) {
                                int size = zzadkVarZzd.size();
                                zzadkVarZzd = zzadkVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, zzadkVarZzd);
                            }
                            i20 = i30;
                            iZzi = zzabq.zze(zzaenVar2.zzF(iZzy), i20, bArr, i29, i2, zzadkVarZzd, zzabpVar);
                            i19 = i3;
                            i23 = i26;
                            i21 = iZzy;
                            i22 = i22;
                            i24 = i24;
                            i2 = i2;
                        } else {
                            i10 = i22;
                            i24 = i24;
                            i9 = i26;
                            i18 = i29;
                            unsafe = unsafe2;
                            i11 = iZzy;
                            i12 = i18;
                            i5 = i30;
                            i24 = i24;
                        }
                    }
                }
                if (i5 != i3 || i3 == 0) {
                    if (this.zzh) {
                        zzabpVar2 = zzabpVar;
                        zzacs zzacsVar = zzabpVar2.zzd;
                        if (zzacsVar != zzacs.zza) {
                            i9 = i9;
                            if (zzacsVar.zzb(this.zzg, i9) != null) {
                                throw null;
                            }
                            iZzi = zzabq.zzi(i5, bArr, i12, i2, zzd(obj), zzabpVar);
                            obj = obj;
                        }
                        i2 = i2;
                        i20 = i5;
                        zzaenVar2 = this;
                        zzabpVar3 = zzabpVar2;
                        i23 = i9;
                        obj3 = obj;
                        i21 = i11;
                        i22 = i10;
                        unsafe2 = unsafe;
                        bArr2 = bArr;
                        i19 = i3;
                    } else {
                        zzabpVar2 = zzabpVar;
                    }
                    iZzi = zzabq.zzi(i5, bArr, i12, i2, zzd(obj), zzabpVar);
                    i2 = i2;
                    i20 = i5;
                    zzaenVar2 = this;
                    zzabpVar3 = zzabpVar2;
                    i23 = i9;
                    obj3 = obj;
                    i21 = i11;
                    i22 = i10;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i19 = i3;
                } else {
                    zzaenVar = this;
                    obj2 = obj;
                    i6 = i24;
                    i22 = i10;
                    i7 = 1048575;
                    i4 = i12;
                }
            } else {
                int i38 = i24;
                unsafe = unsafe2;
                i3 = i19;
                obj2 = obj3;
                zzaenVar = zzaenVar2;
                i4 = iZzi;
                i5 = i20;
                i6 = i38;
                i7 = 1048575;
            }
        }
        if (i6 != i7) {
            unsafe.putInt(obj2, i6, i22);
        }
        for (int i39 = zzaenVar.zzl; i39 < zzaenVar.zzm; i39++) {
            zzG(obj, zzaenVar.zzk[i39], null, zzaenVar.zzo, obj);
        }
        if (i3 == 0) {
            if (i4 != i2) {
                throw zzadn.zzg();
            }
        } else if (i4 > i2 || i5 != i3) {
            throw zzadn.zzg();
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final Object zze() {
        return ((zzadf) this.zzg).zzw();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final void zzf(Object obj) {
        if (zzY(obj)) {
            if (obj instanceof zzadf) {
                zzadf zzadfVar = (zzadf) obj;
                zzadfVar.zzH(Integer.MAX_VALUE);
                zzadfVar.zza = 0;
                zzadfVar.zzF();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzC = zzC(i);
                long j = 1048575 & iZzC;
                int iZzB = zzB(iZzC);
                if (iZzB != 9) {
                    switch (iZzB) {
                        case 17:
                            if (zzV(obj, i)) {
                                zzF(i).zzf(zzb.getObject(obj, j));
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                        case 24:
                        case 25:
                        case 26:
                        case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                        case 28:
                        case 29:
                        case 30:
                        case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                        case 32:
                        case 33:
                        case 34:
                        case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                        case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                        case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                        case 38:
                        case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                        case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                        case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                        case 42:
                        case 43:
                        case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                        case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.zzn.zzb(obj, j);
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j);
                            if (object != null) {
                                ((zzaee) object).zzc();
                                unsafe.putObject(obj, j, object);
                            }
                            break;
                    }
                } else if (zzV(obj, i)) {
                    zzF(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzo.zzm(obj);
            if (this.zzh) {
                this.zzp.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final void zzg(Object obj, Object obj2) {
        zzL(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzC = zzC(i);
            long j = 1048575 & iZzC;
            int i2 = this.zzc[i];
            switch (zzB(iZzC)) {
                case 0:
                    if (zzV(obj2, i)) {
                        zzafx.zzo(obj, j, zzafx.zza(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 1:
                    if (zzV(obj2, i)) {
                        zzafx.zzp(obj, j, zzafx.zzb(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 2:
                    if (zzV(obj2, i)) {
                        zzafx.zzr(obj, j, zzafx.zzd(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 3:
                    if (zzV(obj2, i)) {
                        zzafx.zzr(obj, j, zzafx.zzd(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 4:
                    if (zzV(obj2, i)) {
                        zzafx.zzq(obj, j, zzafx.zzc(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 5:
                    if (zzV(obj2, i)) {
                        zzafx.zzr(obj, j, zzafx.zzd(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 6:
                    if (zzV(obj2, i)) {
                        zzafx.zzq(obj, j, zzafx.zzc(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 7:
                    if (zzV(obj2, i)) {
                        zzafx.zzm(obj, j, zzafx.zzw(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 8:
                    if (zzV(obj2, i)) {
                        zzafx.zzs(obj, j, zzafx.zzf(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 9:
                    zzM(obj, obj2, i);
                    break;
                case 10:
                    if (zzV(obj2, i)) {
                        zzafx.zzs(obj, j, zzafx.zzf(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 11:
                    if (zzV(obj2, i)) {
                        zzafx.zzq(obj, j, zzafx.zzc(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 12:
                    if (zzV(obj2, i)) {
                        zzafx.zzq(obj, j, zzafx.zzc(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 13:
                    if (zzV(obj2, i)) {
                        zzafx.zzq(obj, j, zzafx.zzc(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 14:
                    if (zzV(obj2, i)) {
                        zzafx.zzr(obj, j, zzafx.zzd(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 15:
                    if (zzV(obj2, i)) {
                        zzafx.zzq(obj, j, zzafx.zzc(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 16:
                    if (zzV(obj2, i)) {
                        zzafx.zzr(obj, j, zzafx.zzd(obj2, j));
                        zzP(obj, i);
                    }
                    break;
                case 17:
                    zzM(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                case 24:
                case 25:
                case 26:
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                case 28:
                case 29:
                case 30:
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                case 32:
                case 33:
                case 34:
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                case 38:
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                case 42:
                case 43:
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzn.zzc(obj, obj2, j);
                    break;
                case 50:
                    zzaey.zzI(this.zzr, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzZ(obj2, i2, i)) {
                        zzafx.zzs(obj, j, zzafx.zzf(obj2, j));
                        zzQ(obj, i2, i);
                    }
                    break;
                case 60:
                    zzN(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                case 67:
                    if (zzZ(obj2, i2, i)) {
                        zzafx.zzs(obj, j, zzafx.zzf(obj2, j));
                        zzQ(obj, i2, i);
                    }
                    break;
                case 68:
                    zzN(obj, obj2, i);
                    break;
            }
        }
        zzaey.zzF(this.zzo, obj, obj2);
        if (this.zzh) {
            zzaey.zzE(this.zzp, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:173:0x062e A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:59:0x00d9, B:171:0x0629, B:173:0x062e, B:174:0x0633), top: B:192:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x063f A[LOOP:3: B:177:0x063b->B:179:0x063f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:181:0x0653  */
    /* JADX WARN: Code duplicated, block: B:187:0x065f A[LOOP:2: B:185:0x065b->B:187:0x065f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x0673  */
    /* JADX WARN: Code duplicated, block: B:213:0x0639 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final void zzh(Object obj, zzaev zzaevVar, zzacs zzacsVar) throws Throwable {
        Object obj2;
        zzafn zzafnVar;
        Object obj3;
        int i;
        zzafn zzafnVar2;
        Object obj4;
        zzact zzactVar;
        zzacs zzacsVar2;
        int i2;
        Object obj5;
        Object obj6 = obj;
        zzacs zzacsVar3 = zzacsVar;
        zzacsVar.getClass();
        zzL(obj);
        zzafn zzafnVar3 = this.zzo;
        zzact zzactVar2 = this.zzp;
        Object objZzG = null;
        zzacx zzacxVar = null;
        while (true) {
            try {
                int iZzc = zzaevVar.zzc();
                int iZzx = zzx(iZzc);
                if (iZzx >= 0) {
                    zzafnVar = zzafnVar3;
                    obj3 = obj6;
                    try {
                        int iZzC = zzC(iZzx);
                        try {
                            switch (zzB(iZzC)) {
                                case 0:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzo(obj3, iZzC & 1048575, zzaevVar.zza());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 1:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzp(obj3, iZzC & 1048575, zzaevVar.zzb());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 2:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzr(obj3, iZzC & 1048575, zzaevVar.zzl());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 3:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzr(obj3, iZzC & 1048575, zzaevVar.zzo());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 4:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzq(obj3, iZzC & 1048575, zzaevVar.zzg());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 5:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzr(obj3, iZzC & 1048575, zzaevVar.zzk());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 6:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzq(obj3, iZzC & 1048575, zzaevVar.zzf());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 7:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzm(obj3, iZzC & 1048575, zzaevVar.zzN());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 8:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzO(obj3, iZzC, zzaevVar);
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 9:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaek zzaekVar = (zzaek) zzI(obj3, iZzx);
                                    zzaevVar.zzu(zzaekVar, zzF(iZzx), zzacsVar2);
                                    zzR(obj3, iZzx, zzaekVar);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 10:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzs(obj3, iZzC & 1048575, zzaevVar.zzp());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 11:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzq(obj3, iZzC & 1048575, zzaevVar.zzj());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 12:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    int iZze = zzaevVar.zze();
                                    zzadj zzadjVarZzE = zzE(iZzx);
                                    if (zzadjVarZzE == null || zzadjVarZzE.zza()) {
                                        zzafx.zzq(obj3, iZzC & 1048575, iZze);
                                        zzP(obj3, iZzx);
                                        objZzG = obj5;
                                    } else {
                                        objZzG = zzaey.zzD(obj3, iZzc, iZze, obj5, zzafnVar);
                                    }
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 13:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzq(obj3, iZzC & 1048575, zzaevVar.zzh());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 14:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzr(obj3, iZzC & 1048575, zzaevVar.zzm());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 15:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzq(obj3, iZzC & 1048575, zzaevVar.zzi());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 16:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzafx.zzr(obj3, iZzC & 1048575, zzaevVar.zzn());
                                    zzP(obj3, iZzx);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 17:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaek zzaekVar2 = (zzaek) zzI(obj3, iZzx);
                                    zzaevVar.zzt(zzaekVar2, zzF(iZzx), zzacsVar2);
                                    zzR(obj3, iZzx, zzaekVar2);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 18:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzx(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 19:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzB(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 20:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzE(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 21:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzM(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 22:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzD(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzA(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 24:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzz(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 25:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzv(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 26:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    if (zzU(iZzC)) {
                                        ((zzach) zzaevVar).zzK(this.zzn.zza(obj3, iZzC & 1048575), true);
                                    } else {
                                        ((zzach) zzaevVar).zzK(this.zzn.zza(obj3, iZzC & 1048575), false);
                                    }
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzF(this.zzn.zza(obj3, iZzC & 1048575), zzF(iZzx), zzacsVar2);
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 28:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzw(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 29:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzL(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 30:
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    List listZza = this.zzn.zza(obj3, iZzC & 1048575);
                                    zzaevVar.zzy(listZza);
                                    objZzG = zzaey.zzC(obj, iZzc, listZza, zzE(iZzx), objZzG, zzafnVar);
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzG(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 32:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzH(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 33:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzI(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 34:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzJ(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzx(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzB(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzE(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 38:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzM(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzD(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzA(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzz(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 42:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzv(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 43:
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    zzaevVar.zzL(this.zzn.zza(obj3, iZzC & 1048575));
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                    List listZza2 = this.zzn.zza(obj3, iZzC & 1048575);
                                    zzaevVar.zzy(listZza2);
                                    obj2 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    try {
                                        objZzG = zzaey.zzC(obj, iZzc, listZza2, zzE(iZzx), obj2, zzafnVar);
                                    } catch (zzadm unused) {
                                        objZzG = obj2;
                                        zzafnVar.zzq(zzaevVar);
                                        if (objZzG == null) {
                                            objZzG = zzafnVar.zzc(obj3);
                                        }
                                        if (!zzafnVar.zzp(objZzG, zzaevVar)) {
                                            for (i2 = this.zzl; i2 < this.zzm; i2++) {
                                                objZzG = zzG(obj, this.zzk[i2], objZzG, zzafnVar, obj);
                                            }
                                            if (objZzG != null) {
                                                zzafnVar.zzn(obj3, objZzG);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                    zzaevVar.zzG(this.zzn.zza(obj3, iZzC & 1048575));
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 46:
                                    zzaevVar.zzH(this.zzn.zza(obj3, iZzC & 1048575));
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 47:
                                    zzaevVar.zzI(this.zzn.zza(obj3, iZzC & 1048575));
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 48:
                                    zzaevVar.zzJ(this.zzn.zza(obj3, iZzC & 1048575));
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 49:
                                    zzaevVar.zzC(this.zzn.zza(obj3, iZzC & 1048575), zzF(iZzx), zzacsVar3);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 50:
                                    Object objZzH = zzH(iZzx);
                                    long jZzC = zzC(iZzx) & 1048575;
                                    Object objZzf = zzafx.zzf(obj3, jZzC);
                                    if (objZzf == null) {
                                        objZzf = zzaee.zza().zzb();
                                        zzafx.zzs(obj3, jZzC, objZzf);
                                    } else if (zzaef.zzb(objZzf)) {
                                        Object objZzb = zzaee.zza().zzb();
                                        zzaef.zzc(objZzb, objZzf);
                                        zzafx.zzs(obj3, jZzC, objZzb);
                                        objZzf = objZzb;
                                    }
                                    throw null;
                                case 51:
                                    zzafx.zzs(obj3, iZzC & 1048575, Double.valueOf(zzaevVar.zza()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 52:
                                    zzafx.zzs(obj3, iZzC & 1048575, Float.valueOf(zzaevVar.zzb()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 53:
                                    zzafx.zzs(obj3, iZzC & 1048575, Long.valueOf(zzaevVar.zzl()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 54:
                                    zzafx.zzs(obj3, iZzC & 1048575, Long.valueOf(zzaevVar.zzo()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 55:
                                    zzafx.zzs(obj3, iZzC & 1048575, Integer.valueOf(zzaevVar.zzg()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 56:
                                    zzafx.zzs(obj3, iZzC & 1048575, Long.valueOf(zzaevVar.zzk()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 57:
                                    zzafx.zzs(obj3, iZzC & 1048575, Integer.valueOf(zzaevVar.zzf()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 58:
                                    zzafx.zzs(obj3, iZzC & 1048575, Boolean.valueOf(zzaevVar.zzN()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 59:
                                    zzO(obj3, iZzC, zzaevVar);
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 60:
                                    zzaek zzaekVar3 = (zzaek) zzJ(obj3, iZzc, iZzx);
                                    zzaevVar.zzu(zzaekVar3, zzF(iZzx), zzacsVar3);
                                    zzS(obj3, iZzc, iZzx, zzaekVar3);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 61:
                                    zzafx.zzs(obj3, iZzC & 1048575, zzaevVar.zzp());
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 62:
                                    zzafx.zzs(obj3, iZzC & 1048575, Integer.valueOf(zzaevVar.zzj()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 63:
                                    int iZze2 = zzaevVar.zze();
                                    zzadj zzadjVarZzE2 = zzE(iZzx);
                                    if (zzadjVarZzE2 != null && !zzadjVarZzE2.zza()) {
                                        objZzG = zzaey.zzD(obj3, iZzc, iZze2, objZzG, zzafnVar);
                                        zzactVar = zzactVar2;
                                        zzacsVar2 = zzacsVar3;
                                        obj6 = obj3;
                                        zzactVar2 = zzactVar;
                                        zzacsVar3 = zzacsVar2;
                                        zzafnVar3 = zzafnVar;
                                    }
                                    zzafx.zzs(obj3, iZzC & 1048575, Integer.valueOf(iZze2));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 64:
                                    zzafx.zzs(obj3, iZzC & 1048575, Integer.valueOf(zzaevVar.zzh()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 65:
                                    zzafx.zzs(obj3, iZzC & 1048575, Long.valueOf(zzaevVar.zzm()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                    zzafx.zzs(obj3, iZzC & 1048575, Integer.valueOf(zzaevVar.zzi()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 67:
                                    zzafx.zzs(obj3, iZzC & 1048575, Long.valueOf(zzaevVar.zzn()));
                                    zzQ(obj3, iZzc, iZzx);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                case 68:
                                    zzaek zzaekVar4 = (zzaek) zzJ(obj3, iZzc, iZzx);
                                    zzaevVar.zzt(zzaekVar4, zzF(iZzx), zzacsVar3);
                                    zzS(obj3, iZzc, iZzx, zzaekVar4);
                                    obj5 = objZzG;
                                    zzactVar = zzactVar2;
                                    zzacsVar2 = zzacsVar3;
                                    objZzG = obj5;
                                    obj6 = obj3;
                                    zzactVar2 = zzactVar;
                                    zzacsVar3 = zzacsVar2;
                                    zzafnVar3 = zzafnVar;
                                    break;
                                default:
                                    if (objZzG == null) {
                                        objZzG = zzafnVar.zzc(obj3);
                                    }
                                    try {
                                        try {
                                            if (!zzafnVar.zzp(objZzG, zzaevVar)) {
                                                for (int i3 = this.zzl; i3 < this.zzm; i3++) {
                                                    objZzG = zzG(obj, this.zzk[i3], objZzG, zzafnVar, obj);
                                                }
                                                if (objZzG != null) {
                                                    zzafnVar.zzn(obj3, objZzG);
                                                    return;
                                                }
                                                return;
                                            }
                                            zzactVar = zzactVar2;
                                            zzacsVar2 = zzacsVar3;
                                        } catch (zzadm unused2) {
                                            zzactVar = zzactVar2;
                                            zzacsVar2 = zzacsVar3;
                                            zzafnVar.zzq(zzaevVar);
                                            if (objZzG == null) {
                                                objZzG = zzafnVar.zzc(obj3);
                                            }
                                            if (!zzafnVar.zzp(objZzG, zzaevVar)) {
                                                while (i2 < this.zzm) {
                                                    objZzG = zzG(obj, this.zzk[i2], objZzG, zzafnVar, obj);
                                                }
                                                if (objZzG != null) {
                                                    zzafnVar.zzn(obj3, objZzG);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        obj6 = obj3;
                                        zzactVar2 = zzactVar;
                                        zzacsVar3 = zzacsVar2;
                                        zzafnVar3 = zzafnVar;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    break;
                            }
                        } catch (zzadm unused3) {
                            obj2 = objZzG;
                            zzactVar = zzactVar2;
                            zzacsVar2 = zzacsVar3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = objZzG;
                    }
                } else {
                    if (iZzc == Integer.MAX_VALUE) {
                        for (int i4 = this.zzl; i4 < this.zzm; i4++) {
                            objZzG = zzG(obj, this.zzk[i4], objZzG, zzafnVar3, obj);
                        }
                        if (objZzG != null) {
                            zzafnVar3.zzn(obj6, objZzG);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objZzc = !this.zzh ? null : zzactVar2.zzc(zzacsVar3, this.zzg, iZzc);
                        if (objZzc != null) {
                            zzacx zzacxVarZzb = zzacxVar == null ? zzactVar2.zzb(obj6) : zzacxVar;
                            zzafnVar2 = zzafnVar3;
                            obj4 = obj6;
                            try {
                                objZzG = zzactVar2.zzd(obj, zzaevVar, objZzc, zzacsVar, zzacxVarZzb, objZzG, zzafnVar2);
                                zzacxVar = zzacxVarZzb;
                            } catch (Throwable th4) {
                                th = th4;
                                obj3 = obj4;
                                zzafnVar = zzafnVar2;
                                obj2 = objZzG;
                                objZzG = obj2;
                                for (i = this.zzl; i < this.zzm; i++) {
                                    objZzG = zzG(obj, this.zzk[i], objZzG, zzafnVar, obj);
                                }
                                if (objZzG != null) {
                                    zzafnVar.zzn(obj3, objZzG);
                                }
                                throw th;
                            }
                        } else {
                            zzafnVar2 = zzafnVar3;
                            obj4 = obj6;
                            zzafnVar2.zzq(zzaevVar);
                            if (objZzG == null) {
                                objZzG = zzafnVar2.zzc(obj4);
                            }
                            try {
                                if (!zzafnVar2.zzp(objZzG, zzaevVar)) {
                                    int i5 = this.zzl;
                                    while (i5 < this.zzm) {
                                        zzafn zzafnVar4 = zzafnVar2;
                                        objZzG = zzG(obj, this.zzk[i5], objZzG, zzafnVar4, obj);
                                        i5++;
                                        obj4 = obj4;
                                        zzafnVar2 = zzafnVar4;
                                    }
                                    Object obj7 = obj4;
                                    zzafn zzafnVar5 = zzafnVar2;
                                    if (objZzG != null) {
                                        zzafnVar5.zzn(obj7, objZzG);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                obj3 = obj4;
                                zzafnVar = zzafnVar2;
                            }
                        }
                        obj6 = obj4;
                        zzafnVar3 = zzafnVar2;
                    } catch (Throwable th6) {
                        th = th6;
                        zzafnVar = zzafnVar3;
                        obj3 = obj6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                obj2 = objZzG;
                zzafnVar = zzafnVar3;
                obj3 = obj6;
            }
            objZzG = obj2;
            while (i < this.zzm) {
                objZzG = zzG(obj, this.zzk[i], objZzG, zzafnVar, obj);
            }
            if (objZzG != null) {
                zzafnVar.zzn(obj3, objZzG);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzabp zzabpVar) throws zzadn {
        if (this.zzj) {
            zzv(obj, bArr, i, i2, zzabpVar);
        } else {
            zzc(obj, bArr, i, i2, 0, zzabpVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzH;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzC = zzC(i);
            long j = iZzC & 1048575;
            switch (zzB(iZzC)) {
                case 0:
                    if (!zzT(obj, obj2, i) || Double.doubleToLongBits(zzafx.zza(obj, j)) != Double.doubleToLongBits(zzafx.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzT(obj, obj2, i) || Float.floatToIntBits(zzafx.zzb(obj, j)) != Float.floatToIntBits(zzafx.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzT(obj, obj2, i) || zzafx.zzd(obj, j) != zzafx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzT(obj, obj2, i) || zzafx.zzd(obj, j) != zzafx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzT(obj, obj2, i) || zzafx.zzc(obj, j) != zzafx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzT(obj, obj2, i) || zzafx.zzd(obj, j) != zzafx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzT(obj, obj2, i) || zzafx.zzc(obj, j) != zzafx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzT(obj, obj2, i) || zzafx.zzw(obj, j) != zzafx.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzT(obj, obj2, i) || !zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzT(obj, obj2, i) || !zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzT(obj, obj2, i) || !zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzT(obj, obj2, i) || zzafx.zzc(obj, j) != zzafx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzT(obj, obj2, i) || zzafx.zzc(obj, j) != zzafx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzT(obj, obj2, i) || zzafx.zzc(obj, j) != zzafx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzT(obj, obj2, i) || zzafx.zzd(obj, j) != zzafx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzT(obj, obj2, i) || zzafx.zzc(obj, j) != zzafx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzT(obj, obj2, i) || zzafx.zzd(obj, j) != zzafx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzT(obj, obj2, i) || !zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                case 24:
                case 25:
                case 26:
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                case 28:
                case 29:
                case 30:
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                case 32:
                case 33:
                case 34:
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                case 38:
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                case 42:
                case 43:
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzH = zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j));
                    break;
                case 50:
                    zZzH = zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                case 67:
                case 68:
                    long jZzz = zzz(i) & 1048575;
                    if (zzafx.zzc(obj, jZzz) != zzafx.zzc(obj2, jZzz) || !zzaey.zzH(zzafx.zzf(obj, j), zzafx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzH) {
                return false;
            }
        }
        if (!this.zzo.zzd(obj).equals(this.zzo.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(obj);
        this.zzp.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3 A[LOOP:1: B:45:0x00b2->B:50:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e1 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzaew zzaewVarZzF;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzl) {
            int i7 = this.zzk[i6];
            int i8 = this.zzc[i7];
            int iZzC = zzC(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzC) != 0 && !zzW(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzB = zzB(iZzC);
            if (iZzB == 9 || iZzB == 17) {
                if (zzW(obj, i7, i, i2, i11) && !zzX(obj, iZzC, zzF(i7))) {
                    return false;
                }
            } else if (iZzB == 27) {
                list = (List) zzafx.zzf(obj, iZzC & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzaewVarZzF = zzF(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzaewVarZzF.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzB == 60 || iZzB == 68) {
                if (zzZ(obj, i8, i7) && !zzX(obj, iZzC, zzF(i7))) {
                    return false;
                }
            } else if (iZzB == 49) {
                list = (List) zzafx.zzf(obj, iZzC & 1048575);
                if (list.isEmpty()) {
                    zzaewVarZzF = zzF(i7);
                    while (i3 < list.size()) {
                        if (!zzaewVarZzF.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzB == 50 && !((zzaee) zzafx.zzf(obj, iZzC & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final void zzn(Object obj, zzaco zzacoVar) {
        if (!this.zzj) {
            zzab(obj, zzacoVar);
            return;
        }
        if (this.zzh) {
            this.zzp.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzC = zzC(i);
            int i2 = this.zzc[i];
            switch (zzB(iZzC)) {
                case 0:
                    if (zzV(obj, i)) {
                        zzacoVar.zzf(i2, zzafx.zza(obj, iZzC & 1048575));
                    }
                    break;
                case 1:
                    if (zzV(obj, i)) {
                        zzacoVar.zzo(i2, zzafx.zzb(obj, iZzC & 1048575));
                    }
                    break;
                case 2:
                    if (zzV(obj, i)) {
                        zzacoVar.zzt(i2, zzafx.zzd(obj, iZzC & 1048575));
                    }
                    break;
                case 3:
                    if (zzV(obj, i)) {
                        zzacoVar.zzJ(i2, zzafx.zzd(obj, iZzC & 1048575));
                    }
                    break;
                case 4:
                    if (zzV(obj, i)) {
                        zzacoVar.zzr(i2, zzafx.zzc(obj, iZzC & 1048575));
                    }
                    break;
                case 5:
                    if (zzV(obj, i)) {
                        zzacoVar.zzm(i2, zzafx.zzd(obj, iZzC & 1048575));
                    }
                    break;
                case 6:
                    if (zzV(obj, i)) {
                        zzacoVar.zzk(i2, zzafx.zzc(obj, iZzC & 1048575));
                    }
                    break;
                case 7:
                    if (zzV(obj, i)) {
                        zzacoVar.zzb(i2, zzafx.zzw(obj, iZzC & 1048575));
                    }
                    break;
                case 8:
                    if (zzV(obj, i)) {
                        zzad(i2, zzafx.zzf(obj, iZzC & 1048575), zzacoVar);
                    }
                    break;
                case 9:
                    if (zzV(obj, i)) {
                        zzacoVar.zzv(i2, zzafx.zzf(obj, iZzC & 1048575), zzF(i));
                    }
                    break;
                case 10:
                    if (zzV(obj, i)) {
                        zzacoVar.zzd(i2, (zzacc) zzafx.zzf(obj, iZzC & 1048575));
                    }
                    break;
                case 11:
                    if (zzV(obj, i)) {
                        zzacoVar.zzH(i2, zzafx.zzc(obj, iZzC & 1048575));
                    }
                    break;
                case 12:
                    if (zzV(obj, i)) {
                        zzacoVar.zzi(i2, zzafx.zzc(obj, iZzC & 1048575));
                    }
                    break;
                case 13:
                    if (zzV(obj, i)) {
                        zzacoVar.zzw(i2, zzafx.zzc(obj, iZzC & 1048575));
                    }
                    break;
                case 14:
                    if (zzV(obj, i)) {
                        zzacoVar.zzy(i2, zzafx.zzd(obj, iZzC & 1048575));
                    }
                    break;
                case 15:
                    if (zzV(obj, i)) {
                        zzacoVar.zzA(i2, zzafx.zzc(obj, iZzC & 1048575));
                    }
                    break;
                case 16:
                    if (zzV(obj, i)) {
                        zzacoVar.zzC(i2, zzafx.zzd(obj, iZzC & 1048575));
                    }
                    break;
                case 17:
                    if (zzV(obj, i)) {
                        zzacoVar.zzq(i2, zzafx.zzf(obj, iZzC & 1048575), zzF(i));
                    }
                    break;
                case 18:
                    zzaey.zzL(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 19:
                    zzaey.zzP(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 20:
                    zzaey.zzS(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 21:
                    zzaey.zzaa(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 22:
                    zzaey.zzR(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    zzaey.zzO(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 24:
                    zzaey.zzN(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 25:
                    zzaey.zzJ(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 26:
                    zzaey.zzY(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar);
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    zzaey.zzT(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, zzF(i));
                    break;
                case 28:
                    zzaey.zzK(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar);
                    break;
                case 29:
                    zzaey.zzZ(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 30:
                    zzaey.zzM(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    zzaey.zzU(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 32:
                    zzaey.zzV(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 33:
                    zzaey.zzW(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case 34:
                    zzaey.zzX(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, false);
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    zzaey.zzL(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    zzaey.zzP(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    zzaey.zzS(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 38:
                    zzaey.zzaa(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    zzaey.zzR(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    zzaey.zzO(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    zzaey.zzN(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 42:
                    zzaey.zzJ(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 43:
                    zzaey.zzZ(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    zzaey.zzM(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    zzaey.zzU(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 46:
                    zzaey.zzV(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 47:
                    zzaey.zzW(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 48:
                    zzaey.zzX(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, true);
                    break;
                case 49:
                    zzaey.zzQ(i2, (List) zzafx.zzf(obj, iZzC & 1048575), zzacoVar, zzF(i));
                    break;
                case 50:
                    zzac(zzacoVar, i2, zzafx.zzf(obj, iZzC & 1048575), i);
                    break;
                case 51:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzf(i2, zzo(obj, iZzC & 1048575));
                    }
                    break;
                case 52:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzo(i2, zzp(obj, iZzC & 1048575));
                    }
                    break;
                case 53:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzt(i2, zzD(obj, iZzC & 1048575));
                    }
                    break;
                case 54:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzJ(i2, zzD(obj, iZzC & 1048575));
                    }
                    break;
                case 55:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzr(i2, zzs(obj, iZzC & 1048575));
                    }
                    break;
                case 56:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzm(i2, zzD(obj, iZzC & 1048575));
                    }
                    break;
                case 57:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzk(i2, zzs(obj, iZzC & 1048575));
                    }
                    break;
                case 58:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzb(i2, zzaa(obj, iZzC & 1048575));
                    }
                    break;
                case 59:
                    if (zzZ(obj, i2, i)) {
                        zzad(i2, zzafx.zzf(obj, iZzC & 1048575), zzacoVar);
                    }
                    break;
                case 60:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzv(i2, zzafx.zzf(obj, iZzC & 1048575), zzF(i));
                    }
                    break;
                case 61:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzd(i2, (zzacc) zzafx.zzf(obj, iZzC & 1048575));
                    }
                    break;
                case 62:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzH(i2, zzs(obj, iZzC & 1048575));
                    }
                    break;
                case 63:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzi(i2, zzs(obj, iZzC & 1048575));
                    }
                    break;
                case 64:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzw(i2, zzs(obj, iZzC & 1048575));
                    }
                    break;
                case 65:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzy(i2, zzD(obj, iZzC & 1048575));
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzA(i2, zzs(obj, iZzC & 1048575));
                    }
                    break;
                case 67:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzC(i2, zzD(obj, iZzC & 1048575));
                    }
                    break;
                case 68:
                    if (zzZ(obj, i2, i)) {
                        zzacoVar.zzq(i2, zzafx.zzf(obj, iZzC & 1048575), zzF(i));
                    }
                    break;
            }
        }
        zzafn zzafnVar = this.zzo;
        zzafnVar.zzr(zzafnVar.zzd(obj), zzacoVar);
    }

    private final void zzN(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzZ(obj2, i2, i)) {
            long jZzC = zzC(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(obj2, jZzC);
            if (object == null) {
                throw new IllegalStateException(eoBKjVuj.UwIRtlFsF + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzaew zzaewVarZzF = zzF(i);
            if (!zzZ(obj, i2, i)) {
                if (zzY(object)) {
                    Object objZze = zzaewVarZzF.zze();
                    zzaewVarZzF.zzg(objZze, object);
                    unsafe.putObject(obj, jZzC, objZze);
                } else {
                    unsafe.putObject(obj, jZzC, object);
                }
                zzQ(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jZzC);
            if (!zzY(object2)) {
                Object objZze2 = zzaewVarZzF.zze();
                zzaewVarZzF.zzg(objZze2, object2);
                unsafe.putObject(obj, jZzC, objZze2);
                object2 = objZze2;
            }
            zzaewVarZzF.zzg(object2, object);
        }
    }

    private static Field zzK(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m(ygoi.mqCekiluSEt, str, " for ", name, " not found. Known fields are ");
            sbM22m.append(string);
            throw new RuntimeException(sbM22m.toString());
        }
    }
}
