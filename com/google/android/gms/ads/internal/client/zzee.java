package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzee extends zzayt implements zzeg {
    public zzee(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zze() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzf(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzg() {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzh() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzi() {
        zzdb(1, zza());
    }
}
