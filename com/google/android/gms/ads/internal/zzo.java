package com.google.android.gms.ads.internal;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzfdx;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzo extends WebViewClient {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object zza;

    public zzo(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        ProgressDialog progressDialog;
        switch (this.$r8$classId) {
            case 1:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                super.onPageFinished(view, url);
                WebDialog webDialog = (WebDialog) this.zza;
                if (!webDialog.isDetached && (progressDialog = webDialog.spinner) != null) {
                    progressDialog.dismiss();
                }
                FrameLayout frameLayout = webDialog.contentFrameLayout;
                if (frameLayout != null) {
                    frameLayout.setBackgroundColor(0);
                }
                WebDialog.AnonymousClass1 anonymousClass1 = webDialog.webView;
                if (anonymousClass1 != null) {
                    anonymousClass1.setVisibility(0);
                }
                ImageView imageView = webDialog.crossImageView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                webDialog.isPageFinished = true;
                break;
            default:
                super.onPageFinished(view, url);
                break;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap bitmap) {
        ProgressDialog progressDialog;
        switch (this.$r8$classId) {
            case 1:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.stringPlus(url, "Webview loading URL: ");
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                super.onPageStarted(view, url, bitmap);
                WebDialog webDialog = (WebDialog) this.zza;
                if (!webDialog.isDetached && (progressDialog = webDialog.spinner) != null) {
                    progressDialog.show();
                    break;
                }
                break;
            default:
                super.onPageStarted(view, url, bitmap);
                break;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        switch (this.$r8$classId) {
            case 0:
                zzu zzuVar = (zzu) this.zza;
                zzbk zzbkVar = zzuVar.zzg;
                if (zzbkVar != null) {
                    try {
                        zzbkVar.zzf(zzfdx.zzd(1, null, null));
                    } catch (RemoteException e) {
                        int i = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
                zzbk zzbkVar2 = zzuVar.zzg;
                if (zzbkVar2 != null) {
                    try {
                        zzbkVar2.zze(0);
                    } catch (RemoteException e2) {
                        int i2 = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                        return;
                    }
                }
                break;
            default:
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                break;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, String url) {
        int i;
        Object obj = this.zza;
        int iZzC = 0;
        switch (this.$r8$classId) {
            case 0:
                zzu zzuVar = (zzu) obj;
                if (url.startsWith(zzuVar.zzr())) {
                    return false;
                }
                if (url.startsWith("gmsg://noAdLoaded")) {
                    zzbk zzbkVar = zzuVar.zzg;
                    if (zzbkVar != null) {
                        try {
                            zzbkVar.zzf(zzfdx.zzd(3, null, null));
                        } catch (RemoteException e) {
                            int i2 = zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                        }
                        break;
                    }
                    zzbk zzbkVar2 = zzuVar.zzg;
                    if (zzbkVar2 != null) {
                        try {
                            zzbkVar2.zze(3);
                        } catch (RemoteException e2) {
                            int i3 = zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                        }
                        break;
                    }
                    zzuVar.zzX(0);
                    return true;
                }
                if (url.startsWith("gmsg://scriptLoadFailed")) {
                    zzbk zzbkVar3 = zzuVar.zzg;
                    if (zzbkVar3 != null) {
                        try {
                            zzbkVar3.zzf(zzfdx.zzd(1, null, null));
                        } catch (RemoteException e3) {
                            int i4 = zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e3);
                        }
                        break;
                    }
                    zzbk zzbkVar4 = zzuVar.zzg;
                    if (zzbkVar4 != null) {
                        try {
                            zzbkVar4.zze(0);
                        } catch (RemoteException e4) {
                            int i5 = zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e4);
                        }
                        break;
                    }
                    zzuVar.zzX(0);
                    return true;
                }
                boolean zStartsWith = url.startsWith("gmsg://adResized");
                Context context = zzuVar.zzd;
                if (zStartsWith) {
                    zzbk zzbkVar5 = zzuVar.zzg;
                    if (zzbkVar5 != null) {
                        try {
                            zzbkVar5.zzi();
                        } catch (RemoteException e5) {
                            int i6 = zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e5);
                        }
                        break;
                    }
                    String queryParameter = Uri.parse(url).getQueryParameter("height");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        try {
                            zzf zzfVar = zzbb.zzb.zzc;
                            iZzC = zzf.zzC(context, Integer.parseInt(queryParameter));
                            break;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    zzuVar.zzX(iZzC);
                    return true;
                }
                if (url.startsWith("gmsg://")) {
                    return true;
                }
                zzbk zzbkVar6 = zzuVar.zzg;
                if (zzbkVar6 != null) {
                    try {
                        zzbkVar6.zzc();
                        zzuVar.zzg.zzh();
                    } catch (RemoteException e6) {
                        int i7 = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e6);
                    }
                    break;
                }
                if (zzuVar.zzh != null) {
                    Uri uriZza = Uri.parse(url);
                    try {
                        uriZza = zzuVar.zzh.zza(uriZza, context, null, null);
                    } catch (zzavv e7) {
                        int i8 = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to process ad data", e7);
                    }
                    url = uriZza.toString();
                    break;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
                return true;
            default:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.stringPlus(url, "Redirect URL: ");
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Uri uri = Uri.parse(url);
                boolean z = uri.getPath() != null && Pattern.matches("^/(v\\d+\\.\\d+/)??dialog/.*", uri.getPath());
                WebDialog webDialog = (WebDialog) obj;
                if (!StringsKt__StringsKt.startsWith(url, webDialog.expectedRedirectUrl, false)) {
                    if (StringsKt__StringsKt.startsWith(url, "fbconnect://cancel", false)) {
                        webDialog.cancel();
                        return true;
                    }
                    if (!z && !StringsKt__StringsKt.contains$default(url, "touch")) {
                        try {
                            webDialog.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                            return true;
                        } catch (ActivityNotFoundException unused2) {
                        }
                    }
                    return false;
                }
                Bundle responseUri = webDialog.parseResponseUri(url);
                String string = responseUri.getString("error");
                if (string == null) {
                    string = responseUri.getString("error_type");
                }
                String string2 = responseUri.getString("error_msg");
                if (string2 == null) {
                    string2 = responseUri.getString("error_message");
                }
                if (string2 == null) {
                    string2 = responseUri.getString("error_description");
                }
                String string3 = responseUri.getString("error_code");
                if (string3 != null && !Utility.isNullOrEmpty(string3)) {
                    try {
                        i = Integer.parseInt(string3);
                    } catch (NumberFormatException unused3) {
                        i = -1;
                    }
                    break;
                } else {
                    i = -1;
                }
                if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i == -1) {
                    WebDialog.OnCompleteListener onCompleteListener = webDialog.onCompleteListener;
                    if (onCompleteListener == null || webDialog.isListenerCalled) {
                        return true;
                    }
                    webDialog.isListenerCalled = true;
                    onCompleteListener.onComplete(responseUri, null);
                    webDialog.dismiss();
                    return true;
                }
                if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    webDialog.cancel();
                    return true;
                }
                if (i == 4201) {
                    webDialog.cancel();
                    return true;
                }
                webDialog.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                return true;
        }
    }

    public zzo(WebDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this.zza = this$0;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError error) {
        switch (this.$r8$classId) {
            case 1:
                Intrinsics.checkNotNullParameter(webView, eoBKjVuj.WbtguqGkRcN);
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(error, "error");
                super.onReceivedSslError(webView, handler, error);
                handler.cancel();
                ((WebDialog) this.zza).sendErrorToListener(new FacebookDialogException(null, -11, null));
                break;
            default:
                super.onReceivedSslError(webView, handler, error);
                break;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int i, String description, String failingUrl) {
        switch (this.$r8$classId) {
            case 1:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
                super.onReceivedError(view, i, description, failingUrl);
                ((WebDialog) this.zza).sendErrorToListener(new FacebookDialogException(description, i, failingUrl));
                break;
            default:
                super.onReceivedError(view, i, description, failingUrl);
                break;
        }
    }
}
