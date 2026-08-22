package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.WorkContinuation;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzxq {
    private final Context zza;
    private zzyk zzb;
    private final String zzc;
    private final FirebaseApp zzd;
    private boolean zze = false;
    private String zzf;

    public zzxq(Context context, FirebaseApp firebaseApp, String str) {
        zzah.checkNotNull(context);
        this.zza = context;
        zzah.checkNotNull(firebaseApp);
        this.zzd = firebaseApp;
        this.zzc = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Android/Fallback/", str);
    }

    public final void zza(URLConnection uRLConnection) {
        String str;
        String strConcat = this.zze ? String.valueOf(this.zzc).concat("/FirebaseUI-Android") : String.valueOf(this.zzc).concat("/FirebaseCore-Android");
        if (this.zzb == null) {
            Context context = this.zza;
            this.zzb = new zzyk(context, context.getPackageName());
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zzb());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zza());
        uRLConnection.setRequestProperty("Accept-Language", zzxr.zza());
        uRLConnection.setRequestProperty("X-Client-Version", strConcat);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zzf);
        uRLConnection.setRequestProperty("X-Firebase-GMPID", this.zzd.getOptions().getApplicationId());
        HeartBeatController heartBeatController = (HeartBeatController) FirebaseAuth.getInstance(this.zzd).zzy().get();
        if (heartBeatController != null) {
            try {
                str = (String) WorkContinuation.await(heartBeatController.getHeartBeatsHeader());
            } catch (InterruptedException | ExecutionException e) {
                Log.w("LocalRequestInterceptor", "Unable to get heartbeats: ".concat(String.valueOf(e.getMessage())));
                str = null;
            }
        } else {
            str = null;
        }
        uRLConnection.setRequestProperty("X-Firebase-Client", str);
        this.zzf = null;
    }

    public final void zzb(String str) {
        this.zze = !TextUtils.isEmpty(str);
    }

    public final void zzc(String str) {
        this.zzf = str;
    }
}
