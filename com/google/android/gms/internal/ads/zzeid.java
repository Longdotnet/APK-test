package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
final class zzeid implements zzdgn {
    private final Context zza;
    private final zzdpj zzb;
    private final zzfcw zzc;
    private final VersionInfoParcel zzd;
    private final zzfca zze;
    private final ListenableFuture zzf;
    private final zzcfg zzg;
    private final zzbki zzh;
    private final boolean zzi;
    private final zzecl zzj;
    private final zzdsd zzk;
    private final zzdsj zzl;

    public zzeid(Context context, zzdpj zzdpjVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel, zzfca zzfcaVar, ListenableFuture listenableFuture, zzcfg zzcfgVar, zzbki zzbkiVar, boolean z, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzdpjVar;
        this.zzc = zzfcwVar;
        this.zzd = versionInfoParcel;
        this.zze = zzfcaVar;
        this.zzf = listenableFuture;
        this.zzg = zzcfgVar;
        this.zzh = zzbkiVar;
        this.zzi = z;
        this.zzj = zzeclVar;
        this.zzk = zzdsdVar;
        this.zzl = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzdoo zzdooVar = (zzdoo) zzgdn.zzq(this.zzf);
        try {
            zzfca zzfcaVar = this.zze;
            final zzcfg zzcfgVarZza = this.zzg;
            if (zzcfgVarZza.zzaG()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbb)).booleanValue()) {
                    zzcfgVarZza = this.zzb.zza(this.zzc.zze, null, null);
                    zzbkx.zzb(zzcfgVarZza, zzdooVar.zzg());
                    final zzdpn zzdpnVar = new zzdpn();
                    zzdpnVar.zza(this.zza, zzcfgVarZza.zzF());
                    zzdooVar.zzl().zzi(zzcfgVarZza, true, this.zzi ? this.zzh : null, this.zzk.zza());
                    zzcfgVarZza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzeib
                        @Override // com.google.android.gms.internal.ads.zzcgw
                        public final void zza(boolean z2, int i, String str, String str2) {
                            zzdpnVar.zzb();
                            zzcfg zzcfgVar = zzcfgVarZza;
                            zzcfgVar.zzab();
                            zzcfgVar.zzN().zzs();
                        }
                    });
                    zzcfgVarZza.zzN().zzK(new zzcgx() { // from class: com.google.android.gms.internal.ads.zzeic
                        @Override // com.google.android.gms.internal.ads.zzcgx
                        public final void zza() {
                            zzcfgVarZza.zzaa();
                        }
                    });
                    zzfcf zzfcfVar = zzfcaVar.zzs;
                    zzcfgVarZza.zzae(zzfcfVar.zzb, zzfcfVar.zza, null);
                }
            }
            zzcfg zzcfgVar = zzcfgVarZza;
            zzcfgVar.zzaq(true);
            boolean z2 = this.zzi;
            boolean zZze = z2 ? this.zzh.zze(false) : false;
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            boolean zZzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zza);
            boolean z3 = z2 && this.zzh.zzd();
            float fZza = z2 ? this.zzh.zza() : 0.0f;
            zzfca zzfcaVar2 = this.zze;
            com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZze, zZzJ, z3, fZza, z, zzfcaVar2.zzO, zzfcaVar2.zzP);
            if (zzcwlVar != null) {
                zzcwlVar.zzf();
            }
            zzdgc zzdgcVarZzh = zzdooVar.zzh();
            int i = zzfcaVar2.zzQ;
            VersionInfoParcel versionInfoParcel = this.zzd;
            String str = zzfcaVar2.zzB;
            zzfcf zzfcfVar2 = zzfcaVar2.zzs;
            String str2 = zzfcfVar2.zzb;
            String str3 = zzfcfVar2.zza;
            zzfcw zzfcwVar = this.zzc;
            GraphRequest.Companion.zza(context, new AdOverlayInfoParcel(zzdgcVarZzh, zzcfgVar, i, versionInfoParcel, str, zzlVar, str2, str3, zzfcwVar.zzf, zzcwlVar, zzfcaVar2.zzb() ? this.zzj : null, zzcfgVar.zzr()), true, this.zzl);
        } catch (zzcfs e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
