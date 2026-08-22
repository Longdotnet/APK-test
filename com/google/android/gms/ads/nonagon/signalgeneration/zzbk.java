package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzdrr;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbk {
    public final String zza;
    public String zzb;
    public final zzbvq zzd;
    public Bundle zze;
    public final long zzg;
    public final long zzh;
    public String zzc = null;
    public final Bundle zzf = new Bundle();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    public zzbk(JsonReader jsonReader, zzbvq zzbvqVar) throws IOException {
        Bundle bundle;
        byte b;
        this.zzg = -1L;
        this.zzh = -1L;
        this.zzd = zzbvqVar;
        HashMap map = new HashMap();
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            switch (strNextName == null ? "" : strNextName) {
                case "start_time":
                    b = 2;
                    break;
                case "params":
                    b = 0;
                    break;
                case "signal_dictionary":
                    b = 1;
                    break;
                case "end_time":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                strNextString = jsonReader.nextString();
            } else if (b == 1) {
                map = new HashMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    map.put(jsonReader.nextName(), jsonReader.nextString());
                }
                jsonReader.endObject();
            } else if (b == 2) {
                this.zzg = jsonReader.nextLong();
            } else if (b != 3) {
                jsonReader.skipValue();
            } else {
                this.zzh = jsonReader.nextLong();
            }
        }
        this.zza = strNextString;
        jsonReader.endObject();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.zzf.putString((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() || zzbvqVar == null || (bundle = zzbvqVar.zzm) == null) {
            return;
        }
        bundle.putLong(zzdrr.GET_SIGNALS_SDKCORE_START.zza(), this.zzg);
        zzbvqVar.zzm.putLong(zzdrr.GET_SIGNALS_SDKCORE_END.zza(), this.zzh);
    }
}
