package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zza(9);
    public final int zba;
    public final CredentialPickerConfig zbb;
    public final boolean zbc;
    public final boolean zbd;
    public final String[] zbe;
    public final boolean zbf;
    public final String zbg;
    public final String zbh;

    public HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.zba = i;
        zzah.checkNotNull(credentialPickerConfig);
        this.zbb = credentialPickerConfig;
        this.zbc = z;
        this.zbd = z2;
        zzah.checkNotNull(strArr);
        this.zbe = strArr;
        if (i < 2) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
        } else {
            this.zbf = z3;
            this.zbg = str;
            this.zbh = str2;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zbb, i, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zbc ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zbd ? 1 : 0);
        CloseableKt.writeStringArray(parcel, 4, this.zbe, false);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zbf ? 1 : 0);
        CloseableKt.writeString(parcel, 6, this.zbg, false);
        CloseableKt.writeString(parcel, 7, this.zbh, false);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zba);
        CloseableKt.zzb(parcel, iZza);
    }
}
