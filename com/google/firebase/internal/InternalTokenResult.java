package com.google.firebase.internal;

import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class InternalTokenResult {
    private String zza;

    public InternalTokenResult(String str) {
        this.zza = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return zzah.equal(this.zza, ((InternalTokenResult) obj).zza);
        }
        return false;
    }

    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zza, "token");
        return zzzVar.toString();
    }
}
