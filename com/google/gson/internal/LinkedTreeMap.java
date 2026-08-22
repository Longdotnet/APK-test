package com.google.gson.internal;

import com.google.android.gms.location.zzn;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes3.dex */
public final class LinkedTreeMap extends AbstractMap implements Serializable {
    public static final zzn NATURAL_ORDER = new zzn(3);
    public final Comparator comparator;
    public KeySet entrySet;
    public final Node header;
    public KeySet keySet;
    public int modCount;
    public Node root;
    public int size;

    public final class KeySet extends AbstractSet {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ LinkedTreeMap this$0;

        /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$KeySet$1, reason: invalid class name */
        public final class AnonymousClass1 implements Iterator {
            public final /* synthetic */ int $r8$classId;
            public int expectedModCount;
            public Node lastReturned = null;
            public Node next;
            public final /* synthetic */ LinkedTreeMap this$0;

            public AnonymousClass1(LinkedTreeMap linkedTreeMap, int i) {
                this.$r8$classId = i;
                this.this$0 = linkedTreeMap;
                this.next = linkedTreeMap.header.next;
                this.expectedModCount = linkedTreeMap.modCount;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.next != this.this$0.header;
            }

            @Override // java.util.Iterator
            public Object next() {
                switch (this.$r8$classId) {
                    case 0:
                        return nextNode().key;
                    default:
                        return next$com$google$gson$internal$LinkedTreeMap$LinkedTreeMapIterator();
                }
            }

            public final Object next$com$google$gson$internal$LinkedTreeMap$LinkedTreeMapIterator() {
                return nextNode();
            }

            public final Node nextNode() {
                Node node = this.next;
                LinkedTreeMap linkedTreeMap = this.this$0;
                if (node == linkedTreeMap.header) {
                    throw new NoSuchElementException();
                }
                if (linkedTreeMap.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                this.next = node.next;
                this.lastReturned = node;
                return node;
            }

            @Override // java.util.Iterator
            public final void remove() {
                Node node = this.lastReturned;
                if (node == null) {
                    throw new IllegalStateException();
                }
                LinkedTreeMap linkedTreeMap = this.this$0;
                linkedTreeMap.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = linkedTreeMap.modCount;
            }
        }

