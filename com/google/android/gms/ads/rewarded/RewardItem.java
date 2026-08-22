package com.google.android.gms.ads.rewarded;

import com.facebook.GraphRequest;

/* JADX INFO: loaded from: classes.dex */
public interface RewardItem {
    public static final GraphRequest.Companion DEFAULT_REWARD = new GraphRequest.Companion(27);

    int getAmount();

    String getType();
}
