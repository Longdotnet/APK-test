package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.facebook.internal.Validate;
import com.google.android.gms.ads.jY.UUFMQdNK;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new FragmentState.AnonymousClass1(26);
    public final String firstName;
    public final String id;
    public final String lastName;
    public final Uri linkUri;
    public final String middleName;
    public final String name;
    public final Uri pictureUri;

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        this.pictureUri = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.id;
        return ((str5 == null && ((Profile) obj).id == null) || Intrinsics.areEqual(str5, ((Profile) obj).id)) && (((str = this.firstName) == null && ((Profile) obj).firstName == null) || Intrinsics.areEqual(str, ((Profile) obj).firstName)) && ((((str2 = this.middleName) == null && ((Profile) obj).middleName == null) || Intrinsics.areEqual(str2, ((Profile) obj).middleName)) && ((((str3 = this.lastName) == null && ((Profile) obj).lastName == null) || Intrinsics.areEqual(str3, ((Profile) obj).lastName)) && ((((str4 = this.name) == null && ((Profile) obj).name == null) || Intrinsics.areEqual(str4, ((Profile) obj).name)) && ((((uri = this.linkUri) == null && ((Profile) obj).linkUri == null) || Intrinsics.areEqual(uri, ((Profile) obj).linkUri)) && (((uri2 = this.pictureUri) == null && ((Profile) obj).pictureUri == null) || Intrinsics.areEqual(uri2, ((Profile) obj).pictureUri))))));
    }

    public final int hashCode() {
        String str = this.id;
        int iHashCode = 527 + (str != null ? str.hashCode() : 0);
        String str2 = this.firstName;
        if (str2 != null) {
            iHashCode = (iHashCode * 31) + str2.hashCode();
        }
        String str3 = this.middleName;
        if (str3 != null) {
            iHashCode = (iHashCode * 31) + str3.hashCode();
        }
        String str4 = this.lastName;
        if (str4 != null) {
            iHashCode = (iHashCode * 31) + str4.hashCode();
        }
        String str5 = this.name;
        if (str5 != null) {
            iHashCode = (iHashCode * 31) + str5.hashCode();
        }
        Uri uri = this.linkUri;
        if (uri != null) {
            iHashCode = (iHashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.pictureUri;
        return uri2 != null ? (iHashCode * 31) + uri2.hashCode() : iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.middleName);
        dest.writeString(this.lastName);
        dest.writeString(this.name);
        Uri uri = this.linkUri;
        dest.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.pictureUri;
        dest.writeString(uri2 != null ? uri2.toString() : null);
    }

    public Profile(JSONObject jSONObject) {
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString("first_name", null);
        this.middleName = jSONObject.optString("middle_name", null);
        this.lastName = jSONObject.optString(UUFMQdNK.aEJF, null);
        this.name = jSONObject.optString("name", null);
        String strOptString = jSONObject.optString("link_uri", null);
        this.linkUri = strOptString == null ? null : Uri.parse(strOptString);
        String strOptString2 = jSONObject.optString("picture_uri", null);
        this.pictureUri = strOptString2 != null ? Uri.parse(strOptString2) : null;
    }

    public Profile(Parcel parcel) {
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String string = parcel.readString();
        this.linkUri = string == null ? null : Uri.parse(string);
        String string2 = parcel.readString();
        this.pictureUri = string2 != null ? Uri.parse(string2) : null;
    }
}
