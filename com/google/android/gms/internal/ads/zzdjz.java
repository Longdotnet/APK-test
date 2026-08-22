package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjz implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdny zzd;
    private final Clock zze;
    private zzbig zzf;
    private zzbkf zzg;

    public zzdjz(zzdny zzdnyVar, Clock clock) {
        this.zzd = zzdnyVar;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zza != null && this.zzb != null) {
            HashMap map = new HashMap();
            map.put("id", this.zza);
            ((DefaultClock) this.zze).getClass();
            map.put("time_interval", String.valueOf(System.currentTimeMillis() - this.zzb.longValue()));
            map.put("messageType", "onePointFiveClick");
            this.zzd.zzj("sendMessageToNativeJs", map);
        }
        zzd();
    }

    public final zzbig zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf == null || this.zzb == null) {
            return;
        }
        zzd();
        try {
            this.zzf.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzc(final zzbig zzbigVar) {
        this.zzf = zzbigVar;
        zzbkf zzbkfVar = this.zzg;
        if (zzbkfVar != null) {
            this.zzd.zzn("/unconfirmedClick", zzbkfVar);
        }
        zzbkf zzbkfVar2 = new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdjy
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                zzdjz zzdjzVar = this.zza;
                try {
                    zzdjzVar.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzbig zzbigVar2 = zzbigVar;
                zzdjzVar.zza = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzbigVar2 == null) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
                } else {
                    try {
                        zzbigVar2.zzf(str);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        };
        this.zzg = zzbkfVar2;
        this.zzd.zzl("/unconfirmedClick", zzbkfVar2);
    }
}
