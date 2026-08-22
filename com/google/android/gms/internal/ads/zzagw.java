package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzagw extends zzahf {
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    public zzagw(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagw.class == obj.getClass()) {
            zzagw zzagwVar = (zzagw) obj;
            if (this.zzc == zzagwVar.zzc && Objects.equals(this.zza, zzagwVar.zza) && Objects.equals(this.zzb, zzagwVar.zzb) && Arrays.equals(this.zzd, zzagwVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str != null ? str.hashCode() : 0;
        int i = this.zzc;
        String str2 = this.zzb;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = ((i + 527) * 31) + iHashCode;
        return Arrays.hashCode(this.zzd) + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, 31, iHashCode2, 31);
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", description=" + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzahf, com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        zzarVar.zza(this.zzd, this.zzc);
    }
}
