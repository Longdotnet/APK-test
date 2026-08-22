package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdnf implements zzbgd {
    final /* synthetic */ String zza = "_videoMediaView";
    final /* synthetic */ zzdng zzb;

    public zzdnf(zzdng zzdngVar, String str) {
        Objects.requireNonNull(zzdngVar);
        this.zzb = zzdngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzc() {
        zzdng zzdngVar = this.zzb;
        if (zzdngVar.zzd != null) {
            zzdngVar.zzd.zzG(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzd(MotionEvent motionEvent) {
    }
}
