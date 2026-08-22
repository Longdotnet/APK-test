package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayTypeAdapter extends TypeAdapter {
    public static final TypeAdapters.AnonymousClass28 FACTORY = new TypeAdapters.AnonymousClass28(1);
    public final /* synthetic */ int $r8$classId = 0;
    public final TypeAdapterRuntimeTypeWrapper componentTypeAdapter;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        switch (this.$r8$classId) {
            case 0:
                if (obj == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.beginArray();
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        this.componentTypeAdapter.write(jsonWriter, Array.get(obj, i));
                    }
                    jsonWriter.endArray();
                }
                break;
            default:
                Collection collection = (Collection) obj;
                if (collection == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.beginArray();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        this.componentTypeAdapter.write(jsonWriter, it.next());
                    }
                    jsonWriter.endArray();
                }
                break;
        }
    }

    public ArrayTypeAdapter(Gson gson, Type type, TypeAdapter typeAdapter, ObjectConstructor objectConstructor) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
    }
}
