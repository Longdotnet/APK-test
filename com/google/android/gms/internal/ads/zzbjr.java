package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzbjr implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        try {
            zzfse.zzj(zzcfgVar.getContext()).zzk();
            zzfsf.zzi(zzcfgVar.getContext()).zzj();
            zzfsg.zza(zzcfgVar.getContext()).zzb(null);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
