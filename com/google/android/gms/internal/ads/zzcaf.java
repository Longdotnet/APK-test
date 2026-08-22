package com.google.android.gms.internal.ads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcaf {
    public static final zzgdy zza;
    public static final zzgdy zzb;
    public static final zzgdy zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzgdz zze;
    public static final zzgdy zzf;
    public static final zzgdy zzg;

    /* JADX WARN: Code duplicated, block: B:11:0x006c  */
    static {
        ThreadPoolExecutor threadPoolExecutor;
        zzbcv zzbcvVar = zzbde.zzlJ;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (zzbdVar.zzd.zzc(zzbcvVar) == null || !((Boolean) zzbdVar.zzd.zzc(zzbcvVar)).booleanValue()) {
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcab("Default"));
        } else {
            zzbcv zzbcvVar2 = zzbde.zzlK;
            if (zzbdVar.zzd.zzc(zzbcvVar2) != null) {
                zzbcv zzbcvVar3 = zzbde.zzlL;
                if (zzbdVar.zzd.zzc(zzbcvVar3) != null) {
                    threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzbdVar.zzd.zzc(zzbcvVar2)).intValue(), ((Integer) zzbdVar.zzd.zzc(zzbcvVar2)).intValue(), 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcab("Default"));
                    threadPoolExecutor.allowCoreThreadTimeOut(((Boolean) zzbdVar.zzd.zzc(zzbcvVar3)).booleanValue());
                } else {
                    threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcab("Default"));
                }
            } else {
                threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcab("Default"));
            }
        }
        zza = new zzcad(threadPoolExecutor, null);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10L, timeUnit, new LinkedBlockingQueue(), new zzcab("Loader"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        zzb = new zzcad(threadPoolExecutor2, null);
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10L, timeUnit, new LinkedBlockingQueue(), new zzcab("Activeview"));
        threadPoolExecutor3.allowCoreThreadTimeOut(true);
        zzc = new zzcad(threadPoolExecutor3, null);
        zzcaa zzcaaVar = new zzcaa(3, new zzcab("Schedule"));
        zzd = zzcaaVar;
        zze = zzgef.zzb(zzcaaVar);
        zzf = new zzcad(new zzcac(), null);
        zzg = new zzcad(zzgef.zzc(), null);
    }
}
