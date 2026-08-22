package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzevc implements zzeuc {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbzj zzg;

    public zzevc(zzbzj zzbzjVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbzjVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    public static zzevd zzd(zzevc zzevcVar, Throwable th) {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        ContentResolver contentResolver = zzevcVar.zza.getContentResolver();
        return new zzevd(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfsa());
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzgde zzgdeVarZzw = zzgde.zzw(this.zzg.zza(this.zza, this.zzd));
        zzfve zzfveVar = new zzfve() { // from class: com.google.android.gms.internal.ads.zzeva
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzevc.zzc(this.zza, (AdvertisingIdClient.Info) obj);
            }
        };
        Executor executor = this.zzc;
        return (zzgde) zzgdn.zze((zzgde) zzgdn.zzo((zzgde) zzgdn.zzm(zzgdeVarZzw, zzfveVar, executor), ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzfve() { // from class: com.google.android.gms.internal.ads.zzevb
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                return zzevc.zzd(this.zza, (Throwable) obj);
            }
        }, executor);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static zzevd zzc(zzevc zzevcVar, AdvertisingIdClient.Info info) {
        zzfsa zzfsaVar = new zzfsa();
        if (zzevcVar.zze) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdu)).booleanValue()) {
                Context context = zzevcVar.zza;
                zzfse zzfseVarZzj = zzfse.zzj(context);
                Objects.requireNonNull(info);
                String str = info.zza;
                Objects.requireNonNull(str);
                zzfsaVar = zzfseVarZzj.zzi(str, context.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdz)).longValue(), zzevcVar.zzf);
            }
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdt)).booleanValue()) {
                try {
                    Context context2 = zzevcVar.zza;
                    zzfse zzfseVarZzj2 = zzfse.zzj(context2);
                    Objects.requireNonNull(info);
                    String str2 = info.zza;
                    Objects.requireNonNull(str2);
                    zzfsaVar = zzfseVarZzj2.zzi(str2, context2.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdz)).longValue(), zzevcVar.zzf);
                } catch (IOException | IllegalArgumentException e) {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, dLDI.atkQTkHlNqJE);
                    zzfsaVar = new zzfsa();
                }
            }
        }
        return new zzevd(info, null, zzfsaVar);
    }
}
