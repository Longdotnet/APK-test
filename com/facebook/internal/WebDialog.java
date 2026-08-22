package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginTargetApp;
import com.google.android.gms.ads.internal.zzo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import kotlin.collections.ArraysKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WebDialog extends Dialog {
    public static volatile int webDialogTheme;
    public FrameLayout contentFrameLayout;
    public ImageView crossImageView;
    public String expectedRedirectUrl;
    public boolean isDetached;
    public boolean isListenerCalled;
    public boolean isPageFinished;
    public OnCompleteListener onCompleteListener;
    public ProgressDialog spinner;
    public final UploadStagingResourcesTask uploadTask;
    public String url;
    public AnonymousClass1 webView;
    public WindowManager.LayoutParams windowParams;

    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    public final class UploadStagingResourcesTask extends AsyncTask {
        public final String action;
        public Exception[] exceptions;
        public final Bundle parameters;
        public final /* synthetic */ WebDialog this$0;

        public UploadStagingResourcesTask(WebDialog this$0, String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.action = str;
            this.parameters = bundle;
            this.exceptions = new Exception[0];
        }

        @Override // android.os.AsyncTask
        public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    return doInBackground((Void[]) objArr);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                    return null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(this, th2);
                return null;
            }
        }

        public final void onPostExecute(String[] strArr) {
            Bundle bundle = this.parameters;
            WebDialog webDialog = this.this$0;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ProgressDialog progressDialog = webDialog.spinner;
                    if (progressDialog != null) {
                        progressDialog.dismiss();
                    }
                    Exception[] excArr = this.exceptions;
                    int length = excArr.length;
                    int i = 0;
                    while (i < length) {
                        Exception exc = excArr[i];
                        i++;
                        if (exc != null) {
                            webDialog.sendErrorToListener(exc);
                            return;
                        }
                    }
                    if (strArr == null) {
                        webDialog.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                        return;
                    }
                    List listAsList = ArraysKt.asList(strArr);
                    if (listAsList.contains(null)) {
                        webDialog.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                        return;
                    }
                    Utility.putJSONValueInBundle(bundle, new JSONArray((Collection) listAsList));
                    webDialog.url = Utility.buildUri(Utility.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, bundle).toString();
                    ImageView imageView = webDialog.crossImageView;
                    if (imageView == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    webDialog.setUpWebView((imageView.getDrawable().getIntrinsicWidth() / 2) + 1);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(this, th2);
            }
        }

        /* JADX WARN: Type inference failed for: r10v1, types: [com.facebook.internal.WebDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0] */
        public final String[] doInBackground(Void... p0) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return null;
                }
                try {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    String[] stringArray = this.parameters.getStringArray("media");
                    if (stringArray == null) {
                        return null;
                    }
                    final String[] strArr = new String[stringArray.length];
                    this.exceptions = new Exception[stringArray.length];
                    final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
                    ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
                    AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
                    try {
                        int length = stringArray.length - 1;
                        if (length >= 0) {
                            final int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                if (isCancelled()) {
                                    Iterator it = concurrentLinkedQueue.iterator();
                                    while (it.hasNext()) {
                                        ((GraphRequestAsyncTask) it.next()).cancel(true);
                                    }
                                    return null;
                                }
                                Uri uri = Uri.parse(stringArray[i]);
                                if (Utility.isWebUri(uri)) {
                                    strArr[i] = uri.toString();
                                    countDownLatch.countDown();
                                } else {
                                    ?? r10 = new GraphRequest.Callback() { // from class: com.facebook.internal.WebDialog$UploadStagingResourcesTask$$ExternalSyntheticLambda0
                                        @Override // com.facebook.GraphRequest.Callback
                                        public final void onCompleted(GraphResponse graphResponse) {
                                            int i3 = i;
                                            String[] strArr2 = strArr;
                                            WebDialog.UploadStagingResourcesTask this$0 = this;
                                            Intrinsics.checkNotNullParameter(this$0, "this$0");
                                            CountDownLatch countDownLatch2 = countDownLatch;
                                            try {
                                                FacebookRequestError facebookRequestError = graphResponse.error;
                                                String str = "Error staging photo.";
                                                if (facebookRequestError != null) {
                                                    String errorMessage = facebookRequestError.getErrorMessage();
                                                    if (errorMessage != null) {
                                                        str = errorMessage;
                                                    }
                                                    throw new FacebookGraphResponseException(graphResponse, str);
                                                }
                                                JSONObject jSONObject = graphResponse.graphObject;
                                                if (jSONObject == null) {
                                                    throw new FacebookException("Error staging photo.");
                                                }
                                                String strOptString = jSONObject.optString("uri");
                                                if (strOptString == null) {
                                                    throw new FacebookException("Error staging photo.");
                                                }
                                                strArr2[i3] = strOptString;
                                                countDownLatch2.countDown();
                                            } catch (Exception e) {
                                                this$0.exceptions[i3] = e;
                                            }
                                        }
                                    };
                                    Intrinsics.checkNotNullExpressionValue(uri, "uri");
                                    concurrentLinkedQueue.add(TextStreamsKt.newUploadStagingResourceWithImageRequest(currentAccessToken, uri, r10).executeAsync());
                                }
                                if (i2 <= length) {
                                    i = i2;
                                }
                            }
                        }
                        countDownLatch.await();
                        return strArr;
                    } catch (Exception unused) {
                        Iterator it2 = concurrentLinkedQueue.iterator();
                        while (it2.hasNext()) {
                            ((GraphRequestAsyncTask) it2.next()).cancel(true);
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                    return null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(this, th2);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    onPostExecute((String[]) obj);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(this, th2);
            }
        }
    }

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.valuesCustom().length];
            iArr[1] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.facebook.internal.WebDialog$setUpWebView$1, reason: invalid class name */
    public final class AnonymousClass1 extends WebView {
        @Override // android.webkit.WebView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            try {
                super.onWindowFocusChanged(z);
            } catch (NullPointerException unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebDialog(FragmentActivity fragmentActivity, String str, Bundle bundle, LoginTargetApp loginTargetApp, OnCompleteListener onCompleteListener) {
        Uri uriBuildUri;
        super(fragmentActivity, webDialogTheme);
        Validate.sdkInitialized();
        this.expectedRedirectUrl = "fbconnect://success";
        bundle = bundle == null ? new Bundle() : bundle;
        String str2 = Utility.isChromeOS(fragmentActivity) ? "fbconnect://chrome_os_success" : "fbconnect://success";
        this.expectedRedirectUrl = str2;
        bundle.putString("redirect_uri", str2);
        bundle.putString("display", "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", Arrays.copyOf(new Object[]{"16.0.0"}, 1)));
        this.onCompleteListener = onCompleteListener;
        if (str.equals(FirebaseAnalytics.Event.SHARE) && bundle.containsKey("media")) {
            this.uploadTask = new UploadStagingResourcesTask(this, str, bundle);
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[loginTargetApp.ordinal()] == 1) {
            uriBuildUri = Utility.buildUri(Utility.getInstagramDialogAuthority(), "oauth/authorize", bundle);
        } else {
            uriBuildUri = Utility.buildUri(Utility.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + ((Object) str), bundle);
        }
        this.url = uriBuildUri.toString();
    }

    public static int getScaledSize(int i, float f, int i2, int i3) {
        double d;
        int i4 = (int) (i / f);
        if (i4 <= i2) {
            d = 1.0d;
        } else {
            d = i4 >= i3 ? 0.5d : ((((double) (i3 - i4)) / ((double) (i3 - i2))) * 0.5d) + 0.5d;
        }
        return (int) (((double) i) * d);
    }

    public static final void initDefaultTheme(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = fragmentActivity.getPackageManager().getApplicationInfo(fragmentActivity.getPackageName(), 128);
            if ((applicationInfo == null ? null : applicationInfo.metaData) != null && webDialogTheme == 0) {
                int i = applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme");
                if (i == 0) {
                    i = R.style.com_facebook_activity_theme;
                }
                webDialogTheme = i;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        sendErrorToListener(new FacebookOperationCanceledException());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ProgressDialog progressDialog;
        AnonymousClass1 anonymousClass1 = this.webView;
        if (anonymousClass1 != null) {
            anonymousClass1.stopLoading();
        }
        if (!this.isDetached && (progressDialog = this.spinner) != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        AutofillManager autofillManagerM;
        WindowManager.LayoutParams layoutParams;
        WindowManager.LayoutParams attributes;
        this.isDetached = false;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (Build.VERSION.SDK_INT >= 26 && (autofillManagerM = Utility$$ExternalSyntheticApiModelOutline0.m(context.getSystemService(Utility$$ExternalSyntheticApiModelOutline0.m67m()))) != null && autofillManagerM.isAutofillSupported() && autofillManagerM.isEnabled() && (layoutParams = this.windowParams) != null && layoutParams.token == null) {
            Activity ownerActivity = getOwnerActivity();
            Window window = ownerActivity == null ? null : ownerActivity.getWindow();
            layoutParams.token = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
            WindowManager.LayoutParams layoutParams2 = this.windowParams;
            Intrinsics.stringPlus(layoutParams2 != null ? layoutParams2.token : null, "Set token on onAttachedToWindow(): ");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        ProgressDialog progressDialog2 = this.spinner;
        if (progressDialog2 != null) {
            progressDialog2.setMessage(getContext().getString(R.string.com_facebook_loading));
        }
        ProgressDialog progressDialog3 = this.spinner;
        if (progressDialog3 != null) {
            progressDialog3.setCanceledOnTouchOutside(false);
        }
        ProgressDialog progressDialog4 = this.spinner;
        if (progressDialog4 != null) {
            progressDialog4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.internal.WebDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    WebDialog this$0 = this.f$0;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.cancel();
                }
            });
        }
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(16);
        }
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new WebDialog$$ExternalSyntheticLambda2(this, 0));
        Drawable drawable = getContext().getResources().getDrawable(2131165287);
        ImageView imageView2 = this.crossImageView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
        ImageView imageView3 = this.crossImageView;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        if (this.url != null) {
            ImageView imageView4 = this.crossImageView;
            if (imageView4 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            setUpWebView((imageView4.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        }
        FrameLayout frameLayout2 = this.contentFrameLayout;
        if (frameLayout2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        setContentView(frameLayout2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (i == 4) {
            AnonymousClass1 anonymousClass1 = this.webView;
            if (anonymousClass1 != null && Intrinsics.areEqual(Boolean.valueOf(anonymousClass1.canGoBack()), Boolean.TRUE)) {
                AnonymousClass1 anonymousClass2 = this.webView;
                if (anonymousClass2 == null) {
                    return true;
                }
                anonymousClass2.goBack();
                return true;
            }
            cancel();
        }
        return super.onKeyDown(i, event);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            if ((uploadStagingResourcesTask == null ? null : uploadStagingResourcesTask.getStatus()) == AsyncTask.Status.PENDING) {
                if (uploadStagingResourcesTask != null) {
                    uploadStagingResourcesTask.execute(new Void[0]);
                }
                ProgressDialog progressDialog = this.spinner;
                if (progressDialog == null) {
                    return;
                }
                progressDialog.show();
                return;
            }
        }
        resize();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.token == null) {
            this.windowParams = params;
        }
        super.onWindowAttributesChanged(params);
    }

    public Bundle parseResponseUri(String str) {
        Uri uri = Uri.parse(str);
        Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
        urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
        return urlQueryString;
    }

    public final void resize() {
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = i < i2 ? i : i2;
        if (i < i2) {
            i = i2;
        }
        int iMin = Math.min(getScaledSize(i3, displayMetrics.density, 480, 800), displayMetrics.widthPixels);
        int iMin2 = Math.min(getScaledSize(i, displayMetrics.density, 800, 1280), displayMetrics.heightPixels);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(iMin, iMin2);
    }

    public final void sendErrorToListener(Exception exc) {
        if (this.onCompleteListener == null || this.isListenerCalled) {
            return;
        }
        this.isListenerCalled = true;
        FacebookException facebookException = exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc);
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(null, facebookException);
        }
        dismiss();
    }

    public final void setUpWebView(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(getContext());
        this.webView = anonymousClass1;
        anonymousClass1.setVerticalScrollBarEnabled(false);
        AnonymousClass1 anonymousClass2 = this.webView;
        if (anonymousClass2 != null) {
            anonymousClass2.setHorizontalScrollBarEnabled(false);
        }
        AnonymousClass1 anonymousClass3 = this.webView;
        if (anonymousClass3 != null) {
            anonymousClass3.setWebViewClient(new zzo(this));
        }
        AnonymousClass1 anonymousClass4 = this.webView;
        WebSettings settings = anonymousClass4 == null ? null : anonymousClass4.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        AnonymousClass1 anonymousClass5 = this.webView;
        if (anonymousClass5 != null) {
            String str = this.url;
            if (str == null) {
                throw new IllegalStateException("Required value was null.");
            }
            anonymousClass5.loadUrl(str);
        }
        AnonymousClass1 anonymousClass6 = this.webView;
        if (anonymousClass6 != null) {
            anonymousClass6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        AnonymousClass1 anonymousClass7 = this.webView;
        if (anonymousClass7 != null) {
            anonymousClass7.setVisibility(4);
        }
        AnonymousClass1 anonymousClass8 = this.webView;
        WebSettings settings2 = anonymousClass8 == null ? null : anonymousClass8.getSettings();
        if (settings2 != null) {
            settings2.setSavePassword(false);
        }
        AnonymousClass1 anonymousClass9 = this.webView;
        WebSettings settings3 = anonymousClass9 != null ? anonymousClass9.getSettings() : null;
        if (settings3 != null) {
            settings3.setSaveFormData(false);
        }
        AnonymousClass1 anonymousClass10 = this.webView;
        if (anonymousClass10 != null) {
            anonymousClass10.setFocusable(true);
        }
        AnonymousClass1 anonymousClass11 = this.webView;
        if (anonymousClass11 != null) {
            anonymousClass11.setFocusableInTouchMode(true);
        }
        AnonymousClass1 anonymousClass12 = this.webView;
        if (anonymousClass12 != null) {
            anonymousClass12.setOnTouchListener(new WebDialog$$ExternalSyntheticLambda0());
        }
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(-872415232);
        FrameLayout frameLayout = this.contentFrameLayout;
        if (frameLayout == null) {
            return;
        }
        frameLayout.addView(linearLayout);
    }
}
