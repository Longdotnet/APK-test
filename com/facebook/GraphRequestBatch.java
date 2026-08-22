package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class GraphRequestBatch extends AbstractList {
    public static final AtomicInteger idGenerator = new AtomicInteger();
    public Handler callbackHandler;
    public final ArrayList requests;
    public final String id = String.valueOf(Integer.valueOf(idGenerator.incrementAndGet()));
    public final ArrayList callbacks = new ArrayList();

    public GraphRequestBatch(List list) {
        this.requests = new ArrayList(list);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        GraphRequest element = (GraphRequest) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        this.requests.add(i, element);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.requests.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return super.contains((GraphRequest) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (GraphRequest) this.requests.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return super.indexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return super.lastIndexOf((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return super.remove((GraphRequest) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        GraphRequest element = (GraphRequest) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return (GraphRequest) this.requests.set(i, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.requests.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return (GraphRequest) this.requests.remove(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        GraphRequest element = (GraphRequest) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.requests.add(element);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        this.requests = new ArrayList(ArraysKt.asList(graphRequestArr));
    }
}
