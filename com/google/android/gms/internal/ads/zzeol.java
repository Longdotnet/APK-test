package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzeol implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    public zzeol(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    public static zzeom zzc(zzeol zzeolVar) {
        double intExtra;
        boolean zIsCharging;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmv)).booleanValue()) {
            BatteryManager batteryManager = (BatteryManager) zzeolVar.zzb.getSystemService("batterymanager");
            intExtra = batteryManager != null ? ((double) batteryManager.getIntProperty(4)) / 100.0d : -1.0d;
            zIsCharging = batteryManager != null ? batteryManager.isCharging() : zze(zzeolVar.zzd());
        } else {
            Intent intentZzd = zzeolVar.zzd();
            boolean zZze = zze(intentZzd);
            intExtra = intentZzd != null ? ((double) intentZzd.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((double) intentZzd.getIntExtra("scale", -1)) : -1.0d;
            zIsCharging = zZze;
        }
        return new zzeom(intExtra, zIsCharging);
    }

    private final Intent zzd() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        return (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlv)).booleanValue() || Build.VERSION.SDK_INT < 33) ? this.zzb.registerReceiver(null, intentFilter) : this.zzb.registerReceiver(null, intentFilter, 4);
    }

    private static final boolean zze(Intent intent) {
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeok
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeol.zzc(this.zza);
            }
        });
    }
}
