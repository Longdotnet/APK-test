package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzlr {
    private final zzph zza;
    private final zzlq zze;
    private final zzmo zzh;
    private final zzdt zzi;
    private boolean zzj;
    private zzhj zzk;
    private zzxc zzl = new zzxc(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzlr(zzlq zzlqVar, zzmo zzmoVar, zzdt zzdtVar, zzph zzphVar) {
        this.zza = zzphVar;
        this.zze = zzlqVar;
        this.zzh = zzmoVar;
        this.zzi = zzdtVar;
    }

    private final void zzr(int i, int i2) {
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                return;
            }
            ((zzlp) list.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzlp zzlpVar) {
        zzlo zzloVar = (zzlo) this.zzf.get(zzlpVar);
        if (zzloVar != null) {
            zzloVar.zza.zzi(zzloVar.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzlp zzlpVar = (zzlp) it.next();
            if (zzlpVar.zzc.isEmpty()) {
                zzs(zzlpVar);
                it.remove();
            }
        }
    }

    private final void zzu(zzlp zzlpVar) {
        if (zzlpVar.zze && zzlpVar.zzc.isEmpty()) {
            zzlo zzloVar = (zzlo) this.zzf.remove(zzlpVar);
            zzloVar.getClass();
            zzvj zzvjVar = zzloVar.zza;
            zzvjVar.zzp(zzloVar.zzb);
            zzln zzlnVar = zzloVar.zzc;
            zzvjVar.zzs(zzlnVar);
            zzvjVar.zzr(zzlnVar);
            this.zzg.remove(zzlpVar);
        }
    }

    private final void zzv(zzlp zzlpVar) {
        zzvc zzvcVar = zzlpVar.zza;
        zzvi zzviVar = new zzvi() { // from class: com.google.android.gms.internal.ads.zzlh
            @Override // com.google.android.gms.internal.ads.zzvi
            public final void zza(zzvj zzvjVar, zzbl zzblVar) {
                this.zza.zze.zzk();
            }
        };
        zzln zzlnVar = new zzln(this, zzlpVar);
        this.zzf.put(zzlpVar, new zzlo(zzvcVar, zzviVar, zzlnVar));
        zzvcVar.zzh(new Handler(zzex.zzz(), null), zzlnVar);
        zzvcVar.zzg(new Handler(zzex.zzz(), null), zzlnVar);
        zzvcVar.zzm(zzviVar, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            zzlp zzlpVar = (zzlp) this.zzb.remove(i2);
            this.zzd.remove(zzlpVar.zzb);
            zzr(i2, -zzlpVar.zza.zzC().zzc());
            zzlpVar.zze = true;
            if (this.zzj) {
                zzu(zzlpVar);
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzbl zzb() {
        List list = this.zzb;
        if (list.isEmpty()) {
            return zzbl.zza;
        }
        int iZzc = 0;
        for (int i = 0; i < list.size(); i++) {
            zzlp zzlpVar = (zzlp) list.get(i);
            zzlpVar.zzd = iZzc;
            iZzc += zzlpVar.zza.zzC().zzc();
        }
        return new zzly(list, this.zzl);
    }

    public final zzbl zzc(int i, int i2, List list) {
        zzdd.zzd(i >= 0 && i <= i2 && i2 <= zza());
        zzdd.zzd(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzlp) this.zzb.get(i3)).zza.zzt((zzap) list.get(i3 - i));
        }
        return zzb();
    }

    public final void zzg(zzhj zzhjVar) {
        zzdd.zzf(!this.zzj);
        this.zzk = zzhjVar;
        int i = 0;
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                this.zzj = true;
                return;
            }
            zzlp zzlpVar = (zzlp) list.get(i);
            zzv(zzlpVar);
            this.zzg.add(zzlpVar);
            i++;
        }
    }

    public final void zzh() {
        for (zzlo zzloVar : this.zzf.values()) {
            try {
                zzloVar.zza.zzp(zzloVar.zzb);
            } catch (RuntimeException e) {
                zzea.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzvj zzvjVar = zzloVar.zza;
            zzln zzlnVar = zzloVar.zzc;
            zzvjVar.zzs(zzlnVar);
            zzvjVar.zzr(zzlnVar);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzvf zzvfVar) {
        IdentityHashMap identityHashMap = this.zzc;
        zzlp zzlpVar = (zzlp) identityHashMap.remove(zzvfVar);
        zzlpVar.getClass();
        zzlpVar.zza.zzG(zzvfVar);
        zzlpVar.zzc.remove(((zzuz) zzvfVar).zza);
        if (!identityHashMap.isEmpty()) {
            zzt();
        }
        zzu(zzlpVar);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzbl zzk(int i, List list, zzxc zzxcVar) {
        if (!list.isEmpty()) {
            this.zzl = zzxcVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzlp zzlpVar = (zzlp) list.get(i2 - i);
                if (i2 > 0) {
                    zzlp zzlpVar2 = (zzlp) this.zzb.get(i2 - 1);
                    zzlpVar.zzc(zzlpVar2.zza.zzC().zzc() + zzlpVar2.zzd);
                } else {
                    zzlpVar.zzc(0);
                }
                zzr(i2, zzlpVar.zza.zzC().zzc());
                this.zzb.add(i2, zzlpVar);
                this.zzd.put(zzlpVar.zzb, zzlpVar);
                if (this.zzj) {
                    zzv(zzlpVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzlpVar);
                    } else {
                        zzs(zzlpVar);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzbl zzl(int i, int i2, int i3, zzxc zzxcVar) {
        zzdd.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzbl zzm(int i, int i2, zzxc zzxcVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzdd.zzd(z);
        this.zzl = zzxcVar;
        zzw(i, i2);
        return zzb();
    }

    public final zzbl zzn(List list, zzxc zzxcVar) {
        List list2 = this.zzb;
        zzw(0, list2.size());
        return zzk(list2.size(), list, zzxcVar);
    }

    public final zzbl zzo(zzxc zzxcVar) {
        int iZza = zza();
        if (zzxcVar.zzc() != iZza) {
            zzxcVar = zzxcVar.zzf().zzg(0, iZza);
        }
        this.zzl = zzxcVar;
        return zzb();
    }

    public final zzvf zzp(zzvh zzvhVar, zzzm zzzmVar, long j) {
        int i = zzly.zzb;
        Pair pair = (Pair) zzvhVar.zza;
        Object obj = pair.first;
        zzvh zzvhVarZza = zzvhVar.zza(pair.second);
        zzlp zzlpVar = (zzlp) this.zzd.get(obj);
        zzlpVar.getClass();
        this.zzg.add(zzlpVar);
        zzlo zzloVar = (zzlo) this.zzf.get(zzlpVar);
        if (zzloVar != null) {
            zzloVar.zza.zzk(zzloVar.zzb);
        }
        zzlpVar.zzc.add(zzvhVarZza);
        zzuz zzuzVarZzI = zzlpVar.zza.zzI(zzvhVarZza, zzzmVar, j);
        this.zzc.put(zzuzVarZzI, zzlpVar);
        zzt();
        return zzuzVarZzI;
    }

    public final zzxc zzq() {
        return this.zzl;
    }
}
