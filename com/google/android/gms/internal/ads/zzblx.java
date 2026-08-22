package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzblx extends zzblu {
    final /* synthetic */ zzcak zza;

    public zzblx(zzbly zzblyVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzblyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(parcelFileDescriptor);
    }
}
