package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdaz extends zzdbt implements zzbix {
    public zzdaz(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final synchronized void zzb(final String str, final String str2) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzday
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((AppEventListener) obj).onAppEvent(str, str2);
            }
        });
    }
}
