package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgcv extends zzgcx {
    public zzgcv(zzfyl zzfylVar, boolean z) {
        super(zzfylVar, z);
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzgcx
    public final /* bridge */ /* synthetic */ Object zzD(List list) {
        ArrayList arrayListZzb = zzfzg.zzb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgcw zzgcwVar = (zzgcw) it.next();
            arrayListZzb.add(zzgcwVar != null ? zzgcwVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZzb);
    }
}
