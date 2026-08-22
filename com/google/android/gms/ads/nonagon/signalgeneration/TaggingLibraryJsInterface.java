package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.impl.WorkerWrapper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.zza;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzgdy;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class TaggingLibraryJsInterface {
    public final Context zza;
    public final WebView zzb;
    public final zzavu zzc;
    public final zzfda zzd;
    public final int zze;
    public final zzdso zzf;
    public final boolean zzg;
    public final zzgdy zzh = zzcaf.zzf;
    public final zzfjy zzi;
    public final zzo zzj;
    public final zzf zzk;
    public final zzj zzl;

    public TaggingLibraryJsInterface(WebView webView, zzavu zzavuVar, zzdso zzdsoVar, zzfjy zzfjyVar, zzfda zzfdaVar, zzo zzoVar, zzf zzfVar, zzj zzjVar) {
        this.zzb = webView;
        Context context = webView.getContext();
        this.zza = context;
        this.zzc = zzavuVar;
        this.zzf = zzdsoVar;
        zzbde.zza(context);
        zzbcv zzbcvVar = zzbde.zzjZ;
        zzbd zzbdVar = zzbd.zza;
        this.zze = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        this.zzg = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzka)).booleanValue();
        this.zzi = zzfjyVar;
        this.zzd = zzfdaVar;
        this.zzj = zzoVar;
        this.zzk = zzfVar;
        this.zzl = zzjVar;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        try {
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzvVar.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strZzd = this.zzc.zzc().zzd(this.zza, str, this.zzb);
            if (this.zzg) {
                zzvVar.zzl.getClass();
                MediaType.Companion.zzd(this.zzf, "csg", new Pair("clat", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            }
            return strZzd;
        } catch (RuntimeException e) {
            int i = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting click signals. ", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getClickSignalsWithTimeout(String str, int i) {
        if (i <= 0) {
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid timeout for getting click signals. Timeout=");
            int i2 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg(strM);
            return "";
        }
        try {
            return (String) zzcaf.zza.zzb(new com.google.android.gms.ads.internal.zzh(this, str, 3, false)).get(Math.min(i, this.zze), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            int i3 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting click signals with timeout. ", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            return e instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        String string = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        zzbu zzbuVar = new zzbu(this, string);
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            this.zzj.zzg(this.zzb, zzbuVar);
        } else {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzkc)).booleanValue()) {
                this.zzh.execute(new WorkerWrapper.AnonymousClass1(this, bundle, zzbuVar, 11, false));
            } else {
                QueryInfo.generate(this.zza, new AdRequest((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(bundle)), zzbuVar);
            }
        }
        return string;
    }

    @JavascriptInterface
    public String getViewSignalsWithTimeout(int i) {
        if (i <= 0) {
            String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid timeout for getting view signals. Timeout=");
            int i2 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg(strM);
            return "";
        }
        try {
            return (String) zzcaf.zza.zzb(new com.android.billingclient.api.zzaz(this, 6)).get(Math.min(i, this.zze), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            int i3 = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting view signals with timeout. ", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            return e instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public void recordClick(String str) {
        if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzke)).booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        zzcaf.zza.execute(new zza(this, str, 25));
    }

    @JavascriptInterface
    public void reportTouchEvent(String str) {
        int i;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("x");
            int i4 = jSONObject.getInt("y");
            int i5 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i6 = jSONObject.getInt("type");
            try {
                if (i6 != 0) {
                    int i7 = 1;
                    if (i6 != 1) {
                        i7 = 2;
                        if (i6 != 2) {
                            i7 = 3;
                            i2 = i6 != 3 ? -1 : 0;
                            this.zzc.zzd(MotionEvent.obtain(0L, i5, i, i3, i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
                            return;
                        }
                    }
                    i = i7;
                    this.zzc.zzd(MotionEvent.obtain(0L, i5, i, i3, i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
                    return;
                }
                this.zzc.zzd(MotionEvent.obtain(0L, i5, i, i3, i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
                return;
            } catch (RuntimeException e) {
                e = e;
                int i8 = zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
                return;
            } catch (JSONException e2) {
                e = e2;
                int i9 = zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
                return;
            }
            i = i2;
        } catch (RuntimeException | JSONException e3) {
            e = e3;
        }
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzvVar.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strZzh = this.zzc.zzc().zzh(this.zza, this.zzb, null);
            if (this.zzg) {
                zzvVar.zzl.getClass();
                MediaType.Companion.zzd(this.zzf, "vsg", new Pair(oKjScaD.yoSW, String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            }
            return strZzh;
        } catch (RuntimeException e) {
            int i = zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Exception getting view signals. ", e);
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }
}
