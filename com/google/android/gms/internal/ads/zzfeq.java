package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfeq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfeq> CREATOR = new zzfer();
    public final Context zza;
    public final zzfen zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfen[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfeq(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfen[] zzfenVarArrValues = zzfen.values();
        this.zzh = zzfenVarArrValues;
        int[] iArrZza = zzfeo.zza();
        this.zzl = iArrZza;
        int[] iArrZza2 = zzfep.zza();
        this.zzm = iArrZza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = zzfenVarArrValues[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = iArrZza[i5];
        this.zzk = i6;
        int i7 = iArrZza2[i6];
    }

    public static zzfeq zza(zzfen zzfenVar, Context context) {
        if (zzfenVar == zzfen.Rewarded) {
            zzbcv zzbcvVar = zzbde.zzgC;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            return new zzfeq(context, zzfenVar, ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue(), ((Integer) zzbdVar.zzd.zzb(zzbde.zzgI)).intValue(), ((Integer) zzbdVar.zzd.zzb(zzbde.zzgK)).intValue(), (String) zzbdVar.zzd.zzb(zzbde.zzgM), (String) zzbdVar.zzd.zzb(zzbde.zzgE), (String) zzbdVar.zzd.zzb(zzbde.zzgG));
        }
        if (zzfenVar == zzfen.Interstitial) {
            zzbcv zzbcvVar2 = zzbde.zzgD;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.zza;
            return new zzfeq(context, zzfenVar, ((Integer) zzbdVar2.zzd.zzb(zzbcvVar2)).intValue(), ((Integer) zzbdVar2.zzd.zzb(zzbde.zzgJ)).intValue(), ((Integer) zzbdVar2.zzd.zzb(zzbde.zzgL)).intValue(), (String) zzbdVar2.zzd.zzb(zzbde.zzgN), (String) zzbdVar2.zzd.zzb(zzbde.zzgF), (String) zzbdVar2.zzd.zzb(zzbde.zzgH));
        }
        if (zzfenVar != zzfen.AppOpen) {
            return null;
        }
        zzbcv zzbcvVar3 = zzbde.zzgQ;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar3 = com.google.android.gms.ads.internal.client.zzbd.zza;
        return new zzfeq(context, zzfenVar, ((Integer) zzbdVar3.zzd.zzb(zzbcvVar3)).intValue(), ((Integer) zzbdVar3.zzd.zzb(zzbde.zzgS)).intValue(), ((Integer) zzbdVar3.zzd.zzb(zzbde.zzgT)).intValue(), (String) zzbdVar3.zzd.zzb(zzbde.zzgO), (String) zzbdVar3.zzd.zzb(zzbde.zzgP), (String) zzbdVar3.zzd.zzb(zzbde.zzgR));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.zzc;
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.zzd;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i4);
        int i5 = this.zze;
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(i5);
        CloseableKt.writeString(parcel, 5, this.zzf, false);
        int i6 = this.zzj;
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(i6);
        int i7 = this.zzk;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(i7);
        CloseableKt.zzb(parcel, iZza);
    }

    private zzfeq(Context context, zzfen zzfenVar, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfen.values();
        this.zzl = zzfeo.zza();
        this.zzm = zzfep.zza();
        this.zza = context;
        this.zzi = zzfenVar.ordinal();
        this.zzb = zzfenVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else {
            i4 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
