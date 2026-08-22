package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcz<T> {
    public static final /* synthetic */ int zzd = 0;
    private static volatile zzcy zze;
    private static volatile boolean zzf;
    final zzcx zzb;
    final String zzc;
    private final T zzj;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzcz<?>>> zzg = new AtomicReference<>();
    private static final zzdb zzh = new zzdb(zzcr.zza, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ zzcz(zzcx zzcxVar, String str, Object obj, boolean z, zzct zzctVar) {
        if (zzcxVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzb = zzcxVar;
        this.zzc = str;
        this.zzj = obj;
        this.zzm = true;
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zza;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            try {
                                zzcy zzcyVar = zze;
                                Context applicationContext = context.getApplicationContext();
                                if (applicationContext != null) {
                                    context = applicationContext;
                                }
                                if (zzcyVar == null || zzcyVar.zza() != context) {
                                    zzcg.zzd();
                                    zzda.zzc();
                                    zzcn.zze();
                                    zze = new zzcd(context, zzdk.zza(new zzdg() { // from class: com.google.android.gms.internal.auth.zzcs
                                        @Override // com.google.android.gms.internal.auth.zzdg
                                        public final Object zza() {
                                            zzde zzdeVarZzc;
                                            zzde zzdeVarZzc2;
                                            Context contextCreateDeviceProtectedStorageContext = context;
                                            int i = zzcz.zzd;
                                            String str = Build.TYPE;
                                            String str2 = Build.TAGS;
                                            if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
                                                return zzde.zzc();
                                            }
                                            if (zzcc.zza() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
                                                contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
                                            }
                                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                            try {
                                                StrictMode.allowThreadDiskWrites();
                                                try {
                                                    File file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
                                                    zzdeVarZzc = file.exists() ? zzde.zzd(file) : zzde.zzc();
                                                } catch (RuntimeException e) {
                                                    Log.e("HermeticFileOverrides", "no data dir", e);
                                                    zzdeVarZzc = zzde.zzc();
                                                }
                                                if (zzdeVarZzc.zzb()) {
                                                    File file2 = (File) zzdeVarZzc.zza();
                                                    try {
                                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                                        try {
                                                            HashMap map = new HashMap();
                                                            HashMap map2 = new HashMap();
                                                            while (true) {
                                                                String line = bufferedReader.readLine();
                                                                if (line == null) {
                                                                    break;
                                                                }
                                                                String[] strArrSplit = line.split(" ", 3);
                                                                if (strArrSplit.length != 3) {
                                                                    Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                                                                } else {
                                                                    String str3 = new String(strArrSplit[0]);
                                                                    String strDecode = Uri.decode(new String(strArrSplit[1]));
                                                                    String strDecode2 = (String) map2.get(strArrSplit[2]);
                                                                    if (strDecode2 == null) {
                                                                        String str4 = new String(strArrSplit[2]);
                                                                        strDecode2 = Uri.decode(str4);
                                                                        if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                                            map2.put(str4, strDecode2);
                                                                        }
                                                                    }
                                                                    if (!map.containsKey(str3)) {
                                                                        map.put(str3, new HashMap());
                                                                    }
                                                                    ((Map) map.get(str3)).put(strDecode, strDecode2);
                                                                }
                                                            }
                                                            String strValueOf = String.valueOf(file2);
                                                            StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                                                            sb.append("Parsed ");
                                                            sb.append(strValueOf);
                                                            Log.i("HermeticFileOverrides", sb.toString());
                                                            zzco zzcoVar = new zzco(map);
                                                            bufferedReader.close();
                                                            zzdeVarZzc2 = zzde.zzd(zzcoVar);
                                                        } catch (Throwable th) {
                                                            try {
                                                                bufferedReader.close();
                                                            } catch (Throwable th2) {
                                                                th.addSuppressed(th2);
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (IOException e2) {
                                                        throw new RuntimeException(e2);
                                                    }
                                                } else {
                                                    zzdeVarZzc2 = zzde.zzc();
                                                }
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                                return zzdeVarZzc2;
                                            } catch (Throwable th3) {
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                                                throw th3;
                                            }
                                        }
                                    }));
                                    zzi.incrementAndGet();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public abstract T zza(Object obj);

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00de A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e6 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f8 A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:59:0x010c A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x010f A[Catch: all -> 0x0068, TryCatch #0 {all -> 0x0068, blocks: (B:12:0x001d, B:14:0x0021, B:16:0x0027, B:18:0x003c, B:20:0x0048, B:22:0x0051, B:24:0x0063, B:28:0x0071, B:27:0x006b, B:55:0x00e8, B:57:0x00f8, B:59:0x010c, B:60:0x010f, B:61:0x0113, B:43:0x00c0, B:45:0x00c6, B:49:0x00d8, B:51:0x00de, B:54:0x00e6, B:48:0x00d6, B:30:0x0076, B:32:0x007c, B:34:0x008a, B:38:0x00af, B:40:0x00b9, B:36:0x00a1, B:62:0x0118, B:63:0x011d, B:64:0x011e), top: B:70:0x001d }] */
    public final T zzb() {
        zzck zzckVarZza;
        Object objZzb;
        T tZza;
        String str;
        String strZzb;
        zzde<zzco> zzdeVarZza;
        String strZza;
        if (!this.zzm && this.zzc == null) {
            throw new NullPointerException(kBfGXgdfpo.mlNf);
        }
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                try {
                    if (this.zzk < i) {
                        zzcy zzcyVar = zze;
                        if (zzcyVar == null) {
                            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                        }
                        boolean z = this.zzb.zzf;
                        String strZzb2 = zzcn.zza(zzcyVar.zza()).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                        if (strZzb2 == null || !zzcb.zzc.matcher(strZzb2).matches()) {
                            if (this.zzb.zzb == null) {
                                Context contextZza = zzcyVar.zza();
                                String str2 = this.zzb.zza;
                                zzckVarZza = zzda.zza(contextZza, null);
                            } else if (zzcp.zza(zzcyVar.zza(), this.zzb.zzb)) {
                                boolean z2 = this.zzb.zzh;
                                zzckVarZza = zzcg.zza(zzcyVar.zza().getContentResolver(), this.zzb.zzb);
                            } else {
                                zzckVarZza = null;
                            }
                            if (zzckVarZza != null && (objZzb = zzckVarZza.zzb(zzc())) != null) {
                                tZza = zza(objZzb);
                            }
                            if (tZza == null) {
                                if (this.zzb.zze) {
                                    tZza = null;
                                } else {
                                    zzcn zzcnVarZza = zzcn.zza(zzcyVar.zza());
                                    if (this.zzb.zze) {
                                        str = null;
                                    } else {
                                        str = this.zzc;
                                    }
                                    strZzb = zzcnVarZza.zzb(str);
                                    if (strZzb != null) {
                                        tZza = zza(strZzb);
                                    } else {
                                        tZza = null;
                                    }
                                }
                                if (tZza == null) {
                                    tZza = this.zzj;
                                }
                            }
                            zzdeVarZza = zzcyVar.zzb().zza();
                            if (zzdeVarZza.zzb()) {
                                zzco zzcoVarZza = zzdeVarZza.zza();
                                zzcx zzcxVar = this.zzb;
                                strZza = zzcoVarZza.zza(zzcxVar.zzb, null, zzcxVar.zzd, this.zzc);
                                if (strZza == null) {
                                    tZza = this.zzj;
                                } else {
                                    tZza = zza(strZza);
                                }
                            }
                            this.zzl = tZza;
                            this.zzk = i;
                        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                            String strValueOf = String.valueOf(zzc());
                            Log.d("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
                        }
                        tZza = null;
                        if (tZza == null) {
                            if (this.zzb.zze) {
                                zzcn zzcnVarZza2 = zzcn.zza(zzcyVar.zza());
                                if (this.zzb.zze) {
                                    str = null;
                                } else {
                                    str = this.zzc;
                                }
                                strZzb = zzcnVarZza2.zzb(str);
                                if (strZzb != null) {
                                    tZza = zza(strZzb);
                                } else {
                                    tZza = null;
                                }
                            } else {
                                tZza = null;
                            }
                            if (tZza == null) {
                                tZza = this.zzj;
                            }
                        }
                        zzdeVarZza = zzcyVar.zzb().zza();
                        if (zzdeVarZza.zzb()) {
                            zzco zzcoVarZza2 = zzdeVarZza.zza();
                            zzcx zzcxVar2 = this.zzb;
                            strZza = zzcoVarZza2.zza(zzcxVar2.zzb, null, zzcxVar2.zzd, this.zzc);
                            if (strZza == null) {
                                tZza = this.zzj;
                            } else {
                                tZza = zza(strZza);
                            }
                        }
                        this.zzl = tZza;
                        this.zzk = i;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzl;
    }
}
