package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzezn {
    private final zzfej zza;
    private final zzcve zzb;
    private final Executor zzc;
    private zzezl zzd;

    public zzezn(zzfej zzfejVar, zzcve zzcveVar, Executor executor) {
        this.zza = zzfejVar;
        this.zzb = zzcveVar;
        this.zzc = executor;
    }

    @Deprecated
    public final zzfet zze() {
        zzfcw zzfcwVarZzf = this.zzb.zzf();
        return this.zza.zzc(zzfcwVarZzf.zzd, zzfcwVarZzf.zzf, zzfcwVarZzf.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFutureZzh;
        zzezl zzezlVar = this.zzd;
        if (zzezlVar != null) {
            return zzgdn.zzh(zzezlVar);
        }
        if (((Boolean) zzbfl.zza.zze()).booleanValue()) {
            zzgde zzgdeVarZzw = zzgde.zzw(this.zzb.zzb().zzf(this.zza.zza()));
            zzezk zzezkVar = new zzezk(this);
            Executor executor = this.zzc;
            listenableFutureZzh = (zzgde) zzgdn.zze((zzgde) zzgdn.zzm(zzgdeVarZzw, zzezkVar, executor), zzdyx.class, new zzezj(this), executor);
        } else {
            zzezl zzezlVar2 = new zzezl(null, zze(), null);
            this.zzd = zzezlVar2;
            listenableFutureZzh = zzgdn.zzh(zzezlVar2);
        }
        return zzgdn.zzm(listenableFutureZzh, new zzfve() { // from class: com.google.android.gms.internal.ads.zzezi
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return (zzezl) obj;
            }
        }, this.zzc);
    }
}
