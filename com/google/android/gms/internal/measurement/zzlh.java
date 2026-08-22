package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzlh {
    public static final int zza(int i, Object obj, Object obj2) {
        zzlg zzlgVar = (zzlg) obj;
        if (zzlgVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlgVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzlg zzlgVarZzb = (zzlg) obj;
        zzlg zzlgVar = (zzlg) obj2;
        if (!zzlgVar.isEmpty()) {
            if (!zzlgVarZzb.zze()) {
                zzlgVarZzb = zzlgVarZzb.zzb();
            }
            zzlgVarZzb.zzd(zzlgVar);
        }
        return zzlgVarZzb;
    }
}
