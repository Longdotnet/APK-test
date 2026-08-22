package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import com.android.billingclient.api.zzcj;
import com.facebook.ProfileCache;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class SignInHubActivity extends FragmentActivity {
    public static boolean zba = false;
    public boolean zbb = false;
    public SignInConfiguration zbc;
    public boolean zbd;
    public int zbe;
    public Intent zbf;

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        GoogleSignInAccount googleSignInAccount;
        if (this.zbb) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && (googleSignInAccount = signInAccount.zbc) != null) {
                Fragment.AnonymousClass7 anonymousClass7Zbc = Fragment.AnonymousClass7.zbc(this);
                GoogleSignInOptions googleSignInOptions = this.zbc.zbb;
                synchronized (anonymousClass7Zbc) {
                    ((Storage) anonymousClass7Zbc.this$0).saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
                }
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccount);
                this.zbd = true;
                this.zbe = i2;
                this.zbf = intent;
                zbc();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                zbd(intExtra);
                return;
            }
        }
        zbd(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", strValueOf.length() != 0 ? "Unknown action: ".concat(strValueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        bundleExtra.getClass();
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.zbc = signInConfiguration;
        if (bundle != null) {
            boolean z = bundle.getBoolean("signingInGoogleApiClients");
            this.zbd = z;
            if (z) {
                this.zbe = bundle.getInt("signInResultCode");
                Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                intent2.getClass();
                this.zbf = intent2;
                zbc();
                return;
            }
            return;
        }
        if (zba) {
            setResult(0);
            zbd(12502);
            return;
        }
        zba = true;
        Intent intent3 = new Intent(action);
        if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent3.setPackage("com.google.android.gms");
        } else {
            intent3.setPackage(getPackageName());
        }
        intent3.putExtra("config", this.zbc);
        try {
            startActivityForResult(intent3, 40962);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            zbd(17);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zbc() {
        LoaderManager supportLoaderManager = getSupportLoaderManager();
        ProfileCache profileCache = new ProfileCache(this, 26);
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) supportLoaderManager;
        LoaderManagerImpl.LoaderViewModel loaderViewModel = loaderManagerImpl.mLoaderViewModel;
        if (loaderViewModel.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        SparseArrayCompat sparseArrayCompat = loaderViewModel.mLoaders;
        LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo) sparseArrayCompat.get(0, null);
        LifecycleOwner lifecycleOwner = loaderManagerImpl.mLifecycleOwner;
        if (loaderInfo == null) {
            try {
                loaderViewModel.mCreatingLoader = true;
                zbc zbcVar = new zbc(this, GoogleApiClient.getAllClients());
                if (zbc.class.isMemberClass() && !Modifier.isStatic(zbc.class.getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + zbcVar);
                }
                LoaderManagerImpl.LoaderInfo loaderInfo2 = new LoaderManagerImpl.LoaderInfo(zbcVar);
                sparseArrayCompat.put(0, loaderInfo2);
                loaderViewModel.mCreatingLoader = false;
                zzcj zzcjVar = new zzcj(loaderInfo2.mLoader, profileCache);
                loaderInfo2.observe(lifecycleOwner, zzcjVar);
                zzcj zzcjVar2 = loaderInfo2.mObserver;
                if (zzcjVar2 != null) {
                    loaderInfo2.removeObserver(zzcjVar2);
                }
                loaderInfo2.mLifecycleOwner = lifecycleOwner;
                loaderInfo2.mObserver = zzcjVar;
            } catch (Throwable th) {
                loaderViewModel.mCreatingLoader = false;
                throw th;
            }
        } else {
            zzcj zzcjVar3 = new zzcj(loaderInfo.mLoader, profileCache);
            loaderInfo.observe(lifecycleOwner, zzcjVar3);
            zzcj zzcjVar4 = loaderInfo.mObserver;
            if (zzcjVar4 != null) {
                loaderInfo.removeObserver(zzcjVar4);
            }
            loaderInfo.mLifecycleOwner = lifecycleOwner;
            loaderInfo.mObserver = zzcjVar3;
        }
        zba = false;
    }

    public final void zbd(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }
}
