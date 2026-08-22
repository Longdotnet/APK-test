package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgxf {
    private final zzgxe zza;

    private zzgxf(zzgxe zzgxeVar) {
        this.zza = zzgxeVar;
    }

    public static zzgxf zzb(byte[] bArr, zzgfn zzgfnVar) {
        return new zzgxf(zzgxe.zzb(bArr));
    }

    public static zzgxf zzc(int i) {
        return new zzgxf(zzgxe.zzb(zzgpa.zzb(i)));
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final byte[] zzd(zzgfn zzgfnVar) {
        return this.zza.zzd();
    }
}
