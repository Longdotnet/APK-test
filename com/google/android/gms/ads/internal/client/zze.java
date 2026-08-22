package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new com.google.android.gms.appset.zzb(12);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public zze zzd;
    public IBinder zze;

    public zze(int i, String str, String str2, zze zzeVar, IBinder iBinder) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzeVar;
        this.zze = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i, false);
        CloseableKt.writeIBinder(parcel, 5, this.zze);
        CloseableKt.zzb(parcel, iZza);
    }

    public final AdError zza() {
        zze zzeVar = this.zzd;
        return new AdError(this.zza, this.zzb, this.zzc, zzeVar != null ? new AdError(zzeVar.zza, zzeVar.zzb, zzeVar.zzc, null) : null);
    }

    public final LoadAdError zzb() {
        AdError adError;
        zzea zzdyVar;
        zze zzeVar = this.zzd;
        if (zzeVar == null) {
            adError = null;
        } else {
            adError = new AdError(zzeVar.zza, zzeVar.zzb, zzeVar.zzc, null);
        }
        IBinder iBinder = this.zze;
        if (iBinder == null) {
            zzdyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdyVar = iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(iBinder);
        }
        return new LoadAdError(this.zza, this.zzb, this.zzc, adError, zzdyVar != null ? new ResponseInfo(zzdyVar) : null);
    }
}
