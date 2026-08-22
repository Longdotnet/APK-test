package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.AbstractCollection;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    public final AbstractCollection zza;
    public final AbstractCollection zzb;
    public final AbstractCollection zzc;
    public final AbstractCollection zzd;

    /* JADX WARN: Multi-variable type inference failed */
    public zzg(List list, List list2, List list3, List list4) {
        this.zza = (AbstractCollection) list;
        this.zzb = (AbstractCollection) list2;
        this.zzc = (AbstractCollection) list3;
        this.zzd = (AbstractCollection) list4;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.AbstractCollection, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.AbstractCollection, java.util.List] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeStringList(parcel, 1, this.zza);
        CloseableKt.writeTypedList(parcel, 2, this.zzb, false);
        CloseableKt.writeStringList(parcel, 3, this.zzc);
        CloseableKt.writeStringList(parcel, 4, this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    public final List zza() {
        return this.zza;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    public final List zzb() {
        return this.zzb;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    public final List zzc() {
        return this.zzc;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    public final List zzd() {
        return this.zzd;
    }
}
