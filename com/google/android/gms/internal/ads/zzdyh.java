package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyh extends zzbvh {
    private final zzcak zza;
    private final zzbvq zzb;

    public zzdyh(zzcak zzcakVar, zzbvq zzbvqVar) {
        this.zza = zzcakVar;
        this.zzb = zzbvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        zzcak zzcakVar = this.zza;
        zzbbVar.getClass();
        zzcakVar.zzd(new com.google.android.gms.ads.internal.util.zzba(zzbbVar.zza, zzbbVar.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(new zzdyy(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvq zzbvqVar) {
        this.zza.zzc(new zzdyy(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvqVar));
    }
}
