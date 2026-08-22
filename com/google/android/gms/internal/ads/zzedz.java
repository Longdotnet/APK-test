package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzedz implements zzdgn {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfca zzc;
    private final zzcfg zzd;
    private final zzfcw zze;
    private final zzbki zzf;
    private final boolean zzg;
    private final zzecl zzh;
    private final zzdsj zzi;

    public zzedz(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfca zzfcaVar, zzcfg zzcfgVar, zzfcw zzfcwVar, boolean z, zzbki zzbkiVar, zzecl zzeclVar, zzdsj zzdsjVar) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfcaVar;
        this.zzd = zzcfgVar;
        this.zze = zzfcwVar;
        this.zzg = z;
        this.zzf = zzbkiVar;
        this.zzh = zzeclVar;
        this.zzi = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzc;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzcod zzcodVar = (zzcod) zzgdn.zzq(this.zzb);
        zzcfg zzcfgVar = this.zzd;
        zzcfgVar.zzaq(true);
        boolean z2 = this.zzg;
        boolean zZze = z2 ? this.zzf.zze(true) : true;
        boolean z3 = z2 && this.zzf.zzd();
        float fZza = z2 ? this.zzf.zza() : 0.0f;
        zzfca zzfcaVar = this.zzc;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZze, true, z3, fZza, z, zzfcaVar.zzO, false);
        if (zzcwlVar != null) {
            zzcwlVar.zzf();
        }
        GraphRequest.Companion companion = com.google.android.gms.ads.internal.zzv.zza.zzc;
        zzdgc zzdgcVarZzg = zzcodVar.zzg();
        int i = zzfcaVar.zzQ;
        if (i == -1) {
            com.google.android.gms.ads.internal.client.zzx zzxVar = this.zze.zzj;
            if (zzxVar == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Error setting app open orientation; no targeting orientation available.");
            } else {
                int i3 = zzxVar.zza;
                if (i3 == 1) {
                    i = 7;
                } else if (i3 == 2) {
                    i = 6;
                } else {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Error setting app open orientation; no targeting orientation available.");
                }
            }
        }
        int i5 = i;
        VersionInfoParcel versionInfoParcel = this.zza;
        String str = zzfcaVar.zzB;
        zzfcf zzfcfVar = zzfcaVar.zzs;
        GraphRequest.Companion.zza(context, new AdOverlayInfoParcel(zzdgcVarZzg, zzcfgVar, i5, versionInfoParcel, str, zzlVar, zzfcfVar.zzb, zzfcfVar.zza, this.zze.zzf, zzcwlVar, zzfcaVar.zzb() ? this.zzh : null, zzcfgVar.zzr()), true, this.zzi);
    }
}
