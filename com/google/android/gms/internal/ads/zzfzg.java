package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzfzg {
    public static ArrayList zza(Iterator it) {
        ArrayList arrayList = new ArrayList();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static ArrayList zzb(int i) {
        zzfxn.zza(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzc(List list, zzfve zzfveVar) {
        return list instanceof RandomAccess ? new zzfzd(list, zzfveVar) : new zzfzf(list, zzfveVar);
    }
}
