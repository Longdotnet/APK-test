package com.google.android.gms.location;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzu {
    public static final Feature zzc;
    public static final Feature[] zzf;

    static {
        Feature feature = new Feature("name_ulr_private", 1L);
        Feature feature2 = new Feature("name_sleep_segment_request", 1L);
        Feature feature3 = new Feature("support_context_feature_id", 1L);
        zzc = feature3;
        zzf = new Feature[]{feature, feature2, feature3, new Feature("get_current_location", 1L), new Feature("get_last_activity_feature_id", 1L)};
    }
}
