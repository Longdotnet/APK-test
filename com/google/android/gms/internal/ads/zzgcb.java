package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgcb<V> extends zzgcc<V> {

    /* JADX INFO: loaded from: classes.dex */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgcc.zzg) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        public zza(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zzb<V> implements Runnable {
        final zzgcb<V> zza;
        final ListenableFuture zzb;

        public zzb(zzgcb zzgcbVar, ListenableFuture listenableFuture) {
            this.zza = zzgcbVar;
            this.zzb = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.valueField != this) {
                return;
            }
            if (zzgcc.zzv(this.zza, this, zzgcb.zze(this.zzb))) {
                zzgcb.zzx(this.zza, false);
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgcb.zzc.1
            public AnonymousClass1(String str) {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        static final zzc zzb = new zzc(new Throwable("Failure.exception is unexpectedly null.") { // from class: com.google.android.gms.internal.ads.zzgcb.zzc.2
            public AnonymousClass2(String str) {
                super("Failure.exception is unexpectedly null.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzc;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzgcb$zzc$1 */
        public class AnonymousClass1 extends Throwable {
            public AnonymousClass1(String str) {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzgcb$zzc$2 */
        public class AnonymousClass2 extends Throwable {
            public AnonymousClass2(String str) {
                super("Failure.exception is unexpectedly null.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        }

        public zzc(Throwable th) {
            th.getClass();
            this.zzc = th;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    interface zze<V> extends ListenableFuture {
        @Override // com.google.common.util.concurrent.ListenableFuture
        /* synthetic */ void addListener(Runnable runnable, Executor executor);
    }

    /* JADX INFO: loaded from: classes.dex */
    abstract class zzf<V> extends zzgcb<V> implements zze<V> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(ListenableFuture listenableFuture) {
        Throwable thZzi;
        if (listenableFuture instanceof zze) {
            Object zzaVar = ((zzgcb) listenableFuture).valueField;
            if (zzaVar instanceof zza) {
                zza zzaVar2 = (zza) zzaVar;
                if (zzaVar2.zzc) {
                    Throwable th = zzaVar2.zzd;
                    zzaVar = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            Objects.requireNonNull(zzaVar);
            return zzaVar;
        }
        if ((listenableFuture instanceof zzger) && (thZzi = ((zzger) listenableFuture).zzi()) != null) {
            return new zzc(thZzi);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!zzgcc.zzg) && zIsCancelled) {
            zza zzaVar3 = zza.zzb;
            Objects.requireNonNull(zzaVar3);
            return zzaVar3;
        }
        try {
            Object objZzf = zzf(listenableFuture);
            if (zIsCancelled) {
                return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture))));
            }
            return objZzf == null ? zzgcc.zze : objZzf;
        } catch (Error e) {
            e = e;
            return new zzc(e);
        } catch (CancellationException e2) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(listenableFuture)), e2)) : new zza(false, e2);
        } catch (ExecutionException e3) {
            return zIsCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture)), e3)) : new zzc(e3.getCause());
        } catch (Exception e4) {
            e = e4;
            return new zzc(e);
        }
    }

    private static Object zzf(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static Object zzh(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (!(obj instanceof zzc)) {
            if (obj == zzgcc.zze) {
                return null;
            }
            return obj;
        }
        Throwable th2 = ((zzc) obj).zzc;
        if (th2 != null) {
            throw new ExecutionException(th2);
        }
        zzgcc.zzf.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "getDoneValue", "Failure.exception is unexpectedly null.");
        throw new ExecutionException(zzc.zzb.zzc);
    }

    public static boolean zzm(Object obj) {
        return !(obj instanceof zzb);
    }

    public static void zzx(zzgcb zzgcbVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            zzgcbVar.zzt();
            if (z) {
                zzgcbVar.zzk();
            }
            zzgcbVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZzp = zzgcbVar.zzp(zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZzp != null) {
                zzd zzdVar4 = zzdVarZzp.next;
                zzdVarZzp.next = zzdVar3;
                zzdVar3 = zzdVarZzp;
                zzdVarZzp = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzdVar = zzdVar3.next;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zzgcbVar = zzbVar.zza;
                    if (zzgcbVar.valueField == zzbVar && zzgcc.zzv(zzgcbVar, zzbVar, zze(zzbVar.zzb))) {
                        z = false;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    Objects.requireNonNull(executor);
                    zzy(runnable2, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            zzgcc.zzf.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", CoroutineAdapterKt$$ExternalSyntheticLambda0.m("RuntimeException while executing runnable ", String.valueOf(runnable), " with executor ", String.valueOf(executor)), (Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcc, com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzfvp.zzc(runnable, "Runnable was null.");
        zzfvp.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listenersField) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzu(zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listenersField;
                }
            } while (zzdVar != zzd.zza);
        }
        zzy(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        zza zzaVar;
        Object obj = this.valueField;
        if (!(obj instanceof zzb) && !(obj == null)) {
            return false;
        }
        if (zzgcc.zzg) {
            zzaVar = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            zzaVar = z ? zza.zza : zza.zzb;
            Objects.requireNonNull(zzaVar);
        }
        zzgcb<V> zzgcbVar = this;
        boolean z2 = false;
        while (true) {
            if (zzgcc.zzv(zzgcbVar, obj, zzaVar)) {
                zzx(zzgcbVar, z);
                if (obj instanceof zzb) {
                    ListenableFuture listenableFuture = ((zzb) obj).zzb;
                    if (listenableFuture instanceof zze) {
                        zzgcbVar = (zzgcb) listenableFuture;
                        obj = zzgcbVar.valueField;
                        if ((obj == null) | (obj instanceof zzb)) {
                            z2 = true;
                        }
                    } else {
                        listenableFuture.cancel(z);
                    }
                }
                return true;
            }
            obj = zzgcbVar.valueField;
            if (zzm(obj)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return zzq();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzm(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public void zzb() {
    }

    public boolean zzc(Object obj) {
        if (obj == null) {
            obj = zzgcc.zze;
        }
        if (!zzgcc.zzv(this, null, obj)) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    public boolean zzd(Throwable th) {
        th.getClass();
        if (!zzgcc.zzv(this, null, new zzc(th))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzger
    public final Throwable zzi() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzc;
        }
        return null;
    }

    public void zzk() {
    }

    public final void zzl(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzo());
        }
    }

    public final boolean zzn(ListenableFuture listenableFuture) {
        zzc zzcVar;
        listenableFuture.getClass();
        Object obj = this.valueField;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!zzgcc.zzv(this, null, zze(listenableFuture))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, listenableFuture);
            if (zzgcc.zzv(this, null, zzbVar)) {
                try {
                    listenableFuture.addListener(zzbVar, zzgdb.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzgcc.zzv(this, zzbVar, zzcVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof zza) {
            listenableFuture.cancel(((zza) obj).zzc);
        }
        return false;
    }

    public final boolean zzo() {
        Object obj = this.valueField;
        return (obj instanceof zza) && ((zza) obj).zzc;
    }

    private final void zzw(StringBuilder sb) {
        try {
            Object objZzf = zzf(this);
            sb.append("SUCCESS, result=[");
            if (objZzf == null) {
                sb.append(jIKWv.mwM);
            } else if (objZzf == this) {
                sb.append("this future");
            } else {
                sb.append(objZzf.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzf)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return zzr(j, timeUnit);
    }

    public String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzw(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                ListenableFuture listenableFuture = ((zzb) obj).zzb;
                try {
                    if (listenableFuture == this) {
                        sb.append("this future");
                    } else {
                        sb.append(listenableFuture);
                    }
                } catch (Throwable th) {
                    zzgeg.zzb(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strConcat = zzfwg.zza(zza());
                } catch (Throwable th2) {
                    zzgeg.zzb(th2);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(th2.getClass()));
                }
                if (strConcat != null) {
                    sb.append(mnwSv.sAacRPgOesX);
                    sb.append(strConcat);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzw(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
