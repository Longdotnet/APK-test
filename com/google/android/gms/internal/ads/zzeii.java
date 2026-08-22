package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzeii implements zzdgn {
    final /* synthetic */ zzedp zza;
    final /* synthetic */ zzfca zzb;

    public zzeii(zzeik zzeikVar, zzedp zzedpVar, zzfca zzfcaVar) {
        this.zza = zzedpVar;
        this.zzb = zzfcaVar;
        Objects.requireNonNull(zzeikVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) throws zzdgm {
        try {
            zzfdu zzfduVar = (zzfdu) this.zza.zzb;
            zzfduVar.zzv(z);
            zzfduVar.zzA();
        } catch (zzfdd e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot show rewarded video.", e);
            throw new zzdgm(e.getCause());
        }
    }
}
