package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonPrimitive extends JsonElement {
    public final Serializable value;

    public JsonPrimitive(Boolean bool) {
        bool.getClass();
        this.value = bool;
    }

    public static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Serializable serializable = jsonPrimitive.value;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        Serializable serializable = this.value;
        Serializable serializable2 = jsonPrimitive.value;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        double dDoubleValue = getAsNumber().doubleValue();
        double dDoubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final boolean getAsBoolean() {
        Serializable serializable = this.value;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(getAsString());
    }

    public final Number getAsNumber() {
        Serializable serializable = this.value;
        return serializable instanceof String ? new LazilyParsedNumber((String) serializable) : (Number) serializable;
    }

    @Override // com.google.gson.JsonElement
    public final String getAsString() {
        Serializable serializable = this.value;
        if (serializable instanceof Number) {
            return getAsNumber().toString();
        }
        return serializable instanceof Boolean ? ((Boolean) serializable).toString() : (String) serializable;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.value;
        if (serializable == null) {
            return 31;
        }
        if (isIntegral(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public JsonPrimitive(Number number) {
        number.getClass();
        this.value = number;
    }

    public JsonPrimitive(String str) {
        str.getClass();
        this.value = str;
    }
}
