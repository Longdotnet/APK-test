package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ListFieldSchemaFull implements ListFieldSchema {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public static <E> List<E> getList(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) UnsafeUtil.getObject(obj, j);
        if (list instanceof LazyStringList) {
            objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
        } else {
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                if (protobufList.isModifiable()) {
                    protobufList.makeImmutable();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        UnsafeUtil.putObject(obj, j, objUnmodifiableList);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object obj, Object obj2, long j) {
        List list = getList(obj2, j);
        List listMutableListAt = mutableListAt(obj, j, list.size());
        int size = listMutableListAt.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listMutableListAt.addAll(list);
        }
        if (size > 0) {
            list = listMutableListAt;
        }
        UnsafeUtil.putObject(obj, j, list);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object obj, long j) {
        return mutableListAt(obj, j, 10);
    }

    private static <L> List<L> mutableListAt(Object obj, long j, int i) {
        Object obj2;
        List<L> listMutableCopyWithCapacity2;
        List<L> list = getList(obj, j);
        if (list.isEmpty()) {
            if (list instanceof LazyStringList) {
                listMutableCopyWithCapacity2 = new LazyStringArrayList(i);
            } else {
                listMutableCopyWithCapacity2 = ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list).mutableCopyWithCapacity2(i) : new ArrayList<>(i);
            }
            UnsafeUtil.putObject(obj, j, listMutableCopyWithCapacity2);
            return listMutableCopyWithCapacity2;
        }
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i);
            arrayList.addAll(list);
            UnsafeUtil.putObject(obj, j, arrayList);
            obj2 = arrayList;
        } else {
            if (!(list instanceof UnmodifiableLazyStringList)) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    return list;
                }
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                if (protobufList.isModifiable()) {
                    return list;
                }
                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + i);
                UnsafeUtil.putObject(obj, j, protobufListMutableCopyWithCapacity2);
                return protobufListMutableCopyWithCapacity2;
            }
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(list.size() + i);
            lazyStringArrayList.addAll((UnmodifiableLazyStringList) list);
            UnsafeUtil.putObject(obj, j, lazyStringArrayList);
            obj2 = lazyStringArrayList;
        }
        return (List<L>) obj2;
    }
}
