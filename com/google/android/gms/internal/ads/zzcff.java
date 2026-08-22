package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzcff extends WebChromeClient {
    private final zzcfg zza;

    public zzcff(zzcfg zzcfgVar) {
        this.zza = zzcfgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcfg)) {
            return webView.getContext();
        }
        zzcfg zzcfgVar = (zzcfg) webView;
        Activity activityZzi = zzcfgVar.zzi();
        return activityZzi != null ? activityZzi : zzcfgVar.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcfg)) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = ((zzcfg) webView).zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzb();
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Tried to close an AdWebView not associated with an overlay.");
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage = consoleMessage.message();
        String strSourceId = consoleMessage.sourceId();
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("JS: ", strMessage, " (", strSourceId, ":"), consoleMessage.lineNumber(), ")");
        if (strM.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzcfe.zza[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg(strM);
        } else if (i == 2) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strM);
        } else if (i == 3 || i == 4 || i != 5) {
            int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strM);
        } else {
            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze(strM);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        zzcfg zzcfgVar = this.zza;
        if (zzcfgVar.zzH() != null) {
            webView2.setWebViewClient(zzcfgVar.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072L, j4) + j, 1048576L);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzcfg zzcfgVar = this.zza;
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
            if (com.google.android.gms.ads.internal.util.zzs.zzB(zzcfgVar.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                z = true;
            } else {
                com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
                if (com.google.android.gms.ads.internal.util.zzs.zzB(zzcfgVar.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zzbcv zzbcvVar = zzbde.zznC;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                callback.invoke(str, false, true);
            } else {
                callback.invoke(str, z, true);
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zznD)).booleanValue()) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("AdWebChromeClient.onGeolocationPermissionsShowPrompt()");
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzg();
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get ad overlay when hiding custom view.");
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        Activity activity = zzmVarZzL.zzb;
        FrameLayout frameLayout = new FrameLayout(activity);
        zzmVarZzL.zzh = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        zzmVarZzL.zzh.addView(view, -1, -1);
        activity.setContentView(zzmVarZzL.zzh);
        zzmVarZzL.zzs = true;
        zzmVarZzL.zzi = customViewCallback;
        zzmVarZzL.zzg = true;
        zzmVarZzL.zzA(i);
    }

    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        com.google.android.gms.ads.internal.zzb zzbVarZzd;
        try {
            zzcfg zzcfgVar = this.zza;
            if (zzcfgVar != null && zzcfgVar.zzN() != null && zzcfgVar.zzN().zzd() != null && (zzbVarZzd = zzcfgVar.zzN().zzd()) != null && !zzbVarZzd.zzc()) {
                zzbVarZzd.zzb("window." + str + "('" + str3 + "')");
                return false;
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.util.zzs.zzL(context);
            builderZzL.setTitle(str2);
            if (z) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                TextView textView = new TextView(context);
                textView.setText(str3);
                EditText editText = new EditText(context);
                editText.setText(str4);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                builderZzL.setView(linearLayout).setPositiveButton(R.string.ok, new zzcfd(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new zzcfc(jsPromptResult)).setOnCancelListener(new zzcfb(jsPromptResult)).create().show();
            } else {
                builderZzL.setMessage(str3).setPositiveButton(R.string.ok, new zzcfa(jsResult)).setNegativeButton(R.string.cancel, new zzcez(jsResult)).setOnCancelListener(new zzcey(jsResult)).create().show();
            }
            return true;
        } catch (WindowManager.BadTokenException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to display Dialog.", e);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
