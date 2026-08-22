package com.daerisoft.thespikerm;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.gson.yWTz.kBfGXgdfpo;
import com.yoyogames.runner.RunnerJNILib;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class YYFirebaseAuthentication extends RunnerSocial {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static Activity activity = RunnerActivity.CurrentActivity;
    public double Auth_valueListernerInd = 5000.0d;
    public FirebaseAuth.IdTokenListener mIdTokenListener = null;

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYFirebaseAuthentication$1, reason: invalid class name */
    public final class AnonymousClass1 implements OnCompleteListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ YYFirebaseAuthentication this$0;
        public final /* synthetic */ double val$listenerInd;

        public /* synthetic */ AnonymousClass1(YYFirebaseAuthentication yYFirebaseAuthentication, double d, int i) {
            this.$r8$classId = i;
            this.this$0 = yYFirebaseAuthentication;
            this.val$listenerInd = d;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            switch (this.$r8$classId) {
                case 0:
                    int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "FirebaseAuthentication_SignInWithCustomToken");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                    break;
                case 1:
                    int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap2, ZRqOdXiy.fjFfU, "FirebaseAuthentication_LinkWithEmailPassword");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap2, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap2, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap2, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
                    break;
                case 2:
                    int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "FirebaseAuthentication_SignIn_OAuth");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap3, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap3, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap3, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
                    break;
                case 3:
                    int iJCreateDsMap4 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap4, "type", "FirebaseAuthentication_LinkWithOAuthCredential");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap4, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap4, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap4, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap4, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap4, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap4, 70);
                    break;
                case 4:
                    int iJCreateDsMap5 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap5, "type", "FirebaseAuthentication_UnlinkProvider");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap5, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap5, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap5, mnwSv.ZHajYokeyOuDk, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap5, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap5, 70);
                    break;
                case 5:
                    int iJCreateDsMap6 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap6, "type", "FirebaseAuthentication_SignInWithPhoneNumber");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap6, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap6, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap6, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap6, kBfGXgdfpo.WbmiMMdMWv, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap6, "status", 400.0d, task));
                        Log.w(GooglePlayBillingService.TAG, "signInWithCredential:failure", task.getException());
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap6, 70);
                    break;
                case 6:
                    int iJCreateDsMap7 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap7, "type", oKjScaD.ZFanNCf);
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap7, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap7, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap7, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap7, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap7, 70);
                    break;
                case 7:
                    int iJCreateDsMap8 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap8, "type", "FirebaseAuthentication_ReauthenticateWithEmail");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap8, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap8, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap8, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap8, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap8, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap8, 70);
                    break;
                case 8:
                    int iJCreateDsMap9 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap9, "type", "FirebaseAuthentication_ReauthenticateWithOAuth");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap9, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap9, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap9, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap9, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap9, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap9, 70);
                    break;
                case 9:
                    int iJCreateDsMap10 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap10, "type", "FirebaseAuthentication_ReauthenticateWithPhoneNumber");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap10, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap10, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap10, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap10, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap10, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap10, 70);
                    break;
                case 10:
                    int iJCreateDsMap11 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap11, "type", "SDKFirebaseAuthentication_SignInWithProvider");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap11, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap11, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap11, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap11, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap11, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap11, 70);
                    break;
                case 11:
                    int iJCreateDsMap12 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap12, "type", "SDKFirebaseAuthentication_LinkWithProvider");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap12, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap12, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap12, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap12, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap12, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap12, 70);
                    break;
                case 12:
                    int iJCreateDsMap13 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap13, "type", "SDKFirebaseAuthentication_ReauthenticateWithProvider");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap13, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap13, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap13, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap13, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap13, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap13, 70);
                    break;
                case 13:
                    int iJCreateDsMap14 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap14, "type", "FirebaseAuthentication_SignIn_Email");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap14, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap14, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap14, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap14, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap14, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap14, 70);
                    break;
                case 14:
                    int iJCreateDsMap15 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap15, "type", "FirebaseAuthentication_SignUp_Email");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap15, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap15, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap15, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap15, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap15, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap15, 70);
                    break;
                default:
                    int iJCreateDsMap16 = RunnerJNILib.jCreateDsMap(null, null, null);
                    RunnerJNILib.DsMapAddString(iJCreateDsMap16, "type", "FirebaseAuthentication_SignIn_Anonymously");
                    RunnerJNILib.DsMapAddDouble(iJCreateDsMap16, "listener", this.val$listenerInd);
                    if (task.isSuccessful()) {
                        RunnerJNILib.DsMapAddDouble(iJCreateDsMap16, "status", 200.0d);
                        RunnerJNILib.DsMapAddString(iJCreateDsMap16, FirebaseAnalytics.Param.VALUE, this.this$0.SDKFirebaseAuthentication_GetUserData_From(((AuthResult) task.getResult()).getUser()));
                    } else {
                        RunnerJNILib.DsMapAddString(iJCreateDsMap16, "errorMessage", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iJCreateDsMap16, "status", 400.0d, task));
                    }
                    RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap16, 70);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.daerisoft.thespikerm.YYFirebaseAuthentication$26, reason: invalid class name */
    /* JADX INFO: loaded from: classes.dex */
    public final class AnonymousClass26 implements FirebaseAuth.IdTokenListener {
        public final /* synthetic */ double val$listenerInd;

        public AnonymousClass26(double d) {
            this.val$listenerInd = d;
        }

        @Override // com.google.firebase.auth.FirebaseAuth.IdTokenListener
        public final void onIdTokenChanged(FirebaseAuth firebaseAuth) {
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser != null) {
                currentUser.getIdToken(false).addOnCompleteListener(new Fragment.AnonymousClass7(this, 16));
                return;
            }
            int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "FirebaseAuthentication_IdTokenListener");
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "listener", this.val$listenerInd);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "status", 200.0d);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap, "withSuncyan", 0.0d);
            RunnerJNILib.DsMapAddString(iJCreateDsMap, FirebaseAnalytics.Param.VALUE, "");
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
        }
    }

    private double Auth_getListenerInd() {
        double d = this.Auth_valueListernerInd + 1.0d;
        this.Auth_valueListernerInd = d;
        return d;
    }

    private String generateNonce(int i) {
        SecureRandom secureRandom = new SecureRandom();
        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.US_ASCII.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.IGNORE;
        charsetDecoderNewDecoder.onUnmappableCharacter(codingErrorAction);
        charsetDecoderNewDecoder.onMalformedInput(codingErrorAction);
        byte[] bArr = new byte[i];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        while (charBufferAllocate.hasRemaining()) {
            secureRandom.nextBytes(bArr);
            byteBufferWrap.rewind();
            charsetDecoderNewDecoder.reset();
            charsetDecoderNewDecoder.decode(byteBufferWrap, charBufferAllocate, false);
        }
        charBufferAllocate.flip();
        return charBufferAllocate.toString();
    }

    private String sha256(String str) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public double SDKFirebaseAuthentication_ChangeDisplayName(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().updateProfile(new UserProfileChangeRequest.Builder().setDisplayName(str).build()).addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(8, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ChangeEmail(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().updateEmail(str).addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(6, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ChangePassword(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().updatePassword(str).addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(7, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ChangePhotoURL(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().updateProfile(new UserProfileChangeRequest.Builder().setPhotoUri(Uri.parse(str)).build()).addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(9, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_DeleteAccount() {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().delete().addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(2, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_GetIdToken() {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().getIdToken(true).addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(4, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public String SDKFirebaseAuthentication_GetUserData() {
        return SDKFirebaseAuthentication_GetUserData_From(FirebaseAuth.getInstance().getCurrentUser());
    }

    public double SDKFirebaseAuthentication_IdTokenListener2() {
        double dAuth_getListenerInd = Auth_getListenerInd();
        this.mIdTokenListener = new AnonymousClass26(dAuth_getListenerInd);
        FirebaseAuth.getInstance().addIdTokenListener(this.mIdTokenListener);
        return dAuth_getListenerInd;
    }

    public void SDKFirebaseAuthentication_IdTokenListener_Remove() {
        if (this.mIdTokenListener != null) {
            FirebaseAuth.getInstance().removeIdTokenListener(this.mIdTokenListener);
            this.mIdTokenListener = null;
        }
    }

    public double SDKFirebaseAuthentication_LinkWithEmailPassword(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().linkWithCredential(EmailAuthProvider.getCredential(str, str2)).addOnCompleteListener(new AnonymousClass1(this, dAuth_getListenerInd, 1));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_LinkWithOAuthCredential(String str, String str2, String str3, String str4) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().linkWithCredential(getAuthCredentialFromProvider(str, str2, str3)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 3));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_LinkWithPhoneNumber(String str, String str2, String str3) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().linkWithCredential(PhoneAuthProvider.getCredential(str3, str2)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 6));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_LinkWithProvider(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(str);
        builderNewBuilder.setScopes(jsonArrayString2List(str2));
        FirebaseAuth.getInstance().startActivityForSignInWithProvider(activity, builderNewBuilder.build()).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 11));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ReauthenticateWithEmail(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().reauthenticateAndRetrieveData(EmailAuthProvider.getCredential(str, str2)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 7));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ReauthenticateWithOAuth(String str, String str2, String str3, String str4) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().reauthenticateAndRetrieveData(getAuthCredentialFromProvider(str, str2, str3)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 8));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ReauthenticateWithPhoneNumber(String str, String str2, String str3) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().reauthenticateAndRetrieveData(PhoneAuthProvider.getCredential(str3, str2)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 9));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_ReauthenticateWithProvider(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(str);
        builderNewBuilder.setScopes(jsonArrayString2List(str2));
        FirebaseAuth.getInstance().getCurrentUser().startActivityForLinkWithProvider(activity, builderNewBuilder.build()).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 12));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_RefreshUserData() {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().reload().addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(3, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SendEmailVerification() {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(1, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SendPasswordResetEmail(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().sendPasswordResetEmail(str).addOnCompleteListener(new YYGooglePlayServices.AnonymousClass1(5, dAuth_getListenerInd));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SignInWithCustomToken(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().signInWithCustomToken(str).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 0));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SignInWithPhoneNumber(String str, String str2, String str3) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().signInWithCredential(PhoneAuthProvider.getCredential(str3, str2)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 5));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SignInWithProvider(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(str);
        builderNewBuilder.setScopes(jsonArrayString2List(str2));
        Log.i(GooglePlayBillingService.TAG, "Hello SDKFirebaseAuthentication_SignInWithProvider :" + str + " : " + str2);
        FirebaseAuth.getInstance().startActivityForSignInWithProvider(activity, builderNewBuilder.build()).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 10));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SignIn_Anonymously() {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 15));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SignIn_Email(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().signInWithEmailAndPassword(str, str2).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 13));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_SignIn_OAuth(String str, String str2, String str3, String str4) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().signInWithCredential(getAuthCredentialFromProvider(str, str2, str3)).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 2));
        return dAuth_getListenerInd;
    }

    public void SDKFirebaseAuthentication_SignOut() {
        FirebaseAuth.getInstance().signOut();
    }

    public double SDKFirebaseAuthentication_SignUp_Email(String str, String str2) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(str, str2).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 14));
        return dAuth_getListenerInd;
    }

    public double SDKFirebaseAuthentication_UnlinkProvider(String str) {
        double dAuth_getListenerInd = Auth_getListenerInd();
        FirebaseAuth.getInstance().getCurrentUser().unlink(str).addOnCompleteListener(activity, new AnonymousClass1(this, dAuth_getListenerInd, 4));
        return dAuth_getListenerInd;
    }

    public AuthCredential getAuthCredentialFromProvider(String str, String str2, String str3) {
        Auth_getListenerInd();
        str3.getClass();
        switch (str3) {
            case "apple.com":
                return OAuthProvider.newCredentialBuilder("apple.com").setIdTokenWithRawNonce(str, generateNonce(16)).build();
            case "playgames.google.com":
                return PlayGamesAuthProvider.getCredential(str);
            case "google.com":
                if (str2.equals("id_token")) {
                    return GoogleAuthProvider.getCredential(str, null);
                }
                if (str2.equals("access_token")) {
                    return GoogleAuthProvider.getCredential(null, str);
                }
                return null;
            case "facebook.com":
                return FacebookAuthProvider.getCredential(str);
            default:
                return null;
        }
    }

    public List<String> jsonArrayString2List(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public String SDKFirebaseAuthentication_GetUserData_From(FirebaseUser firebaseUser) {
        String str = eoBKjVuj.RzxjPKQu;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, firebaseUser.getDisplayName());
            jSONObject.put("email", firebaseUser.getEmail());
            jSONObject.put("localId", firebaseUser.getUid());
            jSONObject.put("emailVerified", firebaseUser.isEmailVerified());
            jSONObject.put("phoneNumber", firebaseUser.isEmailVerified());
            jSONObject.put("photoUrl", firebaseUser.getPhotoUrl());
            jSONObject.put("lastLoginAt", firebaseUser.getMetadata().getCreationTimestamp());
            jSONObject.put("createdAt", firebaseUser.getMetadata().getLastSignInTimestamp());
            List<? extends UserInfo> providerData = firebaseUser.getProviderData();
            JSONArray jSONArray = new JSONArray();
            for (UserInfo userInfo : providerData) {
                if (!userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(str, userInfo.getDisplayName());
                    jSONObject2.put("email", userInfo.getEmail());
                    jSONObject2.put("phoneNumber", userInfo.getPhoneNumber());
                    jSONObject2.put("photoUrl", userInfo.getPhotoUrl());
                    jSONObject2.put("providerId", userInfo.getProviderId());
                    jSONObject2.put("rawId", userInfo.getUid());
                    jSONObject2.put("federatedId", userInfo.getUid());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("providerUserInfo", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("kind", "identitytoolkit#GetAccountInfoResponse");
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject);
            jSONObject3.put(DYYbQc.gRfyJtQ, jSONArray2);
            return jSONObject3.toString();
        } catch (Exception unused) {
            return "{}";
        }
    }
}
