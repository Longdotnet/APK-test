package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzfc extends zzfe {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ zzfc(zzfb zzfbVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfe
    public final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzgz.zzf(obj, j);
        if (list instanceof zzfa) {
            objUnmodifiableList = ((zzfa) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzfx) && (list instanceof zzeu)) {
                zzeu zzeuVar = (zzeu) list;
                if (zzeuVar.zzc()) {
                    zzeuVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzgz.zzp(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.auth.zzfe
    public final <E> void zzb(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listZzd;
        List list3 = (List) zzgz.zzf(obj2, j);
        int size = list3.size();
        List list4 = (List) zzgz.zzf(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzfa) {
                listZzd = new zzez(size);
            } else {
                listZzd = ((list4 instanceof zzfx) && (list4 instanceof zzeu)) ? ((zzeu) list4).zzd(size) : new ArrayList(size);
            }
            zzgz.zzp(obj, j, listZzd);
            list2 = listZzd;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzgz.zzp(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzgu) {
                zzez zzezVar = new zzez(list4.size() + size);
                zzezVar.addAll(zzezVar.size(), (zzgu) list4);
                zzgz.zzp(obj, j, zzezVar);
                list = zzezVar;
            } else if ((list4 instanceof zzfx) && (list4 instanceof zzeu)) {
                zzeu zzeuVar = (zzeu) list4;
                if (!zzeuVar.zzc()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzeu<E> zzeuVarZzd = zzeuVar.zzd(list4.size() + size);
                    zzgz.zzp(obj, j, zzeuVarZzd);
                    list2 = zzeuVarZzd;
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
        zzgz.zzp(obj, j, list3);
    }

    private zzfc() {
        super(null);
    }
}
