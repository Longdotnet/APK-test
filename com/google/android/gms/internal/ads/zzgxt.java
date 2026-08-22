package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgxt extends zzgxw {
    private final int zzc;
    private final int zzd;

    public zzgxt(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgxz.zzq(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgxw, com.google.android.gms.internal.ads.zzgxz
    public final byte zza(int i) {
        zzgxz.zzy(i, this.zzd);
        return ((zzgxw) this).zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzgxw, com.google.android.gms.internal.ads.zzgxz
    public final byte zzb(int i) {
        return ((zzgxw) this).zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzgxw
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxw, com.google.android.gms.internal.ads.zzgxz
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxw, com.google.android.gms.internal.ads.zzgxz
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(((zzgxw) this).zza, this.zzc + i, bArr, i2, i3);
    }
}
