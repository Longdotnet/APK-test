package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapterRuntimeTypeWrapper extends TypeAdapter {
    public final Gson context;
    public final TypeAdapter delegate;
    public final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        Type type = this.type;
        Type type2 = (obj == null || !(type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) ? type : obj.getClass();
        TypeAdapter typeAdapter = this.delegate;
        if (type2 != type) {
            TypeAdapter adapter = this.context.getAdapter(new TypeToken(type2));
            if (!(adapter instanceof ReflectiveTypeAdapterFactory.Adapter) || (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                typeAdapter = adapter;
            }
        }
        typeAdapter.write(jsonWriter, obj);
    }
}
