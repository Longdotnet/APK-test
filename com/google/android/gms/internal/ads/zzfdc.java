package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzfdc {
    public static com.google.android.gms.ads.internal.client.zzr zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfcb zzfcbVar = (zzfcb) it.next();
            if (zzfcbVar.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzfcbVar.zza, zzfcbVar.zzb));
            }
        }
        return new com.google.android.gms.ads.internal.client.zzr(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzfcb zzb(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        return zzrVar.zzi ? new zzfcb(-3, 0, true) : new zzfcb(zzrVar.zze, zzrVar.zzb, false);
    }
}
