package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzffl {
    private final zzffe zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzffl(final zzfej zzfejVar, final zzffd zzffdVar, final zzffe zzffeVar) {
        this.zza = zzffeVar;
        this.zzb = zzgdn.zzf(zzgdn.zzn(zzffdVar.zza(zzffeVar), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzffj
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzffl.zzb(this.zza, zzffdVar, zzfejVar, zzffeVar, (zzfes) obj);
            }
        }, zzffeVar.zzb()), Exception.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzffk
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzffl.zza(this.zza, zzffdVar, (Exception) obj);
            }
        }, zzffeVar.zzb());
    }

    public static /* synthetic */ ListenableFuture zza(zzffl zzfflVar, zzffd zzffdVar, Exception exc) {
        synchronized (zzfflVar) {
            zzfflVar.zzd = true;
            throw exc;
        }
    }

    public static /* synthetic */ ListenableFuture zzb(zzffl zzfflVar, zzffd zzffdVar, zzfej zzfejVar, zzffe zzffeVar, zzfes zzfesVar) {
        ListenableFuture listenableFutureZzh;
        synchronized (zzfflVar) {
            try {
                zzfflVar.zzd = true;
                zzffdVar.zzb(zzfesVar);
                if (zzfflVar.zzc) {
                    listenableFutureZzh = zzgdn.zzh(new zzffc(zzfesVar, zzffeVar));
                } else {
                    zzfejVar.zzd(zzffeVar.zza(), zzfesVar);
                    listenableFutureZzh = zzgdn.zzh(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listenableFutureZzh;
    }

    public final synchronized ListenableFuture zzc(zzffe zzffeVar) {
        if (!this.zzd && !this.zzc) {
            zzffe zzffeVar2 = this.zza;
            if (zzffeVar2.zza() != null && zzffeVar.zza() != null && zzffeVar2.zza().equals(zzffeVar.zza())) {
                this.zzc = true;
                return this.zzb;
            }
        }
        return null;
    }

    public final synchronized void zzd(zzgdj zzgdjVar) {
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzffi
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzi();
            }
        };
        zzffe zzffeVar = this.zza;
        zzgdn.zzr(zzgdn.zzn(this.zzb, zzgcuVar, zzffeVar.zzb()), zzgdjVar, zzffeVar.zzb());
    }
}
