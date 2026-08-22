package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzcuo implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzcuo(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzcuo zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzcuo(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel versionInfoParcelZza = ((zzchz) this.zzb).zza();
        final zzfcw zzfcwVarZzc = ((zzcvp) this.zzc).zzc();
        return new zzfve() { // from class: com.google.android.gms.internal.ads.zzcun
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                zzfca zzfcaVar = (zzfca) obj;
                com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
                zzauVar.zzc = zzfcaVar.zzB;
                zzauVar.zzf = zzfcaVar.zzC.toString();
                zzauVar.zze = versionInfoParcelZza.afmaVersion;
                zzauVar.zzd = zzfcwVarZzc.zzf;
                return zzauVar;
            }
        };
    }
}
