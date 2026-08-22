package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.daerisoft.thespikerm.R;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginFragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class FacebookActivity extends FragmentActivity {
    public Fragment currentFragment;

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void dump(String prefix, FileDescriptor fileDescriptor, PrintWriter writer, String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(writer, "writer");
            if (Intrinsics.areEqual(null, Boolean.TRUE)) {
                return;
            }
            super.dump(prefix, fileDescriptor, writer, strArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Fragment fragment = this.currentFragment;
        if (fragment == null) {
            return;
        }
        fragment.onConfigurationChanged(newConfig);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Fragment fragment;
        Fragment fragment2;
        FacebookException facebookException;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.sdkInitialized.get()) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            synchronized (FacebookSdk.class) {
                FacebookSdk.sdkInitialize(applicationContext, null);
            }
        }
        setContentView(R.layout.com_facebook_activity_layout);
        if (!"PassThrough".equals(intent.getAction())) {
            Intent intent2 = getIntent();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag("SingleFragment");
            if (fragmentFindFragmentByTag == null) {
                if ("FacebookDialogFragment".equals(intent2.getAction())) {
                    fragment = fragmentFindFragmentByTag;
                    FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
                    facebookDialogFragment.setRetainInstance(true);
                    facebookDialogFragment.show(supportFragmentManager, "SingleFragment");
                    fragment2 = facebookDialogFragment;
                } else {
                    fragment = fragmentFindFragmentByTag;
                    LoginFragment loginFragment = new LoginFragment();
                    loginFragment.setRetainInstance(true);
                    BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
                    backStackRecord.doAddOp(R.id.com_facebook_fragment_container, loginFragment, "SingleFragment");
                    backStackRecord.commitInternal(false);
                    fragment2 = loginFragment;
                }
                fragment = fragment2;
            }
            fragment = fragmentFindFragmentByTag;
            this.currentFragment = fragment;
            return;
        }
        Intent requestIntent = getIntent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(requestIntent, "requestIntent");
        Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(requestIntent);
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || methodArgumentsFromIntent == null) {
            facebookException = null;
        } else {
            try {
                String string = methodArgumentsFromIntent.getString("error_type");
                if (string == null) {
                    string = methodArgumentsFromIntent.getString("com.facebook.platform.status.ERROR_TYPE");
                }
                String string2 = methodArgumentsFromIntent.getString("error_description");
                if (string2 == null) {
                    string2 = methodArgumentsFromIntent.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
                }
                facebookException = (string == null || !string.equalsIgnoreCase("UserCanceled")) ? new FacebookException(string2) : new FacebookOperationCanceledException(string2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
                facebookException = null;
            }
        }
        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
        Intent intent3 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent3, "intent");
        setResult(0, NativeProtocol.createProtocolResultIntent(intent3, null, facebookException));
        finish();
    }
}
