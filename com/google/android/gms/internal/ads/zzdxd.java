package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxd implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzdxd(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
    }

    public static zzdxd zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzdxd(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x004f  */
    /* JADX WARN: Code duplicated, block: B:8:0x006e  */
    /* JADX WARN: Code duplicated, block: B:9:0x0078  */
    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        ListenableFuture listenableFutureZzb;
        final zzavu zzavuVar = (zzavu) this.zza.zzb();
        final Context contextZza = ((zzchl) this.zzb).zza();
        zzfcw zzfcwVarZzc = ((zzcvp) this.zzc).zzc();
        long jLongValue = ((Long) this.zzd.zzb()).longValue();
        zzgdy zzgdyVarZzc = zzffu.zzc();
        zzbcv zzbcvVar = zzbde.zzcX;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        int iIntValue = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        if (iIntValue != -1) {
            if (Integer.toString(iIntValue).equals(MediaType.Companion.zzb(MediaType.Companion.zzc(zzfcwVarZzc.zzd)))) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                if (System.currentTimeMillis() - jLongValue < ((Integer) zzbdVar.zzd.zzb(zzbde.zzcZ)).intValue()) {
                    listenableFutureZzb = zzgdyVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdww
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzavuVar.zzc().zzg(contextZza);
                        }
                    });
                } else {
                    listenableFutureZzb = zzgdyVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwx
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return zzavuVar.zzc().zzf(contextZza);
                        }
                    });
                }
            } else {
                listenableFutureZzb = zzgdyVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwx
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzavuVar.zzc().zzf(contextZza);
                    }
                });
            }
        } else {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            if (System.currentTimeMillis() - jLongValue < ((Integer) zzbdVar.zzd.zzb(zzbde.zzcZ)).intValue()) {
                listenableFutureZzb = zzgdyVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdww
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzavuVar.zzc().zzg(contextZza);
                    }
                });
            } else {
                listenableFutureZzb = zzgdyVarZzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwx
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzavuVar.zzc().zzf(contextZza);
                    }
                });
            }
        }
        zzhgz.zzb(listenableFutureZzb);
        return listenableFutureZzb;
    }
}
