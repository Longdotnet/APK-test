package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzahi extends zzahf {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzahi(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahi.class == obj.getClass()) {
            zzahi zzahiVar = (zzahi) obj;
            if (this.zza == zzahiVar.zza && this.zzb == zzahiVar.zzb && this.zzc == zzahiVar.zzc && Arrays.equals(this.zzd, zzahiVar.zzd) && Arrays.equals(this.zze, zzahiVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza + 527;
        int[] iArr = this.zzd;
        int iHashCode = Arrays.hashCode(iArr) + (((((i * 31) + this.zzb) * 31) + this.zzc) * 31);
        return Arrays.hashCode(this.zze) + (iHashCode * 31);
    }
}
