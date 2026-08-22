package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzhv extends BroadcastReceiver {
    private final zzdt zza;

    public zzhv(zzhx zzhxVar, zzdt zzdtVar, zzhw zzhwVar) {
        Objects.requireNonNull(zzhxVar);
        this.zza = zzdtVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("vzs12yE738pZVshG", new Object[]{this, context, intent});
    }
}
