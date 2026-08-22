package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxn extends zzayk {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzaxn(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "n8+dbEkb8sSSkj8RrAZPAIBpRkB5kUln+00UVnn84X80gYgRIiK8WSxHPJEqxXHc", "yKnJQpgvAxtK/oRpf77IDthT8ZJJ6VXKsBNJ0lMvjYQ=", zzastVar, i, 44);
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
            zzastVar.zzo(zzh.longValue());
        }
    }
}
