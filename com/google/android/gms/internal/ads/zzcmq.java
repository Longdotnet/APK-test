package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmq {
    zzbup zza;
    zzbup zzb;
    private final Context zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzedi zze;
    private final zzdpo zzf;
    private final zzgdy zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    public zzcmq(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzedi zzediVar, zzdpo zzdpoVar, zzgdy zzgdyVar, zzgdy zzgdyVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzgVar;
        this.zze = zzediVar;
        this.zzf = zzdpoVar;
        this.zzg = zzgdyVar;
        this.zzh = zzgdyVar2;
        this.zzi = scheduledExecutorService;
    }

    public static ListenableFuture zzb(zzcmq zzcmqVar, final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkG), "10");
            return zzgdn.zzh(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        zzbcv zzbcvVar = zzbde.zzkH;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        builderBuildUpon.appendQueryParameter((String) zzbdVar.zzd.zzb(zzbcvVar), "1");
        builderBuildUpon.appendQueryParameter((String) zzbdVar.zzd.zzb(zzbde.zzkG), "12");
        if (str.contains((CharSequence) zzbdVar.zzd.zzb(zzbde.zzkI))) {
            builderBuildUpon.authority((String) zzbdVar.zzd.zzb(zzbde.zzkJ));
        }
        return (zzgde) zzgdn.zzn(zzgde.zzw(zzcmqVar.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcmm
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkG);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzgdn.zzh(builder2.toString());
            }
        }, zzcmqVar.zzh);
    }

    public static /* synthetic */ ListenableFuture zzc(final zzcmq zzcmqVar, String str, final Throwable th) {
        zzcmqVar.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmj
            @Override // java.lang.Runnable
            public final void run() {
                zzcmq.zzg(this.zza, th);
            }
        });
        return zzgdn.zzh(str);
    }

    public static ListenableFuture zzd(final zzcmq zzcmqVar, Uri.Builder builder, final Throwable th) {
        zzcmqVar.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmi
            @Override // java.lang.Runnable
            public final void run() {
                zzcmq.zzh(this.zza, th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkG), "9");
        return zzgdn.zzh(builder.toString());
    }

    public static void zzg(zzcmq zzcmqVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkL)).booleanValue()) {
            zzbup zzbupVarZzc = zzbun.zzc(zzcmqVar.zzc);
            zzcmqVar.zzb = zzbupVarZzc;
            zzbupVarZzc.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
        } else {
            zzbup zzbupVarZza = zzbun.zza(zzcmqVar.zzc);
            zzcmqVar.zza = zzbupVarZza;
            zzbupVarZza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
        }
    }

    public static void zzh(zzcmq zzcmqVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkL)).booleanValue()) {
            zzbup zzbupVarZzc = zzbun.zzc(zzcmqVar.zzc);
            zzcmqVar.zzb = zzbupVarZzc;
            zzbupVarZzc.zzh(th, "AttributionReporting");
        } else {
            zzbup zzbupVarZza = zzbun.zza(zzcmqVar.zzc);
            zzcmqVar.zza = zzbupVarZza;
            zzbupVarZza.zzh(th, "AttributionReportingSampled");
        }
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkE));
    }

    private final ListenableFuture zzk(final String str, final InputEvent inputEvent, Random random) {
        try {
            zzbcv zzbcvVar = zzbde.zzkE;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (!str.contains((CharSequence) zzbdVar.zzd.zzb(zzbcvVar)) || ((com.google.android.gms.ads.internal.util.zzj) this.zzd).zzN()) {
                return zzgdn.zzh(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) zzbdVar.zzd.zzb(zzbde.zzkF), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            if (inputEvent != null) {
                return (zzgde) zzgdn.zzf((zzgde) zzgdn.zzn(zzgde.zzw(this.zze.zza()), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcmk
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzcmq.zzb(this.zza, builderBuildUpon, str, inputEvent, (Integer) obj);
                    }
                }, this.zzh), Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcml
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return zzcmq.zzd(this.zza, builderBuildUpon, (Throwable) obj);
                    }
                }, this.zzg);
            }
            builderBuildUpon.appendQueryParameter((String) zzbdVar.zzd.zzb(zzbde.zzkG), "11");
            return zzgdn.zzh(builderBuildUpon.toString());
        } catch (Exception e) {
            return zzgdn.zzg(e);
        }
    }

    public final ListenableFuture zze(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgdn.zzh(str) : zzgdn.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcmh
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzcmq.zzc(this.zza, str, (Throwable) obj);
            }
        }, this.zzg);
    }

    public final void zzi(String str, zzfjy zzfjyVar, Random random, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzgdn.zzr(zzgdn.zzo(zzk(str, this.zzf.zza(), random), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkK)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcmp(this, zzfjyVar, str, zzvVar), this.zzg);
    }
}
