package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: loaded from: classes.dex */
public final class zzbh implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ zzbi zza;

    public zzbh(zzbi zzbiVar) {
        this.zza = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        zzbi zzbiVar = this.zza;
        if (z) {
            zzbiVar.zzc = true;
            zzbiVar.zzc();
        } else {
            zzbiVar.zzc = false;
            if (zzbiVar.zzg()) {
                zzbiVar.zzb.zzc();
            }
        }
    }
}
