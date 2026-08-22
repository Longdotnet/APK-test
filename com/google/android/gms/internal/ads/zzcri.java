package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcri implements zzehc {
    public final List zza;

    public zzcri(List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzehc
    public final void zzr() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzgdn.zzr((ListenableFuture) it.next(), new zzcrh(this), zzgef.zzc());
        }
    }

    public zzcri(zzcra zzcraVar) {
        this.zza = Collections.singletonList(zzgdn.zzh(zzcraVar));
    }
}
