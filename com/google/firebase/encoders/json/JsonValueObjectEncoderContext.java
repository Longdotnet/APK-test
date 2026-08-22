package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    public final ObjectEncoder fallbackEncoder;
    public final boolean ignoreNullValues;
    public final JsonWriter jsonWriter;
    public final Map objectEncoders;
    public final Map valueEncoders;
    public JsonValueObjectEncoderContext childContext = null;
    public boolean active = true;

    public JsonValueObjectEncoderContext(Writer writer, Map map, Map map2, ObjectEncoder objectEncoder, boolean z) {
        this.jsonWriter = new JsonWriter(writer);
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
        this.ignoreNullValues = z;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) throws IOException {
        add(obj, true);
        return this;
    }

    public final void maybeUnNest() throws IOException {
        if (!this.active) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.childContext;
        if (jsonValueObjectEncoderContext != null) {
            jsonValueObjectEncoderContext.maybeUnNest();
            this.childContext.active = false;
            this.childContext = null;
            this.jsonWriter.endObject();
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) throws IOException {
        maybeUnNest();
        this.childContext = new JsonValueObjectEncoderContext(this);
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        jsonWriter.beginObject();
        return this.childContext;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final JsonValueObjectEncoderContext add(Object obj, String str) throws IOException {
        boolean z = this.ignoreNullValues;
        JsonWriter jsonWriter = this.jsonWriter;
        if (z) {
            if (obj != null) {
                maybeUnNest();
                jsonWriter.name(str);
                add(obj, false);
            }
            return this;
        }
        maybeUnNest();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            add(obj, false);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        return nested(fieldDescriptor.getName());
    }

    public JsonValueObjectEncoderContext(JsonValueObjectEncoderContext jsonValueObjectEncoderContext) {
        this.jsonWriter = jsonValueObjectEncoderContext.jsonWriter;
        this.objectEncoders = jsonValueObjectEncoderContext.objectEncoders;
        this.valueEncoders = jsonValueObjectEncoderContext.valueEncoders;
        this.fallbackEncoder = jsonValueObjectEncoderContext.fallbackEncoder;
        this.ignoreNullValues = jsonValueObjectEncoderContext.ignoreNullValues;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) throws IOException {
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i) throws IOException {
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j) throws IOException {
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z) throws IOException {
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return add(obj, fieldDescriptor.getName());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) throws IOException {
        String name = fieldDescriptor.getName();
        double d = f;
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(name);
        maybeUnNest();
        jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) throws IOException {
        String name = fieldDescriptor.getName();
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(name);
        maybeUnNest();
        jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        String name = fieldDescriptor.getName();
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(name);
        maybeUnNest();
        jsonWriter.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        String name = fieldDescriptor.getName();
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(name);
        maybeUnNest();
        jsonWriter.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        String name = fieldDescriptor.getName();
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(name);
        maybeUnNest();
        jsonWriter.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(float f) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(f);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(double d) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(int i) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(long j) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(byte[] bArr) throws IOException {
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        if (bArr == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final JsonValueObjectEncoderContext add(Object obj, boolean z) throws IOException {
        int i = 0;
        if (z && (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number))) {
            throw new EncodingException((obj == null ? null : obj.getClass()) + DaWYVMJ.MEgzzdJ);
        }
        JsonWriter jsonWriter = this.jsonWriter;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                maybeUnNest();
                jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
                return this;
            }
            jsonWriter.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i < length) {
                    jsonWriter.value(iArr[i]);
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i < length2) {
                    long j = jArr[i];
                    maybeUnNest();
                    jsonWriter.value(j);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i < length3) {
                    jsonWriter.value(dArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i < length4) {
                    jsonWriter.value(zArr[i]);
                    i++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    add((Object) number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    add(obj2, false);
                }
            }
            jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            jsonWriter.beginArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(it.next(), false);
            }
            jsonWriter.endArray();
            return this;
        }
        if (obj instanceof Map) {
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add(entry.getValue(), (String) key);
                } catch (ClassCastException e) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                }
            }
            jsonWriter.endObject();
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            if (!z) {
                jsonWriter.beginObject();
            }
            objectEncoder.encode(obj, this);
            if (!z) {
                jsonWriter.endObject();
            }
            return this;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            valueEncoder.encode(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            String strName = ((Enum) obj).name();
            maybeUnNest();
            jsonWriter.value(strName);
            return this;
        }
        if (!z) {
            jsonWriter.beginObject();
        }
        this.fallbackEncoder.encode(obj, this);
        if (!z) {
            jsonWriter.endObject();
        }
        return this;
    }
}
