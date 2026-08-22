package androidx.core.os;

import android.os.Bundle;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class BundleCompat$Api33Impl {
    public static <T> T getParcelable(Bundle bundle, String str, Class<T> cls) {
        return (T) bundle.getParcelable(str, cls);
    }

    public static <T> T[] getParcelableArray(Bundle bundle, String str, Class<T> cls) {
        return (T[]) bundle.getParcelableArray(str, cls);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle bundle, String str, Class<? extends T> cls) {
        return bundle.getParcelableArrayList(str, cls);
    }

    public static <T extends Serializable> T getSerializable(Bundle bundle, String str, Class<T> cls) {
        return (T) bundle.getSerializable(str, cls);
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle bundle, String str, Class<? extends T> cls) {
        return bundle.getSparseParcelableArray(str, cls);
    }
}
