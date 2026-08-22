package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdnk implements zzbkf {
    private final zzbht zza;
    private final zzdny zzb;
    private final zzhgl zzc;

    public zzdnk(zzdje zzdjeVar, zzdit zzditVar, zzdny zzdnyVar, zzhgl zzhglVar) {
        this.zza = zzdjeVar.zzc(zzditVar.zzA());
        this.zzb = zzdnyVar;
        this.zzc = zzhglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbhj) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Failed to call onCustomClick for asset ", str, ".");
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk(strM$1, e);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzl("/nativeAdCustomClick", this);
    }
}
