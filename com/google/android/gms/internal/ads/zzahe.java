package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class zzahe {
    public static final zzahc zza = new Object() { // from class: com.google.android.gms.internal.ads.zzahc
    };

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int iZzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZzd;
        }
        while (true) {
            int length = bArr.length;
            if (iZzd >= length - 1) {
                return length;
            }
            int i3 = iZzd + 1;
            if ((iZzd - i) % 2 == 0 && bArr[i3] == 0) {
                return iZzd;
            }
            iZzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzen zzenVar, int i) {
        byte[] bArrZzN = zzenVar.zzN();
        int iZzc = zzenVar.zzc();
        int i2 = iZzc;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iZzc + i) {
                return i;
            }
            if ((bArrZzN[i2] & 255) == 255 && bArrZzN[i3] == 0) {
                System.arraycopy(bArrZzN, i2 + 2, bArrZzN, i3, (i - (i2 - iZzc)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static zzfyq zzf(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzfyq.zzo("");
        }
        int i3 = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        int iZzc = zzc(bArr, i2, i);
        while (i2 < iZzc) {
            zzfynVar.zzf(new String(bArr, i2, iZzc - i2, zzi(i)));
            i2 = zzb(i) + iZzc;
            iZzc = zzc(bArr, i2, i);
        }
        zzfyq zzfyqVarZzi = zzfynVar.zzi();
        return zzfyqVarZzi.isEmpty() ? zzfyq.zzo("") : zzfyqVarZzi;
    }

    private static String zzg(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzh(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static Charset zzi(int i) {
        if (i == 1) {
            return StandardCharsets.UTF_16;
        }
        if (i != 2) {
            return i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8;
        }
        return StandardCharsets.UTF_16BE;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX WARN: Code duplicated, block: B:30:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x007d A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:41:0x008f A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004b, B:25:0x006d, B:29:0x0073, B:41:0x008f, B:42:0x0091, B:45:0x0097, B:48:0x00a1, B:31:0x007d, B:35:0x0084, B:10:0x0025), top: B:54:0x0008 }] */
    private static boolean zzj(zzen zzenVar, int i, int i2, boolean z) {
        boolean z2;
        int iZzo;
        long jZzo;
        int iZzq;
        int i3;
        int iZzc = zzenVar.zzc();
        while (true) {
            try {
                z2 = true;
                z2 = true;
                int i4 = 1;
                int i5 = 1;
                if (zzenVar.zza() >= i2) {
                    if (i >= 3) {
                        iZzo = zzenVar.zzg();
                        jZzo = zzenVar.zzu();
                        iZzq = zzenVar.zzq();
                    } else {
                        iZzo = zzenVar.zzo();
                        jZzo = zzenVar.zzo();
                        iZzq = 0;
                    }
                    if (iZzo != 0 || jZzo != 0 || iZzq != 0) {
                        if (i != 4 || z) {
                            if (i == 4) {
                                if ((iZzq & 64) != 0) {
                                    i4 = 0;
                                }
                                int i6 = i4;
                                i5 = iZzq & 1;
                                i3 = i6;
                            } else if (i == 3) {
                                if ((iZzq & 32) != 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if ((iZzq & 128) != 0) {
                                    i5 = 0;
                                }
                            } else {
                                i3 = 0;
                                i5 = 0;
                            }
                            if (i5 != 0) {
                                i3 += 4;
                            }
                            if (jZzo >= i3 && zzenVar.zza() >= jZzo) {
                                zzenVar.zzM((int) jZzo);
                            }
                        } else if ((8421504 & jZzo) == 0) {
                            long j = ((jZzo >> 16) & 255) << 14;
                            jZzo = ((jZzo >> 24) << 21) | j | (jZzo & 255) | (((jZzo >> 8) & 255) << 7);
                            if (i == 4) {
                                if ((iZzq & 64) != 0) {
                                    i4 = 0;
                                }
                                int i7 = i4;
                                i5 = iZzq & 1;
                                i3 = i7;
                            } else if (i == 3) {
                                if ((iZzq & 32) != 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if ((iZzq & 128) != 0) {
                                    i5 = 0;
                                }
                            } else {
                                i3 = 0;
                                i5 = 0;
                            }
                            if (i5 != 0) {
                                i3 += 4;
                            }
                            if (jZzo >= i3) {
                                zzenVar.zzM((int) jZzo);
                            }
                        }
                        z2 = false;
                        break;
                    }
                    break;
                }
                break;
            } catch (Throwable th) {
                zzenVar.zzL(iZzc);
                throw th;
            }
        }
        zzenVar.zzL(iZzc);
        return z2;
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        return i2 <= i ? zzex.zzb : Arrays.copyOfRange(bArr, i, i2);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15311. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private static com.google.android.gms.internal.ads.zzahf zzl(int r35, com.google.android.gms.internal.ads.zzen r36, boolean r37, int r38, com.google.android.gms.internal.ads.zzahc r39) {
        /*
            Method dump skipped, instruction units count: 1531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahe.zzl(int, com.google.android.gms.internal.ads.zzen, boolean, int, com.google.android.gms.internal.ads.zzahc):com.google.android.gms.internal.ads.zzahf");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008d  */
    /* JADX WARN: Code duplicated, block: B:34:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00e0 A[SYNTHETIC] */
    public static final zzav zza(byte[] bArr, int i, zzahc zzahcVar, zzagq zzagqVar) {
        boolean z;
        zzahd zzahdVar;
        int i2;
        int iZze;
        zzahf zzahfVarZzl;
        ArrayList arrayList = new ArrayList();
        zzen zzenVar = new zzen(bArr, i);
        int iZza = zzenVar.zza();
        boolean z2 = false;
        String str = iafHZUfOuHNwvy.mlLPNwzAPar;
        if (iZza < 10) {
            zzea.zzf(str, "Data too short to be an ID3 tag");
        } else {
            int iZzo = zzenVar.zzo();
            if (iZzo == 4801587) {
                int iZzm = zzenVar.zzm();
                zzenVar.zzM(1);
                int iZzm2 = zzenVar.zzm();
                int iZzl = zzenVar.zzl();
                if (iZzm != 2) {
                    if (iZzm == 3) {
                        if ((iZzm2 & 64) != 0) {
                            int iZzg = zzenVar.zzg();
                            zzenVar.zzM(iZzg);
                            iZzl -= iZzg + 4;
                        }
                    } else if (iZzm == 4) {
                        if ((iZzm2 & 64) != 0) {
                            int iZzl2 = zzenVar.zzl();
                            zzenVar.zzM(iZzl2 - 4);
                            iZzl -= iZzl2;
                        }
                        if ((iZzm2 & 16) != 0) {
                            iZzl -= 10;
                        }
                    } else {
                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZzm, "Skipped ID3 tag with unsupported majorVersion=", str);
                    }
                    if (iZzm < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    zzahdVar = new zzahd(iZzm, z, iZzl);
                } else if ((iZzm2 & 64) != 0) {
                    zzea.zzf(str, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (iZzm < 4 || (iZzm2 & 128) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    zzahdVar = new zzahd(iZzm, z, iZzl);
                }
                if (zzahdVar == null) {
                    return null;
                }
                int iZzc = zzenVar.zzc();
                i2 = zzahdVar.zza == 2 ? 6 : 10;
                iZze = zzahdVar.zzc;
                if (zzahdVar.zzb) {
                    iZze = zze(zzenVar, zzahdVar.zzc);
                }
                zzenVar.zzK(iZzc + iZze);
                if (!zzj(zzenVar, zzahdVar.zza, i2, false)) {
                    if (zzahdVar.zza == 4 || !zzj(zzenVar, 4, i2, true)) {
                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(zzahdVar.zza, "Failed to validate ID3 tag with majorVersion=", str);
                        return null;
                    }
                    z2 = true;
                }
                while (zzenVar.zza() >= i2) {
                    zzahfVarZzl = zzl(zzahdVar.zza, zzenVar, z2, i2, zzahcVar);
                    if (zzahfVarZzl != null) {
                        arrayList.add(zzahfVarZzl);
                    }
                }
                return new zzav(arrayList);
            }
            zzea.zzf(str, "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(iZzo))));
        }
        zzahdVar = null;
        if (zzahdVar == null) {
            return null;
        }
        int iZzc2 = zzenVar.zzc();
        if (zzahdVar.zza == 2) {
        }
        iZze = zzahdVar.zzc;
        if (zzahdVar.zzb) {
            iZze = zze(zzenVar, zzahdVar.zzc);
        }
        zzenVar.zzK(iZzc2 + iZze);
        if (!zzj(zzenVar, zzahdVar.zza, i2, false)) {
            if (zzahdVar.zza == 4) {
            }
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(zzahdVar.zza, "Failed to validate ID3 tag with majorVersion=", str);
            return null;
        }
        while (zzenVar.zza() >= i2) {
            zzahfVarZzl = zzl(zzahdVar.zza, zzenVar, z2, i2, zzahcVar);
            if (zzahfVarZzl != null) {
                arrayList.add(zzahfVarZzl);
            }
        }
        return new zzav(arrayList);
    }
}
