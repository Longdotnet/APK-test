package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxy extends zzayk {
    public zzaxy(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "+T/U1hw7+KZ4U7a2mmAOu7BJ15632T6q77fmzX/Xgjcy3uK841Ng+VsVpINIYuXP", "GzjxqsxzxT+aATwD+mE+LGwR24OtaI/aqws6qGNlH18=", zzastVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdf);
        bool.booleanValue();
        zzawd zzawdVar = new zzawd((String) this.zze.invoke(null, this.zza.zzb(), bool));
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzj(zzawdVar.zza);
            zzastVar.zzA(zzawdVar.zzb);
        }
    }
}
