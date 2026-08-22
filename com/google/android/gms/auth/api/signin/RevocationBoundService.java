package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlinx.coroutines.android.Mos.kiqcCZ;

/* JADX INFO: loaded from: classes2.dex */
public final class RevocationBoundService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return (IBinder) kiqcCZ.IvNERGj.invoke(null, this, intent);
    }
}
