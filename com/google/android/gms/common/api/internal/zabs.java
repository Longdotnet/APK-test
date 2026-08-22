package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zabs {
    public final ApiKey zaa;
    public final Feature zab;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (zzah.equal(this.zaa, zabsVar.zaa) && zzah.equal(this.zab, zabsVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zaa, "key");
        zzzVar.add(this.zab, "feature");
        return zzzVar.toString();
    }
}
