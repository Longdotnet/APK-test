package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfs {
    public static final zzbeo zza = zzbeo.zzd("gads:trustless_token_for_decagon:enabled", true);
    public static final zzbeo zzb;

    static {
        zzbeo.zzd("gads:invalidate_token_at_refresh_start", true);
        zzbeo.zzd("gms:expose_token_for_gma:enabled", true);
        zzbeo.zzd("gads:referesh_rate_limit", false);
        zzb = zzbeo.zzb("gads:timeout_for_trustless_token:millis", 2000L);
        zzbeo.zzd("gads:token_anonymization:enabled", true);
        zzbeo.zzb("gads:cached_token:ttl_millis", 10800000L);
    }
}
