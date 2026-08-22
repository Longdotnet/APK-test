package com.google.android.gms.games.internal.v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.games_v2.zzfn;

/* JADX INFO: loaded from: classes.dex */
public final class GamesResolutionActivity extends Activity {
    public ResultReceiver zza;
    public boolean zzb;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            zza(i2, intent);
            finish();
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25);
        sb.append("Unexpected request code: ");
        sb.append(i);
        zzfn.zzg("ResultActivity", sb.toString());
        zza(0, intent);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("resultReceiver");
            zzah.checkNotNull(resultReceiver);
            this.zza = resultReceiver;
            return;
        }
        ResultReceiver resultReceiver2 = (ResultReceiver) getIntent().getParcelableExtra("resultReceiver");
        zzah.checkNotNull(resultReceiver2);
        this.zza = resultReceiver2;
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT);
        zzah.checkNotNull(pendingIntent);
        try {
            startIntentSenderForResult(pendingIntent.getIntentSender(), 0, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            zzfn.zzh("ResultActivity", "Failed to launch", e);
            zza(0, null);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        if (!isChangingConfigurations()) {
            zza(0, null);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("resultReceiver", this.zza);
    }

    public final void zza(int i, Intent intent) {
        Bundle bundle;
        if (this.zzb) {
            return;
        }
        this.zzb = true;
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver != null) {
            if (intent == null) {
                bundle = new Bundle();
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("resultData", intent);
                bundle = bundle2;
            }
            resultReceiver.send(i, bundle);
        }
    }
}
