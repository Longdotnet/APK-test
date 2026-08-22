package com.google.android.gms.internal.ads;

import android.app.Activity;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes2.dex */
final class zzebr extends zzecn {
    private final Activity zza;
    private final com.google.android.gms.ads.internal.overlay.zzm zzb;
    private final String zzc;
    private final String zzd;

    public /* synthetic */ zzebr(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, String str, String str2, zzebq zzebqVar) {
        this.zza = activity;
        this.zzb = zzmVar;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzecn) {
            zzecn zzecnVar = (zzecn) obj;
            if (this.zza.equals(zzecnVar.zza()) && ((zzmVar = this.zzb) != null ? zzmVar.equals(zzecnVar.zzb()) : zzecnVar.zzb() == null) && ((str = this.zzc) != null ? str.equals(zzecnVar.zzc()) : zzecnVar.zzc() == null) && ((str2 = this.zzd) != null ? str2.equals(zzecnVar.zzd()) : zzecnVar.zzd() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzb;
        int iHashCode2 = ((iHashCode * 1000003) ^ (zzmVar == null ? 0 : zzmVar.hashCode())) * 1000003;
        String str = this.zzc;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzd;
        return iHashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final Activity zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final com.google.android.gms.ads.internal.overlay.zzm zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzecn
    public final String zzd() {
        return this.zzd;
    }

    public final String toString() {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("OfflineUtilsParams{activity=", this.zza.toString(), ", adOverlay=", String.valueOf(this.zzb), ", gwsQueryId=");
        sbM22m.append(this.zzc);
        sbM22m.append(", uri=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM22m, this.zzd, bUqMCsuPSX.lfe);
    }
}
