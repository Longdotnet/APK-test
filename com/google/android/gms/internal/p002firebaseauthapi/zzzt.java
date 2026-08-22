package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzt> CREATOR = new zzzu();
    private final List zza;

    public zzzt() {
        this.zza = new ArrayList();
    }

    public static zzzt zza(zzzt zzztVar) {
        zzah.checkNotNull(zzztVar);
        List list = zzztVar.zza;
        zzzt zzztVar2 = new zzzt();
        if (list != null && !list.isEmpty()) {
            zzztVar2.zza.addAll(list);
        }
        return zzztVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 2, this.zza, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final List zzb() {
        return this.zza;
    }

    public zzzt(List list) {
        List listUnmodifiableList;
        if (list == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(list);
        }
        this.zza = listUnmodifiableList;
    }
}
