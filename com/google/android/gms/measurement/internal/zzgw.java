package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.work.impl.WorkerWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzgw implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzhx zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzgw(zzhx zzhxVar, Bundle bundle, int i) {
        this.$r8$classId = i;
        this.zza = zzhxVar;
        this.zzb = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzhx zzhxVar = this.zza;
                zzfr zzfrVar = (zzfr) zzhxVar.mBuilder;
                Bundle bundle = this.zzb;
                if (bundle == null) {
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    zzewVar.zzs.zzb(new Bundle());
                    break;
                } else {
                    zzew zzewVar2 = zzfrVar.zzl;
                    zzfr.zzP(zzewVar2);
                    Bundle bundleZza = zzewVar2.zzs.zza();
                    Iterator<String> it = bundle.keySet().iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        Fragment.AnonymousClass7 anonymousClass7 = zzhxVar.zzn;
                        zzeh zzehVar = zzfrVar.zzm;
                        zzlb zzlbVar = zzfrVar.zzp;
                        if (!zHasNext) {
                            zzfr.zzP(zzlbVar);
                            int iZzc = zzfrVar.zzk.zzc();
                            if (bundleZza.size() > iZzc) {
                                int i = 0;
                                for (String str : new TreeSet(bundleZza.keySet())) {
                                    i++;
                                    if (i > iZzc) {
                                        bundleZza.remove(str);
                                    }
                                }
                                zzfr.zzP(zzlbVar);
                                zzlb.zzN(anonymousClass7, null, 26, null, null, 0);
                                zzfr.zzR(zzehVar);
                                zzehVar.zzi.zza("Too many default event parameters set. Discarding beyond event parameter limit");
                            }
                            zzew zzewVar3 = zzfrVar.zzl;
                            zzfr.zzP(zzewVar3);
                            zzewVar3.zzs.zzb(bundleZza);
                            zzjm zzjmVarZzt = zzfrVar.zzt();
                            zzjmVarZzt.zzg();
                            zzjmVarZzt.zza();
                            zzjmVarZzt.zzR(new WorkerWrapper.AnonymousClass1(zzjmVarZzt, zzjmVarZzt.zzO(false), bundleZza, 24));
                            break;
                        } else {
                            String next = it.next();
                            Object obj = bundle.get(next);
                            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                                zzfr.zzP(zzlbVar);
                                if (zzlb.zzaf(obj)) {
                                    zzlb.zzN(anonymousClass7, null, 27, null, null, 0);
                                }
                                zzfr.zzR(zzehVar);
                                zzehVar.zzi.zzc(next, "Invalid default event parameter type. Name, value", obj);
                            } else if (zzlb.zzah(next)) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzi.zzb(next, "Invalid default event parameter name. Name");
                            } else if (obj == null) {
                                bundleZza.remove(next);
                            } else {
                                zzfr.zzP(zzlbVar);
                                if (zzlbVar.zzaa("param", next, 100, obj)) {
                                    zzlbVar.zzO(bundleZza, next, obj);
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                zzhx zzhxVar2 = this.zza;
                zzhxVar2.zzg();
                zzhxVar2.zza();
                Bundle bundle2 = this.zzb;
                String string = bundle2.getString("name");
                String string2 = bundle2.getString(FirebaseAnalytics.Param.ORIGIN);
                com.google.android.gms.common.internal.zzah.checkNotEmpty(string);
                com.google.android.gms.common.internal.zzah.checkNotEmpty(string2);
                com.google.android.gms.common.internal.zzah.checkNotNull(bundle2.get(FirebaseAnalytics.Param.VALUE));
                zzfr zzfrVar2 = (zzfr) zzhxVar2.mBuilder;
                boolean zZzJ = zzfrVar2.zzJ();
                zzlb zzlbVar2 = zzfrVar2.zzp;
                if (!zZzJ) {
                    zzeh zzehVar2 = zzfrVar2.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzl.zza("Conditional property not set since app measurement is disabled");
                } else {
                    zzkw zzkwVar = new zzkw(bundle2.getLong("triggered_timestamp"), bundle2.get(FirebaseAnalytics.Param.VALUE), string, string2);
                    try {
                        zzfr.zzP(zzlbVar2);
                        bundle2.getString("app_id");
                        zzaw zzawVarZzz = zzlbVar2.zzz(bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), string2, 0L, true);
                        zzfr.zzP(zzlbVar2);
                        bundle2.getString("app_id");
                        zzaw zzawVarZzz2 = zzlbVar2.zzz(bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), string2, 0L, true);
                        zzfr.zzP(zzlbVar2);
                        bundle2.getString("app_id");
                        zzfrVar2.zzt().zzE(new zzac(bundle2.getString("app_id"), string2, zzkwVar, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), zzawVarZzz2, bundle2.getLong("trigger_timeout"), zzawVarZzz, bundle2.getLong("time_to_live"), zzlbVar2.zzz(bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), string2, 0L, true)));
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
                break;
            default:
                zzhx zzhxVar3 = this.zza;
                zzhxVar3.zzg();
                zzhxVar3.zza();
                Bundle bundle3 = this.zzb;
                String string3 = bundle3.getString("name");
                com.google.android.gms.common.internal.zzah.checkNotEmpty(string3);
                zzfr zzfrVar3 = (zzfr) zzhxVar3.mBuilder;
                if (!zzfrVar3.zzJ()) {
                    zzeh zzehVar3 = zzfrVar3.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzl.zza("Conditional property not cleared since app measurement is disabled");
                } else {
                    zzkw zzkwVar2 = new zzkw(0L, null, string3, "");
                    try {
                        zzlb zzlbVar3 = zzfrVar3.zzp;
                        zzfr.zzP(zzlbVar3);
                        bundle3.getString("app_id");
                        zzfrVar3.zzt().zzE(new zzac(bundle3.getString("app_id"), "", zzkwVar2, bundle3.getLong("creation_timestamp"), bundle3.getBoolean("active"), bundle3.getString("trigger_event_name"), null, bundle3.getLong("trigger_timeout"), null, bundle3.getLong("time_to_live"), zzlbVar3.zzz(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), "", bundle3.getLong("creation_timestamp"), true)));
                    } catch (IllegalArgumentException unused2) {
                        return;
                    }
                }
                break;
        }
    }
}
