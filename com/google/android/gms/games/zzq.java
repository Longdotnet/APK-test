package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends zzg implements PlayerRelationshipInfo {
    public final com.google.android.gms.games.internal.player.zzd zza;

    public zzq(DataHolder dataHolder, int i, com.google.android.gms.games.internal.player.zzd zzdVar) {
        super(dataHolder, i);
        this.zza = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return zzo.zze(this, obj);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final /* synthetic */ Object freeze() {
        return new zzo(this);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final int getFriendStatus() {
        return zzu(this.zza.zzH, -1);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        Parcelable.Creator<zzo> creator = zzo.CREATOR;
        return Arrays.hashCode(new Object[]{Integer.valueOf(getFriendStatus()), zza(), zzb(), zzc()});
    }

    public final String toString() {
        return zzo.zzf(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzp.zza(new zzo(this), parcel);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zza() {
        return zzj(this.zza.zzI, null);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzb() {
        return zzj(this.zza.zzJ, null);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzc() {
        return zzj(this.zza.zzK, null);
    }
}
