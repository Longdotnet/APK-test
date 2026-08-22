package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkl implements zzbkf {
    private final Context zza;
    private final Map zzb;

    public zzbkl(Context context, Map map) {
        this.zza = context;
        this.zzb = map;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        byte b;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzbyo zzbyoVar = zzvVar.zzB;
        Context context = this.zza;
        if (zzbyoVar.zzp(context)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            int iHashCode = str.hashCode();
            if (iHashCode != 94399) {
                if (iHashCode != 94401) {
                    if (iHashCode == 94407 && str.equals("_ai")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("_ac")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("_aa")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                zzvVar.zzB.zzj(context, str2, (Map) this.zzb.get("_ac"));
            } else if (b == 1) {
                zzvVar.zzB.zzk(context, str2, (Map) this.zzb.get("_ai"));
            } else if (b == 2) {
                zzvVar.zzB.zzh(context, str2);
            } else {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("logScionEvent gmsg contained unsupported eventName");
            }
        }
    }
}
