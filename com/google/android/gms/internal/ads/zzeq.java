package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzeq implements zzds {
    private Message zza;

    private zzeq() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzds
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        this.zza = null;
        zzes.zzm(this);
    }

    public final zzeq zzb(Message message, zzes zzesVar) {
        this.zza = message;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzes.zzm(this);
        return zSendMessageAtFrontOfQueue;
    }

    public /* synthetic */ zzeq(zzer zzerVar) {
    }
}
