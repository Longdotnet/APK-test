package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdgo implements zzcxm, com.google.android.gms.ads.internal.overlay.zzr, zzcws {
    zzedh zza;
    private final Context zzb;
    private final zzcfg zzc;
    private final zzfca zzd;
    private final VersionInfoParcel zze;
    private final zzedf zzf;

    public zzdgo(Context context, zzcfg zzcfgVar, zzfca zzfcaVar, VersionInfoParcel versionInfoParcel, zzedf zzedfVar) {
        this.zzb = context;
        this.zzc = zzcfgVar;
        this.zzd = zzfcaVar;
        this.zze = versionInfoParcel;
        this.zzf = zzedfVar;
    }

    private final boolean zzg() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfC)).booleanValue() && this.zzf.zzd();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        zzcfg zzcfgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfF)).booleanValue() || (zzcfgVar = this.zzc) == null) {
            return;
        }
        if (this.zza != null || zzg()) {
            if (this.zza != null) {
                zzcfgVar.zzd("onSdkImpression", new ArrayMap());
            } else {
                this.zzf.zzb();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        zzcfg zzcfgVar;
        if (zzg()) {
            this.zzf.zzb();
        } else {
            if (this.zza == null || (zzcfgVar = this.zzc) == null) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfF)).booleanValue()) {
                zzcfgVar.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        zzcfg zzcfgVar;
        zzede zzedeVar;
        zzedd zzeddVar;
        zzfca zzfcaVar = this.zzd;
        if (!zzfcaVar.zzT || (zzcfgVar = this.zzc) == null) {
            return;
        }
        Context context = this.zzb;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        if (zzvVar.zzz.zzl(context)) {
            if (zzg()) {
                this.zzf.zzc();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.zze;
            String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            zzfcz zzfczVar = zzfcaVar.zzV;
            String strZza = zzfczVar.zza();
            if (zzfczVar.zzc() == 1) {
                zzeddVar = zzedd.VIDEO;
                zzedeVar = zzede.DEFINED_BY_JAVASCRIPT;
            } else {
                zzedeVar = zzfcaVar.zzY == 2 ? zzede.UNSPECIFIED : zzede.BEGIN_TO_RENDER;
                zzeddVar = zzedd.HTML_DISPLAY;
            }
            zzedh zzedhVarZza = zzvVar.zzz.zza(str, zzcfgVar.zzG(), "", ehgOP.LJhJcSnwBsajo, strZza, zzedeVar, zzeddVar, zzfcaVar.zzal);
            this.zza = zzedhVarZza;
            if (zzedhVarZza != null) {
                zzfll zzfllVarZza = zzedhVarZza.zza();
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfB)).booleanValue();
                zzedb zzedbVar = zzvVar.zzz;
                if (zBooleanValue) {
                    zzedbVar.zzj(zzfllVarZza, zzcfgVar.zzG());
                    Iterator it = zzcfgVar.zzV().iterator();
                    while (it.hasNext()) {
                        com.google.android.gms.ads.internal.zzv.zza.zzz.zzg(zzfllVarZza, (View) it.next());
                    }
                } else {
                    zzedbVar.zzj(zzfllVarZza, zzcfgVar.zzF());
                }
                zzcfgVar.zzat(this.zza);
                com.google.android.gms.ads.internal.zzv.zza.zzz.zzk(zzfllVarZza);
                zzcfgVar.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
