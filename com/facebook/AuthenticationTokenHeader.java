package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.fragment.app.FragmentState;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.internal.Validate;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AuthenticationTokenHeader implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new FragmentState.AnonymousClass1(23);
    public final String alg;
    public final String kid;
    public final String typ;

    public AuthenticationTokenHeader(String encodedHeaderString) {
        Intrinsics.checkNotNullParameter(encodedHeaderString, "encodedHeaderString");
        Validate.notEmpty(encodedHeaderString, "encodedHeaderString");
        byte[] decodedBytes = Base64.decode(encodedHeaderString, 0);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        Charset charset = Charsets.UTF_8;
        try {
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, charset));
            String alg = jSONObject.optString("alg");
            Intrinsics.checkNotNullExpressionValue(alg, "alg");
            boolean z = alg.length() > 0 && alg.equals("RS256");
            String strOptString = jSONObject.optString("kid");
            Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObj.optString(\"kid\")");
            boolean z2 = strOptString.length() > 0;
            String strOptString2 = jSONObject.optString("typ");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "jsonObj.optString(\"typ\")");
            boolean z3 = strOptString2.length() > 0;
            if (z && z2 && z3) {
                byte[] decodedBytes2 = Base64.decode(encodedHeaderString, 0);
                Intrinsics.checkNotNullExpressionValue(decodedBytes2, "decodedBytes");
                JSONObject jSONObject2 = new JSONObject(new String(decodedBytes2, charset));
                String string = jSONObject2.getString("alg");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"alg\")");
                this.alg = string;
                String string2 = jSONObject2.getString("typ");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"typ\")");
                this.typ = string2;
                String string3 = jSONObject2.getString("kid");
                Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(\"kid\")");
                this.kid = string3;
                return;
            }
        } catch (JSONException unused) {
        }
        throw new IllegalArgumentException("Invalid Header");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        return Intrinsics.areEqual(this.alg, authenticationTokenHeader.alg) && Intrinsics.areEqual(this.typ, authenticationTokenHeader.typ) && Intrinsics.areEqual(this.kid, authenticationTokenHeader.kid);
    }

    public final int hashCode() {
        return this.kid.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(527, 31, this.alg), 31, this.typ);
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put("typ", this.typ);
        jSONObject.put("kid", this.kid);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "headerJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.alg);
        dest.writeString(this.typ);
        dest.writeString(this.kid);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        Validate.notNullOrEmpty(string, "alg");
        this.alg = string;
        String string2 = parcel.readString();
        Validate.notNullOrEmpty(string2, "typ");
        this.typ = string2;
        String string3 = parcel.readString();
        Validate.notNullOrEmpty(string3, "kid");
        this.kid = string3;
    }
}
