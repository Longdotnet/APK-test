package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbqq implements MediationAdLoadCallback {
    final /* synthetic */ zzbpw zza;
    final /* synthetic */ zzbqr zzb;

    public zzbqq(zzbqr zzbqrVar, zzbpw zzbpwVar) {
        this.zza = zzbpwVar;
        Objects.requireNonNull(zzbqrVar);
        this.zzb = zzbqrVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.zza.getClass().getCanonicalName();
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
            this.zzb.getClass();
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        return new zzbqh(this.zza);
    }

    public final void onFailure(String str) {
        try {
            com.google.android.gms.ads.internal.util.client.zzo.zze(this.zzb.zza.getClass().getCanonicalName() + "failed to loaded mediation ad: " + str);
            zzbpw zzbpwVar = this.zza;
            zzbpwVar.zzi(0, str);
            zzbpwVar.zzg(0);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
