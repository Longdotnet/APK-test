package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;

/* JADX INFO: loaded from: classes.dex */
public final class NativeAdOptions {
    public final boolean zza;
    public final int zzb;
    public final boolean zzc;
    public final int zzd;
    public final VideoOptions zze;
    public final boolean zzf;
    public final boolean zzg;
    public final int zzh;
    public final int zzi;

    public final class Builder {
        public VideoOptions zzd;
        public boolean zza = false;
        public int zzb = 0;
        public boolean zzc = false;
        public int zze = 1;
        public boolean zzf = false;
        public boolean zzg = false;
        public int zzh = 0;
        public int zzi = 1;
    }

    public /* synthetic */ NativeAdOptions(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zze;
        this.zze = builder.zzd;
        this.zzf = builder.zzf;
        this.zzg = builder.zzg;
        this.zzh = builder.zzh;
        this.zzi = builder.zzi;
    }
}
