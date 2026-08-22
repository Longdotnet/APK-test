package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvb {
    private final zzfha zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhgl zzg;
    private final String zzh;
    private final zzeuf zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfcw zzk;
    private final int zzl;
    private final zzdbo zzm;

    public zzcvb(zzfha zzfhaVar, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhgl zzhglVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzeuf zzeufVar, zzfcw zzfcwVar, zzdbo zzdboVar, int i) {
        this.zza = zzfhaVar;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhglVar;
        this.zzh = str2;
        this.zzi = zzeufVar;
        this.zzj = zzgVar;
        this.zzk = zzfcwVar;
        this.zzm = zzdboVar;
        this.zzl = i;
    }

    public static zzbvq zza(zzcvb zzcvbVar, ListenableFuture listenableFuture, Bundle bundle) {
        zzcva zzcvaVar = (zzcva) listenableFuture.get();
        Bundle bundle2 = zzcvaVar.zza;
        String str = (String) ((ListenableFuture) zzcvbVar.zzg.zzb()).get();
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhk)).booleanValue() && ((com.google.android.gms.ads.internal.util.zzj) zzcvbVar.zzj).zzN();
        String str2 = zzcvbVar.zzh;
        PackageInfo packageInfo = zzcvbVar.zzf;
        List list = zzcvbVar.zze;
        return new zzbvq(bundle2, zzcvbVar.zzb, zzcvbVar.zzc, zzcvbVar.zzd, list, packageInfo, str, str2, null, null, z, zzcvbVar.zzk.zza(), bundle, zzcvaVar.zzb, zzcvbVar.zzl);
    }

    public final ListenableFuture zzb(Bundle bundle) {
        this.zzm.zza();
        zzfgu zzfguVar = zzfgu.SIGNALS;
        zzfha zzfhaVar = this.zza;
        Objects.requireNonNull(zzfhaVar);
        return zzfgk.zzc(this.zzi.zza(new zzcva(new Bundle(), new Bundle()), bundle, this.zzl == 2), zzfguVar, zzfhaVar).zza();
    }

    public final ListenableFuture zzc() {
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzs;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        final ListenableFuture listenableFutureZzb = zzb(bundle);
        return this.zza.zza(zzfgu.REQUEST_PARCEL, listenableFutureZzb, (ListenableFuture) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcuz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcvb.zza(this.zza, listenableFutureZzb, bundle);
            }
        }).zza();
    }
}
