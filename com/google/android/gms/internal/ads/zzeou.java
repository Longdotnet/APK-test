package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzeou implements zzeuc {
    private final AtomicReference zza = new AtomicReference();
    private final AtomicReference zzb = new AtomicReference(Boolean.FALSE);
    private final Clock zzc;
    private final Executor zzd;
    private final zzeuc zze;
    private final long zzf;
    private final zzdsj zzg;

    public zzeou(zzeuc zzeucVar, long j, Clock clock, Executor executor, zzdsj zzdsjVar) {
        this.zzc = clock;
        this.zze = zzeucVar;
        this.zzf = j;
        this.zzd = executor;
        this.zzg = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return this.zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzeot zzeotVar;
        zzbcv zzbcvVar = zzbde.zzmj;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzmi)).booleanValue() && !((Boolean) this.zzb.getAndSet(Boolean.TRUE)).booleanValue()) {
                ScheduledExecutorService scheduledExecutorService = zzcaf.zzd;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzeor
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeou zzeouVar = this.zza;
                        zzeouVar.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeos
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzeou zzeouVar2 = zzeouVar;
                                zzeouVar2.zza.set(new zzeot(zzeouVar2.zze.zzb(), zzeouVar2.zzf, zzeouVar2.zzc));
                            }
                        });
                    }
                };
                long j = this.zzf;
                scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
            }
            synchronized (this) {
                try {
                    AtomicReference atomicReference = this.zza;
                    zzeot zzeotVar2 = (zzeot) atomicReference.get();
                    if (zzeotVar2 == null) {
                        zzeot zzeotVar3 = new zzeot(this.zze.zzb(), this.zzf, this.zzc);
                        atomicReference.set(zzeotVar3);
                        return zzeotVar3.zza;
                    }
                    if (((Boolean) this.zzb.get()).booleanValue() || !zzeotVar2.zza()) {
                        zzeotVar = zzeotVar2;
                    } else {
                        ListenableFuture listenableFuture = zzeotVar2.zza;
                        zzeuc zzeucVar = this.zze;
                        zzeot zzeotVar4 = new zzeot(zzeucVar.zzb(), this.zzf, this.zzc);
                        this.zza.set(zzeotVar4);
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzmk)).booleanValue()) {
                            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzml)).booleanValue()) {
                                zzdsi zzdsiVarZza = this.zzg.zza();
                                zzdsiVarZza.zzb("action", "scs");
                                zzdsiVarZza.zzb("sid", String.valueOf(zzeucVar.zza()));
                                zzdsiVarZza.zzj();
                            }
                            return listenableFuture;
                        }
                        zzeotVar = zzeotVar4;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            AtomicReference atomicReference2 = this.zza;
            zzeotVar = (zzeot) atomicReference2.get();
            if (zzeotVar == null || zzeotVar.zza()) {
                zzeuc zzeucVar2 = this.zze;
                zzeot zzeotVar5 = new zzeot(zzeucVar2.zzb(), this.zzf, this.zzc);
                atomicReference2.set(zzeotVar5);
                zzeotVar = zzeotVar5;
            }
        }
        return zzeotVar.zza;
    }
}
