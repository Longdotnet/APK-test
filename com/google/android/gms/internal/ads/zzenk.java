package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.auth.IJ.gZrKCJ;

/* JADX INFO: loaded from: classes2.dex */
public final class zzenk implements zzeub {
    private final com.google.android.gms.ads.internal.client.zzx zza;
    private final boolean zzb;

    public zzenk(com.google.android.gms.ads.internal.client.zzx zzxVar, boolean z) {
        this.zza = zzxVar;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfJ)).booleanValue()) {
            bundle.putBoolean(gZrKCJ.OMiAQOy, this.zzb);
        }
        com.google.android.gms.ads.internal.client.zzx zzxVar = this.zza;
        if (zzxVar != null) {
            int i = zzxVar.zza;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
