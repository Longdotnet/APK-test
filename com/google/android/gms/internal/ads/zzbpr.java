package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpr extends zzayt implements zzbpt {
    public zzbpr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzB(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzD(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzE() {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzF() {
        zzdb(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzG(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzH(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzI() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzJ(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzK(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzL() {
        zzdb(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzM() {
        Parcel parcelZzda = zzda(22, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzN() {
        Parcel parcelZzda = zzda(13, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqb zzO() {
        zzbqb zzbqbVar;
        Parcel parcelZzda = zzda(15, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbqbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbqbVar = iInterfaceQueryLocalInterface instanceof zzbqb ? (zzbqb) iInterfaceQueryLocalInterface : new zzbqb(strongBinder);
        }
        parcelZzda.recycle();
        return zzbqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqc zzP() {
        zzbqc zzbqcVar;
        Parcel parcelZzda = zzda(16, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbqcVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbqcVar = iInterfaceQueryLocalInterface instanceof zzbqc ? (zzbqc) iInterfaceQueryLocalInterface : new zzbqc(strongBinder);
        }
        parcelZzda.recycle();
        return zzbqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final Bundle zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final com.google.android.gms.ads.internal.client.zzed zzh() {
        Parcel parcelZzda = zzda(26, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbhj zzi() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbpz zzj() {
        zzbpz zzbpxVar;
        Parcel parcelZzda = zzda(36, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbpxVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbpxVar = iInterfaceQueryLocalInterface instanceof zzbpz ? (zzbpz) iInterfaceQueryLocalInterface : new zzbpx(strongBinder);
        }
        parcelZzda.recycle();
        return zzbpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqf zzk() {
        zzbqf zzbqdVar;
        Parcel parcelZzda = zzda(27, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbqdVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbqdVar = iInterfaceQueryLocalInterface instanceof zzbqf ? (zzbqf) iInterfaceQueryLocalInterface : new zzbqd(strongBinder);
        }
        parcelZzda.recycle();
        return zzbqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbse zzl() {
        Parcel parcelZzda = zzda(33, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(parcelZzda, zzbse.CREATOR);
        parcelZzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbse zzm() {
        Parcel parcelZzda = zzda(34, zza());
        zzbse zzbseVar = (zzbse) zzayv.zza(parcelZzda, zzbse.CREATOR);
        parcelZzda.recycle();
        return zzbseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final IObjectWrapper zzn() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(2, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzo() {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbwn zzbwnVar, String str2) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(null);
        zzayv.zzg(parcelZza, zzbwnVar);
        parcelZza.writeString(str2);
        zzdb(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzq(IObjectWrapper iObjectWrapper, zzbmh zzbmhVar, List list) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbmhVar);
        parcelZza.writeTypedList(list);
        zzdb(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzr(IObjectWrapper iObjectWrapper, zzbwn zzbwnVar, List list) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbwnVar);
        parcelZza.writeStringList(list);
        zzdb(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzs(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzdb(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbpw zzbpwVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbpw zzbpwVar, zzbge zzbgeVar, List list) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzmVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayv.zzg(parcelZza, zzbpwVar);
        zzayv.zze(parcelZza, zzbgeVar);
        parcelZza.writeStringList(list);
        zzdb(14, parcelZza);
    }
}
