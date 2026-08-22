package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class FacebookSignatureValidator {
    public static final HashSet validAppSignatureHashes = GamepadHandler_API19.hashSetOf("8a3c4b262d721acd49a4bf97d5213199c86fa2b9", "cc2751449a350f668590264ed76692694a80308a", "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc", "df6b721c8b4d3b6eb44c861d4415007e5a35fc95", "9b8f518b086098de3d77736f9458a3d2f6f95a37", "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3", "c56fb7d591ba6704df047fd98f535372fea00211");

    public static final boolean validateSignature(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        String brand = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        Intrinsics.checkNotNullExpressionValue(brand, "brand");
        if (StringsKt__StringsKt.startsWith(brand, "generic", false) && (i & 2) != 0) {
            return true;
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr != null && signatureArr.length != 0) {
                Intrinsics.checkNotNullExpressionValue(signatureArr, "packageInfo.signatures");
                for (Signature signature : signatureArr) {
                    HashSet hashSet = validAppSignatureHashes;
                    byte[] byteArray = signature.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
                    if (!CollectionsKt.contains(hashSet, Utility.hashWithAlgorithm("SHA-1", byteArray))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
