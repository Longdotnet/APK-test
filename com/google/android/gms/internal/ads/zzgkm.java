package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgkm {
    private static final ThreadLocal zza = new zzgkl();

    public static AlgorithmParameterSpec zza(byte[] bArr, int i, int i2) {
        int i3 = zzgpj.zza;
        Objects.equals(System.getProperty("java.vendor"), "The Android Project");
        return new GCMParameterSpec(128, bArr, i, 12);
    }

    public static Cipher zzb() {
        return (Cipher) zza.get();
    }

    public static SecretKey zzc(byte[] bArr) throws InvalidAlgorithmParameterException {
        zzgxc.zza(bArr.length);
        return new SecretKeySpec(bArr, PZmDzEagKNdW.dkPozlawdNHCL);
    }
}
