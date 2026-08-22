package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqn implements zzcxm, zzcws {
    private final Context zza;
    private final zzcfg zzb;
    private final zzfca zzc;
    private final VersionInfoParcel zzd;
    private zzedh zze;
    private boolean zzf;
    private final zzedf zzg;

    public zzcqn(Context context, zzcfg zzcfgVar, zzfca zzfcaVar, VersionInfoParcel versionInfoParcel, zzedf zzedfVar) {
        this.zza = context;
        this.zzb = zzcfgVar;
        this.zzc = zzfcaVar;
        this.zzd = versionInfoParcel;
        this.zzg = zzedfVar;
    }

    private final synchronized void zza() {
        zzcfg zzcfgVar;
        zzede zzedeVar;
        zzedd zzeddVar;
        try {
            zzfca zzfcaVar = this.zzc;
            if (zzfcaVar.zzT && (zzcfgVar = this.zzb) != null) {
                Context context = this.zza;
                com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                if (zzvVar.zzz.zzl(context)) {
                    VersionInfoParcel versionInfoParcel = this.zzd;
                    String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
                    zzfcz zzfczVar = zzfcaVar.zzV;
                    String strZza = zzfczVar.zza();
                    if (zzfczVar.zzc() == 1) {
                        zzeddVar = zzedd.VIDEO;
                        zzedeVar = zzede.DEFINED_BY_JAVASCRIPT;
                    } else {
                        int i = zzfcaVar.zze;
                        zzedd zzeddVar2 = zzedd.HTML_DISPLAY;
                        zzedeVar = i == 1 ? zzede.ONE_PIXEL : zzede.BEGIN_TO_RENDER;
                        zzeddVar = zzeddVar2;
                    }
                    zzedh zzedhVarZza = zzvVar.zzz.zza(str, zzcfgVar.zzG(), "", gZrKCJ.iQhLEhAOpa, strZza, zzedeVar, zzeddVar, zzfcaVar.zzal);
                    this.zze = zzedhVarZza;
                    if (zzedhVarZza != null) {
                        zzfll zzfllVarZza = zzedhVarZza.zza();
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfB)).booleanValue()) {
                            zzvVar.zzz.zzj(zzfllVarZza, zzcfgVar.zzG());
                            Iterator it = zzcfgVar.zzV().iterator();
                            while (it.hasNext()) {
                                com.google.android.gms.ads.internal.zzv.zza.zzz.zzg(zzfllVarZza, (View) it.next());
                            }
                        } else {
                            zzvVar.zzz.zzj(zzfllVarZza, zzcfgVar.zzF());
                        }
                        zzcfgVar.zzat(this.zze);
                        com.google.android.gms.ads.internal.zzv.zza.zzz.zzk(zzfllVarZza);
                        this.zzf = true;
                        zzcfgVar.zzd("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfC)).booleanValue() && this.zzg.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final synchronized void zzt() {
        zzcfg zzcfgVar;
        if (zzb()) {
            this.zzg.zzb();
            return;
        }
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzT || this.zze == null || (zzcfgVar = this.zzb) == null) {
            return;
        }
        zzcfgVar.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final synchronized void zzu() {
        if (zzb()) {
            this.zzg.zzc();
        } else {
            if (this.zzf) {
                return;
            }
            zza();
        }
    }
}
