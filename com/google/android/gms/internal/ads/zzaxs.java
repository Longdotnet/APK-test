package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxs extends zzayk {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzaxs(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "2yqQbpMMcqKX38M442dN+dCyzykwnAxluzbiBDnzfSZwwykVdh1BxKbQaA6qVZBU", "1XIQFsxUhHfLRHhylour2btyczZCL08SFkmijCbkayQ=", zzastVar, i, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        if (zzh == null) {
            synchronized (zzi) {
                try {
                    if (zzh == null) {
                        zzh = (Long) this.zze.invoke(null, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzw(zzh.longValue());
        }
    }
}
