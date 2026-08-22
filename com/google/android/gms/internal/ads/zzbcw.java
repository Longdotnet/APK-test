package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcw {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb((zzbcv) it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbdf.zza());
        return arrayList;
    }

    public final List zzb() {
        List listZza = zza();
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb((zzbcv) it.next());
            if (!TextUtils.isEmpty(str)) {
                listZza.add(str);
            }
        }
        listZza.addAll(zzbdf.zzb());
        return listZza;
    }

    public final void zzc(zzbcv zzbcvVar) {
        this.zzb.add(zzbcvVar);
    }

    public final void zzd(zzbcv zzbcvVar) {
        this.zza.add(zzbcvVar);
    }

    public final void zze(zzbcv zzbcvVar) {
        this.zzc.add(zzbcvVar);
    }

    public final void zzf(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbcv zzbcvVar : this.zza) {
            if (zzbcvVar.zze() == 1) {
                zzbcvVar.zzd(editor, zzbcvVar.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Flag Json is null.");
        }
    }
}
