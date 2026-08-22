package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes3.dex */
public final class NodeList extends LockFreeLinkedListNode implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return this;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean isRemoved() {
        return false;
    }
}
