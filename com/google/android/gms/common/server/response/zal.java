package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import java.util.ArrayList;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zza(17);
    public final int zaa;
    public final String zab;
    public final ArrayList zac;

    public zal(int i, String str, ArrayList arrayList) {
        this.zaa = i;
        this.zab = str;
        this.zac = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeString(parcel, 2, this.zab, false);
        CloseableKt.writeTypedList(parcel, 3, this.zac, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.zaa = 1;
        this.zab = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam((FastJsonResponse.Field) map.get(str2), str2));
            }
        }
        this.zac = arrayList;
    }
}
