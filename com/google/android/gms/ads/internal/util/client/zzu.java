package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbun;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class zzu implements zze {
    public final Context zza;
    public final String zzb;
    public String zzc;

    public zzu(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final URL zzc(String str) {
        URL url = null;
        try {
            url = new URI(str).toURL();
        } catch (IllegalArgumentException e) {
            e = e;
            zze(str, e);
        } catch (MalformedURLException e2) {
            e = e2;
            zze(str, e);
        } catch (URISyntaxException e3) {
            zze(str, e3);
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zze)).booleanValue()) {
                try {
                    zzo.zze("Attempting to parse components, encode, and reconstruct URI.");
                    URL url2 = new URL(str);
                    URI uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
                    url = uri.toURL();
                    zzo.zze("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"" + str + "\" -> encoded URI: " + uri.toString());
                } catch (IllegalArgumentException | MalformedURLException | URISyntaxException e4) {
                    zze(str, e4);
                }
            }
        }
        if (url != null) {
            return url;
        }
        zzo.zze("Falling back to direct new URL(\"" + str + nYVxXTZQ.yqJkpNr);
        return new URL(str);
    }

    public final void zze(String str, Exception exc) {
        zzo.zzj("Error while parsing ping URL: " + str + ". " + exc.getMessage());
        zzbun.zza(this.zza).zzi(exc, "HttpUrlPinger.pingUrl", ((float) ((Integer) zzbd.zza.zzd.zzb(zzbde.zznf)).intValue()) / 100.0f);
    }

    @Override // com.google.android.gms.ads.internal.util.client.zze
    public final zzt zza(String str) {
        zzt zztVar = zzt.zzc;
        zzt zztVar2 = zzt.zzb;
        try {
            zzo.zze("Pinging URL: " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzc(str).openConnection();
            try {
                zzf zzfVar = zzbb.zzb.zzc;
                String str2 = this.zzb;
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setReadTimeout(60000);
                if (str2 != null) {
                    httpURLConnection.setRequestProperty(bUqMCsuPSX.krZHdnYmXF, str2);
                }
                httpURLConnection.setUseCaches(false);
                zzl zzlVar = new zzl();
                zzlVar.zzc(httpURLConnection, null);
                int responseCode = httpURLConnection.getResponseCode();
                zzlVar.zze(httpURLConnection, responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    zzo.zzj("Received non-success response code " + responseCode + " from pinging URL: " + str);
                    if (responseCode == 502) {
                        zztVar2 = zztVar;
                    }
                } else {
                    if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzii)).booleanValue()) {
                        this.zzc = httpURLConnection.getHeaderField("X-Afma-Ad-Event-Value");
                    }
                    zztVar2 = zzt.zza;
                }
                return zztVar2;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e = e;
            zzo.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
            return zztVar;
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            zze(str, e);
        } catch (RuntimeException e3) {
            e = e3;
            zzo.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
            return zztVar;
        } catch (MalformedURLException e4) {
            e = e4;
            zze(str, e);
        } catch (Throwable th) {
            throw th;
        }
    }
}
