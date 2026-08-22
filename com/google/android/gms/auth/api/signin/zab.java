package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zab implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zab(int i) {
        this.$r8$classId = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString = null;
                String strCreateString2 = null;
                String strCreateString3 = null;
                String strCreateString4 = null;
                Uri uri = null;
                String strCreateString5 = null;
                String strCreateString6 = null;
                ArrayList arrayListCreateTypedList = null;
                String strCreateString7 = null;
                String strCreateString8 = null;
                long j = 0;
                int i = 0;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i2 = parcel.readInt();
                    switch ((char) i2) {
                        case 1:
                            i = Protocol.Companion.readInt(parcel, i2);
                            break;
                        case 2:
                            strCreateString = Protocol.Companion.createString(parcel, i2);
                            break;
                        case 3:
                            strCreateString2 = Protocol.Companion.createString(parcel, i2);
                            break;
                        case 4:
                            strCreateString3 = Protocol.Companion.createString(parcel, i2);
                            break;
                        case 5:
                            strCreateString4 = Protocol.Companion.createString(parcel, i2);
                            break;
                        case 6:
                            uri = (Uri) Protocol.Companion.createParcelable(parcel, i2, Uri.CREATOR);
                            break;
                        case 7:
                            strCreateString5 = Protocol.Companion.createString(parcel, i2);
                            break;
                        case '\b':
                            j = Protocol.Companion.readLong(parcel, i2);
                            break;
                        case '\t':
                            strCreateString6 = Protocol.Companion.createString(parcel, i2);
                            break;
                        case '\n':
                            arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i2, Scope.CREATOR);
                            break;
                        case 11:
                            strCreateString7 = Protocol.Companion.createString(parcel, i2);
                            break;
                        case '\f':
                            strCreateString8 = Protocol.Companion.createString(parcel, i2);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i2);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
                return new GoogleSignInAccount(i, strCreateString, strCreateString2, strCreateString3, strCreateString4, uri, strCreateString5, j, strCreateString6, arrayListCreateTypedList, strCreateString7, strCreateString8);
            case 1:
                int iValidateObjectHeader2 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList2 = null;
                ArrayList arrayListCreateTypedList3 = null;
                Account account = null;
                String strCreateString9 = null;
                String strCreateString10 = null;
                String strCreateString11 = null;
                int i3 = 0;
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i4 = parcel.readInt();
                    switch ((char) i4) {
                        case 1:
                            i3 = Protocol.Companion.readInt(parcel, i4);
                            break;
                        case 2:
                            arrayListCreateTypedList3 = Protocol.Companion.createTypedList(parcel, i4, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) Protocol.Companion.createParcelable(parcel, i4, Account.CREATOR);
                            break;
                        case 4:
                            z = Protocol.Companion.readBoolean(parcel, i4);
                            break;
                        case 5:
                            z2 = Protocol.Companion.readBoolean(parcel, i4);
                            break;
                        case 6:
                            z3 = Protocol.Companion.readBoolean(parcel, i4);
                            break;
                        case 7:
                            strCreateString9 = Protocol.Companion.createString(parcel, i4);
                            break;
                        case '\b':
                            strCreateString10 = Protocol.Companion.createString(parcel, i4);
                            break;
                        case '\t':
                            arrayListCreateTypedList2 = Protocol.Companion.createTypedList(parcel, i4, GoogleSignInOptionsExtensionParcelable.CREATOR);
                            break;
                        case '\n':
                            strCreateString11 = Protocol.Companion.createString(parcel, i4);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i4);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader2);
                return new GoogleSignInOptions(i3, arrayListCreateTypedList3, account, z, z2, z3, strCreateString9, strCreateString10, GoogleSignInOptions.zam(arrayListCreateTypedList2), strCreateString11);
            default:
                int iValidateObjectHeader3 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString12 = "";
                GoogleSignInAccount googleSignInAccount = null;
                String strCreateString13 = "";
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i5 = parcel.readInt();
                    char c = (char) i5;
                    if (c == 4) {
                        strCreateString12 = Protocol.Companion.createString(parcel, i5);
                    } else if (c == 7) {
                        googleSignInAccount = (GoogleSignInAccount) Protocol.Companion.createParcelable(parcel, i5, GoogleSignInAccount.CREATOR);
                    } else if (c != '\b') {
                        Protocol.Companion.skipUnknownField(parcel, i5);
                    } else {
                        strCreateString13 = Protocol.Companion.createString(parcel, i5);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader3);
                SignInAccount signInAccount = new SignInAccount();
                signInAccount.zbc = googleSignInAccount;
                zzah.checkNotEmpty(strCreateString12, "8.3 and 8.4 SDKs require non-null email");
                signInAccount.zba = strCreateString12;
                zzah.checkNotEmpty(strCreateString13, "8.3 and 8.4 SDKs require non-null userId");
                signInAccount.zbb = strCreateString13;
                return signInAccount;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new GoogleSignInAccount[i];
            case 1:
                return new GoogleSignInOptions[i];
            default:
                return new SignInAccount[i];
        }
    }
}
