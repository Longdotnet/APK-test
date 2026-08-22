package com.google.protobuf.util;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.SingletonImmutableSet;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$Base64Encoding;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.stream.JsonReader;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Duration;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.StringValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt64Value;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.logging.Logger;
import kotlin.io.TextStreamsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
public class JsonFormat {
    private static final Logger logger = Logger.getLogger(JsonFormat.class.getName());

    /* JADX INFO: renamed from: com.google.protobuf.util.JsonFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public static final class CompactTextGenerator implements TextGenerator {
        private final Appendable output;

        public /* synthetic */ CompactTextGenerator(Appendable appendable, AnonymousClass1 anonymousClass1) {
            this(appendable);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void indent() {
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void outdent() {
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void print(CharSequence charSequence) throws IOException {
            this.output.append(charSequence);
        }

        private CompactTextGenerator(Appendable appendable) {
            this.output = appendable;
        }
    }

    public static class Parser {
        private static final int DEFAULT_RECURSION_LIMIT = 100;
        private final boolean ignoringUnknownFields;
        private final TypeRegistry oldRegistry;
        private final int recursionLimit;
        private final com.google.protobuf.TypeRegistry registry;

        public /* synthetic */ Parser(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, int i, AnonymousClass1 anonymousClass1) {
            this(typeRegistry, typeRegistry2, z, i);
        }

        public Parser ignoringUnknownFields() {
            return new Parser(this.registry, this.oldRegistry, true, this.recursionLimit);
        }

        public void merge(String str, Message.Builder builder) {
            new ParserImpl(this.registry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit).merge(str, builder);
        }

        public Parser usingRecursionLimit(int i) {
            return new Parser(this.registry, this.oldRegistry, this.ignoringUnknownFields, i);
        }

        public Parser usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Parser(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), typeRegistry, this.ignoringUnknownFields, this.recursionLimit);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        private Parser(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, int i) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.ignoringUnknownFields = z;
            this.recursionLimit = i;
        }

        public void merge(Reader reader, Message.Builder builder) throws IOException {
            new ParserImpl(this.registry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit).merge(reader, builder);
        }

        public Parser usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Parser(typeRegistry, this.oldRegistry, this.ignoringUnknownFields, this.recursionLimit);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }
    }

    public static class ParserImpl {
        private static final double EPSILON = 1.0E-6d;
        private static final BigDecimal MAX_DOUBLE;
        private static final BigDecimal MIN_DOUBLE;
        private static final BigDecimal MORE_THAN_ONE;
        private final boolean ignoringUnknownFields;
        private final TypeRegistry oldRegistry;
        private final int recursionLimit;
        private final com.google.protobuf.TypeRegistry registry;
        private static final Map<String, WellKnownTypeParser> wellKnownTypeParsers = buildWellKnownTypeParsers();
        private static final BigInteger MAX_UINT32 = new BigInteger("FFFFFFFF", 16);
        private static final BigInteger MAX_UINT64 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
        private final Map<Descriptors.Descriptor, Map<String, Descriptors.FieldDescriptor>> fieldNameMaps = new HashMap();
        private int currentDepth = 0;

        public interface WellKnownTypeParser {
            void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder);
        }

        static {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(1.000001d));
            MORE_THAN_ONE = bigDecimal;
            MAX_DOUBLE = new BigDecimal(String.valueOf(Double.MAX_VALUE)).multiply(bigDecimal);
            MIN_DOUBLE = new BigDecimal(String.valueOf(-1.7976931348623157E308d)).multiply(bigDecimal);
        }

        public ParserImpl(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, boolean z, int i) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.ignoringUnknownFields = z;
            this.recursionLimit = i;
        }

        private static Map<String, WellKnownTypeParser> buildWellKnownTypeParsers() {
            HashMap map = new HashMap();
            map.put(Any.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.1
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeAny(jsonElement, builder);
                }
            });
            WellKnownTypeParser wellKnownTypeParser = new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.2
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeWrapper(jsonElement, builder);
                }
            };
            map.put(BoolValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(Int32Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(UInt32Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(Int64Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(UInt64Value.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(StringValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(BytesValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(FloatValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(DoubleValue.getDescriptor().getFullName(), wellKnownTypeParser);
            map.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.3
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeTimestamp(jsonElement, builder);
                }
            });
            map.put(Duration.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.4
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeDuration(jsonElement, builder);
                }
            });
            map.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.5
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) {
                    parserImpl.mergeFieldMask(jsonElement, builder);
                }
            });
            map.put(Struct.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.6
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeStruct(jsonElement, builder);
                }
            });
            map.put(ListValue.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.7
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeListValue(jsonElement, builder);
                }
            });
            map.put(Value.getDescriptor().getFullName(), new WellKnownTypeParser() { // from class: com.google.protobuf.util.JsonFormat.ParserImpl.8
                @Override // com.google.protobuf.util.JsonFormat.ParserImpl.WellKnownTypeParser
                public void merge(ParserImpl parserImpl, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
                    parserImpl.mergeValue(jsonElement, builder);
                }
            });
            return map;
        }

        private Map<String, Descriptors.FieldDescriptor> getFieldNameMap(Descriptors.Descriptor descriptor) {
            if (this.fieldNameMaps.containsKey(descriptor)) {
                return this.fieldNameMaps.get(descriptor);
            }
            HashMap map = new HashMap();
            for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
                map.put(fieldDescriptor.getName(), fieldDescriptor);
                map.put(fieldDescriptor.getJsonName(), fieldDescriptor);
            }
            this.fieldNameMaps.put(descriptor, map);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAny(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("type_url");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName(FirebaseAnalytics.Param.VALUE);
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null || fieldDescriptorFindFieldByName.getType() != Descriptors.FieldDescriptor.Type.STRING || fieldDescriptorFindFieldByName2.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                throw new InvalidProtocolBufferException("Invalid Any type.");
            }
            if (!(jsonElement instanceof JsonObject)) {
                throw new InvalidProtocolBufferException("Expect message object but got: " + jsonElement);
            }
            JsonObject jsonObject = (JsonObject) jsonElement;
            if (((AbstractCollection) jsonObject.members.entrySet()).isEmpty()) {
                return;
            }
            LinkedTreeMap linkedTreeMap = jsonObject.members;
            JsonElement jsonElement2 = (JsonElement) linkedTreeMap.get("@type");
            if (jsonElement2 == null) {
                throw new InvalidProtocolBufferException("Missing type url when parsing: " + jsonElement);
            }
            String asString = jsonElement2.getAsString();
            Descriptors.Descriptor descriptorForTypeUrl = this.registry.getDescriptorForTypeUrl(asString);
            if (descriptorForTypeUrl == null && (descriptorForTypeUrl = this.oldRegistry.getDescriptorForTypeUrl(asString)) == null) {
                throw new InvalidProtocolBufferException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Cannot resolve type: ", asString));
            }
            builder.setField(fieldDescriptorFindFieldByName, asString);
            DynamicMessage.Builder builderNewBuilderForType = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
            WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(descriptorForTypeUrl.getFullName());
            if (wellKnownTypeParser != null) {
                JsonElement jsonElement3 = (JsonElement) linkedTreeMap.get(FirebaseAnalytics.Param.VALUE);
                if (jsonElement3 != null) {
                    wellKnownTypeParser.merge(this, jsonElement3, builderNewBuilderForType);
                }
            } else {
                mergeMessage(jsonElement, builderNewBuilderForType, true);
            }
            builder.setField(fieldDescriptorFindFieldByName2, builderNewBuilderForType.build().toByteString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDuration(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                builder.mergeFrom(Durations.parse(jsonElement.getAsString()).toByteString());
            } catch (UnsupportedOperationException | ParseException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Failed to parse duration: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        private void mergeField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (fieldDescriptor.isRepeated()) {
                if (builder.getRepeatedFieldCount(fieldDescriptor) > 0) {
                    throw new InvalidProtocolBufferException("Field " + fieldDescriptor.getFullName() + " has already been set.");
                }
            } else if (builder.hasField(fieldDescriptor)) {
                throw new InvalidProtocolBufferException("Field " + fieldDescriptor.getFullName() + " has already been set.");
            }
            if (fieldDescriptor.isRepeated() && (jsonElement instanceof JsonNull)) {
                return;
            }
            if (fieldDescriptor.isMapField()) {
                mergeMapField(fieldDescriptor, jsonElement, builder);
                return;
            }
            if (fieldDescriptor.isRepeated()) {
                mergeRepeatedField(fieldDescriptor, jsonElement, builder);
                return;
            }
            if (fieldDescriptor.getContainingOneof() != null) {
                mergeOneofField(fieldDescriptor, jsonElement, builder);
                return;
            }
            Object fieldValue = parseFieldValue(fieldDescriptor, jsonElement, builder);
            if (fieldValue != null) {
                builder.setField(fieldDescriptor, fieldValue);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFieldMask(JsonElement jsonElement, Message.Builder builder) {
            builder.mergeFrom(FieldMaskUtil.fromJsonString(jsonElement.getAsString()).toByteString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeListValue(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = builder.getDescriptorForType().findFieldByName("values");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid ListValue type.");
            }
            mergeRepeatedField(fieldDescriptorFindFieldByName, jsonElement, builder);
        }

        private void mergeMapField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (!(jsonElement instanceof JsonObject)) {
                throw new InvalidProtocolBufferException("Expect a map object but found: " + jsonElement);
            }
            Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageType.findFieldByName("key");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = messageType.findFieldByName(FirebaseAnalytics.Param.VALUE);
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null) {
                throw new InvalidProtocolBufferException("Invalid map field: " + fieldDescriptor.getFullName());
            }
            for (Map.Entry entry : (LinkedTreeMap.KeySet) ((JsonObject) jsonElement).members.entrySet()) {
                Message.Builder builderNewBuilderForField = builder.newBuilderForField(fieldDescriptor);
                Object fieldValue = parseFieldValue(fieldDescriptorFindFieldByName, new JsonPrimitive((String) entry.getKey()), builderNewBuilderForField);
                Object fieldValue2 = parseFieldValue(fieldDescriptorFindFieldByName2, (JsonElement) entry.getValue(), builderNewBuilderForField);
                if (fieldValue2 != null) {
                    builderNewBuilderForField.setField(fieldDescriptorFindFieldByName, fieldValue);
                    builderNewBuilderForField.setField(fieldDescriptorFindFieldByName2, fieldValue2);
                    builder.addRepeatedField(fieldDescriptor, builderNewBuilderForField.build());
                } else if (!this.ignoringUnknownFields || fieldDescriptorFindFieldByName2.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                    throw new InvalidProtocolBufferException("Map value cannot be null.");
                }
            }
        }

        private void mergeMessage(JsonElement jsonElement, Message.Builder builder, boolean z) throws InvalidProtocolBufferException {
            if (!(jsonElement instanceof JsonObject)) {
                throw new InvalidProtocolBufferException("Expect message object but got: " + jsonElement);
            }
            Map<String, Descriptors.FieldDescriptor> fieldNameMap = getFieldNameMap(builder.getDescriptorForType());
            for (Map.Entry entry : (LinkedTreeMap.KeySet) ((JsonObject) jsonElement).members.entrySet()) {
                if (!z || !((String) entry.getKey()).equals("@type")) {
                    Descriptors.FieldDescriptor fieldDescriptor = fieldNameMap.get(entry.getKey());
                    if (fieldDescriptor != null) {
                        mergeField(fieldDescriptor, (JsonElement) entry.getValue(), builder);
                    } else if (!this.ignoringUnknownFields) {
                        throw new InvalidProtocolBufferException("Cannot find field: " + ((String) entry.getKey()) + " in message " + builder.getDescriptorForType().getFullName());
                    }
                }
            }
        }

        private void mergeOneofField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Object fieldValue = parseFieldValue(fieldDescriptor, jsonElement, builder);
            if (fieldValue == null) {
                return;
            }
            if (builder.getOneofFieldDescriptor(fieldDescriptor.getContainingOneof()) == null) {
                builder.setField(fieldDescriptor, fieldValue);
                return;
            }
            throw new InvalidProtocolBufferException("Cannot set field " + fieldDescriptor.getFullName() + " because another field " + builder.getOneofFieldDescriptor(fieldDescriptor.getContainingOneof()).getFullName() + " belonging to the same oneof has already been set ");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStruct(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = builder.getDescriptorForType().findFieldByName("fields");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid Struct type.");
            }
            mergeMapField(fieldDescriptorFindFieldByName, jsonElement, builder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimestamp(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                builder.mergeFrom(Timestamps.parse(jsonElement.getAsString()).toByteString());
            } catch (UnsupportedOperationException | ParseException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Failed to parse timestamp: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeValue(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            if (jsonElement instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
                Serializable serializable = jsonPrimitive.value;
                if (serializable instanceof Boolean) {
                    builder.setField(descriptorForType.findFieldByName("bool_value"), Boolean.valueOf(jsonPrimitive.getAsBoolean()));
                    return;
                } else if (serializable instanceof Number) {
                    builder.setField(descriptorForType.findFieldByName("number_value"), Double.valueOf(jsonPrimitive.value instanceof Number ? jsonPrimitive.getAsNumber().doubleValue() : Double.parseDouble(jsonPrimitive.getAsString())));
                    return;
                } else {
                    builder.setField(descriptorForType.findFieldByName("string_value"), jsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement instanceof JsonObject) {
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("struct_value");
                Message.Builder builderNewBuilderForField = builder.newBuilderForField(fieldDescriptorFindFieldByName);
                merge(jsonElement, builderNewBuilderForField);
                builder.setField(fieldDescriptorFindFieldByName, builderNewBuilderForField.build());
                return;
            }
            if (jsonElement instanceof JsonArray) {
                Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName("list_value");
                Message.Builder builderNewBuilderForField2 = builder.newBuilderForField(fieldDescriptorFindFieldByName2);
                merge(jsonElement, builderNewBuilderForField2);
                builder.setField(fieldDescriptorFindFieldByName2, builderNewBuilderForField2.build());
                return;
            }
            if (jsonElement instanceof JsonNull) {
                builder.setField(descriptorForType.findFieldByName("null_value"), NullValue.NULL_VALUE.getValueDescriptor());
            } else {
                throw new IllegalStateException("Unexpected json data: " + jsonElement);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeWrapper(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(FirebaseAnalytics.Param.VALUE);
            if (fieldDescriptorFindFieldByName != null) {
                builder.setField(fieldDescriptorFindFieldByName, parseFieldValue(fieldDescriptorFindFieldByName, jsonElement, builder));
            } else {
                throw new InvalidProtocolBufferException("Invalid wrapper type: " + descriptorForType.getFullName());
            }
        }

        private boolean parseBool(JsonElement jsonElement) throws InvalidProtocolBufferException {
            if (jsonElement.getAsString().equals("true")) {
                return true;
            }
            if (jsonElement.getAsString().equals("false")) {
                return false;
            }
            throw new InvalidProtocolBufferException("Invalid bool value: " + jsonElement);
        }

        private ByteString parseBytes(JsonElement jsonElement) {
            try {
                return ByteString.copyFrom(BaseEncoding$StandardBaseEncoding.BASE64.decode(jsonElement.getAsString()));
            } catch (IllegalArgumentException unused) {
                return ByteString.copyFrom(BaseEncoding$StandardBaseEncoding.BASE64_URL.decode(jsonElement.getAsString()));
            }
        }

        private Descriptors.EnumValueDescriptor parseEnum(Descriptors.EnumDescriptor enumDescriptor, JsonElement jsonElement) throws InvalidProtocolBufferException {
            String asString = jsonElement.getAsString();
            Descriptors.EnumValueDescriptor enumValueDescriptorFindValueByName = enumDescriptor.findValueByName(asString);
            if (enumValueDescriptorFindValueByName == null) {
                try {
                    int int32 = parseInt32(jsonElement);
                    enumValueDescriptorFindValueByName = enumDescriptor.isClosed() ? enumDescriptor.findValueByNumber(int32) : enumDescriptor.findValueByNumberCreatingIfUnknown(int32);
                } catch (InvalidProtocolBufferException unused) {
                }
                if (enumValueDescriptorFindValueByName == null && !this.ignoringUnknownFields) {
                    StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Invalid enum value: ", asString, " for enum type: ");
                    sbM21m.append(enumDescriptor.getFullName());
                    throw new InvalidProtocolBufferException(sbM21m.toString());
                }
            }
            return enumValueDescriptorFindValueByName;
        }

        private Object parseFieldValue(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (jsonElement instanceof JsonNull) {
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && fieldDescriptor.getMessageType().getFullName().equals(Value.getDescriptor().getFullName())) {
                    return builder.newBuilderForField(fieldDescriptor).mergeFrom(Value.newBuilder().setNullValueValue(0).build().toByteString()).build();
                }
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM && fieldDescriptor.getEnumType().getFullName().equals(NullValue.getDescriptor().getFullName())) {
                    return fieldDescriptor.getEnumType().findValueByNumber(0);
                }
                return null;
            }
            if ((jsonElement instanceof JsonObject) && fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.GROUP) {
                throw new InvalidProtocolBufferException(String.format("Invalid value: %s for expected type: %s", jsonElement, fieldDescriptor.getType()));
            }
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return Integer.valueOf(parseInt32(jsonElement));
                case 4:
                case 5:
                case 6:
                    return Long.valueOf(parseInt64(jsonElement));
                case 7:
                    return Boolean.valueOf(parseBool(jsonElement));
                case 8:
                    return Float.valueOf(parseFloat(jsonElement));
                case 9:
                    return Double.valueOf(parseDouble(jsonElement));
                case 10:
                case 11:
                    return Integer.valueOf(parseUint32(jsonElement));
                case 12:
                case 13:
                    return Long.valueOf(parseUint64(jsonElement));
                case 14:
                    return parseString(jsonElement);
                case 15:
                    return parseBytes(jsonElement);
                case 16:
                    return parseEnum(fieldDescriptor.getEnumType(), jsonElement);
                case 17:
                case 18:
                    int i = this.currentDepth;
                    if (i >= this.recursionLimit) {
                        throw new InvalidProtocolBufferException("Hit recursion limit.");
                    }
                    this.currentDepth = i + 1;
                    Message.Builder builderNewBuilderForField = builder.newBuilderForField(fieldDescriptor);
                    merge(jsonElement, builderNewBuilderForField);
                    this.currentDepth--;
                    return builderNewBuilderForField.build();
                default:
                    throw new InvalidProtocolBufferException("Invalid field type: " + fieldDescriptor.getType());
            }
        }

        private int parseInt32(JsonElement jsonElement) throws InvalidProtocolBufferException {
            try {
                try {
                    return Integer.parseInt(jsonElement.getAsString());
                } catch (RuntimeException unused) {
                    return new BigDecimal(jsonElement.getAsString()).intValueExact();
                }
            } catch (RuntimeException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Not an int32 value: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        private long parseInt64(JsonElement jsonElement) throws InvalidProtocolBufferException {
            try {
                try {
                    return Long.parseLong(jsonElement.getAsString());
                } catch (RuntimeException unused) {
                    return new BigDecimal(jsonElement.getAsString()).longValueExact();
                }
            } catch (RuntimeException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Not an int64 value: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        private String parseString(JsonElement jsonElement) {
            return jsonElement.getAsString();
        }

        private int parseUint32(JsonElement jsonElement) throws InvalidProtocolBufferException {
            try {
                try {
                    long j = Long.parseLong(jsonElement.getAsString());
                    if (j >= 0 && j <= 4294967295L) {
                        return (int) j;
                    }
                    throw new InvalidProtocolBufferException("Out of range uint32 value: " + jsonElement);
                } catch (RuntimeException unused) {
                    BigInteger bigIntegerExact = new BigDecimal(jsonElement.getAsString()).toBigIntegerExact();
                    if (bigIntegerExact.signum() >= 0 && bigIntegerExact.compareTo(MAX_UINT32) <= 0) {
                        return bigIntegerExact.intValue();
                    }
                    throw new InvalidProtocolBufferException("Out of range uint32 value: " + jsonElement);
                }
            } catch (RuntimeException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Not an uint32 value: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        private long parseUint64(JsonElement jsonElement) throws InvalidProtocolBufferException {
            try {
                BigInteger bigIntegerExact = new BigDecimal(jsonElement.getAsString()).toBigIntegerExact();
                if (bigIntegerExact.compareTo(BigInteger.ZERO) >= 0 && bigIntegerExact.compareTo(MAX_UINT64) <= 0) {
                    return bigIntegerExact.longValue();
                }
                throw new InvalidProtocolBufferException("Out of range uint64 value: " + jsonElement);
            } catch (RuntimeException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Not an uint64 value: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        public void merge(Reader reader, Message.Builder builder) throws IOException {
            try {
                JsonReader jsonReader = new JsonReader(reader);
                jsonReader.lenient = false;
                merge(TextStreamsKt.parseReader(jsonReader), builder);
            } catch (JsonIOException e) {
                if (!(e.getCause() instanceof IOException)) {
                    throw new InvalidProtocolBufferException(e.getMessage(), e);
                }
                throw ((IOException) e.getCause());
            } catch (RuntimeException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage(), e2);
            }
        }

        private void mergeRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            if (!(jsonElement instanceof JsonArray)) {
                throw new InvalidProtocolBufferException("Expected an array for " + fieldDescriptor.getName() + " but found " + jsonElement);
            }
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (int i = 0; i < jsonArray.elements.size(); i++) {
                Object fieldValue = parseFieldValue(fieldDescriptor, (JsonElement) jsonArray.elements.get(i), builder);
                if (fieldValue != null) {
                    builder.addRepeatedField(fieldDescriptor, fieldValue);
                } else if (!this.ignoringUnknownFields || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                    throw new InvalidProtocolBufferException(gZrKCJ.bWveXvmTuFEM + fieldDescriptor.getFullName());
                }
            }
        }

        private double parseDouble(JsonElement jsonElement) throws InvalidProtocolBufferException {
            if (jsonElement.getAsString().equals("NaN")) {
                return Double.NaN;
            }
            if (jsonElement.getAsString().equals("Infinity")) {
                return Double.POSITIVE_INFINITY;
            }
            if (jsonElement.getAsString().equals(DaWYVMJ.tBtqnVk)) {
                return Double.NEGATIVE_INFINITY;
            }
            try {
                BigDecimal bigDecimal = new BigDecimal(jsonElement.getAsString());
                if (bigDecimal.compareTo(MAX_DOUBLE) <= 0 && bigDecimal.compareTo(MIN_DOUBLE) >= 0) {
                    return bigDecimal.doubleValue();
                }
                throw new InvalidProtocolBufferException("Out of range double value: " + jsonElement);
            } catch (RuntimeException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Not a double value: " + jsonElement);
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        private float parseFloat(JsonElement jsonElement) throws InvalidProtocolBufferException {
            if (jsonElement.getAsString().equals(eoBKjVuj.jxhLOUU)) {
                return Float.NaN;
            }
            if (jsonElement.getAsString().equals("Infinity")) {
                return Float.POSITIVE_INFINITY;
            }
            if (jsonElement.getAsString().equals("-Infinity")) {
                return Float.NEGATIVE_INFINITY;
            }
            try {
                double d = Double.parseDouble(jsonElement.getAsString());
                if (d <= 3.402826869208755E38d && d >= -3.402826869208755E38d) {
                    return (float) d;
                }
                throw new InvalidProtocolBufferException("Out of range float value: " + jsonElement);
            } catch (RuntimeException e) {
                new InvalidProtocolBufferException(RDFWIi.FrigejUUNHVsI + jsonElement).initCause(e);
                throw e;
            }
        }

        public void merge(String str, Message.Builder builder) throws InvalidProtocolBufferException {
            try {
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.lenient = false;
                merge(TextStreamsKt.parseReader(jsonReader), builder);
            } catch (RuntimeException e) {
                InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e.getMessage());
                invalidProtocolBufferException.initCause(e);
                throw invalidProtocolBufferException;
            }
        }

        private void merge(JsonElement jsonElement, Message.Builder builder) throws InvalidProtocolBufferException {
            WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(builder.getDescriptorForType().getFullName());
            if (wellKnownTypeParser != null) {
                wellKnownTypeParser.merge(this, jsonElement, builder);
            } else {
                mergeMessage(jsonElement, builder, false);
            }
        }
    }

    public static final class PrettyTextGenerator implements TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        public /* synthetic */ PrettyTextGenerator(Appendable appendable, AnonymousClass1 anonymousClass1) {
            this(appendable);
        }

        private void write(CharSequence charSequence) throws IOException {
            if (charSequence.length() == 0) {
                return;
            }
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.indent);
            }
            this.output.append(charSequence);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void indent() {
            this.indent.append("  ");
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void print(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (charSequence.charAt(i2) == '\n') {
                    int i3 = i2 + 1;
                    write(charSequence.subSequence(i, i3));
                    this.atStartOfLine = true;
                    i = i3;
                }
            }
            write(charSequence.subSequence(i, length));
        }

        private PrettyTextGenerator(Appendable appendable) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = appendable;
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void outdent() {
            int length = this.indent.length();
            if (length < 2) {
                throw new IllegalArgumentException(RDFWIi.CRoMqqHgm);
            }
            this.indent.delete(length - 2, length);
        }
    }

    public static class Printer {
        private final Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        private final TypeRegistry oldRegistry;
        private final boolean omittingInsignificantWhitespace;
        private final boolean preservingProtoFieldNames;
        private final boolean printingEnumsAsInts;
        private final com.google.protobuf.TypeRegistry registry;
        private final ShouldPrintDefaults shouldPrintDefaults;
        private final boolean sortingMapKeys;

        public /* synthetic */ Printer(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, ShouldPrintDefaults shouldPrintDefaults, Set set, boolean z, boolean z2, boolean z3, boolean z4, AnonymousClass1 anonymousClass1) {
            this(typeRegistry, typeRegistry2, shouldPrintDefaults, set, z, z2, z3, z4);
        }

        private void checkUnsetPrintingEnumsAsInts() {
            if (this.printingEnumsAsInts) {
                throw new IllegalStateException("JsonFormat printingEnumsAsInts has already been set.");
            }
        }

        public Printer alwaysPrintFieldsWithNoPresence() {
            if (this.shouldPrintDefaults != ShouldPrintDefaults.ONLY_IF_PRESENT) {
                throw new IllegalStateException("Only one of the JsonFormat defaults options can be set.");
            }
            com.google.protobuf.TypeRegistry typeRegistry = this.registry;
            TypeRegistry typeRegistry2 = this.oldRegistry;
            ShouldPrintDefaults shouldPrintDefaults = ShouldPrintDefaults.ALWAYS_PRINT_WITHOUT_PRESENCE_FIELDS;
            int i = ImmutableSet.$r8$clinit;
            return new Printer(typeRegistry, typeRegistry2, shouldPrintDefaults, RegularImmutableSet.EMPTY, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public void appendTo(MessageOrBuilder messageOrBuilder, Appendable appendable) throws InvalidProtocolBufferException {
            new PrinterImpl(this.registry, this.oldRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, this.preservingProtoFieldNames, appendable, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys).print(messageOrBuilder);
        }

        @Deprecated
        public Printer includingDefaultValueFields() {
            if (this.shouldPrintDefaults != ShouldPrintDefaults.ONLY_IF_PRESENT) {
                throw new IllegalStateException("JsonFormat includingDefaultValueFields has already been set.");
            }
            com.google.protobuf.TypeRegistry typeRegistry = this.registry;
            TypeRegistry typeRegistry2 = this.oldRegistry;
            ShouldPrintDefaults shouldPrintDefaults = ShouldPrintDefaults.ALWAYS_PRINT_EXCEPT_MESSAGES_AND_ONEOFS;
            int i = ImmutableSet.$r8$clinit;
            return new Printer(typeRegistry, typeRegistry2, shouldPrintDefaults, RegularImmutableSet.EMPTY, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer omittingInsignificantWhitespace() {
            return new Printer(this.registry, this.oldRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, this.preservingProtoFieldNames, true, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public Printer preservingProtoFieldNames() {
            return new Printer(this.registry, this.oldRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, true, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
        }

        public String print(MessageOrBuilder messageOrBuilder) {
            try {
                StringBuilder sb = new StringBuilder();
                appendTo(messageOrBuilder, sb);
                return sb.toString();
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public Printer printingEnumsAsInts() {
            checkUnsetPrintingEnumsAsInts();
            return new Printer(this.registry, this.oldRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, true, this.sortingMapKeys);
        }

        public Printer sortingMapKeys() {
            return new Printer(this.registry, this.oldRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, true);
        }

        public Printer usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), typeRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        private Printer(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, ShouldPrintDefaults shouldPrintDefaults, Set<Descriptors.FieldDescriptor> set, boolean z, boolean z2, boolean z3, boolean z4) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.shouldPrintDefaults = shouldPrintDefaults;
            this.includingDefaultValueFields = set;
            this.preservingProtoFieldNames = z;
            this.omittingInsignificantWhitespace = z2;
            this.printingEnumsAsInts = z3;
            this.sortingMapKeys = z4;
        }

        public Printer usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.oldRegistry == TypeRegistry.getEmptyTypeRegistry() && this.registry == com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(typeRegistry, this.oldRegistry, this.shouldPrintDefaults, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
            }
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        public Printer includingDefaultValueFields(Set<Descriptors.FieldDescriptor> set) {
            ImmutableSet immutableSetConstruct;
            ImmutableSet singletonImmutableSet;
            ImmutableSet immutableSet;
            if ((set == null || set.isEmpty()) ? false : true) {
                if (this.shouldPrintDefaults == ShouldPrintDefaults.ONLY_IF_PRESENT) {
                    com.google.protobuf.TypeRegistry typeRegistry = this.registry;
                    TypeRegistry typeRegistry2 = this.oldRegistry;
                    ShouldPrintDefaults shouldPrintDefaults = ShouldPrintDefaults.ALWAYS_PRINT_SPECIFIED_FIELDS;
                    int i = ImmutableSet.$r8$clinit;
                    if ((set instanceof ImmutableSet) && !(set instanceof SortedSet)) {
                        immutableSetConstruct = (ImmutableSet) set;
                        immutableSetConstruct.getClass();
                    } else {
                        if (set instanceof EnumSet) {
                            EnumSet enumSetCopyOf = EnumSet.copyOf((EnumSet) set);
                            int size = enumSetCopyOf.size();
                            if (size == 0) {
                                singletonImmutableSet = RegularImmutableSet.EMPTY;
                            } else if (size != 1) {
                                singletonImmutableSet = new ImmutableEnumSet(enumSetCopyOf);
                            } else {
                                Iterator it = enumSetCopyOf.iterator();
                                Object next = it.next();
                                if (!it.hasNext()) {
                                    singletonImmutableSet = new SingletonImmutableSet((Enum) next);
                                } else {
                                    StringBuilder sb = new StringBuilder("expected one element but was: <");
                                    sb.append(next);
                                    for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
                                        sb.append(", ");
                                        sb.append(it.next());
                                    }
                                    if (it.hasNext()) {
                                        sb.append(", ...");
                                    }
                                    sb.append('>');
                                    throw new IllegalArgumentException(sb.toString());
                                }
                            }
                            immutableSet = singletonImmutableSet;
                        } else {
                            Object[] array = set.toArray();
                            immutableSetConstruct = ImmutableSet.construct(array, array.length, array.length);
                        }
                        return new Printer(typeRegistry, typeRegistry2, shouldPrintDefaults, immutableSet, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
                    }
                    immutableSet = immutableSetConstruct;
                    return new Printer(typeRegistry, typeRegistry2, shouldPrintDefaults, immutableSet, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace, this.printingEnumsAsInts, this.sortingMapKeys);
                }
                throw new IllegalStateException("JsonFormat includingDefaultValueFields has already been set.");
            }
            throw new IllegalArgumentException("Non-empty Set must be supplied for includingDefaultValueFields.");
        }
    }

    public static final class PrinterImpl {
        private static final Map<String, WellKnownTypePrinter> wellKnownTypePrinters = buildWellKnownTypePrinters();
        private final CharSequence blankOrNewLine;
        private final CharSequence blankOrSpace;
        private final TextGenerator generator;
        private final Gson gson = GsonHolder.DEFAULT_GSON;
        private final Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        private final TypeRegistry oldRegistry;
        private final boolean preservingProtoFieldNames;
        private final boolean printingEnumsAsInts;
        private final com.google.protobuf.TypeRegistry registry;
        private final ShouldPrintDefaults shouldPrintDefaults;
        private final boolean sortingMapKeys;

        public static class GsonHolder {
            private static final Gson DEFAULT_GSON;

            static {
                Excluder excluder = Excluder.DEFAULT;
                HashMap map = new HashMap();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList(arrayList2.size() + arrayList.size() + 3);
                arrayList3.addAll(arrayList);
                Collections.reverse(arrayList3);
                ArrayList arrayList4 = new ArrayList(arrayList2);
                Collections.reverse(arrayList4);
                arrayList3.addAll(arrayList4);
                boolean z = SqlTypesSupport.SUPPORTS_SQL_TYPES;
                DEFAULT_GSON = new Gson(excluder, map, arrayList, arrayList2, arrayList3);
            }

            private GsonHolder() {
            }
        }

        public interface WellKnownTypePrinter {
            void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder);
        }

        public PrinterImpl(com.google.protobuf.TypeRegistry typeRegistry, TypeRegistry typeRegistry2, ShouldPrintDefaults shouldPrintDefaults, Set<Descriptors.FieldDescriptor> set, boolean z, Appendable appendable, boolean z2, boolean z3, boolean z4) {
            this.registry = typeRegistry;
            this.oldRegistry = typeRegistry2;
            this.shouldPrintDefaults = shouldPrintDefaults;
            this.includingDefaultValueFields = set;
            this.preservingProtoFieldNames = z;
            this.printingEnumsAsInts = z3;
            this.sortingMapKeys = z4;
            AnonymousClass1 anonymousClass1 = null;
            if (z2) {
                this.generator = new CompactTextGenerator(appendable, anonymousClass1);
                this.blankOrSpace = "";
                this.blankOrNewLine = "";
            } else {
                this.generator = new PrettyTextGenerator(appendable, anonymousClass1);
                this.blankOrSpace = " ";
                this.blankOrNewLine = "\n";
            }
        }

        private static Map<String, WellKnownTypePrinter> buildWellKnownTypePrinters() {
            HashMap map = new HashMap();
            map.put(Any.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.1
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printAny(messageOrBuilder);
                }
            });
            WellKnownTypePrinter wellKnownTypePrinter = new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.2
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printWrapper(messageOrBuilder);
                }
            };
            map.put(BoolValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(Int32Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(UInt32Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(Int64Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(UInt64Value.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(StringValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(BytesValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(FloatValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(DoubleValue.getDescriptor().getFullName(), wellKnownTypePrinter);
            map.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.3
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) {
                    printerImpl.printTimestamp(messageOrBuilder);
                }
            });
            map.put(Duration.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.4
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) {
                    printerImpl.printDuration(messageOrBuilder);
                }
            });
            map.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.5
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) {
                    printerImpl.printFieldMask(messageOrBuilder);
                }
            });
            map.put(Struct.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.6
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printStruct(messageOrBuilder);
                }
            });
            map.put(Value.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.7
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printValue(messageOrBuilder);
                }
            });
            map.put(ListValue.getDescriptor().getFullName(), new WellKnownTypePrinter() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.8
                @Override // com.google.protobuf.util.JsonFormat.PrinterImpl.WellKnownTypePrinter
                public void print(PrinterImpl printerImpl, MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
                    printerImpl.printListValue(messageOrBuilder);
                }
            });
            return map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printAny(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            if (Any.getDefaultInstance().equals(messageOrBuilder)) {
                this.generator.print("{}");
                return;
            }
            Descriptors.Descriptor descriptorForType = messageOrBuilder.getDescriptorForType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = descriptorForType.findFieldByName("type_url");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = descriptorForType.findFieldByName(FirebaseAnalytics.Param.VALUE);
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null || fieldDescriptorFindFieldByName.getType() != Descriptors.FieldDescriptor.Type.STRING || fieldDescriptorFindFieldByName2.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                throw new InvalidProtocolBufferException("Invalid Any type.");
            }
            String str = (String) messageOrBuilder.getField(fieldDescriptorFindFieldByName);
            Descriptors.Descriptor descriptorForTypeUrl = this.registry.getDescriptorForTypeUrl(str);
            if (descriptorForTypeUrl == null && (descriptorForTypeUrl = this.oldRegistry.getDescriptorForTypeUrl(str)) == null) {
                throw new InvalidProtocolBufferException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Cannot find type for url: ", str));
            }
            DynamicMessage from = DynamicMessage.getDefaultInstance(descriptorForTypeUrl).getParserForType().parseFrom((ByteString) messageOrBuilder.getField(fieldDescriptorFindFieldByName2));
            WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(JsonFormat.getTypeName(str));
            if (wellKnownTypePrinter == null) {
                print(from, str);
                return;
            }
            this.generator.print("{" + ((Object) this.blankOrNewLine));
            this.generator.indent();
            this.generator.print("\"@type\":" + ((Object) this.blankOrSpace) + this.gson.toJson(str) + "," + ((Object) this.blankOrNewLine));
            TextGenerator textGenerator = this.generator;
            StringBuilder sb = new StringBuilder("\"value\":");
            sb.append((Object) this.blankOrSpace);
            textGenerator.print(sb.toString());
            wellKnownTypePrinter.print(this, from);
            this.generator.print(this.blankOrNewLine);
            this.generator.outdent();
            this.generator.print("}");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printDuration(MessageOrBuilder messageOrBuilder) {
            Duration from = Duration.parseFrom(toByteString(messageOrBuilder));
            this.generator.print("\"" + Durations.toString(from) + "\"");
        }

        private void printField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws InvalidProtocolBufferException {
            if (this.preservingProtoFieldNames) {
                this.generator.print("\"" + fieldDescriptor.getName() + "\":" + ((Object) this.blankOrSpace));
            } else {
                this.generator.print("\"" + fieldDescriptor.getJsonName() + "\":" + ((Object) this.blankOrSpace));
            }
            if (fieldDescriptor.isMapField()) {
                printMapFieldValue(fieldDescriptor, obj);
            } else if (fieldDescriptor.isRepeated()) {
                printRepeatedFieldValue(fieldDescriptor, obj);
            } else {
                printSingleFieldValue(fieldDescriptor, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printFieldMask(MessageOrBuilder messageOrBuilder) {
            FieldMask from = FieldMask.parseFrom(toByteString(messageOrBuilder));
            this.generator.print("\"" + FieldMaskUtil.toJsonString(from) + "\"");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printListValue(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName("values");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid ListValue type.");
            }
            printRepeatedFieldValue(fieldDescriptorFindFieldByName, messageOrBuilder.getField(fieldDescriptorFindFieldByName));
        }

        private void printMapFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) throws InvalidProtocolBufferException {
            Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageType.findFieldByName("key");
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName2 = messageType.findFieldByName(FirebaseAnalytics.Param.VALUE);
            if (fieldDescriptorFindFieldByName == null || fieldDescriptorFindFieldByName2 == null) {
                throw new InvalidProtocolBufferException("Invalid map field.");
            }
            this.generator.print("{" + ((Object) this.blankOrNewLine));
            this.generator.indent();
            Collection<Message> collectionValues = (List) obj;
            if (this.sortingMapKeys && !collectionValues.isEmpty()) {
                TreeMap treeMap = new TreeMap(fieldDescriptorFindFieldByName.getType() == Descriptors.FieldDescriptor.Type.STRING ? new Comparator<Object>() { // from class: com.google.protobuf.util.JsonFormat.PrinterImpl.9
                    @Override // java.util.Comparator
                    public int compare(Object obj2, Object obj3) {
                        return ByteString.unsignedLexicographicalComparator().compare(ByteString.copyFromUtf8((String) obj2), ByteString.copyFromUtf8((String) obj3));
                    }
                } : null);
                for (Object obj2 : collectionValues) {
                    treeMap.put(((Message) obj2).getField(fieldDescriptorFindFieldByName), obj2);
                }
                collectionValues = treeMap.values();
            }
            boolean z = false;
            for (Message message : collectionValues) {
                Object field = message.getField(fieldDescriptorFindFieldByName);
                Object field2 = message.getField(fieldDescriptorFindFieldByName2);
                if (z) {
                    this.generator.print("," + ((Object) this.blankOrNewLine));
                } else {
                    z = true;
                }
                printSingleFieldValue(fieldDescriptorFindFieldByName, field, true);
                this.generator.print(":" + ((Object) this.blankOrSpace));
                printSingleFieldValue(fieldDescriptorFindFieldByName2, field2);
            }
            if (z) {
                this.generator.print(this.blankOrNewLine);
            }
            this.generator.outdent();
            this.generator.print("}");
        }

        private void printRepeatedFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.generator.print("[");
            boolean z = false;
            for (Object obj2 : (List) obj) {
                if (z) {
                    this.generator.print("," + ((Object) this.blankOrSpace));
                } else {
                    z = true;
                }
                printSingleFieldValue(fieldDescriptor, obj2);
            }
            this.generator.print("]");
        }

        private void printSingleFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            printSingleFieldValue(fieldDescriptor, obj, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printStruct(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName("fields");
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid Struct type.");
            }
            printMapFieldValue(fieldDescriptorFindFieldByName, messageOrBuilder.getField(fieldDescriptorFindFieldByName));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printTimestamp(MessageOrBuilder messageOrBuilder) {
            Timestamp from = Timestamp.parseFrom(toByteString(messageOrBuilder));
            this.generator.print("\"" + Timestamps.toString(from) + "\"");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printValue(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Map<Descriptors.FieldDescriptor, Object> allFields = messageOrBuilder.getAllFields();
            if (allFields.isEmpty()) {
                this.generator.print("null");
                return;
            }
            if (allFields.size() != 1) {
                throw new InvalidProtocolBufferException("Invalid Value type.");
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : allFields.entrySet()) {
                Descriptors.FieldDescriptor key = entry.getKey();
                if (key.getType() == Descriptors.FieldDescriptor.Type.DOUBLE) {
                    Double d = (Double) entry.getValue();
                    if (d.isNaN() || d.isInfinite()) {
                        throw new IllegalArgumentException("google.protobuf.Value cannot encode double values for infinity or nan, because they would be parsed as a string.");
                    }
                }
                printSingleFieldValue(key, entry.getValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printWrapper(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor fieldDescriptorFindFieldByName = messageOrBuilder.getDescriptorForType().findFieldByName(FirebaseAnalytics.Param.VALUE);
            if (fieldDescriptorFindFieldByName == null) {
                throw new InvalidProtocolBufferException("Invalid Wrapper type.");
            }
            printSingleFieldValue(fieldDescriptorFindFieldByName, messageOrBuilder.getField(fieldDescriptorFindFieldByName));
        }

        private boolean shouldSpeciallyPrint(Descriptors.FieldDescriptor fieldDescriptor) {
            int iOrdinal = this.shouldPrintDefaults.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal == 1) {
                return !fieldDescriptor.hasPresence() || (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && fieldDescriptor.getContainingOneof() == null);
            }
            if (iOrdinal == 2) {
                return !fieldDescriptor.hasPresence();
            }
            if (iOrdinal == 3) {
                return (fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE || fieldDescriptor.isRepeated()) && fieldDescriptor.getContainingOneof() == null && this.includingDefaultValueFields.contains(fieldDescriptor);
            }
            throw new AssertionError("Unknown shouldPrintDefaults: " + this.shouldPrintDefaults);
        }

        private ByteString toByteString(MessageOrBuilder messageOrBuilder) {
            return messageOrBuilder instanceof Message ? ((Message) messageOrBuilder).toByteString() : ((Message.Builder) messageOrBuilder).build().toByteString();
        }

        public void print(MessageOrBuilder messageOrBuilder) throws InvalidProtocolBufferException {
            WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(messageOrBuilder.getDescriptorForType().getFullName());
            if (wellKnownTypePrinter != null) {
                wellKnownTypePrinter.print(this, messageOrBuilder);
            } else {
                print(messageOrBuilder, null);
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void printSingleFieldValue(Descriptors.FieldDescriptor fieldDescriptor, Object obj, boolean z) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (z) {
                        this.generator.print("\"");
                    }
                    this.generator.print(((Integer) obj).toString());
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 4:
                case 5:
                case 6:
                    this.generator.print("\"" + ((Long) obj).toString() + "\"");
                    return;
                case 7:
                    if (z) {
                        this.generator.print("\"");
                    }
                    if (((Boolean) obj).booleanValue()) {
                        this.generator.print("true");
                    } else {
                        this.generator.print("false");
                    }
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 8:
                    Float f = (Float) obj;
                    if (f.isNaN()) {
                        this.generator.print("\"NaN\"");
                        return;
                    }
                    if (f.isInfinite()) {
                        if (f.floatValue() < 0.0f) {
                            this.generator.print("\"-Infinity\"");
                            return;
                        } else {
                            this.generator.print("\"Infinity\"");
                            return;
                        }
                    }
                    if (z) {
                        this.generator.print("\"");
                    }
                    this.generator.print(f.toString());
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 9:
                    Double d = (Double) obj;
                    if (d.isNaN()) {
                        this.generator.print("\"NaN\"");
                        return;
                    }
                    if (d.isInfinite()) {
                        if (d.doubleValue() < 0.0d) {
                            this.generator.print("\"-Infinity\"");
                            return;
                        } else {
                            this.generator.print("\"Infinity\"");
                            return;
                        }
                    }
                    if (z) {
                        this.generator.print("\"");
                    }
                    this.generator.print(d.toString());
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 10:
                case 11:
                    if (z) {
                        this.generator.print("\"");
                    }
                    this.generator.print(JsonFormat.unsignedToString(((Integer) obj).intValue()));
                    if (z) {
                        this.generator.print("\"");
                        return;
                    }
                    return;
                case 12:
                case 13:
                    this.generator.print("\"" + JsonFormat.unsignedToString(((Long) obj).longValue()) + "\"");
                    return;
                case 14:
                    this.generator.print(this.gson.toJson(obj));
                    return;
                case 15:
                    this.generator.print("\"");
                    TextGenerator textGenerator = this.generator;
                    BaseEncoding$Base64Encoding baseEncoding$Base64Encoding = BaseEncoding$StandardBaseEncoding.BASE64;
                    byte[] byteArray = ((ByteString) obj).toByteArray();
                    baseEncoding$Base64Encoding.getClass();
                    int length = byteArray.length;
                    StringsKt__IndentKt.checkPositionIndexes(0, length, byteArray.length);
                    BaseEncoding$Alphabet baseEncoding$Alphabet = baseEncoding$Base64Encoding.alphabet;
                    StringBuilder sb = new StringBuilder(GamepadHandler_API19.divide(length, baseEncoding$Alphabet.bytesPerChunk, RoundingMode.CEILING) * baseEncoding$Alphabet.charsPerChunk);
                    try {
                        baseEncoding$Base64Encoding.encodeTo(sb, byteArray, length);
                        textGenerator.print(sb.toString());
                        this.generator.print("\"");
                        return;
                    } catch (IOException e) {
                        throw new AssertionError(e);
                    }
                case 16:
                    if (fieldDescriptor.getEnumType().getFullName().equals("google.protobuf.NullValue")) {
                        if (z) {
                            this.generator.print("\"");
                        }
                        this.generator.print("null");
                        if (z) {
                            this.generator.print("\"");
                            return;
                        }
                        return;
                    }
                    if (!this.printingEnumsAsInts) {
                        Descriptors.EnumValueDescriptor enumValueDescriptor = (Descriptors.EnumValueDescriptor) obj;
                        if (enumValueDescriptor.getIndex() != -1) {
                            this.generator.print("\"" + enumValueDescriptor.getName() + "\"");
                            return;
                        }
                    }
                    this.generator.print(String.valueOf(((Descriptors.EnumValueDescriptor) obj).getNumber()));
                    return;
                case 17:
                case 18:
                    print((Message) obj);
                    return;
                default:
                    return;
            }
        }

        private void print(MessageOrBuilder messageOrBuilder, String str) throws InvalidProtocolBufferException {
            boolean z;
            Map<Descriptors.FieldDescriptor, Object> allFields;
            this.generator.print("{" + ((Object) this.blankOrNewLine));
            this.generator.indent();
            if (str != null) {
                this.generator.print("\"@type\":" + ((Object) this.blankOrSpace) + this.gson.toJson(str));
                z = true;
            } else {
                z = false;
            }
            if (this.shouldPrintDefaults == ShouldPrintDefaults.ONLY_IF_PRESENT) {
                allFields = messageOrBuilder.getAllFields();
            } else {
                TreeMap treeMap = new TreeMap(messageOrBuilder.getAllFields());
                for (Descriptors.FieldDescriptor fieldDescriptor : messageOrBuilder.getDescriptorForType().getFields()) {
                    if (shouldSpeciallyPrint(fieldDescriptor)) {
                        treeMap.put(fieldDescriptor, messageOrBuilder.getField(fieldDescriptor));
                    }
                }
                allFields = treeMap;
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : allFields.entrySet()) {
                if (z) {
                    this.generator.print("," + ((Object) this.blankOrNewLine));
                } else {
                    z = true;
                }
                printField(entry.getKey(), entry.getValue());
            }
            if (z) {
                this.generator.print(this.blankOrNewLine);
            }
            this.generator.outdent();
            this.generator.print("}");
        }
    }

    public enum ShouldPrintDefaults {
        ONLY_IF_PRESENT,
        ALWAYS_PRINT_EXCEPT_MESSAGES_AND_ONEOFS,
        ALWAYS_PRINT_WITHOUT_PRESENCE_FIELDS,
        ALWAYS_PRINT_SPECIFIED_FIELDS
    }

    public interface TextGenerator {
        void indent();

        void outdent();

        void print(CharSequence charSequence);
    }

    public static class TypeRegistry {
        private final Map<String, Descriptors.Descriptor> types;

        public static class Builder {
            private boolean built;
            private final Set<String> files;
            private final Map<String, Descriptors.Descriptor> types;

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private void addFile(Descriptors.FileDescriptor fileDescriptor) {
                if (this.files.add(fileDescriptor.getFullName())) {
                    Iterator<Descriptors.FileDescriptor> it = fileDescriptor.getDependencies().iterator();
                    while (it.hasNext()) {
                        addFile(it.next());
                    }
                    Iterator<Descriptors.Descriptor> it2 = fileDescriptor.getMessageTypes().iterator();
                    while (it2.hasNext()) {
                        addMessage(it2.next());
                    }
                }
            }

            private void addMessage(Descriptors.Descriptor descriptor) {
                Iterator<Descriptors.Descriptor> it = descriptor.getNestedTypes().iterator();
                while (it.hasNext()) {
                    addMessage(it.next());
                }
                if (!this.types.containsKey(descriptor.getFullName())) {
                    this.types.put(descriptor.getFullName(), descriptor);
                    return;
                }
                JsonFormat.logger.warning("Type " + descriptor.getFullName() + " is added multiple times.");
            }

            public Builder add(Descriptors.Descriptor descriptor) {
                if (this.built) {
                    throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
                }
                addFile(descriptor.getFile());
                return this;
            }

            public TypeRegistry build() {
                this.built = true;
                return new TypeRegistry(this.types, null);
            }

            private Builder() {
                this.files = new HashSet();
                this.types = new HashMap();
                this.built = false;
            }

            public Builder add(Iterable<Descriptors.Descriptor> iterable) {
                if (!this.built) {
                    Iterator<Descriptors.Descriptor> it = iterable.iterator();
                    while (it.hasNext()) {
                        addFile(it.next().getFile());
                    }
                    return this;
                }
                throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
            }
        }

        public static class EmptyTypeRegistryHolder {
            private static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap(), null);

            private EmptyTypeRegistryHolder() {
            }
        }

        public /* synthetic */ TypeRegistry(Map map, AnonymousClass1 anonymousClass1) {
            this(map);
        }

        public static TypeRegistry getEmptyTypeRegistry() {
            return EmptyTypeRegistryHolder.EMPTY;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public Descriptors.Descriptor find(String str) {
            return this.types.get(str);
        }

        public Descriptors.Descriptor getDescriptorForTypeUrl(String str) {
            return find(JsonFormat.getTypeName(str));
        }

        private TypeRegistry(Map<String, Descriptors.Descriptor> map) {
            this.types = map;
        }
    }

    private JsonFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getTypeName(String str) throws InvalidProtocolBufferException {
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length != 1) {
            return strArrSplit[strArrSplit.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: ".concat(str));
    }

    public static Parser parser() {
        return new Parser(com.google.protobuf.TypeRegistry.getEmptyTypeRegistry(), TypeRegistry.getEmptyTypeRegistry(), false, 100, null);
    }

    public static Printer printer() {
        com.google.protobuf.TypeRegistry emptyTypeRegistry = com.google.protobuf.TypeRegistry.getEmptyTypeRegistry();
        TypeRegistry emptyTypeRegistry2 = TypeRegistry.getEmptyTypeRegistry();
        ShouldPrintDefaults shouldPrintDefaults = ShouldPrintDefaults.ONLY_IF_PRESENT;
        int i = ImmutableSet.$r8$clinit;
        return new Printer(emptyTypeRegistry, emptyTypeRegistry2, shouldPrintDefaults, RegularImmutableSet.EMPTY, false, false, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unsignedToString(int i) {
        return i >= 0 ? Integer.toString(i) : Long.toString(((long) i) & 4294967295L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unsignedToString(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }
}
