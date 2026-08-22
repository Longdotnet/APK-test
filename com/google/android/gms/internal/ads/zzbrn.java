package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrn extends zzayt implements zzbrp {
    public zzbrn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final com.google.android.gms.ads.internal.client.zzed zze() {
        Parcel parcelZzda = zzda(5, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzf() {
        Parcel parcelZzda = zzda(2, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(parcelZzda, zzbse.CREATOR);
        parcelZzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final zzbse zzg() {
        Parcel parcelZzda = zzda(3, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(parcelZzda, zzbse.CREATOR);
        parcelZzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbrs zzbrsVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzayv.zze(parcelZza, bundle);
        zzayv.zze(parcelZza, bundle2);
        zzayv.zze(parcelZza, zzrVar);
        zzayv.zzg(parcelZza, zzbrsVar);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbra zzbraVar, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbraVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrdVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzayv.zze(parcelZza, zzrVar);
        zzdb(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrdVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzayv.zze(parcelZza, zzrVar);
        zzdb(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrg zzbrgVar, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrgVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrjVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar, zzbge zzbgeVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrjVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzayv.zze(parcelZza, zzbgeVar);
        zzdb(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrmVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbrmVar);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzq(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(24, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(15, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final boolean zzt(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(17, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
