package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzhhd implements zzhgr {
    private final List zza;
    private final List zzb;

    static {
        zzhgs.zza(Collections.emptySet());
    }

    public /* synthetic */ zzhhd(List list, List list2, zzhhb zzhhbVar) {
        this.zza = list;
        this.zzb = list2;
    }

    public static zzhhc zza(int i, int i2) {
        return new zzhhc(i, i2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc */
    public final Set zzb() {
        List list = this.zza;
        int size = list.size();
        List list2 = this.zzb;
        ArrayList arrayList = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) ((zzhha) list2.get(i)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZza = zzhgo.zza(size);
        int size3 = list.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Object objZzb = ((zzhha) list.get(i2)).zzb();
            objZzb.getClass();
            hashSetZza.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                obj.getClass();
                hashSetZza.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZza);
    }
}
