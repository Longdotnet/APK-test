package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectionAccessor {
    public static final ReflectionAccessor instance;

    static {
        instance = JavaVersion.majorJavaVersion < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
