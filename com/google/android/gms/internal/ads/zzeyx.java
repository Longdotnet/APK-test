package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyx implements zzezr {
    private final zzezr zza;
    private final zzezr zzb;
    private final zzfff zzc;
    private final String zzd;
    private zzcve zze;
    private final Executor zzf;

    public zzeyx(zzezr zzezrVar, zzezr zzezrVar2, zzfff zzfffVar, String str, Executor executor) {
        this.zza = zzezrVar;
        this.zzb = zzezrVar2;
        this.zzc = zzfffVar;
        this.zzd = str;
        this.zzf = executor;
    }

    public static /* synthetic */ ListenableFuture zzb(final zzeyx zzeyxVar, zzezs zzezsVar, zzeyw zzeywVar, zzezq zzezqVar, zzcve zzcveVar, zzezc zzezcVar) {
        if (zzezcVar != null) {
            zzeyw zzeywVar2 = new zzeyw(zzeywVar.zza, zzeywVar.zzb, zzeywVar.zzc, zzeywVar.zzd, zzeywVar.zze, zzeywVar.zzf, zzezcVar.zza);
            zzfes zzfesVar = zzezcVar.zzc;
            if (zzfesVar != null) {
                zzeyxVar.zze = null;
                zzeyxVar.zzc.zzf(zzeywVar2);
                return zzeyxVar.zzg(zzfesVar, zzezsVar);
            }
            zzfff zzfffVar = zzeyxVar.zzc;
            ListenableFuture listenableFutureZza = zzfffVar.zza(zzeywVar2);
            if (listenableFutureZza != null) {
                zzeyxVar.zze = null;
                return zzgdn.zzn(listenableFutureZza, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeyt
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzeyx.zze(this.zza, (zzffc) obj);
                    }
                }, zzeyxVar.zzf);
            }
            zzfffVar.zzf(zzeywVar2);
            zzezsVar = new zzezs(zzezsVar.zzb, zzezcVar.zzb);
        }
        ListenableFuture listenableFutureZzb = ((zzezh) zzeyxVar.zza).zzb(zzezsVar, zzezqVar, zzcveVar);
        zzeyxVar.zze = zzcveVar;
        return listenableFutureZzb;
    }

    public static /* synthetic */ ListenableFuture zze(zzeyx zzeyxVar, zzffc zzffcVar) throws zzdwm {
        zzfes zzfesVar;
        zzffe zzffeVar;
        if (zzffcVar == null || (zzfesVar = zzffcVar.zza) == null || (zzffeVar = zzffcVar.zzb) == null) {
            throw new zzdwm(1, "Empty prefetch");
        }
        zzbcj.zzb.zzc zzcVarZzd = zzbcj.zzb.zzd();
        zzbcj.zzb.zza.C0004zza c0004zzaZza = zzbcj.zzb.zza.zza();
        c0004zzaZza.zzf(zzbcj.zzb.zzd.IN_MEMORY);
        c0004zzaZza.zzh(zzbcj.zzb.zze.zzi());
        zzcVarZzd.zzd(c0004zzaZza);
        zzfesVar.zza.zzb().zzc().zzm(zzcVarZzd.zzbr());
        return zzeyxVar.zzg(zzfesVar, ((zzeyw) zzffeVar).zzb);
    }

    private final ListenableFuture zzg(zzfes zzfesVar, zzezs zzezsVar) {
        zzcve zzcveVar = zzfesVar.zza;
        this.zze = zzcveVar;
        if (zzfesVar.zzc != null) {
            if (zzcveVar.zze() != null) {
                zzfesVar.zzc.zzp().zzl(zzfesVar.zza.zze());
            }
            return zzgdn.zzh(zzfesVar.zzc);
        }
        zzcveVar.zzb().zzk(zzfesVar.zzb);
        return ((zzezh) this.zza).zzb(zzezsVar, null, zzfesVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcve zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzf(zzezsVar, zzezqVar, null);
    }

    public final synchronized ListenableFuture zzf(final zzezs zzezsVar, final zzezq zzezqVar, zzcve zzcveVar) {
        zzcvd zzcvdVarZza = zzezqVar.zza(zzezsVar.zzb);
        zzcvdVarZza.zza(new zzeyy(this.zzd));
        final zzcve zzcveVar2 = (zzcve) zzcvdVarZza.zzh();
        zzcveVar2.zzf();
        zzcveVar2.zzf();
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzcveVar2.zzf().zzd;
        if (zzmVar.zzs == null && zzmVar.zzx == null) {
            zzfcw zzfcwVarZzf = zzcveVar2.zzf();
            com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzfcwVarZzf.zzd;
            String str = zzfcwVarZzf.zzf;
            com.google.android.gms.ads.internal.client.zzx zzxVar = zzfcwVarZzf.zzj;
            Executor executor = this.zzf;
            final zzeyw zzeywVar = new zzeyw(zzezqVar, zzezsVar, zzmVar2, str, executor, zzxVar, null);
            return (zzgde) zzgdn.zzn(zzgde.zzw(((zzezd) this.zzb).zzb(zzezsVar, zzezqVar, zzcveVar2)), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeyu
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzeyx.zzb(this.zza, zzezsVar, zzeywVar, zzezqVar, zzcveVar2, (zzezc) obj);
                }
            }, executor);
        }
        this.zze = zzcveVar2;
        return ((zzezh) this.zza).zzb(zzezsVar, zzezqVar, zzcveVar2);
    }
}
