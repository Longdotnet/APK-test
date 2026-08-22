package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class zzgcx extends zzgcn {
    private List zza;

    public zzgcx(zzfyl zzfylVar, boolean z) {
        super(zzfylVar, z, true);
        List listEmptyList = zzfylVar.isEmpty() ? Collections.emptyList() : zzfzg.zzb(zzfylVar.size());
        for (int i = 0; i < zzfylVar.size(); i++) {
            listEmptyList.add(null);
        }
        this.zza = listEmptyList;
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    public final void zzA(int i) {
        super.zzA(i);
        this.zza = null;
    }

    public abstract Object zzD(List list);

    @Override // com.google.android.gms.internal.ads.zzgcn
    public final void zzx(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzgcw(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcn
    public final void zzy() {
        List list = this.zza;
        if (list != null) {
            zzc(zzD(list));
        }
    }
}
