package com.google.firebase.encoders.proto;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    public final ObjectEncoder fallbackEncoder;
    public final Map objectEncoders;
    public OutputStream output;
    public final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    public final Map valueEncoders;
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final FieldDescriptor MAP_KEY_DESC = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();
    public static final FieldDescriptor MAP_VALUE_DESC = FieldDescriptor.builder(FirebaseAnalytics.Param.VALUE).withProperty(AtProtobuf.builder().tag(2).build()).build();
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 DEFAULT_MAP_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0(1);

    /* JADX INFO: renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1, reason: invalid class name */
    public abstract /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ProtobufDataEncoderContext(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.output = outputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    public static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return ((AtProtobuf.ProtobufImpl) protobuf).tag;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, Object obj) {
        add(FieldDescriptor.of(str), obj, true);
        return this;
    }

    public final void doEncode(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        lengthCountingOutputStream.length = 0L;
        try {
            OutputStream outputStream = this.output;
            this.output = lengthCountingOutputStream;
            try {
                objectEncoder.encode(obj, this);
                this.output = outputStream;
                long j = lengthCountingOutputStream.length;
                lengthCountingOutputStream.close();
                if (z && j == 0) {
                    return;
                }
                writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                writeVarInt64(j);
                objectEncoder.encode(obj, this);
            } catch (Throwable th) {
                this.output = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void encode(Object obj) {
        if (obj == null) {
            return;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
        } else {
            throw new EncodingException("No encoder for " + obj.getClass());
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) {
        encode(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) {
        nested(FieldDescriptor.of(str));
        throw null;
    }

    public final void writeVarInt32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.output.write((i & 127) | 128);
            i >>>= 7;
        }
        this.output.write(i & 127);
    }

    public final void writeVarInt64(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.output.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.output.write(((int) j) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) {
        add(FieldDescriptor.of(str), d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i) {
        add(FieldDescriptor.of(str), i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j) {
        add(FieldDescriptor.of(str), j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z) {
        add(FieldDescriptor.of(str), z ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        add(fieldDescriptor, obj, true);
        return this;
    }

    public final ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                doEncode(DEFAULT_MAP_ENCODER, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            add(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return this;
        }
        if (obj instanceof Float) {
            add(fieldDescriptor, ((Float) obj).floatValue(), z);
            return this;
        }
        if (obj instanceof Number) {
            add(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            add(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            writeVarInt32(bArr.length);
            this.output.write(bArr);
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            doEncode(objectEncoder, fieldDescriptor, obj, z);
            return this;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            ProtobufValueEncoderContext protobufValueEncoderContext = this.valueEncoderContext;
            protobufValueEncoderContext.encoded = false;
            protobufValueEncoderContext.field = fieldDescriptor;
            protobufValueEncoderContext.skipDefault = z;
            valueEncoder.encode(obj, protobufValueEncoderContext);
            return this;
        }
        if (obj instanceof ProtoEnum) {
            add(fieldDescriptor, ((ProtoEnum) obj).getNumber(), true);
            return this;
        }
        if (obj instanceof Enum) {
            add(fieldDescriptor, ((Enum) obj).ordinal(), true);
            return this;
        }
        doEncode(this.fallbackEncoder, fieldDescriptor, obj, z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) {
        add(fieldDescriptor, d, true);
        return this;
    }

    public final void add(FieldDescriptor fieldDescriptor, double d, boolean z) {
        if (z && d == 0.0d) {
            return;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
        this.output.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d).array());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) {
        add(fieldDescriptor, f, true);
        return this;
    }

    public final void add(FieldDescriptor fieldDescriptor, float f, boolean z) {
        if (z && f == 0.0f) {
            return;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
        this.output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(f).array());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) {
        add(fieldDescriptor, i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) {
        add(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) {
        add(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    public final void add(FieldDescriptor fieldDescriptor, int i, boolean z) {
        if (z && i == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            AtProtobuf.ProtobufImpl protobufImpl = (AtProtobuf.ProtobufImpl) protobuf;
            int i2 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobufImpl.intEncoding.ordinal()];
            int i3 = protobufImpl.tag;
            if (i2 == 1) {
                writeVarInt32(i3 << 3);
                writeVarInt32(i);
                return;
            } else if (i2 == 2) {
                writeVarInt32(i3 << 3);
                writeVarInt32((i << 1) ^ (i >> 31));
                return;
            } else {
                if (i2 != 3) {
                    return;
                }
                writeVarInt32((i3 << 3) | 5);
                this.output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array());
                return;
            }
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final void add(FieldDescriptor fieldDescriptor, long j, boolean z) {
        if (z && j == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            AtProtobuf.ProtobufImpl protobufImpl = (AtProtobuf.ProtobufImpl) protobuf;
            int i = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobufImpl.intEncoding.ordinal()];
            int i2 = protobufImpl.tag;
            if (i == 1) {
                writeVarInt32(i2 << 3);
                writeVarInt64(j);
                return;
            } else if (i == 2) {
                writeVarInt32(i2 << 3);
                writeVarInt64((j >> 63) ^ (j << 1));
                return;
            } else {
                if (i != 3) {
                    return;
                }
                writeVarInt32((i2 << 3) | 1);
                this.output.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
                return;
            }
        }
        throw new EncodingException("Field has no @Protobuf config");
    }
}
