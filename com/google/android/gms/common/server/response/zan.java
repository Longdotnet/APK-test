package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.drive.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zza(16);
    public final int zaa;
    public final HashMap zab;
    public final String zac;

    public zan(int i, String str, ArrayList arrayList) {
        this.zaa = i;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zalVar = (zal) arrayList.get(i2);
            String str2 = zalVar.zab;
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = zalVar.zac;
            zzah.checkNotNull(arrayList2);
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zamVar = (zam) arrayList2.get(i3);
                map2.put(zamVar.zab, zamVar.zac);
            }
            map.put(str2, map2);
        }
        this.zab = map;
        zzah.checkNotNull(str);
        this.zac = str;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map3 = (Map) map.get((String) it.next());
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map3.get((String) it2.next())).zaj = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap map = this.zab;
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map2.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.zab;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, (Map) map.get(str)));
        }
        CloseableKt.writeTypedList(parcel, 2, arrayList, false);
        CloseableKt.writeString(parcel, 3, this.zac, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