        public /* synthetic */ KeySet(LinkedTreeMap linkedTreeMap, int i) {
            this.$r8$classId = i;
            this.this$0 = linkedTreeMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            switch (this.$r8$classId) {
                case 0:
                    this.this$0.clear();
                    break;
                default:
                    this.this$0.clear();
                    break;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Node nodeFind;
            Object obj2;
            Object value;
            switch (this.$r8$classId) {
                case 0:
                    return this.this$0.containsKey(obj);
                default:
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    LinkedTreeMap linkedTreeMap = this.this$0;
                    linkedTreeMap.getClass();
                    Object key = entry.getKey();
                    Node node = null;
                    if (key != null) {
                        try {
                            nodeFind = linkedTreeMap.find(key, false);
                        } catch (ClassCastException unused) {
                            nodeFind = null;
                        }
                        break;
                    } else {
                        nodeFind = null;
                    }
                    if (nodeFind != null && ((obj2 = nodeFind.value) == (value = entry.getValue()) || (obj2 != null && obj2.equals(value)))) {
                        node = nodeFind;
                    }
                    return node != null;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1(this.this$0, 0);
                default:
                    return new AnonymousClass1(this.this$0, 1);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Node nodeFind;
            Object obj2;
            Object value;
            switch (this.$r8$classId) {
                case 0:
                    LinkedTreeMap linkedTreeMap = this.this$0;
                    linkedTreeMap.getClass();
                    Node nodeFind2 = null;
                    if (obj != null) {
                        try {
                            nodeFind2 = linkedTreeMap.find(obj, false);
                            break;
                        } catch (ClassCastException unused) {
                        }
                    }
                    if (nodeFind2 != null) {
                        linkedTreeMap.removeInternal(nodeFind2, true);
                    }
                    return nodeFind2 != null;
                default:
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    LinkedTreeMap linkedTreeMap2 = this.this$0;
                    linkedTreeMap2.getClass();
                    Object key = entry.getKey();
                    Node node = null;
                    if (key != null) {
                        try {
                            nodeFind = linkedTreeMap2.find(key, false);
                        } catch (ClassCastException unused2) {
                            nodeFind = null;
                        }
                        break;
                    } else {
                        nodeFind = null;
                    }
                    if (nodeFind != null && ((obj2 = nodeFind.value) == (value = entry.getValue()) || (obj2 != null && obj2.equals(value)))) {
                        node = nodeFind;
                    }
                    if (node == null) {
                        return false;
                    }
                    linkedTreeMap2.removeInternal(node, true);
                    return true;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return this.this$0.size;
        }
    }

    public LinkedTreeMap() {
        zzn zznVar = NATURAL_ORDER;
        this.size = 0;
        this.modCount = 0;
        this.header = new Node();
        this.comparator = zznVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node node = this.header;
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Node nodeFind = null;
        if (obj != null) {
            try {
                nodeFind = find(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return nodeFind != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        KeySet keySet = this.entrySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet(this, 1);
        this.entrySet = keySet2;
        return keySet2;
    }

    public final Node find(Object obj, boolean z) {
        int iCompareTo;
        Node node;
        Node node2 = this.root;
        zzn zznVar = NATURAL_ORDER;
        Comparator comparator = this.comparator;
        if (node2 != null) {
            Comparable comparable = comparator == zznVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = node2.key;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return node2;
                }
                Node node3 = iCompareTo < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        Node node4 = this.header;
        if (node2 != null) {
            node = new Node(node2, obj, node4, node4.prev);
            if (iCompareTo < 0) {
                node2.left = node;
            } else {
                node2.right = node;
            }
            rebalance(node2, true);
        } else {
            if (comparator == zznVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            node = new Node(node2, obj, node4, node4.prev);
            this.root = node;
        }
        this.size++;
        this.modCount++;
        return node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Node nodeFind;
        if (obj != null) {
            try {
                nodeFind = find(obj, false);
            } catch (ClassCastException unused) {
                nodeFind = null;
            }
        } else {
            nodeFind = null;
        }
        if (nodeFind != null) {
            return nodeFind.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet(this, 0);
        this.keySet = keySet2;
        return keySet2;
    }

    public final void rebalance(Node node, boolean z) {
        while (node != null) {
            Node node2 = node.left;
            Node node3 = node.right;
            int i = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                Node node4 = node3.left;
                Node node5 = node3.right;
                int i4 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                Node node6 = node2.left;
                Node node7 = node2.right;
                int i5 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Node nodeFind;
        if (obj != null) {
            try {
                nodeFind = find(obj, false);
            } catch (ClassCastException unused) {
                nodeFind = null;
            }
        } else {
            nodeFind = null;
        }
        if (nodeFind != null) {
            removeInternal(nodeFind, true);
        }
        if (nodeFind != null) {
            return nodeFind.value;
        }
        return null;
    }

    public final void removeInternal(Node node, boolean z) {
        Node node2;
        Node node3;
        int i;
        if (z) {
            Node node4 = node.prev;
            node4.next = node.next;
            node.next.prev = node4;
        }
        Node node5 = node.left;
        Node node6 = node.right;
        Node node7 = node.parent;
        int i2 = 0;
        if (node5 == null || node6 == null) {
            if (node5 != null) {
                replaceInParent(node, node5);
                node.left = null;
            } else if (node6 != null) {
                replaceInParent(node, node6);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (node5.height > node6.height) {
            Node node8 = node5.right;
            while (true) {
                Node node9 = node8;
                node3 = node5;
                node5 = node9;
                if (node5 == null) {
                    break;
                } else {
                    node8 = node5.right;
                }
            }
        } else {
            Node node10 = node6.left;
            while (true) {
                node2 = node6;
                node6 = node10;
                if (node6 == null) {
                    break;
                } else {
                    node10 = node6.left;
                }
            }
            node3 = node2;
        }
        removeInternal(node3, false);
        Node node11 = node.left;
        if (node11 != null) {
            i = node11.height;
            node3.left = node11;
            node11.parent = node3;
            node.left = null;
        } else {
            i = 0;
        }
        Node node12 = node.right;
        if (node12 != null) {
            i2 = node12.height;
            node3.right = node12;
            node12.parent = node3;
            node.right = null;
        }
        node3.height = Math.max(i, i2) + 1;
        replaceInParent(node, node3);
    }

    public final void replaceInParent(Node node, Node node2) {
        Node node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            this.root = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    public final void rotateLeft(Node node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node3.left;
        Node node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int iMax = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node.height = iMax;
        node3.height = Math.max(iMax, node5 != null ? node5.height : 0) + 1;
    }

    public final void rotateRight(Node node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node2.left;
        Node node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int iMax = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node.height = iMax;
        node2.height = Math.max(iMax, node4 != null ? node4.height : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(mnwSv.spWHq);
        }
        Node nodeFind = find(obj, true);
        Object obj3 = nodeFind.value;
        nodeFind.value = obj2;
        return obj3;
    }

    public final class Node implements Map.Entry {
        public int height;
        public final Object key;
        public Node left;
        public Node next;
        public Node parent;
        public Node prev;
        public Node right;
        public Object value;

        public Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.key;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.value;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object obj = this.key;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.value;
            return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node node, Object obj, Node node2, Node node3) {
            this.parent = node;
            this.key = obj;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
