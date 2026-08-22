package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final class C$Gson$Types$WildcardTypeImpl implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    public final Type lowerBound;
    public final Type upperBound;

    public C$Gson$Types$WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
        Streams.checkArgument(typeArr2.length <= 1);
        Streams.checkArgument(typeArr.length == 1);
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            Streams.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = Streams.canonicalize(typeArr[0]);
            return;
        }
        typeArr2[0].getClass();
        Streams.checkNotPrimitive(typeArr2[0]);
        Streams.checkArgument(typeArr[0] == Object.class);
        this.lowerBound = Streams.canonicalize(typeArr2[0]);
        this.upperBound = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && Streams.equals(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type != null ? new Type[]{type} : Streams.EMPTY_TYPE_ARRAY;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    public final int hashCode() {
        Type type = this.lowerBound;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.lowerBound;
        if (type != null) {
            return "? super " + Streams.typeToString(type);
        }
        Type type2 = this.upperBound;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + Streams.typeToString(type2);
    }
}
