package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzftv extends zzfso {
    final /* synthetic */ zzftw zza;
    private final zzfub zzb;

    public zzftv(zzftw zzftwVar, zzfub zzfubVar) {
        Objects.requireNonNull(zzftwVar);
        this.zza = zzftwVar;
        this.zzb = zzfubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsp
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzftz zzftzVarZzc = zzfua.zzc();
        zzftzVarZzc.zzb(i);
        if (string != null) {
            zzftzVarZzc.zza(string);
        }
        this.zzb.zza(zzftzVarZzc.zzc());
        if (i == 8157) {
            this.zza.zzd();
        }
    }
}
