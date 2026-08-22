package com.google.android.gms.games;

import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.YYGooglePlayServices;
import com.daerisoft.thespikerm.YYGoogleSignIn;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzj {
    public static Status zza(int i) {
        return new Status(i, zzb(i));
    }

    public static String zzb(int i) {
        if (i == 0) {
            return "STATUS_OK";
        }
        if (i == 1) {
            return "STATUS_INTERNAL_ERROR";
        }
        if (i == 2) {
            return "STATUS_CLIENT_RECONNECT_REQUIRED";
        }
        if (i == 3) {
            return "STATUS_NETWORK_ERROR_STALE_DATA";
        }
        if (i == 4) {
            return "STATUS_NETWORK_ERROR_NO_DATA";
        }
        if (i == 5) {
            return "STATUS_NETWORK_ERROR_OPERATION_DEFERRED";
        }
        if (i == 6) {
            return "STATUS_NETWORK_ERROR_OPERATION_FAILED";
        }
        if (i != 7) {
            if (i == 14) {
                return "STATUS_INTERRUPTED";
            }
            if (i == 15) {
                return "STATUS_TIMEOUT";
            }
            if (i == 6500) {
                return "STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE";
            }
            if (i == 6501) {
                return "STATUS_MATCH_ERROR_INACTIVE_MATCH";
            }
            switch (i) {
                case 7:
                    break;
                case 8:
                    return "STATUS_APP_MISCONFIGURED";
                case 9:
                    return "STATUS_GAME_NOT_FOUND";
                case 500:
                    return "STATUS_RESOLVE_STALE_OR_NO_DATA";
                case 1500:
                    return "STATUS_PLAYER_OOB_REQUIRED";
                case 4006:
                    return "STATUS_SNAPSHOT_CONFLICT_MISSING";
                case 8000:
                    return "STATUS_MILESTONE_CLAIMED_PREVIOUSLY";
                case 8001:
                    return xPQrbOSWiEdU.AsosESlEsRSWDB;
                case 8002:
                    return "STATUS_QUEST_NO_LONGER_AVAILABLE";
                case 8003:
                    return "STATUS_QUEST_NOT_STARTED";
                case 9000:
                    return "STATUS_VIDEO_NOT_ACTIVE";
                case 9001:
                    return "STATUS_VIDEO_UNSUPPORTED";
                case YYGoogleSignIn.REQ_SIGN_IN /* 9002 */:
                    return "STATUS_VIDEO_PERMISSION_ERROR";
                case YYGooglePlayServices.RC_ACHIEVEMENT_UI /* 9003 */:
                    return "STATUS_VIDEO_STORAGE_ERROR";
                case YYGooglePlayServices.RC_LEADERBOARD_UI /* 9004 */:
                    return "STATUS_VIDEO_UNEXPECTED_CAPTURE_ERROR";
                case 9006:
                    return "STATUS_VIDEO_ALREADY_CAPTURING";
                case YYGooglePlayServices.RC_SAVED_GAMES /* 9009 */:
                    return iafHZUfOuHNwvy.DfLdydWEW;
                case 9010:
                    return "STATUS_VIDEO_NO_MIC";
                case 9011:
                    return "STATUS_VIDEO_NO_CAMERA";
                case 9012:
                    return DYYbQc.phjPjnwKyvw;
                case 9016:
                    return "STATUS_VIDEO_RELEASE_TIMEOUT";
                case 9017:
                    return "STATUS_VIDEO_CAPTURE_VIDEO_PERMISSION_REQUIRED";
                case 9200:
                    return "STATUS_VIDEO_MISSING_OVERLAY_PERMISSION";
                case 10000:
                    return "STATUS_CLIENT_LOADING";
                case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /* 10001 */:
                    return "STATUS_CLIENT_EMPTY";
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /* 10002 */:
                    return "STATUS_CLIENT_HIDDEN";
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /* 10003 */:
                    return "STATUS_CONSENT_REQUIRED";
                default:
                    switch (i) {
                        case 1000:
                            return "STATUS_AUTH_ERROR_HARD";
                        case 1001:
                            return "STATUS_AUTH_ERROR_USER_RECOVERABLE";
                        case 1002:
                            return "STATUS_AUTH_ERROR_UNREGISTERED_CLIENT_ID";
                        case 1003:
                            return "STATUS_AUTH_ERROR_API_ACCESS_DENIED";
                        case 1004:
                            return "STATUS_AUTH_ERROR_ACCOUNT_NOT_USABLE";
                        case 1005:
                            return "STATUS_AUTH_ERROR_ACCOUNT_UNICORN";
                        case 1006:
                            return "STATUS_AUTH_ERROR_SERVICE_CACHE_MISTAKE";
                        default:
                            switch (i) {
                                case 2000:
                                    return "STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS";
                                case 2001:
                                    return "STATUS_REQUEST_UPDATE_TOTAL_FAILURE";
                                case 2002:
                                    return "STATUS_REQUEST_TOO_MANY_RECIPIENTS";
                                default:
                                    switch (i) {
                                        case 3000:
                                            return "STATUS_ACHIEVEMENT_UNLOCK_FAILURE";
                                        case 3001:
                                            return "STATUS_ACHIEVEMENT_UNKNOWN";
                                        case 3002:
                                            return "STATUS_ACHIEVEMENT_NOT_INCREMENTAL";
                                        case 3003:
                                            return "STATUS_ACHIEVEMENT_UNLOCKED";
                                        default:
                                            switch (i) {
                                                case 4000:
                                                    return gZrKCJ.cOivcLHaqj;
                                                case 4001:
                                                    return "STATUS_SNAPSHOT_CREATION_FAILED";
                                                case 4002:
                                                    return "STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE";
                                                case 4003:
                                                    return "STATUS_SNAPSHOT_COMMIT_FAILED";
                                                case 4004:
                                                    return "STATUS_SNAPSHOT_CONFLICT";
                                                default:
                                                    switch (i) {
                                                        case 6000:
                                                            return "STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED";
                                                        case 6001:
                                                            return "STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER";
                                                        case 6002:
                                                            return wsbWxekY.wbTch;
                                                        case 6003:
                                                            return "STATUS_MULTIPLAYER_DISABLED";
                                                        default:
                                                            switch (i) {
                                                                case 6503:
                                                                    return "STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION";
                                                                case 6504:
                                                                    return wsbWxekY.MrcondYL;
                                                                case 6505:
                                                                    return "STATUS_MATCH_ERROR_ALREADY_REMATCHED";
                                                                case 6506:
                                                                    return "STATUS_MATCH_NOT_FOUND";
                                                                case 6507:
                                                                    return "STATUS_MATCH_ERROR_LOCALLY_MODIFIED";
                                                                default:
                                                                    switch (i) {
                                                                        case 7000:
                                                                            return "STATUS_REAL_TIME_CONNECTION_FAILED";
                                                                        case 7001:
                                                                            return "STATUS_REAL_TIME_MESSAGE_SEND_FAILED";
                                                                        case 7002:
                                                                            return "STATUS_INVALID_REAL_TIME_ROOM_ID";
                                                                        case 7003:
                                                                            return "STATUS_PARTICIPANT_NOT_CONNECTED";
                                                                        case 7004:
                                                                            return "STATUS_REAL_TIME_ROOM_NOT_JOINED";
                                                                        case 7005:
                                                                            return "STATUS_REAL_TIME_INACTIVE_ROOM";
                                                                        case 7006:
                                                                            return "STATUS_REAL_TIME_SERVICE_NOT_CONNECTED";
                                                                        case 7007:
                                                                            return "STATUS_OPERATION_IN_FLIGHT";
                                                                        default:
                                                                            Locale locale = Locale.US;
                                                                            return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Status code (", ") not found!");
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return "STATUS_LICENSE_CHECK_FAILED";
    }
}
