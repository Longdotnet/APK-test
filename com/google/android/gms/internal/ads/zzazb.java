package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzazb extends BroadcastReceiver {
    final /* synthetic */ zzaze zza;

    public zzazb(zzaze zzazeVar) {
        Objects.requireNonNull(zzazeVar);
        this.zza = zzazeVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("OWBdQkpjcBE94nlo", new Object[]{this, context, intent});
    }
}
