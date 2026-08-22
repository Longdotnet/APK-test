package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeReflectionAccessor extends ReflectionAccessor {
    public static Class unsafeClass;
    public final Field overrideField;
    public final Object theUnsafe;

    public UnsafeReflectionAccessor() {
        Object obj;
        Field declaredField = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            unsafeClass = cls;
            Field declaredField2 = cls.getDeclaredField("theUnsafe");
            declaredField2.setAccessible(true);
            obj = declaredField2.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.theUnsafe = obj;
        try {
            declaredField = AccessibleObject.class.getDeclaredField("override");
        } catch (Exception unused2) {
        }
        this.overrideField = declaredField;
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public final void makeAccessible(AccessibleObject accessibleObject) {
        Field field;
        Object obj = this.theUnsafe;
        if (obj != null && (field = this.overrideField) != null) {
            try {
                Long l = (Long) unsafeClass.getMethod("objectFieldOffset", Field.class).invoke(obj, field);
                l.getClass();
                unsafeClass.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(obj, accessibleObject, l, Boolean.TRUE);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }
}
