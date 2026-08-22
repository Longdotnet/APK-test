package androidx.work;

import com.facebook.ProfileCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public final Data merge(ArrayList arrayList) throws Throwable {
        ProfileCache profileCache = new ProfileCache(15);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            map.putAll(Collections.unmodifiableMap(((Data) it.next()).mValues));
        }
        profileCache.putAll(map);
        Data data = new Data((HashMap) profileCache.sharedPreferences);
        Data.toByteArrayInternal(data);
        return data;
    }
}
