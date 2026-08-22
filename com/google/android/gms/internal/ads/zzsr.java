package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzsr extends Handler {
    final /* synthetic */ zzst zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzsr(zzst zzstVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(zzstVar);
        this.zza = zzstVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzst.zza(this.zza, message);
    }
}
