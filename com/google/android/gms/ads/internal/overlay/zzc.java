package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appset.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb(24);
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final Intent zzh;
    public final zzaa zzi;
    public final boolean zzj;

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent, IBinder iBinder, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = intent;
        this.zzi = (zzaa) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder));
        this.zzj = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zza, false);
        CloseableKt.writeString(parcel, 3, this.zzb, false);
        CloseableKt.writeString(parcel, 4, this.zzc, false);
        CloseableKt.writeString(parcel, 5, this.zzd, false);
        CloseableKt.writeString(parcel, 6, this.zze, false);
        CloseableKt.writeString(parcel, 7, this.zzf, false);
        CloseableKt.writeString(parcel, 8, this.zzg, false);
        CloseableKt.writeParcelable(parcel, 9, this.zzh, i, false);
        CloseableKt.writeIBinder(parcel, 10, new ObjectWrapper(this.zzi).asBinder());
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(this.zzj ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzc(Intent intent, zzaa zzaaVar) {
        this(null, null, null, null, null, null, null, intent, new ObjectWrapper(zzaaVar).asBinder(), false);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, zzaa zzaaVar) {
        this(str, str2, str3, str4, str5, str6, str7, null, new ObjectWrapper(zzaaVar).asBinder(), false);
    }
}
