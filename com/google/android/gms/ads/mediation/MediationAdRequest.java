package com.google.android.gms.ads.mediation;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface MediationAdRequest {
    Set getKeywords();

    boolean isDesignedForFamilies();

    boolean isTesting();

    int taggedForChildDirectedTreatment();
}
