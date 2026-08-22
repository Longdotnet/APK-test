package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgbd {
    private static final zzgbd zza;

    public static zzgbd zzi() {
        return zza;
    }

    public abstract int zza(byte[] bArr, CharSequence charSequence);

    public abstract void zzc(Appendable appendable, byte[] bArr, int i, int i2);

    public abstract int zzd(int i);

    public abstract int zze(int i);

    public abstract zzgbd zzf();

    public CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public final String zzj(byte[] bArr, int i, int i2) {
        zzfvp.zzk(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zze(i2));
        try {
            zzc(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzk(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzg = zzg(charSequence);
            int iZzd = zzd(charSequenceZzg.length());
            byte[] bArr = new byte[iZzd];
            int iZza = zza(bArr, charSequenceZzg);
            if (iZza == iZzd) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZza];
            System.arraycopy(bArr, 0, bArr2, 0, iZza);
            return bArr2;
        } catch (zzgbb e) {
            throw new IllegalArgumentException(e);
        }
    }

    static {
        new zzgba("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        new zzgba("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new zzgbc("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzgbc("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        zza = new zzgaz(PZmDzEagKNdW.rTolELccB, "0123456789ABCDEF");
    }
}
