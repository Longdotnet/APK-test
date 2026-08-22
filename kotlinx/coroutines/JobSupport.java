package kotlinx.coroutines;

import androidx.startup.StartupException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes3.dex */
public class JobSupport implements Job, ParentJob {
    private volatile Object _parentHandle;
    private volatile Object _state;
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    public final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting = 0;
        private volatile Object _rootCause;
        public final NodeList list;
        public static final AtomicIntegerFieldUpdater _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
        public static final AtomicReferenceFieldUpdater _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
        public static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");

        public Finishing(NodeList nodeList, Throwable th) {
            this.list = nodeList;
            this._rootCause = th;
        }

        public final void addExceptionLocked(Throwable th) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                _rootCause$FU.set(this, th);
                return;
            }
            if (th == rootCause) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$FU.get(this);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final boolean isCompleting() {
            return _isCompleting$FU.get(this) != 0;
        }

        public final ArrayList sealLocked(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th != null && !th.equals(rootCause)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, BuildersKt.SEALED);
            return arrayList;
        }

        public final String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + _exceptionsHolder$FU.get(this) + ", list=" + this.list + ']';
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? BuildersKt.EMPTY_ACTIVE : BuildersKt.EMPTY_NEW;
    }

    public static ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev = lockFreeLinkedListNode.correctPrev();
            if (lockFreeLinkedListNodeCorrectPrev == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._prev$FU;
                Object obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                while (true) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNode.isRemoved()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                }
            } else {
                lockFreeLinkedListNode = lockFreeLinkedListNodeCorrectPrev;
            }
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String stateString(Object obj) {
        if (!(obj instanceof Finishing)) {
            if (obj instanceof Incomplete) {
                return ((Incomplete) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) obj;
        if (finishing.isCancelling()) {
            return "Cancelling";
        }
        return finishing.isCompleting() ? "Completing" : "Active";
    }

    public final boolean addLastAtomic(Incomplete incomplete, NodeList nodeList, JobNode jobNode) {
        char c;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, this, incomplete);
        do {
            LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev = nodeList.correctPrev();
            if (lockFreeLinkedListNodeCorrectPrev == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._prev$FU;
                Object obj = atomicReferenceFieldUpdater.get(nodeList);
                while (true) {
                    lockFreeLinkedListNodeCorrectPrev = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNodeCorrectPrev.isRemoved()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNodeCorrectPrev);
                }
            }
            LockFreeLinkedListNode._prev$FU.lazySet(jobNode, lockFreeLinkedListNodeCorrectPrev);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$FU;
            atomicReferenceFieldUpdater2.lazySet(jobNode, nodeList);
            jobSupport$addLastAtomic$$inlined$addLastIf$1.oldNext = nodeList;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(lockFreeLinkedListNodeCorrectPrev, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1)) {
                    if (jobSupport$addLastAtomic$$inlined$addLastIf$1.perform(lockFreeLinkedListNodeCorrectPrev) != null) {
                        c = 2;
                        break;
                    }
                    c = 1;
                    break;
                }
                if (atomicReferenceFieldUpdater2.get(lockFreeLinkedListNodeCorrectPrev) != nodeList) {
                    c = 0;
                    break;
                }
            }
            if (c == 1) {
                return true;
            }
        } while (c != 2);
        return false;
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        Symbol symbol;
        Object objTryMakeCompleting = BuildersKt.COMPLETING_ALREADY;
        if (this instanceof JobImpl) {
            do {
                Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                    objTryMakeCompleting = BuildersKt.COMPLETING_ALREADY;
                    break;
                }
                objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(false, createCauseException(obj)));
            } while (objTryMakeCompleting == BuildersKt.COMPLETING_RETRY);
            if (objTryMakeCompleting == BuildersKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        }
        if (objTryMakeCompleting == BuildersKt.COMPLETING_ALREADY) {
            Throwable thCreateCauseException = null;
            loop1: while (true) {
                Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                if (state$kotlinx_coroutines_core2 instanceof Finishing) {
                    synchronized (state$kotlinx_coroutines_core2) {
                        try {
                            Finishing finishing = (Finishing) state$kotlinx_coroutines_core2;
                            finishing.getClass();
                            if (Finishing._exceptionsHolder$FU.get(finishing) == BuildersKt.SEALED) {
                                symbol = BuildersKt.TOO_LATE_TO_CANCEL;
                            } else {
                                boolean zIsCancelling = ((Finishing) state$kotlinx_coroutines_core2).isCancelling();
                                if (thCreateCauseException == null) {
                                    thCreateCauseException = createCauseException(obj);
                                }
                                ((Finishing) state$kotlinx_coroutines_core2).addExceptionLocked(thCreateCauseException);
                                Throwable rootCause = zIsCancelling ? null : ((Finishing) state$kotlinx_coroutines_core2).getRootCause();
                                if (rootCause != null) {
                                    notifyCancelling(((Finishing) state$kotlinx_coroutines_core2).list, rootCause);
                                }
                                symbol = BuildersKt.COMPLETING_ALREADY;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } else if (state$kotlinx_coroutines_core2 instanceof Incomplete) {
                    if (thCreateCauseException == null) {
                        thCreateCauseException = createCauseException(obj);
                    }
                    Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core2;
                    if (incomplete.isActive()) {
                        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                        if (orPromoteCancellingList == null) {
                            continue;
                        } else {
                            Finishing finishing2 = new Finishing(orPromoteCancellingList, thCreateCauseException);
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                                if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, finishing2)) {
                                    notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                    symbol = BuildersKt.COMPLETING_ALREADY;
                                } else if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                                }
                            }
                        }
                    } else {
                        Object objTryMakeCompleting2 = tryMakeCompleting(state$kotlinx_coroutines_core2, new CompletedExceptionally(false, thCreateCauseException));
                        if (objTryMakeCompleting2 == BuildersKt.COMPLETING_ALREADY) {
                            throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core2).toString());
                        }
                        if (objTryMakeCompleting2 != BuildersKt.COMPLETING_RETRY) {
                            objTryMakeCompleting = objTryMakeCompleting2;
                            break;
                        }
                    }
                } else {
                    symbol = BuildersKt.TOO_LATE_TO_CANCEL;
                }
                objTryMakeCompleting = symbol;
                break;
            }
        }
        return objTryMakeCompleting == BuildersKt.COMPLETING_ALREADY || objTryMakeCompleting == BuildersKt.COMPLETING_WAITING_CHILDREN || objTryMakeCompleting != BuildersKt.TOO_LATE_TO_CANCEL;
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public final void completeStateFinalization(Incomplete incomplete, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
        }
        StartupException startupException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new StartupException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            Object next = list.getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !nextNode.equals(list); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) nextNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th3) {
                        if (startupException != null) {
                            ExceptionsKt.addSuppressed(startupException, th3);
                        } else {
                            startupException = new StartupException("Exception in completion handler " + jobNode + " for " + this, th3);
                        }
                    }
                }
            }
            if (startupException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(startupException);
            }
        }
    }

    public final Throwable createCauseException(Object obj) {
        Throwable rootCause;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        JobSupport jobSupport = (JobSupport) ((ParentJob) obj);
        Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            rootCause = null;
        }
        CancellationException jobCancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        if (jobCancellationException == null) {
            jobCancellationException = new JobCancellationException("Parent job is ".concat(stateString(state$kotlinx_coroutines_core)), rootCause, jobSupport);
        }
        return jobCancellationException;
    }

    public final Object finalizeFinishingState(Finishing finishing, Object obj) {
        Object obj2 = null;
        Throwable jobCancellationException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (finishing) {
            finishing.isCancelling();
            ArrayList<Throwable> arrayListSealLocked = finishing.sealLocked(th);
            if (!arrayListSealLocked.isEmpty()) {
                for (Object obj3 : arrayListSealLocked) {
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                jobCancellationException = (Throwable) obj2;
                if (jobCancellationException == null) {
                    jobCancellationException = (Throwable) arrayListSealLocked.get(0);
                }
            } else if (finishing.isCancelling()) {
                jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            if (jobCancellationException != null && arrayListSealLocked.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListSealLocked.size()));
                for (Throwable th2 : arrayListSealLocked) {
                    if (th2 != jobCancellationException && th2 != jobCancellationException && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        ExceptionsKt.addSuppressed(jobCancellationException, th2);
                    }
                }
            }
        }
        if (jobCancellationException != null && jobCancellationException != th) {
            obj = new CompletedExceptionally(false, jobCancellationException);
        }
        if (jobCancellationException != null) {
            boolean z = jobCancellationException instanceof CancellationException;
            ChildHandle childHandle = (ChildHandle) _parentHandle$FU.get(this);
            if (childHandle != null && childHandle != NonDisposableHandle.INSTANCE) {
                z = childHandle.childCancelled(jobCancellationException) || z;
            }
            if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                CompletedExceptionally._handled$FU.compareAndSet((CompletedExceptionally) obj, 0, 1);
            }
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        Object incompleteStateBox = obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, finishing, incompleteStateBox) && atomicReferenceFieldUpdater.get(this) == finishing) {
        }
        completeStateFinalization(finishing, obj);
        return obj;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return MediaType.Companion.get(this, key);
    }

    public final CancellationException getCancellationException() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Finishing)) {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new JobCancellationException(cancellationExceptionMessage(), th, this) : cancellationException;
        }
        Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        if (rootCause == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = cancellationExceptionMessage();
        }
        return new JobCancellationException(strConcat, rootCause, this);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.$$INSTANCE;
    }

    public final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = _state$FU.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final void initParentJob(Job job) {
        byte b;
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$FU;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
            return;
        }
        JobSupport jobSupport = (JobSupport) job;
        do {
            Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
            boolean z = state$kotlinx_coroutines_core instanceof Empty;
            b = 0;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
            if (z) {
                if (!((Empty) state$kotlinx_coroutines_core).isActive) {
                    Empty empty = BuildersKt.EMPTY_ACTIVE;
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(jobSupport, state$kotlinx_coroutines_core, empty)) {
                            jobSupport.getClass();
                            b = 1;
                        } else if (atomicReferenceFieldUpdater2.get(jobSupport) != state$kotlinx_coroutines_core) {
                            b = -1;
                        }
                    }
                }
            } else if (state$kotlinx_coroutines_core instanceof InactiveNodeList) {
                NodeList nodeList = ((InactiveNodeList) state$kotlinx_coroutines_core).list;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(jobSupport, state$kotlinx_coroutines_core, nodeList)) {
                        jobSupport.getClass();
                        b = 1;
                    } else if (atomicReferenceFieldUpdater2.get(jobSupport) != state$kotlinx_coroutines_core) {
                        b = -1;
                    }
                }
            }
            if (b == 0) {
                break;
            }
        } while (b != 1);
        ChildHandle childHandle = (ChildHandle) BuildersKt.invokeOnCompletion$default(jobSupport, true, new ChildHandleNode(this), 2);
        atomicReferenceFieldUpdater.set(this, childHandle);
        if (getState$kotlinx_coroutines_core() instanceof Incomplete) {
            return;
        }
        childHandle.dispose();
        atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x00be  */
    /* JADX WARN: Code duplicated, block: B:97:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x00c6 A[SYNTHETIC] */
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1 function1) {
        JobNode invokeOnCompletion;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable rootCause;
        if (z) {
            invokeOnCompletion = function1 instanceof JobCancellingNode ? (JobCancellingNode) function1 : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCancelling(function1);
            }
        } else {
            invokeOnCompletion = function1 instanceof JobNode ? (JobNode) function1 : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCompletion(function1);
            }
        }
        invokeOnCompletion.job = this;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, state$kotlinx_coroutines_core, invokeOnCompletion)) {
                        if (atomicReferenceFieldUpdater2.get(this) != state$kotlinx_coroutines_core) {
                        }
                    }
                    return invokeOnCompletion;
                }
                NodeList nodeList = new NodeList();
                Incomplete inactiveNodeList = empty.isActive ? nodeList : new InactiveNodeList(nodeList);
                do {
                    atomicReferenceFieldUpdater = _state$FU;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, empty, inactiveNodeList)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == empty);
            } else {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (z2) {
                        CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core : null;
                        function1.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    }
                    return NonDisposableHandle.INSTANCE;
                }
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list == null) {
                    Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    DisposableHandle disposableHandle = NonDisposableHandle.INSTANCE;
                    if (z && (state$kotlinx_coroutines_core instanceof Finishing)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            try {
                                rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                if (rootCause == null || ((function1 instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                                    if (addLastAtomic((Incomplete) state$kotlinx_coroutines_core, list, invokeOnCompletion)) {
                                        if (rootCause == null) {
                                            return invokeOnCompletion;
                                        }
                                        disposableHandle = invokeOnCompletion;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (rootCause != null) {
                            if (z2) {
                                function1.invoke(rootCause);
                            }
                            return disposableHandle;
                        }
                        if (addLastAtomic((Incomplete) state$kotlinx_coroutines_core, list, invokeOnCompletion)) {
                            return invokeOnCompletion;
                        }
                    } else {
                        rootCause = null;
                        if (rootCause != null) {
                            if (z2) {
                                function1.invoke(rootCause);
                            }
                            return disposableHandle;
                        }
                        if (addLastAtomic((Incomplete) state$kotlinx_coroutines_core, list, invokeOnCompletion)) {
                            return invokeOnCompletion;
                        }
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return MediaType.Companion.minusKey(this, key);
    }

    public final void notifyCancelling(NodeList nodeList, Throwable th) {
        Object next = nodeList.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        StartupException startupException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !nextNode.equals(nodeList); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) nextNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th2) {
                    if (startupException != null) {
                        ExceptionsKt.addSuppressed(startupException, th2);
                    } else {
                        startupException = new StartupException("Exception in completion handler " + jobNode + " for " + this, th2);
                    }
                }
            }
        }
        if (startupException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(startupException);
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) _parentHandle$FU.get(this);
        if (childHandle == null || childHandle == NonDisposableHandle.INSTANCE) {
            return;
        }
        childHandle.childCancelled(th);
    }

    public void onCompletionInternal(Object obj) {
    }

    public void onStart() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return MediaType.Companion.plus(this, coroutineContext);
    }

    public final void promoteSingleToNodeList(JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NodeList nodeList = new NodeList();
        jobNode.getClass();
        LockFreeLinkedListNode._prev$FU.lazySet(nodeList, jobNode);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$FU;
        atomicReferenceFieldUpdater2.lazySet(nodeList, jobNode);
        loop0: while (jobNode.getNext() == jobNode) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(jobNode, jobNode, nodeList)) {
                    nodeList.finishAdd(jobNode);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(jobNode) == jobNode);
        }
        LockFreeLinkedListNode nextNode = jobNode.getNextNode();
        do {
            atomicReferenceFieldUpdater = _state$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, nextNode)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == jobNode);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}');
        sb.append('@');
        sb.append(BuildersKt.getHexAddress(this));
        return sb.toString();
    }

    public final Object tryMakeCompleting(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof Incomplete)) {
            return BuildersKt.COMPLETING_ALREADY;
        }
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            Object incompleteStateBox = obj2 instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = _state$FU;
                if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, incompleteStateBox)) {
                    onCompletionInternal(obj2);
                    completeStateFinalization(incomplete, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == incomplete);
            return BuildersKt.COMPLETING_RETRY;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete2);
        if (orPromoteCancellingList == null) {
            return BuildersKt.COMPLETING_RETRY;
        }
        ChildHandleNode childHandleNodeNextChild = null;
        Finishing finishing = incomplete2 instanceof Finishing ? (Finishing) incomplete2 : null;
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, null);
        }
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                return BuildersKt.COMPLETING_ALREADY;
            }
            Finishing._isCompleting$FU.set(finishing, 1);
            if (finishing != incomplete2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, finishing)) {
                    if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                        return BuildersKt.COMPLETING_RETRY;
                    }
                }
            }
            boolean zIsCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            Throwable rootCause = finishing.getRootCause();
            if (zIsCancelling) {
                rootCause = null;
            }
            if (rootCause != null) {
                notifyCancelling(orPromoteCancellingList, rootCause);
            }
            ChildHandleNode childHandleNode = incomplete2 instanceof ChildHandleNode ? (ChildHandleNode) incomplete2 : null;
            if (childHandleNode == null) {
                NodeList list = incomplete2.getList();
                if (list != null) {
                    childHandleNodeNextChild = nextChild(list);
                }
            } else {
                childHandleNodeNextChild = childHandleNode;
            }
            if (childHandleNodeNextChild != null) {
                while (BuildersKt.invokeOnCompletion$default(childHandleNodeNextChild.childJob, false, new ChildCompletion(this, finishing, childHandleNodeNextChild, obj2), 1) == NonDisposableHandle.INSTANCE) {
                    childHandleNodeNextChild = nextChild(childHandleNodeNextChild);
                    if (childHandleNodeNextChild == null) {
                    }
                }
                return BuildersKt.COMPLETING_WAITING_CHILDREN;
            }
            return finalizeFinishingState(finishing, obj2);
        }
    }

    public final class ChildCompletion extends JobNode {
        public final ChildHandleNode child;
        public final JobSupport parent;
        public final Object proposedUpdate;
        public final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void invoke(Throwable th) {
            ChildHandleNode childHandleNode = this.child;
            JobSupport jobSupport = this.parent;
            jobSupport.getClass();
            ChildHandleNode childHandleNodeNextChild = JobSupport.nextChild(childHandleNode);
            Finishing finishing = this.state;
            Object obj = this.proposedUpdate;
            if (childHandleNodeNextChild != null) {
                while (BuildersKt.invokeOnCompletion$default(childHandleNodeNextChild.childJob, false, new ChildCompletion(jobSupport, finishing, childHandleNodeNextChild, obj), 1) == NonDisposableHandle.INSTANCE) {
                    childHandleNodeNextChild = JobSupport.nextChild(childHandleNodeNextChild);
                    if (childHandleNodeNextChild == null) {
                    }
                }
                return;
            }
            jobSupport.finalizeFinishingState(finishing, obj);
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(StartupException startupException) {
        throw startupException;
    }
}
