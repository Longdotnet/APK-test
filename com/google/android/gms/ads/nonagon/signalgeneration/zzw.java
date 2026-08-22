package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzdep;
import com.google.android.gms.internal.ads.zzdsd;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzw implements zzdep {
    public final zzdsd zza;
    public final zzv zzb;
    public final String zzc;
    public final int zzd;

    public zzw(zzdsd zzdsdVar, zzv zzvVar, String str, int i) {
        this.zza = zzdsdVar;
        this.zzb = zzvVar;
        this.zzc = str;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(zzbk zzbkVar) {
        String strOptString;
        if (zzbkVar == null || this.zzd == 2) {
            return;
        }
        boolean zIsEmpty = TextUtils.isEmpty(zzbkVar.zzc);
        zzdsd zzdsdVar = this.zza;
        zzv zzvVar = this.zzb;
        if (zIsEmpty) {
            zzvVar.zze(this.zzc, zzbkVar.zzb, zzdsdVar);
            return;
        }
        try {
            strOptString = new JSONObject(zzbkVar.zzc).optString("request_id");
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "RenderSignals.getRequestId");
            strOptString = null;
        }
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        zzvVar.zze(strOptString, zzbkVar.zzc, zzdsdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
    }
}
