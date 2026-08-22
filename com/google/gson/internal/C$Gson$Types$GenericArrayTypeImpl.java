package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final class C$Gson$Types$GenericArrayTypeImpl implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    public final Type componentType;

    public C$Gson$Types$GenericArrayTypeImpl(Type type) {
        this.componentType = Streams.canonicalize(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && Streams.equals(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.componentType;
    }

    public final int hashCode() {
        return this.componentType.hashCode();
    }

    public final String toString() {
        return Streams.typeToString(this.componentType) + "[]";
    }
}
