package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzeop implements zzeuc {
    private final zzeyy zza;

    public zzeop(zzeyy zzeyyVar) {
        this.zza = zzeyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzeyy zzeyyVar = this.zza;
        if (zzeyyVar == null) {
            return zzgdn.zzh(new zzeoo(null));
        }
        String strZza = zzeyyVar.zza();
        int i = Strings.$r8$clinit;
        return (strZza == null || strZza.trim().isEmpty()) ? zzgdn.zzh(new zzeoo(null)) : zzgdn.zzh(new zzeoo(strZza));
    }
}
