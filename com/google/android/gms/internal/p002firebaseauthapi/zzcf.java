package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
final class zzcf implements zzap {
    private final zzbu zza;
    private final zzjd zzb;
    private final zzjd zzc;

    public /* synthetic */ zzcf(zzbu zzbuVar, zzce zzceVar) {
        zzjd zzjdVarZza;
        this.zza = zzbuVar;
        if (zzbuVar.zzf()) {
            zzje zzjeVarZzb = zzgm.zza().zzb();
            zzjj zzjjVarZza = zzgj.zza(zzbuVar);
            this.zzb = zzjeVarZzb.zza(zzjjVarZza, "aead", "encrypt");
            zzjdVarZza = zzjeVarZzb.zza(zzjjVarZza, "aead", "decrypt");
        } else {
            zzjdVarZza = zzgj.zza;
            this.zzb = zzjdVarZza;
        }
        this.zzc = zzjdVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzbq zzbqVar : this.zza.zze(bArrCopyOf)) {
                try {
                    byte[] bArrZza = ((zzap) zzbqVar.zze()).zza(bArrCopyOfRange, bArr2);
                    zzbqVar.zza();
                    int length2 = bArrCopyOfRange.length;
                    return bArrZza;
                } catch (GeneralSecurityException e) {
                    zzcg.zza.logp(Level.INFO, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e.toString()));
                }
            }
        }
        for (zzbq zzbqVar2 : this.zza.zze(zzas.zza)) {
            try {
                byte[] bArrZza2 = ((zzap) zzbqVar2.zze()).zza(bArr, bArr2);
                zzbqVar2.zza();
                return bArrZza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        throw null;
    }
}
