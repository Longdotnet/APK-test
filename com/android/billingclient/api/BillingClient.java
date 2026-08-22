package com.android.billingclient.api;

import androidx.room.RoomOpenHelper;
import com.daerisoft.thespikerm.RunnerActivity;

/* JADX INFO: loaded from: classes.dex */
public abstract class BillingClient {
    public abstract BillingResult launchBillingFlow(RunnerActivity runnerActivity, BillingFlowParams billingFlowParams);

    public abstract void querySkuDetailsAsync(RoomOpenHelper roomOpenHelper, SkuDetailsResponseListener skuDetailsResponseListener);
}
