package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzos {
    private final zzbj zza;
    private zzfyq zzb = zzfyq.zzn();
    private zzfyt zzc = zzfyt.zzd();
    private zzvh zzd;
    private zzvh zze;
    private zzvh zzf;

    public zzos(zzbj zzbjVar) {
        this.zza = zzbjVar;
    }

    private static zzvh zzj(zzbh zzbhVar, zzfyq zzfyqVar, zzvh zzvhVar, zzbj zzbjVar) {
        zzbl zzblVarZzo = zzbhVar.zzo();
        int iZzf = zzbhVar.zzf();
        Object objZzf = zzblVarZzo.zzo() ? null : zzblVarZzo.zzf(iZzf);
        int iZzc = (zzbhVar.zzx() || zzblVarZzo.zzo()) ? -1 : zzblVarZzo.zzd(iZzf, zzbjVar, false).zzc(zzex.zzs(zzbhVar.zzl()));
        for (int i = 0; i < zzfyqVar.size(); i++) {
            zzvh zzvhVar2 = (zzvh) zzfyqVar.get(i);
            if (zzm(zzvhVar2, objZzf, zzbhVar.zzx(), zzbhVar.zzc(), zzbhVar.zzd(), iZzc)) {
                return zzvhVar2;
            }
        }
        if (zzfyqVar.isEmpty() && zzvhVar != null) {
            if (zzm(zzvhVar, objZzf, zzbhVar.zzx(), zzbhVar.zzc(), zzbhVar.zzd(), iZzc)) {
                return zzvhVar;
            }
        }
        return null;
    }

    private final void zzk(zzfys zzfysVar, zzvh zzvhVar, zzbl zzblVar) {
        if (zzvhVar == null) {
            return;
        }
        if (zzblVar.zza(zzvhVar.zza) != -1) {
            zzfysVar.zza(zzvhVar, zzblVar);
            return;
        }
        zzbl zzblVar2 = (zzbl) this.zzc.get(zzvhVar);
        if (zzblVar2 != null) {
            zzfysVar.zza(zzvhVar, zzblVar2);
        }
    }

    private final void zzl(zzbl zzblVar) {
        zzfys zzfysVar = new zzfys();
        if (this.zzb.isEmpty()) {
            zzk(zzfysVar, this.zze, zzblVar);
            if (!Objects.equals(this.zzf, this.zze)) {
                zzk(zzfysVar, this.zzf, zzblVar);
            }
            if (!Objects.equals(this.zzd, this.zze) && !Objects.equals(this.zzd, this.zzf)) {
                zzk(zzfysVar, this.zzd, zzblVar);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfysVar, (zzvh) this.zzb.get(i), zzblVar);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfysVar, this.zzd, zzblVar);
            }
        }
        this.zzc = zzfysVar.zzc();
    }

    private static boolean zzm(zzvh zzvhVar, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzvhVar.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (zzvhVar.zzb != i || zzvhVar.zzc != i2) {
                return false;
            }
        } else if (zzvhVar.zzb != -1 || zzvhVar.zze != i3) {
            return false;
        }
        return true;
    }

    public final zzbl zza(zzvh zzvhVar) {
        return (zzbl) this.zzc.get(zzvhVar);
    }

    public final zzvh zzb() {
        return this.zzd;
    }

    public final zzvh zzc() {
        Object next;
        Object obj;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfyq zzfyqVar = this.zzb;
        if (!(zzfyqVar instanceof List)) {
            Iterator<E> it = zzfyqVar.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else {
            if (zzfyqVar.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = zzfyqVar.get(zzfyqVar.size() - 1);
        }
        return (zzvh) obj;
    }

    public final zzvh zzd() {
        return this.zze;
    }

    public final zzvh zze() {
        return this.zzf;
    }

    public final void zzg(zzbh zzbhVar) {
        this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzvh zzvhVar, zzbh zzbhVar) {
        this.zzb = zzfyq.zzl(list);
        if (!list.isEmpty()) {
            this.zze = (zzvh) list.get(0);
            zzvhVar.getClass();
            this.zzf = zzvhVar;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
        }
        zzl(zzbhVar.zzo());
    }

    public final void zzi(zzbh zzbhVar) {
        this.zzd = zzj(zzbhVar, this.zzb, this.zze, this.zza);
        zzl(zzbhVar.zzo());
    }
}
