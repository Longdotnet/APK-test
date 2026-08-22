package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgah extends zzfyt {
    static final zzfyt zza = new zzgah(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzgah(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static zzgah zzj(int i, Object[] objArr, zzfys zzfysVar) {
        short[] sArr;
        char c;
        char c2;
        ?? r6;
        ?? r3;
        ?? r4;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzgah) zza;
        }
        zzfyr zzfyrVar = null;
        ?? r5 = 0;
        zzfyr zzfyrVar2 = null;
        zzfyr zzfyrVar3 = null;
        int i3 = 1;
        if (i2 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzfxn.zzb(obj, obj2);
            return new zzgah(null, objArrCopyOf, 1);
        }
        zzfvp.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iZzh = zzfyv.zzh(i);
        if (i2 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            zzfxn.zzb(obj3, obj4);
            i2 = 1;
            c = 1;
            c2 = 2;
        } else {
            int i4 = iZzh - 1;
            byte b = -1;
            if (iZzh <= 128) {
                byte[] bArr = new byte[iZzh];
                Arrays.fill(bArr, (byte) -1);
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int i7 = i6 + i6;
                    int i8 = i5 + i5;
                    Object obj5 = objArrCopyOf[i8];
                    Objects.requireNonNull(obj5);
                    Object obj6 = objArrCopyOf[i8 ^ i3];
                    Objects.requireNonNull(obj6);
                    zzfxn.zzb(obj5, obj6);
                    int iZza = zzfyi.zza(obj5.hashCode());
                    while (true) {
                        int i9 = iZza & i4;
                        int i10 = bArr[i9] & 255;
                        if (i10 == 255) {
                            bArr[i9] = (byte) i7;
                            if (i6 < i5) {
                                objArrCopyOf[i7] = obj5;
                                objArrCopyOf[i7 ^ 1] = obj6;
                            }
                            i6++;
                            break;
                        }
                        if (obj5.equals(objArrCopyOf[i10 == true ? 1 : 0])) {
                            int i11 = ~i10;
                            Object obj7 = objArrCopyOf[i11 == true ? 1 : 0];
                            Objects.requireNonNull(obj7);
                            zzfyr zzfyrVar4 = new zzfyr(obj5, obj6, obj7);
                            objArrCopyOf[i11 == true ? 1 : 0] = obj6;
                            zzfyrVar2 = zzfyrVar4;
                            break;
                        }
                        iZza = i9 + 1;
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 == i2) {
                    r3 = bArr;
                } else {
                    r4 = new Object[]{bArr, Integer.valueOf(i6), zzfyrVar2};
                    c2 = 2;
                }
                c = 1;
                r5 = r4;
            } else {
                if (iZzh <= 32768) {
                    sArr = new short[iZzh];
                    Arrays.fill(sArr, (short) -1);
                    int i12 = 0;
                    for (int i13 = 0; i13 < i2; i13++) {
                        int i14 = i12 + i12;
                        int i15 = i13 + i13;
                        Object obj8 = objArrCopyOf[i15];
                        Objects.requireNonNull(obj8);
                        Object obj9 = objArrCopyOf[i15 ^ 1];
                        Objects.requireNonNull(obj9);
                        zzfxn.zzb(obj8, obj9);
                        int iZza2 = zzfyi.zza(obj8.hashCode());
                        while (true) {
                            int i16 = iZza2 & i4;
                            char c3 = (char) sArr[i16];
                            if (c3 == 65535) {
                                sArr[i16] = (short) i14;
                                if (i12 < i13) {
                                    objArrCopyOf[i14] = obj8;
                                    objArrCopyOf[i14 ^ 1] = obj9;
                                }
                                i12++;
                                break;
                            }
                            if (obj8.equals(objArrCopyOf[c3])) {
                                int i17 = c3 ^ 1;
                                Object obj10 = objArrCopyOf[i17 == true ? 1 : 0];
                                Objects.requireNonNull(obj10);
                                zzfyr zzfyrVar5 = new zzfyr(obj8, obj9, obj10);
                                objArrCopyOf[i17 == true ? 1 : 0] = obj9;
                                zzfyrVar3 = zzfyrVar5;
                                break;
                            }
                            iZza2 = i16 + 1;
                        }
                    }
                    if (i12 != i2) {
                        Integer numValueOf = Integer.valueOf(i12);
                        c = 1;
                        c2 = 2;
                        r6 = new Object[]{sArr, numValueOf, zzfyrVar3};
                        r5 = r6;
                    }
                    r3 = sArr;
                } else {
                    int i18 = 1;
                    sArr = new int[iZzh];
                    Arrays.fill((int[]) sArr, -1);
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < i2) {
                        int i21 = i20 + i20;
                        int i22 = i19 + i19;
                        Object obj11 = objArrCopyOf[i22];
                        Objects.requireNonNull(obj11);
                        Object obj12 = objArrCopyOf[i22 ^ i18];
                        Objects.requireNonNull(obj12);
                        zzfxn.zzb(obj11, obj12);
                        int iZza3 = zzfyi.zza(obj11.hashCode());
                        while (true) {
                            int i23 = iZza3 & i4;
                            ?? r15 = sArr[i23];
                            if (r15 == b) {
                                sArr[i23] = i21;
                                if (i20 < i19) {
                                    objArrCopyOf[i21] = obj11;
                                    objArrCopyOf[i21 ^ 1] = obj12;
                                }
                                i20++;
                                break;
                            }
                            if (obj11.equals(objArrCopyOf[r15])) {
                                int i24 = r15 ^ 1;
                                Object obj13 = objArrCopyOf[i24 == true ? 1 : 0];
                                Objects.requireNonNull(obj13);
                                zzfyr zzfyrVar6 = new zzfyr(obj11, obj12, obj13);
                                objArrCopyOf[i24 == true ? 1 : 0] = obj12;
                                zzfyrVar = zzfyrVar6;
                                break;
                            }
                            iZza3 = i23 + 1;
                            b = -1;
                        }
                        i19++;
                        i18 = 1;
                        b = -1;
                    }
                    if (i20 != i2) {
                        c = 1;
                        c2 = 2;
                        r6 = new Object[]{sArr, Integer.valueOf(i20), zzfyrVar};
                        r5 = r6;
                    }
                    r3 = sArr;
                }
                c = 1;
                r5 = r4;
            }
            c2 = 2;
            r4 = r3;
            c = 1;
            r5 = r4;
        }
        boolean z = r5 instanceof Object[];
        ?? r7 = r5;
        if (z) {
            Object[] objArr2 = (Object[]) r5;
            zzfyr zzfyrVar7 = (zzfyr) objArr2[c2];
            if (zzfysVar == null) {
                throw zzfyrVar7.zza();
            }
            zzfysVar.zzc = zzfyrVar7;
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r7 = obj14;
            i2 = iIntValue;
        }
        return new zzgah(r7, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.ads.zzfyt, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iZza = zzfyi.zza(obj.hashCode());
                    while (true) {
                        int i2 = iZza & length;
                        int i3 = bArr[i2] & 255;
                        if (i3 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i3])) {
                            obj2 = objArr[i3 ^ 1];
                        } else {
                            iZza = i2 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iZza2 = zzfyi.zza(obj.hashCode());
                    while (true) {
                        int i4 = iZza2 & length2;
                        char c = (char) sArr[i4];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            obj2 = objArr[c ^ 1];
                        } else {
                            iZza2 = i4 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iZza3 = zzfyi.zza(obj.hashCode());
                    while (true) {
                        int i5 = iZza3 & length3;
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i6])) {
                            obj2 = objArr[i6 ^ 1];
                        } else {
                            iZza3 = i5 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfyt
    public final zzfyl zza() {
        return new zzgag(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzfyt
    public final zzfyv zzf() {
        return new zzgae(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzfyt
    public final zzfyv zzg() {
        return new zzgaf(this, new zzgag(this.zzb, 0, this.zzd));
    }
}
