package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SaveAccountLinkingTokenResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenResult> CREATOR = new zza(18);
    public final PendingIntent zba;

    public SaveAccountLinkingTokenResult(PendingIntent pendingIntent) {
        this.zba = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SaveAccountLinkingTokenResult) {
            return zzah.equal(this.zba, ((SaveAccountLinkingTokenResult) obj).zba);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zba, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
