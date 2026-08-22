package com.yoyogames.runner;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.RemoteException;
import android.os.Trace;
import android.provider.Settings;
import android.util.Log;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Data;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import com.daerisoft.thespikerm.DemoGLSurfaceView;
import com.daerisoft.thespikerm.DemoRenderer;
import com.daerisoft.thespikerm.FirebaseAuthentication_tools;
import com.daerisoft.thespikerm.FirebaseAuthentication_tools$3$1;
import com.daerisoft.thespikerm.GamepadHandler_API12$GamepadInstance;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.R;
import com.daerisoft.thespikerm.RunnerActivity;
import com.daerisoft.thespikerm.RunnerKeyboardController;
import com.daerisoft.thespikerm.RunnerKeyboardController.AnonymousClass5;
import com.daerisoft.thespikerm.VideoPlayback;
import com.daerisoft.thespikerm.YYFirebaseSetup;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.facebook.ProfileCache;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import com.google.android.gms.ads.nonagon.signalgeneration.zzd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbmz;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzbxp;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzdsd;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.location.zzn;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzdx;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzjm;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.android.gms.tasks.zzg;
import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes3.dex */
public class RunnerJNILib {
    public static ClipboardManager mClipboard;
    public static int mCurrentRefreshRate;
    public static int mGameSpeedControl;
    public static int mMaxRefreshRateSupported;
    public static VideoPlayback mVideoPlayback;
    public static Context ms_context;
    public static boolean ms_exitcalled;
    public static boolean ms_loadLibraryFailed;
    public static MediaPlayer ms_mp;
    public static String ms_versionName;
    private static WifiManager.MulticastLock multicast_lock;

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$10 */
    public final class AnonymousClass10 implements Runnable {
        public final /* synthetic */ int $r8$classId = 1;
        public final /* synthetic */ int val$_timeout;
        public final /* synthetic */ int val$id;
        public final /* synthetic */ Object val$post;
        public final /* synthetic */ Object val$url;

        public AnonymousClass10(SystemForegroundService systemForegroundService, int i, Notification notification, int i2) {
            this.val$post = systemForegroundService;
            this.val$id = i;
            this.val$url = notification;
            this.val$_timeout = i2;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00d0 A[Catch: Exception -> 0x00df, TryCatch #1 {Exception -> 0x00df, blocks: (B:18:0x0050, B:19:0x0099, B:20:0x00a6, B:22:0x00ad, B:24:0x00b3, B:25:0x00b7, B:29:0x00cd, B:32:0x00d4, B:31:0x00d0, B:27:0x00c6), top: B:37:0x0050 }] */
        @Override // java.lang.Runnable
        public final void run() {
            HttpURLConnection httpURLConnection;
            byte[] byteArray;
            int i = this.val$_timeout;
            Object obj = this.val$post;
            int i2 = this.val$id;
            Object obj2 = this.val$url;
            switch (this.$r8$classId) {
                case 0:
                    String str = dLDI.gEubjpD;
                    String string = null;
                    try {
                        httpURLConnection = (HttpURLConnection) new URL((String) obj2).openConnection();
                    } catch (MalformedURLException unused) {
                        RunnerJNILib.HttpResultString("MalformedURLException", 404, i2);
                        httpURLConnection = null;
                    } catch (IOException unused2) {
                        RunnerJNILib.HttpResultString("IOException", 404, i2);
                        httpURLConnection = null;
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setConnectTimeout(i);
                            httpURLConnection.connect();
                            httpURLConnection.getOutputStream().write(((String) obj).getBytes("UTF-8"));
                            httpURLConnection.getOutputStream().flush();
                            httpURLConnection.getOutputStream().close();
                            int responseCode = httpURLConnection.getResponseCode();
                            Log.i(GooglePlayBillingService.TAG, str + responseCode + "'");
                            try {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i3 = inputStream.read(bArr);
                                    if (i3 == -1) {
                                        byteArray = byteArrayOutputStream.toByteArray();
                                        try {
                                            byteArrayOutputStream.close();
                                            inputStream.close();
                                            string = httpURLConnection.getURL().toString();
                                        } catch (IOException unused3) {
                                            Log.i(GooglePlayBillingService.TAG, "HttpPost: IO exception");
                                        }
                                        if (byteArray != null || byteArray.length == 0) {
                                            byteArray = new byte[]{0};
                                        }
                                        RunnerJNILib.HttpResult(byteArray, responseCode, i2, string, RunnerJNILib.HttpGetHeaders(httpURLConnection));
                                        httpURLConnection.disconnect();
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i3);
                                    }
                                    Log.i(GooglePlayBillingService.TAG, "HttpPost: IO exception");
                                    if (byteArray != null) {
                                        byteArray = new byte[]{0};
                                    } else {
                                        byteArray = new byte[]{0};
                                    }
                                    RunnerJNILib.HttpResult(byteArray, responseCode, i2, string, RunnerJNILib.HttpGetHeaders(httpURLConnection));
                                    httpURLConnection.disconnect();
                                }
                            } catch (IOException unused4) {
                                byteArray = null;
                            }
                        } catch (Exception unused5) {
                            RunnerJNILib.HttpResultString("IOException", 404, i2);
                            return;
                        }
                    }
                    break;
                case 1:
                    ((CustomTabsClient.AnonymousClass2) obj).val$callback.onActivityResized(i2, i, (Bundle) obj2);
                    break;
                default:
                    Notification notification = (Notification) obj2;
                    SystemForegroundService systemForegroundService = (SystemForegroundService) obj;
                    if (Build.VERSION.SDK_INT < 29) {
                        systemForegroundService.startForeground(i2, notification);
                    } else {
                        systemForegroundService.startForeground(i2, notification, i);
                    }
                    break;
            }
        }

        public AnonymousClass10(CustomTabsClient.AnonymousClass2 anonymousClass2, int i, int i2, Bundle bundle) {
            this.val$post = anonymousClass2;
            this.val$id = i;
            this.val$_timeout = i2;
            this.val$url = bundle;
        }

