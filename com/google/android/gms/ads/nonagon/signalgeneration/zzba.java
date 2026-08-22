package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhgz;

/* JADX INFO: loaded from: classes.dex */
public final class zzba implements zzhgr {
    public final zzaz zza;

    public zzba(zzaz zzazVar) {
        this.zza = zzazVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        byte b;
        zzbcj.zza.EnumC0001zza enumC0001zza;
        switch (this.zza.zza) {
            case "NATIVE":
                b = 2;
                break;
            case "INTERSTITIAL":
                b = 1;
                break;
            case "REWARDED":
                b = 3;
                break;
            case "BANNER":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            enumC0001zza = zzbcj.zza.EnumC0001zza.BANNER;
        } else if (b == 1) {
            enumC0001zza = zzbcj.zza.EnumC0001zza.INTERSTITIAL;
        } else if (b != 2) {
            enumC0001zza = b != 3 ? zzbcj.zza.EnumC0001zza.AD_INITIATER_UNSPECIFIED : zzbcj.zza.EnumC0001zza.REWARD_BASED_VIDEO_AD;
        } else {
            enumC0001zza = zzbcj.zza.EnumC0001zza.AD_LOADER;
        }
        zzhgz.zzb(enumC0001zza);
        return enumC0001zza;
    }
}
