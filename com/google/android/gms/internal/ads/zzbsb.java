package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzbsb implements MediationAdLoadCallback {
    final /* synthetic */ zzbrm zza;
    final /* synthetic */ zzbpw zzb;
    final /* synthetic */ zzbsc zzc;

    public zzbsb(zzbsc zzbscVar, zzbrm zzbrmVar, zzbpw zzbpwVar) {
        this.zza = zzbrmVar;
        this.zzb = zzbpwVar;
        Objects.requireNonNull(zzbscVar);
        this.zzc = zzbscVar;
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
            com.google.android.gms.ads.internal.util.client.zzo.zzh(TSDAbK.YsEQr, e);
            return null;
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined", null));
    }
}
