package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzof;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.zzz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhx extends zzf {
    public zzhw zza;
    public final zzs zzb;
    public boolean zzc;
    public zzgr zzd;
    public final CopyOnWriteArraySet zze;
    public boolean zzf;
    public final AtomicReference zzg;
    public final Object zzh;
    public zzai zzi;
    public int zzj;
    public final AtomicLong zzk;
    public long zzl;
    public int zzm;
    public final Fragment.AnonymousClass7 zzn;

    public zzhx(zzfr zzfrVar) {
        super(zzfrVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new Fragment.AnonymousClass7(this, 24);
        this.zzg = new AtomicReference();
        this.zzi = new zzai(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzs(zzfrVar);
    }

    public static /* bridge */ /* synthetic */ void zzv(zzhx zzhxVar, zzai zzaiVar, zzai zzaiVar2) {
        boolean z;
        zzah zzahVar = zzah.ANALYTICS_STORAGE;
        zzah zzahVar2 = zzah.AD_STORAGE;
        zzah[] zzahVarArr = {zzahVar, zzahVar2};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            zzah zzahVar3 = zzahVarArr[i];
            if (!zzaiVar2.zzi(zzahVar3) && zzaiVar.zzi(zzahVar3)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zZzl = zzaiVar.zzl(zzaiVar2, zzahVar, zzahVar2);
        if (z || zZzl) {
            ((zzfr) zzhxVar.mBuilder).zzh().zzo();
        }
    }

    public static void zzw(zzhx zzhxVar, zzai zzaiVar, int i, long j, boolean z, boolean z2) {
        zzhxVar.zzg();
        zzhxVar.zza();
        long j2 = zzhxVar.zzl;
        zzfr zzfrVar = (zzfr) zzhxVar.mBuilder;
        if (j <= j2) {
            int i2 = zzhxVar.zzm;
            zzai zzaiVar2 = zzai.zza;
            if (i2 <= i) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzj.zzb(zzaiVar, "Dropped out-of-date consent setting, proposed settings");
                return;
            }
        }
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzg();
        if (!zzewVar.zzl(i)) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzj.zzb(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = zzewVar.zza().edit();
        editorEdit.putString("consent_settings", zzaiVar.zzh());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        zzhxVar.zzl = j;
        zzhxVar.zzm = i;
        zzjm zzjmVarZzt = zzfrVar.zzt();
        zzjmVarZzt.zzg();
        zzjmVarZzt.zza();
        if (z) {
            zzfr zzfrVar2 = (zzfr) zzjmVarZzt.mBuilder;
            zzfrVar2.getClass();
            zzfrVar2.zzi().zzj();
        }
        if (zzjmVarZzt.zzM()) {
            zzjmVarZzt.zzR(new zziq(zzjmVarZzt, zzjmVarZzt.zzO(false), 3));
        }
        if (z2) {
            zzfrVar.zzt().zzu(new AtomicReference());
        }
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.zzr.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzgw(this, bundle2, 2));
    }

    public final void zzB$1() {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (!(zzfrVar.zze.getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzfrVar.zze.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fc, code lost:
    
        if (r3 > 100) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0132, code lost:
    
        if (r5 > 100) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzE(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25, long r26) {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.zzE(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        ((zzfr) this.mBuilder).zzr.getClass();
        zzH(str, str2, bundle, System.currentTimeMillis());
    }

    public final void zzH(String str, String str2, Bundle bundle, long j) {
        zzg();
        zzI(str, str2, j, bundle, true, this.zzd == null || zzlb.zzah(str2), true);
    }

    public final void zzL(long j, boolean z) {
        zzg();
        zza();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Resetting analytics data (FE)");
        zzkc zzkcVar = zzfrVar.zzo;
        zzfr.zzQ(zzkcVar);
        zzkcVar.zzg();
        zzka zzkaVar = zzkcVar.zzb;
        zzkaVar.zzd.zzb();
        zzkaVar.zza = 0L;
        zzkaVar.zzb = 0L;
        zzpd.zzc();
        zzdt zzdtVar = zzdu.zzam;
        zzag zzagVar = zzfrVar.zzk;
        if (zzagVar.zzs(null, zzdtVar)) {
            zzfrVar.zzh().zzo();
        }
        boolean zZzJ = zzfrVar.zzJ();
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzc.zzb(j);
        zzfr zzfrVar2 = (zzfr) zzewVar.mBuilder;
        zzew zzewVar2 = zzfrVar2.zzl;
        zzfr.zzP(zzewVar2);
        if (!TextUtils.isEmpty(zzewVar2.zzp.zza())) {
            zzewVar.zzp.zzb(null);
        }
        zzof.zzc();
        zzdt zzdtVar2 = zzdu.zzad;
        zzag zzagVar2 = zzfrVar2.zzk;
        if (zzagVar2.zzs(null, zzdtVar2)) {
            zzewVar.zzj.zzb(0L);
        }
        zzewVar.zzk.zzb(0L);
        if (!zzagVar2.zzv()) {
            zzewVar.zzi(!zZzJ);
        }
        zzewVar.zzq.zzb(null);
        zzewVar.zzr.zzb(0L);
        zzewVar.zzs.zzb(null);
        if (z) {
            zzjm zzjmVarZzt = zzfrVar.zzt();
            zzjmVarZzt.zzg();
            zzjmVarZzt.zza();
            zzq zzqVarZzO = zzjmVarZzt.zzO(false);
            zzfr zzfrVar3 = (zzfr) zzjmVarZzt.mBuilder;
            zzfrVar3.getClass();
            zzfrVar3.zzi().zzj();
            zzjmVarZzt.zzR(new zziq(zzjmVarZzt, zzqVarZzO, 0));
        }
        zzof.zzc();
        if (zzagVar.zzs(null, zzdtVar2)) {
            zzfr.zzQ(zzkcVar);
            zzkcVar.zza.zza();
        }
        this.zzc = !zZzJ;
    }

    public final void zzQ(Bundle bundle, long j) {
        com.google.android.gms.common.internal.zzah.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean zIsEmpty = TextUtils.isEmpty(bundle2.getString("app_id"));
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (!zIsEmpty) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzg.zza(bundle2, "app_id", String.class, null);
        zzg.zza(bundle2, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        zzg.zza(bundle2, "name", String.class, null);
        zzg.zza(bundle2, FirebaseAnalytics.Param.VALUE, Object.class, null);
        zzg.zza(bundle2, "trigger_event_name", String.class, null);
        zzg.zza(bundle2, "trigger_timeout", Long.class, 0L);
        zzg.zza(bundle2, "timed_out_event_name", String.class, null);
        zzg.zza(bundle2, "timed_out_event_params", Bundle.class, null);
        zzg.zza(bundle2, "triggered_event_name", String.class, null);
        zzg.zza(bundle2, "triggered_event_params", Bundle.class, null);
        zzg.zza(bundle2, "time_to_live", Long.class, 0L);
        zzg.zza(bundle2, "expired_event_name", String.class, null);
        zzg.zza(bundle2, "expired_event_params", Bundle.class, null);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(bundle2.getString("name"));
        com.google.android.gms.common.internal.zzah.checkNotEmpty(bundle2.getString(FirebaseAnalytics.Param.ORIGIN));
        com.google.android.gms.common.internal.zzah.checkNotNull(bundle2.get(FirebaseAnalytics.Param.VALUE));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get(FirebaseAnalytics.Param.VALUE);
        zzlb zzlbVar = zzfrVar.zzp;
        zzfr.zzP(zzlbVar);
        int iZzl = zzlbVar.zzl(string);
        zzec zzecVar = zzfrVar.zzq;
        zzeh zzehVar2 = zzfrVar.zzm;
        if (iZzl != 0) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(zzecVar.zzf(string), "Invalid conditional user property name");
            return;
        }
        zzlb zzlbVar2 = zzfrVar.zzp;
        zzfr.zzP(zzlbVar2);
        if (zzlbVar2.zzd(obj, string) != 0) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzecVar.zzf(string), "Invalid conditional user property value", obj);
            return;
        }
        zzfr.zzP(zzlbVar2);
        Object objZzB = zzlbVar2.zzB(obj, string);
        if (objZzB == null) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzecVar.zzf(string), "Unable to normalize conditional user property value", obj);
            return;
        }
        zzg.zzb(bundle2, objZzB);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzecVar.zzf(string), "Invalid conditional user property timeout", Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong("time_to_live");
        if (j3 <= 15552000000L && j3 >= 1) {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zzgw(this, bundle2, 1));
        } else {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzecVar.zzf(string), "Invalid conditional user property time to live", Long.valueOf(j3));
        }
    }

    public final void zzS(zzai zzaiVar, int i, long j) {
        zzai zzaiVar2;
        boolean z;
        boolean zZzl;
        boolean z2;
        zzai zzaiVarZzd = zzaiVar;
        zza();
        if (i != -10) {
            if (((Boolean) zzaiVarZzd.zzb.get(zzah.AD_STORAGE)) == null) {
                if (((Boolean) zzaiVarZzd.zzb.get(zzah.ANALYTICS_STORAGE)) == null) {
                    zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zza("Discarding empty consent settings");
                    return;
                }
            }
        }
        synchronized (this.zzh) {
            try {
                zzaiVar2 = this.zzi;
                int i2 = this.zzj;
                zzai zzaiVar3 = zzai.zza;
                z = false;
                if (i <= i2) {
                    zZzl = zzaiVarZzd.zzl(zzaiVar2, (zzah[]) zzaiVarZzd.zzb.keySet().toArray(new zzah[0]));
                    zzah zzahVar = zzah.ANALYTICS_STORAGE;
                    if (zzaiVarZzd.zzi(zzahVar) && !this.zzi.zzi(zzahVar)) {
                        z = true;
                    }
                    zzaiVarZzd = zzaiVarZzd.zzd(this.zzi);
                    this.zzi = zzaiVarZzd;
                    this.zzj = i;
                    z2 = z;
                    z = true;
                } else {
                    zZzl = false;
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            zzeh zzehVar2 = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzj.zzb(zzaiVarZzd, "Ignoring lower-priority consent settings, proposed settings");
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (zZzl) {
            this.zzg.set(null);
            zzfo zzfoVar = ((zzfr) this.mBuilder).zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzq(new zzhr(this, zzaiVarZzd, j, i, andIncrement, z2, zzaiVar2));
            return;
        }
        zzhs zzhsVar = new zzhs(this, zzaiVarZzd, i, andIncrement, z2, zzaiVar2);
        if (i == 30 || i == -10) {
            zzfo zzfoVar2 = ((zzfr) this.mBuilder).zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzq(zzhsVar);
        } else {
            zzfo zzfoVar3 = ((zzfr) this.mBuilder).zzn;
            zzfr.zzR(zzfoVar3);
            zzfoVar3.zzp(zzhsVar);
        }
    }

    public final void zzV(zzai zzaiVar) {
        zzg();
        boolean z = (zzaiVar.zzi(zzah.ANALYTICS_STORAGE) && zzaiVar.zzi(zzah.AD_STORAGE)) || ((zzfr) this.mBuilder).zzt().zzM();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (z != zzfrVar.zzF) {
            zzfr zzfrVar2 = (zzfr) this.mBuilder;
            zzfo zzfoVar2 = zzfrVar2.zzn;
            zzfr.zzR(zzfoVar2);
            zzfoVar2.zzg();
            zzfrVar2.zzF = z;
            zzew zzewVar = ((zzfr) this.mBuilder).zzl;
            zzfr.zzP(zzewVar);
            zzewVar.zzg();
            Boolean boolValueOf = zzewVar.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzewVar.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                zzaa(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:34:0x008f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    public final void zzX(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int iZzl;
        Fragment.AnonymousClass7 anonymousClass7;
        int iZzd;
        zzlb zzlbVar;
        Object objZzB;
        int length;
        String str3 = str == null ? "app" : str;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (!z) {
            zzlb zzlbVar2 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar2);
            i = 6;
            if (zzlbVar2.zzac("user property", str2)) {
                if (zzlbVar2.zzZ("user property", zzg.zza$2, null, str2)) {
                    ((zzfr) zzlbVar2.mBuilder).getClass();
                    if (zzlbVar2.zzY(24, "user property", str2)) {
                        i = 0;
                    }
                } else {
                    iZzl = 15;
                }
            }
            anonymousClass7 = this.zzn;
            if (i != 0) {
                zzfr.zzP(zzfrVar.zzp);
                String strZzD = zzlb.zzD(str2, 24, true);
                length = str2 != null ? str2.length() : 0;
                zzfr.zzP(zzfrVar.zzp);
                zzlb.zzN(anonymousClass7, null, i, "_ev", strZzD, length);
                return;
            }
            if (obj != null) {
                zzfo zzfoVar = zzfrVar.zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzp(new zzgi(this, str3, str2, null, j, 1));
                return;
            }
            zzlb zzlbVar3 = zzfrVar.zzp;
            zzfr.zzP(zzlbVar3);
            iZzd = zzlbVar3.zzd(obj, str2);
            zzlbVar = zzfrVar.zzp;
            if (iZzd != 0) {
                zzfr.zzP(zzlbVar);
                String strZzD2 = zzlb.zzD(str2, 24, true);
                length = (!(obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0;
                zzfr.zzP(zzlbVar);
                zzlb.zzN(anonymousClass7, null, iZzd, "_ev", strZzD2, length);
                return;
            }
            zzfr.zzP(zzlbVar);
            objZzB = zzlbVar.zzB(obj, str2);
            if (objZzB != null) {
                zzfo zzfoVar2 = zzfrVar.zzn;
                zzfr.zzR(zzfoVar2);
                zzfoVar2.zzp(new zzgi(this, str3, str2, objZzB, j, 1));
            }
        }
        zzlb zzlbVar4 = zzfrVar.zzp;
        zzfr.zzP(zzlbVar4);
        iZzl = zzlbVar4.zzl(str2);
        i = iZzl;
        anonymousClass7 = this.zzn;
        if (i != 0) {
            zzfr.zzP(zzfrVar.zzp);
            String strZzD3 = zzlb.zzD(str2, 24, true);
            if (str2 != null) {
            }
            zzfr.zzP(zzfrVar.zzp);
            zzlb.zzN(anonymousClass7, null, i, "_ev", strZzD3, length);
            return;
        }
        if (obj != null) {
            zzfo zzfoVar3 = zzfrVar.zzn;
            zzfr.zzR(zzfoVar3);
            zzfoVar3.zzp(new zzgi(this, str3, str2, null, j, 1));
            return;
        }
        zzlb zzlbVar5 = zzfrVar.zzp;
        zzfr.zzP(zzlbVar5);
        iZzd = zzlbVar5.zzd(obj, str2);
        zzlbVar = zzfrVar.zzp;
        if (iZzd != 0) {
            zzfr.zzP(zzlbVar);
            String strZzD4 = zzlb.zzD(str2, 24, true);
            if (obj instanceof String) {
            }
            zzfr.zzP(zzlbVar);
            zzlb.zzN(anonymousClass7, null, iZzd, "_ev", strZzD4, length);
            return;
        }
        zzfr.zzP(zzlbVar);
        objZzB = zzlbVar.zzB(obj, str2);
        if (objZzB != null) {
            zzfo zzfoVar4 = zzfrVar.zzn;
            zzfr.zzR(zzfoVar4);
            zzfoVar4.zzp(new zzgi(this, str3, str2, objZzB, j, 1));
        }
    }

    public final void zzaa(Boolean bool, boolean z) {
        zzg();
        zza();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zzb(bool, "Setting app measurement enabled (FE)");
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzg();
        SharedPreferences.Editor editorEdit = zzewVar.zza().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z) {
            zzew zzewVar2 = zzfrVar.zzl;
            zzfr.zzP(zzewVar2);
            zzewVar2.zzg();
            SharedPreferences.Editor editorEdit2 = zzewVar2.zza().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (zzfrVar.zzF || !(bool == null || bool.booleanValue())) {
            zzab();
        }
    }

    public final void zzab() {
        zzg();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        String strZza = zzewVar.zzh.zza();
        if (strZza != null) {
            boolean zEquals = "unset".equals(strZza);
            DefaultClock defaultClock = zzfrVar.zzr;
            if (zEquals) {
                defaultClock.getClass();
                zzY(System.currentTimeMillis(), null, "app", "_npa");
            } else {
                Long lValueOf = Long.valueOf(true != "true".equals(strZza) ? 0L : 1L);
                defaultClock.getClass();
                zzY(System.currentTimeMillis(), lValueOf, "app", "_npa");
            }
        }
        boolean zZzJ = zzfrVar.zzJ();
        zzeh zzehVar = zzfrVar.zzm;
        if (!zZzJ || !this.zzc) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Updating Scion state (FE)");
            zzjm zzjmVarZzt = zzfrVar.zzt();
            zzjmVarZzt.zzg();
            zzjmVarZzt.zza();
            zzjmVarZzt.zzR(new zziq(zzjmVarZzt, zzjmVarZzt.zzO(true), 2));
            return;
        }
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzof.zzc();
        if (zzfrVar.zzk.zzs(null, zzdu.zzad)) {
            zzkc zzkcVar = zzfrVar.zzo;
            zzfr.zzQ(zzkcVar);
            zzkcVar.zza.zza();
        }
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzgy(this, 1));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final String zzo$1() {
        return (String) this.zzg.get();
    }

    public final void zzz() {
        zzg();
        zza();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zzfrVar.zzM()) {
            zzdt zzdtVar = zzdu.zzX;
            zzag zzagVar = zzfrVar.zzk;
            if (zzagVar.zzs(null, zzdtVar)) {
                ((zzfr) zzagVar.mBuilder).getClass();
                Boolean boolZzk = zzagVar.zzk("google_analytics_deferred_deep_link_enabled");
                if (boolZzk != null && boolZzk.booleanValue()) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzk.zza("Deferred Deep Link feature enabled.");
                    zzfo zzfoVar = zzfrVar.zzn;
                    zzfr.zzR(zzfoVar);
                    zzfoVar.zzp(new zzgy(this, 0));
                }
            }
            zzjm zzjmVarZzt = zzfrVar.zzt();
            zzjmVarZzt.zzg();
            zzjmVarZzt.zza();
            zzq zzqVarZzO = zzjmVarZzt.zzO(true);
            ((zzfr) zzjmVarZzt.mBuilder).zzi().zzq(3, new byte[0]);
            zzjmVarZzt.zzR(new zziq(zzjmVarZzt, zzqVarZzO, 1));
            this.zzc = false;
            zzew zzewVar = zzfrVar.zzl;
            zzfr.zzP(zzewVar);
            zzewVar.zzg();
            String string = zzewVar.zza().getString("previous_os_version", null);
            ((zzfr) zzewVar.mBuilder).zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzewVar.zza().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzfrVar.zzg().zzu();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzG("auto", "_ou", bundle);
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0383  */
    /* JADX WARN: Code duplicated, block: B:136:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:138:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:140:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:141:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:143:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:144:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:146:0x03da  */
    /* JADX WARN: Code duplicated, block: B:147:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:149:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:154:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:156:0x0401  */
    /* JADX WARN: Code duplicated, block: B:158:0x0408  */
    /* JADX WARN: Code duplicated, block: B:161:0x0411  */
    /* JADX WARN: Code duplicated, block: B:163:0x041c  */
    /* JADX WARN: Code duplicated, block: B:166:0x045d  */
    /* JADX WARN: Code duplicated, block: B:167:0x0471  */
    /* JADX WARN: Code duplicated, block: B:170:0x0491  */
    /* JADX WARN: Code duplicated, block: B:173:0x049d A[LOOP:2: B:171:0x0497->B:173:0x049d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:191:0x03ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x03ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x04b2 A[SYNTHETIC] */
    public final void zzI(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        boolean z4;
        long j2;
        long j3;
        ArrayList arrayList;
        int size;
        int i;
        int i2;
        Bundle bundleZzt;
        String str3;
        zzlb zzlbVar;
        Bundle bundle2;
        zzea zzeaVarZzi;
        byte[] bArrMarshall;
        boolean zZzq;
        boolean z5;
        Iterator it;
        String str4;
        Object obj;
        Bundle[] bundleArr;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotNull(bundle);
        zzg();
        zza();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        boolean zZzJ = zzfrVar.zzJ();
        zzeh zzehVar = zzfrVar.zzm;
        if (!zZzJ) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zza("Event not sent since app measurement is disabled");
            return;
        }
        List list = zzfrVar.zzh().zzh;
        if (list != null && !list.contains(str2)) {
            zzfr.zzR(zzehVar);
            zzehVar.zzk.zzc(str2, "Dropping non-safelisted event. event name, origin", str);
            return;
        }
        if (!this.zzf) {
            this.zzf = true;
            try {
                boolean z6 = zzfrVar.zzi;
                Context context = zzfrVar.zze;
                try {
                    (!z6 ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, context.getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, context);
                } catch (Exception e) {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zzb(e, "Failed to invoke Tag Manager's initialize() method");
                }
            } catch (ClassNotFoundException unused) {
                zzfr.zzR(zzehVar);
                zzehVar.zzj.zza("Tag Manager is not found and thus will not be used");
            }
        }
        boolean zEquals = "_cmp".equals(str2);
        DefaultClock defaultClock = zzfrVar.zzr;
        if (zEquals && bundle.containsKey("gclid")) {
            String string = bundle.getString("gclid");
            defaultClock.getClass();
            zzY(System.currentTimeMillis(), string, "auto", "_lgclid");
        }
        zzew zzewVar = zzfrVar.zzl;
        zzlb zzlbVar2 = zzfrVar.zzp;
        if (z && !zzlb.zzb[0].equals(str2)) {
            zzfr.zzP(zzlbVar2);
            zzfr.zzP(zzewVar);
            zzlbVar2.zzL(bundle, zzewVar.zzs.zza());
        }
        zzec zzecVar = zzfrVar.zzq;
        Fragment.AnonymousClass7 anonymousClass7 = this.zzn;
        if (!z3 && !"_iap".equals(str2)) {
            zzfr.zzP(zzlbVar2);
            int i3 = 2;
            if (zzlbVar2.zzac("event", str2)) {
                if (zzlbVar2.zzZ("event", zzg.f3zza, zzg.zzb, str2)) {
                    ((zzfr) zzlbVar2.mBuilder).getClass();
                    if (zzlbVar2.zzY(40, "event", str2)) {
                        i3 = 0;
                    }
                } else {
                    i3 = 13;
                }
            }
            if (i3 != 0) {
                zzfr.zzR(zzehVar);
                zzehVar.zzf.zzb(zzecVar.zzd(str2), "Invalid public event name. Event will not be logged (FE)");
                zzfr.zzP(zzlbVar2);
                String strZzD = zzlb.zzD(str2, 40, true);
                int length = str2 != null ? str2.length() : 0;
                zzfr.zzP(zzlbVar2);
                zzlb.zzN(anonymousClass7, null, i3, "_ev", strZzD, length);
                return;
            }
        }
        zzim zzimVar = zzfrVar.zzs;
        zzfr.zzQ(zzimVar);
        zzie zzieVarZzj = zzimVar.zzj(false);
        if (zzieVarZzj != null && !bundle.containsKey("_sc")) {
            zzieVarZzj.zzd = true;
        }
        zzlb.zzK(zzieVarZzj, bundle, z && !z3);
        boolean zEquals2 = "am".equals(str);
        boolean zZzah = zzlb.zzah(str2);
        if (!z || this.zzd == null || zZzah) {
            z4 = zEquals2;
        } else {
            if (!zEquals2) {
                zzfr.zzR(zzehVar);
                zzehVar.zzk.zzc(zzecVar.zzd(str2), "Passing event to registered event handler (FE)", zzecVar.zzb(bundle));
                com.google.android.gms.common.internal.zzah.checkNotNull(this.zzd);
                ((zzz) this.zzd).interceptEvent(str, str2, bundle, j);
                return;
            }
            z4 = true;
        }
        if (zzfrVar.zzM()) {
            zzfr.zzP(zzlbVar2);
            int iZzh = zzlbVar2.zzh(str2);
            if (iZzh != 0) {
                zzfr.zzR(zzehVar);
                zzehVar.zzf.zzb(zzecVar.zzd(str2), "Invalid event name. Event will not be logged (FE)");
                zzfr.zzP(zzlbVar2);
                String strZzD2 = zzlb.zzD(str2, 40, true);
                int length2 = str2 != null ? str2.length() : 0;
                zzfr.zzP(zzlbVar2);
                zzlb.zzN(anonymousClass7, null, iZzh, "_ev", strZzD2, length2);
                return;
            }
            List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList("_o", GsPcpBmONXh.SjLsTOuGIo, "_sc", "_si"));
            zzfr.zzP(zzlbVar2);
            Bundle bundleZzy = zzlbVar2.zzy(str2, bundle, listUnmodifiableList, z3);
            com.google.android.gms.common.internal.zzah.checkNotNull(bundleZzy);
            zzfr.zzQ(zzimVar);
            zzie zzieVarZzj2 = zzimVar.zzj(false);
            zzkc zzkcVar = zzfrVar.zzo;
            boolean z7 = z4;
            String str5 = "_o";
            if (zzieVarZzj2 != null && "_ae".equals(str2)) {
                zzfr.zzQ(zzkcVar);
                zzka zzkaVar = zzkcVar.zzb;
                ((zzfr) zzkaVar.zzc.mBuilder).zzr.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j4 = jElapsedRealtime - zzkaVar.zzb;
                zzkaVar.zzb = jElapsedRealtime;
                if (j4 > 0) {
                    zzfr.zzP(zzlbVar2);
                    zzlbVar2.zzI(bundleZzy, j4);
                }
            }
            zznw.zzc();
            if (zzfrVar.zzk.zzs(null, zzdu.zzac)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    zzfr.zzP(zzlbVar2);
                    String string2 = bundleZzy.getString("_ffr");
                    int i4 = Strings.$r8$clinit;
                    if (string2 == null || string2.trim().isEmpty()) {
                        string2 = null;
                    } else if (string2 != null) {
                        string2 = string2.trim();
                    }
                    zzfr zzfrVar2 = (zzfr) zzlbVar2.mBuilder;
                    zzew zzewVar2 = zzfrVar2.zzl;
                    zzfr.zzP(zzewVar2);
                    String strZza = zzewVar2.zzp.zza();
                    if (string2 == strZza || (string2 != null && string2.equals(strZza))) {
                        zzeh zzehVar2 = zzfrVar2.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzk.zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    } else {
                        zzew zzewVar3 = zzfrVar2.zzl;
                        zzfr.zzP(zzewVar3);
                        zzewVar3.zzp.zzb(string2);
                    }
                } else if ("_ae".equals(str2)) {
                    zzfr.zzP(zzlbVar2);
                    zzew zzewVar4 = ((zzfr) zzlbVar2.mBuilder).zzl;
                    zzfr.zzP(zzewVar4);
                    String strZza2 = zzewVar4.zzp.zza();
                    if (!TextUtils.isEmpty(strZza2)) {
                        bundleZzy.putString("_ffr", strZza2);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bundleZzy);
            zzfr.zzP(zzewVar);
            if (zzewVar.zzj.zza() > 0) {
                zzfr.zzP(zzewVar);
                if (zzewVar.zzk(j)) {
                    zzfr.zzP(zzewVar);
                    if (zzewVar.zzm.zzb()) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzl.zza("Current session is expired, remove the session number, ID, and engagement time");
                        defaultClock.getClass();
                        j2 = j;
                        zzY(System.currentTimeMillis(), null, "auto", "_sid");
                        defaultClock.getClass();
                        zzY(System.currentTimeMillis(), null, "auto", "_sno");
                        defaultClock.getClass();
                        zzY(System.currentTimeMillis(), null, "auto", "_se");
                        zzfr.zzP(zzewVar);
                        j3 = 0;
                        zzewVar.zzk.zzb(0L);
                    }
                    if (bundleZzy.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j3) == 1) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzl.zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                        zzfr.zzQ(zzkcVar);
                        zzkcVar.zza.zzb(j2, true);
                    }
                    arrayList = new ArrayList(bundleZzy.keySet());
                    Collections.sort(arrayList);
                    size = arrayList.size();
                    for (i = 0; i < size; i++) {
                        str4 = (String) arrayList.get(i);
                        if (str4 != null) {
                            zzfr.zzP(zzlbVar2);
                            obj = bundleZzy.get(str4);
                            if (obj instanceof Bundle) {
                                bundleArr = new Bundle[]{(Bundle) obj};
                            } else if (obj instanceof Parcelable[]) {
                                Parcelable[] parcelableArr = (Parcelable[]) obj;
                                bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                            } else if (obj instanceof ArrayList) {
                                ArrayList arrayList3 = (ArrayList) obj;
                                bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                            } else {
                                bundleArr = null;
                            }
                            if (bundleArr != null) {
                                bundleZzy.putParcelableArray(str4, bundleArr);
                            }
                        }
                    }
                    i2 = 0;
                    while (i2 < arrayList2.size()) {
                        bundleZzt = (Bundle) arrayList2.get(i2);
                        if (i2 != 0) {
                            str3 = "_ep";
                        } else {
                            str3 = str2;
                        }
                        String str6 = str5;
                        bundleZzt.putString(str6, str);
                        if (z2) {
                            zzfr.zzP(zzlbVar2);
                            zzlbVar = zzlbVar2;
                            bundleZzt = zzlbVar.zzt(bundleZzt);
                        } else {
                            zzlbVar = zzlbVar2;
                        }
                        bundle2 = bundleZzt;
                        zzaw zzawVar = new zzaw(str3, new zzau(bundle2), str, j);
                        zzjm zzjmVarZzt = zzfrVar.zzt();
                        zzjmVarZzt.getClass();
                        zzjmVarZzt.zzg();
                        zzjmVarZzt.zza();
                        zzfr zzfrVar3 = (zzfr) zzjmVarZzt.mBuilder;
                        zzfrVar3.getClass();
                        zzeaVarZzi = zzfrVar3.zzi();
                        zzeaVarZzi.getClass();
                        Parcel parcelObtain = Parcel.obtain();
                        zzr.zza(zzawVar, parcelObtain, 0);
                        bArrMarshall = parcelObtain.marshall();
                        parcelObtain.recycle();
                        if (bArrMarshall.length > 131072) {
                            zzeh zzehVar3 = ((zzfr) zzeaVarZzi.mBuilder).zzm;
                            zzfr.zzR(zzehVar3);
                            zzehVar3.zze.zza("Event is too long for local database. Sending event directly to service");
                            z5 = true;
                            zZzq = false;
                        } else {
                            zZzq = zzeaVarZzi.zzq(0, bArrMarshall);
                            z5 = true;
                        }
                        zzjmVarZzt.zzR(new zzio(zzjmVarZzt, zzjmVarZzt.zzO(z5), zZzq, zzawVar, 1));
                        if (!z7) {
                            it = this.zze.iterator();
                            while (it.hasNext()) {
                                ((zzgs) it.next()).onEvent(str, str2, new Bundle(bundle2), j);
                            }
                        }
                        i2++;
                        str5 = str6;
                        zzlbVar2 = zzlbVar;
                    }
                    zzfr.zzQ(zzimVar);
                    if (zzimVar.zzj(false) == null && "_ae".equals(str2)) {
                        zzfr.zzQ(zzkcVar);
                        defaultClock.getClass();
                        zzkcVar.zzb.zzd(SystemClock.elapsedRealtime(), true, true);
                        return;
                    }
                }
                j2 = j;
            } else {
                j2 = j;
            }
            j3 = 0;
            if (bundleZzy.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j3) == 1) {
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                zzfr.zzQ(zzkcVar);
                zzkcVar.zza.zzb(j2, true);
            }
            arrayList = new ArrayList(bundleZzy.keySet());
            Collections.sort(arrayList);
            size = arrayList.size();
            while (i < size) {
                str4 = (String) arrayList.get(i);
                if (str4 != null) {
                    zzfr.zzP(zzlbVar2);
                    obj = bundleZzy.get(str4);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[]{(Bundle) obj};
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr2 = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr2, parcelableArr2.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList4 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleZzy.putParcelableArray(str4, bundleArr);
                    }
                }
            }
            i2 = 0;
            while (i2 < arrayList2.size()) {
                bundleZzt = (Bundle) arrayList2.get(i2);
                if (i2 != 0) {
                    str3 = "_ep";
                } else {
                    str3 = str2;
                }
                String str7 = str5;
                bundleZzt.putString(str7, str);
                if (z2) {
                    zzfr.zzP(zzlbVar2);
                    zzlbVar = zzlbVar2;
                    bundleZzt = zzlbVar.zzt(bundleZzt);
                } else {
                    zzlbVar = zzlbVar2;
                }
                bundle2 = bundleZzt;
                zzaw zzawVar2 = new zzaw(str3, new zzau(bundle2), str, j);
                zzjm zzjmVarZzt2 = zzfrVar.zzt();
                zzjmVarZzt2.getClass();
                zzjmVarZzt2.zzg();
                zzjmVarZzt2.zza();
                zzfr zzfrVar4 = (zzfr) zzjmVarZzt2.mBuilder;
                zzfrVar4.getClass();
                zzeaVarZzi = zzfrVar4.zzi();
                zzeaVarZzi.getClass();
                Parcel parcelObtain2 = Parcel.obtain();
                zzr.zza(zzawVar2, parcelObtain2, 0);
                bArrMarshall = parcelObtain2.marshall();
                parcelObtain2.recycle();
                if (bArrMarshall.length > 131072) {
                    zzeh zzehVar4 = ((zzfr) zzeaVarZzi.mBuilder).zzm;
                    zzfr.zzR(zzehVar4);
                    zzehVar4.zze.zza("Event is too long for local database. Sending event directly to service");
                    z5 = true;
                    zZzq = false;
                } else {
                    zZzq = zzeaVarZzi.zzq(0, bArrMarshall);
                    z5 = true;
                }
                zzjmVarZzt2.zzR(new zzio(zzjmVarZzt2, zzjmVarZzt2.zzO(z5), zZzq, zzawVar2, 1));
                if (!z7) {
                    it = this.zze.iterator();
                    while (it.hasNext()) {
                        ((zzgs) it.next()).onEvent(str, str2, new Bundle(bundle2), j);
                    }
                }
                i2++;
                str5 = str7;
                zzlbVar2 = zzlbVar;
            }
            zzfr.zzQ(zzimVar);
            if (zzimVar.zzj(false) == null) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0069  */
    public final void zzY(long j, Object obj, String str, String str2) {
        Object obj2;
        String str3;
        boolean zZzq;
        Object objValueOf = obj;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        zzg();
        zza();
        boolean zEquals = ZRqOdXiy.gnLxHbtQicmoSCw.equals(str2);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zEquals) {
            if (objValueOf instanceof String) {
                String str4 = (String) objValueOf;
                if (!TextUtils.isEmpty(str4)) {
                    long j2 = true != "false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                    objValueOf = Long.valueOf(j2);
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    zzewVar.zzh.zzb(j2 == 1 ? "true" : "false");
                } else if (objValueOf == null) {
                    zzew zzewVar2 = zzfrVar.zzl;
                    zzfr.zzP(zzewVar2);
                    zzewVar2.zzh.zzb("unset");
                } else {
                    obj2 = objValueOf;
                    str3 = str2;
                }
            } else if (objValueOf == null) {
                zzew zzewVar3 = zzfrVar.zzl;
                zzfr.zzP(zzewVar3);
                zzewVar3.zzh.zzb("unset");
            } else {
                obj2 = objValueOf;
                str3 = str2;
            }
            obj2 = objValueOf;
            str3 = "_npa";
        } else {
            obj2 = objValueOf;
            str3 = str2;
        }
        if (!zzfrVar.zzJ()) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("User property not set since app measurement is disabled");
            return;
        }
        if (zzfrVar.zzM()) {
            zzkw zzkwVar = new zzkw(j, obj2, str3, str);
            zzjm zzjmVarZzt = zzfrVar.zzt();
            zzjmVarZzt.zzg();
            zzjmVarZzt.zza();
            zzfr zzfrVar2 = (zzfr) zzjmVarZzt.mBuilder;
            zzfrVar2.getClass();
            zzea zzeaVarZzi = zzfrVar2.zzi();
            zzeaVarZzi.getClass();
            Parcel parcelObtain = Parcel.obtain();
            zzr.zza(zzkwVar, parcelObtain);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            if (bArrMarshall.length > 131072) {
                zzeh zzehVar2 = ((zzfr) zzeaVarZzi.mBuilder).zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zze.zza("User property too long for local database. Sending directly to service");
                zZzq = false;
            } else {
                zZzq = zzeaVarZzi.zzq(1, bArrMarshall);
            }
            zzjmVarZzt.zzR(new zzio(zzjmVarZzt, zzjmVarZzt.zzO(true), zZzq, zzkwVar, 0));
        }
    }

    public final void zzR(Bundle bundle, int i, long j) {
        Object obj;
        String string;
        zza();
        zzai zzaiVar = zzai.zza;
        zzah[] zzahVarArrValues = zzah.values();
        int length = zzahVarArrValues.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            zzah zzahVar = zzahVarArrValues[i2];
            if (bundle.containsKey(zzahVar.zzd) && (string = bundle.getString(zzahVar.zzd)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            zzfr zzfrVar = (zzfr) this.mBuilder;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzi.zzb(obj, mnwSv.CqxuXlV);
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzi.zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), i, j);
    }
}
