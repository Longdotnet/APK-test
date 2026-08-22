package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbww extends zzayt implements zzbwy {
    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() {
        zzdb(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzg() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzh(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk(zzbws zzbwsVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbwsVar);
        zzdb(3, parcelZza);
    }

    public zzbww(IBinder iBinder) {
        super(iBinder, YcVWhnLsj.JPysAjfMrUB);
    }
}
