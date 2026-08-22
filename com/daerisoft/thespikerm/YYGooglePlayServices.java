package com.daerisoft.thespikerm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.InputMergerFactory$1;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.PlayGamesSdk;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.GetTokenResult;
import com.yoyogames.runner.RunnerJNILib;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class YYGooglePlayServices extends RunnerSocial {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static final int RC_ACHIEVEMENT_UI = 9003;
    public static final int RC_LEADERBOARD_UI = 9004;
    public static final int RC_SAVED_GAMES = 9009;
    public static Activity activity = RunnerActivity.CurrentActivity;
    public int AsyncInd = 0;
    public double ind_ShowSavedGamesUI;
    public HashMap<String, Snapshot> mapSnapshot;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYGooglePlayServices$1 */
    public final class AnonymousClass1 implements OnCompleteListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ double val$ind;

        public /* synthetic */ AnonymousClass1(int i, double d) {
            this.$r8$classId = i;
            this.val$ind = d;
        }

        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v30, types: [double[], java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r1v32 */
        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            ?? r1;
            switch (this.$r8$classId) {
                case 0:
                    double d = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SignIn");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
                        if (task.isSuccessful()) {
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "isAuthenticated", ((AuthenticationResult) task.getResult()).isAuthenticated() ? 1.0d : 0.0d);
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                    } catch (Exception unused) {
                        int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SignIn");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                        return;
                    }
                    break;
                case 1:
                    int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "FirebaseAuthentication_SendEmailVerification");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap3, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap3, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
                    break;
                case 2:
                    int iJCreateDsMap4 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap4, "type", "FirebaseAuthentication_DeleteAccount");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap4, "listener", this.val$ind);
                    boolean zIsSuccessful = task.isSuccessful();
                    String str = JrbhsraGtto.aNqx;
                    if (zIsSuccessful) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap4, str, 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap4, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap4, str, 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap4, 70);
                    break;
                case 3:
                    int iJCreateDsMap5 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap5, "type", "FirebaseAuthentication_RefreshUserData");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap5, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap5, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap5, 70);
                    break;
                case 4:
                    int iJCreateDsMap6 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap6, "type", "FirebaseAuthentication_GetIdToken");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap6, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap6, FirebaseAnalytics.Param.VALUE, ((GetTokenResult) task.getResult()).getToken());
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap6, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap6, FirebaseAnalytics.Param.VALUE, "null");
                        RunnerJNILib.DsMapAddString(iJCreateDsMap6, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap6, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap6, 70);
                    break;
                case 5:
                    int iJCreateDsMap7 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap7, "type", "FirebaseAuthentication_SendPasswordResetEmail");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap7, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap7, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap7, 70);
                    break;
                case 6:
                    int iJCreateDsMap8 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap8, "type", "FirebaseAuthentication_ChangeEmail");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap8, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap8, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap8, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap8, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap8, 70);
                    break;
                case 7:
                    int iJCreateDsMap9 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap9, "type", "FirebaseAuthentication_ChangePassword");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap9, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap9, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap9, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap9, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap9, 70);
                    break;
                case 8:
                    int iJCreateDsMap10 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap10, "type", "FirebaseAuthentication_ChangeDisplayName");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap10, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap10, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap10, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap10, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap10, 70);
                    break;
                case 9:
                    int iJCreateDsMap11 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap11, "type", "FirebaseAuthentication_ChangePhotoURL");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap11, "listener", this.val$ind);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap11, "status", 200.0d);
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap11, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap11, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap11, 70);
                    break;
                case 10:
                    double d2 = this.val$ind;
                    try {
                        task.getResult();
                        AchievementBuffer achievementBuffer = (AchievementBuffer) ((AnnotatedData) task.getResult()).get();
                        try {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<Object> it = achievementBuffer.iterator();
                            while (it.hasNext()) {
                                Achievement achievement = (Achievement) it.next();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("id", achievement.getAchievementId());
                                jSONObject.put("description", achievement.getDescription());
                                Iterator<Object> it2 = it;
                                jSONObject.put("lastUpdatedTimestamp", achievement.getLastUpdatedTimestamp());
                                jSONObject.put("name", achievement.getName());
                                if (achievement.getRevealedImageUri() != null) {
                                    jSONObject.put("revealedImage", achievement.getRevealedImageUri().toString());
                                }
                                jSONObject.put("state", achievement.getState());
                                jSONObject.put("typeAchievement", achievement.getType());
                                if (achievement.getUnlockedImageUri() != null) {
                                    jSONObject.put("unlockedImage", achievement.getUnlockedImageUri().toString());
                                }
                                jSONObject.put("xpValue", achievement.getXpValue());
                                if (achievement.getType() == 1) {
                                    jSONObject.put("currentSteps", achievement.getCurrentSteps());
                                    jSONObject.put(FKidOcdAYt.RmGyVPkiovkarV, achievement.getFormattedCurrentSteps());
                                    jSONObject.put("formattedTotalSteps", achievement.getFormattedTotalSteps());
                                    jSONObject.put("totalSteps", achievement.getTotalSteps());
                                }
                                jSONArray.put(jSONObject);
                                it = it2;
                            }
                            try {
                                int iJCreateDsMap12 = RunnerJNILib.jCreateDsMap(null, null, null);
                                RunnerJNILib.DsMapAddDouble(iJCreateDsMap12, "ind", d2);
                                RunnerJNILib.DsMapAddString(iJCreateDsMap12, "type", "GooglePlayServices_Achievements_GetStatus");
                                RunnerJNILib.DsMapAddDouble(iJCreateDsMap12, FirebaseAnalytics.Param.SUCCESS, task.isSuccessful() ? 1.0d : 0.0d);
                                RunnerJNILib.DsMapAddString(iJCreateDsMap12, FETmZwrVHuasmL.JvzRTZQSrLEYk, jSONArray.toString());
                                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap12, 70);
                            } catch (Exception unused2) {
                                r1 = 0;
                                int iJCreateDsMap13 = RunnerJNILib.jCreateDsMap(r1, r1, r1);
                                RunnerJNILib.DsMapAddDouble(iJCreateDsMap13, "ind", d2);
                                RunnerJNILib.DsMapAddString(iJCreateDsMap13, "type", "GooglePlayServices_Achievements_GetStatus");
                                RunnerJNILib.DsMapAddDouble(iJCreateDsMap13, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap13, 70);
                                return;
                            }
                        } catch (Exception unused3) {
                            r1 = 0;
                        }
                    } catch (Exception unused4) {
                        int iJCreateDsMap14 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap14, "type", "GooglePlayServices_Achievements_GetStatus");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap14, "ind", d2);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap14, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap14, 70);
                        return;
                    }
                    break;
                case 11:
                    double d3 = this.val$ind;
                    try {
                        task.getResult();
                        boolean zIsSuccessful2 = task.isSuccessful();
                        int iJCreateDsMap15 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap15, "type", "GooglePlayServices_SavedGames_DiscardAndClose");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap15, "ind", d3);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap15, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful2 ? 1.0d : 0.0d);
                        if (!zIsSuccessful2) {
                            Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_DiscardAndClose : failed to discard and close the saved game - " + task.getException().getMessage());
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap15, 70);
                    } catch (Exception unused5) {
                        int iJCreateDsMap16 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap16, "type", "GooglePlayServices_SavedGames_DiscardAndClose");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap16, "ind", d3);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap16, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap16, 70);
                        return;
                    }
                    break;
                case 12:
                    double d4 = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap17 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap17, "type", "GooglePlayServices_IsAuthenticated");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap17, "ind", d4);
                        if (task.isSuccessful()) {
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap17, "isAuthenticated", ((AuthenticationResult) task.getResult()).isAuthenticated() ? 1.0d : 0.0d);
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap17, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap17, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap17, 70);
                    } catch (Exception unused6) {
                        int iJCreateDsMap18 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap18, "type", "GooglePlayServices_IsAuthenticated");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap18, "ind", d4);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap18, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap18, 70);
                        return;
                    }
                    break;
                case 13:
                    double d5 = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap19 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap19, "type", "GooglePlayServices_RequestServerSideAccess");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap19, "ind", d5);
                        if (task.isSuccessful()) {
                            RunnerJNILib.DsMapAddString(iJCreateDsMap19, "authCode", (String) task.getResult());
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap19, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap19, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap19, 70);
                    } catch (Exception unused7) {
                        int iJCreateDsMap20 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap20, "type", "GooglePlayServices_RequestServerSideAccess");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap20, "ind", d5);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap20, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap20, 70);
                        return;
                    }
                    break;
                default:
                    double d6 = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap21 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap21, "type", "GooglePlayServices_Player_Current");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap21, "ind", d6);
                        if (task.isSuccessful()) {
                            RunnerJNILib.DsMapAddString(iJCreateDsMap21, "player", YYGooglePlayServices.PlayerJSON((Player) task.getResult()).toString());
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap21, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap21, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap21, 70);
                    } catch (Exception unused8) {
                        int iJCreateDsMap22 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap22, "type", "GooglePlayServices_Player_Current");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap22, "ind", d6);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap22, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap22, 70);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYGooglePlayServices$14 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass14 implements OnCompleteListener {
        public final /* synthetic */ double val$ind;
        public final /* synthetic */ String val$leader_id;
        public final /* synthetic */ double val$score;
        public final /* synthetic */ String val$scoreTag;

        public AnonymousClass14() {
            d = d;
            str = str;
            d = d;
            str = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            double d = d;
            try {
                task.getResult();
                int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_Leaderboard_SubmitScore");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "leaderboardId", str);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SCORE, d);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "scoreTag", str);
                if (task.isSuccessful()) {
                    task.getResult();
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                    ScoreSubmissionData scoreSubmissionData = (ScoreSubmissionData) task.getResult();
                    HashMap map = new HashMap();
                    ScoreSubmissionData.Result scoreResult = scoreSubmissionData.getScoreResult(0);
                    if (scoreResult != null) {
                        HashMap map2 = new HashMap();
                        map2.put("isNewBest", Double.valueOf(scoreResult.newBest ? 1.0d : 0.0d));
                        map2.put(FirebaseAnalytics.Param.SCORE, Double.valueOf(scoreResult.rawScore));
                        map2.put("scoreTag", scoreResult.scoreTag);
                        map.put("daily", map2);
                    }
                    if (scoreSubmissionData.getScoreResult(1) != null) {
                        HashMap map3 = new HashMap();
                        map3.put("isNewBest", Double.valueOf(scoreResult.newBest ? 1.0d : 0.0d));
                        map3.put(FirebaseAnalytics.Param.SCORE, Double.valueOf(scoreResult.rawScore));
                        map3.put("scoreTag", scoreResult.scoreTag);
                        map.put("weekly", map3);
                    }
                    if (scoreSubmissionData.getScoreResult(2) != null) {
                        HashMap map4 = new HashMap();
                        map4.put("isNewBest", Double.valueOf(scoreResult.newBest ? 1.0d : 0.0d));
                        map4.put(FirebaseAnalytics.Param.SCORE, Double.valueOf(scoreResult.rawScore));
                        map4.put("scoreTag", scoreResult.scoreTag);
                        map.put("allTime", map4);
                    }
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "report", new JSONObject((Map) map).toString());
                } else {
                    task.getException();
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                }
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
            } catch (Exception unused) {
                int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_Leaderboard_SubmitScore");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
            }
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYGooglePlayServices$15 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass15 implements OnCompleteListener {
        public final /* synthetic */ double val$ind;

        public AnonymousClass15() {
            d = d;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            double d = d;
            try {
                task.getResult();
                try {
                    LeaderboardsClient.LeaderboardScores leaderboardScores = (LeaderboardsClient.LeaderboardScores) ((AnnotatedData) task.getResult()).get();
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Object> it = leaderboardScores.getScores().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(YYGooglePlayServices.LeaderboardScoreJSON((LeaderboardScore) it.next()));
                    }
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_Leaderboard_LoadPlayerCenteredScores");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, task.isSuccessful() ? 1.0d : 0.0d);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "leaderboard", YYGooglePlayServices.LeaderboardJSON(leaderboardScores.getLeaderboard()));
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "data", jSONArray.toString());
                    }
                    leaderboardScores.release();
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                } catch (Exception unused) {
                    int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_Leaderboard_LoadPlayerCenteredScores");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                }
            } catch (Exception unused2) {
                int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "GooglePlayServices_Leaderboard_LoadPlayerCenteredScores");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "ind", d);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
            }
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYGooglePlayServices$16 */
    public final class AnonymousClass16 implements OnCompleteListener {
        public final /* synthetic */ double val$ind;

        public AnonymousClass16() {
            d = d;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            double d = d;
            String str = FETmZwrVHuasmL.gqZScJISnK;
            try {
                task.getResult();
                try {
                    LeaderboardsClient.LeaderboardScores leaderboardScores = (LeaderboardsClient.LeaderboardScores) ((AnnotatedData) task.getResult()).get();
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Object> it = leaderboardScores.getScores().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(YYGooglePlayServices.LeaderboardScoreJSON((LeaderboardScore) it.next()));
                    }
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, str, "GooglePlayServices_Leaderboard_LoadTopScores");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, task.isSuccessful() ? 1.0d : 0.0d);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "leaderboard", YYGooglePlayServices.LeaderboardJSON(leaderboardScores.getLeaderboard()));
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "data", jSONArray.toString());
                    }
                    leaderboardScores.release();
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                } catch (Exception unused) {
                    int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap2, str, "GooglePlayServices_Leaderboard_LoadTopScores");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                }
            } catch (Exception unused2) {
                int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap3, str, "GooglePlayServices_Leaderboard_LoadTopScores");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "ind", d);
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
            }
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYGooglePlayServices$7 */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass7 implements OnCompleteListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ String val$arch_id;
        public final /* synthetic */ double val$ind;

        public /* synthetic */ AnonymousClass7(int i, String str, double d) {
            this.$r8$classId = i;
            this.val$ind = d;
            this.val$arch_id = str;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            switch (this.$r8$classId) {
                case 0:
                    double d = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_Achievements_Increment");
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, FirebaseAnalytics.Param.ACHIEVEMENT_ID, this.val$arch_id);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
                        if (task.isSuccessful()) {
                            task.getResult();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                    } catch (Exception unused) {
                        int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_Achievements_Increment");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                        return;
                    }
                    break;
                case 1:
                    double d2 = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "GooglePlayServices_Achievements_Unlock");
                        RunnerJNILib.DsMapAddString(iJCreateDsMap3, FirebaseAnalytics.Param.ACHIEVEMENT_ID, this.val$arch_id);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "ind", d2);
                        if (task.isSuccessful()) {
                            task.getResult();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
                    } catch (Exception unused2) {
                        int iJCreateDsMap4 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap4, "type", "GooglePlayServices_Achievements_Unlock");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap4, "ind", d2);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap4, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap4, 70);
                        return;
                    }
                    break;
                case 2:
                    double d3 = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap5 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap5, "type", "GooglePlayServices_Achievements_Reveal");
                        RunnerJNILib.DsMapAddString(iJCreateDsMap5, FirebaseAnalytics.Param.ACHIEVEMENT_ID, this.val$arch_id);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, "ind", d3);
                        if (task.isSuccessful()) {
                            task.getResult();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap5, 70);
                    } catch (Exception unused3) {
                        int iJCreateDsMap6 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap6, "type", "GooglePlayServices_Achievements_Reveal");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap6, "ind", d3);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap6, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap6, 70);
                        return;
                    }
                    break;
                default:
                    double d4 = this.val$ind;
                    try {
                        task.getResult();
                        int iJCreateDsMap7 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap7, "type", "GooglePlayServices_Achievements_SetSteps");
                        RunnerJNILib.DsMapAddString(iJCreateDsMap7, FirebaseAnalytics.Param.ACHIEVEMENT_ID, this.val$arch_id);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, "ind", d4);
                        if (task.isSuccessful()) {
                            task.getResult();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        } else {
                            task.getException();
                            RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        }
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap7, 70);
                    } catch (Exception unused4) {
                        int iJCreateDsMap8 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap8, "type", "GooglePlayServices_Achievements_SetSteps");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap8, "ind", d4);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap8, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap8, 70);
                    }
                    break;
            }
        }
    }

    public YYGooglePlayServices() {
        PlayGamesSdk.initialize(activity);
        this.mapSnapshot = new HashMap<>();
    }

    public static JSONObject GameJSON(Game game) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("areSnapshotsEnabled", game.areSnapshotsEnabled() ? 1.0d : 0.0d);
            jSONObject.put("achievementTotalCount", game.getAchievementTotalCount());
            jSONObject.put("applicationId", game.getApplicationId());
            jSONObject.put("description", game.getDescription());
            jSONObject.put("developerName", game.getDeveloperName());
            String displayName = game.getDisplayName();
            if (displayName != null) {
                jSONObject.put("displayName", displayName);
            }
            Uri featuredImageUri = game.getFeaturedImageUri();
            if (featuredImageUri != null) {
                jSONObject.put("featuredImageUri", featuredImageUri.toString());
            }
            jSONObject.put("gamepadSupport", game.hasGamepadSupport() ? 1.0d : 0.0d);
            Uri hiResImageUri = game.getHiResImageUri();
            if (hiResImageUri != null) {
                jSONObject.put("hiResImageUri", hiResImageUri.toString());
            }
            Uri iconImageUri = game.getIconImageUri();
            if (iconImageUri != null) {
                jSONObject.put("iconImageUri", iconImageUri.toString());
            }
            jSONObject.put("leaderboardCount", game.getLeaderboardCount());
            jSONObject.put("primaryCategory", game.getPrimaryCategory());
            jSONObject.put("secondaryCategory", game.getSecondaryCategory());
            jSONObject.put("themeColor", game.getThemeColor());
        } catch (Exception e) {
            Log.e(GooglePlayBillingService.TAG, "GameJSON : failed to create Game json object - " + e.getMessage());
        }
        return jSONObject;
    }

    public static String LeaderboardJSON(Leaderboard leaderboard) {
        HashMap map = new HashMap();
        if (leaderboard.getDisplayName() != null) {
            map.put("displayName", leaderboard.getDisplayName());
        }
        if (leaderboard.getIconImageUri() != null) {
            map.put("iconImageUri", leaderboard.getIconImageUri().toString());
        }
        if (leaderboard.getLeaderboardId() != null) {
            map.put("leaderboardId", leaderboard.getLeaderboardId());
        }
        map.put("scoreOrder", Integer.valueOf(leaderboard.getScoreOrder()));
        return new JSONObject((Map) map).toString();
    }

    public static JSONObject LeaderboardScoreJSON(LeaderboardScore leaderboardScore) {
        JSONObject jSONObject = new JSONObject();
        if (leaderboardScore.getDisplayRank() != null) {
            jSONObject.put("displayRank", leaderboardScore.getDisplayRank());
        }
        if (leaderboardScore.getDisplayScore() != null) {
            jSONObject.put("displayScore", leaderboardScore.getDisplayScore());
        }
        jSONObject.put("rank", leaderboardScore.getRank());
        jSONObject.put("rawScore", leaderboardScore.getRawScore());
        if (PlayerJSON(leaderboardScore.getScoreHolder()) != null) {
            jSONObject.put("scoreHolder", PlayerJSON(leaderboardScore.getScoreHolder()));
        }
        if (leaderboardScore.getScoreHolderDisplayName() != null) {
            jSONObject.put("scoreHolderDisplayName", leaderboardScore.getScoreHolderDisplayName());
        }
        if (leaderboardScore.getScoreHolderHiResImageUri() != null) {
            jSONObject.put("scoreHolderHiResImageUri", leaderboardScore.getScoreHolderHiResImageUri().toString());
        }
        if (leaderboardScore.getScoreHolderIconImageUri() != null) {
            jSONObject.put("scoreHolderIconImageUri", leaderboardScore.getScoreHolderIconImageUri().toString());
        }
        if (leaderboardScore.getScoreTag() != null) {
            jSONObject.put("scoreTag", leaderboardScore.getScoreTag());
        }
        jSONObject.put("timestampMillis", leaderboardScore.getTimestampMillis());
        return jSONObject;
    }

    private double getAsyncInd() {
        int i = this.AsyncInd + 1;
        this.AsyncInd = i;
        return i;
    }

    public /* synthetic */ void lambda$GooglePlayServices_SavedGames_CommitAndClose$1(double d, String str, Task task) {
        try {
            task.getResult();
            boolean zIsSuccessful = task.isSuccessful();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_CommitAndClose");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
            if (zIsSuccessful) {
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "snapshotMetadata", SnapshotMetadataJSON((SnapshotMetadata) task.getResult()).toString());
                this.mapSnapshot.remove(str);
            } else {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_CommitAndClose: failed to commit and close the saved game - " + task.getException().getMessage());
            }
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SavedGames_CommitAndClose");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    public static /* synthetic */ void lambda$GooglePlayServices_SavedGames_CommitNew$2(double d, Task task) {
        boolean zIsSuccessful = task.isSuccessful();
        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_CommitNew");
        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
        if (zIsSuccessful) {
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "snapshotMetadata", SnapshotMetadataJSON((SnapshotMetadata) task.getResult()).toString());
        } else {
            Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_CommitNew: failed to commit and close the saved game - " + task.getException().getMessage());
        }
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
    }

    public /* synthetic */ void lambda$GooglePlayServices_SavedGames_CommitNew$3(double d, String str, String str2, String str3, SnapshotsClient snapshotsClient, Task task) {
        Bitmap bitmapDecodeFile;
        try {
            task.getResult();
            boolean zIsSuccessful = task.isSuccessful();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_CommitNew");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
            if (!zIsSuccessful || ((SnapshotsClient.DataOrConflict) task.getResult()).isConflict()) {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_CommitNew: task failed or conflict - " + task.getException().getMessage());
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                return;
            }
            Snapshot snapshot = (Snapshot) ((SnapshotsClient.DataOrConflict) task.getResult()).getData();
            this.mapSnapshot.put(snapshot.getMetadata().getUniqueName(), snapshot);
            try {
                snapshot.getSnapshotContents().writeBytes(str.getBytes("UTF-8"));
            } catch (Exception e) {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_CommitNew : Failed to write snapshot data - " + e.getMessage());
            }
            SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
            if (!str2.isEmpty()) {
                builder.setDescription(str2);
            }
            if (!str3.isEmpty()) {
                File file = new File(activity.getFilesDir() + "/" + str3);
                if (file.exists() && (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) != null) {
                    builder.setCoverImage(bitmapDecodeFile);
                }
            }
            snapshotsClient.commitAndClose(snapshot, builder.build()).addOnCompleteListener(new YYGooglePlayServices$$ExternalSyntheticLambda0(1, d));
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SavedGames_CommitNew");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    public static /* synthetic */ void lambda$GooglePlayServices_SavedGames_Delete$6(double d, Task task) {
        try {
            task.getResult();
            boolean zIsSuccessful = task.isSuccessful();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_Delete");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
            if (zIsSuccessful) {
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "snapshotID", (String) task.getResult());
            } else {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_Delete : failed to delete saved game - " + task.getException().getMessage());
            }
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SavedGames_Delete");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    public static /* synthetic */ void lambda$GooglePlayServices_SavedGames_Load$4(double d, Task task) {
        try {
            task.getResult();
            boolean zIsSuccessful = task.isSuccessful();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_Load");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
            if (zIsSuccessful) {
                SnapshotMetadataBuffer snapshotMetadataBuffer = (SnapshotMetadataBuffer) ((AnnotatedData) task.getResult()).get();
                JSONArray jSONArray = new JSONArray();
                Iterator<Object> it = snapshotMetadataBuffer.iterator();
                while (it.hasNext()) {
                    jSONArray.put(SnapshotMetadataJSON((SnapshotMetadata) it.next()));
                }
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "snapshots", jSONArray.toString());
            } else {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_Load : failed to load saved games - " + task.getException().getMessage());
            }
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SavedGames_Load");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    public /* synthetic */ void lambda$GooglePlayServices_SavedGames_Open$5(double d, Task task) {
        try {
            task.getResult();
            boolean zIsSuccessful = task.isSuccessful();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_Open");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
            if (zIsSuccessful) {
                Snapshot snapshot = (Snapshot) ((SnapshotsClient.DataOrConflict) task.getResult()).getData();
                this.mapSnapshot.put(snapshot.getMetadata().getUniqueName(), snapshot);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "snapshotMetadata", SnapshotMetadataJSON(snapshot.getMetadata()).toString());
                try {
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "data", new String(snapshot.getSnapshotContents().readFully(), "UTF-8"));
                } catch (Exception e) {
                    Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_Open : Exception while reading snapshot data - " + e.getMessage());
                }
            } else {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_Open : failed to open saved game - " + task.getException().getMessage());
            }
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SavedGames_Open");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    public static /* synthetic */ void lambda$GooglePlayServices_SavedGames_ShowSavedGamesUI$0(Intent intent) {
        try {
            activity.startActivityForResult(intent, RC_SAVED_GAMES);
        } catch (Exception e) {
            Log.e(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_ShowSavedGamesUI: failed to show save games UI - " + e.getMessage());
        }
    }

    public double GooglePlayServices_Achievements_GetStatus(double d) {
        double asyncInd = getAsyncInd();
        PlayGames.getAchievementsClient(activity).load(d >= 0.5d).addOnCompleteListener(new AnonymousClass1(10, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_Achievements_Increment(String str, double d) {
        double asyncInd = getAsyncInd();
        PlayGames.getAchievementsClient(activity).incrementImmediate(str, (int) d).addOnCompleteListener(new AnonymousClass7(0, str, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_Achievements_Reveal(String str) {
        double asyncInd = getAsyncInd();
        PlayGames.getAchievementsClient(activity).revealImmediate(str).addOnCompleteListener(new AnonymousClass7(2, str, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_Achievements_SetSteps(String str, double d) {
        double asyncInd = getAsyncInd();
        PlayGames.getAchievementsClient(activity).setStepsImmediate(str, (int) d).addOnCompleteListener(new AnonymousClass7(3, str, asyncInd));
        return asyncInd;
    }

    public void GooglePlayServices_Achievements_Show() {
        Task achievementsIntent = PlayGames.getAchievementsClient(activity).getAchievementsIntent();
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(27);
        zzw zzwVar = (zzw) achievementsIntent;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, inputMergerFactory$1);
    }

    public double GooglePlayServices_Achievements_Unlock(String str) {
        double asyncInd = getAsyncInd();
        PlayGames.getAchievementsClient(activity).unlockImmediate(str).addOnCompleteListener(new AnonymousClass7(1, str, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_IsAuthenticated() {
        double asyncInd = getAsyncInd();
        PlayGames.getGamesSignInClient(activity).isAuthenticated().addOnCompleteListener(new AnonymousClass1(12, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_IsAvailable() {
        return ((double) GoogleApiAvailability.zab.isGooglePlayServicesAvailable(activity, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) == 0.0d ? 1.0d : 0.0d;
    }

    public double GooglePlayServices_Leaderboard_LoadPlayerCenteredScores(String str, double d, double d2, double d3, double d4) {
        double asyncInd = getAsyncInd();
        PlayGames.getLeaderboardsClient(activity).loadPlayerCenteredScores(str, (int) d, (int) d2, (int) d3, d4 >= 0.5d).addOnCompleteListener(new OnCompleteListener() { // from class: com.daerisoft.thespikerm.YYGooglePlayServices.15
            public final /* synthetic */ double val$ind;

            public AnonymousClass15() {
                d = asyncInd;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                double d5 = d;
                try {
                    task.getResult();
                    try {
                        LeaderboardsClient.LeaderboardScores leaderboardScores = (LeaderboardsClient.LeaderboardScores) ((AnnotatedData) task.getResult()).get();
                        JSONArray jSONArray = new JSONArray();
                        Iterator<Object> it = leaderboardScores.getScores().iterator();
                        while (it.hasNext()) {
                            jSONArray.put(YYGooglePlayServices.LeaderboardScoreJSON((LeaderboardScore) it.next()));
                        }
                        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_Leaderboard_LoadPlayerCenteredScores");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, task.isSuccessful() ? 1.0d : 0.0d);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d5);
                        if (task.isSuccessful()) {
                            RunnerJNILib.DsMapAddString(iJCreateDsMap, "leaderboard", YYGooglePlayServices.LeaderboardJSON(leaderboardScores.getLeaderboard()));
                            RunnerJNILib.DsMapAddString(iJCreateDsMap, "data", jSONArray.toString());
                        }
                        leaderboardScores.release();
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                    } catch (Exception unused) {
                        int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_Leaderboard_LoadPlayerCenteredScores");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                    }
                } catch (Exception unused2) {
                    int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "GooglePlayServices_Leaderboard_LoadPlayerCenteredScores");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "ind", d5);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
                }
            }
        });
        return asyncInd;
    }

    public double GooglePlayServices_Leaderboard_LoadTopScores(String str, double d, double d2, double d3, double d4) {
        double asyncInd = getAsyncInd();
        PlayGames.getLeaderboardsClient(activity).loadTopScores(str, (int) d, (int) d2, (int) d3, d4 >= 0.5d).addOnCompleteListener(new OnCompleteListener() { // from class: com.daerisoft.thespikerm.YYGooglePlayServices.16
            public final /* synthetic */ double val$ind;

            public AnonymousClass16() {
                d = asyncInd;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                double d5 = d;
                String str2 = FETmZwrVHuasmL.gqZScJISnK;
                try {
                    task.getResult();
                    try {
                        LeaderboardsClient.LeaderboardScores leaderboardScores = (LeaderboardsClient.LeaderboardScores) ((AnnotatedData) task.getResult()).get();
                        JSONArray jSONArray = new JSONArray();
                        Iterator<Object> it = leaderboardScores.getScores().iterator();
                        while (it.hasNext()) {
                            jSONArray.put(YYGooglePlayServices.LeaderboardScoreJSON((LeaderboardScore) it.next()));
                        }
                        int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, str2, "GooglePlayServices_Leaderboard_LoadTopScores");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, task.isSuccessful() ? 1.0d : 0.0d);
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d5);
                        if (task.isSuccessful()) {
                            RunnerJNILib.DsMapAddString(iJCreateDsMap, "leaderboard", YYGooglePlayServices.LeaderboardJSON(leaderboardScores.getLeaderboard()));
                            RunnerJNILib.DsMapAddString(iJCreateDsMap, "data", jSONArray.toString());
                        }
                        leaderboardScores.release();
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                    } catch (Exception unused) {
                        int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap2, str2, "GooglePlayServices_Leaderboard_LoadTopScores");
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                    }
                } catch (Exception unused2) {
                    int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap3, str2, "GooglePlayServices_Leaderboard_LoadTopScores");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "ind", d5);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
                }
            }
        });
        return asyncInd;
    }

    public void GooglePlayServices_Leaderboard_Show(String str) {
        Task leaderboardIntent = PlayGames.getLeaderboardsClient(activity).getLeaderboardIntent(str);
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(25);
        zzw zzwVar = (zzw) leaderboardIntent;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, inputMergerFactory$1);
    }

    public void GooglePlayServices_Leaderboard_ShowAll() {
        Task allLeaderboardsIntent = PlayGames.getLeaderboardsClient(activity).getAllLeaderboardsIntent();
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(24);
        zzw zzwVar = (zzw) allLeaderboardsIntent;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, inputMergerFactory$1);
    }

    public double GooglePlayServices_Leaderboard_SubmitScore(String str, double d, String str2) {
        double asyncInd = getAsyncInd();
        PlayGames.getLeaderboardsClient(activity).submitScoreImmediate(str, (long) d, str2).addOnCompleteListener(new OnCompleteListener() { // from class: com.daerisoft.thespikerm.YYGooglePlayServices.14
            public final /* synthetic */ double val$ind;
            public final /* synthetic */ String val$leader_id;
            public final /* synthetic */ double val$score;
            public final /* synthetic */ String val$scoreTag;

            public AnonymousClass14() {
                d = asyncInd;
                str = str;
                d = d;
                str = str2;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                double d2 = d;
                try {
                    task.getResult();
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_Leaderboard_SubmitScore");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d2);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "leaderboardId", str);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SCORE, d);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "scoreTag", str);
                    if (task.isSuccessful()) {
                        task.getResult();
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                        ScoreSubmissionData scoreSubmissionData = (ScoreSubmissionData) task.getResult();
                        HashMap map = new HashMap();
                        ScoreSubmissionData.Result scoreResult = scoreSubmissionData.getScoreResult(0);
                        if (scoreResult != null) {
                            HashMap map2 = new HashMap();
                            map2.put("isNewBest", Double.valueOf(scoreResult.newBest ? 1.0d : 0.0d));
                            map2.put(FirebaseAnalytics.Param.SCORE, Double.valueOf(scoreResult.rawScore));
                            map2.put("scoreTag", scoreResult.scoreTag);
                            map.put("daily", map2);
                        }
                        if (scoreSubmissionData.getScoreResult(1) != null) {
                            HashMap map3 = new HashMap();
                            map3.put("isNewBest", Double.valueOf(scoreResult.newBest ? 1.0d : 0.0d));
                            map3.put(FirebaseAnalytics.Param.SCORE, Double.valueOf(scoreResult.rawScore));
                            map3.put("scoreTag", scoreResult.scoreTag);
                            map.put("weekly", map3);
                        }
                        if (scoreSubmissionData.getScoreResult(2) != null) {
                            HashMap map4 = new HashMap();
                            map4.put("isNewBest", Double.valueOf(scoreResult.newBest ? 1.0d : 0.0d));
                            map4.put(FirebaseAnalytics.Param.SCORE, Double.valueOf(scoreResult.rawScore));
                            map4.put("scoreTag", scoreResult.scoreTag);
                            map.put("allTime", map4);
                        }
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "report", new JSONObject((Map) map).toString());
                    } else {
                        task.getException();
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                } catch (Exception unused) {
                    int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_Leaderboard_SubmitScore");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d2);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                }
            }
        });
        return asyncInd;
    }

    public double GooglePlayServices_PlayerStats_LoadPlayerStats(double d) {
        double asyncInd = getAsyncInd();
        PlayGames.getPlayerStatsClient(activity).loadPlayerStats(d >= 0.5d).addOnCompleteListener(new YYGooglePlayServices$$ExternalSyntheticLambda0(0, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_Player_Current() {
        double asyncInd = getAsyncInd();
        PlayGames.getPlayersClient(activity).getCurrentPlayer().addOnCompleteListener(new AnonymousClass1(14, asyncInd));
        return asyncInd;
    }

    public void GooglePlayServices_Player_CurrentID() {
        PlayGames.getPlayersClient(activity).getCurrentPlayerId().addOnCompleteListener(new InputMergerFactory$1(26));
    }

    public double GooglePlayServices_RequestServerSideAccess(String str, double d) {
        double asyncInd = getAsyncInd();
        PlayGames.getGamesSignInClient(activity).requestServerSideAccess(str, d >= 0.5d).addOnCompleteListener(new AnonymousClass1(13, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_SavedGames_CommitAndClose(final String str, String str2, String str3, String str4) {
        Bitmap bitmapDecodeFile;
        final double asyncInd = getAsyncInd();
        Snapshot snapshot = this.mapSnapshot.get(str);
        if (snapshot == null) {
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_CommitAndClose");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", asyncInd);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_CommitAndClose : couldn't find snapshot with name '" + str + "'");
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } else {
            try {
                snapshot.getSnapshotContents().writeBytes(str3.getBytes("UTF_8"));
            } catch (Exception e) {
                Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_CommitAndClose: Exception while converting data to bytes - " + e.getMessage());
            }
            SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
            if (!str2.isEmpty()) {
                builder.setDescription(str2);
            }
            if (!str4.isEmpty()) {
                File file = new File(activity.getFilesDir() + "/" + str4);
                if (file.exists() && (bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath())) != null) {
                    builder.setCoverImage(bitmapDecodeFile);
                }
            }
            PlayGames.getSnapshotsClient(activity).commitAndClose(snapshot, builder.build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.daerisoft.thespikerm.YYGooglePlayServices$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$GooglePlayServices_SavedGames_CommitAndClose$1(asyncInd, str, task);
                }
            });
        }
        return asyncInd;
    }

    public double GooglePlayServices_SavedGames_CommitNew(String str, final String str2, final String str3, final String str4) {
        final double asyncInd = getAsyncInd();
        final SnapshotsClient snapshotsClient = PlayGames.getSnapshotsClient(activity);
        snapshotsClient.open(str, true, (int) 1.0d).addOnCompleteListener(new OnCompleteListener() { // from class: com.daerisoft.thespikerm.YYGooglePlayServices$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SnapshotsClient snapshotsClient2 = snapshotsClient;
                this.f$0.lambda$GooglePlayServices_SavedGames_CommitNew$3(asyncInd, str3, str2, str4, snapshotsClient2, task);
            }
        });
        return asyncInd;
    }

    public double GooglePlayServices_SavedGames_DiscardAndClose(String str) {
        double asyncInd = getAsyncInd();
        Snapshot snapshot = this.mapSnapshot.get(str);
        if (snapshot == null) {
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_DiscardAndClose");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", asyncInd);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_DiscardAndClose : couldn't find snapshot with name '" + str + "'");
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } else {
            PlayGames.getSnapshotsClient(activity).discardAndClose(snapshot).addOnCompleteListener(new AnonymousClass1(11, asyncInd));
        }
        return asyncInd;
    }

    public double GooglePlayServices_SavedGames_Load(double d) {
        double asyncInd = getAsyncInd();
        PlayGames.getSnapshotsClient(activity).load(d >= 0.5d).addOnCompleteListener(new YYGooglePlayServices$$ExternalSyntheticLambda0(2, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_SavedGames_Open(String str) {
        final double asyncInd = getAsyncInd();
        PlayGames.getSnapshotsClient(activity).open(str, false, 1).addOnCompleteListener(new OnCompleteListener() { // from class: com.daerisoft.thespikerm.YYGooglePlayServices$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$GooglePlayServices_SavedGames_Open$5(asyncInd, task);
            }
        });
        return asyncInd;
    }

    public double GooglePlayServices_SavedGames_ShowSavedGamesUI(String str, double d, double d2, double d3) {
        this.ind_ShowSavedGamesUI = getAsyncInd();
        Task selectSnapshotIntent = PlayGames.getSnapshotsClient(activity).getSelectSnapshotIntent(str, d > 0.5d, d2 > 0.5d, (int) d3);
        DifferentialMotionFlingController$$ExternalSyntheticLambda0 differentialMotionFlingController$$ExternalSyntheticLambda0 = new DifferentialMotionFlingController$$ExternalSyntheticLambda0(2);
        zzw zzwVar = (zzw) selectSnapshotIntent;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, differentialMotionFlingController$$ExternalSyntheticLambda0);
        return this.ind_ShowSavedGamesUI;
    }

    public double GooglePlayServices_SignIn() {
        double asyncInd = getAsyncInd();
        PlayGames.getGamesSignInClient(activity).signIn().addOnCompleteListener(new AnonymousClass1(0, asyncInd));
        return asyncInd;
    }

    public double GooglePlayServices_UriToPath(String str) {
        double asyncInd = getAsyncInd();
        activity.runOnUiThread(new YYGooglePlayServices$Obj_UriToPath$1(str, asyncInd));
        return asyncInd;
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 9009) {
            return;
        }
        if (intent == null) {
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_ShowSavedGamesUI_OnExit");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", this.ind_ShowSavedGamesUI);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
            return;
        }
        if (!intent.hasExtra(SnapshotsClient.EXTRA_SNAPSHOT_METADATA)) {
            if (intent.hasExtra(SnapshotsClient.EXTRA_SNAPSHOT_NEW)) {
                int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_SavedGames_ShowSavedGamesUI_OnNew");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", this.ind_ShowSavedGamesUI);
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                return;
            }
            return;
        }
        SnapshotMetadata snapshotMetadata = (SnapshotMetadata) intent.getParcelableExtra(SnapshotsClient.EXTRA_SNAPSHOT_METADATA);
        int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
        RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "GooglePlayServices_SavedGames_ShowSavedGamesUI_OnOpen");
        RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "ind", this.ind_ShowSavedGamesUI);
        RunnerJNILib.DsMapAddString(iJCreateDsMap3, "snapshotMetadata", SnapshotMetadataJSON(snapshotMetadata).toString());
        RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
        GooglePlayServices_SavedGames_Open(snapshotMetadata.getUniqueName());
    }

    public static JSONObject PlayerJSON(Player player) {
        HashMap map = new HashMap();
        if (player.getBannerImageLandscapeUri() != null) {
            map.put("bannerImageLandscapeUri", player.getBannerImageLandscapeUri().toString());
        }
        if (player.getBannerImagePortraitUri() != null) {
            map.put("bannerImagePortraitUri", player.getBannerImagePortraitUri().toString());
        }
        if (player.getDisplayName() != null) {
            map.put("displayName", player.getDisplayName());
        }
        if (player.getHiResImageUri() != null) {
            map.put("hiResImageUri", player.getHiResImageUri().toString());
        }
        if (player.getIconImageUri() != null) {
            map.put(FETmZwrVHuasmL.xUzBIaXGAXisTWc, player.getIconImageUri().toString());
        }
        map.put("currentXpTotal", Double.valueOf(player.getLevelInfo().getCurrentXpTotal()));
        map.put("lastLevelUpTimestamp", Double.valueOf(player.getLevelInfo().getLastLevelUpTimestamp()));
        map.put("currentLevelNumber", Double.valueOf(player.getLevelInfo().getCurrentLevel().getLevelNumber()));
        map.put("currentMaxXp", Double.valueOf(player.getLevelInfo().getCurrentLevel().getMaxXp()));
        map.put("currentMinXp", Double.valueOf(player.getLevelInfo().getCurrentLevel().getMinXp()));
        map.put("nextLevelNumber", Double.valueOf(player.getLevelInfo().getNextLevel().getLevelNumber()));
        map.put("nextMaxXp", Double.valueOf(player.getLevelInfo().getNextLevel().getMaxXp()));
        map.put("nextMinXp", Double.valueOf(player.getLevelInfo().getNextLevel().getMinXp()));
        if (player.getPlayerId() != null) {
            map.put("playerId", player.getPlayerId());
        }
        map.put("retrievedTimestamp", Double.valueOf(player.getRetrievedTimestamp()));
        if (player.getTitle() != null) {
            map.put("title", player.getTitle());
        }
        if (player.hasHiResImage()) {
            map.put("hasHiResImage", Double.valueOf(1.0d));
        } else {
            map.put("hasHiResImage", Double.valueOf(0.0d));
        }
        if (player.hasIconImage()) {
            map.put("hasIconImage", Double.valueOf(1.0d));
        } else {
            map.put("hasIconImage", Double.valueOf(0.0d));
        }
        return new JSONObject((Map) map);
    }

    public static JSONObject SnapshotMetadataJSON(SnapshotMetadata snapshotMetadata) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coverImageAspectRatio", snapshotMetadata.getCoverImageAspectRatio());
            Uri coverImageUri = snapshotMetadata.getCoverImageUri();
            if (coverImageUri != null) {
                jSONObject.put("coverImageUri", coverImageUri.toString());
            }
            String description = snapshotMetadata.getDescription();
            if (description != null) {
                jSONObject.put("description", description);
            }
            String deviceName = snapshotMetadata.getDeviceName();
            if (deviceName != null) {
                jSONObject.put(CyjpdoedCdLTIO.XHqCzVrN, deviceName);
            }
            jSONObject.put("game", GameJSON(snapshotMetadata.getGame()));
            jSONObject.put("hasChangePending", snapshotMetadata.hasChangePending() ? 1.0d : 0.0d);
            jSONObject.put("lastModifiedTimestamp", snapshotMetadata.getLastModifiedTimestamp());
            jSONObject.put("owner", PlayerJSON(snapshotMetadata.getOwner()));
            jSONObject.put("playedTime", snapshotMetadata.getPlayedTime());
            jSONObject.put("progressValue", snapshotMetadata.getProgressValue());
            String uniqueName = snapshotMetadata.getUniqueName();
            if (uniqueName != null) {
                jSONObject.put("uniqueName", uniqueName);
            }
        } catch (Exception e) {
            Log.e(GooglePlayBillingService.TAG, "SnapshotMetadataJSON : failed to create SnapshotMetadata json object - " + e.getMessage());
        }
        return jSONObject;
    }

    public static /* synthetic */ void lambda$GooglePlayServices_PlayerStats_LoadPlayerStats$7(double d, Task task) {
        try {
            task.getResult();
            boolean zIsSuccessful = task.isSuccessful();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_PlayerStats_LoadPlayerStats");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, zIsSuccessful ? 1.0d : 0.0d);
            if (zIsSuccessful) {
                PlayerStats playerStats = (PlayerStats) ((AnnotatedData) task.getResult()).get();
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "AverageSessionLength", playerStats.getAverageSessionLength());
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "DaysSinceLastPlayed", playerStats.getDaysSinceLastPlayed());
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "NumberOfPurchases", playerStats.getNumberOfPurchases());
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "NumberOfSessions", playerStats.getNumberOfSessions());
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "SessionPercentile", playerStats.getSessionPercentile());
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "SpendPercentile", playerStats.getSpendPercentile());
            } else {
                Log.i(TSDAbK.mVwKsEFOnGPXP, "GooglePlayServices_PlayerStats_LoadPlayerStats : failed to query player stats - " + task.getException().getMessage());
            }
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_PlayerStats_LoadPlayerStats");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "ind", d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    public double GooglePlayServices_SavedGames_Delete(String str) {
        double asyncInd = getAsyncInd();
        Snapshot snapshot = this.mapSnapshot.get(str);
        if (snapshot == null) {
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_SavedGames_Delete");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, RDFWIi.VRSqjcnIgNKXdj, asyncInd);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            Log.i(GooglePlayBillingService.TAG, "GooglePlayServices_SavedGames_Delete : couldn't find snapshot with name '" + str + "'");
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } else {
            PlayGames.getSnapshotsClient(activity).delete(snapshot.getMetadata()).addOnCompleteListener(new YYGooglePlayServices$$ExternalSyntheticLambda0(3, asyncInd));
        }
        return asyncInd;
    }
}
