package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT;
    public List deserializationStrategies;
    public List serializationStrategies;

    /* JADX INFO: renamed from: com.google.gson.internal.Excluder$1 */
    public final class AnonymousClass1 extends TypeAdapter {
        public TypeAdapter delegate;
        public final /* synthetic */ Gson val$gson;
        public final /* synthetic */ boolean val$skipSerialize;
        public final /* synthetic */ TypeToken val$type;

        public AnonymousClass1(boolean z, boolean z2, Gson gson, TypeToken typeToken) {
            this.val$skipSerialize = z2;
            this.val$gson = gson;
            this.val$type = typeToken;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            if (this.val$skipSerialize) {
                jsonWriter.nullValue();
                return;
            }
            TypeAdapter typeAdapter = this.delegate;
            if (typeAdapter == null) {
                TypeToken typeToken = this.val$type;
                Gson gson = this.val$gson;
                List<TypeAdapterFactory> list = gson.factories;
                TypeAdapterFactory typeAdapterFactory = Excluder.this;
                if (!list.contains(typeAdapterFactory)) {
                    typeAdapterFactory = gson.jsonAdapterFactory;
                }
                boolean z = false;
                for (TypeAdapterFactory typeAdapterFactory2 : list) {
                    if (z) {
                        TypeAdapter typeAdapterCreate = typeAdapterFactory2.create(gson, typeToken);
                        if (typeAdapterCreate != null) {
                            this.delegate = typeAdapterCreate;
                            typeAdapter = typeAdapterCreate;
                        }
                    } else if (typeAdapterFactory2 == typeAdapterFactory) {
                        z = true;
                    }
                }
                throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
            }
            typeAdapter.write(jsonWriter, obj);
        }
    }

    static {
        Excluder excluder = new Excluder();
        excluder.serializationStrategies = Collections.emptyList();
        excluder.deserializationStrategies = Collections.emptyList();
        DEFAULT = excluder;
    }

    public static boolean isAnonymousOrNonStaticLocal(Class cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.getModifiers() & 8) == 0 && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public final Object clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        boolean z;
        boolean z2;
        boolean zIsAnonymousOrNonStaticLocal = isAnonymousOrNonStaticLocal(typeToken.rawType);
        if (zIsAnonymousOrNonStaticLocal) {
            z = true;
        } else {
            excludeClassInStrategy(true);
            z = false;
        }
        if (zIsAnonymousOrNonStaticLocal) {
            z2 = true;
        } else {
            excludeClassInStrategy(false);
            z2 = false;
        }
        if (z || z2) {
            return new TypeAdapter(z2, z, gson, typeToken) { // from class: com.google.gson.internal.Excluder.1
                public TypeAdapter delegate;
                public final /* synthetic */ Gson val$gson;
                public final /* synthetic */ boolean val$skipSerialize;
                public final /* synthetic */ TypeToken val$type;

                public AnonymousClass1(boolean z3, boolean z4, Gson gson2, TypeToken typeToken2) {
                    this.val$skipSerialize = z4;
                    this.val$gson = gson2;
                    this.val$type = typeToken2;
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    if (this.val$skipSerialize) {
                        jsonWriter.nullValue();
                        return;
                    }
                    TypeAdapter typeAdapter = this.delegate;
                    if (typeAdapter == null) {
                        TypeToken typeToken2 = this.val$type;
                        Gson gson2 = this.val$gson;
                        List<TypeAdapterFactory> list = gson2.factories;
                        TypeAdapterFactory typeAdapterFactory = Excluder.this;
                        if (!list.contains(typeAdapterFactory)) {
                            typeAdapterFactory = gson2.jsonAdapterFactory;
                        }
                        boolean z3 = false;
                        for (TypeAdapterFactory typeAdapterFactory2 : list) {
                            if (z3) {
                                TypeAdapter typeAdapterCreate = typeAdapterFactory2.create(gson2, typeToken2);
                                if (typeAdapterCreate != null) {
                                    this.delegate = typeAdapterCreate;
                                    typeAdapter = typeAdapterCreate;
                                }
                            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                                z3 = true;
                            }
                        }
                        throw new IllegalArgumentException("GSON cannot serialize " + typeToken2);
                    }
                    typeAdapter.write(jsonWriter, obj);
                }
            };
        }
        return null;
    }

    public final void excludeClassInStrategy(boolean z) {
        Iterator it = (z ? this.serializationStrategies : this.deserializationStrategies).iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }
}
