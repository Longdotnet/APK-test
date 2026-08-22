package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzfk {
    private final zzap zza;
    private final zzat zzb;

    public zzfk(zzap zzapVar) {
        this.zza = zzapVar;
        this.zzb = null;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        zzap zzapVar = this.zza;
        return zzapVar != null ? zzapVar.zza(bArr, bArr2) : this.zzb.zza(bArr, bArr2);
    }

    public zzfk(zzat zzatVar) {
        this.zza = null;
        this.zzb = zzatVar;
    }
}
