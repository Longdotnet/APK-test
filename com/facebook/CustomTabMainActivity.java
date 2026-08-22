package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.room.RoomOpenHelper;
import com.android.billingclient.api.BillingFlowParams;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;
import com.facebook.login.LoginTargetApp;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomTabMainActivity extends Activity {
    public zzq redirectReceiver;
    public boolean shouldCloseCustomTab = true;
    public static final String EXTRA_ACTION = Intrinsics.stringPlus(TSDAbK.IVhtQIGLizq, "CustomTabMainActivity");
    public static final String EXTRA_PARAMS = Intrinsics.stringPlus(".extra_params", "CustomTabMainActivity");
    public static final String EXTRA_CHROME_PACKAGE = Intrinsics.stringPlus(".extra_chromePackage", "CustomTabMainActivity");
    public static final String EXTRA_URL = Intrinsics.stringPlus(".extra_url", "CustomTabMainActivity");
    public static final String EXTRA_TARGET_APP = Intrinsics.stringPlus(".extra_targetApp", "CustomTabMainActivity");
    public static final String REFRESH_ACTION = Intrinsics.stringPlus(".action_refresh", "CustomTabMainActivity");
    public static final String NO_ACTIVITY_EXCEPTION = Intrinsics.stringPlus(".no_activity_exception", "CustomTabMainActivity");

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.valuesCustom().length];
            iArr[1] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        String stringExtra;
        LoginTargetApp loginTargetApp;
        ProfileCache profileCache;
        boolean z;
        Uri uriBuildUri;
        super.onCreate(bundle);
        if (Intrinsics.areEqual(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle != null || (stringExtra = getIntent().getStringExtra(EXTRA_ACTION)) == null) {
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
        String stringExtra3 = getIntent().getStringExtra(EXTRA_TARGET_APP);
        LoginTargetApp[] loginTargetAppArrValuesCustom = LoginTargetApp.valuesCustom();
        int length = loginTargetAppArrValuesCustom.length;
        int i = 0;
        do {
            if (i >= length) {
                loginTargetApp = LoginTargetApp.FACEBOOK;
                break;
            } else {
                loginTargetApp = loginTargetAppArrValuesCustom[i];
                i++;
            }
        } while (!loginTargetApp.targetApp.equals(stringExtra3));
        if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
            profileCache = new InstagramCustomTab(stringExtra, bundleExtra);
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            if (stringExtra.equals("oauth")) {
                uriBuildUri = Utility.buildUri(Utility.getInstagramDialogAuthority(), "oauth/authorize", bundleExtra);
            } else {
                uriBuildUri = Utility.buildUri(Utility.getInstagramDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + stringExtra, bundleExtra);
            }
            if (!CrashShieldHandler.isObjectCrashing(profileCache)) {
                try {
                    profileCache.sharedPreferences = uriBuildUri;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(profileCache, th);
                }
            }
        } else {
            profileCache = new ProfileCache(stringExtra, bundleExtra);
        }
        if (CrashShieldHandler.isObjectCrashing(profileCache)) {
            z = false;
        } else {
            try {
                ReentrantLock reentrantLock = CustomTabPrefetchHelper.lock;
                reentrantLock.lock();
                reentrantLock.unlock();
                RoomOpenHelper roomOpenHelperBuild = new BillingFlowParams(null).build();
                ((Intent) roomOpenHelperBuild.mConfiguration).setPackage(stringExtra2);
                try {
                    roomOpenHelperBuild.launchUrl(this, (Uri) profileCache.sharedPreferences);
                    z = true;
                } catch (ActivityNotFoundException unused) {
                    z = false;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(profileCache, th2);
            }
        }
        this.shouldCloseCustomTab = false;
        if (!z) {
            setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
            finish();
        } else {
            zzq zzqVar = new zzq(this, 6);
            this.redirectReceiver = zzqVar;
            LocalBroadcastManager.getInstance(this).registerReceiver(zzqVar, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (Intrinsics.areEqual(REFRESH_ACTION, intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (Intrinsics.areEqual(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    public final void sendResult(int i, Intent intent) {
        Bundle bundle;
        zzq zzqVar = this.redirectReceiver;
        if (zzqVar != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(zzqVar);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            if (stringExtra != null) {
                Uri uri = Uri.parse(stringExtra);
                bundle = Utility.parseUrlQueryString(uri.getQuery());
                bundle.putAll(Utility.parseUrlQueryString(uri.getFragment()));
            } else {
                bundle = new Bundle();
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Intent intentCreateProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent2, bundle, null);
            if (intentCreateProtocolResultIntent != null) {
                intent = intentCreateProtocolResultIntent;
            }
            setResult(i, intent);
        } else {
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            setResult(i, NativeProtocol.createProtocolResultIntent(intent3, null, null));
        }
        finish();
    }
}
