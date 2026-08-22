package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyBillingActivity extends Activity {
    public ResultReceiver inAppMessageResultReceiver;
    public boolean isFlowFromFirstPartyClient;
    public ResultReceiver priceChangeResultReceiver;
    public boolean sendCancelledBroadcastIfFinished;

    public final Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i;
        PendingIntent pendingIntent;
        int i2;
        super.onCreate(bundle);
        if (bundle != null) {
            zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.priceChangeResultReceiver = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.isFlowFromFirstPartyClient = true;
                i2 = 110;
                i = i2;
            } else {
                i = 100;
            }
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.priceChangeResultReceiver = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            i = 100;
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            i2 = 101;
            i = i2;
        } else {
            i = 100;
            pendingIntent = null;
        }
        try {
            this.sendCancelledBroadcastIfFinished = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            zzb.zzl("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e);
            ResultReceiver resultReceiver = this.priceChangeResultReceiver;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                    if (this.isFlowFromFirstPartyClient) {
                        intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
                    intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(intentMakePurchasesUpdatedIntent);
                }
            }
            this.sendCancelledBroadcastIfFinished = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.priceChangeResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Intent intentMakePurchasesUpdatedIntent;
        super.onActivityResult(i, i2, intent);
        Bundle extras = null;
        if (i != 100 && i != 110) {
            if (i == 101) {
                int iZza = zzb.zza(intent, "ProxyBillingActivity");
                ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
                if (resultReceiver != null) {
                    if (intent != null) {
                        extras = intent.getExtras();
                    }
                    resultReceiver.send(iZza, extras);
                }
            } else {
                zzb.zzk("ProxyBillingActivity", GsPcpBmONXh.efFbpRZQbSYY + i + "; skipping...");
            }
        } else {
            int i3 = zzb.zze(intent, "ProxyBillingActivity").zza;
            if (i2 == -1) {
                if (i3 != 0) {
                    i2 = -1;
                    zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + i3);
                } else {
                    i3 = 0;
                }
            } else {
                zzb.zzk("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + i3);
            }
            ResultReceiver resultReceiver2 = this.priceChangeResultReceiver;
            if (resultReceiver2 != null) {
                if (intent != null) {
                    extras = intent.getExtras();
                }
                resultReceiver2.send(i3, extras);
            } else {
                if (intent != null) {
                    if (intent.getExtras() != null) {
                        String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                        if (string != null) {
                            intentMakePurchasesUpdatedIntent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
                            intentMakePurchasesUpdatedIntent.setPackage(getApplicationContext().getPackageName());
                            intentMakePurchasesUpdatedIntent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", string);
                            intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                        } else {
                            Intent intentMakePurchasesUpdatedIntent2 = makePurchasesUpdatedIntent();
                            intentMakePurchasesUpdatedIntent2.putExtras(intent.getExtras());
                            intentMakePurchasesUpdatedIntent2.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                            intentMakePurchasesUpdatedIntent = intentMakePurchasesUpdatedIntent2;
                        }
                    } else {
                        intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                        zzb.zzk("ProxyBillingActivity", "Got null bundle!");
                        intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
                        intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                        builderNewBuilder.zza = 6;
                        builderNewBuilder.zzb = "An internal error occurred.";
                        intentMakePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzcb.zza(22, 2, builderNewBuilder.build()).zzc());
                        intentMakePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                    }
                } else {
                    intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                }
                if (i == 110) {
                    intentMakePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                }
                sendBroadcast(intentMakePurchasesUpdatedIntent);
            }
        }
        this.sendCancelledBroadcastIfFinished = false;
        finish();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent intentMakePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            intentMakePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            intentMakePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", gZrKCJ.wmGSF);
            sendBroadcast(intentMakePurchasesUpdatedIntent);
        }
    }
}
