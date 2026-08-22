package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;

/* JADX INFO: loaded from: classes2.dex */
public final class zzduu extends zzfrz {
    private final SensorManager zza;
    private final Sensor zzb;
    private float zzc;
    private Float zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzdut zzi;
    private boolean zzj;

    public zzduu(Context context) {
        super("FlickDetector", "ads");
        this.zzc = 0.0f;
        this.zzd = Float.valueOf(0.0f);
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zze = System.currentTimeMillis();
        this.zzf = 0;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
        this.zzj = false;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.zza = sensorManager;
        if (sensorManager != null) {
            this.zzb = sensorManager.getDefaultSensor(4);
        } else {
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfrz
    public final void zza(SensorEvent sensorEvent) {
        zzbcv zzbcvVar = zzbde.zzjy;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.zze;
            zzbcv zzbcvVar2 = zzbde.zzjA;
            zzbdc zzbdcVar = zzbdVar.zzd;
            if (j + ((long) ((Integer) zzbdcVar.zzb(zzbcvVar2)).intValue()) < jCurrentTimeMillis) {
                this.zzf = 0;
                this.zze = jCurrentTimeMillis;
                this.zzg = false;
                this.zzh = false;
                this.zzc = this.zzd.floatValue();
            }
            float fFloatValue = this.zzd.floatValue() + (sensorEvent.values[1] * 4.0f);
            this.zzd = Float.valueOf(fFloatValue);
            float f = this.zzc;
            zzbcv zzbcvVar3 = zzbde.zzjz;
            if (fFloatValue > ((Float) zzbdcVar.zzb(zzbcvVar3)).floatValue() + f) {
                this.zzc = this.zzd.floatValue();
                this.zzh = true;
            } else if (this.zzd.floatValue() < this.zzc - ((Float) zzbdcVar.zzb(zzbcvVar3)).floatValue()) {
                this.zzc = this.zzd.floatValue();
                this.zzg = true;
            }
            if (this.zzd.isInfinite()) {
                this.zzd = Float.valueOf(0.0f);
                this.zzc = 0.0f;
            }
            if (this.zzg && this.zzh) {
                com.google.android.gms.ads.internal.util.zze.zza("Flick detected.");
                this.zze = jCurrentTimeMillis;
                int i = this.zzf + 1;
                this.zzf = i;
                this.zzg = false;
                this.zzh = false;
                zzdut zzdutVar = this.zzi;
                if (zzdutVar == null || i != ((Integer) zzbdcVar.zzb(zzbde.zzjB)).intValue()) {
                    return;
                }
                zzdvi zzdviVar = (zzdvi) zzdutVar;
                zzdviVar.zzh(new zzdvg(zzdviVar), zzdvh.GESTURE);
            }
        }
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (this.zzj && (sensorManager = this.zza) != null && (sensor = this.zzb) != null) {
                    sensorManager.unregisterListener(this, sensor);
                    this.zzj = false;
                    com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for flick gestures.");
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
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjy)).booleanValue()) {
                    if (!this.zzj && (sensorManager = this.zza) != null && (sensor = this.zzb) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.zzj = true;
                        com.google.android.gms.ads.internal.util.zze.zza("Listening for flick gestures.");
                    }
                    if (this.zza == null || this.zzb == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj(bUqMCsuPSX.YldhlRIHAj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(zzdut zzdutVar) {
        this.zzi = zzdutVar;
    }
}
