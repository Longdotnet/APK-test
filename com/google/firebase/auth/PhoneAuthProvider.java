package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import java.util.concurrent.TimeUnit;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class PhoneAuthProvider {
    public static final String PHONE_SIGN_IN_METHOD = "phone";
    public static final String PROVIDER_ID = "phone";
    private FirebaseAuth zza;

    public static class ForceResendingToken extends AbstractSafeParcelable {
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzd();

        public static ForceResendingToken zza() {
            return new ForceResendingToken();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            CloseableKt.zzb(parcel, CloseableKt.zza(parcel, 20293));
        }
    }

    public static abstract class OnVerificationStateChangedCallbacks {
        private static final Logger zza = new Logger("PhoneAuthProvider", new String[0]);

        public void onCodeAutoRetrievalTimeOut(String str) {
            Logger logger = zza;
            Log.i(logger.zza, logger.format("Sms auto retrieval timed-out.", new Object[0]));
        }

        public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
        }

        public abstract void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(FirebaseException firebaseException);
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public static PhoneAuthCredential getCredential(String str, String str2) {
        return PhoneAuthCredential.zzc(str, str2);
    }

    @Deprecated
    public static PhoneAuthProvider getInstance(FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }

    public static void verifyPhoneNumber(PhoneAuthOptions phoneAuthOptions) {
        com.google.android.gms.common.internal.zzah.checkNotNull(phoneAuthOptions);
        phoneAuthOptions.zzb().zzI(phoneAuthOptions);
    }

    @Deprecated
    public static PhoneAuthProvider getInstance() {
        return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        PhoneAuthOptions.Builder builderNewBuilder = PhoneAuthOptions.newBuilder(this.zza);
        builderNewBuilder.setPhoneNumber(str);
        builderNewBuilder.setTimeout(Long.valueOf(j), timeUnit);
        builderNewBuilder.setActivity(activity);
        builderNewBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        verifyPhoneNumber(builderNewBuilder.build());
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, ForceResendingToken forceResendingToken) {
        PhoneAuthOptions.Builder builderNewBuilder = PhoneAuthOptions.newBuilder(this.zza);
        builderNewBuilder.setPhoneNumber(str);
        builderNewBuilder.setTimeout(Long.valueOf(j), timeUnit);
        builderNewBuilder.setActivity(activity);
        builderNewBuilder.setCallbacks(onVerificationStateChangedCallbacks);
        if (forceResendingToken != null) {
            builderNewBuilder.setForceResendingToken(forceResendingToken);
        }
        verifyPhoneNumber(builderNewBuilder.build());
    }
}
