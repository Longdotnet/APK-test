package com.google.android.gms.ads;

/* JADX INFO: loaded from: classes.dex */
public abstract class FullScreenContentCallback {
    public abstract void onAdDismissedFullScreenContent();

    public void onAdFailedToShowFullScreenContent(AdError adError) {
    }

    public abstract void onAdShowedFullScreenContent();
}
