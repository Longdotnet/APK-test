package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwq extends zzdbt {
    private boolean zzb;

    public zzcwq(Set set) {
        super(set);
        this.zzb = false;
    }

    public final synchronized void zza() {
        if (this.zzb) {
            return;
        }
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcwp
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzcws) obj).zzt();
            }
        });
        this.zzb = true;
    }
}
