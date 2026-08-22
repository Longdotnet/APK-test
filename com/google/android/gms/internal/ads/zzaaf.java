package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class zzaaf {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzaab
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((zzaad) obj).zza - ((zzaad) obj2).zza;
        }
    };
    private static final Comparator zzb = new Comparator() { // from class: com.google.android.gms.internal.ads.zzaac
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((zzaad) obj).zzc, ((zzaad) obj2).zzc);
        }
    };
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzaad[] zzd = new zzaad[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzaaf(int i) {
    }

    public final float zza(float f) {
        int i = 0;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = this.zzg;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.zzc;
            if (i >= arrayList.size()) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((zzaad) arrayList.get(arrayList.size() - 1)).zzc;
            }
            float f3 = 0.5f * f2;
            zzaad zzaadVar = (zzaad) arrayList.get(i);
            i2 += zzaadVar.zzb;
            if (i2 >= f3) {
                return zzaadVar.zzc;
            }
            i++;
        }
    }

    public final void zzb(int i, float f) {
        zzaad zzaadVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzaad[] zzaadVarArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzaadVar = zzaadVarArr[i3];
        } else {
            zzaadVar = new zzaad(null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzaadVar.zza = i4;
        zzaadVar.zzb = i;
        zzaadVar.zzc = f;
        ArrayList arrayList = this.zzc;
        arrayList.add(zzaadVar);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            zzaad zzaadVar2 = (zzaad) arrayList.get(0);
            int i7 = zzaadVar2.zzb;
            if (i7 <= i6) {
                this.zzg -= i7;
                arrayList.remove(0);
                int i8 = this.zzh;
                if (i8 < 5) {
                    zzaad[] zzaadVarArr2 = this.zzd;
                    this.zzh = i8 + 1;
                    zzaadVarArr2[i8] = zzaadVar2;
                }
            } else {
                zzaadVar2.zzb = i7 - i6;
                this.zzg -= i6;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
