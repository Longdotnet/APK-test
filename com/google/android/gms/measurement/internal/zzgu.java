package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzcl;

/* JADX INFO: loaded from: classes.dex */
public final class zzgu {
    public final Context zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final Boolean zze;
    public final long zzf;
    public final zzcl zzg;
    public final boolean zzh;
    public final Long zzi;
    public final String zzj;

    public zzgu(Context context, zzcl zzclVar, Long l) {
        this.zzh = true;
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.zzah.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzclVar != null) {
            this.zzg = zzclVar;
            this.zzb = zzclVar.zzf;
            this.zzc = zzclVar.zze;
            this.zzd = zzclVar.zzd;
            this.zzh = zzclVar.zzc;
            this.zzf = zzclVar.zzb;
            this.zzj = zzclVar.zzh;
            Bundle bundle = zzclVar.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
