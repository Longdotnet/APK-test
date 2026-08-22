package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator {
    public static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, mostRecentGameInfoEntity.zza(), false);
        CloseableKt.writeString(parcel, 2, mostRecentGameInfoEntity.zzb(), false);
        long jZzc = mostRecentGameInfoEntity.zzc();
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(jZzc);
        CloseableKt.writeParcelable(parcel, 4, mostRecentGameInfoEntity.zzd(), i, false);
        CloseableKt.writeParcelable(parcel, 5, mostRecentGameInfoEntity.zze(), i, false);
        CloseableKt.writeParcelable(parcel, 6, mostRecentGameInfoEntity.zzf(), i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strCreateString = Protocol.Companion.createString(parcel, i);
                    break;
                case 2:
                    strCreateString2 = Protocol.Companion.createString(parcel, i);
                    break;
                case 3:
                    j = Protocol.Companion.readLong(parcel, i);
                    break;
                case 4:
                    uri = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
                    break;
                case 6:
                    uri3 = (Uri) Protocol.Companion.createParcelable(parcel, i, Uri.CREATOR);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new MostRecentGameInfoEntity(strCreateString, strCreateString2, j, uri, uri2, uri3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
