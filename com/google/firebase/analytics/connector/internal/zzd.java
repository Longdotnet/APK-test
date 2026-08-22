package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgs;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements zzgs {
    public final /* synthetic */ zze zza;

    public zzd(zze zzeVar) {
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        zze zzeVar = this.zza;
        if (zzeVar.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzc.zzc(str2));
            zzeVar.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