        public AnonymousClass10(String str, int i, int i2, String str2) {
            this.val$url = str;
            this.val$id = i;
            this.val$_timeout = i2;
            this.val$post = str2;
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$11 */
    public final class AnonymousClass11 implements Runnable {
        public final /* synthetic */ int val$_timeout;
        public final /* synthetic */ String val$headers;
        public final /* synthetic */ int val$id;
        public final /* synthetic */ String val$method;
        public final /* synthetic */ byte[] val$post;
        public final /* synthetic */ String val$url;

        public AnonymousClass11() {
            str = str;
            i = i;
            str = str;
            i = i;
            str = str;
            bArr = bArr;
        }

        /* JADX WARN: Code duplicated, block: B:43:0x010a A[Catch: Exception -> 0x0048, IOException -> 0x0105, TryCatch #2 {IOException -> 0x0105, blocks: (B:39:0x0100, B:43:0x010a, B:44:0x0113, B:46:0x011a, B:47:0x011e), top: B:66:0x0100 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x011a A[Catch: Exception -> 0x0048, IOException -> 0x0105, LOOP:1: B:44:0x0113->B:46:0x011a, LOOP_END, TryCatch #2 {IOException -> 0x0105, blocks: (B:39:0x0100, B:43:0x010a, B:44:0x0113, B:46:0x011a, B:47:0x011e), top: B:66:0x0100 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x013f  */
        /* JADX WARN: Code duplicated, block: B:56:0x0145 A[Catch: Exception -> 0x0048, SocketTimeoutException -> 0x009d, TryCatch #1 {SocketTimeoutException -> 0x009d, blocks: (B:24:0x0077, B:27:0x00b5, B:26:0x00a1, B:28:0x00b9, B:31:0x00c0, B:33:0x00c6, B:34:0x00db, B:54:0x0142, B:57:0x0149, B:56:0x0145, B:51:0x012a), top: B:64:0x0077 }] */
        /* JADX WARN: Code duplicated, block: B:77:0x011e A[EDGE_INSN: B:77:0x011e->B:47:0x011e BREAK  A[LOOP:1: B:44:0x0113->B:46:0x011a], SYNTHETIC] */
        @Override // java.lang.Runnable
        public final void run() {
            HttpURLConnection httpURLConnection;
            int i;
            InputStream errorStream;
            byte[] byteArray;
            ByteArrayOutputStream byteArrayOutputStream;
            byte[] bArr;
            int i2;
            String str = str;
            int i3 = i;
            int i4 = 404;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (MalformedURLException unused) {
                RunnerJNILib.HttpResultString("MalformedURLException", 404, i3);
                httpURLConnection = null;
            } catch (IOException unused2) {
                RunnerJNILib.HttpResultString("IOException", 404, i3);
                httpURLConnection = null;
            }
            if (httpURLConnection == null) {
                return;
            }
            try {
                try {
                    httpURLConnection.setDoInput(true);
                    if (str.equals("GET") || str.equals("HEAD")) {
                        httpURLConnection.setDoOutput(false);
                        Log.i(GooglePlayBillingService.TAG, "Setting do output to false");
                    } else {
                        Log.i(GooglePlayBillingService.TAG, "Setting do output to true");
                        httpURLConnection.setDoOutput(true);
                    }
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod(str);
                    httpURLConnection.setConnectTimeout(i);
                    String[] strArrSplit = str.split("\r\n");
                    int length = strArrSplit.length;
                    int i5 = 0;
                    while (i5 < length) {
                        String str2 = strArrSplit[i5];
                        String[] strArrSplit2 = str2.split(": ");
                        if (strArrSplit2.length == 2) {
                            try {
                                Log.i(GooglePlayBillingService.TAG, "HttpRequest: Found header " + strArrSplit2[0] + ": " + strArrSplit2[1]);
                                httpURLConnection.setRequestProperty(strArrSplit2[0], strArrSplit2[1]);
                            } catch (SocketTimeoutException unused3) {
                                i = 404;
                                Log.i(GooglePlayBillingService.TAG, "HttpRequest: request timed out");
                                RunnerJNILib.HttpResultString("HTTP request timed out", i, i3);
                                return;
                            }
                        } else {
                            Log.i(GooglePlayBillingService.TAG, "HttpRequest: Malformed header " + str2);
                        }
                        i5++;
                        i4 = 404;
                    }
                    httpURLConnection.connect();
                    byte[] bArr2 = bArr;
                    if (bArr2 != null && !str.equals("GET")) {
                        httpURLConnection.getOutputStream().write(bArr2);
                        httpURLConnection.getOutputStream().flush();
                        httpURLConnection.getOutputStream().close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i(GooglePlayBillingService.TAG, "HttpRequest: Got response code '" + responseCode + "'");
                    try {
                        errorStream = httpURLConnection.getInputStream();
                    } catch (IOException unused4) {
                        errorStream = null;
                    }
                    if (errorStream == null) {
                        try {
                            errorStream = httpURLConnection.getErrorStream();
                            if (errorStream != null) {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                bArr = new byte[4096];
                                while (true) {
                                    i2 = errorStream.read(bArr);
                                    if (i2 != -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i2);
                                    }
                                }
                                byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    errorStream.close();
                                } catch (IOException e) {
                                    e = e;
                                    Log.i(GooglePlayBillingService.TAG, "HttpRequest: IO exception:" + e);
                                }
                            } else {
                                byteArray = null;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            byteArray = null;
                            Log.i(GooglePlayBillingService.TAG, "HttpRequest: IO exception:" + e);
                            if (byteArray != null) {
                                byteArray = new byte[]{0};
                            } else {
                                byteArray = new byte[]{0};
                            }
                            RunnerJNILib.HttpResult(byteArray, responseCode, i3, httpURLConnection.getURL().toString(), RunnerJNILib.HttpGetHeaders(httpURLConnection));
                            httpURLConnection.disconnect();
                        }
                    } else if (errorStream != null) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        bArr = new byte[4096];
                        while (true) {
                            i2 = errorStream.read(bArr);
                            if (i2 != -1) {
                                break;
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                        }
                        byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        errorStream.close();
                    } else {
                        byteArray = null;
                    }
                    if (byteArray != null || byteArray.length == 0) {
                        byteArray = new byte[]{0};
                    }
                    RunnerJNILib.HttpResult(byteArray, responseCode, i3, httpURLConnection.getURL().toString(), RunnerJNILib.HttpGetHeaders(httpURLConnection));
                    httpURLConnection.disconnect();
                } catch (SocketTimeoutException unused5) {
                    i = i4;
                }
            } catch (Exception e3) {
                Log.i(GooglePlayBillingService.TAG, "HttpRequest: exception:" + e3);
                RunnerJNILib.HttpResultString("HTTP request exception", 404, i3);
            }
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$13 */
    public final class AnonymousClass13 implements Runnable {
        public final /* synthetic */ int val$flags;

        public AnonymousClass13() {
            i = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RunnerActivity.UIVisibilityFlags = i;
            RunnerActivity.CurrentActivity.setupUiVisibility();
            RunnerActivity.CurrentActivity.setupUiVisibilityDelayed();
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$14 */
    public final class AnonymousClass14 implements Runnable {
        public final /* synthetic */ boolean val$enable;

        public AnonymousClass14() {
            z = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (z) {
                RunnerActivity.CurrentActivity.getWindow().clearFlags(128);
            } else {
                RunnerActivity.CurrentActivity.getWindow().addFlags(128);
            }
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$2 */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$sNo;
        public final /* synthetic */ Object val$sText;
        public final /* synthetic */ Object val$sUrl;
        public final /* synthetic */ Object val$sYes;

        /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$2$2 */
        public final class DialogInterfaceOnClickListenerC00072 implements DialogInterface.OnClickListener {
            public final /* synthetic */ int $r8$classId;
            public final /* synthetic */ Object this$0;

            public /* synthetic */ DialogInterfaceOnClickListenerC00072(Object obj, int i) {
                this.$r8$classId = i;
                this.this$0 = obj;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                switch (this.$r8$classId) {
                    case 0:
                        RunnerJNILib.OpenURL((String) ((AnonymousClass2) this.this$0).val$sUrl);
                        break;
                    case 1:
                        ((AtomicInteger) this.this$0).set(i);
                        break;
                    case 2:
                        ((zzau) this.this$0).zzr();
                        break;
                    case 3:
                        zzs zzsVar = zzv.zza.zzd;
                        zzs.zzV((Context) this.this$0, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
                        break;
                    case 4:
                        RunnerJNILib.LoginResult("", "", ((AnonymousClass6) this.this$0).val$idDialog);
                        break;
                    case 5:
                        ((AnonymousClass3) this.this$0).val$latch.countDown();
                        break;
                    case 6:
                        RunnerJNILib.InputResult("OK", 1, ((AnonymousClass4) this.this$0).val$idDialog);
                        break;
                    case 7:
                        WorkerWrapper.AnonymousClass1 anonymousClass1 = (WorkerWrapper.AnonymousClass1) this.this$0;
                        RunnerActivity.InputStringResult = (String) anonymousClass1.val$runExpedited;
                        ((CountDownLatch) anonymousClass1.this$0).countDown();
                        break;
                    default:
                        AnonymousClass6 anonymousClass6 = (AnonymousClass6) this.this$0;
                        String str = anonymousClass6.val$sDefault;
                        RunnerActivity.InputStringResult = str;
                        RunnerJNILib.InputResult(str, 0, anonymousClass6.val$idDialog);
                        break;
                }
            }

            public DialogInterfaceOnClickListenerC00072(zzax zzaxVar, Context context) {
                this.$r8$classId = 3;
                this.this$0 = context;
                Objects.requireNonNull(zzaxVar);
            }
        }

        public /* synthetic */ AnonymousClass2(int i, String str, Object obj, Object obj2, Object obj3) {
            this.$r8$classId = i;
            this.val$sYes = obj;
            this.val$sText = str;
            this.val$sUrl = obj2;
            this.val$sNo = obj3;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00da -> B:117:0x00e2). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public final void run() {
            boolean zContains;
            byte[] bArrZzu = null;
            switch (this.$r8$classId) {
                case 0:
                    AlertDialog.Builder builder = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    builder.setMessage((String) this.val$sText).setCancelable(false).setPositiveButton((String) this.val$sYes, new DialogInterfaceOnClickListenerC00072(this, 0)).setNegativeButton((String) this.val$sNo, new AnonymousClass1(0));
                    builder.create().show();
                    return;
                case 1:
                    CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo) this.val$sText;
                    if (cascadingMenuInfo != null) {
                        ProfileCache profileCache = (ProfileCache) this.val$sNo;
                        ((CascadingMenuPopup) profileCache.sharedPreferences).mShouldCloseImmediately = true;
                        cascadingMenuInfo.menu.close(false);
                        ((CascadingMenuPopup) profileCache.sharedPreferences).mShouldCloseImmediately = false;
                    }
                    MenuItemImpl menuItemImpl = (MenuItemImpl) this.val$sYes;
                    if (menuItemImpl.isEnabled() && menuItemImpl.hasSubMenu()) {
                        ((MenuBuilder) this.val$sUrl).performItemAction(menuItemImpl, null, 4);
                        return;
                    }
                    return;
                case 2:
                    SettableFuture settableFuture = (SettableFuture) this.val$sUrl;
                    UUID uuid = (UUID) this.val$sText;
                    String string = uuid.toString();
                    Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                    String str = WorkProgressUpdater.TAG;
                    StringBuilder sb = new StringBuilder("Updating progress for ");
                    sb.append(uuid);
                    sb.append(" (");
                    Data data = (Data) this.val$sYes;
                    sb.append(data);
                    sb.append(")");
                    logger$LogcatLogger.debug(str, sb.toString(), new Throwable[0]);
                    WorkProgressUpdater workProgressUpdater = (WorkProgressUpdater) this.val$sNo;
                    WorkDatabase workDatabase = workProgressUpdater.mWorkDatabase;
                    WorkDatabase workDatabase2 = workProgressUpdater.mWorkDatabase;
                    workDatabase.beginTransaction();
                    try {
                        WorkSpec workSpec = workDatabase2.workSpecDao().getWorkSpec(string);
                        if (workSpec == null) {
                            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        if (workSpec.state == 2) {
                            WorkProgress workProgress = new WorkProgress(string, data);
                            Dispatcher dispatcherWorkProgressDao = workDatabase2.workProgressDao();
                            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) dispatcherWorkProgressDao.executorServiceOrNull;
                            workDatabase_Impl.assertNotSuspendingTransaction();
                            workDatabase_Impl.beginTransaction();
                            try {
                                ((WorkTagDao_Impl$1) dispatcherWorkProgressDao.readyAsyncCalls).insert(workProgress);
                                workDatabase_Impl.setTransactionSuccessful();
                                workDatabase_Impl.endTransaction();
                            } catch (Throwable th) {
                                workDatabase_Impl.endTransaction();
                                throw th;
                            }
                        } else {
                            Logger$LogcatLogger.get().warning(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.", new Throwable[0]);
                        }
                        settableFuture.set(null);
                        workDatabase2.setTransactionSuccessful();
                    } catch (Throwable th2) {
                        try {
                            Logger$LogcatLogger.get().error(WorkProgressUpdater.TAG, "Error updating Worker progress", th2);
                            settableFuture.setException(th2);
                        } finally {
                            workDatabase2.endTransaction();
                        }
                        break;
                    }
                    return;
                case 3:
                    Context context = (Context) this.val$sYes;
                    try {
                        new zzbbe(context, (String) this.val$sText, ((AdRequest) this.val$sUrl).zza, (AppOpenAd.AppOpenAdLoadCallback) this.val$sNo).zza();
                        return;
                    } catch (IllegalStateException e) {
                        zzbun.zza(context).zzh(e, "AppOpenAd.load");
                        return;
                    }
                case 4:
                    Context context2 = (Context) this.val$sYes;
                    try {
                        new zzbmz(context2, (String) this.val$sText).zza(((AdRequest) this.val$sUrl).zza, (InterstitialAdLoadCallback) this.val$sNo);
                        return;
                    } catch (IllegalStateException e2) {
                        zzbun.zza(context2).zzh(e2, "InterstitialAd.load");
                        return;
                    }
                case 5:
                    zzb zzbVar = (zzb) this.val$sYes;
                    String str2 = (String) this.val$sText;
                    com.google.android.gms.ads.nonagon.signalgeneration.zzau zzauVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzau) this.val$sUrl;
                    zzbze zzbzeVar = (zzbze) this.val$sNo;
                    zzd zzdVar = zzbVar.zzb;
                    zzdVar.zzk();
                    synchronized (zzdVar.zzd) {
                        zContains = zzdVar.zza.contains(str2);
                        break;
                    }
                    if (zContains || zzbVar.zze()) {
                        return;
                    }
                    zzauVar.zzf(new ObjectWrapper(zzbVar.zza), zzbzeVar, null);
                    return;
                case 6:
                    com.google.android.gms.ads.nonagon.signalgeneration.zzv zzvVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzv) this.val$sText;
                    zzdsd zzdsdVar = (zzdsd) this.val$sYes;
                    zzvVar.zzj(zzdsdVar, (ArrayDeque) this.val$sUrl, "to");
                    zzvVar.zzj(zzdsdVar, (ArrayDeque) this.val$sNo, "of");
                    return;
                case 7:
                    Context context3 = (Context) this.val$sYes;
                    try {
                        new zzbxe(context3, (String) this.val$sText).zza(((AdManagerAdRequest) this.val$sUrl).zza, (RewardedAdLoadCallback) this.val$sNo);
                        return;
                    } catch (IllegalStateException e3) {
                        zzbun.zza(context3).zzh(e3, "RewardedAd.loadAdManager");
                        return;
                    }
                case 8:
                    Context context4 = (Context) this.val$sYes;
                    try {
                        new zzbxe(context4, (String) this.val$sText).zza(((AdRequest) this.val$sUrl).zza, (RewardedAdLoadCallback) this.val$sNo);
                        return;
                    } catch (IllegalStateException e4) {
                        zzbun.zza(context4).zzh(e4, QTaELkFI.yaxKrVGHGbf);
                        return;
                    }
                case 9:
                    Context context5 = (Context) this.val$sYes;
                    try {
                        new zzbxp(context5, (String) this.val$sText).zza(((AdManagerAdRequest) this.val$sUrl).zza, (RewardedInterstitialAdLoadCallback) this.val$sNo);
                        return;
                    } catch (IllegalStateException e5) {
                        zzbun.zza(context5).zzh(e5, "RewardedInterstitialAdManager.load");
                        return;
                    }
                case 10:
                    Context context6 = (Context) this.val$sYes;
                    try {
                        new zzbxp(context6, (String) this.val$sText).zza(((AdRequest) this.val$sUrl).zza, (RewardedInterstitialAdLoadCallback) this.val$sNo);
                        return;
                    } catch (IllegalStateException e6) {
                        zzbun.zza(context6).zzh(e6, "RewardedInterstitialAd.load");
                        return;
                    }
                case 11:
                    zzjm zzjmVarZzt = ((zzfr) ((zzhx) this.val$sNo).mBuilder).zzt();
                    zzjmVarZzt.zzg();
                    zzjmVarZzt.zza();
                    zzjmVarZzt.zzR(new WorkForegroundUpdater.AnonymousClass1(zzjmVarZzt, (AtomicReference) this.val$sUrl, (String) this.val$sText, (String) this.val$sYes, zzjmVarZzt.zzO(false), 1));
                    return;
                case 12:
                    zzcf zzcfVar = (zzcf) this.val$sUrl;
                    zzjm zzjmVar = (zzjm) this.val$sNo;
                    zzfr zzfrVar = (zzfr) zzjmVar.mBuilder;
                    try {
                        try {
                            zzdx zzdxVar = zzjmVar.zzb;
                            if (zzdxVar == null) {
                                zzeh zzehVar = zzfrVar.zzm;
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zza("Discarding data. Failed to send event to service to bundle");
                                zzlb zzlbVar = zzfrVar.zzp;
                                zzfr.zzP(zzlbVar);
                                zzlbVar.zzS(zzcfVar, null);
                            } else {
                                bArrZzu = zzdxVar.zzu((zzaw) this.val$sYes, (String) this.val$sText);
                                zzjmVar.zzQ();
                                zzlb zzlbVar2 = zzfrVar.zzp;
                                zzfr.zzP(zzlbVar2);
                                zzlbVar2.zzS(zzcfVar, bArrZzu);
                            }
                        } catch (RemoteException e7) {
                            zzeh zzehVar2 = zzfrVar.zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzd.zzb(e7, "Failed to send event to the service to bundle");
                            zzlb zzlbVar3 = zzfrVar.zzp;
                            zzfr.zzP(zzlbVar3);
                            zzlbVar3.zzS(zzcfVar, bArrZzu);
                        }
                        return;
                    } catch (Throwable th3) {
                        zzlb zzlbVar4 = zzfrVar.zzp;
                        zzfr.zzP(zzlbVar4);
                        zzlbVar4.zzS(zzcfVar, bArrZzu);
                        throw th3;
                    }
                case 13:
                    zzjm zzjmVarZzt2 = ((AppMeasurementDynamiteService) this.val$sNo).zza.zzt();
                    zzjmVarZzt2.zzg();
                    zzjmVarZzt2.zza();
                    zzfr zzfrVar2 = (zzfr) zzjmVarZzt2.mBuilder;
                    zzlb zzlbVar5 = zzfrVar2.zzp;
                    zzfr.zzP(zzlbVar5);
                    int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(((zzfr) zzlbVar5.mBuilder).zze, 12451000);
                    zzcf zzcfVar2 = (zzcf) this.val$sYes;
                    if (iIsGooglePlayServicesAvailable == 0) {
                        zzjmVarZzt2.zzR(new AnonymousClass2(zzjmVarZzt2, (zzaw) this.val$sUrl, (String) this.val$sText, zzcfVar2));
                        return;
                    }
                    zzeh zzehVar3 = zzfrVar2.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzg.zza("Not bundling data. Service unavailable or out of date");
                    zzlb zzlbVar6 = zzfrVar2.zzp;
                    zzfr.zzP(zzlbVar6);
                    zzlbVar6.zzS(zzcfVar2, new byte[0]);
                    return;
                default:
                    zzjm zzjmVarZzt3 = ((AppMeasurementDynamiteService) this.val$sNo).zza.zzt();
                    zzjmVarZzt3.zzg();
                    zzjmVarZzt3.zza();
                    zzjmVarZzt3.zzR(new WorkForegroundUpdater.AnonymousClass1(zzjmVarZzt3, (String) this.val$sText, (String) this.val$sYes, zzjmVarZzt3.zzO(false), (zzcf) this.val$sUrl, 2));
                    return;
            }
        }

        public AnonymousClass2(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, zzaw zzawVar, String str) {
            this.$r8$classId = 13;
            this.val$sNo = appMeasurementDynamiteService;
            this.val$sYes = zzcfVar;
            this.val$sUrl = zzawVar;
            this.val$sText = str;
        }

        public AnonymousClass2(zzjm zzjmVar, zzaw zzawVar, String str, zzcf zzcfVar) {
            this.$r8$classId = 12;
            this.val$sNo = zzjmVar;
            this.val$sYes = zzawVar;
            this.val$sText = str;
            this.val$sUrl = zzcfVar;
        }

        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Serializable serializable, Serializable serializable2, int i) {
            this.$r8$classId = i;
            this.val$sText = obj;
            this.val$sYes = obj2;
            this.val$sUrl = serializable;
            this.val$sNo = serializable2;
        }

        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Object obj3, Object obj4, int i) {
            this.$r8$classId = i;
            this.val$sNo = obj;
            this.val$sText = obj2;
            this.val$sYes = obj3;
            this.val$sUrl = obj4;
        }

        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, String str, String str2, int i) {
            this.$r8$classId = i;
            this.val$sNo = obj;
            this.val$sUrl = obj2;
            this.val$sText = str;
            this.val$sYes = str2;
        }

        /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$2$1 */
        public final class AnonymousClass1 implements DialogInterface.OnClickListener {
            public final /* synthetic */ int $r8$classId;

            public /* synthetic */ AnonymousClass1(int i) {
                this.$r8$classId = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                switch (this.$r8$classId) {
                    case 0:
                        dialogInterface.cancel();
                        break;
                    case 1:
                        RunnerActivity.CurrentActivity.finish();
                        break;
                }
            }

            private final void onClick$com$google$android$gms$ads$internal$util$zzai(DialogInterface dialogInterface, int i) {
            }
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$3 */
    public final class AnonymousClass3 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ CountDownLatch val$latch;
        public final /* synthetic */ String val$sMessage;

        public /* synthetic */ AnonymousClass3(String str, CountDownLatch countDownLatch, int i) {
            this.$r8$classId = i;
            this.val$sMessage = str;
            this.val$latch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    AlertDialog.Builder builder = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    builder.setMessage(this.val$sMessage).setCancelable(false).setPositiveButton("OK", new AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, 5));
                    builder.create().show();
                    break;
                default:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    final int i = 0;
                    builder2.setMessage(this.val$sMessage).setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener(this) { // from class: com.yoyogames.runner.RunnerJNILib$7$1
                        public final /* synthetic */ RunnerJNILib.AnonymousClass3 this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            switch (i) {
                                case 0:
                                    RunnerActivity.ShowQuestionYesNo = 1;
                                    this.this$0.val$latch.countDown();
                                    break;
                                default:
                                    RunnerActivity.ShowQuestionYesNo = 0;
                                    this.this$0.val$latch.countDown();
                                    break;
                            }
                        }
                    });
                    final int i2 = 1;
                    builder2.setNegativeButton("No", new DialogInterface.OnClickListener(this) { // from class: com.yoyogames.runner.RunnerJNILib$7$1
                        public final /* synthetic */ RunnerJNILib.AnonymousClass3 this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            switch (i2) {
                                case 0:
                                    RunnerActivity.ShowQuestionYesNo = 1;
                                    this.this$0.val$latch.countDown();
                                    break;
                                default:
                                    RunnerActivity.ShowQuestionYesNo = 0;
                                    this.this$0.val$latch.countDown();
                                    break;
                            }
                        }
                    });
                    builder2.create().show();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$4 */
    public final class AnonymousClass4 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ int val$idDialog;
        public final /* synthetic */ String val$sMessage;

        public /* synthetic */ AnonymousClass4(String str, int i, int i2) {
            this.$r8$classId = i2;
            this.val$sMessage = str;
            this.val$idDialog = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    AlertDialog.Builder builder = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    builder.setMessage(this.val$sMessage).setCancelable(false).setPositiveButton("OK", new AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, 6));
                    builder.create().show();
                    break;
                default:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    final int i = 0;
                    builder2.setMessage(this.val$sMessage).setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener(this) { // from class: com.yoyogames.runner.RunnerJNILib$8$1
                        public final /* synthetic */ RunnerJNILib.AnonymousClass4 this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            switch (i) {
                                case 0:
                                    RunnerJNILib.InputResult("1", 1, this.this$0.val$idDialog);
                                    break;
                                default:
                                    RunnerJNILib.InputResult("0", 0, this.this$0.val$idDialog);
                                    break;
                            }
                        }
                    });
                    final int i2 = 1;
                    builder2.setNegativeButton("No", new DialogInterface.OnClickListener(this) { // from class: com.yoyogames.runner.RunnerJNILib$8$1
                        public final /* synthetic */ RunnerJNILib.AnonymousClass4 this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            switch (i2) {
                                case 0:
                                    RunnerJNILib.InputResult("1", 1, this.this$0.val$idDialog);
                                    break;
                                default:
                                    RunnerJNILib.InputResult("0", 0, this.this$0.val$idDialog);
                                    break;
                            }
                        }
                    });
                    builder2.create().show();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$6 */
    public final class AnonymousClass6 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ int val$idDialog;
        public final /* synthetic */ String val$sDefault;
        public final /* synthetic */ String val$sMessage;

        public /* synthetic */ AnonymousClass6(int i, int i2, String str, String str2) {
            this.$r8$classId = i2;
            this.val$sDefault = str;
            this.val$sMessage = str2;
            this.val$idDialog = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    AlertDialog.Builder builder = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    EditText editText = new EditText(RunnerJNILib.ms_context);
                    editText.setText(this.val$sDefault);
                    builder.setView(editText);
                    builder.setMessage(this.val$sMessage).setCancelable(false).setPositiveButton("OK", new RunnerJNILib$5$1(this, editText, 2));
                    builder.setNegativeButton("Cancel", new AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, 8));
                    builder.create().show();
                    break;
                default:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(RunnerActivity.CurrentActivity);
                    View viewInflate = LayoutInflater.from(RunnerActivity.CurrentActivity).inflate(R.layout.userpasslayout, (ViewGroup) null);
                    builder2.setView(viewInflate);
                    final EditText editText2 = (EditText) viewInflate.findViewById(R.id.username);
                    final EditText editText3 = (EditText) viewInflate.findViewById(R.id.password);
                    editText2.setText(this.val$sDefault);
                    editText3.setText(this.val$sMessage);
                    builder2.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.yoyogames.runner.RunnerJNILib$12$1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            StringBuilder sb = new StringBuilder();
                            EditText editText4 = editText2;
                            sb.append(editText4.getText().toString());
                            sb.append('#');
                            sb.append(editText3.getText().toString());
                            RunnerJNILib.LoginResult(sb.toString(), editText4.getText().toString(), this.this$0.val$idDialog);
                        }
                    });
                    builder2.setNegativeButton("Cancel", new AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, 4));
                    builder2.create().show();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$9 */
    public final class AnonymousClass9 implements Runnable {
        public final /* synthetic */ int val$_timeout;
        public final /* synthetic */ int val$id;
        public final /* synthetic */ String val$url;

        public AnonymousClass9() {
            str = str;
            i = i;
            i = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HttpURLConnection httpURLConnection;
            InputStream errorStream;
            InputStream inputStream;
            byte[] bArr;
            int i = i;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (MalformedURLException unused) {
                RunnerJNILib.HttpResultString("MalformedURLException", 404, i);
                httpURLConnection = null;
            } catch (IOException unused2) {
                RunnerJNILib.HttpResultString("IOException", 404, i);
                httpURLConnection = null;
            }
            if (httpURLConnection == null) {
                return;
            }
            try {
                httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.connect();
                String string = httpURLConnection.getURL().toString();
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    errorStream = httpURLConnection.getInputStream();
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 == -1) {
                            inputStream.close();
                            Log.i(GooglePlayBillingService.TAG, "http_get responseCode=" + responseCode + ", id=" + i + ", finalurl=" + string + " headers=" + RunnerJNILib.HttpGetHeaders(httpURLConnection));
                            RunnerJNILib.HttpResult(null, responseCode, i, string, RunnerJNILib.HttpGetHeaders(httpURLConnection));
                            httpURLConnection.disconnect();
                            return;
                        }
                        RunnerJNILib.HttpProgress(bArr, i2, i, string, "", httpURLConnection.getContentLength());
                        bArr = bArr;
                    }
                } catch (IOException unused3) {
                    errorStream = httpURLConnection.getErrorStream();
                }
                inputStream = errorStream;
                bArr = new byte[4096];
            } catch (Exception e) {
                Log.i(GooglePlayBillingService.TAG, "Exception = " + e.toString());
                RunnerJNILib.HttpResultString("IOException", 404, i);
            }
        }
    }

    public static void AcquireMulticastLock() {
        if (multicast_lock == null) {
            WifiManager.MulticastLock multicastLockCreateMulticastLock = ((WifiManager) ms_context.getApplicationContext().getSystemService("wifi")).createMulticastLock("RunnerJNILib");
            multicast_lock = multicastLockCreateMulticastLock;
            multicastLockCreateMulticastLock.setReferenceCounted(true);
        }
        multicast_lock.acquire();
    }

    public static native void BackKeyLongPressEvent();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Class[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static Object CallExtensionFunction(String str, String str2, int i, Object[] objArr) {
        Class<?> cls;
        Object objInvoke = 0;
        objInvoke = 0;
        objInvoke = 0;
        objInvoke = 0;
        objInvoke = 0;
        if (RunnerActivity.mExtension == null) {
            Log.i(GooglePlayBillingService.TAG, "Attempting to call extension function with no extensions loaded " + str2 + " on class " + str);
            return null;
        }
        if (str != null) {
            try {
                if (str2 != null) {
                    try {
                        cls = Class.forName("com.daerisoft.thespikerm.".concat(str));
                    } catch (ClassNotFoundException unused) {
                        Log.i(GooglePlayBillingService.TAG, "Extension Class not found: com.daerisoft.thespikerm." + str + " attempting to call " + str2);
                        cls = null;
                    }
                    if (cls != null) {
                        int i2 = 0;
                        while (true) {
                            Object[] objArr2 = RunnerActivity.mExtension;
                            if (i2 >= objArr2.length) {
                                break;
                            }
                            Object obj = objArr2[i2];
                            if (obj != null && cls.isInstance(obj)) {
                                if (i > 0) {
                                    Class<?>[] clsArr = new Class[i];
                                    for (int i3 = 0; i3 < i; i3++) {
                                        clsArr[i3] = objArr[i3].getClass();
                                    }
                                    try {
                                        Method method = RunnerActivity.mExtension[i2].getClass().getMethod(str2, clsArr);
                                        Log.i(GooglePlayBillingService.TAG, "Method found, attempting to invoke " + str2);
                                        objInvoke = method.invoke(RunnerActivity.mExtension[i2], objArr);
                                        break;
                                    } catch (Exception e) {
                                        Log.i(GooglePlayBillingService.TAG, "Exception thrown calling method on extension class:" + e + " looking for " + str2 + " on " + str + " " + e.getMessage());
                                        for (int i4 = 0; i4 < i; i4++) {
                                            Log.i(GooglePlayBillingService.TAG, "Argument " + i4 + " of type " + clsArr[i4].toString());
                                        }
                                        e.printStackTrace();
                                        for (Method method2 : RunnerActivity.mExtension[i2].getClass().getMethods()) {
                                            Log.i(GooglePlayBillingService.TAG, "Found method " + method2.toString());
                                        }
                                        i2++;
                                        objInvoke = objInvoke;
                                    }
                                } else {
                                    try {
                                        objInvoke = RunnerActivity.mExtension[i2].getClass().getMethod(str2, objInvoke).invoke(RunnerActivity.mExtension[i2], objInvoke);
                                        break;
                                    } catch (Exception e2) {
                                        Log.i(GooglePlayBillingService.TAG, "Exception thrown calling argfree method on extension class:" + e2 + " looking for " + str2 + " on " + str + " " + e2.getMessage());
                                        e2.printStackTrace();
                                        i2++;
                                        objInvoke = objInvoke;
                                    }
                                }
                            }
                            i2++;
                            objInvoke = objInvoke;
                        }
                    }
                    return objInvoke;
                }
            } catch (Exception e3) {
                StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Exception thrown trying to call method ", str2, " on ", str, " ");
                sbM22m.append(e3.getMessage());
                Log.i(GooglePlayBillingService.TAG, sbM22m.toString());
                e3.printStackTrace();
            }
        }
        if (str == null) {
            Log.i(GooglePlayBillingService.TAG, "Attempting to call extension function with null classname method:" + str2);
        } else if (str2 == null) {
            Log.i(GooglePlayBillingService.TAG, "Attempting to call extension function with null methodname on class:".concat(str));
        }
        return null;
    }

    public static native boolean ChangeInitialScreenFrequency();

    public static int CheckPermission(String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && (str.equals("android.permission.WRITE_EXTERNAL_STORAGE") || str.equals("android.permission.READ_EXTERNAL_STORAGE"))) {
            return Environment.isExternalStorageManager() ? 1 : 0;
        }
        if (i >= 24 && str.equals("android.permission.POST_NOTIFICATIONS")) {
            return ((NotificationManager) RunnerActivity.CurrentActivity.getSystemService("notification")).areNotificationsEnabled() ? 1 : 0;
        }
        ms_context.getPackageManager();
        if (ContextCompat.checkSelfPermission(RunnerActivity.CurrentActivity, str) == 0) {
            Log.i(GooglePlayBillingService.TAG, "permission granted: " + str);
            return 1;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(RunnerActivity.CurrentActivity, str)) {
            Log.i(GooglePlayBillingService.TAG, "permission denied but not prevented from asking: " + str);
            return 0;
        }
        Log.i(GooglePlayBillingService.TAG, "permission denied and shouldn't be requested: " + str);
        return -1;
    }

    public static void ClearGamepads() {
    }

    public static native void CloudResultData(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void CloudResultString(String str, int i, int i2);

    public static native void CreateAsynEventWithDSMap(int i, int i2);

    public static native int CreateVersionDSMap(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z);

    public static native void DsMapAddDouble(int i, String str, double d);

    public static native void DsMapAddString(int i, String str, String str2);

    public static void DumpUsedMemory() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        Log.i(GooglePlayBillingService.TAG, String.format(Locale.US, "App Memory: Pss=%.2f MB\nPrivate=%.2f MB\nShared=%.2f MB", Double.valueOf(((double) memoryInfo.getTotalPss()) / 1024.0d), Double.valueOf(((double) memoryInfo.getTotalPrivateDirty()) / 1024.0d), Double.valueOf(((double) memoryInfo.getTotalSharedDirty()) / 1024.0d)));
    }

    public static int DynamicAssetExists(String str) {
        try {
            InputStream inputStreamOpen = ms_context.getAssets().open(str.toLowerCase(Locale.ROOT));
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
                return 1;
            }
        } catch (IOException unused) {
        }
        Log.i(GooglePlayBillingService.TAG, "Failed to find asset:" + str);
        return 0;
    }

    public static ByteBuffer[] EnumerateCertificates() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        ArrayList arrayList = new ArrayList();
        KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
        keyStore.load(null);
        Enumeration<String> enumerationAliases = keyStore.aliases();
        while (enumerationAliases.hasMoreElements()) {
            Certificate certificate = keyStore.getCertificate(enumerationAliases.nextElement());
            if (certificate.getType().equals("X.509")) {
                byte[] encoded = ((X509Certificate) certificate).getEncoded();
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(encoded.length);
                byteBufferAllocateDirect.put(encoded, 0, encoded.length);
                arrayList.add(byteBufferAllocateDirect);
            }
        }
        return (ByteBuffer[]) arrayList.toArray(new ByteBuffer[0]);
    }

    public static void ExitApplication() {
        if (ms_exitcalled) {
            return;
        }
        Log.i(GooglePlayBillingService.TAG, "First exit application called");
        ms_exitcalled = true;
        RunnerActivity.ViewHandler.post(new AnonymousClass1(0));
    }

    public static native String[] ExpandCompressedFile(String str, String str2);

    public static int GLSupportsASTC() {
        return DemoGLSurfaceView.m_astcSupported;
    }

    public static float[] GamepadAxesValues(int i) {
        return null;
    }

    public static float[] GamepadButtonValues(int i) {
        return null;
    }

    public static boolean GamepadConnected(int i) {
        return false;
    }

    public static String GamepadDescription(int i) {
        return "";
    }

    public static int GamepadGMLMapping(int i, int i2) {
        return -1;
    }

    public static int GamepadsCount() {
        return 0;
    }

    public static Context GetApplicationContext() {
        return ms_context;
    }

    public static Object GetAssetManager() {
        try {
            return ms_context.getAssets();
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Exception:" + e.toString());
            return null;
        }
    }

    public static int GetDefaultFrameBuffer() {
        return DemoRenderer.m_defaultFrameBuffer;
    }

    public static native String GetSaveFileName(String str);

    public static String GetUDID() {
        String string = Settings.Secure.getString(ms_context.getContentResolver(), "android_id");
        return string == null ? "UDID NOT AVAILABLE" : string;
    }

    public static int HasVsyncHandler() {
        return RunnerActivity.CurrentActivity.vsyncHandler != null ? 1 : 0;
    }

    public static void HttpGet(String str, int i, int i2) {
        Log.i(GooglePlayBillingService.TAG, "HttpGet(\"" + str + "\", " + i + ")");
        new Thread(new Runnable() { // from class: com.yoyogames.runner.RunnerJNILib.9
            public final /* synthetic */ int val$_timeout;
            public final /* synthetic */ int val$id;
            public final /* synthetic */ String val$url;

            public AnonymousClass9() {
                str = str;
                i = i;
                i = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                HttpURLConnection httpURLConnection;
                InputStream errorStream;
                InputStream inputStream;
                byte[] bArr;
                int i3 = i;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (MalformedURLException unused) {
                    RunnerJNILib.HttpResultString("MalformedURLException", 404, i3);
                    httpURLConnection = null;
                } catch (IOException unused2) {
                    RunnerJNILib.HttpResultString("IOException", 404, i3);
                    httpURLConnection = null;
                }
                if (httpURLConnection == null) {
                    return;
                }
                try {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.connect();
                    String string = httpURLConnection.getURL().toString();
                    int responseCode = httpURLConnection.getResponseCode();
                    try {
                        errorStream = httpURLConnection.getInputStream();
                        while (true) {
                            int i4 = inputStream.read(bArr);
                            if (i4 == -1) {
                                inputStream.close();
                                Log.i(GooglePlayBillingService.TAG, "http_get responseCode=" + responseCode + ", id=" + i3 + ", finalurl=" + string + " headers=" + RunnerJNILib.HttpGetHeaders(httpURLConnection));
                                RunnerJNILib.HttpResult(null, responseCode, i3, string, RunnerJNILib.HttpGetHeaders(httpURLConnection));
                                httpURLConnection.disconnect();
                                return;
                            }
                            RunnerJNILib.HttpProgress(bArr, i4, i, string, "", httpURLConnection.getContentLength());
                            bArr = bArr;
                        }
                    } catch (IOException unused3) {
                        errorStream = httpURLConnection.getErrorStream();
                    }
                    inputStream = errorStream;
                    bArr = new byte[4096];
                } catch (Exception e) {
                    Log.i(GooglePlayBillingService.TAG, "Exception = " + e.toString());
                    RunnerJNILib.HttpResultString("IOException", 404, i3);
                }
            }
        }).start();
    }

    public static String HttpGetHeaders(HttpURLConnection httpURLConnection) {
        String str = "";
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            for (String str2 : entry.getValue()) {
                str = entry.getKey() != null ? str + entry.getKey() + ": " + str2 + "\r\n" : str + "nokey: " + str2 + "\r\n";
            }
        }
        return str;
    }

    public static void HttpPost(String str, String str2, int i, int i2) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("HttpPost(\"", str, "\", \"", str2, "\", ");
        sbM22m.append(i);
        sbM22m.append(")");
        Log.i(GooglePlayBillingService.TAG, sbM22m.toString());
        new Thread(new AnonymousClass10(str, i, i2, str2)).start();
    }

    public static native void HttpProgress(byte[] bArr, int i, int i2, String str, String str2, int i3);

    public static void HttpRequest(String str, String str2, String str3, byte[] bArr, int i, int i2) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("HttpRequest(\"", str, "\", \"", str2, "\", \"");
        sbM22m.append(bArr);
        sbM22m.append("\", ");
        sbM22m.append(i);
        sbM22m.append(")");
        Log.i(GooglePlayBillingService.TAG, sbM22m.toString());
        new Thread(new Runnable() { // from class: com.yoyogames.runner.RunnerJNILib.11
            public final /* synthetic */ int val$_timeout;
            public final /* synthetic */ String val$headers;
            public final /* synthetic */ int val$id;
            public final /* synthetic */ String val$method;
            public final /* synthetic */ byte[] val$post;
            public final /* synthetic */ String val$url;

            public AnonymousClass11() {
                str = str;
                i = i;
                str = str2;
                i = i2;
                str = str3;
                bArr = bArr;
            }

            /* JADX WARN: Code duplicated, block: B:43:0x010a A[Catch: Exception -> 0x0048, IOException -> 0x0105, TryCatch #2 {IOException -> 0x0105, blocks: (B:39:0x0100, B:43:0x010a, B:44:0x0113, B:46:0x011a, B:47:0x011e), top: B:66:0x0100 }] */
            /* JADX WARN: Code duplicated, block: B:46:0x011a A[Catch: Exception -> 0x0048, IOException -> 0x0105, LOOP:1: B:44:0x0113->B:46:0x011a, LOOP_END, TryCatch #2 {IOException -> 0x0105, blocks: (B:39:0x0100, B:43:0x010a, B:44:0x0113, B:46:0x011a, B:47:0x011e), top: B:66:0x0100 }] */
            /* JADX WARN: Code duplicated, block: B:52:0x013f  */
            /* JADX WARN: Code duplicated, block: B:56:0x0145 A[Catch: Exception -> 0x0048, SocketTimeoutException -> 0x009d, TryCatch #1 {SocketTimeoutException -> 0x009d, blocks: (B:24:0x0077, B:27:0x00b5, B:26:0x00a1, B:28:0x00b9, B:31:0x00c0, B:33:0x00c6, B:34:0x00db, B:54:0x0142, B:57:0x0149, B:56:0x0145, B:51:0x012a), top: B:64:0x0077 }] */
            /* JADX WARN: Code duplicated, block: B:77:0x011e A[EDGE_INSN: B:77:0x011e->B:47:0x011e BREAK  A[LOOP:1: B:44:0x0113->B:46:0x011a], SYNTHETIC] */
            @Override // java.lang.Runnable
            public final void run() {
                HttpURLConnection httpURLConnection;
                int i3;
                InputStream errorStream;
                byte[] byteArray;
                ByteArrayOutputStream byteArrayOutputStream;
                byte[] bArr2;
                int i4;
                String str4 = str;
                int i5 = i;
                int i6 = 404;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (MalformedURLException unused) {
                    RunnerJNILib.HttpResultString("MalformedURLException", 404, i5);
                    httpURLConnection = null;
                } catch (IOException unused2) {
                    RunnerJNILib.HttpResultString("IOException", 404, i5);
                    httpURLConnection = null;
                }
                if (httpURLConnection == null) {
                    return;
                }
                try {
                    try {
                        httpURLConnection.setDoInput(true);
                        if (str4.equals("GET") || str4.equals("HEAD")) {
                            httpURLConnection.setDoOutput(false);
                            Log.i(GooglePlayBillingService.TAG, "Setting do output to false");
                        } else {
                            Log.i(GooglePlayBillingService.TAG, "Setting do output to true");
                            httpURLConnection.setDoOutput(true);
                        }
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod(str4);
                        httpURLConnection.setConnectTimeout(i);
                        String[] strArrSplit = str.split("\r\n");
                        int length = strArrSplit.length;
                        int i7 = 0;
                        while (i7 < length) {
                            String str5 = strArrSplit[i7];
                            String[] strArrSplit2 = str5.split(": ");
                            if (strArrSplit2.length == 2) {
                                try {
                                    Log.i(GooglePlayBillingService.TAG, "HttpRequest: Found header " + strArrSplit2[0] + ": " + strArrSplit2[1]);
                                    httpURLConnection.setRequestProperty(strArrSplit2[0], strArrSplit2[1]);
                                } catch (SocketTimeoutException unused3) {
                                    i3 = 404;
                                    Log.i(GooglePlayBillingService.TAG, "HttpRequest: request timed out");
                                    RunnerJNILib.HttpResultString("HTTP request timed out", i3, i5);
                                    return;
                                }
                            } else {
                                Log.i(GooglePlayBillingService.TAG, "HttpRequest: Malformed header " + str5);
                            }
                            i7++;
                            i6 = 404;
                        }
                        httpURLConnection.connect();
                        byte[] bArr3 = bArr;
                        if (bArr3 != null && !str4.equals("GET")) {
                            httpURLConnection.getOutputStream().write(bArr3);
                            httpURLConnection.getOutputStream().flush();
                            httpURLConnection.getOutputStream().close();
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        Log.i(GooglePlayBillingService.TAG, "HttpRequest: Got response code '" + responseCode + "'");
                        try {
                            errorStream = httpURLConnection.getInputStream();
                        } catch (IOException unused4) {
                            errorStream = null;
                        }
                        if (errorStream == null) {
                            try {
                                errorStream = httpURLConnection.getErrorStream();
                                if (errorStream != null) {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    bArr2 = new byte[4096];
                                    while (true) {
                                        i4 = errorStream.read(bArr2);
                                        if (i4 != -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr2, 0, i4);
                                        }
                                    }
                                    byteArray = byteArrayOutputStream.toByteArray();
                                    try {
                                        byteArrayOutputStream.close();
                                        errorStream.close();
                                    } catch (IOException e) {
                                        e = e;
                                        Log.i(GooglePlayBillingService.TAG, "HttpRequest: IO exception:" + e);
                                    }
                                } else {
                                    byteArray = null;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                byteArray = null;
                                Log.i(GooglePlayBillingService.TAG, "HttpRequest: IO exception:" + e);
                                if (byteArray != null) {
                                    byteArray = new byte[]{0};
                                } else {
                                    byteArray = new byte[]{0};
                                }
                                RunnerJNILib.HttpResult(byteArray, responseCode, i5, httpURLConnection.getURL().toString(), RunnerJNILib.HttpGetHeaders(httpURLConnection));
                                httpURLConnection.disconnect();
                            }
                        } else if (errorStream != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            bArr2 = new byte[4096];
                            while (true) {
                                i4 = errorStream.read(bArr2);
                                if (i4 != -1) {
                                    break;
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i4);
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            errorStream.close();
                        } else {
                            byteArray = null;
                        }
                        if (byteArray != null || byteArray.length == 0) {
                            byteArray = new byte[]{0};
                        }
                        RunnerJNILib.HttpResult(byteArray, responseCode, i5, httpURLConnection.getURL().toString(), RunnerJNILib.HttpGetHeaders(httpURLConnection));
                        httpURLConnection.disconnect();
                    } catch (SocketTimeoutException unused5) {
                        i3 = i6;
                    }
                } catch (Exception e3) {
                    Log.i(GooglePlayBillingService.TAG, "HttpRequest: exception:" + e3);
                    RunnerJNILib.HttpResultString("HTTP request exception", 404, i5);
                }
            }
        }).start();
    }

    public static native void HttpResult(byte[] bArr, int i, int i2, String str, String str2);

    public static native void HttpResultString(String str, int i, int i2);

    public static void Init() {
        try {
            System.loadLibrary(GooglePlayBillingService.TAG);
        } catch (UnsatisfiedLinkError e) {
            Log.i(GooglePlayBillingService.TAG, "Unsatisfied link error - " + e);
            ms_loadLibraryFailed = true;
            ms_exitcalled = true;
        }
        ms_mp = null;
    }

    public static native void InputResult(String str, int i, int i2);

    public static String InputString(String str, String str2) {
        Log.i(GooglePlayBillingService.TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m("InputString(\"", str, "\", \"", str2, "\")"));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RunnerActivity.ViewHandler.post(new WorkerWrapper.AnonymousClass1(str2, str, countDownLatch, 27, false));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return RunnerActivity.InputStringResult;
    }

    public static native void KeyEvent(int i, int i2, int i3, int i4, int i5);

    public static void LeaveRating(String str, String str2, String str3, String str4) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("LeaveRating(", str, ", ", str2, ", ");
        sbM22m.append(str3);
        sbM22m.append(", ");
        sbM22m.append(str4);
        sbM22m.append(")");
        Log.i(GooglePlayBillingService.TAG, sbM22m.toString());
        RunnerActivity.ViewHandler.post(new AnonymousClass2((Object) str, (Object) str2, (Serializable) str4, (Serializable) str3, 0));
    }

    public static native void LoginResult(String str, String str2, int i);

    public static native void MouseButtonEvent(int i, boolean z);

    public static native void MouseMoveEvent(float f, float f2);

    public static native void MouseWheelEvent(float f);

    public static void MoveTaskToBack() {
        RunnerActivity.CurrentActivity.runOnUiThread(new AnonymousClass1(10));
    }

    public static native void OnDisplayFrequencyChanged();

    public static void OnKeyboardStringSet(int[] iArr) {
        RunnerActivity.ViewHandler.post(new zzg(iArr, 3));
    }

    public static native void OnVirtualKeyboardStatus(String str, int i);

    public static native void OnVirtualKeyboardTextInserted(int[] iArr, int i);

    public static void OpenURL(String str) {
        try {
            ms_context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "OpenURL failed: " + e);
        }
    }

    public static native void Pause(int i);

    public static native int Process(int i, int i2, float f, float f2, float f3, int i3, int i4, float f4);

    public static int PushCancelLocalNotification(int i) {
        Object objCallExtensionFunction = CallExtensionFunction("GooglePushNotificationsExtension", "pushCancelLocalNotification", 1, new Object[]{Integer.valueOf(i)});
        if (objCallExtensionFunction != null) {
            return ((Integer) objCallExtensionFunction).intValue();
        }
        return -1;
    }

    public static int PushGetLocalNotification(int i, int i2) {
        Object objCallExtensionFunction = CallExtensionFunction("GooglePushNotificationsExtension", "pushGetLocalNotification", 2, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (objCallExtensionFunction != null) {
            return ((Integer) objCallExtensionFunction).intValue();
        }
        return -1;
    }

    public static void PushLocalNotification(float f, String str, String str2, String str3) {
        CallExtensionFunction("GooglePushNotificationsExtension", "pushLocalNotification", 4, new Object[]{Float.valueOf(f), str, str2, str3});
    }

    public static void ReleaseMulticastLock() {
        multicast_lock.release();
    }

    public static native void RenderSplash(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static void RestrictOrientation(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        RunnerActivity.CurrentActivity.RestrictOrientation(z, z2, z3, z4, z5);
    }

    public static native void Resume(int i);

    public static native void SetKeyValue(int i, int i2, String str);

    public static void SetThreadPriority(int i) {
        Log.i(GooglePlayBillingService.TAG, "SetThreadPriority(" + i);
        Thread.currentThread().setPriority(i);
    }

    public static void ShowMessage(String str) {
        Log.i(GooglePlayBillingService.TAG, "ShowMessage(\"" + str + "\")");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RunnerActivity.ViewHandler.post(new AnonymousClass3(str, countDownLatch, 0));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public static void ShowMessageAsync(String str, int i) {
        Log.i(GooglePlayBillingService.TAG, "ShowMessageAsync(\"" + str + "\"," + i + ")");
        RunnerActivity.FocusOverride = true;
        RunnerActivity.ViewHandler.post(new AnonymousClass4(str, i, 0));
    }

    public static int ShowQuestion(String str) {
        Log.i(GooglePlayBillingService.TAG, "ShowQuestion(\"" + str + "\")");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        RunnerActivity.ShowQuestionYesNo = 0;
        RunnerActivity.ViewHandler.post(new AnonymousClass3(str, countDownLatch, 1));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return RunnerActivity.ShowQuestionYesNo;
    }

    public static void ShowQuestionAsync(String str, int i) {
        Log.i(GooglePlayBillingService.TAG, "ShowQuestionAsync(\"" + str + "\"," + i + ")");
        RunnerActivity.FocusOverride = true;
        RunnerActivity.ViewHandler.post(new AnonymousClass4(str, i, 1));
    }

    public static native void Startup(String str, String str2, String str3, int i, boolean z);

    public static native void TouchEvent(int i, int i2, float f, float f2, int i3);

    public static native boolean UpdateGameSpeed();

    public static int UsingGL2() {
        return DemoGLSurfaceView.m_usingGL2;
    }

    public static void VideoClose() {
        mVideoPlayback.VideoPlayback_Close();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x004c A[ORIG_RETURN, RETURN] */
    public static boolean VideoDraw(ByteBuffer byteBuffer) {
        double d;
        mVideoPlayback.getClass();
        try {
            TextureView textureView = VideoPlayback.mTextureView;
            if (textureView != null) {
                Bitmap bitmap = textureView.getBitmap(VideoPlayback.mMediaPlayer.getVideoWidth(), VideoPlayback.mMediaPlayer.getVideoHeight());
                if (bitmap != null) {
                    bitmap.copyPixelsToBuffer(byteBuffer);
                    d = 1.0d;
                } else {
                    Log.i(GooglePlayBillingService.TAG, "Null bitmap generated");
                }
                if (d >= 0.5d) {
                    return true;
                }
                return false;
            }
            Log.i(GooglePlayBillingService.TAG, "Surface View null when attempting to draw");
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Exception thrown trying to write to surface:" + e);
        }
        d = 0.0d;
        if (d >= 0.5d) {
            return true;
        }
        return false;
    }

    public static void VideoEnableLoop(double d) {
        VideoPlayback videoPlayback = mVideoPlayback;
        videoPlayback.getClass();
        boolean z = d >= 0.5d;
        try {
            videoPlayback.Looping = z;
            VideoPlayback.mMediaPlayer.setLooping(z);
        } catch (Exception unused) {
        }
    }

    public static double VideoGetDuration() {
        mVideoPlayback.getClass();
        if (!VideoPlayback.mInitialised) {
            return 0.0d;
        }
        try {
            return VideoPlayback.mMediaPlayer.getDuration();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static double VideoGetFormat() {
        mVideoPlayback.getClass();
        return 0;
    }

    public static double VideoGetPosition() {
        mVideoPlayback.getClass();
        if (!VideoPlayback.mInitialised) {
            return 0.0d;
        }
        try {
            return VideoPlayback.mMediaPlayer.getCurrentPosition();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static double VideoGetStatus() {
        return mVideoPlayback.player_status;
    }

    public static double VideoGetVolume() {
        return mVideoPlayback.volume;
    }

    public static double VideoH() {
        mVideoPlayback.getClass();
        if (!VideoPlayback.mInitialised) {
            return 0.0d;
        }
        try {
            return VideoPlayback.mMediaPlayer.getVideoHeight();
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Exception thrown attempting to get video height:" + e);
            return 0.0d;
        }
    }

    public static double VideoIsLooping() {
        return mVideoPlayback.Looping ? 1.0d : 0.0d;
    }

    public static void VideoOpen(String str) {
        VideoPlayback videoPlayback = mVideoPlayback;
        videoPlayback.getClass();
        RunnerActivity.CurrentActivity.runOnUiThread(new WorkerWrapper.AnonymousClass1(videoPlayback, videoPlayback, str, 9));
    }

    public static void VideoPause() {
        VideoPlayback videoPlayback = mVideoPlayback;
        videoPlayback.getClass();
        if (VideoPlayback.mInitialised) {
            try {
                videoPlayback.player_status = 3;
                VideoPlayback.mMediaPlayer.pause();
            } catch (Exception unused) {
            }
        }
    }

    public static void VideoResume() {
        mVideoPlayback.VideoPlayback_Resume();
    }

    public static void VideoSeekTo(double d) {
        VideoPlayback videoPlayback = mVideoPlayback;
        videoPlayback.getClass();
        if (VideoPlayback.mInitialised) {
            try {
                VideoPlayback.mMediaPlayer.pause();
                VideoPlayback.mMediaPlayer.seekTo((int) d);
                if (videoPlayback.player_status == 2) {
                    videoPlayback.VideoPlayback_Resume();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void VideoSetVolume(double d) {
        mVideoPlayback.volume = d;
        if (VideoPlayback.mInitialised) {
            float f = (float) d;
            VideoPlayback.mMediaPlayer.setVolume(f, f);
        }
    }

    public static double VideoStatus() {
        return mVideoPlayback.VideoPlayback_Status;
    }

    public static double VideoW() {
        mVideoPlayback.getClass();
        if (!VideoPlayback.mInitialised) {
            return 0.0d;
        }
        try {
            return VideoPlayback.mMediaPlayer.getVideoWidth();
        } catch (Exception e) {
            Log.i(GooglePlayBillingService.TAG, "Exception thrown attempting to get video width:" + e);
            return 0.0d;
        }
    }

    public static int VirtualKeyboardGetHeight() {
        RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = RunnerActivity.CurrentActivity.GetKeyboardController();
        if (runnerKeyboardControllerGetKeyboardController != null) {
            return runnerKeyboardControllerGetKeyboardController.m_currentKeyboardHeight;
        }
        return 0;
    }

    public static boolean VirtualKeyboardGetStatus() {
        RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = RunnerActivity.CurrentActivity.GetKeyboardController();
        if (runnerKeyboardControllerGetKeyboardController != null) {
            return runnerKeyboardControllerGetKeyboardController.m_virtualKeyboardActive;
        }
        return false;
    }

    public static void VirtualKeyboardToggle(boolean z, int i, int i2, int i3, boolean z2, int[] iArr) {
        RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = RunnerActivity.CurrentActivity.GetKeyboardController();
        if (runnerKeyboardControllerGetKeyboardController != null) {
            runnerKeyboardControllerGetKeyboardController.m_viewHandler.post(runnerKeyboardControllerGetKeyboardController.new AnonymousClass5(z, i, i3, z2, i2, iArr));
        }
    }

    public static void WaitForVsync() {
        long jNanoTime = System.nanoTime();
        int i = DemoRenderer.elapsedVsyncs;
        while (DemoRenderer.elapsedVsyncs != -1 && i == DemoRenderer.elapsedVsyncs) {
            if (System.nanoTime() - jNanoTime > 100000000) {
                Log.i(GooglePlayBillingService.TAG, "vsync timeout...");
                return;
            }
        }
    }

    public static native ByteBuffer bufferGetByteBuffer(int i);

    public static native ByteBuffer bufferResize(int i, int i2);

    public static native boolean canFlip();

    public static String clipboardGetText() {
        ClipData.Item itemAt;
        ClipboardManager clipboardManager = mClipboard;
        if (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip() == null || (itemAt = clipboardManager.getPrimaryClip().getItemAt(0)) == null || itemAt.getText() == null) {
            return null;
        }
        return itemAt.getText().toString();
    }

    public static boolean clipboardHasText() {
        ClipData.Item itemAt;
        ClipboardManager clipboardManager = mClipboard;
        return (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip() == null || (itemAt = clipboardManager.getPrimaryClip().getItemAt(0)) == null || itemAt.getText() == null || itemAt.getText().length() <= 0) ? false : true;
    }

    public static void clipboardSetText(String str) {
        ClipboardManager clipboardManager = mClipboard;
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("gm", str));
        }
    }

    public static void cloudStringSave(String str, String str2, int i) {
        Log.i(GooglePlayBillingService.TAG, "cloud_string_save() called when not logged in to appropriate service");
    }

    public static void cloudSynchronise(int i) {
        Log.i(GooglePlayBillingService.TAG, "cloudSynchronise called when not logged in to appropriate service");
    }

    public static native void dsListAddInt(int i, int i2);

    public static native void dsListAddString(int i, String str);

    public static native int dsListCreate();

    public static native int dsListGetSize(int i);

    public static native double dsListGetValueDouble(int i, int i2);

    public static native int dsListGetValueInt(int i, int i2);

    public static native String dsListGetValueString(int i, int i2);

    public static native void dsMapAddInt(int i, String str, int i2);

    public static native void dsMapAddString(int i, String str, String str2);

    public static native int dsMapCreate();

    public static native String extGetVersion(String str);

    public static native double extOptGetReal(String str, String str2);

    public static native String extOptGetString(String str, String str2);

    public static native int getGuiHeight();

    public static native int getGuiWidth();

    public static native void iCadeEventDispatch(int i, boolean z);

    public static native int initGLFuncs(int i);

    public static boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) ms_context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static native int jCreateDsMap(String[] strArr, String[] strArr2, double[] dArr);

    public static native void onGPDeviceAdded(int i, String str, String str2, int i2, int i3, int i4, int i5, int i6);

    public static native void onGPDeviceRemoved(int i);

    public static native void onGPKeyDown(int i, int i2);

    public static native void onGPKeyUp(int i, int i2);

    public static native void onGPNativeAxis(int i, int i2, float f);

    public static native void onGPNativeHat(int i, int i2, float f, float f2);

    public static native void onGamepadChange();

    public static void powersaveEnable(boolean z) {
        RunnerActivity.ViewHandler.post(new Runnable() { // from class: com.yoyogames.runner.RunnerJNILib.14
            public final /* synthetic */ boolean val$enable;

            public AnonymousClass14() {
                z = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (z) {
                    RunnerActivity.CurrentActivity.getWindow().clearFlags(128);
                } else {
                    RunnerActivity.CurrentActivity.getWindow().addFlags(128);
                }
            }
        });
    }

    public static native void registerGamepadConnected(int i, int i2, int i3);

    public static void setSystemUIVisibilityFlags(int i) {
        Log.i(GooglePlayBillingService.TAG, "Calling setSystemUIVisibilityFlags");
        RunnerActivity.ViewHandler.post(new Runnable() { // from class: com.yoyogames.runner.RunnerJNILib.13
            public final /* synthetic */ int val$flags;

            public AnonymousClass13() {
                i = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RunnerActivity.UIVisibilityFlags = i;
                RunnerActivity.CurrentActivity.setupUiVisibility();
                RunnerActivity.CurrentActivity.setupUiVisibilityDelayed();
            }
        });
    }

    public static void EnumerateGamepadDevices() {
        ArrayList arrayList;
        String str;
        String str2;
        int i;
        int i2;
        int i3 = 16;
        if (MapsKt__MapsKt.ms_GamepadHandler == null) {
            GamepadHandler_API19 gamepadHandler_API19 = new GamepadHandler_API19();
            gamepadHandler_API19.m_Gamepads = new ArrayList();
            MapsKt__MapsKt.ms_GamepadHandler = gamepadHandler_API19;
        }
        GamepadHandler_API19 gamepadHandler_API110 = MapsKt__MapsKt.ms_GamepadHandler;
        gamepadHandler_API110.getClass();
        int[] deviceIds = InputDevice.getDeviceIds();
        int i4 = 0;
        while (true) {
            int length = deviceIds.length;
            arrayList = gamepadHandler_API110.m_Gamepads;
            str = QTaELkFI.XjjOmmPjW;
            str2 = sgtsHsWT.MKz;
            if (i4 >= length) {
                break;
            }
            int i5 = deviceIds[i4];
            if (i5 >= 0 && gamepadHandler_API110.GetGamepad(i5) == null) {
                InputDevice device = InputDevice.getDevice(i5);
                int sources = device.getSources();
                if ((sources & 16) == i3 || (sources & 1025) == 1025 || (sources & 513) == 513) {
                    GamepadHandler_API12$GamepadInstance gamepadHandler_API12$GamepadInstance = new GamepadHandler_API12$GamepadInstance();
                    List<InputDevice.MotionRange> motionRanges = device.getMotionRanges();
                    Collections.sort(motionRanges, new zzn(1));
                    gamepadHandler_API12$GamepadInstance.idDevice = i5;
                    gamepadHandler_API12$GamepadInstance.name = device.getName();
                    String descriptor = device.getDescriptor();
                    if (descriptor == null || descriptor.isEmpty()) {
                        descriptor = device.getName();
                    }
                    gamepadHandler_API12$GamepadInstance.desc = descriptor;
                    gamepadHandler_API12$GamepadInstance.axes = new ArrayList();
                    gamepadHandler_API12$GamepadInstance.hats = new ArrayList();
                    gamepadHandler_API110.getClass();
                    gamepadHandler_API12$GamepadInstance.vendorId = device.getVendorId();
                    gamepadHandler_API12$GamepadInstance.productId = device.getProductId();
                    int[] iArr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 16, 1, 32768, 65536, 131072, 262144, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, -1, -1, -1, -1};
                    boolean[] zArrHasKeys = device.hasKeys(96, 97, 99, 100, 4, 110, TossType.TOSS_FIXED_MED_FOR_BEGINNER_VALUE, TossType.TOSS_NETUPC_VALUE, TossType.TOSS_SPOTLIGHT_VALUE, TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE, TossType.TOSS_OPEN_BALANCED_VALUE, 19, 20, 21, 22, 109, 23, TossType.TOSS_FIXED_LOW_FOR_BEGINNER_VALUE, TossType.TOSS_NETUPOPEN_VALUE, 98, 101, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203);
                    int i6 = 0;
                    for (int i7 = 0; i7 < 37; i7++) {
                        if (zArrHasKeys[i7]) {
                            i6 |= iArr[i7];
                        }
                    }
                    gamepadHandler_API12$GamepadInstance.buttonMask = i6;
                    for (InputDevice.MotionRange motionRange : motionRanges) {
                        if ((motionRange.getSource() & 16) != 0) {
                            if (motionRange.getAxis() == 15 || motionRange.getAxis() == 16) {
                                gamepadHandler_API12$GamepadInstance.hats.add(motionRange);
                            } else {
                                gamepadHandler_API12$GamepadInstance.axes.add(motionRange);
                            }
                        }
                    }
                    i = 16;
                    arrayList.add(gamepadHandler_API12$GamepadInstance);
                    onGPDeviceAdded(gamepadHandler_API12$GamepadInstance.idDevice, gamepadHandler_API12$GamepadInstance.name, gamepadHandler_API12$GamepadInstance.desc, gamepadHandler_API12$GamepadInstance.productId, gamepadHandler_API12$GamepadInstance.vendorId, gamepadHandler_API12$GamepadInstance.axes.size(), gamepadHandler_API12$GamepadInstance.hats.size() / 2, gamepadHandler_API12$GamepadInstance.buttonMask);
                    Log.i(GooglePlayBillingService.TAG, TSDAbK.mrQy + deviceIds[i4] + " name:" + gamepadHandler_API12$GamepadInstance.name + " desc:" + gamepadHandler_API12$GamepadInstance.desc + str2 + gamepadHandler_API12$GamepadInstance.productId + " vendorId:" + gamepadHandler_API12$GamepadInstance.vendorId + str + Integer.toHexString(gamepadHandler_API12$GamepadInstance.buttonMask) + " numHats:" + (gamepadHandler_API12$GamepadInstance.hats.size() / 2) + " numAxes:" + gamepadHandler_API12$GamepadInstance.axes.size());
                } else {
                    gamepadHandler_API110 = gamepadHandler_API110;
                    i2 = 1;
                    i = 16;
                }
                i4 += i2;
                i3 = i;
                gamepadHandler_API110 = gamepadHandler_API110;
            } else {
                i = i3;
            }
            i2 = 1;
            i4 += i2;
            i3 = i;
            gamepadHandler_API110 = gamepadHandler_API110;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            GamepadHandler_API12$GamepadInstance gamepadHandler_API12$GamepadInstance2 = (GamepadHandler_API12$GamepadInstance) arrayList.get(i8);
            int i9 = 0;
            while (i9 < deviceIds.length && gamepadHandler_API12$GamepadInstance2.idDevice != deviceIds[i9]) {
                i9++;
            }
            if (i9 == deviceIds.length) {
                arrayList2.add(Integer.valueOf(gamepadHandler_API12$GamepadInstance2.idDevice));
                Log.i(GooglePlayBillingService.TAG, "GAMEPAD :: removed device id:" + gamepadHandler_API12$GamepadInstance2.idDevice + " name:" + gamepadHandler_API12$GamepadInstance2.name + " desc:" + gamepadHandler_API12$GamepadInstance2.desc + str2 + gamepadHandler_API12$GamepadInstance2.productId + " vendorId:" + gamepadHandler_API12$GamepadInstance2.vendorId + str + Integer.toHexString(gamepadHandler_API12$GamepadInstance2.buttonMask) + " numHats:" + (gamepadHandler_API12$GamepadInstance2.hats.size() / 2) + " numAxes:" + gamepadHandler_API12$GamepadInstance2.axes.size());
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            int iIntValue = ((Integer) arrayList2.get(i10)).intValue();
            onGPDeviceRemoved(iIntValue);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (((GamepadHandler_API12$GamepadInstance) arrayList.get(i11)).idDevice == iIntValue) {
                    arrayList.remove(i11);
                    break;
                }
            }
        }
    }

    public static void InputStringAsync(String str, String str2, int i) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m(JuorMn.tNcvJKB, str, "\", \"", str2, "\",");
        sbM22m.append(i);
        sbM22m.append(")");
        Log.i(GooglePlayBillingService.TAG, sbM22m.toString());
        RunnerActivity.FocusOverride = true;
        RunnerActivity.ViewHandler.post(new AnonymousClass6(i, 0, str2, str));
    }

    public static int OsGetInfo() {
        String str = iafHZUfOuHNwvy.AdHbcKQyQjIPd;
        String property = System.getProperty("os.version", str);
        String property2 = System.getProperty("user.region", str);
        RunnerKeyboardController runnerKeyboardControllerGetKeyboardController = RunnerActivity.CurrentActivity.GetKeyboardController();
        return CreateVersionDSMap(Build.VERSION.SDK_INT, Build.VERSION.RELEASE, Build.MODEL, Build.DEVICE, Build.MANUFACTURER, Build.CPU_ABI, Build.CPU_ABI2, Build.BOOTLOADER, Build.BOARD, property, property2, ms_versionName, runnerKeyboardControllerGetKeyboardController != null ? runnerKeyboardControllerGetKeyboardController.m_physicalKeyboardConnected : false);
    }

    public static void RequestPermission(String str) {
        String str2 = iafHZUfOuHNwvy.zabHS;
        Log.i(GooglePlayBillingService.TAG, "requesting permission:" + str);
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 1) {
            ActivityCompat.requestPermissions(RunnerActivity.CurrentActivity, strArrSplit, 2296);
            return;
        }
        if (!strArrSplit[0].equals("android.permission.WRITE_EXTERNAL_STORAGE") || (!strArrSplit[1].equals("android.permission.READ_EXTERNAL_STORAGE") && (!strArrSplit[0].equals("android.permission.READ_EXTERNAL_STORAGE") || !strArrSplit[1].equals("android.permission.WRITE_EXTERNAL_STORAGE")))) {
            ActivityCompat.requestPermissions(RunnerActivity.CurrentActivity, strArrSplit, 2296);
            return;
        }
        if (Build.VERSION.SDK_INT < 30) {
            ActivityCompat.requestPermissions(RunnerActivity.CurrentActivity, strArrSplit, 2296);
            return;
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(str2 + RunnerActivity.CurrentActivity.getApplicationContext().getPackageName()));
            RunnerActivity.CurrentActivity.startActivityForResult(intent, 2296);
        } catch (Exception unused) {
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
            RunnerActivity.CurrentActivity.startActivityForResult(intent2, 2296);
        }
    }

    public static void ShowLogin(String str, String str2, int i) {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("LoginDialog(\"", str, "\", \"", str2, "\",");
        sbM22m.append(i);
        sbM22m.append(")");
        Log.i(bUqMCsuPSX.EZXAO, sbM22m.toString());
        RunnerActivity.FocusOverride = true;
        RunnerActivity.ViewHandler.post(new AnonymousClass6(i, 1, str, str2));
    }

    public static void Init(Context context) {
        ms_context = context;
        VideoPlayback videoPlayback = new VideoPlayback();
        videoPlayback.VideoPlayback_Status = -2;
        videoPlayback.Looping = false;
        videoPlayback.player_status = 0;
        videoPlayback.volume = 1.0d;
        mVideoPlayback = videoPlayback;
        mClipboard = (ClipboardManager) context.getSystemService("clipboard");
    }

    public static Object CallExtensionFunction(String str, String str2, int i, double[] dArr, Object[] objArr) throws ClassNotFoundException {
        Class<?> cls;
        Object obj;
        Class<?> cls2;
        Method method;
        Class<?>[] parameterTypes;
        Object obj2 = null;
        if (RunnerActivity.mExtension == null) {
            Log.i(GooglePlayBillingService.TAG, "Attempting to call extension function with no extensions loaded " + str2 + " on class " + str);
            return null;
        }
        if (str == null || str2 == null) {
            if (str == null) {
                Log.i(GooglePlayBillingService.TAG, "Attempting to call extension function with null classname method:" + str2);
                return null;
            }
            if (str2 != null) {
                return null;
            }
            Log.i(GooglePlayBillingService.TAG, "Attempting to call extension function with null methodname on class:".concat(str));
            return null;
        }
        try {
            try {
                cls = Class.forName("com.daerisoft.thespikerm.".concat(str));
            } catch (ClassNotFoundException unused) {
                Log.i(GooglePlayBillingService.TAG, "Extension Class not found: com.daerisoft.thespikerm." + str + " attempting to call " + str2);
                cls = null;
            } catch (Exception e) {
                e = e;
            }
            if (cls == null) {
                return null;
            }
            Object objInvoke = null;
            int i2 = 0;
            while (true) {
                try {
                    Object[] objArr2 = RunnerActivity.mExtension;
                    if (i2 >= objArr2.length) {
                        return objInvoke;
                    }
                    if (cls.isInstance(objArr2[i2])) {
                        if (i > 0) {
                            Class<?>[] clsArr = new Class[i];
                            Object[] objArr3 = new Object[i];
                            for (int i3 = 0; i3 < i; i3++) {
                                try {
                                    Object obj3 = objArr[i3];
                                    if (obj3 != null) {
                                        clsArr[i3] = obj3.getClass();
                                        objArr3[i3] = objArr[i3];
                                    } else {
                                        clsArr[i3] = Double.TYPE;
                                        objArr3[i3] = Double.valueOf(dArr[i3]);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    obj2 = objInvoke;
                                }
                            }
                            Method[] methods = cls.getMethods();
                            int length = methods.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length) {
                                    cls2 = cls;
                                    obj = objInvoke;
                                    method = null;
                                    break;
                                }
                                Method method2 = methods[i4];
                                if (str2.equals(method2.getName()) && (parameterTypes = method2.getParameterTypes()) != null) {
                                    cls2 = cls;
                                    if (parameterTypes.length == i) {
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= i) {
                                                obj = objInvoke;
                                                break;
                                            }
                                            obj = objInvoke;
                                            try {
                                                Class<?>[] clsArr2 = parameterTypes;
                                                if (!parameterTypes[i5].isAssignableFrom(clsArr[i5])) {
                                                    break;
                                                }
                                                i5++;
                                                objInvoke = obj;
                                                parameterTypes = clsArr2;
                                            } catch (Exception e3) {
                                                e = e3;
                                            }
                                        }
                                        if (i5 == i) {
                                            method = method2;
                                            break;
                                        }
                                    }
                                    i4++;
                                    cls = cls2;
                                    objInvoke = obj;
                                } else {
                                    cls2 = cls;
                                }
                                obj = objInvoke;
                                i4++;
                                cls = cls2;
                                objInvoke = obj;
                            }
                            if (method != null) {
                                try {
                                    objInvoke = method.invoke(RunnerActivity.mExtension[i2], objArr3);
                                } catch (InvocationTargetException e4) {
                                    Throwable targetException = e4.getTargetException();
                                    Log.i(GooglePlayBillingService.TAG, "InvocationTargetException thrown trying to call method " + str2 + " on " + str);
                                    Log.i(GooglePlayBillingService.TAG, "Target exception: " + targetException.getMessage() + ". Cause: " + targetException.getCause() + ". Stack trace: \n" + Log.getStackTraceString(targetException));
                                    for (Method method3 : RunnerActivity.mExtension[i2].getClass().getMethods()) {
                                        Log.i(GooglePlayBillingService.TAG, "Found method " + method3.toString());
                                    }
                                    objInvoke = obj;
                                } catch (Exception e5) {
                                    Log.i(GooglePlayBillingService.TAG, xPQrbOSWiEdU.fhxceCE + str2 + " on " + str);
                                    Log.i(GooglePlayBillingService.TAG, "Exception:" + e5.getMessage() + ". Details: " + e5.toString() + ". Stack trace:\n" + Log.getStackTraceString(e5));
                                    for (Method method4 : RunnerActivity.mExtension[i2].getClass().getMethods()) {
                                        Log.i(GooglePlayBillingService.TAG, "Found method " + method4.toString());
                                    }
                                    objInvoke = obj;
                                }
                            } else {
                                Log.i(GooglePlayBillingService.TAG, "Unable to find method to invoke matching methodname:" + str2 + " on class:" + str + " with params:");
                                for (int i6 = 0; i6 < i; i6++) {
                                    Log.i(GooglePlayBillingService.TAG, "param:" + i6 + ":" + clsArr[i6]);
                                }
                            }
                        } else {
                            cls2 = cls;
                            obj = objInvoke;
                            try {
                                Method method5 = RunnerActivity.mExtension[i2].getClass().getMethod(str2, null);
                                if (method5 == null) {
                                    Log.i(GooglePlayBillingService.TAG, "Can't find argfree method on extension class:");
                                } else {
                                    objInvoke = method5.invoke(RunnerActivity.mExtension[i2], null);
                                }
                            } catch (Exception e6) {
                                Log.i(GooglePlayBillingService.TAG, "Exception thrown trying to call " + str2 + " on class " + str + " with no arguments:" + e6.getMessage());
                                e6.printStackTrace();
                            }
                        }
                        i2++;
                        cls = cls2;
                    } else {
                        cls2 = cls;
                        obj = objInvoke;
                    }
                    objInvoke = obj;
                    i2++;
                    cls = cls2;
                } catch (Exception e7) {
                    e = e7;
                    obj = objInvoke;
                }
                obj2 = obj;
                Log.i(GooglePlayBillingService.TAG, "Exception thrown trying to call method " + str2 + " on " + str);
                Log.i(GooglePlayBillingService.TAG, e.getMessage());
                e.printStackTrace();
                return obj2;
            }
        } catch (Exception e8) {
            e = e8;
            obj2 = null;
        }
    }

    /* JADX INFO: renamed from: com.yoyogames.runner.RunnerJNILib$1 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    RunnerActivity.CurrentActivity.finish();
                    return;
                case 1:
                    try {
                        int i = TraceCompat.$r8$clinit;
                        Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                        if (EmojiCompat.sInstance != null) {
                            EmojiCompat.get().load();
                            break;
                        }
                        return;
                    } finally {
                        int i2 = TraceCompat.$r8$clinit;
                        Trace.endSection();
                    }
                case 2:
                    AlertDialog.Builder builder = new AlertDialog.Builder(RunnerJNILib.ms_context);
                    builder.setMessage("Unable to find library for this devices architecture, which is " + System.getProperty("os.arch") + ", ensure you have included the correct architecture in your APK").setCancelable(false).setPositiveButton("OK", new AnonymousClass2.AnonymousClass1(1));
                    builder.create().show();
                    return;
                case 3:
                    RunnerActivity.CurrentActivity.doSetup(DemoRenderer.m_apkFilePath);
                    return;
                case 4:
                    ((ViewGroup) FirebaseAuthentication_tools.activity.findViewById(android.R.id.content)).removeView(FirebaseAuthentication_tools.webView);
                    FirebaseAuthentication_tools.webView.destroy();
                    WebView unused = FirebaseAuthentication_tools.webView = null;
                    return;
                case 5:
                    try {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        ImageView unused2 = FirebaseAuthentication_tools.imageView = new ImageView(FirebaseAuthentication_tools.activity);
                        FirebaseAuthentication_tools.imageView.setLayoutParams(layoutParams);
                        FirebaseAuthentication_tools.imageView.setImageBitmap(BitmapFactory.decodeStream(FirebaseAuthentication_tools.activity.getAssets().open("WebView/img_close.png".toLowerCase())));
                        FirebaseAuthentication_tools.imageView.setOnClickListener(new FirebaseAuthentication_tools$3$1());
                        ((ViewGroup) FirebaseAuthentication_tools.activity.findViewById(android.R.id.content)).addView(FirebaseAuthentication_tools.imageView);
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                case 6:
                    ((ViewGroup) FirebaseAuthentication_tools.activity.findViewById(android.R.id.content)).removeView(FirebaseAuthentication_tools.imageView);
                    ImageView unused4 = FirebaseAuthentication_tools.imageView = null;
                    return;
                case 7:
                    return;
                case 8:
                    Process.killProcess(Process.myPid());
                    return;
                case 9:
                    FirebaseApp.initializeApp(YYFirebaseSetup.activity);
                    return;
                default:
                    RunnerActivity.CurrentActivity.moveTaskToBack(true);
                    return;
            }
        }

        private final void run$com$daerisoft$thespikerm$RunnerActivity$1() {
        }
    }
}
