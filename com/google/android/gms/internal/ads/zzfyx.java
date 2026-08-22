package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfyx extends zzfwq {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfvq zzb;

    public zzfyx(Iterator it, zzfvq zzfvqVar) {
        this.zza = it;
        this.zzb = zzfvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfwq
    public final Object zza() {
        zzfvq zzfvqVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzfvqVar = this.zzb;
            next = it.next();
        } while (!zzfvqVar.zza(next));
        return next;
    }
}
