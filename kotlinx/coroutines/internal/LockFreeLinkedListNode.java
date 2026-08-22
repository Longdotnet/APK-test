package kotlinx.coroutines.internal;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public class LockFreeLinkedListNode {
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1 */
    public final /* synthetic */ class AnonymousClass1 extends CallableReference implements Function0, KCallable {
        public final boolean syntheticJavaProperty;

        public AnonymousClass1(LockFreeLinkedListNode lockFreeLinkedListNode) {
            super(lockFreeLinkedListNode, BuildersKt.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
            this.syntheticJavaProperty = false;
        }

        public final KCallable compute() {
            if (!this.syntheticJavaProperty) {
                KCallable kCallable = this.reflected;
                if (kCallable != null) {
                    return kCallable;
                }
                Reflection.factory.getClass();
                this.reflected = this;
            }
            return this;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AnonymousClass1) {
                AnonymousClass1 anonymousClass1 = (AnonymousClass1) obj;
                return getOwner().equals(anonymousClass1.getOwner()) && this.name.equals(anonymousClass1.name) && this.signature.equals(anonymousClass1.signature) && Intrinsics.areEqual(this.receiver, anonymousClass1.receiver);
            }
            if (obj instanceof AnonymousClass1) {
                return obj.equals(compute());
            }
            return false;
        }

        public final int hashCode() {
            return this.signature.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(getOwner().hashCode() * 31, 31, this.name);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.receiver.getClass().getSimpleName();
        }

        public final String toString() {
            KCallable kCallableCompute = compute();
            return kCallableCompute != this ? kCallableCompute.toString() : CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder("property "), this.name, " (Kotlin reflection is not available)");
        }
    }

    public final LockFreeLinkedListNode correctPrev() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _prev$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) atomicReferenceFieldUpdater2.get(this);
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = _next$FU;
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode2);
                    if (obj == this) {
                        if (lockFreeLinkedListNode == lockFreeLinkedListNode2) {
                            return lockFreeLinkedListNode2;
                        }
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            if (atomicReferenceFieldUpdater2.get(this) != lockFreeLinkedListNode) {
                                break;
                            }
                        }
                        return lockFreeLinkedListNode2;
                    }
                    if (isRemoved()) {
                        return null;
                    }
                    if (obj == null) {
                        return lockFreeLinkedListNode2;
                    }
                    if (obj instanceof OpDescriptor) {
                        ((OpDescriptor) obj).perform(lockFreeLinkedListNode2);
                        break;
                    }
                    if (!(obj instanceof Removed)) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                    } else {
                        if (lockFreeLinkedListNode3 != null) {
                            break;
                        }
                        lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode2);
                    }
                }
                LockFreeLinkedListNode lockFreeLinkedListNode4 = ((Removed) obj).ref;
                while (!atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode3, lockFreeLinkedListNode2, lockFreeLinkedListNode4)) {
                    if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode3) != lockFreeLinkedListNode2) {
                        break;
                    }
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    public final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                    if (isRemoved()) {
                        lockFreeLinkedListNode.correctPrev();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) == lockFreeLinkedListNode2);
        }
    }

    public final Object getNext() {
        while (true) {
            Object obj = _next$FU.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object next = getNext();
        Removed removed = next instanceof Removed ? (Removed) next : null;
        if (removed != null && (lockFreeLinkedListNode = removed.ref) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) next;
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public String toString() {
        return new AnonymousClass1(this) + '@' + BuildersKt.getHexAddress(this);
    }
}
