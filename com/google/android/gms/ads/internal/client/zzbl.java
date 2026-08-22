package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzbl extends zzayt implements zzbn {
    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb(zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc() {
        zzdb(1, zza());
    }
}
