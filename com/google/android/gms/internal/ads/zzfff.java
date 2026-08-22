package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class zzfff {
    private final zzfej zza;
    private final zzffd zzb;
    private final zzfef zzc;
    private zzffl zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfff(zzfej zzfejVar, zzfef zzfefVar, zzffd zzffdVar) {
        this.zza = zzfejVar;
        this.zzc = zzfefVar;
        this.zzb = zzffdVar;
        zzfefVar.zzb(new zzffa(this));
    }

    public static /* synthetic */ void zzc(zzfff zzfffVar) {
        synchronized (zzfffVar) {
            zzfffVar.zzf = 1;
            zzfffVar.zzh();
        }
    }

    public final synchronized void zzh() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgy)).booleanValue() && !((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzg().zzh()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (true) {
                ArrayDeque arrayDeque = this.zzd;
                if (arrayDeque.isEmpty()) {
                    break;
                }
                zzffe zzffeVar = (zzffe) arrayDeque.pollFirst();
                if (zzffeVar == null || (zzffeVar.zza() != null && this.zza.zze(zzffeVar.zza()))) {
                    zzffl zzfflVar = new zzffl(this.zza, this.zzb, zzffeVar);
                    this.zze = zzfflVar;
                    zzfflVar.zzd(new zzffb(this, zzffeVar));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized ListenableFuture zza(zzffe zzffeVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzc(zzffeVar);
    }

    public final synchronized void zzf(zzffe zzffeVar) {
        this.zzd.add(zzffeVar);
    }
}
