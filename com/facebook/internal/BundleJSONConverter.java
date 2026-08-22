package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BundleJSONConverter {
    public static final HashMap SETTERS;

    /* JADX INFO: renamed from: com.facebook.internal.BundleJSONConverter$1, reason: invalid class name */
    public final class AnonymousClass1 {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }
    }

    static {
        HashMap map = new HashMap();
        SETTERS = map;
        map.put(Boolean.class, new AnonymousClass1(0));
        map.put(Integer.class, new AnonymousClass1(1));
        map.put(Long.class, new AnonymousClass1(2));
        map.put(Double.class, new AnonymousClass1(3));
        map.put(String.class, new AnonymousClass1(4));
        map.put(String[].class, new AnonymousClass1(5));
        map.put(JSONArray.class, new AnonymousClass1(6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Bundle convertToBundle(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator itKeys = jsonObject.keys();
        while (itKeys.hasNext()) {
            String key = (String) itKeys.next();
            Object obj = jsonObject.get(key);
            if (obj != JSONObject.NULL) {
                if (!(obj instanceof JSONObject)) {
                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) SETTERS.get(obj.getClass());
                    if (anonymousClass1 == null) {
                        throw new IllegalArgumentException(Intrinsics.stringPlus(obj.getClass(), "Unsupported type: "));
                    }
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    switch (anonymousClass1.$r8$classId) {
                        case 0:
                            bundle.putBoolean(key, ((Boolean) obj).booleanValue());
                            break;
                        case 1:
                            bundle.putInt(key, ((Integer) obj).intValue());
                            break;
                        case 2:
                            bundle.putLong(key, ((Long) obj).longValue());
                            break;
                        case 3:
                            bundle.putDouble(key, ((Double) obj).doubleValue());
                            break;
                        case 4:
                            bundle.putString(key, (String) obj);
                            break;
                        case 5:
                            throw new IllegalArgumentException("Unexpected type from JSON");
                        default:
                            JSONArray jSONArray = (JSONArray) obj;
                            ArrayList arrayList = new ArrayList();
                            if (jSONArray.length() != 0) {
                                int length = jSONArray.length();
                                if (length > 0) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i + 1;
                                        Object obj2 = jSONArray.get(i);
                                        if (!(obj2 instanceof String)) {
                                            throw new IllegalArgumentException(Intrinsics.stringPlus(obj2.getClass(), "Unexpected type in an array: "));
                                        }
                                        arrayList.add(obj2);
                                        if (i2 < length) {
                                            i = i2;
                                        }
                                    }
                                }
                                bundle.putStringArrayList(key, arrayList);
                            } else {
                                bundle.putStringArrayList(key, arrayList);
                            }
                            break;
                    }
                } else {
                    bundle.putBundle(key, convertToBundle((JSONObject) obj));
                }
            }
        }
        return bundle;
    }
}
