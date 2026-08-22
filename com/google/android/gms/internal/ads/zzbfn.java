package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbfn {
    public static final zzbeo zza = zzbeo.zzb("gads:dynamite_load:fail:sample_rate", 10000);
    public static final zzbeo zzb = zzbeo.zzd("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbeo zzc = new zzbeo("gads:public_beta:traffic_multiplier", iafHZUfOuHNwvy.MFJCzVePbdtPK, 4);
    public static final zzbeo zzd = new zzbeo("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbeo zze;
    public static final zzbeo zzf;

    static {
        zzbeo.zzd("gads:sdk_crash_report_enabled", false);
        zze = zzbeo.zzd("gads:sdk_crash_report_full_stacktrace", false);
        zzf = zzbeo.zza("gads:trapped_exception_sample_rate", 0.01d);
    }
}
