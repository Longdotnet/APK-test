package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzdsi {
    final /* synthetic */ zzdsj zza;
    private final Map zzb;

    public zzdsi(zzdsj zzdsjVar) {
        Objects.requireNonNull(zzdsjVar);
        this.zza = zzdsjVar;
        this.zzb = new ConcurrentHashMap();
    }

    public static /* bridge */ /* synthetic */ zzdsi zza(zzdsi zzdsiVar) {
        zzdsiVar.zzb.putAll(zzdsiVar.zza.zzc);
        return zzdsiVar;
    }

    public final zzdsi zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdsi zzc(zzfca zzfcaVar) {
        zzb("aai", zzfcaVar.zzw);
        zzb("request_id", zzfcaVar.zzan);
        zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfca.zza(zzfcaVar.zzb));
        return this;
    }

    public final zzdsi zzd(zzfcd zzfcdVar) {
        zzb("gqi", zzfcdVar.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzi() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsh
            @Override // java.lang.Runnable
            public final void run() {
                zzdsi zzdsiVar = this.zza;
                zzdsiVar.zza.zza.zze(zzdsiVar.zzb);
            }
        });
    }

    public final void zzj() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsf
            @Override // java.lang.Runnable
            public final void run() {
                zzdsi zzdsiVar = this.zza;
                zzdsiVar.zza.zza.zzg(zzdsiVar.zzb);
            }
        });
    }

    public final void zzk() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsg
            @Override // java.lang.Runnable
            public final void run() {
                zzdsi zzdsiVar = this.zza;
                zzdsiVar.zza.zza.zzf(zzdsiVar.zzb);
            }
        });
    }
}
