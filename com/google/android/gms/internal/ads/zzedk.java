package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$Api33Ext4JavaImpl;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzedk {
    private final Context zza;

    public zzedk(Context context) {
        this.zza = context;
    }

    public final ListenableFuture zza(boolean z) {
        try {
            GetTopicsRequest getTopicsRequest = new GetTopicsRequest(z);
            TopicsManagerFutures$Api33Ext4JavaImpl topicsManagerFutures$Api33Ext4JavaImplFrom = TopicsManagerFutures$Api33Ext4JavaImpl.from(this.zza);
            return topicsManagerFutures$Api33Ext4JavaImplFrom != null ? topicsManagerFutures$Api33Ext4JavaImplFrom.getTopicsAsync(getTopicsRequest) : zzgdn.zzg(new IllegalStateException());
        } catch (Exception e) {
            return zzgdn.zzg(e);
        }
    }
}
