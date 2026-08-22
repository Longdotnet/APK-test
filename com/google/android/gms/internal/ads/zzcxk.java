package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxk extends zzdbt implements zzcxm {
    public zzcxk(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcxj
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcxm) obj).zzu();
            }
        });
    }
}
