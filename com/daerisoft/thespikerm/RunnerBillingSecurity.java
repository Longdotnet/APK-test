package com.daerisoft.thespikerm;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class RunnerBillingSecurity {
    public static final String KEY_FACTORY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    public static final SecureRandom RANDOM = new SecureRandom();
    public static HashSet<Long> sKnownNonces = new HashSet<>();

    public static long generateNonce() {
        long jNextLong = RANDOM.nextLong();
        sKnownNonces.add(Long.valueOf(jNextLong));
        return jNextLong;
    }

    public static PublicKey generatePublicKey(String str) {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (IllegalArgumentException e) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: Base64 decoding failed.");
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }

    public static String getBase64EncodedPublicKey() {
        return RunnerActivity.BASE64_PUBLIC_KEY;
    }

    public static boolean isNonceKnown(long j) {
        return sKnownNonces.contains(Long.valueOf(j));
    }

    public static void removeNonce(long j) {
        sKnownNonces.remove(Long.valueOf(j));
    }

    public static boolean verify(PublicKey publicKey, String str, String str2) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            if (signature.verify(Base64.decode(str2, 0))) {
                return true;
            }
            Log.e(GooglePlayBillingService.TAG, "BILLING: Signature verification failed.");
            return false;
        } catch (IllegalArgumentException unused) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: Base64 decoding failed.");
            return false;
        } catch (InvalidKeyException unused2) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: Invalid key specification.");
            return false;
        } catch (NoSuchAlgorithmException unused3) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: NoSuchAlgorithmException.");
            return false;
        } catch (SignatureException unused4) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: Signature exception.");
            return false;
        }
    }

    public static boolean verifyPurchase(String str, String str2) {
        if (str == null) {
            Log.e(GooglePlayBillingService.TAG, "BILLING: signedData is null");
            return false;
        }
        if (TextUtils.isEmpty(str2) || verify(generatePublicKey(getBase64EncodedPublicKey()), str, str2)) {
            return true;
        }
        Log.w(GooglePlayBillingService.TAG, "BILLING: signature does not match data.");
        return false;
    }
}
