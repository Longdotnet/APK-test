package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzr(1);
    public String zza;
    public String zzb;
    public zzkw zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public final zzaw zzg;
    public long zzh;
    public zzaw zzi;
    public final long zzj;
    public final zzaw zzk;

    public zzac(zzac zzacVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar);
        this.zza = zzacVar.zza;
        this.zzb = zzacVar.zzb;
        this.zzc = zzacVar.zzc;
        this.zzd = zzacVar.zzd;
        this.zze = zzacVar.zze;
        this.zzf = zzacVar.zzf;
        this.zzg = zzacVar.zzg;
        this.zzh = zzacVar.zzh;
        this.zzi = zzacVar.zzi;
        this.zzj = zzacVar.zzj;
        this.zzk = zzacVar.zzk;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zza, false);
        CloseableKt.writeString(parcel, 3, this.zzb, false);
        CloseableKt.writeParcelable(parcel, 4, this.zzc, i, false);
        long j = this.zzd;
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(j);
        boolean z = this.zze;
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 7, this.zzf, false);
        CloseableKt.writeParcelable(parcel, 8, this.zzg, i, false);
        long j2 = this.zzh;
        CloseableKt.zzc(parcel, 9, 8);
        parcel.writeLong(j2);
        CloseableKt.writeParcelable(parcel, 10, this.zzi, i, false);
        CloseableKt.zzc(parcel, 11, 8);
        parcel.writeLong(this.zzj);
        CloseableKt.writeParcelable(parcel, 12, this.zzk, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzac(String str, String str2, zzkw zzkwVar, long j, boolean z, String str3, zzaw zzawVar, long j2, zzaw zzawVar2, long j3, zzaw zzawVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkwVar;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzawVar;
        this.zzh = j2;
        this.zzi = zzawVar2;
        this.zzj = j3;
        this.zzk = zzawVar3;
    }
}
