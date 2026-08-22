package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zza(8);
    public final int zba;
    public final boolean zbb;
    public final String[] zbc;
    public final CredentialPickerConfig zbd;
    public final CredentialPickerConfig zbe;
    public final boolean zbf;
    public final String zbg;
    public final String zbh;
    public final boolean zbi;

    public CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.zba = i;
        this.zbb = z;
        zzah.checkNotNull(strArr);
        this.zbc = strArr;
        this.zbd = credentialPickerConfig == null ? new CredentialPickerConfig(2, 1, false, true, false) : credentialPickerConfig;
        this.zbe = credentialPickerConfig2 == null ? new CredentialPickerConfig(2, 1, false, true, false) : credentialPickerConfig2;
        if (i < 3) {
            this.zbf = true;
            this.zbg = null;
            this.zbh = null;
        } else {
            this.zbf = z2;
            this.zbg = str;
            this.zbh = str2;
        }
        this.zbi = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zbb ? 1 : 0);
        CloseableKt.writeStringArray(parcel, 2, this.zbc, false);
        CloseableKt.writeParcelable(parcel, 3, this.zbd, i, false);
        CloseableKt.writeParcelable(parcel, 4, this.zbe, i, false);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zbf ? 1 : 0);
        CloseableKt.writeString(parcel, 6, this.zbg, false);
        CloseableKt.writeString(parcel, 7, this.zbh, false);
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(this.zbi ? 1 : 0);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zba);
        CloseableKt.zzb(parcel, iZza);
    }
}
