package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzfle {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ScheduledExecutorService zzc;
    private final ClientApi zzd = new ClientApi();
    private zzbpq zze;
    private final Clock zzf;

    public zzfle(Context context, VersionInfoParcel versionInfoParcel, ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = scheduledExecutorService;
        this.zzf = clock;
    }

    private static zzfkg zzd() {
        zzbcv zzbcvVar = zzbde.zzB;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        return new zzfkg(((Long) zzbdVar.zzd.zzb(zzbcvVar)).longValue(), 2.0d, ((Long) zzbdVar.zzd.zzb(zzbde.zzC)).longValue(), 0.2d);
    }

    public final zzfld zza(com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
        if (adFormat == null) {
            return null;
        }
        int iOrdinal = adFormat.ordinal();
        if (iOrdinal == 1) {
            return new zzfki(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzceVar, this.zzc, zzd(), this.zzf);
        }
        if (iOrdinal == 2) {
            return new zzflh(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzceVar, this.zzc, zzd(), this.zzf);
        }
        if (iOrdinal != 5) {
            return null;
        }
        return new zzfkf(this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzceVar, this.zzc, zzd(), this.zzf);
    }

    public final zzfld zzb(String str, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar) {
        AdFormat adFormat = AdFormat.getAdFormat(zzfvVar.zzb);
        if (adFormat == null) {
            return null;
        }
        int iOrdinal = adFormat.ordinal();
        if (iOrdinal == 1) {
            return new zzfki(str, this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzchVar, this.zzc, zzd(), this.zzf);
        }
        if (iOrdinal == 2) {
            return new zzflh(str, this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzchVar, this.zzc, zzd(), this.zzf);
        }
        if (iOrdinal != 5) {
            return null;
        }
        return new zzfkf(str, this.zzd, this.zza, this.zzb.clientJarVersion, this.zze, zzfvVar, zzchVar, this.zzc, zzd(), this.zzf);
    }

    public final void zzc(zzbpq zzbpqVar) {
        this.zze = zzbpqVar;
    }
}
