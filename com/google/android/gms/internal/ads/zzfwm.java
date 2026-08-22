package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class zzfwm {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb;

    static {
        Object objZza = zza();
        zzb = objZza;
        if (objZza != null) {
            zzb("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (objZza == null) {
            return;
        }
        zzc(objZza);
    }

    private static Object zza() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzb(String str, Class... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzc(Object obj) {
        try {
            Method methodZzb = zzb("getStackTraceDepth", Throwable.class);
            if (methodZzb == null) {
                return null;
            }
            methodZzb.invoke(obj, new Throwable());
            return methodZzb;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }
}
