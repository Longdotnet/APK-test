package com.google.gson.internal.bind;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.sql.SqlDateTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.yWTz.kBfGXgdfpo;
import com.google.protobuf.DescriptorProtos;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeAdapters {
    public static final AnonymousClass30 ATOMIC_BOOLEAN_FACTORY;
    public static final AnonymousClass30 ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final AnonymousClass30 ATOMIC_INTEGER_FACTORY;
    public static final AnonymousClass1 BIG_DECIMAL;
    public static final AnonymousClass1 BIG_INTEGER;
    public static final AnonymousClass1 BOOLEAN_AS_STRING;
    public static final AnonymousClass31 BOOLEAN_FACTORY;
    public static final AnonymousClass31 BYTE_FACTORY;
    public static final AnonymousClass32 CALENDAR_FACTORY;
    public static final AnonymousClass31 CHARACTER_FACTORY;
    public static final AnonymousClass30 CURRENCY_FACTORY;
    public static final AnonymousClass28 ENUM_FACTORY;
    public static final AnonymousClass30 INET_ADDRESS_FACTORY;
    public static final AnonymousClass31 INTEGER_FACTORY;
    public static final AnonymousClass30 JSON_ELEMENT_FACTORY;
    public static final AnonymousClass30 LOCALE_FACTORY;
    public static final AnonymousClass1 LONG;
    public static final AnonymousClass31 SHORT_FACTORY;
    public static final AnonymousClass30 STRING_BUFFER_FACTORY;
    public static final AnonymousClass30 STRING_BUILDER_FACTORY;
    public static final AnonymousClass30 STRING_FACTORY;
    public static final AnonymousClass30 URI_FACTORY;
    public static final AnonymousClass30 URL_FACTORY;
    public static final AnonymousClass30 UUID_FACTORY;
    public static final AnonymousClass30 CLASS_FACTORY = new AnonymousClass30(Class.class, new Gson.AnonymousClass4(new AnonymousClass1(0), 2), 0);
    public static final AnonymousClass30 BIT_SET_FACTORY = new AnonymousClass30(BitSet.class, new Gson.AnonymousClass4(new AnonymousClass1(20), 2), 0);

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$28 */
    public final class AnonymousClass28 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass28(int i) {
            this.$r8$classId = i;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            switch (this.$r8$classId) {
                case 0:
                    Class superclass = typeToken.rawType;
                    if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
                        return null;
                    }
                    if (!superclass.isEnum()) {
                        superclass = superclass.getSuperclass();
                    }
                    return new EnumTypeAdapter(superclass);
                case 1:
                    Type type = typeToken.type;
                    boolean z = type instanceof GenericArrayType;
                    if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
                        return null;
                    }
                    Type genericComponentType = z ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
                    return new ArrayTypeAdapter(gson, gson.getAdapter(new TypeToken(genericComponentType)), Streams.getRawType(genericComponentType));
                case 2:
                    if (typeToken.rawType == Date.class) {
                        return new DateTypeAdapter();
                    }
                    return null;
                case 3:
                    if (typeToken.rawType == Object.class) {
                        return new ObjectTypeAdapter(gson);
                    }
                    return null;
                case 4:
                    if (typeToken.rawType == java.sql.Date.class) {
                        return new SqlDateTypeAdapter(0);
                    }
                    return null;
                case 5:
                    if (typeToken.rawType == Time.class) {
                        return new SqlDateTypeAdapter(1);
                    }
                    return null;
                default:
                    if (typeToken.rawType != Timestamp.class) {
                        return null;
                    }
                    gson.getClass();
                    return new SqlDateTypeAdapter(gson.getAdapter(new TypeToken(Date.class)));
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$30 */
    public final class AnonymousClass30 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Class val$type;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public /* synthetic */ AnonymousClass30(Class cls, TypeAdapter typeAdapter, int i) {
            this.$r8$classId = i;
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            switch (this.$r8$classId) {
                case 0:
                    if (typeToken.rawType == this.val$type) {
                        return this.val$typeAdapter;
                    }
                    return null;
                default:
                    Class cls = this.val$type;
                    Class<?> cls2 = typeToken.rawType;
                    if (cls.isAssignableFrom(cls2)) {
                        return new DateTypeAdapter(this, cls2);
                    }
                    return null;
            }
        }

        public final String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
                default:
                    return "Factory[typeHierarchy=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    public final class AnonymousClass31 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$boxed;
        public final /* synthetic */ TypeAdapter val$typeAdapter;
        public final /* synthetic */ Class val$unboxed;

        public AnonymousClass31(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class cls = this.val$unboxed;
            Class cls2 = typeToken.rawType;
            if (cls2 == cls || cls2 == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public final String toString() {
            return "Factory[type=" + this.val$boxed.getName() + "+" + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + kBfGXgdfpo.zkuYTzDQjPkZ;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    public final class AnonymousClass32 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public /* synthetic */ AnonymousClass32(TypeAdapter typeAdapter, int i) {
            this.$r8$classId = i;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            switch (this.$r8$classId) {
                case 0:
                    Class cls = typeToken.rawType;
                    if (cls == Calendar.class || cls == GregorianCalendar.class) {
                        return (AnonymousClass1) this.val$typeAdapter;
                    }
                    return null;
                default:
                    if (typeToken.rawType == Number.class) {
                        return (AnonymousClass1) this.val$typeAdapter;
                    }
                    return null;
            }
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((AnonymousClass1) this.val$typeAdapter) + "]";
                default:
                    return super.toString();
            }
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(21);
        BOOLEAN_AS_STRING = new AnonymousClass1(22);
        BOOLEAN_FACTORY = new AnonymousClass31(Boolean.TYPE, Boolean.class, anonymousClass1);
        BYTE_FACTORY = new AnonymousClass31(Byte.TYPE, Byte.class, new AnonymousClass1(23));
        SHORT_FACTORY = new AnonymousClass31(Short.TYPE, Short.class, new AnonymousClass1(24));
        INTEGER_FACTORY = new AnonymousClass31(Integer.TYPE, Integer.class, new AnonymousClass1(25));
        ATOMIC_INTEGER_FACTORY = new AnonymousClass30(AtomicInteger.class, new Gson.AnonymousClass4(new AnonymousClass1(26), 2), 0);
        ATOMIC_BOOLEAN_FACTORY = new AnonymousClass30(AtomicBoolean.class, new Gson.AnonymousClass4(new AnonymousClass1(27), 2), 0);
        ATOMIC_INTEGER_ARRAY_FACTORY = new AnonymousClass30(AtomicIntegerArray.class, new Gson.AnonymousClass4(new AnonymousClass1(2), 2), 0);
        LONG = new AnonymousClass1(3);
        CHARACTER_FACTORY = new AnonymousClass31(Character.TYPE, Character.class, new AnonymousClass1(6));
        AnonymousClass1 anonymousClass2 = new AnonymousClass1(7);
        BIG_DECIMAL = new AnonymousClass1(8);
        BIG_INTEGER = new AnonymousClass1(9);
        STRING_FACTORY = new AnonymousClass30(String.class, anonymousClass2, 0);
        STRING_BUILDER_FACTORY = new AnonymousClass30(StringBuilder.class, new AnonymousClass1(10), 0);
        STRING_BUFFER_FACTORY = new AnonymousClass30(StringBuffer.class, new AnonymousClass1(11), 0);
        URL_FACTORY = new AnonymousClass30(URL.class, new AnonymousClass1(12), 0);
        URI_FACTORY = new AnonymousClass30(URI.class, new AnonymousClass1(13), 0);
        INET_ADDRESS_FACTORY = new AnonymousClass30(InetAddress.class, new AnonymousClass1(14), 1);
        UUID_FACTORY = new AnonymousClass30(UUID.class, new AnonymousClass1(15), 0);
        CURRENCY_FACTORY = new AnonymousClass30(Currency.class, new Gson.AnonymousClass4(new AnonymousClass1(16), 2), 0);
        CALENDAR_FACTORY = new AnonymousClass32(new AnonymousClass1(17), 0);
        LOCALE_FACTORY = new AnonymousClass30(Locale.class, new AnonymousClass1(18), 0);
        JSON_ELEMENT_FACTORY = new AnonymousClass30(JsonElement.class, new AnonymousClass1(19), 1);
        ENUM_FACTORY = new AnonymousClass28(0);
    }

    public final class EnumTypeAdapter extends TypeAdapter {
        public final /* synthetic */ int $r8$classId;
        public final Object constantToName;
        public final Object nameToConstant;

        /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter$1 */
        public final class AnonymousClass1 implements PrivilegedAction {
            public final /* synthetic */ Field val$field;

            public AnonymousClass1() {
                field = field;
            }

            @Override // java.security.PrivilegedAction
            public final Object run() {
                field.setAccessible(true);
                return null;
            }
        }

        public EnumTypeAdapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, ObjectConstructor objectConstructor) {
            this.$r8$classId = 1;
            this.constantToName = mapTypeAdapterFactory;
            new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.nameToConstant = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            switch (this.$r8$classId) {
                case 0:
                    Enum r5 = (Enum) obj;
                    jsonWriter.value(r5 == null ? null : (String) ((HashMap) this.constantToName).get(r5));
                    break;
                default:
                    Map map = (Map) obj;
                    if (map == null) {
                        jsonWriter.nullValue();
                    } else {
                        ((MapTypeAdapterFactory) this.constantToName).getClass();
                        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = (TypeAdapterRuntimeTypeWrapper) this.nameToConstant;
                        jsonWriter.beginObject();
                        for (Map.Entry entry : map.entrySet()) {
                            jsonWriter.name(String.valueOf(entry.getKey()));
                            typeAdapterRuntimeTypeWrapper.write(jsonWriter, entry.getValue());
                        }
                        jsonWriter.endObject();
                    }
                    break;
            }
        }

        public EnumTypeAdapter(Class cls) {
            this.$r8$classId = 0;
            this.nameToConstant = new HashMap();
            this.constantToName = new HashMap();
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isEnumConstant()) {
                        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter.1
                            public final /* synthetic */ Field val$field;

                            public AnonymousClass1() {
                                field = field;
                            }

                            @Override // java.security.PrivilegedAction
                            public final Object run() {
                                field.setAccessible(true);
                                return null;
                            }
                        });
                        Enum r4 = (Enum) field.get(null);
                        String strName = r4.name();
                        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                        if (serializedName != null) {
                            strName = serializedName.value();
                            for (String str : serializedName.alternate()) {
                                ((HashMap) this.nameToConstant).put(str, r4);
                            }
                        }
                        ((HashMap) this.nameToConstant).put(strName, r4);
                        ((HashMap) this.constantToName).put(r4, strName);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$1 */
    public final class AnonymousClass1 extends TypeAdapter {
        public static final AnonymousClass32 LAZILY_PARSED_NUMBER_FACTORY = new AnonymousClass32(new AnonymousClass1(1), 1);
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        public static JsonElement read(JsonReader jsonReader) {
            String strNextQuotedValue;
            int iOrdinal = Fragment$$ExternalSyntheticOutline0.ordinal(jsonReader.peek());
            if (iOrdinal == 0) {
                JsonArray jsonArray = new JsonArray();
                int iDoPeek = jsonReader.peeked;
                if (iDoPeek == 0) {
                    iDoPeek = jsonReader.doPeek();
                }
                if (iDoPeek != 3) {
                    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
                }
                jsonReader.push(1);
                jsonReader.pathIndices[jsonReader.stackSize - 1] = 0;
                jsonReader.peeked = 0;
                while (jsonReader.hasNext()) {
                    jsonArray.elements.add(read(jsonReader));
                }
                int iDoPeek2 = jsonReader.peeked;
                if (iDoPeek2 == 0) {
                    iDoPeek2 = jsonReader.doPeek();
                }
                if (iDoPeek2 != 4) {
                    throw new IllegalStateException("Expected END_ARRAY but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
                }
                int i = jsonReader.stackSize;
                jsonReader.stackSize = i - 1;
                int[] iArr = jsonReader.pathIndices;
                int i2 = i - 2;
                iArr[i2] = iArr[i2] + 1;
                jsonReader.peeked = 0;
                return jsonArray;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 5) {
                    return new JsonPrimitive(jsonReader.nextString());
                }
                if (iOrdinal == 6) {
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
                }
                if (iOrdinal != 7) {
                    if (iOrdinal != 8) {
                        throw new IllegalArgumentException();
                    }
                    int iDoPeek3 = jsonReader.peeked;
                    if (iDoPeek3 == 0) {
                        iDoPeek3 = jsonReader.doPeek();
                    }
                    if (iDoPeek3 != 7) {
                        throw new IllegalStateException("Expected null but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
                    }
                    jsonReader.peeked = 0;
                    int[] iArr2 = jsonReader.pathIndices;
                    int i3 = jsonReader.stackSize - 1;
                    iArr2[i3] = iArr2[i3] + 1;
                    return JsonNull.INSTANCE;
                }
                int iDoPeek4 = jsonReader.peeked;
                if (iDoPeek4 == 0) {
                    iDoPeek4 = jsonReader.doPeek();
                }
                boolean z = false;
                if (iDoPeek4 == 5) {
                    jsonReader.peeked = 0;
                    int[] iArr3 = jsonReader.pathIndices;
                    int i4 = jsonReader.stackSize - 1;
                    iArr3[i4] = iArr3[i4] + 1;
                    z = true;
                } else {
                    if (iDoPeek4 != 6) {
                        throw new IllegalStateException("Expected a boolean but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
                    }
                    jsonReader.peeked = 0;
                    int[] iArr4 = jsonReader.pathIndices;
                    int i5 = jsonReader.stackSize - 1;
                    iArr4[i5] = iArr4[i5] + 1;
                }
                return new JsonPrimitive(Boolean.valueOf(z));
            }
            JsonObject jsonObject = new JsonObject();
            int iDoPeek5 = jsonReader.peeked;
            if (iDoPeek5 == 0) {
                iDoPeek5 = jsonReader.doPeek();
            }
            if (iDoPeek5 != 1) {
                throw new IllegalStateException("Expected BEGIN_OBJECT but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
            }
            jsonReader.push(3);
            jsonReader.peeked = 0;
            while (jsonReader.hasNext()) {
                int iDoPeek6 = jsonReader.peeked;
                if (iDoPeek6 == 0) {
                    iDoPeek6 = jsonReader.doPeek();
                }
                if (iDoPeek6 == 14) {
                    strNextQuotedValue = jsonReader.nextUnquotedValue();
                } else if (iDoPeek6 == 12) {
                    strNextQuotedValue = jsonReader.nextQuotedValue('\'');
                } else {
                    if (iDoPeek6 != 13) {
                        throw new IllegalStateException("Expected a name but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
                    }
                    strNextQuotedValue = jsonReader.nextQuotedValue('\"');
                }
                jsonReader.peeked = 0;
                jsonReader.pathNames[jsonReader.stackSize - 1] = strNextQuotedValue;
                jsonObject.members.put(strNextQuotedValue, read(jsonReader));
            }
            int iDoPeek7 = jsonReader.peeked;
            if (iDoPeek7 == 0) {
                iDoPeek7 = jsonReader.doPeek();
            }
            if (iDoPeek7 != 2) {
                throw new IllegalStateException("Expected END_OBJECT but was " + BarcodeFormat$EnumUnboxingLocalUtility.stringValueOf(jsonReader.peek()) + jsonReader.locationString());
            }
            int i6 = jsonReader.stackSize;
            int i7 = i6 - 1;
            jsonReader.stackSize = i7;
            jsonReader.pathNames[i7] = null;
            int[] iArr5 = jsonReader.pathIndices;
            int i8 = i6 - 2;
            iArr5[i8] = iArr5[i8] + 1;
            jsonReader.peeked = 0;
            return jsonObject;
        }

        public static void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || (jsonElement instanceof JsonNull)) {
                jsonWriter.nullValue();
                return;
            }
            boolean z = jsonElement instanceof JsonPrimitive;
            if (z) {
                if (!z) {
                    throw new IllegalStateException("Not a JSON Primitive: " + jsonElement);
                }
                JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
                Serializable serializable = jsonPrimitive.value;
                if (serializable instanceof Number) {
                    jsonWriter.value(jsonPrimitive.getAsNumber());
                    return;
                } else if (serializable instanceof Boolean) {
                    jsonWriter.value(jsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(jsonPrimitive.getAsString());
                    return;
                }
            }
            boolean z2 = jsonElement instanceof JsonArray;
            if (z2) {
                jsonWriter.beginArray();
                if (!z2) {
                    throw new IllegalStateException("Not a JSON Array: " + jsonElement);
                }
                Iterator it = ((JsonArray) jsonElement).elements.iterator();
                while (it.hasNext()) {
                    write(jsonWriter, (JsonElement) it.next());
                }
                jsonWriter.endArray();
                return;
            }
            boolean z3 = jsonElement instanceof JsonObject;
            if (!z3) {
                throw new IllegalArgumentException(ZRqOdXiy.tTMK + jsonElement.getClass());
            }
            jsonWriter.beginObject();
            if (!z3) {
                throw new IllegalStateException("Not a JSON Object: " + jsonElement);
            }
            Iterator it2 = ((LinkedTreeMap.KeySet) ((JsonObject) jsonElement).members.entrySet()).iterator();
            while (((LinkedTreeMap.KeySet.AnonymousClass1) it2).hasNext()) {
                LinkedTreeMap.Node nodeNextNode = ((LinkedTreeMap.KeySet.AnonymousClass1) it2).nextNode();
                jsonWriter.name((String) nodeNextNode.getKey());
                write(jsonWriter, (JsonElement) nodeNextNode.getValue());
            }
            jsonWriter.endObject();
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
                case 1:
                    jsonWriter.value((Number) obj);
                    return;
                case 2:
                    AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                    jsonWriter.beginArray();
                    int length = atomicIntegerArray.length();
                    for (int i = 0; i < length; i++) {
                        jsonWriter.value(atomicIntegerArray.get(i));
                    }
                    jsonWriter.endArray();
                    return;
                case 3:
                    jsonWriter.value((Number) obj);
                    return;
                case 4:
                    jsonWriter.value((Number) obj);
                    return;
                case 5:
                    jsonWriter.value((Number) obj);
                    return;
                case 6:
                    Character ch = (Character) obj;
                    jsonWriter.value(ch == null ? null : String.valueOf(ch));
                    return;
                case 7:
                    jsonWriter.value((String) obj);
                    return;
                case 8:
                    jsonWriter.value((BigDecimal) obj);
                    return;
                case 9:
                    jsonWriter.value((BigInteger) obj);
                    return;
                case 10:
                    StringBuilder sb = (StringBuilder) obj;
                    jsonWriter.value(sb == null ? null : sb.toString());
                    return;
                case 11:
                    StringBuffer stringBuffer = (StringBuffer) obj;
                    jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
                    return;
                case 12:
                    URL url = (URL) obj;
                    jsonWriter.value(url == null ? null : url.toExternalForm());
                    return;
                case 13:
                    URI uri = (URI) obj;
                    jsonWriter.value(uri == null ? null : uri.toASCIIString());
                    return;
                case 14:
                    InetAddress inetAddress = (InetAddress) obj;
                    jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
                    return;
                case 15:
                    UUID uuid = (UUID) obj;
                    jsonWriter.value(uuid == null ? null : uuid.toString());
                    return;
                case 16:
                    jsonWriter.value(((Currency) obj).getCurrencyCode());
                    return;
                case 17:
                    Calendar calendar = (Calendar) obj;
                    if (calendar == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("year");
                    jsonWriter.value(calendar.get(1));
                    jsonWriter.name("month");
                    jsonWriter.value(calendar.get(2));
                    jsonWriter.name("dayOfMonth");
                    jsonWriter.value(calendar.get(5));
                    jsonWriter.name("hourOfDay");
                    jsonWriter.value(calendar.get(11));
                    jsonWriter.name("minute");
                    jsonWriter.value(calendar.get(12));
                    jsonWriter.name("second");
                    jsonWriter.value(calendar.get(13));
                    jsonWriter.endObject();
                    return;
                case 18:
                    Locale locale = (Locale) obj;
                    jsonWriter.value(locale == null ? null : locale.toString());
                    return;
                case 19:
                    write(jsonWriter, (JsonElement) obj);
                    return;
                case 20:
                    BitSet bitSet = (BitSet) obj;
                    jsonWriter.beginArray();
                    int length2 = bitSet.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        jsonWriter.value(bitSet.get(i2) ? 1L : 0L);
                    }
                    jsonWriter.endArray();
                    return;
                case 21:
                    Boolean bool = (Boolean) obj;
                    if (bool == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    jsonWriter.writeDeferredName();
                    jsonWriter.beforeValue();
                    jsonWriter.out.write(bool.booleanValue() ? "true" : "false");
                    return;
                case 22:
                    Boolean bool2 = (Boolean) obj;
                    jsonWriter.value(bool2 == null ? "null" : bool2.toString());
                    return;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    jsonWriter.value((Number) obj);
                    return;
                case 24:
                    jsonWriter.value((Number) obj);
                    return;
                case 25:
                    jsonWriter.value((Number) obj);
                    return;
                case 26:
                    jsonWriter.value(((AtomicInteger) obj).get());
                    return;
                default:
                    jsonWriter.value(((AtomicBoolean) obj).get());
                    return;
            }
        }
    }
}
