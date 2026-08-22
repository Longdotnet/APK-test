package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuw implements zzeuc {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzgdy zzc;
    private final ScheduledExecutorService zzd;
    private final zzedk zze;
    private final zzfcw zzf;
    private final VersionInfoParcel zzg;

    public zzeuw(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzedk zzedkVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzgdyVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzedkVar;
        this.zzf = zzfcwVar;
        this.zzg = versionInfoParcel;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeuw zzeuwVar, final Throwable th) {
        zzeuy zzeuyVar;
        zzeuwVar.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeut
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkR)).booleanValue();
                Throwable th2 = th;
                if (zBooleanValue) {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzx(th2, "TopicsSignalUnsampled.fetchTopicsSignal");
                } else {
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th2, "TopicsSignal.fetchTopicsSignal");
                }
            }
        });
        if (th instanceof SecurityException) {
            zzeuyVar = new zzeuy("", 2, null);
        } else if (th instanceof IllegalStateException) {
            zzeuyVar = new zzeuy("", 3, null);
        } else if (th instanceof IllegalArgumentException) {
            zzeuyVar = new zzeuy("", 4, null);
        } else {
            zzeuyVar = th instanceof TimeoutException ? new zzeuy("", 5, null) : new zzeuy("", 0, null);
        }
        return zzgdn.zzh(zzeuyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
    
        if (java.util.Arrays.asList(r0.split(",")).contains(r9.zzb.getPackageName()) == false) goto L48;
     */
    @Override // com.google.android.gms.internal.ads.zzeuc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zzb() {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuw.zzb():com.google.common.util.concurrent.ListenableFuture");
    }
}
