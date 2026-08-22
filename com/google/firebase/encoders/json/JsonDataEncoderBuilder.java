package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.zxing.oned.UPCAWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    private static final ValueEncoder<Boolean> BOOLEAN_ENCODER;
    private static final ValueEncoder<String> STRING_ENCODER;
    private static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0(0);
    private static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();
    private ObjectEncoder<Object> fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
    private boolean ignoreNullValues = false;

    public final class TimestampEncoder implements ValueEncoder {
        public static final SimpleDateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        public final void encode(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).add(rfc339.format((Date) obj));
        }
    }

    static {
        final int i = 0;
        STRING_ENCODER = new ValueEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1
            @Override // com.google.firebase.encoders.ValueEncoder
            public final void encode(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        ((ValueEncoderContext) obj2).add((String) obj);
                        break;
                    default:
                        JsonDataEncoderBuilder.lambda$static$2((Boolean) obj, (ValueEncoderContext) obj2);
                        break;
                }
            }
        };
        final int i2 = 1;
        BOOLEAN_ENCODER = new ValueEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1
            @Override // com.google.firebase.encoders.ValueEncoder
            public final void encode(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        ((ValueEncoderContext) obj2).add((String) obj);
                        break;
                    default:
                        JsonDataEncoderBuilder.lambda$static$2((Boolean) obj, (ValueEncoderContext) obj2);
                        break;
                }
            }
        };
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) STRING_ENCODER);
        registerEncoder(Boolean.class, (ValueEncoder) BOOLEAN_ENCODER);
        registerEncoder(Date.class, (ValueEncoder) TIMESTAMP_ENCODER);
    }

    public static /* synthetic */ void lambda$static$0(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public static /* synthetic */ void lambda$static$2(Boolean bool, ValueEncoderContext valueEncoderContext) {
        valueEncoderContext.add(bool.booleanValue());
    }

    public DataEncoder build() {
        return new UPCAWriter(this);
    }

    public JsonDataEncoderBuilder configureWith(Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    public JsonDataEncoderBuilder ignoreNullValues(boolean z) {
        this.ignoreNullValues = z;
        return this;
    }

    public JsonDataEncoderBuilder registerFallbackEncoder(ObjectEncoder<Object> objectEncoder) {
        this.fallbackEncoder = objectEncoder;
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public <T> JsonDataEncoderBuilder registerEncoder(Class<T> cls, ObjectEncoder<? super T> objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public <T> JsonDataEncoderBuilder registerEncoder(Class<T> cls, ValueEncoder<? super T> valueEncoder) {
        this.valueEncoders.put(cls, valueEncoder);
        this.objectEncoders.remove(cls);
        return this;
    }
}
