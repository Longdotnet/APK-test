package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzfyu extends zzfyj {
    Object[] zzd;
    private int zze;

    public zzfyu() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfyj, com.google.android.gms.internal.ads.zzfyk
    public final /* bridge */ /* synthetic */ zzfyk zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfyu zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzh = zzfyv.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzh <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzfyi.zza(iHashCode);
                while (true) {
                    int i = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        zza(obj);
        return this;
    }

    public final zzfyu zzg(Object... objArr) {
        if (this.zzd != null) {
            for (int i = 0; i < 2; i++) {
                zzf(objArr[i]);
            }
        } else {
            zzd(objArr, 2);
        }
        return this;
    }

    public final zzfyu zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            zzc(iterable);
        }
        return this;
    }

    public final zzfyv zzi() {
        zzfyv zzfyvVarZzv;
        int i = this.zzb;
        if (i == 0) {
            return zzgai.zza;
        }
        if (i == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzgat(obj);
        }
        if (this.zzd == null || zzfyv.zzh(i) != this.zzd.length) {
            zzfyvVarZzv = zzfyv.zzv(this.zzb, this.zza);
            this.zzb = zzfyvVarZzv.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzfyv.zzw(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            int i3 = this.zze;
            Object[] objArr = this.zzd;
            zzfyvVarZzv = new zzgai(objArrCopyOf, i3, objArr, objArr.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzfyvVarZzv;
    }

    public zzfyu(int i, boolean z) {
        super(i);
        this.zzd = new Object[zzfyv.zzh(i)];
    }
}
