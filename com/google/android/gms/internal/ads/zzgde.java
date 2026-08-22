package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public class zzgde extends zzgdo {
    public static zzgde zzw(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzgde ? (zzgde) listenableFuture : new zzgdf(listenableFuture);
    }
}
