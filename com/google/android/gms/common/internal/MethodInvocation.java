package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new com.google.android.gms.drive.zza(4);
    public final int zaa;
    public final int zab;
    public final int zac;
    public final long zad;
    public final long zae;
    public final String zaf;
    public final String zag;
    public final int zah;
    public final int zai;

    public MethodInvocation(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.zaa = i;
        this.zab = i2;
        this.zac = i3;
        this.zad = j;
        this.zae = j2;
        this.zaf = str;
        this.zag = str2;
        this.zah = i4;
        this.zai = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zab);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zac);
        CloseableKt.zzc(parcel, 4, 8);
        parcel.writeLong(this.zad);
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(this.zae);
        CloseableKt.writeString(parcel, 6, this.zaf, false);
        CloseableKt.writeString(parcel, 7, this.zag, false);
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(this.zah);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zai);
        CloseableKt.zzb(parcel, iZza);
    }
}
