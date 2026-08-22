package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.webkit.WebViewCompat;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.TextStreamsKt;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzcgf extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcfg {
    public static final /* synthetic */ int zza = 0;
    private final String zzA;
    private zzcgi zzB;
    private boolean zzC;
    private boolean zzD;
    private zzbgd zzE;
    private zzbgb zzF;
    private zzbaq zzG;
    private int zzH;
    private int zzI;
    private zzbdq zzJ;
    private final zzbdq zzK;
    private zzbdq zzL;
    private final zzbdr zzM;
    private int zzN;
    private com.google.android.gms.ads.internal.overlay.zzm zzO;
    private boolean zzP;
    private final com.google.android.gms.ads.internal.util.zzck zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private Map zzW;
    private final WindowManager zzX;
    private final zzbcc zzY;
    private boolean zzZ;
    private final zzchc zzb;
    private final zzavu zzc;
    private final zzfda zzd;
    private final zzbel zze;
    private final VersionInfoParcel zzf;
    private com.google.android.gms.ads.internal.zzn zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfca zzk;
    private zzfcd zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcfo zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzedh zzq;
    private zzedf zzr;
    private zzchd zzs;
    private final String zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private Boolean zzy;
    private boolean zzz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcgf(zzchc zzchcVar, zzchd zzchdVar, String str, boolean z, boolean z2, zzavu zzavuVar, zzbel zzbelVar, VersionInfoParcel versionInfoParcel, zzbdt zzbdtVar, com.google.android.gms.ads.internal.zzn zznVar, com.google.android.gms.ads.internal.zza zzaVar, zzbcc zzbccVar, zzfca zzfcaVar, zzfcd zzfcdVar, zzfda zzfdaVar) {
        zzfcd zzfcdVar2;
        super(zzchcVar);
        int i = 2;
        boolean z3 = false;
        this.zzm = false;
        this.zzn = false;
        this.zzz = true;
        this.zzA = "";
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzU = -1;
        this.zzV = -1;
        this.zzb = zzchcVar;
        this.zzs = zzchdVar;
        this.zzt = str;
        this.zzw = z;
        this.zzc = zzavuVar;
        this.zzd = zzfdaVar;
        this.zze = zzbelVar;
        this.zzf = versionInfoParcel;
        this.zzg = zznVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzX = windowManager;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.zzi = displayMetrics;
        this.zzj = displayMetrics.density;
        this.zzY = zzbccVar;
        this.zzk = zzfcaVar;
        this.zzl = zzfcdVar;
        this.zzQ = new com.google.android.gms.ads.internal.util.zzck(zzchcVar.zza(), this, this);
        this.zzZ = false;
        setBackgroundColor(0);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlZ)).booleanValue()) {
            setSoundEffectsEnabled(false);
        }
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        zzbcv zzbcvVar = zzbde.zzlY;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        zzbcv zzbcvVar2 = zzbde.zznB;
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
            settings.setGeolocationEnabled(false);
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        settings.setUserAgentString(zzvVar.zzd.zzc(zzchcVar, versionInfoParcel.afmaVersion));
        Context context = getContext();
        MapsKt__MapsKt.zza(context, new com.google.android.gms.ads.internal.zzh(settings, context, i, z3));
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzba();
        addJavascriptInterface(new zzcgm(this, new zzcgl(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbi();
        zzbdr zzbdrVar = new zzbdr(new zzbdt(true, "make_wv", this.zzt));
        this.zzM = zzbdrVar;
        Context contextCreatePackageContext = null;
        zzbdrVar.zza().zzc(null);
        if (((Boolean) zzbdcVar.zzb(zzbde.zzcc)).booleanValue() && (zzfcdVar2 = this.zzl) != null && zzfcdVar2.zzb != null) {
            zzbdrVar.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbdrVar.zza();
        zzbdq zzbdqVarZzf = zzbdt.zzf();
        this.zzK = zzbdqVarZzf;
        zzbdrVar.zzb("native:view_create", zzbdqVarZzf);
        this.zzL = null;
        this.zzJ = null;
        if (SimpleSQLiteQuery.zzb == null) {
            SimpleSQLiteQuery.zzb = new SimpleSQLiteQuery();
        }
        SimpleSQLiteQuery simpleSQLiteQuery = SimpleSQLiteQuery.zzb;
        simpleSQLiteQuery.getClass();
        com.google.android.gms.ads.internal.util.zze.zza("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(zzchcVar);
        if (!defaultUserAgent.equals(simpleSQLiteQuery.mQuery)) {
            int i3 = GooglePlayServicesUtil.$r8$clinit;
            try {
                contextCreatePackageContext = zzchcVar.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (contextCreatePackageContext == null) {
                zzchcVar.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(zzchcVar)).apply();
            }
            simpleSQLiteQuery.mQuery = defaultUserAgent;
        }
        com.google.android.gms.ads.internal.util.zze.zza("User agent is updated.");
        zzvVar.zzi.zzt();
    }

    private final synchronized void zzba() {
        zzfca zzfcaVar = this.zzk;
        if (zzfcaVar != null && zzfcaVar.zzam) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Disabling hardware acceleration on an overlay.");
            zzbc();
            return;
        }
        if (!this.zzw && !this.zzs.zzi()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Enabling hardware acceleration on an AdView.");
            zzbe();
            return;
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Enabling hardware acceleration on an overlay.");
        zzbe();
    }

    private final synchronized void zzbb() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzr();
    }

    private final synchronized void zzbc() {
        try {
            if (!this.zzx) {
                setLayerType(1, null);
            }
            this.zzx = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzbd(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", true != z ? "0" : "1");
        zzd("onAdVisibilityChanged", map);
    }

    private final synchronized void zzbe() {
        try {
            if (this.zzx) {
                setLayerType(0, null);
            }
            this.zzx = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzbf(String str) {
        final String str2 = "about:blank";
        try {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable(str2) { // from class: com.google.android.gms.internal.ads.zzcga
                public final /* synthetic */ String zzb = "about:blank";

                @Override // java.lang.Runnable
                public final void run() {
                    zzcgf zzcgfVar = this.zza;
                    String str3 = this.zzb;
                    super/*android.webkit.WebView*/.loadUrl("about:blank");
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzbg() {
        zzbdl.zza(this.zzM.zza(), this.zzK, "aeh2");
    }

    private final synchronized void zzbh() {
        try {
            Map map = this.zzW;
            if (map != null) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzcdn) it.next()).release();
                }
            }
            this.zzW = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzbi() {
        zzbdr zzbdrVar = this.zzM;
        if (zzbdrVar == null) {
            return;
        }
        zzbdt zzbdtVarZza = zzbdrVar.zza();
        zzbdj zzbdjVarZzg = com.google.android.gms.ads.internal.zzv.zza.zzi.zzg();
        if (zzbdjVarZzg != null) {
            zzbdjVarZzg.zzf(zzbdtVarZza);
        }
    }

    private final synchronized void zzbj() {
        Boolean boolZzl = com.google.android.gms.ads.internal.zzv.zza.zzi.zzl();
        this.zzy = boolZzl;
        if (boolZzl == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaY(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zzaY(Boolean.FALSE);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void destroy() {
        View decorView;
        try {
            zzbi();
            com.google.android.gms.ads.internal.util.zzck zzckVar = this.zzQ;
            zzckVar.zze = false;
            Activity activity = zzckVar.zzb;
            if (activity != null && zzckVar.zzc) {
                Window window = activity.getWindow();
                ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(zzckVar.zzf);
                }
                zzckVar.zzc = false;
            }
            com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
            if (zzmVar != null) {
                zzmVar.zzb();
                this.zzp.zzm();
                this.zzp = null;
            }
            this.zzq = null;
            this.zzr = null;
            this.zzo.zzl();
            this.zzG = null;
            this.zzg = null;
            setOnClickListener(null);
            setOnTouchListener(null);
            if (this.zzv) {
                return;
            }
            com.google.android.gms.ads.internal.zzv.zza.zzD.zzd(this);
            zzbh();
            this.zzv = true;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlj)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
                zzX();
                return;
            }
            Activity activityZza = this.zzb.zza();
            if (activityZza != null && activityZza.isDestroyed()) {
                com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
                zzX();
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
                com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
                zzbf("about:blank");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzaE()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlk)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcaf.zzf.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfz
                @Override // java.lang.Runnable
                public final void run() {
                    super/*android.webkit.WebView*/.evaluateJavascript(str, valueCallback);
                }
            });
        }
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                try {
                    if (!this.zzv) {
                        this.zzo.zzl();
                        com.google.android.gms.ads.internal.zzv.zza.zzD.zzd(this);
                        zzbh();
                        zzbb();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            super.finalize();
        } catch (Throwable th2) {
            super.finalize();
            throw th2;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzaE()) {
            super.loadData(str, str2, str3);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!zzaE()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void loadUrl(final String str) {
        if (zzaE()) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgc
                @Override // java.lang.Runnable
                public final void run() {
                    super/*android.webkit.WebView*/.loadUrl(str);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "AdWebViewImpl.loadUrl");
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final synchronized void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            boolean z = true;
            if (!zzaE()) {
                com.google.android.gms.ads.internal.util.zzck zzckVar = this.zzQ;
                zzckVar.zzd = true;
                if (zzckVar.zze) {
                    zzckVar.zzg();
                }
            }
            if (this.zzZ) {
                onResume();
                this.zzZ = false;
            }
            boolean z2 = this.zzC;
            zzcfo zzcfoVar = this.zzo;
            if (zzcfoVar == null || !zzcfoVar.zzW()) {
                z = z2;
            } else {
                if (!this.zzD) {
                    this.zzo.zza();
                    this.zzo.zzb();
                    this.zzD = true;
                }
                zzaZ();
            }
            zzbd(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        zzcfo zzcfoVar;
        View decorView;
        synchronized (this) {
            try {
                if (!zzaE()) {
                    com.google.android.gms.ads.internal.util.zzck zzckVar = this.zzQ;
                    zzckVar.zzd = false;
                    Activity activity = zzckVar.zzb;
                    if (activity != null && zzckVar.zzc) {
                        Window window = activity.getWindow();
                        ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(zzckVar.zzf);
                        }
                        zzckVar.zzc = false;
                    }
                }
                super.onDetachedFromWindow();
                if (this.zzD && (zzcfoVar = this.zzo) != null && zzcfoVar.zzW() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                    this.zzo.zza();
                    this.zzo.zzb();
                    this.zzD = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzly)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            com.google.android.gms.ads.internal.util.zzs.zzU(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Couldn't find an Activity to view url/mimetype: ", str, " / ", str4);
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze(strM);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (zzaE()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaZ = zzaZ();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL != null && zZzaZ && zzmVarZzL.zzm) {
            zzmVarZzL.zzm = false;
            zzmVarZzL.zzd.zzaa();
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0083 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0085 A[Catch: all -> 0x000f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:11:0x0012, B:13:0x0018, B:15:0x001c, B:18:0x0026, B:20:0x002e, B:23:0x0033, B:25:0x003b, B:27:0x004d, B:30:0x0052, B:32:0x0059, B:36:0x0063, B:39:0x0068, B:42:0x0079, B:50:0x0091, B:44:0x0080, B:47:0x0085, B:53:0x009e, B:55:0x00a6, B:57:0x00b8, B:60:0x00bd, B:62:0x00d9, B:64:0x00e1, B:63:0x00dd, B:67:0x00e6, B:69:0x00ee, B:72:0x00f9, B:81:0x011d, B:83:0x0124, B:87:0x012b, B:89:0x013d, B:91:0x014b, B:95:0x0158, B:98:0x015d, B:100:0x01a5, B:101:0x01a9, B:103:0x01b0, B:108:0x01bd, B:110:0x01c3, B:111:0x01c6, B:113:0x01ca, B:114:0x01d3, B:117:0x01de), top: B:122:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (zzaE()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.zzw && !this.zzs.zzf()) {
            if (this.zzs.zzh()) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzs.zzj()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzef)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzcgi zzcgiVarZzq = zzq();
                float fZze = zzcgiVarZzq != null ? zzcgiVarZzq.zze() : 0.0f;
                if (fZze == 0.0f) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                float f = size2 * fZze;
                int i7 = (int) (size / fZze);
                if (size2 != 0) {
                    i3 = (int) f;
                    if (size == 0) {
                        i6 = size;
                    } else if (i3 != 0) {
                        i7 = (int) (i3 / fZze);
                        i4 = size2;
                        i5 = i3;
                        i6 = i5;
                    }
                    i4 = size2;
                    i5 = i3;
                } else if (i7 != 0) {
                    i5 = (int) (i7 * fZze);
                    i6 = size;
                    i4 = i7;
                } else {
                    size2 = 0;
                    i3 = (int) f;
                    if (size == 0) {
                        i6 = size;
                    } else if (i3 != 0) {
                        i7 = (int) (i3 / fZze);
                        i4 = size2;
                        i5 = i3;
                        i6 = i5;
                    }
                    i4 = size2;
                    i5 = i3;
                }
                setMeasuredDimension(Math.min(i5, i6), Math.min(i7, i4));
                return;
            }
            if (this.zzs.zzg()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzen)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzag("/contentHeight", new zzcgd(this));
                zzaW("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                float f2 = this.zzi.density;
                int size3 = View.MeasureSpec.getSize(i);
                int i8 = this.zzI;
                setMeasuredDimension(size3, i8 != -1 ? (int) (i8 * f2) : View.MeasureSpec.getSize(i2));
                return;
            }
            if (this.zzs.zzi()) {
                DisplayMetrics displayMetrics = this.zzi;
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            int i9 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            int i10 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size5 : Integer.MAX_VALUE;
            zzchd zzchdVar = this.zzs;
            boolean z = zzchdVar.zzb > i9 || zzchdVar.zza > i10;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfM)).booleanValue()) {
                zzchd zzchdVar2 = this.zzs;
                float f3 = zzchdVar2.zzb;
                float f4 = this.zzj;
                z &= f3 / f4 <= ((float) i9) / f4 && ((float) zzchdVar2.zza) / f4 <= ((float) i10) / f4;
            }
            if (!z) {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                if (!this.zzn) {
                    this.zzY.zzc(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED);
                    this.zzn = true;
                }
                zzchd zzchdVar3 = this.zzs;
                setMeasuredDimension(zzchdVar3.zzb, zzchdVar3.zza);
                return;
            }
            zzchd zzchdVar4 = this.zzs;
            float f5 = zzchdVar4.zzb;
            float f6 = this.zzj;
            String str = "Not enough space to show ad. Needs " + ((int) (f5 / f6)) + "x" + ((int) (zzchdVar4.zza / f6)) + " dp, but only has " + ((int) (size4 / f6)) + "x" + ((int) (size5 / f6)) + " dp.";
            int i11 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str);
            if (getVisibility() != 8) {
                setVisibility(4);
            }
            setMeasuredDimension(0, 0);
            if (this.zzm) {
                return;
            }
            this.zzY.zzc(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED);
            this.zzm = true;
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final void onPause() {
        if (zzaE()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmX)).booleanValue() && TextStreamsKt.isFeatureSupported("MUTE_AUDIO")) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Muting webview");
                int i2 = WebViewCompat.$r8$clinit;
                if (!WebViewFeatureInternal.MUTE_AUDIO.isSupportedByWebView()) {
                    throw WebViewFeatureInternal.getUnsupportedOperationException();
                }
                ((WebViewProviderBoundaryInterface) WebViewCompat.getProvider(this).sharedPreferences).setAudioMuted(true);
            }
        } catch (Exception e) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not pause webview.", e);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzna)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdWebViewImpl.onPause");
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final void onResume() {
        if (zzaE()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmX)).booleanValue() && TextStreamsKt.isFeatureSupported("MUTE_AUDIO")) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Unmuting webview");
                int i2 = WebViewCompat.$r8$clinit;
                if (!WebViewFeatureInternal.MUTE_AUDIO.isSupportedByWebView()) {
                    throw WebViewFeatureInternal.getUnsupportedOperationException();
                }
                ((WebViewProviderBoundaryInterface) WebViewCompat.getProvider(this).sharedPreferences).setAudioMuted(false);
            }
        } catch (Exception e) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not resume webview.", e);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzna)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdWebViewImpl.onResume");
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdN)).booleanValue() && this.zzo.zzT();
        if ((!this.zzo.zzW() || this.zzo.zzU()) && !z) {
            zzavu zzavuVar = this.zzc;
            if (zzavuVar != null) {
                zzavuVar.zzd(motionEvent);
            }
            zzbel zzbelVar = this.zze;
            if (zzbelVar != null) {
                zzbelVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                try {
                    zzbgd zzbgdVar = this.zzE;
                    if (zzbgdVar != null) {
                        zzbgdVar.zzd(motionEvent);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (zzaE()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcfo) {
            this.zzo = (zzcfo) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaE()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzA(int i) {
        this.zzN = i;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzC(zzcgi zzcgiVar) {
        if (this.zzB == null) {
            this.zzB = zzcgiVar;
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcex
    public final zzfca zzD() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgv
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final WebViewClient zzH() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgt
    public final zzavu zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzbaq zzJ() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzbgd zzK() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final /* synthetic */ zzcgy zzN() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgs
    public final synchronized zzchd zzO() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzedf zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzedh zzQ() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgj
    public final zzfcd zzR() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzfda zzS() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final ListenableFuture zzT() {
        zzbel zzbelVar = this.zze;
        return zzbelVar == null ? zzgdn.zzh(null) : zzbelVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized String zzU() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final List zzV() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzW(zzfca zzfcaVar, zzfcd zzfcdVar) {
        this.zzk = zzfcaVar;
        this.zzl = zzfcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzX() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzbb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcge(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzY() {
        zzbg();
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.afmaVersion);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzZ(int i) {
        if (i == 0) {
            zzbdr zzbdrVar = this.zzM;
            zzbdl.zza(zzbdrVar.zza(), this.zzK, "aebb2");
        }
        zzbg();
        zzbdr zzbdrVar2 = this.zzM;
        zzbdrVar2.zza();
        zzbdrVar2.zza().zzd("close_type", String.valueOf(i));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zzf.afmaVersion);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zza(String str) {
        zzaW(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaA(String str, Predicate predicate) {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzS(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaC() {
        return this.zzH > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaD(final boolean z, final int i) {
        destroy();
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzcgb
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                int i2 = zzcgf.zza;
                zzbcj.zzbl.zza zzaVarZzb = zzbcj.zzbl.zzb();
                boolean zZzf = zzaVarZzb.zzf();
                boolean z2 = z;
                if (zZzf != z2) {
                    zzaVarZzb.zzd(z2);
                }
                zzaVarZzb.zze(i);
                zzaVar.zzab(zzaVarZzb.zzbr());
            }
        };
        zzbcc zzbccVar = this.zzY;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(GamesActivityResultCodes.RESULT_LICENSE_FAILED);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaE() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaF() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaG() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaH() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaJ(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        this.zzo.zzv(zzcVar, z, z2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaK(String str, String str2, int i) {
        this.zzo.zzw(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaL(boolean z, int i, boolean z2) {
        this.zzo.zzx(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zzo.zzz(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzo.zzA(z, i, str, z2, z3);
    }

    public final zzcfo zzaO() {
        return this.zzo;
    }

    public final synchronized Boolean zzaP() {
        return this.zzy;
    }

    public final synchronized void zzaV(String str, ValueCallback valueCallback) {
        if (!zzaE()) {
            evaluateJavascript(str, null);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzaW(String str) {
        if (zzaP() == null) {
            zzbj();
        }
        if (zzaP().booleanValue()) {
            zzaV(str, null);
        } else {
            zzaX("javascript:".concat(str));
        }
    }

    public final synchronized void zzaX(String str) {
        if (!zzaE()) {
            loadUrl(str);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzaY(Boolean bool) {
        synchronized (this) {
            this.zzy = bool;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzy(bool);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        if (r11.zzV != r10) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzaZ() {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgf.zzaZ():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaa() {
        if (this.zzJ == null) {
            zzbdr zzbdrVar = this.zzM;
            zzbdl.zza(zzbdrVar.zza(), this.zzK, "aes2");
            zzbdrVar.zza();
            zzbdq zzbdqVarZzf = zzbdt.zzf();
            this.zzJ = zzbdqVarZzf;
            zzbdrVar.zzb("native:view_show", zzbdqVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.afmaVersion);
        zzd("onshow", map);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0043  */
    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzab() {
        float f;
        HashMap map = new HashMap(3);
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        map.put("app_muted", String.valueOf(zzvVar.zzj.zze()));
        map.put("app_volume", String.valueOf(zzvVar.zzj.zza()));
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (audioManager == null) {
            f = 0.0f;
        } else {
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            if (streamMaxVolume != 0) {
                f = streamVolume / streamMaxVolume;
            } else {
                f = 0.0f;
            }
        }
        map.put("device_volume", String.valueOf(f));
        zzd("volume", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzac(boolean z) {
        this.zzo.zzm(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzad() {
        com.google.android.gms.ads.internal.util.zzck zzckVar = this.zzQ;
        zzckVar.zze = true;
        if (zzckVar.zzd) {
            zzckVar.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzae(String str, String str2, String str3) {
        String str4;
        try {
            if (zzaE()) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
                return;
            }
            String str5 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzag);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", str5);
                jSONObject.put("sdk", "Google Mobile Ads");
                jSONObject.put("sdkVersion", "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to build MRAID_ENV", e);
                str4 = null;
            }
            super.loadDataWithBaseURL(str, zzcgr.zzb(str2, str4), "text/html", "UTF-8", null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaf() {
        if (this.zzL == null) {
            zzbdr zzbdrVar = this.zzM;
            zzbdrVar.zza();
            zzbdq zzbdqVarZzf = zzbdt.zzf();
            this.zzL = zzbdqVarZzf;
            zzbdrVar.zzb("native:view_load", zzbdqVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzag(String str, zzbkf zzbkfVar) {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzB(str, zzbkfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzah() {
        com.google.android.gms.ads.internal.util.zze.zza("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzai(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzaj(zzchd zzchdVar) {
        this.zzs = zzchdVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzak(zzbaq zzbaqVar) {
        this.zzG = zzbaqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzal(boolean z) {
        this.zzz = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzam() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzan(Context context) {
        zzchc zzchcVar = this.zzb;
        zzchcVar.setBaseContext(context);
        this.zzQ.zzb = zzchcVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzao(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzy(this.zzo.zzV(), z);
        } else {
            this.zzu = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzap(zzbgb zzbgbVar) {
        this.zzF = zzbgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzaq(boolean z) {
        try {
            boolean z2 = this.zzw;
            this.zzw = z;
            zzba();
            if (z != z2) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzah)).booleanValue()) {
                    if (!this.zzs.zzi()) {
                    }
                }
                new zzbsu(this, "").zzl(true != z ? "default" : "expanded");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzar(zzbgd zzbgdVar) {
        this.zzE = zzbgdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzas(zzedf zzedfVar) {
        this.zzr = zzedfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzat(zzedh zzedhVar) {
        this.zzq = zzedhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzau(int i) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzA(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzav(boolean z) {
        this.zzZ = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzO = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzax(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i = this.zzH + (true != z ? -1 : 1);
        this.zzH = i;
        if (i > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzay(boolean z) {
        if (z) {
            try {
                setBackgroundColor(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            if (z) {
                zzmVar.zzl.setBackgroundColor(0);
            } else {
                zzmVar.zzl.setBackgroundColor(-16777216);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaz(String str, zzbkf zzbkfVar) {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzR(str, zzbkfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zzb(String str, String str2) {
        zzaW(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzo(map));
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzdf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdg() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdh() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzdi() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzl.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        boolean z;
        synchronized (this) {
            z = zzazcVar.zzj;
            this.zzC = z;
        }
        zzbd(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("(window.AFMA_ReceiveMessage || function() {})('", str, "',", jSONObject.toString(), ");");
        String string = sbM22m.toString();
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Dispatching AFMA event: ".concat(string));
        zzaW(sbM22m.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized int zzf() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgn, com.google.android.gms.internal.ads.zzccb
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzbdq zzk() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final zzbdr zzl() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgu, com.google.android.gms.internal.ads.zzccb
    public final VersionInfoParcel zzm() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzcbq zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized zzcdn zzo(String str) {
        Map map = this.zzW;
        if (map == null) {
            return null;
        }
        return (zzcdn) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zzp(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final synchronized zzcgi zzq() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized String zzr() {
        zzfcd zzfcdVar = this.zzl;
        if (zzfcdVar == null) {
            return null;
        }
        return zzfcdVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized String zzs() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzt(String str, zzcdn zzcdnVar) {
        try {
            if (this.zzW == null) {
                this.zzW = new HashMap();
            }
            this.zzW.put(str, zzcdnVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzv(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put(FirebaseAnalytics.Param.SUCCESS, true != z ? "0" : "1");
        map.put("duration", Long.toString(j));
        zzd("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzw() {
        zzbgb zzbgbVar = this.zzF;
        if (zzbgbVar != null) {
            final zzdmz zzdmzVar = (zzdmz) zzbgbVar;
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmx
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdmzVar.zzd();
                    } catch (RemoteException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzl(TSDAbK.mjHIY, e);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzz(boolean z) {
        this.zzo.zzF(false);
    }
}
