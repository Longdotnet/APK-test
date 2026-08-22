package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zbh extends com.google.android.gms.internal.p000authapi.zbb implements zbr {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zbl zba;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zbh(zbl zblVar, int i) {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
        this.$r8$classId = i;
        this.zba = zblVar;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 101:
                throw new UnsupportedOperationException();
            case TOSS_OPEN_MASKED_SOLHWA_VALUE:
                zbc((Status) com.google.android.gms.internal.p000authapi.zbc.zba(parcel, Status.CREATOR));
                break;
            case TOSS_OPEN_BALANCED_VALUE:
                zbb((Status) com.google.android.gms.internal.p000authapi.zbc.zba(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zbr
    public void zbb(Status status) {
        switch (this.$r8$classId) {
            case 1:
                ((zbk) this.zba).setResult(status);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zbr
    public void zbc(Status status) {
        switch (this.$r8$classId) {
            case 0:
                ((zbi) this.zba).setResult(status);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
