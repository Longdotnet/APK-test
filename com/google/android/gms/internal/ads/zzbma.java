package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbma implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzbmc zzb;

    public zzbma(zzbmc zzbmcVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzbmcVar);
        this.zzb = zzbmcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "onConnectionSuspended: ")));
    }
}
