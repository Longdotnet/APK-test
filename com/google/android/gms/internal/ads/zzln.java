package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzln implements zzvs, zzsd {
    final /* synthetic */ zzlr zza;
    private final zzlp zzb;

    public zzln(zzlr zzlrVar, zzlp zzlpVar) {
        Objects.requireNonNull(zzlrVar);
        this.zza = zzlrVar;
        this.zzb = zzlpVar;
    }

    private final Pair zzf(int i, zzvh zzvhVar) {
        zzvh zzvhVarZza;
        zzvh zzvhVar2 = null;
        if (zzvhVar != null) {
            zzlp zzlpVar = this.zzb;
            int i2 = 0;
            while (true) {
                List list = zzlpVar.zzc;
                if (i2 >= list.size()) {
                    zzvhVarZza = null;
                    break;
                }
                if (((zzvh) list.get(i2)).zzd == zzvhVar.zzd) {
                    Object obj = zzvhVar.zza;
                    Object obj2 = zzlpVar.zzb;
                    int i3 = zzly.zzb;
                    zzvhVarZza = zzvhVar.zza(Pair.create(obj2, obj));
                    break;
                }
                i2++;
            }
            if (zzvhVarZza == null) {
                return null;
            }
            zzvhVar2 = zzvhVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzvhVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzag(int i, zzvh zzvhVar, final zzvd zzvdVar) {
        final Pair pairZzf = zzf(0, zzvhVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzll
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zzvh) pair.second, zzvdVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzah(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar) {
        final Pair pairZzf = zzf(0, zzvhVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlk
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzvh) pair.second, zzuyVar, zzvdVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzai(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar) {
        final Pair pairZzf = zzf(0, zzvhVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlm
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzvh) pair.second, zzuyVar, zzvdVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzaj(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zzvhVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlj
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzaj(((Integer) pair.first).intValue(), (zzvh) pair.second, zzuyVar, zzvdVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzak(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar, final int i2) {
        final Pair pairZzf = zzf(0, zzvhVar);
        if (pairZzf != null) {
            this.zza.zzi.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzli
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzak(((Integer) pair.first).intValue(), (zzvh) pair.second, zzuyVar, zzvdVar, i2);
                }
            });
        }
    }
}
