package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.zze;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zztm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztm> CREATOR = new zztn();
    final String zza;
    final List zzb;
    final zze zzc;

    public zztm(String str, List list, zze zzeVar) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzeVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeTypedList(parcel, 2, this.zzb, false);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zze zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List zzc() {
        return zzba.zzb(this.zzb);
    }
}
