package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzenw implements zzeuc {
    final Context zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzcsq zze;
    private final zzfed zzf;
    private final zzfcw zzg;
    private final com.google.android.gms.ads.internal.util.zzg zzh = com.google.android.gms.ads.internal.zzv.zza.zzi.zzi();
    private final zzdsd zzi;
    private final zzcte zzj;

    public zzenw(Context context, String str, String str2, zzcsq zzcsqVar, zzfed zzfedVar, zzfcw zzfcwVar, zzdsd zzdsdVar, zzcte zzcteVar, long j) {
        this.zza = context;
        this.zzb = str;
        this.zzc = str2;
        this.zze = zzcsqVar;
        this.zzf = zzfedVar;
        this.zzg = zzfcwVar;
        this.zzi = zzdsdVar;
        this.zzj = zzcteVar;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        Bundle bundle = new Bundle();
        zzdsd zzdsdVar = this.zzi;
        Map mapZzb = zzdsdVar.zzb();
        String str = this.zzb;
        mapZzb.put("seq_num", str);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzdsdVar.zzd("tsacc", String.valueOf(System.currentTimeMillis() - this.zzd));
            zzdsdVar.zzd("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zza) ? "1" : "0");
        }
        zzcsq zzcsqVar = this.zze;
        zzfcw zzfcwVar = this.zzg;
        zzcsqVar.zzk(zzfcwVar.zzd);
        bundle.putAll(this.zzf.zzb());
        return zzgdn.zzh(new zzenx(this.zza, bundle, str, this.zzc, this.zzh, zzfcwVar.zzf, this.zzj));
    }
}
