package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzeb extends zzayt implements zzed {
    public zzeb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zze() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzf() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzg() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final zzeg zzi() {
        zzeg zzeeVar;
        Parcel parcelZzda = zzda(11, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzeeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzeeVar = iInterfaceQueryLocalInterface instanceof zzeg ? (zzeg) iInterfaceQueryLocalInterface : new zzee(strongBinder);
        }
        parcelZzda.recycle();
        return zzeeVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzm(zzeg zzegVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzegVar);
        zzdb(8, parcelZza);
    }
}
