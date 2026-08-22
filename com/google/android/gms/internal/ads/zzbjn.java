package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjn implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzftx zzftxVarZzl = zzfty.zzl();
        zzftxVarZzl.zzb((String) map.get("appId"));
        zzftxVarZzl.zzh(zzcfgVar.getWidth());
        zzftxVarZzl.zzg(zzcfgVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzftxVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzftxVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzftxVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzftxVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzftxVarZzl.zza((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzv.zza.zzt.zzj(zzcfgVar, zzftxVarZzl.zzi());
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
