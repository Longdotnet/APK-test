package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdkt implements zzgdj {
    final /* synthetic */ zzdku zza;

    public zzdkt(zzdku zzdkuVar) {
        Objects.requireNonNull(zzdkuVar);
        this.zza = zzdkuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfH)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcfg zzcfgVar = (zzcfg) list.get(0);
            if (zzcfgVar != null) {
                this.zza.zzb(zzcfgVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfH)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "omid native display exp");
            }
        }
    }
}
