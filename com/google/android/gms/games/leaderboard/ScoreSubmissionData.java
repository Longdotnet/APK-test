package com.google.android.gms.games.leaderboard;

import android.database.CursorWindow;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;

/* JADX INFO: loaded from: classes.dex */
public final class ScoreSubmissionData {
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final SparseArray zzd = new SparseArray();

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long j, String str, String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        public String toString() {
            zzz zzzVar = new zzz(this);
            zzzVar.add(Long.valueOf(this.rawScore), "RawScore");
            zzzVar.add(this.formattedScore, "FormattedScore");
            zzzVar.add(this.scoreTag, "ScoreTag");
            zzzVar.add(Boolean.valueOf(this.newBest), "NewBest");
            return zzzVar.toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzc = dataHolder.zai;
        int i = dataHolder.zad;
        zzah.checkArgument(i == 3);
        int i2 = 0;
        while (i2 < i) {
            int windowIndex = dataHolder.getWindowIndex(i2);
            if (i2 == 0) {
                this.zza = dataHolder.getString(0, windowIndex, "leaderboardId");
                this.zzb = dataHolder.getString(0, windowIndex, "playerId");
                i2 = 0;
            }
            if (dataHolder.getBoolean(i2, windowIndex, "hasResult")) {
                dataHolder.zae(i2, "rawScore");
                CursorWindow[] cursorWindowArr = dataHolder.zah;
                Result result = new Result(cursorWindowArr[windowIndex].getLong(i2, dataHolder.zab.getInt("rawScore")), dataHolder.getString(i2, windowIndex, "formattedScore"), dataHolder.getString(i2, windowIndex, "scoreTag"), dataHolder.getBoolean(i2, windowIndex, "newBest"));
                SparseArray sparseArray = this.zzd;
                dataHolder.zae(i2, "timeSpan");
                sparseArray.put(cursorWindowArr[windowIndex].getInt(i2, dataHolder.zab.getInt("timeSpan")), result);
            }
            i2++;
        }
    }

    public String getLeaderboardId() {
        return this.zza;
    }

    public String getPlayerId() {
        return this.zzb;
    }

    public Result getScoreResult(int i) {
        return (Result) this.zzd.get(i);
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zzb, "PlayerId");
        zzzVar.add(Integer.valueOf(this.zzc), "StatusCode");
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzd.get(i);
            zzzVar.add(com.google.android.gms.internal.games_v2.zzz.zza(i), "TimesSpan");
            zzzVar.add(result == null ? "null" : result.toString(), "Result");
        }
        return zzzVar.toString();
    }
}
