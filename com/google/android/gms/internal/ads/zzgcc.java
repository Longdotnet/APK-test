package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.coroutines.internal.Jbo.ygoi;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
abstract class zzgcc<V> extends zzger implements ListenableFuture {
    private static final zza zzbi;
    static final Object zze = new Object();
    static final zzgdw zzf = new zzgdw(zzgcb.class);
    static final boolean zzg;
    volatile zzgcb.zzd listenersField;
    volatile Object valueField;
    volatile zze waitersField;

    /* JADX INFO: loaded from: classes.dex */
    abstract class zza {
        public /* synthetic */ zza(zzgcg zzgcgVar) {
        }

        public abstract zzgcb.zzd zza(zzgcc zzgccVar, zzgcb.zzd zzdVar);

        public abstract zze zzb(zzgcc zzgccVar, zze zzeVar);

        public abstract void zzc(zze zzeVar, zze zzeVar2);

        public abstract void zzd(zze zzeVar, Thread thread);

        public abstract boolean zze(zzgcc zzgccVar, zzgcb.zzd zzdVar, zzgcb.zzd zzdVar2);

        public abstract boolean zzf(zzgcc zzgccVar, Object obj, Object obj2);

        public abstract boolean zzg(zzgcc zzgccVar, zze zzeVar, zze zzeVar2);
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zzb extends zza {
        private static final AtomicReferenceFieldUpdater<zze, Thread> zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, "thread");
        private static final AtomicReferenceFieldUpdater<zze, zze> zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, "next");
        private static final AtomicReferenceFieldUpdater<? super zzgcc<?>, zze> zzc = AtomicReferenceFieldUpdater.newUpdater(zzgcc.class, zze.class, "waitersField");
        private static final AtomicReferenceFieldUpdater<? super zzgcc<?>, zzgcb.zzd> zzd = AtomicReferenceFieldUpdater.newUpdater(zzgcc.class, zzgcb.zzd.class, "listenersField");
        private static final AtomicReferenceFieldUpdater<? super zzgcc<?>, Object> zze = AtomicReferenceFieldUpdater.newUpdater(zzgcc.class, Object.class, "valueField");

