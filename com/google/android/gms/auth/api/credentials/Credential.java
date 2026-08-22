package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza(6);
    public final String zba;
    public final String zbb;
    public final Uri zbc;
    public final List zbd;
    public final String zbe;
    public final String zbf;
    public final String zbg;
    public final String zbh;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zba, credential.zba) && TextUtils.equals(this.zbb, credential.zbb) && zzah.equal(this.zbc, credential.zbc) && TextUtils.equals(this.zbe, credential.zbe) && TextUtils.equals(this.zbf, credential.zbf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbe, this.zbf});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zba, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.writeParcelable(parcel, 3, this.zbc, i, false);
        CloseableKt.writeTypedList(parcel, 4, this.zbd, false);
        CloseableKt.writeString(parcel, 5, this.zbe, false);
        CloseableKt.writeString(parcel, 6, this.zbf, false);
        CloseableKt.writeString(parcel, 9, this.zbg, false);
        CloseableKt.writeString(parcel, 10, this.zbh, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public Credential(String str, String str2, Uri uri, ArrayList arrayList, String str3, String str4, String str5, String str6) {
        List listUnmodifiableList;
        Boolean boolValueOf;
        zzah.checkNotNull(str, "credential identifier cannot be null");
        String strTrim = str.trim();
        zzah.checkNotEmpty(strTrim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException(ZRqOdXiy.LYgtrhJlxC);
        }
        if (str4 != null) {
            if (TextUtils.isEmpty(str4)) {
                boolValueOf = Boolean.FALSE;
            } else {
                Uri uri2 = Uri.parse(str4);
                if (uri2.isAbsolute() && uri2.isHierarchical() && !TextUtils.isEmpty(uri2.getScheme()) && !TextUtils.isEmpty(uri2.getAuthority())) {
                    boolean z = true;
                    if (!"http".equalsIgnoreCase(uri2.getScheme()) && !"https".equalsIgnoreCase(uri2.getScheme())) {
                        z = false;
                    }
                    boolValueOf = Boolean.valueOf(z);
                } else {
                    boolValueOf = Boolean.FALSE;
                }
            }
            if (!boolValueOf.booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.zbb = str2;
        this.zbc = uri;
        if (arrayList == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        }
        this.zbd = listUnmodifiableList;
        this.zba = strTrim;
        this.zbe = str3;
        this.zbf = str4;
        this.zbg = str5;
        this.zbh = str6;
    }
}
