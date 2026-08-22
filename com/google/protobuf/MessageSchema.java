package com.google.protobuf;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: renamed from: com.google.protobuf.MessageSchema$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32;
        int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint33) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint33 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint33 < i4) {
            int i5 = iDecodeVarint33 + 1;
            int i6 = bArr[iDecodeVarint33];
            if (i6 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i6, bArr, i5, registers);
                i6 = registers.int1;
            } else {
                iDecodeVarint32 = i5;
            }
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i7 != 1) {
                if (i7 == 2 && i8 == metadata.valueType.getWireType()) {
                    iDecodeVarint33 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint33 = ArrayDecoders.skipField(i6, bArr, iDecodeVarint32, i2, registers);
                }
            } else if (i8 == metadata.keyType.getWireType()) {
                iDecodeVarint33 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint33 = ArrayDecoders.skipField(i6, bArr, iDecodeVarint32, i2, registers);
            }
        }
        if (iDecodeVarint33 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint65;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint33;
            case 16:
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint66;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return isFieldPresent(t, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i) {
        return (i & LEGACY_ENUM_IS_CLOSED_MASK) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            if (SchemaFor == 0) {
                SchemaFor = SchemaFor;
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            SchemaFor = SchemaFor;
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    /* JADX WARN: Code duplicated, block: B:170:0x064b A[Catch: all -> 0x0671, TRY_LEAVE, TryCatch #0 {all -> 0x0671, blocks: (B:168:0x0645, B:170:0x064b, B:182:0x0675, B:183:0x067a), top: B:204:0x0645 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0658 A[LOOP:2: B:173:0x0654->B:175:0x0658, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:177:0x066d  */
    /* JADX WARN: Code duplicated, block: B:181:0x0673 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:182:0x0675 A[Catch: all -> 0x0671, TRY_ENTER, TryCatch #0 {all -> 0x0671, blocks: (B:168:0x0645, B:170:0x064b, B:182:0x0675, B:183:0x067a), top: B:204:0x0645 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0687 A[LOOP:3: B:186:0x0683->B:188:0x0687, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:190:0x069c  */
    /* JADX WARN: Code duplicated, block: B:198:0x06b1 A[LOOP:4: B:196:0x06ad->B:198:0x06b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:227:0x0651 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x0680 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        T t2;
        UnknownFieldSchema unknownFieldSchema2;
        int i;
        Object objFilterMapUnknownEnumValues;
        T t3;
        ExtensionRegistryLite extensionRegistryLite2;
        int i2;
        Object objFilterMapUnknownEnumValues2;
        int i3;
        Object objFilterMapUnknownEnumValues3;
        Object obj;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t4 = t;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        Object builderFromMessage = null;
        Object obj2 = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    t2 = t4;
                    try {
                        int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                        try {
                            switch (type(iTypeAndOffsetAt)) {
                                case 0:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader.readDouble());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 1:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader.readFloat());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 2:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readInt64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 3:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readUInt64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 4:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readInt32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 5:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readFixed64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 6:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readFixed32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 7:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader.readBool());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 8:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readString(t2, iTypeAndOffsetAt, reader);
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 9:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeMessageField(t2, iPositionForFieldNumber, messageLite);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 10:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 11:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readUInt32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 12:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    int i4 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i4)) {
                                        UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i4);
                                        setFieldPresent(t2, iPositionForFieldNumber);
                                        builderFromMessage = obj;
                                    } else {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i4, obj, unknownFieldSchema2);
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 13:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readSFixed32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 14:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readSFixed64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 15:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readSInt32());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 16:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readSInt64());
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 17:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeMessageField(t2, iPositionForFieldNumber, messageLite2);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 18:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 19:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 20:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 21:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 22:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 24:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 25:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 26:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readStringList(t2, iTypeAndOffsetAt, reader);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readMessageList(t, iTypeAndOffsetAt, reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 28:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 29:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 30:
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 32:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 33:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 34:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 38:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 42:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 43:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt2);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 46:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 47:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 48:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 49:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    try {
                                        readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                        builderFromMessage = obj;
                                        try {
                                            if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    for (i2 = this.checkInitializedCount; i2 < this.repeatedFieldOffsetStart; i2++) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                for (i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        builderFromMessage = obj;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 50:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    try {
                                        mergeMap(t, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite, reader);
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                while (i2 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            while (i3 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        while (i < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case ONEOF_TYPE_OFFSET /* 51 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 52:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 53:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 54:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 55:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 56:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 57:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 58:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 59:
                                    readString(t2, iTypeAndOffsetAt, reader);
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 60:
                                    MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite3, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                    storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite3);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 61:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 62:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 63:
                                    int i5 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i5)) {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i5, builderFromMessage, unknownFieldSchema3);
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                        t4 = t2;
                                    }
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i5));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 64:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 65:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 67:
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                case 68:
                                    MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite4, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                    storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite4);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                                default:
                                    if (builderFromMessage == null) {
                                        try {
                                            builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t2);
                                            break;
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                            extensionRegistryLite2 = extensionRegistryLite3;
                                            unknownFieldSchema2 = unknownFieldSchema3;
                                            if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    while (i2 < this.repeatedFieldOffsetStart) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                while (i3 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            unknownFieldSchema2 = unknownFieldSchema3;
                                            objFilterMapUnknownEnumValues = builderFromMessage;
                                            while (i < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                        Object objFilterMapUnknownEnumValues4 = builderFromMessage;
                                        for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                            objFilterMapUnknownEnumValues4 = filterMapUnknownEnumValues(t, this.intArray[i6], objFilterMapUnknownEnumValues4, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues4 != null) {
                                            unknownFieldSchema3.setBuilderToMessage(t2, objFilterMapUnknownEnumValues4);
                                            return;
                                        }
                                        return;
                                    }
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    t4 = t2;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object objFilterMapUnknownEnumValues5 = builderFromMessage;
                        for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                            objFilterMapUnknownEnumValues5 = filterMapUnknownEnumValues(t, this.intArray[i7], objFilterMapUnknownEnumValues5, unknownFieldSchema, t);
                        }
                        if (objFilterMapUnknownEnumValues5 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t4, objFilterMapUnknownEnumValues5);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objFindExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite3, this.defaultInstance, fieldNumber);
                        if (objFindExtensionByNumber != null) {
                            Object mutableExtensions = obj2 == null ? extensionSchema.getMutableExtensions(t) : obj2;
                            t3 = t4;
                            try {
                                builderFromMessage = extensionSchema.parseExtension(t, reader, objFindExtensionByNumber, extensionRegistryLite, mutableExtensions, builderFromMessage, unknownFieldSchema);
                                obj2 = mutableExtensions;
                            } catch (Throwable th6) {
                                th = th6;
                                t2 = t3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                objFilterMapUnknownEnumValues = builderFromMessage;
                                while (i < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                        } else {
                            t3 = t4;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                if (builderFromMessage == null) {
                                    builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t3);
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                }
                            } else if (!reader.skipField()) {
                            }
                        }
                        t4 = t3;
                    } catch (Throwable th7) {
                        th = th7;
                        t2 = t4;
                        unknownFieldSchema2 = unknownFieldSchema3;
                        objFilterMapUnknownEnumValues = builderFromMessage;
                        while (i < this.repeatedFieldOffsetStart) {
                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                        }
                        if (objFilterMapUnknownEnumValues != null) {
                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
            objFilterMapUnknownEnumValues = builderFromMessage;
            while (i < this.repeatedFieldOffsetStart) {
                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
            }
            if (objFilterMapUnknownEnumValues != null) {
                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
            }
            throw th;
        }
        int i8 = this.checkInitializedCount;
        Object objFilterMapUnknownEnumValues6 = builderFromMessage;
        while (i8 < this.repeatedFieldOffsetStart) {
            objFilterMapUnknownEnumValues6 = filterMapUnknownEnumValues(t, this.intArray[i8], objFilterMapUnknownEnumValues6, unknownFieldSchema, t);
            i8++;
            t3 = t3;
        }
        T t5 = t3;
        if (objFilterMapUnknownEnumValues6 != null) {
            unknownFieldSchema3.setBuilderToMessage(t5, objFilterMapUnknownEnumValues6);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t, T t2, int i) {
        if (isFieldPresent(t2, i)) {
            long jOffset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(t, i)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t, jOffset, object);
                }
                setFieldPresent(t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case ONEOF_TYPE_OFFSET /* 51 */:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
            case 67:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t, int i) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long jOffset = offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t, int i, int i2) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(t, i, i2)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset(typeAndOffsetAt(i2)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int[] iArr;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i = 0;
        int i2 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i2++;
            }
        }
        int[] iArr3 = i > 0 ? new int[i] : null;
        int[] iArr4 = i2 > 0 ? new int[i2] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < fields.length) {
            FieldInfo fieldInfo2 = fields[i3];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr2, i4, objArr);
            if (i5 < checkInitialized.length && checkInitialized[i5] == fieldNumber3) {
                checkInitialized[i5] = i4;
                i5++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr3[i6] = i4;
                i6++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    iArr4[i7] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i7++;
                }
                i3++;
                i4 += 3;
            }
            i3++;
            i4 += 3;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        if (iArr4 == null) {
            iArr4 = EMPTY_INT_ARRAY;
        }
        int length2 = checkInitialized.length + iArr3.length + iArr4.length;
        if (length2 > 0) {
            iArr = new int[length2];
            System.arraycopy(checkInitialized, 0, iArr, 0, checkInitialized.length);
            System.arraycopy(iArr3, 0, iArr, checkInitialized.length, iArr3.length);
            System.arraycopy(iArr4, 0, iArr, checkInitialized.length + iArr3.length, iArr4.length);
        } else {
            iArr = EMPTY_INT_ARRAY;
        }
        return new MessageSchema<>(iArr2, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), true, iArr, checkInitialized.length, checkInitialized.length + iArr3.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0254  */
    /* JADX WARN: Code duplicated, block: B:123:0x0258  */
    /* JADX WARN: Code duplicated, block: B:126:0x0270  */
    /* JADX WARN: Code duplicated, block: B:128:0x0274  */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Object[] objArr;
        int iObjectFieldOffset;
        int i21;
        int i22;
        int i23;
        int iObjectFieldOffset2;
        java.lang.reflect.Field fieldReflectField;
        int i24;
        char cCharAt9;
        int i25;
        int i26;
        int i27;
        Object obj;
        java.lang.reflect.Field fieldReflectField2;
        int i28;
        Object obj2;
        java.lang.reflect.Field fieldReflectField3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (stringInfo.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = stringInfo.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = stringInfo.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i6 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            iArr = EMPTY_INT_ARRAY;
            i2 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = stringInfo.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = stringInfo.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = stringInfo.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = stringInfo.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = stringInfo.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = stringInfo.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = stringInfo.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = stringInfo.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = stringInfo.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = stringInfo.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = stringInfo.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = stringInfo.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = stringInfo.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = stringInfo.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = stringInfo.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = stringInfo.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            int i61 = (iCharAt4 * 2) + iCharAt5;
            i2 = iCharAt4;
            i3 = iCharAt9;
            i34 = i58;
            i4 = iCharAt7;
            i5 = iCharAt6;
            i6 = i61;
            iArr = iArr2;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[iCharAt * 2];
        int i62 = i3 + iCharAt2;
        int i63 = i3;
        int i64 = i62;
        int i65 = 0;
        int i66 = 0;
        while (i34 < length) {
            int i67 = i34 + 1;
            int iCharAt10 = stringInfo.charAt(i34);
            if (iCharAt10 >= c) {
                int i68 = iCharAt10 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i31 = i69 + 1;
                    cCharAt12 = stringInfo.charAt(i69);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i68 |= (cCharAt12 & 8191) << i70;
                    i70 += 13;
                    i69 = i31;
                }
                iCharAt10 = i68 | (cCharAt12 << i70);
                i15 = i31;
            } else {
                i15 = i67;
            }
            int i71 = i15 + 1;
            int iCharAt11 = stringInfo.charAt(i15);
            if (iCharAt11 >= c) {
                int i72 = iCharAt11 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i30 = i73 + 1;
                    cCharAt11 = stringInfo.charAt(i73);
                    i16 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i72 |= (cCharAt11 & 8191) << i74;
                    i74 += 13;
                    i73 = i30;
                    length = i16;
                }
                iCharAt11 = i72 | (cCharAt11 << i74);
                i17 = i30;
            } else {
                i16 = length;
                i17 = i71;
            }
            int i75 = iCharAt11 & 255;
            int i76 = i4;
            if ((iCharAt11 & CHECK_INITIALIZED_BIT) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i77 = i65;
            if (i75 >= ONEOF_TYPE_OFFSET) {
                int i78 = i17 + 1;
                int iCharAt12 = stringInfo.charAt(i17);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = 13;
                    while (true) {
                        i29 = i78 + 1;
                        cCharAt10 = stringInfo.charAt(i78);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i80;
                        i80 += 13;
                        i78 = i29;
                        c2 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i80);
                    i78 = i29;
                }
                int i81 = i75 - 51;
                int i82 = i78;
                if (i81 == 9 || i81 == 17) {
                    i26 = i6 + 1;
                    objArr2[((i66 / 3) * 2) + 1] = objects[i6];
                } else {
                    if (i81 == 12 && (rawMessageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (iCharAt11 & LEGACY_ENUM_IS_CLOSED_BIT) != 0)) {
                        i26 = i6 + 1;
                        objArr2[((i66 / 3) * 2) + 1] = objects[i6];
                    }
                    i27 = iCharAt12 * 2;
                    obj = objects[i27];
                    if (obj instanceof java.lang.reflect.Field) {
                        fieldReflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i27] = fieldReflectField2;
                    }
                    int i83 = i5;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i28 = i27 + 1;
                    obj2 = objects[i28];
                    int i84 = i6;
                    if (obj2 instanceof java.lang.reflect.Field) {
                        fieldReflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i28] = fieldReflectField3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    i18 = i84;
                    i21 = i82;
                    i20 = iCharAt10;
                    i19 = i83;
                    objArr = objects;
                    i23 = iObjectFieldOffset3;
                    i22 = 0;
                }
                i6 = i26;
                i27 = iCharAt12 * 2;
                obj = objects[i27];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i27] = fieldReflectField2;
                }
                int i85 = i5;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i28 = i27 + 1;
                obj2 = objects[i28];
                int i86 = i6;
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i28] = fieldReflectField3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i18 = i86;
                i21 = i82;
                i20 = iCharAt10;
                i19 = i85;
                objArr = objects;
                i23 = iObjectFieldOffset4;
                i22 = 0;
            } else {
                int i87 = i5;
                i18 = i6 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i6]);
                i19 = i87;
                if (i75 == 9 || i75 == 17) {
                    i20 = iCharAt10;
                    objArr2[((i66 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i75 == 27 || i75 == 49) {
                        i20 = iCharAt10;
                        i25 = i6 + 2;
                        objArr2[((i66 / 3) * 2) + 1] = objects[i18];
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i20 = iCharAt10;
                        if (rawMessageInfo.getSyntax() == ProtoSyntax.PROTO2 || (iCharAt11 & LEGACY_ENUM_IS_CLOSED_BIT) != 0) {
                            i25 = i6 + 2;
                            objArr2[((i66 / 3) * 2) + 1] = objects[i18];
                        }
                    } else if (i75 == 50) {
                        int i88 = i63 + 1;
                        iArr[i63] = i66;
                        int i89 = (i66 / 3) * 2;
                        int i90 = i6 + 2;
                        objArr2[i89] = objects[i18];
                        if ((iCharAt11 & LEGACY_ENUM_IS_CLOSED_BIT) != 0) {
                            i18 = i6 + 3;
                            objArr2[i89 + 1] = objects[i90];
                            i20 = iCharAt10;
                            i63 = i88;
                        } else {
                            i63 = i88;
                            i18 = i90;
                            i20 = iCharAt10;
                        }
                    } else {
                        i20 = iCharAt10;
                    }
                    i18 = i25;
                }
                objArr = objects;
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) == 0 || i75 > 17) {
                    iObjectFieldOffset = 1048575;
                    i21 = i17;
                    i22 = 0;
                } else {
                    i21 = i17 + 1;
                    int iCharAt13 = stringInfo.charAt(i17);
                    if (iCharAt13 >= 55296) {
                        int i91 = iCharAt13 & 8191;
                        int i92 = 13;
                        while (true) {
                            i24 = i21 + 1;
                            cCharAt9 = stringInfo.charAt(i21);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i91 |= (cCharAt9 & 8191) << i92;
                            i92 += 13;
                            i21 = i24;
                        }
                        iCharAt13 = i91 | (cCharAt9 << i92);
                        i21 = i24;
                    }
                    int i93 = (iCharAt13 / 32) + (i2 * 2);
                    Object obj3 = objArr[i93];
                    if (obj3 instanceof java.lang.reflect.Field) {
                        fieldReflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls, (String) obj3);
                        objArr[i93] = fieldReflectField;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField);
                    i22 = iCharAt13 % 32;
                }
                if (i75 >= 18 && i75 <= 49) {
                    iArr[i64] = iObjectFieldOffset5;
                    i64++;
                }
                int i94 = iObjectFieldOffset;
                i23 = iObjectFieldOffset5;
                iObjectFieldOffset2 = i94;
            }
            int i95 = i66 + 1;
            iArr3[i66] = i20;
            int i96 = i66 + 2;
            String str = stringInfo;
            Class<?> cls2 = cls;
            iArr3[i95] = ((iCharAt11 & UTF8_CHECK_BIT) != 0 ? ENFORCE_UTF8_MASK : 0) | ((iCharAt11 & REQUIRED_BIT) != 0 ? REQUIRED_MASK : 0) | ((iCharAt11 & LEGACY_ENUM_IS_CLOSED_BIT) != 0 ? LEGACY_ENUM_IS_CLOSED_MASK : 0) | (i75 << 20) | i23;
            i66 += 3;
            iArr3[i96] = (i22 << 20) | iObjectFieldOffset2;
            objects = objArr;
            i6 = i18;
            i34 = i21;
            i4 = i76;
            stringInfo = str;
            length = i16;
            i65 = i77;
            cls = cls2;
            i5 = i19;
            c = 55296;
        }
        return new MessageSchema<>(iArr3, objArr2, i5, i4, rawMessageInfo.getDefaultInstance(), false, iArr, i3, i62, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & 1048575;
        switch (i7) {
            case ONEOF_TYPE_OFFSET /* 51 */:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i9 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i10 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(t, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(t, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint65;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i13 = registers.int1;
                if (i13 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint33, iDecodeVarint33 + i13)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, iDecodeVarint33, i13, Internal.UTF_8));
                    iDecodeVarint33 += i13;
                }
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint33;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t, i4, i8);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i8), bArr, i, i2, registers);
                storeOneofMessageField(t, i4, i8, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i4);
                return iDecodeBytes;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint34 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                    unsafe.putObject(t, j, Integer.valueOf(i14));
                    unsafe.putInt(t, j2, i4);
                } else {
                    getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                }
                return iDecodeVarint34;
            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint35 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint35;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i4);
                return iDecodeVarint66;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t, i4, i8);
                int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                storeOneofMessageField(t, i4, i8, objMutableOneofMessageFieldForMerge2);
                return iMergeGroupField;
            default:
                return i;
        }
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(protobufListMutableCopyWithCapacity2.size() * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        switch (i7) {
            case 18:
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 1 ? ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 19:
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 5 ? ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 20:
            case 21:
            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 22:
            case 29:
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 32:
            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 1 ? ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 24:
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 5 ? ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 26:
                if (i5 == 2) {
                    return (j & 536870912) == 0 ? ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                return i;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return i5 == 2 ? ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 28:
                return i5 == 2 ? ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 30:
            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                if (i5 == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                } else {
                    if (i5 != 0) {
                        return i;
                    }
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t, i4, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i6), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                return i5 == 0 ? ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            case 49:
                return i5 == 3 ? ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : i;
            default:
                return i;
        }
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Field ", str, " for ");
            sbM21m.append(cls.getName());
            sbM21m.append(" not found. Known fields are ");
            sbM21m.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbM21m.toString());
        }
    }

    private void setFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t, j, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t, j));
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i == iNumberAt) {
                return i4;
            }
            if (i < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007a  */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x009e  */
    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:31:0x00af  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, Object[] objArr) {
        int iObjectFieldOffset;
        int iId;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        int i2;
        Class<?> messageFieldClass;
        int i3;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof == null) {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            iId = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fieldInfo.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i] = fieldInfo.getFieldNumber();
            int i4 = i + 1;
            if (fieldInfo.isEnforceUtf8()) {
                i2 = ENFORCE_UTF8_MASK;
            } else {
                i2 = 0;
            }
            iArr[i4] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | i2 | (iId << 20) | iObjectFieldOffset;
            iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i3 = (i / 3) * 2;
            objArr[i3] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i3 + 1] = messageFieldClass;
            } else if (fieldInfo.getEnumVerifier() != null) {
                objArr[i3 + 1] = fieldInfo.getEnumVerifier();
            }
        }
        iId = fieldInfo.getType().id() + ONEOF_TYPE_OFFSET;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        int i5 = i + 1;
        if (fieldInfo.isEnforceUtf8()) {
            i2 = ENFORCE_UTF8_MASK;
        } else {
            i2 = 0;
        }
        iArr[i5] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | i2 | (iId << 20) | iObjectFieldOffset;
        iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        messageFieldClass = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objArr[((i / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i3 = (i / 3) * 2;
        objArr[i3] = fieldInfo.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objArr[i3 + 1] = messageFieldClass;
        } else if (fieldInfo.getEnumVerifier() != null) {
            objArr[i3 + 1] = fieldInfo.getEnumVerifier();
        }
    }

    private void storeMessageField(T t, int i, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t, i);
    }

    private void storeOneofMessageField(T t, int i, int i2, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i2)), obj);
        setOneofPresent(t, i, i2);
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    private void writeFieldsInAscendingOrder(T t, Writer writer) {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i;
        Map.Entry<?, ?> entry2;
        int i2;
        int i3;
        Map.Entry<?, ?> entry3;
        boolean z;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator it2 = extensions.iterator();
                entry = (Map.Entry) it2.next();
                it = it2;
            }
        } else {
            entry = null;
            it = null;
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i7);
            int iNumberAt = numberAt(i7);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i8 = this.buffer[i7 + 2];
                int i9 = i8 & i4;
                if (i9 != i5) {
                    i6 = i9 == i4 ? 0 : unsafe.getInt(t, i9);
                    i5 = i9;
                } else {
                    entry = entry;
                }
                int i10 = 1 << (i8 >>> 20);
                i = i5;
                i2 = i10;
                entry2 = entry;
            } else {
                i = i5;
                entry2 = entry;
                i2 = 0;
            }
            int i11 = i6;
            while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                    }
                    break;
                case 1:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    }
                    break;
                case 2:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 3:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 4:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 5:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 6:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 7:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    }
                    break;
                case 8:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 9:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                    }
                    break;
                case 10:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 11:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 12:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 13:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 14:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 15:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 16:
                    i3 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 17:
                    entry3 = entry2;
                    i3 = length;
                    if (isFieldPresent(t, i7, i, i11, i2)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                    }
                    break;
                case 18:
                    z = false;
                    SchemaUtil.writeDoubleList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 19:
                    z = false;
                    SchemaUtil.writeFloatList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 20:
                    z = false;
                    SchemaUtil.writeInt64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 21:
                    z = false;
                    SchemaUtil.writeUInt64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 22:
                    z = false;
                    SchemaUtil.writeInt32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    z = false;
                    SchemaUtil.writeFixed64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 24:
                    z = false;
                    SchemaUtil.writeFixed32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 25:
                    z = false;
                    SchemaUtil.writeBoolList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    SchemaUtil.writeMessageList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i7));
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 29:
                    z = false;
                    SchemaUtil.writeUInt32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 30:
                    z = false;
                    SchemaUtil.writeEnumList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    z = false;
                    SchemaUtil.writeSFixed32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 32:
                    z = false;
                    SchemaUtil.writeSFixed64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 33:
                    z = false;
                    SchemaUtil.writeSInt32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 34:
                    z = false;
                    SchemaUtil.writeSInt64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, false);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    SchemaUtil.writeDoubleList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    SchemaUtil.writeFloatList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    SchemaUtil.writeInt64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    SchemaUtil.writeInt32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    SchemaUtil.writeFixed64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    SchemaUtil.writeFixed32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    SchemaUtil.writeEnumList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    SchemaUtil.writeSFixed32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, true);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i7), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i7));
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i7);
                    i3 = length;
                    entry3 = entry2;
                    break;
                case ONEOF_TYPE_OFFSET /* 51 */:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                    }
                    i3 = length;
                    entry3 = entry2;
                    break;
                default:
                    i3 = length;
                    entry3 = entry2;
                    break;
            }
            i7 += 3;
            i5 = i;
            entry = entry3;
            i6 = i11;
            length = i3;
            i4 = 1048575;
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T t, Writer writer) {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        } else {
            itDescendingIterator = null;
            entry = null;
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, length)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), length);
                    break;
                case ONEOF_TYPE_OFFSET /* 51 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0079 A[PHI: r12
  0x0079: PHI (r12v4 int) = 
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v8 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v9 int)
  (r12v1 int)
  (r12v10 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v11 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v1 int)
  (r12v12 int)
  (r12v1 int)
 binds: [B:21:0x0060, B:227:0x0563, B:224:0x054d, B:218:0x0525, B:215:0x0506, B:212:0x04e9, B:209:0x04ce, B:206:0x04b3, B:203:0x049b, B:200:0x0485, B:197:0x046b, B:194:0x0450, B:191:0x042f, B:167:0x0331, B:161:0x0313, B:155:0x02f5, B:149:0x02d7, B:143:0x02b9, B:137:0x029b, B:131:0x027d, B:125:0x025f, B:119:0x0241, B:113:0x0224, B:107:0x0207, B:101:0x01ea, B:95:0x01cd, B:93:0x01be, B:88:0x01ac, B:83:0x0178, B:80:0x016c, B:77:0x015c, B:74:0x014c, B:71:0x013c, B:68:0x0130, B:65:0x0124, B:62:0x0118, B:59:0x0109, B:55:0x00f9, B:53:0x00f3, B:51:0x00e5, B:48:0x00d4, B:45:0x00c5, B:42:0x00b6, B:40:0x00b0, B:38:0x00a9, B:35:0x009e, B:32:0x008f, B:29:0x0080, B:26:0x0078, B:24:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t) {
        int i;
        int i2;
        int i3;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        int iComputeSFixed32Size;
        boolean z;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i7);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i7);
            int i9 = this.buffer[i7 + 2];
            int i10 = i9 & i4;
            if (iType <= 17) {
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(t, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            if (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) {
                i10 = 0;
            }
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i8 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        Object object = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i8 = iComputeBytesSize + i8;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                        i8 += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i8 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i7, i, i2, i3)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeMessage;
                    break;
                case 19:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i8 += iComputeSizeMessage;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                    i8 += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i8 += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeMessage;
                    break;
                case 30:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i8 += iComputeSizeFixed32List;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i10, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i8 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                    i8 += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i7));
                    i8 += iComputeSizeMessage;
                    break;
                case ONEOF_TYPE_OFFSET /* 51 */:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i8 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i8 = iComputeBytesSize + i8;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                        i8 += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i8 += iComputeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i8 += iComputeBoolSize;
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i8 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i7)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i7));
                        i8 += iComputeBoolSize;
                    }
                    break;
                default:
                    break;
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        int unknownFieldsSerializedSize = i8 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int i2;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i3 = iHashLong + i;
                    break;
                case 1:
                    i = i3 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 2:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 3:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 5:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 7:
                    i = i3 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 8:
                    i = i3 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 14:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i3 = i2 + iOneofIntAt;
                    break;
                case 16:
                    i = i3 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i3 = iHashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                case 24:
                case 25:
                case 26:
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                case 28:
                case 29:
                case 30:
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                case 32:
                case 33:
                case 34:
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                case 38:
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                case 42:
                case 43:
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i3 = iHashLong + i;
                    break;
                case 50:
                    i = i3 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i3 = iHashLong + i;
                    break;
                case ONEOF_TYPE_OFFSET /* 51 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i3 = iHashLong + i;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i2 = i3 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i3 = i2 + iOneofIntAt;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i3 = iHashLong + i;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        i = i3 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i3 = iHashLong + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t).hashCode() + (i3 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:58:0x008f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa A[SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int iNumberAt = numberAt(i6);
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = UNSAFE.getInt(t, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i3;
                i2 = i4;
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t, i6, i, i2, i9)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t, i6, i, i2, i9) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t, iNumberAt, i6) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (!isListInitialized(t, iTypeAndOffsetAt, i6)) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x007c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t) {
        if (isMutable(t)) {
            if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(t, i)) {
                                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                            case 24:
                            case 25:
                            case 26:
                            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                            case 28:
                            case 29:
                            case 30:
                            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                            case 32:
                            case 33:
                            case 34:
                            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                            case 38:
                            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                            case 42:
                            case 43:
                            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t, jOffset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t, jOffset);
                                if (object != null) {
                                    unsafe.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
                                }
                                break;
                        }
                    } else if (isOneofPresent(t, numberAt(i), i)) {
                        getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                    }
                } else if (isFieldPresent(t, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        checkMutable(t);
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009a. Please report as an issue. */
    public int parseMessage(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) {
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int i4;
        int i5;
        int i6;
        int i7;
        T t2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte[] bArr2;
        int i15;
        int i16;
        byte b;
        byte[] bArr3;
        int iDecodeVarint64;
        int i17;
        int i18;
        MessageSchema<T> messageSchema2 = this;
        T t3 = t;
        byte[] bArr4 = bArr;
        i2 = i2;
        i3 = i3;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(t);
        Unsafe unsafe2 = UNSAFE;
        int iDecodeUnknownField = i;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = 1048575;
        while (true) {
            if (iDecodeUnknownField < i2) {
                int i24 = iDecodeUnknownField + 1;
                byte b2 = bArr4[iDecodeUnknownField];
                if (b2 < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b2, bArr4, i24, registers2);
                    i8 = registers2.int1;
                    i24 = iDecodeVarint32;
                } else {
                    i8 = b2;
                }
                int i25 = i8 >>> 3;
                int i26 = i8 & 7;
                int iPositionForFieldNumber = i25 > i22 ? messageSchema2.positionForFieldNumber(i25, i19 / 3) : messageSchema2.positionForFieldNumber(i25);
                if (iPositionForFieldNumber == -1) {
                    i9 = i25;
                    i10 = i24;
                    i5 = i8;
                    i11 = i21;
                    i12 = i23;
                    unsafe = unsafe2;
                    i3 = i3;
                    i13 = 0;
                } else {
                    int i27 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i27);
                    long jOffset = offset(i27);
                    int i28 = i8;
                    if (iType <= 17) {
                        int i29 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i30 = 1 << (i29 >>> 20);
                        int i31 = 1048575;
                        int i32 = i29 & 1048575;
                        if (i32 != i23) {
                            if (i23 != 1048575) {
                                unsafe2.putInt(t3, i23, i21);
                                i31 = 1048575;
                            }
                            i12 = i32;
                            i14 = i32 == i31 ? 0 : unsafe2.getInt(t3, i32);
                        } else {
                            i14 = i21;
                            i12 = i23;
                        }
                        switch (iType) {
                            case 0:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 1) {
                                    UnsafeUtil.putDouble(t3, jOffset, ArrayDecoders.decodeDouble(bArr2, i24));
                                    iDecodeUnknownField = i24 + 8;
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 1:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 5) {
                                    UnsafeUtil.putFloat(t3, jOffset, ArrayDecoders.decodeFloat(bArr2, i24));
                                    iDecodeUnknownField = i24 + 4;
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i24, registers2);
                                    unsafe2.putLong(t, jOffset, registers2.long1);
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr3;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i24, registers2);
                                    unsafe2.putInt(t3, jOffset, registers2.int1);
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 1) {
                                    unsafe2.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr2, i24));
                                    iDecodeUnknownField = i24 + 8;
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 5) {
                                    unsafe2.putInt(t3, jOffset, ArrayDecoders.decodeFixed32(bArr2, i24));
                                    iDecodeUnknownField = i24 + 4;
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i24, registers2);
                                    UnsafeUtil.putBoolean(t3, jOffset, registers2.long1 != 0);
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 2) {
                                    iDecodeUnknownField = isEnforceUtf8(i27) ? ArrayDecoders.decodeStringRequireUtf8(bArr2, i24, registers2) : ArrayDecoders.decodeString(bArr2, i24, registers2);
                                    unsafe2.putObject(t3, jOffset, registers2.object1);
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 2) {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t3, i15);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i15), bArr, i24, i2, registers);
                                    messageSchema2.storeMessageField(t3, i15, objMutableMessageFieldForMerge);
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 2) {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i24, registers2);
                                    unsafe2.putObject(t3, jOffset, registers2.object1);
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i24, registers2);
                                    int i33 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i15);
                                    if (!isLegacyEnumIsClosed(i27) || enumFieldVerifier == null || enumFieldVerifier.isInRange(i33)) {
                                        unsafe2.putInt(t3, jOffset, i33);
                                        i21 = i14 | i30;
                                        i19 = i15;
                                        bArr4 = bArr2;
                                        i20 = i16;
                                        i23 = i12;
                                        i22 = i9;
                                    } else {
                                        getMutableUnknownFields(t).storeField(i16, Long.valueOf(i33));
                                        i3 = i3;
                                        i19 = i15;
                                        i21 = i14;
                                        i20 = i16;
                                        i23 = i12;
                                        i22 = i9;
                                        bArr4 = bArr2;
                                    }
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                if (i26 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i24, registers2);
                                    unsafe2.putInt(t3, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr2;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 16:
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                bArr3 = bArr;
                                if (i26 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i24, registers2);
                                    unsafe2.putLong(t, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i21 = i14 | i30;
                                    i19 = i15;
                                    bArr4 = bArr3;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            case 17:
                                if (i26 == 3) {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t3, iPositionForFieldNumber);
                                    i9 = i25;
                                    i16 = i28;
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i24, i2, (i25 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t3, iPositionForFieldNumber, objMutableMessageFieldForMerge2);
                                    i21 = i14 | i30;
                                    bArr4 = bArr;
                                    i19 = iPositionForFieldNumber;
                                    i20 = i16;
                                    i23 = i12;
                                    i22 = i9;
                                } else {
                                    i9 = i25;
                                    i16 = i28;
                                    b = -1;
                                    i15 = iPositionForFieldNumber;
                                    i3 = i3;
                                    i10 = i24;
                                    i13 = i15;
                                    unsafe = unsafe2;
                                    i11 = i14;
                                    i5 = i16;
                                }
                                break;
                            default:
                                i9 = i25;
                                i15 = iPositionForFieldNumber;
                                i16 = i28;
                                b = -1;
                                i3 = i3;
                                i10 = i24;
                                i13 = i15;
                                unsafe = unsafe2;
                                i11 = i14;
                                i5 = i16;
                                break;
                        }
                    } else {
                        i9 = i25;
                        int i34 = i23;
                        i11 = i21;
                        if (iType != 27) {
                            i12 = i34;
                            if (iType <= 49) {
                                int i35 = i24;
                                unsafe = unsafe2;
                                i13 = iPositionForFieldNumber;
                                i18 = i28;
                                iDecodeUnknownField = parseRepeatedField(t, bArr, i24, i2, i28, i9, i26, iPositionForFieldNumber, i27, iType, jOffset, registers);
                                if (iDecodeUnknownField != i35) {
                                    messageSchema2 = this;
                                    t3 = t;
                                    bArr4 = bArr;
                                    i3 = i3;
                                    registers2 = registers;
                                    i20 = i18;
                                    i21 = i11;
                                    i19 = i13;
                                    i23 = i12;
                                    i22 = i9;
                                    unsafe2 = unsafe;
                                } else {
                                    i10 = iDecodeUnknownField;
                                    i5 = i18;
                                }
                            } else {
                                i17 = i24;
                                unsafe = unsafe2;
                                i13 = iPositionForFieldNumber;
                                i18 = i28;
                                if (iType != 50) {
                                    iDecodeUnknownField = parseOneofField(t, bArr, i17, i2, i18, i9, i26, i27, iType, jOffset, i13, registers);
                                    if (iDecodeUnknownField != i17) {
                                        messageSchema2 = this;
                                        t3 = t;
                                        bArr4 = bArr;
                                        i3 = i3;
                                        registers2 = registers;
                                        i20 = i18;
                                        i21 = i11;
                                        i19 = i13;
                                        i23 = i12;
                                        i22 = i9;
                                        unsafe2 = unsafe;
                                    } else {
                                        i10 = iDecodeUnknownField;
                                        i5 = i18;
                                    }
                                } else if (i26 == 2) {
                                    iDecodeUnknownField = parseMapField(t, bArr, i17, i2, i13, jOffset, registers);
                                    if (iDecodeUnknownField != i17) {
                                        messageSchema2 = this;
                                        t3 = t;
                                        bArr4 = bArr;
                                        i3 = i3;
                                        registers2 = registers;
                                        i20 = i18;
                                        i21 = i11;
                                        i19 = i13;
                                        i23 = i12;
                                        i22 = i9;
                                        unsafe2 = unsafe;
                                    } else {
                                        i10 = iDecodeUnknownField;
                                        i5 = i18;
                                    }
                                }
                            }
                        } else if (i26 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t3, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t3, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), i28, bArr, i24, i2, protobufListMutableCopyWithCapacity2, registers);
                            i3 = i3;
                            i19 = iPositionForFieldNumber;
                            i20 = i28;
                            i21 = i11;
                            i23 = i34;
                            i22 = i9;
                            bArr4 = bArr;
                        } else {
                            i12 = i34;
                            i17 = i24;
                            unsafe = unsafe2;
                            i13 = iPositionForFieldNumber;
                            i18 = i28;
                        }
                        i10 = i17;
                        i5 = i18;
                    }
                }
                if (i5 != i3 || i3 == 0) {
                    iDecodeUnknownField = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i5, bArr, i10, i2, getMutableUnknownFields(t), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i5, bArr, i10, i2, t, this.defaultInstance, this.unknownFieldSchema, registers);
                    t3 = t;
                    bArr4 = bArr;
                    i20 = i5;
                    messageSchema2 = this;
                    registers2 = registers;
                    i21 = i11;
                    i19 = i13;
                    i23 = i12;
                    i22 = i9;
                    unsafe2 = unsafe;
                    i3 = i3;
                } else {
                    i7 = 1048575;
                    messageSchema = this;
                    i4 = i10;
                    i21 = i11;
                    i6 = i12;
                }
            } else {
                int i36 = i23;
                unsafe = unsafe2;
                i3 = i3;
                messageSchema = messageSchema2;
                i4 = iDecodeUnknownField;
                i5 = i20;
                i6 = i36;
                i7 = 1048575;
            }
        }
        if (i6 != i7) {
            t2 = t;
            unsafe.putInt(t2, i6, i21);
        } else {
            t2 = t;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i37 = messageSchema.checkInitializedCount; i37 < messageSchema.repeatedFieldOffsetStart; i37++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(t, messageSchema.intArray[i37], unknownFieldSetLite, messageSchema.unknownFieldSchema, t);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i3 == 0) {
            if (i4 != i2) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i4 > i2 || i5 != i3) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i4;
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else {
            writeFieldsInAscendingOrder(t, writer);
        }
    }

    private boolean isFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(t, j) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t, jOffset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t, jOffset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
            case 11:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t, T t2, int i) {
        int iNumberAt = numberAt(i);
        if (!isOneofPresent(t2, iNumberAt, i)) {
            return;
        }
        long jOffset = offset(typeAndOffsetAt(i));
        Unsafe unsafe = UNSAFE;
        Object object = unsafe.getObject(t2, jOffset);
        if (object != null) {
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(t, iNumberAt, i)) {
                if (!isMutable(object)) {
                    unsafe.putObject(t, jOffset, object);
                } else {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jOffset, objNewInstance);
                }
                setOneofPresent(t, iNumberAt, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + numberAt(i) + wsbWxekY.poLBeZuT + t2);
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        checkMutable(t);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    private boolean equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset));
            case 1:
                return arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset));
            case 2:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 3:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 4:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 5:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 6:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 7:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean(t, jOffset) == UnsafeUtil.getBoolean(t2, jOffset);
            case 8:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 9:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 10:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 11:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 12:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 13:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 14:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 15:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset);
            case 16:
                return arePresentForEquals(t, t2, i) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset);
            case 17:
                return arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
            case 25:
            case 26:
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            case 29:
            case 30:
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case 32:
            case 33:
            case 34:
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case 42:
            case 43:
            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            case ONEOF_TYPE_OFFSET /* 51 */:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
            case 67:
            case 68:
                return isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset));
            default:
                return true;
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) {
        parseMessage(t, bArr, i, i2, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }
}
