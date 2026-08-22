package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzear implements zzgdj {
    final /* synthetic */ zzfge zza;

    public zzear(zzeas zzeasVar, zzfge zzfgeVar) {
        this.zza = zzfgeVar;
        Objects.requireNonNull(zzeasVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        String strValueOf = String.valueOf(th.getMessage());
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to get offline signal database: ".concat(strValueOf));
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error executing function on offline signal database: ".concat(strValueOf));
        }
    }
}
