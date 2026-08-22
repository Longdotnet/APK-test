package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public class zzcfo extends WebViewClient implements zzcgy {
    public static final /* synthetic */ int zzb = 0;
    private zzdsj zzA;
    private boolean zzB;
    private boolean zzC;
    private int zzD;
    private boolean zzE;
    private final zzecl zzG;
    private View.OnAttachStateChangeListener zzH;
    protected zzbya zza;
    private final zzcfg zzc;
    private final zzbcc zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzr zzh;
    private zzcgw zzi;
    private zzcgx zzj;
    private zzbiv zzk;
    private zzbix zzl;
    private zzded zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private com.google.android.gms.ads.internal.overlay.zzad zzw;
    private zzbst zzx;
    private com.google.android.gms.ads.internal.zzb zzy;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbso zzz = null;
    private final HashSet zzF = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfW)).split(",")));

    public zzcfo(zzcfg zzcfgVar, zzbcc zzbccVar, boolean z, zzbst zzbstVar, zzbso zzbsoVar, zzecl zzeclVar) {
        this.zzd = zzbccVar;
        this.zzc = zzcfgVar;
        this.zzs = z;
        this.zzx = zzbstVar;
        this.zzG = zzeclVar;
    }

    private static WebResourceResponse zzY() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzaY)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzZ(String str, Map map) throws IOException {
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(10000);
                uRLConnectionOpenConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                zzcfg zzcfgVar = this.zzc;
                zzsVar.zzg(zzcfgVar.getContext(), zzcfgVar.zzm().afmaVersion, httpURLConnection, 60000);
                com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl();
                WebResourceResponse webResourceResponse = null;
                zzlVar.zzc(httpURLConnection, null);
                int responseCode = httpURLConnection.getResponseCode();
                zzlVar.zze(httpURLConnection, responseCode);
                if (responseCode < 300 || responseCode >= 400) {
                    String contentType = httpURLConnection.getContentType();
                    String strTrim = "";
                    String strTrim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
                    String contentType2 = httpURLConnection.getContentType();
                    if (!TextUtils.isEmpty(contentType2)) {
                        String[] strArrSplit = contentType2.split(";");
                        if (strArrSplit.length != 1) {
                            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                                if (strArrSplit[i2].trim().startsWith("charset")) {
                                    String[] strArrSplit2 = strArrSplit[i2].trim().split("=");
                                    if (strArrSplit2.length > 1) {
                                        strTrim = strArrSplit2[1].trim();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    String str2 = strTrim;
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    HashMap map2 = new HashMap(headerFields.size());
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                            map2.put(entry2.getKey(), entry2.getValue().get(0));
                        }
                    }
                    com.google.android.gms.ads.internal.util.zzt zztVar = com.google.android.gms.ads.internal.zzv.zza.zzg;
                    int responseCode2 = httpURLConnection.getResponseCode();
                    String responseMessage = httpURLConnection.getResponseMessage();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    zztVar.getClass();
                    webResourceResponse = new WebResourceResponse(strTrim2, str2, responseCode2, responseMessage, map2, inputStream);
                } else {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    if (!headerField.startsWith("tel:")) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            String str3 = TSDAbK.sPUoT;
                            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj(str3);
                            webResourceResponse = zzY();
                        } else if (protocol.equals("http") || protocol.equals("https")) {
                            String str4 = "Redirecting to " + headerField;
                            int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zze(str4);
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Unsupported scheme: " + protocol);
                            webResourceResponse = zzY();
                        }
                    }
                }
                TrafficStats.clearThreadStatsTag();
                return webResourceResponse;
            }
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbkf) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzab() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzH;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(final View view, final zzbya zzbyaVar, final int i) {
        if (!zzbyaVar.zzi() || i <= 0) {
            return;
        }
        zzbyaVar.zzg(view);
        if (zzbyaVar.zzi()) {
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzac(view, zzbyaVar, i - 1);
                }
            }, 100L);
        }
    }

    private static final boolean zzad(zzcfg zzcfgVar) {
        return zzcfgVar.zzD() != null && zzcfgVar.zzD().zzb();
    }

    private static final boolean zzae(boolean z, zzcfg zzcfgVar) {
        return (!z || zzcfgVar.zzO().zzi() || zzcfgVar.zzU().equals("interstitial_mb")) ? false : true;
    }

    public static void zzh(zzcfo zzcfoVar) {
        zzcfg zzcfgVar = zzcfoVar.zzc;
        zzcfgVar.zzad();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzcfgVar.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzl.removeView(zzmVarZzL.zzf);
            zzmVarZzL.zzw(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzn(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Toolbar toolbar;
        synchronized (this.zzf) {
            try {
                zzcfg zzcfgVar = this.zzc;
                if (zzcfgVar.zzaE()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                    zzcfgVar.zzX();
                    return;
                }
                this.zzB = true;
                zzcgx zzcgxVar = this.zzj;
                if (zzcgxVar != null) {
                    zzcgxVar.zza();
                    this.zzj = null;
                }
                zzk();
                zzcfg zzcfgVar2 = this.zzc;
                if (zzcfgVar2.zzL() != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmq)).booleanValue() || (toolbar = zzcfgVar2.zzL().zzw) == null) {
                        return;
                    }
                    toolbar.setSubtitle(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaD(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case ModuleDescriptor.MODULE_VERSION /* 86 */:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzn(uriZza);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = uriZza.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzbya zzbyaVar = this.zza;
                        if (zzbyaVar != null) {
                            zzbyaVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzded zzdedVar = this.zzm;
                    if (zzdedVar != null) {
                        zzdedVar.zzdf();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            zzcfg zzcfgVar = this.zzc;
            if (zzcfgVar.zzG().willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzavu zzavuVarZzI = zzcfgVar.zzI();
                    zzfda zzfdaVarZzS = zzcfgVar.zzS();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmu)).booleanValue() || zzfdaVarZzS == null) {
                        if (zzavuVarZzI != null && zzavuVarZzI.zzf(uriZza)) {
                            uriZza = zzavuVarZzI.zza(uriZza, zzcfgVar.getContext(), (View) zzcfgVar, zzcfgVar.zzi());
                        }
                    } else if (zzavuVarZzI != null && zzavuVarZzI.zzf(uriZza)) {
                        uriZza = zzfdaVarZzS.zza(uriZza, zzcfgVar.getContext(), (View) zzcfgVar, zzcfgVar.zzi());
                    }
                } catch (zzavv unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzy;
                if (zzbVar == null || zzbVar.zzc()) {
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null, null);
                    zzcfg zzcfgVar2 = this.zzc;
                    zzv(zzcVar, true, false, zzcfgVar2 != null ? zzcfgVar2.zzr() : "");
                } else {
                    zzbVar.zzb(str);
                }
            }
        }
        return true;
    }

    public final void zzA(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcfg zzcfgVar = this.zzc;
        boolean zZzaF = zzcfgVar.zzaF();
        boolean zZzae = zzae(zZzaF, zzcfgVar);
        boolean z4 = true;
        if (!zZzae && z2) {
            z4 = false;
        }
        zzy(new AdOverlayInfoParcel(zZzae ? null : this.zzg, zZzaF ? null : new zzcfn(zzcfgVar, this.zzh), this.zzk, this.zzl, this.zzw, zzcfgVar, z, i, str, zzcfgVar.zzm(), z4 ? null : this.zzm, zzad(zzcfgVar) ? this.zzG : null, z3));
    }

    public final void zzB(String str, zzbkf zzbkfVar) {
        synchronized (this.zzf) {
            try {
                HashMap map = this.zze;
                List copyOnWriteArrayList = (List) map.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                    map.put(str, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(zzbkfVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzC(zzcgw zzcgwVar) {
        this.zzi = zzcgwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzD(com.google.android.gms.ads.internal.zzb zzbVar) {
        this.zzy = zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzE(int i, int i2) {
        zzbso zzbsoVar = this.zzz;
        if (zzbsoVar != null) {
            zzbsoVar.zze(i, i2);
        }
    }

    public final void zzF(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzG(boolean z) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzH(boolean z) {
        synchronized (this.zzf) {
            this.zzv = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzI() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfi
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfo.zzh(this.zza);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzJ(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzK(zzcgx zzcgxVar) {
        this.zzj = zzcgxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzL(zzbya zzbyaVar) {
        this.zza = zzbyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzM(zzcmq zzcmqVar, zzeca zzecaVar, zzfjy zzfjyVar) {
        zzQ("/click");
        if (zzecaVar != null && zzfjyVar != null) {
            zzB("/click", new zzfde(this.zzm, zzcmqVar, zzfjyVar, zzecaVar));
            return;
        }
        zzded zzdedVar = this.zzm;
        zzbkf zzbkfVar = zzbke.zza;
        zzB("/click", new zzbjd(zzdedVar, zzcmqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzN(zzcmq zzcmqVar) {
        zzQ("/click");
        zzded zzdedVar = this.zzm;
        zzbkf zzbkfVar = zzbke.zza;
        zzB("/click", new zzbjd(zzdedVar, zzcmqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzO(zzcmq zzcmqVar, zzeca zzecaVar, zzdsj zzdsjVar) {
        zzQ("/open");
        zzB("/open", new zzbkr(this.zzy, this.zzz, zzecaVar, zzdsjVar, zzcmqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzP(zzfca zzfcaVar) {
        zzcfg zzcfgVar = this.zzc;
        if (com.google.android.gms.ads.internal.zzv.zza.zzB.zzp(zzcfgVar.getContext())) {
            zzQ("/logScionEvent");
            new HashMap();
            zzB("/logScionEvent", new zzbkl(zzcfgVar.getContext(), zzfcaVar.zzaw));
        }
    }

    public final void zzQ(String str) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzR(String str, zzbkf zzbkfVar) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.remove(zzbkfVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzS(String str, Predicate predicate) {
        synchronized (this.zzf) {
            try {
                List<zzbkf> list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (zzbkf zzbkfVar : list) {
                    if (predicate.apply(zzbkfVar)) {
                        arrayList.add(zzbkfVar);
                    }
                }
                list.removeAll(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzT() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzU() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzv;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final boolean zzV() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzW() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzX(com.google.android.gms.ads.internal.client.zza zzaVar, zzbiv zzbivVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbix zzbixVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, boolean z, zzbki zzbkiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbsv zzbsvVar, zzbya zzbyaVar, final zzeca zzecaVar, final zzfjy zzfjyVar, zzdsj zzdsjVar, zzbkz zzbkzVar, zzded zzdedVar, zzbky zzbkyVar, zzbks zzbksVar, zzbkg zzbkgVar, zzcmq zzcmqVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzbyaVar) : zzbVar;
        zzcfg zzcfgVar = this.zzc;
        this.zzz = new zzbso(zzcfgVar, zzbsvVar);
        this.zza = zzbyaVar;
        zzbcv zzbcvVar = zzbde.zzbf;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzB("/adMetadata", new zzbiu(zzbivVar));
        }
        if (zzbixVar != null) {
            zzB("/appEvent", new zzbiw(zzbixVar));
        }
        zzB("/backButton", zzbke.zzj);
        zzB("/refresh", zzbke.zzk);
        zzB("/canOpenApp", zzbke.zzb);
        zzB("/canOpenURLs", zzbke.zza);
        zzB("/canOpenIntents", zzbke.zzc);
        zzB("/close", zzbke.zzd);
        zzB("/customClose", zzbke.zze);
        zzB("/instrument", zzbke.zzn);
        zzB("/delayPageLoaded", zzbke.zzp);
        zzB("/delayPageClosed", zzbke.zzq);
        zzB("/getLocationInfo", zzbke.zzr);
        zzB("/log", zzbke.zzg);
        zzB("/mraid", new zzbkm(zzbVar2, this.zzz, zzbsvVar));
        zzbst zzbstVar = this.zzx;
        if (zzbstVar != null) {
            zzB("/mraidLoaded", zzbstVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzB("/open", new zzbkr(zzbVar2, this.zzz, zzecaVar, zzdsjVar, zzcmqVar));
        zzB("/precache", new zzcdo());
        zzB(sgtsHsWT.jZFXN, zzbke.zzi);
        zzB("/video", zzbke.zzl);
        zzB(mnwSv.nMYqOFOMaN, zzbke.zzm);
        if (zzecaVar == null || zzfjyVar == null) {
            zzB("/click", new zzbjd(zzdedVar, zzcmqVar));
            zzB("/httpTrack", zzbke.zzf);
        } else {
            zzB("/click", new zzfde(zzdedVar, zzcmqVar, zzfjyVar, zzecaVar));
            zzB("/httpTrack", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzfdf
                @Override // com.google.android.gms.internal.ads.zzbkf
                public final void zza(Object obj, Map map) {
                    zzcex zzcexVar = (zzcex) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from httpTrack GMSG.");
                        return;
                    }
                    zzfca zzfcaVarZzD = zzcexVar.zzD();
                    if (zzfcaVarZzD != null && !zzfcaVarZzD.zzai) {
                        zzfjyVar.zzd(str, zzfcaVarZzD.zzax, null, null);
                        return;
                    }
                    zzfcd zzfcdVarZzR = ((zzcgj) zzcexVar).zzR();
                    if (zzfcdVarZzR == null) {
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingHttpTrackGmsgHandler");
                    } else {
                        zzeca zzecaVar2 = zzecaVar;
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        zzecaVar2.zzd(new zzecc(System.currentTimeMillis(), zzfcdVarZzR.zzb, str, 2));
                    }
                }
            });
        }
        if (com.google.android.gms.ads.internal.zzv.zza.zzB.zzp(zzcfgVar.getContext())) {
            Map map = new HashMap();
            if (zzcfgVar.zzD() != null) {
                map = zzcfgVar.zzD().zzaw;
            }
            zzB("/logScionEvent", new zzbkl(zzcfgVar.getContext(), map));
        }
        if (zzbkiVar != null) {
            zzB("/setInterstitialProperties", new zzbkh(zzbkiVar));
        }
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (zzbkzVar != null && ((Boolean) zzbdcVar.zzb(zzbde.zzjp)).booleanValue()) {
            zzB("/inspectorNetworkExtras", zzbkzVar);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzjI)).booleanValue() && zzbkyVar != null) {
            zzB("/shareSheet", zzbkyVar);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzjN)).booleanValue() && zzbksVar != null) {
            zzB("/inspectorOutOfContextTest", zzbksVar);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzjS)).booleanValue() && zzbkgVar != null) {
            zzB("/inspectorStorage", zzbkgVar);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzlV)).booleanValue()) {
            zzB("/bindPlayStoreOverlay", zzbke.zzu);
            zzB("/presentPlayStoreOverlay", zzbke.zzv);
            zzB("/expandPlayStoreOverlay", zzbke.zzw);
            zzB("/collapsePlayStoreOverlay", zzbke.zzx);
            zzB("/closePlayStoreOverlay", zzbke.zzy);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzdB)).booleanValue()) {
            zzB("/setPAIDPersonalizationEnabled", zzbke.zzA);
            zzB("/resetPAID", zzbke.zzz);
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzmp)).booleanValue() && zzcfgVar.zzD() != null && zzcfgVar.zzD().zzar) {
            zzB("/writeToLocalStorage", zzbke.zzB);
            zzB("/clearLocalStorageKeys", zzbke.zzC);
        }
        this.zzg = zzaVar;
        this.zzh = zzrVar;
        this.zzk = zzbivVar;
        this.zzl = zzbixVar;
        this.zzw = zzadVar;
        this.zzy = zzbVar3;
        this.zzm = zzdedVar;
        this.zzA = zzdsjVar;
        this.zzn = z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02a0 A[Catch: NoClassDefFoundError -> 0x0020, Exception -> 0x0023, TryCatch #14 {Exception -> 0x0023, NoClassDefFoundError -> 0x0020, blocks: (B:3:0x000c, B:5:0x0019, B:10:0x0026, B:12:0x0036, B:14:0x003d, B:16:0x004b, B:18:0x0067, B:20:0x0080, B:22:0x0097, B:23:0x009a, B:25:0x009d, B:28:0x00b7, B:31:0x00cd, B:34:0x00e0, B:80:0x01b4, B:52:0x0169, B:103:0x02a0, B:92:0x0227, B:93:0x0250, B:91:0x01ff, B:51:0x0144, B:33:0x00d7, B:94:0x0251, B:96:0x025b, B:98:0x0261, B:100:0x0294, B:105:0x02af, B:107:0x02b5, B:109:0x02c3), top: B:121:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:107:0x02b5 A[Catch: NoClassDefFoundError -> 0x0020, Exception -> 0x0023, TryCatch #14 {Exception -> 0x0023, NoClassDefFoundError -> 0x0020, blocks: (B:3:0x000c, B:5:0x0019, B:10:0x0026, B:12:0x0036, B:14:0x003d, B:16:0x004b, B:18:0x0067, B:20:0x0080, B:22:0x0097, B:23:0x009a, B:25:0x009d, B:28:0x00b7, B:31:0x00cd, B:34:0x00e0, B:80:0x01b4, B:52:0x0169, B:103:0x02a0, B:92:0x0227, B:93:0x0250, B:91:0x01ff, B:51:0x0144, B:33:0x00d7, B:94:0x0251, B:96:0x025b, B:98:0x0261, B:100:0x0294, B:105:0x02af, B:107:0x02b5, B:109:0x02c3), top: B:121:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02c8 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x009c  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f1 A[Catch: all -> 0x01fa, TryCatch #11 {all -> 0x01fa, blocks: (B:84:0x01df, B:86:0x01f1, B:90:0x01fc), top: B:119:0x01df }] */
    public final WebResourceResponse zzc(String str, Map map) throws Throwable {
        int i;
        InputStream inputStreamZza;
        InputStream inputStreamZzc;
        final boolean z;
        final boolean z2;
        String str2;
        try {
            Map map2 = new HashMap();
            zzcfg zzcfgVar = this.zzc;
            if (zzcfgVar.zzD() != null) {
                map2 = zzcfgVar.zzD().zzaw;
            }
            String strZzc = zzbyq.zzc(str, zzcfgVar.getContext(), this.zzE, map2);
            if (!strZzc.equals(str)) {
                return zzZ(strZzc, map);
            }
            Parcelable.Creator<zzbbo> creator = zzbbo.CREATOR;
            zzbbo zzbboVarZza = zzbbo.zza(Uri.parse(str));
            if (zzbboVarZza != null) {
                HashMap map3 = new HashMap();
                map3.put("Access-Control-Allow-Origin", "*");
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameterNames().contains("range")) {
                    List listZzf = zzfwe.zzb(zzfva.zzc('-')).zzf(uri.getQueryParameter("range"));
                    if (listZzf.size() == 2) {
                        int i2 = Integer.parseInt((String) listZzf.get(0));
                        int i3 = Integer.parseInt((String) listZzf.get(1)) + 1;
                        if (i2 > 0) {
                            zzbboVarZza.zzh = i2;
                        }
                        i = i3 - i2;
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                zzbcv zzbcvVar = zzbde.zzeD;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    zzbboVarZza.zzi = zzfwg.zzc(zzcfgVar.zzr());
                    zzbboVarZza.zzj = zzcfgVar.zzf();
                    boolean z3 = zzbboVarZza.zzg;
                    zzbdc zzbdcVar = zzbdVar.zzd;
                    Long l = z3 ? (Long) zzbdcVar.zzb(zzbde.zzeF) : (Long) zzbdcVar.zzb(zzbde.zzeE);
                    String str3 = "AdWebViewClient.interceptRequest.gcache";
                    long jLongValue = l.longValue();
                    com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
                    zzvVar.zzl.getClass();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Future futureZza = zzbbz.zza(zzcfgVar.getContext(), zzbboVarZza);
                    try {
                        zzbca zzbcaVar = (zzbca) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                        try {
                            try {
                                map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbcaVar.zzd()));
                                map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbcaVar.zzf()));
                                map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbcaVar.zze()));
                                map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbcaVar.zza()));
                                inputStreamZzc = zzbcaVar.zzc();
                                if (i != -1) {
                                    try {
                                        inputStreamZzc = zzgbg.zza(inputStreamZzc, i);
                                    } catch (InterruptedException e) {
                                        e = e;
                                        z2 = true;
                                        try {
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                                            }
                                            futureZza.cancel(true);
                                            Thread.currentThread().interrupt();
                                            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                            final long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z2, jElapsedRealtime2);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime2 + "ms";
                                        } catch (Throwable th) {
                                            th = th;
                                            z = z2;
                                            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                            final long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z, jElapsedRealtime3);
                                                }
                                            });
                                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime3 + "ms");
                                            throw th;
                                        }
                                    } catch (ExecutionException e2) {
                                        e = e2;
                                        z = true;
                                        try {
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                                            }
                                            futureZza.cancel(true);
                                            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                            final long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z, jElapsedRealtime4);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime4 + "ms";
                                        } catch (Throwable th2) {
                                            th = th2;
                                            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                            final long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzc.zzv(z, jElapsedRealtime5);
                                                }
                                            });
                                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + "ms");
                                            throw th;
                                        }
                                    } catch (TimeoutException e3) {
                                        e = e3;
                                        z = true;
                                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                                        }
                                        futureZza.cancel(true);
                                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                        final long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.zza.zzc.zzv(z, jElapsedRealtime6);
                                            }
                                        });
                                        str2 = "Cache connection took " + jElapsedRealtime6 + "ms";
                                    }
                                }
                                zzvVar.zzl.getClass();
                                final long jElapsedRealtime7 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                final boolean z4 = true;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zza.zzc.zzv(z4, jElapsedRealtime7);
                                    }
                                });
                                str2 = "Cache connection took " + jElapsedRealtime7 + "ms";
                            } catch (InterruptedException e4) {
                                e = e4;
                                inputStreamZzc = null;
                            } catch (ExecutionException e5) {
                                e = e5;
                                inputStreamZzc = null;
                                z = true;
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                                }
                                futureZza.cancel(true);
                                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                final long jElapsedRealtime8 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zza.zzc.zzv(z, jElapsedRealtime8);
                                    }
                                });
                                str2 = "Cache connection took " + jElapsedRealtime8 + "ms";
                                com.google.android.gms.ads.internal.util.zze.zza(str2);
                                inputStreamZza = inputStreamZzc;
                                if (inputStreamZza != null) {
                                    return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                                }
                                if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                    return null;
                                }
                                return null;
                            } catch (TimeoutException e6) {
                                e = e6;
                                inputStreamZzc = null;
                                z = true;
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                                }
                                futureZza.cancel(true);
                                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                final long jElapsedRealtime9 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zza.zzc.zzv(z, jElapsedRealtime9);
                                    }
                                });
                                str2 = "Cache connection took " + jElapsedRealtime9 + "ms";
                                com.google.android.gms.ads.internal.util.zze.zza(str2);
                                inputStreamZza = inputStreamZzc;
                                if (inputStreamZza != null) {
                                    return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                                }
                                if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                    return null;
                                }
                                return null;
                            }
                            com.google.android.gms.ads.internal.util.zze.zza(str2);
                        } catch (Throwable th3) {
                            th = th3;
                            z = true;
                            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                            final long jElapsedRealtime10 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zza.zzc.zzv(z, jElapsedRealtime10);
                                }
                            });
                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime10 + "ms");
                            throw th;
                        }
                    } catch (InterruptedException e7) {
                        e = e7;
                        inputStreamZzc = null;
                        z2 = false;
                    } catch (ExecutionException e8) {
                        e = e8;
                        str3 = str3;
                        inputStreamZzc = null;
                        z = false;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                        }
                        futureZza.cancel(true);
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        final long jElapsedRealtime11 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzc.zzv(z, jElapsedRealtime11);
                            }
                        });
                        str2 = "Cache connection took " + jElapsedRealtime11 + "ms";
                        com.google.android.gms.ads.internal.util.zze.zza(str2);
                        inputStreamZza = inputStreamZzc;
                        if (inputStreamZza != null) {
                            return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                        }
                        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                            return null;
                        }
                        return null;
                    } catch (TimeoutException e9) {
                        e = e9;
                        str3 = str3;
                        inputStreamZzc = null;
                        z = false;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeI)).booleanValue()) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, str3);
                        }
                        futureZza.cancel(true);
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        final long jElapsedRealtime12 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzc.zzv(z, jElapsedRealtime12);
                            }
                        });
                        str2 = "Cache connection took " + jElapsedRealtime12 + "ms";
                        com.google.android.gms.ads.internal.util.zze.zza(str2);
                        inputStreamZza = inputStreamZzc;
                        if (inputStreamZza != null) {
                            return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                        }
                        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                            return null;
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                } else {
                    zzbbl zzbblVarZzb = com.google.android.gms.ads.internal.zzv.zza.zzk.zzb(zzbboVarZza);
                    if (zzbblVarZzb == null || !zzbblVarZzb.zze()) {
                        inputStreamZza = null;
                    } else {
                        map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbblVarZzb.zzd()));
                        map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbblVarZzb.zzg()));
                        map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbblVarZzb.zzf()));
                        map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbblVarZzb.zza()));
                        inputStreamZzc = zzbblVarZzb.zzc();
                        if (i != -1) {
                            inputStreamZza = zzgbg.zza(inputStreamZzc, i);
                        }
                    }
                    if (inputStreamZza != null) {
                        return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                    }
                }
                inputStreamZza = inputStreamZzc;
                if (inputStreamZza != null) {
                    return new WebResourceResponse("", "", 200, "OK", map3, inputStreamZza);
                }
            }
            if (com.google.android.gms.ads.internal.util.client.zzl.zzk() || !((Boolean) zzbfa.zzb.zze()).booleanValue()) {
                return null;
            }
            return zzZ(str, map);
        } catch (Exception e10) {
            e = e10;
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdWebViewClient.interceptRequest");
            return zzY();
        } catch (NoClassDefFoundError e11) {
            e = e11;
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdWebViewClient.interceptRequest");
            return zzY();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzded zzdedVar = this.zzm;
        if (zzdedVar != null) {
            zzdedVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzded zzdedVar = this.zzm;
        if (zzdedVar != null) {
            zzdedVar.zzdf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final zzdsj zze() {
        return this.zzA;
    }

    public final void zzk() {
        if (this.zzi != null && ((this.zzB && this.zzD <= 0) || this.zzC || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue()) {
                zzcfg zzcfgVar = this.zzc;
                if (zzcfgVar.zzl() != null) {
                    zzbdl.zza(zzcfgVar.zzl().zza(), zzcfgVar.zzk(), "awfllc");
                }
            }
            zzcgw zzcgwVar = this.zzi;
            boolean z = false;
            if (!this.zzC && !this.zzo) {
                z = true;
            }
            zzcgwVar.zza(z, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzaf();
    }

    public final void zzl() {
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            zzbyaVar.zzf();
            this.zza = null;
        }
        zzab();
        synchronized (this.zzf) {
            try {
                this.zze.clear();
                this.zzg = null;
                this.zzh = null;
                this.zzi = null;
                this.zzj = null;
                this.zzk = null;
                this.zzl = null;
                this.zzn = false;
                this.zzs = false;
                this.zzt = false;
                this.zzu = false;
                this.zzw = null;
                this.zzy = null;
                this.zzx = null;
                zzbso zzbsoVar = this.zzz;
                if (zzbsoVar != null) {
                    zzbsoVar.zzb(true);
                    this.zzz = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzm(boolean z) {
        this.zzE = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzn(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(uri)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgV)).booleanValue() || com.google.android.gms.ads.internal.zzv.zza.zzi.zzg() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfj
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i = zzcfo.zzb;
                    com.google.android.gms.ads.internal.zzv.zza.zzi.zzg().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        zzbcv zzbcvVar = zzbde.zzfV;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && this.zzF.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzbdVar.zzd.zzb(zzbde.zzfX)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                zzsVar.getClass();
                zzgdn.zzr(zzgdn.zzj(new com.android.billingclient.api.zzaz(uri, 4), zzsVar.zzl), new zzcfm(this, list, path, uri), zzcaf.zzf);
                return;
            }
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzv.zza.zzd;
        zzaa(com.google.android.gms.ads.internal.util.zzs.zzQ(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzo() {
        zzbcc zzbccVar = this.zzd;
        if (zzbccVar != null) {
            zzbccVar.zzc(10005);
        }
        this.zzC = true;
        this.zzp = GamesActivityResultCodes.RESULT_APP_MISCONFIGURED;
        this.zzq = "Page loaded delay cancel.";
        zzk();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzp() {
        synchronized (this.zzf) {
        }
        this.zzD++;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzq() {
        this.zzD--;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzr(int i, int i2, boolean z) {
        zzbst zzbstVar = this.zzx;
        if (zzbstVar != null) {
            zzbstVar.zzb(i, i2);
        }
        zzbso zzbsoVar = this.zzz;
        if (zzbsoVar != null) {
            zzbsoVar.zzd(i, i2, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzs() {
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            zzcfg zzcfgVar = this.zzc;
            WebView webViewZzG = zzcfgVar.zzG();
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (webViewZzG.isAttachedToWindow()) {
                zzac(webViewZzG, zzbyaVar, 10);
                return;
            }
            zzab();
            zzcfl zzcflVar = new zzcfl(this, zzbyaVar);
            this.zzH = zzcflVar;
            ((View) zzcfgVar).addOnAttachStateChangeListener(zzcflVar);
        }
    }

    public final void zzv(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        zzcfg zzcfgVar = this.zzc;
        boolean zZzaF = zzcfgVar.zzaF();
        boolean z3 = zzae(zZzaF, zzcfgVar) || z2;
        zzy(new AdOverlayInfoParcel(zzcVar, z3 ? null : this.zzg, zZzaF ? null : this.zzh, this.zzw, zzcfgVar.zzm(), zzcfgVar, z3 || !z ? null : this.zzm, str));
    }

    public final void zzw(String str, String str2, int i) {
        zzecl zzeclVar = this.zzG;
        zzcfg zzcfgVar = this.zzc;
        zzy(new AdOverlayInfoParcel(zzcfgVar, zzcfgVar.zzm(), str, str2, zzeclVar));
    }

    public final void zzx(boolean z, int i, boolean z2) {
        zzcfg zzcfgVar = this.zzc;
        boolean zZzae = zzae(zzcfgVar.zzaF(), zzcfgVar);
        boolean z3 = true;
        if (!zZzae && z2) {
            z3 = false;
        }
        zzy(new AdOverlayInfoParcel(zZzae ? null : this.zzg, this.zzh, this.zzw, zzcfgVar, z, i, zzcfgVar.zzm(), z3 ? null : this.zzm, zzad(zzcfgVar) ? this.zzG : null));
    }

    public final void zzy(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbso zzbsoVar = this.zzz;
        boolean zZzf = zzbsoVar != null ? zzbsoVar.zzf() : false;
        GraphRequest.Companion companion = com.google.android.gms.ads.internal.zzv.zza.zzc;
        GraphRequest.Companion.zza(this.zzc.getContext(), adOverlayInfoParcel, !zZzf, this.zzA);
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzbyaVar.zzh(str);
        }
    }

    public final void zzz(boolean z, int i, String str, String str2, boolean z2) {
        zzcfg zzcfgVar = this.zzc;
        boolean zZzaF = zzcfgVar.zzaF();
        boolean zZzae = zzae(zZzaF, zzcfgVar);
        boolean z3 = true;
        if (!zZzae && z2) {
            z3 = false;
        }
        zzy(new AdOverlayInfoParcel(zZzae ? null : this.zzg, zZzaF ? null : new zzcfn(zzcfgVar, this.zzh), this.zzk, this.zzl, this.zzw, zzcfgVar, z, i, str, str2, zzcfgVar.zzm(), z3 ? null : this.zzm, zzad(zzcfgVar) ? this.zzG : null));
    }
}
