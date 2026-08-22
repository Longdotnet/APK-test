package androidx.work;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.RoundRectDrawable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.text.PrecomputedTextCompat;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.daerisoft.thespikerm.GooglePlayBillingService;
import com.daerisoft.thespikerm.YYGooglePlayServices;
import com.daerisoft.thespikerm.YYGoogleSignIn;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.protobuf.DescriptorProtos;
import com.yoyogames.runner.RunnerJNILib;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class InputMergerFactory$1 implements ActionBarDrawerToggle$Delegate, MenuPresenter.Callback, ProfileInstaller$DiagnosticsCallback, SupportSQLiteOpenHelper.Factory, OnSuccessListener, OnCompleteListener {
    public static InputMergerFactory$1 DEFAULT;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ InputMergerFactory$1(int i) {
        this.$r8$classId = i;
    }

    public static boolean handleDeleteSurroundingText(EmojiInputConnection emojiInputConnection, Editable editable, int i, int i2, boolean z) {
        int iMin;
        if (editable == null || i < 0 || i2 < 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
            return false;
        }
        if (z) {
            int iMax = Math.max(i, 0);
            int length = editable.length();
            if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        if (iMax == 0) {
                            break loop0;
                        }
                        selectionStart--;
                        if (selectionStart < 0) {
                            if (!z2) {
                                selectionStart = 0;
                                break loop0;
                            }
                            break loop0;
                        }
                        char cCharAt = editable.charAt(selectionStart);
                        if (z2) {
                            if (Character.isHighSurrogate(cCharAt)) {
                                iMax--;
                            }
                        } else if (!Character.isSurrogate(cCharAt)) {
                            iMax--;
                        } else if (!Character.isHighSurrogate(cCharAt)) {
                            z2 = true;
                        }
                        selectionStart = -1;
                        break loop0;
                    }
                }
            }
            selectionStart = -1;
            break loop0;
            int iMax2 = Math.max(i2, 0);
            iMin = editable.length();
            if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                loop2: while (true) {
                    boolean z3 = false;
                    while (true) {
                        if (iMax2 != 0) {
                            if (selectionEnd >= iMin) {
                                if (!z3) {
                                    break loop2;
                                }
                                break loop2;
                            }
                            char cCharAt2 = editable.charAt(selectionEnd);
                            if (z3) {
                                if (Character.isLowSurrogate(cCharAt2)) {
                                    iMax2--;
                                    selectionEnd++;
                                }
                            } else if (!Character.isSurrogate(cCharAt2)) {
                                iMax2--;
                                selectionEnd++;
                            } else if (!Character.isLowSurrogate(cCharAt2)) {
                                selectionEnd++;
                                z3 = true;
                            }
                            iMin = -1;
                            break loop2;
                        }
                        iMin = selectionEnd;
                        break loop2;
                    }
                }
            }
            iMin = -1;
            break loop2;
            if (selectionStart == -1 || iMin == -1) {
                return false;
            }
        } else {
            selectionStart = Math.max(selectionStart - i, 0);
            iMin = Math.min(selectionEnd + i2, editable.length());
        }
        TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, iMin, TypefaceEmojiSpan.class);
        if (typefaceEmojiSpanArr == null || typefaceEmojiSpanArr.length <= 0) {
            return false;
        }
        for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
            int spanStart = editable.getSpanStart(typefaceEmojiSpan);
            int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
            selectionStart = Math.min(spanStart, selectionStart);
            iMin = Math.max(spanEnd, iMin);
        }
        int iMax3 = Math.max(selectionStart, 0);
        int iMin2 = Math.min(iMin, editable.length());
        emojiInputConnection.beginBatchEdit();
        editable.delete(iMax3, iMin2);
        emojiInputConnection.endBatchEdit();
        return true;
    }

    public static void onBillingSetupFinished(BillingResult billingResult) {
        if (billingResult.zza == 0) {
            boolean unused = GooglePlayBillingService.m_isStoreConnected = true;
            RunnerJNILib.CreateAsynEventWithDSMap(RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12005.0d}), 66);
        } else {
            boolean unused2 = GooglePlayBillingService.m_isStoreConnected = false;
            RunnerJNILib.CreateAsynEventWithDSMap(RunnerJNILib.jCreateDsMap(new String[]{"id"}, null, new double[]{12006.0d}), 66);
        }
    }

    private final void onDiagnosticReceived$androidx$profileinstaller$ProfileInstaller$1() {
    }

    private final void onResultReceived$androidx$profileinstaller$ProfileInstaller$1(int i, Serializable serializable) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(BillingFlowParams billingFlowParams) {
        boolean z = billingFlowParams.zza;
        return new FrameworkSQLiteOpenHelper((Context) billingFlowParams.zzd, (String) billingFlowParams.zze, (RoomOpenHelper) billingFlowParams.zzf, z);
    }

    public Signature[] getSigningSignatures(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public boolean isPrecomputedText(CharSequence charSequence) {
        return charSequence instanceof PrecomputedTextCompat;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        try {
            task.getResult();
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GooglePlayServices_Player_CurrentID");
            if (task.isSuccessful()) {
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "playerID", (String) task.getResult());
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
            } else {
                task.getException();
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            }
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        } catch (Exception unused) {
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GooglePlayServices_Player_CurrentID");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        }
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
        switch (this.$r8$classId) {
            case 15:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        return false;
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Serializable serializable) {
        String str;
        switch (this.$r8$classId) {
            case 15:
                break;
            default:
                switch (i) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i == 6 || i == 7 || i == 8) {
                    Log.e("ProfileInstaller", str, (Throwable) serializable);
                } else {
                    Log.d("ProfileInstaller", str);
                }
                break;
        }
    }

    public void setMaxElevation(RoomOpenHelper roomOpenHelper, float f) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((Drawable) roomOpenHelper.mConfiguration);
        CardView cardView = (CardView) roomOpenHelper.mDelegate;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f != roundRectDrawable.mPadding || roundRectDrawable.mInsetForPadding != useCompatPadding || roundRectDrawable.mInsetForRadius != preventCornerOverlap) {
            roundRectDrawable.mPadding = f;
            roundRectDrawable.mInsetForPadding = useCompatPadding;
            roundRectDrawable.mInsetForRadius = preventCornerOverlap;
            roundRectDrawable.updateBounds(null);
            roundRectDrawable.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            roomOpenHelper.setShadowPadding(0, 0, 0, 0);
            return;
        }
        RoundRectDrawable roundRectDrawable2 = (RoundRectDrawable) ((Drawable) roomOpenHelper.mConfiguration);
        float f2 = roundRectDrawable2.mPadding;
        float f3 = roundRectDrawable2.mRadius;
        int iCeil = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f2, f3, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f2, f3, cardView.getPreventCornerOverlap()));
        roomOpenHelper.setShadowPadding(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.$r8$classId) {
            case 24:
                try {
                    YYGooglePlayServices.activity.startActivityForResult((Intent) obj, YYGooglePlayServices.RC_LEADERBOARD_UI);
                } catch (Exception e) {
                    Log.e(GooglePlayBillingService.TAG, "ERROR GooglePlayServices_Leaderboard_ShowAll: " + e.getMessage(), e);
                    return;
                }
                break;
            case 25:
                try {
                    YYGooglePlayServices.activity.startActivityForResult((Intent) obj, YYGooglePlayServices.RC_LEADERBOARD_UI);
                } catch (Exception e2) {
                    Log.e(GooglePlayBillingService.TAG, "ERROR GooglePlayServices_Leaderboard_Show: " + e2.getMessage(), e2);
                    return;
                }
                break;
            case 26:
            default:
                try {
                    YYGoogleSignIn.activity.startIntentSenderForResult(((BeginSignInResult) obj).zba.getIntentSender(), YYGoogleSignIn.REQ_ONE_TAP, null, 0, 0, 0);
                } catch (IntentSender.SendIntentException e3) {
                    Log.e(xPQrbOSWiEdU.TXGOlIdZekZd, "GoogleSignIn Error Catch: Couldn't start One Tap UI: " + e3.getLocalizedMessage());
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GoogleSignIn_Show");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 0.0d);
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                }
                break;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                try {
                    YYGooglePlayServices.activity.startActivityForResult((Intent) obj, YYGooglePlayServices.RC_ACHIEVEMENT_UI);
                } catch (Exception e4) {
                    Log.e(GooglePlayBillingService.TAG, "ERROR GooglePlayServices_Achievements_Show: " + e4.getMessage(), e4);
                    return;
                }
                break;
        }
    }
}
