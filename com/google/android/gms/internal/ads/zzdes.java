package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdes extends zzdbt {
    public zzdes(Set set) {
        super(set);
    }

    public final synchronized void zza(final com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdeq
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdep) obj).zze(zzbkVar);
            }
        });
    }

    public final synchronized void zzb(final String str) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzder
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzdep) obj).zzf(str);
            }
        });
    }
}
