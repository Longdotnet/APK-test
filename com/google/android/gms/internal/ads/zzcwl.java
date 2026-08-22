package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwl extends zzdbt implements zzcwc {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd;

    public zzcwl(zzcwk zzcwkVar, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzd = false;
        this.zzb = scheduledExecutorService;
        zzo(zzcwkVar, executor);
    }

    public static /* synthetic */ void zza(zzcwl zzcwlVar) {
        synchronized (zzcwlVar) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Timeout waiting for show call succeed to be called.");
            zzcwlVar.zze(new zzdgm("Timeout for show call succeed."));
            zzcwlVar.zzd = true;
        }
    }

    public final synchronized void zzb() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzc(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwd
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwc) obj).zzc(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzd() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwe
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwc) obj).zzd();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zze(final zzdgm zzdgmVar) {
        if (this.zzd) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwg
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwc) obj).zze(zzdgmVar);
            }
        });
    }

    public final void zzf() {
        this.zzc = this.zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcwf
            @Override // java.lang.Runnable
            public final void run() {
                zzcwl.zza(this.zza);
            }
        }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlf)).intValue(), TimeUnit.MILLISECONDS);
    }
}
