package com.google.android.gms.ads.internal;

import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.WebView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzbeq;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends AsyncTask {
    public final /* synthetic */ zzu zza;

    public /* synthetic */ zzr(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        zzu zzuVar = this.zza;
        try {
            zzuVar.zzh = (zzavu) zzuVar.zzc.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            int i = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        } catch (ExecutionException e2) {
            e = e2;
            int i2 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        } catch (TimeoutException e3) {
            int i3 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e3);
        }
        zzuVar.getClass();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbeq.zzd.zze());
        Request request = zzuVar.zze;
        builder.appendQueryParameter("query", (String) request.headers);
        builder.appendQueryParameter("pubId", (String) request.method);
        builder.appendQueryParameter("mappver", (String) request.tags);
        TreeMap treeMap = (TreeMap) request.url;
        for (String str : treeMap.keySet()) {
            builder.appendQueryParameter(str, (String) treeMap.get(str));
        }
        Uri uriBuild = builder.build();
        zzavu zzavuVar = zzuVar.zzh;
        if (zzavuVar != null) {
            try {
                uriBuild = zzavuVar.zzb(uriBuild, zzuVar.zzd);
            } catch (zzavv e4) {
                int i4 = zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to process ad data", e4);
            }
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzuVar.zzr(), "#", uriBuild.getEncodedQuery());
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        WebView webView = this.zza.zzf;
        if (webView == null || str == null) {
            return;
        }
        webView.loadUrl(str);
    }
}
