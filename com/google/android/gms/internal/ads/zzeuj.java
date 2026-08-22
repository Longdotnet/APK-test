package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuj implements zzeub {
    private final int zza;
    private final int zzb;

    public zzeuj(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        int i;
        Bundle bundle = ((zzcva) obj).zza;
        int i2 = this.zza;
        if (i2 == -1 || (i = this.zzb) == -1) {
            return;
        }
        bundle.putInt("sessions_without_flags", i2);
        bundle.putInt("crashes_without_flags", i);
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.zzb;
        if (com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zze()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
