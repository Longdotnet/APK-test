package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeoa implements zzeuc {
    private final zzgdy zza;
    private final VersionInfoParcel zzb;

    public zzeoa(VersionInfoParcel versionInfoParcel, zzgdy zzgdyVar) {
        this.zzb = versionInfoParcel;
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 54;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzenz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeob.zzc(this.zza.zzb);
            }
        });
    }
}
