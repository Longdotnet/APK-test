package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class ListenerHolder<L> {
    public final Executor zaa;
    public volatile Object zab;
    public volatile ListenerKey zac;

    public static final class ListenerKey<L> {
        public final Object zaa;
        public final String zab;

        public ListenerKey(Object obj, String str) {
            this.zaa = obj;
            this.zab = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        public int hashCode() {
            return this.zab.hashCode() + (System.identityHashCode(this.zaa) * 31);
        }

        public String toIdString() {
            return this.zab + "@" + System.identityHashCode(this.zaa);
        }
    }

    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    public ListenerHolder(Object obj, Looper looper, String str) {
        this.zaa = new zzu(looper);
        zzah.checkNotNull(obj, "Listener must not be null");
        this.zab = obj;
        zzah.checkNotEmpty(str);
        this.zac = new ListenerKey(obj, str);
    }

    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    public boolean hasListener() {
        return this.zab != null;
    }

    public void notifyListener(final Notifier<? super L> notifier) {
        zzah.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder listenerHolder = this.zaa;
                ListenerHolder.Notifier notifier2 = notifier;
                Object obj = listenerHolder.zab;
                if (obj == null) {
                    notifier2.onNotifyListenerFailed();
                    return;
                }
                try {
                    notifier2.notifyListener(obj);
                } catch (RuntimeException e) {
                    notifier2.onNotifyListenerFailed();
                    throw e;
                }
            }
        });
    }

    public ListenerHolder(Object obj, Executor executor, String str) {
        zzah.checkNotNull(executor, "Executor must not be null");
        this.zaa = executor;
        zzah.checkNotNull(obj, "Listener must not be null");
        this.zab = obj;
        zzah.checkNotEmpty(str);
        this.zac = new ListenerKey(obj, str);
    }
}
