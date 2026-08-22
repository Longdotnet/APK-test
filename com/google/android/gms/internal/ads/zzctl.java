package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzctl implements zzcza, zzdep {
    private zzbvk zza;
    private final Context zzc;
    private final zzfhx zzd;
    private final VersionInfoParcel zze;
    private final Executor zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final AtomicBoolean zzb = new AtomicBoolean();

    public zzctl(Context context, zzfhx zzfhxVar, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzc = context;
        this.zzd = zzfhxVar;
        this.zze = versionInfoParcel;
        this.zzf = executor;
    }

    public static /* synthetic */ void zzc(zzctl zzctlVar) {
        zzbco.zze(zzctlVar.zzc);
        zzctlVar.zzh = true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    public final void zzd() {
        zzbvk zzbvkVar;
        int i;
        zzbow zzbowVarZza;
        if (!this.zzb.getAndSet(true)) {
            if (((Boolean) zzbfe.zzj.zze()).booleanValue()) {
                i = 2;
            } else {
                i = 3;
                if (!((Boolean) zzbfe.zzk.zze()).booleanValue()) {
                    if (((Boolean) zzbfe.zzi.zze()).booleanValue()) {
                        try {
                            String strOptString = new JSONObject(((com.google.android.gms.ads.internal.util.zzj) com.google.android.gms.ads.internal.zzv.zza.zzi.zzi()).zzg().zzc()).optString("local_flag_write");
                            if (TextUtils.equals(strOptString, "client")) {
                                i = 2;
                            } else if (!TextUtils.equals(strOptString, "service")) {
                                i = 1;
                            }
                        } catch (JSONException unused) {
                        }
                    } else {
                        i = 1;
                    }
                }
            }
            int i2 = i - 1;
            if (i2 == 1) {
                zzbowVarZza = com.google.android.gms.ads.internal.zzv.zza.zzs.zza(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
            } else if (i2 == 2) {
                zzbowVarZza = com.google.android.gms.ads.internal.zzv.zza.zzs.zzb(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
            }
            zzboq zzboqVar = zzbot.zza;
            this.zza = new zzbvm(this.zzc, zzbowVarZza.zza("google.afma.sdkConstants.getSdkConstants", zzboqVar, zzboqVar), this.zze);
            this.zzg = true;
        }
        if (this.zzg && (zzbvkVar = this.zza) != null) {
            ListenableFuture listenableFutureZza = zzbvkVar.zza();
            if (!this.zzh && ((Boolean) zzbew.zzi.zze()).booleanValue()) {
                listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzctk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzctl.zzc(this.zza);
                    }
                }, this.zzf);
            }
            zzcai.zza(listenableFutureZza, "persistFlagsClient");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
        zzd();
    }
}
