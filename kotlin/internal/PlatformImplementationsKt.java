package kotlin.internal;

import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        PlatformImplementations platformImplementations;
        try {
            Object objNewInstance = JDK8PlatformImplementations.class.newInstance();
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    platformImplementations = (PlatformImplementations) objNewInstance;
                } catch (ClassNotFoundException unused) {
                    Object objNewInstance2 = JDK7PlatformImplementations.class.newInstance();
                    Intrinsics.checkNotNullExpressionValue(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        try {
                            platformImplementations = (PlatformImplementations) objNewInstance2;
                        } catch (ClassCastException e) {
                            ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                            ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                            if (Intrinsics.areEqual(classLoader, classLoader2)) {
                                throw e;
                            }
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                        }
                    } catch (ClassNotFoundException unused2) {
                        platformImplementations = new PlatformImplementations();
                    }
                }
                IMPLEMENTATIONS = platformImplementations;
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = objNewInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                if (Intrinsics.areEqual(classLoader3, classLoader4)) {
                    throw e2;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            Intrinsics.checkNotNullExpressionValue(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    platformImplementations = (PlatformImplementations) objNewInstance3;
                } catch (ClassCastException e3) {
                    ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                    ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                    if (Intrinsics.areEqual(classLoader5, classLoader6)) {
                        throw e3;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    platformImplementations = (PlatformImplementations) objNewInstance4;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                    if (Intrinsics.areEqual(classLoader7, classLoader8)) {
                        throw e4;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                }
            }
        }
    }
}
