package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.room.RoomOpenHelper;
import com.android.billingclient.api.BillingFlowParams;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamite.yXvB.MJoJJyFaOH;
import com.google.android.gms.internal.p002firebaseauthapi.zzxf;
import com.google.android.gms.internal.p002firebaseauthapi.zzxg;
import com.google.android.gms.internal.p002firebaseauthapi.zzyz;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import kotlinx.coroutines.android.Mos.kiqcCZ;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GenericIdpActivity extends FragmentActivity implements zzxg {
    public static long zzb;
    public static final zzbm zzc = zzbm.zzc();
    public final Executor zzd = com.google.android.gms.internal.p002firebaseauthapi.zzf.zza().zza(1);
    public boolean zze = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh() {
        zzb = 0L;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzc.zzd(this);
        } else {
            zzc.zzf(this, zzai.zza("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(Status status) {
        zzb = 0L;
        this.zze = false;
        Intent intent = new Intent();
        zzbl.zzc(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzc.zzd(this);
        } else {
            zzc.zzf(getApplicationContext(), status);
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        kiqcCZ.wmTZvBznobyZo.invoke(null, this, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() throws IllegalAccessException, InvocationTargetException {
        MJoJJyFaOH.KTGSHsgF.invoke(null, this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zze);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final Uri.Builder zzb(Intent intent, String str, String str2) {
        return zzg(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final String zzc(String str) {
        return zzyz.zzb(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final HttpURLConnection zzd(URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final void zze(String str, Status status) {
        if (status == null) {
            zzh();
        } else {
            zzi(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final void zzf(Uri uri, String str) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
            zze(str, null);
            return;
        }
        List<ResolveInfo> listQueryIntentServices = getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            RoomOpenHelper roomOpenHelperBuild = new BillingFlowParams().build();
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a custom chrome tab.");
            roomOpenHelperBuild.launchUrl(this, uri);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.putExtra("com.android.browser.application_id", str);
            Log.i("GenericIdpActivity", "Opening IDP Sign In link in a browser window.");
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }

    public final Uri.Builder zzg(Uri.Builder builder, Intent intent, String str, String str2) {
        String string;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String strJoin = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        Bundle bundleExtra = intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            string = null;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str3 : bundleExtra.keySet()) {
                    String string2 = bundleExtra.getString(str3);
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.put(str3, string2);
                    }
                }
            } catch (JSONException unused) {
                Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
            }
            string = jSONObject.toString();
        }
        String string3 = UUID.randomUUID().toString();
        String strZza = zzxf.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str4 = string;
        String str5 = strJoin;
        zzj.zzb().zzd(getApplicationContext(), str, string3, strZza, action, stringExtra2, stringExtra3, stringExtra4);
        String strZzc = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(strZzc)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            zzi(zzai.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        if (strZza == null) {
            return null;
        }
        builder.appendQueryParameter("eid", "p").appendQueryParameter("v", "X".concat(String.valueOf(stringExtra5))).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", strZza).appendQueryParameter("eventId", string3).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", strZzc);
        if (!TextUtils.isEmpty(str5)) {
            builder.appendQueryParameter("scopes", str5);
        }
        if (!TextUtils.isEmpty(str4)) {
            builder.appendQueryParameter("customParameters", str4);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            builder.appendQueryParameter("tid", stringExtra3);
        }
        return builder;
    }
}
