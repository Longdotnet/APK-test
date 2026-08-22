package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfqp extends zzfqx {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    public final zzfqx zza(String str) {
        this.zza = "";
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqx zzb(boolean z) {
        this.zzb = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqy zzc() {
        if (this.zzb == 1 && this.zza != null && this.zzc != 0 && this.zzd != 0) {
            return new zzfqr(this.zza, false, this.zzc, null, null, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if (this.zzb == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.zzc == 0) {
            sb.append(" fileChecks");
        }
        if (this.zzd == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqx zzd(int i) {
        this.zzc = i;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfqx
    public final zzfqx zze(int i) {
        this.zzd = 1;
        return this;
    }
}
