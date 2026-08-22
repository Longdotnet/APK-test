package com.google.android.gms.internal.play_billing;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.google.protobuf.DescriptorProtos;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzef<T> implements zzeo<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzfp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzec zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdq zzl;
    private final zzff zzm;
    private final zzce zzn;
    private final zzei zzo;
    private final zzdx zzp;

    private zzef(int[] iArr, Object[] objArr, int i, int i2, zzec zzecVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzceVar != null && zzceVar.zzf(zzecVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzeiVar;
        this.zzl = zzdqVar;
        this.zzm = zzffVar;
        this.zzn = zzceVar;
        this.zzg = zzecVar;
        this.zzp = zzdxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzeo zzeoVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzeoVarZzv.zze();
                    zzeoVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzeoVarZzv.zze();
                zzeoVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzeoVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzeo zzeoVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzeoVarZzv.zze();
                    zzeoVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzeoVarZzv.zze();
                zzeoVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzeoVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzfp.zzq(obj, j, (1 << (iZzp >>> 20)) | zzfp.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzfp.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzfp.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzfp.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzfp.zzb(obj, j2)) != 0;
            case 2:
                return zzfp.zzd(obj, j2) != 0;
            case 3:
                return zzfp.zzd(obj, j2) != 0;
            case 4:
                return zzfp.zzc(obj, j2) != 0;
            case 5:
                return zzfp.zzd(obj, j2) != 0;
            case 6:
                return zzfp.zzc(obj, j2) != 0;
            case 7:
                return zzfp.zzw(obj, j2);
            case 8:
                Object objZzf = zzfp.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzbq) {
                    return !zzbq.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzfp.zzf(obj, j2) != null;
            case 10:
                return !zzbq.zzb.equals(zzfp.zzf(obj, j2));
            case 11:
                return zzfp.zzc(obj, j2) != 0;
            case 12:
                return zzfp.zzc(obj, j2) != 0;
            case 13:
                return zzfp.zzc(obj, j2) != 0;
            case 14:
                return zzfp.zzd(obj, j2) != 0;
            case 15:
                return zzfp.zzc(obj, j2) != 0;
            case 16:
                return zzfp.zzd(obj, j2) != 0;
            case 17:
                return zzfp.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzeo zzeoVar) {
        return zzeoVar.zzk(zzfp.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcs) {
            return ((zzcs) obj).zzw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzfp.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzfp.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzfx zzfxVar) {
        if (obj instanceof String) {
            zzfxVar.zzG(i, (String) obj);
        } else {
            zzfxVar.zzd(i, (zzbq) obj);
        }
    }

    public static zzfg zzd(Object obj) {
        zzcs zzcsVar = (zzcs) obj;
        zzfg zzfgVar = zzcsVar.zzc;
        if (zzfgVar != zzfg.zzc()) {
            return zzfgVar;
        }
        zzfg zzfgVarZzf = zzfg.zzf();
        zzcsVar.zzc = zzfgVarZzf;
        return zzfgVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0266  */
    /* JADX WARN: Code duplicated, block: B:127:0x026b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0281  */
    /* JADX WARN: Code duplicated, block: B:131:0x0284  */
    public static zzef zzl(Class cls, zzdz zzdzVar, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
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
        int iObjectFieldOffset;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        Field fieldZzz;
        char cCharAt9;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldZzz2;
        int i25;
        Object obj2;
        Field fieldZzz3;
        int i26;
        char cCharAt10;
        int i27;
        char cCharAt11;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        if (!(zzdzVar instanceof zzen)) {
            throw null;
        }
        zzen zzenVar = (zzen) zzdzVar;
        String strZzd = zzenVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strZzd.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i32 = iCharAt3 & 8191;
            int i33 = 13;
            while (true) {
                i29 = i31 + 1;
                cCharAt13 = strZzd.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i29;
            }
            iCharAt3 = i32 | (cCharAt13 << i33);
            i31 = i29;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i5 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt4 = strZzd.charAt(i31);
            if (iCharAt4 >= 55296) {
                int i35 = iCharAt4 & 8191;
                int i36 = 13;
                while (true) {
                    i14 = i34 + 1;
                    cCharAt8 = strZzd.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i14;
                }
                iCharAt4 = i35 | (cCharAt8 << i36);
                i34 = i14;
            }
            int i37 = i34 + 1;
            int iCharAt5 = strZzd.charAt(i34);
            if (iCharAt5 >= 55296) {
                int i38 = iCharAt5 & 8191;
                int i39 = 13;
                while (true) {
                    i13 = i37 + 1;
                    cCharAt7 = strZzd.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i13;
                }
                iCharAt5 = i38 | (cCharAt7 << i39);
                i37 = i13;
            }
            int i40 = i37 + 1;
            int iCharAt6 = strZzd.charAt(i37);
            if (iCharAt6 >= 55296) {
                int i41 = iCharAt6 & 8191;
                int i42 = 13;
                while (true) {
                    i12 = i40 + 1;
                    cCharAt6 = strZzd.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i12;
                }
                iCharAt6 = i41 | (cCharAt6 << i42);
                i40 = i12;
            }
            int i43 = i40 + 1;
            int iCharAt7 = strZzd.charAt(i40);
            if (iCharAt7 >= 55296) {
                int i44 = iCharAt7 & 8191;
                int i45 = 13;
                while (true) {
                    i11 = i43 + 1;
                    cCharAt5 = strZzd.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i11;
                }
                iCharAt7 = i44 | (cCharAt5 << i45);
                i43 = i11;
            }
            int i46 = i43 + 1;
            iCharAt = strZzd.charAt(i43);
            if (iCharAt >= 55296) {
                int i47 = iCharAt & 8191;
                int i48 = 13;
                while (true) {
                    i10 = i46 + 1;
                    cCharAt4 = strZzd.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i10;
                }
                iCharAt = i47 | (cCharAt4 << i48);
                i46 = i10;
            }
            int i49 = i46 + 1;
            iCharAt2 = strZzd.charAt(i46);
            if (iCharAt2 >= 55296) {
                int i50 = iCharAt2 & 8191;
                int i51 = 13;
                while (true) {
                    i9 = i49 + 1;
                    cCharAt3 = strZzd.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i9;
                }
                iCharAt2 = i50 | (cCharAt3 << i51);
                i49 = i9;
            }
            int i52 = i49 + 1;
            int iCharAt8 = strZzd.charAt(i49);
            if (iCharAt8 >= 55296) {
                int i53 = iCharAt8 & 8191;
                int i54 = 13;
                while (true) {
                    i8 = i52 + 1;
                    cCharAt2 = strZzd.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i8;
                }
                iCharAt8 = i53 | (cCharAt2 << i54);
                i52 = i8;
            }
            int i55 = i52 + 1;
            int iCharAt9 = strZzd.charAt(i52);
            if (iCharAt9 >= 55296) {
                int i56 = iCharAt9 & 8191;
                int i57 = 13;
                while (true) {
                    i7 = i55 + 1;
                    cCharAt = strZzd.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i55 = i7;
                }
                iCharAt9 = i56 | (cCharAt << i57);
                i55 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i31 = i55;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzenVar.zze();
        Class<?> cls2 = zzenVar.zza().getClass();
        int i58 = i4 + iCharAt2;
        int i59 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i59];
        int i60 = 0;
        int i61 = 0;
        int i62 = i4;
        int i63 = i58;
        while (i31 < length) {
            int i64 = i31 + 1;
            int iCharAt10 = strZzd.charAt(i31);
            if (iCharAt10 >= c) {
                int i65 = iCharAt10 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i28 = i66 + 1;
                    cCharAt12 = strZzd.charAt(i66);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i65 |= (cCharAt12 & 8191) << i67;
                    i67 += 13;
                    i66 = i28;
                }
                iCharAt10 = i65 | (cCharAt12 << i67);
                i15 = i28;
            } else {
                i15 = i64;
            }
            int i68 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i69 = iCharAt11 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i27 = i70 + 1;
                    cCharAt11 = strZzd.charAt(i70);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i71;
                    i71 += 13;
                    i70 = i27;
                }
                iCharAt11 = i69 | (cCharAt11 << i71);
                i16 = i27;
            } else {
                i16 = i68;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            int i72 = iCharAt11 & 255;
            int i73 = iCharAt11 & 2048;
            int i74 = length;
            if (i72 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i76 = 13;
                    int i77 = iCharAt12 & 8191;
                    int i78 = i75;
                    while (true) {
                        i26 = i78 + 1;
                        cCharAt10 = strZzd.charAt(i78);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i77 |= (cCharAt10 & 8191) << i76;
                        i76 += 13;
                        i78 = i26;
                        c2 = 55296;
                    }
                    iCharAt12 = i77 | (cCharAt10 << i76);
                    i22 = i26;
                } else {
                    i22 = i75;
                }
                int i79 = i22;
                int i80 = i72 - 51;
                if (i80 == 9 || i80 == 17) {
                    i23 = i2 + 1;
                    int i81 = i61 / 3;
                    objArr[i81 + i81 + 1] = objArrZze[i2];
                } else {
                    if (i80 == 12) {
                        if (zzenVar.zzc() == 1 || i73 != 0) {
                            i23 = i2 + 1;
                            int i82 = i61 / 3;
                            objArr[i82 + i82 + 1] = objArrZze[i2];
                        } else {
                            i73 = 0;
                        }
                    }
                    i24 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i24];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i24] = fieldZzz2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i25 = i24 + 1;
                    obj2 = objArrZze[i25];
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i25] = fieldZzz3;
                    }
                    zzenVar = zzenVar;
                    strZzd = strZzd;
                    i19 = i2;
                    i17 = i79;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i18 = 0;
                }
                i2 = i23;
                i24 = iCharAt12 + iCharAt12;
                obj = objArrZze[i24];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i24] = fieldZzz2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i25 = i24 + 1;
                obj2 = objArrZze[i25];
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i25] = fieldZzz3;
                }
                zzenVar = zzenVar;
                strZzd = strZzd;
                i19 = i2;
                i17 = i79;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz3);
                i18 = 0;
            } else {
                int i83 = i2 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i2]);
                if (i72 == 9 || i72 == 17) {
                    zzenVar = zzenVar;
                    int i84 = i61 / 3;
                    objArr[i84 + i84 + 1] = fieldZzz4.getType();
                } else {
                    if (i72 == 27) {
                        i20 = 1;
                        i21 = i2 + 2;
                    } else if (i72 == 49) {
                        i21 = i2 + 2;
                        i20 = 1;
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        zzenVar = zzenVar;
                        if (zzenVar.zzc() == 1 || i73 != 0) {
                            i21 = i2 + 2;
                            int i85 = i61 / 3;
                            objArr[i85 + i85 + 1] = objArrZze[i83];
                            i83 = i21;
                        } else {
                            i73 = 0;
                        }
                    } else {
                        if (i72 == 50) {
                            int i86 = i2 + 2;
                            int i87 = i62 + 1;
                            iArr[i62] = i61;
                            int i88 = i61 / 3;
                            int i89 = i88 + i88;
                            objArr[i89] = objArrZze[i83];
                            if (i73 != 0) {
                                i83 = i2 + 3;
                                objArr[i89 + 1] = objArrZze[i86];
                                i62 = i87;
                            } else {
                                i83 = i86;
                                i62 = i87;
                                i73 = 0;
                            }
                        }
                        zzenVar = zzenVar;
                    }
                    int i90 = i61 / 3;
                    objArr[i90 + i90 + i20] = objArrZze[i83];
                    i83 = i21;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i72 > 17) {
                    i17 = i16;
                    i18 = 0;
                } else {
                    int i91 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i92 = iCharAt13 & 8191;
                        int i93 = 13;
                        while (true) {
                            i17 = i91 + 1;
                            cCharAt9 = strZzd.charAt(i91);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i92 |= (cCharAt9 & 8191) << i93;
                            i93 += 13;
                            i91 = i17;
                        }
                        iCharAt13 = i92 | (cCharAt9 << i93);
                    } else {
                        i17 = i91;
                    }
                    int i94 = (iCharAt13 / 32) + i5 + i5;
                    Object obj3 = objArrZze[i94];
                    if (obj3 instanceof Field) {
                        fieldZzz = (Field) obj3;
                    } else {
                        fieldZzz = zzz(cls2, (String) obj3);
                        objArrZze[i94] = fieldZzz;
                    }
                    i18 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz);
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i63] = iObjectFieldOffset3;
                    i63++;
                }
                i19 = i83;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i95 = i61 + 1;
            iArr2[i61] = iCharAt10;
            int i96 = i61 + 2;
            iArr2[i95] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i73 != 0 ? Integer.MIN_VALUE : 0) | (i72 << 20);
            i61 += 3;
            iArr2[i96] = (i18 << 20) | iObjectFieldOffset;
            i2 = i19;
            i31 = i17;
            length = i74;
            zzenVar = zzenVar;
            strZzd = strZzd;
            i6 = i6;
            i3 = i3;
            c = 55296;
        }
        zzen zzenVar2 = zzenVar;
        return new zzef(iArr2, objArr, i3, i6, zzenVar2.zza(), zzenVar2.zzc(), false, iArr, i4, i58, zzeiVar, zzdqVar, zzffVar, zzceVar, zzdxVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzfp.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzfp.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzfp.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzfp.zzf(obj, j)).longValue();
    }

    private final zzcw zzu(int i) {
        int i2 = i / 3;
        return (zzcw) this.zzd[i2 + i2 + 1];
    }

    private final zzeo zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzeo zzeoVar = (zzeo) objArr[i3];
        if (zzeoVar != null) {
            return zzeoVar;
        }
        zzeo zzeoVarZzb = zzel.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzeoVarZzb;
        return zzeoVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzeo zzeoVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzeoVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzeoVarZzv.zze();
        if (object != null) {
            zzeoVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzeo zzeoVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzeoVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzeoVarZzv.zze();
        if (object != null) {
            zzeoVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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
            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Field ", str, " for ", name, " not found. Known fields are ");
            sbM22m.append(string);
            throw new RuntimeException(sbM22m.toString());
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 21881. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int iZzc;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int iZzs = zzs(i5);
            int[] iArr = this.zzc;
            int i6 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i7 = iArr[i5];
            long j = i6;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzfp.zza(obj, j));
                    byte[] bArr = zzda.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iZzc;
                    break;
                case 1:
                    i2 = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzfp.zzb(obj, j));
                    i4 = iFloatToIntBits + i2;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    byte[] bArr2 = zzda.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iZzc;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    byte[] bArr3 = zzda.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iZzc;
                    break;
                case 4:
                    i = i4 * 53;
                    iZzc = zzfp.zzc(obj, j);
                    i4 = i + iZzc;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    byte[] bArr4 = zzda.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iZzc;
                    break;
                case 6:
                    i = i4 * 53;
                    iZzc = zzfp.zzc(obj, j);
                    i4 = i + iZzc;
                    break;
                case 7:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzda.zza(zzfp.zzw(obj, j));
                    i4 = iFloatToIntBits + i2;
                    break;
                case 8:
                    i2 = i4 * 53;
                    iFloatToIntBits = ((String) zzfp.zzf(obj, j)).hashCode();
                    i4 = iFloatToIntBits + i2;
                    break;
                case 9:
                    i3 = i4 * 53;
                    Object objZzf = zzfp.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i4 = i3 + iHashCode;
                    break;
                case 10:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                    i4 = iFloatToIntBits + i2;
                    break;
                case 11:
                    i = i4 * 53;
                    iZzc = zzfp.zzc(obj, j);
                    i4 = i + iZzc;
                    break;
                case 12:
                    i = i4 * 53;
                    iZzc = zzfp.zzc(obj, j);
                    i4 = i + iZzc;
                    break;
                case 13:
                    i = i4 * 53;
                    iZzc = zzfp.zzc(obj, j);
                    i4 = i + iZzc;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    byte[] bArr5 = zzda.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iZzc;
                    break;
                case 15:
                    i = i4 * 53;
                    iZzc = zzfp.zzc(obj, j);
                    i4 = i + iZzc;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    byte[] bArr6 = zzda.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iZzc;
                    break;
                case 17:
                    i3 = i4 * 53;
                    Object objZzf2 = zzfp.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i4 = i3 + iHashCode;
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
                    i2 = i4 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                    i4 = iFloatToIntBits + i2;
                    break;
                case 50:
                    i2 = i4 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                    i4 = iFloatToIntBits + i2;
                    break;
                case 51:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzda.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = iFloatToIntBits + i2;
                    }
                    break;
                case 53:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzda.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzda.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        iZzc = zzo(obj, j);
                        i4 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzda.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        iZzc = zzo(obj, j);
                        i4 = i + iZzc;
                    }
                    break;
                case 58:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzda.zza(zzN(obj, j));
                        i4 = iFloatToIntBits + i2;
                    }
                    break;
                case 59:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = ((String) zzfp.zzf(obj, j)).hashCode();
                        i4 = iFloatToIntBits + i2;
                    }
                    break;
                case 60:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                        i4 = iFloatToIntBits + i2;
                    }
                    break;
                case 61:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                        i4 = iFloatToIntBits + i2;
                    }
                    break;
                case 62:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        iZzc = zzo(obj, j);
                        i4 = i + iZzc;
                    }
                    break;
                case 63:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        iZzc = zzo(obj, j);
                        i4 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        iZzc = zzo(obj, j);
                        i4 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzda.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iZzc;
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        iZzc = zzo(obj, j);
                        i4 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzM(obj, i7, i5)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzda.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iZzc;
                    }
                    break;
                case 68:
                    if (zzM(obj, i7, i5)) {
                        i2 = i4 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                        i4 = iFloatToIntBits + i2;
                    }
                    break;
            }
        }
        int iHashCode2 = this.zzm.zzd(obj).hashCode() + (i4 * 53);
        return this.zzh ? (iHashCode2 * 53) + this.zzn.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:120:0x0343  */
    /* JADX WARN: Code duplicated, block: B:122:0x0350  */
    /* JADX WARN: Code duplicated, block: B:124:0x0353  */
    /* JADX WARN: Code duplicated, block: B:125:0x0356  */
    /* JADX WARN: Code duplicated, block: B:134:0x039d  */
    /* JADX WARN: Code duplicated, block: B:135:0x039f  */
    /* JADX WARN: Code duplicated, block: B:162:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:165:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:173:0x0569  */
    /* JADX WARN: Code duplicated, block: B:176:0x0572  */
    /* JADX WARN: Code duplicated, block: B:179:0x0580  */
    /* JADX WARN: Code duplicated, block: B:181:0x0583  */
    /* JADX WARN: Code duplicated, block: B:183:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:185:0x05b2 A[LOOP:2: B:182:0x05a5->B:185:0x05b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x05de  */
    /* JADX WARN: Code duplicated, block: B:190:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:192:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:194:0x0606 A[LOOP:3: B:193:0x0604->B:194:0x0606, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:199:0x061c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:200:0x061e  */
    /* JADX WARN: Code duplicated, block: B:202:0x062f  */
    /* JADX WARN: Code duplicated, block: B:204:0x0637 A[LOOP:4: B:201:0x062d->B:204:0x0637, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:207:0x064f  */
    /* JADX WARN: Code duplicated, block: B:209:0x065b  */
    /* JADX WARN: Code duplicated, block: B:211:0x0666 A[LOOP:5: B:210:0x0664->B:211:0x0666, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:216:0x067d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:217:0x067f  */
    /* JADX WARN: Code duplicated, block: B:219:0x0690  */
    /* JADX WARN: Code duplicated, block: B:221:0x0698 A[LOOP:6: B:218:0x068e->B:221:0x0698, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:222:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:224:0x06b2  */
    /* JADX WARN: Code duplicated, block: B:225:0x06b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:226:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:229:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:231:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:233:0x06df  */
    /* JADX WARN: Code duplicated, block: B:235:0x06f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:236:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:238:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:242:0x0714  */
    /* JADX WARN: Code duplicated, block: B:243:0x071c  */
    /* JADX WARN: Code duplicated, block: B:246:0x072d  */
    /* JADX WARN: Code duplicated, block: B:249:0x0745  */
    /* JADX WARN: Code duplicated, block: B:251:0x0756  */
    /* JADX WARN: Code duplicated, block: B:252:0x075a  */
    /* JADX WARN: Code duplicated, block: B:254:0x0769  */
    /* JADX WARN: Code duplicated, block: B:256:0x0771  */
    /* JADX WARN: Code duplicated, block: B:258:0x0775 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:259:0x0777  */
    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:260:0x077d  */
    /* JADX WARN: Code duplicated, block: B:263:0x0787  */
    /* JADX WARN: Code duplicated, block: B:265:0x078f  */
    /* JADX WARN: Code duplicated, block: B:267:0x0797  */
    /* JADX WARN: Code duplicated, block: B:269:0x079b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:281:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:283:0x07d4  */
    /* JADX WARN: Code duplicated, block: B:285:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:287:0x080d  */
    /* JADX WARN: Code duplicated, block: B:288:0x0814  */
    /* JADX WARN: Code duplicated, block: B:290:0x0828  */
    /* JADX WARN: Code duplicated, block: B:292:0x0830  */
    /* JADX WARN: Code duplicated, block: B:294:0x0838 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:295:0x083a  */
    /* JADX WARN: Code duplicated, block: B:296:0x0840  */
    /* JADX WARN: Code duplicated, block: B:299:0x084f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:301:0x0857  */
    /* JADX WARN: Code duplicated, block: B:303:0x085f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:311:0x0884  */
    /* JADX WARN: Code duplicated, block: B:313:0x088e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:314:0x0890  */
    /* JADX WARN: Code duplicated, block: B:315:0x0894  */
    /* JADX WARN: Code duplicated, block: B:317:0x089c  */
    /* JADX WARN: Code duplicated, block: B:320:0x08a9  */
    /* JADX WARN: Code duplicated, block: B:322:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:324:0x08b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:328:0x08c7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:339:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:341:0x0900  */
    /* JADX WARN: Code duplicated, block: B:343:0x090b  */
    /* JADX WARN: Code duplicated, block: B:345:0x0915  */
    /* JADX WARN: Code duplicated, block: B:346:0x0917  */
    /* JADX WARN: Code duplicated, block: B:352:0x092d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:353:0x092f  */
    /* JADX WARN: Code duplicated, block: B:355:0x093b  */
    /* JADX WARN: Code duplicated, block: B:356:0x093d  */
    /* JADX WARN: Code duplicated, block: B:359:0x0944  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:361:0x094c  */
    /* JADX WARN: Code duplicated, block: B:363:0x0956  */
    /* JADX WARN: Code duplicated, block: B:364:0x0958  */
    /* JADX WARN: Code duplicated, block: B:366:0x095e  */
    /* JADX WARN: Code duplicated, block: B:368:0x096f  */
    /* JADX WARN: Code duplicated, block: B:370:0x097a A[LOOP:14: B:369:0x0978->B:370:0x097a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:375:0x098c  */
    /* JADX WARN: Code duplicated, block: B:377:0x098f  */
    /* JADX WARN: Code duplicated, block: B:379:0x099c  */
    /* JADX WARN: Code duplicated, block: B:381:0x09a4 A[LOOP:15: B:378:0x099a->B:381:0x09a4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:382:0x09ae  */
    /* JADX WARN: Code duplicated, block: B:384:0x09bf  */
    /* JADX WARN: Code duplicated, block: B:386:0x09ca A[LOOP:16: B:385:0x09c8->B:386:0x09ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:391:0x09dd  */
    /* JADX WARN: Code duplicated, block: B:393:0x09e0  */
    /* JADX WARN: Code duplicated, block: B:395:0x09ed  */
    /* JADX WARN: Code duplicated, block: B:397:0x09f5 A[LOOP:17: B:394:0x09eb->B:397:0x09f5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:398:0x09ff  */
    /* JADX WARN: Code duplicated, block: B:400:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:401:0x0a17 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:402:0x0a19  */
    /* JADX WARN: Code duplicated, block: B:403:0x0a31  */
    /* JADX WARN: Code duplicated, block: B:404:0x0a38  */
    /* JADX WARN: Code duplicated, block: B:406:0x0a49  */
    /* JADX WARN: Code duplicated, block: B:408:0x0a54 A[LOOP:18: B:407:0x0a52->B:408:0x0a54, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:413:0x0a67 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:414:0x0a69  */
    /* JADX WARN: Code duplicated, block: B:416:0x0a76  */
    /* JADX WARN: Code duplicated, block: B:418:0x0a7e A[LOOP:19: B:415:0x0a74->B:418:0x0a7e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:419:0x0a88  */
    /* JADX WARN: Code duplicated, block: B:421:0x0a99  */
    /* JADX WARN: Code duplicated, block: B:423:0x0aa4 A[LOOP:20: B:422:0x0aa2->B:423:0x0aa4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:428:0x0abb  */
    /* JADX WARN: Code duplicated, block: B:430:0x0abe  */
    /* JADX WARN: Code duplicated, block: B:432:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:434:0x0ad7 A[LOOP:21: B:431:0x0acd->B:434:0x0ad7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:435:0x0ae5  */
    /* JADX WARN: Code duplicated, block: B:437:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:439:0x0b01 A[LOOP:22: B:438:0x0aff->B:439:0x0b01, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:444:0x0b17  */
    /* JADX WARN: Code duplicated, block: B:446:0x0b1a  */
    /* JADX WARN: Code duplicated, block: B:448:0x0b2b  */
    /* JADX WARN: Code duplicated, block: B:450:0x0b33 A[LOOP:23: B:447:0x0b29->B:450:0x0b33, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:452:0x0b46 A[PHI: r0 r3 r7 r10 r11 r13 r14 r15 r36
  0x0b46: PHI (r0v68 byte[]) = (r0v22 byte[]), (r0v24 byte[]), (r0v26 byte[]), (r0v36 byte[]), (r0v50 byte[]), (r0v67 byte[]), (r0v72 byte[]) binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r3v97 'this' com.google.android.gms.internal.play_billing.zzef<T>) = 
  (r3v55 'this' com.google.android.gms.internal.play_billing.zzef<T>)
  (r3v56 'this' com.google.android.gms.internal.play_billing.zzef<T>)
  (r3v57 'this' com.google.android.gms.internal.play_billing.zzef<T>)
  (r3v66 'this' com.google.android.gms.internal.play_billing.zzef<T>)
  (r38v0 'this' com.google.android.gms.internal.play_billing.zzef<T> A[IMMUTABLE_TYPE, THIS])
  (r3v92 'this' com.google.android.gms.internal.play_billing.zzef<T>)
  (r3v102 'this' com.google.android.gms.internal.play_billing.zzef<T>)
 binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r7v26 com.google.android.gms.internal.play_billing.zzbc) = 
  (r7v6 com.google.android.gms.internal.play_billing.zzbc)
  (r7v7 com.google.android.gms.internal.play_billing.zzbc)
  (r7v8 com.google.android.gms.internal.play_billing.zzbc)
  (r7v14 com.google.android.gms.internal.play_billing.zzbc)
  (r13v47 com.google.android.gms.internal.play_billing.zzbc)
  (r7v25 com.google.android.gms.internal.play_billing.zzbc)
  (r7v31 com.google.android.gms.internal.play_billing.zzbc)
 binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r10v88 int) = (r10v48 int), (r10v49 int), (r10v50 int), (r10v65 int), (r10v78 int), (r10v85 int), (r10v94 int) binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r11v48 int) = (r11v31 int), (r11v31 int), (r11v31 int), (r11v36 int), (r11v31 int), (r11v31 int), (r11v31 int) binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r13v67 int) = (r13v48 int), (r13v49 int), (r13v50 int), (r13v56 int), (r13v63 int), (r13v66 int), (r13v72 int) binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r14v74 int) = (r14v47 int), (r14v48 int), (r14v49 int), (r14v54 int), (r14v67 int), (r14v71 int), (r14v79 int) binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r15v37 int) = (r15v12 int), (r15v13 int), (r15v14 int), (r15v18 int), (r15v27 int), (r15v34 int), (r15v42 int) binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]
  0x0b46: PHI (r36v28 sun.misc.Unsafe) = 
  (r36v7 sun.misc.Unsafe)
  (r36v8 sun.misc.Unsafe)
  (r36v9 sun.misc.Unsafe)
  (r36v15 sun.misc.Unsafe)
  (r36v21 sun.misc.Unsafe)
  (r36v25 sun.misc.Unsafe)
  (r36v31 sun.misc.Unsafe)
 binds: [B:445:0x0b18, B:429:0x0abc, B:413:0x0a67, B:338:0x08ea, B:282:0x07cf, B:206:0x0646, B:189:0x05de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:461:0x0b9a  */
    /* JADX WARN: Code duplicated, block: B:464:0x0bab  */
    /* JADX WARN: Code duplicated, block: B:466:0x0bbe  */
    /* JADX WARN: Code duplicated, block: B:468:0x0bd1 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:469:0x0bdf  */
    /* JADX WARN: Code duplicated, block: B:471:0x0be2  */
    /* JADX WARN: Code duplicated, block: B:472:0x0c10  */
    /* JADX WARN: Code duplicated, block: B:473:0x0c12  */
    /* JADX WARN: Code duplicated, block: B:475:0x0c17  */
    /* JADX WARN: Code duplicated, block: B:478:0x0c3c  */
    /* JADX WARN: Code duplicated, block: B:479:0x0c4a  */
    /* JADX WARN: Code duplicated, block: B:481:0x0c51  */
    /* JADX WARN: Code duplicated, block: B:483:0x0c73  */
    /* JADX WARN: Code duplicated, block: B:485:0x0c7a  */
    /* JADX WARN: Code duplicated, block: B:491:0x0c9a  */
    /* JADX WARN: Code duplicated, block: B:492:0x0ca5  */
    /* JADX WARN: Code duplicated, block: B:494:0x0cad  */
    /* JADX WARN: Code duplicated, block: B:495:0x0cbf  */
    /* JADX WARN: Code duplicated, block: B:497:0x0cc6  */
    /* JADX WARN: Code duplicated, block: B:498:0x0cf4  */
    /* JADX WARN: Code duplicated, block: B:499:0x0d02  */
    /* JADX WARN: Code duplicated, block: B:501:0x0d14  */
    /* JADX WARN: Code duplicated, block: B:503:0x0d1c  */
    /* JADX WARN: Code duplicated, block: B:504:0x0d22  */
    /* JADX WARN: Code duplicated, block: B:513:0x0d48  */
    /* JADX WARN: Code duplicated, block: B:515:0x0d56  */
    /* JADX WARN: Code duplicated, block: B:517:0x0d60  */
    /* JADX WARN: Code duplicated, block: B:518:0x0d62  */
    /* JADX WARN: Code duplicated, block: B:521:0x0d71  */
    /* JADX WARN: Code duplicated, block: B:523:0x0d80  */
    /* JADX WARN: Code duplicated, block: B:524:0x0d91  */
    /* JADX WARN: Code duplicated, block: B:526:0x0da0  */
    /* JADX WARN: Code duplicated, block: B:527:0x0db1  */
    /* JADX WARN: Code duplicated, block: B:529:0x0dbf  */
    /* JADX WARN: Code duplicated, block: B:530:0x0dd0  */
    /* JADX WARN: Code duplicated, block: B:532:0x0dde  */
    /* JADX WARN: Code duplicated, block: B:533:0x0df0  */
    /* JADX WARN: Code duplicated, block: B:535:0x0dff  */
    /* JADX WARN: Code duplicated, block: B:536:0x0e15  */
    /* JADX WARN: Code duplicated, block: B:538:0x0e24  */
    /* JADX WARN: Code duplicated, block: B:539:0x0e3a A[PHI: r4 r11 r13 r14 r21 r23 r28
  0x0e3a: PHI (r4v126 com.google.android.gms.internal.play_billing.zzbc) = 
  (r4v99 com.google.android.gms.internal.play_billing.zzbc)
  (r4v100 com.google.android.gms.internal.play_billing.zzbc)
  (r4v101 com.google.android.gms.internal.play_billing.zzbc)
  (r4v102 com.google.android.gms.internal.play_billing.zzbc)
  (r4v103 com.google.android.gms.internal.play_billing.zzbc)
  (r4v104 com.google.android.gms.internal.play_billing.zzbc)
  (r4v106 com.google.android.gms.internal.play_billing.zzbc)
  (r4v107 com.google.android.gms.internal.play_billing.zzbc)
  (r4v109 com.google.android.gms.internal.play_billing.zzbc)
  (r4v114 com.google.android.gms.internal.play_billing.zzbc)
  (r4v120 com.google.android.gms.internal.play_billing.zzbc)
  (r4v127 com.google.android.gms.internal.play_billing.zzbc)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]
  0x0e3a: PHI (r11v67 int) = 
  (r11v50 int)
  (r11v51 int)
  (r11v52 int)
  (r11v53 int)
  (r11v54 int)
  (r11v55 int)
  (r11v57 int)
  (r11v58 int)
  (r11v59 int)
  (r11v61 int)
  (r11v63 int)
  (r11v68 int)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]
  0x0e3a: PHI (r13v102 com.google.android.gms.internal.play_billing.zzef<T>) = 
  (r13v74 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v75 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v76 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v77 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v78 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v79 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v81 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v82 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v83 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v89 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v94 com.google.android.gms.internal.play_billing.zzef<T>)
  (r13v103 com.google.android.gms.internal.play_billing.zzef<T>)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]
  0x0e3a: PHI (r14v108 int) = 
  (r14v87 int)
  (r14v88 int)
  (r14v89 int)
  (r14v90 int)
  (r14v91 int)
  (r14v92 int)
  (r14v94 int)
  (r14v95 int)
  (r14v96 int)
  (r14v100 int)
  (r14v103 int)
  (r14v109 int)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]
  0x0e3a: PHI (r21v20 int) = 
  (r21v4 int)
  (r21v5 int)
  (r21v6 int)
  (r21v7 int)
  (r21v8 int)
  (r21v9 int)
  (r21v11 int)
  (r21v12 int)
  (r21v13 int)
  (r21v15 int)
  (r21v17 int)
  (r21v21 int)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]
  0x0e3a: PHI (r23v30 int) = 
  (r23v14 int)
  (r23v15 int)
  (r23v16 int)
  (r23v17 int)
  (r23v18 int)
  (r23v19 int)
  (r23v21 int)
  (r23v22 int)
  (r23v23 int)
  (r23v25 int)
  (r23v27 int)
  (r23v31 int)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]
  0x0e3a: PHI (r28v17 int) = 
  (r28v1 int)
  (r28v2 int)
  (r28v3 int)
  (r28v4 int)
  (r28v5 int)
  (r28v6 int)
  (r28v8 int)
  (r28v9 int)
  (r28v10 int)
  (r28v12 int)
  (r28v14 int)
  (r28v18 int)
 binds: [B:537:0x0e22, B:534:0x0dfd, B:531:0x0ddc, B:528:0x0dbd, B:525:0x0d9e, B:522:0x0d7e, B:514:0x0d54, B:500:0x0d12, B:498:0x0cf4, B:482:0x0c66, B:478:0x0c3c, B:468:0x0bd1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:555:0x0e94  */
    /* JADX WARN: Code duplicated, block: B:586:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x01fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x0392 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:0x040a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x0426 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0462 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x0484 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x04dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0617 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0678 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x07c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x07c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x07b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x07ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x087f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0870 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x08e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x08dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x08d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x08d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0928 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0987 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x09d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0a62 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0ab6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x0b12 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x0b49 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x0b85 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x0e3d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x04c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x0382 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x03a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x03c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x03fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0416 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0451 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x0472 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:640:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x018f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x031a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x02df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x037d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x0548 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0532 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x04da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x0b72 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x0b63 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x0e55 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x0556 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x0b83 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x05d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:685:0x05cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x05d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:0x05d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:696:0x073d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x0727 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:701:0x07b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:702:0x07a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:0x079d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:709:0x0875 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:710:0x0865 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:711:0x0861 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0875 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:717:0x08bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x08bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:728:0x091f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x091f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:0x0875 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:738:0x0b47 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:741:0x0b47 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:744:0x0b44 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:747:0x02dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:748:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:749:0x030a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x023c  */
    /* JADX WARN: Code duplicated, block: B:750:0x02c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:755:0x029e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:756:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:757:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:762:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0244  */
    /* JADX WARN: Code duplicated, block: B:78:0x0247  */
    /* JADX WARN: Code duplicated, block: B:79:0x0250  */
    /* JADX WARN: Code duplicated, block: B:81:0x025b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0262  */
    /* JADX WARN: Code duplicated, block: B:85:0x026a A[LOOP:24: B:82:0x0260->B:85:0x026a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x0278  */
    /* JADX WARN: Code duplicated, block: B:91:0x028b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0293 A[LOOP:27: B:90:0x0289->B:93:0x0293, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:97:0x02a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x02a6  */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzbc zzbcVar) throws zzdc {
        zzef<T> zzefVar;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iZzq;
        int i10;
        int i11;
        int i12;
        zzbc zzbcVar2;
        int i13;
        int i14;
        byte[] bArr2;
        int i15;
        int iZzg;
        zzcd zzcdVar;
        int i16;
        int[] iArr;
        int i17;
        int iZzr;
        long j;
        byte b;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        Unsafe unsafe2;
        int i26;
        int i27;
        int i28;
        int i29;
        int iZzh;
        int i30;
        boolean z;
        int i31;
        int i32;
        int i33;
        int i34;
        int length;
        int i35;
        char[] cArr;
        int i36;
        int i37;
        int i38;
        byte b2;
        byte b3;
        byte b4;
        int i39;
        int iZza;
        int i40;
        Unsafe unsafe3;
        Unsafe unsafe4;
        int i41;
        int i42;
        int i43;
        zzbc zzbcVar3;
        Unsafe unsafe5;
        int i44;
        zzbc zzbcVar4;
        int i45;
        int i46;
        zzcz zzczVarZzd;
        zzbc zzbcVar5;
        long j2;
        Unsafe unsafe6;
        zzcz zzczVar;
        int i47;
        int i48;
        int i49;
        int i50;
        zzca zzcaVar;
        int iZzh2;
        int iZzh3;
        zzca zzcaVar2;
        int i51;
        zzck zzckVar;
        int iZzh4;
        zzck zzckVar2;
        int i52;
        zzdr zzdrVar;
        int iZzh5;
        zzdr zzdrVar2;
        int i53;
        int i54;
        int i55;
        int i56;
        char c;
        int i57;
        int iZzf;
        zzdr zzdrVar3;
        int iZzh6;
        zzdr zzdrVar4;
        int iZzh7;
        int i58;
        zzct zzctVar;
        int iZzh8;
        zzct zzctVar2;
        int i59;
        zzbe zzbeVar;
        boolean z2;
        int iZzh9;
        boolean z3;
        zzbe zzbeVar2;
        int i60;
        boolean z4;
        zzcz zzczVar2;
        int i61;
        int i62;
        int iZzh10;
        int i63;
        int i64;
        int i65;
        zzcz zzczVar3;
        int iZzh11;
        int i66;
        int i67;
        int i68;
        int iZzh12;
        int i69;
        int iZzh13;
        int i70;
        byte[] bArr3;
        int i71;
        int iZzj;
        zzcw zzcwVarZzu;
        zzff zzffVar;
        int i72;
        int i73;
        Iterator it;
        Object objZzo;
        int iIntValue;
        int size;
        int i74;
        int i75;
        Object objZzo2;
        Integer num;
        int iIntValue2;
        int i76;
        int i77;
        zzct zzctVar3;
        int iZzh14;
        zzct zzctVar4;
        int i78;
        zzdr zzdrVar5;
        int iZzh15;
        zzdr zzdrVar6;
        int i79;
        int i80;
        int i81;
        zzeo zzeoVarZzv;
        int i82;
        int i83;
        int iZzh16;
        Unsafe unsafe7;
        Object object;
        Unsafe unsafe8;
        long j3;
        int i84;
        int i85;
        int i86;
        int iZzk;
        boolean z5;
        int iZzh17;
        int i87;
        int i88;
        int i89;
        int i90;
        zzbc zzbcVar6;
        int iZzh18;
        int i91;
        zzcw zzcwVarZzu2;
        zzef<T> zzefVar2 = this;
        Object obj2 = obj;
        byte[] bArr4 = bArr;
        int i92 = i2;
        i3 = i3;
        zzbc zzbcVar7 = zzbcVar;
        int i93 = 3;
        zzA(obj);
        Unsafe unsafe9 = zzb;
        int i94 = 0;
        int i95 = -1;
        int iZzl = i;
        int i96 = -1;
        int i97 = 0;
        int i98 = 0;
        int i99 = 0;
        int i100 = 1048575;
        while (true) {
            if (iZzl < i92) {
                int iZzi = iZzl + 1;
                int i101 = bArr4[iZzl];
                if (i101 < 0) {
                    iZzi = zzbd.zzi(i101, bArr4, iZzi, zzbcVar7);
                    i101 = zzbcVar7.zza;
                }
                int i102 = (i101 == true ? 1 : 0) >>> 3;
                if (i102 > i96) {
                    iZzq = (i102 < zzefVar2.zze || i102 > zzefVar2.zzf) ? i95 : zzefVar2.zzq(i102, i97 / i93);
                } else {
                    if (i102 < zzefVar2.zze || i102 > zzefVar2.zzf) {
                        i9 = i95;
                    } else {
                        iZzq = zzefVar2.zzq(i102, i94);
                    }
                    if (i9 == i95) {
                        i16 = (i101 == true ? 1 : 0) & 7;
                        iArr = zzefVar2.zzc;
                        i17 = iArr[i9 + 1];
                        iZzr = zzr(i17);
                        j = i17 & 1048575;
                        b = i101 == true ? 1 : 0;
                        if (iZzr <= 17) {
                            int i103 = iArr[i9 + 2];
                            i18 = 1 << (i103 >>> 20);
                            i19 = 1048575;
                            i20 = i103 & 1048575;
                            i21 = i100;
                            i22 = iZzi;
                            if (i20 != i21) {
                                if (i21 != 1048575) {
                                    unsafe9.putInt(obj2, i21, i98);
                                    i19 = 1048575;
                                }
                                if (i20 == i19) {
                                    i23 = 0;
                                } else {
                                    i23 = unsafe9.getInt(obj2, i20);
                                }
                                i100 = i20;
                            } else {
                                i23 = i98;
                                i100 = i21;
                            }
                            switch (iZzr) {
                                case 0:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 1) {
                                        int i104 = i28 + 8;
                                        int i105 = i23 | i18;
                                        zzfp.zzo(obj2, j, Double.longBitsToDouble(zzbd.zzn(bArr4, i28)));
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26 == true ? 1 : 0;
                                        i93 = 3;
                                        i100 = i100;
                                        i95 = -1;
                                        i96 = i24;
                                        i98 = i105;
                                        unsafe9 = unsafe2;
                                        i94 = 0;
                                        iZzl = i104;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 1:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 5) {
                                        iZzh = i28 + 4;
                                        i30 = i23 | i18;
                                        zzfp.zzp(obj2, j, Float.intBitsToFloat(zzbd.zzb(bArr4, i28)));
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i93 = i29;
                                        i100 = i100;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i30;
                                        unsafe9 = unsafe2;
                                        i94 = i27;
                                        iZzl = iZzh;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 0) {
                                        int i106 = i23 | i18;
                                        int iZzk2 = zzbd.zzk(bArr4, i28, zzbcVar7);
                                        unsafe2.putLong(obj, j, zzbcVar7.zzb);
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26 == true ? 1 : 0;
                                        i93 = 3;
                                        i100 = i100;
                                        i98 = i106;
                                        unsafe9 = unsafe2;
                                        i96 = i24;
                                        i94 = 0;
                                        iZzl = iZzk2;
                                        i95 = -1;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 0) {
                                        i30 = i23 | i18;
                                        iZzh = zzbd.zzh(bArr4, i28, zzbcVar7);
                                        unsafe2.putInt(obj2, j, zzbcVar7.zza);
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i93 = i29;
                                        i100 = i100;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i30;
                                        unsafe9 = unsafe2;
                                        i94 = i27;
                                        iZzl = iZzh;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 1) {
                                        int i107 = i28 + 8;
                                        unsafe2.putLong(obj, j, zzbd.zzn(bArr4, i28));
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26 == true ? 1 : 0;
                                        i93 = 3;
                                        i100 = i100;
                                        i98 = i18 | i23;
                                        unsafe9 = unsafe2;
                                        i95 = -1;
                                        i94 = 0;
                                        iZzl = i107;
                                        i96 = i24;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 5) {
                                        iZzh = i28 + 4;
                                        i30 = i23 | i18;
                                        unsafe2.putInt(obj2, j, zzbd.zzb(bArr4, i28));
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i93 = i29;
                                        i100 = i100;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i30;
                                        unsafe9 = unsafe2;
                                        i94 = i27;
                                        iZzl = iZzh;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 7:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 0) {
                                        i30 = i23 | i18;
                                        iZzh = zzbd.zzk(bArr4, i28, zzbcVar7);
                                        if (zzbcVar7.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzfp.zzm(obj2, j, z);
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i93 = i29;
                                        i100 = i100;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i30;
                                        unsafe9 = unsafe2;
                                        i94 = i27;
                                        iZzl = iZzh;
                                    } else {
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 8:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i28 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i31 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 2) {
                                        if ((i17 & 536870912) != 0) {
                                            iZzh = zzbd.zzh(bArr4, i28, zzbcVar7);
                                            i33 = zzbcVar7.zza;
                                            if (i33 >= 0) {
                                                throw zzdc.zzd();
                                            }
                                            i34 = i23 | i18;
                                            if (i33 == 0) {
                                                zzbcVar7.zzc = "";
                                                i37 = i34;
                                                i27 = 0;
                                            } else {
                                                int i108 = zzfu.zza;
                                                length = bArr4.length;
                                                if ((((length - iZzh) - i33) | iZzh | i33) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh), Integer.valueOf(i33)));
                                                }
                                                i35 = iZzh + i33;
                                                cArr = new char[i33];
                                                i36 = 0;
                                                while (iZzh < i35) {
                                                    b4 = bArr4[iZzh];
                                                    if (zzfq.zzd(b4)) {
                                                        iZzh++;
                                                        cArr[i36] = (char) b4;
                                                        i36++;
                                                    } else {
                                                        while (true) {
                                                            while (true) {
                                                                if (iZzh < i35) {
                                                                    i38 = iZzh + 1;
                                                                    b2 = bArr4[iZzh];
                                                                    if (zzfq.zzd(b2)) {
                                                                        cArr[i36] = (char) b2;
                                                                        i36++;
                                                                        iZzh = i38;
                                                                        while (iZzh < i35) {
                                                                            b3 = bArr4[iZzh];
                                                                            if (zzfq.zzd(b3)) {
                                                                                iZzh++;
                                                                                cArr[i36] = (char) b3;
                                                                                i36++;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i34 = i34;
                                                                        if (b2 < -32) {
                                                                            if (i38 < i35) {
                                                                                throw zzdc.zzc();
                                                                            }
                                                                            iZzh += 2;
                                                                            zzfq.zzc(b2, bArr4[i38], cArr, i36);
                                                                            i36++;
                                                                            i34 = i34;
                                                                        } else if (b2 < -16) {
                                                                            if (i38 < i35 - 1) {
                                                                                throw zzdc.zzc();
                                                                            }
                                                                            int i109 = iZzh + 2;
                                                                            iZzh += 3;
                                                                            zzfq.zzb(b2, bArr4[i38], bArr4[i109], cArr, i36);
                                                                            i36++;
                                                                        } else {
                                                                            if (i38 < i35 - 2) {
                                                                                throw zzdc.zzc();
                                                                            }
                                                                            byte b5 = bArr4[i38];
                                                                            int i110 = iZzh + 3;
                                                                            byte b6 = bArr4[iZzh + 2];
                                                                            iZzh += 4;
                                                                            zzfq.zza(b2, b5, b6, bArr4[i110], cArr, i36);
                                                                            i36 += 2;
                                                                        }
                                                                    }
                                                                } else {
                                                                    i37 = i34;
                                                                    i27 = 0;
                                                                    zzbcVar7.zzc = new String(cArr, 0, i36);
                                                                    iZzh = i35;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                while (true) {
                                                    while (true) {
                                                        if (iZzh < i35) {
                                                            i38 = iZzh + 1;
                                                            b2 = bArr4[iZzh];
                                                            if (zzfq.zzd(b2)) {
                                                                cArr[i36] = (char) b2;
                                                                i36++;
                                                                iZzh = i38;
                                                                while (iZzh < i35) {
                                                                    b3 = bArr4[iZzh];
                                                                    if (zzfq.zzd(b3)) {
                                                                        iZzh++;
                                                                        cArr[i36] = (char) b3;
                                                                        i36++;
                                                                    }
                                                                }
                                                            } else {
                                                                i34 = i34;
                                                                if (b2 < -32) {
                                                                    if (i38 < i35) {
                                                                        throw zzdc.zzc();
                                                                    }
                                                                    iZzh += 2;
                                                                    zzfq.zzc(b2, bArr4[i38], cArr, i36);
                                                                    i36++;
                                                                    i34 = i34;
                                                                } else if (b2 < -16) {
                                                                    if (i38 < i35 - 1) {
                                                                        throw zzdc.zzc();
                                                                    }
                                                                    int i1010 = iZzh + 2;
                                                                    iZzh += 3;
                                                                    zzfq.zzb(b2, bArr4[i38], bArr4[i1010], cArr, i36);
                                                                    i36++;
                                                                } else {
                                                                    if (i38 < i35 - 2) {
                                                                        throw zzdc.zzc();
                                                                    }
                                                                    byte b7 = bArr4[i38];
                                                                    int i111 = iZzh + 3;
                                                                    byte b8 = bArr4[iZzh + 2];
                                                                    iZzh += 4;
                                                                    zzfq.zza(b2, b7, b8, bArr4[i111], cArr, i36);
                                                                    i36 += 2;
                                                                }
                                                            }
                                                        } else {
                                                            i37 = i34;
                                                            i27 = 0;
                                                            zzbcVar7.zzc = new String(cArr, 0, i36);
                                                            iZzh = i35;
                                                        }
                                                    }
                                                }
                                            }
                                            i30 = i37;
                                            i29 = 3;
                                        } else {
                                            i29 = 3;
                                            i27 = 0;
                                            iZzh = zzbd.zzh(bArr4, i28, zzbcVar7);
                                            i32 = zzbcVar7.zza;
                                            if (i32 >= 0) {
                                                throw zzdc.zzd();
                                            }
                                            i30 = i23 | i18;
                                            if (i32 == 0) {
                                                zzbcVar7.zzc = "";
                                            } else {
                                                zzbcVar7.zzc = new String(bArr4, iZzh, i32, zzda.zzb);
                                                iZzh += i32;
                                            }
                                        }
                                        unsafe2.putObject(obj2, j, zzbcVar7.zzc);
                                        i92 = i2;
                                        i3 = i3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i93 = i29;
                                        i100 = i100;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i30;
                                        unsafe9 = unsafe2;
                                        i94 = i27;
                                        iZzl = iZzh;
                                    } else {
                                        i29 = i31;
                                        i27 = 0;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 9:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i39 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i31 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 2) {
                                        int i112 = i23 | i18;
                                        Object objZzx = zzefVar2.zzx(obj2, i25);
                                        i92 = i2;
                                        int iZzm = zzbd.zzm(objZzx, zzefVar2.zzv(i25), bArr, i39, i92, zzbcVar);
                                        zzefVar2.zzF(obj2, i25, objZzx);
                                        i93 = 3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26 == true ? 1 : 0;
                                        i95 = -1;
                                        iZzl = iZzm;
                                        i98 = i112;
                                        unsafe9 = unsafe2;
                                        i96 = i24;
                                        i94 = 0;
                                    } else {
                                        i28 = i39;
                                        i29 = i31;
                                        i27 = 0;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 10:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i39 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i31 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 2) {
                                        i23 |= i18;
                                        iZza = zzbd.zza(bArr4, i39, zzbcVar7);
                                        unsafe2.putObject(obj2, j, zzbcVar7.zzc);
                                        i92 = i2;
                                        i93 = i31;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i23;
                                        iZzl = iZza;
                                        unsafe9 = unsafe2;
                                        i94 = 0;
                                    } else {
                                        i28 = i39;
                                        i29 = i31;
                                        i27 = 0;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 12:
                                    i24 = i102;
                                    unsafe2 = unsafe9;
                                    i39 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i31 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 0) {
                                        iZza = zzbd.zzh(bArr4, i39, zzbcVar7);
                                        i40 = zzbcVar7.zza;
                                        zzcw zzcwVarZzu3 = zzefVar2.zzu(i25);
                                        if ((i17 & Integer.MIN_VALUE) != 0 || zzcwVarZzu3 == null || zzcwVarZzu3.zza(i40)) {
                                            i23 |= i18;
                                            unsafe2.putInt(obj2, j, i40);
                                        } else {
                                            zzd(obj).zzj(i26 == true ? 1 : 0, Long.valueOf(i40));
                                        }
                                        i92 = i2;
                                        i93 = i31;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i23;
                                        iZzl = iZza;
                                        unsafe9 = unsafe2;
                                        i94 = 0;
                                    } else {
                                        i28 = i39;
                                        i29 = i31;
                                        i27 = 0;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 15:
                                    i24 = i102;
                                    unsafe3 = unsafe9;
                                    i39 = i22;
                                    i26 = b == true ? 1 : 0;
                                    i31 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    zzbcVar7 = zzbcVar7;
                                    if (i16 == 0) {
                                        i23 |= i18;
                                        iZza = zzbd.zzh(bArr4, i39, zzbcVar7);
                                        unsafe2 = unsafe3;
                                        unsafe2.putInt(obj2, j, zzbu.zzb(zzbcVar7.zza));
                                        i92 = i2;
                                        i93 = i31;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26;
                                        i95 = i11;
                                        i96 = i24;
                                        i98 = i23;
                                        iZzl = iZza;
                                        unsafe9 = unsafe2;
                                        i94 = 0;
                                    } else {
                                        unsafe2 = unsafe3;
                                        i28 = i39;
                                        i29 = i31;
                                        i27 = 0;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                case 16:
                                    i24 = i102;
                                    unsafe4 = unsafe9;
                                    i26 = b == true ? 1 : 0;
                                    i93 = 3;
                                    i11 = -1;
                                    i25 = i9;
                                    if (i16 == 0) {
                                        int i113 = i23 | i18;
                                        int iZzk3 = zzbd.zzk(bArr4, i22, zzbcVar7);
                                        unsafe4.putLong(obj, j, zzbu.zzc(zzbcVar7.zzb));
                                        i92 = i2;
                                        i3 = i3;
                                        i93 = 3;
                                        iZzl = iZzk3;
                                        zzbcVar7 = zzbcVar7;
                                        i97 = i25;
                                        i99 = i26 == true ? 1 : 0;
                                        i100 = i100;
                                        i95 = -1;
                                        unsafe9 = unsafe4;
                                        i96 = i24;
                                        i94 = 0;
                                        i98 = i113;
                                    } else {
                                        unsafe2 = unsafe4;
                                        i27 = 0;
                                        i29 = i93;
                                        i28 = i22;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                                default:
                                    i93 = 3;
                                    if (i16 == 3) {
                                        int i114 = i23 | i18;
                                        Object objZzx2 = zzefVar2.zzx(obj2, i9);
                                        int i115 = i9;
                                        iZzl = zzbd.zzl(objZzx2, zzefVar2.zzv(i9), bArr, i22, i2, (i102 << 3) | 4, zzbcVar);
                                        zzefVar2.zzF(obj2, i115, objZzx2);
                                        i99 = b == true ? 1 : 0;
                                        i97 = i115;
                                        i100 = i100;
                                        i95 = -1;
                                        unsafe9 = unsafe9;
                                        i96 = i102;
                                        i94 = 0;
                                        i92 = i2;
                                        i3 = i3;
                                        i98 = i114;
                                    } else {
                                        i24 = i102;
                                        i11 = -1;
                                        i25 = i9;
                                        unsafe2 = unsafe9;
                                        i26 = b == true ? 1 : 0;
                                        i27 = 0;
                                        i29 = i93;
                                        i28 = i22;
                                        i4 = i3;
                                        i14 = i28;
                                        zzbcVar2 = zzbcVar7;
                                        i97 = i25;
                                        unsafe = unsafe2;
                                        i10 = i29;
                                        i12 = i100;
                                        zzefVar = zzefVar2;
                                        i98 = i23;
                                        i13 = i27;
                                        i101 = i26;
                                        bArr2 = bArr4;
                                        i15 = i24;
                                        i2 = i2;
                                    }
                                    break;
                            }
                        } else {
                            i41 = i102;
                            i42 = i100;
                            i11 = -1;
                            i43 = i9;
                            zzbcVar3 = zzbcVar7;
                            unsafe5 = unsafe9;
                            if (iZzr == 27) {
                                i12 = i42;
                                i46 = b == true ? 1 : 0;
                                i13 = 0;
                                zzbcVar5 = zzbcVar3;
                                if (iZzr <= 49) {
                                    j2 = i17;
                                    unsafe6 = zzb;
                                    zzczVar = (zzcz) unsafe6.getObject(obj2, j);
                                    if (!zzczVar.zzc()) {
                                        int size2 = zzczVar.size();
                                        zzcz zzczVarZzd2 = zzczVar.zzd(size2 != 0 ? size2 + size2 : 10);
                                        unsafe6.putObject(obj2, j, zzczVarZzd2);
                                        zzczVar = zzczVarZzd2;
                                    }
                                    switch (iZzr) {
                                        case 18:
                                        case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                            unsafe = unsafe5;
                                            zzbcVar5 = zzbcVar5;
                                            i47 = i43;
                                            i15 = i41;
                                            i48 = 3;
                                            this = zzefVar2;
                                            i49 = iZzi;
                                            bArr2 = bArr;
                                            if (i16 == 2) {
                                                zzcaVar2 = (zzca) zzczVar;
                                                iZzh2 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i51 = zzbcVar5.zza + iZzh2;
                                                while (iZzh2 < i51) {
                                                    zzcaVar2.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, iZzh2)));
                                                    iZzh2 += 8;
                                                }
                                                if (iZzh2 != i51) {
                                                    throw zzdc.zzg();
                                                }
                                            } else if (i16 == 1) {
                                                i50 = i49 + 8;
                                                zzcaVar = (zzca) zzczVar;
                                                zzcaVar.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, i49)));
                                                while (i50 < i2) {
                                                    iZzh3 = zzbd.zzh(bArr2, i50, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        zzcaVar.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, iZzh3)));
                                                        i50 = iZzh3 + 8;
                                                    } else {
                                                        iZzh2 = i50;
                                                    }
                                                }
                                                iZzh2 = i50;
                                            } else {
                                                iZzh2 = i49;
                                            }
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 19:
                                        case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                            unsafe = unsafe5;
                                            zzbcVar5 = zzbcVar5;
                                            i47 = i43;
                                            i15 = i41;
                                            i48 = 3;
                                            this = zzefVar2;
                                            i49 = iZzi;
                                            bArr2 = bArr;
                                            if (i16 == 2) {
                                                zzckVar2 = (zzck) zzczVar;
                                                iZzh2 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i52 = zzbcVar5.zza + iZzh2;
                                                while (iZzh2 < i52) {
                                                    zzckVar2.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, iZzh2)));
                                                    iZzh2 += 4;
                                                }
                                                if (iZzh2 != i52) {
                                                    throw zzdc.zzg();
                                                }
                                            } else if (i16 == 5) {
                                                iZzh2 = i49 + 4;
                                                zzckVar = (zzck) zzczVar;
                                                zzckVar.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, i49)));
                                                while (iZzh2 < i2) {
                                                    iZzh4 = zzbd.zzh(bArr2, iZzh2, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        zzckVar.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, iZzh4)));
                                                        iZzh2 = iZzh4 + 4;
                                                    }
                                                }
                                            } else {
                                                iZzh2 = i49;
                                            }
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                        case 38:
                                            unsafe = unsafe5;
                                            zzbcVar5 = zzbcVar5;
                                            i47 = i43;
                                            i15 = i41;
                                            i48 = 3;
                                            this = zzefVar2;
                                            i49 = iZzi;
                                            bArr2 = bArr;
                                            if (i16 == 2) {
                                                zzdrVar2 = (zzdr) zzczVar;
                                                iZzh2 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i53 = zzbcVar5.zza + iZzh2;
                                                while (iZzh2 < i53) {
                                                    iZzh2 = zzbd.zzk(bArr2, iZzh2, zzbcVar5);
                                                    zzdrVar2.zzf(zzbcVar5.zzb);
                                                }
                                                if (iZzh2 != i53) {
                                                    throw zzdc.zzg();
                                                }
                                            } else if (i16 == 0) {
                                                zzdrVar = (zzdr) zzczVar;
                                                iZzh2 = zzbd.zzk(bArr2, i49, zzbcVar5);
                                                zzdrVar.zzf(zzbcVar5.zzb);
                                                while (iZzh2 < i2) {
                                                    iZzh5 = zzbd.zzh(bArr2, iZzh2, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        iZzh2 = zzbd.zzk(bArr2, iZzh5, zzbcVar5);
                                                        zzdrVar.zzf(zzbcVar5.zzb);
                                                    }
                                                }
                                            } else {
                                                iZzh2 = i49;
                                            }
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                        case 43:
                                            bArr2 = bArr;
                                            unsafe = unsafe5;
                                            i54 = i46 == true ? 1 : 0;
                                            zzbcVar5 = zzbcVar5;
                                            i55 = i41;
                                            i56 = 3;
                                            c = 2;
                                            i49 = iZzi;
                                            i57 = i43;
                                            if (i16 == 2) {
                                                iZzf = zzbd.zzf(bArr2, i49, zzczVar, zzbcVar5);
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                iZzh2 = iZzf;
                                                this = this;
                                            } else if (i16 == 0) {
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54 == true ? 1 : 0;
                                                i48 = 3;
                                                iZzh2 = zzbd.zzj(i54 == true ? 1 : 0, bArr, i49, i2, zzczVar, zzbcVar);
                                                this = this;
                                            } else {
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54 == true ? 1 : 0;
                                                i48 = 3;
                                                this = this;
                                                iZzh2 = i49;
                                            }
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                        case 32:
                                        case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                        case 46:
                                            bArr2 = bArr;
                                            unsafe = unsafe5;
                                            i54 = i46 == true ? 1 : 0;
                                            zzbcVar5 = zzbcVar5;
                                            i55 = i41;
                                            i56 = 3;
                                            c = 2;
                                            i49 = iZzi;
                                            i57 = i43;
                                            if (i16 == 2) {
                                                if (i16 == 1) {
                                                    iZzf = i49 + 8;
                                                    zzdrVar3 = (zzdr) zzczVar;
                                                    zzdrVar3.zzf(zzbd.zzn(bArr2, i49));
                                                    while (iZzf < i2) {
                                                        iZzh6 = zzbd.zzh(bArr2, iZzf, zzbcVar5);
                                                        if (i54 == zzbcVar5.zza) {
                                                            i15 = i55;
                                                            i47 = i57;
                                                            i46 = i54;
                                                            i48 = i56;
                                                            iZzh2 = iZzf;
                                                            this = this;
                                                            if (iZzh2 != i49) {
                                                                i92 = i2;
                                                                i3 = i3;
                                                                iZzl = iZzh2;
                                                                i93 = i48;
                                                                i99 = i46;
                                                                i97 = i47;
                                                                i96 = i15;
                                                                i94 = 0;
                                                                i100 = i12;
                                                                i95 = -1;
                                                                unsafe9 = unsafe;
                                                                bArr4 = bArr2;
                                                                zzefVar2 = this;
                                                                zzbcVar7 = zzbcVar5;
                                                                obj2 = obj;
                                                            } else {
                                                                i4 = i3;
                                                                zzefVar = this;
                                                                zzbcVar2 = zzbcVar5;
                                                                i10 = i48;
                                                                i101 = i46;
                                                                i97 = i47;
                                                                obj2 = obj;
                                                                i2 = i2;
                                                                i14 = iZzh2;
                                                            }
                                                        } else {
                                                            zzdrVar3.zzf(zzbd.zzn(bArr2, iZzh6));
                                                            iZzf = iZzh6 + 8;
                                                        }
                                                        break;
                                                    }
                                                    i15 = i55;
                                                    i47 = i57;
                                                    i46 = i54;
                                                    i48 = i56;
                                                    iZzh2 = iZzf;
                                                    this = this;
                                                    if (iZzh2 != i49) {
                                                        i92 = i2;
                                                        i3 = i3;
                                                        iZzl = iZzh2;
                                                        i93 = i48;
                                                        i99 = i46;
                                                        i97 = i47;
                                                        i96 = i15;
                                                        i94 = 0;
                                                        i100 = i12;
                                                        i95 = -1;
                                                        unsafe9 = unsafe;
                                                        bArr4 = bArr2;
                                                        zzefVar2 = this;
                                                        zzbcVar7 = zzbcVar5;
                                                        obj2 = obj;
                                                    } else {
                                                        i4 = i3;
                                                        zzefVar = this;
                                                        zzbcVar2 = zzbcVar5;
                                                        i10 = i48;
                                                        i101 = i46;
                                                        i97 = i47;
                                                        obj2 = obj;
                                                        i2 = i2;
                                                        i14 = iZzh2;
                                                    }
                                                }
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                this = this;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                                break;
                                            } else {
                                                zzdrVar4 = (zzdr) zzczVar;
                                                iZzh7 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i58 = zzbcVar5.zza + iZzh7;
                                                while (iZzh7 < i58) {
                                                    zzdrVar4.zzf(zzbd.zzn(bArr2, iZzh7));
                                                    iZzh7 += 8;
                                                }
                                                if (iZzh7 != i58) {
                                                    throw zzdc.zzg();
                                                }
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                iZzh2 = iZzh7;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            }
                                            break;
                                        case 24:
                                        case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                        case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                        case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                            bArr2 = bArr;
                                            unsafe = unsafe5;
                                            i54 = i46 == true ? 1 : 0;
                                            zzbcVar5 = zzbcVar5;
                                            i55 = i41;
                                            i56 = 3;
                                            c = 2;
                                            i49 = iZzi;
                                            i57 = i43;
                                            if (i16 == 2) {
                                                if (i16 == 5) {
                                                    iZzh7 = i49 + 4;
                                                    zzctVar = (zzct) zzczVar;
                                                    zzctVar.zzg(zzbd.zzb(bArr2, i49));
                                                    while (iZzh7 < i2) {
                                                        iZzh8 = zzbd.zzh(bArr2, iZzh7, zzbcVar5);
                                                        if (i54 == zzbcVar5.zza) {
                                                            zzctVar.zzg(zzbd.zzb(bArr2, iZzh8));
                                                            iZzh7 = iZzh8 + 4;
                                                        }
                                                    }
                                                }
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                this = this;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                zzctVar2 = (zzct) zzczVar;
                                                iZzh7 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i59 = zzbcVar5.zza + iZzh7;
                                                while (iZzh7 < i59) {
                                                    zzctVar2.zzg(zzbd.zzb(bArr2, iZzh7));
                                                    iZzh7 += 4;
                                                }
                                                if (iZzh7 != i59) {
                                                    throw zzdc.zzg();
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            iZzh2 = iZzh7;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 25:
                                        case 42:
                                            bArr2 = bArr;
                                            unsafe = unsafe5;
                                            i54 = i46 == true ? 1 : 0;
                                            zzbcVar5 = zzbcVar5;
                                            i55 = i41;
                                            i56 = 3;
                                            c = 2;
                                            i49 = iZzi;
                                            i57 = i43;
                                            if (i16 == 2) {
                                                if (i16 == 0) {
                                                    zzbeVar = (zzbe) zzczVar;
                                                    iZzh7 = zzbd.zzk(bArr2, i49, zzbcVar5);
                                                    if (zzbcVar5.zzb != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    zzbeVar.zze(z2);
                                                    while (iZzh7 < i2) {
                                                        iZzh9 = zzbd.zzh(bArr2, iZzh7, zzbcVar5);
                                                        if (i54 == zzbcVar5.zza) {
                                                            iZzh7 = zzbd.zzk(bArr2, iZzh9, zzbcVar5);
                                                            if (zzbcVar5.zzb != 0) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            zzbeVar.zze(z3);
                                                        }
                                                    }
                                                }
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                this = this;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                zzbeVar2 = (zzbe) zzczVar;
                                                iZzh7 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i60 = zzbcVar5.zza + iZzh7;
                                                while (iZzh7 < i60) {
                                                    iZzh7 = zzbd.zzk(bArr2, iZzh7, zzbcVar5);
                                                    if (zzbcVar5.zzb != 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    zzbeVar2.zze(z4);
                                                }
                                                if (iZzh7 != i60) {
                                                    throw zzdc.zzg();
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            iZzh2 = iZzh7;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 26:
                                            bArr2 = bArr;
                                            unsafe = unsafe5;
                                            i54 = i46 == true ? 1 : 0;
                                            zzczVar2 = zzczVar;
                                            zzbcVar5 = zzbcVar5;
                                            i55 = i41;
                                            i56 = 3;
                                            c = 2;
                                            i49 = iZzi;
                                            i57 = i43;
                                            if (i16 == 2) {
                                                if ((536870912 & j2) == 0) {
                                                    iZzf = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                    i65 = zzbcVar5.zza;
                                                    if (i65 >= 0) {
                                                        throw zzdc.zzd();
                                                    }
                                                    if (i65 == 0) {
                                                        zzczVar3 = zzczVar2;
                                                        zzczVar3.add("");
                                                    } else {
                                                        zzczVar3 = zzczVar2;
                                                        zzczVar3.add(new String(bArr2, iZzf, i65, zzda.zzb));
                                                        iZzf += i65;
                                                    }
                                                    while (iZzf < i2) {
                                                        iZzh11 = zzbd.zzh(bArr2, iZzf, zzbcVar5);
                                                        if (i54 == zzbcVar5.zza) {
                                                            iZzf = zzbd.zzh(bArr2, iZzh11, zzbcVar5);
                                                            i66 = zzbcVar5.zza;
                                                            if (i66 >= 0) {
                                                                throw zzdc.zzd();
                                                            }
                                                            if (i66 == 0) {
                                                                zzczVar3.add("");
                                                            } else {
                                                                zzczVar3.add(new String(bArr2, iZzf, i66, zzda.zzb));
                                                                iZzf += i66;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    iZzf = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                    i61 = zzbcVar5.zza;
                                                    if (i61 >= 0) {
                                                        throw zzdc.zzd();
                                                    }
                                                    if (i61 == 0) {
                                                        zzczVar2.add("");
                                                    } else {
                                                        i62 = iZzf + i61;
                                                        if (zzfu.zze(bArr2, iZzf, i62)) {
                                                            throw zzdc.zzc();
                                                        }
                                                        zzczVar2.add(new String(bArr2, iZzf, i61, zzda.zzb));
                                                        iZzf = i62;
                                                    }
                                                    while (iZzf < i2) {
                                                        iZzh10 = zzbd.zzh(bArr2, iZzf, zzbcVar5);
                                                        if (i54 == zzbcVar5.zza) {
                                                            iZzf = zzbd.zzh(bArr2, iZzh10, zzbcVar5);
                                                            i63 = zzbcVar5.zza;
                                                            if (i63 >= 0) {
                                                                throw zzdc.zzd();
                                                            }
                                                            if (i63 == 0) {
                                                                zzczVar2.add("");
                                                            } else {
                                                                i64 = iZzf + i63;
                                                                if (zzfu.zze(bArr2, iZzf, i64)) {
                                                                    throw zzdc.zzc();
                                                                }
                                                                zzczVar2.add(new String(bArr2, iZzf, i63, zzda.zzb));
                                                                iZzf = i64;
                                                            }
                                                        }
                                                    }
                                                }
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                iZzh2 = iZzf;
                                                this = this;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            this = this;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                                            i67 = iZzi;
                                            unsafe = unsafe5;
                                            i47 = i43;
                                            i68 = i41;
                                            if (i16 == 2) {
                                                bArr2 = bArr;
                                                zzbcVar5 = zzbcVar5;
                                                c = 2;
                                                int iZze = zzbd.zze(zzv(i47), i46 == true ? 1 : 0, bArr, i67, i2, zzczVar, zzbcVar);
                                                i47 = i47;
                                                i46 = i46 == true ? 1 : 0;
                                                i48 = 3;
                                                i49 = i67;
                                                i15 = i68;
                                                iZzh2 = iZze;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                bArr2 = bArr;
                                                i49 = i67;
                                                i48 = 3;
                                                i15 = i68;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            }
                                            break;
                                        case 28:
                                            i67 = iZzi;
                                            unsafe = unsafe5;
                                            i47 = i43;
                                            i68 = i41;
                                            if (i16 == 2) {
                                                iZzh12 = zzbd.zzh(bArr, i67, zzbcVar5);
                                                i69 = zzbcVar5.zza;
                                                if (i69 >= 0) {
                                                    throw zzdc.zzd();
                                                }
                                                if (i69 <= bArr.length - iZzh12) {
                                                    throw zzdc.zzg();
                                                }
                                                if (i69 == 0) {
                                                    zzczVar.add(zzbq.zzb);
                                                } else {
                                                    zzczVar.add(zzbq.zzl(bArr, iZzh12, i69));
                                                    iZzh12 += i69;
                                                }
                                                while (iZzh12 < i2) {
                                                    iZzh13 = zzbd.zzh(bArr, iZzh12, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        iZzh12 = zzbd.zzh(bArr, iZzh13, zzbcVar5);
                                                        i70 = zzbcVar5.zza;
                                                        if (i70 >= 0) {
                                                            throw zzdc.zzd();
                                                        }
                                                        if (i70 <= bArr.length - iZzh12) {
                                                            throw zzdc.zzg();
                                                        }
                                                        if (i70 == 0) {
                                                            zzczVar.add(zzbq.zzb);
                                                        } else {
                                                            zzczVar.add(zzbq.zzl(bArr, iZzh12, i70));
                                                            iZzh12 += i70;
                                                        }
                                                    } else {
                                                        this = this;
                                                        bArr2 = bArr;
                                                        zzbcVar5 = zzbcVar5;
                                                        i49 = i67;
                                                        i48 = 3;
                                                        i15 = i68;
                                                        iZzh2 = iZzh12;
                                                    }
                                                }
                                                this = this;
                                                bArr2 = bArr;
                                                zzbcVar5 = zzbcVar5;
                                                i49 = i67;
                                                i48 = 3;
                                                i15 = i68;
                                                iZzh2 = iZzh12;
                                            } else {
                                                bArr2 = bArr;
                                                i49 = i67;
                                                i48 = 3;
                                                i15 = i68;
                                                iZzh2 = i49;
                                            }
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 30:
                                        case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                            bArr3 = bArr;
                                            i71 = iZzi;
                                            unsafe = unsafe5;
                                            i47 = i43;
                                            if (i16 == 2) {
                                                iZzj = zzbd.zzf(bArr3, i71, zzczVar, zzbcVar5);
                                            } else if (i16 == 0) {
                                                this = this;
                                                bArr2 = bArr3;
                                                zzbcVar5 = zzbcVar5;
                                                i49 = i71;
                                                i15 = i41;
                                                i48 = 3;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                iZzj = zzbd.zzj(i46 == true ? 1 : 0, bArr, i71, i2, zzczVar, zzbcVar);
                                            }
                                            zzcwVarZzu = zzefVar2.zzu(i47);
                                            zzffVar = zzefVar2.zzm;
                                            int i116 = zzeq.zza;
                                            if (zzcwVarZzu != null) {
                                                i72 = iZzj;
                                                i73 = i41;
                                            } else if (zzczVar instanceof RandomAccess) {
                                                size = zzczVar.size();
                                                i74 = 0;
                                                i75 = 0;
                                                objZzo2 = null;
                                                while (i74 < size) {
                                                    int i117 = iZzj;
                                                    num = (Integer) zzczVar.get(i74);
                                                    iIntValue2 = num.intValue();
                                                    if (zzcwVarZzu.zza(iIntValue2)) {
                                                        if (i74 != i75) {
                                                            zzczVar.set(i75, num);
                                                        }
                                                        i75++;
                                                        i77 = 1;
                                                        i76 = i41;
                                                    } else {
                                                        i76 = i41;
                                                        objZzo2 = zzeq.zzo(obj2, i76, iIntValue2, objZzo2, zzffVar);
                                                        i77 = 1;
                                                    }
                                                    i74 += i77;
                                                    i41 = i76;
                                                    iZzj = i117;
                                                }
                                                i72 = iZzj;
                                                i73 = i41;
                                                if (i75 != size) {
                                                    zzczVar.subList(i75, size).clear();
                                                }
                                            } else {
                                                i72 = iZzj;
                                                i73 = i41;
                                                it = zzczVar.iterator();
                                                objZzo = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!zzcwVarZzu.zza(iIntValue)) {
                                                        objZzo = zzeq.zzo(obj2, i73, iIntValue, objZzo, zzffVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            this = this;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i48 = 3;
                                            i15 = i73;
                                            iZzh2 = i72;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 33:
                                        case 47:
                                            bArr3 = bArr;
                                            i71 = iZzi;
                                            unsafe = unsafe5;
                                            i47 = i43;
                                            if (i16 == 2) {
                                                if (i16 == 0) {
                                                    zzctVar3 = (zzct) zzczVar;
                                                    iZzh2 = zzbd.zzh(bArr3, i71, zzbcVar5);
                                                    zzctVar3.zzg(zzbu.zzb(zzbcVar5.zza));
                                                    while (iZzh2 < i2) {
                                                        iZzh14 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                        if (i46 == zzbcVar5.zza) {
                                                            iZzh2 = zzbd.zzh(bArr3, iZzh14, zzbcVar5);
                                                            zzctVar3.zzg(zzbu.zzb(zzbcVar5.zza));
                                                        }
                                                    }
                                                }
                                                this = zzefVar2;
                                                bArr2 = bArr3;
                                                zzbcVar5 = zzbcVar5;
                                                i49 = i71;
                                                i15 = i41;
                                                i48 = 3;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                zzctVar4 = (zzct) zzczVar;
                                                iZzh2 = zzbd.zzh(bArr3, i71, zzbcVar5);
                                                i78 = zzbcVar5.zza + iZzh2;
                                                while (iZzh2 < i78) {
                                                    iZzh2 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                    zzctVar4.zzg(zzbu.zzb(zzbcVar5.zza));
                                                }
                                                if (iZzh2 != i78) {
                                                    throw zzdc.zzg();
                                                }
                                            }
                                            this = zzefVar2;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i15 = i41;
                                            i48 = 3;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr3 = bArr;
                                            i71 = iZzi;
                                            unsafe = unsafe5;
                                            i47 = i43;
                                            if (i16 == 2) {
                                                if (i16 == 0) {
                                                    zzdrVar5 = (zzdr) zzczVar;
                                                    iZzh2 = zzbd.zzk(bArr3, i71, zzbcVar5);
                                                    zzdrVar5.zzf(zzbu.zzc(zzbcVar5.zzb));
                                                    while (iZzh2 < i2) {
                                                        iZzh15 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                        if (i46 == zzbcVar5.zza) {
                                                            iZzh2 = zzbd.zzk(bArr3, iZzh15, zzbcVar5);
                                                            zzdrVar5.zzf(zzbu.zzc(zzbcVar5.zzb));
                                                        }
                                                    }
                                                }
                                                this = zzefVar2;
                                                bArr2 = bArr3;
                                                zzbcVar5 = zzbcVar5;
                                                i49 = i71;
                                                i15 = i41;
                                                i48 = 3;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                zzdrVar6 = (zzdr) zzczVar;
                                                iZzh2 = zzbd.zzh(bArr3, i71, zzbcVar5);
                                                i79 = zzbcVar5.zza + iZzh2;
                                                while (iZzh2 < i79) {
                                                    iZzh2 = zzbd.zzk(bArr3, iZzh2, zzbcVar5);
                                                    zzdrVar6.zzf(zzbu.zzc(zzbcVar5.zzb));
                                                }
                                                if (iZzh2 != i79) {
                                                    throw zzdc.zzg();
                                                }
                                            }
                                            this = zzefVar2;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i15 = i41;
                                            i48 = 3;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        default:
                                            if (i16 == 3) {
                                                i80 = ((i46 == true ? 1 : 0) & (-8)) | 4;
                                                i81 = i43;
                                                zzeoVarZzv = zzefVar2.zzv(i81);
                                                i71 = iZzi;
                                                unsafe = unsafe5;
                                                iZzh2 = zzbd.zzc(zzeoVarZzv, bArr, i71, i2, i80, zzbcVar);
                                                zzczVar.add(zzbcVar5.zzc);
                                                i82 = i2;
                                                while (true) {
                                                    if (iZzh2 < i82) {
                                                        i83 = i81;
                                                        bArr3 = bArr;
                                                        iZzh16 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                        if (i46 == zzbcVar5.zza) {
                                                            iZzh2 = zzbd.zzc(zzeoVarZzv, bArr, iZzh16, i2, i80, zzbcVar);
                                                            zzczVar.add(zzbcVar5.zzc);
                                                            i82 = i82;
                                                            i81 = i83;
                                                            zzeoVarZzv = zzeoVarZzv;
                                                        } else {
                                                            i47 = i83;
                                                        }
                                                    } else {
                                                        i47 = i81;
                                                        bArr3 = bArr;
                                                    }
                                                }
                                                this = zzefVar2;
                                                bArr2 = bArr3;
                                                zzbcVar5 = zzbcVar5;
                                                i49 = i71;
                                                i15 = i41;
                                                i48 = 3;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            } else {
                                                unsafe = unsafe5;
                                                this = zzefVar2;
                                                zzbcVar5 = zzbcVar5;
                                                i47 = i43;
                                                i15 = i41;
                                                i48 = 3;
                                                bArr2 = bArr;
                                                i49 = iZzi;
                                                iZzh2 = i49;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    unsafe = unsafe5;
                                    i45 = i43;
                                    i15 = i41;
                                    zzefVar = zzefVar2;
                                    i44 = iZzi;
                                    bArr2 = bArr;
                                    if (iZzr == 50) {
                                        obj2 = obj;
                                        unsafe8 = zzb;
                                        j3 = iArr[i45 + 2] & 1048575;
                                        switch (iZzr) {
                                            case 51:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 1) {
                                                    iZzk = i85 + 8;
                                                    unsafe8.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzbd.zzn(bArr2, i85))));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 52:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 5) {
                                                    iZzk = i85 + 4;
                                                    unsafe8.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzbd.zzb(bArr2, i85))));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 0) {
                                                    iZzk = zzbd.zzk(bArr2, i85, zzbcVar2);
                                                    unsafe8.putObject(obj2, j, Long.valueOf(zzbcVar2.zzb));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 0) {
                                                    iZzk = zzbd.zzh(bArr2, i85, zzbcVar2);
                                                    unsafe8.putObject(obj2, j, Integer.valueOf(zzbcVar2.zza));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 56:
                                            case 65:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 1) {
                                                    iZzk = i85 + 8;
                                                    unsafe8.putObject(obj2, j, Long.valueOf(zzbd.zzn(bArr2, i85)));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 5) {
                                                    iZzk = i85 + 4;
                                                    unsafe8.putObject(obj2, j, Integer.valueOf(zzbd.zzb(bArr2, i85)));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 58:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 0) {
                                                    iZzk = zzbd.zzk(bArr2, i85, zzbcVar2);
                                                    if (zzbcVar2.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    unsafe8.putObject(obj2, j, Boolean.valueOf(z5));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzk;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 59:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                if (i16 == 2) {
                                                    iZzh17 = zzbd.zzh(bArr2, i85, zzbcVar2);
                                                    i87 = zzbcVar2.zza;
                                                    if (i87 == 0) {
                                                        unsafe8.putObject(obj2, j, "");
                                                    } else {
                                                        i88 = iZzh17 + i87;
                                                        if ((i17 & 536870912) == 0 && !zzfu.zze(bArr2, iZzh17, i88)) {
                                                            throw zzdc.zzc();
                                                        }
                                                        unsafe8.putObject(obj2, j, new String(bArr2, iZzh17, i87, zzda.zzb));
                                                        iZzh17 = i88;
                                                    }
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzh17;
                                                } else {
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 60:
                                                if (i16 == 2) {
                                                    Object objZzy = zzefVar.zzy(obj2, i15, i45);
                                                    zzeo zzeoVarZzv2 = zzefVar.zzv(i45);
                                                    i10 = 3;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i85 = i44;
                                                    zzefVar = zzefVar;
                                                    int iZzm2 = zzbd.zzm(objZzy, zzeoVarZzv2, bArr, i44, i2, zzbcVar);
                                                    zzefVar.zzG(obj2, i15, i45, objZzy);
                                                    zzbcVar2 = zzbcVar;
                                                    iZzl = iZzm2;
                                                    i2 = i2;
                                                    i86 = i45;
                                                } else {
                                                    zzefVar = zzefVar;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i10 = 3;
                                                    i85 = i44;
                                                    i2 = i2;
                                                    zzbcVar2 = zzbcVar;
                                                    i86 = i45;
                                                    iZzl = i85;
                                                }
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 61:
                                                i89 = i44;
                                                i90 = i45;
                                                zzbcVar6 = zzbcVar;
                                                if (i16 == 2) {
                                                    int iZza2 = zzbd.zza(bArr2, i89, zzbcVar6);
                                                    unsafe8.putObject(obj2, j, zzbcVar6.zzc);
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZza2;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i86 = i90;
                                                    i10 = 3;
                                                    i85 = i89;
                                                    zzbcVar2 = zzbcVar6;
                                                    if (iZzl != i85) {
                                                        i3 = i3;
                                                        zzbcVar7 = zzbcVar2;
                                                        i92 = i2;
                                                        i96 = i15;
                                                        i97 = i86;
                                                        i95 = -1;
                                                        i93 = i10;
                                                        i99 = i84;
                                                        unsafe9 = unsafe;
                                                        bArr4 = bArr2;
                                                        zzefVar2 = zzefVar;
                                                        i94 = 0;
                                                        i100 = i12;
                                                    } else {
                                                        i4 = i3;
                                                        i14 = iZzl;
                                                        i97 = i86;
                                                        i101 = i84;
                                                    }
                                                }
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                iZzl = i85;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 63:
                                                i89 = i44;
                                                i90 = i45;
                                                zzbcVar6 = zzbcVar;
                                                if (i16 == 0) {
                                                    iZzh18 = zzbd.zzh(bArr2, i89, zzbcVar6);
                                                    i91 = zzbcVar6.zza;
                                                    zzcwVarZzu2 = zzefVar.zzu(i90);
                                                    if (zzcwVarZzu2 != null || zzcwVarZzu2.zza(i91)) {
                                                        unsafe8.putObject(obj2, j, Integer.valueOf(i91));
                                                        unsafe8.putInt(obj2, j3, i15);
                                                    } else {
                                                        zzd(obj).zzj(i46 == true ? 1 : 0, Long.valueOf(i91));
                                                    }
                                                    iZzl = iZzh18;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i86 = i90;
                                                    i10 = 3;
                                                    i85 = i89;
                                                    zzbcVar2 = zzbcVar6;
                                                    if (iZzl != i85) {
                                                        i3 = i3;
                                                        zzbcVar7 = zzbcVar2;
                                                        i92 = i2;
                                                        i96 = i15;
                                                        i97 = i86;
                                                        i95 = -1;
                                                        i93 = i10;
                                                        i99 = i84;
                                                        unsafe9 = unsafe;
                                                        bArr4 = bArr2;
                                                        zzefVar2 = zzefVar;
                                                        i94 = 0;
                                                        i100 = i12;
                                                    } else {
                                                        i4 = i3;
                                                        i14 = iZzl;
                                                        i97 = i86;
                                                        i101 = i84;
                                                    }
                                                }
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                iZzl = i85;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                                i89 = i44;
                                                i90 = i45;
                                                zzbcVar6 = zzbcVar;
                                                if (i16 == 0) {
                                                    iZzh18 = zzbd.zzh(bArr2, i89, zzbcVar6);
                                                    unsafe8.putObject(obj2, j, Integer.valueOf(zzbu.zzb(zzbcVar6.zza)));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzh18;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i86 = i90;
                                                    i10 = 3;
                                                    i85 = i89;
                                                    zzbcVar2 = zzbcVar6;
                                                    if (iZzl != i85) {
                                                        i3 = i3;
                                                        zzbcVar7 = zzbcVar2;
                                                        i92 = i2;
                                                        i96 = i15;
                                                        i97 = i86;
                                                        i95 = -1;
                                                        i93 = i10;
                                                        i99 = i84;
                                                        unsafe9 = unsafe;
                                                        bArr4 = bArr2;
                                                        zzefVar2 = zzefVar;
                                                        i94 = 0;
                                                        i100 = i12;
                                                    } else {
                                                        i4 = i3;
                                                        i14 = iZzl;
                                                        i97 = i86;
                                                        i101 = i84;
                                                    }
                                                }
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                iZzl = i85;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                            case 67:
                                                i89 = i44;
                                                i90 = i45;
                                                if (i16 == 0) {
                                                    zzbcVar6 = zzbcVar;
                                                    iZzh18 = zzbd.zzk(bArr2, i89, zzbcVar6);
                                                    unsafe8.putObject(obj2, j, Long.valueOf(zzbu.zzc(zzbcVar6.zzb)));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                    iZzl = iZzh18;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i86 = i90;
                                                    i10 = 3;
                                                    i85 = i89;
                                                    zzbcVar2 = zzbcVar6;
                                                    if (iZzl != i85) {
                                                        i3 = i3;
                                                        zzbcVar7 = zzbcVar2;
                                                        i92 = i2;
                                                        i96 = i15;
                                                        i97 = i86;
                                                        i95 = -1;
                                                        i93 = i10;
                                                        i99 = i84;
                                                        unsafe9 = unsafe;
                                                        bArr4 = bArr2;
                                                        zzefVar2 = zzefVar;
                                                        i94 = 0;
                                                        i100 = i12;
                                                    } else {
                                                        i4 = i3;
                                                        i14 = iZzl;
                                                        i97 = i86;
                                                        i101 = i84;
                                                    }
                                                } else {
                                                    i2 = i2;
                                                    zzefVar = zzefVar;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i86 = i90;
                                                    i10 = 3;
                                                    i85 = i89;
                                                    zzbcVar2 = zzbcVar;
                                                    iZzl = i85;
                                                    if (iZzl != i85) {
                                                        i3 = i3;
                                                        zzbcVar7 = zzbcVar2;
                                                        i92 = i2;
                                                        i96 = i15;
                                                        i97 = i86;
                                                        i95 = -1;
                                                        i93 = i10;
                                                        i99 = i84;
                                                        unsafe9 = unsafe;
                                                        bArr4 = bArr2;
                                                        zzefVar2 = zzefVar;
                                                        i94 = 0;
                                                        i100 = i12;
                                                    } else {
                                                        i4 = i3;
                                                        i14 = iZzl;
                                                        i97 = i86;
                                                        i101 = i84;
                                                    }
                                                }
                                                break;
                                            case 68:
                                                if (i16 == 3) {
                                                    break;
                                                } else {
                                                    int i118 = ((i46 == true ? 1 : 0) & (-8)) | 4;
                                                    Object objZzy2 = zzefVar.zzy(obj2, i15, i45);
                                                    iZzl = zzbd.zzl(objZzy2, zzefVar.zzv(i45), bArr, i44, i2, i118, zzbcVar);
                                                    zzefVar.zzG(obj2, i15, i45, objZzy2);
                                                    i2 = i2;
                                                    i86 = i45;
                                                    zzefVar = zzefVar;
                                                    i85 = i44;
                                                    i84 = i46 == true ? 1 : 0;
                                                    i10 = 3;
                                                    zzbcVar2 = zzbcVar;
                                                }
                                                if (iZzl != i85) {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                    break;
                                                } else {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    break;
                                                }
                                            default:
                                                zzbcVar2 = zzbcVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                i86 = i45;
                                                i10 = 3;
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                iZzl = i85;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i16 == 2) {
                                            unsafe7 = zzb;
                                            Object objZzw = zzefVar.zzw(i45);
                                            object = unsafe7.getObject(obj, j);
                                            if (!((zzdw) object).zze()) {
                                                zzdw zzdwVarZzb = zzdw.zza().zzb();
                                                zzdx.zza(zzdwVarZzb, object);
                                                unsafe7.putObject(obj, j, zzdwVarZzb);
                                            }
                                            throw null;
                                        }
                                        zzbcVar4 = zzbcVar5;
                                        obj2 = obj;
                                        i4 = i3;
                                        zzbcVar2 = zzbcVar4;
                                        i101 = i46;
                                        i97 = i45;
                                        i10 = 3;
                                        i2 = i2;
                                        int i119 = i44;
                                        zzefVar = zzefVar;
                                        i14 = i119;
                                    }
                                }
                            } else if (i16 == 2) {
                                zzczVarZzd = (zzcz) unsafe5.getObject(obj2, j);
                                if (!zzczVarZzd.zzc()) {
                                    int size3 = zzczVarZzd.size();
                                    zzczVarZzd = zzczVarZzd.zzd(size3 != 0 ? size3 + size3 : 10);
                                    unsafe5.putObject(obj2, j, zzczVarZzd);
                                }
                                iZzl = zzbd.zze(zzefVar2.zzv(i43), b == true ? 1 : 0, bArr, iZzi, i2, zzczVarZzd, zzbcVar);
                                i99 = b == true ? 1 : 0;
                                unsafe9 = unsafe5;
                                zzbcVar7 = zzbcVar3;
                                i93 = 3;
                                i97 = i43;
                                i94 = 0;
                                i100 = i42;
                                i95 = -1;
                                i96 = i41;
                                bArr4 = bArr;
                                i92 = i2;
                                i3 = i3;
                            } else {
                                i12 = i42;
                                i13 = 0;
                                i44 = iZzi;
                                unsafe = unsafe5;
                                zzbcVar4 = zzbcVar3;
                                i15 = i41;
                                zzefVar = zzefVar2;
                                bArr2 = bArr;
                                i45 = i43;
                                i46 = b == true ? 1 : 0;
                                i4 = i3;
                                zzbcVar2 = zzbcVar4;
                                i101 = i46;
                                i97 = i45;
                                i10 = 3;
                                i2 = i2;
                                int i1110 = i44;
                                zzefVar = zzefVar;
                                i14 = i1110;
                            }
                        }
                    } else {
                        i10 = i93;
                        i4 = i3;
                        i11 = i95;
                        i97 = i94;
                        unsafe = unsafe9;
                        i12 = i100;
                        zzbcVar2 = zzbcVar7;
                        i2 = i92;
                        i13 = i97;
                        zzefVar = zzefVar2;
                        i14 = iZzi;
                        bArr2 = bArr4;
                        i15 = i102;
                    }
                    if (i101 == i4 || i4 == 0) {
                        if (zzefVar.zzh || (zzcdVar = zzbcVar2.zzd) == zzcd.zza) {
                            iZzg = zzbd.zzg(i101 == true ? 1 : 0, bArr, i14, i2, zzd(obj), zzbcVar);
                        } else {
                            if (zzcdVar.zzb(zzefVar.zzg, i15) != null) {
                                throw null;
                            }
                            iZzg = zzbd.zzg(i101 == true ? 1 : 0, bArr, i14, i2, zzd(obj), zzbcVar);
                        }
                        zzbcVar7 = zzbcVar;
                        i99 = i101;
                        i3 = i4;
                        i92 = i2;
                        i96 = i15;
                        i95 = i11;
                        i93 = i10;
                        unsafe9 = unsafe;
                        bArr4 = bArr2;
                        iZzl = iZzg;
                        zzefVar2 = zzefVar;
                        i94 = i13;
                        i100 = i12;
                    } else {
                        i7 = i101;
                        i6 = i98;
                        i8 = i12;
                        i5 = 1048575;
                        iZzl = i14;
                    }
                }
                i9 = iZzq;
                if (i9 == i95) {
                    i16 = (i101 == true ? 1 : 0) & 7;
                    iArr = zzefVar2.zzc;
                    i17 = iArr[i9 + 1];
                    iZzr = zzr(i17);
                    j = i17 & 1048575;
                    b = i101 == true ? 1 : 0;
                    if (iZzr <= 17) {
                        int i1011 = iArr[i9 + 2];
                        i18 = 1 << (i1011 >>> 20);
                        i19 = 1048575;
                        i20 = i1011 & 1048575;
                        i21 = i100;
                        i22 = iZzi;
                        if (i20 != i21) {
                            if (i21 != 1048575) {
                                unsafe9.putInt(obj2, i21, i98);
                                i19 = 1048575;
                            }
                            if (i20 == i19) {
                                i23 = 0;
                            } else {
                                i23 = unsafe9.getInt(obj2, i20);
                            }
                            i100 = i20;
                        } else {
                            i23 = i98;
                            i100 = i21;
                        }
                        switch (iZzr) {
                            case 0:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 1) {
                                    int i1012 = i28 + 8;
                                    int i1013 = i23 | i18;
                                    zzfp.zzo(obj2, j, Double.longBitsToDouble(zzbd.zzn(bArr4, i28)));
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26 == true ? 1 : 0;
                                    i93 = 3;
                                    i100 = i100;
                                    i95 = -1;
                                    i96 = i24;
                                    i98 = i1013;
                                    unsafe9 = unsafe2;
                                    i94 = 0;
                                    iZzl = i1012;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 1:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 5) {
                                    iZzh = i28 + 4;
                                    i30 = i23 | i18;
                                    zzfp.zzp(obj2, j, Float.intBitsToFloat(zzbd.zzb(bArr4, i28)));
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i93 = i29;
                                    i100 = i100;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i30;
                                    unsafe9 = unsafe2;
                                    i94 = i27;
                                    iZzl = iZzh;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 2:
                            case 3:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 0) {
                                    int i1014 = i23 | i18;
                                    int iZzk4 = zzbd.zzk(bArr4, i28, zzbcVar7);
                                    unsafe2.putLong(obj, j, zzbcVar7.zzb);
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26 == true ? 1 : 0;
                                    i93 = 3;
                                    i100 = i100;
                                    i98 = i1014;
                                    unsafe9 = unsafe2;
                                    i96 = i24;
                                    i94 = 0;
                                    iZzl = iZzk4;
                                    i95 = -1;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 4:
                            case 11:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 0) {
                                    i30 = i23 | i18;
                                    iZzh = zzbd.zzh(bArr4, i28, zzbcVar7);
                                    unsafe2.putInt(obj2, j, zzbcVar7.zza);
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i93 = i29;
                                    i100 = i100;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i30;
                                    unsafe9 = unsafe2;
                                    i94 = i27;
                                    iZzl = iZzh;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 5:
                            case 14:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 1) {
                                    int i1015 = i28 + 8;
                                    unsafe2.putLong(obj, j, zzbd.zzn(bArr4, i28));
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26 == true ? 1 : 0;
                                    i93 = 3;
                                    i100 = i100;
                                    i98 = i18 | i23;
                                    unsafe9 = unsafe2;
                                    i95 = -1;
                                    i94 = 0;
                                    iZzl = i1015;
                                    i96 = i24;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 6:
                            case 13:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 5) {
                                    iZzh = i28 + 4;
                                    i30 = i23 | i18;
                                    unsafe2.putInt(obj2, j, zzbd.zzb(bArr4, i28));
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i93 = i29;
                                    i100 = i100;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i30;
                                    unsafe9 = unsafe2;
                                    i94 = i27;
                                    iZzl = iZzh;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 7:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i27 = 0;
                                i29 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 0) {
                                    i30 = i23 | i18;
                                    iZzh = zzbd.zzk(bArr4, i28, zzbcVar7);
                                    if (zzbcVar7.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzfp.zzm(obj2, j, z);
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i93 = i29;
                                    i100 = i100;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i30;
                                    unsafe9 = unsafe2;
                                    i94 = i27;
                                    iZzl = iZzh;
                                } else {
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 8:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i28 = i22;
                                i26 = b == true ? 1 : 0;
                                i31 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 2) {
                                    if ((i17 & 536870912) != 0) {
                                        iZzh = zzbd.zzh(bArr4, i28, zzbcVar7);
                                        i33 = zzbcVar7.zza;
                                        if (i33 >= 0) {
                                            throw zzdc.zzd();
                                        }
                                        i34 = i23 | i18;
                                        if (i33 == 0) {
                                            zzbcVar7.zzc = "";
                                            i37 = i34;
                                            i27 = 0;
                                        } else {
                                            int i1016 = zzfu.zza;
                                            length = bArr4.length;
                                            if ((((length - iZzh) - i33) | iZzh | i33) >= 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzh), Integer.valueOf(i33)));
                                            }
                                            i35 = iZzh + i33;
                                            cArr = new char[i33];
                                            i36 = 0;
                                            while (iZzh < i35) {
                                                b4 = bArr4[iZzh];
                                                if (zzfq.zzd(b4)) {
                                                    iZzh++;
                                                    cArr[i36] = (char) b4;
                                                    i36++;
                                                } else {
                                                    while (true) {
                                                        while (true) {
                                                            if (iZzh < i35) {
                                                                i38 = iZzh + 1;
                                                                b2 = bArr4[iZzh];
                                                                if (zzfq.zzd(b2)) {
                                                                    cArr[i36] = (char) b2;
                                                                    i36++;
                                                                    iZzh = i38;
                                                                    while (iZzh < i35) {
                                                                        b3 = bArr4[iZzh];
                                                                        if (zzfq.zzd(b3)) {
                                                                            iZzh++;
                                                                            cArr[i36] = (char) b3;
                                                                            i36++;
                                                                        }
                                                                    }
                                                                } else {
                                                                    i34 = i34;
                                                                    if (b2 < -32) {
                                                                        if (i38 < i35) {
                                                                            throw zzdc.zzc();
                                                                        }
                                                                        iZzh += 2;
                                                                        zzfq.zzc(b2, bArr4[i38], cArr, i36);
                                                                        i36++;
                                                                        i34 = i34;
                                                                    } else if (b2 < -16) {
                                                                        if (i38 < i35 - 1) {
                                                                            throw zzdc.zzc();
                                                                        }
                                                                        int i1017 = iZzh + 2;
                                                                        iZzh += 3;
                                                                        zzfq.zzb(b2, bArr4[i38], bArr4[i1017], cArr, i36);
                                                                        i36++;
                                                                    } else {
                                                                        if (i38 < i35 - 2) {
                                                                            throw zzdc.zzc();
                                                                        }
                                                                        byte b9 = bArr4[i38];
                                                                        int i1111 = iZzh + 3;
                                                                        byte b10 = bArr4[iZzh + 2];
                                                                        iZzh += 4;
                                                                        zzfq.zza(b2, b9, b10, bArr4[i1111], cArr, i36);
                                                                        i36 += 2;
                                                                    }
                                                                }
                                                            } else {
                                                                i37 = i34;
                                                                i27 = 0;
                                                                zzbcVar7.zzc = new String(cArr, 0, i36);
                                                                iZzh = i35;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            while (true) {
                                                while (true) {
                                                    if (iZzh < i35) {
                                                        i38 = iZzh + 1;
                                                        b2 = bArr4[iZzh];
                                                        if (zzfq.zzd(b2)) {
                                                            cArr[i36] = (char) b2;
                                                            i36++;
                                                            iZzh = i38;
                                                            while (iZzh < i35) {
                                                                b3 = bArr4[iZzh];
                                                                if (zzfq.zzd(b3)) {
                                                                    iZzh++;
                                                                    cArr[i36] = (char) b3;
                                                                    i36++;
                                                                }
                                                            }
                                                        } else {
                                                            i34 = i34;
                                                            if (b2 < -32) {
                                                                if (i38 < i35) {
                                                                    throw zzdc.zzc();
                                                                }
                                                                iZzh += 2;
                                                                zzfq.zzc(b2, bArr4[i38], cArr, i36);
                                                                i36++;
                                                                i34 = i34;
                                                            } else if (b2 < -16) {
                                                                if (i38 < i35 - 1) {
                                                                    throw zzdc.zzc();
                                                                }
                                                                int i1018 = iZzh + 2;
                                                                iZzh += 3;
                                                                zzfq.zzb(b2, bArr4[i38], bArr4[i1018], cArr, i36);
                                                                i36++;
                                                            } else {
                                                                if (i38 < i35 - 2) {
                                                                    throw zzdc.zzc();
                                                                }
                                                                byte b11 = bArr4[i38];
                                                                int i1112 = iZzh + 3;
                                                                byte b12 = bArr4[iZzh + 2];
                                                                iZzh += 4;
                                                                zzfq.zza(b2, b11, b12, bArr4[i1112], cArr, i36);
                                                                i36 += 2;
                                                            }
                                                        }
                                                    } else {
                                                        i37 = i34;
                                                        i27 = 0;
                                                        zzbcVar7.zzc = new String(cArr, 0, i36);
                                                        iZzh = i35;
                                                    }
                                                }
                                            }
                                        }
                                        i30 = i37;
                                        i29 = 3;
                                    } else {
                                        i29 = 3;
                                        i27 = 0;
                                        iZzh = zzbd.zzh(bArr4, i28, zzbcVar7);
                                        i32 = zzbcVar7.zza;
                                        if (i32 >= 0) {
                                            throw zzdc.zzd();
                                        }
                                        i30 = i23 | i18;
                                        if (i32 == 0) {
                                            zzbcVar7.zzc = "";
                                        } else {
                                            zzbcVar7.zzc = new String(bArr4, iZzh, i32, zzda.zzb);
                                            iZzh += i32;
                                        }
                                    }
                                    unsafe2.putObject(obj2, j, zzbcVar7.zzc);
                                    i92 = i2;
                                    i3 = i3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i93 = i29;
                                    i100 = i100;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i30;
                                    unsafe9 = unsafe2;
                                    i94 = i27;
                                    iZzl = iZzh;
                                } else {
                                    i29 = i31;
                                    i27 = 0;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 9:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i39 = i22;
                                i26 = b == true ? 1 : 0;
                                i31 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 2) {
                                    int i1113 = i23 | i18;
                                    Object objZzx3 = zzefVar2.zzx(obj2, i25);
                                    i92 = i2;
                                    int iZzm3 = zzbd.zzm(objZzx3, zzefVar2.zzv(i25), bArr, i39, i92, zzbcVar);
                                    zzefVar2.zzF(obj2, i25, objZzx3);
                                    i93 = 3;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26 == true ? 1 : 0;
                                    i95 = -1;
                                    iZzl = iZzm3;
                                    i98 = i1113;
                                    unsafe9 = unsafe2;
                                    i96 = i24;
                                    i94 = 0;
                                } else {
                                    i28 = i39;
                                    i29 = i31;
                                    i27 = 0;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 10:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i39 = i22;
                                i26 = b == true ? 1 : 0;
                                i31 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 2) {
                                    i23 |= i18;
                                    iZza = zzbd.zza(bArr4, i39, zzbcVar7);
                                    unsafe2.putObject(obj2, j, zzbcVar7.zzc);
                                    i92 = i2;
                                    i93 = i31;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i23;
                                    iZzl = iZza;
                                    unsafe9 = unsafe2;
                                    i94 = 0;
                                } else {
                                    i28 = i39;
                                    i29 = i31;
                                    i27 = 0;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 12:
                                i24 = i102;
                                unsafe2 = unsafe9;
                                i39 = i22;
                                i26 = b == true ? 1 : 0;
                                i31 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 0) {
                                    iZza = zzbd.zzh(bArr4, i39, zzbcVar7);
                                    i40 = zzbcVar7.zza;
                                    zzcw zzcwVarZzu4 = zzefVar2.zzu(i25);
                                    if ((i17 & Integer.MIN_VALUE) != 0) {
                                        i23 |= i18;
                                        unsafe2.putInt(obj2, j, i40);
                                    } else {
                                        i23 |= i18;
                                        unsafe2.putInt(obj2, j, i40);
                                    }
                                    i92 = i2;
                                    i93 = i31;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i23;
                                    iZzl = iZza;
                                    unsafe9 = unsafe2;
                                    i94 = 0;
                                } else {
                                    i28 = i39;
                                    i29 = i31;
                                    i27 = 0;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 15:
                                i24 = i102;
                                unsafe3 = unsafe9;
                                i39 = i22;
                                i26 = b == true ? 1 : 0;
                                i31 = 3;
                                i11 = -1;
                                i25 = i9;
                                zzbcVar7 = zzbcVar7;
                                if (i16 == 0) {
                                    i23 |= i18;
                                    iZza = zzbd.zzh(bArr4, i39, zzbcVar7);
                                    unsafe2 = unsafe3;
                                    unsafe2.putInt(obj2, j, zzbu.zzb(zzbcVar7.zza));
                                    i92 = i2;
                                    i93 = i31;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26;
                                    i95 = i11;
                                    i96 = i24;
                                    i98 = i23;
                                    iZzl = iZza;
                                    unsafe9 = unsafe2;
                                    i94 = 0;
                                } else {
                                    unsafe2 = unsafe3;
                                    i28 = i39;
                                    i29 = i31;
                                    i27 = 0;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            case 16:
                                i24 = i102;
                                unsafe4 = unsafe9;
                                i26 = b == true ? 1 : 0;
                                i93 = 3;
                                i11 = -1;
                                i25 = i9;
                                if (i16 == 0) {
                                    int i1114 = i23 | i18;
                                    int iZzk5 = zzbd.zzk(bArr4, i22, zzbcVar7);
                                    unsafe4.putLong(obj, j, zzbu.zzc(zzbcVar7.zzb));
                                    i92 = i2;
                                    i3 = i3;
                                    i93 = 3;
                                    iZzl = iZzk5;
                                    zzbcVar7 = zzbcVar7;
                                    i97 = i25;
                                    i99 = i26 == true ? 1 : 0;
                                    i100 = i100;
                                    i95 = -1;
                                    unsafe9 = unsafe4;
                                    i96 = i24;
                                    i94 = 0;
                                    i98 = i1114;
                                } else {
                                    unsafe2 = unsafe4;
                                    i27 = 0;
                                    i29 = i93;
                                    i28 = i22;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                            default:
                                i93 = 3;
                                if (i16 == 3) {
                                    int i1115 = i23 | i18;
                                    Object objZzx4 = zzefVar2.zzx(obj2, i9);
                                    int i1116 = i9;
                                    iZzl = zzbd.zzl(objZzx4, zzefVar2.zzv(i9), bArr, i22, i2, (i102 << 3) | 4, zzbcVar);
                                    zzefVar2.zzF(obj2, i1116, objZzx4);
                                    i99 = b == true ? 1 : 0;
                                    i97 = i1116;
                                    i100 = i100;
                                    i95 = -1;
                                    unsafe9 = unsafe9;
                                    i96 = i102;
                                    i94 = 0;
                                    i92 = i2;
                                    i3 = i3;
                                    i98 = i1115;
                                } else {
                                    i24 = i102;
                                    i11 = -1;
                                    i25 = i9;
                                    unsafe2 = unsafe9;
                                    i26 = b == true ? 1 : 0;
                                    i27 = 0;
                                    i29 = i93;
                                    i28 = i22;
                                    i4 = i3;
                                    i14 = i28;
                                    zzbcVar2 = zzbcVar7;
                                    i97 = i25;
                                    unsafe = unsafe2;
                                    i10 = i29;
                                    i12 = i100;
                                    zzefVar = zzefVar2;
                                    i98 = i23;
                                    i13 = i27;
                                    i101 = i26;
                                    bArr2 = bArr4;
                                    i15 = i24;
                                    i2 = i2;
                                }
                                break;
                        }
                    } else {
                        i41 = i102;
                        i42 = i100;
                        i11 = -1;
                        i43 = i9;
                        zzbcVar3 = zzbcVar7;
                        unsafe5 = unsafe9;
                        if (iZzr == 27) {
                            i12 = i42;
                            i46 = b == true ? 1 : 0;
                            i13 = 0;
                            zzbcVar5 = zzbcVar3;
                            if (iZzr <= 49) {
                                j2 = i17;
                                unsafe6 = zzb;
                                zzczVar = (zzcz) unsafe6.getObject(obj2, j);
                                if (!zzczVar.zzc()) {
                                    int size4 = zzczVar.size();
                                    zzcz zzczVarZzd3 = zzczVar.zzd(size4 != 0 ? size4 + size4 : 10);
                                    unsafe6.putObject(obj2, j, zzczVarZzd3);
                                    zzczVar = zzczVarZzd3;
                                }
                                switch (iZzr) {
                                    case 18:
                                    case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                        unsafe = unsafe5;
                                        zzbcVar5 = zzbcVar5;
                                        i47 = i43;
                                        i15 = i41;
                                        i48 = 3;
                                        this = zzefVar2;
                                        i49 = iZzi;
                                        bArr2 = bArr;
                                        if (i16 == 2) {
                                            zzcaVar2 = (zzca) zzczVar;
                                            iZzh2 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                            i51 = zzbcVar5.zza + iZzh2;
                                            while (iZzh2 < i51) {
                                                zzcaVar2.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, iZzh2)));
                                                iZzh2 += 8;
                                            }
                                            if (iZzh2 != i51) {
                                                throw zzdc.zzg();
                                            }
                                        } else if (i16 == 1) {
                                            i50 = i49 + 8;
                                            zzcaVar = (zzca) zzczVar;
                                            zzcaVar.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, i49)));
                                            while (i50 < i2) {
                                                iZzh3 = zzbd.zzh(bArr2, i50, zzbcVar5);
                                                if (i46 == zzbcVar5.zza) {
                                                    zzcaVar.zzf(Double.longBitsToDouble(zzbd.zzn(bArr2, iZzh3)));
                                                    i50 = iZzh3 + 8;
                                                } else {
                                                    iZzh2 = i50;
                                                }
                                            }
                                            iZzh2 = i50;
                                        } else {
                                            iZzh2 = i49;
                                        }
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 19:
                                    case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                        unsafe = unsafe5;
                                        zzbcVar5 = zzbcVar5;
                                        i47 = i43;
                                        i15 = i41;
                                        i48 = 3;
                                        this = zzefVar2;
                                        i49 = iZzi;
                                        bArr2 = bArr;
                                        if (i16 == 2) {
                                            zzckVar2 = (zzck) zzczVar;
                                            iZzh2 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                            i52 = zzbcVar5.zza + iZzh2;
                                            while (iZzh2 < i52) {
                                                zzckVar2.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, iZzh2)));
                                                iZzh2 += 4;
                                            }
                                            if (iZzh2 != i52) {
                                                throw zzdc.zzg();
                                            }
                                        } else if (i16 == 5) {
                                            iZzh2 = i49 + 4;
                                            zzckVar = (zzck) zzczVar;
                                            zzckVar.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, i49)));
                                            while (iZzh2 < i2) {
                                                iZzh4 = zzbd.zzh(bArr2, iZzh2, zzbcVar5);
                                                if (i46 == zzbcVar5.zza) {
                                                    zzckVar.zzf(Float.intBitsToFloat(zzbd.zzb(bArr2, iZzh4)));
                                                    iZzh2 = iZzh4 + 4;
                                                }
                                            }
                                        } else {
                                            iZzh2 = i49;
                                        }
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                    case 38:
                                        unsafe = unsafe5;
                                        zzbcVar5 = zzbcVar5;
                                        i47 = i43;
                                        i15 = i41;
                                        i48 = 3;
                                        this = zzefVar2;
                                        i49 = iZzi;
                                        bArr2 = bArr;
                                        if (i16 == 2) {
                                            zzdrVar2 = (zzdr) zzczVar;
                                            iZzh2 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                            i53 = zzbcVar5.zza + iZzh2;
                                            while (iZzh2 < i53) {
                                                iZzh2 = zzbd.zzk(bArr2, iZzh2, zzbcVar5);
                                                zzdrVar2.zzf(zzbcVar5.zzb);
                                            }
                                            if (iZzh2 != i53) {
                                                throw zzdc.zzg();
                                            }
                                        } else if (i16 == 0) {
                                            zzdrVar = (zzdr) zzczVar;
                                            iZzh2 = zzbd.zzk(bArr2, i49, zzbcVar5);
                                            zzdrVar.zzf(zzbcVar5.zzb);
                                            while (iZzh2 < i2) {
                                                iZzh5 = zzbd.zzh(bArr2, iZzh2, zzbcVar5);
                                                if (i46 == zzbcVar5.zza) {
                                                    iZzh2 = zzbd.zzk(bArr2, iZzh5, zzbcVar5);
                                                    zzdrVar.zzf(zzbcVar5.zzb);
                                                }
                                            }
                                        } else {
                                            iZzh2 = i49;
                                        }
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                    case 43:
                                        bArr2 = bArr;
                                        unsafe = unsafe5;
                                        i54 = i46 == true ? 1 : 0;
                                        zzbcVar5 = zzbcVar5;
                                        i55 = i41;
                                        i56 = 3;
                                        c = 2;
                                        i49 = iZzi;
                                        i57 = i43;
                                        if (i16 == 2) {
                                            iZzf = zzbd.zzf(bArr2, i49, zzczVar, zzbcVar5);
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            iZzh2 = iZzf;
                                            this = this;
                                        } else if (i16 == 0) {
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54 == true ? 1 : 0;
                                            i48 = 3;
                                            iZzh2 = zzbd.zzj(i54 == true ? 1 : 0, bArr, i49, i2, zzczVar, zzbcVar);
                                            this = this;
                                        } else {
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54 == true ? 1 : 0;
                                            i48 = 3;
                                            this = this;
                                            iZzh2 = i49;
                                        }
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                    case 32:
                                    case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    case 46:
                                        bArr2 = bArr;
                                        unsafe = unsafe5;
                                        i54 = i46 == true ? 1 : 0;
                                        zzbcVar5 = zzbcVar5;
                                        i55 = i41;
                                        i56 = 3;
                                        c = 2;
                                        i49 = iZzi;
                                        i57 = i43;
                                        if (i16 == 2) {
                                            if (i16 == 1) {
                                                iZzf = i49 + 8;
                                                zzdrVar3 = (zzdr) zzczVar;
                                                zzdrVar3.zzf(zzbd.zzn(bArr2, i49));
                                                while (iZzf < i2) {
                                                    iZzh6 = zzbd.zzh(bArr2, iZzf, zzbcVar5);
                                                    if (i54 == zzbcVar5.zza) {
                                                        i15 = i55;
                                                        i47 = i57;
                                                        i46 = i54;
                                                        i48 = i56;
                                                        iZzh2 = iZzf;
                                                        this = this;
                                                        if (iZzh2 != i49) {
                                                            i92 = i2;
                                                            i3 = i3;
                                                            iZzl = iZzh2;
                                                            i93 = i48;
                                                            i99 = i46;
                                                            i97 = i47;
                                                            i96 = i15;
                                                            i94 = 0;
                                                            i100 = i12;
                                                            i95 = -1;
                                                            unsafe9 = unsafe;
                                                            bArr4 = bArr2;
                                                            zzefVar2 = this;
                                                            zzbcVar7 = zzbcVar5;
                                                            obj2 = obj;
                                                        } else {
                                                            i4 = i3;
                                                            zzefVar = this;
                                                            zzbcVar2 = zzbcVar5;
                                                            i10 = i48;
                                                            i101 = i46;
                                                            i97 = i47;
                                                            obj2 = obj;
                                                            i2 = i2;
                                                            i14 = iZzh2;
                                                        }
                                                    } else {
                                                        zzdrVar3.zzf(zzbd.zzn(bArr2, iZzh6));
                                                        iZzf = iZzh6 + 8;
                                                    }
                                                    break;
                                                }
                                                i15 = i55;
                                                i47 = i57;
                                                i46 = i54;
                                                i48 = i56;
                                                iZzh2 = iZzf;
                                                this = this;
                                                if (iZzh2 != i49) {
                                                    i92 = i2;
                                                    i3 = i3;
                                                    iZzl = iZzh2;
                                                    i93 = i48;
                                                    i99 = i46;
                                                    i97 = i47;
                                                    i96 = i15;
                                                    i94 = 0;
                                                    i100 = i12;
                                                    i95 = -1;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = this;
                                                    zzbcVar7 = zzbcVar5;
                                                    obj2 = obj;
                                                } else {
                                                    i4 = i3;
                                                    zzefVar = this;
                                                    zzbcVar2 = zzbcVar5;
                                                    i10 = i48;
                                                    i101 = i46;
                                                    i97 = i47;
                                                    obj2 = obj;
                                                    i2 = i2;
                                                    i14 = iZzh2;
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            this = this;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                            break;
                                        } else {
                                            zzdrVar4 = (zzdr) zzczVar;
                                            iZzh7 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                            i58 = zzbcVar5.zza + iZzh7;
                                            while (iZzh7 < i58) {
                                                zzdrVar4.zzf(zzbd.zzn(bArr2, iZzh7));
                                                iZzh7 += 8;
                                            }
                                            if (iZzh7 != i58) {
                                                throw zzdc.zzg();
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            iZzh2 = iZzh7;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                    case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                    case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                        bArr2 = bArr;
                                        unsafe = unsafe5;
                                        i54 = i46 == true ? 1 : 0;
                                        zzbcVar5 = zzbcVar5;
                                        i55 = i41;
                                        i56 = 3;
                                        c = 2;
                                        i49 = iZzi;
                                        i57 = i43;
                                        if (i16 == 2) {
                                            if (i16 == 5) {
                                                iZzh7 = i49 + 4;
                                                zzctVar = (zzct) zzczVar;
                                                zzctVar.zzg(zzbd.zzb(bArr2, i49));
                                                while (iZzh7 < i2) {
                                                    iZzh8 = zzbd.zzh(bArr2, iZzh7, zzbcVar5);
                                                    if (i54 == zzbcVar5.zza) {
                                                        zzctVar.zzg(zzbd.zzb(bArr2, iZzh8));
                                                        iZzh7 = iZzh8 + 4;
                                                    }
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            this = this;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            zzctVar2 = (zzct) zzczVar;
                                            iZzh7 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                            i59 = zzbcVar5.zza + iZzh7;
                                            while (iZzh7 < i59) {
                                                zzctVar2.zzg(zzbd.zzb(bArr2, iZzh7));
                                                iZzh7 += 4;
                                            }
                                            if (iZzh7 != i59) {
                                                throw zzdc.zzg();
                                            }
                                        }
                                        i15 = i55;
                                        i47 = i57;
                                        i46 = i54;
                                        i48 = i56;
                                        iZzh2 = iZzh7;
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        bArr2 = bArr;
                                        unsafe = unsafe5;
                                        i54 = i46 == true ? 1 : 0;
                                        zzbcVar5 = zzbcVar5;
                                        i55 = i41;
                                        i56 = 3;
                                        c = 2;
                                        i49 = iZzi;
                                        i57 = i43;
                                        if (i16 == 2) {
                                            if (i16 == 0) {
                                                zzbeVar = (zzbe) zzczVar;
                                                iZzh7 = zzbd.zzk(bArr2, i49, zzbcVar5);
                                                if (zzbcVar5.zzb != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                zzbeVar.zze(z2);
                                                while (iZzh7 < i2) {
                                                    iZzh9 = zzbd.zzh(bArr2, iZzh7, zzbcVar5);
                                                    if (i54 == zzbcVar5.zza) {
                                                        iZzh7 = zzbd.zzk(bArr2, iZzh9, zzbcVar5);
                                                        if (zzbcVar5.zzb != 0) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        zzbeVar.zze(z3);
                                                    }
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            this = this;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            zzbeVar2 = (zzbe) zzczVar;
                                            iZzh7 = zzbd.zzh(bArr2, i49, zzbcVar5);
                                            i60 = zzbcVar5.zza + iZzh7;
                                            while (iZzh7 < i60) {
                                                iZzh7 = zzbd.zzk(bArr2, iZzh7, zzbcVar5);
                                                if (zzbcVar5.zzb != 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                zzbeVar2.zze(z4);
                                            }
                                            if (iZzh7 != i60) {
                                                throw zzdc.zzg();
                                            }
                                        }
                                        i15 = i55;
                                        i47 = i57;
                                        i46 = i54;
                                        i48 = i56;
                                        iZzh2 = iZzh7;
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 26:
                                        bArr2 = bArr;
                                        unsafe = unsafe5;
                                        i54 = i46 == true ? 1 : 0;
                                        zzczVar2 = zzczVar;
                                        zzbcVar5 = zzbcVar5;
                                        i55 = i41;
                                        i56 = 3;
                                        c = 2;
                                        i49 = iZzi;
                                        i57 = i43;
                                        if (i16 == 2) {
                                            if ((536870912 & j2) == 0) {
                                                iZzf = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i65 = zzbcVar5.zza;
                                                if (i65 >= 0) {
                                                    throw zzdc.zzd();
                                                }
                                                if (i65 == 0) {
                                                    zzczVar3 = zzczVar2;
                                                    zzczVar3.add("");
                                                } else {
                                                    zzczVar3 = zzczVar2;
                                                    zzczVar3.add(new String(bArr2, iZzf, i65, zzda.zzb));
                                                    iZzf += i65;
                                                }
                                                while (iZzf < i2) {
                                                    iZzh11 = zzbd.zzh(bArr2, iZzf, zzbcVar5);
                                                    if (i54 == zzbcVar5.zza) {
                                                        iZzf = zzbd.zzh(bArr2, iZzh11, zzbcVar5);
                                                        i66 = zzbcVar5.zza;
                                                        if (i66 >= 0) {
                                                            throw zzdc.zzd();
                                                        }
                                                        if (i66 == 0) {
                                                            zzczVar3.add("");
                                                        } else {
                                                            zzczVar3.add(new String(bArr2, iZzf, i66, zzda.zzb));
                                                            iZzf += i66;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzf = zzbd.zzh(bArr2, i49, zzbcVar5);
                                                i61 = zzbcVar5.zza;
                                                if (i61 >= 0) {
                                                    throw zzdc.zzd();
                                                }
                                                if (i61 == 0) {
                                                    zzczVar2.add("");
                                                } else {
                                                    i62 = iZzf + i61;
                                                    if (zzfu.zze(bArr2, iZzf, i62)) {
                                                        throw zzdc.zzc();
                                                    }
                                                    zzczVar2.add(new String(bArr2, iZzf, i61, zzda.zzb));
                                                    iZzf = i62;
                                                }
                                                while (iZzf < i2) {
                                                    iZzh10 = zzbd.zzh(bArr2, iZzf, zzbcVar5);
                                                    if (i54 == zzbcVar5.zza) {
                                                        iZzf = zzbd.zzh(bArr2, iZzh10, zzbcVar5);
                                                        i63 = zzbcVar5.zza;
                                                        if (i63 >= 0) {
                                                            throw zzdc.zzd();
                                                        }
                                                        if (i63 == 0) {
                                                            zzczVar2.add("");
                                                        } else {
                                                            i64 = iZzf + i63;
                                                            if (zzfu.zze(bArr2, iZzf, i64)) {
                                                                throw zzdc.zzc();
                                                            }
                                                            zzczVar2.add(new String(bArr2, iZzf, i63, zzda.zzb));
                                                            iZzf = i64;
                                                        }
                                                    }
                                                }
                                            }
                                            i15 = i55;
                                            i47 = i57;
                                            i46 = i54;
                                            i48 = i56;
                                            iZzh2 = iZzf;
                                            this = this;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        }
                                        i15 = i55;
                                        i47 = i57;
                                        i46 = i54;
                                        i48 = i56;
                                        this = this;
                                        iZzh2 = i49;
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                                        i67 = iZzi;
                                        unsafe = unsafe5;
                                        i47 = i43;
                                        i68 = i41;
                                        if (i16 == 2) {
                                            bArr2 = bArr;
                                            zzbcVar5 = zzbcVar5;
                                            c = 2;
                                            int iZze2 = zzbd.zze(zzv(i47), i46 == true ? 1 : 0, bArr, i67, i2, zzczVar, zzbcVar);
                                            i47 = i47;
                                            i46 = i46 == true ? 1 : 0;
                                            i48 = 3;
                                            i49 = i67;
                                            i15 = i68;
                                            iZzh2 = iZze2;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            bArr2 = bArr;
                                            i49 = i67;
                                            i48 = 3;
                                            i15 = i68;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        }
                                        break;
                                    case 28:
                                        i67 = iZzi;
                                        unsafe = unsafe5;
                                        i47 = i43;
                                        i68 = i41;
                                        if (i16 == 2) {
                                            iZzh12 = zzbd.zzh(bArr, i67, zzbcVar5);
                                            i69 = zzbcVar5.zza;
                                            if (i69 >= 0) {
                                                throw zzdc.zzd();
                                            }
                                            if (i69 <= bArr.length - iZzh12) {
                                                throw zzdc.zzg();
                                            }
                                            if (i69 == 0) {
                                                zzczVar.add(zzbq.zzb);
                                            } else {
                                                zzczVar.add(zzbq.zzl(bArr, iZzh12, i69));
                                                iZzh12 += i69;
                                            }
                                            while (iZzh12 < i2) {
                                                iZzh13 = zzbd.zzh(bArr, iZzh12, zzbcVar5);
                                                if (i46 == zzbcVar5.zza) {
                                                    iZzh12 = zzbd.zzh(bArr, iZzh13, zzbcVar5);
                                                    i70 = zzbcVar5.zza;
                                                    if (i70 >= 0) {
                                                        throw zzdc.zzd();
                                                    }
                                                    if (i70 <= bArr.length - iZzh12) {
                                                        throw zzdc.zzg();
                                                    }
                                                    if (i70 == 0) {
                                                        zzczVar.add(zzbq.zzb);
                                                    } else {
                                                        zzczVar.add(zzbq.zzl(bArr, iZzh12, i70));
                                                        iZzh12 += i70;
                                                    }
                                                } else {
                                                    this = this;
                                                    bArr2 = bArr;
                                                    zzbcVar5 = zzbcVar5;
                                                    i49 = i67;
                                                    i48 = 3;
                                                    i15 = i68;
                                                    iZzh2 = iZzh12;
                                                }
                                            }
                                            this = this;
                                            bArr2 = bArr;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i67;
                                            i48 = 3;
                                            i15 = i68;
                                            iZzh2 = iZzh12;
                                        } else {
                                            bArr2 = bArr;
                                            i49 = i67;
                                            i48 = 3;
                                            i15 = i68;
                                            iZzh2 = i49;
                                        }
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 30:
                                    case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                        bArr3 = bArr;
                                        i71 = iZzi;
                                        unsafe = unsafe5;
                                        i47 = i43;
                                        if (i16 == 2) {
                                            iZzj = zzbd.zzf(bArr3, i71, zzczVar, zzbcVar5);
                                        } else if (i16 == 0) {
                                            this = this;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i15 = i41;
                                            i48 = 3;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            iZzj = zzbd.zzj(i46 == true ? 1 : 0, bArr, i71, i2, zzczVar, zzbcVar);
                                        }
                                        zzcwVarZzu = zzefVar2.zzu(i47);
                                        zzffVar = zzefVar2.zzm;
                                        int i1117 = zzeq.zza;
                                        if (zzcwVarZzu != null) {
                                            i72 = iZzj;
                                            i73 = i41;
                                        } else if (zzczVar instanceof RandomAccess) {
                                            size = zzczVar.size();
                                            i74 = 0;
                                            i75 = 0;
                                            objZzo2 = null;
                                            while (i74 < size) {
                                                int i1118 = iZzj;
                                                num = (Integer) zzczVar.get(i74);
                                                iIntValue2 = num.intValue();
                                                if (zzcwVarZzu.zza(iIntValue2)) {
                                                    if (i74 != i75) {
                                                        zzczVar.set(i75, num);
                                                    }
                                                    i75++;
                                                    i77 = 1;
                                                    i76 = i41;
                                                } else {
                                                    i76 = i41;
                                                    objZzo2 = zzeq.zzo(obj2, i76, iIntValue2, objZzo2, zzffVar);
                                                    i77 = 1;
                                                }
                                                i74 += i77;
                                                i41 = i76;
                                                iZzj = i1118;
                                            }
                                            i72 = iZzj;
                                            i73 = i41;
                                            if (i75 != size) {
                                                zzczVar.subList(i75, size).clear();
                                            }
                                        } else {
                                            i72 = iZzj;
                                            i73 = i41;
                                            it = zzczVar.iterator();
                                            objZzo = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!zzcwVarZzu.zza(iIntValue)) {
                                                    objZzo = zzeq.zzo(obj2, i73, iIntValue, objZzo, zzffVar);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        this = this;
                                        bArr2 = bArr3;
                                        zzbcVar5 = zzbcVar5;
                                        i49 = i71;
                                        i48 = 3;
                                        i15 = i73;
                                        iZzh2 = i72;
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        bArr3 = bArr;
                                        i71 = iZzi;
                                        unsafe = unsafe5;
                                        i47 = i43;
                                        if (i16 == 2) {
                                            if (i16 == 0) {
                                                zzctVar3 = (zzct) zzczVar;
                                                iZzh2 = zzbd.zzh(bArr3, i71, zzbcVar5);
                                                zzctVar3.zzg(zzbu.zzb(zzbcVar5.zza));
                                                while (iZzh2 < i2) {
                                                    iZzh14 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        iZzh2 = zzbd.zzh(bArr3, iZzh14, zzbcVar5);
                                                        zzctVar3.zzg(zzbu.zzb(zzbcVar5.zza));
                                                    }
                                                }
                                            }
                                            this = zzefVar2;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i15 = i41;
                                            i48 = 3;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            zzctVar4 = (zzct) zzczVar;
                                            iZzh2 = zzbd.zzh(bArr3, i71, zzbcVar5);
                                            i78 = zzbcVar5.zza + iZzh2;
                                            while (iZzh2 < i78) {
                                                iZzh2 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                zzctVar4.zzg(zzbu.zzb(zzbcVar5.zza));
                                            }
                                            if (iZzh2 != i78) {
                                                throw zzdc.zzg();
                                            }
                                        }
                                        this = zzefVar2;
                                        bArr2 = bArr3;
                                        zzbcVar5 = zzbcVar5;
                                        i49 = i71;
                                        i15 = i41;
                                        i48 = 3;
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    case 34:
                                    case 48:
                                        bArr3 = bArr;
                                        i71 = iZzi;
                                        unsafe = unsafe5;
                                        i47 = i43;
                                        if (i16 == 2) {
                                            if (i16 == 0) {
                                                zzdrVar5 = (zzdr) zzczVar;
                                                iZzh2 = zzbd.zzk(bArr3, i71, zzbcVar5);
                                                zzdrVar5.zzf(zzbu.zzc(zzbcVar5.zzb));
                                                while (iZzh2 < i2) {
                                                    iZzh15 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        iZzh2 = zzbd.zzk(bArr3, iZzh15, zzbcVar5);
                                                        zzdrVar5.zzf(zzbu.zzc(zzbcVar5.zzb));
                                                    }
                                                }
                                            }
                                            this = zzefVar2;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i15 = i41;
                                            i48 = 3;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            zzdrVar6 = (zzdr) zzczVar;
                                            iZzh2 = zzbd.zzh(bArr3, i71, zzbcVar5);
                                            i79 = zzbcVar5.zza + iZzh2;
                                            while (iZzh2 < i79) {
                                                iZzh2 = zzbd.zzk(bArr3, iZzh2, zzbcVar5);
                                                zzdrVar6.zzf(zzbu.zzc(zzbcVar5.zzb));
                                            }
                                            if (iZzh2 != i79) {
                                                throw zzdc.zzg();
                                            }
                                        }
                                        this = zzefVar2;
                                        bArr2 = bArr3;
                                        zzbcVar5 = zzbcVar5;
                                        i49 = i71;
                                        i15 = i41;
                                        i48 = 3;
                                        if (iZzh2 != i49) {
                                            i92 = i2;
                                            i3 = i3;
                                            iZzl = iZzh2;
                                            i93 = i48;
                                            i99 = i46;
                                            i97 = i47;
                                            i96 = i15;
                                            i94 = 0;
                                            i100 = i12;
                                            i95 = -1;
                                            unsafe9 = unsafe;
                                            bArr4 = bArr2;
                                            zzefVar2 = this;
                                            zzbcVar7 = zzbcVar5;
                                            obj2 = obj;
                                        } else {
                                            i4 = i3;
                                            zzefVar = this;
                                            zzbcVar2 = zzbcVar5;
                                            i10 = i48;
                                            i101 = i46;
                                            i97 = i47;
                                            obj2 = obj;
                                            i2 = i2;
                                            i14 = iZzh2;
                                        }
                                        break;
                                    default:
                                        if (i16 == 3) {
                                            i80 = ((i46 == true ? 1 : 0) & (-8)) | 4;
                                            i81 = i43;
                                            zzeoVarZzv = zzefVar2.zzv(i81);
                                            i71 = iZzi;
                                            unsafe = unsafe5;
                                            iZzh2 = zzbd.zzc(zzeoVarZzv, bArr, i71, i2, i80, zzbcVar);
                                            zzczVar.add(zzbcVar5.zzc);
                                            i82 = i2;
                                            while (true) {
                                                if (iZzh2 < i82) {
                                                    i83 = i81;
                                                    bArr3 = bArr;
                                                    iZzh16 = zzbd.zzh(bArr3, iZzh2, zzbcVar5);
                                                    if (i46 == zzbcVar5.zza) {
                                                        iZzh2 = zzbd.zzc(zzeoVarZzv, bArr, iZzh16, i2, i80, zzbcVar);
                                                        zzczVar.add(zzbcVar5.zzc);
                                                        i82 = i82;
                                                        i81 = i83;
                                                        zzeoVarZzv = zzeoVarZzv;
                                                    } else {
                                                        i47 = i83;
                                                    }
                                                } else {
                                                    i47 = i81;
                                                    bArr3 = bArr;
                                                }
                                            }
                                            this = zzefVar2;
                                            bArr2 = bArr3;
                                            zzbcVar5 = zzbcVar5;
                                            i49 = i71;
                                            i15 = i41;
                                            i48 = 3;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        } else {
                                            unsafe = unsafe5;
                                            this = zzefVar2;
                                            zzbcVar5 = zzbcVar5;
                                            i47 = i43;
                                            i15 = i41;
                                            i48 = 3;
                                            bArr2 = bArr;
                                            i49 = iZzi;
                                            iZzh2 = i49;
                                            if (iZzh2 != i49) {
                                                i92 = i2;
                                                i3 = i3;
                                                iZzl = iZzh2;
                                                i93 = i48;
                                                i99 = i46;
                                                i97 = i47;
                                                i96 = i15;
                                                i94 = 0;
                                                i100 = i12;
                                                i95 = -1;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = this;
                                                zzbcVar7 = zzbcVar5;
                                                obj2 = obj;
                                            } else {
                                                i4 = i3;
                                                zzefVar = this;
                                                zzbcVar2 = zzbcVar5;
                                                i10 = i48;
                                                i101 = i46;
                                                i97 = i47;
                                                obj2 = obj;
                                                i2 = i2;
                                                i14 = iZzh2;
                                            }
                                        }
                                        break;
                                }
                            } else {
                                unsafe = unsafe5;
                                i45 = i43;
                                i15 = i41;
                                zzefVar = zzefVar2;
                                i44 = iZzi;
                                bArr2 = bArr;
                                if (iZzr == 50) {
                                    obj2 = obj;
                                    unsafe8 = zzb;
                                    j3 = iArr[i45 + 2] & 1048575;
                                    switch (iZzr) {
                                        case 51:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 1) {
                                                iZzk = i85 + 8;
                                                unsafe8.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzbd.zzn(bArr2, i85))));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 52:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 5) {
                                                iZzk = i85 + 4;
                                                unsafe8.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzbd.zzb(bArr2, i85))));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 0) {
                                                iZzk = zzbd.zzk(bArr2, i85, zzbcVar2);
                                                unsafe8.putObject(obj2, j, Long.valueOf(zzbcVar2.zzb));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 0) {
                                                iZzk = zzbd.zzh(bArr2, i85, zzbcVar2);
                                                unsafe8.putObject(obj2, j, Integer.valueOf(zzbcVar2.zza));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 56:
                                        case 65:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 1) {
                                                iZzk = i85 + 8;
                                                unsafe8.putObject(obj2, j, Long.valueOf(zzbd.zzn(bArr2, i85)));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 5) {
                                                iZzk = i85 + 4;
                                                unsafe8.putObject(obj2, j, Integer.valueOf(zzbd.zzb(bArr2, i85)));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 58:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 0) {
                                                iZzk = zzbd.zzk(bArr2, i85, zzbcVar2);
                                                if (zzbcVar2.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                unsafe8.putObject(obj2, j, Boolean.valueOf(z5));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzk;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 59:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            if (i16 == 2) {
                                                iZzh17 = zzbd.zzh(bArr2, i85, zzbcVar2);
                                                i87 = zzbcVar2.zza;
                                                if (i87 == 0) {
                                                    unsafe8.putObject(obj2, j, "");
                                                } else {
                                                    i88 = iZzh17 + i87;
                                                    if ((i17 & 536870912) == 0) {
                                                    }
                                                    unsafe8.putObject(obj2, j, new String(bArr2, iZzh17, i87, zzda.zzb));
                                                    iZzh17 = i88;
                                                }
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzh17;
                                            } else {
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 60:
                                            if (i16 == 2) {
                                                Object objZzy3 = zzefVar.zzy(obj2, i15, i45);
                                                zzeo zzeoVarZzv3 = zzefVar.zzv(i45);
                                                i10 = 3;
                                                i84 = i46 == true ? 1 : 0;
                                                i85 = i44;
                                                zzefVar = zzefVar;
                                                int iZzm4 = zzbd.zzm(objZzy3, zzeoVarZzv3, bArr, i44, i2, zzbcVar);
                                                zzefVar.zzG(obj2, i15, i45, objZzy3);
                                                zzbcVar2 = zzbcVar;
                                                iZzl = iZzm4;
                                                i2 = i2;
                                                i86 = i45;
                                            } else {
                                                zzefVar = zzefVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i10 = 3;
                                                i85 = i44;
                                                i2 = i2;
                                                zzbcVar2 = zzbcVar;
                                                i86 = i45;
                                                iZzl = i85;
                                            }
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 61:
                                            i89 = i44;
                                            i90 = i45;
                                            zzbcVar6 = zzbcVar;
                                            if (i16 == 2) {
                                                int iZza3 = zzbd.zza(bArr2, i89, zzbcVar6);
                                                unsafe8.putObject(obj2, j, zzbcVar6.zzc);
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZza3;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                            }
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i86 = i90;
                                            i10 = 3;
                                            i85 = i89;
                                            zzbcVar2 = zzbcVar6;
                                            iZzl = i85;
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 63:
                                            i89 = i44;
                                            i90 = i45;
                                            zzbcVar6 = zzbcVar;
                                            if (i16 == 0) {
                                                iZzh18 = zzbd.zzh(bArr2, i89, zzbcVar6);
                                                i91 = zzbcVar6.zza;
                                                zzcwVarZzu2 = zzefVar.zzu(i90);
                                                if (zzcwVarZzu2 != null) {
                                                    unsafe8.putObject(obj2, j, Integer.valueOf(i91));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                } else {
                                                    unsafe8.putObject(obj2, j, Integer.valueOf(i91));
                                                    unsafe8.putInt(obj2, j3, i15);
                                                }
                                                iZzl = iZzh18;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                            }
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i86 = i90;
                                            i10 = 3;
                                            i85 = i89;
                                            zzbcVar2 = zzbcVar6;
                                            iZzl = i85;
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                            i89 = i44;
                                            i90 = i45;
                                            zzbcVar6 = zzbcVar;
                                            if (i16 == 0) {
                                                iZzh18 = zzbd.zzh(bArr2, i89, zzbcVar6);
                                                unsafe8.putObject(obj2, j, Integer.valueOf(zzbu.zzb(zzbcVar6.zza)));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzh18;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                            }
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i86 = i90;
                                            i10 = 3;
                                            i85 = i89;
                                            zzbcVar2 = zzbcVar6;
                                            iZzl = i85;
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                        case 67:
                                            i89 = i44;
                                            i90 = i45;
                                            if (i16 == 0) {
                                                zzbcVar6 = zzbcVar;
                                                iZzh18 = zzbd.zzk(bArr2, i89, zzbcVar6);
                                                unsafe8.putObject(obj2, j, Long.valueOf(zzbu.zzc(zzbcVar6.zzb)));
                                                unsafe8.putInt(obj2, j3, i15);
                                                iZzl = iZzh18;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar6;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                            } else {
                                                i2 = i2;
                                                zzefVar = zzefVar;
                                                i84 = i46 == true ? 1 : 0;
                                                i86 = i90;
                                                i10 = 3;
                                                i85 = i89;
                                                zzbcVar2 = zzbcVar;
                                                iZzl = i85;
                                                if (iZzl != i85) {
                                                    i3 = i3;
                                                    zzbcVar7 = zzbcVar2;
                                                    i92 = i2;
                                                    i96 = i15;
                                                    i97 = i86;
                                                    i95 = -1;
                                                    i93 = i10;
                                                    i99 = i84;
                                                    unsafe9 = unsafe;
                                                    bArr4 = bArr2;
                                                    zzefVar2 = zzefVar;
                                                    i94 = 0;
                                                    i100 = i12;
                                                } else {
                                                    i4 = i3;
                                                    i14 = iZzl;
                                                    i97 = i86;
                                                    i101 = i84;
                                                }
                                            }
                                            break;
                                        case 68:
                                            if (i16 == 3) {
                                                break;
                                            } else {
                                                int i1119 = ((i46 == true ? 1 : 0) & (-8)) | 4;
                                                Object objZzy4 = zzefVar.zzy(obj2, i15, i45);
                                                iZzl = zzbd.zzl(objZzy4, zzefVar.zzv(i45), bArr, i44, i2, i1119, zzbcVar);
                                                zzefVar.zzG(obj2, i15, i45, objZzy4);
                                                i2 = i2;
                                                i86 = i45;
                                                zzefVar = zzefVar;
                                                i85 = i44;
                                                i84 = i46 == true ? 1 : 0;
                                                i10 = 3;
                                                zzbcVar2 = zzbcVar;
                                            }
                                            if (iZzl != i85) {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                                break;
                                            } else {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                                break;
                                            }
                                        default:
                                            zzbcVar2 = zzbcVar;
                                            i84 = i46 == true ? 1 : 0;
                                            i85 = i44;
                                            i86 = i45;
                                            i10 = 3;
                                            i2 = i2;
                                            zzefVar = zzefVar;
                                            iZzl = i85;
                                            if (iZzl != i85) {
                                                i3 = i3;
                                                zzbcVar7 = zzbcVar2;
                                                i92 = i2;
                                                i96 = i15;
                                                i97 = i86;
                                                i95 = -1;
                                                i93 = i10;
                                                i99 = i84;
                                                unsafe9 = unsafe;
                                                bArr4 = bArr2;
                                                zzefVar2 = zzefVar;
                                                i94 = 0;
                                                i100 = i12;
                                            } else {
                                                i4 = i3;
                                                i14 = iZzl;
                                                i97 = i86;
                                                i101 = i84;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i16 == 2) {
                                        unsafe7 = zzb;
                                        Object objZzw2 = zzefVar.zzw(i45);
                                        object = unsafe7.getObject(obj, j);
                                        if (!((zzdw) object).zze()) {
                                            zzdw zzdwVarZzb2 = zzdw.zza().zzb();
                                            zzdx.zza(zzdwVarZzb2, object);
                                            unsafe7.putObject(obj, j, zzdwVarZzb2);
                                        }
                                        throw null;
                                    }
                                    zzbcVar4 = zzbcVar5;
                                    obj2 = obj;
                                    i4 = i3;
                                    zzbcVar2 = zzbcVar4;
                                    i101 = i46;
                                    i97 = i45;
                                    i10 = 3;
                                    i2 = i2;
                                    int i11110 = i44;
                                    zzefVar = zzefVar;
                                    i14 = i11110;
                                }
                            }
                        } else if (i16 == 2) {
                            zzczVarZzd = (zzcz) unsafe5.getObject(obj2, j);
                            if (!zzczVarZzd.zzc()) {
                                int size5 = zzczVarZzd.size();
                                zzczVarZzd = zzczVarZzd.zzd(size5 != 0 ? size5 + size5 : 10);
                                unsafe5.putObject(obj2, j, zzczVarZzd);
                            }
                            iZzl = zzbd.zze(zzefVar2.zzv(i43), b == true ? 1 : 0, bArr, iZzi, i2, zzczVarZzd, zzbcVar);
                            i99 = b == true ? 1 : 0;
                            unsafe9 = unsafe5;
                            zzbcVar7 = zzbcVar3;
                            i93 = 3;
                            i97 = i43;
                            i94 = 0;
                            i100 = i42;
                            i95 = -1;
                            i96 = i41;
                            bArr4 = bArr;
                            i92 = i2;
                            i3 = i3;
                        } else {
                            i12 = i42;
                            i13 = 0;
                            i44 = iZzi;
                            unsafe = unsafe5;
                            zzbcVar4 = zzbcVar3;
                            i15 = i41;
                            zzefVar = zzefVar2;
                            bArr2 = bArr;
                            i45 = i43;
                            i46 = b == true ? 1 : 0;
                            i4 = i3;
                            zzbcVar2 = zzbcVar4;
                            i101 = i46;
                            i97 = i45;
                            i10 = 3;
                            i2 = i2;
                            int i11111 = i44;
                            zzefVar = zzefVar;
                            i14 = i11111;
                        }
                    }
                } else {
                    i10 = i93;
                    i4 = i3;
                    i11 = i95;
                    i97 = i94;
                    unsafe = unsafe9;
                    i12 = i100;
                    zzbcVar2 = zzbcVar7;
                    i2 = i92;
                    i13 = i97;
                    zzefVar = zzefVar2;
                    i14 = iZzi;
                    bArr2 = bArr4;
                    i15 = i102;
                }
                if (i101 == i4) {
                }
                if (zzefVar.zzh) {
                    iZzg = zzbd.zzg(i101 == true ? 1 : 0, bArr, i14, i2, zzd(obj), zzbcVar);
                } else {
                    iZzg = zzbd.zzg(i101 == true ? 1 : 0, bArr, i14, i2, zzd(obj), zzbcVar);
                }
                zzbcVar7 = zzbcVar;
                i99 = i101;
                i3 = i4;
                i92 = i2;
                i96 = i15;
                i95 = i11;
                i93 = i10;
                unsafe9 = unsafe;
                bArr4 = bArr2;
                iZzl = iZzg;
                zzefVar2 = zzefVar;
                i94 = i13;
                i100 = i12;
            } else {
                zzefVar = zzefVar2;
                i4 = i3;
                unsafe = unsafe9;
                i5 = 1048575;
                i2 = i92;
                i6 = i98;
                i7 = i99;
                i8 = i100;
            }
        }
        if (i8 != i5) {
            unsafe.putInt(obj2, i8, i6);
        }
        for (int i120 = zzefVar.zzj; i120 < zzefVar.zzk; i120++) {
            int[] iArr2 = zzefVar.zzi;
            int[] iArr3 = zzefVar.zzc;
            int i121 = iArr2[i120];
            int i122 = iArr3[i121];
            Object objZzf = zzfp.zzf(obj2, zzefVar.zzs(i121) & i5);
            if (objZzf != null && zzefVar.zzu(i121) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzl != i2) {
                throw zzdc.zze();
            }
        } else if (iZzl > i2 || i7 != i4) {
            throw zzdc.zze();
        }
        return iZzl;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        return ((zzcs) this.zzg).zzl();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzcs) {
                zzcs zzcsVar = (zzcs) obj;
                zzcsVar.zzu(Integer.MAX_VALUE);
                zzcsVar.zza = 0;
                zzcsVar.zzs();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
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
                                this.zzl.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzdw) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzd(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzfp.zzo(obj, j, zzfp.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzfp.zzp(obj, j, zzfp.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzfp.zzm(obj, j, zzfp.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzeq.zza;
                    zzfp.zzs(obj, j, zzdx.zza(zzfp.zzf(obj, j), zzfp.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzeq.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzeq.zzp(this.zzn, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzbc zzbcVar) throws zzdc {
        zzc(obj, bArr, i, i2, 0, zzbcVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzi(Object obj, zzfx zzfxVar) {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        if (this.zzh) {
            zzci zzciVarZzb = this.zzn.zzb(obj);
            if (zzciVarZzb.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzciVarZzb.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i5 = 1048575;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        while (i8 < iArr.length) {
            int iZzs = zzs(i8);
            int[] iArr2 = this.zzc;
            int iZzr = zzr(iZzs);
            int i9 = iArr2[i8];
            if (iZzr <= 17) {
                int i10 = iArr2[i8 + 2];
                int i11 = i10 & i5;
                if (i11 != i6) {
                    i7 = i11 == i5 ? 0 : unsafe.getInt(obj, i11);
                    i6 = i11;
                } else {
                    iZzr = iZzr;
                }
                i = i6;
                i2 = i7;
                i3 = 1 << (i10 >>> 20);
            } else {
                iZzr = iZzr;
                i = i6;
                i2 = i7;
                i3 = 0;
            }
            while (entry != null && this.zzn.zza(entry) <= i9) {
                this.zzn.zze(zzfxVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzs & 1048575;
            switch (iZzr) {
                case 0:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzf(i9, zzfp.zza(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 1:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzo(i9, zzfp.zzb(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 2:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzt(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 3:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzK(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 4:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzr(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 5:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzm(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 6:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzk(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 7:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzb(i9, zzfp.zzw(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 8:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzO(i9, unsafe.getObject(obj, j), zzfxVar);
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 9:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzv(i9, unsafe.getObject(obj, j), zzv(i4));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 10:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzd(i9, (zzbq) unsafe.getObject(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 11:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzI(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 12:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzi(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 13:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzx(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 14:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzz(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 15:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzB(i9, unsafe.getInt(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 16:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i4, i, i2, i3)) {
                        zzfxVar.zzD(i9, unsafe.getLong(obj, j));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 17:
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    if (zzJ(obj, i8, i, i2, i3)) {
                        zzfxVar.zzq(i9, unsafe.getObject(obj, j), zzv(i4));
                    }
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 18:
                    z = false;
                    zzeq.zzt(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 19:
                    z = false;
                    zzeq.zzx(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 20:
                    z = false;
                    zzeq.zzz(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 21:
                    z = false;
                    zzeq.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 22:
                    z = false;
                    zzeq.zzy(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    z = false;
                    zzeq.zzw(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 24:
                    z = false;
                    zzeq.zzv(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 25:
                    z = false;
                    zzeq.zzs(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 26:
                    int i12 = this.zzc[i8];
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzeq.zza;
                    if (list != null && !list.isEmpty()) {
                        zzfxVar.zzH(i12, list);
                    }
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    int i14 = this.zzc[i8];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzeo zzeoVarZzv = zzv(i8);
                    int i15 = zzeq.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i16 = 0; i16 < list2.size(); i16++) {
                            ((zzbz) zzfxVar).zzv(i14, list2.get(i16), zzeoVarZzv);
                        }
                    }
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 28:
                    int i17 = this.zzc[i8];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i18 = zzeq.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzfxVar.zze(i17, list3);
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 29:
                    z2 = false;
                    zzeq.zzE(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 30:
                    z2 = false;
                    zzeq.zzu(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    z2 = false;
                    zzeq.zzA(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 32:
                    z2 = false;
                    zzeq.zzB(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 33:
                    z2 = false;
                    zzeq.zzC(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 34:
                    z2 = false;
                    zzeq.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, false);
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    z3 = true;
                    zzeq.zzt(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    z3 = true;
                    zzeq.zzx(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    z3 = true;
                    zzeq.zzz(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 38:
                    z3 = true;
                    zzeq.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    z3 = true;
                    zzeq.zzy(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    z3 = true;
                    zzeq.zzw(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    z3 = true;
                    zzeq.zzv(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 42:
                    z3 = true;
                    zzeq.zzs(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 43:
                    z3 = true;
                    zzeq.zzE(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    z3 = true;
                    zzeq.zzu(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    z3 = true;
                    zzeq.zzA(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 46:
                    z3 = true;
                    zzeq.zzB(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 47:
                    z3 = true;
                    zzeq.zzC(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 48:
                    z3 = true;
                    zzeq.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzfxVar, true);
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 49:
                    int i19 = this.zzc[i8];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzeo zzeoVarZzv2 = zzv(i8);
                    int i20 = zzeq.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i21 = 0; i21 < list4.size(); i21++) {
                            ((zzbz) zzfxVar).zzq(i19, list4.get(i21), zzeoVarZzv2);
                        }
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 51:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzf(i9, zzm(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 52:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzo(i9, zzn(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 53:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzt(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 54:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzK(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 55:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzr(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 56:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzm(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 57:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzk(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 58:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzb(i9, zzN(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 59:
                    if (zzM(obj, i9, i8)) {
                        zzO(i9, unsafe.getObject(obj, j), zzfxVar);
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 60:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzv(i9, unsafe.getObject(obj, j), zzv(i8));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 61:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzd(i9, (zzbq) unsafe.getObject(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 62:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzI(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 63:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzi(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 64:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzx(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 65:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzz(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzB(i9, zzo(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 67:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzD(i9, zzt(obj, j));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                case 68:
                    if (zzM(obj, i9, i8)) {
                        zzfxVar.zzq(i9, unsafe.getObject(obj, j), zzv(i8));
                    }
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
                default:
                    i4 = i8;
                    i8 = i4 + 3;
                    i6 = i;
                    i7 = i2;
                    i5 = 1048575;
                    it = it;
                    iArr = iArr;
                    entry = entry;
                    break;
            }
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzn.zze(zzfxVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        zzff zzffVar = this.zzm;
        zzffVar.zzj(zzffVar.zzd(obj), zzfxVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzG;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzfp.zza(obj, j)) != Double.doubleToLongBits(zzfp.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzfp.zzb(obj, j)) != Float.floatToIntBits(zzfp.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzfp.zzw(obj, j) != zzfp.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
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
                    zZzG = zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j));
                    break;
                case 50:
                    zZzG = zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzfp.zzc(obj, jZzp) != zzfp.zzc(obj2, jZzp) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzG) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzn.zzb(obj).equals(this.zzn.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzeo zzeoVarZzv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzs = zzs(i7);
            int i9 = this.zzc[i7 + 2];
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
            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzfp.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzeoVarZzv = zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzeoVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzfp.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzeoVarZzv = zzv(i7);
                    while (i3 < list.size()) {
                        if (!zzeoVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzdw) zzfp.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || this.zzn.zzb(obj).zzj();
    }
}
