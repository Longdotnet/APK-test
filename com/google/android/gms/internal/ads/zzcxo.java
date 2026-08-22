package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxo extends zzdbt implements zzcxq {
    public zzcxo(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcxq
    public final void zza(final zzcra zzcraVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcxn
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcxq) obj).zza(zzcraVar);
            }
        });
    }
}
