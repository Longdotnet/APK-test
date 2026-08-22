package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbaz;

/* JADX INFO: loaded from: classes.dex */
public final class zzbv extends zzayt implements zzbx {
    public zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzA() {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzC() {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(zzbh zzbhVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbhVar);
        zzdb(20, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(zzbk zzbkVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbkVar);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzG(zzr zzrVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzrVar);
        zzdb(13, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(zzco zzcoVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzcoVar);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbazVar);
        zzdb(40, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(zzcv zzcvVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzcvVar);
        zzdb(45, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(34, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzO(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(22, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(zzdt zzdtVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdtVar);
        zzdb(42, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(long j) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzdb(48, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzW(zzgc zzgcVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzgcVar);
        zzdb(29, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(44, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzad(zzm zzmVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzmVar);
        Parcel parcelZzda = zzda(4, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzc() {
        Parcel parcelZzda = zzda(47, zza());
        long j = parcelZzda.readLong();
        parcelZzda.recycle();
        return j;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzr zzh() {
        Parcel parcelZzda = zzda(12, zza());
        zzr zzrVar = (zzr) zzayv.zza(parcelZzda, zzr.CREATOR);
        parcelZzda.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzbk zzj() {
        zzbk zzbiVar;
        Parcel parcelZzda = zzda(33, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
        }
        parcelZzda.recycle();
        return zzbiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzco zzk() {
        zzco zzcmVar;
        Parcel parcelZzda = zzda(32, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzcmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(strongBinder);
        }
        parcelZzda.recycle();
        return zzcmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzea zzl() {
        zzea zzdyVar;
        Parcel parcelZzda = zzda(41, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzdyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdyVar = iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(strongBinder);
        }
        parcelZzda.recycle();
        return zzdyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzed zzm() {
        zzed zzebVar;
        Parcel parcelZzda = zzda(26, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzebVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzebVar = iInterfaceQueryLocalInterface instanceof zzed ? (zzed) iInterfaceQueryLocalInterface : new zzeb(strongBinder);
        }
        parcelZzda.recycle();
        return zzebVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(1, zza()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() {
        Parcel parcelZzda = zzda(31, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzy() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(zzm zzmVar, zzbn zzbnVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, zzbnVar);
        zzdb(43, parcelZza);
    }
}
