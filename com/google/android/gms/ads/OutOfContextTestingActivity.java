package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.LinearLayout;
import androidx.appcompat.widget.TooltipPopup;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.ads.internal.client.zzae;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbpm;

/* JADX INFO: loaded from: classes.dex */
public final class OutOfContextTestingActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TooltipPopup tooltipPopup = zzbb.zzb.zzd;
        zzbpm zzbpmVar = new zzbpm();
        tooltipPopup.getClass();
        zzdw zzdwVar = (zzdw) new zzae(tooltipPopup, this, zzbpmVar).zzd(this, false);
        if (zzdwVar == null) {
            finish();
            return;
        }
        setContentView(R.layout.admob_empty_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("adUnit");
        if (stringExtra == null) {
            finish();
            return;
        }
        try {
            zzdwVar.zze(stringExtra, new ObjectWrapper(this), new ObjectWrapper(linearLayout));
        } catch (RemoteException unused) {
            finish();
        }
    }
}
