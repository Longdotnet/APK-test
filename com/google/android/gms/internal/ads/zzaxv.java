package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxv extends zzayk {
    private final zzawa zzh;
    private final long zzi;
    private final long zzj;

    public zzaxv(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, zzawa zzawaVar, long j, long j2) {
        super(zzawxVar, "Q2alXHIIp2vvtZN4ZNw4W3dXvS5FZxkSx8F3noC2XP6gq0/XB0ulYQV32h8ZSW0i", "bHzouddPHTqhUNsOeni/FRK++KVVMe5yU+yUqilZ/gg=", zzastVar, i, 11);
        this.zzh = zzawaVar;
        this.zzi = j;
        this.zzj = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        zzawa zzawaVar = this.zzh;
        if (zzawaVar != null) {
            zzavy zzavyVar = new zzavy((String) this.zze.invoke(null, zzawaVar.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)));
            zzast zzastVar = this.zzd;
            synchronized (zzastVar) {
                try {
                    zzastVar.zzx(zzavyVar.zza.longValue());
                    if (zzavyVar.zzb.longValue() >= 0) {
                        zzastVar.zzO(zzavyVar.zzb.longValue());
                    }
                    if (zzavyVar.zzc.longValue() >= 0) {
                        zzastVar.zzf(zzavyVar.zzc.longValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
