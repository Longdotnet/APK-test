package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzfsv extends zzfty {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    public /* synthetic */ zzfsv(IBinder iBinder, String str, int i, float f, int i2, int i3, String str2, int i4, String str3, String str4, String str5, zzfsu zzfsuVar) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i4;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfty) {
            zzfty zzftyVar = (zzfty) obj;
            if (this.zza.equals(zzftyVar.zzf()) && ((str = this.zzb) != null ? str.equals(zzftyVar.zzh()) : zzftyVar.zzh() == null) && this.zzc == zzftyVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzftyVar.zza())) {
                zzftyVar.zzb();
                zzftyVar.zzd();
                zzftyVar.zzj();
                if (this.zze == zzftyVar.zze()) {
                    zzftyVar.zzi();
                    String str2 = this.zzf;
                    if (str2 != null ? str2.equals(zzftyVar.zzg()) : zzftyVar.zzg() == null) {
                        zzftyVar.zzk();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int iHashCode2 = (((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i = this.zze;
        String str2 = this.zzf;
        return ((((iHashCode2 * 1525764945) ^ i) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("OverlayDisplayShowRequest{windowToken=", this.zza.toString(), ", appId=");
        sbM21m.append(this.zzb);
        sbM21m.append(", layoutGravity=");
        sbM21m.append(this.zzc);
        sbM21m.append(", layoutVerticalMargin=");
        sbM21m.append(this.zzd);
        sbM21m.append(", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=");
        sbM21m.append(this.zze);
        sbM21m.append(", deeplinkUrl=null, adFieldEnifd=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM21m, this.zzf, ", thirdPartyAuthCallerId=null}");
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final float zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final int zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final IBinder zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfty
    public final String zzk() {
        return null;
    }
}
