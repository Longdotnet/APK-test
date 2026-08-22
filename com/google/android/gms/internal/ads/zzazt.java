package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzazt {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final void zza(zzazs zzazsVar) {
        synchronized (this.zzb) {
            try {
                List list = this.zzc;
                if (list.size() >= 10) {
                    String str = "Queue is full, current size = " + list.size();
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze(str);
                    list.remove(0);
                }
                int i2 = this.zza;
                this.zza = i2 + 1;
                zzazsVar.zzg(i2);
                zzazsVar.zzk();
                list.add(zzazsVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(zzazs zzazsVar) {
        synchronized (this.zzb) {
            try {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    zzazs zzazsVar2 = (zzazs) it.next();
                    com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                    if (((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzK()) {
                        if (!((com.google.android.gms.ads.internal.util.zzj) zzvVar.zzi.zzi()).zzL() && !zzazsVar.equals(zzazsVar2) && zzazsVar2.zzd().equals(zzazsVar.zzd())) {
                            it.remove();
                            return true;
                        }
                    } else if (!zzazsVar.equals(zzazsVar2) && zzazsVar2.zzc().equals(zzazsVar.zzc())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(zzazs zzazsVar) {
        synchronized (this.zzb) {
            try {
                return this.zzc.contains(zzazsVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
