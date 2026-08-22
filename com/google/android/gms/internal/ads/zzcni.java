package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzcni {
    private final String zza;
    private final zzbpf zzb;
    private final Executor zzc;
    private zzcnn zzd;
    private final zzbkf zze = new zzcnf(this);
    private final zzbkf zzf = new zzcnh(this);

    public zzcni(String str, zzbpf zzbpfVar, Executor executor) {
        this.zza = str;
        this.zzb = zzbpfVar;
        this.zzc = executor;
    }

    public static /* bridge */ /* synthetic */ boolean zzg(zzcni zzcniVar, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzcniVar.zza);
    }

    public final void zzc(zzcnn zzcnnVar) {
        zzbpf zzbpfVar = this.zzb;
        zzbpfVar.zzb("/updateActiveView", this.zze);
        zzbpfVar.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcnnVar;
    }

    public final void zzd(zzcfg zzcfgVar) {
        zzcfgVar.zzag("/updateActiveView", this.zze);
        zzcfgVar.zzag("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        zzbpf zzbpfVar = this.zzb;
        zzbpfVar.zzc("/updateActiveView", this.zze);
        zzbpfVar.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcfg zzcfgVar) {
        zzcfgVar.zzaz("/updateActiveView", this.zze);
        zzcfgVar.zzaz("/untrackActiveViewUnit", this.zzf);
    }
}
