package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Streams {
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    public static void assertInstantiable(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: ".concat(cls.getName()));
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: ".concat(cls.getName()));
        }
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C$Gson$Types$GenericArrayTypeImpl(canonicalize(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C$Gson$Types$ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new C$Gson$Types$GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new C$Gson$Types$WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNotPrimitive(Type type) {
        checkArgument(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static boolean equal(Type type, Type type2) {
        return type == type2 || (type != null && type.equals(type2));
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type getGenericSupertype(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            checkArgument(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static JsonElement parse(JsonReader jsonReader) {
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
                try {
                    TypeAdapters.AnonymousClass30 anonymousClass30 = TypeAdapters.CLASS_FACTORY;
                    return TypeAdapters.AnonymousClass1.read(jsonReader);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            } catch (NumberFormatException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x009b  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0102  */
    /* JADX WARN: Code duplicated, block: B:69:0x0109  */
    /* JADX WARN: Code duplicated, block: B:71:0x011a  */
    /* JADX WARN: Code duplicated, block: B:73:0x011d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0127  */
    /* JADX WARN: Code duplicated, block: B:79:0x012b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0132  */
    /* JADX WARN: Code duplicated, block: B:99:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v17, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.google.gson.internal.$Gson$Types$WildcardTypeImpl] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.gson.internal.$Gson$Types$WildcardTypeImpl] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static Type resolve(Type type, Class cls, Type type2, HashMap map) {
        Type[] lowerBounds;
        Type[] upperBounds;
        Type typeResolve;
        Type[] upperBounds2;
        Type typeResolve2;
        Type[] lowerBounds2;
        Type typeResolve3;
        boolean z;
        Type[] actualTypeArguments;
        int length;
        Type c$Gson$Types$ParameterizedTypeImpl;
        Type typeResolve4;
        Type genericComponentType;
        Type typeResolve5;
        TypeVariable typeVariable;
        TypeVariable typeVariable2 = null;
        do {
            if (!(type2 instanceof TypeVariable)) {
                if (!(type2 instanceof Class)) {
                    if (type2 instanceof GenericArrayType) {
                        if (type2 instanceof ParameterizedType) {
                            if (type2 instanceof WildcardType) {
                                break;
                            }
                            type2 = (WildcardType) type2;
                            lowerBounds = type2.getLowerBounds();
                            upperBounds = type2.getUpperBounds();
                            if (lowerBounds.length == 1) {
                                if (upperBounds.length == 1) {
                                    break;
                                }
                                typeResolve = resolve(type, cls, upperBounds[0], map);
                                if (typeResolve != upperBounds[0]) {
                                    break;
                                }
                                if (typeResolve instanceof WildcardType) {
                                    upperBounds2 = ((WildcardType) typeResolve).getUpperBounds();
                                } else {
                                    upperBounds2 = new Type[]{typeResolve};
                                }
                                type2 = new C$Gson$Types$WildcardTypeImpl(upperBounds2, EMPTY_TYPE_ARRAY);
                                break;
                            }
                            typeResolve2 = resolve(type, cls, lowerBounds[0], map);
                            if (typeResolve2 != lowerBounds[0]) {
                                break;
                            }
                            if (typeResolve2 instanceof WildcardType) {
                                lowerBounds2 = ((WildcardType) typeResolve2).getLowerBounds();
                            } else {
                                lowerBounds2 = new Type[]{typeResolve2};
                            }
                            type2 = new C$Gson$Types$WildcardTypeImpl(new Type[]{Object.class}, lowerBounds2);
                            break;
                        }
                        type2 = (ParameterizedType) type2;
                        Type ownerType = type2.getOwnerType();
                        typeResolve3 = resolve(type, cls, ownerType, map);
                        z = !equal(typeResolve3, ownerType);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        for (int i = 0; i < length; i++) {
                            typeResolve4 = resolve(type, cls, actualTypeArguments[i], map);
                            if (equal(typeResolve4, actualTypeArguments[i])) {
                                if (!z) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z = true;
                                }
                                actualTypeArguments[i] = typeResolve4;
                            }
                        }
                        if (z) {
                            break;
                        }
                        c$Gson$Types$ParameterizedTypeImpl = new C$Gson$Types$ParameterizedTypeImpl(typeResolve3, type2.getRawType(), actualTypeArguments);
                        type2 = c$Gson$Types$ParameterizedTypeImpl;
                        break;
                    }
                    type2 = (GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeResolve5 = resolve(type, cls, genericComponentType, map);
                    if (equal(genericComponentType, typeResolve5)) {
                        c$Gson$Types$ParameterizedTypeImpl = new C$Gson$Types$GenericArrayTypeImpl(typeResolve5);
                        type2 = c$Gson$Types$ParameterizedTypeImpl;
                        break;
                    }
                    break;
                }
                Class cls2 = (Class) type2;
                if (!cls2.isArray()) {
                    if (type2 instanceof GenericArrayType) {
                        if (type2 instanceof ParameterizedType) {
                            if (type2 instanceof WildcardType) {
                                break;
                            }
                            type2 = (WildcardType) type2;
                            lowerBounds = type2.getLowerBounds();
                            upperBounds = type2.getUpperBounds();
                            if (lowerBounds.length == 1) {
                                if (upperBounds.length == 1) {
                                    break;
                                }
                                typeResolve = resolve(type, cls, upperBounds[0], map);
                                if (typeResolve != upperBounds[0]) {
                                    break;
                                }
                                if (typeResolve instanceof WildcardType) {
                                    upperBounds2 = ((WildcardType) typeResolve).getUpperBounds();
                                } else {
                                    upperBounds2 = new Type[]{typeResolve};
                                }
                                type2 = new C$Gson$Types$WildcardTypeImpl(upperBounds2, EMPTY_TYPE_ARRAY);
                                break;
                            }
                            typeResolve2 = resolve(type, cls, lowerBounds[0], map);
                            if (typeResolve2 != lowerBounds[0]) {
                                break;
                            }
                            if (typeResolve2 instanceof WildcardType) {
                                lowerBounds2 = ((WildcardType) typeResolve2).getLowerBounds();
                            } else {
                                lowerBounds2 = new Type[]{typeResolve2};
                            }
                            type2 = new C$Gson$Types$WildcardTypeImpl(new Type[]{Object.class}, lowerBounds2);
                            break;
                        }
                        type2 = (ParameterizedType) type2;
                        Type ownerType2 = type2.getOwnerType();
                        typeResolve3 = resolve(type, cls, ownerType2, map);
                        z = !equal(typeResolve3, ownerType2);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        while (i < length) {
                            typeResolve4 = resolve(type, cls, actualTypeArguments[i], map);
                            if (equal(typeResolve4, actualTypeArguments[i])) {
                                if (!z) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z = true;
                                }
                                actualTypeArguments[i] = typeResolve4;
                            }
                        }
                        if (z) {
                            break;
                        }
                        c$Gson$Types$ParameterizedTypeImpl = new C$Gson$Types$ParameterizedTypeImpl(typeResolve3, type2.getRawType(), actualTypeArguments);
                        type2 = c$Gson$Types$ParameterizedTypeImpl;
                        break;
                    }
                    type2 = (GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeResolve5 = resolve(type, cls, genericComponentType, map);
                    if (equal(genericComponentType, typeResolve5)) {
                        break;
                    }
                    c$Gson$Types$ParameterizedTypeImpl = new C$Gson$Types$GenericArrayTypeImpl(typeResolve5);
                    type2 = c$Gson$Types$ParameterizedTypeImpl;
                    break;
                }
                Class<?> componentType = cls2.getComponentType();
                Type typeResolve6 = resolve(type, cls, componentType, map);
                if (!equal(componentType, typeResolve6)) {
                    c$Gson$Types$ParameterizedTypeImpl = new C$Gson$Types$GenericArrayTypeImpl(typeResolve6);
                    type2 = c$Gson$Types$ParameterizedTypeImpl;
                    break;
                }
                type2 = cls2;
                break;
            }
            typeVariable = (TypeVariable) type2;
            Type type3 = (Type) map.get(typeVariable);
            if (type3 != null) {
                return type3 == Void.TYPE ? type2 : type3;
            }
            map.put(typeVariable, Void.TYPE);
            if (typeVariable2 == null) {
                typeVariable2 = typeVariable;
            }
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 == null) {
                type2 = typeVariable;
            } else {
                Type genericSupertype = getGenericSupertype(type, cls, cls3);
                if (genericSupertype instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    int length2 = typeParameters.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i2])) {
                            type2 = ((ParameterizedType) genericSupertype).getActualTypeArguments()[i2];
                            break;
                        }
                        i2++;
                    }
                } else {
                    type2 = typeVariable;
                }
            }
        } while (type2 != typeVariable);
        if (typeVariable2 != null) {
            map.put(typeVariable2, type2);
        }
        return type2;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public abstract Object newInstance(Class cls);
}
