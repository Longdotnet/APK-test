package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfny extends zzfnt {
    public zzfny(zzfnm zzfnmVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnmVar, hashSet, jSONObject, j);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        zzfnm zzfnmVar = this.zzd;
        JSONObject jSONObject = this.zzb;
        if (zzfne.zzg(jSONObject, zzfnmVar.zza())) {
            return null;
        }
        zzfnmVar.zze(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfnu, android.os.AsyncTask
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzfmi zzfmiVarZza;
        if (!TextUtils.isEmpty(str) && (zzfmiVarZza = zzfmi.zza()) != null) {
            for (zzflp zzflpVar : zzfmiVarZza.zzc()) {
                if (((zzfnt) this).zza.contains(zzflpVar.zzh())) {
                    zzflpVar.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
