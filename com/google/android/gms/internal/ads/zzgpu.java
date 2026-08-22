package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgpu extends zzgqo {
    private final int zza;
    private final int zzb;
    private final zzgps zzc;

    public /* synthetic */ zzgpu(int i, int i2, zzgps zzgpsVar, zzgpt zzgptVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgpsVar;
    }

    public static zzgpr zze() {
        return new zzgpr(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpu)) {
            return false;
        }
        zzgpu zzgpuVar = (zzgpu) obj;
        return zzgpuVar.zza == this.zza && zzgpuVar.zzd() == zzd() && zzgpuVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzgpu.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzc != zzgps.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgps zzgpsVar = this.zzc;
        if (zzgpsVar == zzgps.zzd) {
            return this.zzb;
        }
        if (zzgpsVar == zzgps.zza || zzgpsVar == zzgps.zzb || zzgpsVar == zzgps.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgps zzf() {
        return this.zzc;
    }

    public final String toString() {
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("AES-CMAC Parameters (variant: ", String.valueOf(this.zzc), ", ");
        sbM21m.append(this.zzb);
        sbM21m.append(MnHfHMYQDPUO.xtIsJApneknKoou);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM21m, this.zza, "-byte key)");
    }
}
