package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    public String zza;
    public String zzb;
    public List zzc;

    public zzag() {
    }

    public static zzag zza(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzag zzagVar = new zzag();
        zzagVar.zza = str;
        return zzagVar;
    }

    public static zzag zzb(List list, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(list);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzag zzagVar = new zzag();
        zzagVar.zzc = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzagVar.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            }
        }
        zzagVar.zzb = str;
        return zzagVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeTypedList(parcel, 3, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zza != null;
    }

    public zzag(String str, String str2, List list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
    }
}
