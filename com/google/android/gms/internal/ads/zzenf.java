package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzenf implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;

    public zzenf(zzgdy zzgdyVar, Context context) {
        this.zzb = zzgdyVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 61;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznm)).booleanValue()) {
            return zzgdn.zzh(new zzeng(null, false));
        }
        final ContentResolver contentResolver = this.zza.getContentResolver();
        return contentResolver == null ? zzgdn.zzh(new zzeng(null, false)) : this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzene
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ContentResolver contentResolver2 = contentResolver;
                return new zzeng(Settings.Secure.getString(contentResolver2, "advertising_id"), Settings.Secure.getInt(contentResolver2, "limit_ad_tracking", 0) == 1);
            }
        });
    }
}
