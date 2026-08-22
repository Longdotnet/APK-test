package com.google.android.gms.internal.measurement;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzhc extends zzhz {
    private final Context zza;
    private final zzii zzb;

    public zzhc(Context context, zzii zziiVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = zziiVar;
    }

    public final boolean equals(Object obj) {
        zzii zziiVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhz) {
            zzhz zzhzVar = (zzhz) obj;
            if (this.zza.equals(zzhzVar.zza()) && ((zziiVar = this.zzb) != null ? zziiVar.equals(zzhzVar.zzb()) : zzhzVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzii zziiVar = this.zzb;
        return iHashCode ^ (zziiVar == null ? 0 : zziiVar.hashCode());
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("FlagsContext{context=", this.zza.toString(), ", hermeticFileOverrides=", String.valueOf(this.zzb), "}");
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final zzii zzb() {
        return this.zzb;
    }
}
