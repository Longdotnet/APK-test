package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.EllipticCurve;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzpt implements zzau {
    private static final byte[] zza = new byte[0];
    private final ECPrivateKey zzb;
    private final zzpv zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzps zzf;
    private final int zzg;

    public zzpt(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i, zzps zzpsVar) {
        this.zzb = eCPrivateKey;
        this.zzc = new zzpv(eCPrivateKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzg = i;
        this.zzf = zzpsVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    /* JADX WARN: Code duplicated, block: B:13:0x004a  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzau
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i;
        int length;
        EllipticCurve curve = this.zzb.getParams().getCurve();
        int i2 = this.zzg;
        int iZza = zzpx.zza(curve);
        int i3 = i2 - 1;
        if (i3 != 0) {
            if (i3 == 2) {
                i = iZza + iZza;
            }
            length = bArr.length;
            if (length >= i) {
                throw new GeneralSecurityException("ciphertext too short");
            }
            return this.zzf.zzb(this.zzc.zza(Arrays.copyOfRange(bArr, 0, i), this.zzd, this.zze, null, this.zzf.zza(), this.zzg)).zza(Arrays.copyOfRange(bArr, i, length), zza);
        }
        iZza += iZza;
        i = iZza + 1;
        length = bArr.length;
        if (length >= i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.zzf.zzb(this.zzc.zza(Arrays.copyOfRange(bArr, 0, i), this.zzd, this.zze, null, this.zzf.zza(), this.zzg)).zza(Arrays.copyOfRange(bArr, i, length), zza);
    }
}
