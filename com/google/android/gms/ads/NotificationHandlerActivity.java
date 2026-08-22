package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.internal.client.zzai;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbtj;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationHandlerActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            TooltipPopup tooltipPopup = zzbb.zzb.zzd;
            zzbpm zzbpmVar = new zzbpm();
            tooltipPopup.getClass();
            zzbtj zzbtjVar = (zzbtj) new zzai(tooltipPopup, this, zzbpmVar).zzd(this, false);
            if (zzbtjVar == null) {
                zzo.zzg("OfflineUtils is null");
            } else {
                zzbtjVar.zze(getIntent());
            }
        } catch (RemoteException e) {
            zzo.zzg("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        finish();
    }
}
