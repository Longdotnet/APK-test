package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class zzw {
    private final Application zza;
    private final Handler zzb;
    private final Executor zzc;
    private final zzaq zzd;
    private final zzbo zze;
    private final zzn zzf;
    private final zzz zzg;
    private final zze zzh;

    public zzw(Application application, zzad zzadVar, Handler handler, Executor executor, zzaq zzaqVar, zzbo zzboVar, zzn zznVar, zzz zzzVar, zze zzeVar) {
        this.zza = application;
        this.zzb = handler;
        this.zzc = executor;
        this.zzd = zzaqVar;
        this.zze = zzboVar;
        this.zzf = zznVar;
        this.zzg = zzzVar;
        this.zzh = zzeVar;
    }

    public static void zza(final zzw zzwVar, Activity activity, ConsentRequestParameters consentRequestParameters, final ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, final ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        try {
            ConsentDebugSettings consentDebugSettings = consentRequestParameters.zzc;
            if (consentDebugSettings == null || !consentDebugSettings.zza) {
                Log.i("UserMessagingPlatform", "Use new ConsentDebugSettings.Builder().addTestDeviceHashedId(\"" + zzcm.zza(zzwVar.zza) + "\") to set this as a debug device.");
            }
            final zzab zzabVarZza = new zzy(zzwVar.zzg, zzwVar.zzd(zzwVar.zzf.zzc(activity, consentRequestParameters))).zza();
            zzaq zzaqVar = zzwVar.zzd;
            zzaqVar.zzg(zzabVarZza.zza);
            zzaqVar.zzi(zzabVarZza.zzb);
            zzwVar.zze.zzd(zzabVarZza.zzc);
            zzwVar.zzh.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzu
                @Override // java.lang.Runnable
                public final void run() {
                    zzw.zzb(this.zza, onConsentInfoUpdateSuccessListener, zzabVarZza);
                }
            });
        } catch (zzg e) {
            zzwVar.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzr
                @Override // java.lang.Runnable
                public final void run() {
                    onConsentInfoUpdateFailureListener.onConsentInfoUpdateFailure(e.zza());
                }
            });
        } catch (RuntimeException e2) {
            final zzg zzgVar = new zzg(1, "Caught exception when trying to request consent info update: ".concat(String.valueOf(Log.getStackTraceString(e2))));
            zzwVar.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzs
                @Override // java.lang.Runnable
                public final void run() {
                    onConsentInfoUpdateFailureListener.onConsentInfoUpdateFailure(zzgVar.zza());
                }
            });
        }
    }

    public static /* synthetic */ void zzb(zzw zzwVar, final ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, zzab zzabVar) {
        Objects.requireNonNull(onConsentInfoUpdateSuccessListener);
        zzwVar.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzt
            @Override // java.lang.Runnable
            public final void run() {
                onConsentInfoUpdateSuccessListener.onConsentInfoUpdateSuccess();
            }
        });
        if (zzabVar.zzb != ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED) {
            zzwVar.zze.zzc();
        }
    }

    public final void zzc(final Activity activity, final ConsentRequestParameters consentRequestParameters, final ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, final ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzv
            @Override // java.lang.Runnable
            public final void run() {
                zzw.zza(this.zza, activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
            }
        });
    }

    private final zzcl zzd(zzcj zzcjVar) throws zzg {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://fundingchoicesmessages.google.com/a/consent").openConnection();
            httpURLConnection.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(this.zza));
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            try {
                JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
                try {
                    jsonWriter.beginObject();
                    String str = zzcjVar.zza;
                    if (str != null) {
                        jsonWriter.name("admob_app_id");
                        jsonWriter.value(str);
                    }
                    zzcf zzcfVar = zzcjVar.zzb;
                    if (zzcfVar != null) {
                        jsonWriter.name("device_info");
                        jsonWriter.beginObject();
                        int i = zzcfVar.zzc;
                        if (i != 1) {
                            jsonWriter.name("os_type");
                            int i2 = i - 1;
                            if (i2 == 0) {
                                jsonWriter.value("UNKNOWN");
                            } else if (i2 == 1) {
                                jsonWriter.value("ANDROID");
                            }
                        }
                        String str2 = zzcfVar.zza;
                        if (str2 != null) {
                            jsonWriter.name(QTaELkFI.bDKz);
                            jsonWriter.value(str2);
                        }
                        Integer num = zzcfVar.zzb;
                        if (num != null) {
                            jsonWriter.name("android_api_level");
                            jsonWriter.value(num);
                        }
                        jsonWriter.endObject();
                    }
                    String str3 = zzcjVar.zzc;
                    if (str3 != null) {
                        jsonWriter.name("language_code");
                        jsonWriter.value(str3);
                    }
                    Boolean bool = zzcjVar.zzd;
                    if (bool != null) {
                        jsonWriter.name("tag_for_under_age_of_consent");
                        jsonWriter.value(bool.booleanValue());
                    }
                    Map map = zzcjVar.zze;
                    if (!map.isEmpty()) {
                        jsonWriter.name("stored_infos_map");
                        jsonWriter.beginObject();
                        for (Map.Entry entry : map.entrySet()) {
                            jsonWriter.name((String) entry.getKey());
                            jsonWriter.value((String) entry.getValue());
                        }
                        jsonWriter.endObject();
                    }
                    zzch zzchVar = zzcjVar.zzf;
                    if (zzchVar != null) {
                        jsonWriter.name("screen_info");
                        jsonWriter.beginObject();
                        Integer num2 = zzchVar.zza;
                        if (num2 != null) {
                            jsonWriter.name("width");
                            jsonWriter.value(num2);
                        }
                        Integer num3 = zzchVar.zzb;
                        if (num3 != null) {
                            jsonWriter.name("height");
                            jsonWriter.value(num3);
                        }
                        Double d = zzchVar.zzc;
                        if (d != null) {
                            jsonWriter.name("density");
                            jsonWriter.value(d);
                        }
                        List<zzcg> list = zzchVar.zzd;
                        if (!list.isEmpty()) {
                            jsonWriter.name("screen_insets");
                            jsonWriter.beginArray();
                            for (zzcg zzcgVar : list) {
                                jsonWriter.beginObject();
                                Integer num4 = zzcgVar.zza;
                                if (num4 != null) {
                                    jsonWriter.name("top");
                                    jsonWriter.value(num4);
                                }
                                Integer num5 = zzcgVar.zzb;
                                if (num5 != null) {
                                    jsonWriter.name("left");
                                    jsonWriter.value(num5);
                                }
                                Integer num6 = zzcgVar.zzc;
                                if (num6 != null) {
                                    jsonWriter.name("right");
                                    jsonWriter.value(num6);
                                }
                                Integer num7 = zzcgVar.zzd;
                                if (num7 != null) {
                                    jsonWriter.name("bottom");
                                    jsonWriter.value(num7);
                                }
                                jsonWriter.endObject();
                            }
                            jsonWriter.endArray();
                        }
                        jsonWriter.endObject();
                    }
                    zzcd zzcdVar = zzcjVar.zzg;
                    if (zzcdVar != null) {
                        jsonWriter.name("app_info");
                        jsonWriter.beginObject();
                        String str4 = zzcdVar.zza;
                        if (str4 != null) {
                            jsonWriter.name("package_name");
                            jsonWriter.value(str4);
                        }
                        String str5 = zzcdVar.zzb;
                        if (str5 != null) {
                            jsonWriter.name("publisher_display_name");
                            jsonWriter.value(str5);
                        }
                        String str6 = zzcdVar.zzc;
                        if (str6 != null) {
                            jsonWriter.name("version");
                            jsonWriter.value(str6);
                        }
                        jsonWriter.endObject();
                    }
                    zzci zzciVar = zzcjVar.zzh;
                    if (zzciVar != null) {
                        jsonWriter.name("sdk_info");
                        jsonWriter.beginObject();
                        String str7 = zzciVar.zza;
                        if (str7 != null) {
                            jsonWriter.name("version");
                            jsonWriter.value(str7);
                        }
                        jsonWriter.endObject();
                    }
                    List list2 = zzcjVar.zzi;
                    if (!list2.isEmpty()) {
                        jsonWriter.name("debug_params");
                        jsonWriter.beginArray();
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            switch ((zzce) it.next()) {
                                case DEBUG_PARAM_UNKNOWN:
                                    jsonWriter.value("DEBUG_PARAM_UNKNOWN");
                                    break;
                                case ALWAYS_SHOW:
                                    jsonWriter.value("ALWAYS_SHOW");
                                    break;
                                case GEO_OVERRIDE_EEA:
                                    jsonWriter.value("GEO_OVERRIDE_EEA");
                                    break;
                                case GEO_OVERRIDE_REGULATED_US_STATE:
                                    jsonWriter.value("GEO_OVERRIDE_REGULATED_US_STATE");
                                    break;
                                case GEO_OVERRIDE_OTHER:
                                    jsonWriter.value("GEO_OVERRIDE_OTHER");
                                    break;
                                case GEO_OVERRIDE_NON_EEA:
                                    jsonWriter.value("GEO_OVERRIDE_NON_EEA");
                                    break;
                                case PREVIEWING_DEBUG_MESSAGES:
                                    jsonWriter.value("PREVIEWING_DEBUG_MESSAGES");
                                    break;
                            }
                        }
                        jsonWriter.endArray();
                    }
                    jsonWriter.endObject();
                    jsonWriter.close();
                    outputStreamWriter.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        throw new IOException("Http error code - " + responseCode + ".\n" + new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next());
                    }
                    String headerField = httpURLConnection.getHeaderField("x-ump-using-header");
                    if (headerField != null) {
                        zzcl zzclVarZza = zzcl.zza(new JsonReader(new StringReader(headerField)));
                        zzclVarZza.zza = new Scanner(httpURLConnection.getInputStream()).useDelimiter("\\A").next();
                        return zzclVarZza;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    try {
                        bufferedReader.readLine();
                        JsonReader jsonReader = new JsonReader(bufferedReader);
                        try {
                            zzcl zzclVarZza2 = zzcl.zza(jsonReader);
                            jsonReader.close();
                            bufferedReader.close();
                            return zzclVarZza2;
                        } catch (Throwable th) {
                            try {
                                jsonReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        jsonWriter.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
                throw th7;
            }
        } catch (SocketTimeoutException e) {
            throw new zzg(4, "The server timed out.", e);
        } catch (IOException e2) {
            throw new zzg(2, "Error making request.", e2);
        }
    }
}
