package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzfmr extends BroadcastReceiver {
    final /* synthetic */ zzfms zza;

    public zzfmr(zzfms zzfmsVar) {
        Objects.requireNonNull(zzfmsVar);
        this.zza = zzfmsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("41wiiMqKPjQtwsoR", new Object[]{this, context, intent});
    }
}
