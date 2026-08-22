package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
final class zzaqq implements zzaqc {
    private final Map zza = new HashMap();
    private final zzapp zzb;
    private final BlockingQueue zzc;
    private final zzapu zzd;

    public zzaqq(zzapp zzappVar, BlockingQueue blockingQueue, zzapu zzapuVar) {
        this.zzd = zzapuVar;
        this.zzb = zzappVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final synchronized void zza(zzaqd zzaqdVar) {
        try {
            Map map = this.zza;
            String strZzj = zzaqdVar.zzj();
            List list = (List) map.remove(strZzj);
            if (list == null || list.isEmpty()) {
                return;
            }
            if (zzaqp.zzb) {
                zzaqp.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzj);
            }
            zzaqd zzaqdVar2 = (zzaqd) list.remove(0);
            map.put(strZzj, list);
            zzaqdVar2.zzu(this);
            try {
                this.zzc.put(zzaqdVar2);
            } catch (InterruptedException e) {
                zzaqp.zzb("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzb.zzb();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final void zzb(zzaqd zzaqdVar, zzaqj zzaqjVar) {
        List list;
        zzapm zzapmVar = zzaqjVar.zzb;
        if (zzapmVar == null || zzapmVar.zza(System.currentTimeMillis())) {
            zza(zzaqdVar);
            return;
        }
        String strZzj = zzaqdVar.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(strZzj);
        }
        if (list != null) {
            if (zzaqp.zzb) {
                zzaqp.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzj);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zzb((zzaqd) it.next(), zzaqjVar, null);
            }
        }
    }

    public final synchronized boolean zzc(zzaqd zzaqdVar) {
        try {
            Map map = this.zza;
            String strZzj = zzaqdVar.zzj();
            if (!map.containsKey(strZzj)) {
                map.put(strZzj, null);
                zzaqdVar.zzu(this);
                if (zzaqp.zzb) {
                    zzaqp.zza("new request, sending to network %s", strZzj);
                }
                return false;
            }
            List arrayList = (List) map.get(strZzj);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            zzaqdVar.zzm("waiting-for-response");
            arrayList.add(zzaqdVar);
            map.put(strZzj, arrayList);
            if (zzaqp.zzb) {
                zzaqp.zza("Request for cacheKey=%s is in flight, putting on hold.", strZzj);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
