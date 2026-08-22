package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxs extends zzdbt implements zzbiv {
    private final Bundle zzb;

    public zzcxs(Set set) {
        super(set);
        this.zzb = new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbiv
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcxr
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((OnAdMetadataChangedListener) obj).onAdMetadataChanged();
            }
        });
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
