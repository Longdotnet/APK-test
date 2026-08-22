package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new com.google.android.gms.drive.zza(6);
    public final int zaa;
    public final IBinder zab;
    public final ConnectionResult zac;
    public final boolean zad;
    public final boolean zae;

    public zav(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.zaa = i;
        this.zab = iBinder;
        this.zac = connectionResult;
        this.zad = z;
        this.zae = z2;
    }

    public final boolean equals(Object obj) {
        Object zzwVar;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (this.zac.equals(zavVar.zac)) {
            Object zzwVar2 = null;
            IBinder iBinder = this.zab;
            if (iBinder == null) {
                zzwVar = null;
            } else {
                int i = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzw(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }
            IBinder iBinder2 = zavVar.zab;
            if (iBinder2 != null) {
                int i2 = AccountAccessor.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                zzwVar2 = iInterfaceQueryLocalInterface2 instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface2 : new zzw(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor");
            }
            if (zzah.equal(zzwVar, zzwVar2)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeIBinder(parcel, 2, this.zab);
        CloseableKt.writeParcelable(parcel, 3, this.zac, i, false);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zad ? 1 : 0);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zae ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
