package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes.dex */
final class zabp implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ zabq zaa;

    public zabp(zabq zabqVar) {
        this.zaa = zabqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.zaa.zaa.zar.post(new zabo(this));
    }
}
