package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpq> CREATOR = new zzfpr();
    public final int zza;
    private zzatq zzb = null;
    private byte[] zzc;

    public zzfpq(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzatq zzatqVar = this.zzb;
        if (zzatqVar != null || this.zzc == null) {
            if (zzatqVar == null || this.zzc != null) {
                if (zzatqVar != null && this.zzc != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzatqVar != null || this.zzc != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        byte[] bArrZzaV = this.zzc;
        if (bArrZzaV == null) {
            bArrZzaV = this.zzb.zzaV();
        }
        CloseableKt.writeByteArray(parcel, 2, bArrZzaV, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zzatq zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzatq.zzd(this.zzc, zzgyr.zza());
                this.zzc = null;
            } catch (zzgzw | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }
}
