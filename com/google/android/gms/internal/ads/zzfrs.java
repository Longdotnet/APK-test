package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public interface zzfrs {
    ExecutorService zza(int i);

    ExecutorService zzb(ThreadFactory threadFactory, int i);

    ExecutorService zzc(int i, ThreadFactory threadFactory, int i2);
}
