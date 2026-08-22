package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzyt extends BroadcastReceiver {
    final /* synthetic */ zzyv zza;
    private final String zzb;

    public zzyt(zzyv zzyvVar, String str) {
        this.zza = zzyvVar;
        this.zzb = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                zzyu zzyuVar = (zzyu) this.zza.zzd.get(this.zzb);
                if (zzyuVar == null) {
                    zzyv.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String strZzb = zzyv.zzb(str);
                    zzyuVar.zze = strZzb;
                    if (strZzb == null) {
                        zzyv.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzag.zzd(zzyuVar.zzd)) {
                        zzyv.zze(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
