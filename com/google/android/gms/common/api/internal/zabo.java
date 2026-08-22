package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
final class zabo implements Runnable {
    public final /* synthetic */ zabp zaa;

    public zabo(zabp zabpVar) {
        this.zaa = zabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client = this.zaa.zaa.zac;
        client.disconnect(client.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
