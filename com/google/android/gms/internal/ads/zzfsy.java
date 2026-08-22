package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzfsy extends zzfua {
    private final int zza;
    private final String zzb;

    public /* synthetic */ zzfsy(int i, String str, zzfsx zzfsxVar) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfua) {
            zzfua zzfuaVar = (zzfua) obj;
            if (this.zza == zzfuaVar.zza() && ((str = this.zzb) != null ? str.equals(zzfuaVar.zzb()) : zzfuaVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OverlayDisplayState{statusCode=");
        sb.append(this.zza);
        sb.append(", sessionToken=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.zzb, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final String zzb() {
        return this.zzb;
    }
}
