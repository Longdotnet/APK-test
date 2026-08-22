package com.google.android.gms.common.api.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zaa extends LifecycleCallback {
    public ArrayList zaa;

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = this.zaa;
            this.zaa = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
