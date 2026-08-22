package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeys implements zzezr {
    private zzcve zza;
    private final Executor zzb = zzgef.zzc();

    public final zzcve zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzezs zzezsVar, zzezq zzezqVar, zzcve zzcveVar) {
        zzcvd zzcvdVarZza = zzezqVar.zza(zzezsVar.zzb);
        zzcvdVarZza.zzb(new zzezv(true));
        zzcve zzcveVar2 = (zzcve) zzcvdVarZza.zzh();
        this.zza = zzcveVar2;
        final zzcse zzcseVarZzb = zzcveVar2.zzb();
        final zzfes zzfesVar = new zzfes();
        zzgde zzgdeVarZzw = zzgde.zzw(zzcseVarZzb.zzi());
        zzgcu zzgcuVar = new zzgcu(this) { // from class: com.google.android.gms.internal.ads.zzeyq
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                zzfcn zzfcnVar = (zzfcn) obj;
                zzfesVar.zzb = zzfcnVar;
                Iterator it = zzfcnVar.zzb.zza.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Iterator it2 = ((zzfca) it.next()).zza.iterator();
                    while (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            return zzgdn.zzh(null);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return zzcseVarZzb.zzh(zzgdn.zzh(zzfcnVar));
                }
                return zzgdn.zzh(null);
            }
        };
        Executor executor = this.zzb;
        return (zzgde) zzgdn.zzm((zzgde) zzgdn.zzn(zzgdeVarZzw, zzgcuVar, executor), new zzfve() { // from class: com.google.android.gms.internal.ads.zzeyr
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzfes zzfesVar2 = zzfesVar;
                zzfesVar2.zzc = (zzcra) obj;
                return zzfesVar2;
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzb(zzezsVar, zzezqVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
