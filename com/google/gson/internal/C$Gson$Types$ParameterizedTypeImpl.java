package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final class C$Gson$Types$ParameterizedTypeImpl implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;
    public final Type ownerType;
    public final Type rawType;
    public final Type[] typeArguments;

    public C$Gson$Types$ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z = true;
            boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z2) {
                z = false;
            }
            Streams.checkArgument(z);
        }
        this.ownerType = type == null ? null : Streams.canonicalize(type);
        this.rawType = Streams.canonicalize(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.typeArguments = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            this.typeArguments[i].getClass();
            Streams.checkNotPrimitive(this.typeArguments[i]);
            Type[] typeArr3 = this.typeArguments;
            typeArr3[i] = Streams.canonicalize(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && Streams.equals(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.typeArguments.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.rawType;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
        Type type = this.ownerType;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.typeArguments;
        int length = typeArr.length;
        Type type = this.rawType;
        if (length == 0) {
            return Streams.typeToString(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(Streams.typeToString(type));
        sb.append("<");
        sb.append(Streams.typeToString(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(Streams.typeToString(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
