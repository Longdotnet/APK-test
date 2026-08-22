package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class zzenx implements zzeub {
    private final Context zza;
    private final Bundle zzb;
    private final String zzc;
    private final String zzd;
    private final com.google.android.gms.ads.internal.util.zzg zze;
    private final String zzf;
    private final zzcte zzg;

    public zzenx(Context context, Bundle bundle, String str, String str2, com.google.android.gms.ads.internal.util.zzg zzgVar, String str3, zzcte zzcteVar) {
        this.zza = context;
        this.zzb = bundle;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzgVar;
        this.zzf = str3;
        this.zzg = zzcteVar;
    }

    private final void zzc(Bundle bundle) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfU)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                bundle.putString("_app_id", com.google.android.gms.ads.internal.util.zzs.zzq(this.zza));
            } catch (RemoteException | RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AppStatsSignal_AppId");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcva) obj).zzb;
        bundle.putBundle("quality_signals", this.zzb);
        zzc(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        bundle.putBundle("quality_signals", this.zzb);
        bundle.putString("seq_num", this.zzc);
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) this.zze;
        if (!zzjVar.zzN()) {
            bundle.putString("session_id", this.zzd);
        }
        bundle.putBoolean("client_purpose_one", !zzjVar.zzN());
        zzc(bundle);
        String str = this.zzf;
        if (str != null) {
            Bundle bundle2 = new Bundle();
            zzcte zzcteVar = this.zzg;
            bundle2.putLong("dload", zzcteVar.zzb(str));
            bundle2.putInt("pcc", zzcteVar.zza(str));
            bundle.putBundle("ad_unit_quality_signals", bundle2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkh)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            if (zzvVar.zzi.zza() > 0) {
                bundle.putInt("nrwv", zzvVar.zzi.zza());
            }
        }
    }
}
