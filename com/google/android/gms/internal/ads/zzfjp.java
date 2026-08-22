package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjp {
    private final com.google.android.gms.ads.internal.util.client.zzx zza;
    private final com.google.android.gms.ads.internal.util.client.zzu zzb;
    private final zzgdz zzc;
    private final zzfjq zzd;

    public zzfjp(com.google.android.gms.ads.internal.util.client.zzx zzxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzgdz zzgdzVar, zzfjq zzfjqVar) {
        this.zza = zzxVar;
        this.zzb = zzuVar;
        this.zzc = zzgdzVar;
        this.zzd = zzfjqVar;
    }

    public static ListenableFuture zzc(zzfjp zzfjpVar, int i, long j, String str, com.google.android.gms.ads.internal.util.client.zzt zztVar) {
        if (zztVar != com.google.android.gms.ads.internal.util.client.zzt.zzc) {
            return zzgdn.zzh(zztVar);
        }
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = zzfjpVar.zza;
        long j2 = ((com.google.android.gms.ads.internal.util.client.zzn) zzxVar).zzb;
        if (i != 1) {
            j2 = (long) (((com.google.android.gms.ads.internal.util.client.zzn) zzxVar).zzc * j);
        }
        return zzfjpVar.zze(str, j2, i + 1);
    }

    private final ListenableFuture zze(final String str, final long j, final int i) {
        final String strM;
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        if (i > ((com.google.android.gms.ads.internal.util.client.zzn) zzxVar).zza) {
            zzfjq zzfjqVar = this.zzd;
            if (zzfjqVar == null || !((com.google.android.gms.ads.internal.util.client.zzn) zzxVar).zzd) {
                return zzgdn.zzh(com.google.android.gms.ads.internal.util.client.zzt.zzc);
            }
            zzfjqVar.zza(str, "", 2);
            return zzgdn.zzh(com.google.android.gms.ads.internal.util.client.zzt.zzd);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziW)).booleanValue()) {
            Uri uri = Uri.parse(str);
            String encodedQuery = uri.getEncodedQuery();
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            builderClearQuery.appendQueryParameter("pa", Integer.toString(i));
            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(String.valueOf(builderClearQuery.build()), "&", encodedQuery);
        } else {
            strM = str;
        }
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzfjo
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzfjp.zzc(this.zza, i, j, str, (com.google.android.gms.ads.internal.util.client.zzt) obj);
            }
        };
        if (j == 0) {
            zzgdz zzgdzVar = this.zzc;
            return zzgdn.zzn(zzgdzVar.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzb.zza(strM);
                }
            }), zzgcuVar, zzgdzVar);
        }
        zzgdz zzgdzVar2 = this.zzc;
        return zzgdn.zzn(zzgdzVar2.schedule(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzb.zza(strM);
            }
        }, j, TimeUnit.MILLISECONDS), zzgcuVar, zzgdzVar2);
    }

    public final ListenableFuture zzd(String str) {
        try {
            return zze(str, 0L, 1);
        } catch (NullPointerException | RejectedExecutionException unused) {
            return zzgdn.zzh(com.google.android.gms.ads.internal.util.client.zzt.zzb);
        }
    }
}
