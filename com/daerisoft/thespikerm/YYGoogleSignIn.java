package com.daerisoft.thespikerm;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.work.InputMergerFactory$1;
import androidx.work.WorkContinuation;
import com.facebook.ProfileCache;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.zbn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p000authapi.zbay;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzv;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class YYGoogleSignIn extends RunnerSocial {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static final int REQ_ONE_TAP = 635;
    public static final int REQ_SIGN_IN = 9002;
    public static Activity activity = RunnerActivity.CurrentActivity;
    public GoogleSignInClient mGoogleSignInClient;
    public SignInClient oneTapClient;

    public void GoogleSignIn_Show(String str) {
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        new HashSet();
        new HashMap();
        zzah.checkNotNull(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.zah);
        String str2 = googleSignInOptions.zam;
        Account account = googleSignInOptions.zai;
        String str3 = googleSignInOptions.zan;
        HashMap mapZam = GoogleSignInOptions.zam(googleSignInOptions.zao);
        String str4 = googleSignInOptions.zap;
        zzah.checkNotEmpty(str);
        zzah.checkArgument(str2 == null || str2.equals(str), "two different server client ids provided");
        hashSet.add(GoogleSignInOptions.zab);
        if (hashSet.contains(GoogleSignInOptions.zae)) {
            Scope scope = GoogleSignInOptions.zad;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.zac);
        }
        this.mGoogleSignInClient = new GoogleSignInClient(activity, Auth.GOOGLE_SIGN_IN_API, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, googleSignInOptions.zak, googleSignInOptions.zal, str, str3, mapZam, str4), new ApiExceptionMapper());
        Activity activity2 = activity;
        zzah.checkNotNull(activity2);
        this.oneTapClient = new zbay(activity2, new zbn());
        BeginSignInRequest.PasswordRequestOptions passwordRequestOptions = new BeginSignInRequest.PasswordRequestOptions(false);
        zzah.checkNotEmpty(str);
        Task taskBeginSignIn = this.oneTapClient.beginSignIn(new BeginSignInRequest(passwordRequestOptions, new BeginSignInRequest.GoogleIdTokenRequestOptions(true, str, null, true, null, null, false), null, true, 0));
        Activity activity3 = activity;
        InputMergerFactory$1 inputMergerFactory$1 = new InputMergerFactory$1(28);
        zzw zzwVar = (zzw) taskBeginSignIn;
        zzwVar.getClass();
        zzu zzuVar = TaskExecutors.MAIN_THREAD;
        zzh zzhVar = new zzh((Executor) zzuVar, (OnSuccessListener) inputMergerFactory$1);
        zzr zzrVar = zzwVar.zzb;
        zzrVar.zza(zzhVar);
        zzv.zza(activity3).zzb(zzhVar);
        zzwVar.zzi();
        Activity activity4 = activity;
        zzh zzhVar2 = new zzh(zzuVar, new ProfileCache(this, 18));
        zzrVar.zza(zzhVar2);
        zzv.zza(activity4).zzb(zzhVar2);
        zzwVar.zzi();
    }

    @Override // com.daerisoft.thespikerm.RunnerSocial
    public void onActivityResult(int i, int i2, Intent intent) {
        GoogleSignInResult googleSignInResult;
        GoogleSignInAccount googleSignInAccount;
        if (i == 635) {
            try {
                SignInCredential signInCredentialFromIntent = this.oneTapClient.getSignInCredentialFromIntent(intent);
                int iJCreateDsMap = RunnerJNILib.jCreateDsMap(null, null, null);
                RunnerJNILib.DsMapAddString(iJCreateDsMap, "type", "GoogleSignIn_Show");
                RunnerJNILib.DsMapAddDouble(iJCreateDsMap, FirebaseAnalytics.Param.SUCCESS, 1.0d);
                String str = signInCredentialFromIntent.zbg;
                if (str != null) {
                    RunnerJNILib.DsMapAddString(iJCreateDsMap, "idToken", str);
                }
                RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap, 70);
                return;
            } catch (ApiException e) {
                int statusCode = e.getStatusCode();
                if (statusCode == 7) {
                    Log.d(GooglePlayBillingService.TAG, "GoogleSignIn NETWORK ERROR: One-tap encountered a network error.");
                    return;
                } else {
                    if (statusCode == 16) {
                        Log.d(GooglePlayBillingService.TAG, "GoogleSignIn CANCELED: One-tap dialog was closed by user.");
                        return;
                    }
                    Log.d(GooglePlayBillingService.TAG, "GoogleSignIn ERROR: Couldn't get credential from result: " + e.getLocalizedMessage());
                    return;
                }
            }
        }
        if (i != 9002) {
            return;
        }
        Logger logger = zbm.zba;
        if (intent == null) {
            googleSignInResult = new GoogleSignInResult(null, Status.RESULT_INTERNAL_ERROR);
        } else {
            Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
            GoogleSignInAccount googleSignInAccount2 = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
            if (googleSignInAccount2 == null) {
                if (status == null) {
                    status = Status.RESULT_INTERNAL_ERROR;
                }
                googleSignInResult = new GoogleSignInResult(null, status);
            } else {
                googleSignInResult = new GoogleSignInResult(googleSignInAccount2, Status.RESULT_SUCCESS);
            }
        }
        Status status2 = googleSignInResult.zba;
        try {
            String str2 = ((GoogleSignInAccount) ((!status2.isSuccess() || (googleSignInAccount = googleSignInResult.zbb) == null) ? WorkContinuation.forException(zzah.fromStatus(status2)) : WorkContinuation.forResult(googleSignInAccount)).getResult$1()).zae;
            int iJCreateDsMap2 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "type", "GoogleSignIn_Show");
            RunnerJNILib.DsMapAddString(iJCreateDsMap2, "idToken", str2);
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap2, FirebaseAnalytics.Param.SUCCESS, 1.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap2, 70);
        } catch (ApiException e2) {
            int iJCreateDsMap3 = RunnerJNILib.jCreateDsMap(null, null, null);
            RunnerJNILib.DsMapAddString(iJCreateDsMap3, "type", "GoogleSignIn_Show");
            RunnerJNILib.DsMapAddString(iJCreateDsMap3, "code", String.valueOf(e2.getStatusCode()));
            RunnerJNILib.DsMapAddString(iJCreateDsMap3, "message", e2.getLocalizedMessage());
            RunnerJNILib.DsMapAddDouble(iJCreateDsMap3, FirebaseAnalytics.Param.SUCCESS, 0.0d);
            RunnerJNILib.CreateAsynEventWithDSMap(iJCreateDsMap3, 70);
        }
    }
}
