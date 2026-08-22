package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.internal.Validate;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes2.dex */
public final class AuthenticationToken implements Parcelable {
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new FragmentState.AnonymousClass1(21);
    public final AuthenticationTokenClaims claims;
    public final String expectedNonce;
    public final AuthenticationTokenHeader header;
    public final String signature;
    public final String token;

    public AuthenticationToken(String str, String expectedNonce) {
        Intrinsics.checkNotNullParameter(expectedNonce, "expectedNonce");
        Validate.notEmpty(str, "token");
        Validate.notEmpty(expectedNonce, "expectedNonce");
        boolean zVerify = false;
        List listSplit$default = StringsKt__StringsKt.split$default(str, new String[]{"."}, 0, 6);
        if (listSplit$default.size() != 3) {
            throw new IllegalArgumentException("Invalid IdToken string");
        }
        String str2 = (String) listSplit$default.get(0);
        String str3 = (String) listSplit$default.get(1);
        String str4 = (String) listSplit$default.get(2);
        this.token = str;
        this.expectedNonce = expectedNonce;
        AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str2);
        this.header = authenticationTokenHeader;
        this.claims = new AuthenticationTokenClaims(str3, expectedNonce);
        try {
            String rawKeyFromEndPoint = Protocol.Companion.getRawKeyFromEndPoint(authenticationTokenHeader.kid);
            if (rawKeyFromEndPoint != null) {
                zVerify = Protocol.Companion.verify(Protocol.Companion.getPublicKeyFromString(rawKeyFromEndPoint), str2 + '.' + str3, str4);
            }
        } catch (IOException | InvalidKeySpecException unused) {
        }
        if (!zVerify) {
            throw new IllegalArgumentException("Invalid Signature");
        }
        this.signature = str4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        return Intrinsics.areEqual(this.token, authenticationToken.token) && Intrinsics.areEqual(this.expectedNonce, authenticationToken.expectedNonce) && Intrinsics.areEqual(this.header, authenticationToken.header) && Intrinsics.areEqual(this.claims, authenticationToken.claims) && Intrinsics.areEqual(this.signature, authenticationToken.signature);
    }

    public final int hashCode() {
        return this.signature.hashCode() + ((this.claims.hashCode() + ((this.header.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(527, 31, this.token), 31, this.expectedNonce)) * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.token);
        dest.writeString(this.expectedNonce);
        dest.writeParcelable(this.header, i);
        dest.writeParcelable(this.claims, i);
        dest.writeString(this.signature);
    }

    public AuthenticationToken(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        Validate.notNullOrEmpty(string, "token");
        this.token = string;
        String string2 = parcel.readString();
        Validate.notNullOrEmpty(string2, "expectedNonce");
        this.expectedNonce = string2;
        Parcelable parcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (parcelable != null) {
            this.header = (AuthenticationTokenHeader) parcelable;
            Parcelable parcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (parcelable2 != null) {
                this.claims = (AuthenticationTokenClaims) parcelable2;
                String string3 = parcel.readString();
                Validate.notNullOrEmpty(string3, "signature");
                this.signature = string3;
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }
}
