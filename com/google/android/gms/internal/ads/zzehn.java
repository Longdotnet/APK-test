package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzehn implements zzdgn {
    final /* synthetic */ zzedp zza;
    final /* synthetic */ zzfca zzb;

    public zzehn(zzeho zzehoVar, zzedp zzedpVar, zzfca zzfcaVar) {
        this.zza = zzedpVar;
        this.zzb = zzfcaVar;
        Objects.requireNonNull(zzehoVar);
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
            zzfduVar.zzz(context);
        } catch (zzfdd e) {
            throw new zzdgm(e.getCause());
        }
    }
}
