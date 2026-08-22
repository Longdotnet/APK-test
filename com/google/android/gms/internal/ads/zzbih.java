package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbih extends zzayt implements zzbij {
    public zzbih(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzA(Bundle bundle) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        zzdb(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzB() {
        zzdb(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzC(Bundle bundle) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        zzdb(33, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzD(Bundle bundle) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        zzdb(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzE() {
        zzdb(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzF(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdfVar);
        zzdb(26, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzG(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdtVar);
        zzdb(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzH(long j) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzdb(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzI(zzbig zzbigVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbigVar);
        zzdb(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzJ() {
        Parcel parcelZzda = zzda(30, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzK() {
        Parcel parcelZzda = zzda(24, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final boolean zzL(Bundle bundle) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        Parcel parcelZzda = zzda(16, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final double zze() {
        Parcel parcelZzda = zzda(8, zza());
        double d = parcelZzda.readDouble();
        parcelZzda.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final long zzf() {
        Parcel parcelZzda = zzda(34, zza());
        long j = parcelZzda.readLong();
        parcelZzda.recycle();
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final Bundle zzg() {
        Parcel parcelZzda = zzda(20, zza());
        Bundle bundle = (Bundle) zzayv.zza(parcelZzda, Bundle.CREATOR);
        parcelZzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final com.google.android.gms.ads.internal.client.zzea zzh() {
        Parcel parcelZzda = zzda(31, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final com.google.android.gms.ads.internal.client.zzed zzi() {
        Parcel parcelZzda = zzda(11, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgi zzj() {
        zzbgi zzbggVar;
        Parcel parcelZzda = zzda(14, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbggVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbggVar = iInterfaceQueryLocalInterface instanceof zzbgi ? (zzbgi) iInterfaceQueryLocalInterface : new zzbgg(strongBinder);
        }
        parcelZzda.recycle();
        return zzbggVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgm zzk() {
        zzbgm zzbgkVar;
        Parcel parcelZzda = zzda(29, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbgkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbgkVar = iInterfaceQueryLocalInterface instanceof zzbgm ? (zzbgm) iInterfaceQueryLocalInterface : new zzbgk(strongBinder);
        }
        parcelZzda.recycle();
        return zzbgkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final zzbgp zzl() {
        zzbgp zzbgnVar;
        Parcel parcelZzda = zzda(5, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbgnVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbgnVar = iInterfaceQueryLocalInterface instanceof zzbgp ? (zzbgp) iInterfaceQueryLocalInterface : new zzbgn(strongBinder);
        }
        parcelZzda.recycle();
        return zzbgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final IObjectWrapper zzm() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(19, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final IObjectWrapper zzn() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(18, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzo() {
        Parcel parcelZzda = zzda(7, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzp() {
        Parcel parcelZzda = zzda(4, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzq() {
        Parcel parcelZzda = zzda(6, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzr() {
        Parcel parcelZzda = zzda(2, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzs() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzt() {
        Parcel parcelZzda = zzda(10, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final String zzu() {
        Parcel parcelZzda = zzda(9, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final List zzv() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList arrayListZzb = zzayv.zzb(parcelZzda);
        parcelZzda.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final List zzw() {
        Parcel parcelZzda = zzda(23, zza());
        ArrayList arrayListZzb = zzayv.zzb(parcelZzda);
        parcelZzda.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzx() {
        zzdb(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzy() {
        zzdb(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zzz(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdjVar);
        zzdb(25, parcelZza);
    }
}
