package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface zzgdz extends ScheduledExecutorService, zzgdy {
    zzgdx zzc(Callable callable, long j, TimeUnit timeUnit);
}
