package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzff {
    public static final byte[] zza = zzc(1, 0);
    public static final byte[] zzb = zzc(2, 32);
    public static final byte[] zzc = zzc(2, 16);
    public static final byte[] zzd = zzc(2, 17);
    public static final byte[] zze = zzc(2, 18);
    public static final byte[] zzf = zzc(2, 1);
    public static final byte[] zzg = zzc(2, 2);
    public static final byte[] zzh = zzc(2, 3);
    public static final byte[] zzi = zzc(2, 1);
    public static final byte[] zzj = zzc(2, 2);
    public static final byte[] zzk = zzc(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm;
    private static final byte[] zzn;
    private static final byte[] zzo;

    static {
        Charset charset = StandardCharsets.UTF_8;
        zzm = "KEM".getBytes(charset);
        zzn = "HPKE".getBytes(charset);
        zzo = "HPKE-v1".getBytes(charset);
    }

    public static byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return zzpp.zzc(zzn, bArr, bArr2, bArr3);
    }

    public static byte[] zzc(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] zzd(byte[] bArr) {
        return zzpp.zzc(zzm, bArr);
    }

    public static byte[] zze(String str, byte[] bArr, byte[] bArr2) {
        return zzpp.zzc(zzo, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static byte[] zzf(String str, byte[] bArr, byte[] bArr2, int i) {
        return zzpp.zzc(zzc(2, i), zzo, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static int zzg(int i) throws GeneralSecurityException {
        int i2 = i - 2;
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static void zza(zznh zznhVar) throws GeneralSecurityException {
        if (zznhVar.zzf() != 2 && zznhVar.zzf() != 1) {
            int iZze = zznhVar.zze();
            String str = mnwSv.eKWpsmmqQH;
            if (iZze != 2 && zznhVar.zze() != 1) {
                if (zznhVar.zzd() != 2 && zznhVar.zzd() != 1) {
                    return;
                }
                int iZzd = zznhVar.zzd();
                if (iZzd != 2) {
                    if (iZzd != 3) {
                        if (iZzd != 4) {
                            if (iZzd == 5) {
                                str = "CHACHA20_POLY1305";
                            }
                        } else {
                            str = "AES_256_GCM";
                        }
                    } else {
                        str = "AES_128_GCM";
                    }
                } else {
                    str = "AEAD_UNKNOWN";
                }
                throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
            }
            int iZze2 = zznhVar.zze();
            if (iZze2 != 2) {
                if (iZze2 != 3) {
                    if (iZze2 != 4) {
                        if (iZze2 == 5) {
                            str = "HKDF_SHA512";
                        }
                    } else {
                        str = "HKDF_SHA384";
                    }
                } else {
                    str = "HKDF_SHA256";
                }
            } else {
                str = "KDF_UNKNOWN";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        }
        throw new GeneralSecurityException("Invalid KEM param: ".concat(zznb.zza(zznhVar.zzf())));
    }
}
