package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzfqr extends zzfqy {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    public /* synthetic */ zzfqr(String str, boolean z, int i, zzfqn zzfqnVar, zzfqo zzfqoVar, int i2, zzfqq zzfqqVar) {
        this.zzb = str;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfqy) {
            zzfqy zzfqyVar = (zzfqy) obj;
            if (this.zzb.equals(zzfqyVar.zzc())) {
                zzfqyVar.zzd();
                int i = this.zzc;
                int iZze = zzfqyVar.zze();
                if (i == 0) {
                    throw null;
                }
                if (i == iZze) {
                    zzfqyVar.zza();
                    zzfqyVar.zzb();
                    int i2 = this.zzd;
                    int iZzf = zzfqyVar.zzf();
                    if (i2 == 0) {
                        throw null;
                    }
                    if (iZzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        int i = this.zzc;
        if (i == 0) {
            throw null;
        }
        int i2 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i;
        if (this.zzd != 0) {
            return (i2 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        String str;
        int i = this.zzc;
        if (i == 1) {
            str = "ALL_CHECKS";
        } else if (i == 2) {
            str = "SKIP_COMPLIANCE_CHECK";
        } else if (i != 3) {
            str = i != 4 ? "null" : "NO_CHECKS";
        } else {
            str = "SKIP_SECURITY_CHECK";
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("FileComplianceOptions{fileOwner=", this.zzb, ", hasDifferentDmaOwner=false, fileChecks=", str, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose="), this.zzd == 1 ? "READ_AND_WRITE" : "null", "}");
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final zzfqn zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final zzfqo zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final int zzf() {
        return this.zzd;
    }
}
