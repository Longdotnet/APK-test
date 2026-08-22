package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.WorkContinuation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.internal.p002firebaseauthapi.zzaal;
import com.google.android.gms.internal.p002firebaseauthapi.zzwy;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import com.google.android.gms.internal.p002firebaseauthapi.zzxr;
import com.google.android.gms.internal.p002firebaseauthapi.zzyp;
import com.google.android.gms.internal.p002firebaseauthapi.zzyz;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbj;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FirebaseAuth implements InternalAuthProvider {
    private FirebaseApp zza;
    private final List zzb;
    private final List zzc;
    private List zzd;
    private zzwy zze;
    private FirebaseUser zzf;
    private com.google.firebase.auth.internal.zzw zzg;
    private final Object zzh;
    private String zzi;
    private final Object zzj;
    private String zzk;
    private final zzbg zzl;
    private final zzbm zzm;
    private final com.google.firebase.auth.internal.zzf zzn;
    private final Provider zzo;
    private zzbi zzp;
    private zzbj zzq;

    /* JADX INFO: loaded from: classes.dex */
    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(FirebaseApp firebaseApp, Provider provider) {
        zzzy zzzyVarZzb;
        zzwy zzwyVar = new zzwy(firebaseApp);
        zzbg zzbgVar = new zzbg(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbm zzbmVarZzc = zzbm.zzc();
        com.google.firebase.auth.internal.zzf zzfVarZzb = com.google.firebase.auth.internal.zzf.zzb();
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzh = new Object();
        this.zzj = new Object();
        this.zzq = zzbj.zza();
        this.zza = firebaseApp;
        this.zze = zzwyVar;
        this.zzl = zzbgVar;
        this.zzg = new com.google.firebase.auth.internal.zzw();
        com.google.android.gms.common.internal.zzah.checkNotNull(zzbmVarZzc);
        this.zzm = zzbmVarZzc;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzfVarZzb);
        this.zzn = zzfVarZzb;
        this.zzo = provider;
        FirebaseUser firebaseUserZza = zzbgVar.zza();
        this.zzf = firebaseUserZza;
        if (firebaseUserZza != null && (zzzyVarZzb = zzbgVar.zzb(firebaseUserZza)) != null) {
            zzH(this, this.zzf, zzzyVarZzb, false, false);
        }
        zzbmVarZzc.zze(this);
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static void zzG(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + firebaseUser.getUid() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        firebaseAuth.zzq.execute(new zzl(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zze() : null)));
    }

    public static void zzH(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzzy zzzyVar, boolean z, boolean z2) {
        boolean z3;
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzzyVar);
        boolean z4 = true;
        boolean z5 = firebaseAuth.zzf != null && firebaseUser.getUid().equals(firebaseAuth.zzf.getUid());
        if (z5 || !z2) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzf;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z6 = (z5 && firebaseUser2.zzd().zze().equals(zzzyVar.zze())) ? false : true;
                z3 = true ^ z5;
                z4 = z6;
            }
            FirebaseUser firebaseUser3 = firebaseAuth.zzf;
            if (firebaseUser3 == null) {
                firebaseAuth.zzf = firebaseUser;
            } else {
                firebaseUser3.zzc(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzf.zzb();
                }
                firebaseAuth.zzf.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z) {
                firebaseAuth.zzl.zzd(firebaseAuth.zzf);
            }
            if (z4) {
                FirebaseUser firebaseUser4 = firebaseAuth.zzf;
                if (firebaseUser4 != null) {
                    firebaseUser4.zzh(zzzyVar);
                }
                zzG(firebaseAuth, firebaseAuth.zzf);
            }
            if (z3) {
                zzF(firebaseAuth, firebaseAuth.zzf);
            }
            if (z) {
                firebaseAuth.zzl.zze(firebaseUser, zzzyVar);
            }
            FirebaseUser firebaseUser5 = firebaseAuth.zzf;
            if (firebaseUser5 != null) {
                zzx(firebaseAuth).zze(firebaseUser5.zzd());
            }
        }
    }

    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzL(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (this.zzg.zzd() && str != null && str.equals(this.zzg.zza())) ? new zzq(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks;
    }

    private final boolean zzM(String str) {
        ActionCodeUrl link = ActionCodeUrl.parseLink(str);
        return (link == null || TextUtils.equals(this.zzk, link.zza())) ? false : true;
    }

    public static zzbi zzx(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzp == null) {
            FirebaseApp firebaseApp = firebaseAuth.zza;
            com.google.android.gms.common.internal.zzah.checkNotNull(firebaseApp);
            firebaseAuth.zzp = new zzbi(firebaseApp);
        }
        return firebaseAuth.zzp;
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzq.execute(new zzk(this, authStateListener));
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        zzbj zzbjVar = this.zzq;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzbjVar);
        zzbjVar.execute(new zzj(this, idTokenListener));
    }

    public Task applyActionCode(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk);
    }

    public Task checkActionCode(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zzb(this.zza, str, this.zzk);
    }

    public Task confirmPasswordReset(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        return this.zze.zzc(this.zza, str, str2, this.zzk);
    }

    public Task createUserWithEmailAndPassword(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        return this.zze.zzd(this.zza, str, str2, this.zzk, new zzs(this));
    }

    public Task fetchSignInMethodsForEmail(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zzf(this.zza, str, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public final Task getAccessToken(boolean z) {
        return zzc(this.zzf, z);
    }

    public FirebaseApp getApp() {
        return this.zza;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    public Task getPendingAuthResult() {
        return this.zzm.zza();
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    public final String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    public Task sendPasswordResetEmail(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    public Task sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotNull(actionCodeSettings);
        if (!actionCodeSettings.canHandleCodeInApp()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        return this.zze.zzv(this.zza, str, actionCodeSettings, this.zzk);
    }

    public Task setFirebaseUIVersion(String str) {
        return this.zze.zzw(str);
    }

    public void setLanguageCode(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public void setTenantId(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    public Task signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zze.zzx(this.zza, new zzs(this), this.zzk);
        }
        com.google.firebase.auth.internal.zzx zzxVar = (com.google.firebase.auth.internal.zzx) this.zzf;
        zzxVar.zzq(false);
        return WorkContinuation.forResult(new com.google.firebase.auth.internal.zzr(zzxVar));
    }

    public Task signInWithCredential(AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (!(authCredentialZza instanceof EmailAuthCredential)) {
            if (authCredentialZza instanceof PhoneAuthCredential) {
                return this.zze.zzC(this.zza, (PhoneAuthCredential) authCredentialZza, this.zzk, new zzs(this));
            }
            return this.zze.zzy(this.zza, authCredentialZza, this.zzk, new zzs(this));
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
        if (emailAuthCredential.zzg()) {
            String strZzf = emailAuthCredential.zzf();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
            return zzM(strZzf) ? WorkContinuation.forException(zzxc.zza(new Status(17072))) : this.zze.zzB(this.zza, emailAuthCredential, new zzs(this));
        }
        zzwy zzwyVar = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String strZzd = emailAuthCredential.zzd();
        String strZze = emailAuthCredential.zze();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZze);
        return zzwyVar.zzA(firebaseApp, strZzd, strZze, this.zzk, new zzs(this));
    }

    public Task signInWithCustomToken(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zzz(this.zza, str, this.zzk, new zzs(this));
    }

    public Task signInWithEmailAndPassword(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        return this.zze.zzA(this.zza, str, str2, this.zzk, new zzs(this));
    }

    public Task signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzD();
        zzbi zzbiVar = this.zzp;
        if (zzbiVar != null) {
            zzbiVar.zzc();
        }
    }

    public Task startActivityForSignInWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        com.google.android.gms.common.internal.zzah.checkNotNull(federatedAuthProvider);
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzm.zzi(activity, taskCompletionSource, this)) {
            return WorkContinuation.forException(zzxc.zza(new Status(17057)));
        }
        this.zzm.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.zza;
    }

    public Task updateCurrentUser(FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        }
        String tenantId = firebaseUser.getTenantId();
        if ((tenantId != null && !tenantId.equals(this.zzk)) || ((str = this.zzk) != null && !str.equals(tenantId))) {
            return WorkContinuation.forException(zzxc.zza(new Status(17072)));
        }
        String apiKey = firebaseUser.zza().getOptions().getApiKey();
        String apiKey2 = this.zza.getOptions().getApiKey();
        if (!firebaseUser.zzd().zzj() || !apiKey2.equals(apiKey)) {
            return zzg(firebaseUser, new zzu(this));
        }
        zzE(com.google.firebase.auth.internal.zzx.zzk(this.zza, firebaseUser), firebaseUser.zzd(), true);
        return WorkContinuation.forResult(null);
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = zzxr.zza();
        }
    }

    public void useEmulator(String str, int i) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        boolean z = false;
        if (i >= 0 && i <= 65535) {
            z = true;
        }
        com.google.android.gms.common.internal.zzah.checkArgument(z, "Port number must be in the range 0-65535");
        zzyz.zzf(this.zza, str, i);
    }

    public Task verifyPasswordResetCode(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zzM(this.zza, str, this.zzk);
    }

    public final void zzD() {
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zzl);
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            this.zzl.zzc("com.google.firebase.auth.GET_TOKEN_RESPONSE." + firebaseUser.getUid());
            this.zzf = null;
        }
        this.zzl.zzc("com.google.firebase.auth.FIREBASE_USER");
        zzG(this, null);
        zzF(this, null);
    }

    public final void zzE(FirebaseUser firebaseUser, zzzy zzzyVar, boolean z) {
        zzH(this, firebaseUser, zzzyVar, true, false);
    }

    public final void zzI(PhoneAuthOptions phoneAuthOptions) {
        String uid;
        if (!phoneAuthOptions.zzk()) {
            FirebaseAuth firebaseAuthZzb = phoneAuthOptions.zzb();
            String strZzh = phoneAuthOptions.zzh();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh);
            long jLongValue = phoneAuthOptions.zzg().longValue();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZze = phoneAuthOptions.zze();
            Activity activityZza = phoneAuthOptions.zza();
            com.google.android.gms.common.internal.zzah.checkNotNull(activityZza);
            Executor executorZzi = phoneAuthOptions.zzi();
            boolean z = phoneAuthOptions.zzd() != null;
            if (z || !zzyp.zzd(strZzh, onVerificationStateChangedCallbacksZze, activityZza, executorZzi)) {
                firebaseAuthZzb.zzn.zza(firebaseAuthZzb, strZzh, activityZza, firebaseAuthZzb.zzK()).addOnCompleteListener(new zzo(firebaseAuthZzb, strZzh, jLongValue, timeUnit, onVerificationStateChangedCallbacksZze, activityZza, executorZzi, z));
                return;
            }
            return;
        }
        FirebaseAuth firebaseAuthZzb2 = phoneAuthOptions.zzb();
        MultiFactorSession multiFactorSessionZzc = phoneAuthOptions.zzc();
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorSessionZzc);
        if (((com.google.firebase.auth.internal.zzag) multiFactorSessionZzc).zze()) {
            uid = phoneAuthOptions.zzh();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(uid);
        } else {
            PhoneMultiFactorInfo phoneMultiFactorInfoZzf = phoneAuthOptions.zzf();
            com.google.android.gms.common.internal.zzah.checkNotNull(phoneMultiFactorInfoZzf);
            uid = phoneMultiFactorInfoZzf.getUid();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(uid);
        }
        if (phoneAuthOptions.zzd() != null) {
            PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZze2 = phoneAuthOptions.zze();
            Activity activityZza2 = phoneAuthOptions.zza();
            com.google.android.gms.common.internal.zzah.checkNotNull(activityZza2);
            if (zzyp.zzd(uid, onVerificationStateChangedCallbacksZze2, activityZza2, phoneAuthOptions.zzi())) {
                return;
            }
        }
        com.google.firebase.auth.internal.zzf zzfVar = firebaseAuthZzb2.zzn;
        String strZzh2 = phoneAuthOptions.zzh();
        Activity activityZza3 = phoneAuthOptions.zza();
        com.google.android.gms.common.internal.zzah.checkNotNull(activityZza3);
        zzfVar.zza(firebaseAuthZzb2, strZzh2, activityZza3, firebaseAuthZzb2.zzK()).addOnCompleteListener(new zzp(firebaseAuthZzb2, phoneAuthOptions));
    }

    public final void zzJ(String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z, String str2, String str3) {
        long jConvert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (jConvert < 0 || jConvert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        this.zze.zzO(this.zza, new zzaal(str, jConvert, z, this.zzi, this.zzk, str2, zzK(), str3), zzL(str, onVerificationStateChangedCallbacks), activity, executor);
    }

    public final boolean zzK() {
        return zzxh.zza(getApp().getApplicationContext());
    }

    public final Task zza(FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        return this.zze.zze(firebaseUser, new zzi(this, firebaseUser));
    }

    public final Task zzb(FirebaseUser firebaseUser, MultiFactorAssertion multiFactorAssertion, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorAssertion);
        return multiFactorAssertion instanceof PhoneMultiFactorAssertion ? this.zze.zzg(this.zza, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzs(this)) : WorkContinuation.forException(zzxc.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    public final Task zzc(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return WorkContinuation.forException(zzxc.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzzy zzzyVarZzd = firebaseUser.zzd();
        return (!zzzyVarZzd.zzj() || z) ? this.zze.zzi(this.zza, firebaseUser, zzzyVarZzd.zzf(), new zzn(this, 0)) : WorkContinuation.forResult(zzay.zza(zzzyVarZzd.zze()));
    }

    public final Task zzd(FirebaseUser firebaseUser, AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        return this.zze.zzj(this.zza, firebaseUser, authCredential.zza(), new zzn(this, 1));
    }

    public final Task zze(FirebaseUser firebaseUser, AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (!(authCredentialZza instanceof EmailAuthCredential)) {
            return authCredentialZza instanceof PhoneAuthCredential ? this.zze.zzq(this.zza, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzk, new zzn(this, 1)) : this.zze.zzk(this.zza, firebaseUser, authCredentialZza, firebaseUser.getTenantId(), new zzn(this, 1));
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
        if (!"password".equals(emailAuthCredential.getSignInMethod())) {
            String strZzf = emailAuthCredential.zzf();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
            return zzM(strZzf) ? WorkContinuation.forException(zzxc.zza(new Status(17072))) : this.zze.zzm(this.zza, firebaseUser, emailAuthCredential, new zzn(this, 1));
        }
        zzwy zzwyVar = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String strZzd = emailAuthCredential.zzd();
        String strZze = emailAuthCredential.zze();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZze);
        return zzwyVar.zzo(firebaseApp, firebaseUser, strZzd, strZze, firebaseUser.getTenantId(), new zzn(this, 1));
    }

    public final Task zzf(FirebaseUser firebaseUser, AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (!(authCredentialZza instanceof EmailAuthCredential)) {
            return authCredentialZza instanceof PhoneAuthCredential ? this.zze.zzr(this.zza, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzk, new zzn(this, 1)) : this.zze.zzl(this.zza, firebaseUser, authCredentialZza, firebaseUser.getTenantId(), new zzn(this, 1));
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
        if (!"password".equals(emailAuthCredential.getSignInMethod())) {
            String strZzf = emailAuthCredential.zzf();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
            return zzM(strZzf) ? WorkContinuation.forException(zzxc.zza(new Status(17072))) : this.zze.zzn(this.zza, firebaseUser, emailAuthCredential, new zzn(this, 1));
        }
        zzwy zzwyVar = this.zze;
        FirebaseApp firebaseApp = this.zza;
        String strZzd = emailAuthCredential.zzd();
        String strZze = emailAuthCredential.zze();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZze);
        return zzwyVar.zzp(firebaseApp, firebaseUser, strZzd, strZze, firebaseUser.getTenantId(), new zzn(this, 1));
    }

    public final Task zzg(FirebaseUser firebaseUser, zzbk zzbkVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        return this.zze.zzs(this.zza, firebaseUser, zzbkVar);
    }

    public final Task zzh(MultiFactorAssertion multiFactorAssertion, com.google.firebase.auth.internal.zzag zzagVar, FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorAssertion);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzagVar);
        String strZzd = zzagVar.zzd();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzd);
        return this.zze.zzh(this.zza, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, strZzd, new zzs(this));
    }

    public final Task zzi(ActionCodeSettings actionCodeSettings, String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zzf(this.zzi);
        }
        return this.zze.zzt(this.zza, actionCodeSettings, str);
    }

    public final Task zzj(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        com.google.android.gms.common.internal.zzah.checkNotNull(federatedAuthProvider);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzm.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return WorkContinuation.forException(zzxc.zza(new Status(17057)));
        }
        this.zzm.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.zza;
    }

    public final Task zzk(Activity activity, FederatedAuthProvider federatedAuthProvider, FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        com.google.android.gms.common.internal.zzah.checkNotNull(federatedAuthProvider);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzm.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return WorkContinuation.forException(zzxc.zza(new Status(17057)));
        }
        this.zzm.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.zza;
    }

    public final Task zzl(FirebaseUser firebaseUser, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        Task taskZzF = this.zze.zzF(this.zza, firebaseUser, str, new zzn(this, 1));
        zzr zzrVar = new zzr(0);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzF;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, zzrVar);
    }

    public final Task zzm(FirebaseUser firebaseUser, String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        return this.zze.zzG(this.zza, firebaseUser, str, new zzn(this, 1));
    }

    public final Task zzn(FirebaseUser firebaseUser, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zzH(this.zza, firebaseUser, str, new zzn(this, 1));
    }

    public final Task zzo(FirebaseUser firebaseUser, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return this.zze.zzI(this.zza, firebaseUser, str, new zzn(this, 1));
    }

    public final Task zzp(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(phoneAuthCredential);
        return this.zze.zzJ(this.zza, firebaseUser, phoneAuthCredential.clone(), new zzn(this, 1));
    }

    public final Task zzq(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(userProfileChangeRequest);
        return this.zze.zzK(this.zza, firebaseUser, userProfileChangeRequest, new zzn(this, 1));
    }

    public final Task zzr(String str, String str2, ActionCodeSettings actionCodeSettings) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzi;
        if (str3 != null) {
            actionCodeSettings.zzf(str3);
        }
        return this.zze.zzL(str, str2, actionCodeSettings);
    }

    public final synchronized zzbi zzw() {
        return zzx(this);
    }

    public final Provider zzy() {
        return this.zzo;
    }

    public static void zzF(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", TSDAbK.SyfTScTRLl + firebaseUser.getUid() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.zzq.execute(new zzm(firebaseAuth));
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        com.google.android.gms.common.internal.zzah.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzw().zzd(this.zzc.size());
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public Task sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        actionCodeSettings.zzg(1);
        return this.zze.zzu(this.zza, str, actionCodeSettings, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        com.google.android.gms.common.internal.zzah.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzw().zzd(this.zzc.size());
    }
}
