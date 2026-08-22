package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxm extends zzbwr {
    private final String zza;
    private final int zzb;

    public zzbxm(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final String zzf() {
        return this.zza;
    }

    public zzbxm(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
