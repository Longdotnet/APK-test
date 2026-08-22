package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdv extends zzbm implements zzdx {
    public zzdv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final String zzd(zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzqVar);
        Parcel parcelZzb = zzb(11, parcelZza);
        String string = parcelZzb.readString();
        parcelZzb.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzf(String str, String str2, zzq zzqVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbo.zze(parcelZza, zzqVar);
        Parcel parcelZzb = zzb(16, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzb.createTypedArrayList(zzac.CREATOR);
        parcelZzb.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzg(String str, String str2, String str3) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        Parcel parcelZzb = zzb(17, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzb.createTypedArrayList(zzac.CREATOR);
        parcelZzb.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzh(String str, String str2, boolean z, zzq zzqVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbo.zzd(parcelZza, z);
        zzbo.zze(parcelZza, zzqVar);
        Parcel parcelZzb = zzb(14, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzb.createTypedArrayList(zzkw.CREATOR);
        parcelZzb.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzi(String str, String str2, String str3, boolean z) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        zzbo.zzd(parcelZza, z);
        Parcel parcelZzb = zzb(15, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzb.createTypedArrayList(zzkw.CREATOR);
        parcelZzb.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzj(zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzqVar);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzk(zzaw zzawVar, zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzawVar);
        zzbo.zze(parcelZza, zzqVar);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzm(zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzqVar);
        zzc(18, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzn(zzac zzacVar, zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzacVar);
        zzbo.zze(parcelZza, zzqVar);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzp(zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzqVar);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzq(String str, String str2, long j, String str3) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzr(Bundle bundle, zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, bundle);
        zzbo.zze(parcelZza, zzqVar);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzs(zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzqVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzt(zzkw zzkwVar, zzq zzqVar) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzkwVar);
        zzbo.zze(parcelZza, zzqVar);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final byte[] zzu(zzaw zzawVar, String str) {
        Parcel parcelZza = zza();
        zzbo.zze(parcelZza, zzawVar);
        parcelZza.writeString(str);
        Parcel parcelZzb = zzb(9, parcelZza);
        byte[] bArrCreateByteArray = parcelZzb.createByteArray();
        parcelZzb.recycle();
        return bArrCreateByteArray;
    }
}
