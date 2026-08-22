package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzadu extends zzady {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ zzadu(zzadt zzadtVar) {
        super(null);
    }

    private static List zzf(Object obj, long j, int i) {
        List list;
        List listZzd;
        List list2 = (List) zzafx.zzf(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzads) {
                listZzd = new zzadr(i);
            } else {
                listZzd = ((list2 instanceof zzaer) && (list2 instanceof zzadk)) ? ((zzadk) list2).zzd(i) : new ArrayList(i);
            }
            zzafx.zzs(obj, j, listZzd);
            return listZzd;
        }
        if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            zzafx.zzs(obj, j, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof zzafs)) {
                if (!(list2 instanceof zzaer) || !(list2 instanceof zzadk)) {
                    return list2;
                }
                zzadk zzadkVar = (zzadk) list2;
                if (zzadkVar.zzc()) {
                    return list2;
                }
                zzadk zzadkVarZzd = zzadkVar.zzd(list2.size() + i);
                zzafx.zzs(obj, j, zzadkVarZzd);
                return zzadkVarZzd;
            }
            zzadr zzadrVar = new zzadr(list2.size() + i);
            zzadrVar.addAll(zzadrVar.size(), (zzafs) list2);
            zzafx.zzs(obj, j, zzadrVar);
            list = zzadrVar;
        }
        return list;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzafx.zzf(obj, j);
        if (list instanceof zzads) {
            objUnmodifiableList = ((zzads) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzaer) && (list instanceof zzadk)) {
                zzadk zzadkVar = (zzadk) list;
                if (zzadkVar.zzc()) {
                    zzadkVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzafx.zzs(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzafx.zzf(obj2, j);
        List listZzf = zzf(obj, j, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzafx.zzs(obj, j, list);
    }

    private zzadu() {
        super(null);
    }
}
