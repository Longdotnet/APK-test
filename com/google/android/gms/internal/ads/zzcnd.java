package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnd implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;
    private final zzhha zzg;
    private final zzhha zzh;
    private final zzhha zzi;
    private final zzhha zzj;
    private final zzhha zzk;
    private final zzhha zzl;
    private final zzhha zzm;
    private final zzhha zzn;
    private final zzhha zzo;

    private zzcnd(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13, zzhha zzhhaVar14, zzhha zzhhaVar15, zzhha zzhhaVar16, zzhha zzhhaVar17) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
        this.zzd = zzhhaVar5;
        this.zze = zzhhaVar6;
        this.zzf = zzhhaVar7;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
        this.zzj = zzhhaVar11;
        this.zzk = zzhhaVar12;
        this.zzl = zzhhaVar14;
        this.zzm = zzhhaVar15;
        this.zzn = zzhhaVar16;
        this.zzo = zzhhaVar17;
    }

    public static zzcnd zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13, zzhha zzhhaVar14, zzhha zzhhaVar15, zzhha zzhhaVar16, zzhha zzhhaVar17) {
        return new zzcnd(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11, zzhhaVar12, zzhhaVar13, zzhhaVar14, zzhhaVar15, zzhhaVar16, zzhhaVar17);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcnc(((zzchl) this.zza).zza(), zzffu.zzc(), (Executor) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), ((zzcru) this.zzd).zzc(), ((zzcrr) this.zze).zzc(), (zzfju) this.zzf.zzb(), (zzfdi) this.zzg.zzb(), (View) this.zzh.zzb(), (zzcfg) this.zzi.zzb(), (zzavu) this.zzj.zzb(), (zzbel) this.zzk.zzb(), zzcjv.zzc(), (zzfhu) this.zzl.zzb(), ((zzcvl) this.zzm).zza(), (zzcyi) this.zzn.zzb(), (zzcuu) this.zzo.zzb());
    }
}
