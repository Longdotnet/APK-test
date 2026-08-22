package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class zzcyt implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzcyv zzcyvVar = (zzcyv) this.zza.get();
        if (zzcyvVar != null) {
            zzcyvVar.zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcyr
                @Override // com.google.android.gms.internal.ads.zzdbs
                public final void zza(Object obj) {
                    ((zzcyp) obj).zzb();
                }
            });
        }
    }
}