        private zzb() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final zzgcb.zzd zza(zzgcc zzgccVar, zzgcb.zzd zzdVar) {
            return zzd.getAndSet(zzgccVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final zze zzb(zzgcc zzgccVar, zze zzeVar) {
            return zzc.getAndSet(zzgccVar, zzeVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final void zzc(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final void zzd(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zze(zzgcc zzgccVar, zzgcb.zzd zzdVar, zzgcb.zzd zzdVar2) {
            return zzgcd.zza(zzd, zzgccVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zzf(zzgcc zzgccVar, Object obj, Object obj2) {
            return zzgcd.zza(zze, zzgccVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zzg(zzgcc zzgccVar, zze zzeVar, zze zzeVar2) {
            return zzgcd.zza(zzc, zzgccVar, zzeVar, zzeVar2);
        }

        public /* synthetic */ zzb(zzgcg zzgcgVar) {
            super(null);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zzc extends zza {
        private zzc() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final zzgcb.zzd zza(zzgcc zzgccVar, zzgcb.zzd zzdVar) {
            zzgcb.zzd zzdVar2;
            synchronized (zzgccVar) {
                try {
                    zzdVar2 = zzgccVar.listenersField;
                    if (zzdVar2 != zzdVar) {
                        zzgccVar.listenersField = zzdVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final zze zzb(zzgcc zzgccVar, zze zzeVar) {
            zze zzeVar2;
            synchronized (zzgccVar) {
                try {
                    zzeVar2 = zzgccVar.waitersField;
                    if (zzeVar2 != zzeVar) {
                        zzgccVar.waitersField = zzeVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final void zzc(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final void zzd(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zze(zzgcc zzgccVar, zzgcb.zzd zzdVar, zzgcb.zzd zzdVar2) {
            synchronized (zzgccVar) {
                try {
                    if (zzgccVar.listenersField != zzdVar) {
                        return false;
                    }
                    zzgccVar.listenersField = zzdVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zzf(zzgcc zzgccVar, Object obj, Object obj2) {
            synchronized (zzgccVar) {
                try {
                    if (zzgccVar.valueField != obj) {
                        return false;
                    }
                    zzgccVar.valueField = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zzg(zzgcc zzgccVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzgccVar) {
                try {
                    if (zzgccVar.waitersField != zzeVar) {
                        return false;
                    }
                    zzgccVar.waitersField = zzeVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ zzc(zzgcg zzgcgVar) {
            super(null);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zzd extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;
        public static final /* synthetic */ int zzg = 0;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.android.gms.internal.ads.zzgcf
                        @Override // java.security.PrivilegedExceptionAction
                        public final Object run() throws IllegalAccessException {
                            int i = zzgcc.zzd.zzg;
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzgcc.class.getDeclaredField("waitersField"));
                    zzb = unsafe.objectFieldOffset(zzgcc.class.getDeclaredField("listenersField"));
                    zzd = unsafe.objectFieldOffset(zzgcc.class.getDeclaredField("valueField"));
                    zze = unsafe.objectFieldOffset(zze.class.getDeclaredField("thread"));
                    zzf = unsafe.objectFieldOffset(zze.class.getDeclaredField("next"));
                    zza = unsafe;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }

        private zzd() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final zzgcb.zzd zza(zzgcc zzgccVar, zzgcb.zzd zzdVar) {
            zzgcb.zzd zzdVar2;
            do {
                zzdVar2 = zzgccVar.listenersField;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzgccVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final zze zzb(zzgcc zzgccVar, zze zzeVar) {
            zze zzeVar2;
            do {
                zzeVar2 = zzgccVar.waitersField;
                if (zzeVar == zzeVar2) {
                    break;
                }
            } while (!zzg(zzgccVar, zzeVar2, zzeVar));
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final void zzc(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final void zzd(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zze(zzgcc zzgccVar, zzgcb.zzd zzdVar, zzgcb.zzd zzdVar2) {
            return zzgce.zza(zza, zzgccVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zzf(zzgcc zzgccVar, Object obj, Object obj2) {
            return zzgce.zza(zza, zzgccVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgcc.zza
        public final boolean zzg(zzgcc zzgccVar, zze zzeVar, zze zzeVar2) {
            return zzgce.zza(zza, zzgccVar, zzc, zzeVar, zzeVar2);
        }

        public /* synthetic */ zzd(zzgcg zzgcgVar) {
            super(null);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    final class zze {
        static final zze zza = new zze(false);
        volatile zze next;
        volatile Thread thread;

        public zze(boolean z) {
        }

        public zze() {
            zzgcc.zzs(this, Thread.currentThread());
        }
    }

    private final void zza(zze zzeVar) {
        zzeVar.thread = null;
        while (true) {
            zze zzeVar2 = this.waitersField;
            if (zzeVar2 != zze.zza) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.next;
                    if (zzeVar2.thread != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.next = zzeVar4;
                        if (zzeVar3.thread == null) {
                        }
                    } else if (!zzbi.zzg(this, zzeVar2, zzeVar4)) {
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }

    public static /* synthetic */ void zzs(zze zzeVar, Thread thread) {
        zzbi.zzd(zzeVar, thread);
    }

    public static boolean zzv(zzgcc zzgccVar, Object obj, Object obj2) {
        return zzbi.zzf(zzgccVar, obj, obj2);
    }

    public abstract /* synthetic */ void addListener(Runnable runnable, Executor executor);

    public final zzgcb.zzd zzp(zzgcb.zzd zzdVar) {
        return zzbi.zza(this, zzdVar);
    }

    public final Object zzq() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) && zzgcb.zzm(obj2)) {
            return zzgcb.zzh(obj2);
        }
        zze zzeVar = this.waitersField;
        if (zzeVar != zze.zza) {
            zze zzeVar2 = new zze();
            do {
                zza zzaVar = zzbi;
                zzaVar.zzc(zzeVar2, zzeVar);
                if (zzaVar.zzg(this, zzeVar, zzeVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzeVar2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & zzgcb.zzm(obj)));
                    return zzgcb.zzh(obj);
                }
                zzeVar = this.waitersField;
            } while (zzeVar != zze.zza);
        }
        Object obj3 = this.valueField;
        Objects.requireNonNull(obj3);
        return zzgcb.zzh(obj3);
    }

    public final void zzt() {
        for (zze zzeVarZzb = zzbi.zzb(this, zze.zza); zzeVarZzb != null; zzeVarZzb = zzeVarZzb.next) {
            Thread thread = zzeVarZzb.thread;
            if (thread != null) {
                zzeVarZzb.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    public final boolean zzu(zzgcb.zzd zzdVar, zzgcb.zzd zzdVar2) {
        return zzbi.zze(this, zzdVar, zzdVar2);
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzcVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", ehgOP.EsUoQMNFe));
        } catch (SecurityException unused) {
            z = false;
        }
        zzg = z;
        String property = System.getProperty("java.runtime.name", "");
        if (property == null || property.contains("Android")) {
            try {
                zzcVar = new zzd(null);
            } catch (Error | Exception e) {
                try {
                    th = e;
                    th2 = null;
                    zzcVar = new zzb(null);
                } catch (Error | Exception e2) {
                    th = e;
                    th2 = e2;
                    zzcVar = new zzc(null);
                }
            }
        } else {
            try {
                zzcVar = new zzb(null);
            } catch (NoClassDefFoundError unused2) {
                zzcVar = new zzc(null);
            }
        }
        th2 = null;
        th = null;
        zzbi = zzcVar;
        if (th2 != null) {
            zzgdw zzgdwVar = zzf;
            Logger loggerZza = zzgdwVar.zza();
            Level level = Level.SEVERE;
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", oKjScaD.FwpDOPcjKMmsbeA, th);
            zzgdwVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th2);
        }
    }

    public final Object zzr(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        boolean z = true;
        if ((obj != null) && zzgcb.zzm(obj)) {
            return zzgcb.zzh(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zze zzeVar = this.waitersField;
            if (zzeVar != zze.zza) {
                zze zzeVar2 = new zze();
                while (true) {
                    zza zzaVar = zzbi;
                    zzaVar.zzc(zzeVar2, zzeVar);
                    if (zzaVar.zzg(this, zzeVar, zzeVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzeVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && zzgcb.zzm(obj2)) {
                                return zzgcb.zzh(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzeVar2);
                        break;
                    }
                    zzeVar = this.waitersField;
                    if (zzeVar == zze.zza) {
                    }
                }
            }
            Object obj3 = this.valueField;
            Objects.requireNonNull(obj3);
            return zzgcb.zzh(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.valueField;
            if ((obj4 != null) && zzgcb.zzm(obj4)) {
                return zzgcb.zzh(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            if (jConvert != 0 && nanos2 <= 1000) {
                z = false;
            }
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                if (z) {
                    strConcat3 = strConcat3.concat(",");
                }
                strConcat2 = strConcat3.concat(" ");
            }
            if (z) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(ygoi.dqSpiFGnVfujmuF));
        }
        throw new TimeoutException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strConcat, " for ", string));
    }
}
