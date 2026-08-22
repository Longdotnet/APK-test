package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpi implements zzhgr {
    private final zzcoz zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;

    private zzcpi(zzcoz zzcozVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzcozVar;
        this.zzb = zzhhaVar;
        this.zzc = zzhhaVar2;
        this.zzd = zzhhaVar3;
        this.zze = zzhhaVar4;
    }

    public static zzcpi zza(zzcoz zzcozVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzcpi(zzcozVar, zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    public static zzddv zzc(zzcoz zzcozVar, final Context context, final VersionInfoParcel versionInfoParcel, final zzfca zzfcaVar, final zzfcw zzfcwVar) {
        return new zzddv(new zzcxm() { // from class: com.google.android.gms.internal.ads.zzcox
            @Override // com.google.android.gms.internal.ads.zzcxm
            public final void zzu() {
                com.google.android.gms.ads.internal.util.zzay zzayVar = com.google.android.gms.ads.internal.zzv.zza.zzp;
                Context context2 = context;
                zzfcw zzfcwVar2 = zzfcwVar;
                zzayVar.zzn(context2, versionInfoParcel.afmaVersion, zzfcaVar.zzC.toString(), zzfcwVar2.zzf);
            }
        }, zzcaf.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (Context) this.zzb.zzb(), ((zzchz) this.zzc).zza(), ((zzcrr) this.zzd).zzc(), ((zzcvp) this.zze).zzc());
    }
}
