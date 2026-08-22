package com.google.android.gms.ads.internal.util.client;

import com.android.billingclient.api.zzat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzb {
    public static final ThreadPoolExecutor zza = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), new zzat("ClientDefault"));
    public static final ExecutorService zzb = Executors.newSingleThreadExecutor(new zzat("ClientSingle"));
}
