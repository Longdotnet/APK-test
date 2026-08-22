package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzew implements zzav {
    private final zznn zza;
    private final zzex zzb;
    private final zzet zzc;
    private final zzes zzd;

    private zzew(zznn zznnVar, zzex zzexVar, zzes zzesVar, zzet zzetVar, byte[] bArr) {
        this.zza = zznnVar;
        this.zzb = zzexVar;
        this.zzd = zzesVar;
        this.zzc = zzetVar;
    }

    public static zzew zza(zznn zznnVar) {
        if (zznnVar.zzg().zzs()) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        zznh zznhVarZzb = zznnVar.zzb();
        return new zzew(zznnVar, zzez.zzb(zznhVarZzb), zzez.zzc(zznhVarZzb), zzez.zza(zznhVarZzb), null);
    }
}
