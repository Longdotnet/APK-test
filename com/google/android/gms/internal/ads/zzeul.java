package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzeul implements zzeub {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final String zzh;
    public final ArrayList zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;
    public final boolean zzm;
    public final String zzn;
    public final long zzo;
    public final boolean zzp;
    public final String zzq;
    public final int zzr;

    public zzeul(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList arrayList, String str3, String str4, String str5, boolean z6, String str6, long j, boolean z7, String str7, int i, String str8) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = z5;
        this.zzg = str2;
        this.zzh = str8;
        this.zzi = arrayList;
        this.zzj = str3;
        this.zzk = str4;
        this.zzl = str5;
        this.zzm = z6;
        this.zzn = str6;
        this.zzo = j;
        this.zzp = z7;
        this.zzq = str7;
        this.zzr = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcva) obj).zzb;
        bundle.putBoolean("simulator", this.zzd);
        bundle.putInt("build_api_level", this.zzr);
        ArrayList<String> arrayList = this.zzi;
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("hl_list", arrayList);
        }
        bundle.putString("submodel", this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        bundle.putBoolean("cog", this.zza);
        bundle.putBoolean("coh", this.zzb);
        bundle.putString("gl", this.zzc);
        bundle.putBoolean("simulator", this.zzd);
        bundle.putBoolean("is_latchsky", this.zze);
        bundle.putInt("build_api_level", this.zzr);
        zzbcv zzbcvVar = zzbde.zzlx;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            bundle.putBoolean("is_sidewinder", this.zzf);
        }
        bundle.putString("hl", this.zzg);
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zznI)).booleanValue()) {
            bundle.putString("dlc", this.zzh);
        }
        ArrayList<String> arrayList = this.zzi;
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("hl_list", arrayList);
        }
        bundle.putString("mv", this.zzj);
        bundle.putString("submodel", this.zzn);
        Bundle bundleZza = zzfdk.zza(bundle, "device");
        bundle.putBundle("device", bundleZza);
        bundleZza.putString("build", this.zzl);
        bundleZza.putLong("remaining_data_partition_space", this.zzo);
        Bundle bundleZza2 = zzfdk.zza(bundleZza, "browser");
        bundleZza.putBundle("browser", bundleZza2);
        bundleZza2.putBoolean("is_browser_custom_tabs_capable", this.zzm);
        String str = this.zzk;
        if (!TextUtils.isEmpty(str)) {
            Bundle bundleZza3 = zzfdk.zza(bundleZza, "play_store");
            bundleZza.putBundle("play_store", bundleZza3);
            bundleZza3.putString("package_version", str);
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzlN)).booleanValue()) {
            bundle.putBoolean("is_bstar", this.zzp);
        }
        String str2 = this.zzq;
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("v_unity", str2);
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzlH)).booleanValue()) {
            zzfdk.zzg(bundle, "gotmt_l", true, ((Boolean) zzbdVar.zzd.zzb(zzbde.zzlE)).booleanValue());
            zzfdk.zzg(bundle, "gotmt_i", true, ((Boolean) zzbdVar.zzd.zzb(zzbde.zzlD)).booleanValue());
        }
    }
}
