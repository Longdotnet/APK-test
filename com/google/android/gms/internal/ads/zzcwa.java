package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwa extends zzdbt implements zzcwb {
    public zzcwa(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcvz
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcwb) obj).zzdD(zzeVar);
            }
        });
    }
}
