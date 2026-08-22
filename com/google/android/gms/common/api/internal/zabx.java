package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;

/* JADX INFO: loaded from: classes2.dex */
public final class zabx extends BroadcastReceiver {
    public Context zaa;
    public final zabw zab;

    public zabx(zabw zabwVar) {
        this.zab = zabwVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("FXllmmK4V5PfzXqS", new Object[]{this, context, intent});
    }

    public final void zaa(Context context) {
        this.zaa = context;
    }

    public final synchronized void zab() {
        try {
            Context context = this.zaa;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.zaa = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
