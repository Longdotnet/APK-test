package com.google.android.gms.auth;

import android.accounts.Account;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzn;
import com.google.android.gms.auth.api.accounttransfer.zzr;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.auth.api.accounttransfer.zzv;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.SignInPassword;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.HashSet;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zza(int i) {
        this.$r8$classId = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                long j = 0;
                String strCreateString = null;
                String strCreateString2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i4 = parcel.readInt();
                    switch ((char) i4) {
                        case 1:
                            i = Protocol.Companion.readInt(parcel, i4);
                            break;
                        case 2:
                            j = Protocol.Companion.readLong(parcel, i4);
                            break;
                        case 3:
                            strCreateString = Protocol.Companion.createString(parcel, i4);
                            break;
                        case 4:
                            i2 = Protocol.Companion.readInt(parcel, i4);
                            break;
                        case 5:
                            i3 = Protocol.Companion.readInt(parcel, i4);
                            break;
                        case 6:
                            strCreateString2 = Protocol.Companion.createString(parcel, i4);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i4);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
                return new AccountChangeEvent(i, j, strCreateString, i2, i3, strCreateString2);
            case 1:
                int iValidateObjectHeader2 = Protocol.Companion.validateObjectHeader(parcel);
                HashSet hashSet = new HashSet();
                int i5 = 0;
                ArrayList arrayListCreateTypedList = null;
                zzr zzrVar = null;
                int i6 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i7 = parcel.readInt();
                    char c = (char) i7;
                    if (c == 1) {
                        i6 = Protocol.Companion.readInt(parcel, i7);
                        hashSet.add(1);
                    } else if (c == 2) {
                        arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i7, zzt.CREATOR);
                        hashSet.add(2);
                    } else if (c == 3) {
                        i5 = Protocol.Companion.readInt(parcel, i7);
                        hashSet.add(3);
                    } else if (c != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i7);
                    } else {
                        zzrVar = (zzr) Protocol.Companion.createParcelable(parcel, i7, zzr.CREATOR);
                        hashSet.add(4);
                    }
                }
                if (parcel.dataPosition() == iValidateObjectHeader2) {
                    return new zzn(hashSet, i6, arrayListCreateTypedList, i5, zzrVar);
                }
                StringBuilder sb = new StringBuilder(37);
                sb.append("Overread allowed size end=");
                sb.append(iValidateObjectHeader2);
                throw new SafeParcelReader$ParseException(sb.toString(), parcel);
            case 2:
                int iValidateObjectHeader3 = Protocol.Companion.validateObjectHeader(parcel);
                int i8 = 0;
                ArrayList arrayListCreateStringList = null;
                ArrayList arrayListCreateStringList2 = null;
                ArrayList arrayListCreateStringList3 = null;
                ArrayList arrayListCreateStringList4 = null;
                ArrayList arrayListCreateStringList5 = null;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i9 = parcel.readInt();
                    switch ((char) i9) {
                        case 1:
                            i8 = Protocol.Companion.readInt(parcel, i9);
                            break;
                        case 2:
                            arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i9);
                            break;
                        case 3:
                            arrayListCreateStringList2 = Protocol.Companion.createStringList(parcel, i9);
                            break;
                        case 4:
                            arrayListCreateStringList3 = Protocol.Companion.createStringList(parcel, i9);
                            break;
                        case 5:
                            arrayListCreateStringList4 = Protocol.Companion.createStringList(parcel, i9);
                            break;
                        case 6:
                            arrayListCreateStringList5 = Protocol.Companion.createStringList(parcel, i9);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i9);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new zzr(i8, arrayListCreateStringList, arrayListCreateStringList2, arrayListCreateStringList3, arrayListCreateStringList4, arrayListCreateStringList5);
            case 3:
                int iValidateObjectHeader4 = Protocol.Companion.validateObjectHeader(parcel);
                HashSet hashSet2 = new HashSet();
                zzv zzvVar = null;
                String strCreateString3 = null;
                String strCreateString4 = null;
                String strCreateString5 = null;
                int i10 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i11 = parcel.readInt();
                    char c2 = (char) i11;
                    if (c2 == 1) {
                        i10 = Protocol.Companion.readInt(parcel, i11);
                        hashSet2.add(1);
                    } else if (c2 == 2) {
                        zzvVar = (zzv) Protocol.Companion.createParcelable(parcel, i11, zzv.CREATOR);
                        hashSet2.add(2);
                    } else if (c2 == 3) {
                        strCreateString3 = Protocol.Companion.createString(parcel, i11);
                        hashSet2.add(3);
                    } else if (c2 == 4) {
                        strCreateString4 = Protocol.Companion.createString(parcel, i11);
                        hashSet2.add(4);
                    } else if (c2 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i11);
                    } else {
                        strCreateString5 = Protocol.Companion.createString(parcel, i11);
                        hashSet2.add(5);
                    }
                }
                if (parcel.dataPosition() == iValidateObjectHeader4) {
                    return new zzt(hashSet2, i10, zzvVar, strCreateString3, strCreateString4, strCreateString5);
                }
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Overread allowed size end=");
                sb2.append(iValidateObjectHeader4);
                throw new SafeParcelReader$ParseException(sb2.toString(), parcel);
            case 4:
                int iValidateObjectHeader5 = Protocol.Companion.validateObjectHeader(parcel);
                HashSet hashSet3 = new HashSet();
                int i12 = 0;
                String strCreateString6 = null;
                byte[] bArrCreateByteArray = null;
                PendingIntent pendingIntent = null;
                DeviceMetaData deviceMetaData = null;
                int i13 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i14 = parcel.readInt();
                    switch ((char) i14) {
                        case 1:
                            i13 = Protocol.Companion.readInt(parcel, i14);
                            hashSet3.add(1);
                            break;
                        case 2:
                            strCreateString6 = Protocol.Companion.createString(parcel, i14);
                            hashSet3.add(2);
                            break;
                        case 3:
                            i12 = Protocol.Companion.readInt(parcel, i14);
                            hashSet3.add(3);
                            break;
                        case 4:
                            bArrCreateByteArray = Protocol.Companion.createByteArray(parcel, i14);
                            hashSet3.add(4);
                            break;
                        case 5:
                            pendingIntent = (PendingIntent) Protocol.Companion.createParcelable(parcel, i14, PendingIntent.CREATOR);
                            hashSet3.add(5);
                            break;
                        case 6:
                            deviceMetaData = (DeviceMetaData) Protocol.Companion.createParcelable(parcel, i14, DeviceMetaData.CREATOR);
                            hashSet3.add(6);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i14);
                            break;
                    }
                }
                if (parcel.dataPosition() == iValidateObjectHeader5) {
                    return new zzv(hashSet3, i13, strCreateString6, i12, bArrCreateByteArray, pendingIntent, deviceMetaData);
                }
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Overread allowed size end=");
                sb3.append(iValidateObjectHeader5);
                throw new SafeParcelReader$ParseException(sb3.toString(), parcel);
            case 5:
                int iValidateObjectHeader6 = Protocol.Companion.validateObjectHeader(parcel);
                int i15 = 0;
                boolean z = false;
                boolean z2 = false;
                long j2 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i16 = parcel.readInt();
                    char c3 = (char) i16;
                    if (c3 == 1) {
                        i15 = Protocol.Companion.readInt(parcel, i16);
                    } else if (c3 == 2) {
                        z = Protocol.Companion.readBoolean(parcel, i16);
                    } else if (c3 == 3) {
                        j2 = Protocol.Companion.readLong(parcel, i16);
                    } else if (c3 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i16);
                    } else {
                        z2 = Protocol.Companion.readBoolean(parcel, i16);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader6);
                return new DeviceMetaData(i15, z, j2, z2);
            case 6:
                int iValidateObjectHeader7 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString7 = null;
                String strCreateString8 = null;
                Uri uri = null;
                ArrayList arrayListCreateTypedList2 = null;
                String strCreateString9 = null;
                String strCreateString10 = null;
                String strCreateString11 = null;
                String strCreateString12 = null;
                while (parcel.dataPosition() < iValidateObjectHeader7) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            strCreateString7 = Protocol.Companion.createString(parcel, i17);
                            break;
                        case 2:
                            strCreateString8 = Protocol.Companion.createString(parcel, i17);
                            break;
                        case 3:
                            uri = (Uri) Protocol.Companion.createParcelable(parcel, i17, Uri.CREATOR);
                            break;
                        case 4:
                            arrayListCreateTypedList2 = Protocol.Companion.createTypedList(parcel, i17, IdToken.CREATOR);
                            break;
                        case 5:
                            strCreateString9 = Protocol.Companion.createString(parcel, i17);
                            break;
                        case 6:
                            strCreateString10 = Protocol.Companion.createString(parcel, i17);
                            break;
                        case 7:
                        case '\b':
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i17);
                            break;
                        case '\t':
                            strCreateString11 = Protocol.Companion.createString(parcel, i17);
                            break;
                        case '\n':
                            strCreateString12 = Protocol.Companion.createString(parcel, i17);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader7);
                return new Credential(strCreateString7, strCreateString8, uri, arrayListCreateTypedList2, strCreateString9, strCreateString10, strCreateString11, strCreateString12);
            case 7:
                int iValidateObjectHeader8 = Protocol.Companion.validateObjectHeader(parcel);
                int i18 = 0;
                int i19 = 0;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                while (parcel.dataPosition() < iValidateObjectHeader8) {
                    int i20 = parcel.readInt();
                    char c4 = (char) i20;
                    if (c4 == 1) {
                        z3 = Protocol.Companion.readBoolean(parcel, i20);
                    } else if (c4 == 2) {
                        z4 = Protocol.Companion.readBoolean(parcel, i20);
                    } else if (c4 == 3) {
                        z5 = Protocol.Companion.readBoolean(parcel, i20);
                    } else if (c4 == 4) {
                        i19 = Protocol.Companion.readInt(parcel, i20);
                    } else if (c4 != 1000) {
                        Protocol.Companion.skipUnknownField(parcel, i20);
                    } else {
                        i18 = Protocol.Companion.readInt(parcel, i20);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader8);
                return new CredentialPickerConfig(i18, i19, z3, z4, z5);
            case 8:
                int iValidateObjectHeader9 = Protocol.Companion.validateObjectHeader(parcel);
                int i21 = 0;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                String[] strArrCreateStringArray = null;
                CredentialPickerConfig credentialPickerConfig = null;
                CredentialPickerConfig credentialPickerConfig2 = null;
                String strCreateString13 = null;
                String strCreateString14 = null;
                while (parcel.dataPosition() < iValidateObjectHeader9) {
                    int i22 = parcel.readInt();
                    char c5 = (char) i22;
                    if (c5 != 1000) {
                        switch (c5) {
                            case 1:
                                z6 = Protocol.Companion.readBoolean(parcel, i22);
                                break;
                            case 2:
                                strArrCreateStringArray = Protocol.Companion.createStringArray(parcel, i22);
                                break;
                            case 3:
                                credentialPickerConfig = (CredentialPickerConfig) Protocol.Companion.createParcelable(parcel, i22, CredentialPickerConfig.CREATOR);
                                break;
                            case 4:
                                credentialPickerConfig2 = (CredentialPickerConfig) Protocol.Companion.createParcelable(parcel, i22, CredentialPickerConfig.CREATOR);
                                break;
                            case 5:
                                z7 = Protocol.Companion.readBoolean(parcel, i22);
                                break;
                            case 6:
                                strCreateString13 = Protocol.Companion.createString(parcel, i22);
                                break;
                            case 7:
                                strCreateString14 = Protocol.Companion.createString(parcel, i22);
                                break;
                            case '\b':
                                z8 = Protocol.Companion.readBoolean(parcel, i22);
                                break;
                            default:
                                Protocol.Companion.skipUnknownField(parcel, i22);
                                break;
                        }
                    } else {
                        i21 = Protocol.Companion.readInt(parcel, i22);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader9);
                return new CredentialRequest(i21, z6, strArrCreateStringArray, credentialPickerConfig, credentialPickerConfig2, z7, strCreateString13, strCreateString14, z8);
            case 9:
                int iValidateObjectHeader10 = Protocol.Companion.validateObjectHeader(parcel);
                int i23 = 0;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                CredentialPickerConfig credentialPickerConfig3 = null;
                String[] strArrCreateStringArray2 = null;
                String strCreateString15 = null;
                String strCreateString16 = null;
                while (parcel.dataPosition() < iValidateObjectHeader10) {
                    int i24 = parcel.readInt();
                    char c6 = (char) i24;
                    if (c6 != 1000) {
                        switch (c6) {
                            case 1:
                                credentialPickerConfig3 = (CredentialPickerConfig) Protocol.Companion.createParcelable(parcel, i24, CredentialPickerConfig.CREATOR);
                                break;
                            case 2:
                                z9 = Protocol.Companion.readBoolean(parcel, i24);
                                break;
                            case 3:
                                z10 = Protocol.Companion.readBoolean(parcel, i24);
                                break;
                            case 4:
                                strArrCreateStringArray2 = Protocol.Companion.createStringArray(parcel, i24);
                                break;
                            case 5:
                                z11 = Protocol.Companion.readBoolean(parcel, i24);
                                break;
                            case 6:
                                strCreateString15 = Protocol.Companion.createString(parcel, i24);
                                break;
                            case 7:
                                strCreateString16 = Protocol.Companion.createString(parcel, i24);
                                break;
                            default:
                                Protocol.Companion.skipUnknownField(parcel, i24);
                                break;
                        }
                    } else {
                        i23 = Protocol.Companion.readInt(parcel, i24);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader10);
                return new HintRequest(i23, credentialPickerConfig3, z9, z10, strArrCreateStringArray2, z11, strCreateString15, strCreateString16);
            case 10:
                int iValidateObjectHeader11 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString17 = null;
                String strCreateString18 = null;
                while (parcel.dataPosition() < iValidateObjectHeader11) {
                    int i25 = parcel.readInt();
                    char c7 = (char) i25;
                    if (c7 == 1) {
                        strCreateString17 = Protocol.Companion.createString(parcel, i25);
                    } else if (c7 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i25);
                    } else {
                        strCreateString18 = Protocol.Companion.createString(parcel, i25);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader11);
                return new IdToken(strCreateString17, strCreateString18);
            case 11:
                int iValidateObjectHeader12 = Protocol.Companion.validateObjectHeader(parcel);
                BeginSignInRequest.PasswordRequestOptions passwordRequestOptions = null;
                BeginSignInRequest.GoogleIdTokenRequestOptions googleIdTokenRequestOptions = null;
                String strCreateString19 = null;
                boolean z12 = false;
                int i26 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader12) {
                    int i27 = parcel.readInt();
                    char c8 = (char) i27;
                    if (c8 == 1) {
                        passwordRequestOptions = (BeginSignInRequest.PasswordRequestOptions) Protocol.Companion.createParcelable(parcel, i27, BeginSignInRequest.PasswordRequestOptions.CREATOR);
                    } else if (c8 == 2) {
                        googleIdTokenRequestOptions = (BeginSignInRequest.GoogleIdTokenRequestOptions) Protocol.Companion.createParcelable(parcel, i27, BeginSignInRequest.GoogleIdTokenRequestOptions.CREATOR);
                    } else if (c8 == 3) {
                        strCreateString19 = Protocol.Companion.createString(parcel, i27);
                    } else if (c8 == 4) {
                        z12 = Protocol.Companion.readBoolean(parcel, i27);
                    } else if (c8 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i27);
                    } else {
                        i26 = Protocol.Companion.readInt(parcel, i27);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader12);
                return new BeginSignInRequest(passwordRequestOptions, googleIdTokenRequestOptions, strCreateString19, z12, i26);
            case 12:
                int iValidateObjectHeader13 = Protocol.Companion.validateObjectHeader(parcel);
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader13) {
                    int i28 = parcel.readInt();
                    if (((char) i28) != 1) {
                        Protocol.Companion.skipUnknownField(parcel, i28);
                    } else {
                        pendingIntent2 = (PendingIntent) Protocol.Companion.createParcelable(parcel, i28, PendingIntent.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader13);
                return new BeginSignInResult(pendingIntent2);
            case 13:
                int iValidateObjectHeader14 = Protocol.Companion.validateObjectHeader(parcel);
                int i29 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader14) {
                    int i30 = parcel.readInt();
                    if (((char) i30) != 1) {
                        Protocol.Companion.skipUnknownField(parcel, i30);
                    } else {
                        i29 = Protocol.Companion.readInt(parcel, i30);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader14);
                return new GetPhoneNumberHintIntentRequest(i29);
            case 14:
                int iValidateObjectHeader15 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString20 = null;
                String strCreateString21 = null;
                String strCreateString22 = null;
                String strCreateString23 = null;
                boolean z13 = false;
                int i31 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader15) {
                    int i32 = parcel.readInt();
                    switch ((char) i32) {
                        case 1:
                            strCreateString20 = Protocol.Companion.createString(parcel, i32);
                            break;
                        case 2:
                            strCreateString21 = Protocol.Companion.createString(parcel, i32);
                            break;
                        case 3:
                            strCreateString22 = Protocol.Companion.createString(parcel, i32);
                            break;
                        case 4:
                            strCreateString23 = Protocol.Companion.createString(parcel, i32);
                            break;
                        case 5:
                            z13 = Protocol.Companion.readBoolean(parcel, i32);
                            break;
                        case 6:
                            i31 = Protocol.Companion.readInt(parcel, i32);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i32);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader15);
                return new GetSignInIntentRequest(strCreateString20, strCreateString21, strCreateString22, strCreateString23, z13, i31);
            case 15:
                int iValidateObjectHeader16 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z14 = false;
                boolean z15 = false;
                boolean z16 = false;
                String strCreateString24 = null;
                String strCreateString25 = null;
                String strCreateString26 = null;
                ArrayList arrayListCreateStringList6 = null;
                while (parcel.dataPosition() < iValidateObjectHeader16) {
                    int i33 = parcel.readInt();
                    switch ((char) i33) {
                        case 1:
                            z14 = Protocol.Companion.readBoolean(parcel, i33);
                            break;
                        case 2:
                            strCreateString24 = Protocol.Companion.createString(parcel, i33);
                            break;
                        case 3:
                            strCreateString25 = Protocol.Companion.createString(parcel, i33);
                            break;
                        case 4:
                            z15 = Protocol.Companion.readBoolean(parcel, i33);
                            break;
                        case 5:
                            strCreateString26 = Protocol.Companion.createString(parcel, i33);
                            break;
                        case 6:
                            arrayListCreateStringList6 = Protocol.Companion.createStringList(parcel, i33);
                            break;
                        case 7:
                            z16 = Protocol.Companion.readBoolean(parcel, i33);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i33);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader16);
                return new BeginSignInRequest.GoogleIdTokenRequestOptions(z14, strCreateString24, strCreateString25, z15, strCreateString26, arrayListCreateStringList6, z16);
            case 16:
                int iValidateObjectHeader17 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z17 = false;
                while (parcel.dataPosition() < iValidateObjectHeader17) {
                    int i34 = parcel.readInt();
                    if (((char) i34) != 1) {
                        Protocol.Companion.skipUnknownField(parcel, i34);
                    } else {
                        z17 = Protocol.Companion.readBoolean(parcel, i34);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader17);
                return new BeginSignInRequest.PasswordRequestOptions(z17);
            case 17:
                int iValidateObjectHeader18 = Protocol.Companion.validateObjectHeader(parcel);
                PendingIntent pendingIntent3 = null;
                String strCreateString27 = null;
                String strCreateString28 = null;
                ArrayList arrayListCreateStringList7 = null;
                String strCreateString29 = null;
                int i35 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader18) {
                    int i36 = parcel.readInt();
                    switch ((char) i36) {
                        case 1:
                            pendingIntent3 = (PendingIntent) Protocol.Companion.createParcelable(parcel, i36, PendingIntent.CREATOR);
                            break;
                        case 2:
                            strCreateString27 = Protocol.Companion.createString(parcel, i36);
                            break;
                        case 3:
                            strCreateString28 = Protocol.Companion.createString(parcel, i36);
                            break;
                        case 4:
                            arrayListCreateStringList7 = Protocol.Companion.createStringList(parcel, i36);
                            break;
                        case 5:
                            strCreateString29 = Protocol.Companion.createString(parcel, i36);
                            break;
                        case 6:
                            i35 = Protocol.Companion.readInt(parcel, i36);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i36);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader18);
                return new SaveAccountLinkingTokenRequest(pendingIntent3, strCreateString27, strCreateString28, arrayListCreateStringList7, strCreateString29, i35);
            case 18:
                int iValidateObjectHeader19 = Protocol.Companion.validateObjectHeader(parcel);
                PendingIntent pendingIntent4 = null;
                while (parcel.dataPosition() < iValidateObjectHeader19) {
                    int i37 = parcel.readInt();
                    if (((char) i37) != 1) {
                        Protocol.Companion.skipUnknownField(parcel, i37);
                    } else {
                        pendingIntent4 = (PendingIntent) Protocol.Companion.createParcelable(parcel, i37, PendingIntent.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader19);
                return new SaveAccountLinkingTokenResult(pendingIntent4);
            case 19:
                int iValidateObjectHeader20 = Protocol.Companion.validateObjectHeader(parcel);
                SignInPassword signInPassword = null;
                int i38 = 0;
                String strCreateString30 = null;
                while (parcel.dataPosition() < iValidateObjectHeader20) {
                    int i39 = parcel.readInt();
                    char c9 = (char) i39;
                    if (c9 == 1) {
                        signInPassword = (SignInPassword) Protocol.Companion.createParcelable(parcel, i39, SignInPassword.CREATOR);
                    } else if (c9 == 2) {
                        strCreateString30 = Protocol.Companion.createString(parcel, i39);
                    } else if (c9 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i39);
                    } else {
                        i38 = Protocol.Companion.readInt(parcel, i39);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader20);
                return new SavePasswordRequest(signInPassword, strCreateString30, i38);
            case 20:
                int iValidateObjectHeader21 = Protocol.Companion.validateObjectHeader(parcel);
                PendingIntent pendingIntent5 = null;
                while (parcel.dataPosition() < iValidateObjectHeader21) {
                    int i40 = parcel.readInt();
                    if (((char) i40) != 1) {
                        Protocol.Companion.skipUnknownField(parcel, i40);
                    } else {
                        pendingIntent5 = (PendingIntent) Protocol.Companion.createParcelable(parcel, i40, PendingIntent.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader21);
                return new SavePasswordResult(pendingIntent5);
            case 21:
                int iValidateObjectHeader22 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString31 = null;
                String strCreateString32 = null;
                String strCreateString33 = null;
                String strCreateString34 = null;
                Uri uri2 = null;
                String strCreateString35 = null;
                String strCreateString36 = null;
                String strCreateString37 = null;
                while (parcel.dataPosition() < iValidateObjectHeader22) {
                    int i41 = parcel.readInt();
                    switch ((char) i41) {
                        case 1:
                            strCreateString31 = Protocol.Companion.createString(parcel, i41);
                            break;
                        case 2:
                            strCreateString32 = Protocol.Companion.createString(parcel, i41);
                            break;
                        case 3:
                            strCreateString33 = Protocol.Companion.createString(parcel, i41);
                            break;
                        case 4:
                            strCreateString34 = Protocol.Companion.createString(parcel, i41);
                            break;
                        case 5:
                            uri2 = (Uri) Protocol.Companion.createParcelable(parcel, i41, Uri.CREATOR);
                            break;
                        case 6:
                            strCreateString35 = Protocol.Companion.createString(parcel, i41);
                            break;
                        case 7:
                            strCreateString36 = Protocol.Companion.createString(parcel, i41);
                            break;
                        case '\b':
                            strCreateString37 = Protocol.Companion.createString(parcel, i41);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i41);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader22);
                return new SignInCredential(strCreateString31, strCreateString32, strCreateString33, strCreateString34, uri2, strCreateString35, strCreateString36, strCreateString37);
            case 22:
                int iValidateObjectHeader23 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString38 = null;
                String strCreateString39 = null;
                while (parcel.dataPosition() < iValidateObjectHeader23) {
                    int i42 = parcel.readInt();
                    char c10 = (char) i42;
                    if (c10 == 1) {
                        strCreateString38 = Protocol.Companion.createString(parcel, i42);
                    } else if (c10 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i42);
                    } else {
                        strCreateString39 = Protocol.Companion.createString(parcel, i42);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader23);
                return new SignInPassword(strCreateString38, strCreateString39);
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                int iValidateObjectHeader24 = Protocol.Companion.validateObjectHeader(parcel);
                int i43 = 0;
                int i44 = 0;
                String strCreateString40 = null;
                byte[] bArrCreateByteArray2 = null;
                Bundle bundleCreateBundle = null;
                long j3 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader24) {
                    int i45 = parcel.readInt();
                    char c11 = (char) i45;
                    if (c11 == 1) {
                        strCreateString40 = Protocol.Companion.createString(parcel, i45);
                    } else if (c11 == 2) {
                        i44 = Protocol.Companion.readInt(parcel, i45);
                    } else if (c11 == 3) {
                        j3 = Protocol.Companion.readLong(parcel, i45);
                    } else if (c11 == 4) {
                        bArrCreateByteArray2 = Protocol.Companion.createByteArray(parcel, i45);
                    } else if (c11 == 5) {
                        bundleCreateBundle = Protocol.Companion.createBundle(parcel, i45);
                    } else if (c11 != 1000) {
                        Protocol.Companion.skipUnknownField(parcel, i45);
                    } else {
                        i43 = Protocol.Companion.readInt(parcel, i45);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader24);
                return new ProxyRequest(i43, strCreateString40, i44, j3, bArrCreateByteArray2, bundleCreateBundle);
            case 24:
                int iValidateObjectHeader25 = Protocol.Companion.validateObjectHeader(parcel);
                int i46 = 0;
                int i47 = 0;
                int i48 = 0;
                PendingIntent pendingIntent6 = null;
                Bundle bundleCreateBundle2 = null;
                byte[] bArrCreateByteArray3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader25) {
                    int i49 = parcel.readInt();
                    char c12 = (char) i49;
                    if (c12 == 1) {
                        i47 = Protocol.Companion.readInt(parcel, i49);
                    } else if (c12 == 2) {
                        pendingIntent6 = (PendingIntent) Protocol.Companion.createParcelable(parcel, i49, PendingIntent.CREATOR);
                    } else if (c12 == 3) {
                        i48 = Protocol.Companion.readInt(parcel, i49);
                    } else if (c12 == 4) {
                        bundleCreateBundle2 = Protocol.Companion.createBundle(parcel, i49);
                    } else if (c12 == 5) {
                        bArrCreateByteArray3 = Protocol.Companion.createByteArray(parcel, i49);
                    } else if (c12 != 1000) {
                        Protocol.Companion.skipUnknownField(parcel, i49);
                    } else {
                        i46 = Protocol.Companion.readInt(parcel, i49);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader25);
                return new ProxyResponse(i46, i47, pendingIntent6, i48, bundleCreateBundle2, bArrCreateByteArray3);
            case 25:
                int iValidateObjectHeader26 = Protocol.Companion.validateObjectHeader(parcel);
                Bundle bundleCreateBundle3 = null;
                int i50 = 0;
                int i51 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader26) {
                    int i52 = parcel.readInt();
                    char c13 = (char) i52;
                    if (c13 == 1) {
                        i50 = Protocol.Companion.readInt(parcel, i52);
                    } else if (c13 == 2) {
                        i51 = Protocol.Companion.readInt(parcel, i52);
                    } else if (c13 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i52);
                    } else {
                        bundleCreateBundle3 = Protocol.Companion.createBundle(parcel, i52);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader26);
                return new GoogleSignInOptionsExtensionParcelable(i50, i51, bundleCreateBundle3);
            case 26:
                int iValidateObjectHeader27 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString41 = null;
                GoogleSignInOptions googleSignInOptions = null;
                while (parcel.dataPosition() < iValidateObjectHeader27) {
                    int i53 = parcel.readInt();
                    char c14 = (char) i53;
                    if (c14 == 2) {
                        strCreateString41 = Protocol.Companion.createString(parcel, i53);
                    } else if (c14 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i53);
                    } else {
                        googleSignInOptions = (GoogleSignInOptions) Protocol.Companion.createParcelable(parcel, i53, GoogleSignInOptions.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader27);
                return new SignInConfiguration(strCreateString41, googleSignInOptions);
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                int iValidateObjectHeader28 = Protocol.Companion.validateObjectHeader(parcel);
                int i54 = 0;
                String strCreateString42 = null;
                Account account = null;
                int i55 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader28) {
                    int i56 = parcel.readInt();
                    char c15 = (char) i56;
                    if (c15 == 1) {
                        i54 = Protocol.Companion.readInt(parcel, i56);
                    } else if (c15 == 2) {
                        i55 = Protocol.Companion.readInt(parcel, i56);
                    } else if (c15 == 3) {
                        strCreateString42 = Protocol.Companion.createString(parcel, i56);
                    } else if (c15 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i56);
                    } else {
                        account = (Account) Protocol.Companion.createParcelable(parcel, i56, Account.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader28);
                return new AccountChangeEventsRequest(i54, i55, strCreateString42, account);
            case 28:
                int iValidateObjectHeader29 = Protocol.Companion.validateObjectHeader(parcel);
                int i57 = 0;
                ArrayList arrayListCreateTypedList3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader29) {
                    int i58 = parcel.readInt();
                    char c16 = (char) i58;
                    if (c16 == 1) {
                        i57 = Protocol.Companion.readInt(parcel, i58);
                    } else if (c16 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i58);
                    } else {
                        arrayListCreateTypedList3 = Protocol.Companion.createTypedList(parcel, i58, AccountChangeEvent.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader29);
                return new AccountChangeEventsResponse(arrayListCreateTypedList3, i57);
            default:
                int iValidateObjectHeader30 = Protocol.Companion.validateObjectHeader(parcel);
                int i59 = 0;
                ParcelFileDescriptor parcelFileDescriptor = null;
                int i60 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader30) {
                    int i61 = parcel.readInt();
                    char c17 = (char) i61;
                    if (c17 == 1) {
                        i59 = Protocol.Companion.readInt(parcel, i61);
                    } else if (c17 == 2) {
                        parcelFileDescriptor = (ParcelFileDescriptor) Protocol.Companion.createParcelable(parcel, i61, ParcelFileDescriptor.CREATOR);
                    } else if (c17 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i61);
                    } else {
                        i60 = Protocol.Companion.readInt(parcel, i61);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader30);
                return new BitmapTeleporter(i59, parcelFileDescriptor, i60);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new AccountChangeEvent[i];
            case 1:
                return new zzn[i];
            case 2:
                return new zzr[i];
            case 3:
                return new zzt[i];
            case 4:
                return new zzv[i];
            case 5:
                return new DeviceMetaData[i];
            case 6:
                return new Credential[i];
            case 7:
                return new CredentialPickerConfig[i];
            case 8:
                return new CredentialRequest[i];
            case 9:
                return new HintRequest[i];
            case 10:
                return new IdToken[i];
            case 11:
                return new BeginSignInRequest[i];
            case 12:
                return new BeginSignInResult[i];
            case 13:
                return new GetPhoneNumberHintIntentRequest[i];
            case 14:
                return new GetSignInIntentRequest[i];
            case 15:
                return new BeginSignInRequest.GoogleIdTokenRequestOptions[i];
            case 16:
                return new BeginSignInRequest.PasswordRequestOptions[i];
            case 17:
                return new SaveAccountLinkingTokenRequest[i];
            case 18:
                return new SaveAccountLinkingTokenResult[i];
            case 19:
                return new SavePasswordRequest[i];
            case 20:
                return new SavePasswordResult[i];
            case 21:
                return new SignInCredential[i];
            case 22:
                return new SignInPassword[i];
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                return new ProxyRequest[i];
            case 24:
                return new ProxyResponse[i];
            case 25:
                return new GoogleSignInOptionsExtensionParcelable[i];
            case 26:
                return new SignInConfiguration[i];
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return new AccountChangeEventsRequest[i];
            case 28:
                return new AccountChangeEventsResponse[i];
            default:
                return new BitmapTeleporter[i];
        }
    }
}
