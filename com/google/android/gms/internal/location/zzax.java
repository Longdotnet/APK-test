package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes.dex */
final class zzax extends zzaj {
    private BaseImplementation.ResultHolder<Status> zza;

    public zzax(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zza = resultHolder;
    }

    private final void zze(int i) {
        if (this.zza == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times", new Exception());
            return;
        }
        if ((i < 0 || i > 1) && (i < 1000 || i >= 1006)) {
            i = 1;
        }
        if (i == 1) {
            i = 13;
        }
        this.zza.setResult(new Status(i));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzb(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult", new Exception());
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzc(int i, String[] strArr) {
        zze(i);
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzd(int i, PendingIntent pendingIntent) {
        zze(i);
    }
}
