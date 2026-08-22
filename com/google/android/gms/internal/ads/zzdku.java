package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdku implements zzcws {
    private final zzdit zza;
    private final zzdiy zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdku(zzdit zzditVar, zzdiy zzdiyVar, Executor executor, Executor executor2) {
        this.zza = zzditVar;
        this.zzb = zzdiyVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcfg zzcfgVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdks
            @Override // java.lang.Runnable
            public final void run() {
                zzcfgVar.zzd("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        if (this.zzb.zzd()) {
            zzdit zzditVar = this.zza;
            zzedh zzedhVarZzu = zzditVar.zzu();
            if (zzedhVarZzu == null && zzditVar.zzw() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfG)).booleanValue()) {
                ListenableFuture listenableFutureZzw = zzditVar.zzw();
                zzcak zzcakVarZzp = zzditVar.zzp();
                if (listenableFutureZzw == null || zzcakVarZzp == null) {
                    return;
                }
                zzgdn.zzr(zzgdn.zzl(listenableFutureZzw, zzcakVarZzp), new zzdkt(this), this.zzd);
                return;
            }
            if (zzedhVarZzu != null) {
                zzcfg zzcfgVarZzr = zzditVar.zzr();
                zzcfg zzcfgVarZzs = zzditVar.zzs();
                if (zzcfgVarZzr == null) {
                    zzcfgVarZzr = zzcfgVarZzs == null ? null : zzcfgVarZzs;
                }
                if (zzcfgVarZzr != null) {
                    zzb(zzcfgVarZzr);
                }
            }
        }
    }
}
