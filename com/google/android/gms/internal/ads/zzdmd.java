package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmd implements zzhgr {
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
    private final zzhha zzp;
    private final zzhha zzq;

    private zzdmd(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13, zzhha zzhhaVar14, zzhha zzhhaVar15, zzhha zzhhaVar16, zzhha zzhhaVar17, zzhha zzhhaVar18) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
        this.zzg = zzhhaVar8;
        this.zzh = zzhhaVar9;
        this.zzi = zzhhaVar10;
        this.zzj = zzhhaVar11;
        this.zzk = zzhhaVar12;
        this.zzl = zzhhaVar13;
        this.zzm = zzhhaVar14;
        this.zzn = zzhhaVar15;
        this.zzo = zzhhaVar16;
        this.zzp = zzhhaVar17;
        this.zzq = zzhhaVar18;
    }

    public static zzdmd zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10, zzhha zzhhaVar11, zzhha zzhhaVar12, zzhha zzhhaVar13, zzhha zzhhaVar14, zzhha zzhhaVar15, zzhha zzhhaVar16, zzhha zzhhaVar17, zzhha zzhhaVar18) {
        return new zzdmd(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10, zzhhaVar11, zzhhaVar12, zzhhaVar13, zzhhaVar14, zzhhaVar15, zzhhaVar16, zzhhaVar17, zzhhaVar18);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdmc zzb() {
        return new zzdmc((Context) this.zza.zzb(), (zzdli) this.zzb.zzb(), (zzavu) this.zzc.zzb(), ((zzchz) this.zzd).zza(), ((zzcju) this.zze).zza(), (zzbcc) this.zzf.zzb(), zzffu.zzc(), ((zzcvp) this.zzg).zzc(), (zzdmu) this.zzh.zzb(), (zzdpj) this.zzi.zzb(), (ScheduledExecutorService) this.zzj.zzb(), (zzdsj) this.zzk.zzb(), (zzfjy) this.zzl.zzb(), (zzeca) this.zzm.zzb(), (zzdoe) this.zzn.zzb(), (zzecl) this.zzo.zzb(), (zzfda) this.zzp.zzb(), (zzdsd) this.zzq.zzb());
    }
}
