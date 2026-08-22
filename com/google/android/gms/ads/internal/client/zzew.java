package com.google.android.gms.ads.internal.client;

import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda17;
import com.google.android.gms.internal.ads.zzbmj;
import com.google.android.gms.internal.ads.zzbmm;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzew extends zzbmj {
    public final /* synthetic */ zzey zza;

    @Override // com.google.android.gms.internal.ads.zzbmk
    public final void zzb(List list) {
        int i;
        ArrayList arrayList;
        zzey zzeyVar = this.zza;
        synchronized (zzeyVar.zzf) {
            zzeyVar.zzi = false;
            zzeyVar.zzj = true;
            arrayList = new ArrayList(zzeyVar.zzh);
            zzeyVar.zzh.clear();
        }
        zzbmm zzbmmVarZzA = zzey.zzA(list);
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((GoogleMobileAdsGM$$ExternalSyntheticLambda17) arrayList.get(i)).f$0.lambda$AdMob_Initialize$0(zzbmmVarZzA);
        }
    }
}
