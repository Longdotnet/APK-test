package kotlin.jvm.internal;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeIntrinsics {
    public static void throwCce(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        Intrinsics.sanitizeStackTrace(classCastException, TypeIntrinsics.class.getName());
        throw classCastException;
    }
}
