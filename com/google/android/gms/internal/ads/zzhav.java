package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.google.protobuf.DescriptorProtos;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzhav<T> implements zzhbl<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhce.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhas zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhbx zzm;
    private final zzgys zzn;

    private zzhav(int[] iArr, Object[] objArr, int i, int i2, zzhas zzhasVar, boolean z, int[] iArr2, int i3, int i4, zzhay zzhayVar, zzhaf zzhafVar, zzhbx zzhbxVar, zzgys zzgysVar, zzhan zzhanVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhasVar instanceof zzgzh;
        boolean z2 = false;
        if (zzgysVar != null && (zzhasVar instanceof zzgzd)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzhbxVar;
        this.zzn = zzgysVar;
        this.zzg = zzhasVar;
    }

    private final Object zzA(Object obj, int i) {
        zzhbl zzhblVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzhblVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhblVarZzx.zze();
        if (object != null) {
            zzhblVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhbl zzhblVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzhblVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhblVarZzx.zze();
        if (object != null) {
            zzhblVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Field ", str, " for ", name, " not found. Known fields are ");
            sbM22m.append(string);
            throw new RuntimeException(sbM22m.toString(), e);
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhbl zzhblVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzhblVarZzx.zze();
                    zzhblVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzhblVarZzx.zze();
                zzhblVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhblVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzhbl zzhblVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzhblVarZzx.zze();
                    zzhblVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzhblVarZzx.zze();
                zzhblVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhblVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzhbf zzhbfVar) {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhce.zzv(obj, j, zzhbfVar.zzs());
        } else if (this.zzi) {
            zzhce.zzv(obj, j, zzhbfVar.zzr());
        } else {
            zzhce.zzv(obj, j, zzhbfVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzhce.zzt(obj, j, (1 << (iZzr >>> 20)) | zzhce.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhce.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzhce.zzd(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhce.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhce.zzc(obj, j2)) != 0;
            case 2:
                return zzhce.zzf(obj, j2) != 0;
            case 3:
                return zzhce.zzf(obj, j2) != 0;
            case 4:
                return zzhce.zzd(obj, j2) != 0;
            case 5:
                return zzhce.zzf(obj, j2) != 0;
            case 6:
                return zzhce.zzd(obj, j2) != 0;
            case 7:
                return zzhce.zzz(obj, j2);
            case 8:
                Object objZzh = zzhce.zzh(obj, j2);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgxz) {
                    return !zzgxz.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhce.zzh(obj, j2) != null;
            case 10:
                return !zzgxz.zzb.equals(zzhce.zzh(obj, j2));
            case 11:
                return zzhce.zzd(obj, j2) != 0;
            case 12:
                return zzhce.zzd(obj, j2) != 0;
            case 13:
                return zzhce.zzd(obj, j2) != 0;
            case 14:
                return zzhce.zzf(obj, j2) != 0;
            case 15:
                return zzhce.zzd(obj, j2) != 0;
            case 16:
                return zzhce.zzf(obj, j2) != 0;
            case 17:
                return zzhce.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhbl zzhblVar) {
        return zzhblVar.zzl(zzhce.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgzh) {
            return ((zzgzh) obj).zzcd();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhce.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhce.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzhcm zzhcmVar) {
        if (obj instanceof String) {
            zzhcmVar.zzG(i, (String) obj);
        } else {
            zzhcmVar.zzd(i, (zzgxz) obj);
        }
    }

    public static zzhby zzd(Object obj) {
        zzgzh zzgzhVar = (zzgzh) obj;
        zzhby zzhbyVar = zzgzhVar.zzt;
        if (zzhbyVar != zzhby.zzc()) {
            return zzhbyVar;
        }
        zzhby zzhbyVarZzf = zzhby.zzf();
        zzgzhVar.zzt = zzhbyVarZzf;
        return zzhbyVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0266  */
    /* JADX WARN: Code duplicated, block: B:126:0x0269  */
    /* JADX WARN: Code duplicated, block: B:129:0x0280  */
    /* JADX WARN: Code duplicated, block: B:131:0x0284  */
    /* JADX WARN: Code duplicated, block: B:170:0x0349  */
    /* JADX WARN: Code duplicated, block: B:185:0x0395  */
    /* JADX WARN: Code duplicated, block: B:188:0x039d  */
    public static zzhav zzm(Class cls, zzhap zzhapVar, zzhay zzhayVar, zzhaf zzhafVar, zzhbx zzhbxVar, zzgys zzgysVar, zzhan zzhanVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzC;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzC2;
        int i28;
        Object obj2;
        Field fieldZzC3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzhapVar instanceof zzhbe)) {
            throw null;
        }
        zzhbe zzhbeVar = (zzhbe) zzhapVar;
        String strZzd = zzhbeVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strZzd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strZzd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strZzd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strZzd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strZzd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strZzd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strZzd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strZzd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strZzd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strZzd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strZzd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strZzd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strZzd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strZzd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strZzd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strZzd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strZzd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzhbeVar.zze();
        Class<?> cls2 = zzhbeVar.zza().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strZzd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strZzd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrZze[i4];
                } else {
                    if (i84 == 12) {
                        if (zzhbeVar.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrZze[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i27];
                    if (obj instanceof Field) {
                        fieldZzC2 = (Field) obj;
                    } else {
                        fieldZzC2 = zzC(cls2, (String) obj);
                        objArrZze[i27] = fieldZzC2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzC2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzC3 = (Field) obj2;
                    } else {
                        fieldZzC3 = zzC(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzC3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC3);
                    i20 = 0;
                    strZzd = strZzd;
                    zzhbeVar = zzhbeVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzC2 = (Field) obj;
                } else {
                    fieldZzC2 = zzC(cls2, (String) obj);
                    objArrZze[i27] = fieldZzC2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzC2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzC3 = (Field) obj2;
                } else {
                    fieldZzC3 = zzC(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzC3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC3);
                i20 = 0;
                strZzd = strZzd;
                zzhbeVar = zzhbeVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzC4 = zzC(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzC4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zzhbeVar = zzhbeVar;
                            if (zzhbeVar.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i67 / 3;
                                objArr[i91 + i91 + 1] = objArrZze[i18];
                                i18 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i67;
                            int i94 = i67 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrZze[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i95 + 1] = objArrZze[i92];
                                i64 = i93;
                                zzhbeVar = zzhbeVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = i16;
                            i20 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strZzd.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = (iCharAt13 / 32) + i6 + i6;
                            Object obj3 = objArrZze[i99];
                            if (obj3 instanceof Field) {
                                fieldZzC = (Field) obj3;
                            } else {
                                fieldZzC = zzC(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzC;
                            }
                            i19 = i96;
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i21 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i67 / 3;
                    objArr[i100 + i100 + i23] = objArrZze[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        i19 = i16;
                        i20 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i21 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i21 = i78;
            }
            int i101 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i102 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = iObjectFieldOffset | (i21 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i67 += 3;
            iArr3[i102] = (i20 << 20) | iObjectFieldOffset2;
            strZzd = strZzd;
            i4 = i18;
            i34 = i19;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            zzhbeVar = zzhbeVar;
            i2 = i17;
            c = 55296;
        }
        return new zzhav(iArr3, objArr, i2, i5, zzhbeVar.zza(), false, iArr, i3, i62, zzhayVar, zzhafVar, zzhbxVar, zzgysVar, zzhanVar);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhce.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhce.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhce.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhce.zzh(obj, j)).longValue();
    }

    private final zzgzn zzw(int i) {
        int i2 = i / 3;
        return (zzgzn) this.zzd[i2 + i2 + 1];
    }

    private final zzhbl zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhbl zzhblVar = (zzhbl) objArr[i3];
        if (zzhblVar != null) {
            return zzhblVar;
        }
        zzhbl zzhblVarZzb = zzhbc.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzhblVarZzb;
        return zzhblVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhbx zzhbxVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzh = zzhce.zzh(obj, zzu(i) & 1048575);
        if (objZzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 21841. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.ads.zzhbl
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhav.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int iZzd;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i4 >= iArr.length) {
                int iHashCode = ((zzgzh) obj).zzt.hashCode() + (i5 * 53);
                return this.zzh ? (iHashCode * 53) + ((zzgzd) obj).zza.zza.hashCode() : iHashCode;
            }
            int iZzu = zzu(i4);
            int i6 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i7 = iArr[i4];
            long j = i6;
            int iHashCode2 = 37;
            switch (iZzt) {
                case 0:
                    i = i5 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhce.zzb(obj, j));
                    byte[] bArr = zzgzu.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzd;
                    break;
                case 1:
                    i2 = i5 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhce.zzc(obj, j));
                    i5 = iFloatToIntBits + i2;
                    break;
                case 2:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr2 = zzgzu.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzd;
                    break;
                case 3:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr3 = zzgzu.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzd;
                    break;
                case 4:
                    i = i5 * 53;
                    iZzd = zzhce.zzd(obj, j);
                    i5 = i + iZzd;
                    break;
                case 5:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr4 = zzgzu.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzd;
                    break;
                case 6:
                    i = i5 * 53;
                    iZzd = zzhce.zzd(obj, j);
                    i5 = i + iZzd;
                    break;
                case 7:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzgzu.zza(zzhce.zzz(obj, j));
                    i5 = iFloatToIntBits + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    iFloatToIntBits = ((String) zzhce.zzh(obj, j)).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 9:
                    i3 = i5 * 53;
                    Object objZzh = zzhce.zzh(obj, j);
                    if (objZzh != null) {
                        iHashCode2 = objZzh.hashCode();
                    }
                    i5 = i3 + iHashCode2;
                    break;
                case 10:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzhce.zzh(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 11:
                    i = i5 * 53;
                    iZzd = zzhce.zzd(obj, j);
                    i5 = i + iZzd;
                    break;
                case 12:
                    i = i5 * 53;
                    iZzd = zzhce.zzd(obj, j);
                    i5 = i + iZzd;
                    break;
                case 13:
                    i = i5 * 53;
                    iZzd = zzhce.zzd(obj, j);
                    i5 = i + iZzd;
                    break;
                case 14:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr5 = zzgzu.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzd;
                    break;
                case 15:
                    i = i5 * 53;
                    iZzd = zzhce.zzd(obj, j);
                    i5 = i + iZzd;
                    break;
                case 16:
                    i = i5 * 53;
                    jDoubleToLongBits = zzhce.zzf(obj, j);
                    byte[] bArr6 = zzgzu.zzb;
                    iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i + iZzd;
                    break;
                case 17:
                    i3 = i5 * 53;
                    Object objZzh2 = zzhce.zzh(obj, j);
                    if (objZzh2 != null) {
                        iHashCode2 = objZzh2.hashCode();
                    }
                    i5 = i3 + iHashCode2;
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
                    i2 = i5 * 53;
                    iFloatToIntBits = zzhce.zzh(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 50:
                    i2 = i5 * 53;
                    iFloatToIntBits = zzhce.zzh(obj, j).hashCode();
                    i5 = iFloatToIntBits + i2;
                    break;
                case 51:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzgzu.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzd;
                    }
                    break;
                case 52:
                    if (zzR(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 53:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzgzu.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzd;
                    }
                    break;
                case 54:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzgzu.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzd;
                    }
                    break;
                case 55:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i + iZzd;
                    }
                    break;
                case 56:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzgzu.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzd;
                    }
                    break;
                case 57:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i + iZzd;
                    }
                    break;
                case 58:
                    if (zzR(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzgzu.zza(zzS(obj, j));
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 59:
                    if (zzR(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = ((String) zzhce.zzh(obj, j)).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 60:
                    if (zzR(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzhce.zzh(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 61:
                    if (zzR(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzhce.zzh(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
                case 62:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i + iZzd;
                    }
                    break;
                case 63:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i + iZzd;
                    }
                    break;
                case 64:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i + iZzd;
                    }
                    break;
                case 65:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzgzu.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzd;
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        iZzd = zzp(obj, j);
                        i5 = i + iZzd;
                    }
                    break;
                case 67:
                    if (zzR(obj, i7, i4)) {
                        i = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzgzu.zzb;
                        iZzd = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i + iZzd;
                    }
                    break;
                case 68:
                    if (zzR(obj, i7, i4)) {
                        i2 = i5 * 53;
                        iFloatToIntBits = zzhce.zzh(obj, j).hashCode();
                        i5 = iFloatToIntBits + i2;
                    }
                    break;
            }
            i4 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:402:0x0992  */
    /* JADX WARN: Code duplicated, block: B:404:0x09a8  */
    /* JADX WARN: Code duplicated, block: B:492:0x0cce A[PHI: r3 r6 r8 r12 r13 r14 r22 r23
  0x0cce: PHI (r3v87 int) = 
  (r3v67 int)
  (r3v68 int)
  (r3v69 int)
  (r3v70 int)
  (r3v71 int)
  (r3v72 int)
  (r3v73 int)
  (r3v74 int)
  (r3v75 int)
  (r3v80 int)
  (r3v84 int)
  (r3v88 int)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r6v75 com.google.android.gms.internal.ads.zzgxn) = 
  (r6v53 com.google.android.gms.internal.ads.zzgxn)
  (r6v54 com.google.android.gms.internal.ads.zzgxn)
  (r6v55 com.google.android.gms.internal.ads.zzgxn)
  (r6v56 com.google.android.gms.internal.ads.zzgxn)
  (r6v57 com.google.android.gms.internal.ads.zzgxn)
  (r6v58 com.google.android.gms.internal.ads.zzgxn)
  (r6v59 com.google.android.gms.internal.ads.zzgxn)
  (r6v60 com.google.android.gms.internal.ads.zzgxn)
  (r6v61 com.google.android.gms.internal.ads.zzgxn)
  (r6v66 com.google.android.gms.internal.ads.zzgxn)
  (r6v71 com.google.android.gms.internal.ads.zzgxn)
  (r6v76 com.google.android.gms.internal.ads.zzgxn)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r8v137 int) = 
  (r8v112 int)
  (r8v113 int)
  (r8v114 int)
  (r8v115 int)
  (r8v116 int)
  (r8v117 int)
  (r8v118 int)
  (r8v119 int)
  (r8v120 int)
  (r8v125 int)
  (r8v131 int)
  (r8v138 int)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r12v80 sun.misc.Unsafe) = 
  (r12v58 sun.misc.Unsafe)
  (r12v59 sun.misc.Unsafe)
  (r12v60 sun.misc.Unsafe)
  (r12v61 sun.misc.Unsafe)
  (r12v62 sun.misc.Unsafe)
  (r12v63 sun.misc.Unsafe)
  (r12v64 sun.misc.Unsafe)
  (r12v65 sun.misc.Unsafe)
  (r12v66 sun.misc.Unsafe)
  (r12v71 sun.misc.Unsafe)
  (r12v76 sun.misc.Unsafe)
  (r12v81 sun.misc.Unsafe)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r13v85 java.lang.Object) = 
  (r13v57 java.lang.Object)
  (r13v58 java.lang.Object)
  (r13v59 java.lang.Object)
  (r13v60 java.lang.Object)
  (r13v61 java.lang.Object)
  (r13v62 java.lang.Object)
  (r13v63 java.lang.Object)
  (r13v64 java.lang.Object)
  (r13v65 java.lang.Object)
  (r13v75 java.lang.Object)
  (r13v80 java.lang.Object)
  (r13v86 java.lang.Object)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r14v83 int) = 
  (r14v59 int)
  (r14v60 int)
  (r14v61 int)
  (r14v62 int)
  (r14v63 int)
  (r14v64 int)
  (r14v65 int)
  (r14v66 int)
  (r14v67 int)
  (r3v63 int)
  (r14v78 int)
  (r14v84 int)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r22v37 int) = 
  (r22v15 int)
  (r22v16 int)
  (r22v17 int)
  (r22v18 int)
  (r22v19 int)
  (r22v20 int)
  (r22v21 int)
  (r22v22 int)
  (r22v23 int)
  (r22v27 int)
  (r22v33 int)
  (r22v38 int)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]
  0x0cce: PHI (r23v26 int) = 
  (r23v5 int)
  (r23v6 int)
  (r23v7 int)
  (r23v8 int)
  (r23v9 int)
  (r23v10 int)
  (r23v11 int)
  (r23v12 int)
  (r23v13 int)
  (r23v19 int)
  (r23v23 int)
  (r23v27 int)
 binds: [B:490:0x0cb7, B:487:0x0c90, B:484:0x0c6d, B:481:0x0c4a, B:478:0x0c27, B:475:0x0c03, B:468:0x0bd7, B:454:0x0b8f, B:452:0x0b75, B:430:0x0aae, B:422:0x0a67, B:418:0x0a20] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:509:0x0d27  */
    /* JADX WARN: Code duplicated, block: B:573:0x0cd1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0ce8 A[SYNTHETIC] */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzgxn zzgxnVar) {
        int i4;
        Object obj2;
        Unsafe unsafe;
        zzhav<T> zzhavVar;
        int i5;
        int i6;
        int i7;
        int i8;
        zzgxn zzgxnVar2;
        int i9;
        int i10;
        int i11;
        int i12;
        int iZzg;
        int i13;
        zzgxn zzgxnVar3;
        int i14;
        int i15;
        boolean z;
        int iZzh;
        int i16;
        boolean z2;
        int i17;
        int iZzh2;
        Unsafe unsafe2;
        boolean z3;
        boolean z4;
        int i18;
        zzgxn zzgxnVar4;
        Unsafe unsafe3;
        int i19;
        Object obj3;
        int i20;
        int i21;
        int i22;
        zzgxn zzgxnVar5;
        int i23;
        int i24;
        int iZzh3;
        int i25;
        int i26;
        int i27;
        Unsafe unsafe4;
        int i28;
        int i29;
        int iZzf;
        int iZzh4;
        int iZzh5;
        Object obj4;
        Unsafe unsafe5;
        int i30;
        int iZzj;
        int i31;
        int i32;
        int iZzk;
        int i33;
        int i34;
        int i35;
        Object obj5;
        zzhav<T> zzhavVar2 = this;
        Object obj6 = obj;
        byte[] bArr2 = bArr;
        i2 = i2;
        i3 = i3;
        zzgxn zzgxnVar6 = zzgxnVar;
        int i36 = 3;
        zzD(obj);
        Unsafe unsafe6 = zzb;
        int i37 = -1;
        int iZzl = i;
        int i38 = -1;
        int iZzs = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 1048575;
        while (true) {
            if (iZzl < i2) {
                int iZzi = iZzl + 1;
                int i42 = bArr2[iZzl];
                if (i42 < 0) {
                    iZzi = zzgxo.zzi(i42, bArr2, iZzi, zzgxnVar6);
                    i42 = zzgxnVar6.zza;
                }
                int i43 = i42 >>> 3;
                iZzs = i43 > i38 ? (i43 < zzhavVar2.zze || i43 > zzhavVar2.zzf) ? i37 : zzhavVar2.zzs(i43, iZzs / i36) : zzhavVar2.zzq(i43);
                if (iZzs == i37) {
                    i7 = i36;
                    i4 = i3;
                    i8 = i37;
                    iZzs = 0;
                    obj2 = obj6;
                    zzhavVar = zzhavVar2;
                    zzgxnVar2 = zzgxnVar6;
                    i9 = iZzi;
                    i10 = i42;
                    Unsafe unsafe7 = unsafe6;
                    i11 = i43;
                    unsafe = unsafe7;
                } else {
                    int i44 = i42 & 7;
                    int[] iArr = zzhavVar2.zzc;
                    int i45 = iArr[iZzs + 1];
                    int iZzt = zzt(i45);
                    long j = i45 & 1048575;
                    int i46 = i42;
                    if (iZzt <= 17) {
                        int i47 = iArr[iZzs + 2];
                        int i48 = 1 << (i47 >>> 20);
                        int i49 = 1048575;
                        int i50 = i47 & 1048575;
                        if (i50 != i41) {
                            if (i41 != 1048575) {
                                unsafe6.putInt(obj6, i41, i39);
                                i49 = 1048575;
                            }
                            i13 = i50 == i49 ? 0 : unsafe6.getInt(obj6, i50);
                            i41 = i50;
                        } else {
                            i13 = i39;
                            i41 = i41;
                        }
                        switch (iZzt) {
                            case 0:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                z = true;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 1) {
                                    iZzh = iZzi + 8;
                                    i13 |= i48;
                                    zzhce.zzr(obj6, j, Double.longBitsToDouble(zzgxo.zzn(bArr2, iZzi)));
                                    z3 = z;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh;
                                    i41 = i41;
                                    i39 = i13;
                                    i36 = 3;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 1:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                z = true;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 5) {
                                    iZzh = iZzi + 4;
                                    i13 |= i48;
                                    zzhce.zzs(obj6, j, Float.intBitsToFloat(zzgxo.zzb(bArr2, iZzi)));
                                    z3 = z;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh;
                                    i41 = i41;
                                    i39 = i13;
                                    i36 = 3;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 2:
                            case 3:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 0) {
                                    i16 = i13 | i48;
                                    int iZzk2 = zzgxo.zzk(bArr2, iZzi, zzgxnVar3);
                                    unsafe6.putLong(obj, j, zzgxnVar3.zzb);
                                    i2 = i2;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15 == true ? 1 : 0;
                                    iZzl = iZzk2;
                                    i37 = -1;
                                    i36 = 3;
                                    i39 = i16;
                                    i38 = i14;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 4:
                            case 11:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                z2 = true;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 0) {
                                    i17 = i13 | i48;
                                    iZzh2 = zzgxo.zzh(bArr2, iZzi, zzgxnVar3);
                                    unsafe6.putInt(obj6, j, zzgxnVar3.zza);
                                    zzgxnVar6 = zzgxnVar3;
                                    z4 = z2;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh2;
                                    i36 = 3;
                                    i39 = i17;
                                    i41 = i41;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 5:
                            case 14:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 1) {
                                    int i51 = i48 | i13;
                                    unsafe6.putLong(obj, j, zzgxo.zzn(bArr2, iZzi));
                                    i2 = i2;
                                    i3 = i3;
                                    zzgxnVar6 = zzgxnVar3;
                                    iZzl = iZzi + 8;
                                    i40 = i15 == true ? 1 : 0;
                                    i41 = i41;
                                    i38 = i14;
                                    i36 = 3;
                                    i39 = i51;
                                    i37 = -1;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 6:
                            case 13:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                z = true;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 5) {
                                    iZzh = iZzi + 4;
                                    i13 |= i48;
                                    unsafe6.putInt(obj6, j, zzgxo.zzb(bArr2, iZzi));
                                    z3 = z;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh;
                                    i41 = i41;
                                    i39 = i13;
                                    i36 = 3;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 7:
                                zzgxnVar3 = zzgxnVar;
                                i14 = i43;
                                z2 = true;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 0) {
                                    i17 = i13 | i48;
                                    iZzh2 = zzgxo.zzk(bArr2, iZzi, zzgxnVar3);
                                    zzhce.zzp(obj6, j, zzgxnVar3.zzb != 0);
                                    zzgxnVar6 = zzgxnVar3;
                                    z4 = z2;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh2;
                                    i36 = 3;
                                    i39 = i17;
                                    i41 = i41;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 8:
                                zzgxnVar3 = zzgxnVar;
                                z = true;
                                i8 = -1;
                                i14 = i43;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 2) {
                                    if (zzM(i45)) {
                                        iZzh = zzgxo.zzh(bArr2, iZzi, zzgxnVar3);
                                        int i52 = zzgxnVar3.zza;
                                        if (i52 < 0) {
                                            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i13 |= i48;
                                        if (i52 == 0) {
                                            zzgxnVar3.zzc = "";
                                        } else {
                                            zzgxnVar3.zzc = zzhcj.zzh(bArr2, iZzh, i52);
                                            iZzh += i52;
                                        }
                                    } else {
                                        int i53 = i13 | i48;
                                        int iZzh6 = zzgxo.zzh(bArr2, iZzi, zzgxnVar3);
                                        int i54 = zzgxnVar3.zza;
                                        if (i54 < 0) {
                                            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        if (i54 == 0) {
                                            zzgxnVar3.zzc = "";
                                        } else {
                                            zzgxnVar3.zzc = new String(bArr2, iZzh6, i54, zzgzu.zza);
                                            iZzh6 += i54;
                                        }
                                        int i55 = iZzh6;
                                        i13 = i53;
                                        iZzh = i55;
                                    }
                                    unsafe6.putObject(obj6, j, zzgxnVar3.zzc);
                                    z3 = z;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh;
                                    i41 = i41;
                                    i39 = i13;
                                    i36 = 3;
                                } else {
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 9:
                                zzgxnVar3 = zzgxnVar;
                                unsafe2 = unsafe6;
                                i8 = -1;
                                i14 = i43;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 2) {
                                    i16 = i13 | i48;
                                    Object objZzA = zzhavVar2.zzA(obj6, iZzs);
                                    unsafe6 = unsafe2;
                                    i2 = i2;
                                    int iZzm = zzgxo.zzm(objZzA, zzhavVar2.zzx(iZzs), bArr, iZzi, i2, zzgxnVar);
                                    zzhavVar2.zzJ(obj6, iZzs, objZzA);
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15 == true ? 1 : 0;
                                    i37 = -1;
                                    i36 = 3;
                                    iZzl = iZzm;
                                    i39 = i16;
                                    i38 = i14;
                                } else {
                                    unsafe6 = unsafe2;
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 10:
                                zzgxnVar3 = zzgxnVar;
                                unsafe2 = unsafe6;
                                i8 = -1;
                                i14 = i43;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 2) {
                                    int i56 = i13 | i48;
                                    bArr2 = bArr;
                                    int iZza = zzgxo.zza(bArr2, iZzi, zzgxnVar3);
                                    unsafe2.putObject(obj6, j, zzgxnVar3.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    unsafe6 = unsafe2;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15 == true ? 1 : 0;
                                    i41 = i41;
                                    i38 = i14;
                                    i37 = -1;
                                    i39 = i56;
                                    iZzl = iZza;
                                    i36 = 3;
                                } else {
                                    bArr2 = bArr;
                                    unsafe6 = unsafe2;
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 12:
                                zzgxnVar3 = zzgxnVar;
                                unsafe2 = unsafe6;
                                z3 = true;
                                i8 = -1;
                                i14 = i43;
                                i15 = i46 == true ? 1 : 0;
                                if (i44 == 0) {
                                    iZzh = zzgxo.zzh(bArr2, iZzi, zzgxnVar3);
                                    int i57 = zzgxnVar3.zza;
                                    zzgzn zzgznVarZzw = zzhavVar2.zzw(iZzs);
                                    if ((i45 & Integer.MIN_VALUE) == 0 || zzgznVarZzw == null || zzgznVarZzw.zza(i57)) {
                                        i13 |= i48;
                                        unsafe2.putInt(obj6, j, i57);
                                    } else {
                                        zzd(obj).zzj(i15 == true ? 1 : 0, Long.valueOf(i57));
                                    }
                                    bArr2 = bArr;
                                    unsafe6 = unsafe2;
                                    zzgxnVar6 = zzgxnVar3;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh;
                                    i41 = i41;
                                    i39 = i13;
                                    i36 = 3;
                                } else {
                                    bArr2 = bArr;
                                    unsafe6 = unsafe2;
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 15:
                                zzgxnVar3 = zzgxnVar;
                                z4 = true;
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                Unsafe unsafe8 = unsafe6;
                                i14 = i43;
                                if (i44 == 0) {
                                    i17 = i13 | i48;
                                    iZzh2 = zzgxo.zzh(bArr2, iZzi, zzgxnVar3);
                                    unsafe8.putInt(obj6, j, zzgyf.zzD(zzgxnVar3.zza));
                                    zzgxnVar6 = zzgxnVar3;
                                    unsafe6 = unsafe8;
                                    i40 = i15;
                                    i38 = i14;
                                    i37 = i8;
                                    iZzl = iZzh2;
                                    i36 = 3;
                                    i39 = i17;
                                    i41 = i41;
                                } else {
                                    unsafe6 = unsafe8;
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            case 16:
                                i8 = -1;
                                i15 = i46 == true ? 1 : 0;
                                Unsafe unsafe9 = unsafe6;
                                if (i44 == 0) {
                                    int i58 = i13 | i48;
                                    int iZzk3 = zzgxo.zzk(bArr2, iZzi, zzgxnVar);
                                    unsafe9.putLong(obj, j, zzgyf.zzF(zzgxnVar.zzb));
                                    unsafe6 = unsafe9;
                                    i2 = i2;
                                    i3 = i3;
                                    zzgxnVar6 = zzgxnVar;
                                    i40 = i15 == true ? 1 : 0;
                                    i38 = i43;
                                    i37 = -1;
                                    i36 = 3;
                                    i39 = i58;
                                    iZzl = iZzk3;
                                    i41 = i41;
                                } else {
                                    i14 = i43;
                                    unsafe6 = unsafe9;
                                    zzgxnVar3 = zzgxnVar;
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                            default:
                                if (i44 == 3) {
                                    int i59 = i13 | i48;
                                    Object objZzA2 = zzhavVar2.zzA(obj6, iZzs);
                                    iZzl = zzgxo.zzl(objZzA2, zzhavVar2.zzx(iZzs), bArr, iZzi, i2, (i43 << 3) | 4, zzgxnVar);
                                    zzhavVar2.zzJ(obj6, iZzs, objZzA2);
                                    unsafe6 = unsafe6;
                                    i36 = 3;
                                    i38 = i43;
                                    i40 = i46 == true ? 1 : 0;
                                    iZzs = iZzs;
                                    i41 = i41;
                                    i37 = -1;
                                    i2 = i2;
                                    i3 = i3;
                                    zzgxnVar6 = zzgxnVar;
                                    i39 = i59;
                                } else {
                                    i8 = -1;
                                    zzgxnVar3 = zzgxnVar;
                                    i14 = i43;
                                    i15 = i46 == true ? 1 : 0;
                                    i4 = i3;
                                    i9 = iZzi;
                                    obj2 = obj6;
                                    i10 = i15;
                                    unsafe = unsafe6;
                                    i41 = i41;
                                    i11 = i14;
                                    i7 = 3;
                                    i39 = i13;
                                    zzhavVar = zzhavVar2;
                                    zzgxnVar2 = zzgxnVar3;
                                }
                                break;
                        }
                    } else {
                        i8 = -1;
                        if (iZzt != 27) {
                            i18 = i41;
                            unsafe3 = unsafe6;
                            int i60 = i43;
                            int i61 = i46 == true ? 1 : 0;
                            if (iZzt <= 49) {
                                long j2 = i45;
                                zzgzt zzgztVar = (zzgzt) unsafe3.getObject(obj6, j);
                                if (!zzgztVar.zzc()) {
                                    int size = zzgztVar.size();
                                    zzgzt zzgztVarZzf = zzgztVar.zzf(size + size);
                                    unsafe3.putObject(obj6, j, zzgztVarZzf);
                                    zzgztVar = zzgztVarZzf;
                                }
                                switch (iZzt) {
                                    case 18:
                                    case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                        int i62 = iZzi;
                                        i60 = i60;
                                        i22 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        if (i44 == 2) {
                                            zzgyo zzgyoVar = (zzgyo) zzgztVar;
                                            iZzh3 = zzgxo.zzh(bArr2, i62, zzgxnVar5);
                                            int i63 = zzgxnVar5.zza;
                                            int i64 = iZzh3 + i63;
                                            if (i64 > bArr2.length) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgyoVar.zzi((i63 / 8) + zzgyoVar.size());
                                            while (iZzh3 < i64) {
                                                zzgyoVar.zzh(Double.longBitsToDouble(zzgxo.zzn(bArr2, iZzh3)));
                                                iZzh3 += 8;
                                                i62 = i62;
                                            }
                                            i24 = i62;
                                            if (iZzh3 != i64) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else {
                                            i24 = i62;
                                            if (i44 == 1) {
                                                iZzh3 = i24 + 8;
                                                zzgyo zzgyoVar2 = (zzgyo) zzgztVar;
                                                zzgyoVar2.zzh(Double.longBitsToDouble(zzgxo.zzn(bArr2, i24)));
                                                while (iZzh3 < i22) {
                                                    int iZzh7 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar5);
                                                    if (i61 == zzgxnVar5.zza) {
                                                        zzgyoVar2.zzh(Double.longBitsToDouble(zzgxo.zzn(bArr2, iZzh7)));
                                                        iZzh3 = iZzh7 + 8;
                                                    }
                                                }
                                            } else {
                                                iZzh3 = i24;
                                            }
                                        }
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 19:
                                    case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                        i25 = iZzi;
                                        i60 = i60;
                                        i22 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        if (i44 != 2) {
                                            if (i44 == 5) {
                                                iZzh3 = i25 + 4;
                                                zzgyy zzgyyVar = (zzgyy) zzgztVar;
                                                zzgyyVar.zzh(Float.intBitsToFloat(zzgxo.zzb(bArr2, i25)));
                                                while (iZzh3 < i22) {
                                                    int iZzh8 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar5);
                                                    if (i61 == zzgxnVar5.zza) {
                                                        zzgyyVar.zzh(Float.intBitsToFloat(zzgxo.zzb(bArr2, iZzh8)));
                                                        iZzh3 = iZzh8 + 4;
                                                    }
                                                }
                                            }
                                            i24 = i25;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        } else {
                                            zzgyy zzgyyVar2 = (zzgyy) zzgztVar;
                                            iZzh3 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                            int i65 = zzgxnVar5.zza;
                                            int i66 = iZzh3 + i65;
                                            if (i66 > bArr2.length) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgyyVar2.zzi((i65 / 4) + zzgyyVar2.size());
                                            while (iZzh3 < i66) {
                                                zzgyyVar2.zzh(Float.intBitsToFloat(zzgxo.zzb(bArr2, iZzh3)));
                                                iZzh3 += 4;
                                            }
                                            if (iZzh3 != i66) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i24 = i25;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                    case 38:
                                        i25 = iZzi;
                                        i60 = i60;
                                        i22 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        if (i44 != 2) {
                                            if (i44 == 0) {
                                                zzhah zzhahVar = (zzhah) zzgztVar;
                                                iZzh3 = zzgxo.zzk(bArr2, i25, zzgxnVar5);
                                                zzhahVar.zzg(zzgxnVar5.zzb);
                                                while (iZzh3 < i22) {
                                                    int iZzh9 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar5);
                                                    if (i61 == zzgxnVar5.zza) {
                                                        iZzh3 = zzgxo.zzk(bArr2, iZzh9, zzgxnVar5);
                                                        zzhahVar.zzg(zzgxnVar5.zzb);
                                                    }
                                                }
                                            }
                                            i24 = i25;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        } else {
                                            zzhah zzhahVar2 = (zzhah) zzgztVar;
                                            iZzh3 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                            int i67 = zzgxnVar5.zza + iZzh3;
                                            while (iZzh3 < i67) {
                                                iZzh3 = zzgxo.zzk(bArr2, iZzh3, zzgxnVar5);
                                                zzhahVar2.zzg(zzgxnVar5.zzb);
                                            }
                                            if (iZzh3 != i67) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i24 = i25;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                    case 43:
                                        i25 = iZzi;
                                        i26 = i60;
                                        i27 = i61 == true ? 1 : 0;
                                        unsafe4 = unsafe3;
                                        i28 = iZzs;
                                        i29 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        if (i44 == 2) {
                                            iZzf = zzgxo.zzf(bArr2, i25, zzgztVar, zzgxnVar5);
                                            i23 = i28;
                                            iZzh3 = iZzf;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            i24 = i25;
                                        } else if (i44 == 0) {
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i24 = i25;
                                            i22 = i29;
                                            i61 = i27 == true ? 1 : 0;
                                            iZzh3 = zzgxo.zzj(i27 == true ? 1 : 0, bArr, i24, i2, zzgztVar, zzgxnVar);
                                            i60 = i26;
                                        } else {
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            i24 = i25;
                                            iZzh3 = i24;
                                        }
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                    case 32:
                                    case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    case 46:
                                        i25 = iZzi;
                                        i26 = i60;
                                        i27 = i61 == true ? 1 : 0;
                                        unsafe4 = unsafe3;
                                        i28 = iZzs;
                                        i29 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        if (i44 != 2) {
                                            if (i44 == 1) {
                                                iZzf = i25 + 8;
                                                zzhah zzhahVar3 = (zzhah) zzgztVar;
                                                zzhahVar3.zzg(zzgxo.zzn(bArr2, i25));
                                                while (iZzf < i29) {
                                                    int iZzh10 = zzgxo.zzh(bArr2, iZzf, zzgxnVar5);
                                                    if (i27 != zzgxnVar5.zza) {
                                                        i23 = i28;
                                                        iZzh3 = iZzf;
                                                        unsafe3 = unsafe4;
                                                        i22 = i29;
                                                        i61 = i27;
                                                        i60 = i26;
                                                        i24 = i25;
                                                        if (iZzh3 != i24) {
                                                            zzhavVar = this;
                                                            obj2 = obj;
                                                            i4 = i3;
                                                            i9 = iZzh3;
                                                            zzgxnVar2 = zzgxnVar5;
                                                            i7 = 3;
                                                            i11 = i60;
                                                            i10 = i61;
                                                            iZzs = i23;
                                                            unsafe = unsafe3;
                                                            i41 = i18;
                                                        } else {
                                                            zzhavVar2 = this;
                                                            obj6 = obj;
                                                            i3 = i3;
                                                            i38 = i60;
                                                            i2 = i22;
                                                            i40 = i61;
                                                            iZzs = i23;
                                                            zzgxnVar6 = zzgxnVar5;
                                                            i37 = -1;
                                                            i36 = 3;
                                                            iZzl = iZzh3;
                                                            unsafe6 = unsafe3;
                                                            i41 = i18;
                                                        }
                                                    } else {
                                                        zzhahVar3.zzg(zzgxo.zzn(bArr2, iZzh10));
                                                        iZzf = iZzh10 + 8;
                                                    }
                                                    break;
                                                }
                                                i23 = i28;
                                                iZzh3 = iZzf;
                                                unsafe3 = unsafe4;
                                                i22 = i29;
                                                i61 = i27;
                                                i60 = i26;
                                                i24 = i25;
                                                if (iZzh3 != i24) {
                                                    zzhavVar = this;
                                                    obj2 = obj;
                                                    i4 = i3;
                                                    i9 = iZzh3;
                                                    zzgxnVar2 = zzgxnVar5;
                                                    i7 = 3;
                                                    i11 = i60;
                                                    i10 = i61;
                                                    iZzs = i23;
                                                    unsafe = unsafe3;
                                                    i41 = i18;
                                                } else {
                                                    zzhavVar2 = this;
                                                    obj6 = obj;
                                                    i3 = i3;
                                                    i38 = i60;
                                                    i2 = i22;
                                                    i40 = i61;
                                                    iZzs = i23;
                                                    zzgxnVar6 = zzgxnVar5;
                                                    i37 = -1;
                                                    i36 = 3;
                                                    iZzl = iZzh3;
                                                    unsafe6 = unsafe3;
                                                    i41 = i18;
                                                }
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            i24 = i25;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                            break;
                                        } else {
                                            zzhah zzhahVar4 = (zzhah) zzgztVar;
                                            iZzh4 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                            int i68 = zzgxnVar5.zza;
                                            int i69 = iZzh4 + i68;
                                            if (i69 > bArr2.length) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzhahVar4.zzi((i68 / 8) + zzhahVar4.size());
                                            while (iZzh4 < i69) {
                                                zzhahVar4.zzg(zzgxo.zzn(bArr2, iZzh4));
                                                iZzh4 += 8;
                                            }
                                            if (iZzh4 != i69) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            iZzh3 = iZzh4;
                                            i24 = i25;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                    case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                    case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                        i25 = iZzi;
                                        i26 = i60;
                                        i27 = i61 == true ? 1 : 0;
                                        unsafe4 = unsafe3;
                                        i28 = iZzs;
                                        i29 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        if (i44 != 2) {
                                            if (i44 == 5) {
                                                iZzf = i25 + 4;
                                                zzgzi zzgziVar = (zzgzi) zzgztVar;
                                                zzgziVar.zzi(zzgxo.zzb(bArr2, i25));
                                                while (iZzf < i29) {
                                                    int iZzh11 = zzgxo.zzh(bArr2, iZzf, zzgxnVar5);
                                                    if (i27 != zzgxnVar5.zza) {
                                                        i23 = i28;
                                                        iZzh3 = iZzf;
                                                        unsafe3 = unsafe4;
                                                        i22 = i29;
                                                        i61 = i27;
                                                        i60 = i26;
                                                        i24 = i25;
                                                        if (iZzh3 != i24) {
                                                            zzhavVar = this;
                                                            obj2 = obj;
                                                            i4 = i3;
                                                            i9 = iZzh3;
                                                            zzgxnVar2 = zzgxnVar5;
                                                            i7 = 3;
                                                            i11 = i60;
                                                            i10 = i61;
                                                            iZzs = i23;
                                                            unsafe = unsafe3;
                                                            i41 = i18;
                                                        } else {
                                                            zzhavVar2 = this;
                                                            obj6 = obj;
                                                            i3 = i3;
                                                            i38 = i60;
                                                            i2 = i22;
                                                            i40 = i61;
                                                            iZzs = i23;
                                                            zzgxnVar6 = zzgxnVar5;
                                                            i37 = -1;
                                                            i36 = 3;
                                                            iZzl = iZzh3;
                                                            unsafe6 = unsafe3;
                                                            i41 = i18;
                                                        }
                                                    } else {
                                                        zzgziVar.zzi(zzgxo.zzb(bArr2, iZzh11));
                                                        iZzf = iZzh11 + 4;
                                                    }
                                                    break;
                                                }
                                                i23 = i28;
                                                iZzh3 = iZzf;
                                                unsafe3 = unsafe4;
                                                i22 = i29;
                                                i61 = i27;
                                                i60 = i26;
                                                i24 = i25;
                                                if (iZzh3 != i24) {
                                                    zzhavVar = this;
                                                    obj2 = obj;
                                                    i4 = i3;
                                                    i9 = iZzh3;
                                                    zzgxnVar2 = zzgxnVar5;
                                                    i7 = 3;
                                                    i11 = i60;
                                                    i10 = i61;
                                                    iZzs = i23;
                                                    unsafe = unsafe3;
                                                    i41 = i18;
                                                } else {
                                                    zzhavVar2 = this;
                                                    obj6 = obj;
                                                    i3 = i3;
                                                    i38 = i60;
                                                    i2 = i22;
                                                    i40 = i61;
                                                    iZzs = i23;
                                                    zzgxnVar6 = zzgxnVar5;
                                                    i37 = -1;
                                                    i36 = 3;
                                                    iZzl = iZzh3;
                                                    unsafe6 = unsafe3;
                                                    i41 = i18;
                                                }
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            i24 = i25;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                            break;
                                        } else {
                                            zzgzi zzgziVar2 = (zzgzi) zzgztVar;
                                            iZzh4 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                            int i70 = zzgxnVar5.zza;
                                            int i71 = iZzh4 + i70;
                                            if (i71 > bArr2.length) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgziVar2.zzj((i70 / 4) + zzgziVar2.size());
                                            while (iZzh4 < i71) {
                                                zzgziVar2.zzi(zzgxo.zzb(bArr2, iZzh4));
                                                iZzh4 += 4;
                                            }
                                            if (iZzh4 != i71) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            iZzh3 = iZzh4;
                                            i24 = i25;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i25 = iZzi;
                                        i26 = i60;
                                        i27 = i61 == true ? 1 : 0;
                                        unsafe4 = unsafe3;
                                        i28 = iZzs;
                                        i29 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        if (i44 != 2) {
                                            if (i44 == 0) {
                                                zzgxp zzgxpVar = (zzgxp) zzgztVar;
                                                iZzf = zzgxo.zzk(bArr2, i25, zzgxnVar5);
                                                zzgxpVar.zzg(zzgxnVar5.zzb != 0);
                                                while (iZzf < i29) {
                                                    int iZzh12 = zzgxo.zzh(bArr2, iZzf, zzgxnVar5);
                                                    if (i27 != zzgxnVar5.zza) {
                                                        i23 = i28;
                                                        iZzh3 = iZzf;
                                                        unsafe3 = unsafe4;
                                                        i22 = i29;
                                                        i61 = i27;
                                                        i60 = i26;
                                                        i24 = i25;
                                                        if (iZzh3 != i24) {
                                                            zzhavVar = this;
                                                            obj2 = obj;
                                                            i4 = i3;
                                                            i9 = iZzh3;
                                                            zzgxnVar2 = zzgxnVar5;
                                                            i7 = 3;
                                                            i11 = i60;
                                                            i10 = i61;
                                                            iZzs = i23;
                                                            unsafe = unsafe3;
                                                            i41 = i18;
                                                        } else {
                                                            zzhavVar2 = this;
                                                            obj6 = obj;
                                                            i3 = i3;
                                                            i38 = i60;
                                                            i2 = i22;
                                                            i40 = i61;
                                                            iZzs = i23;
                                                            zzgxnVar6 = zzgxnVar5;
                                                            i37 = -1;
                                                            i36 = 3;
                                                            iZzl = iZzh3;
                                                            unsafe6 = unsafe3;
                                                            i41 = i18;
                                                        }
                                                    } else {
                                                        iZzf = zzgxo.zzk(bArr2, iZzh12, zzgxnVar5);
                                                        zzgxpVar.zzg(zzgxnVar5.zzb != 0);
                                                    }
                                                    break;
                                                }
                                                i23 = i28;
                                                iZzh3 = iZzf;
                                                unsafe3 = unsafe4;
                                                i22 = i29;
                                                i61 = i27;
                                                i60 = i26;
                                                i24 = i25;
                                                if (iZzh3 != i24) {
                                                    zzhavVar = this;
                                                    obj2 = obj;
                                                    i4 = i3;
                                                    i9 = iZzh3;
                                                    zzgxnVar2 = zzgxnVar5;
                                                    i7 = 3;
                                                    i11 = i60;
                                                    i10 = i61;
                                                    iZzs = i23;
                                                    unsafe = unsafe3;
                                                    i41 = i18;
                                                } else {
                                                    zzhavVar2 = this;
                                                    obj6 = obj;
                                                    i3 = i3;
                                                    i38 = i60;
                                                    i2 = i22;
                                                    i40 = i61;
                                                    iZzs = i23;
                                                    zzgxnVar6 = zzgxnVar5;
                                                    i37 = -1;
                                                    i36 = 3;
                                                    iZzl = iZzh3;
                                                    unsafe6 = unsafe3;
                                                    i41 = i18;
                                                }
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            i24 = i25;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                            break;
                                        } else {
                                            zzgxp zzgxpVar2 = (zzgxp) zzgztVar;
                                            iZzh4 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                            int i72 = zzgxnVar5.zza + iZzh4;
                                            while (iZzh4 < i72) {
                                                iZzh4 = zzgxo.zzk(bArr2, iZzh4, zzgxnVar5);
                                                zzgxpVar2.zzg(zzgxnVar5.zzb != 0);
                                            }
                                            if (iZzh4 != i72) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i22 = i29;
                                            i61 = i27;
                                            i60 = i26;
                                            iZzh3 = iZzh4;
                                            i24 = i25;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        break;
                                    case 26:
                                        i25 = iZzi;
                                        i26 = i60;
                                        i27 = i61 == true ? 1 : 0;
                                        unsafe4 = unsafe3;
                                        i28 = iZzs;
                                        i29 = i2;
                                        zzgxnVar5 = zzgxnVar;
                                        if (i44 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzh5 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                                int i73 = zzgxnVar5.zza;
                                                if (i73 < 0) {
                                                    throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i73 == 0) {
                                                    obj4 = "";
                                                    zzgztVar.add(obj4);
                                                } else {
                                                    obj4 = "";
                                                    zzgztVar.add(new String(bArr2, iZzh5, i73, zzgzu.zza));
                                                    iZzh5 += i73;
                                                }
                                                while (iZzh5 < i29) {
                                                    int iZzh13 = zzgxo.zzh(bArr2, iZzh5, zzgxnVar5);
                                                    if (i27 == zzgxnVar5.zza) {
                                                        iZzh5 = zzgxo.zzh(bArr2, iZzh13, zzgxnVar5);
                                                        int i74 = zzgxnVar5.zza;
                                                        if (i74 < 0) {
                                                            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i74 == 0) {
                                                            zzgztVar.add(obj4);
                                                        } else {
                                                            zzgztVar.add(new String(bArr2, iZzh5, i74, zzgzu.zza));
                                                            iZzh5 += i74;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzh5 = zzgxo.zzh(bArr2, i25, zzgxnVar5);
                                                int i75 = zzgxnVar5.zza;
                                                if (i75 < 0) {
                                                    throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i75 == 0) {
                                                    zzgztVar.add("");
                                                } else {
                                                    int i76 = iZzh5 + i75;
                                                    if (!zzhcj.zzi(bArr2, iZzh5, i76)) {
                                                        throw new zzgzw("Protocol message had invalid UTF-8.");
                                                    }
                                                    zzgztVar.add(new String(bArr2, iZzh5, i75, zzgzu.zza));
                                                    iZzh5 = i76;
                                                }
                                                while (iZzh5 < i29) {
                                                    int iZzh14 = zzgxo.zzh(bArr2, iZzh5, zzgxnVar5);
                                                    if (i27 == zzgxnVar5.zza) {
                                                        iZzh5 = zzgxo.zzh(bArr2, iZzh14, zzgxnVar5);
                                                        int i77 = zzgxnVar5.zza;
                                                        if (i77 < 0) {
                                                            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i77 == 0) {
                                                            zzgztVar.add("");
                                                        } else {
                                                            int i78 = iZzh5 + i77;
                                                            if (!zzhcj.zzi(bArr2, iZzh5, i78)) {
                                                                throw new zzgzw("Protocol message had invalid UTF-8.");
                                                            }
                                                            zzgztVar.add(new String(bArr2, iZzh5, i77, zzgzu.zza));
                                                            iZzh5 = i78;
                                                        }
                                                    }
                                                }
                                            }
                                            i23 = i28;
                                            unsafe3 = unsafe4;
                                            i61 = i27;
                                            i24 = i25;
                                            iZzh3 = iZzh5;
                                            i22 = i29;
                                            i60 = i26;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        i23 = i28;
                                        unsafe3 = unsafe4;
                                        i22 = i29;
                                        i61 = i27;
                                        i60 = i26;
                                        i24 = i25;
                                        iZzh3 = i24;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                                        i25 = iZzi;
                                        unsafe5 = unsafe3;
                                        i30 = i2;
                                        if (i44 == 2) {
                                            zzhbl zzhblVarZzx = zzhavVar2.zzx(iZzs);
                                            i26 = i60;
                                            i27 = i61 == true ? 1 : 0;
                                            i29 = i30;
                                            unsafe4 = unsafe5;
                                            iZzh5 = zzgxo.zze(zzhblVarZzx, i61 == true ? 1 : 0, bArr, i25, i2, zzgztVar, zzgxnVar);
                                            i23 = iZzs;
                                            zzgxnVar5 = zzgxnVar;
                                            unsafe3 = unsafe4;
                                            i61 = i27;
                                            i24 = i25;
                                            iZzh3 = iZzh5;
                                            i22 = i29;
                                            i60 = i26;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        i24 = i25;
                                        i22 = i30;
                                        unsafe3 = unsafe5;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        iZzh3 = i24;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 28:
                                        i25 = iZzi;
                                        unsafe5 = unsafe3;
                                        i30 = i2;
                                        if (i44 == 2) {
                                            iZzh3 = zzgxo.zzh(bArr2, i25, zzgxnVar);
                                            int i79 = zzgxnVar.zza;
                                            if (i79 < 0) {
                                                throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i79 > bArr2.length - iZzh3) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i79 == 0) {
                                                zzgztVar.add(zzgxz.zzb);
                                            } else {
                                                zzgztVar.add(zzgxz.zzv(bArr2, iZzh3, i79));
                                                iZzh3 += i79;
                                            }
                                            while (iZzh3 < i30) {
                                                int iZzh15 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar);
                                                if (i61 != zzgxnVar.zza) {
                                                    i24 = i25;
                                                    i22 = i30;
                                                    unsafe3 = unsafe5;
                                                    zzgxnVar5 = zzgxnVar;
                                                    i23 = iZzs;
                                                    if (iZzh3 != i24) {
                                                        zzhavVar = this;
                                                        obj2 = obj;
                                                        i4 = i3;
                                                        i9 = iZzh3;
                                                        zzgxnVar2 = zzgxnVar5;
                                                        i7 = 3;
                                                        i11 = i60;
                                                        i10 = i61;
                                                        iZzs = i23;
                                                        unsafe = unsafe3;
                                                        i41 = i18;
                                                    } else {
                                                        zzhavVar2 = this;
                                                        obj6 = obj;
                                                        i3 = i3;
                                                        i38 = i60;
                                                        i2 = i22;
                                                        i40 = i61;
                                                        iZzs = i23;
                                                        zzgxnVar6 = zzgxnVar5;
                                                        i37 = -1;
                                                        i36 = 3;
                                                        iZzl = iZzh3;
                                                        unsafe6 = unsafe3;
                                                        i41 = i18;
                                                    }
                                                    break;
                                                } else {
                                                    iZzh3 = zzgxo.zzh(bArr2, iZzh15, zzgxnVar);
                                                    int i80 = zzgxnVar.zza;
                                                    if (i80 < 0) {
                                                        throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i80 > bArr2.length - iZzh3) {
                                                        throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i80 == 0) {
                                                        zzgztVar.add(zzgxz.zzb);
                                                    } else {
                                                        zzgztVar.add(zzgxz.zzv(bArr2, iZzh3, i80));
                                                        iZzh3 += i80;
                                                    }
                                                }
                                            }
                                            i24 = i25;
                                            i22 = i30;
                                            unsafe3 = unsafe5;
                                            zzgxnVar5 = zzgxnVar;
                                            i23 = iZzs;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        i24 = i25;
                                        i22 = i30;
                                        unsafe3 = unsafe5;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        iZzh3 = i24;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 30:
                                    case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                        i25 = iZzi;
                                        unsafe5 = unsafe3;
                                        i30 = i2;
                                        if (i44 != 2) {
                                            if (i44 == 0) {
                                                iZzj = zzgxo.zzj(i61 == true ? 1 : 0, bArr, i25, i2, zzgztVar, zzgxnVar);
                                            }
                                            i24 = i25;
                                            i22 = i30;
                                            unsafe3 = unsafe5;
                                            zzgxnVar5 = zzgxnVar;
                                            i23 = iZzs;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        } else {
                                            iZzj = zzgxo.zzf(bArr2, i25, zzgztVar, zzgxnVar);
                                        }
                                        int i81 = iZzj;
                                        zzhbn.zzn(obj, i60, zzgztVar, zzhavVar2.zzw(iZzs), null, zzhavVar2.zzm);
                                        i24 = i25;
                                        iZzh3 = i81;
                                        i22 = i30;
                                        unsafe3 = unsafe5;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        i25 = iZzi;
                                        unsafe5 = unsafe3;
                                        i30 = i2;
                                        if (i44 != 2) {
                                            if (i44 == 0) {
                                                zzgzi zzgziVar3 = (zzgzi) zzgztVar;
                                                iZzh3 = zzgxo.zzh(bArr2, i25, zzgxnVar);
                                                zzgziVar3.zzi(zzgyf.zzD(zzgxnVar.zza));
                                                while (iZzh3 < i30) {
                                                    int iZzh16 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar);
                                                    if (i61 == zzgxnVar.zza) {
                                                        iZzh3 = zzgxo.zzh(bArr2, iZzh16, zzgxnVar);
                                                        zzgziVar3.zzi(zzgyf.zzD(zzgxnVar.zza));
                                                    }
                                                }
                                            }
                                            i24 = i25;
                                            i22 = i30;
                                            unsafe3 = unsafe5;
                                            zzgxnVar5 = zzgxnVar;
                                            i23 = iZzs;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        } else {
                                            zzgzi zzgziVar4 = (zzgzi) zzgztVar;
                                            iZzh3 = zzgxo.zzh(bArr2, i25, zzgxnVar);
                                            int i82 = zzgxnVar.zza + iZzh3;
                                            while (iZzh3 < i82) {
                                                iZzh3 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar);
                                                zzgziVar4.zzi(zzgyf.zzD(zzgxnVar.zza));
                                            }
                                            if (iZzh3 != i82) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i24 = i25;
                                        i22 = i30;
                                        unsafe3 = unsafe5;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        i25 = iZzi;
                                        unsafe5 = unsafe3;
                                        i30 = i2;
                                        if (i44 != 2) {
                                            if (i44 == 0) {
                                                zzhah zzhahVar5 = (zzhah) zzgztVar;
                                                iZzh3 = zzgxo.zzk(bArr2, i25, zzgxnVar);
                                                zzhahVar5.zzg(zzgyf.zzF(zzgxnVar.zzb));
                                                while (iZzh3 < i30) {
                                                    int iZzh17 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar);
                                                    if (i61 == zzgxnVar.zza) {
                                                        iZzh3 = zzgxo.zzk(bArr2, iZzh17, zzgxnVar);
                                                        zzhahVar5.zzg(zzgyf.zzF(zzgxnVar.zzb));
                                                    }
                                                }
                                            }
                                            i24 = i25;
                                            i22 = i30;
                                            unsafe3 = unsafe5;
                                            zzgxnVar5 = zzgxnVar;
                                            i23 = iZzs;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        } else {
                                            zzhah zzhahVar6 = (zzhah) zzgztVar;
                                            iZzh3 = zzgxo.zzh(bArr2, i25, zzgxnVar);
                                            int i83 = zzgxnVar.zza + iZzh3;
                                            while (iZzh3 < i83) {
                                                iZzh3 = zzgxo.zzk(bArr2, iZzh3, zzgxnVar);
                                                zzhahVar6.zzg(zzgyf.zzF(zzgxnVar.zzb));
                                            }
                                            if (iZzh3 != i83) {
                                                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i24 = i25;
                                        i22 = i30;
                                        unsafe3 = unsafe5;
                                        zzgxnVar5 = zzgxnVar;
                                        i23 = iZzs;
                                        if (iZzh3 != i24) {
                                            zzhavVar = this;
                                            obj2 = obj;
                                            i4 = i3;
                                            i9 = iZzh3;
                                            zzgxnVar2 = zzgxnVar5;
                                            i7 = 3;
                                            i11 = i60;
                                            i10 = i61;
                                            iZzs = i23;
                                            unsafe = unsafe3;
                                            i41 = i18;
                                        } else {
                                            zzhavVar2 = this;
                                            obj6 = obj;
                                            i3 = i3;
                                            i38 = i60;
                                            i2 = i22;
                                            i40 = i61;
                                            iZzs = i23;
                                            zzgxnVar6 = zzgxnVar5;
                                            i37 = -1;
                                            i36 = 3;
                                            iZzl = iZzh3;
                                            unsafe6 = unsafe3;
                                            i41 = i18;
                                        }
                                        break;
                                    default:
                                        if (i44 == 3) {
                                            int i84 = ((i61 == true ? 1 : 0) & (-8)) | 4;
                                            zzhbl zzhblVarZzx2 = zzhavVar2.zzx(iZzs);
                                            i25 = iZzi;
                                            iZzh3 = zzgxo.zzc(zzhblVarZzx2, bArr, iZzi, i2, i84, zzgxnVar);
                                            zzgztVar.add(zzgxnVar.zzc);
                                            int i85 = i2;
                                            while (iZzh3 < i85) {
                                                int iZzh18 = zzgxo.zzh(bArr2, iZzh3, zzgxnVar);
                                                if (i61 != zzgxnVar.zza) {
                                                    unsafe5 = unsafe3;
                                                    i30 = i85;
                                                    i24 = i25;
                                                    i22 = i30;
                                                    unsafe3 = unsafe5;
                                                    zzgxnVar5 = zzgxnVar;
                                                    i23 = iZzs;
                                                    if (iZzh3 != i24) {
                                                        zzhavVar = this;
                                                        obj2 = obj;
                                                        i4 = i3;
                                                        i9 = iZzh3;
                                                        zzgxnVar2 = zzgxnVar5;
                                                        i7 = 3;
                                                        i11 = i60;
                                                        i10 = i61;
                                                        iZzs = i23;
                                                        unsafe = unsafe3;
                                                        i41 = i18;
                                                    } else {
                                                        zzhavVar2 = this;
                                                        obj6 = obj;
                                                        i3 = i3;
                                                        i38 = i60;
                                                        i2 = i22;
                                                        i40 = i61;
                                                        iZzs = i23;
                                                        zzgxnVar6 = zzgxnVar5;
                                                        i37 = -1;
                                                        i36 = 3;
                                                        iZzl = iZzh3;
                                                        unsafe6 = unsafe3;
                                                        i41 = i18;
                                                    }
                                                } else {
                                                    iZzh3 = zzgxo.zzc(zzhblVarZzx2, bArr, iZzh18, i2, i84, zzgxnVar);
                                                    zzgztVar.add(zzgxnVar.zzc);
                                                    i85 = i85;
                                                    unsafe3 = unsafe3;
                                                }
                                                break;
                                            }
                                            unsafe5 = unsafe3;
                                            i30 = i85;
                                            i24 = i25;
                                            i22 = i30;
                                            unsafe3 = unsafe5;
                                            zzgxnVar5 = zzgxnVar;
                                            i23 = iZzs;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        } else {
                                            i24 = iZzi;
                                            i22 = i2;
                                            zzgxnVar5 = zzgxnVar;
                                            i23 = iZzs;
                                            iZzh3 = i24;
                                            if (iZzh3 != i24) {
                                                zzhavVar = this;
                                                obj2 = obj;
                                                i4 = i3;
                                                i9 = iZzh3;
                                                zzgxnVar2 = zzgxnVar5;
                                                i7 = 3;
                                                i11 = i60;
                                                i10 = i61;
                                                iZzs = i23;
                                                unsafe = unsafe3;
                                                i41 = i18;
                                            } else {
                                                zzhavVar2 = this;
                                                obj6 = obj;
                                                i3 = i3;
                                                i38 = i60;
                                                i2 = i22;
                                                i40 = i61;
                                                iZzs = i23;
                                                zzgxnVar6 = zzgxnVar5;
                                                i37 = -1;
                                                i36 = 3;
                                                iZzl = iZzh3;
                                                unsafe6 = unsafe3;
                                                i41 = i18;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                int i86 = iZzi;
                                i11 = i60;
                                i20 = i61 == true ? 1 : 0;
                                zzgxnVar4 = zzgxnVar;
                                i21 = iZzs;
                                if (iZzt != 50) {
                                    zzhavVar = this;
                                    long j3 = iArr[i21 + 2] & 1048575;
                                    switch (iZzt) {
                                        case 51:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 1) {
                                                iZzk = i31 + 8;
                                                unsafe.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzgxo.zzn(bArr2, i31))));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 52:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 5) {
                                                iZzk = i31 + 4;
                                                unsafe.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzgxo.zzb(bArr2, i31))));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 0) {
                                                iZzk = zzgxo.zzk(bArr2, i31, zzgxnVar2);
                                                unsafe.putObject(obj2, j, Long.valueOf(zzgxnVar2.zzb));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 0) {
                                                iZzk = zzgxo.zzh(bArr2, i31, zzgxnVar2);
                                                unsafe.putObject(obj2, j, Integer.valueOf(zzgxnVar2.zza));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 1) {
                                                iZzk = i31 + 8;
                                                unsafe.putObject(obj2, j, Long.valueOf(zzgxo.zzn(bArr2, i31)));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 5) {
                                                iZzk = i31 + 4;
                                                unsafe.putObject(obj2, j, Integer.valueOf(zzgxo.zzb(bArr2, i31)));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 58:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 0) {
                                                iZzk = zzgxo.zzk(bArr2, i31, zzgxnVar2);
                                                unsafe.putObject(obj2, j, Boolean.valueOf(zzgxnVar2.zzb != 0));
                                                unsafe.putInt(obj2, j3, i11);
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 59:
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            obj2 = obj;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            if (i44 == 2) {
                                                int iZzh19 = zzgxo.zzh(bArr2, i31, zzgxnVar2);
                                                int i87 = zzgxnVar2.zza;
                                                if (i87 == 0) {
                                                    unsafe.putObject(obj2, j, "");
                                                } else {
                                                    int i88 = iZzh19 + i87;
                                                    if ((i45 & 536870912) != 0 && !zzhcj.zzi(bArr2, iZzh19, i88)) {
                                                        throw new zzgzw("Protocol message had invalid UTF-8.");
                                                    }
                                                    unsafe.putObject(obj2, j, new String(bArr2, iZzh19, i87, zzgzu.zza));
                                                    iZzh19 = i88;
                                                }
                                                unsafe.putInt(obj2, j3, i11);
                                                iZzk = iZzh19;
                                            } else {
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 60:
                                            i31 = i86;
                                            zzgxnVar2 = zzgxnVar4;
                                            unsafe = unsafe3;
                                            if (i44 == 2) {
                                                Object objZzB = zzhavVar.zzB(obj, i11, i21);
                                                i7 = 3;
                                                i11 = i11;
                                                obj2 = obj;
                                                iZzk = zzgxo.zzm(objZzB, zzhavVar.zzx(i21), bArr, i31, i2, zzgxnVar);
                                                zzhavVar.zzK(obj2, i11, i21, objZzB);
                                                i10 = i20 == true ? 1 : 0;
                                                i32 = i21;
                                            } else {
                                                obj2 = obj;
                                                i11 = i11;
                                                i7 = 3;
                                                i32 = i21;
                                                i10 = i20 == true ? 1 : 0;
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 61:
                                            i31 = i86;
                                            i33 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            unsafe = unsafe3;
                                            if (i44 == 2) {
                                                int iZza2 = zzgxo.zza(bArr2, i31, zzgxnVar2);
                                                unsafe.putObject(obj, j, zzgxnVar2.zzc);
                                                unsafe.putInt(obj, j3, i11);
                                                obj2 = obj;
                                                i32 = i21;
                                                iZzk = iZza2;
                                                i10 = i33;
                                                i7 = 3;
                                                if (iZzk != i31) {
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzk;
                                                    i40 = i10 == true ? 1 : 0;
                                                    zzgxnVar6 = zzgxnVar2;
                                                    zzhavVar2 = zzhavVar;
                                                    obj6 = obj2;
                                                    i38 = i11;
                                                    i37 = -1;
                                                    i41 = i18;
                                                    i36 = i7;
                                                    iZzs = i32;
                                                    unsafe6 = unsafe;
                                                } else {
                                                    i4 = i3;
                                                    i9 = iZzk;
                                                    i41 = i18;
                                                    iZzs = i32;
                                                }
                                            } else {
                                                obj2 = obj;
                                                i32 = i21;
                                                i10 = i33 == true ? 1 : 0;
                                                i7 = 3;
                                                iZzk = i31;
                                                if (iZzk != i31) {
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzk;
                                                    i40 = i10 == true ? 1 : 0;
                                                    zzgxnVar6 = zzgxnVar2;
                                                    zzhavVar2 = zzhavVar;
                                                    obj6 = obj2;
                                                    i38 = i11;
                                                    i37 = -1;
                                                    i41 = i18;
                                                    i36 = i7;
                                                    iZzs = i32;
                                                    unsafe6 = unsafe;
                                                } else {
                                                    i4 = i3;
                                                    i9 = iZzk;
                                                    i41 = i18;
                                                    iZzs = i32;
                                                }
                                            }
                                            break;
                                        case 63:
                                            i31 = i86;
                                            i34 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            i35 = i21;
                                            obj5 = obj;
                                            unsafe = unsafe3;
                                            if (i44 == 0) {
                                                iZzk = zzgxo.zzh(bArr2, i31, zzgxnVar2);
                                                int i89 = zzgxnVar2.zza;
                                                zzgzn zzgznVarZzw2 = zzhavVar.zzw(i35);
                                                if (zzgznVarZzw2 == null || zzgznVarZzw2.zza(i89)) {
                                                    i33 = i34 == true ? 1 : 0;
                                                    unsafe.putObject(obj5, j, Integer.valueOf(i89));
                                                    unsafe.putInt(obj5, j3, i11);
                                                } else {
                                                    zzhby zzhbyVarZzd = zzd(obj);
                                                    Long lValueOf = Long.valueOf(i89);
                                                    i33 = i34 == true ? 1 : 0;
                                                    zzhbyVarZzd.zzj(i33 == true ? 1 : 0, lValueOf);
                                                }
                                                obj2 = obj5;
                                                i32 = i35;
                                                i10 = i33;
                                                i7 = 3;
                                                if (iZzk != i31) {
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzk;
                                                    i40 = i10 == true ? 1 : 0;
                                                    zzgxnVar6 = zzgxnVar2;
                                                    zzhavVar2 = zzhavVar;
                                                    obj6 = obj2;
                                                    i38 = i11;
                                                    i37 = -1;
                                                    i41 = i18;
                                                    i36 = i7;
                                                    iZzs = i32;
                                                    unsafe6 = unsafe;
                                                } else {
                                                    i4 = i3;
                                                    i9 = iZzk;
                                                    i41 = i18;
                                                    iZzs = i32;
                                                }
                                            }
                                            obj2 = obj5;
                                            i32 = i35;
                                            i10 = i34;
                                            i7 = 3;
                                            iZzk = i31;
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                            i31 = i86;
                                            i34 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            i35 = i21;
                                            obj5 = obj;
                                            unsafe = unsafe3;
                                            if (i44 == 0) {
                                                iZzk = zzgxo.zzh(bArr2, i31, zzgxnVar2);
                                                unsafe.putObject(obj5, j, Integer.valueOf(zzgyf.zzD(zzgxnVar2.zza)));
                                                unsafe.putInt(obj5, j3, i11);
                                                obj2 = obj5;
                                                i32 = i35;
                                                i11 = i11;
                                                i10 = i34;
                                                i7 = 3;
                                                if (iZzk != i31) {
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzk;
                                                    i40 = i10 == true ? 1 : 0;
                                                    zzgxnVar6 = zzgxnVar2;
                                                    zzhavVar2 = zzhavVar;
                                                    obj6 = obj2;
                                                    i38 = i11;
                                                    i37 = -1;
                                                    i41 = i18;
                                                    i36 = i7;
                                                    iZzs = i32;
                                                    unsafe6 = unsafe;
                                                } else {
                                                    i4 = i3;
                                                    i9 = iZzk;
                                                    i41 = i18;
                                                    iZzs = i32;
                                                }
                                            }
                                            obj2 = obj5;
                                            i32 = i35;
                                            i10 = i34;
                                            i7 = 3;
                                            iZzk = i31;
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        case 67:
                                            i34 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            i35 = i21;
                                            obj5 = obj;
                                            unsafe = unsafe3;
                                            if (i44 == 0) {
                                                i31 = i86;
                                                iZzk = zzgxo.zzk(bArr2, i31, zzgxnVar2);
                                                unsafe.putObject(obj5, j, Long.valueOf(zzgyf.zzF(zzgxnVar2.zzb)));
                                                unsafe.putInt(obj5, j3, i11);
                                                obj2 = obj5;
                                                i32 = i35;
                                                i11 = i11;
                                                i10 = i34;
                                                i7 = 3;
                                                if (iZzk != i31) {
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzk;
                                                    i40 = i10 == true ? 1 : 0;
                                                    zzgxnVar6 = zzgxnVar2;
                                                    zzhavVar2 = zzhavVar;
                                                    obj6 = obj2;
                                                    i38 = i11;
                                                    i37 = -1;
                                                    i41 = i18;
                                                    i36 = i7;
                                                    iZzs = i32;
                                                    unsafe6 = unsafe;
                                                } else {
                                                    i4 = i3;
                                                    i9 = iZzk;
                                                    i41 = i18;
                                                    iZzs = i32;
                                                }
                                            } else {
                                                i31 = i86;
                                                obj2 = obj5;
                                                i32 = i35;
                                                i10 = i34;
                                                i7 = 3;
                                                iZzk = i31;
                                                if (iZzk != i31) {
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzk;
                                                    i40 = i10 == true ? 1 : 0;
                                                    zzgxnVar6 = zzgxnVar2;
                                                    zzhavVar2 = zzhavVar;
                                                    obj6 = obj2;
                                                    i38 = i11;
                                                    i37 = -1;
                                                    i41 = i18;
                                                    i36 = i7;
                                                    iZzs = i32;
                                                    unsafe6 = unsafe;
                                                } else {
                                                    i4 = i3;
                                                    i9 = iZzk;
                                                    i41 = i18;
                                                    iZzs = i32;
                                                }
                                            }
                                            break;
                                        case 68:
                                            if (i44 == 3) {
                                                int i90 = ((i20 == true ? 1 : 0) & (-8)) | 4;
                                                Object objZzB2 = zzhavVar.zzB(obj, i11, i21);
                                                zzgxnVar2 = zzgxnVar4;
                                                int iZzl2 = zzgxo.zzl(objZzB2, zzhavVar.zzx(i21), bArr, i86, i2, i90, zzgxnVar);
                                                zzhavVar.zzK(obj, i11, i21, objZzB2);
                                                obj2 = obj;
                                                i32 = i21;
                                                i11 = i11;
                                                unsafe = unsafe3;
                                                iZzk = iZzl2;
                                                i10 = i20 == true ? 1 : 0;
                                                i7 = 3;
                                                i31 = i86;
                                            } else {
                                                zzgxnVar2 = zzgxnVar4;
                                                obj2 = obj;
                                                i31 = i86;
                                                i11 = i11;
                                                i32 = i21;
                                                i10 = i20 == true ? 1 : 0;
                                                i7 = 3;
                                                unsafe = unsafe3;
                                                iZzk = i31;
                                            }
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                        default:
                                            obj2 = obj;
                                            i31 = i86;
                                            i32 = i21;
                                            i7 = 3;
                                            unsafe = unsafe3;
                                            i11 = i11;
                                            i10 = i20 == true ? 1 : 0;
                                            zzgxnVar2 = zzgxnVar4;
                                            iZzk = i31;
                                            if (iZzk != i31) {
                                                i2 = i2;
                                                i3 = i3;
                                                iZzl = iZzk;
                                                i40 = i10 == true ? 1 : 0;
                                                zzgxnVar6 = zzgxnVar2;
                                                zzhavVar2 = zzhavVar;
                                                obj6 = obj2;
                                                i38 = i11;
                                                i37 = -1;
                                                i41 = i18;
                                                i36 = i7;
                                                iZzs = i32;
                                                unsafe6 = unsafe;
                                            } else {
                                                i4 = i3;
                                                i9 = iZzk;
                                                i41 = i18;
                                                iZzs = i32;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i44 == 2) {
                                        Object objZzz = zzz(i21);
                                        Object object = unsafe3.getObject(obj, j);
                                        if (zzhan.zza(object)) {
                                            zzham zzhamVarZzb = zzham.zza().zzb();
                                            zzhan.zzb(zzhamVarZzb, object);
                                            unsafe3.putObject(obj, j, zzhamVarZzb);
                                        }
                                        throw null;
                                    }
                                    i19 = i86;
                                    zzhavVar = this;
                                    obj3 = obj;
                                }
                            }
                        } else if (i44 == 2) {
                            zzgzt zzgztVarZzf2 = (zzgzt) unsafe6.getObject(obj6, j);
                            if (!zzgztVarZzf2.zzc()) {
                                int size2 = zzgztVarZzf2.size();
                                zzgztVarZzf2 = zzgztVarZzf2.zzf(size2 == 0 ? 10 : size2 + size2);
                                unsafe6.putObject(obj6, j, zzgztVarZzf2);
                            }
                            iZzl = zzgxo.zze(zzhavVar2.zzx(iZzs), i46 == true ? 1 : 0, bArr, iZzi, i2, zzgztVarZzf2, zzgxnVar);
                            iZzs = iZzs;
                            unsafe6 = unsafe6;
                            i40 = i46 == true ? 1 : 0;
                            i38 = i43;
                            i37 = -1;
                            i41 = i41;
                            i2 = i2;
                            i3 = i3;
                            zzgxnVar6 = zzgxnVar;
                            i36 = 3;
                        } else {
                            i18 = i41;
                            Unsafe unsafe10 = unsafe6;
                            zzgxnVar4 = zzgxnVar;
                            unsafe3 = unsafe10;
                            i19 = iZzi;
                            obj3 = obj6;
                            i11 = i43;
                            zzhavVar = zzhavVar2;
                            i20 = i46 == true ? 1 : 0;
                            i21 = iZzs;
                        }
                        i4 = i3;
                        obj2 = obj3;
                        iZzs = i21;
                        i7 = 3;
                        i9 = i19;
                        unsafe = unsafe3;
                        i41 = i18;
                        zzgxn zzgxnVar7 = zzgxnVar4;
                        i11 = i11;
                        i10 = i20;
                        zzgxnVar2 = zzgxnVar7;
                    }
                }
                if (i10 != i4 || i4 == 0) {
                    if (zzhavVar.zzh) {
                        zzgyr zzgyrVar = zzgxnVar2.zzd;
                        int i91 = zzgyr.zzb;
                        int i92 = zzhbc.zza;
                        if (zzgyrVar == zzgyr.zza) {
                            i12 = i10;
                            iZzg = zzgxo.zzg(i12 == true ? 1 : 0, bArr, i9, i2, zzd(obj), zzgxnVar);
                        } else {
                            if (zzgyrVar.zzc(zzhavVar.zzg, i11) != null) {
                                throw null;
                            }
                            i12 = i10;
                            iZzg = zzgxo.zzg(i10 == true ? 1 : 0, bArr, i9, i2, zzd(obj), zzgxnVar);
                        }
                    } else {
                        i12 = i10;
                        iZzg = zzgxo.zzg(i12 == true ? 1 : 0, bArr, i9, i2, zzd(obj), zzgxnVar);
                    }
                    i2 = i2;
                    zzgxnVar6 = zzgxnVar2;
                    zzhavVar2 = zzhavVar;
                    i40 = i12;
                    i3 = i4;
                    obj6 = obj2;
                    i38 = i11;
                    i37 = i8;
                    i36 = i7;
                    iZzl = iZzg;
                    unsafe6 = unsafe;
                } else {
                    iZzl = i9;
                    i6 = i10;
                    i5 = i39;
                }
            } else {
                i4 = i3;
                obj2 = obj6;
                unsafe = unsafe6;
                zzhavVar = zzhavVar2;
                i5 = i39;
                i6 = i40;
            }
        }
        if (i41 != 1048575) {
            unsafe.putInt(obj2, i41, i5);
        }
        for (int i93 = zzhavVar.zzk; i93 < zzhavVar.zzl; i93++) {
            zzy(obj, zzhavVar.zzj[i93], null, zzhavVar.zzm, obj);
        }
        if (i4 == 0) {
            if (iZzl != i2) {
                throw new zzgzw("Failed to parse the message.");
            }
        } else if (iZzl > i2 || i6 != i4) {
            throw new zzgzw("Failed to parse the message.");
        }
        return iZzl;
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final Object zze() {
        return ((zzgzh) this.zzg).zzbj();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgzh) {
                zzgzh zzgzhVar = (zzgzh) obj;
                zzgzhVar.zzbT();
                zzgzhVar.zzbS();
                zzgzhVar.zzbV();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzu = zzu(i);
                int i2 = 1048575 & iZzu;
                int iZzt = zzt(iZzu);
                long j = i2;
                if (iZzt != 9) {
                    if (iZzt != 60 && iZzt != 68) {
                        switch (iZzt) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzx(i).zzf(zzb.getObject(obj, j));
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
                                ((zzgzt) zzhce.zzh(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzham) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzR(obj, iArr[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzhbn.zzq(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzhbn.zzp(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhce.zzr(obj, j, zzhce.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzhce.zzs(obj, j, zzhce.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzhce.zzp(obj, j, zzhce.zzz(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzhce.zzt(obj, j, zzhce.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzhce.zzu(obj, j, zzhce.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
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
                    zzgzt zzgztVarZzf = (zzgzt) zzhce.zzh(obj, j);
                    zzgzt zzgztVar = (zzgzt) zzhce.zzh(obj2, j);
                    int size = zzgztVarZzf.size();
                    int size2 = zzgztVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzgztVarZzf.zzc()) {
                            zzgztVarZzf = zzgztVarZzf.zzf(size2 + size);
                        }
                        zzgztVarZzf.addAll(zzgztVar);
                    }
                    if (size > 0) {
                        zzgztVar = zzgztVarZzf;
                    }
                    zzhce.zzv(obj, j, zzgztVar);
                    break;
                case 50:
                    int i4 = zzhbn.zza;
                    zzhce.zzv(obj, j, zzhan.zzb(zzhce.zzh(obj, j), zzhce.zzh(obj2, j)));
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
                    if (zzR(obj2, i3, i)) {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzhce.zzv(obj, j, zzhce.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x050e  */
    /* JADX WARN: Code duplicated, block: B:320:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzh(Object obj, zzhbf zzhbfVar, zzgyr zzgyrVar) {
        zzgyrVar.getClass();
        zzD(obj);
        zzhbx zzhbxVar = this.zzm;
        Object objZza = null;
        while (true) {
            try {
                int iZzc = zzhbfVar.zzc();
                int iZzq = zzq(iZzc);
                if (iZzq >= 0) {
                    int iZzu = zzu(iZzq);
                    try {
                        switch (zzt(iZzu)) {
                            case 0:
                                zzhce.zzr(obj, iZzu & 1048575, zzhbfVar.zza());
                                zzH(obj, iZzq);
                                break;
                            case 1:
                                zzhce.zzs(obj, iZzu & 1048575, zzhbfVar.zzb());
                                zzH(obj, iZzq);
                                break;
                            case 2:
                                zzhce.zzu(obj, iZzu & 1048575, zzhbfVar.zzl());
                                zzH(obj, iZzq);
                                break;
                            case 3:
                                zzhce.zzu(obj, iZzu & 1048575, zzhbfVar.zzo());
                                zzH(obj, iZzq);
                                break;
                            case 4:
                                zzhce.zzt(obj, iZzu & 1048575, zzhbfVar.zzg());
                                zzH(obj, iZzq);
                                break;
                            case 5:
                                zzhce.zzu(obj, iZzu & 1048575, zzhbfVar.zzk());
                                zzH(obj, iZzq);
                                break;
                            case 6:
                                zzhce.zzt(obj, iZzu & 1048575, zzhbfVar.zzf());
                                zzH(obj, iZzq);
                                break;
                            case 7:
                                zzhce.zzp(obj, iZzu & 1048575, zzhbfVar.zzN());
                                zzH(obj, iZzq);
                                break;
                            case 8:
                                zzG(obj, iZzu, zzhbfVar);
                                zzH(obj, iZzq);
                                break;
                            case 9:
                                zzhas zzhasVar = (zzhas) zzA(obj, iZzq);
                                zzhbfVar.zzu(zzhasVar, zzx(iZzq), zzgyrVar);
                                zzJ(obj, iZzq, zzhasVar);
                                break;
                            case 10:
                                zzhce.zzv(obj, iZzu & 1048575, zzhbfVar.zzp());
                                zzH(obj, iZzq);
                                break;
                            case 11:
                                zzhce.zzt(obj, iZzu & 1048575, zzhbfVar.zzj());
                                zzH(obj, iZzq);
                                break;
                            case 12:
                                int iZze = zzhbfVar.zze();
                                zzgzn zzgznVarZzw = zzw(iZzq);
                                if (zzgznVarZzw == null || zzgznVarZzw.zza(iZze)) {
                                    zzhce.zzt(obj, iZzu & 1048575, iZze);
                                    zzH(obj, iZzq);
                                } else {
                                    objZza = zzhbn.zzo(obj, iZzc, iZze, objZza, zzhbxVar);
                                }
                                break;
                            case 13:
                                zzhce.zzt(obj, iZzu & 1048575, zzhbfVar.zzh());
                                zzH(obj, iZzq);
                                break;
                            case 14:
                                zzhce.zzu(obj, iZzu & 1048575, zzhbfVar.zzm());
                                zzH(obj, iZzq);
                                break;
                            case 15:
                                zzhce.zzt(obj, iZzu & 1048575, zzhbfVar.zzi());
                                zzH(obj, iZzq);
                                break;
                            case 16:
                                zzhce.zzu(obj, iZzu & 1048575, zzhbfVar.zzn());
                                zzH(obj, iZzq);
                                break;
                            case 17:
                                zzhas zzhasVar2 = (zzhas) zzA(obj, iZzq);
                                zzhbfVar.zzt(zzhasVar2, zzx(iZzq), zzgyrVar);
                                zzJ(obj, iZzq, zzhasVar2);
                                break;
                            case 18:
                                zzhbfVar.zzx(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 19:
                                zzhbfVar.zzB(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 20:
                                zzhbfVar.zzE(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 21:
                                zzhbfVar.zzM(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 22:
                                zzhbfVar.zzD(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                zzhbfVar.zzA(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 24:
                                zzhbfVar.zzz(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 25:
                                zzhbfVar.zzv(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 26:
                                if (zzM(iZzu)) {
                                    ((zzgyg) zzhbfVar).zzK(zzhaf.zza(obj, iZzu & 1048575), true);
                                } else {
                                    ((zzgyg) zzhbfVar).zzK(zzhaf.zza(obj, iZzu & 1048575), false);
                                }
                                break;
                            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                                zzhbfVar.zzF(zzhaf.zza(obj, iZzu & 1048575), zzx(iZzq), zzgyrVar);
                                break;
                            case 28:
                                zzhbfVar.zzw(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 29:
                                zzhbfVar.zzL(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 30:
                                List listZza = zzhaf.zza(obj, iZzu & 1048575);
                                zzhbfVar.zzy(listZza);
                                objZza = zzhbn.zzn(obj, iZzc, listZza, zzw(iZzq), objZza, zzhbxVar);
                                break;
                            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                zzhbfVar.zzG(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 32:
                                zzhbfVar.zzH(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 33:
                                zzhbfVar.zzI(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 34:
                                zzhbfVar.zzJ(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                zzhbfVar.zzx(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                zzhbfVar.zzB(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                zzhbfVar.zzE(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 38:
                                zzhbfVar.zzM(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                zzhbfVar.zzD(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                zzhbfVar.zzA(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                zzhbfVar.zzz(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 42:
                                zzhbfVar.zzv(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 43:
                                zzhbfVar.zzL(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                List listZza2 = zzhaf.zza(obj, iZzu & 1048575);
                                zzhbfVar.zzy(listZza2);
                                objZza = zzhbn.zzn(obj, iZzc, listZza2, zzw(iZzq), objZza, zzhbxVar);
                                break;
                            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                zzhbfVar.zzG(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 46:
                                zzhbfVar.zzH(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 47:
                                zzhbfVar.zzI(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 48:
                                zzhbfVar.zzJ(zzhaf.zza(obj, iZzu & 1048575));
                                break;
                            case 49:
                                zzhbfVar.zzC(zzhaf.zza(obj, iZzu & 1048575), zzx(iZzq), zzgyrVar);
                                break;
                            case 50:
                                Object objZzz = zzz(iZzq);
                                long jZzu = zzu(iZzq) & 1048575;
                                Object objZzh = zzhce.zzh(obj, jZzu);
                                if (objZzh == null) {
                                    objZzh = zzham.zza().zzb();
                                    zzhce.zzv(obj, jZzu, objZzh);
                                } else if (zzhan.zza(objZzh)) {
                                    Object objZzb = zzham.zza().zzb();
                                    zzhan.zzb(objZzb, objZzh);
                                    zzhce.zzv(obj, jZzu, objZzb);
                                    objZzh = objZzb;
                                }
                                throw null;
                            case 51:
                                zzhce.zzv(obj, iZzu & 1048575, Double.valueOf(zzhbfVar.zza()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 52:
                                zzhce.zzv(obj, iZzu & 1048575, Float.valueOf(zzhbfVar.zzb()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 53:
                                zzhce.zzv(obj, iZzu & 1048575, Long.valueOf(zzhbfVar.zzl()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 54:
                                zzhce.zzv(obj, iZzu & 1048575, Long.valueOf(zzhbfVar.zzo()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 55:
                                zzhce.zzv(obj, iZzu & 1048575, Integer.valueOf(zzhbfVar.zzg()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 56:
                                zzhce.zzv(obj, iZzu & 1048575, Long.valueOf(zzhbfVar.zzk()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 57:
                                zzhce.zzv(obj, iZzu & 1048575, Integer.valueOf(zzhbfVar.zzf()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 58:
                                zzhce.zzv(obj, iZzu & 1048575, Boolean.valueOf(zzhbfVar.zzN()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 59:
                                zzG(obj, iZzu, zzhbfVar);
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 60:
                                zzhas zzhasVar3 = (zzhas) zzB(obj, iZzc, iZzq);
                                zzhbfVar.zzu(zzhasVar3, zzx(iZzq), zzgyrVar);
                                zzK(obj, iZzc, iZzq, zzhasVar3);
                                break;
                            case 61:
                                zzhce.zzv(obj, iZzu & 1048575, zzhbfVar.zzp());
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 62:
                                zzhce.zzv(obj, iZzu & 1048575, Integer.valueOf(zzhbfVar.zzj()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 63:
                                int iZze2 = zzhbfVar.zze();
                                zzgzn zzgznVarZzw2 = zzw(iZzq);
                                if (zzgznVarZzw2 == null || zzgznVarZzw2.zza(iZze2)) {
                                    zzhce.zzv(obj, iZzu & 1048575, Integer.valueOf(iZze2));
                                    zzI(obj, iZzc, iZzq);
                                } else {
                                    objZza = zzhbn.zzo(obj, iZzc, iZze2, objZza, zzhbxVar);
                                }
                                break;
                            case 64:
                                zzhce.zzv(obj, iZzu & 1048575, Integer.valueOf(zzhbfVar.zzh()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 65:
                                zzhce.zzv(obj, iZzu & 1048575, Long.valueOf(zzhbfVar.zzm()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                zzhce.zzv(obj, iZzu & 1048575, Integer.valueOf(zzhbfVar.zzi()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 67:
                                zzhce.zzv(obj, iZzu & 1048575, Long.valueOf(zzhbfVar.zzn()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 68:
                                zzhas zzhasVar4 = (zzhas) zzB(obj, iZzc, iZzq);
                                zzhbfVar.zzt(zzhasVar4, zzx(iZzq), zzgyrVar);
                                zzK(obj, iZzc, iZzq, zzhasVar4);
                                break;
                            default:
                                if (objZza == null) {
                                    objZza = zzhbxVar.zza(obj);
                                }
                                if (!zzhbxVar.zzk(objZza, zzhbfVar, 0)) {
                                    for (int i = this.zzk; i < this.zzl; i++) {
                                        zzy(obj, this.zzj[i], objZza, zzhbxVar, obj);
                                    }
                                }
                                break;
                        }
                    } catch (zzgzv unused) {
                        if (objZza == null) {
                            objZza = zzhbxVar.zza(obj);
                        }
                        if (!zzhbxVar.zzk(objZza, zzhbfVar, 0)) {
                            for (int i2 = this.zzk; i2 < this.zzl; i2++) {
                                zzy(obj, this.zzj[i2], objZza, zzhbxVar, obj);
                            }
                            if (objZza != null) {
                                zzhbxVar.zzj(obj, objZza);
                            }
                        }
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                        zzy(obj, this.zzj[i3], objZza, zzhbxVar, obj);
                    }
                } else {
                    if ((!this.zzh ? null : zzgyrVar.zzc(this.zzg, iZzc)) != null) {
                        throw null;
                    }
                    if (objZza == null) {
                        objZza = zzhbxVar.zza(obj);
                    }
                    if (!zzhbxVar.zzk(objZza, zzhbfVar, 0)) {
                        for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                            zzy(obj, this.zzj[i4], objZza, zzhbxVar, obj);
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zzk; i5 < this.zzl; i5++) {
                    zzy(obj, this.zzj[i5], objZza, zzhbxVar, obj);
                }
                if (objZza != null) {
                    zzhbxVar.zzj(obj, objZza);
                }
                throw th;
            }
        }
        if (objZza != null) {
            zzhbxVar.zzj(obj, objZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxn zzgxnVar) {
        zzc(obj, bArr, i, i2, 0, zzgxnVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0235  */
    /* JADX WARN: Code duplicated, block: B:101:0x0244  */
    /* JADX WARN: Code duplicated, block: B:102:0x0253  */
    /* JADX WARN: Code duplicated, block: B:103:0x0263  */
    /* JADX WARN: Code duplicated, block: B:104:0x0273  */
    /* JADX WARN: Code duplicated, block: B:105:0x0283  */
    /* JADX WARN: Code duplicated, block: B:106:0x0293  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:110:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:111:0x02da  */
    /* JADX WARN: Code duplicated, block: B:112:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:113:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:114:0x0307  */
    /* JADX WARN: Code duplicated, block: B:115:0x0316  */
    /* JADX WARN: Code duplicated, block: B:116:0x0325  */
    /* JADX WARN: Code duplicated, block: B:117:0x0338  */
    /* JADX WARN: Code duplicated, block: B:118:0x0347  */
    /* JADX WARN: Code duplicated, block: B:119:0x0357  */
    /* JADX WARN: Code duplicated, block: B:120:0x0367  */
    /* JADX WARN: Code duplicated, block: B:121:0x0377  */
    /* JADX WARN: Code duplicated, block: B:122:0x0387  */
    /* JADX WARN: Code duplicated, block: B:123:0x0397  */
    /* JADX WARN: Code duplicated, block: B:124:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:125:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:126:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:128:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:129:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:131:0x040b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0414  */
    /* JADX WARN: Code duplicated, block: B:134:0x042f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0438  */
    /* JADX WARN: Code duplicated, block: B:137:0x0453  */
    /* JADX WARN: Code duplicated, block: B:138:0x045c  */
    /* JADX WARN: Code duplicated, block: B:140:0x0477  */
    /* JADX WARN: Code duplicated, block: B:141:0x0480  */
    /* JADX WARN: Code duplicated, block: B:143:0x049b  */
    /* JADX WARN: Code duplicated, block: B:144:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:146:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:147:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:149:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:150:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x0509  */
    /* JADX WARN: Code duplicated, block: B:153:0x0516  */
    /* JADX WARN: Code duplicated, block: B:155:0x0531  */
    /* JADX WARN: Code duplicated, block: B:156:0x053a  */
    /* JADX WARN: Code duplicated, block: B:158:0x0555  */
    /* JADX WARN: Code duplicated, block: B:159:0x055e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0579  */
    /* JADX WARN: Code duplicated, block: B:162:0x0582  */
    /* JADX WARN: Code duplicated, block: B:164:0x059d  */
    /* JADX WARN: Code duplicated, block: B:165:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:167:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:168:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:170:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:171:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:173:0x0609  */
    /* JADX WARN: Code duplicated, block: B:174:0x0611  */
    /* JADX WARN: Code duplicated, block: B:176:0x062c  */
    /* JADX WARN: Code duplicated, block: B:177:0x0634  */
    /* JADX WARN: Code duplicated, block: B:179:0x064f  */
    /* JADX WARN: Code duplicated, block: B:190:0x01b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x0656 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0094  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:54:0x0106  */
    /* JADX WARN: Code duplicated, block: B:56:0x010c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0117  */
    /* JADX WARN: Code duplicated, block: B:59:0x011d  */
    /* JADX WARN: Code duplicated, block: B:60:0x012a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0130  */
    /* JADX WARN: Code duplicated, block: B:63:0x0139  */
    /* JADX WARN: Code duplicated, block: B:65:0x013f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0148  */
    /* JADX WARN: Code duplicated, block: B:68:0x014e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0157  */
    /* JADX WARN: Code duplicated, block: B:71:0x015d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0166  */
    /* JADX WARN: Code duplicated, block: B:74:0x016c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0175  */
    /* JADX WARN: Code duplicated, block: B:77:0x017b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0184  */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Code duplicated, block: B:80:0x018a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0193  */
    /* JADX WARN: Code duplicated, block: B:83:0x0199  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01db  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:97:0x0208  */
    /* JADX WARN: Code duplicated, block: B:98:0x0217  */
    /* JADX WARN: Code duplicated, block: B:99:0x0226  */
    @Override // com.google.android.gms.internal.ads.zzhbl
    public final void zzj(Object obj, zzhcm zzhcmVar) {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        long j;
        boolean z;
        if (this.zzh) {
            zzgyw zzgywVar = ((zzgzd) obj).zza;
            if (zzgywVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzgywVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzu = zzu(i7);
            int iZzt = zzt(iZzu);
            int i8 = iArr[i7];
            if (iZzt <= 17) {
                int i9 = iArr[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                } else {
                    i9 = i9;
                }
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
                i = i5;
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            while (entry != null) {
                zzgys zzgysVar = this.zzn;
                if (((zzgze) entry.getKey()).zza > i8) {
                    j = iZzu & 1048575;
                    switch (iZzt) {
                        case 0:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzf(i8, zzhce.zzb(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 1:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzo(i8, zzhce.zzc(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 2:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzt(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 3:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzK(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 4:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzr(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 5:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzm(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 6:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzk(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 7:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzb(i8, zzhce.zzz(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 8:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzT(i8, unsafe.getObject(obj, j), zzhcmVar);
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 9:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 10:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzd(i8, (zzgxz) unsafe.getObject(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 11:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzI(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 12:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzi(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 13:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzx(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 14:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzz(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 15:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzB(i8, unsafe.getInt(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 16:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzD(i8, unsafe.getLong(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 17:
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            if (zzO(obj, i7, i, i2, i3)) {
                                zzhcmVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 18:
                            z = false;
                            zzhbn.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 19:
                            z = false;
                            zzhbn.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 20:
                            z = false;
                            zzhbn.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 21:
                            z = false;
                            zzhbn.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 22:
                            z = false;
                            zzhbn.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                            z = false;
                            zzhbn.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 24:
                            z = false;
                            zzhbn.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 25:
                            z = false;
                            zzhbn.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 26:
                            zzhbn.zzG(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                            zzhbn.zzB(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, zzx(i7));
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 28:
                            zzhbn.zzs(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 29:
                            z = false;
                            zzhbn.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 30:
                            z = false;
                            zzhbn.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                            z = false;
                            zzhbn.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 32:
                            z = false;
                            zzhbn.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 33:
                            z = false;
                            zzhbn.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 34:
                            z = false;
                            zzhbn.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                            it = it;
                            iArr = iArr;
                            entry = entry;
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                            zzhbn.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                            zzhbn.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                            zzhbn.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 38:
                            zzhbn.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                            zzhbn.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                            zzhbn.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                            zzhbn.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 42:
                            zzhbn.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 43:
                            zzhbn.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                            zzhbn.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                            zzhbn.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 46:
                            zzhbn.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 47:
                            zzhbn.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 48:
                            zzhbn.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 49:
                            zzhbn.zzy(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, zzx(i7));
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 50:
                            if (unsafe.getObject(obj, j) != null) {
                                throw null;
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 51:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzf(i8, zzn(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 52:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzo(i8, zzo(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 53:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzt(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 54:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzK(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 55:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzr(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 56:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzm(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 57:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzk(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 58:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzb(i8, zzS(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 59:
                            if (zzR(obj, i8, i7)) {
                                zzT(i8, unsafe.getObject(obj, j), zzhcmVar);
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 60:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 61:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzd(i8, (zzgxz) unsafe.getObject(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 62:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzI(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 63:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzi(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 64:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzx(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 65:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzz(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzB(i8, zzp(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 67:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzD(i8, zzv(obj, j));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        case 68:
                            if (zzR(obj, i8, i7)) {
                                zzhcmVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                            }
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                        default:
                            i7 += 3;
                            i5 = i;
                            i6 = i2;
                            it = it;
                            iArr = iArr;
                            i4 = 1048575;
                            entry = entry;
                            break;
                    }
                } else {
                    zzgysVar.zzb(zzhcmVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
            j = iZzu & 1048575;
            switch (iZzt) {
                case 0:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzf(i8, zzhce.zzb(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 1:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzo(i8, zzhce.zzc(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 2:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 3:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzK(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 4:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 5:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 6:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 7:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzb(i8, zzhce.zzz(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 8:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzT(i8, unsafe.getObject(obj, j), zzhcmVar);
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 9:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 10:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzd(i8, (zzgxz) unsafe.getObject(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 11:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzI(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 12:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 13:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzx(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 14:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzz(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 15:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzB(i8, unsafe.getInt(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 16:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzD(i8, unsafe.getLong(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 17:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzhcmVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 18:
                    z = false;
                    zzhbn.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 19:
                    z = false;
                    zzhbn.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 20:
                    z = false;
                    zzhbn.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 21:
                    z = false;
                    zzhbn.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 22:
                    z = false;
                    zzhbn.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    z = false;
                    zzhbn.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 24:
                    z = false;
                    zzhbn.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 25:
                    z = false;
                    zzhbn.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 26:
                    zzhbn.zzG(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    zzhbn.zzB(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, zzx(i7));
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 28:
                    zzhbn.zzs(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 29:
                    z = false;
                    zzhbn.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 30:
                    z = false;
                    zzhbn.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    z = false;
                    zzhbn.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 32:
                    z = false;
                    zzhbn.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 33:
                    z = false;
                    zzhbn.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 34:
                    z = false;
                    zzhbn.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    zzhbn.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    zzhbn.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    zzhbn.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 38:
                    zzhbn.zzI(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    zzhbn.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    zzhbn.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    zzhbn.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 42:
                    zzhbn.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 43:
                    zzhbn.zzH(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    zzhbn.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    zzhbn.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 46:
                    zzhbn.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 47:
                    zzhbn.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 48:
                    zzhbn.zzF(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, true);
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 49:
                    zzhbn.zzy(iArr[i7], (List) unsafe.getObject(obj, j), zzhcmVar, zzx(i7));
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 51:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzf(i8, zzn(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 52:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzo(i8, zzo(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 53:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzt(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 54:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzK(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 55:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzr(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 56:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzm(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 57:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzk(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 58:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzb(i8, zzS(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 59:
                    if (zzR(obj, i8, i7)) {
                        zzT(i8, unsafe.getObject(obj, j), zzhcmVar);
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 60:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 61:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzd(i8, (zzgxz) unsafe.getObject(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 62:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzI(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 63:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzi(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 64:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzx(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 65:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzz(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzB(i8, zzp(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 67:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzD(i8, zzv(obj, j));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                case 68:
                    if (zzR(obj, i8, i7)) {
                        zzhcmVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
                default:
                    i7 += 3;
                    i5 = i;
                    i6 = i2;
                    it = it;
                    iArr = iArr;
                    i4 = 1048575;
                    entry = entry;
                    break;
            }
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzn.zzb(zzhcmVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        ((zzgzh) obj).zzt.zzl(zzhcmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbl
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzJ;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzhce.zzb(obj, j)) != Double.doubleToLongBits(zzhce.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzhce.zzc(obj, j)) != Float.floatToIntBits(zzhce.zzc(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzhce.zzf(obj, j) != zzhce.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzhce.zzf(obj, j) != zzhce.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzhce.zzd(obj, j) != zzhce.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzhce.zzf(obj, j) != zzhce.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzhce.zzd(obj, j) != zzhce.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzhce.zzz(obj, j) != zzhce.zzz(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzhce.zzd(obj, j) != zzhce.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzhce.zzd(obj, j) != zzhce.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzhce.zzd(obj, j) != zzhce.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzhce.zzf(obj, j) != zzhce.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzhce.zzd(obj, j) != zzhce.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzhce.zzf(obj, j) != zzhce.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
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
                    zZzJ = zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j));
                    break;
                case 50:
                    zZzJ = zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j));
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
                    long jZzr = zzr(i) & 1048575;
                    if (zzhce.zzd(obj, jZzr) != zzhce.zzd(obj2, jZzr) || !zzhbn.zzJ(zzhce.zzh(obj, j), zzhce.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzJ) {
                return false;
            }
        }
        if (!((zzgzh) obj).zzt.equals(((zzgzh) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzgzd) obj).zza.equals(((zzgzd) obj2).zza);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00be A[LOOP:1: B:45:0x00ad->B:50:0x00be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00db A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbl
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzhbl zzhblVarZzx;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzu = zzu(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iZzu) != 0 && !zzO(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzt = zzt(iZzu);
            if (iZzt == 9 || iZzt == 17) {
                if (zzO(obj, i7, i, i2, i11) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 27) {
                list = (List) zzhce.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhblVarZzx = zzx(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzhblVarZzx.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzt == 60 || iZzt == 68) {
                if (zzR(obj, i8, i7) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 49) {
                list = (List) zzhce.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    zzhblVarZzx = zzx(i7);
                    while (i3 < list.size()) {
                        if (!zzhblVarZzx.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzt == 50 && !((zzham) zzhce.zzh(obj, iZzu & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzgzd) obj).zza.zzi();
    }
}
