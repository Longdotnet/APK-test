package com.google.gson;

import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.firebase.auth.zzz;
import com.google.firebase.inject.PVS.jIKWv;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes3.dex */
public final class Gson {
    public final zzz constructorConstructor;
    public final List factories;
    public final boolean htmlSafe;
    public final MapTypeAdapterFactory jsonAdapterFactory;
    public final ThreadLocal calls = new ThreadLocal();
    public final ConcurrentHashMap typeTokenCache = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.google.gson.Gson$4, reason: invalid class name */
    public final class AnonymousClass4 extends TypeAdapter {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ TypeAdapter val$longAdapter;

        public /* synthetic */ AnonymousClass4(TypeAdapter typeAdapter, int i) {
            this.$r8$classId = i;
            this.val$longAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            switch (this.$r8$classId) {
                case 0:
                    this.val$longAdapter.write(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
                    break;
                case 1:
                    AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                    jsonWriter.beginArray();
                    int length = atomicLongArray.length();
                    for (int i = 0; i < length; i++) {
                        this.val$longAdapter.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                    }
                    jsonWriter.endArray();
                    break;
                default:
                    if (obj == null) {
                        jsonWriter.nullValue();
                    } else {
                        this.val$longAdapter.write(jsonWriter, obj);
                    }
                    break;
            }
        }
    }

    public final class FutureTypeAdapter extends TypeAdapter {
        public TypeAdapter delegate;

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            TypeAdapter typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.write(jsonWriter, obj);
        }
    }

    static {
        new TypeToken(Object.class);
    }

