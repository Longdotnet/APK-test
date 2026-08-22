package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfgq {
    final /* synthetic */ zzfgs zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    public /* synthetic */ zzfgq(zzfgs zzfgsVar, Object obj, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this(zzfgsVar, obj, null, listenableFuture, list, listenableFuture2);
    }

    public final zzfgg zza() {
        Object obj = this.zzb;
        String strZzf = this.zzc;
        if (strZzf == null) {
            strZzf = this.zza.zzf(obj);
        }
        final zzfgg zzfggVar = new zzfgg(obj, strZzf, this.zzf);
        this.zza.zzd.zza(zzfggVar);
        ListenableFuture listenableFuture = this.zzd;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgo
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd.zzc(zzfggVar);
            }
        };
        zzgdy zzgdyVar = zzcaf.zzg;
        listenableFuture.addListener(runnable, zzgdyVar);
        zzgdn.zzr(zzfggVar, new zzfgp(this, zzfggVar), zzgdyVar);
        return zzfggVar;
    }

    public final zzfgq zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfgq zzc(Class cls, zzgcu zzgcuVar) {
        zzfgs zzfgsVar = this.zza;
        return new zzfgq(zzfgsVar, this.zzb, this.zzc, this.zzd, this.zze, zzgdn.zzf(this.zzf, cls, zzgcuVar, zzfgsVar.zzb));
    }

    public final zzfgq zzd(final ListenableFuture listenableFuture) {
        return zzg(new zzgcu() { // from class: com.google.android.gms.internal.ads.zzfgn
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return listenableFuture;
            }
        }, zzcaf.zzg);
    }

    public final zzfgq zze(final zzfge zzfgeVar) {
        return zzf(new zzgcu() { // from class: com.google.android.gms.internal.ads.zzfgm
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(zzfgeVar.zza(obj));
            }
        });
    }

    public final zzfgq zzf(zzgcu zzgcuVar) {
        return zzg(zzgcuVar, this.zza.zzb);
    }

    public final zzfgq zzg(zzgcu zzgcuVar, Executor executor) {
        return new zzfgq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgdn.zzn(this.zzf, zzgcuVar, executor));
    }

    public final zzfgq zzh(String str) {
        return new zzfgq(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfgq zzi(long j, TimeUnit timeUnit) {
        zzfgs zzfgsVar = this.zza;
        return new zzfgq(zzfgsVar, this.zzb, this.zzc, this.zzd, this.zze, zzgdn.zzo(this.zzf, j, timeUnit, zzfgsVar.zzc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzfgq(zzfgs zzfgsVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        Objects.requireNonNull(zzfgsVar);
        this.zza = zzfgsVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }
}
