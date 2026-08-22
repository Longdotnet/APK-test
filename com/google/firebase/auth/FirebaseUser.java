package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public Task delete() {
        return FirebaseAuth.getInstance(zza()).zza(this);
    }

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getDisplayName();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getEmail();

    public Task getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zza()).zzc(this, z);
    }

    public abstract FirebaseUserMetadata getMetadata();

    public abstract MultiFactor getMultiFactor();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getPhoneNumber();

    @Override // com.google.firebase.auth.UserInfo
    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getProviderId();

    public abstract String getTenantId();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getUid();

    public abstract boolean isAnonymous();

    public Task linkWithCredential(AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzd(this, authCredential);
    }

    public Task reauthenticate(AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zze(this, authCredential);
    }

    public Task reauthenticateAndRetrieveData(AuthCredential authCredential) {
        com.google.android.gms.common.internal.zzah.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zza()).zzf(this, authCredential);
    }

    public Task reload() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zza());
        return firebaseAuth.zzg(this, new zzn(firebaseAuth, 1));
    }

    public Task sendEmailVerification() {
        Task taskZzc = FirebaseAuth.getInstance(zza()).zzc(this, false);
        zzy zzyVar = new zzy(this);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzc;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, zzyVar);
    }

    public Task startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        com.google.android.gms.common.internal.zzah.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzj(activity, federatedAuthProvider, this);
    }

    public Task startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        com.google.android.gms.common.internal.zzah.checkNotNull(activity);
        com.google.android.gms.common.internal.zzah.checkNotNull(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzk(activity, federatedAuthProvider, this);
    }

    public Task unlink(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzm(this, str);
    }

    public Task updateEmail(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzn(this, str);
    }

    public Task updatePassword(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zza()).zzo(this, str);
    }

    public Task updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zza()).zzp(this, phoneAuthCredential);
    }

    public Task updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        com.google.android.gms.common.internal.zzah.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zza()).zzq(this, userProfileChangeRequest);
    }

    public Task verifyBeforeUpdateEmail(String str) {
        return verifyBeforeUpdateEmail(str, null);
    }

    public abstract FirebaseApp zza();

    public abstract FirebaseUser zzb();

    public abstract FirebaseUser zzc(List list);

    public abstract zzzy zzd();

    public abstract String zze();

    public abstract String zzf();

    public abstract List zzg();

    public abstract void zzh(zzzy zzzyVar);

    public abstract void zzi(List list);

    public Task verifyBeforeUpdateEmail(String str, ActionCodeSettings actionCodeSettings) {
        Task taskZzc = FirebaseAuth.getInstance(zza()).zzc(this, false);
        zzaa zzaaVar = new zzaa(this, str, actionCodeSettings);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzc;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, zzaaVar);
    }

    public Task sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        Task taskZzc = FirebaseAuth.getInstance(zza()).zzc(this, false);
        zzz zzzVar = new zzz(this, actionCodeSettings, 0);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzc;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, zzzVar);
    }
}
