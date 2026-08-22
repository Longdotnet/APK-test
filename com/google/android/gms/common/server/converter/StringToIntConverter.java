package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zza(13);
    public final int zaa;
    public final HashMap zab = new HashMap();
    public final SparseArray zac = new SparseArray();

    public StringToIntConverter(ArrayList arrayList, int i) {
        this.zaa = i;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zac zacVar = (zac) arrayList.get(i2);
            String str = zacVar.zab;
            int i3 = zacVar.zac;
            this.zab.put(str, Integer.valueOf(i3));
            this.zac.put(i3, str);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.zab;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, ((Integer) map.get(str)).intValue()));
        }
        CloseableKt.writeTypedList(parcel, 2, arrayList, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
