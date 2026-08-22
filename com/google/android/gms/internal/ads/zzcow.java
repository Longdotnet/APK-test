package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzcow implements zzhgr {
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

    private zzcow(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
        this.zzg = zzhhaVar7;
        this.zzh = zzhhaVar8;
        this.zzi = zzhhaVar9;
        this.zzj = zzhhaVar10;
    }

    public static zzcov zzc(zzcqz zzcqzVar, Context context, zzfcb zzfcbVar, View view, zzcfg zzcfgVar, zzcqy zzcqyVar, zzdje zzdjeVar, zzdef zzdefVar, zzhgl zzhglVar, Executor executor) {
        return new zzcov(zzcqzVar, context, zzfcbVar, view, zzcfgVar, zzcqyVar, zzdjeVar, zzdefVar, zzhglVar, executor);
    }

    public static zzcow zzd(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6, zzhha zzhhaVar7, zzhha zzhhaVar8, zzhha zzhhaVar9, zzhha zzhhaVar10) {
        return new zzcow(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6, zzhhaVar7, zzhhaVar8, zzhhaVar9, zzhhaVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcov zzb() {
        return new zzcov(((zzcth) this.zza).zzb(), (Context) this.zzb.zzb(), ((zzcpc) this.zzc).zzc(), ((zzcpb) this.zzd).zza(), ((zzcpq) this.zze).zza(), ((zzcpd) this.zzf).zzc(), ((zzdgz) this.zzg).zzc(), (zzdef) this.zzh.zzb(), zzhgq.zza(this.zzi), (Executor) this.zzj.zzb());
    }
}
