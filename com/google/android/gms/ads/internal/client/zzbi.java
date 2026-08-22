package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi extends zzayt implements zzbk {
    public zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc() {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzd() {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf(zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() {
        zzdb(7, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzk() {
        zzdb(9, zza());
    }
}
