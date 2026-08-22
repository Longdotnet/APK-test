package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdem extends zzdbt implements zzbkw {
    public zzdem(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zza(final zzbwo zzbwoVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdel
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzbkw) obj).zza(zzbwoVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zzb() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdek
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzbkw) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final synchronized void zzc() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzdej
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzbkw) obj).zzc();
            }
        });
    }
}