    public Gson(Excluder excluder, HashMap map, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        zzz zzzVar = new zzz(map);
        this.constructorConstructor = zzzVar;
        this.htmlSafe = true;
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList4.add(ObjectTypeAdapter.DOUBLE_FACTORY);
        arrayList4.add(excluder);
        arrayList4.addAll(arrayList3);
        arrayList4.add(TypeAdapters.STRING_FACTORY);
        arrayList4.add(TypeAdapters.INTEGER_FACTORY);
        arrayList4.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList4.add(TypeAdapters.BYTE_FACTORY);
        arrayList4.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapters.AnonymousClass1 anonymousClass1 = TypeAdapters.LONG;
        arrayList4.add(new TypeAdapters.AnonymousClass31(Long.TYPE, Long.class, anonymousClass1));
        final int i = 0;
        arrayList4.add(new TypeAdapters.AnonymousClass31(Double.TYPE, Double.class, new TypeAdapter() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                switch (i) {
                    case 0:
                        Number number = (Number) obj;
                        if (number != null) {
                            Gson.checkValidFloatingPoint(number.doubleValue());
                            jsonWriter.value(number);
                        } else {
                            jsonWriter.nullValue();
                        }
                        break;
                    default:
                        Number number2 = (Number) obj;
                        if (number2 != null) {
                            Gson.checkValidFloatingPoint(number2.floatValue());
                            jsonWriter.value(number2);
                        } else {
                            jsonWriter.nullValue();
                        }
                        break;
                }
            }
        }));
        final int i2 = 1;
        arrayList4.add(new TypeAdapters.AnonymousClass31(Float.TYPE, Float.class, new TypeAdapter() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
                switch (i2) {
                    case 0:
                        Number number = (Number) obj;
                        if (number != null) {
                            Gson.checkValidFloatingPoint(number.doubleValue());
                            jsonWriter.value(number);
                        } else {
                            jsonWriter.nullValue();
                        }
                        break;
                    default:
                        Number number2 = (Number) obj;
                        if (number2 != null) {
                            Gson.checkValidFloatingPoint(number2.floatValue());
                            jsonWriter.value(number2);
                        } else {
                            jsonWriter.nullValue();
                        }
                        break;
                }
            }
        }));
        arrayList4.add(TypeAdapters.AnonymousClass1.LAZILY_PARSED_NUMBER_FACTORY);
        arrayList4.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList4.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList4.add(new TypeAdapters.AnonymousClass30(AtomicLong.class, new AnonymousClass4(new AnonymousClass4(anonymousClass1, 0), 2), 0));
        arrayList4.add(new TypeAdapters.AnonymousClass30(AtomicLongArray.class, new AnonymousClass4(new AnonymousClass4(anonymousClass1, 1), 2), 0));
        arrayList4.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList4.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList4.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList4.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList4.add(new TypeAdapters.AnonymousClass30(BigDecimal.class, TypeAdapters.BIG_DECIMAL, 0));
        arrayList4.add(new TypeAdapters.AnonymousClass30(BigInteger.class, TypeAdapters.BIG_INTEGER, 0));
        arrayList4.add(TypeAdapters.URL_FACTORY);
        arrayList4.add(TypeAdapters.URI_FACTORY);
        arrayList4.add(TypeAdapters.UUID_FACTORY);
        arrayList4.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList4.add(TypeAdapters.LOCALE_FACTORY);
        arrayList4.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList4.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList4.add(DateTypeAdapter.FACTORY);
        arrayList4.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList4.add(SqlTypesSupport.TIME_FACTORY);
            arrayList4.add(SqlTypesSupport.DATE_FACTORY);
            arrayList4.add(SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList4.add(ArrayTypeAdapter.FACTORY);
        arrayList4.add(TypeAdapters.CLASS_FACTORY);
        arrayList4.add(new MapTypeAdapterFactory(zzzVar, 1));
        arrayList4.add(new MapTypeAdapterFactory(zzzVar, 0));
        MapTypeAdapterFactory mapTypeAdapterFactory = new MapTypeAdapterFactory(zzzVar, 2);
        this.jsonAdapterFactory = mapTypeAdapterFactory;
        arrayList4.add(mapTypeAdapterFactory);
        arrayList4.add(TypeAdapters.ENUM_FACTORY);
        arrayList4.add(new ReflectiveTypeAdapterFactory(zzzVar, excluder, mapTypeAdapterFactory));
        this.factories = Collections.unmodifiableList(arrayList4);
    }

    public static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final TypeAdapter getAdapter(TypeToken typeToken) {
        boolean z;
        ConcurrentHashMap concurrentHashMap = this.typeTokenCache;
        TypeAdapter typeAdapter = (TypeAdapter) concurrentHashMap.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        ThreadLocal threadLocal = this.calls;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            z = false;
        }
        FutureTypeAdapter futureTypeAdapter = (FutureTypeAdapter) map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter futureTypeAdapter2 = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter2);
            Iterator it = this.factories.iterator();
            while (it.hasNext()) {
                TypeAdapter typeAdapterCreate = ((TypeAdapterFactory) it.next()).create(this, typeToken);
                if (typeAdapterCreate != null) {
                    if (futureTypeAdapter2.delegate != null) {
                        throw new AssertionError();
                    }
                    futureTypeAdapter2.delegate = typeAdapterCreate;
                    concurrentHashMap.put(typeToken, typeAdapterCreate);
                    map.remove(typeToken);
                    if (z) {
                        threadLocal.remove();
                    }
                    return typeAdapterCreate;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.9) cannot handle " + typeToken);
        } catch (Throwable th) {
            map.remove(typeToken);
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final JsonWriter newJsonWriter(Writer writer) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.serializeNulls = false;
        return jsonWriter;
    }

    public final void toJson(Object obj, Class cls, JsonWriter jsonWriter) {
        TypeAdapter adapter = getAdapter(new TypeToken(cls));
        boolean z = jsonWriter.lenient;
        jsonWriter.lenient = true;
        boolean z2 = jsonWriter.htmlSafe;
        jsonWriter.htmlSafe = this.htmlSafe;
        boolean z3 = jsonWriter.serializeNulls;
        jsonWriter.serializeNulls = false;
        try {
            try {
                try {
                    adapter.write(jsonWriter, obj);
                    jsonWriter.lenient = z;
                    jsonWriter.htmlSafe = z2;
                    jsonWriter.serializeNulls = z3;
                } catch (AssertionError e) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                }
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } catch (Throwable th) {
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
            throw th;
        }
    }

    public final String toString() {
        return ehgOP.cfygO + this.factories + ",instanceCreators:" + this.constructorConstructor + jIKWv.HNpnDNXV;
    }

    public final String toJson(Object obj) {
        if (obj == null) {
            StringWriter stringWriter = new StringWriter();
            try {
                toJson(newJsonWriter(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            toJson(obj, cls, newJsonWriter(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final void toJson(JsonWriter jsonWriter) {
        JsonNull jsonNull = JsonNull.INSTANCE;
        boolean z = jsonWriter.lenient;
        jsonWriter.lenient = true;
        boolean z2 = jsonWriter.htmlSafe;
        jsonWriter.htmlSafe = this.htmlSafe;
        boolean z3 = jsonWriter.serializeNulls;
        jsonWriter.serializeNulls = false;
        try {
            try {
                try {
                    TypeAdapters.AnonymousClass30 anonymousClass30 = TypeAdapters.CLASS_FACTORY;
                    TypeAdapters.AnonymousClass1.write(jsonWriter, (JsonElement) jsonNull);
                    jsonWriter.lenient = z;
                    jsonWriter.htmlSafe = z2;
                    jsonWriter.serializeNulls = z3;
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.9): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            jsonWriter.lenient = z;
            jsonWriter.htmlSafe = z2;
            jsonWriter.serializeNulls = z3;
            throw th;
        }
    }
}
