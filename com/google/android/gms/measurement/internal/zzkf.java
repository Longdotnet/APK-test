package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.internal.measurement.zzbs;

/* JADX INFO: loaded from: classes2.dex */
public final class zzkf extends zzkh {
    public final AlarmManager zza;
    public zzjz zzb;
    public Integer zzc;

    public zzkf(zzkt zzktVar) {
        super(zzktVar);
        this.zza = (AlarmManager) ((zzfr) this.mBuilder).zze.getSystemService("alarm");
    }

    public final void zza() {
        JobScheduler jobScheduler;
        zzW();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzi().zzb();
        if (Build.VERSION.SDK_INT < 24 || (jobScheduler = (JobScheduler) zzfrVar.zze.getSystemService("jobscheduler")) == null) {
            return;
        }
        jobScheduler.cancel(zzf());
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
        JobScheduler jobScheduler;
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        if (Build.VERSION.SDK_INT < 24 || (jobScheduler = (JobScheduler) ((zzfr) this.mBuilder).zze.getSystemService("jobscheduler")) == null) {
            return;
        }
        jobScheduler.cancel(zzf());
    }

    public final PendingIntent zzh() {
        Context context = ((zzfr) this.mBuilder).zze;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
    }

    public final zzap zzi() {
        if (this.zzb == null) {
            this.zzb = new zzjz(this, this.zzf.zzn, 1);
        }
        return this.zzb;
    }

    public final int zzf() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf(bUqMCsuPSX.zmCzuAzqO.concat(String.valueOf(((zzfr) this.mBuilder).zze.getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }
}
