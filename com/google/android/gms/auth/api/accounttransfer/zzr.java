package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzbz;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends zzbz {
    public static final Parcelable.Creator<zzr> CREATOR = new zza(2);
    public static final ArrayMap zzb;
    public final int zza;
    public ArrayList zzc;
    public ArrayList zzd;
    public ArrayList zze;
    public ArrayList zzf;
    public ArrayList zzg;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzb = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.forStrings(2, "registered"));
        arrayMap.put("in_progress", FastJsonResponse.Field.forStrings(3, "in_progress"));
        arrayMap.put(FirebaseAnalytics.Param.SUCCESS, FastJsonResponse.Field.forStrings(4, FirebaseAnalytics.Param.SUCCESS));
        arrayMap.put("failed", FastJsonResponse.Field.forStrings(5, "failed"));
        arrayMap.put("escrowed", FastJsonResponse.Field.forStrings(6, "escrowed"));
    }

    public zzr(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        this.zza = i;
        this.zzc = arrayList;
        this.zzd = arrayList2;
        this.zze = arrayList3;
        this.zzf = arrayList4;
        this.zzg = arrayList5;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map getFieldMappings() {
        return zzb;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.zaf) {
            case 1:
                return Integer.valueOf(this.zza);
            case 2:
                return this.zzc;
            case 3:
                return this.zzd;
            case 4:
                return this.zze;
            case 5:
                return this.zzf;
            case 6:
                return this.zzg;
            default:
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(field.zaf);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringsInternal(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        int i = field.zaf;
        if (i == 2) {
            this.zzc = arrayList;
            return;
        }
        if (i == 3) {
            this.zzd = arrayList;
            return;
        }
        if (i == 4) {
            this.zze = arrayList;
        } else if (i == 5) {
            this.zzf = arrayList;
        } else {
            if (i != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(i)));
            }
            this.zzg = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.writeStringList(parcel, 2, this.zzc);
        CloseableKt.writeStringList(parcel, 3, this.zzd);
        CloseableKt.writeStringList(parcel, 4, this.zze);
        CloseableKt.writeStringList(parcel, 5, this.zzf);
        CloseableKt.writeStringList(parcel, 6, this.zzg);
        CloseableKt.zzb(parcel, iZza);
    }
}
