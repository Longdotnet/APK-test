package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class zzemh implements zzeuc {
    private final zzgdy zza;
    private final zzfcw zzb;
    private final int zzc;

    public zzemh(zzgdy zzgdyVar, zzfcw zzfcwVar, zzfdl zzfdlVar, int i) {
        this.zza = zzgdyVar;
        this.zzb = zzfcwVar;
        this.zzc = i;
    }

    public static zzemi zzc(zzemh zzemhVar) {
        List listAsList;
        zzbcv zzbcvVar = zzbde.zzhl;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String strZza = null;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzfcw zzfcwVar = zzemhVar.zzb;
            if (zzemhVar.zzc != 2) {
                String strZzc = MediaType.Companion.zzc(zzfcwVar.zzd);
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzhn)).booleanValue()) {
                    listAsList = Arrays.asList(((String) zzbdVar.zzd.zzb(zzbde.zzho)).split(","));
                } else {
                    listAsList = Arrays.asList(((String) zzbdVar.zzd.zzb(zzbde.zzhm)).split(","));
                }
                if (listAsList.contains(MediaType.Companion.zzb(strZzc))) {
                    strZza = zzfdl.zza();
                }
            }
        }
        return new zzemi(strZza);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzemg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzemh.zzc(this.zza);
            }
        });
    }
}
