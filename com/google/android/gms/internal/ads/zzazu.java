package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzazu implements Runnable {
    final /* synthetic */ zzazv zza;

    public zzazu(zzazv zzazvVar) {
        Objects.requireNonNull(zzazvVar);
        this.zza = zzazvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzazv zzazvVar = this.zza;
        synchronized (zzazvVar.zzc) {
            if (zzazvVar.zzd && zzazvVar.zze) {
                zzazvVar.zzd = false;
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("App went background");
                Iterator it = zzazvVar.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzazw) it.next()).zza(false);
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                    }
                }
            } else {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("App is still foreground");
            }
        }
    }
}
