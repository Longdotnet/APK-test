package com.google.gson.reflect;

import com.google.gson.internal.Streams;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeToken {
    public final int hashCode;
    public final Class rawType;
    public final Type type;

    public TypeToken(Type type) {
        type.getClass();
        Type typeCanonicalize = Streams.canonicalize(type);
        this.type = typeCanonicalize;
        this.rawType = Streams.getRawType(typeCanonicalize);
        this.hashCode = typeCanonicalize.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            if (Streams.equals(this.type, ((TypeToken) obj).type)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final String toString() {
        return Streams.typeToString(this.type);
    }
}
