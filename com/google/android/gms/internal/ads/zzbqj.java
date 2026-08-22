package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbqj implements MediationAdLoadCallback {
    final /* synthetic */ zzbpw zza;
    final /* synthetic */ Adapter zzb;
    final /* synthetic */ zzbqr zzc;

    public zzbqj(zzbqr zzbqrVar, zzbpw zzbpwVar, Adapter adapter) {
        this.zza = zzbpwVar;
        this.zzb = adapter;
        Objects.requireNonNull(zzbqrVar);
        this.zzc = zzbqrVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.getClass().getCanonicalName();
            int i = adError.zza;
            int i2 = adError.zza;
            String str = adError.zzb;
            com.google.android.gms.ads.internal.util.client.zzo.zze(canonicalName + "failed to load mediation ad: ErrorCode = " + i + ". ErrorMessage = " + str + ". ErrorDomain = " + adError.zzc);
            zzbpw zzbpwVar = this.zza;
            zzbpwVar.zzh(adError.zza());
            zzbpwVar.zzi(i2, str);
            zzbpwVar.zzg(i2);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final /* synthetic */ Object onSuccess(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
        try {
            this.zzc.getClass();
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        return new zzbqh(this.zza);
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, "undefined", null));
    }
}
