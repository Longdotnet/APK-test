package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class zzcb implements zzd {
    private final Application zza;
    private final zzbx zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzao zzf;
    private final zzbc zzg;
    private final zzaq zzh;

    public zzcb(Application application, zzbx zzbxVar, Handler handler, Executor executor, zze zzeVar, zzao zzaoVar, zzbc zzbcVar, zzaq zzaqVar) {
        this.zza = application;
        this.zzb = zzbxVar;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzeVar;
        this.zzf = zzaoVar;
        this.zzg = zzbcVar;
        this.zzh = zzaqVar;
    }

    public static /* synthetic */ void zzc(zzcb zzcbVar) {
        String strConcat;
        JSONObject jSONObject = new JSONObject();
        Application application = zzcbVar.zza;
        try {
            jSONObject.put("app_name", application.getPackageManager().getApplicationLabel(application.getApplicationInfo()).toString());
            Drawable applicationIcon = application.getPackageManager().getApplicationIcon(application.getApplicationInfo());
            if (applicationIcon == null) {
                strConcat = null;
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strConcat = "data:image/png;base64,".concat(String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2)));
            }
            jSONObject.put("app_icon", strConcat);
            JSONObject jSONObject2 = new JSONObject();
            zzaq zzaqVar = zzcbVar.zzh;
            for (String str : zzaqVar.zzc().keySet()) {
                jSONObject2.put(str, zzaqVar.zzc().get(str));
            }
            jSONObject.put("stored_infos_map", jSONObject2);
        } catch (JSONException unused) {
        }
        zzcbVar.zzg.zzc().zzd("UMP_configureFormWithAppAssets", jSONObject.toString());
    }

    private final void zzg(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty url.");
        }
        Uri uri = Uri.parse(strOptString);
        if (uri.getScheme() == null) {
            Log.d("UserMessagingPlatform", "Action[browser]: empty scheme: ".concat(String.valueOf(strOptString)));
        }
        try {
            this.zzb.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException e) {
            Log.d("UserMessagingPlatform", "Action[browser]: can not open url: ".concat(String.valueOf(strOptString)), e);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        final Handler handler = this.zzc;
        Objects.requireNonNull(handler);
        return new Executor() { // from class: com.google.android.gms.internal.consent_sdk.zzbz
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void zzd() {
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzca
            @Override // java.lang.Runnable
            public final void run() {
                zzcb.zzc(this.zza);
            }
        });
    }

    public final void zze(String str) {
        Log.d("UserMessagingPlatform", "Receive consent action: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        this.zze.zzb(uri.getQueryParameter("action"), uri.getQueryParameter("args"), this, this.zzf);
    }

    public final void zzf(int i, String str, String str2) {
        Locale locale = Locale.US;
        this.zzg.zzj(new zzg(2, "WebResourceError(" + i + ", " + str2 + "): " + str));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final boolean zzb(String str, JSONObject jSONObject) {
        byte b;
        byte b2 = -1;
        int i = 3;
        switch (str) {
            case "load_complete":
                b = 0;
                break;
            case "configure_app_assets":
                b = 3;
                break;
            case "browser":
                b = 2;
                break;
            case "dismiss":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        return false;
                    }
                    zzd();
                    return true;
                }
                zzg(jSONObject);
                return true;
            }
            String strOptString = jSONObject.optString(oKjScaD.uDILCwoBPy);
            switch (strOptString.hashCode()) {
                case -954325659:
                    if (strOptString.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) {
                        b2 = 3;
                    }
                    break;
                case -258041904:
                    if (strOptString.equals("personalized")) {
                        b2 = 0;
                    }
                    break;
                case 429411856:
                    if (strOptString.equals(kBfGXgdfpo.aUkWNlTXRhbCpZZ)) {
                        b2 = 4;
                    }
                    break;
                case 467888915:
                    if (strOptString.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) {
                        b2 = 1;
                    }
                    break;
                case 1666911234:
                    if (strOptString.equals("non_personalized")) {
                        b2 = 2;
                    }
                    break;
                case 1725474845:
                    if (strOptString.equals("CONSENT_SIGNAL_NOT_REQUIRED")) {
                        b2 = 5;
                    }
                    break;
            }
            if (b2 != 0 && b2 != 1 && b2 != 2 && b2 != 3 && b2 != 4) {
                if (b2 != 5) {
                    this.zzg.zzh(new zzg(1, "We are getting something wrong with the webview."));
                } else {
                    i = 1;
                    this.zzg.zzg(i);
                }
            } else {
                this.zzg.zzg(i);
            }
            return true;
        }
        this.zzg.zzi();
        return true;
    }
}
