package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfm implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzdfm(zzdff zzdffVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
    }

    public static zzdfm zza(zzdff zzdffVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzdfm(zzdffVar, zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel versionInfoParcelZza = ((zzchz) this.zzb).zza();
        final zzfca zzfcaVarZzc = ((zzcrr) this.zzc).zzc();
        final zzfcw zzfcwVarZzc = ((zzcvp) this.zzd).zzc();
        return new zzddv(new zzcxm() { // from class: com.google.android.gms.internal.ads.zzdfd
            @Override // com.google.android.gms.internal.ads.zzcxm
            public final void zzu() {
                com.google.android.gms.ads.internal.util.zzay zzayVar = com.google.android.gms.ads.internal.zzv.zza.zzp;
                Context context2 = context;
                zzfcw zzfcwVar = zzfcwVarZzc;
                zzayVar.zzn(context2, versionInfoParcelZza.afmaVersion, zzfcaVarZzc.zzC.toString(), zzfcwVar.zzf);
            }
        }, zzcaf.zzg);
    }
}
