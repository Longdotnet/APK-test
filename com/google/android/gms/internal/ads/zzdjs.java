package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdjs implements zzbgd {
    final /* synthetic */ zzdkr zza;
    final /* synthetic */ ViewGroup zzb;

    public zzdjs(zzdkr zzdkrVar, ViewGroup viewGroup) {
        this.zza = zzdkrVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzc() {
        zzfyq zzfyqVar = zzdjp.zza;
        zzdkr zzdkrVar = this.zza;
        Map mapZzm = zzdkrVar.zzm();
        if (mapZzm == null) {
            return;
        }
        int size = zzfyqVar.size();
        int i = 0;
        while (i < size) {
            Object obj = mapZzm.get((String) zzfyqVar.get(i));
            i++;
            if (obj != null) {
                zzdkrVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
