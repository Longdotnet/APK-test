package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzfg implements zzex {
    private final zzes zza;
    private final int zzb;

    private zzfg(zzes zzesVar, int i) {
        this.zza = zzesVar;
        this.zzb = i;
    }

    public static zzfg zzc(int i) {
        int i2 = i - 1;
        if (i2 != 0) {
            return i2 != 1 ? new zzfg(new zzes("HmacSha512"), 3) : new zzfg(new zzes("HmacSha384"), 2);
        }
        return new zzfg(new zzes("HmacSha256"), 1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzex
    public final byte[] zza(byte[] bArr, zzey zzeyVar) throws GeneralSecurityException {
        byte[] bArrZzh = zzpx.zzh(zzpx.zzi(this.zzb, zzeyVar.zza().zzc()), zzpx.zzk(zzpx.zzl(this.zzb), 1, bArr));
        byte[] bArrZzc = zzpp.zzc(bArr, zzeyVar.zzb().zzc());
        byte[] bArrZzd = zzff.zzd(zzb());
        zzes zzesVar = this.zza;
        return zzesVar.zzb(null, bArrZzh, "eae_prk", bArrZzc, "shared_secret", bArrZzd, zzesVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzex
    public final byte[] zzb() {
        int i = this.zzb - 1;
        if (i != 0) {
            return i != 1 ? zzff.zze : zzff.zzd;
        }
        return zzff.zzc;
    }
}
