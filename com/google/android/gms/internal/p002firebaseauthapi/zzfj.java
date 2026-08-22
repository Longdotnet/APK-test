package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzfj implements zzey {
    private final zzqv zza;
    private final zzqv zzb;

    private zzfj(byte[] bArr, byte[] bArr2) {
        this.zza = zzqv.zzb(bArr);
        this.zzb = zzqv.zzb(bArr2);
    }

    public static zzfj zzc(byte[] bArr) {
        return new zzfj(bArr, zzqt.zzb(bArr));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzey
    public final zzqv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzey
    public final zzqv zzb() {
        return this.zzb;
    }
}
