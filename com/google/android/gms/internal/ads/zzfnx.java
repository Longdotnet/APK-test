package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnx extends zzfnt {
    public zzfnx(zzfnm zzfnmVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnmVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfmi zzfmiVarZza = zzfmi.zza();
        if (zzfmiVarZza != null) {
            for (zzflp zzflpVar : zzfmiVarZza.zzc()) {
                if (((zzfnt) this).zza.contains(zzflpVar.zzh())) {
                    zzflpVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfnu, android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    @Override // com.google.android.gms.internal.ads.zzfnu
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
