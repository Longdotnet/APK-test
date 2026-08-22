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
import com.facebook.appevents.restrictivedatafilter.QAKZ.iXUtESehR;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzxg;
import com.google.android.gms.internal.p002firebaseauthapi.zzxr;
import com.google.android.gms.internal.p002firebaseauthapi.zzyz;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.android.Mos.kiqcCZ;

/* JADX INFO: loaded from: classes2.dex */
public class RecaptchaActivity extends FragmentActivity implements zzxg {
    public static final String zzb = "RecaptchaActivity";
    public static final ExecutorService zzc = com.google.android.gms.internal.p002firebaseauthapi.zzf.zza().zza(2);
    public static long zzd = 0;
    public static final zzbm zze = zzbm.zzc();
    public boolean zzf = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        zzd = 0L;
        this.zzf = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        zze.zzd(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh(Status status) {
        zzd = 0L;
        this.zzf = false;
        Intent intent = new Intent();
        zzbl.zzc(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        zze.zzd(this);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        iXUtESehR.uiV.invoke(null, this, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() throws IllegalAccessException, InvocationTargetException {
        kiqcCZ.TAeZnf.invoke(null, this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zzf);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final Context zza() {
        return getApplicationContext();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final Uri.Builder zzb(Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String string = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
        zzj.zzb().zze(getApplicationContext(), str, string, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String strZzc = zzk.zza(getApplicationContext(), firebaseApp.getPersistenceKey()).zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", !TextUtils.isEmpty(firebaseAuth.getLanguageCode()) ? firebaseAuth.getLanguageCode() : zzxr.zza()).appendQueryParameter("eventId", string).appendQueryParameter("v", "X".concat(String.valueOf(stringExtra2))).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", strZzc);
        }
        Log.e(zzb, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
        zzh(zzai.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
        return null;
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
            zzxg.zza.e("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final void zze(String str, Status status) {
        if (status == null) {
            zzg();
        } else {
            zzh(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxg
    public final void zzf(Uri uri, String str) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e(zzb, "Device cannot resolve intent for: android.intent.action.VIEW");
            zze(str, null);
            return;
        }
        List<ResolveInfo> listQueryIntentServices = getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.putExtra("com.android.browser.application_id", str);
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            startActivity(intent);
            return;
        }
        RoomOpenHelper roomOpenHelperBuild = new BillingFlowParams().build();
        Intent intent2 = (Intent) roomOpenHelperBuild.mConfiguration;
        intent2.addFlags(1073741824);
        intent2.addFlags(268435456);
        roomOpenHelperBuild.launchUrl(this, uri);
    }
}
