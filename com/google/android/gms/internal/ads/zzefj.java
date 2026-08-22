package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzefj implements zzdgn {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfca zzd;
    private final zzcfg zze;
    private final zzfcw zzf;
    private final zzbki zzg;
    private final boolean zzh;
    private final zzecl zzi;
    private final zzdsj zzj;

    public zzefj(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfca zzfcaVar, zzcfg zzcfgVar, zzfcw zzfcwVar, boolean z, zzbki zzbkiVar, zzecl zzeclVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfcaVar;
        this.zze = zzcfgVar;
        this.zzf = zzfcwVar;
        this.zzg = zzbkiVar;
        this.zzh = z;
        this.zzi = zzeclVar;
        this.zzj = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzdfc zzdfcVar = (zzdfc) zzgdn.zzq(this.zzc);
        zzcfg zzcfgVar = this.zze;
        zzcfgVar.zzaq(true);
        boolean z2 = this.zzh;
        boolean zZze = z2 ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        boolean zZzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zza);
        boolean z3 = z2 && this.zzg.zzd();
        float fZza = z2 ? this.zzg.zza() : 0.0f;
        zzfca zzfcaVar = this.zzd;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZze, zZzJ, z3, fZza, z, zzfcaVar.zzO, false);
        if (zzcwlVar != null) {
            zzcwlVar.zzf();
        }
        zzdgc zzdgcVarZzh = zzdfcVar.zzh();
        int i = zzfcaVar.zzQ;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String str = zzfcaVar.zzB;
        zzfcf zzfcfVar = zzfcaVar.zzs;
        GraphRequest.Companion.zza(context, new AdOverlayInfoParcel(zzdgcVarZzh, zzcfgVar, i, versionInfoParcel, str, zzlVar, zzfcfVar.zzb, zzfcfVar.zza, this.zzf.zzf, zzcwlVar, zzfcaVar.zzb() ? this.zzi : null, zzcfgVar.zzr()), true, this.zzj);
    }
}
