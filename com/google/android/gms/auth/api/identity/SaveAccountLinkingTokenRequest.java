package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new zza(17);
    public final PendingIntent zba;
    public final String zbb;
    public final String zbc;
    public final ArrayList zbd;
    public final String zbe;
    public final int zbf;

    public SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, ArrayList arrayList, String str3, int i) {
        this.zba = pendingIntent;
        this.zbb = str;
        this.zbc = str2;
        this.zbd = arrayList;
        this.zbe = str3;
        this.zbf = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        ArrayList arrayList = this.zbd;
        return arrayList.size() == saveAccountLinkingTokenRequest.zbd.size() && arrayList.containsAll(saveAccountLinkingTokenRequest.zbd) && zzah.equal(this.zba, saveAccountLinkingTokenRequest.zba) && zzah.equal(this.zbb, saveAccountLinkingTokenRequest.zbb) && zzah.equal(this.zbc, saveAccountLinkingTokenRequest.zbc) && zzah.equal(this.zbe, saveAccountLinkingTokenRequest.zbe) && this.zbf == saveAccountLinkingTokenRequest.zbf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbe});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zba, i, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.writeString(parcel, 3, this.zbc, false);
        CloseableKt.writeStringList(parcel, 4, this.zbd);
        CloseableKt.writeString(parcel, 5, this.zbe, false);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zbf);
        CloseableKt.zzb(parcel, iZza);
    }
}
