package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbrx implements MediationAdLoadCallback {
    final /* synthetic */ zzbrj zza;
    final /* synthetic */ zzbpw zzb;

    public zzbrx(zzbsc zzbscVar, zzbrj zzbrjVar, zzbpw zzbpwVar) {
        this.zza = zzbrjVar;
        this.zzb = zzbpwVar;
        Objects.requireNonNull(zzbscVar);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final /* synthetic */ Object onSuccess(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zza.zze("Adapter returned null.");
            return null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined", null));
    }
}
