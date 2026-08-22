package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzvr {
    public final int zza;
    public final zzvh zzb;
    private final CopyOnWriteArrayList zzc;

    private zzvr(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvh zzvhVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvhVar;
    }

    public final zzvr zza(int i, zzvh zzvhVar) {
        return new zzvr(this.zzc, 0, zzvhVar);
    }

    public final void zzb(Handler handler, zzvs zzvsVar) {
        this.zzc.add(new zzvq(handler, zzvsVar));
    }

    public final void zzc(final zzdn zzdnVar) {
        for (zzvq zzvqVar : this.zzc) {
            final zzvs zzvsVar = zzvqVar.zzb;
            zzex.zzP(zzvqVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzvp
                @Override // java.lang.Runnable
                public final void run() {
                    zzdnVar.zza(zzvsVar);
                }
            });
        }
    }

    public final void zzd(final zzvd zzvdVar) {
        zzc(new zzdn() { // from class: com.google.android.gms.internal.ads.zzvk
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                ((zzvs) obj).zzag(0, this.zza.zzb, zzvdVar);
            }
        });
    }

    public final void zze(final zzuy zzuyVar, final zzvd zzvdVar) {
        zzc(new zzdn() { // from class: com.google.android.gms.internal.ads.zzvo
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                ((zzvs) obj).zzah(0, this.zza.zzb, zzuyVar, zzvdVar);
            }
        });
    }

    public final void zzf(final zzuy zzuyVar, final zzvd zzvdVar) {
        zzc(new zzdn() { // from class: com.google.android.gms.internal.ads.zzvm
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                ((zzvs) obj).zzai(0, this.zza.zzb, zzuyVar, zzvdVar);
            }
        });
    }

    public final void zzg(final zzuy zzuyVar, final zzvd zzvdVar, final IOException iOException, final boolean z) {
        zzc(new zzdn() { // from class: com.google.android.gms.internal.ads.zzvn
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                ((zzvs) obj).zzaj(0, this.zza.zzb, zzuyVar, zzvdVar, iOException, z);
            }
        });
    }

    public final void zzh(final zzuy zzuyVar, final zzvd zzvdVar, final int i) {
        zzc(new zzdn() { // from class: com.google.android.gms.internal.ads.zzvl
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                ((zzvs) obj).zzak(0, this.zza.zzb, zzuyVar, zzvdVar, i);
            }
        });
    }

    public final void zzi(zzvs zzvsVar) {
        CopyOnWriteArrayList<zzvq> copyOnWriteArrayList = this.zzc;
        for (zzvq zzvqVar : copyOnWriteArrayList) {
            if (zzvqVar.zzb == zzvsVar) {
                copyOnWriteArrayList.remove(zzvqVar);
            }
        }
    }

    public zzvr() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
