package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzajj implements zzadv, zzaeu {
    private long zzA;
    private int zzB;
    private zzahm zzC;
    private final zzakr zza;
    private final int zzb;
    private final zzen zzc;
    private final zzen zzd;
    private final zzen zze;
    private final zzen zzf;
    private final ArrayDeque zzg;
    private final zzajn zzh;
    private final List zzi;
    private zzfyq zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzen zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private long zzv;
    private zzady zzw;
    private zzaji[] zzx;
    private long[][] zzy;
    private int zzz;

    @Deprecated
    public zzajj() {
        this(zzakr.zza, 16);
    }

    private static int zzj(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzk(zzajs zzajsVar, long j) {
        int iZza = zzajsVar.zza(j);
        return iZza == -1 ? zzajsVar.zzb(j) : iZza;
    }

    private static long zzl(zzajs zzajsVar, long j, long j2) {
        int iZzk = zzk(zzajsVar, j);
        return iZzk == -1 ? j2 : Math.min(zzajsVar.zzc[iZzk], j2);
    }

    private final void zzm() {
        this.zzk = 0;
        this.zzn = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzn(long j) {
        int i;
        zzav zzavVar;
        int i2;
        ArrayList arrayList;
        int i3;
        int i4;
        zzajj zzajjVar = this;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            ArrayDeque arrayDeque = zzajjVar.zzg;
            if (arrayDeque.isEmpty() || ((zzfc) arrayDeque.peek()).zza != j) {
                break;
            }
            zzfc zzfcVar = (zzfc) arrayDeque.pop();
            if (zzfcVar.zzd == 1836019574) {
                zzfc zzfcVarZza = zzfcVar.zza(1835365473);
                new ArrayList();
                zzav zzavVarZzb = zzfcVarZza != null ? zzaix.zzb(zzfcVarZza) : null;
                ArrayList arrayList2 = new ArrayList();
                boolean z = zzajjVar.zzB == i6 ? i6 : i5;
                zzaej zzaejVar = new zzaej();
                zzfd zzfdVarZzb = zzfcVar.zzb(1969517665);
                if (zzfdVarZzb != null) {
                    zzav zzavVarZzc = zzaix.zzc(zzfdVarZzb);
                    zzaejVar.zzb(zzavVarZzc);
                    zzavVar = zzavVarZzc;
                } else {
                    zzavVar = null;
                }
                zzfd zzfdVarZzb2 = zzfcVar.zzb(1836476516);
                zzfdVarZzb2.getClass();
                zzau[] zzauVarArr = new zzau[i6];
                zzauVarArr[i5] = zzaix.zzd(zzfdVarZzb2.zza);
                zzav zzavVar2 = new zzav(-9223372036854775807L, zzauVarArr);
                int i7 = zzajjVar.zzb;
                zzaej zzaejVar2 = zzaejVar;
                ArrayList arrayList3 = arrayList2;
                List listZzf = zzaix.zzf(zzfcVar, zzaejVar, -9223372036854775807L, null, i6 != (i7 & 1) ? i5 : i6, z, new zzfve() { // from class: com.google.android.gms.internal.ads.zzajh
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return (zzajp) obj;
                    }
                });
                String strZza = zzajg.zza(listZzf);
                long j2 = -9223372036854775807L;
                int i8 = i5;
                int i9 = i8;
                int size = -1;
                while (i8 < listZzf.size()) {
                    zzajs zzajsVar = (zzajs) listZzf.get(i8);
                    if (zzajsVar.zzb == 0) {
                        i3 = i6;
                        arrayList = arrayList3;
                    } else {
                        zzajp zzajpVar = zzajsVar.zza;
                        zzady zzadyVar = zzajjVar.zzw;
                        int i10 = i9 + 1;
                        int i11 = zzajpVar.zzb;
                        zzaji zzajiVar = new zzaji(zzajpVar, zzajsVar, zzadyVar.zzw(i9, i11));
                        long j3 = zzajpVar.zze;
                        if (j3 == -9223372036854775807L) {
                            j3 = zzajsVar.zzh;
                        }
                        zzafb zzafbVar = zzajiVar.zzc;
                        zzafbVar.zzl(j3);
                        long jMax = Math.max(j2, j3);
                        zzz zzzVar = zzajpVar.zzg;
                        int i12 = "audio/true-hd".equals(zzzVar.zzo) ? zzajsVar.zze * 16 : zzajsVar.zze + 30;
                        zzx zzxVarZzb = zzzVar.zzb();
                        zzxVarZzb.zzX(i12);
                        if (i11 == 2) {
                            int i13 = zzzVar.zzf;
                            if ((i7 & 8) != 0) {
                                i13 |= size == -1 ? 1 : 2;
                            }
                            zzxVarZzb.zzaf(i13);
                            i2 = 1;
                            i11 = 2;
                        } else {
                            i2 = 1;
                        }
                        if (i11 == i2 && zzaejVar2.zza()) {
                            zzaejVar2 = zzaejVar2;
                            zzxVarZzb.zzM(zzaejVar2.zza);
                            zzxVarZzb.zzN(zzaejVar2.zzb);
                        } else {
                            zzaejVar2 = zzaejVar2;
                        }
                        zzav zzavVar3 = zzzVar.zzl;
                        List list = zzajjVar.zzi;
                        zzav[] zzavVarArr = {list.isEmpty() ? null : new zzav(list), zzavVar, zzavVar2};
                        if (zzavVar3 == null) {
                            zzavVar3 = new zzav(-9223372036854775807L, new zzau[0]);
                        }
                        if (zzavVarZzb != null) {
                            int i14 = 0;
                            while (i14 < zzavVarZzb.zza()) {
                                zzau zzauVarZzb = zzavVarZzb.zzb(i14);
                                if (zzauVarZzb instanceof zzfa) {
                                    zzfa zzfaVar = (zzfa) zzauVarZzb;
                                    if (!zzfaVar.zza.equals("com.android.capture.fps")) {
                                        i4 = 1;
                                        zzavVar3 = zzavVar3.zzc(zzfaVar);
                                    } else if (i11 == 2) {
                                        i4 = 1;
                                        zzavVar3 = zzavVar3.zzc(zzfaVar);
                                    } else {
                                        i4 = 1;
                                    }
                                } else {
                                    i4 = 1;
                                }
                                i14 += i4;
                            }
                        }
                        for (int i15 = 0; i15 < 3; i15++) {
                            zzavVar3 = zzavVar3.zzd(zzavVarArr[i15]);
                        }
                        if (zzavVar3.zza() > 0) {
                            zzxVarZzb.zzaa(zzavVar3);
                        }
                        zzxVarZzb.zzG(strZza);
                        zzafbVar.zzm(zzxVarZzb.zzan());
                        if (i11 == 2 && size == -1) {
                            size = arrayList3.size();
                        }
                        arrayList = arrayList3;
                        arrayList.add(zzajiVar);
                        j2 = jMax;
                        i9 = i10;
                        i3 = 1;
                    }
                    i8 += i3;
                    arrayList3 = arrayList;
                    i6 = i3;
                    listZzf = listZzf;
                }
                int i16 = -1;
                zzajjVar.zzz = size;
                zzajjVar.zzA = j2;
                zzaji[] zzajiVarArr = (zzaji[]) arrayList3.toArray(new zzaji[0]);
                zzajjVar.zzx = zzajiVarArr;
                int length = zzajiVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i17 = 0; i17 < zzajiVarArr.length; i17++) {
                    jArr[i17] = new long[zzajiVarArr[i17].zzb.zzb];
                    jArr2[i17] = zzajiVarArr[i17].zzb.zzf[0];
                }
                int i18 = 0;
                long j4 = 0;
                int i19 = 0;
                while (i19 < zzajiVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i20 = i16;
                    for (int i21 = i18; i21 < zzajiVarArr.length; i21++) {
                        if (!zArr[i21]) {
                            long j6 = jArr2[i21];
                            if (j6 <= j5) {
                                i20 = i21;
                                j5 = j6;
                            }
                        }
                    }
                    int i22 = iArr[i20];
                    long[] jArr3 = jArr[i20];
                    jArr3[i22] = j4;
                    zzajs zzajsVar2 = zzajiVarArr[i20].zzb;
                    zzaji[] zzajiVarArr2 = zzajiVarArr;
                    j4 += (long) zzajsVar2.zzd[i22];
                    int i23 = i22 + 1;
                    iArr[i20] = i23;
                    if (i23 < jArr3.length) {
                        jArr2[i20] = zzajsVar2.zzf[i23];
                    } else {
                        zArr[i20] = true;
                        i19++;
                    }
                    zzajiVarArr = zzajiVarArr2;
                    i16 = -1;
                    i18 = 0;
                    zzajjVar = this;
                }
                i = 1;
                zzajjVar.zzy = jArr;
                zzajjVar.zzw.zzG();
                zzajjVar.zzw.zzP(zzajjVar);
                arrayDeque.clear();
                zzajjVar.zzk = 2;
            } else {
                i = i6;
                if (!arrayDeque.isEmpty()) {
                    ((zzfc) arrayDeque.peek()).zzc(zzfcVar);
                }
            }
            i6 = i;
            i5 = 0;
        }
        if (zzajjVar.zzk != 2) {
            zzm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzA;
    }

    /* JADX WARN: Code duplicated, block: B:271:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0179 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x0179 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x008e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0155  */
    /* JADX WARN: Code duplicated, block: B:79:0x0168  */
    /* JADX WARN: Code duplicated, block: B:81:0x0176  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int iZzb;
        int iZzg;
        int i4;
        boolean z;
        int i5;
        while (true) {
            int i6 = 1;
            while (true) {
                i = this.zzk;
                if (i != 0) {
                    break;
                }
                boolean z2 = i6;
                if (this.zzn == 0) {
                    zzen zzenVar = this.zzf;
                    if (!zzadwVar.zzn(zzenVar.zzN(), 0, 8, z2)) {
                        if (this.zzB != 2 || (this.zzb & 2) == 0) {
                            return -1;
                        }
                        zzafb zzafbVarZzw = this.zzw.zzw(0, 4);
                        zzahm zzahmVar = this.zzC;
                        zzav zzavVar = zzahmVar == null ? null : new zzav(-9223372036854775807L, zzahmVar);
                        zzx zzxVar = new zzx();
                        zzxVar.zzaa(zzavVar);
                        zzafbVarZzw.zzm(zzxVar.zzan());
                        this.zzw.zzG();
                        this.zzw.zzP(new zzaet(-9223372036854775807L, 0L));
                        return -1;
                    }
                    this.zzn = 8;
                    zzenVar.zzL(0);
                    this.zzm = zzenVar.zzu();
                    this.zzl = zzenVar.zzg();
                }
                long j = this.zzm;
                if (j == 1) {
                    zzen zzenVar2 = this.zzf;
                    zzadwVar.zzi(zzenVar2.zzN(), 8, 8);
                    this.zzn += 8;
                    this.zzm = zzenVar2.zzw();
                } else if (j == 0) {
                    long jZzd = zzadwVar.zzd();
                    if (jZzd == -1) {
                        zzfc zzfcVar = (zzfc) this.zzg.peek();
                        jZzd = zzfcVar != null ? zzfcVar.zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzm = (jZzd - zzadwVar.zzf()) + ((long) this.zzn);
                    }
                }
                long j2 = this.zzm;
                int i7 = this.zzn;
                if (j2 < i7) {
                    throw zzaz.zzc("Atom size less than header length (unsupported).");
                }
                int i8 = this.zzl;
                if (i8 == 1836019574 || i8 == 1953653099 || i8 == 1835297121 || i8 == 1835626086 || i8 == 1937007212 || i8 == 1701082227 || i8 == 1835365473 || i8 == 1635284069) {
                    i5 = 1;
                    long jZzf = zzadwVar.zzf();
                    long j3 = this.zzm;
                    long j4 = jZzf + j3;
                    long j5 = this.zzn;
                    if (j3 != j5 && this.zzl == 1835365473) {
                        zzen zzenVar3 = this.zze;
                        zzenVar3.zzI(8);
                        zzadwVar.zzh(zzenVar3.zzN(), 0, 8);
                        zzaix.zzg(zzenVar3);
                        zzadwVar.zzk(zzenVar3.zzc());
                        zzadwVar.zzj();
                    }
                    long j6 = j4 - j5;
                    this.zzg.push(new zzfc(this.zzl, j6));
                    if (this.zzm == this.zzn) {
                        zzn(j6);
                    } else {
                        zzm();
                    }
                } else if (i8 == 1835296868 || i8 == 1836476516 || i8 == 1751411826 || i8 == 1937011556 || i8 == 1937011827 || i8 == 1937011571 || i8 == 1668576371 || i8 == 1701606260 || i8 == 1937011555 || i8 == 1937011578 || i8 == 1937013298 || i8 == 1937007471 || i8 == 1668232756 || i8 == 1953196132 || i8 == 1718909296 || i8 == 1969517665 || i8 == 1801812339 || i8 == 1768715124) {
                    zzdd.zzf(i7 == 8);
                    zzdd.zzf(this.zzm <= 2147483647L);
                    zzen zzenVar4 = new zzen((int) this.zzm);
                    System.arraycopy(this.zzf.zzN(), 0, zzenVar4.zzN(), 0, 8);
                    this.zzo = zzenVar4;
                    i5 = 1;
                    this.zzk = 1;
                } else {
                    long jZzf2 = zzadwVar.zzf();
                    long j7 = this.zzn;
                    long j8 = jZzf2 - j7;
                    if (this.zzl == 1836086884) {
                        this.zzC = new zzahm(0L, j8, -9223372036854775807L, j8 + j7, this.zzm - j7);
                    }
                    this.zzo = null;
                    i5 = 1;
                    this.zzk = 1;
                }
                i6 = i5;
            }
            if (i != i6) {
                if (i != 2) {
                    this.zzh.zza(zzadwVar, zzaerVar, this.zzi);
                    if (zzaerVar.zza == 0) {
                        zzm();
                    }
                    return i6;
                }
                long jZzf3 = zzadwVar.zzf();
                int i9 = this.zzp;
                if (i9 == -1) {
                    int i10 = i6;
                    int i11 = i10;
                    int i12 = -1;
                    int i13 = -1;
                    long j9 = Long.MAX_VALUE;
                    long j10 = Long.MAX_VALUE;
                    long j11 = Long.MAX_VALUE;
                    int i14 = 0;
                    while (true) {
                        zzaji[] zzajiVarArr = this.zzx;
                        if (i14 >= zzajiVarArr.length) {
                            break;
                        }
                        zzaji zzajiVar = zzajiVarArr[i14];
                        int i15 = zzajiVar.zze;
                        zzajs zzajsVar = zzajiVar.zzb;
                        if (i15 != zzajsVar.zzb) {
                            long j12 = zzajsVar.zzc[i15];
                            long[][] jArr = this.zzy;
                            String str = zzex.zza;
                            long j13 = jArr[i14][i15];
                            long j14 = j12 - jZzf3;
                            int i16 = (j14 < 0 || j14 >= 262144) ? i6 : 0;
                            if (i16 == 0) {
                                if (i11 == 0) {
                                    i4 = 0;
                                } else {
                                    i11 = i16;
                                    i13 = i14;
                                    j11 = j14;
                                    j10 = j13;
                                }
                                if (j13 < j9) {
                                    i10 = i16;
                                    i12 = i14;
                                    j9 = j13;
                                }
                            } else {
                                i4 = i11;
                            }
                            if (i16 != i4 || j14 >= j11) {
                                i11 = i4;
                            } else {
                                i11 = i16;
                                i13 = i14;
                                j11 = j14;
                                j10 = j13;
                            }
                            if (j13 < j9) {
                                i10 = i16;
                                i12 = i14;
                                j9 = j13;
                            }
                        }
                        i14 += i6;
                    }
                    i9 = (j9 == Long.MAX_VALUE || i10 == 0 || j10 < j9 + 10485760) ? i13 : i12;
                    this.zzp = i9;
                    if (i9 == -1) {
                        return -1;
                    }
                }
                zzaji zzajiVar2 = this.zzx[i9];
                zzafb zzafbVar = zzajiVar2.zzc;
                int i17 = zzajiVar2.zze;
                zzajs zzajsVar2 = zzajiVar2.zzb;
                long j15 = zzajsVar2.zzc[i17] + this.zzv;
                int[] iArr2 = zzajsVar2.zzd;
                int i18 = iArr2[i17];
                zzafc zzafcVar = zzajiVar2.zzd;
                long j16 = (j15 - jZzf3) + ((long) this.zzq);
                if (j16 < 0 || j16 >= 262144) {
                    zzaerVar.zza = j15;
                    return 1;
                }
                zzajp zzajpVar = zzajiVar2.zza;
                if (zzajpVar.zzh == 1) {
                    j16 += 8;
                    i18 -= 8;
                }
                int i19 = i18;
                zzadwVar.zzk((int) j16);
                zzz zzzVar = zzajpVar.zzg;
                String str2 = zzzVar.zzo;
                if (!Objects.equals(str2, "video/avc")) {
                    Objects.equals(str2, "video/hevc");
                }
                this.zzt = true;
                int i20 = zzajpVar.zzk;
                if (i20 == 0) {
                    if ("audio/ac4".equals(str2)) {
                        if (this.zzr == 0) {
                            zzen zzenVar5 = this.zze;
                            zzacy.zzc(i19, zzenVar5);
                            i2 = 7;
                            zzafbVar.zzr(zzenVar5, 7);
                            this.zzr += 7;
                        } else {
                            i2 = 7;
                        }
                        i19 += i2;
                    } else if (zzafcVar != null) {
                        zzafcVar.zzd(zzadwVar);
                    }
                    while (true) {
                        int i21 = this.zzr;
                        if (i21 >= i19) {
                            break;
                        }
                        int iZzf = zzafbVar.zzf(zzadwVar, i19 - i21, false);
                        this.zzq += iZzf;
                        this.zzr += iZzf;
                        this.zzs -= iZzf;
                    }
                } else {
                    zzen zzenVar6 = this.zzd;
                    byte[] bArrZzN = zzenVar6.zzN();
                    bArrZzN[0] = 0;
                    bArrZzN[1] = 0;
                    bArrZzN[2] = 0;
                    int i22 = 4 - i20;
                    i19 += i22;
                    while (this.zzr < i19) {
                        int i23 = this.zzs;
                        if (i23 == 0) {
                            if (this.zzt) {
                                iArr = iArr2;
                            } else {
                                iArr = iArr2;
                                if (zzfv.zzb(zzzVar) + i20 <= iArr2[i17] - this.zzq) {
                                    iZzb = zzfv.zzb(zzzVar);
                                    i3 = i20 + iZzb;
                                }
                                zzadwVar.zzi(bArrZzN, i22, i3);
                                this.zzq += i3;
                                zzenVar6.zzL(0);
                                iZzg = zzenVar6.zzg();
                                if (iZzg >= 0) {
                                    throw zzaz.zza("Invalid NAL length", null);
                                }
                                this.zzs = iZzg - iZzb;
                                zzen zzenVar7 = this.zzc;
                                zzenVar7.zzL(0);
                                zzafbVar.zzr(zzenVar7, 4);
                                this.zzr += 4;
                                if (iZzb > 0) {
                                    zzafbVar.zzr(zzenVar6, iZzb);
                                    this.zzr += iZzb;
                                    if (zzfv.zzj(bArrZzN, 4, iZzb, zzzVar)) {
                                        this.zzt = true;
                                    }
                                }
                            }
                            i3 = i20;
                            iZzb = 0;
                            zzadwVar.zzi(bArrZzN, i22, i3);
                            this.zzq += i3;
                            zzenVar6.zzL(0);
                            iZzg = zzenVar6.zzg();
                            if (iZzg >= 0) {
                                throw zzaz.zza("Invalid NAL length", null);
                            }
                            this.zzs = iZzg - iZzb;
                            zzen zzenVar8 = this.zzc;
                            zzenVar8.zzL(0);
                            zzafbVar.zzr(zzenVar8, 4);
                            this.zzr += 4;
                            if (iZzb > 0) {
                                zzafbVar.zzr(zzenVar6, iZzb);
                                this.zzr += iZzb;
                                if (zzfv.zzj(bArrZzN, 4, iZzb, zzzVar)) {
                                    this.zzt = true;
                                }
                            }
                        } else {
                            iArr = iArr2;
                            int iZzf2 = zzafbVar.zzf(zzadwVar, i23, false);
                            this.zzq += iZzf2;
                            this.zzr += iZzf2;
                            this.zzs -= iZzf2;
                        }
                        iArr2 = iArr;
                    }
                }
                long j17 = zzajsVar2.zzf[i17];
                int i24 = zzajsVar2.zzg[i17];
                if (!this.zzt) {
                    i24 |= 67108864;
                }
                if (zzafcVar != null) {
                    zzafcVar.zzc(zzafbVar, j17, i24, i19, 0, null);
                    if (i17 + 1 == zzajsVar2.zzb) {
                        zzafcVar.zza(zzafbVar, null);
                    }
                } else {
                    zzafbVar.zzt(j17, i24, i19, 0, null);
                }
                zzajiVar2.zze++;
                this.zzp = -1;
                this.zzq = 0;
                this.zzr = 0;
                this.zzs = 0;
                this.zzt = false;
                return 0;
            }
            long j18 = this.zzm - ((long) this.zzn);
            long jZzf4 = zzadwVar.zzf() + j18;
            zzen zzenVar9 = this.zzo;
            if (zzenVar9 != null) {
                zzadwVar.zzi(zzenVar9.zzN(), this.zzn, (int) j18);
                if (this.zzl == 1718909296) {
                    this.zzu = true;
                    zzenVar9.zzL(8);
                    int iZzj = zzj(zzenVar9.zzg());
                    if (iZzj == 0) {
                        zzenVar9.zzM(4);
                        do {
                            if (zzenVar9.zza() <= 0) {
                                iZzj = 0;
                                break;
                            }
                            iZzj = zzj(zzenVar9.zzg());
                        } while (iZzj == 0);
                    }
                    this.zzB = iZzj;
                } else {
                    ArrayDeque arrayDeque = this.zzg;
                    if (!arrayDeque.isEmpty()) {
                        ((zzfc) arrayDeque.peek()).zzd(new zzfd(this.zzl, zzenVar9));
                    }
                }
            } else {
                if (!this.zzu && this.zzl == 1835295092) {
                    this.zzB = 1;
                }
                if (j18 < 262144) {
                    zzadwVar.zzk((int) j18);
                } else {
                    zzaerVar.zza = zzadwVar.zzf() + j18;
                    z = true;
                }
                zzn(jZzf4);
                if (!z && this.zzk != 2) {
                    return 1;
                }
            }
            z = false;
            zzn(jZzf4);
            if (!z) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        if ((this.zzb & 16) == 0) {
            zzadyVar = new zzaku(zzadyVar, this.zza);
        }
        this.zzw = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = false;
        if (j == 0) {
            if (this.zzk != 3) {
                zzm();
                return;
            } else {
                this.zzh.zzb();
                this.zzi.clear();
                return;
            }
        }
        for (zzaji zzajiVar : this.zzx) {
            zzajs zzajsVar = zzajiVar.zzb;
            int iZza = zzajsVar.zza(j2);
            if (iZza == -1) {
                iZza = zzajsVar.zzb(j2);
            }
            zzajiVar.zze = iZza;
            zzafc zzafcVar = zzajiVar.zzd;
            if (zzafcVar != null) {
                zzafcVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long j2;
        long j3;
        long jZzl;
        long j4;
        int iZzb;
        long j5 = j;
        zzaji[] zzajiVarArr = this.zzx;
        if (zzajiVarArr.length == 0) {
            zzaev zzaevVar = zzaev.zza;
            return new zzaes(zzaevVar, zzaevVar);
        }
        int i = this.zzz;
        if (i != -1) {
            zzajs zzajsVar = zzajiVarArr[i].zzb;
            int iZzk = zzk(zzajsVar, j5);
            if (iZzk == -1) {
                zzaev zzaevVar2 = zzaev.zza;
                return new zzaes(zzaevVar2, zzaevVar2);
            }
            long[] jArr = zzajsVar.zzf;
            long j6 = jArr[iZzk];
            long[] jArr2 = zzajsVar.zzc;
            j2 = jArr2[iZzk];
            if (j6 >= j5 || iZzk >= zzajsVar.zzb - 1 || (iZzb = zzajsVar.zzb(j5)) == -1 || iZzb == iZzk) {
                j4 = -9223372036854775807L;
                jZzl = -1;
            } else {
                j4 = jArr[iZzb];
                jZzl = jArr2[iZzb];
            }
            j3 = j4;
            j5 = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
            jZzl = -1;
        }
        int i2 = 0;
        while (true) {
            zzaji[] zzajiVarArr2 = this.zzx;
            if (i2 >= zzajiVarArr2.length) {
                break;
            }
            if (i2 != this.zzz) {
                zzajs zzajsVar2 = zzajiVarArr2[i2].zzb;
                long jZzl2 = zzl(zzajsVar2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jZzl = zzl(zzajsVar2, j3, jZzl);
                }
                j2 = jZzl2;
            }
            i2++;
        }
        zzaev zzaevVar3 = new zzaev(j5, j2);
        return j3 == -9223372036854775807L ? new zzaes(zzaevVar3, zzaevVar3) : new zzaes(zzaevVar3, new zzaev(j3, jZzl));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        zzaey zzaeyVarZzb = zzajo.zzb(zzadwVar, (this.zzb & 2) != 0);
        this.zzj = zzaeyVarZzb != null ? zzfyq.zzo(zzaeyVarZzb) : zzfyq.zzn();
        return zzaeyVarZzb == null;
    }

    public zzajj(zzakr zzakrVar, int i) {
        this.zza = zzakrVar;
        this.zzb = i;
        this.zzj = zzfyq.zzn();
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzh = new zzajn();
        this.zzi = new ArrayList();
        this.zzf = new zzen(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzen(zzfv.zza);
        this.zzd = new zzen(6);
        this.zze = new zzen();
        this.zzp = -1;
        this.zzw = zzady.zza;
        this.zzx = new zzaji[0];
    }
}
