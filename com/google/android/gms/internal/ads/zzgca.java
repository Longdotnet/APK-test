package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgca extends zzgdd implements Runnable {
    public static final /* synthetic */ int zzd = 0;
    ListenableFuture zza;
    Class zzb;
    Object zzc;

    public zzgca(ListenableFuture listenableFuture, Class cls, Object obj) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object objZzp;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = listenableFuture instanceof zzger ? ((zzger) listenableFuture).zzi() : null;
            objZzp = th == null ? zzgdn.zzp(listenableFuture) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                cause = new NullPointerException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Future type ", String.valueOf(listenableFuture.getClass()), " threw ", String.valueOf(e.getClass()), " without a cause"));
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            zzc(objZzp);
            return;
        }
        if (!cls.isInstance(th)) {
            zzn(listenableFuture);
            return;
        }
        try {
            Object objZze = zze(obj, th);
            this.zzb = null;
            this.zzc = null;
            zzf(objZze);
        } catch (Throwable th2) {
            try {
                zzgeg.zza(th2);
                zzd(th2);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZza = super.zza();
        String strM$1 = listenableFuture != null ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("inputFuture=[", listenableFuture.toString(), "], ") : "";
        if (cls == null || obj == null) {
            if (strZza != null) {
                return strM$1.concat(strZza);
            }
            return null;
        }
        return strM$1 + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + "]";
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final void zzb() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    public abstract Object zze(Object obj, Throwable th);

    public abstract void zzf(Object obj);
}
