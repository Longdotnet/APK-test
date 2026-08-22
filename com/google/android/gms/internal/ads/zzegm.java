package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzegm {
    private final zzgeh zzc;
    private zzehc zzf;
    private final String zzh;
    private final int zzi;
    private final zzehb zzj;
    private zzfca zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    public zzegm(zzfcn zzfcnVar, zzehb zzehbVar, zzgeh zzgehVar) {
        this.zzi = zzfcnVar.zzb.zzb.zzr;
        this.zzj = zzehbVar;
        this.zzc = zzgehVar;
        this.zzh = zzehi.zzc(zzfcnVar);
        List list = zzfcnVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzfca) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zze() {
        this.zzj.zzi(this.zzk);
        zzehc zzehcVar = this.zzf;
        if (zzehcVar != null) {
            this.zzc.zzc(zzehcVar);
        } else {
            this.zzc.zzd(new zzehf(3, this.zzh));
        }
    }

    private final synchronized boolean zzf(boolean z) {
        try {
            for (zzfca zzfcaVar : this.zzb) {
                Integer num = (Integer) this.zza.get(zzfcaVar);
                int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
                if (z || !this.zze.contains(zzfcaVar.zzat)) {
                    int i = this.zzg;
                    if (iIntValue < i) {
                        return true;
                    }
                    if (iIntValue > i) {
                        break;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzg() {
        try {
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) this.zza.get((zzfca) it.next());
                if ((num != null ? num.intValue() : Integer.MAX_VALUE) < this.zzg) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean zzh() {
        return zzf(true) || zzg();
    }

    private final synchronized boolean zzi() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzfca) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi && zzf(false)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized zzfca zza() {
        try {
            if (zzi()) {
                int i = 0;
                while (true) {
                    List list = this.zzb;
                    if (i >= list.size()) {
                        break;
                    }
                    zzfca zzfcaVar = (zzfca) list.get(i);
                    String str = zzfcaVar.zzat;
                    Set set = this.zze;
                    if (!set.contains(str)) {
                        if (zzfcaVar.zzav) {
                            this.zzl = true;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            set.add(str);
                        }
                        this.zzd.add(zzfcaVar);
                        return (zzfca) list.remove(i);
                    }
                    i++;
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(Throwable th, zzfca zzfcaVar) {
        this.zzl = false;
        this.zzd.remove(zzfcaVar);
        this.zze.remove(zzfcaVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zze();
    }

    public final synchronized void zzc(zzehc zzehcVar, zzfca zzfcaVar) {
        this.zzl = false;
        this.zzd.remove(zzfcaVar);
        if (zzd()) {
            zzehcVar.zzr();
            return;
        }
        Integer num = (Integer) this.zza.get(zzfcaVar);
        int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
        if (iIntValue > this.zzg) {
            this.zzj.zzm(zzfcaVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = iIntValue;
        this.zzf = zzehcVar;
        this.zzk = zzfcaVar;
        if (zzh()) {
            return;
        }
        zze();
    }

    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
