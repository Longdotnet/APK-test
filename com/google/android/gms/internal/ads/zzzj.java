package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzzj {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzzk zzzkVar) {
        zzc(zzzkVar);
        this.zza.add(new zzzi(handler, zzzkVar));
    }

    public final void zzb(final int i, final long j, final long j2) {
        for (final zzzi zzziVar : this.zza) {
            if (!zzziVar.zzc) {
                zzziVar.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzh
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzziVar.zzb.zzZ(i, j, j2);
                    }
                });
            }
        }
    }

    public final void zzc(zzzk zzzkVar) {
        CopyOnWriteArrayList<zzzi> copyOnWriteArrayList = this.zza;
        for (zzzi zzziVar : copyOnWriteArrayList) {
            if (zzziVar.zzb == zzzkVar) {
                zzziVar.zzc();
                copyOnWriteArrayList.remove(zzziVar);
            }
        }
    }
}
