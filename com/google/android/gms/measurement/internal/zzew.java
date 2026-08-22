package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.android.billingclient.api.BillingFlowParams;
import com.google.android.gms.ads.jY.UUFMQdNK;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class zzew extends zzgl {
    public static final Pair zza = new Pair("", 0L);
    public zzeu zzb;
    public final zzes zzc;
    public final BillingFlowParams zze;
    public final zzes zzf;
    public final zzeq zzg;
    public final BillingFlowParams zzh;
    public final zzeq zzi;
    public final zzes zzj;
    public final zzes zzk;
    public boolean zzl;
    public final zzeq zzm;
    public final zzeq zzn;
    public final zzes zzo;
    public final BillingFlowParams zzp;
    public final BillingFlowParams zzq;
    public final zzes zzr;
    public final Dispatcher zzs;
    public SharedPreferences zzu;
    public String zzv;
    public boolean zzw;
    public long zzx;

    public final SharedPreferences zza() {
        zzg();
        zzu();
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zzu);
        return this.zzu;
    }

    public final zzai zzc() {
        zzg();
        return zzai.zzb(zza().getString("consent_settings", "G1"));
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return true;
    }

    public final void zzi(boolean z) {
        zzg();
        zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzb(Boolean.valueOf(z), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = zza().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    public final boolean zzk(long j) {
        return j - this.zzf.zza() > this.zzj.zza();
    }

    public zzew(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = new zzes(this, "session_timeout", 1800000L);
        this.zzg = new zzeq(this, "start_new_session", true);
        this.zzj = new zzes(this, "last_pause_time", 0L);
        this.zzk = new zzes(this, "session_id", 0L);
        this.zzh = new BillingFlowParams(this, "non_personalized_ads");
        this.zzi = new zzeq(this, "allow_remote_dynamite", false);
        this.zzc = new zzes(this, "first_open_time", 0L);
        com.google.android.gms.common.internal.zzah.checkNotEmpty("app_install_time");
        this.zze = new BillingFlowParams(this, "app_instance_id");
        this.zzm = new zzeq(this, "app_backgrounded", false);
        this.zzn = new zzeq(this, "deep_link_retrieval_complete", false);
        this.zzo = new zzes(this, "deep_link_retrieval_attempts", 0L);
        this.zzp = new BillingFlowParams(this, UUFMQdNK.OYVpqgkedysVMI);
        this.zzq = new BillingFlowParams(this, "deferred_attribution_cache");
        this.zzr = new zzes(this, "deferred_attribution_cache_timestamp", 0L);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.runningSyncCalls = this;
        com.google.android.gms.common.internal.zzah.checkNotEmpty("default_event_parameters");
        dispatcher.executorServiceOrNull = "default_event_parameters";
        dispatcher.readyAsyncCalls = new Bundle();
        this.zzs = dispatcher;
    }

    public final boolean zzl(int i) {
        int i2 = zza().getInt(sgtsHsWT.YYifiUFLhnv, 100);
        zzai zzaiVar = zzai.zza;
        if (i <= i2) {
            return true;
        }
        return false;
    }
}
