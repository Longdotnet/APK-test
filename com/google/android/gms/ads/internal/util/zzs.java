package com.google.android.gms.ads.internal.util;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SimpleSQLiteQuery;
import com.android.billingclient.api.BillingFlowParams;
import com.daerisoft.thespikerm.RunnerActivity;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbwa;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzdpm;
import com.google.android.gms.internal.ads.zzdsi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzfca;
import com.google.android.gms.internal.ads.zzfcd;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfwe;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzhhh;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.collections.MapsKt__MapsKt;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzs {
    public static final zzf zza = new zzf(Looper.getMainLooper());
    public String zzh;
    public volatile String zzi;
    public final AtomicReference zzb = new AtomicReference(null);
    public final AtomicReference zzc = new AtomicReference(null);
    public final AtomicReference zzd = new AtomicReference(new Bundle());
    public final AtomicBoolean zze = new AtomicBoolean();
    public boolean zzf = true;
    public final Object zzg = new Object();
    public boolean zzj = false;
    public boolean zzk = false;
    public final ExecutorService zzl = Executors.newSingleThreadExecutor();

    public static final zzbr zzA(Context context) {
        try {
            Object objNewInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(null).newInstance(null);
            if (!(objNewInstance instanceof IBinder)) {
                int i = zze.$r8$clinit;
                zzo.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) objNewInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            return iInterfaceQueryLocalInterface instanceof zzbr ? (zzbr) iInterfaceQueryLocalInterface : new zzbp(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean zzB(Context context, String str) {
        Context contextZza = zzbwa.zza(context);
        return Wrappers.packageManager(contextZza).val$context.getPackageManager().checkPermission(str, contextZza.getPackageName()) == 0;
    }

    public static final boolean zzC(Context context) {
        try {
            if (Hex.zzm == null) {
                Hex.zzm = Boolean.valueOf(Hex.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE"));
            }
            return Hex.zzm.booleanValue();
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public static final boolean zzD(String str) {
        if (!zzl.zzk()) {
            return false;
        }
        zzbcv zzbcvVar = zzbde.zzfv;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzbdVar.zzd.zzb(zzbde.zzfx);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfw);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean zzF(Context context) {
        try {
            context.getClassLoader().loadClass(mnwSv.UqaIm);
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            int i = zze.$r8$clinit;
            zzo.zzh("Error loading class.", th);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzH(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    return runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode() || (powerManager = (PowerManager) context.getSystemService("power")) == null || !powerManager.isScreenOn();
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzI(Context context) {
        try {
            Bundle bundleZzaa = zzaa(context);
            return TextUtils.isEmpty(zzab(bundleZzaa)) && !TextUtils.isEmpty(bundleZzaa.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
        } catch (RemoteException unused) {
        }
    }

    public static final boolean zzJ(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static final AlertDialog.Builder zzL(Context context) {
        zzt zztVar = com.google.android.gms.ads.internal.zzv.zza.zzg;
        return new AlertDialog.Builder(context, R.style.Theme.Material.Dialog.Alert);
    }

    public static final boolean zzO(zzfca zzfcaVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznJ)).booleanValue() && zzfcaVar != null && zzfcaVar.zze == 4;
    }

    public static final int zzP(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String strConcat = "Could not parse value:".concat(e.toString());
            int i = zze.$r8$clinit;
            zzo.zzj(strConcat);
            return 0;
        }
    }

    public static final HashMap zzQ(Uri uri) {
        String encodedQuery;
        if (uri == null) {
            return null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzr)).booleanValue()) {
            HashMap map = new HashMap();
            for (String str : uri.getQueryParameterNames()) {
                if (!TextUtils.isEmpty(str)) {
                    map.put(str, uri.getQueryParameter(str));
                }
            }
            return map;
        }
        HashMap map2 = new HashMap();
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            int i = 0;
            while (true) {
                int iIndexOf = encodedQuery.indexOf(38, i);
                int length = encodedQuery.length();
                if (iIndexOf != -1) {
                    length = iIndexOf;
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i);
                if (iIndexOf2 > length || iIndexOf2 == -1) {
                    iIndexOf2 = length;
                }
                map2.put(Uri.decode(encodedQuery.substring(i, iIndexOf2)), iIndexOf2 == length ? "" : Uri.decode(encodedQuery.substring(iIndexOf2 + 1, length)));
                if (iIndexOf == -1) {
                    break;
                }
                i = iIndexOf + 1;
            }
        }
        return map2;
    }

    public static final int[] zzR(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? new int[]{0, 0} : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public static final int[] zzS(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        int[] iArr = (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? new int[]{0, 0} : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        com.google.android.gms.ads.internal.client.zzbb zzbbVar = com.google.android.gms.ads.internal.client.zzbb.zzb;
        return new int[]{zzbbVar.zzc.zzb(activity, iArr[0]), zzbbVar.zzc.zzb(activity, iArr[1])};
    }

    public static final boolean zzT(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = com.google.android.gms.ads.internal.zzv.zza.zzd.zzf || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzo(view);
        long jZzx = zzx(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z)) {
            zzbcv zzbcvVar = zzbde.zzby;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                zzbcv zzbcvVar2 = zzbde.zzkZ;
                zzbdc zzbdcVar = zzbdVar.zzd;
                if (!((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue() || jZzx >= ((Integer) zzbdcVar.zzb(zzbde.zzlb)).intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void zzU(Context context, Intent intent) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlw)).booleanValue()) {
            try {
                context.startActivity(intent);
                return;
            } catch (Throwable unused) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
        }
        try {
            try {
                context.startActivity(intent);
            } catch (SecurityException e) {
                int i = zze.$r8$clinit;
                zzo.zzk("", e);
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.startActivityWithUnknownContext");
            }
        } catch (Throwable unused2) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static final void zzV(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzp(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String str = "Opening " + uri.toString() + " in a new browser.";
            int i = zze.$r8$clinit;
            zzo.zze(str);
        } catch (ActivityNotFoundException e) {
            int i2 = zze.$r8$clinit;
            zzo.zzh("No browser is found.", e);
        }
    }

    public static int zza(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "HTTP timeout too low: ", " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        int i2 = zze.$r8$clinit;
        zzo.zzj(strM);
        return 60000;
    }

    public static Bundle zzaa(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(128, context.getPackageName()).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zze.zzb("Error getting metadata", e);
            return null;
        }
    }

    public static String zzab(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "";
    }

    public static boolean zzac(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern patternCompile = (Pattern) atomicReference.get();
            if (patternCompile == null || !str2.equals(patternCompile.pattern())) {
                patternCompile = Pattern.compile(str2);
                atomicReference.set(patternCompile);
            }
            return patternCompile.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static final String zzaf(Context context, String str) {
        Context contextCreatePackageContext;
        if (str == null) {
            return zzr();
        }
        String strZzr = null;
        try {
            if (SimpleSQLiteQuery.zzb == null) {
                SimpleSQLiteQuery.zzb = new SimpleSQLiteQuery();
            }
            SimpleSQLiteQuery simpleSQLiteQuery = SimpleSQLiteQuery.zzb;
            if (TextUtils.isEmpty(simpleSQLiteQuery.mQuery)) {
                int i = GooglePlayServicesUtil.$r8$clinit;
                try {
                    contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
                } catch (PackageManager.NameNotFoundException unused) {
                    contextCreatePackageContext = null;
                }
                simpleSQLiteQuery.mQuery = (String) MapsKt__MapsKt.zza(context, new zzh(contextCreatePackageContext, context, 1));
            }
            strZzr = simpleSQLiteQuery.mQuery;
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(strZzr)) {
            strZzr = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(strZzr)) {
            strZzr = zzr();
        }
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strZzr, " (Mobile; ", str);
        try {
            if (Wrappers.packageManager(context).isCallerInstantApp()) {
                strM = strM + ";aia";
            }
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.getUserAgent");
        }
        return strM.concat(")");
    }

    public static ArrayList zzd() {
        zzbcv zzbcvVar = zzbde.zza;
        List listZzb = com.google.android.gms.ads.internal.client.zzbd.zza.zzb.zzb();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZzb.iterator();
        while (it.hasNext()) {
            Iterator it2 = zzfwe.zzb(zzfva.zzc(',')).zzd((String) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(Long.valueOf((String) it2.next()));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public static final boolean zzo(View view) {
        Activity activity;
        View rootView = view.getRootView();
        if (rootView == null) {
            activity = null;
        } else {
            Context context = rootView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
        }
        if (activity == null) {
            return false;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        return (attributes == null || (attributes.flags & 524288) == 0) ? false : true;
    }

    public static final void zzp(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        extras.putBinder("android.support.customtabs.extra.SESSION", null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }

    public static final String zzq(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzab(zzaa(context));
    }

    public static final String zzs() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, " ", str2);
    }

    public static final HashMap zzw(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String str2 = (String) itKeys.next();
                HashSet hashSet = new HashSet();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str2);
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (strOptString != null) {
                            hashSet.add(strOptString);
                        }
                    }
                    map.put(str2, hashSet);
                }
            }
            return map;
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.getMapOfFileNamesToKeysFromJsonString");
            return map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.ViewParent] */
    public static final long zzx(View view) {
        float fMin = Float.MAX_VALUE;
        do {
            if (!(view instanceof View)) {
                break;
            }
            View view2 = (View) view;
            fMin = Math.min(fMin, view2.getAlpha());
            view = view2.getParent();
        } while (fMin > 0.0f);
        return Math.round((fMin >= 0.0f ? fMin : 0.0f) * 100.0f);
    }

    public final String zzc(Context context, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlI)).booleanValue()) {
            if (this.zzi != null) {
                return this.zzi;
            }
            this.zzi = zzaf(context, str);
            return this.zzi;
        }
        synchronized (this.zzg) {
            try {
                String str2 = this.zzh;
                if (str2 != null) {
                    return str2;
                }
                String strZzaf = zzaf(context, str);
                this.zzh = strZzaf;
                return strZzaf;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzg(Context context, String str, HttpURLConnection httpURLConnection, int i) {
        int iZza = zza(i);
        String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iZza, "HTTP timeout: ", " milliseconds.");
        int i2 = zze.$r8$clinit;
        zzo.zzi(strM);
        httpURLConnection.setConnectTimeout(iZza);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(iZza);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("User-Agent"))) {
            httpURLConnection.setRequestProperty("User-Agent", zzc(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    public final void zzl(Context context) {
        if (this.zzk) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbde.zza(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlv)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new RunnerActivity.AnonymousClass2(1), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new RunnerActivity.AnonymousClass2(1), intentFilter, 4);
        }
        this.zzk = true;
    }

    public final void zzm(Context context) {
        if (this.zzj) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbde.zza(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlv)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzq(this), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzq(this), intentFilter, 4);
        }
        this.zzj = true;
    }

    public final int zzn(Context context, Uri uri) {
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!(context instanceof Activity)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return 2;
        }
        zzbcv zzbcvVar = zzbde.zzeT;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean zBooleanValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue();
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (zBooleanValue) {
            RoomOpenHelper roomOpenHelperBuild = new BillingFlowParams(com.google.android.gms.ads.internal.zzv.zza.zzo.zza()).build();
            if (((Boolean) zzbdcVar.zzb(zzbde.zzff)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
                if (com.google.android.gms.ads.internal.util.client.zzf.zzw()) {
                    return 5;
                }
            }
            ((Intent) roomOpenHelperBuild.mConfiguration).setPackage(zzhhh.zza(context));
            roomOpenHelperBuild.launchUrl(context, uri);
            return 5;
        }
        if (((Boolean) zzbdcVar.zzb(zzbde.zzeR)).booleanValue()) {
            zzbef zzbefVar = new zzbef();
            zzbefVar.zze(new com.google.firebase.auth.zzaa(this, zzbefVar, context, uri));
            zzbefVar.zzb((Activity) context);
            return 5;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(uri);
        intent2.addFlags(268435456);
        context.startActivity(intent2);
        return 9;
    }

    public static final void zzK(View view, int i) {
        String strZza;
        int i2;
        int iHeight;
        int iWidth;
        String str;
        zzfca zzfcaVarZzD;
        zzfcd zzfcdVarZzR;
        View childAt = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = view.getContext().getPackageName();
            if (childAt instanceof zzdpm) {
                childAt = ((zzdpm) childAt).getChildAt(0);
            }
            if (childAt instanceof NativeAdView) {
                strZza = "NATIVE";
                i2 = 1;
            } else {
                strZza = "UNKNOWN";
                i2 = 0;
            }
            if (childAt.getLocalVisibleRect(rect)) {
                iWidth = rect.width();
                iHeight = rect.height();
            } else {
                iHeight = 0;
                iWidth = 0;
            }
            zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            long jZzx = zzx(childAt);
            childAt.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            String str2 = "none";
            if (!(childAt instanceof zzcgj) || (zzfcdVarZzR = ((zzcgj) childAt).zzR()) == null) {
                str = "none";
            } else {
                str = zzfcdVarZzR.zzb;
                childAt.setContentDescription(str + ":" + childAt.hashCode());
            }
            if ((childAt instanceof zzcex) && (zzfcaVarZzD = ((zzcex) childAt).zzD()) != null) {
                strZza = zzfca.zza(zzfcaVarZzD.zzb);
                i2 = zzfcaVarZzD.zze;
                str2 = zzfcaVarZzD.zzE;
            }
            Locale locale = Locale.US;
            String str3 = "<Ad hashCode=" + childAt.hashCode() + ", package=" + packageName + ", adNetCls=" + str2 + ", gwsQueryId=" + str + sgtsHsWT.hGge + strZza + ", impType=" + i2 + ", class=" + childAt.getClass().getName() + ", x=" + i3 + ", y=" + i4 + ", width=" + childAt.getWidth() + ", height=" + childAt.getHeight() + ", vWidth=" + iWidth + ", vHeight=" + iHeight + ", alpha=" + jZzx + ", state=" + Integer.toString(i, 2) + ">";
            int i5 = zze.$r8$clinit;
            zzo.zzi(str3);
        } catch (Exception e) {
            int i6 = zze.$r8$clinit;
            zzo.zzh("Failure getting view location.", e);
        }
    }

    public static final void zzY(Context context, Intent intent, zzdsj zzdsjVar, String str) {
        zzbcv zzbcvVar = zzbde.zznx;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() || !(context instanceof zzchc)) {
            zzU(context, intent);
            return;
        }
        try {
            Uri data = intent.getData();
            if (data != null && data.toString() != null) {
                if (data.toString().matches((String) zzbdVar.zzd.zzb(zzbde.zznz))) {
                    ((zzchc) context).zzc(intent, 236);
                    if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzny)).booleanValue() || zzdsjVar == null) {
                        return;
                    }
                    zzdsi zzdsiVarZza = zzdsjVar.zza();
                    zzdsiVarZza.zzb(ZRqOdXiy.sLHjdi, "hila");
                    zzdsiVarZza.zzb("gqi", zzfwg.zzc(str));
                    zzdsiVarZza.zzi();
                    return;
                }
            }
            zzU(context, intent);
        } catch (ActivityNotFoundException e) {
            e = e;
            int i = zze.$r8$clinit;
            zzo.zzh("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.startActivityForResult");
            zzU(context, intent);
        } catch (SecurityException e2) {
            e = e2;
            int i2 = zze.$r8$clinit;
            zzo.zzh("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdUtil.startActivityForResult");
            zzU(context, intent);
        } catch (Exception e3) {
            int i3 = zze.$r8$clinit;
            zzo.zzh("Error occurred while starting activity for result", e3);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e3, "AdUtil.startActivityForResult");
            zzU(context, intent);
        }
    }

    public static final String zzr() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        String str2 = MnHfHMYQDPUO.zJuA;
        sb.append(str2);
        sb.append(Locale.getDefault());
        String str3 = Build.DEVICE;
        if (str3 != null) {
            sb.append(str2);
            sb.append(str3);
            String str4 = Build.DISPLAY;
            if (str4 != null) {
                sb.append(" Build/");
                sb.append(str4);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }
}
