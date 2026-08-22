package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class ListenerHolders {
    public final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    public static <L> ListenerHolder<L> createListenerHolder(L l, Looper looper, String str) {
        zzah.checkNotNull(l, "Listener must not be null");
        zzah.checkNotNull(looper, "Looper must not be null");
        zzah.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(l, looper, str);
    }

    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l, String str) {
        zzah.checkNotNull(l, "Listener must not be null");
        zzah.checkNotNull(str, "Listener type must not be null");
        zzah.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l, str);
    }

    public final ListenerHolder zaa(Object obj, Looper looper, String str) {
        ListenerHolder listenerHolderCreateListenerHolder = createListenerHolder(obj, looper, "NO_TYPE");
        this.zaa.add(listenerHolderCreateListenerHolder);
        return listenerHolderCreateListenerHolder;
    }

    public final void zab() {
        Set set = this.zaa;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).clear();
        }
        set.clear();
    }

    public static <L> ListenerHolder<L> createListenerHolder(L l, Executor executor, String str) {
        zzah.checkNotNull(l, oKjScaD.hEdnRdVmMXAb);
        zzah.checkNotNull(executor, "Executor must not be null");
        zzah.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(l, executor, str);
    }
}
