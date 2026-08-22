package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzr implements AuthResult {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public zzx zza;
    public zzp zzb;
    public com.google.firebase.auth.zze zzc;

    public zzr(zzx zzxVar, zzp zzpVar, com.google.firebase.auth.zze zzeVar) {
        this.zza = zzxVar;
        this.zzb = zzpVar;
        this.zzc = zzeVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeParcelable(parcel, 3, this.zzc, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzr(zzx zzxVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzxVar);
        this.zza = zzxVar;
        List listZzo = zzxVar.zzo();
        this.zzb = null;
        for (int i = 0; i < listZzo.size(); i++) {
            if (!TextUtils.isEmpty(((zzt) listZzo.get(i)).zza())) {
                this.zzb = new zzp(((zzt) listZzo.get(i)).getProviderId(), ((zzt) listZzo.get(i)).zza(), zzxVar.zzs());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzp(zzxVar.zzs());
        }
        this.zzc = zzxVar.zzj();
    }
}
