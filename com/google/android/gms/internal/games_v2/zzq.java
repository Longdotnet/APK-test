package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    private final int zza;
    private final zzx zzb;

    public zzq(int i, zzx zzxVar) {
        this.zza = i;
        this.zzb = zzxVar;
    }

    public static zzq zza(int i) {
        return new zzq(i, null);
    }

    public static zzq zzb(int i, zzx zzxVar) {
        return new zzq(i, zzxVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        return this.zza == zzqVar.zza && com.google.android.gms.common.internal.zzah.equal(this.zzb, zzqVar.zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        com.google.firebase.auth.zzz zzzVar = new com.google.firebase.auth.zzz(this);
        zzzVar.add(Integer.valueOf(this.zza), "signInType");
        zzzVar.add(this.zzb, "previousStepResolutionResult");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i2 = this.zza;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final int zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzb == null;
    }
}
