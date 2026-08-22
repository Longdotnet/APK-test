package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzej extends BroadcastReceiver {
    final /* synthetic */ zzel zza;

    public /* synthetic */ zzej(zzel zzelVar, zzek zzekVar) {
        Objects.requireNonNull(zzelVar);
        this.zza = zzelVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("fLL2CinH3PuLMyrv", new Object[]{this, context, intent});
    }
}
