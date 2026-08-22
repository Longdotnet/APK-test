package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

/* JADX INFO: loaded from: classes.dex */
public final class NativeAdOptions {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final VideoOptions zzf;
    public final boolean zzg;

    public final class Builder {
        public VideoOptions zze;
        public boolean zza = false;
        public int zzb = -1;
        public int zzc = 0;
        public boolean zzd = false;
        public int zzf = 1;
        public boolean zzg = false;
    }

    public /* synthetic */ NativeAdOptions(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
        this.zze = builder.zzf;
        this.zzf = builder.zze;
        this.zzg = builder.zzg;
    }
}
