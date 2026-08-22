package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfc {
    public static final zzbeo zza = zzbeo.zzd("gads:init:init_on_bg_thread", true);
    public static final zzbeo zzb = zzbeo.zzd("gads:init:init_on_single_bg_thread", false);
    public static final zzbeo zzc = zzbeo.zzd("gads:adloader_load_bg_thread", true);
    public static final zzbeo zzd = zzbeo.zzd("gads:appopen_load_on_bg_thread", true);
    public static final zzbeo zze = zzbeo.zzd("gads:banner_destroy_bg_thread", false);
    public static final zzbeo zzf = zzbeo.zzd("gads:banner_load_bg_thread", true);
    public static final zzbeo zzg = zzbeo.zzd("gads:banner_pause_bg_thread", false);
    public static final zzbeo zzh = zzbeo.zzd("gads:banner_resume_bg_thread", false);
    public static final zzbeo zzi = zzbeo.zzd("gads:interstitial_load_on_bg_thread", true);
    public static final zzbeo zzj;
    public static final zzbeo zzk;

    static {
        zzbeo.zzd("gads:persist_flags_on_bg_thread", true);
        zzj = zzbeo.zzd("gads:query_info_bg_thread", true);
        zzk = zzbeo.zzd("gads:rewarded_load_bg_thread", true);
    }
}
