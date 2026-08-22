package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbge extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbge> CREATOR = new zzbgf();
    public final int zza;
    public final boolean zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final com.google.android.gms.ads.internal.client.zzgc zzf;
    public final boolean zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;

    public zzbge(int i, boolean z, int i2, boolean z2, int i3, com.google.android.gms.ads.internal.client.zzgc zzgcVar, boolean z3, int i4, int i5, boolean z4, int i6) {
        this.zza = i;
        this.zzb = z;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = i3;
        this.zzf = zzgcVar;
        this.zzg = z3;
        this.zzh = i4;
        this.zzj = z4;
        this.zzi = i5;
        this.zzk = i6;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    public static NativeAdOptions zza(zzbge zzbgeVar) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbgeVar == null) {
            return new NativeAdOptions(builder);
        }
        int i = zzbgeVar.zza;
        int i2 = 2;
        if (i == 2) {
            builder.zze = zzbgeVar.zze;
        } else {
            if (i != 3) {
                if (i == 4) {
                    builder.zzf = zzbgeVar.zzg;
                    builder.zzb = zzbgeVar.zzh;
                    int i3 = zzbgeVar.zzi;
                    builder.zzg = zzbgeVar.zzj;
                    builder.zzh = i3;
                    int i4 = zzbgeVar.zzk;
                    if (i4 == 0) {
                        i2 = 1;
                    } else if (i4 == 2) {
                        i2 = 3;
                    } else if (i4 != 1) {
                        i2 = 1;
                    }
                    builder.zzi = i2;
                }
            }
            com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzbgeVar.zzf;
            if (zzgcVar != null) {
                builder.zzd = new VideoOptions(zzgcVar);
            }
            builder.zze = zzbgeVar.zze;
        }
        builder.zza = zzbgeVar.zzb;
        builder.zzc = zzbgeVar.zzd;
        return new NativeAdOptions(builder);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        boolean z = this.zzb;
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        int i3 = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        boolean z2 = this.zzd;
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i4 = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(i4);
        CloseableKt.writeParcelable(parcel, 6, this.zzf, i, false);
        boolean z3 = this.zzg;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(z3 ? 1 : 0);
        int i5 = this.zzh;
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(i5);
        int i6 = this.zzi;
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(i6);
        boolean z4 = this.zzj;
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(z4 ? 1 : 0);
        int i7 = this.zzk;
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(i7);
        CloseableKt.zzb(parcel, iZza);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public zzbge(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        boolean z = nativeAdOptions.zza;
        VideoOptions videoOptions = nativeAdOptions.zzf;
        this(4, z, nativeAdOptions.zzb, nativeAdOptions.zzd, nativeAdOptions.zze, videoOptions != null ? new com.google.android.gms.ads.internal.client.zzgc(videoOptions) : null, nativeAdOptions.zzg, nativeAdOptions.zzc, 0, false, 0);
    }
}
