package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FacebookRequestError implements Parcelable {
    public final Object batchRequestResult;
    public final int errorCode;
    public final String errorMessage;
    public final String errorType;
    public final String errorUserMessage;
    public final String errorUserTitle;
    public final FacebookException exception;
    public final int requestStatusCode;
    public final int subErrorCode;
    public static final GraphRequest.Companion Companion = new GraphRequest.Companion(4);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new FragmentState.AnonymousClass1(24);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class Category {
        public static final /* synthetic */ Category[] $VALUES;
        public static final Category LOGIN_RECOVERABLE;
        public static final Category OTHER;
        public static final Category TRANSIENT;

        static {
            Category category = new Category("LOGIN_RECOVERABLE", 0);
            LOGIN_RECOVERABLE = category;
            Category category2 = new Category("OTHER", 1);
            OTHER = category2;
            Category category3 = new Category("TRANSIENT", 2);
            TRANSIENT = category3;
            $VALUES = new Category[]{category, category2, category3};
        }

        public static Category valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (Category) Enum.valueOf(Category.class, value);
        }

        public static Category[] values() {
            return (Category[]) Arrays.copyOf($VALUES, 3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0030  */
    public FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, Object obj, FacebookException facebookException, boolean z) {
        Set set;
        Set set2;
        Set set3;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.batchRequestResult = obj;
        this.errorMessage = str2;
        GraphRequest.Companion companion = Companion;
        Category category = Category.OTHER;
        if (facebookException != null) {
            this.exception = facebookException;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            FacebookRequestErrorClassification errorClassification = companion.getErrorClassification();
            Category category2 = Category.TRANSIENT;
            if (z) {
                category = category2;
            } else {
                HashMap map = errorClassification.otherErrors;
                if (map == null || !map.containsKey(Integer.valueOf(i2)) || ((set3 = (Set) map.get(Integer.valueOf(i2))) != null && !set3.contains(Integer.valueOf(i3)))) {
                    HashMap map2 = errorClassification.loginRecoverableErrors;
                    if (map2 != null && map2.containsKey(Integer.valueOf(i2)) && ((set2 = (Set) map2.get(Integer.valueOf(i2))) == null || set2.contains(Integer.valueOf(i3)))) {
                        category = Category.LOGIN_RECOVERABLE;
                    } else {
                        HashMap map3 = errorClassification.transientErrors;
                        if (map3 != null && map3.containsKey(Integer.valueOf(i2)) && ((set = (Set) map3.get(Integer.valueOf(i2))) == null || set.contains(Integer.valueOf(i3)))) {
                            category = category2;
                        }
                    }
                }
            }
        }
        companion.getErrorClassification();
        int i4 = FacebookRequestErrorClassification.WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.exception;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    public final String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.requestStatusCode);
        out.writeInt(this.errorCode);
        out.writeInt(this.subErrorCode);
        out.writeString(this.errorType);
        out.writeString(getErrorMessage());
        out.writeString(this.errorUserTitle);
        out.writeString(this.errorUserMessage);
    }

    public FacebookRequestError(Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, false);
    }
}
