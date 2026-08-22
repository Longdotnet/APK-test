package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnx implements zzazd {
    private zzcfg zza;
    private final Executor zzb;
    private final zzcnj zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcnm zzg = new zzcnm();

    public zzcnx(Executor executor, zzcnj zzcnjVar, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcnjVar;
        this.zzd = clock;
    }

    public static /* synthetic */ void zza(zzcnx zzcnxVar, JSONObject jSONObject) {
        String strM$1 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Calling AFMA_updateActiveView(", jSONObject.toString(), ")");
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zze(strM$1);
        zzcnxVar.zza.zzp("AFMA_updateActiveView", jSONObject);
    }

    private final void zzg() {
        try {
            final JSONObject jSONObjectZzb = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcnx.zza(this.zza, jSONObjectZzb);
                    }
                });
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zzb() {
        this.zze = false;
    }

    public final void zzd() {
        this.zze = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        boolean z = this.zzf ? false : zzazcVar.zzj;
        zzcnm zzcnmVar = this.zzg;
        zzcnmVar.zza = z;
        ((DefaultClock) this.zzd).getClass();
        zzcnmVar.zzd = SystemClock.elapsedRealtime();
        zzcnmVar.zzf = zzazcVar;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcfg zzcfgVar) {
        this.zza = zzcfgVar;
    }
}
