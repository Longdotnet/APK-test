package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzgwg implements zzget {
    private final zzgww zza;
    private final zzgfl zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzgwg(zzgww zzgwwVar, zzgfl zzgflVar, int i, byte[] bArr) {
        this.zza = zzgwwVar;
        this.zzb = zzgflVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzget zzb(zzggi zzggiVar) {
        zzgvz zzgvzVar = new zzgvz(zzggiVar.zze().zzd(zzgey.zza()), zzggiVar.zzd().zzd());
        String strValueOf = String.valueOf(zzggiVar.zzd().zzg());
        return new zzgwg(zzgvzVar, new zzgxb(new zzgxa("HMAC".concat(strValueOf), new SecretKeySpec(zzggiVar.zzf().zzd(zzgey.zza()), "HMAC")), zzggiVar.zzd().zze()), zzggiVar.zzd().zze(), zzggiVar.zzb().zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int length = bArr.length;
        int i = this.zzc;
        int length2 = bArr3.length;
        if (length < i + length2) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzgpj.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        int i2 = length - i;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (MessageDigest.isEqual(((zzgxb) this.zzb).zzc(zzgwe.zzb(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
