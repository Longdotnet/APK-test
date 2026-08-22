package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdzj {
    private final zzgdy zza;
    private final zzdyo zzb;
    private final zzhgl zzc;

    public zzdzj(zzgdy zzgdyVar, zzdyo zzdyoVar, zzhgl zzhglVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdyoVar;
        this.zzc = zzhglVar;
    }

    private final ListenableFuture zzg(final zzbvq zzbvqVar, zzdzi zzdziVar, final zzdzi zzdziVar2, final zzgcu zzgcuVar) {
        String str = zzbvqVar.zzd;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        zzgde zzgdeVarZzw = zzgde.zzw(com.google.android.gms.ads.internal.util.zzs.zzD(str) ? zzgdn.zzg(new zzdyx(1)) : zzgdn.zzf(zzdziVar.zza(zzbvqVar), ExecutionException.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzh
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                Throwable cause = (ExecutionException) obj;
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                return zzgdn.zzg(cause);
            }
        }, this.zza));
        zzgcu zzgcuVar2 = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzf
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(((zzdyy) obj).zzb());
            }
        };
        zzgdy zzgdyVar = this.zza;
        return (zzgde) zzgdn.zzf((zzgde) zzgdn.zzn((zzgde) zzgdn.zzn(zzgdeVarZzw, zzgcuVar2, zzgdyVar), zzgcuVar, zzgdyVar), zzdyx.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzg
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                zzdzj zzdzjVar = this.zza;
                return zzgdn.zzn(zzdziVar2.zza(zzbvqVar), zzgcuVar, zzdzjVar.zza);
            }
        }, zzgdyVar);
    }

    public final ListenableFuture zze(final zzbvq zzbvqVar) {
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdzc
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                String str = new String(zzgbg.zzb((InputStream) obj), StandardCharsets.UTF_8);
                zzbvq zzbvqVar2 = zzbvqVar;
                zzbvqVar2.zzj = str;
                return zzgdn.zzh(zzbvqVar2);
            }
        };
        final zzdyo zzdyoVar = this.zzb;
        Objects.requireNonNull(zzdyoVar);
        return zzg(zzbvqVar, new zzdzi() { // from class: com.google.android.gms.internal.ads.zzdzd
            @Override // com.google.android.gms.internal.ads.zzdzi
            public final ListenableFuture zza(zzbvq zzbvqVar2) {
                return zzdyoVar.zza(zzbvqVar2);
            }
        }, new zzdzi() { // from class: com.google.android.gms.internal.ads.zzdze
            @Override // com.google.android.gms.internal.ads.zzdzi
            public final ListenableFuture zza(zzbvq zzbvqVar2) {
                return ((zzeab) this.zza.zzc.zzb()).zzb(zzbvqVar2, Binder.getCallingUid());
            }
        }, zzgcuVar);
    }

    public final ListenableFuture zzf(zzbvq zzbvqVar) {
        return zzg(zzbvqVar, new zzdzi() { // from class: com.google.android.gms.internal.ads.zzdza
            @Override // com.google.android.gms.internal.ads.zzdzi
            public final ListenableFuture zza(zzbvq zzbvqVar2) {
                return this.zza.zzb.zzd(zzbvqVar2.zzh);
            }
        }, new zzdzi() { // from class: com.google.android.gms.internal.ads.zzdzb
            @Override // com.google.android.gms.internal.ads.zzdzi
            public final ListenableFuture zza(zzbvq zzbvqVar2) {
                return ((zzeab) this.zza.zzc.zzb()).zzj(zzbvqVar2.zzh);
            }
        }, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdyz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(null);
            }
        });
    }
}
