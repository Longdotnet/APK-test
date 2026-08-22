package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzbun implements zzbup {
    public static zzbup zza;
    static zzbup zzb;
    static zzbup zzc;
    static Boolean zzd;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final VersionInfoParcel zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;
    private Set zzp;

    /* JADX WARN: Code duplicated, block: B:11:0x0050  */
    public zzbun(Context context, VersionInfoParcel versionInfoParcel) {
        PackageInfo packageInfo;
        String country;
        this.zzf = new Object();
        this.zzh = new WeakHashMap();
        zzfrv.zza();
        this.zzi = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zzn = new AtomicBoolean();
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzg = context;
        this.zzj = versionInfoParcel;
        String string = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzif)).booleanValue()) {
            zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.client.zzf.zza;
            if (context == null || context.getApplicationInfo() == null) {
                packageInfo = null;
            } else {
                try {
                    packageInfo = Wrappers.packageManager(context).getPackageInfo(0, context.getApplicationInfo().packageName);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
            }
        } else {
            packageInfo = null;
        }
        this.zzk = packageInfo;
        zzbcv zzbcvVar = zzbde.zzic;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzfrw zzfrwVar2 = com.google.android.gms.ads.internal.util.client.zzf.zza;
            country = Locale.getDefault().getCountry();
        } else {
            country = "unknown";
        }
        this.zzl = country;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            Context context2 = this.zzg;
            zzfrw zzfrwVar3 = com.google.android.gms.ads.internal.util.client.zzf.zza;
            if (context2 != null) {
                try {
                    PackageInfo packageInfo2 = Wrappers.packageManager(context2).getPackageInfo(128, "com.android.vending");
                    if (packageInfo2 != null) {
                        string = Integer.toString(packageInfo2.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
            }
        } else {
            string = "unknown";
        }
        this.zzm = string;
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhY)).intValue() > 0) {
            this.zzp = new HashSet();
        }
    }

    public static zzbup zza(Context context) {
        synchronized (zze) {
            try {
                if (zza == null) {
                    if (zzl(context)) {
                        zza = new zzbun(context, VersionInfoParcel.forPackage());
                    } else {
                        zza = new zzbuo();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    public static zzbup zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            try {
                if (zzc == null) {
                    boolean z = false;
                    if (((Boolean) zzbew.zzc.zze()).booleanValue()) {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhW)).booleanValue() || ((Boolean) zzbew.zza.zze()).booleanValue()) {
                            z = true;
                        }
                    }
                    if (zzl(context)) {
                        zzbun zzbunVar = new zzbun(context, versionInfoParcel);
                        zzbunVar.zzk();
                        zzbunVar.zzj();
                        zzc = zzbunVar;
                    } else if (!z || context == null) {
                        zzc = new zzbuo();
                    } else {
                        zzbun zzbunVar2 = new zzbun(context, versionInfoParcel, true);
                        zzbunVar2.zzk();
                        zzbunVar2.zzj();
                        zzc = zzbunVar2;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzc;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0037 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x0029, B:13:0x0037, B:14:0x003e), top: B:19:0x0003 }] */
    public static zzbup zzc(Context context) {
        synchronized (zze) {
            try {
                if (zzb == null) {
                    zzbcv zzbcvVar = zzbde.zzhX;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                    if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzhW)).booleanValue()) {
                            zzb = new zzbuo();
                        } else {
                            zzb = new zzbun(context, VersionInfoParcel.forPackage());
                        }
                    } else {
                        zzb = new zzbuo();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzb;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0033 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x0029, B:13:0x0033, B:14:0x003a), top: B:19:0x0003 }] */
    public static zzbup zzd(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            try {
                if (zzb == null) {
                    zzbcv zzbcvVar = zzbde.zzhX;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                    if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzhW)).booleanValue()) {
                            zzb = new zzbuo();
                        } else {
                            zzb = new zzbun(context, versionInfoParcel);
                        }
                    } else {
                        zzb = new zzbuo();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzb;
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzfwg.zzc(com.google.android.gms.ads.internal.util.client.zzf.zzE(zze(th), "SHA-256"));
    }

    private final void zzj() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbul(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzk() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            return;
        }
        synchronized (this.zzf) {
            this.zzh.put(thread, Boolean.TRUE);
        }
        thread.setUncaughtExceptionHandler(new zzbum(this, thread.getUncaughtExceptionHandler()));
    }

    private static boolean zzl(Context context) {
        if (context == null) {
            return false;
        }
        synchronized (zze) {
            try {
                if (zzd == null) {
                    zzd = Boolean.valueOf(com.google.android.gms.ads.internal.client.zzbb.zzb.zzg.nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzne)).intValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhW)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean zZzt = false;
            boolean zEquals = false;
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    zZzt |= com.google.android.gms.ads.internal.util.client.zzf.zzt(stackTraceElement.getClassName());
                    zEquals |= zzbun.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhY)).intValue();
            if (iIntValue > 0) {
                if (this.zzp.size() >= iIntValue) {
                    return;
                }
                String strZzf = zzf(th);
                if (this.zzp.contains(strZzf)) {
                    return;
                } else {
                    this.zzp.add(strZzf);
                }
            }
            if (!zZzt || zEquals) {
                return;
            }
            if (!this.zzo) {
                zzh(th, "");
            }
            if (this.zzn.getAndSet(true) || !((Boolean) zzbew.zzc.zze()).booleanValue()) {
                return;
            }
            zzbco.zzc(this.zzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzh(Throwable th, String str) {
        if (this.zzo) {
            return;
        }
        zzi(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzi(Throwable th, String str, float f) {
        Throwable th2;
        String packageName;
        PackageInfo packageInfo;
        ActivityManager activityManager;
        ActivityManager.MemoryInfo memoryInfo;
        if (this.zzo) {
            return;
        }
        zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.client.zzf.zza;
        boolean zIsCallerInstantApp = false;
        if (((Boolean) zzbfn.zze.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                linkedList.push(cause);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcB)).booleanValue() && stackTrace != null && stackTrace.length == 0 && com.google.android.gms.ads.internal.util.client.zzf.zzt(th3.getClass().getName());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (com.google.android.gms.ads.internal.util.client.zzf.zzt(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z) {
                    th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String strZze = zze(th);
            String strZzf = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjj)).booleanValue() ? zzf(th) : "";
            double d = f;
            double dRandom = Math.random();
            int i = f > 0.0f ? (int) (1.0f / f) : 1;
            if (dRandom < d) {
                ArrayList<String> arrayList2 = new ArrayList();
                try {
                    zIsCallerInstantApp = Wrappers.packageManager(this.zzg).isCallerInstantApp();
                } catch (Throwable th4) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Error fetching instant app info", th4);
                }
                try {
                    packageName = this.zzg.getPackageName();
                } catch (Throwable unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot obtain package name, proceeding.");
                    packageName = "unknown";
                }
                Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zIsCallerInstantApp)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE);
                int i2 = Build.VERSION.SDK_INT;
                Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter("api", String.valueOf(i2));
                String str2 = Build.MANUFACTURER;
                String strM = Build.MODEL;
                if (!strM.startsWith(str2)) {
                    strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str2, " ", strM);
                }
                Uri.Builder builderAppendQueryParameter3 = builderAppendQueryParameter2.appendQueryParameter("device", strM);
                VersionInfoParcel versionInfoParcel = this.zzj;
                Uri.Builder builderAppendQueryParameter4 = builderAppendQueryParameter3.appendQueryParameter("js", versionInfoParcel.afmaVersion).appendQueryParameter("appid", packageName).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", strZze);
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                Uri.Builder builderAppendQueryParameter5 = builderAppendQueryParameter4.appendQueryParameter("eids", TextUtils.join(",", zzbdVar.zzb.zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "785558560").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzbfn.zzc.zze()));
                Context context = this.zzg;
                GoogleApiAvailabilityLight.zza.getClass();
                Uri.Builder builderAppendQueryParameter6 = builderAppendQueryParameter5.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getApkVersion(context))).appendQueryParameter("lite", true != versionInfoParcel.isLiteSdk ? "0" : "1");
                if (!TextUtils.isEmpty(strZzf)) {
                    builderAppendQueryParameter6.appendQueryParameter("hash", strZzf);
                }
                zzbcv zzbcvVar = zzbde.zzid;
                zzbdc zzbdcVar = zzbdVar.zzd;
                if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
                    if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
                        memoryInfo = null;
                    } else {
                        memoryInfo = new ActivityManager.MemoryInfo();
                        try {
                            activityManager.getMemoryInfo(memoryInfo);
                        } catch (NullPointerException unused2) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Error retrieving the memory information.");
                        }
                    }
                    if (memoryInfo != null) {
                        builderAppendQueryParameter6.appendQueryParameter("available_memory", Long.toString(memoryInfo.availMem));
                        builderAppendQueryParameter6.appendQueryParameter("total_memory", Long.toString(memoryInfo.totalMem));
                        builderAppendQueryParameter6.appendQueryParameter("is_low_memory", true != memoryInfo.lowMemory ? "0" : "1");
                    }
                }
                if (((Boolean) zzbdcVar.zzb(zzbde.zzic)).booleanValue()) {
                    String str3 = this.zzl;
                    if (!TextUtils.isEmpty(str3)) {
                        builderAppendQueryParameter6.appendQueryParameter("countrycode", str3);
                    }
                    String str4 = this.zzm;
                    if (!TextUtils.isEmpty(str4)) {
                        builderAppendQueryParameter6.appendQueryParameter("psv", str4);
                    }
                    if (i2 >= 26) {
                        packageInfo = WebView.getCurrentWebViewPackage();
                    } else if (context == null) {
                        packageInfo = null;
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(context).getPackageInfo(128, "com.android.webview");
                        } catch (PackageManager.NameNotFoundException unused3) {
                            packageInfo = null;
                        }
                    }
                    if (packageInfo != null) {
                        builderAppendQueryParameter6.appendQueryParameter("wvvc", Integer.toString(packageInfo.versionCode));
                        builderAppendQueryParameter6.appendQueryParameter("wvvn", packageInfo.versionName);
                        builderAppendQueryParameter6.appendQueryParameter("wvpn", packageInfo.packageName);
                    }
                }
                PackageInfo packageInfo2 = this.zzk;
                if (packageInfo2 != null) {
                    builderAppendQueryParameter6.appendQueryParameter("appvc", String.valueOf(packageInfo2.versionCode));
                    builderAppendQueryParameter6.appendQueryParameter("appvn", packageInfo2.versionName);
                }
                arrayList2.add(builderAppendQueryParameter6.toString());
                for (final String str5 : arrayList2) {
                    final com.google.android.gms.ads.internal.util.client.zzu zzuVar = new com.google.android.gms.ads.internal.util.client.zzu(this.zzg, null);
                    this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbuk
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzuVar.zza(str5);
                        }
                    });
                }
            }
        }
    }

    public zzbun(Context context, VersionInfoParcel versionInfoParcel, boolean z) {
        this(context, versionInfoParcel);
        this.zzo = true;
    }
}
