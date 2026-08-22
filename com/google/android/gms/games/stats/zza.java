package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator {
    public static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel) {
        int iZza = CloseableKt.zza(parcel, 20293);
        float averageSessionLength = playerStatsEntity.getAverageSessionLength();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeFloat(averageSessionLength);
        float churnProbability = playerStatsEntity.getChurnProbability();
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeFloat(churnProbability);
        int daysSinceLastPlayed = playerStatsEntity.getDaysSinceLastPlayed();
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(daysSinceLastPlayed);
        int numberOfPurchases = playerStatsEntity.getNumberOfPurchases();
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(numberOfPurchases);
        int numberOfSessions = playerStatsEntity.getNumberOfSessions();
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(numberOfSessions);
        float sessionPercentile = playerStatsEntity.getSessionPercentile();
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeFloat(sessionPercentile);
        float spendPercentile = playerStatsEntity.getSpendPercentile();
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeFloat(spendPercentile);
        CloseableKt.writeBundle(parcel, 8, playerStatsEntity.zza(), false);
        float spendProbability = playerStatsEntity.getSpendProbability();
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeFloat(spendProbability);
        float highSpenderProbability = playerStatsEntity.getHighSpenderProbability();
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeFloat(highSpenderProbability);
        float totalSpendNext28Days = playerStatsEntity.getTotalSpendNext28Days();
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeFloat(totalSpendNext28Days);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        Bundle bundleCreateBundle = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i4 = parcel.readInt();
            switch ((char) i4) {
                case 1:
                    f = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case 2:
                    f2 = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case 3:
                    i = Protocol.Companion.readInt(parcel, i4);
                    break;
                case 4:
                    i2 = Protocol.Companion.readInt(parcel, i4);
                    break;
                case 5:
                    i3 = Protocol.Companion.readInt(parcel, i4);
                    break;
                case 6:
                    f3 = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case 7:
                    f4 = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case '\b':
                    bundleCreateBundle = Protocol.Companion.createBundle(parcel, i4);
                    break;
                case '\t':
                    f5 = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case '\n':
                    f6 = Protocol.Companion.readFloat(parcel, i4);
                    break;
                case 11:
                    f7 = Protocol.Companion.readFloat(parcel, i4);
                    break;
                default:
                    Protocol.Companion.skipUnknownField(parcel, i4);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PlayerStatsEntity(f, f2, i, i2, i3, f3, f4, bundleCreateBundle, f5, f6, f7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayerStatsEntity[i];
    }
}
