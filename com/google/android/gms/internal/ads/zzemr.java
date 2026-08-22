package com.google.android.gms.internal.ads;

import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzemr implements zzeub {
    public final com.google.android.gms.ads.internal.client.zzr zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;
    public final Insets zzj;

    public zzemr(com.google.android.gms.ads.internal.client.zzr zzrVar, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2, Insets insets) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzrVar, "the adSize must not be null");
        this.zza = zzrVar;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = f;
        this.zzf = i;
        this.zzg = i2;
        this.zzh = str3;
        this.zzi = z2;
        this.zzj = insets;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
        zzc(((zzcva) obj).zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zzb(Object obj) {
        zzc(((zzcva) obj).zza);
    }

    private final void zzc(Bundle bundle) {
        Insets insets;
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.zza;
        int i = zzrVar.zze;
        zzfdk.zzf(bundle, "smart_w", "full", i == -1);
        int i2 = zzrVar.zzb;
        zzfdk.zzf(bundle, "smart_h", "auto", i2 == -2);
        zzfdk.zzg(bundle, "ene", true, zzrVar.zzj);
        zzfdk.zzf(bundle, "rafmt", "102", zzrVar.zzm);
        zzfdk.zzf(bundle, "rafmt", "103", zzrVar.zzn);
        boolean z = zzrVar.zzo;
        zzfdk.zzf(bundle, "rafmt", "105", z);
        zzfdk.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzfdk.zzg(bundle, "interscroller_slot", true, z);
        zzfdk.zzc(bundle, "format", this.zzb);
        zzfdk.zzf(bundle, "fluid", "height", this.zzc);
        String str = this.zzd;
        zzfdk.zzf(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        String str2 = this.zzh;
        zzfdk.zzf(bundle, "sc", str2, true ^ TextUtils.isEmpty(str2));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznH)).booleanValue() && Build.VERSION.SDK_INT >= 35 && (insets = this.zzj) != null) {
            bundle.putInt("sam_t", insets.top);
            bundle.putInt(eoBKjVuj.lZusIZhprzjdDML, insets.bottom);
            bundle.putInt("sam_l", insets.left);
            bundle.putInt("sam_r", insets.right);
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar.zzg;
        if (zzrVarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", i2);
            bundle2.putInt("width", i);
            bundle2.putBoolean("is_fluid_height", zzrVar.zzi);
            arrayList.add(bundle2);
        } else {
            for (com.google.android.gms.ads.internal.client.zzr zzrVar2 : zzrVarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzrVar2.zzi);
                bundle3.putInt("height", zzrVar2.zzb);
                bundle3.putInt("width", zzrVar2.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
