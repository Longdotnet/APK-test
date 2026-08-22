package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.internal.client.zzai;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbtj;

/* JADX INFO: loaded from: classes.dex */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        try {
            TooltipPopup tooltipPopup = zzbb.zzb.zzd;
            zzbpm zzbpmVar = new zzbpm();
            tooltipPopup.getClass();
            ((zzbtj) new zzai(tooltipPopup, this, zzbpmVar).zzd(this, false)).zze(intent);
        } catch (RemoteException e) {
            zzo.zzg("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }
}
