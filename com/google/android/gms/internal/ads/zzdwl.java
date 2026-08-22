package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwl extends zzfrz {
    private final Context zza;
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdwk zzf;
    private boolean zzg;

    public zzdwl(Context context) {
        super("ShakeDetector", "ads");
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfrz
    public final void zza(SensorEvent sensorEvent) {
        zzbcv zzbcvVar = zzbde.zzjt;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0] / 9.80665f;
            float f2 = fArr[1] / 9.80665f;
            float f3 = fArr[2] / 9.80665f;
            float fSqrt = (float) Math.sqrt((f3 * f3) + (f2 * f2) + (f * f));
            zzbcv zzbcvVar2 = zzbde.zzju;
            zzbdc zzbdcVar = zzbdVar.zzd;
            if (fSqrt >= ((Float) zzbdcVar.zzb(zzbcvVar2)).floatValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.zzd + ((long) ((Integer) zzbdcVar.zzb(zzbde.zzjv)).intValue()) <= jCurrentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) zzbdcVar.zzb(zzbde.zzjw)).intValue()) < jCurrentTimeMillis) {
                        this.zze = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.zza("Shake detected.");
                    this.zzd = jCurrentTimeMillis;
                    int i = this.zze + 1;
                    this.zze = i;
                    zzdwk zzdwkVar = this.zzf;
                    if (zzdwkVar == null || i != ((Integer) zzbdcVar.zzb(zzbde.zzjx)).intValue()) {
                        return;
                    }
                    zzdvi zzdviVar = (zzdvi) zzdwkVar;
                    zzdviVar.zzh(new zzdvf(zzdviVar), zzdvh.GESTURE);
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            try {
                if (this.zzg) {
                    SensorManager sensorManager = this.zzb;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(this, this.zzc);
                        com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for shake gestures.");
                    }
                    this.zzg = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                zzbcv zzbcvVar = zzbde.zzjt;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    if (this.zzb == null) {
                        SensorManager sensorManager2 = (SensorManager) this.zza.getSystemService("sensor");
                        this.zzb = sensorManager2;
                        if (sensorManager2 == null) {
                            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Shake detection failed to initialize. Failed to obtain accelerometer.");
                            return;
                        }
                        this.zzc = sensorManager2.getDefaultSensor(1);
                    }
                    if (!this.zzg && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                        this.zzd = System.currentTimeMillis() - ((long) ((Integer) zzbdVar.zzd.zzb(zzbde.zzjv)).intValue());
                        this.zzg = true;
                        com.google.android.gms.ads.internal.util.zze.zza("Listening for shake gestures.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(zzdwk zzdwkVar) {
        this.zzf = zzdwkVar;
    }
}
