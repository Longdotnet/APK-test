package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzddv;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* JADX INFO: loaded from: classes.dex */
public final class zzbf implements zzhgr {
    public final /* synthetic */ int $r8$classId;
    public final zzhha zza;
    public final zzhha zzb;
    public final zzhha zzc;

    public /* synthetic */ zzbf(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, int i) {
        this.$r8$classId = i;
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        switch (this.$r8$classId) {
            case 0:
                Object obj = (zzw) this.zza.zzb();
                zzbm zzbmVar = (zzbm) this.zzb.zzb();
                zzgdy zzgdyVarZzc = zzffu.zzc();
                if (((Integer) this.zzc.zzb()).intValue() == 2) {
                    obj = zzbmVar;
                }
                return new zzddv(obj, zzgdyVarZzc);
            default:
                return new zzbm((zzb) this.zza.zzb(), ((Integer) this.zzb.zzb()).intValue(), (String) this.zzc.zzb());
        }
    }
}
