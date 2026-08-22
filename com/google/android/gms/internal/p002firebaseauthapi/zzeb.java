package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
final class zzeb implements zzat {
    private final zzbu zza;
    private final zzjd zzb;
    private final zzjd zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzat
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzbq zzbqVar : this.zza.zze(bArrCopyOf)) {
                try {
                    byte[] bArrZza = ((zzat) zzbqVar.zze()).zza(bArrCopyOfRange, bArr2);
                    zzbqVar.zza();
                    int length2 = bArrCopyOfRange.length;
                    return bArrZza;
                } catch (GeneralSecurityException e) {
                    zzec.zza.logp(Level.INFO, "com.google.crypto.tink.daead.DeterministicAeadWrapper$WrappedDeterministicAead", "decryptDeterministically", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e.toString()));
                }
            }
        }
        for (zzbq zzbqVar2 : this.zza.zze(zzas.zza)) {
            try {
                byte[] bArrZza2 = ((zzat) zzbqVar2.zze()).zza(bArr, bArr2);
                zzbqVar2.zza();
                return bArrZza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }

    public zzeb(zzbu zzbuVar) {
        zzjd zzjdVarZza;
        this.zza = zzbuVar;
        if (zzbuVar.zzf()) {
            zzje zzjeVarZzb = zzgm.zza().zzb();
            zzjj zzjjVarZza = zzgj.zza(zzbuVar);
            this.zzb = zzjeVarZzb.zza(zzjjVarZza, "daead", GsPcpBmONXh.PwEznFRbQ);
            zzjdVarZza = zzjeVarZzb.zza(zzjjVarZza, "daead", "decrypt");
        } else {
            zzjdVarZza = zzgj.zza;
            this.zzb = zzjdVarZza;
        }
        this.zzc = zzjdVarZza;
    }
}
