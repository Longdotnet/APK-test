package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.InputStream;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbbl> CREATOR = new zzbbm();
    private ParcelFileDescriptor zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    public zzbbl(ParcelFileDescriptor parcelFileDescriptor, boolean z, boolean z2, long j, boolean z3) {
        this.zza = parcelFileDescriptor;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = j;
        this.zze = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 2, zzb(), i, false);
        boolean zZzd = zzd();
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(zZzd ? 1 : 0);
        boolean zZzf = zzf();
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(zZzf ? 1 : 0);
        long jZza = zza();
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(jZza);
        boolean zZzg = zzg();
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(zZzg ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public final synchronized long zza() {
        return this.zzd;
    }

    public final synchronized ParcelFileDescriptor zzb() {
        return this.zza;
    }

    public final synchronized InputStream zzc() {
        if (this.zza == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zza);
        this.zza = null;
        return autoCloseInputStream;
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized boolean zze() {
        return this.zza != null;
    }

    public final synchronized boolean zzf() {
        return this.zzc;
    }

    public final synchronized boolean zzg() {
        return this.zze;
    }

    public zzbbl() {
        this(null, false, false, 0L, false);
    }
}
