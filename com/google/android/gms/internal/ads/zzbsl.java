package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.daerisoft.thespikerm.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsl extends zzbsu {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbsl(zzcfg zzcfgVar, Map map) {
        super(zzcfgVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcfgVar.zzi();
        this.zzc = zze("description");
        this.zzf = zze("summary");
        this.zzd = zzd("start_ticks");
        this.zze = zzd("end_ticks");
        this.zzg = zze(FirebaseAnalytics.Param.LOCATION);
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private final String zze(String str) {
        Map map = this.zza;
        return TextUtils.isEmpty((CharSequence) map.get(str)) ? "" : (String) map.get(str);
    }

    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        Context context = this.zzb;
        if (context == null) {
            zzh("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        if (!new zzbcm(context).zzb()) {
            zzh("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
        AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.util.zzs.zzL(context);
        Resources resourcesZze = zzvVar.zzi.zze();
        builderZzL.setTitle(resourcesZze != null ? resourcesZze.getString(R.string.s5) : "Create calendar event");
        builderZzL.setMessage(resourcesZze != null ? resourcesZze.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        builderZzL.setPositiveButton(resourcesZze != null ? resourcesZze.getString(R.string.s3) : "Accept", new zzbsj(this));
        builderZzL.setNegativeButton(resourcesZze != null ? resourcesZze.getString(R.string.s4) : "Decline", new zzbsk(this));
        builderZzL.create().show();
    }
}
