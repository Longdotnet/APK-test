package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzdm;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzav extends zzdm {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzay zzb;

    public zzav(zzay zzayVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzayVar);
        this.zzb = zzayVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        this.zzb.zzi(this.zza, zzeVar.zzb, true, true);
    }
}
