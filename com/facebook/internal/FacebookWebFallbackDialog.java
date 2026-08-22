package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class FacebookWebFallbackDialog extends WebDialog {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean waitingForDialogToClose;

    public static void $r8$lambda$v9EGjTJ8hS0baGhjnyMXvUVUBYI(FacebookWebFallbackDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.cancel();
    }

    @Override // com.facebook.internal.WebDialog, android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        WebDialog.AnonymousClass1 anonymousClass1 = this.webView;
        if (!this.isPageFinished || this.isListenerCalled || anonymousClass1 == null || !anonymousClass1.isShown()) {
            super.cancel();
        } else {
            if (this.waitingForDialogToClose) {
                return;
            }
            this.waitingForDialogToClose = true;
            anonymousClass1.loadUrl(Intrinsics.stringPlus("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();", "javascript:"));
            new Handler(Looper.getMainLooper()).postDelayed(new AccessTokenManager$$ExternalSyntheticLambda0(this, 11), 1500L);
        }
    }

    @Override // com.facebook.internal.WebDialog
    public final Bundle parseResponseUri(String str) {
        Bundle urlQueryString = Utility.parseUrlQueryString(Uri.parse(str).getQuery());
        String string = urlQueryString.getString("bridge_args");
        urlQueryString.remove("bridge_args");
        if (!Utility.isNullOrEmpty(string)) {
            try {
                urlQueryString.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException unused) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            }
        }
        String string2 = urlQueryString.getString("method_results");
        urlQueryString.remove("method_results");
        if (!Utility.isNullOrEmpty(string2)) {
            try {
                urlQueryString.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(string2)));
            } catch (JSONException unused2) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            }
        }
        urlQueryString.remove("version");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        int iIntValue = 0;
        if (!CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            try {
                iIntValue = NativeProtocol.KNOWN_PROTOCOL_VERSIONS[0].intValue();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
            }
        }
        urlQueryString.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", iIntValue);
        return urlQueryString;
    }
}
