package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class zzdz {
    private final zzdj zza;
    private final zzdt zzb;
    private final zzdx zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzdz(Looper looper, zzdj zzdjVar, zzdx zzdxVar) {
        this(new CopyOnWriteArraySet(), looper, zzdjVar, zzdxVar, true);
    }

    public static /* synthetic */ boolean zzg(zzdz zzdzVar, Message message) {
        Iterator it = zzdzVar.zzd.iterator();
        while (it.hasNext()) {
            ((zzdy) it.next()).zzb(zzdzVar.zzc);
            if (zzdzVar.zzb.zzh(1)) {
                break;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzdd.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzdz zza(Looper looper, zzdx zzdxVar) {
        return new zzdz(this.zzd, looper, this.zza, zzdxVar, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            try {
                if (this.zzh) {
                    return;
                }
                this.zzd.add(new zzdy(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        zzh();
        ArrayDeque arrayDeque = this.zzf;
        if (arrayDeque.isEmpty()) {
            return;
        }
        zzdt zzdtVar = this.zzb;
        if (!zzdtVar.zzh(1)) {
            zzdtVar.zzl(zzdtVar.zzb(1));
        }
        ArrayDeque arrayDeque2 = this.zze;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void zzd(final int i, final zzdw zzdwVar) {
        zzh();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.zzd);
        this.zzf.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdv
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    zzdw zzdwVar2 = zzdwVar;
                    ((zzdy) it.next()).zza(i, zzdwVar2);
                }
            }
        });
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = this.zzd;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zzdy) it.next()).zzc(this.zzc);
        }
        copyOnWriteArraySet.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        CopyOnWriteArraySet<zzdy> copyOnWriteArraySet = this.zzd;
        for (zzdy zzdyVar : copyOnWriteArraySet) {
            if (zzdyVar.zza.equals(obj)) {
                zzdyVar.zzc(this.zzc);
                copyOnWriteArraySet.remove(zzdyVar);
            }
        }
    }

    private zzdz(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzdj zzdjVar, zzdx zzdxVar, boolean z) {
        this.zza = zzdjVar;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzdxVar;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzdjVar.zzd(looper, new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzdu
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                zzdz.zzg(this.zza, message);
                return true;
            }
        });
        this.zzi = z;
    }
}
