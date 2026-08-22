package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdso extends zzdss {
    private final CsiParamDefaults zzf;

    public final Map zza() {
        return new HashMap(this.zza);
    }

    public zzdso(Executor executor, com.google.android.gms.ads.internal.util.client.zzu zzuVar, CsiParamDefaults csiParamDefaults, CsiUrlBuilder csiUrlBuilder, Context context) {
        String str;
        super(executor, zzuVar, csiUrlBuilder, context);
        this.zzf = csiParamDefaults;
        Map map = this.zza;
        csiParamDefaults.getClass();
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        map.put("device", com.google.android.gms.ads.internal.util.zzs.zzs());
        map.put("app", csiParamDefaults.zzb);
        Context context2 = csiParamDefaults.zza;
        boolean zZzF = com.google.android.gms.ads.internal.util.zzs.zzF(context2);
        String str2 = oKjScaD.QpwkcHxRFtqRY;
        if (true != zZzF) {
            str = "0";
        } else {
            str = str2;
        }
        map.put("is_lite_sdk", str);
        zzbcv zzbcvVar = zzbde.zza;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        List listZzb = zzbdVar.zzb.zzb();
        zzbcv zzbcvVar2 = zzbde.zzhc;
        zzbdc zzbdcVar = zzbdVar.zzd;
        boolean zBooleanValue = ((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue();
        zzbzs zzbzsVar = zzvVar.zzi;
        if (zBooleanValue) {
            listZzb.addAll(((com.google.android.gms.ads.internal.util.zzj) zzbzsVar.zzi()).zzg().zzd());
        }
        map.put("e", TextUtils.join(wsbWxekY.RgryuUWuiEU, listZzb));
        map.put("sdkVersion", csiParamDefaults.zzc);
        if (((Boolean) zzbdcVar.zzb(zzbde.zzlM)).booleanValue()) {
            map.put("is_bstar", true != com.google.android.gms.ads.internal.util.zzs.zzC(context2) ? "0" : str2);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzjQ)).booleanValue() && ((Boolean) zzbdcVar.zzb(zzbde.zzcC)).booleanValue()) {
            map.put("plugin", zzfwg.zzc(zzbzsVar.zzn()));
        }
    }
}
