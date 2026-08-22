package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgck extends zzgdd implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    ListenableFuture zza;
    Object zzb;

    public zzgck(ListenableFuture listenableFuture, Object obj) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
        this.zzb = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (listenableFuture == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isCancelled()) {
            zzn(listenableFuture);
            return;
        }
        try {
            try {
                Object objZze = zze(obj, zzgdn.zzp(listenableFuture));
                this.zzb = null;
                zzf(objZze);
            } catch (Throwable th) {
                try {
                    zzgeg.zza(th);
                    zzd(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e) {
            zzd(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e2) {
            zzd(e2.getCause());
        } catch (Exception e3) {
            zzd(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        ListenableFuture listenableFuture = this.zza;
        Object obj = this.zzb;
        String strZza = super.zza();
        String strM$1 = listenableFuture != null ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("inputFuture=[", listenableFuture.toString(), "], ") : "";
        if (obj == null) {
            if (strZza != null) {
                return strM$1.concat(strZza);
            }
            return null;
        }
        return strM$1 + "function=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final void zzb() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    public abstract Object zze(Object obj, Object obj2);

    public abstract void zzf(Object obj);
}
