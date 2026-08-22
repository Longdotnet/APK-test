package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzpm extends BroadcastReceiver {
    final /* synthetic */ zzpo zza;

    public /* synthetic */ zzpm(zzpo zzpoVar, zzpn zzpnVar) {
        Objects.requireNonNull(zzpoVar);
        this.zza = zzpoVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("ZDvt835N4sKcWO2r", new Object[]{this, context, intent});
    }
}
