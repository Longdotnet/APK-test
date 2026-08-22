package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycling {
    public static final HashMap callbackCache = new HashMap();
    public static final HashMap classToAdapters = new HashMap();

    public static void createGeneratedAdapter(Constructor constructor, LifecycleObserver lifecycleObserver) {
        try {
            Intrinsics.checkNotNullExpressionValue(constructor.newInstance(lifecycleObserver), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0116  */
    /* JADX WARN: Code duplicated, block: B:66:0x0122  */
    /* JADX WARN: Code duplicated, block: B:69:0x0126  */
    /* JADX WARN: Code duplicated, block: B:72:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0134  */
    /* JADX WARN: Code duplicated, block: B:77:0x0149  */
    /* JADX WARN: Code duplicated, block: B:87:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static int getObserverConstructorType(Class cls) {
        Constructor declaredConstructor;
        boolean zBooleanValue;
        Class<?>[] interfaces;
        int i;
        boolean z;
        int i2 = 1;
        HashMap map = callbackCache;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String name = cls.getCanonicalName();
                String fullPackage = r4 != null ? r4.getName() : "";
                Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
                if (fullPackage.length() != 0) {
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    name = name.substring(fullPackage.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String).substring(startIndex)");
                }
                Intrinsics.checkNotNullExpressionValue(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String strConcat = StringsKt__StringsKt.replace$default(name, ".", "_").concat("_LifecycleAdapter");
                if (fullPackage.length() != 0) {
                    strConcat = fullPackage + '.' + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap map2 = classToAdapters;
            if (declaredConstructor != null) {
                map2.put(cls, Okio.listOf(declaredConstructor));
            } else {
                ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
                HashMap map3 = classesInfoCache.mHasLifecycleMethods;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((OnLifecycleEvent) declaredMethods[i3].getAnnotation(OnLifecycleEvent.class)) != null) {
                                classesInfoCache.createInfo(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i3++;
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && LifecycleObserver.class.isAssignableFrom(superclass)) {
                        Intrinsics.checkNotNullExpressionValue(superclass, "superclass");
                        if (getObserverConstructorType(superclass) != 1) {
                            Object obj = map2.get(superclass);
                            Intrinsics.checkNotNull(obj);
                            arrayList = new ArrayList((Collection) obj);
                            interfaces = cls.getInterfaces();
                            Intrinsics.checkNotNullExpressionValue(interfaces, "klass.interfaces");
                            for (Class<?> intrface : interfaces) {
                                if (intrface == null && LifecycleObserver.class.isAssignableFrom(intrface)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    Intrinsics.checkNotNullExpressionValue(intrface, "intrface");
                                    if (getObserverConstructorType(intrface) == 1) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        Object obj2 = map2.get(intrface);
                                        Intrinsics.checkNotNull(obj2);
                                        arrayList.addAll((Collection) obj2);
                                    }
                                }
                            }
                            if (arrayList != null) {
                                map2.put(cls, arrayList);
                            }
                        }
                    } else {
                        interfaces = cls.getInterfaces();
                        Intrinsics.checkNotNullExpressionValue(interfaces, "klass.interfaces");
                        while (i < r8) {
                            if (intrface == null) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                Intrinsics.checkNotNullExpressionValue(intrface, "intrface");
                                if (getObserverConstructorType(intrface) == 1) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    Object obj3 = map2.get(intrface);
                                    Intrinsics.checkNotNull(obj3);
                                    arrayList.addAll((Collection) obj3);
                                }
                            }
                        }
                        if (arrayList != null) {
                            map2.put(cls, arrayList);
                        }
                    }
                }
            }
            i2 = 2;
        }
        map.put(cls, Integer.valueOf(i2));
        return i2;
    }
}
