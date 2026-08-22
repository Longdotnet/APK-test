package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzdm extends zzdq {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdm() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzfp.zzf(obj, j);
        if (list instanceof zzdk) {
            objUnmodifiableList = ((zzdk) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzek) && (list instanceof zzcz)) {
                zzcz zzczVar = (zzcz) list;
                if (zzczVar.zzc()) {
                    zzczVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzfp.zzs(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zzb(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listZzd;
        List list3 = (List) zzfp.zzf(obj2, j);
        int size = list3.size();
        List list4 = (List) zzfp.zzf(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzdk) {
                listZzd = new zzdj(size);
            } else {
                listZzd = ((list4 instanceof zzek) && (list4 instanceof zzcz)) ? ((zzcz) list4).zzd(size) : new ArrayList(size);
            }
            zzfp.zzs(obj, j, listZzd);
            list2 = listZzd;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzfp.zzs(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzfk) {
                zzdj zzdjVar = new zzdj(list4.size() + size);
                zzdjVar.addAll(zzdjVar.size(), (zzfk) list4);
                zzfp.zzs(obj, j, zzdjVar);
                list = zzdjVar;
            } else if ((list4 instanceof zzek) && (list4 instanceof zzcz)) {
                zzcz zzczVar = (zzcz) list4;
                if (!zzczVar.zzc()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzcz zzczVarZzd = zzczVar.zzd(list4.size() + size);
                    zzfp.zzs(obj, j, zzczVarZzd);
                    list2 = zzczVarZzd;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzfp.zzs(obj, j, list3);
    }

    public /* synthetic */ zzdm(zzdl zzdlVar) {
        super(null);
    }
}
