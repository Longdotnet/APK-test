package com.google.android.gms.internal.ads;

import com.google.firebase.FirebaseError;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
final class zzaht {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzaia zzc = new zzaia();
    private zzahu zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzadw zzadwVar, int i) {
        byte[] bArr = this.zza;
        zzadwVar.zzi(bArr, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return j;
    }

    public final void zza(zzahu zzahuVar) {
        this.zzd = zzahuVar;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a9 A[LOOP:0: B:3:0x0005->B:37:0x00a9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x00da  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:57:0x011e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0121  */
    /* JADX WARN: Code duplicated, block: B:60:0x0124  */
    /* JADX WARN: Code duplicated, block: B:62:0x012b  */
    /* JADX WARN: Code duplicated, block: B:64:0x0131 A[LOOP:2: B:61:0x0129->B:64:0x0131, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x013e  */
    /* JADX WARN: Code duplicated, block: B:72:0x0157  */
    /* JADX WARN: Code duplicated, block: B:74:0x0162  */
    /* JADX WARN: Code duplicated, block: B:78:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x013e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x0162, please report this as an issue */
    public final boolean zzc(zzadw zzadwVar) throws zzaz {
        int i;
        zzahy zzahyVar;
        long j;
        long j2;
        int i2;
        byte[] bArr;
        String str;
        int i3;
        long j3;
        int i4;
        long jZzd;
        double dLongBitsToDouble;
        int iZzb;
        int iZzc;
        zzdd.zzb(this.zzd);
        while (true) {
            ArrayDeque arrayDeque = this.zzb;
            zzahr zzahrVar = (zzahr) arrayDeque.peek();
            if (zzahrVar != null && zzadwVar.zzf() >= zzahrVar.zzb) {
                ((zzahv) this.zzd).zza.zzj(((zzahr) arrayDeque.pop()).zza);
                return true;
            }
            int i5 = this.zze;
            if (i5 != 0) {
                if (i5 == 1) {
                }
                zzahu zzahuVar = this.zzd;
                i = this.zzf;
                zzahyVar = ((zzahv) zzahuVar).zza;
                switch (i) {
                    case 131:
                    case 136:
                    case 155:
                    case 159:
                    case 176:
                    case 179:
                    case 186:
                    case 215:
                    case 231:
                    case 238:
                    case 241:
                    case 251:
                    case 16871:
                    case 16980:
                    case 17029:
                    case 17143:
                    case 18401:
                    case 18408:
                    case 20529:
                    case 20530:
                    case 21420:
                    case 21432:
                    case 21680:
                    case 21682:
                    case 21690:
                    case 21930:
                    case 21938:
                    case 21945:
                    case 21946:
                    case 21947:
                    case 21948:
                    case 21949:
                    case 21998:
                    case 22186:
                    case 22203:
                    case 25188:
                    case 30114:
                    case 30321:
                    case 2352003:
                    case 2807729:
                        j = this.zzg;
                        if (j <= 8) {
                            zzahyVar.zzl(i, zzd(zzadwVar, (int) j));
                            this.zze = 0;
                            return true;
                        }
                        throw zzaz.zza("Invalid integer size: " + j, null);
                    case 134:
                    case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                    case 21358:
                    case 2274716:
                        j2 = this.zzg;
                        if (j2 <= 2147483647L) {
                            throw zzaz.zza("String element size: " + j2, null);
                        }
                        i2 = (int) j2;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            bArr = new byte[i2];
                            zzadwVar.zzi(bArr, 0, i2);
                            while (i2 > 0) {
                                i3 = i2 - 1;
                                if (bArr[i3] == 0) {
                                    i2 = i3;
                                } else {
                                    str = new String(bArr, 0, i2);
                                }
                            }
                            str = new String(bArr, 0, i2);
                        }
                        zzahyVar.zzn(i, str);
                        this.zze = 0;
                        return true;
                    case 160:
                    case 166:
                    case 174:
                    case 183:
                    case 187:
                    case 224:
                    case 225:
                    case 16868:
                    case 18407:
                    case 19899:
                    case 20532:
                    case 20533:
                    case 21936:
                    case 21968:
                    case 25152:
                    case 28032:
                    case 30113:
                    case 30320:
                    case 290298740:
                    case 357149030:
                    case 374648427:
                    case 408125543:
                    case 440786851:
                    case 475249515:
                    case 524531317:
                        long jZzf = zzadwVar.zzf();
                        arrayDeque.push(new zzahr(i, this.zzg + jZzf, null));
                        ((zzahv) this.zzd).zza.zzm(this.zzf, jZzf, this.zzg);
                        this.zze = 0;
                        return true;
                    case 161:
                    case 163:
                    case 165:
                    case 16877:
                    case 16981:
                    case 18402:
                    case 21419:
                    case 25506:
                    case 30322:
                        zzahyVar.zzh(i, (int) this.zzg, zzadwVar);
                        this.zze = 0;
                        return true;
                    case 181:
                    case 17545:
                    case 21969:
                    case 21970:
                    case 21971:
                    case 21972:
                    case 21973:
                    case 21974:
                    case 21975:
                    case 21976:
                    case 21977:
                    case 21978:
                    case 30323:
                    case 30324:
                    case 30325:
                        j3 = this.zzg;
                        if (j3 == 4 && j3 != 8) {
                            throw zzaz.zza("Invalid float size: " + j3, null);
                        }
                        i4 = (int) j3;
                        jZzd = zzd(zzadwVar, i4);
                        if (i4 == 4) {
                            dLongBitsToDouble = Float.intBitsToFloat((int) jZzd);
                        } else {
                            dLongBitsToDouble = Double.longBitsToDouble(jZzd);
                        }
                        zzahyVar.zzk(i, dLongBitsToDouble);
                        this.zze = 0;
                        return true;
                    default:
                        zzadwVar.zzk((int) this.zzg);
                        this.zze = 0;
                        break;
                }
            } else {
                long jZzd2 = this.zzc.zzd(zzadwVar, true, false, 4);
                if (jZzd2 == -2) {
                    zzadwVar.zzj();
                    while (true) {
                        byte[] bArr2 = this.zza;
                        zzadwVar.zzh(bArr2, 0, 4);
                        iZzb = zzaia.zzb(bArr2[0]);
                        if (iZzb != -1 && iZzb <= 4) {
                            iZzc = (int) zzaia.zzc(bArr2, iZzb, false);
                            zzahy zzahyVar2 = ((zzahv) this.zzd).zza;
                            if (iZzc != 357149030 && iZzc != 524531317 && iZzc != 475249515) {
                                if (iZzc == 374648427) {
                                    iZzc = 374648427;
                                }
                            }
                        }
                        zzadwVar.zzk(1);
                    }
                    zzadwVar.zzk(iZzb);
                    jZzd2 = iZzc;
                }
                if (jZzd2 == -1) {
                    return false;
                }
                this.zzf = (int) jZzd2;
                this.zze = 1;
            }
            this.zzg = this.zzc.zzd(zzadwVar, false, true, 8);
            this.zze = 2;
            zzahu zzahuVar2 = this.zzd;
            i = this.zzf;
            zzahyVar = ((zzahv) zzahuVar2).zza;
            switch (i) {
                case 131:
                case 136:
                case 155:
                case 159:
                case 176:
                case 179:
                case 186:
                case 215:
                case 231:
                case 238:
                case 241:
                case 251:
                case 16871:
                case 16980:
                case 17029:
                case 17143:
                case 18401:
                case 18408:
                case 20529:
                case 20530:
                case 21420:
                case 21432:
                case 21680:
                case 21682:
                case 21690:
                case 21930:
                case 21938:
                case 21945:
                case 21946:
                case 21947:
                case 21948:
                case 21949:
                case 21998:
                case 22186:
                case 22203:
                case 25188:
                case 30114:
                case 30321:
                case 2352003:
                case 2807729:
                    j = this.zzg;
                    if (j <= 8) {
                        zzahyVar.zzl(i, zzd(zzadwVar, (int) j));
                        this.zze = 0;
                        return true;
                    }
                    throw zzaz.zza("Invalid integer size: " + j, null);
                case 134:
                case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                case 21358:
                case 2274716:
                    j2 = this.zzg;
                    if (j2 <= 2147483647L) {
                        throw zzaz.zza("String element size: " + j2, null);
                    }
                    i2 = (int) j2;
                    if (i2 == 0) {
                        str = "";
                    } else {
                        bArr = new byte[i2];
                        zzadwVar.zzi(bArr, 0, i2);
                        while (i2 > 0) {
                            i3 = i2 - 1;
                            if (bArr[i3] == 0) {
                                i2 = i3;
                            } else {
                                str = new String(bArr, 0, i2);
                            }
                        }
                        str = new String(bArr, 0, i2);
                    }
                    zzahyVar.zzn(i, str);
                    this.zze = 0;
                    return true;
                case 160:
                case 166:
                case 174:
                case 183:
                case 187:
                case 224:
                case 225:
                case 16868:
                case 18407:
                case 19899:
                case 20532:
                case 20533:
                case 21936:
                case 21968:
                case 25152:
                case 28032:
                case 30113:
                case 30320:
                case 290298740:
                case 357149030:
                case 374648427:
                case 408125543:
                case 440786851:
                case 475249515:
                case 524531317:
                    long jZzf2 = zzadwVar.zzf();
                    arrayDeque.push(new zzahr(i, this.zzg + jZzf2, null));
                    ((zzahv) this.zzd).zza.zzm(this.zzf, jZzf2, this.zzg);
                    this.zze = 0;
                    return true;
                case 161:
                case 163:
                case 165:
                case 16877:
                case 16981:
                case 18402:
                case 21419:
                case 25506:
                case 30322:
                    zzahyVar.zzh(i, (int) this.zzg, zzadwVar);
                    this.zze = 0;
                    return true;
                case 181:
                case 17545:
                case 21969:
                case 21970:
                case 21971:
                case 21972:
                case 21973:
                case 21974:
                case 21975:
                case 21976:
                case 21977:
                case 21978:
                case 30323:
                case 30324:
                case 30325:
                    j3 = this.zzg;
                    if (j3 == 4) {
                        break;
                    }
                    i4 = (int) j3;
                    jZzd = zzd(zzadwVar, i4);
                    if (i4 == 4) {
                        dLongBitsToDouble = Float.intBitsToFloat((int) jZzd);
                    } else {
                        dLongBitsToDouble = Double.longBitsToDouble(jZzd);
                    }
                    zzahyVar.zzk(i, dLongBitsToDouble);
                    this.zze = 0;
                    return true;
                default:
                    zzadwVar.zzk((int) this.zzg);
                    this.zze = 0;
                    break;
            }
        }
    }
}
