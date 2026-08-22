package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class zzcin extends zzevf {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    final zzhha zzh;
    final zzhha zzi;
    final zzhha zzj;
    final zzhha zzk;
    final zzhha zzl;
    final zzhha zzm;
    final zzhha zzn;
    final zzhha zzo;
    final zzhha zzp;
    final zzhha zzq;
    final zzhha zzr;
    final zzhha zzs;
    final zzhha zzt;
    final zzhha zzu;
    final zzhha zzv;
    final zzhha zzw;
    final zzhha zzx;
    private final zzewi zzy;
    private final zzcio zzz;

    public zzcin(zzcio zzcioVar, zzewi zzewiVar) {
        this.zzz = zzcioVar;
        this.zzy = zzewiVar;
        this.zza = zzhgq.zzc(zzfhv.zza(zzcioVar.zzz));
        zzewk zzewkVarZza = zzewk.zza(zzewiVar);
        this.zzb = zzewkVarZza;
        zzewl zzewlVarZza = zzewl.zza(zzewiVar);
        this.zzc = zzewlVarZza;
        zzewm zzewmVarZza = zzewm.zza(zzewiVar);
        this.zzd = zzewmVarZza;
        zzckz zzckzVar = zzcky.zza;
        zzhha zzhhaVar = zzcioVar.zzf;
        zzhha zzhhaVar2 = zzcioVar.zzc;
        this.zze = zzeve.zza(zzckzVar, zzhhaVar, zzhhaVar2, zzffu.zza(), zzewkVarZza, zzewlVarZza, zzewmVarZza);
        this.zzf = zzevs.zza(zzcks.zza, zzffu.zza(), zzhhaVar);
        zzewj zzewjVarZza = zzewj.zza(zzewiVar);
        this.zzg = zzewjVarZza;
        this.zzh = zzewa.zza(zzcku.zza, zzffu.zza(), zzewjVarZza);
        this.zzi = zzewh.zza(zzckw.zza, zzhhaVar2, zzhhaVar);
        this.zzj = zzewz.zza(zzffu.zza());
        zzewo zzewoVarZza = zzewo.zza(zzewiVar);
        this.zzk = zzewoVarZza;
        zzewp zzewpVarZza = zzewp.zza(zzewiVar);
        this.zzl = zzewpVarZza;
        zzhha zzhhaVar3 = zzcioVar.zzal;
        this.zzm = zzewv.zza(zzhhaVar3, zzewmVarZza, zzcla.zza, zzffu.zza(), zzewjVarZza, zzhhaVar2, zzewoVarZza, zzewpVarZza);
        this.zzn = zzevo.zza(zzewjVarZza, zzckq.zza, zzhhaVar3, zzhhaVar2, zzffu.zza());
        zzewn zzewnVarZza = zzewn.zza(zzewiVar);
        this.zzo = zzewnVarZza;
        zzhha zzhhaVarZzc = zzhgq.zzc(zzdrd.zza());
        this.zzp = zzhhaVarZzc;
        zzhha zzhhaVarZzc2 = zzhgq.zzc(zzdrb.zza());
        this.zzq = zzhhaVarZzc2;
        zzhha zzhhaVarZzc3 = zzhgq.zzc(zzdrf.zza());
        this.zzr = zzhhaVarZzc3;
        zzhha zzhhaVarZzc4 = zzhgq.zzc(zzdrh.zza());
        this.zzs = zzhhaVarZzc4;
        zzhgu zzhguVarZzc = zzhgv.zzc(4);
        zzhguVarZzc.zzb(zzfgu.GMS_SIGNALS, zzhhaVarZzc);
        zzhguVarZzc.zzb(zzfgu.BUILD_URL, zzhhaVarZzc2);
        zzhguVarZzc.zzb(zzfgu.HTTP, zzhhaVarZzc3);
        zzhguVarZzc.zzb(zzfgu.PRE_PROCESS, zzhhaVarZzc4);
        zzhgv zzhgvVarZzc = zzhguVarZzc.zzc();
        this.zzt = zzhgvVarZzc;
        zzhha zzhhaVarZzc5 = zzhgq.zzc(zzdri.zza(zzewnVarZza, zzcioVar.zzf, zzffu.zza(), zzhgvVarZzc));
        this.zzu = zzhhaVarZzc5;
        zzhhc zzhhcVarZza = zzhhd.zza(0, 1);
        zzhhcVarZza.zza(zzhhaVarZzc5);
        zzhhd zzhhdVarZzc = zzhhcVarZza.zzc();
        this.zzv = zzhhdVarZzc;
        zzfhd zzfhdVarZzc = zzfhd.zzc(zzhhdVarZzc);
        this.zzw = zzfhdVarZzc;
        this.zzx = zzhgq.zzc(zzfhc.zza(zzffu.zza(), zzcioVar.zzc, zzfhdVarZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzeuf zza() {
        zzcio zzcioVar = this.zzz;
        Context contextZzc = zzchl.zzc(zzcioVar.zzbp);
        zzhha zzhhaVar = this.zza;
        zzhha zzhhaVar2 = this.zzn;
        zzhha zzhhaVar3 = this.zzm;
        zzhha zzhhaVar4 = this.zzj;
        zzhha zzhhaVar5 = this.zzi;
        zzhha zzhhaVar6 = this.zzh;
        zzhha zzhhaVar7 = this.zzf;
        zzhha zzhhaVar8 = this.zze;
        return zzewq.zza(contextZzc, zzckv.zza(), zzclb.zza(), zzcioVar.zzbo.zzb(), zzc(), zzd(), zzhgq.zza(zzhhaVar8), zzhgq.zza(zzhhaVar7), zzhgq.zza(zzhhaVar6), zzhgq.zza(zzhhaVar5), zzhgq.zza(zzhhaVar4), zzhgq.zza(zzhhaVar3), zzhgq.zza(zzhhaVar2), zzffu.zzc(), (zzfhu) zzhhaVar.zzb(), (zzdsj) zzcioVar.zzl.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzeuf zzb() {
        zzcio zzcioVar = this.zzz;
        Context contextZzc = zzchl.zzc(zzcioVar.zzbp);
        zzewi zzewiVar = this.zzy;
        zzgdy zzgdyVarZzc = zzffu.zzc();
        zzevy zzevyVar = new zzevy(zzckv.zza(), zzffu.zzc(), zzewj.zzd(zzewiVar));
        zzhha zzhhaVar = zzcioVar.zzc;
        return new zzeuf(contextZzc, zzgdyVarZzc, zzfyv.zzs(new zzeso(zzevyVar, 0L, (ScheduledExecutorService) zzhhaVar.zzb()), new zzeso(new zzewf(zzckx.zza(), (ScheduledExecutorService) zzhhaVar.zzb(), zzchl.zzc(zzcioVar.zzbp)), ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzex)).longValue(), (ScheduledExecutorService) zzhhaVar.zzb()), new zzeso(zzeve.zzc(zzckz.zza(), zzchl.zzc(zzcioVar.zzbp), (ScheduledExecutorService) zzhhaVar.zzb(), zzffu.zzc(), zzewiVar.zza(), zzewl.zzd(zzewiVar), zzewm.zzd(zzewiVar)), 0L, (ScheduledExecutorService) zzhhaVar.zzb()), new zzeso(new zzewx(zzffu.zzc()), 0L, (ScheduledExecutorService) zzhhaVar.zzb()), new zzevq(zzckt.zza(), zzffu.zzc(), zzchl.zzc(zzcioVar.zzbp)), zzd(), zzc(), (zzeuc) zzcioVar.zzbo.zzb(), zzevo.zzc(zzewj.zzd(zzewiVar), zzckr.zza(), (zzbzs) zzcioVar.zzal.zzb(), (ScheduledExecutorService) zzhhaVar.zzb(), zzffu.zzc())), (zzfhu) this.zza.zzb(), (zzdsj) zzcioVar.zzl.zzb());
    }

    public final zzevi zzc() {
        zzewi zzewiVar = this.zzy;
        return new zzevi(zzckz.zza(), zzffu.zzc(), zzewiVar.zzf(), zzewiVar.zzd(), zzewiVar.zza());
    }

    public final zzewc zzd() {
        zzewi zzewiVar = this.zzy;
        zzbcn zzbcnVarZza = zzcko.zza();
        zzgdy zzgdyVarZzc = zzffu.zzc();
        List listZzh = zzewiVar.zzh();
        zzhgz.zzb(listZzh);
        return new zzewc(zzbcnVarZza, zzgdyVarZzc, listZzh);
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzfha zze() {
        return (zzfha) this.zzx.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzevf
    public final zzfhu zzf() {
        return (zzfhu) this.zza.zzb();
    }
}
