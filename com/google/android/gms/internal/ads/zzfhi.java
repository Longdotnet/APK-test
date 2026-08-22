package com.google.android.gms.internal.ads;

import android.content.Context;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzfhi {
    public static zzfhj zza(Context context, int i) {
        boolean zBooleanValue;
        if (zzfhx.zza()) {
            int i2 = i - 2;
            if (i2 == 20 || i2 == 21) {
                zBooleanValue = ((Boolean) zzbex.zze.zze()).booleanValue();
            } else if (i2 != 110) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbex.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbex.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbex.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) zzbex.zzf.zze()).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfhl(context, i);
            }
        }
        return new zzfiq();
    }

    public static zzfhj zzb(Context context, int i, int i2, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        zzfhj zzfhjVarZza = zza(context, i);
        if (zzfhjVarZza instanceof zzfhl) {
            zzfhjVarZza.zzi();
            zzfhjVarZza.zzn(i2);
            zzfhjVarZza.zzf(MediaType.Companion.zza(zzmVar.zzm));
            String str = zzmVar.zzp;
            if (zzfht.zze(str)) {
                zzfhjVarZza.zze(str);
            }
        }
        return zzfhjVarZza;
    }
}
