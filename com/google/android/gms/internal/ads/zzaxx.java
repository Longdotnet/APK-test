package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxx extends zzayk {
    private static volatile String zzh;
    private static final Object zzi = new Object();

    public zzaxx(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "d4PN2fwB2P9jxIUN6NPwGCD1vcjTZd510+VTbYWnWivlqPuX4Pd9jb/zoaClHGV2", "B7r3opNSMuM8FMoC6aVwUNpehxdhrcT61rhsqayMJbM=", zzastVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        this.zzd.zzz("E");
        if (zzh == null) {
            synchronized (zzi) {
                try {
                    if (zzh == null) {
                        zzh = (String) this.zze.invoke(null, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzz(zzh);
        }
    }
}
