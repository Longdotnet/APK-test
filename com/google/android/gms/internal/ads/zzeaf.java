package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.AccessTokenCache;
import com.google.android.gms.common.util.Hex;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzeaf implements zzfge {
    protected final Context zza;
    protected final String zzb;

    public zzeaf(Context context, String str, zzbvy zzbvyVar, int i) {
        this.zza = context;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfge
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzeae zza(zzead zzeadVar) {
        String str = zzeadVar.zza;
        int i = zzeadVar.zzb;
        Map map = zzeadVar.zzc;
        byte[] bArr = zzeadVar.zzd;
        String str2 = zzeadVar.zze;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        return zzc(str, i, map, bArr, str2, SystemClock.elapsedRealtime());
    }

    public final zzeae zzc(String str, int i, Map map, byte[] bArr, String str2, long j) throws MalformedURLException, zzdwm {
        HttpURLConnection httpURLConnection;
        URL url;
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        boolean z = true;
        try {
            zzeae zzeaeVar = new zzeae();
            String str3 = this.zzb;
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("SDK version: " + str3);
            com.google.android.gms.ads.internal.util.client.zzo.zze("AdRequestServiceImpl: Sending request: " + str);
            URL url2 = new URL(str);
            HashMap map2 = new HashMap();
            int i3 = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    try {
                        com.google.android.gms.ads.internal.zzv.zza.zzd.zzg(this.zza, str3, httpURLConnection, i);
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            httpURLConnection.setRequestProperty("Content-Type", str2);
                        }
                        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl();
                        try {
                            zzlVar.zzc(httpURLConnection, bArr);
                        } catch (Throwable th) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Network request logging failed.", th);
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "HttpRequestFunction.logAdRequest");
                        }
                        int length = bArr.length;
                        if (length > 0) {
                            httpURLConnection.setDoOutput(z);
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                                try {
                                    bufferedOutputStream2.write(bArr);
                                    Hex.closeQuietly(bufferedOutputStream2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    Hex.closeQuietly(bufferedOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream = null;
                            }
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (map2.containsKey(key)) {
                                ((List) map2.get(key)).addAll(value);
                            } else {
                                map2.put(key, new ArrayList(value));
                            }
                        }
                        zzlVar.zze(httpURLConnection, responseCode);
                        zzeaeVar.zza = responseCode;
                        zzeaeVar.zzb = map2;
                        zzeaeVar.zzc = "";
                        if (responseCode >= 200 && responseCode < 300) {
                            try {
                                InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                                try {
                                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                                    StringBuilder sb = new StringBuilder(8192);
                                    char[] cArr = new char[2048];
                                    while (true) {
                                        int i4 = inputStreamReader2.read(cArr);
                                        if (i4 == -1) {
                                            break;
                                        }
                                        sb.append(cArr, 0, i4);
                                    }
                                    String string = sb.toString();
                                    Hex.closeQuietly(inputStreamReader2);
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk() && string != null) {
                                        zzlVar.zzn("onNetworkResponseBody", new AccessTokenCache(string.getBytes(), 18));
                                    }
                                    zzeaeVar.zzc = string;
                                    if (TextUtils.isEmpty(string)) {
                                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfP)).booleanValue()) {
                                            throw new zzdwm(3);
                                        }
                                    }
                                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                                    zzeaeVar.zzd = SystemClock.elapsedRealtime() - j;
                                    break;
                                } catch (Throwable th4) {
                                    th = th4;
                                    inputStreamReader = inputStreamReader2;
                                    Hex.closeQuietly(inputStreamReader);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                inputStreamReader = null;
                            }
                        } else {
                            if (responseCode < 300 || responseCode >= 400) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Received error HTTP response code: " + responseCode);
                                throw new zzdwm(1, "Received error HTTP response code: " + responseCode);
                            }
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (TextUtils.isEmpty(headerField)) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("No location header to follow redirect.");
                                throw new zzdwm(1, "No location header to follow redirect");
                            }
                            zzbcv zzbcvVar = zzbde.zzig;
                            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                                try {
                                    url = new URI(headerField).toURL();
                                } catch (URISyntaxException e) {
                                    throw new zzdwm(1, e.getMessage(), e);
                                }
                            } else {
                                url = new URL(headerField);
                            }
                            i3++;
                            if (i3 > ((Integer) zzbdVar.zzd.zzb(zzbde.zzfy)).intValue()) {
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Too many redirects.");
                                throw new zzdwm(1, "Too many redirects");
                            }
                            httpURLConnection.disconnect();
                            url2 = url;
                            z = true;
                        }
                    } catch (zzdwm e2) {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziI)).booleanValue()) {
                            throw e2;
                        }
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        zzeaeVar.zzd = SystemClock.elapsedRealtime() - j;
                    }
                } catch (Throwable th6) {
                    httpURLConnection.disconnect();
                    throw th6;
                }
            }
            httpURLConnection.disconnect();
            return zzeaeVar;
        } catch (IOException e3) {
            String strValueOf = String.valueOf(e3.getMessage());
            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            String strConcat = "Error while connecting to ad server: ".concat(strValueOf);
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
            throw new zzdwm(1, strConcat, e3);
        }
    }
}
