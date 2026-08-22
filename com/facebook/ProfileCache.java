package com.facebook;

import android.app.Service;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.util.Function;
import androidx.core.provider.FontProvider;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.JavaScriptReplyProxyImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.work.Data;
import androidx.work.WorkContinuation;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.zzaz;
import com.android.billingclient.api.zzo;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda1;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.YYGoogleSignIn;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.facebook.internal.GamingAction;
import com.facebook.internal.Utility;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzeu;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcak;
import com.google.android.gms.internal.ads.zzfpj;
import com.google.android.gms.internal.ads.zzfua;
import com.google.android.gms.internal.ads.zzfub;
import com.google.android.gms.internal.ads.zzgct;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzej;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.inject.PVS.jIKWv;
import com.yoyogames.runner.RunnerJNILib;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileCache implements WebMessageListenerBoundaryInterface, MenuPresenter.Callback, MenuBuilder.Callback, MenuItemHoverListener, FontProvider.ContentQueryWrapper, EmojiCompat.MetadataRepoLoader, Function, ActivityResultCallback, ProfileInstaller$DiagnosticsCallback, OnFailureListener, InitializationStatus, zzfub, zzaqh, zzfpj, zzgct, zzej, Continuation {
    public final /* synthetic */ int $r8$classId;
    public Object sharedPreferences;

    public /* synthetic */ ProfileCache(int i, boolean z) {
        this.$r8$classId = i;
    }

    @Override // androidx.arch.core.util.Function
    public Object apply() {
        return (ActivityResultRegistry) this.sharedPreferences;
    }

    @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.sharedPreferences;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // com.google.android.gms.ads.initialization.InitializationStatus
    public Map getAdapterStatusMap() {
        HashMap map = new HashMap();
        Objects.requireNonNull((zzey) this.sharedPreferences);
        map.put("com.google.android.gms.ads.MobileAds", new zzeu());
        return map;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public void load(ExceptionsKt exceptionsKt) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, exceptionsKt, threadPoolExecutor, 1));
    }

    public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        StringBuilder sb = new StringBuilder("{ \"responseCode\" : ");
        sb.append(Integer.toString(billingResult.zza));
        sb.append(", \"purchaseToken\" : \"");
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, ((GooglePlayBillingService.AnonymousClass6) this.sharedPreferences).val$purchaseToken, "\" }");
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12008.0d});
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "response_json", strM);
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 66);
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ActivityResult activityResult = (ActivityResult) obj;
        FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.sharedPreferences;
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
        if (launchedFragmentInfo == null) {
            Log.w("FragmentManager", "No IntentSenders were started for " + this);
            return;
        }
        String str = launchedFragmentInfo.mWho;
        Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
        if (fragmentFindFragmentByWho != null) {
            fragmentFindFragmentByWho.onActivityResult(launchedFragmentInfo.mRequestCode, activityResult.resultCode, activityResult.data);
        } else {
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        ((AppCompatDelegateImpl) this.sharedPreferences).checkCloseActionMenu(menuBuilder);
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Intent intentZbc;
        Log.d(GooglePlayBillingService.TAG, "GoogleSignIn onFailure: " + exc.getLocalizedMessage());
        if (!(exc instanceof ApiException)) {
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GoogleSignIn_Show");
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "message", exc.getLocalizedMessage());
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "code", exc.toString());
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
            return;
        }
        ApiException apiException = (ApiException) exc;
        Log.d(GooglePlayBillingService.TAG, "GoogleSignIn onFailure 스테이터스 코드: " + apiException.getStatusCode());
        if (apiException.getMessage() == null || !apiException.getMessage().contains("28433")) {
            return;
        }
        Log.d(GooglePlayBillingService.TAG, "(계정이 존재하지 않음. 수동 로그인 화면 출력) " + exc.getLocalizedMessage());
        GoogleSignInClient googleSignInClient = ((YYGoogleSignIn) this.sharedPreferences).mGoogleSignInClient;
        Context applicationContext = googleSignInClient.getApplicationContext();
        int iZba = googleSignInClient.zba();
        int i = iZba - 1;
        if (iZba == 0) {
            throw null;
        }
        if (i == 2) {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) googleSignInClient.getApiOptions();
            zbm.zba.d("getFallbackSignInIntent()", new Object[0]);
            intentZbc = zbm.zbc(applicationContext, googleSignInOptions);
            intentZbc.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        } else if (i != 3) {
            GoogleSignInOptions googleSignInOptions2 = (GoogleSignInOptions) googleSignInClient.getApiOptions();
            zbm.zba.d("getNoImplementationSignInIntent()", new Object[0]);
            intentZbc = zbm.zbc(applicationContext, googleSignInOptions2);
            intentZbc.setAction("com.google.android.gms.auth.NO_IMPL");
        } else {
            intentZbc = zbm.zbc(applicationContext, (GoogleSignInOptions) googleSignInClient.getApiOptions());
        }
        YYGoogleSignIn.activity.startActivityForResult(intentZbc, YYGoogleSignIn.REQ_SIGN_IN);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.sharedPreferences;
        cascadingMenuPopup.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
        ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i)).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        cascadingMenuPopup.mSubMenuHoverHandler.postAtTime(new RunnerJNILib.AnonymousClass2(this, i2 < arrayList.size() ? (CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i2) : null, menuItemImpl, menuBuilder, 1), menuBuilder, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        ((CascadingMenuPopup) this.sharedPreferences).mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean zOnMenuItemSelected;
        switch (this.$r8$classId) {
            case 3:
                return false;
            case 4:
            default:
                ProfileCache profileCache = ((Toolbar) this.sharedPreferences).mMenuBuilderCallback;
                return false;
            case 5:
                ActionMenuView.OnMenuItemClickListener onMenuItemClickListener = ((ActionMenuView) this.sharedPreferences).mOnMenuItemClickListener;
                if (onMenuItemClickListener == null) {
                    return false;
                }
                Toolbar toolbar = (Toolbar) ((Fragment.AnonymousClass7) onMenuItemClickListener).this$0;
                if (toolbar.mMenuHostHelper.onMenuItemSelected(menuItem)) {
                    zOnMenuItemSelected = true;
                } else {
                    Toolbar.OnMenuItemClickListener onMenuItemClickListener2 = toolbar.mOnMenuItemClickListener;
                    zOnMenuItemSelected = onMenuItemClickListener2 != null ? ((ToolbarActionBar) ((Fragment.AnonymousClass7) onMenuItemClickListener2).this$0).mWindowCallback.mWrapped.onMenuItemSelected(0, menuItem) : false;
                }
                return zOnMenuItemSelected;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        switch (this.$r8$classId) {
            case 3:
                ToolbarActionBar toolbarActionBar = (ToolbarActionBar) this.sharedPreferences;
                boolean zIsOverflowMenuShowing = toolbarActionBar.mDecorToolbar.mToolbar.isOverflowMenuShowing();
                AppCompatDelegateImpl.AppCompatWindowCallback appCompatWindowCallback = toolbarActionBar.mWindowCallback;
                if (zIsOverflowMenuShowing) {
                    appCompatWindowCallback.onPanelClosed(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
                } else if (appCompatWindowCallback.onPreparePanel(0, null, menuBuilder)) {
                    appCompatWindowCallback.onMenuOpened(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
                }
                break;
            case 4:
            default:
                Toolbar toolbar = (Toolbar) this.sharedPreferences;
                ActionMenuPresenter actionMenuPresenter = toolbar.mMenuView.mPresenter;
                if (actionMenuPresenter == null || !actionMenuPresenter.isOverflowMenuShowing()) {
                    Iterator it = toolbar.mMenuHostHelper.mMenuProviders.iterator();
                    while (it.hasNext()) {
                        FragmentManager.this.dispatchPrepareOptionsMenu(menuBuilder);
                    }
                }
                ProfileCache profileCache = toolbar.mMenuBuilderCallback;
                if (profileCache != null) {
                    profileCache.onMenuModeChange(menuBuilder);
                }
                break;
            case 5:
                MenuBuilder.Callback callback = ((ActionMenuView) this.sharedPreferences).mMenuBuilderCallback;
                if (callback != null) {
                    callback.onMenuModeChange(menuBuilder);
                }
                break;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback callback = ((AppCompatDelegateImpl) this.sharedPreferences).mWindow.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, menuBuilder);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006d  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z, InvocationHandler invocationHandler2) {
        WebMessageCompat webMessageCompat;
        WebMessageCompat webMessageCompat2;
        WebMessageBoundaryInterface webMessageBoundaryInterface = (WebMessageBoundaryInterface) WorkContinuation.castToSuppLibClass(WebMessageBoundaryInterface.class, invocationHandler);
        InvocationHandler[] ports = webMessageBoundaryInterface.getPorts();
        ProfileCache[] profileCacheArr = new ProfileCache[ports.length];
        for (int i = 0; i < ports.length; i++) {
            InvocationHandler invocationHandler3 = ports[i];
            ProfileCache profileCache = new ProfileCache(14, false);
            profileCache.sharedPreferences = (WebMessagePortBoundaryInterface) WorkContinuation.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler3);
            profileCacheArr[i] = profileCache;
        }
        if (WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView()) {
            WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) WorkContinuation.castToSuppLibClass(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
            int type = webMessagePayloadBoundaryInterface.getType();
            if (type != 0) {
                if (type != 1) {
                    webMessageCompat2 = null;
                } else {
                    webMessageCompat = new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer());
                }
                if (webMessageCompat2 != null) {
                    JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) WorkContinuation.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler2);
                    ((WebViewCompat.WebMessageListener) this.sharedPreferences).onPostMessage(webView, webMessageCompat2, uri, z, (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface.getOrCreatePeer(new zzaz(jsReplyProxyBoundaryInterface, 2)));
                }
            }
            webMessageCompat = new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString());
        } else {
            webMessageCompat = new WebMessageCompat(webMessageBoundaryInterface.getData());
        }
        webMessageCompat2 = webMessageCompat;
        if (webMessageCompat2 != null) {
            JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface2 = (JsReplyProxyBoundaryInterface) WorkContinuation.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler2);
            ((WebViewCompat.WebMessageListener) this.sharedPreferences).onPostMessage(webView, webMessageCompat2, uri, z, (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface2.getOrCreatePeer(new zzaz(jsReplyProxyBoundaryInterface2, 2)));
        }
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Serializable serializable) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.sharedPreferences).setResultCode(i);
    }

    public void putAll(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap map2 = (HashMap) this.sharedPreferences;
            if (value == null) {
                map2.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    map2.put(str, value);
                } else {
                    int i = 0;
                    if (cls == boolean[].class) {
                        boolean[] zArr = (boolean[]) value;
                        String str2 = Data.TAG;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i < zArr.length) {
                            boolArr[i] = Boolean.valueOf(zArr[i]);
                            i++;
                        }
                        map2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        byte[] bArr = (byte[]) value;
                        String str3 = Data.TAG;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i < bArr.length) {
                            bArr2[i] = Byte.valueOf(bArr[i]);
                            i++;
                        }
                        map2.put(str, bArr2);
                    } else if (cls == int[].class) {
                        int[] iArr = (int[]) value;
                        String str4 = Data.TAG;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i < iArr.length) {
                            numArr[i] = Integer.valueOf(iArr[i]);
                            i++;
                        }
                        map2.put(str, numArr);
                    } else if (cls == long[].class) {
                        long[] jArr = (long[]) value;
                        String str5 = Data.TAG;
                        Long[] lArr = new Long[jArr.length];
                        while (i < jArr.length) {
                            lArr[i] = Long.valueOf(jArr[i]);
                            i++;
                        }
                        map2.put(str, lArr);
                    } else if (cls == float[].class) {
                        float[] fArr = (float[]) value;
                        String str6 = Data.TAG;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i < fArr.length) {
                            fArr2[i] = Float.valueOf(fArr[i]);
                            i++;
                        }
                        map2.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                        }
                        double[] dArr = (double[]) value;
                        String str7 = Data.TAG;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i < dArr.length) {
                            dArr2[i] = Double.valueOf(dArr[i]);
                            i++;
                        }
                        map2.put(str, dArr2);
                    }
                }
            }
        }
    }

    @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
    public Cursor query(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.sharedPreferences;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e) {
            Log.w("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* bridge */ /* synthetic */ Object then(Task task) {
        zzae zzaeVar = (zzae) this.sharedPreferences;
        if (zzaeVar.zzd == null) {
            return task;
        }
        if (task.isSuccessful()) {
            AuthResult authResult = (AuthResult) task.getResult();
            return WorkContinuation.forResult(new zzr((zzx) authResult.getUser(), (zzp) authResult.getAdditionalUserInfo(), zzaeVar.zzd));
        }
        Exception exception = task.getException();
        if (exception instanceof FirebaseAuthUserCollisionException) {
            ((FirebaseAuthUserCollisionException) exception).zza(zzaeVar.zzd);
        }
        return WorkContinuation.forException(exception);
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public void zza(int i, long j) {
        ((zzk) this.sharedPreferences).zzj.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public void zzb(int i, long j, String str) {
        ((zzk) this.sharedPreferences).zzj.zze(i, System.currentTimeMillis() - j, str);
    }

    public zzeh zzk() {
        zzeh zzehVar = zzfr.zzp((Service) this.sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        return zzehVar;
    }

    public /* synthetic */ ProfileCache(Object obj, int i) {
        this.$r8$classId = i;
        this.sharedPreferences = obj;
    }

    public static void createAllTables(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        frameworkSQLiteProgram.execSQL(yzwzcWHcnH.lnbLof);
        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        frameworkSQLiteProgram.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        frameworkSQLiteProgram.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        frameworkSQLiteProgram.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    public static RoomOpenHelper.ValidationResult onValidateSchema(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        HashMap map = new HashMap(2);
        map.put("work_spec_id", new TableInfo.Column(1, "work_spec_id", "TEXT", null, true, 1));
        map.put("prerequisite_id", new TableInfo.Column(2, "prerequisite_id", "TEXT", null, true, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new TableInfo.ForeignKey(bUqMCsuPSX.UJRccOoqtxHrvT, "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
        hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
        TableInfo tableInfo = new TableInfo("Dependency", map, hashSet, hashSet2);
        TableInfo tableInfo2 = TableInfo.read(frameworkSQLiteProgram, "Dependency");
        if (!tableInfo.equals(tableInfo2)) {
            return new RoomOpenHelper.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
        HashMap map2 = new HashMap(25);
        map2.put("id", new TableInfo.Column(1, "id", "TEXT", null, true, 1));
        map2.put("state", new TableInfo.Column(0, "state", "INTEGER", null, true, 1));
        map2.put("worker_class_name", new TableInfo.Column(0, "worker_class_name", "TEXT", null, true, 1));
        map2.put("input_merger_class_name", new TableInfo.Column(0, "input_merger_class_name", "TEXT", null, false, 1));
        map2.put("input", new TableInfo.Column(0, "input", "BLOB", null, true, 1));
        map2.put("output", new TableInfo.Column(0, "output", "BLOB", null, true, 1));
        map2.put("initial_delay", new TableInfo.Column(0, "initial_delay", "INTEGER", null, true, 1));
        map2.put("interval_duration", new TableInfo.Column(0, "interval_duration", "INTEGER", null, true, 1));
        map2.put("flex_duration", new TableInfo.Column(0, "flex_duration", "INTEGER", null, true, 1));
        map2.put("run_attempt_count", new TableInfo.Column(0, "run_attempt_count", "INTEGER", null, true, 1));
        map2.put("backoff_policy", new TableInfo.Column(0, QTaELkFI.HAOgTVkpQcwZ, "INTEGER", null, true, 1));
        map2.put(gZrKCJ.tmpFXnvivZ, new TableInfo.Column(0, "backoff_delay_duration", TSDAbK.gxkMT, null, true, 1));
        map2.put("period_start_time", new TableInfo.Column(0, "period_start_time", "INTEGER", null, true, 1));
        map2.put("minimum_retention_duration", new TableInfo.Column(0, "minimum_retention_duration", "INTEGER", null, true, 1));
        map2.put("schedule_requested_at", new TableInfo.Column(0, "schedule_requested_at", "INTEGER", null, true, 1));
        map2.put("run_in_foreground", new TableInfo.Column(0, "run_in_foreground", "INTEGER", null, true, 1));
        map2.put("out_of_quota_policy", new TableInfo.Column(0, "out_of_quota_policy", "INTEGER", null, true, 1));
        map2.put("required_network_type", new TableInfo.Column(0, "required_network_type", "INTEGER", null, false, 1));
        map2.put("requires_charging", new TableInfo.Column(0, "requires_charging", "INTEGER", null, true, 1));
        map2.put("requires_device_idle", new TableInfo.Column(0, "requires_device_idle", "INTEGER", null, true, 1));
        map2.put(dLDI.tKT, new TableInfo.Column(0, "requires_battery_not_low", jIKWv.pRpnlbooS, null, true, 1));
        map2.put("requires_storage_not_low", new TableInfo.Column(0, "requires_storage_not_low", "INTEGER", null, true, 1));
        map2.put("trigger_content_update_delay", new TableInfo.Column(0, "trigger_content_update_delay", "INTEGER", null, true, 1));
        map2.put("trigger_max_content_delay", new TableInfo.Column(0, "trigger_max_content_delay", "INTEGER", null, true, 1));
        map2.put("content_uri_triggers", new TableInfo.Column(0, "content_uri_triggers", "BLOB", null, false, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
        hashSet4.add(new TableInfo.Index("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
        TableInfo tableInfo3 = new TableInfo("WorkSpec", map2, hashSet3, hashSet4);
        TableInfo tableInfo4 = TableInfo.read(frameworkSQLiteProgram, "WorkSpec");
        if (!tableInfo3.equals(tableInfo4)) {
            return new RoomOpenHelper.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
        }
        HashMap map3 = new HashMap(2);
        map3.put("tag", new TableInfo.Column(1, "tag", "TEXT", null, true, 1));
        map3.put("work_spec_id", new TableInfo.Column(2, "work_spec_id", "TEXT", null, true, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
        TableInfo tableInfo5 = new TableInfo("WorkTag", map3, hashSet5, hashSet6);
        TableInfo tableInfo6 = TableInfo.read(frameworkSQLiteProgram, "WorkTag");
        if (!tableInfo5.equals(tableInfo6)) {
            return new RoomOpenHelper.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
        }
        HashMap map4 = new HashMap(2);
        map4.put("work_spec_id", new TableInfo.Column(1, "work_spec_id", "TEXT", null, true, 1));
        map4.put("system_id", new TableInfo.Column(0, "system_id", "INTEGER", null, true, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        TableInfo tableInfo7 = new TableInfo("SystemIdInfo", map4, hashSet7, new HashSet(0));
        TableInfo tableInfo8 = TableInfo.read(frameworkSQLiteProgram, "SystemIdInfo");
        if (!tableInfo7.equals(tableInfo8)) {
            return new RoomOpenHelper.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
        }
        HashMap map5 = new HashMap(2);
        map5.put("name", new TableInfo.Column(1, "name", eoBKjVuj.hOYltgLlW, null, true, 1));
        map5.put("work_spec_id", new TableInfo.Column(2, "work_spec_id", "TEXT", null, true, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
        TableInfo tableInfo9 = new TableInfo("WorkName", map5, hashSet8, hashSet9);
        TableInfo tableInfo10 = TableInfo.read(frameworkSQLiteProgram, "WorkName");
        if (!tableInfo9.equals(tableInfo10)) {
            return new RoomOpenHelper.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
        }
        HashMap map6 = new HashMap(2);
        map6.put("work_spec_id", new TableInfo.Column(1, "work_spec_id", "TEXT", null, true, 1));
        map6.put("progress", new TableInfo.Column(0, "progress", "BLOB", null, true, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        TableInfo tableInfo11 = new TableInfo("WorkProgress", map6, hashSet10, new HashSet(0));
        TableInfo tableInfo12 = TableInfo.read(frameworkSQLiteProgram, "WorkProgress");
        if (!tableInfo11.equals(tableInfo12)) {
            return new RoomOpenHelper.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
        }
        HashMap map7 = new HashMap(2);
        map7.put("key", new TableInfo.Column(1, "key", ehgOP.bbGjTjQ, null, true, 1));
        map7.put("long_value", new TableInfo.Column(0, "long_value", "INTEGER", null, false, 1));
        TableInfo tableInfo13 = new TableInfo("Preference", map7, new HashSet(0), new HashSet(0));
        TableInfo tableInfo14 = TableInfo.read(frameworkSQLiteProgram, "Preference");
        if (tableInfo13.equals(tableInfo14)) {
            return new RoomOpenHelper.ValidationResult(true, (String) null);
        }
        return new RoomOpenHelper.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
    }

    public ProfileCache(zzo zzoVar) {
        this.$r8$classId = 22;
        Objects.requireNonNull(zzoVar);
        this.sharedPreferences = zzoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public ListenableFuture zza() {
        zzau zzauVar = (zzau) this.sharedPreferences;
        return zzauVar.zzR(zzauVar.zzg, null, "BANNER", null, null, 0, null, new Bundle(), null).zzb();
    }

    public ProfileCache(zzk zzkVar) {
        this.$r8$classId = 24;
        Objects.requireNonNull(zzkVar);
        this.sharedPreferences = zzkVar;
    }

    public ProfileCache(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 15:
                this.sharedPreferences = new HashMap();
                break;
            default:
                SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)");
                this.sharedPreferences = sharedPreferences;
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqh
    public void zza(zzaqm zzaqmVar) {
        ((zzcak) this.sharedPreferences).zzd(zzaqmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    public void zza(zzfua zzfuaVar) {
        zzo zzoVar = (zzo) this.sharedPreferences;
        zzoVar.getClass();
        if (!TextUtils.isEmpty(zzfuaVar.zzb())) {
            if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlU)).booleanValue()) {
                zzoVar.zza = zzfuaVar.zzb();
            }
        }
        switch (zzfuaVar.zza()) {
            case 8152:
                zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(zzoVar, "onLMDOverlayOpened", new HashMap(), 10, false));
                break;
            case 8153:
                zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(zzoVar, "onLMDOverlayClicked", new HashMap(), 10, false));
                break;
            case 8155:
                zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(zzoVar, "onLMDOverlayClose", new HashMap(), 10, false));
                break;
            case 8157:
                zzoVar.zza = null;
                zzoVar.zzb = null;
                zzoVar.zzh = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzfuaVar.zza()));
                zzcaf.zzf.execute(new WorkerWrapper.AnonymousClass1(zzoVar, "onLMDOverlayFailedToOpen", map, 10, false));
                break;
        }
    }

    public ProfileCache(String str, Bundle bundle) {
        Uri uriBuildUri;
        this.$r8$classId = 19;
        bundle = bundle == null ? new Bundle() : bundle;
        GamingAction[] gamingActionArrValuesCustom = GamingAction.valuesCustom();
        ArrayList arrayList = new ArrayList(gamingActionArrValuesCustom.length);
        for (GamingAction gamingAction : gamingActionArrValuesCustom) {
            arrayList.add(gamingAction.rawValue);
        }
        if (arrayList.contains(str)) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            uriBuildUri = Utility.buildUri(String.format("%s", Arrays.copyOf(new Object[]{"fb.gg"}, 1)), Intrinsics.stringPlus(str, "/dialog/"), bundle);
        } else {
            uriBuildUri = Utility.buildUri(Utility.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
        }
        this.sharedPreferences = uriBuildUri;
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    public void zza(String str, int i, IOException iOException, byte[] bArr, Map map) {
        ((zzkt) this.sharedPreferences).zzI(str, i, iOException, bArr, map);
    }

    public ProfileCache(final TextView textView) {
        this.$r8$classId = 10;
        this.sharedPreferences = new Okio(textView) { // from class: androidx.emoji2.viewsintegration.EmojiTextViewHelper$SkippingHelper19
            public final EmojiTextViewHelper$HelperInternal19 mHelperDelegate;

            {
                this.mHelperDelegate = new EmojiTextViewHelper$HelperInternal19(textView);
            }

            @Override // okio.Okio
            public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
                return !(EmojiCompat.sInstance != null) ? inputFilterArr : this.mHelperDelegate.getFilters(inputFilterArr);
            }

            @Override // okio.Okio
            public final void setAllCaps(boolean z) {
                if (EmojiCompat.sInstance != null) {
                    this.mHelperDelegate.setAllCaps(z);
                }
            }

            @Override // okio.Okio
            public final void setEnabled(boolean z) {
                boolean z2 = EmojiCompat.sInstance != null;
                EmojiTextViewHelper$HelperInternal19 emojiTextViewHelper$HelperInternal19 = this.mHelperDelegate;
                if (z2) {
                    emojiTextViewHelper$HelperInternal19.setEnabled(z);
                } else {
                    emojiTextViewHelper$HelperInternal19.mEnabled = z;
                }
            }
        };
    }

    public ProfileCache(Context context) {
        this.$r8$classId = 9;
        this.sharedPreferences = context.getApplicationContext();
    }

    public ProfileCache(Context context, Uri uri) {
        this.$r8$classId = 7;
        this.sharedPreferences = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }
}
