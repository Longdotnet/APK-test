package com.google.android.gms.ads.internal.client;

import androidx.work.Worker;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzfi extends zzbp {
    public final /* synthetic */ zzfk zza;

    public /* synthetic */ zzfi(zzfk zzfkVar) {
        Objects.requireNonNull(zzfkVar);
        this.zza = zzfkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final String zze() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzg(zzm zzmVar) {
        zzh(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzh(zzm zzmVar, int i) {
        zzo.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new Worker.AnonymousClass1(this));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final boolean zzi() {
        return false;
    }
}
