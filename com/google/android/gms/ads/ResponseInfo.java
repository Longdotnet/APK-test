package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ResponseInfo {
    public final zzea zza;
    public final ArrayList zzb = new ArrayList();
    public final AdapterResponseInfo zzc;

    public ResponseInfo(zzea zzeaVar) {
        this.zza = zzeaVar;
        if (zzeaVar != null) {
            try {
                List<zzv> listZzj = zzeaVar.zzj();
                if (listZzj != null) {
                    for (zzv zzvVar : listZzj) {
                        AdapterResponseInfo adapterResponseInfo = zzvVar != null ? new AdapterResponseInfo(zzvVar) : null;
                        if (adapterResponseInfo != null) {
                            this.zzb.add(adapterResponseInfo);
                        }
                    }
                }
            } catch (RemoteException e) {
                zzo.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
        zzea zzeaVar2 = this.zza;
        if (zzeaVar2 == null) {
            return;
        }
        try {
            zzv zzvVarZzf = zzeaVar2.zzf();
            if (zzvVarZzf != null) {
                this.zzc = new AdapterResponseInfo(zzvVarZzf);
            }
        } catch (RemoteException e2) {
            zzo.zzh("Could not forward getLoadedAdapterResponse to ResponseInfo.", e2);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            zzea zzeaVar = this.zza;
            if (zzeaVar != null) {
                return zzeaVar.zzg();
            }
            return null;
        } catch (RemoteException e) {
            zzo.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public final String toString() {
        try {
            return zzd().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzd() {
        String strZzi;
        Bundle bundleZze;
        JSONObject jSONObject = new JSONObject();
        zzea zzeaVar = this.zza;
        if (zzeaVar != null) {
            try {
                strZzi = zzeaVar.zzi();
            } catch (RemoteException e) {
                zzo.zzh("Could not forward getResponseId to ResponseInfo.", e);
                strZzi = null;
            }
        } else {
            strZzi = null;
        }
        if (strZzi == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", strZzi);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AdapterResponseInfo) it.next()).zzb());
        }
        jSONObject.put(iafHZUfOuHNwvy.TJNaPNcGrf, jSONArray);
        AdapterResponseInfo adapterResponseInfo = this.zzc;
        if (adapterResponseInfo != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo.zzb());
        }
        if (zzeaVar != null) {
            try {
                bundleZze = zzeaVar.zze();
            } catch (RemoteException e2) {
                zzo.zzh("Could not forward getResponseExtras to ResponseInfo.", e2);
                bundleZze = new Bundle();
            }
        } else {
            bundleZze = new Bundle();
        }
        if (bundleZze != null) {
            jSONObject.put("Response Extras", zzbb.zzb.zzc.zzn(bundleZze));
        }
        return jSONObject;
    }
}
