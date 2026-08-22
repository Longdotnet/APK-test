package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzk implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ Object zze;

    public zzk(zzhw zzhwVar, boolean z, Uri uri, String str, String str2) {
        this.$r8$classId = 2;
        this.zze = zzhwVar;
        this.zzd = z;
        this.zza = uri;
        this.zzb = str;
        this.zzc = str2;
    }

    public /* synthetic */ zzk(Object obj, Object obj2, String str, String str2, boolean z, int i) {
        this.$r8$classId = i;
        this.zze = obj;
        this.zza = obj2;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleZzs;
        switch (this.$r8$classId) {
            case 0:
                zzjm zzjmVarZzt = ((AppMeasurementDynamiteService) this.zze).zza.zzt();
                zzjmVarZzt.zzg();
                zzjmVarZzt.zza();
                zzjmVarZzt.zzR(new zzin(zzjmVarZzt, this.zzb, this.zzc, zzjmVarZzt.zzO(false), this.zzd, (zzcf) this.zza));
                break;
            case 1:
                zzjm zzjmVarZzt2 = ((zzfr) ((zzhx) this.zze).mBuilder).zzt();
                zzjmVarZzt2.zzg();
                zzjmVarZzt2.zza();
                zzjmVarZzt2.zzR(new zzin(zzjmVarZzt2, (AtomicReference) this.zza, this.zzb, this.zzc, zzjmVarZzt2.zzO(false), this.zzd));
                break;
            default:
                Uri uri = (Uri) this.zza;
                String str = this.zzc;
                zzhx zzhxVar = ((zzhw) this.zze).zza;
                zzfr zzfrVar = (zzfr) zzhxVar.mBuilder;
                zzhxVar.zzg();
                try {
                    zzlb zzlbVar = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar);
                    if (TextUtils.isEmpty(str)) {
                        bundleZzs = null;
                    } else if (str.contains("gclid") || str.contains("utm_campaign") || str.contains("utm_source") || str.contains("utm_medium") || str.contains("utm_id") || str.contains("dclid") || str.contains("srsltid")) {
                        bundleZzs = zzlbVar.zzs(Uri.parse("https://google.com/search?".concat(str)));
                        if (bundleZzs != null) {
                            bundleZzs.putString("_cis", "referrer");
                        }
                    } else {
                        zzeh zzehVar = ((zzfr) zzlbVar.mBuilder).zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzk.zza("Activity created with data 'referrer' without required params");
                        bundleZzs = null;
                    }
                    String str2 = this.zzb;
                    zzs zzsVar = zzhxVar.zzb;
                    if (this.zzd) {
                        zzlb zzlbVar2 = zzfrVar.zzp;
                        zzfr.zzP(zzlbVar2);
                        Bundle bundleZzs2 = zzlbVar2.zzs(uri);
                        if (bundleZzs2 != null) {
                            bundleZzs2.putString("_cis", "intent");
                            if (!bundleZzs2.containsKey("gclid") && bundleZzs != null && bundleZzs.containsKey("gclid")) {
                                bundleZzs2.putString("_cer", "gclid=" + bundleZzs.getString("gclid"));
                            }
                            zzhxVar.zzG(str2, "_cmp", bundleZzs2);
                            zzsVar.zza(str2, bundleZzs2);
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzk.zzb(str, "Activity created with referrer");
                        if (zzfrVar.zzk.zzs(null, zzdu.zzY)) {
                            if (bundleZzs != null) {
                                zzhxVar.zzG(str2, "_cmp", bundleZzs);
                                zzsVar.zza(str2, bundleZzs);
                            } else {
                                zzeh zzehVar3 = zzfrVar.zzm;
                                zzfr.zzR(zzehVar3);
                                zzehVar3.zzk.zzb(str, "Referrer does not contain valid parameters");
                            }
                            zzfrVar.zzr.getClass();
                            zzhxVar.zzX("auto", "_ldl", null, true, System.currentTimeMillis());
                        } else if (!str.contains("gclid") || (!str.contains("utm_campaign") && !str.contains("utm_source") && !str.contains("utm_medium") && !str.contains("utm_term") && !str.contains(mnwSv.gscetnEEhEanFAh))) {
                            zzeh zzehVar4 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar4);
                            zzehVar4.zzk.zza("Activity created with data 'referrer' without required params");
                        } else if (!TextUtils.isEmpty(str)) {
                            zzfrVar.zzr.getClass();
                            zzhxVar.zzX("auto", "_ldl", str, true, System.currentTimeMillis());
                        }
                    }
                } catch (RuntimeException e) {
                    zzeh zzehVar5 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzd.zzb(e, "Throwable caught in handleReferrerForOnActivityCreated");
                }
                break;
        }
    }
}
