package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxk extends zzayk {
    private static final zzayl zzh = new zzayl();
    private final Context zzi;

    public zzaxk(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, Context context) {
        super(zzawxVar, "agDdf5wrmtJ0cP5XVK0JCsJ4BViR17o/n9P6hmH0muvYwmpx2DZ552/tAJvOo6qR", "48yXjRp5G93PEoVZx8WBMAeqgOhil0yQSUdmW98nZyI=", zzastVar, i, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        this.zzd.zzn("E");
        Context context = this.zzi;
        AtomicReference atomicReferenceZza = zzh.zza(context.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                try {
                    if (atomicReferenceZza.get() == null) {
                        atomicReferenceZza.set((String) this.zze.invoke(null, context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzn(zzaul.zza(str.getBytes(), true));
        }
    }
}
