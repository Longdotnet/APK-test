package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzdyg extends zzbvh {
    final /* synthetic */ zzdyi zza;

    public zzdyg(zzdyi zzdyiVar) {
        Objects.requireNonNull(zzdyiVar);
        this.zza = zzdyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        zzcak zzcakVar = this.zza.zza;
        zzbbVar.getClass();
        zzcakVar.zzd(new com.google.android.gms.ads.internal.util.zzba(zzbbVar.zza, zzbbVar.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdyi zzdyiVar = this.zza;
        zzdyiVar.zza.zzc(new zzdyy(autoCloseInputStream, zzdyiVar.zze));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvq zzbvqVar) {
        this.zza.zza.zzc(new zzdyy(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvqVar));
    }
}
