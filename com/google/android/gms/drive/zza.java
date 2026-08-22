package com.google.android.gms.drive;

import android.accounts.Account;
import android.app.PendingIntent;
import android.database.CursorWindow;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.internal.location.zzbe;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzbj;
import com.google.android.gms.location.zzbo;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zza(int i) {
        this.$r8$classId = i;
    }

    public static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i2 = getServiceRequest.zzc;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.zzd);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.zze);
        CloseableKt.writeString(parcel, 4, getServiceRequest.zzf, false);
        CloseableKt.writeIBinder(parcel, 5, getServiceRequest.zzg);
        CloseableKt.writeTypedArray(parcel, 6, getServiceRequest.zzh, i);
        CloseableKt.writeBundle(parcel, 7, getServiceRequest.zzi, false);
        CloseableKt.writeParcelable(parcel, 8, getServiceRequest.zzj, i, false);
        CloseableKt.writeTypedArray(parcel, 10, getServiceRequest.zzk, i);
        CloseableKt.writeTypedArray(parcel, 11, getServiceRequest.zzl, i);
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.zzm ? 1 : 0);
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.zzn);
        boolean z = getServiceRequest.zzo;
        CloseableKt.zzc(parcel, 14, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 15, getServiceRequest.zzp, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
                ParcelFileDescriptor parcelFileDescriptor = null;
                DriveId driveId = null;
                String strCreateString = null;
                int i = 0;
                int i2 = 0;
                boolean z = false;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i3 = parcel.readInt();
                    char c = (char) i3;
                    if (c == 2) {
                        parcelFileDescriptor = (ParcelFileDescriptor) Protocol.Companion.createParcelable(parcel, i3, ParcelFileDescriptor.CREATOR);
                    } else if (c == 3) {
                        i = Protocol.Companion.readInt(parcel, i3);
                    } else if (c == 4) {
                        i2 = Protocol.Companion.readInt(parcel, i3);
                    } else if (c == 5) {
                        driveId = (DriveId) Protocol.Companion.createParcelable(parcel, i3, DriveId.CREATOR);
                    } else if (c == 7) {
                        z = Protocol.Companion.readBoolean(parcel, i3);
                    } else if (c != '\b') {
                        Protocol.Companion.skipUnknownField(parcel, i3);
                    } else {
                        strCreateString = Protocol.Companion.createString(parcel, i3);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
                return new Contents(parcelFileDescriptor, i, i2, driveId, z, strCreateString);
            case 1:
                int iValidateObjectHeader2 = Protocol.Companion.validateObjectHeader(parcel);
                String[] strArrCreateStringArray = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundleCreateBundle = null;
                int i4 = 0;
                int i5 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i6 = parcel.readInt();
                    char c2 = (char) i6;
                    if (c2 == 1) {
                        strArrCreateStringArray = Protocol.Companion.createStringArray(parcel, i6);
                    } else if (c2 == 2) {
                        cursorWindowArr = (CursorWindow[]) Protocol.Companion.createTypedArray(parcel, i6, CursorWindow.CREATOR);
                    } else if (c2 == 3) {
                        i5 = Protocol.Companion.readInt(parcel, i6);
                    } else if (c2 == 4) {
                        bundleCreateBundle = Protocol.Companion.createBundle(parcel, i6);
                    } else if (c2 != 1000) {
                        Protocol.Companion.skipUnknownField(parcel, i6);
                    } else {
                        i4 = Protocol.Companion.readInt(parcel, i6);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader2);
                DataHolder dataHolder = new DataHolder(i4, strArrCreateStringArray, cursorWindowArr, i5, bundleCreateBundle);
                dataHolder.zab = new Bundle();
                int i7 = 0;
                while (true) {
                    String[] strArr = dataHolder.zag;
                    if (i7 >= strArr.length) {
                        CursorWindow[] cursorWindowArr2 = dataHolder.zah;
                        dataHolder.zac = new int[cursorWindowArr2.length];
                        int numRows = 0;
                        for (int i8 = 0; i8 < cursorWindowArr2.length; i8++) {
                            dataHolder.zac[i8] = numRows;
                            numRows += cursorWindowArr2[i8].getNumRows() - (numRows - cursorWindowArr2[i8].getStartPosition());
                        }
                        dataHolder.zad = numRows;
                        return dataHolder;
                    }
                    dataHolder.zab.putInt(strArr[i7], i7);
                    i7++;
                }
                break;
            case 2:
                int iValidateObjectHeader3 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString2 = null;
                int i9 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i10 = parcel.readInt();
                    char c3 = (char) i10;
                    if (c3 == 1) {
                        i9 = Protocol.Companion.readInt(parcel, i10);
                    } else if (c3 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i10);
                    } else {
                        strCreateString2 = Protocol.Companion.createString(parcel, i10);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new ClientIdentity(i9, strCreateString2);
            case 3:
                int iValidateObjectHeader4 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList = null;
                int i11 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i12 = parcel.readInt();
                    char c4 = (char) i12;
                    if (c4 == 1) {
                        i11 = Protocol.Companion.readInt(parcel, i12);
                    } else if (c4 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i12);
                    } else {
                        arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i12, MethodInvocation.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader4);
                return new TelemetryData(i11, arrayListCreateTypedList);
            case 4:
                int iValidateObjectHeader5 = Protocol.Companion.validateObjectHeader(parcel);
                int i13 = -1;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                String strCreateString3 = null;
                String strCreateString4 = null;
                long j = 0;
                long j2 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            i14 = Protocol.Companion.readInt(parcel, i18);
                            break;
                        case 2:
                            i15 = Protocol.Companion.readInt(parcel, i18);
                            break;
                        case 3:
                            i16 = Protocol.Companion.readInt(parcel, i18);
                            break;
                        case 4:
                            j = Protocol.Companion.readLong(parcel, i18);
                            break;
                        case 5:
                            j2 = Protocol.Companion.readLong(parcel, i18);
                            break;
                        case 6:
                            strCreateString3 = Protocol.Companion.createString(parcel, i18);
                            break;
                        case 7:
                            strCreateString4 = Protocol.Companion.createString(parcel, i18);
                            break;
                        case '\b':
                            i17 = Protocol.Companion.readInt(parcel, i18);
                            break;
                        case '\t':
                            i13 = Protocol.Companion.readInt(parcel, i18);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i18);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader5);
                return new MethodInvocation(i14, i15, i16, j, j2, strCreateString3, strCreateString4, i17, i13);
            case 5:
                int iValidateObjectHeader6 = Protocol.Companion.validateObjectHeader(parcel);
                Account account = null;
                int i19 = 0;
                int i20 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i21 = parcel.readInt();
                    char c5 = (char) i21;
                    if (c5 == 1) {
                        i19 = Protocol.Companion.readInt(parcel, i21);
                    } else if (c5 == 2) {
                        account = (Account) Protocol.Companion.createParcelable(parcel, i21, Account.CREATOR);
                    } else if (c5 == 3) {
                        i20 = Protocol.Companion.readInt(parcel, i21);
                    } else if (c5 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i21);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) Protocol.Companion.createParcelable(parcel, i21, GoogleSignInAccount.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader6);
                return new zat(i19, account, i20, googleSignInAccount);
            case 6:
                int iValidateObjectHeader7 = Protocol.Companion.validateObjectHeader(parcel);
                int i22 = 0;
                boolean z2 = false;
                boolean z3 = false;
                IBinder iBinder = null;
                ConnectionResult connectionResult = null;
                while (parcel.dataPosition() < iValidateObjectHeader7) {
                    int i23 = parcel.readInt();
                    char c6 = (char) i23;
                    if (c6 == 1) {
                        i22 = Protocol.Companion.readInt(parcel, i23);
                    } else if (c6 == 2) {
                        iBinder = Protocol.Companion.readIBinder(parcel, i23);
                    } else if (c6 == 3) {
                        connectionResult = (ConnectionResult) Protocol.Companion.createParcelable(parcel, i23, ConnectionResult.CREATOR);
                    } else if (c6 == 4) {
                        z2 = Protocol.Companion.readBoolean(parcel, i23);
                    } else if (c6 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i23);
                    } else {
                        z3 = Protocol.Companion.readBoolean(parcel, i23);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader7);
                return new zav(i22, iBinder, connectionResult, z2, z3);
            case 7:
                int iValidateObjectHeader8 = Protocol.Companion.validateObjectHeader(parcel);
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                boolean z4 = false;
                boolean z5 = false;
                while (parcel.dataPosition() < iValidateObjectHeader8) {
                    int i27 = parcel.readInt();
                    char c7 = (char) i27;
                    if (c7 == 1) {
                        i24 = Protocol.Companion.readInt(parcel, i27);
                    } else if (c7 == 2) {
                        z4 = Protocol.Companion.readBoolean(parcel, i27);
                    } else if (c7 == 3) {
                        z5 = Protocol.Companion.readBoolean(parcel, i27);
                    } else if (c7 == 4) {
                        i25 = Protocol.Companion.readInt(parcel, i27);
                    } else if (c7 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i27);
                    } else {
                        i26 = Protocol.Companion.readInt(parcel, i27);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader8);
                return new RootTelemetryConfiguration(i24, i25, i26, z4, z5);
            case 8:
                return new BinderWrapper(parcel);
            case 9:
                int iValidateObjectHeader9 = Protocol.Companion.validateObjectHeader(parcel);
                Bundle bundleCreateBundle2 = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                int i28 = 0;
                Feature[] featureArr = null;
                while (parcel.dataPosition() < iValidateObjectHeader9) {
                    int i29 = parcel.readInt();
                    char c8 = (char) i29;
                    if (c8 == 1) {
                        bundleCreateBundle2 = Protocol.Companion.createBundle(parcel, i29);
                    } else if (c8 == 2) {
                        featureArr = (Feature[]) Protocol.Companion.createTypedArray(parcel, i29, Feature.CREATOR);
                    } else if (c8 == 3) {
                        i28 = Protocol.Companion.readInt(parcel, i29);
                    } else if (c8 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i29);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) Protocol.Companion.createParcelable(parcel, i29, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader9);
                zzk zzkVar = new zzk();
                zzkVar.zza = bundleCreateBundle2;
                zzkVar.zzb = featureArr;
                zzkVar.zzc = i28;
                zzkVar.zzd = connectionTelemetryConfiguration;
                return zzkVar;
            case 10:
                int iValidateObjectHeader10 = Protocol.Companion.validateObjectHeader(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean z6 = false;
                boolean z7 = false;
                int i30 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader10) {
                    int i31 = parcel.readInt();
                    switch ((char) i31) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) Protocol.Companion.createParcelable(parcel, i31, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            z6 = Protocol.Companion.readBoolean(parcel, i31);
                            break;
                        case 3:
                            z7 = Protocol.Companion.readBoolean(parcel, i31);
                            break;
                        case 4:
                            iArrCreateIntArray = Protocol.Companion.createIntArray(parcel, i31);
                            break;
                        case 5:
                            i30 = Protocol.Companion.readInt(parcel, i31);
                            break;
                        case 6:
                            iArrCreateIntArray2 = Protocol.Companion.createIntArray(parcel, i31);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i31);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader10);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z6, z7, iArrCreateIntArray, i30, iArrCreateIntArray2);
            case 11:
                int iValidateObjectHeader11 = Protocol.Companion.validateObjectHeader(parcel);
                Scope[] scopeArr = GetServiceRequest.zza;
                Bundle bundle = new Bundle();
                Feature[] featureArr2 = GetServiceRequest.zzb;
                Feature[] featureArr3 = featureArr2;
                String strCreateString5 = null;
                IBinder iBinder2 = null;
                Account account2 = null;
                String strCreateString6 = null;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                boolean z8 = false;
                int i35 = 0;
                boolean z9 = false;
                while (parcel.dataPosition() < iValidateObjectHeader11) {
                    int i36 = parcel.readInt();
                    switch ((char) i36) {
                        case 1:
                            i32 = Protocol.Companion.readInt(parcel, i36);
                            break;
                        case 2:
                            i33 = Protocol.Companion.readInt(parcel, i36);
                            break;
                        case 3:
                            i34 = Protocol.Companion.readInt(parcel, i36);
                            break;
                        case 4:
                            strCreateString5 = Protocol.Companion.createString(parcel, i36);
                            break;
                        case 5:
                            iBinder2 = Protocol.Companion.readIBinder(parcel, i36);
                            break;
                        case 6:
                            scopeArr = (Scope[]) Protocol.Companion.createTypedArray(parcel, i36, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = Protocol.Companion.createBundle(parcel, i36);
                            break;
                        case '\b':
                            account2 = (Account) Protocol.Companion.createParcelable(parcel, i36, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i36);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) Protocol.Companion.createTypedArray(parcel, i36, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) Protocol.Companion.createTypedArray(parcel, i36, Feature.CREATOR);
                            break;
                        case '\f':
                            z8 = Protocol.Companion.readBoolean(parcel, i36);
                            break;
                        case '\r':
                            i35 = Protocol.Companion.readInt(parcel, i36);
                            break;
                        case 14:
                            z9 = Protocol.Companion.readBoolean(parcel, i36);
                            break;
                        case 15:
                            strCreateString6 = Protocol.Companion.createString(parcel, i36);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader11);
                return new GetServiceRequest(i32, i33, i34, strCreateString5, iBinder2, scopeArr, bundle, account2, featureArr2, featureArr3, z8, i35, z9, strCreateString6);
            case 12:
                int iValidateObjectHeader12 = Protocol.Companion.validateObjectHeader(parcel);
                StringToIntConverter stringToIntConverter = null;
                int i37 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader12) {
                    int i38 = parcel.readInt();
                    char c9 = (char) i38;
                    if (c9 == 1) {
                        i37 = Protocol.Companion.readInt(parcel, i38);
                    } else if (c9 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i38);
                    } else {
                        stringToIntConverter = (StringToIntConverter) Protocol.Companion.createParcelable(parcel, i38, StringToIntConverter.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader12);
                return new zaa(i37, stringToIntConverter);
            case 13:
                int iValidateObjectHeader13 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList2 = null;
                int i39 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader13) {
                    int i40 = parcel.readInt();
                    char c10 = (char) i40;
                    if (c10 == 1) {
                        i39 = Protocol.Companion.readInt(parcel, i40);
                    } else if (c10 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i40);
                    } else {
                        arrayListCreateTypedList2 = Protocol.Companion.createTypedList(parcel, i40, zac.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader13);
                return new StringToIntConverter(arrayListCreateTypedList2, i39);
            case 14:
                int iValidateObjectHeader14 = Protocol.Companion.validateObjectHeader(parcel);
                int i41 = 0;
                String strCreateString7 = null;
                int i42 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader14) {
                    int i43 = parcel.readInt();
                    char c11 = (char) i43;
                    if (c11 == 1) {
                        i41 = Protocol.Companion.readInt(parcel, i43);
                    } else if (c11 == 2) {
                        strCreateString7 = Protocol.Companion.createString(parcel, i43);
                    } else if (c11 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i43);
                    } else {
                        i42 = Protocol.Companion.readInt(parcel, i43);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader14);
                return new zac(i41, strCreateString7, i42);
            case 15:
                int iValidateObjectHeader15 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString8 = null;
                int i44 = 0;
                FastJsonResponse.Field field = null;
                while (parcel.dataPosition() < iValidateObjectHeader15) {
                    int i45 = parcel.readInt();
                    char c12 = (char) i45;
                    if (c12 == 1) {
                        i44 = Protocol.Companion.readInt(parcel, i45);
                    } else if (c12 == 2) {
                        strCreateString8 = Protocol.Companion.createString(parcel, i45);
                    } else if (c12 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i45);
                    } else {
                        field = (FastJsonResponse.Field) Protocol.Companion.createParcelable(parcel, i45, FastJsonResponse.Field.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader15);
                return new zam(field, strCreateString8, i44);
            case 16:
                int iValidateObjectHeader16 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList3 = null;
                int i46 = 0;
                String strCreateString9 = null;
                while (parcel.dataPosition() < iValidateObjectHeader16) {
                    int i47 = parcel.readInt();
                    char c13 = (char) i47;
                    if (c13 == 1) {
                        i46 = Protocol.Companion.readInt(parcel, i47);
                    } else if (c13 == 2) {
                        arrayListCreateTypedList3 = Protocol.Companion.createTypedList(parcel, i47, zal.CREATOR);
                    } else if (c13 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i47);
                    } else {
                        strCreateString9 = Protocol.Companion.createString(parcel, i47);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader16);
                return new zan(i46, strCreateString9, arrayListCreateTypedList3);
            case 17:
                int iValidateObjectHeader17 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString10 = null;
                int i48 = 0;
                ArrayList arrayListCreateTypedList4 = null;
                while (parcel.dataPosition() < iValidateObjectHeader17) {
                    int i49 = parcel.readInt();
                    char c14 = (char) i49;
                    if (c14 == 1) {
                        i48 = Protocol.Companion.readInt(parcel, i49);
                    } else if (c14 == 2) {
                        strCreateString10 = Protocol.Companion.createString(parcel, i49);
                    } else if (c14 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i49);
                    } else {
                        arrayListCreateTypedList4 = Protocol.Companion.createTypedList(parcel, i49, zam.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader17);
                return new zal(i48, strCreateString10, arrayListCreateTypedList4);
            case 18:
                int iValidateObjectHeader18 = Protocol.Companion.validateObjectHeader(parcel);
                int i50 = 0;
                Parcel parcel2 = null;
                zan zanVar = null;
                while (parcel.dataPosition() < iValidateObjectHeader18) {
                    int i51 = parcel.readInt();
                    char c15 = (char) i51;
                    if (c15 == 1) {
                        i50 = Protocol.Companion.readInt(parcel, i51);
                    } else if (c15 == 2) {
                        int size = Protocol.Companion.readSize(parcel, i51);
                        int iDataPosition = parcel.dataPosition();
                        if (size == 0) {
                            parcel2 = null;
                        } else {
                            Parcel parcelObtain = Parcel.obtain();
                            parcelObtain.appendFrom(parcel, iDataPosition, size);
                            parcel.setDataPosition(iDataPosition + size);
                            parcel2 = parcelObtain;
                        }
                    } else if (c15 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i51);
                    } else {
                        zanVar = (zan) Protocol.Companion.createParcelable(parcel, i51, zan.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader18);
                return new SafeParcelResponse(i50, parcel2, zanVar);
            case 19:
                int iValidateObjectHeader19 = Protocol.Companion.validateObjectHeader(parcel);
                PendingIntent pendingIntent = null;
                int i52 = 0;
                int i53 = 0;
                String strCreateString11 = null;
                while (parcel.dataPosition() < iValidateObjectHeader19) {
                    int i54 = parcel.readInt();
                    char c16 = (char) i54;
                    if (c16 == 1) {
                        i52 = Protocol.Companion.readInt(parcel, i54);
                    } else if (c16 == 2) {
                        i53 = Protocol.Companion.readInt(parcel, i54);
                    } else if (c16 == 3) {
                        pendingIntent = (PendingIntent) Protocol.Companion.createParcelable(parcel, i54, PendingIntent.CREATOR);
                    } else if (c16 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i54);
                    } else {
                        strCreateString11 = Protocol.Companion.createString(parcel, i54);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader19);
                return new ConnectionResult(i52, i53, pendingIntent, strCreateString11);
            case 20:
                int iValidateObjectHeader20 = Protocol.Companion.validateObjectHeader(parcel);
                long j3 = -1;
                int i55 = 0;
                String strCreateString12 = null;
                while (parcel.dataPosition() < iValidateObjectHeader20) {
                    int i56 = parcel.readInt();
                    char c17 = (char) i56;
                    if (c17 == 1) {
                        strCreateString12 = Protocol.Companion.createString(parcel, i56);
                    } else if (c17 == 2) {
                        i55 = Protocol.Companion.readInt(parcel, i56);
                    } else if (c17 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i56);
                    } else {
                        j3 = Protocol.Companion.readLong(parcel, i56);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader20);
                return new Feature(i55, j3, strCreateString12);
            case 21:
                int iValidateObjectHeader21 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                String strCreateString13 = null;
                IBinder iBinder3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader21) {
                    int i57 = parcel.readInt();
                    switch ((char) i57) {
                        case 1:
                            strCreateString13 = Protocol.Companion.createString(parcel, i57);
                            break;
                        case 2:
                            z10 = Protocol.Companion.readBoolean(parcel, i57);
                            break;
                        case 3:
                            z11 = Protocol.Companion.readBoolean(parcel, i57);
                            break;
                        case 4:
                            iBinder3 = Protocol.Companion.readIBinder(parcel, i57);
                            break;
                        case 5:
                            z12 = Protocol.Companion.readBoolean(parcel, i57);
                            break;
                        case 6:
                            z13 = Protocol.Companion.readBoolean(parcel, i57);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i57);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader21);
                return new zzo(strCreateString13, z10, z11, iBinder3, z12, z13);
            case 22:
                int iValidateObjectHeader22 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z14 = false;
                int i58 = 0;
                String strCreateString14 = null;
                int i59 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader22) {
                    int i60 = parcel.readInt();
                    char c18 = (char) i60;
                    if (c18 == 1) {
                        z14 = Protocol.Companion.readBoolean(parcel, i60);
                    } else if (c18 == 2) {
                        strCreateString14 = Protocol.Companion.createString(parcel, i60);
                    } else if (c18 == 3) {
                        i59 = Protocol.Companion.readInt(parcel, i60);
                    } else if (c18 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i60);
                    } else {
                        i58 = Protocol.Companion.readInt(parcel, i60);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader22);
                return new zzq(z14, strCreateString14, i59, i58);
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                int iValidateObjectHeader23 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z15 = false;
                String strCreateString15 = null;
                IBinder iBinder4 = null;
                boolean z16 = false;
                while (parcel.dataPosition() < iValidateObjectHeader23) {
                    int i61 = parcel.readInt();
                    char c19 = (char) i61;
                    if (c19 == 1) {
                        strCreateString15 = Protocol.Companion.createString(parcel, i61);
                    } else if (c19 == 2) {
                        iBinder4 = Protocol.Companion.readIBinder(parcel, i61);
                    } else if (c19 == 3) {
                        z15 = Protocol.Companion.readBoolean(parcel, i61);
                    } else if (c19 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i61);
                    } else {
                        z16 = Protocol.Companion.readBoolean(parcel, i61);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader23);
                return new zzs(strCreateString15, iBinder4, z15, z16);
            case 24:
                int iValidateObjectHeader24 = Protocol.Companion.validateObjectHeader(parcel);
                int i62 = -1;
                long j4 = 0;
                long j5 = 0;
                String strCreateString16 = null;
                while (parcel.dataPosition() < iValidateObjectHeader24) {
                    int i63 = parcel.readInt();
                    char c20 = (char) i63;
                    if (c20 == 2) {
                        strCreateString16 = Protocol.Companion.createString(parcel, i63);
                    } else if (c20 == 3) {
                        j4 = Protocol.Companion.readLong(parcel, i63);
                    } else if (c20 == 4) {
                        j5 = Protocol.Companion.readLong(parcel, i63);
                    } else if (c20 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i63);
                    } else {
                        i62 = Protocol.Companion.readInt(parcel, i63);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader24);
                return new DriveId(i62, strCreateString16, j4, j5);
            case 25:
                int iValidateObjectHeader25 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString17 = "";
                ArrayList arrayListCreateTypedList5 = null;
                int i64 = 0;
                String strCreateString18 = null;
                while (parcel.dataPosition() < iValidateObjectHeader25) {
                    int i65 = parcel.readInt();
                    char c21 = (char) i65;
                    if (c21 == 1) {
                        arrayListCreateTypedList5 = Protocol.Companion.createTypedList(parcel, i65, zzbe.CREATOR);
                    } else if (c21 == 2) {
                        i64 = Protocol.Companion.readInt(parcel, i65);
                    } else if (c21 == 3) {
                        strCreateString17 = Protocol.Companion.createString(parcel, i65);
                    } else if (c21 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i65);
                    } else {
                        strCreateString18 = Protocol.Companion.createString(parcel, i65);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader25);
                return new GeofencingRequest(arrayListCreateTypedList5, i64, strCreateString17, strCreateString18);
            case 26:
                int iValidateObjectHeader26 = Protocol.Companion.validateObjectHeader(parcel);
                int i66 = 1000;
                long j6 = 0;
                zzbo[] zzboVarArr = null;
                int i67 = 1;
                int i68 = 1;
                while (parcel.dataPosition() < iValidateObjectHeader26) {
                    int i69 = parcel.readInt();
                    char c22 = (char) i69;
                    if (c22 == 1) {
                        i67 = Protocol.Companion.readInt(parcel, i69);
                    } else if (c22 == 2) {
                        i68 = Protocol.Companion.readInt(parcel, i69);
                    } else if (c22 == 3) {
                        j6 = Protocol.Companion.readLong(parcel, i69);
                    } else if (c22 == 4) {
                        i66 = Protocol.Companion.readInt(parcel, i69);
                    } else if (c22 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i69);
                    } else {
                        zzboVarArr = (zzbo[]) Protocol.Companion.createTypedArray(parcel, i69, zzbo.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader26);
                LocationAvailability locationAvailability = new LocationAvailability();
                locationAvailability.zzd = i66;
                locationAvailability.zza = i67;
                locationAvailability.zzb = i68;
                locationAvailability.zzc = j6;
                locationAvailability.zze = zzboVarArr;
                return locationAvailability;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                int iValidateObjectHeader27 = Protocol.Companion.validateObjectHeader(parcel);
                int i70 = TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE;
                long j7 = 3600000;
                long j8 = 600000;
                boolean z17 = false;
                long j9 = 0;
                float f = 0.0f;
                int i71 = Integer.MAX_VALUE;
                long j10 = Long.MAX_VALUE;
                boolean z18 = false;
                while (parcel.dataPosition() < iValidateObjectHeader27) {
                    int i72 = parcel.readInt();
                    boolean z19 = z18;
                    switch ((char) i72) {
                        case 1:
                            i70 = Protocol.Companion.readInt(parcel, i72);
                            break;
                        case 2:
                            j7 = Protocol.Companion.readLong(parcel, i72);
                            break;
                        case 3:
                            j8 = Protocol.Companion.readLong(parcel, i72);
                            break;
                        case 4:
                            z17 = Protocol.Companion.readBoolean(parcel, i72);
                            break;
                        case 5:
                            j10 = Protocol.Companion.readLong(parcel, i72);
                            break;
                        case 6:
                            i71 = Protocol.Companion.readInt(parcel, i72);
                            break;
                        case 7:
                            f = Protocol.Companion.readFloat(parcel, i72);
                            break;
                        case '\b':
                            j9 = Protocol.Companion.readLong(parcel, i72);
                            break;
                        case '\t':
                            z18 = Protocol.Companion.readBoolean(parcel, i72);
                            continue;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i72);
                            break;
                    }
                    z18 = z19;
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader27);
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.zza = i70;
                locationRequest.zzb = j7;
                locationRequest.zzc = j8;
                locationRequest.zzd = z17;
                locationRequest.zze = j10;
                locationRequest.zzf = i71;
                locationRequest.zzg = f;
                locationRequest.zzh = j9;
                locationRequest.zzi = z18;
                return locationRequest;
            case 28:
                int iValidateObjectHeader28 = Protocol.Companion.validateObjectHeader(parcel);
                List listCreateTypedList = LocationResult.zza;
                while (parcel.dataPosition() < iValidateObjectHeader28) {
                    int i73 = parcel.readInt();
                    if (((char) i73) != 1) {
                        Protocol.Companion.skipUnknownField(parcel, i73);
                    } else {
                        listCreateTypedList = Protocol.Companion.createTypedList(parcel, i73, Location.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader28);
                return new LocationResult(listCreateTypedList);
            default:
                int iValidateObjectHeader29 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString19 = "";
                String strCreateString20 = "";
                String strCreateString21 = strCreateString20;
                while (parcel.dataPosition() < iValidateObjectHeader29) {
                    int i74 = parcel.readInt();
                    char c23 = (char) i74;
                    if (c23 == 1) {
                        strCreateString20 = Protocol.Companion.createString(parcel, i74);
                    } else if (c23 == 2) {
                        strCreateString21 = Protocol.Companion.createString(parcel, i74);
                    } else if (c23 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i74);
                    } else {
                        strCreateString19 = Protocol.Companion.createString(parcel, i74);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader29);
                return new zzbj(strCreateString19, strCreateString20, strCreateString21);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new Contents[i];
            case 1:
                return new DataHolder[i];
            case 2:
                return new ClientIdentity[i];
            case 3:
                return new TelemetryData[i];
            case 4:
                return new MethodInvocation[i];
            case 5:
                return new zat[i];
            case 6:
                return new zav[i];
            case 7:
                return new RootTelemetryConfiguration[i];
            case 8:
                return new BinderWrapper[i];
            case 9:
                return new zzk[i];
            case 10:
                return new ConnectionTelemetryConfiguration[i];
            case 11:
                return new GetServiceRequest[i];
            case 12:
                return new zaa[i];
            case 13:
                return new StringToIntConverter[i];
            case 14:
                return new zac[i];
            case 15:
                return new zam[i];
            case 16:
                return new zan[i];
            case 17:
                return new zal[i];
            case 18:
                return new SafeParcelResponse[i];
            case 19:
                return new ConnectionResult[i];
            case 20:
                return new Feature[i];
            case 21:
                return new zzo[i];
            case 22:
                return new zzq[i];
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                return new zzs[i];
            case 24:
                return new DriveId[i];
            case 25:
                return new GeofencingRequest[i];
            case 26:
                return new LocationAvailability[i];
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return new LocationRequest[i];
            case 28:
                return new LocationResult[i];
            default:
                return new zzbj[i];
        }
    }
}
