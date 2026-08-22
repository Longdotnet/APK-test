package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbui extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbui> CREATOR = new zzbuj();
    public final View zza;
    public final Map zzb;

    public zzbui(IBinder iBinder, IBinder iBinder2) {
        this.zza = (View) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder));
        this.zzb = (Map) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        View view = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeIBinder(parcel, 1, new ObjectWrapper(view).asBinder());
        CloseableKt.writeIBinder(parcel, 2, new ObjectWrapper(this.zzb).asBinder());
        CloseableKt.zzb(parcel, iZza);
    }
}
