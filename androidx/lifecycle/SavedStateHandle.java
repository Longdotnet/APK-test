package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda3;
import androidx.core.os.BundleApi21ImplKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandle {
    public static final Class[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public final LinkedHashMap flows;
    public final LinkedHashMap liveDatas;
    public final LinkedHashMap regular;
    public final SavedStateRegistry.SavedStateProvider savedStateProvider;
    public final LinkedHashMap savedStateProviders;

    public static Bundle $r8$lambda$eeLDsk5Qp_lgSAYrhUViF2PFB0k(SavedStateHandle this$0) {
        String key;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = MapsKt__MapsKt.toMap(this$0.savedStateProviders).entrySet().iterator();
        do {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = this$0.regular;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                Pair[] pairArr = {new Pair("keys", arrayList), new Pair("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                for (int i = 0; i < 2; i++) {
                    Pair pair = pairArr[i];
                    String str2 = (String) pair.first;
                    Object obj = pair.second;
                    if (obj == null) {
                        bundle.putString(str2, null);
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(str2, ((Character) obj).charValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Number) obj).longValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(str2, ((Number) obj).shortValue());
                    } else if (obj instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj);
                    } else if (obj instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj);
                    } else if (obj instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj);
                    } else if (obj instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj);
                    } else if (obj instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj);
                    } else if (obj instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj);
                    } else if (obj instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj);
                    } else if (obj instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj);
                    } else if (obj instanceof Object[]) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        Intrinsics.checkNotNull(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) obj);
                        }
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj);
                    } else if (obj instanceof IBinder) {
                        bundle.putBinder(str2, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        BundleApi21ImplKt.putSize(bundle, str2, (Size) obj);
                    } else {
                        if (!(obj instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        BundleApi21ImplKt.putSizeF(bundle, str2, (SizeF) obj);
                    }
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            key = (String) entry.getKey();
            Bundle bundleSaveState = ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState();
            Intrinsics.checkNotNullParameter(key, "key");
            if (bundleSaveState != null) {
                Class[] clsArr = ACCEPTABLE_CLASSES;
                int i2 = 0;
                while (true) {
                    if (i2 >= 29) {
                        throw new IllegalArgumentException("Can't put value with type " + bundleSaveState.getClass() + " into saved state");
                    }
                    Class cls = clsArr[i2];
                    Intrinsics.checkNotNull(cls);
                    if (cls.isInstance(bundleSaveState)) {
                        break;
                    }
                    i2++;
                }
            }
            Object obj2 = this$0.liveDatas.get(key);
            MutableLiveData mutableLiveData = obj2 instanceof MutableLiveData ? (MutableLiveData) obj2 : null;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(bundleSaveState);
            } else {
                linkedHashMap.put(key, bundleSaveState);
            }
        } while (this$0.flows.get(key) == null);
        throw new ClassCastException();
    }

    public SavedStateHandle(HashMap map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new ComponentActivity$$ExternalSyntheticLambda3(this, 1);
        linkedHashMap.putAll(map);
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new ComponentActivity$$ExternalSyntheticLambda3(this, 1);
    }
}
