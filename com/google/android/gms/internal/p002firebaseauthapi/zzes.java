package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
final class zzes {
    private final String zza;

    public zzes(String str) {
        this.zza = str;
    }

    private final byte[] zzf(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Mac mac = (Mac) zzpz.zzb.zza(this.zza);
        if (i > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i];
        mac.init(new SecretKeySpec(bArr, this.zza));
        byte[] bArrDoFinal = new byte[0];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr2);
            mac.update((byte) i2);
            bArrDoFinal = mac.doFinal();
            int length = bArrDoFinal.length;
            int i4 = i3 + length;
            if (i4 >= i) {
                System.arraycopy(bArrDoFinal, 0, bArr3, i3, i - i3);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, i3, length);
            i2++;
            i3 = i4;
        }
    }

    private final byte[] zzg(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        Mac mac = (Mac) zzpz.zzb.zza(this.zza);
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], this.zza));
        } else {
            mac.init(new SecretKeySpec(bArr2, this.zza));
        }
        return mac.doFinal(bArr);
    }

    public final int zza() {
        return Mac.getInstance(this.zza).getMacLength();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    public final byte[] zzc() throws GeneralSecurityException {
        byte b;
        String str = this.zza;
        int iHashCode = str.hashCode();
        if (iHashCode != 984523022) {
            if (iHashCode != 984524074) {
                if (iHashCode == 984525777 && str.equals("HmacSha512")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("HmacSha384")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("HmacSha256")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            return zzff.zzf;
        }
        if (b == 1) {
            return zzff.zzg;
        }
        if (b == 2) {
            return zzff.zzh;
        }
        throw new GeneralSecurityException("Could not determine HPKE KDF ID");
    }

    public final byte[] zzd(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) {
        return zzf(bArr, zzff.zzf(str, bArr2, bArr3, i), i);
    }

    public final byte[] zze(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return zzg(zzff.zze(str, bArr2, bArr3), bArr);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i) {
        return zzf(zzg(zzff.zze(ZRqOdXiy.nVpbvsr, bArr2, bArr4), null), zzff.zzf("shared_secret", bArr3, bArr4, i), i);
    }
}
