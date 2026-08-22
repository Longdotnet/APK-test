package androidx.work.impl.utils.futures;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractFuture implements ListenableFuture {
    public static final AsyncTimeout.Companion ATOMIC_HELPER;
    public static final Object NULL;
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    /* JADX INFO: loaded from: classes.dex */
    public final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final CancellationException cause;
        public final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(false, null);
                CAUSELESS_INTERRUPTED = new Cancellation(true, null);
            }
        }

        public Cancellation(boolean z, CancellationException cancellationException) {
            this.wasInterrupted = z;
            this.cause = cancellationException;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class Failure {
        public static final Failure FALLBACK_INSTANCE = new Failure(new AnonymousClass1("Failure occurred while trying to finish a future.", 0));
        public final Throwable exception;

        /* JADX INFO: renamed from: androidx.work.impl.utils.futures.AbstractFuture$Failure$1 */
        public final class AnonymousClass1 extends Throwable {
            public final /* synthetic */ int $r8$classId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ AnonymousClass1(String str, int i) {
                super(str);
                this.$r8$classId = i;
            }

            private final synchronized Throwable fillInStackTrace$androidx$concurrent$futures$AbstractResolvableFuture$Failure$1() {
                return this;
            }

            private final synchronized Throwable fillInStackTrace$androidx$concurrent$futures$CallbackToFutureAdapter$FutureGarbageCollectedException() {
                return this;
            }

            private final synchronized Throwable fillInStackTrace$androidx$work$impl$utils$futures$AbstractFuture$Failure$1() {
                return this;
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                switch (this.$r8$classId) {
                    case 0:
                        fillInStackTrace$androidx$work$impl$utils$futures$AbstractFuture$Failure$1();
                        break;
                    case 1:
                        fillInStackTrace$androidx$concurrent$futures$AbstractResolvableFuture$Failure$1();
                        break;
                    default:
                        fillInStackTrace$androidx$concurrent$futures$CallbackToFutureAdapter$FutureGarbageCollectedException();
                        break;
                }
                return this;
            }
        }

        public Failure(Throwable th) {
            boolean z = AbstractFuture.GENERATE_CANCELLATION_CAUSES;
            th.getClass();
            this.exception = th;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class Listener {
        public static final Listener TOMBSTONE = new Listener(null, null);
        public final Executor executor;
        public Listener next;
        public final Runnable task;

        public Listener(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SafeAtomicHelper extends AsyncTimeout.Companion {
        public final AtomicReferenceFieldUpdater listenersUpdater;
        public final AtomicReferenceFieldUpdater valueUpdater;
        public final AtomicReferenceFieldUpdater waiterNextUpdater;
        public final AtomicReferenceFieldUpdater waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // okio.AsyncTimeout.Companion
        public final boolean casListeners(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.listenersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == listener);
            return false;
        }

        @Override // okio.AsyncTimeout.Companion
        public final boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.valueUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == obj);
            return false;
        }

        @Override // okio.AsyncTimeout.Companion
        public final boolean casWaiters(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.waitersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == waiter);
            return false;
        }

        @Override // okio.AsyncTimeout.Companion
        public final void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // okio.AsyncTimeout.Companion
        public final void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SetFuture implements Runnable {
        public final ListenableFuture future;
        public final SettableFuture owner;

        public SetFuture(SettableFuture settableFuture, ListenableFuture listenableFuture) {
            this.owner = settableFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.owner.value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner);
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class SynchronizedHelper extends AsyncTimeout.Companion {
        @Override // okio.AsyncTimeout.Companion
        public final boolean casListeners(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.listeners != listener) {
                        return false;
                    }
                    abstractFuture.listeners = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.AsyncTimeout.Companion
        public final boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.value != obj) {
                        return false;
                    }
                    abstractFuture.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.AsyncTimeout.Companion
        public final boolean casWaiters(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.waiters != waiter) {
                        return false;
                    }
                    abstractFuture.waiters = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okio.AsyncTimeout.Companion
        public final void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override // okio.AsyncTimeout.Companion
        public final void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class Waiter {
        public static final Waiter TOMBSTONE = new Waiter();
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        AsyncTimeout.Companion synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, FirebaseAnalytics.Param.VALUE));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static void complete(AbstractFuture abstractFuture) {
        Listener listener;
        Listener listener2;
        Listener listener3 = null;
        while (true) {
            Waiter waiter = abstractFuture.waiters;
            if (ATOMIC_HELPER.casWaiters(abstractFuture, waiter, Waiter.TOMBSTONE)) {
                while (waiter != null) {
                    Thread thread = waiter.thread;
                    if (thread != null) {
                        waiter.thread = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.next;
                }
                do {
                    listener = abstractFuture.listeners;
                } while (!ATOMIC_HELPER.casListeners(abstractFuture, listener, Listener.TOMBSTONE));
                while (true) {
                    listener2 = listener3;
                    listener3 = listener;
                    if (listener3 == null) {
                        break;
                    }
                    listener = listener3.next;
                    listener3.next = listener2;
                }
                while (listener2 != null) {
                    listener3 = listener2.next;
                    Runnable runnable = listener2.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.owner;
                        if (abstractFuture.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, listener2.executor);
                    }
                    listener2 = listener3;
                }
                return;
            }
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object getDoneValue$1(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            CancellationException cancellationException = ((Cancellation) obj).cause;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public static Object getUninterruptibly(ListenableFuture listenableFuture) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = listenableFuture.get();
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

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        Listener listener = this.listeners;
        Listener listener2 = Listener.TOMBSTONE;
        if (listener != listener2) {
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.next = listener;
                if (ATOMIC_HELPER.casListeners(this, listener, listener3)) {
                    return;
                } else {
                    listener = this.listeners;
                }
            } while (listener != listener2);
        }
        executeListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
        } else {
            cancellation = z ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED;
        }
        AbstractFuture abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractFuture, obj, cancellation)) {
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).future;
                if (!(listenableFuture instanceof AbstractFuture)) {
                    listenableFuture.cancel(z);
                    return true;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8 A[EDGE_INSN: B:56:0x00a8->B:36:0x0074 BREAK  A[LOOP:0: B:21:0x0041->B:86:?]] */
    /* JADX WARN: Code duplicated, block: B:59:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0100  */
    /* JADX WARN: Code duplicated, block: B:67:0x0108  */
    /* JADX WARN: Code duplicated, block: B:69:0x010c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0123  */
    /* JADX WARN: Code duplicated, block: B:74:0x012f  */
    /* JADX WARN: Code duplicated, block: B:78:0x014f  */
    /* JADX WARN: Code duplicated, block: B:80:0x015b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00a8 -> B:36:0x0074). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // java.util.concurrent.Future
    public final java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            ListenableFuture listenableFuture = ((SetFuture) obj).future;
            return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, listenableFuture == this ? "this future" : String.valueOf(listenableFuture), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 == Waiter.TOMBSTONE) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.next;
                if (waiter2.thread != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.next = waiter4;
                    if (waiter3.thread == null) {
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    public final String toString() {
        String strPendingToString;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.value instanceof Cancellation) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString$1(sb);
        } else {
            try {
                strPendingToString = pendingToString();
            } catch (RuntimeException e) {
                strPendingToString = "Exception thrown from implementation: " + e.getClass();
            }
            if (strPendingToString != null && !strPendingToString.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strPendingToString);
                sb.append("]");
            } else if (isDone()) {
                addDoneString$1(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static Object getFutureValue(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).value;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (cancellation.wasInterrupted) {
                return cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED;
            }
            return obj;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return Cancellation.CAUSELESS_CANCELLED;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (CancellationException e) {
            if (zIsCancelled) {
                return new Cancellation(false, e);
            }
            return new Failure(new IllegalArgumentException(FKidOcdAYt.CMSLdWqwpFiv + listenableFuture, e));
        } catch (ExecutionException e2) {
            return new Failure(e2.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    public final void addDoneString$1(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(uninterruptibly == this ? dLDI.bMtPzmmzlMkvTr : String.valueOf(uninterruptibly));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append(ehgOP.UmVMyfC);
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return getDoneValue$1(obj2);
            }
            Waiter waiter = this.waiters;
            Waiter waiter2 = Waiter.TOMBSTONE;
            if (waiter != waiter2) {
                Waiter waiter3 = new Waiter();
                do {
                    AsyncTimeout.Companion companion = ATOMIC_HELPER;
                    companion.putNext(waiter3, waiter);
                    if (companion.casWaiters(this, waiter, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue$1(obj);
                    }
                    waiter = this.waiters;
                } while (waiter != waiter2);
            }
            return getDoneValue$1(this.value);
        }
        throw new InterruptedException();
    }
}
