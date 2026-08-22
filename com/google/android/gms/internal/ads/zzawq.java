package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.pairip.VMRunner;

/* JADX INFO: loaded from: classes2.dex */
public final class zzawq extends BroadcastReceiver {
    private boolean zza = true;

    public zzawq(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("pzvGSiq2ezsYBHhz", new Object[]{this, context, intent});
    }

    public final boolean zza() {
        return this.zza;
    }
}
