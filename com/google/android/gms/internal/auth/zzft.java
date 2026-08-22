package com.google.android.gms.internal.auth;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.google.protobuf.DescriptorProtos;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzft<T> implements zzgb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfq zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfe zzl;
    private final zzgp<?, ?> zzm;
    private final zzeh<?> zzn;
    private final zzfv zzo;
    private final zzfl zzp;

    /* JADX WARN: Multi-variable type inference failed */
    private zzft(int[] iArr, int[] iArr2, Object[] objArr, int i, int i2, zzfq zzfqVar, boolean z, boolean z2, int[] iArr3, int i3, int i4, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i;
        this.zzh = zzfqVar;
        this.zzi = z2;
        this.zzj = iArr3;
        this.zzk = i3;
        this.zzo = i4;
        this.zzl = zzfvVar;
        this.zzm = zzfeVar;
        this.zzn = zzgpVar;
        this.zzg = i2;
        this.zzp = zzehVar;
    }

    private static Field zzA(Class<?> cls, String str) {
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
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            throw new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, " not found. Known fields are ", string));
        }
    }

    private final void zzB(T t, T t2, int i) {
        long jZzv = zzv(i) & 1048575;
        if (zzG(t2, i)) {
            Object objZzf = zzgz.zzf(t, jZzv);
            Object objZzf2 = zzgz.zzf(t2, jZzv);
            if (objZzf != null && objZzf2 != null) {
                zzgz.zzp(t, jZzv, zzev.zzg(objZzf, objZzf2));
                zzD(t, i);
            } else if (objZzf2 != null) {
                zzgz.zzp(t, jZzv, objZzf2);
                zzD(t, i);
            }
        }
    }

    private final void zzC(T t, T t2, int i) {
        int iZzv = zzv(i);
        int i2 = this.zzc[i];
        long j = iZzv & 1048575;
        if (zzJ(t2, i2, i)) {
            Object objZzf = zzJ(t, i2, i) ? zzgz.zzf(t, j) : null;
            Object objZzf2 = zzgz.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zzgz.zzp(t, j, zzev.zzg(objZzf, objZzf2));
                zzE(t, i2, i);
            } else if (objZzf2 != null) {
                zzgz.zzp(t, j, objZzf2);
                zzE(t, i2, i);
            }
        }
    }

    private final void zzD(T t, int i) {
        int iZzs = zzs(i);
        long j = 1048575 & iZzs;
        if (j == 1048575) {
            return;
        }
        zzgz.zzn(t, j, (1 << (iZzs >>> 20)) | zzgz.zzc(t, j));
    }

    private final void zzE(T t, int i, int i2) {
        zzgz.zzn(t, zzs(i2) & 1048575, i);
    }

    private final boolean zzF(T t, T t2, int i) {
        return zzG(t, i) == zzG(t2, i);
    }

    private final boolean zzG(T t, int i) {
        int iZzs = zzs(i);
        long j = iZzs & 1048575;
        if (j != 1048575) {
            return (zzgz.zzc(t, j) & (1 << (iZzs >>> 20))) != 0;
        }
        int iZzv = zzv(i);
        long j2 = iZzv & 1048575;
        switch (zzu(iZzv)) {
            case 0:
                return zzgz.zza(t, j2) != 0.0d;
            case 1:
                return zzgz.zzb(t, j2) != 0.0f;
            case 2:
                return zzgz.zzd(t, j2) != 0;
            case 3:
                return zzgz.zzd(t, j2) != 0;
            case 4:
                return zzgz.zzc(t, j2) != 0;
            case 5:
                return zzgz.zzd(t, j2) != 0;
            case 6:
                return zzgz.zzc(t, j2) != 0;
            case 7:
                return zzgz.zzt(t, j2);
            case 8:
                Object objZzf = zzgz.zzf(t, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzeb) {
                    return !zzeb.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(t, j2) != null;
            case 10:
                return !zzeb.zzb.equals(zzgz.zzf(t, j2));
            case 11:
                return zzgz.zzc(t, j2) != 0;
            case 12:
                return zzgz.zzc(t, j2) != 0;
            case 13:
                return zzgz.zzc(t, j2) != 0;
            case 14:
                return zzgz.zzd(t, j2) != 0;
            case 15:
                return zzgz.zzc(t, j2) != 0;
            case 16:
                return zzgz.zzd(t, j2) != 0;
            case 17:
                return zzgz.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzG(t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzI(Object obj, int i, zzgb zzgbVar) {
        return zzgbVar.zzi(zzgz.zzf(obj, i & 1048575));
    }

    private final boolean zzJ(T t, int i, int i2) {
        return zzgz.zzc(t, (long) (zzs(i2) & 1048575)) == i;
    }

    public static zzgq zzc(Object obj) {
        zzeq zzeqVar = (zzeq) obj;
        zzgq zzgqVar = zzeqVar.zzc;
        if (zzgqVar != zzgq.zza()) {
            return zzgqVar;
        }
        zzgq zzgqVarZzc = zzgq.zzc();
        zzeqVar.zzc = zzgqVarZzc;
        return zzgqVarZzc;
    }

    public static <T> zzft<T> zzj(Class<T> cls, zzfn zzfnVar, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
        if (zzfnVar instanceof zzga) {
            return zzk((zzga) zzfnVar, zzfvVar, zzfeVar, zzgpVar, zzehVar, zzflVar);
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
    public static <T> zzft<T> zzk(zzga zzgaVar, zzfv zzfvVar, zzfe zzfeVar, zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfl zzflVar) {
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
        Field fieldZzA;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldZzA2;
        int i26;
        Object obj2;
        Field fieldZzA3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        boolean z = zzgaVar.zzc() == 2;
        String strZzd = zzgaVar.zzd();
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
        Object[] objArrZze = zzgaVar.zze();
        Class<?> cls = zzgaVar.zza().getClass();
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
                        fieldZzA2 = (Field) obj;
                    } else {
                        fieldZzA2 = zzA(cls, (String) obj);
                        objArrZze[i25] = fieldZzA2;
                    }
                    iArr2 = iArr3;
                    i17 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzA2);
                    i26 = i25 + 1;
                    obj2 = objArrZze[i26];
                    if (obj2 instanceof Field) {
                        fieldZzA3 = (Field) obj2;
                    } else {
                        fieldZzA3 = zzA(cls, (String) obj2);
                        objArrZze[i26] = fieldZzA3;
                    }
                    objArr = objArr2;
                    i19 = i2;
                    i20 = i80;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = 0;
                }
                i2 = i24;
                i25 = iCharAt12 + iCharAt12;
                obj = objArrZze[i25];
                if (obj instanceof Field) {
                    fieldZzA2 = (Field) obj;
                } else {
                    fieldZzA2 = zzA(cls, (String) obj);
                    objArrZze[i25] = fieldZzA2;
                }
                iArr2 = iArr3;
                i17 = iCharAt;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzA2);
                i26 = i25 + 1;
                obj2 = objArrZze[i26];
                if (obj2 instanceof Field) {
                    fieldZzA3 = (Field) obj2;
                } else {
                    fieldZzA3 = zzA(cls, (String) obj2);
                    objArrZze[i26] = fieldZzA3;
                }
                objArr = objArr2;
                i19 = i2;
                i20 = i80;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = 0;
            } else {
                iArr2 = iArr3;
                i17 = iCharAt;
                i18 = i4;
                int i83 = i2 + 1;
                Field fieldZzA4 = zzA(cls, (String) objArrZze[i2]);
                if (i73 == 9 || i73 == 17) {
                    int i84 = i63 / 3;
                    objArr2[i84 + i84 + 1] = fieldZzA4.getType();
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
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
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
                                fieldZzA = (Field) obj3;
                            } else {
                                fieldZzA = zzA(cls, (String) obj3);
                                objArrZze[i94] = fieldZzA;
                            }
                            i21 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA);
                        }
                        if (i73 >= 18 && i73 <= 49) {
                            iArr[i62] = iObjectFieldOffset;
                            i62++;
                        }
                    }
                    i19 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA4);
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
        return new zzft<>(iArr3, objArr2, iCharAt, i4, zzgaVar.zza(), z, false, iArr, iCharAt3, i60, zzfvVar, zzfeVar, zzgpVar, zzehVar, zzflVar, null);
    }

    private static <T> int zzl(T t, long j) {
        return ((Integer) zzgz.zzf(t, j)).intValue();
    }

    private final <K, V> int zzm(T t, byte[] bArr, int i, int i2, int i3, long j, zzdp zzdpVar) {
        Unsafe unsafe = zzb;
        Object objZzz = zzz(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzfk) object).zze()) {
            zzfk<K, V> zzfkVarZzb = zzfk.zza().zzb();
            zzfl.zza(zzfkVarZzb, object);
            unsafe.putObject(t, j, zzfkVarZzb);
        }
        throw null;
    }

    private final int zzn(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdp zzdpVar) throws zzew {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(zzdq.zzn(bArr, i))));
                unsafe.putInt(t, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(zzdq.zzb(bArr, i))));
                unsafe.putInt(t, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzdq.zzm(bArr, i, zzdpVar);
                unsafe.putObject(t, j, Long.valueOf(zzdpVar.zzb));
                unsafe.putInt(t, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzdq.zzj(bArr, i, zzdpVar);
                unsafe.putObject(t, j, Integer.valueOf(zzdpVar.zza));
                unsafe.putInt(t, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(zzdq.zzn(bArr, i)));
                unsafe.putInt(t, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(zzdq.zzb(bArr, i)));
                unsafe.putInt(t, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzdq.zzm(bArr, i, zzdpVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzdpVar.zzb != 0));
                unsafe.putInt(t, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzdq.zzj(bArr, i, zzdpVar);
                int i9 = zzdpVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzhd.zzd(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzew.zzb();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZzj2, i9, zzev.zza));
                    iZzj2 += i9;
                }
                unsafe.putInt(t, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZzd = zzdq.zzd(zzy(i8), bArr, i, i2, zzdpVar);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzdpVar.zzc);
                } else {
                    unsafe.putObject(t, j, zzev.zzg(object, zzdpVar.zzc));
                }
                unsafe.putInt(t, j2, i4);
                return iZzd;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzdq.zza(bArr, i, zzdpVar);
                unsafe.putObject(t, j, zzdpVar.zzc);
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzdq.zzj(bArr, i, zzdpVar);
                int i10 = zzdpVar.zza;
                zzet zzetVarZzx = zzx(i8);
                if (zzetVarZzx == null || zzetVarZzx.zza()) {
                    unsafe.putObject(t, j, Integer.valueOf(i10));
                    unsafe.putInt(t, j2, i4);
                } else {
                    zzc(t).zzf(i3, Long.valueOf(i10));
                }
                return iZzj3;
            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzdq.zzj(bArr, i, zzdpVar);
                unsafe.putObject(t, j, Integer.valueOf(zzee.zzb(zzdpVar.zza)));
                unsafe.putInt(t, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzdq.zzm(bArr, i, zzdpVar);
                unsafe.putObject(t, j, Long.valueOf(zzee.zzc(zzdpVar.zzb)));
                unsafe.putInt(t, j2, i4);
                return iZzm3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iZzc = zzdq.zzc(zzy(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdpVar);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j, zzdpVar.zzc);
                } else {
                    unsafe.putObject(t, j, zzev.zzg(object2, zzdpVar.zzc));
                }
                unsafe.putInt(t, j2, i4);
                return iZzc;
            default:
                return i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02a0 A[PHI: r0 r18 r23 r26 r27 r28
  0x02a0: PHI (r0v55 int) = (r0v50 int), (r0v53 int), (r0v57 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02a0: PHI (r18v5 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02a0: PHI (r23v3 int) = (r23v1 int), (r23v1 int), (r23v4 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02a0: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02a0: PHI (r27v6 int) = (r27v4 int), (r27v4 int), (r27v7 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02a0: PHI (r28v7 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x02bb A[PHI: r0 r18 r23 r26 r27 r28
  0x02bb: PHI (r0v54 int) = (r0v50 int), (r0v53 int), (r0v57 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r18v4 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r23v2 int) = (r23v1 int), (r23v1 int), (r23v4 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r27v5 int) = (r27v4 int), (r27v4 int), (r27v7 int) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r28v6 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:114:0x0310, B:110:0x02f1, B:100:0x029e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0086. Please report as an issue. */
    private final int zzo(T t, byte[] bArr, int i, int i2, zzdp zzdpVar) throws zzew {
        int i3;
        int iZzk;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int iZzm;
        int iZzd;
        int i10;
        int i11;
        int i12;
        this = this;
        t = t;
        bArr = bArr;
        i2 = i2;
        zzdpVar = zzdpVar;
        Unsafe unsafe2 = zzb;
        int i13 = 1048575;
        int i14 = -1;
        int iZzi = i;
        int i15 = -1;
        int i16 = 1048575;
        int i17 = 0;
        int i18 = 0;
        while (iZzi < i2) {
            int i19 = iZzi + 1;
            byte b = bArr[iZzi];
            if (b < 0) {
                iZzk = zzdq.zzk(b, bArr, i19, zzdpVar);
                i3 = zzdpVar.zza;
            } else {
                i3 = b;
                iZzk = i19;
            }
            int i20 = i3 >>> 3;
            int i21 = i3 & 7;
            int iZzr = i20 > i15 ? this.zzr(i20, i17 / 3) : this.zzq(i20);
            if (iZzr == i14) {
                i4 = iZzk;
                i5 = i20;
                i6 = i14;
                unsafe = unsafe2;
                i7 = 0;
            } else {
                int i22 = this.zzc[iZzr + 1];
                int iZzu = zzu(i22);
                long j = i22 & i13;
                if (iZzu <= 17) {
                    int i23 = this.zzc[iZzr + 2];
                    int i24 = 1 << (i23 >>> 20);
                    i13 = 1048575;
                    int i25 = i23 & 1048575;
                    if (i25 != i16) {
                        if (i16 != 1048575) {
                            unsafe2.putInt(t, i16, i18);
                            i13 = 1048575;
                        }
                        if (i25 != i13) {
                            i18 = unsafe2.getInt(t, i25);
                        }
                        i16 = i25;
                    }
                    switch (iZzu) {
                        case 0:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            i9 = i18;
                            if (i21 != 1) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                zzgz.zzl(t, j, Double.longBitsToDouble(zzdq.zzn(bArr, iZzk)));
                                iZzi = iZzk + 8;
                                i18 = i9 | i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 1:
                            i5 = i20;
                            i9 = i18;
                            i8 = iZzr;
                            if (i21 != 5) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                zzgz.zzm(t, j, Float.intBitsToFloat(zzdq.zzb(bArr, iZzk)));
                                iZzi = iZzk + 4;
                                i18 = i9 | i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            i9 = i18;
                            if (i21 != 0) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzm = zzdq.zzm(bArr, iZzk, zzdpVar);
                                unsafe2.putLong(t, j, zzdpVar.zzb);
                                i18 = i9 | i24;
                                i17 = i8;
                                iZzi = iZzm;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 4:
                        case 11:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            i9 = i18;
                            if (i21 != 0) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzi = zzdq.zzj(bArr, iZzk, zzdpVar);
                                unsafe2.putInt(t, j, zzdpVar.zza);
                                i18 = i9 | i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            i9 = i18;
                            if (i21 != 1) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                unsafe2.putLong(t, j, zzdq.zzn(bArr, iZzk));
                                iZzi = iZzk + 8;
                                i18 = i9 | i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            i5 = i20;
                            i9 = i18;
                            i8 = iZzr;
                            if (i21 != 5) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                unsafe2.putInt(t, j, zzdq.zzb(bArr, iZzk));
                                iZzi = iZzk + 4;
                                i18 = i9 | i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 7:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            i9 = i18;
                            if (i21 != 0) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                int iZzm2 = zzdq.zzm(bArr, iZzk, zzdpVar);
                                zzgz.zzk(t, j, zzdpVar.zzb != 0);
                                i18 = i9 | i24;
                                iZzi = iZzm2;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 8:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            i9 = i18;
                            if (i21 != 2) {
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzi = (536870912 & i22) == 0 ? zzdq.zzg(bArr, iZzk, zzdpVar) : zzdq.zzh(bArr, iZzk, zzdpVar);
                                unsafe2.putObject(t, j, zzdpVar.zzc);
                                i18 = i9 | i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 9:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            if (i21 != 2) {
                                i9 = i18;
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzd = zzdq.zzd(this.zzy(i8), bArr, iZzk, i2, zzdpVar);
                                Object object = unsafe2.getObject(t, j);
                                if (object == null) {
                                    unsafe2.putObject(t, j, zzdpVar.zzc);
                                } else {
                                    unsafe2.putObject(t, j, zzev.zzg(object, zzdpVar.zzc));
                                }
                                i18 |= i24;
                                iZzi = iZzd;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 10:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            if (i21 != 2) {
                                i9 = i18;
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzd = zzdq.zza(bArr, iZzk, zzdpVar);
                                unsafe2.putObject(t, j, zzdpVar.zzc);
                                i18 |= i24;
                                iZzi = iZzd;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 12:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            if (i21 != 0) {
                                i9 = i18;
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzd = zzdq.zzj(bArr, iZzk, zzdpVar);
                                unsafe2.putInt(t, j, zzdpVar.zza);
                                i18 |= i24;
                                iZzi = iZzd;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 15:
                            i5 = i20;
                            zzdpVar = zzdpVar;
                            i8 = iZzr;
                            if (i21 != 0) {
                                i9 = i18;
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                iZzi = zzdq.zzj(bArr, iZzk, zzdpVar);
                                unsafe2.putInt(t, j, zzee.zzb(zzdpVar.zza));
                                i18 |= i24;
                                i17 = i8;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        case 16:
                            if (i21 != 0) {
                                i5 = i20;
                                i8 = iZzr;
                                i9 = i18;
                                i18 = i9;
                                i4 = iZzk;
                                i7 = i8;
                                unsafe = unsafe2;
                                i6 = -1;
                            } else {
                                zzdpVar = zzdpVar;
                                iZzm = zzdq.zzm(bArr, iZzk, zzdpVar);
                                i8 = iZzr;
                                i5 = i20;
                                unsafe2.putLong(t, j, zzee.zzc(zzdpVar.zzb));
                                i18 |= i24;
                                i17 = i8;
                                iZzi = iZzm;
                                i15 = i5;
                                i14 = -1;
                            }
                            break;
                        default:
                            i5 = i20;
                            i8 = iZzr;
                            i9 = i18;
                            i18 = i9;
                            i4 = iZzk;
                            i7 = i8;
                            unsafe = unsafe2;
                            i6 = -1;
                            break;
                    }
                } else {
                    i5 = i20;
                    int i26 = i18;
                    i13 = 1048575;
                    zzdpVar = zzdpVar;
                    if (iZzu != 27) {
                        if (iZzu <= 49) {
                            i11 = i26;
                            int i27 = iZzk;
                            i10 = i16;
                            i7 = iZzr;
                            i6 = -1;
                            unsafe = unsafe2;
                            iZzi = zzp(t, bArr, iZzk, i2, i3, i5, i21, iZzr, i22, iZzu, j, zzdpVar);
                            if (iZzi != i27) {
                                i14 = i6;
                                i15 = i5;
                                i18 = i11;
                                i16 = i10;
                            } else {
                                i4 = iZzi;
                                i18 = i11;
                                i16 = i10;
                            }
                        } else {
                            i10 = i16;
                            i7 = iZzr;
                            unsafe = unsafe2;
                            i11 = i26;
                            i6 = -1;
                            i12 = iZzk;
                            if (iZzu == 50) {
                                if (i21 == 2) {
                                    iZzi = zzm(t, bArr, i12, i2, i7, j, zzdpVar);
                                    if (iZzi != i12) {
                                        i14 = i6;
                                        i15 = i5;
                                        i18 = i11;
                                        i16 = i10;
                                    } else {
                                        i4 = iZzi;
                                    }
                                }
                                i18 = i11;
                                i16 = i10;
                            } else {
                                iZzi = zzn(t, bArr, i12, i2, i3, i5, i21, i22, iZzu, j, i7, zzdpVar);
                                if (iZzi != i12) {
                                    i14 = i6;
                                    i15 = i5;
                                    i18 = i11;
                                    i16 = i10;
                                } else {
                                    i4 = iZzi;
                                    i18 = i11;
                                    i16 = i10;
                                }
                            }
                        }
                        i17 = i7;
                        unsafe2 = unsafe;
                        i13 = 1048575;
                    } else if (i21 == 2) {
                        zzeu zzeuVarZzd = (zzeu) unsafe2.getObject(t, j);
                        if (!zzeuVarZzd.zzc()) {
                            int size = zzeuVarZzd.size();
                            zzeuVarZzd = zzeuVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(t, j, zzeuVarZzd);
                        }
                        iZzi = zzdq.zze(this.zzy(iZzr), i3, bArr, iZzk, i2, zzeuVarZzd, zzdpVar);
                        i17 = iZzr;
                        i18 = i26;
                        i15 = i5;
                        i14 = -1;
                        this = this;
                    } else {
                        i12 = iZzk;
                        i10 = i16;
                        i7 = iZzr;
                        unsafe = unsafe2;
                        i11 = i26;
                        i6 = -1;
                    }
                    i4 = i12;
                    i18 = i11;
                    i16 = i10;
                }
            }
            iZzi = zzdq.zzi(i3, bArr, i4, i2, zzc(t), zzdpVar);
            i14 = i6;
            i15 = i5;
            i17 = i7;
            unsafe2 = unsafe;
            i13 = 1048575;
        }
        int i28 = i18;
        Unsafe unsafe3 = unsafe2;
        if (i16 != i13) {
            unsafe3.putInt(t, i16, i28);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzew.zzd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zzp(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzdp zzdpVar) throws zzew {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzeu zzeuVarZzd = (zzeu) unsafe.getObject(t, j2);
        if (!zzeuVarZzd.zzc()) {
            int size = zzeuVarZzd.size();
            zzeuVarZzd = zzeuVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(t, j2, zzeuVarZzd);
        }
        switch (i7) {
            case 18:
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                if (i5 == 2) {
                    zzef zzefVar = (zzef) zzeuVarZzd;
                    int iZzj3 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i12 = zzdpVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zzefVar.zze(Double.longBitsToDouble(zzdq.zzn(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 1) {
                    zzef zzefVar2 = (zzef) zzeuVarZzd;
                    zzefVar2.zze(Double.longBitsToDouble(zzdq.zzn(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzdq.zzj(bArr, i8, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzefVar2.zze(Double.longBitsToDouble(zzdq.zzn(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                if (i5 == 2) {
                    zzem zzemVar = (zzem) zzeuVarZzd;
                    int iZzj4 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i13 = zzdpVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzemVar.zze(Float.intBitsToFloat(zzdq.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 5) {
                    zzem zzemVar2 = (zzem) zzeuVarZzd;
                    zzemVar2.zze(Float.intBitsToFloat(zzdq.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzdq.zzj(bArr, i9, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzemVar2.zze(Float.intBitsToFloat(zzdq.zzb(bArr, iZzj2)));
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
                    zzff zzffVar = (zzff) zzeuVarZzd;
                    int iZzj5 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i14 = zzdpVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzdq.zzm(bArr, iZzj5, zzdpVar);
                        zzffVar.zze(zzdpVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 0) {
                    zzff zzffVar2 = (zzff) zzeuVarZzd;
                    int iZzm = zzdq.zzm(bArr, iZzj2, zzdpVar);
                    zzffVar2.zze(zzdpVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzdq.zzj(bArr, iZzm, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzdq.zzm(bArr, iZzj6, zzdpVar);
                        zzffVar2.zze(zzdpVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case 43:
                if (i5 == 2) {
                    return zzdq.zzf(bArr, iZzj2, zzeuVarZzd, zzdpVar);
                }
                if (i5 == 0) {
                    return zzdq.zzl(i3, bArr, i, i2, zzeuVarZzd, zzdpVar);
                }
                return iZzj2;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 32:
            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 46:
                if (i5 == 2) {
                    zzff zzffVar3 = (zzff) zzeuVarZzd;
                    int iZzj7 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i15 = zzdpVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzffVar3.zze(zzdq.zzn(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 1) {
                    zzff zzffVar4 = (zzff) zzeuVarZzd;
                    zzffVar4.zze(zzdq.zzn(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzdq.zzj(bArr, i10, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzffVar4.zze(zzdq.zzn(bArr, iZzj2));
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
                    zzer zzerVar = (zzer) zzeuVarZzd;
                    int iZzj8 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i16 = zzdpVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzerVar.zze(zzdq.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 5) {
                    zzer zzerVar2 = (zzer) zzeuVarZzd;
                    zzerVar2.zze(zzdq.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzdq.zzj(bArr, i11, zzdpVar);
                            if (i3 == zzdpVar.zza) {
                                zzerVar2.zze(zzdq.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzdr zzdrVar = (zzdr) zzeuVarZzd;
                    iZzj = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i17 = zzdpVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzdq.zzm(bArr, iZzj, zzdpVar);
                        zzdrVar.zze(zzdpVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzew.zzf();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzdr zzdrVar2 = (zzdr) zzeuVarZzd;
                    int iZzm2 = zzdq.zzm(bArr, iZzj2, zzdpVar);
                    zzdrVar2.zze(zzdpVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzdq.zzj(bArr, iZzm2, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzdq.zzm(bArr, iZzj9, zzdpVar);
                        zzdrVar2.zze(zzdpVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                        int i18 = zzdpVar.zza;
                        if (i18 < 0) {
                            throw zzew.zzc();
                        }
                        if (i18 == 0) {
                            zzeuVarZzd.add("");
                        } else {
                            zzeuVarZzd.add(new String(bArr, iZzj10, i18, zzev.zza));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzdq.zzj(bArr, iZzj10, zzdpVar);
                            if (i3 != zzdpVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzdq.zzj(bArr, iZzj11, zzdpVar);
                            int i19 = zzdpVar.zza;
                            if (i19 < 0) {
                                throw zzew.zzc();
                            }
                            if (i19 == 0) {
                                zzeuVarZzd.add("");
                            } else {
                                zzeuVarZzd.add(new String(bArr, iZzj10, i19, zzev.zza));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i20 = zzdpVar.zza;
                    if (i20 < 0) {
                        throw zzew.zzc();
                    }
                    if (i20 == 0) {
                        zzeuVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzhd.zzd(bArr, iZzj12, i21)) {
                            throw zzew.zzb();
                        }
                        zzeuVarZzd.add(new String(bArr, iZzj12, i20, zzev.zza));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzdq.zzj(bArr, iZzj12, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzdq.zzj(bArr, iZzj13, zzdpVar);
                        int i22 = zzdpVar.zza;
                        if (i22 < 0) {
                            throw zzew.zzc();
                        }
                        if (i22 == 0) {
                            zzeuVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzhd.zzd(bArr, iZzj12, i23)) {
                                throw zzew.zzb();
                            }
                            zzeuVarZzd.add(new String(bArr, iZzj12, i22, zzev.zza));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                if (i5 == 2) {
                    return zzdq.zze(zzy(i6), i3, bArr, i, i2, zzeuVarZzd, zzdpVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i24 = zzdpVar.zza;
                    if (i24 < 0) {
                        throw zzew.zzc();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzew.zzf();
                    }
                    if (i24 == 0) {
                        zzeuVarZzd.add(zzeb.zzb);
                    } else {
                        zzeuVarZzd.add(zzeb.zzk(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzdq.zzj(bArr, iZzj14, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzdq.zzj(bArr, iZzj15, zzdpVar);
                        int i25 = zzdpVar.zza;
                        if (i25 < 0) {
                            throw zzew.zzc();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzew.zzf();
                        }
                        if (i25 == 0) {
                            zzeuVarZzd.add(zzeb.zzb);
                        } else {
                            zzeuVarZzd.add(zzeb.zzk(bArr, iZzj14, i25));
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
                        iZzj = zzdq.zzl(i3, bArr, i, i2, zzeuVarZzd, zzdpVar);
                    }
                    return iZzj2;
                }
                iZzj = zzdq.zzf(bArr, iZzj2, zzeuVarZzd, zzdpVar);
                zzeq zzeqVar = (zzeq) t;
                zzgq zzgqVar = zzeqVar.zzc;
                if (zzgqVar == zzgq.zza()) {
                    zzgqVar = null;
                }
                Object objZzd = zzgd.zzd(i4, zzeuVarZzd, zzx(i6), zzgqVar, this.zzm);
                if (objZzd != null) {
                    zzeqVar.zzc = (zzgq) objZzd;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzer zzerVar3 = (zzer) zzeuVarZzd;
                    int iZzj16 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i26 = zzdpVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzdq.zzj(bArr, iZzj16, zzdpVar);
                        zzerVar3.zze(zzee.zzb(zzdpVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 0) {
                    zzer zzerVar4 = (zzer) zzeuVarZzd;
                    int iZzj17 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    zzerVar4.zze(zzee.zzb(zzdpVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzdq.zzj(bArr, iZzj17, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzdq.zzj(bArr, iZzj18, zzdpVar);
                        zzerVar4.zze(zzee.zzb(zzdpVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzff zzffVar5 = (zzff) zzeuVarZzd;
                    int iZzj19 = zzdq.zzj(bArr, iZzj2, zzdpVar);
                    int i27 = zzdpVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzdq.zzm(bArr, iZzj19, zzdpVar);
                        zzffVar5.zze(zzee.zzc(zzdpVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzew.zzf();
                }
                if (i5 == 0) {
                    zzff zzffVar6 = (zzff) zzeuVarZzd;
                    int iZzm3 = zzdq.zzm(bArr, iZzj2, zzdpVar);
                    zzffVar6.zze(zzee.zzc(zzdpVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzdq.zzj(bArr, iZzm3, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzdq.zzm(bArr, iZzj20, zzdpVar);
                        zzffVar6.zze(zzee.zzc(zzdpVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzgb zzgbVarZzy = zzy(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzdq.zzc(zzgbVarZzy, bArr, i, i2, i28, zzdpVar);
                    zzeuVarZzd.add(zzdpVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzdq.zzj(bArr, iZzc, zzdpVar);
                        if (i3 != zzdpVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzdq.zzc(zzgbVarZzy, bArr, iZzj21, i2, i28, zzdpVar);
                        zzeuVarZzd.add(zzdpVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, 0);
    }

    private final int zzr(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, i2);
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private final int zzt(int i, int i2) {
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

    private static int zzu(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzw(T t, long j) {
        return ((Long) zzgz.zzf(t, j)).longValue();
    }

    private final zzet zzx(int i) {
        int i2 = i / 3;
        return (zzet) this.zzd[i2 + i2 + 1];
    }

    private final zzgb zzy(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgb zzgbVar = (zzgb) this.zzd[i3];
        if (zzgbVar != null) {
            return zzgbVar;
        }
        zzgb<T> zzgbVarZzb = zzfy.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzgbVarZzb;
        return zzgbVarZzb;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final int zza(T t) {
        int i;
        int iZzc;
        int i2;
        int iZzc2;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzv = zzv(i4);
            int i5 = this.zzc[i4];
            long j = 1048575 & iZzv;
            int iHashCode = 37;
            switch (zzu(iZzv)) {
                case 0:
                    i = i3 * 53;
                    iZzc = zzev.zzc(Double.doubleToLongBits(zzgz.zza(t, j)));
                    i3 = iZzc + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iZzc = Float.floatToIntBits(zzgz.zzb(t, j));
                    i3 = iZzc + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iZzc = zzev.zzc(zzgz.zzd(t, j));
                    i3 = iZzc + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iZzc = zzev.zzc(zzgz.zzd(t, j));
                    i3 = iZzc + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    iZzc2 = zzgz.zzc(t, j);
                    i3 = i2 + iZzc2;
                    break;
                case 5:
                    i = i3 * 53;
                    iZzc = zzev.zzc(zzgz.zzd(t, j));
                    i3 = iZzc + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    iZzc2 = zzgz.zzc(t, j);
                    i3 = i2 + iZzc2;
                    break;
                case 7:
                    i = i3 * 53;
                    iZzc = zzev.zza(zzgz.zzt(t, j));
                    i3 = iZzc + i;
                    break;
                case 8:
                    i = i3 * 53;
                    iZzc = ((String) zzgz.zzf(t, j)).hashCode();
                    i3 = iZzc + i;
                    break;
                case 9:
                    Object objZzf = zzgz.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iZzc = zzgz.zzf(t, j).hashCode();
                    i3 = iZzc + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iZzc2 = zzgz.zzc(t, j);
                    i3 = i2 + iZzc2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iZzc2 = zzgz.zzc(t, j);
                    i3 = i2 + iZzc2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iZzc2 = zzgz.zzc(t, j);
                    i3 = i2 + iZzc2;
                    break;
                case 14:
                    i = i3 * 53;
                    iZzc = zzev.zzc(zzgz.zzd(t, j));
                    i3 = iZzc + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    iZzc2 = zzgz.zzc(t, j);
                    i3 = i2 + iZzc2;
                    break;
                case 16:
                    i = i3 * 53;
                    iZzc = zzev.zzc(zzgz.zzd(t, j));
                    i3 = iZzc + i;
                    break;
                case 17:
                    Object objZzf2 = zzgz.zzf(t, j);
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
                    iZzc = zzgz.zzf(t, j).hashCode();
                    i3 = iZzc + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iZzc = zzgz.zzf(t, j).hashCode();
                    i3 = iZzc + i;
                    break;
                case 51:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zzc(Double.doubleToLongBits(((Double) zzgz.zzf(t, j)).doubleValue()));
                        i3 = iZzc + i;
                    }
                    break;
                case 52:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = Float.floatToIntBits(((Float) zzgz.zzf(t, j)).floatValue());
                        i3 = iZzc + i;
                    }
                    break;
                case 53:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zzc(zzw(t, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 54:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zzc(zzw(t, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 55:
                    if (zzJ(t, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzl(t, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 56:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zzc(zzw(t, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 57:
                    if (zzJ(t, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzl(t, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 58:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zza(((Boolean) zzgz.zzf(t, j)).booleanValue());
                        i3 = iZzc + i;
                    }
                    break;
                case 59:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = ((String) zzgz.zzf(t, j)).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
                case 60:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzgz.zzf(t, j).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
                case 61:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzgz.zzf(t, j).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
                case 62:
                    if (zzJ(t, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzl(t, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 63:
                    if (zzJ(t, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzl(t, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 64:
                    if (zzJ(t, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzl(t, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 65:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zzc(zzw(t, j));
                        i3 = iZzc + i;
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzJ(t, i5, i4)) {
                        i2 = i3 * 53;
                        iZzc2 = zzl(t, j);
                        i3 = i2 + iZzc2;
                    }
                    break;
                case 67:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzev.zzc(zzw(t, j));
                        i3 = iZzc + i;
                    }
                    break;
                case 68:
                    if (zzJ(t, i5, i4)) {
                        i = i3 * 53;
                        iZzc = zzgz.zzf(t, j).hashCode();
                        i3 = iZzc + i;
                    }
                    break;
            }
        }
        return this.zzm.zza(t).hashCode() + (i3 * 53);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x03be A[PHI: r0 r25 r26 r27
  0x03be: PHI (r0v23 int) = (r0v18 int), (r0v21 int), (r0v25 int) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]
  0x03be: PHI (r25v4 int) = (r25v2 int), (r25v2 int), (r25v6 int) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]
  0x03be: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]
  0x03be: PHI (r27v7 sun.misc.Unsafe) = (r27v5 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:126:0x03d8 A[PHI: r0 r25 r26 r27
  0x03d8: PHI (r0v22 int) = (r0v18 int), (r0v21 int), (r0v25 int) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]
  0x03d8: PHI (r25v3 int) = (r25v2 int), (r25v2 int), (r25v6 int) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]
  0x03d8: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]
  0x03d8: PHI (r27v6 sun.misc.Unsafe) = (r27v5 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:137:0x0428, B:133:0x0407, B:123:0x03bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x008f. Please report as an issue. */
    public final int zzb(T t, byte[] bArr, int i, int i2, int i3, zzdp zzdpVar) throws zzew {
        Unsafe unsafe;
        T t2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        byte[] bArr2;
        int i13;
        int i14;
        int i15;
        byte[] bArr3;
        int i16;
        byte[] bArr4;
        this = this;
        t = t;
        bArr = bArr;
        i2 = i2;
        i3 = i3;
        zzdpVar = zzdpVar;
        Unsafe unsafe2 = zzb;
        int iZzi = i;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 1048575;
        while (true) {
            if (iZzi < i2) {
                int i22 = iZzi + 1;
                byte b = bArr[iZzi];
                if (b < 0) {
                    int iZzk = zzdq.zzk(b, bArr, i22, zzdpVar);
                    i4 = zzdpVar.zza;
                    i22 = iZzk;
                } else {
                    i4 = b;
                }
                int i23 = i4 >>> 3;
                int i24 = i4 & 7;
                int iZzr = i23 > i20 ? this.zzr(i23, i18 / 3) : this.zzq(i23);
                if (iZzr == -1) {
                    i5 = i23;
                    i6 = i4;
                    i7 = i19;
                    unsafe = unsafe2;
                    i3 = i3;
                    i8 = 0;
                    i9 = i22;
                } else {
                    int i25 = this.zzc[iZzr + 1];
                    int iZzu = zzu(i25);
                    int i26 = i22;
                    long j = i25 & 1048575;
                    int i27 = i4;
                    if (iZzu <= 17) {
                        int i28 = this.zzc[iZzr + 2];
                        int i29 = 1 << (i28 >>> 20);
                        int i30 = i28 & 1048575;
                        if (i30 != i21) {
                            if (i21 != 1048575) {
                                unsafe2.putInt(t, i21, i19);
                            }
                            i19 = unsafe2.getInt(t, i30);
                            i21 = i30;
                        } else {
                            i21 = i21;
                        }
                        int i31 = i19;
                        switch (iZzu) {
                            case 0:
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                bArr3 = bArr;
                                i15 = i27;
                                if (i24 == 1) {
                                    zzgz.zzl(t, j, Double.longBitsToDouble(zzdq.zzn(bArr3, i14)));
                                    iZzi = i14 + 8;
                                    i19 = i31 | i29;
                                    bArr = bArr3;
                                    i18 = i13;
                                    i21 = i21;
                                    i17 = i15;
                                    i20 = i5;
                                    i3 = i3;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 1:
                                bArr3 = bArr;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 5) {
                                    zzgz.zzm(t, j, Float.intBitsToFloat(zzdq.zzb(bArr3, i14)));
                                    iZzi = i14 + 4;
                                    i19 = i31 | i29;
                                    bArr = bArr3;
                                    i18 = i13;
                                    i21 = i21;
                                    i17 = i15;
                                    i20 = i5;
                                    i3 = i3;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 2:
                            case 3:
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 0) {
                                    int iZzm = zzdq.zzm(bArr, i14, zzdpVar);
                                    bArr = bArr;
                                    unsafe2.putLong(t, j, zzdpVar.zzb);
                                    i19 = i31 | i29;
                                    i18 = i13;
                                    iZzi = iZzm;
                                    i21 = i21;
                                    i17 = i15;
                                    i20 = i5;
                                    i3 = i3;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr3 = bArr;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 0) {
                                    iZzi = zzdq.zzj(bArr3, i14, zzdpVar);
                                    unsafe2.putInt(t, j, zzdpVar.zza);
                                    i19 = i31 | i29;
                                    bArr = bArr3;
                                    i18 = i13;
                                    i21 = i21;
                                    i17 = i15;
                                    i20 = i5;
                                    i3 = i3;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 5:
                            case 14:
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 1) {
                                    unsafe2.putLong(t, j, zzdq.zzn(bArr, i14));
                                    iZzi = i14 + 8;
                                    i19 = i31 | i29;
                                    i18 = i13;
                                    bArr = bArr;
                                    i21 = i21;
                                    i17 = i15;
                                    i20 = i5;
                                    i3 = i3;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 6:
                            case 13:
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 5) {
                                    bArr3 = bArr;
                                    unsafe2.putInt(t, j, zzdq.zzb(bArr3, i14));
                                    iZzi = i14 + 4;
                                    i19 = i31 | i29;
                                    bArr = bArr3;
                                    i18 = i13;
                                    i21 = i21;
                                    i17 = i15;
                                    i20 = i5;
                                    i3 = i3;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 7:
                                i16 = i2;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 0) {
                                    iZzi = zzdq.zzm(bArr, i14, zzdpVar);
                                    zzgz.zzk(t, j, zzdpVar.zzb != 0);
                                    i19 = i31 | i29;
                                    bArr = bArr;
                                    i18 = i13;
                                    i20 = i5;
                                    int i32 = i15;
                                    i2 = i16;
                                    i17 = i32;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 8:
                                bArr4 = bArr;
                                i16 = i2;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 2) {
                                    iZzi = (536870912 & i25) == 0 ? zzdq.zzg(bArr4, i14, zzdpVar) : zzdq.zzh(bArr4, i14, zzdpVar);
                                    unsafe2.putObject(t, j, zzdpVar.zzc);
                                    bArr = bArr4;
                                    i18 = i13;
                                    i19 = i31 | i29;
                                    i20 = i5;
                                    int i33 = i15;
                                    i2 = i16;
                                    i17 = i33;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 9:
                                bArr4 = bArr;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 2) {
                                    i16 = i2;
                                    iZzi = zzdq.zzd(this.zzy(i13), bArr4, i14, i16, zzdpVar);
                                    if ((i31 & i29) == 0) {
                                        unsafe2.putObject(t, j, zzdpVar.zzc);
                                    } else {
                                        unsafe2.putObject(t, j, zzev.zzg(unsafe2.getObject(t, j), zzdpVar.zzc));
                                    }
                                    bArr = bArr4;
                                    i18 = i13;
                                    i19 = i31 | i29;
                                    i20 = i5;
                                    int i34 = i15;
                                    i2 = i16;
                                    i17 = i34;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 2) {
                                    iZzi = zzdq.zza(bArr2, i14, zzdpVar);
                                    unsafe2.putObject(t, j, zzdpVar.zzc);
                                    int i35 = i31 | i29;
                                    bArr = bArr2;
                                    i18 = i13;
                                    i21 = i21;
                                    i20 = i5;
                                    i3 = i3;
                                    i19 = i35;
                                    i17 = i15;
                                    i2 = i2;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 0) {
                                    iZzi = zzdq.zzj(bArr2, i14, zzdpVar);
                                    int i36 = zzdpVar.zza;
                                    zzet zzetVarZzx = this.zzx(i13);
                                    if (zzetVarZzx == null || zzetVarZzx.zza()) {
                                        unsafe2.putInt(t, j, i36);
                                        int i37 = i31 | i29;
                                        bArr = bArr2;
                                        i18 = i13;
                                        i21 = i21;
                                        i20 = i5;
                                        i3 = i3;
                                        i19 = i37;
                                        i17 = i15;
                                        i2 = i2;
                                    } else {
                                        zzc(t).zzf(i15, Long.valueOf(i36));
                                        bArr = bArr2;
                                        i19 = i31;
                                        i18 = i13;
                                        i21 = i21;
                                        i17 = i15;
                                        i20 = i5;
                                        i3 = i3;
                                    }
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                i15 = i27;
                                if (i24 == 0) {
                                    iZzi = zzdq.zzj(bArr2, i14, zzdpVar);
                                    unsafe2.putInt(t, j, zzee.zzb(zzdpVar.zza));
                                    int i38 = i31 | i29;
                                    bArr = bArr2;
                                    i18 = i13;
                                    i21 = i21;
                                    i20 = i5;
                                    i3 = i3;
                                    i19 = i38;
                                    i17 = i15;
                                    i2 = i2;
                                } else {
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            case 16:
                                i5 = i23;
                                i13 = iZzr;
                                i14 = i26;
                                if (i24 == 0) {
                                    int iZzm2 = zzdq.zzm(bArr, i14, zzdpVar);
                                    unsafe2.putLong(t, j, zzee.zzc(zzdpVar.zzb));
                                    i19 = i31 | i29;
                                    i18 = i13;
                                    i21 = i21;
                                    iZzi = iZzm2;
                                    i17 = i27;
                                    i20 = i5;
                                    i2 = i2;
                                    i3 = i3;
                                    bArr = bArr;
                                } else {
                                    i15 = i27;
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                            default:
                                if (i24 == 3) {
                                    iZzi = zzdq.zzc(this.zzy(iZzr), bArr, i26, i2, (i23 << 3) | 4, zzdpVar);
                                    if ((i31 & i29) == 0) {
                                        unsafe2.putObject(t, j, zzdpVar.zzc);
                                    } else {
                                        unsafe2.putObject(t, j, zzev.zzg(unsafe2.getObject(t, j), zzdpVar.zzc));
                                    }
                                    i19 = i31 | i29;
                                    bArr = bArr;
                                    i18 = iZzr;
                                    i17 = i27;
                                    i21 = i21;
                                    i20 = i23;
                                    i3 = i3;
                                } else {
                                    i5 = i23;
                                    i13 = iZzr;
                                    i14 = i26;
                                    i15 = i27;
                                    i7 = i31;
                                    i8 = i13;
                                    unsafe = unsafe2;
                                    i21 = i21;
                                    i9 = i14;
                                    i6 = i15;
                                    i3 = i3;
                                }
                                break;
                        }
                    } else {
                        i5 = i23;
                        if (iZzu != 27) {
                            i7 = i19;
                            i10 = i21;
                            if (iZzu <= 49) {
                                unsafe = unsafe2;
                                i8 = iZzr;
                                i12 = i27;
                                iZzi = zzp(t, bArr, i26, i2, i27, i5, i24, iZzr, i25, iZzu, j, zzdpVar);
                                if (iZzi != i26) {
                                    i3 = i3;
                                    i20 = i5;
                                    i19 = i7;
                                    i21 = i10;
                                    i18 = i8;
                                    i17 = i12;
                                } else {
                                    i9 = iZzi;
                                    i21 = i10;
                                    i6 = i12;
                                }
                                unsafe2 = unsafe;
                            } else {
                                unsafe = unsafe2;
                                i8 = iZzr;
                                i11 = i26;
                                i12 = i27;
                                if (iZzu == 50) {
                                    if (i24 == 2) {
                                        iZzi = zzm(t, bArr, i11, i2, i8, j, zzdpVar);
                                        if (iZzi != i11) {
                                            i3 = i3;
                                            i20 = i5;
                                            i19 = i7;
                                            i21 = i10;
                                            i18 = i8;
                                            i17 = i12;
                                        } else {
                                            i9 = iZzi;
                                        }
                                        unsafe2 = unsafe;
                                    }
                                    i21 = i10;
                                    i6 = i12;
                                } else {
                                    iZzi = zzn(t, bArr, i11, i2, i12, i5, i24, i25, iZzu, j, i8, zzdpVar);
                                    if (iZzi != i11) {
                                        i3 = i3;
                                        i20 = i5;
                                        i19 = i7;
                                        i21 = i10;
                                        i18 = i8;
                                        i17 = i12;
                                    } else {
                                        i9 = iZzi;
                                        i21 = i10;
                                        i6 = i12;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                        } else if (i24 == 2) {
                            zzeu zzeuVarZzd = (zzeu) unsafe2.getObject(t, j);
                            if (!zzeuVarZzd.zzc()) {
                                int size = zzeuVarZzd.size();
                                zzeuVarZzd = zzeuVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(t, j, zzeuVarZzd);
                            }
                            i17 = i27;
                            iZzi = zzdq.zze(this.zzy(iZzr), i17, bArr, i26, i2, zzeuVarZzd, zzdpVar);
                            bArr = bArr;
                            i18 = iZzr;
                            i20 = i5;
                            i19 = i19;
                            i21 = i21;
                            i3 = i3;
                        } else {
                            i7 = i19;
                            i10 = i21;
                            unsafe = unsafe2;
                            i8 = iZzr;
                            i11 = i26;
                            i12 = i27;
                        }
                        i9 = i11;
                        i21 = i10;
                        i6 = i12;
                    }
                }
                if (i6 != i3 || i3 == 0) {
                    iZzi = zzdq.zzi(i6, bArr, i9, i2, zzc(t), zzdpVar);
                    i3 = i3;
                    i17 = i6;
                    i20 = i5;
                    i19 = i7;
                    i18 = i8;
                    unsafe2 = unsafe;
                } else {
                    iZzi = i9;
                    i17 = i6;
                    i19 = i7;
                }
            } else {
                unsafe = unsafe2;
                i3 = i3;
            }
        }
        if (i21 != 1048575) {
            long j2 = i21;
            t2 = t;
            unsafe.putInt(t2, j2, i19);
        } else {
            t2 = t;
        }
        for (int i39 = this.zzj; i39 < this.zzk; i39++) {
            int i40 = this.zzi[i39];
            int i41 = this.zzc[i40];
            Object objZzf = zzgz.zzf(t2, zzv(i40) & 1048575);
            if (objZzf != null && zzx(i40) != null) {
                throw null;
            }
        }
        if (i3 == 0) {
            if (iZzi != i2) {
                throw zzew.zzd();
            }
        } else if (iZzi > i2 || i17 != i3) {
            throw zzew.zzd();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final T zzd() {
        return (T) ((zzeq) this.zzg).zzj(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zze(T t) {
        int i;
        int i2 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i2 >= i) {
                break;
            }
            long jZzv = zzv(this.zzi[i2]) & 1048575;
            Object objZzf = zzgz.zzf(t, jZzv);
            if (objZzf != null) {
                ((zzfk) objZzf).zzc();
                zzgz.zzp(t, jZzv, objZzf);
            }
            i2++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(t, this.zzi[i]);
            i++;
        }
        this.zzm.zze(t);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzf(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzv = zzv(i);
            long j = 1048575 & iZzv;
            int i2 = this.zzc[i];
            switch (zzu(iZzv)) {
                case 0:
                    if (zzG(t2, i)) {
                        zzgz.zzl(t, j, zzgz.zza(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 1:
                    if (zzG(t2, i)) {
                        zzgz.zzm(t, j, zzgz.zzb(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 2:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 3:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 4:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 5:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 6:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 7:
                    if (zzG(t2, i)) {
                        zzgz.zzk(t, j, zzgz.zzt(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 8:
                    if (zzG(t2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 9:
                    zzB(t, t2, i);
                    break;
                case 10:
                    if (zzG(t2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 11:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 12:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 13:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 14:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 15:
                    if (zzG(t2, i)) {
                        zzgz.zzn(t, j, zzgz.zzc(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 16:
                    if (zzG(t2, i)) {
                        zzgz.zzo(t, j, zzgz.zzd(t2, j));
                        zzD(t, i);
                    }
                    break;
                case 17:
                    zzB(t, t2, i);
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
                    this.zzl.zzb(t, t2, j);
                    break;
                case 50:
                    zzgd.zzi(this.zzp, t, t2, j);
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
                    if (zzJ(t2, i2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzE(t, i2, i);
                    }
                    break;
                case 60:
                    zzC(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                case 67:
                    if (zzJ(t2, i2, i)) {
                        zzgz.zzp(t, j, zzgz.zzf(t2, j));
                        zzE(t, i2, i);
                    }
                    break;
                case 68:
                    zzC(t, t2, i);
                    break;
            }
        }
        zzgd.zzf(this.zzm, t, t2);
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzg(T t, byte[] bArr, int i, int i2, zzdp zzdpVar) throws zzew {
        if (this.zzh) {
            zzo(t, bArr, i, i2, zzdpVar);
        } else {
            zzb(t, bArr, i, i2, 0, zzdpVar);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzh(T t, T t2) {
        boolean zZzh;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzv = zzv(i);
            long j = iZzv & 1048575;
            switch (zzu(iZzv)) {
                case 0:
                    if (!zzF(t, t2, i) || Double.doubleToLongBits(zzgz.zza(t, j)) != Double.doubleToLongBits(zzgz.zza(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzF(t, t2, i) || Float.floatToIntBits(zzgz.zzb(t, j)) != Float.floatToIntBits(zzgz.zzb(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzF(t, t2, i) || zzgz.zzd(t, j) != zzgz.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzF(t, t2, i) || zzgz.zzd(t, j) != zzgz.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzF(t, t2, i) || zzgz.zzc(t, j) != zzgz.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzF(t, t2, i) || zzgz.zzd(t, j) != zzgz.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzF(t, t2, i) || zzgz.zzc(t, j) != zzgz.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzF(t, t2, i) || zzgz.zzt(t, j) != zzgz.zzt(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzF(t, t2, i) || !zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzF(t, t2, i) || !zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzF(t, t2, i) || !zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzF(t, t2, i) || zzgz.zzc(t, j) != zzgz.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzF(t, t2, i) || zzgz.zzc(t, j) != zzgz.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzF(t, t2, i) || zzgz.zzc(t, j) != zzgz.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzF(t, t2, i) || zzgz.zzd(t, j) != zzgz.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzF(t, t2, i) || zzgz.zzc(t, j) != zzgz.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzF(t, t2, i) || zzgz.zzd(t, j) != zzgz.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzF(t, t2, i) || !zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
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
                    zZzh = zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j));
                    break;
                case 50:
                    zZzh = zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j));
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
                    long jZzs = zzs(i) & 1048575;
                    if (zzgz.zzc(t, jZzs) != zzgz.zzc(t2, jZzs) || !zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzh) {
                return false;
            }
        }
        return this.zzm.zza(t).equals(this.zzm.zza(t2));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzi(T t) {
        int i;
        int i2;
        List list;
        zzgb zzgbVarZzy;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzj) {
            int i7 = this.zzi[i6];
            int i8 = this.zzc[i7];
            int iZzv = zzv(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(t, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzv) != 0 && !zzH(t, i7, i, i2, i11)) {
                return false;
            }
            int iZzu = zzu(iZzv);
            if (iZzu == 9 || iZzu == 17) {
                if (zzH(t, i7, i, i2, i11) && !zzI(t, iZzv, zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 27) {
                list = (List) zzgz.zzf(t, iZzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgbVarZzy = zzy(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgbVarZzy.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzu == 60 || iZzu == 68) {
                if (zzJ(t, i8, i7) && !zzI(t, iZzv, zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 49) {
                list = (List) zzgz.zzf(t, iZzv & 1048575);
                if (list.isEmpty()) {
                    zzgbVarZzy = zzy(i7);
                    while (i3 < list.size()) {
                        if (!zzgbVarZzy.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzu == 50 && !((zzfk) zzgz.zzf(t, iZzv & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return true;
    }
}
