package com.google.gson.internal.bind;

import com.google.firebase.auth.zzz;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    public final /* synthetic */ int $r8$classId;
    public final zzz constructorConstructor;

    public /* synthetic */ MapTypeAdapterFactory(zzz zzzVar, int i) {
        this.$r8$classId = i;
        this.constructorConstructor = zzzVar;
    }

    public static TypeAdapter getTypeAdapter(zzz zzzVar, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter typeAdapterCreate;
        Object objConstruct = zzzVar.get(new TypeToken(jsonAdapter.value())).construct();
        if (objConstruct instanceof TypeAdapter) {
            typeAdapterCreate = (TypeAdapter) objConstruct;
        } else {
            if (!(objConstruct instanceof TypeAdapterFactory)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objConstruct.getClass().getName() + " as a @JsonAdapter for " + Streams.typeToString(typeToken.type) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            typeAdapterCreate = ((TypeAdapterFactory) objConstruct).create(gson, typeToken);
        }
        return (typeAdapterCreate == null || !jsonAdapter.nullSafe()) ? typeAdapterCreate : new Gson.AnonymousClass4(typeAdapterCreate, 2);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        Type[] actualTypeArguments;
        Type type = Object.class;
        zzz zzzVar = this.constructorConstructor;
        switch (this.$r8$classId) {
            case 0:
                if (!Map.class.isAssignableFrom(typeToken.rawType)) {
                    return null;
                }
                Type type2 = typeToken.type;
                Class rawType = Streams.getRawType(type2);
                if (type2 == Properties.class) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    if (type2 instanceof WildcardType) {
                        type2 = ((WildcardType) type2).getUpperBounds()[0];
                    }
                    Streams.checkArgument(Map.class.isAssignableFrom(rawType));
                    Type typeResolve = Streams.resolve(type2, rawType, Streams.getGenericSupertype(type2, rawType, Map.class), new HashMap());
                    actualTypeArguments = typeResolve instanceof ParameterizedType ? ((ParameterizedType) typeResolve).getActualTypeArguments() : new Type[]{type, type};
                }
                Type type3 = actualTypeArguments[0];
                return new TypeAdapters.EnumTypeAdapter(this, gson, actualTypeArguments[0], (type3 == Boolean.TYPE || type3 == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : gson.getAdapter(new TypeToken(type3)), actualTypeArguments[1], gson.getAdapter(new TypeToken(actualTypeArguments[1])), zzzVar.get(typeToken));
            case 1:
                Class cls = typeToken.rawType;
                if (!Collection.class.isAssignableFrom(cls)) {
                    return null;
                }
                Type type4 = typeToken.type;
                if (type4 instanceof WildcardType) {
                    type4 = ((WildcardType) type4).getUpperBounds()[0];
                }
                Streams.checkArgument(Collection.class.isAssignableFrom(cls));
                Type typeResolve2 = Streams.resolve(type4, cls, Streams.getGenericSupertype(type4, cls, Collection.class), new HashMap());
                if (typeResolve2 instanceof WildcardType) {
                    typeResolve2 = ((WildcardType) typeResolve2).getUpperBounds()[0];
                }
                type = typeResolve2 instanceof ParameterizedType ? ((ParameterizedType) typeResolve2).getActualTypeArguments()[0] : Object.class;
                return new ArrayTypeAdapter(gson, type, gson.getAdapter(new TypeToken(type)), zzzVar.get(typeToken));
            default:
                JsonAdapter jsonAdapter = (JsonAdapter) typeToken.rawType.getAnnotation(JsonAdapter.class);
                if (jsonAdapter == null) {
                    return null;
                }
                return getTypeAdapter(zzzVar, gson, typeToken, jsonAdapter);
        }
    }
}
