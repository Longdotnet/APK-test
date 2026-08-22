package com.google.protobuf.util;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

/* JADX INFO: loaded from: classes3.dex */
public final class Values {
    private static final Value NULL_VALUE = Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
    private static final Value TRUE_VALUE = Value.newBuilder().setBoolValue(true).build();
    private static final Value FALSE_VALUE = Value.newBuilder().setBoolValue(false).build();
    private static final Value EMPTY_STR_VALUE = Value.newBuilder().setStringValue(RDFWIi.NOiRcYB).build();

    private Values() {
    }

    public static Value of(boolean z) {
        return z ? TRUE_VALUE : FALSE_VALUE;
    }

    public static Value ofNull() {
        return NULL_VALUE;
    }

    public static Value of(double d) {
        return Value.newBuilder().setNumberValue(d).build();
    }

    public static Value of(String str) {
        return str.isEmpty() ? EMPTY_STR_VALUE : Value.newBuilder().setStringValue(str).build();
    }

    public static Value of(Struct struct) {
        return Value.newBuilder().setStructValue(struct).build();
    }

    public static Value of(ListValue listValue) {
        return Value.newBuilder().setListValue(listValue).build();
    }

    public static Value of(Iterable<Value> iterable) {
        return Value.newBuilder().setListValue(ListValue.newBuilder().addAllValues(iterable)).build();
    }
}
