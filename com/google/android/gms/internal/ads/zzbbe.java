package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbbe {
    private com.google.android.gms.ads.internal.client.zzbx zza;
    private final Context zzb;
    private final String zzc;
    private final com.google.android.gms.ads.internal.client.zzek zzd;
    private final AppOpenAd.AppOpenAdLoadCallback zze;
    private final zzbpm zzf = new zzbpm();
    private final com.google.android.gms.ads.internal.client.zzq zzg = com.google.android.gms.ads.internal.client.zzq.zza;

    public zzbbe(Context context, String str, com.google.android.gms.ads.internal.client.zzek zzekVar, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzekVar;
        this.zze = appOpenAdLoadCallback;
    }

    public final void zza() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzr zzrVarZzb = com.google.android.gms.ads.internal.client.zzr.zzb();
            TooltipPopup tooltipPopup = com.google.android.gms.ads.internal.client.zzbb.zzb.zzd;
            Context context = this.zzb;
            String str = this.zzc;
            zzbpm zzbpmVar = this.zzf;
            tooltipPopup.getClass();
            com.google.android.gms.ads.internal.client.zzbx zzbxVar = (com.google.android.gms.ads.internal.client.zzbx) new com.google.android.gms.ads.internal.client.zzam(tooltipPopup, context, zzrVarZzb, str, zzbpmVar).zzd(context, false);
            this.zza = zzbxVar;
            if (zzbxVar != null) {
                com.google.android.gms.ads.internal.client.zzek zzekVar = this.zzd;
                zzekVar.zzn = jCurrentTimeMillis;
                zzbxVar.zzI(new zzbar(this.zze, str));
                com.google.android.gms.ads.internal.client.zzbx zzbxVar2 = this.zza;
                this.zzg.getClass();
                zzbxVar2.zzad(com.google.android.gms.ads.internal.client.zzq.zza(context, zzekVar));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl(YcVWhnLsj.NbcqIvoq, e);
        }
    }
}
