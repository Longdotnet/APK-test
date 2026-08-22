package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zak implements Handler.Callback {
    public final zaj zab;
    public final zau zah;
    public final ArrayList zac = new ArrayList();
    public final ArrayList zaa = new ArrayList();
    public final ArrayList zad = new ArrayList();
    public volatile boolean zae = false;
    public final AtomicInteger zaf = new AtomicInteger(0);
    public boolean zag = false;
    public final Object zai = new Object();

    public zak(Looper looper, zaj zajVar) {
        this.zab = zajVar;
        this.zah = new zau(looper, this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.wtf("GmsClientEvents", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Don't know how to handle message: "), new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.zai) {
            try {
                if (this.zae && this.zab.isConnected() && this.zac.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public final void zaf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzah.checkNotNull(connectionCallbacks);
        synchronized (this.zai) {
            try {
                if (this.zac.contains(connectionCallbacks)) {
                    Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " is already registered");
                } else {
                    this.zac.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.zab.isConnected()) {
            zau zauVar = this.zah;
            zauVar.sendMessage(zauVar.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void zag(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzah.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            try {
                if (this.zad.contains(onConnectionFailedListener)) {
                    Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " is already registered");
                } else {
                    this.zad.add(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
