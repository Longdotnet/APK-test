package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.AccessTokenCache;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {
    public ActivityResultLauncher zza;
    public ActivityResultLauncher zzb;
    public ResultReceiver zzc;
    public ResultReceiver zzd;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.zzc;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.zzd;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new AccessTokenCache(this, 12));
        this.zzb = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new Fragment.AnonymousClass7((Object) this, 14));
        if (bundle == null) {
            zzb.zzj("ProxyBillingActivityV2", ZRqOdXiy.AtEz);
            if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                this.zzc = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
                ActivityResultLauncher activityResultLauncher = this.zza;
                Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
                IntentSender intentSender = pendingIntent.getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender, "pendingIntent.intentSender");
                activityResultLauncher.launch(new IntentSenderRequest(intentSender, null, 0, 0));
                return;
            }
            if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
                PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
                this.zzd = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
                ActivityResultLauncher activityResultLauncher2 = this.zzb;
                Intrinsics.checkNotNullParameter(pendingIntent2, "pendingIntent");
                IntentSender intentSender2 = pendingIntent2.getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender2, "pendingIntent.intentSender");
                activityResultLauncher2.launch(new IntentSenderRequest(intentSender2, null, 0, 0));
                return;
            }
            return;
        }
        if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
            this.zzc = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
        } else if (bundle.containsKey("external_payment_dialog_result_receiver")) {
            this.zzd = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
        }
    }
}
