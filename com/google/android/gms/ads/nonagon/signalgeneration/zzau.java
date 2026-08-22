package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.core.provider.FontRequestWorker;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.AccessTokenCache;
import com.facebook.ProfileCache;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzcvf;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdny;
import com.google.android.gms.internal.ads.zzdrr;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzfcu;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.ads.zzfdv;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhu;
import com.google.android.gms.internal.ads.zzfhx;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzfve;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgde;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.auth.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.MediaType;
import okhttp3.Request;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzau extends zzbyz {
    public static final ArrayList zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    public static final ArrayList zzb;
    public static final ArrayList zzc;
    public static final ArrayList zzd;
    public final String zzA;
    public final ArrayList zzB;
    public final ArrayList zzC;
    public final ArrayList zzD;
    public final ArrayList zzE;
    public final zzbej zzI;
    public final zzo zzJ;
    public final zzf zzK;
    public final zzche zzf;
    public Context zzg;
    public final zzavu zzh;
    public final zzfda zzi;
    public final zzfdv zzj;
    public final zzgdy zzk;
    public final ScheduledExecutorService zzl;
    public zzbui zzm;
    public final zzdso zzp;
    public final zzfjy zzq;
    public final boolean zzr;
    public final boolean zzs;
    public final boolean zzt;
    public final boolean zzu;
    public final String zzv;
    public final String zzw;
    public final VersionInfoParcel zzy;
    public String zzz;
    public Point zzn = new Point();
    public Point zzo = new Point();
    public final AtomicInteger zzx = new AtomicInteger(0);
    public final AtomicBoolean zzF = new AtomicBoolean(false);
    public final AtomicBoolean zzG = new AtomicBoolean(false);
    public final AtomicInteger zzH = new AtomicInteger(0);

    public zzau(zzche zzcheVar, Context context, zzavu zzavuVar, zzfdv zzfdvVar, zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzdso zzdsoVar, zzfjy zzfjyVar, VersionInfoParcel versionInfoParcel, zzbej zzbejVar, zzfda zzfdaVar, zzo zzoVar, zzf zzfVar) {
        ArrayList arrayListZzZ;
        this.zzf = zzcheVar;
        this.zzg = context;
        this.zzh = zzavuVar;
        this.zzi = zzfdaVar;
        this.zzj = zzfdvVar;
        this.zzk = zzgdyVar;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdsoVar;
        this.zzq = zzfjyVar;
        this.zzy = versionInfoParcel;
        this.zzI = zzbejVar;
        zzbcv zzbcvVar = zzbde.zzhx;
        zzbd zzbdVar = zzbd.zza;
        this.zzr = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        zzbcv zzbcvVar2 = zzbde.zzhw;
        zzbdc zzbdcVar = zzbdVar.zzd;
        this.zzs = ((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue();
        this.zzt = ((Boolean) zzbdcVar.zzb(zzbde.zzhz)).booleanValue();
        this.zzu = ((Boolean) zzbdcVar.zzb(zzbde.zzhB)).booleanValue();
        this.zzv = (String) zzbdcVar.zzb(zzbde.zzhA);
        this.zzw = (String) zzbdcVar.zzb(zzbde.zzhC);
        this.zzA = (String) zzbdcVar.zzb(zzbde.zzhD);
        this.zzJ = zzoVar;
        this.zzK = zzfVar;
        if (((Boolean) zzbdcVar.zzb(zzbde.zzhE)).booleanValue()) {
            this.zzB = zzZ((String) zzbdcVar.zzb(zzbde.zzhF));
            this.zzC = zzZ((String) zzbdcVar.zzb(zzbde.zzhG));
            this.zzD = zzZ((String) zzbdcVar.zzb(zzbde.zzhH));
            arrayListZzZ = zzZ((String) zzbdcVar.zzb(zzbde.zzhI));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            arrayListZzZ = zzd;
        }
        this.zzE = arrayListZzZ;
    }

    public static boolean zzX(Uri uri, ArrayList arrayList, ArrayList arrayList2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final ArrayList zzZ(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzfwg.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static final Uri zzaa(String str, Uri uri, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(string.substring(0, i) + str + "=" + str2 + "&" + string.substring(i));
    }

    public static zzfhu zzs(ListenableFuture listenableFuture, zzbze zzbzeVar) {
        if (!zzfhx.zza() || !((Boolean) zzbex.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfhu zzfhuVarZza = ((zzac) zzgdn.zzp(listenableFuture)).zza();
            zzfhuVarZza.zzd(new ArrayList(Collections.singletonList(zzbzeVar.zzb)));
            zzm zzmVar = zzbzeVar.zzd;
            zzfhuVarZza.zzb(zzmVar == null ? "" : zzmVar.zzp);
            zzfhuVarZza.zzf(zzmVar.zzm);
            return zzfhuVarZza;
        } catch (ExecutionException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
    public final zzac zzR(Context context, String str, String str2, zzr zzrVar, zzm zzmVar, int i, String str3, Bundle bundle, zzbze zzbzeVar) {
        zzr zzrVar2;
        byte b;
        zzfcu zzfcuVar = new zzfcu();
        if ("REWARDED".equals(str2)) {
            zzfcuVar.zzq().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfcuVar.zzq().zza(3);
        }
        zzab zzabVarZzo = this.zzf.zzo();
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(context);
        zzfcuVar.zzu(str == null ? "adUnitId" : str);
        zzfcuVar.zzJ(zzmVar == null ? new zzm(8, -1L, new Bundle(), -1, new ArrayList(), false, -1, false, null, null, null, null, new Bundle(), new Bundle(), new ArrayList(), null, null, false, null, -1, null, new ArrayList(), 60000, null, 0, 0L, 0L) : zzmVar);
        if (zzrVar == null) {
            switch (str2) {
                case "NATIVE":
                    b = 3;
                    break;
                case "APP_OPEN_AD":
                    b = 4;
                    break;
                case "REWARDED":
                    b = 1;
                    break;
                case "REWARDED_INTERSTITIAL":
                    b = 2;
                    break;
                case "BANNER":
                    b = 0;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                zzrVar2 = new zzr(context, AdSize.BANNER);
            } else if (b == 1 || b == 2) {
                zzrVar2 = new zzr("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
            } else if (b != 3) {
                zzrVar2 = b != 4 ? new zzr() : zzr.zzb();
            } else {
                zzrVar2 = zzr.zzc();
            }
        } else {
            zzrVar2 = zzrVar;
        }
        zzfcuVar.zzt(zzrVar2);
        zzfcuVar.zzA(true);
        zzfcuVar.zzB(bundle);
        zzcvfVar.zzk(zzfcuVar.zzL());
        zzcvfVar.zzi(i);
        zzabVarZzo.zza(zzcvfVar.zzl());
        zzaa zzaaVar = new zzaa(19);
        zzaaVar.zza = str2;
        zzaaVar.zzb = str3;
        zzaaVar.zzc = zzbzeVar;
        zzabVarZzo.zzb(new zzaz(zzaaVar));
        new zzdbu();
        return zzabVarZzo.zzc();
    }

    public final zzgde zzS(final String str) {
        final zzdny[] zzdnyVarArr = new zzdny[1];
        ListenableFuture listenableFutureZza = this.zzj.zza();
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaf
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                zzdny zzdnyVar = (zzdny) obj;
                zzdnyVarArr[0] = zzdnyVar;
                zzau zzauVar = this.zza;
                Context context = zzauVar.zzg;
                zzbui zzbuiVar = zzauVar.zzm;
                Map map = zzbuiVar.zzb;
                JSONObject jSONObjectZzd = Okio.zzd(context, map, map, zzbuiVar.zza, null);
                JSONObject jSONObjectZzh = Okio.zzh(zzauVar.zzg, zzauVar.zzm.zza);
                JSONObject jSONObjectZzg = Okio.zzg(zzauVar.zzm.zza);
                JSONObject jSONObjectZze = Okio.zze(zzauVar.zzg, zzauVar.zzm.zza);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("asset_view_signal", jSONObjectZzd);
                jSONObject.put("ad_view_signal", jSONObjectZzh);
                jSONObject.put("scroll_view_signal", jSONObjectZzg);
                jSONObject.put("lock_screen_signal", jSONObjectZze);
                String str2 = str;
                if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str2)) {
                    jSONObject.put("click_signal", Okio.zzc(null, zzauVar.zzg, zzauVar.zzo, zzauVar.zzn));
                }
                return zzdnyVar.zzg(str2, jSONObject);
            }
        };
        zzgdy zzgdyVar = this.zzk;
        ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZza, zzgcuVar, zzgdyVar);
        listenableFutureZzn.addListener(new zza(this, zzdnyVarArr, 23), zzgdyVar);
        final int i = 0;
        zzgde zzgdeVar = (zzgde) zzgdn.zzm((zzgde) zzgdn.zzo(zzgde.zzw(listenableFutureZzn), ((Integer) zzbd.zza.zzd.zzb(zzbde.zzhV)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzam
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                switch (i) {
                    case 0:
                        ArrayList arrayList = zzau.zza;
                        return ((JSONObject) obj).optString("nas");
                    default:
                        ArrayList arrayList2 = zzau.zza;
                        int i2 = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", (Exception) obj);
                        return null;
                }
            }
        }, zzgdyVar);
        final int i2 = 1;
        return (zzgde) zzgdn.zze(zzgdeVar, Exception.class, new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzam
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                switch (i2) {
                    case 0:
                        ArrayList arrayList = zzau.zza;
                        return ((JSONObject) obj).optString("nas");
                    default:
                        ArrayList arrayList2 = zzau.zza;
                        int i3 = zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", (Exception) obj);
                        return null;
                }
            }
        }, zzgdyVar);
    }

    public final void zzT() {
        if (!((Boolean) zzbfj.zze.zze()).booleanValue()) {
            zzgdn.zzr(((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlz)).booleanValue() ? zzgdn.zzk(new ProfileCache(this, 25), zzcaf.zza) : zzR(this.zzg, null, "BANNER", null, null, 0, null, new Bundle(), null).zzb(), new AccessTokenCache(this), this.zzf.zzA());
            return;
        }
        zzo zzoVar = this.zzJ;
        synchronized (zzoVar) {
            zzoVar.zzh(true);
            zzoVar.zzh(false);
        }
    }

    public final void zzU() {
        zzbcv zzbcvVar = zzbde.zzjY;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzkb)).booleanValue()) {
                return;
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzkf)).booleanValue() && this.zzF.getAndSet(true)) {
                return;
            }
            zzT();
        }
    }

    public final void zzV(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ListenableFuture listenableFutureZzn;
        Map map;
        int i = 0;
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhU)).booleanValue()) {
            int i2 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The updating URL feature is not enabled.");
            try {
                zzbufVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                return;
            }
        }
        Iterator it = list.iterator();
        int i3 = 0;
        while (true) {
            boolean zHasNext = it.hasNext();
            arrayList = this.zzC;
            arrayList2 = this.zzB;
            if (!zHasNext) {
                break;
            } else if (zzX((Uri) it.next(), arrayList2, arrayList)) {
                i3++;
            }
        }
        if (i3 > 1) {
            String strValueOf = String.valueOf(list);
            int i4 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Multiple google urls found: ".concat(strValueOf));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Uri uri = (Uri) it2.next();
            if (zzX(uri, arrayList2, arrayList)) {
                com.android.billingclient.api.zzr zzrVar = new com.android.billingclient.api.zzr(this, uri, iObjectWrapper, 4);
                zzgdy zzgdyVar = this.zzk;
                ListenableFuture listenableFutureZzb = zzgdyVar.zzb(zzrVar);
                zzbui zzbuiVar = this.zzm;
                if (zzbuiVar == null || (map = zzbuiVar.zzb) == null || map.isEmpty()) {
                    int i5 = zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Asset view map is empty.");
                    listenableFutureZzn = listenableFutureZzb;
                } else {
                    listenableFutureZzn = zzgdn.zzn(listenableFutureZzb, new zzai(this, i), zzgdyVar);
                }
            } else {
                String strValueOf2 = String.valueOf(uri);
                int i6 = zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Not a Google URL: ".concat(strValueOf2));
                listenableFutureZzn = zzgdn.zzh(uri);
            }
            arrayList3.add(listenableFutureZzn);
        }
        zzgdn.zzr(zzgdn.zzd(arrayList3), new com.google.android.gms.tasks.zzr(this, zzbufVar, z, 2), this.zzf.zzA());
    }

    public final void zzW(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar, boolean z) {
        Map map;
        int i = 1;
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhU)).booleanValue()) {
            try {
                zzbufVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                int i2 = zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                return;
            }
        }
        com.android.billingclient.api.zzr zzrVar = new com.android.billingclient.api.zzr(this, list, iObjectWrapper, 5);
        zzgdy zzgdyVar = this.zzk;
        ListenableFuture listenableFutureZzb = zzgdyVar.zzb(zzrVar);
        zzbui zzbuiVar = this.zzm;
        if (zzbuiVar == null || (map = zzbuiVar.zzb) == null || map.isEmpty()) {
            int i3 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Asset view map is empty.");
        } else {
            listenableFutureZzb = zzgdn.zzn(listenableFutureZzb, new zzai(this, i), zzgdyVar);
        }
        zzgdn.zzr(listenableFutureZzb, new com.google.android.gms.tasks.zzr(this, zzbufVar, z, 1), this.zzf.zzA());
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzkl)).booleanValue()) {
            return new ObjectWrapper(null);
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        CustomTabsClient customTabsClient = (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2);
        CustomTabsCallback customTabsCallback = (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3);
        zzbej zzbejVar = this.zzI;
        zzbejVar.zzg(context, customTabsClient, str, customTabsCallback);
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            zzo zzoVar = this.zzJ;
            synchronized (zzoVar) {
                zzoVar.zzh(true);
                zzoVar.zzh(false);
            }
        }
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            this.zzK.zzb(null);
        }
        return new ObjectWrapper(zzbejVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzg(zzbui zzbuiVar) {
        this.zzm = zzbuiVar;
        this.zzj.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzV(list, iObjectWrapper, zzbufVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzW(list, iObjectWrapper, zzbufVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzj(IObjectWrapper iObjectWrapper) {
        zzbcv zzbcvVar = zzbde.zzjX;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzbcv zzbcvVar2 = zzbde.zzhL;
            zzbdc zzbdcVar = zzbdVar.zzd;
            if (!((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                int i = zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("The webView cannot be null.");
                return;
            }
            zzgdy zzgdyVar = zzcaf.zzf;
            zzf zzfVar = this.zzK;
            zzj zzjVar = new zzj(webView, zzfVar, zzgdyVar);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ, zzfVar, zzjVar), "gmaSdk");
            if (((Boolean) zzbdcVar.zzb(zzbde.zzkh)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzs();
            }
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                zzfVar.zzb(webView);
                if (((Boolean) zzbfj.zzd.zze()).booleanValue()) {
                    zzcaf.zzd.scheduleWithFixedDelay(new zzh(zzjVar, 1), 0L, ((Integer) zzbdcVar.zzb(zzbde.zzki)).intValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
                zzU();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhU)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbui zzbuiVar = this.zzm;
            View view = zzbuiVar == null ? null : zzbuiVar.zza;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationOnScreen(iArr);
            }
            this.zzn = new Point(((int) motionEvent.getRawX()) - iArr[0], ((int) motionEvent.getRawY()) - iArr[1]);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzn;
            motionEventObtain.setLocation(point.x, point.y);
            this.zzh.zzd(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzV(list, iObjectWrapper, zzbufVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzW(list, iObjectWrapper, zzbufVar, false);
    }

    static {
        String str = wsbWxekY.CUxRT;
        zzb = new ArrayList(Arrays.asList(str, ".googleadservices.com"));
        zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
        zzd = new ArrayList(Arrays.asList(str, ".googleadservices.com", ".googlesyndication.com"));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:29:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:9:0x005f A[PHI: r2
  0x005f: PHI (r2v2 int) = (r2v1 int), (r2v1 int), (r2v1 int), (r2v11 int) binds: [B:6:0x0051, B:8:0x005d, B:11:0x006c, B:14:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzf(IObjectWrapper iObjectWrapper, zzbze zzbzeVar, zzbyx zzbyxVar) {
        int i;
        ListenableFuture listenableFutureZzh;
        ListenableFuture listenableFutureZzb;
        ListenableFuture listenableFuture;
        ListenableFuture listenableFutureZzg;
        Bundle bundle = new Bundle();
        zzbcv zzbcvVar = zzbde.zzcq;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            bundle.putLong(zzdrr.PUBLIC_API_CALL.zza(), zzbzeVar.zzd.zzz);
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.DYNAMITE_ENTER.zza());
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfhj zzfhjVarZza = zzfhi.zza(context, 22);
        zzfhjVarZza.zzi();
        zzbcv zzbcvVar2 = zzbde.zzhN;
        zzbdc zzbdcVar = zzbdVar.zzd;
        int i2 = 0;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
            zzm zzmVar = zzbzeVar.zzd;
            if (zzmVar.zzc.getBoolean("optimize_for_app_start", false) && Objects.equals(MediaType.Companion.zzc(zzmVar), GsPcpBmONXh.uDOKplOqIJ)) {
                i2 = 2;
                if (zzbzeVar.zze == 2) {
                    i = i2;
                } else {
                    i = 1;
                }
            } else {
                i = i2;
            }
        } else {
            i = i2;
        }
        String str = zzbzeVar.zzb;
        if ("UNKNOWN".equals(str)) {
            List arrayList = new ArrayList();
            zzbcv zzbcvVar3 = zzbde.zzhM;
            if (!((String) zzbdcVar.zzb(zzbcvVar3)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzbdcVar.zzb(zzbcvVar3)).split(","));
            }
            if (arrayList.contains(MediaType.Companion.zzc(zzbzeVar.zzd))) {
                ListenableFuture listenableFutureZzg2 = zzgdn.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFutureZzg = zzgdn.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture = listenableFutureZzg2;
            } else {
                if (((Boolean) zzbdcVar.zzb(zzbde.zzlz)).booleanValue()) {
                    zzgdy zzgdyVar = zzcaf.zza;
                    listenableFutureZzh = zzgdyVar.zzb(new FontRequestWorker.AnonymousClass1(this, zzbzeVar, i, bundle));
                    listenableFutureZzb = zzgdn.zzn(listenableFutureZzh, new zzal(), zzgdyVar);
                } else {
                    zzac zzacVarZzR = zzR(this.zzg, zzbzeVar.zza, str, zzbzeVar.zzc, zzbzeVar.zzd, i, zzbzeVar.zzf, bundle, zzbzeVar);
                    listenableFutureZzh = zzgdn.zzh(zzacVarZzR);
                    listenableFutureZzb = zzacVarZzR.zzb();
                }
                listenableFuture = listenableFutureZzh;
                listenableFutureZzg = listenableFutureZzb;
            }
        } else {
            if (((Boolean) zzbdcVar.zzb(zzbde.zzlz)).booleanValue()) {
                zzgdy zzgdyVar2 = zzcaf.zza;
                listenableFutureZzh = zzgdyVar2.zzb(new FontRequestWorker.AnonymousClass1(this, zzbzeVar, i, bundle));
                listenableFutureZzb = zzgdn.zzn(listenableFutureZzh, new zzal(), zzgdyVar2);
            } else {
                zzac zzacVarZzR2 = zzR(this.zzg, zzbzeVar.zza, str, zzbzeVar.zzc, zzbzeVar.zzd, i, zzbzeVar.zzf, bundle, zzbzeVar);
                listenableFutureZzh = zzgdn.zzh(zzacVarZzR2);
                listenableFutureZzb = zzacVarZzR2.zzb();
            }
            listenableFuture = listenableFutureZzh;
            listenableFutureZzg = listenableFutureZzb;
        }
        zzgdn.zzr(listenableFutureZzg, new Request.Builder(this, listenableFuture, zzbzeVar, zzbyxVar, zzfhjVarZza), this.zzf.zzA());
    }
}
