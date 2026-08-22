package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class zabl implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ GoogleApiManager zaa;

    public zabl(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        com.google.android.gms.internal.base.zau zauVar = this.zaa.zar;
        zauVar.sendMessage(zauVar.obtainMessage(1, Boolean.valueOf(z)));
    }
}
