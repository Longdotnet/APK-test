package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdeh {
    private final List zza;
    private final zzfjy zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;
    private boolean zzd;

    public zzdeh(zzfca zzfcaVar, zzfjy zzfjyVar) {
        this.zza = zzfcaVar.zzp;
        this.zzb = zzfjyVar;
        this.zzc = zzfcaVar.zzax;
    }

    public final void zza() {
        if (this.zzd) {
            return;
        }
        this.zzb.zze(this.zza, this.zzc);
        this.zzd = true;
    }
}
