package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzayf extends zzayk {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzayf(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "AkswGwusnlvibekdTn6rp1TLruqBIpT26qUqw6ERX2GI+0q3NNodYWGNobvk/KA0", "+ySS/EYovSzthax5b5cNVBSw7OeHS3QqC5FfLg20T6g=", zzastVar, i, 33);
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
            zzastVar.zzT(zzh.longValue());
        }
    }
}
