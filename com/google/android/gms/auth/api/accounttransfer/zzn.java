package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends zzbz {
    public static final Parcelable.Creator<zzn> CREATOR = new zza(1);
    public static final HashMap zzc;
    public final HashSet zza;
    public final int zzb;
    public ArrayList zzd;
    public final int zze;
    public zzr zzf;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put("authenticatorData", new FastJsonResponse.Field(11, true, 11, true, "authenticatorData", 2, zzt.class));
        map.put("progress", new FastJsonResponse.Field(11, false, 11, false, "progress", 4, zzr.class));
    }

    public zzn(HashSet hashSet, int i, ArrayList arrayList, int i2, zzr zzrVar) {
        this.zza = hashSet;
        this.zzb = i;
        this.zzd = arrayList;
        this.zze = i2;
        this.zzf = zzrVar;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int i = field.zaf;
        if (i != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(i), arrayList.getClass().getCanonicalName()));
        }
        this.zzd = arrayList;
        this.zza.add(Integer.valueOf(i));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void addConcreteTypeInternal(FastJsonResponse.Field field, String str, FastJsonResponse fastJsonResponse) {
        int i = field.zaf;
        if (i != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(i), fastJsonResponse.getClass().getCanonicalName()));
        }
        this.zzf = (zzr) fastJsonResponse;
        this.zza.add(Integer.valueOf(i));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* bridge */ /* synthetic */ Map getFieldMappings() {
        return zzc;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        int i = field.zaf;
        if (i == 1) {
            return Integer.valueOf(this.zzb);
        }
        if (i == 2) {
            return this.zzd;
        }
        if (i == 4) {
            return this.zzf;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(field.zaf);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zza.contains(Integer.valueOf(field.zaf));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        HashSet hashSet = this.zza;
        if (hashSet.contains(1)) {
            CloseableKt.zzc(parcel, 1, 4);
            parcel.writeInt(this.zzb);
        }
        if (hashSet.contains(2)) {
            CloseableKt.writeTypedList(parcel, 2, this.zzd, true);
        }
        if (hashSet.contains(3)) {
            CloseableKt.zzc(parcel, 3, 4);
            parcel.writeInt(this.zze);
        }
        if (hashSet.contains(4)) {
            CloseableKt.writeParcelable(parcel, 4, this.zzf, i, true);
        }
        CloseableKt.zzb(parcel, iZza);
    }
}
