package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzddx extends zzdbt implements zzazd {
    private final Map zzb;
    private final Context zzc;
    private final zzfca zzd;

    public zzddx(Context context, Set set, zzfca zzfcaVar) {
        super(set);
        this.zzb = new WeakHashMap(1);
        this.zzc = context;
        this.zzd = zzfcaVar;
    }

    public final synchronized void zza(View view) {
        try {
            Map map = this.zzb;
            zzaze zzazeVar = (zzaze) map.get(view);
            if (zzazeVar == null) {
                zzaze zzazeVar2 = new zzaze(this.zzc, view);
                zzazeVar2.zzd(this);
                map.put(view, zzazeVar2);
                zzazeVar = zzazeVar2;
            }
            if (this.zzd.zzX) {
                zzbcv zzbcvVar = zzbde.zzbB;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    zzazeVar.zzg(((Long) zzbdVar.zzd.zzb(zzbde.zzbA)).longValue());
                    return;
                }
            }
            zzazeVar.zzf();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(View view) {
        Map map = this.zzb;
        if (map.containsKey(view)) {
            ((zzaze) map.get(view)).zze(this);
            map.remove(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final synchronized void zzdr(final zzazc zzazcVar) {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzddw
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((zzazd) obj).zzdr(zzazcVar);
            }
        });
    }
}
