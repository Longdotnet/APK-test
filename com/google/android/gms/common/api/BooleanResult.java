package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public class BooleanResult implements Result {
    public final Status zaa;
    public final boolean zab;

    public BooleanResult(Status status, boolean z) {
        zzah.checkNotNull(status, "Status must not be null");
        this.zaa = status;
        this.zab = z;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zaa.equals(booleanResult.zaa) && this.zab == booleanResult.zab;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zaa;
    }

    public boolean getValue() {
        return this.zab;
    }

    public final int hashCode() {
        return ((this.zaa.hashCode() + 527) * 31) + (this.zab ? 1 : 0);
    }
}
