package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi implements zzgcu {
    public final zzgdy zza;
    public final zzdxo zzb;

    public zzbi(zzgdy zzgdyVar, zzdxo zzdxoVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) {
        zzbvq zzbvqVar = (zzbvq) obj;
        return zzgdn.zzn(this.zzb.zzc(zzbvqVar), new zzai(zzbvqVar, 2), this.zza);
    }
}
