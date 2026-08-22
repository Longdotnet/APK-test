package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzefm implements zzdgn {
    private final zzfca zza;
    private final zzbrp zzb;
    private final AdFormat zzc;
    private zzcwq zzd = null;

    public zzefm(zzfca zzfcaVar, zzbrp zzbrpVar, AdFormat adFormat) {
        this.zza = zzfcaVar;
        this.zzb = zzbrpVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) throws zzdgm {
        boolean zZzs;
        try {
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(new ObjectWrapper(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzs = this.zzb.zzr(new ObjectWrapper(context));
                    }
                    throw new zzdgm("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(new ObjectWrapper(context));
            }
            if (zZzs) {
                zzcwq zzcwqVar = this.zzd;
                if (zzcwqVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbI)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                zzcwqVar.zza();
                return;
            }
            throw new zzdgm("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdgm(th);
        }
    }

    public final void zzc(zzcwq zzcwqVar) {
        this.zzd = zzcwqVar;
    }
}
