package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;
import com.google.android.gms.safetynet.zzh;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzl(int i) {
        this.$r8$classId = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
                int i = 0;
                int i2 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i3 = parcel.readInt();
                    char c = (char) i3;
                    if (c == 1) {
                        i = Protocol.Companion.readInt(parcel, i3);
                    } else if (c != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i3);
                    } else {
                        i2 = Protocol.Companion.readInt(parcel, i3);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
                return new ActivityTransition(i, i2);
            case 1:
                int iValidateObjectHeader2 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList = null;
                boolean z = false;
                boolean z2 = false;
                zzbj zzbjVar = null;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i4 = parcel.readInt();
                    char c2 = (char) i4;
                    if (c2 == 1) {
                        arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i4, LocationRequest.CREATOR);
                    } else if (c2 == 2) {
                        z = Protocol.Companion.readBoolean(parcel, i4);
                    } else if (c2 == 3) {
                        z2 = Protocol.Companion.readBoolean(parcel, i4);
                    } else if (c2 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i4);
                    } else {
                        zzbjVar = (zzbj) Protocol.Companion.createParcelable(parcel, i4, zzbj.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader2);
                return new LocationSettingsRequest(arrayListCreateTypedList, z, z2, zzbjVar);
            case 2:
                int iValidateObjectHeader3 = Protocol.Companion.validateObjectHeader(parcel);
                Status status = null;
                LocationSettingsStates locationSettingsStates = null;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i5 = parcel.readInt();
                    char c3 = (char) i5;
                    if (c3 == 1) {
                        status = (Status) Protocol.Companion.createParcelable(parcel, i5, Status.CREATOR);
                    } else if (c3 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i5);
                    } else {
                        locationSettingsStates = (LocationSettingsStates) Protocol.Companion.createParcelable(parcel, i5, LocationSettingsStates.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new LocationSettingsResult(status, locationSettingsStates);
            case 3:
                int iValidateObjectHeader4 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 1:
                            z3 = Protocol.Companion.readBoolean(parcel, i6);
                            break;
                        case 2:
                            z4 = Protocol.Companion.readBoolean(parcel, i6);
                            break;
                        case 3:
                            z5 = Protocol.Companion.readBoolean(parcel, i6);
                            break;
                        case 4:
                            z6 = Protocol.Companion.readBoolean(parcel, i6);
                            break;
                        case 5:
                            z7 = Protocol.Companion.readBoolean(parcel, i6);
                            break;
                        case 6:
                            z8 = Protocol.Companion.readBoolean(parcel, i6);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i6);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader4);
                return new LocationSettingsStates(z3, z4, z5, z6, z7, z8);
            case 4:
                int iValidateObjectHeader5 = Protocol.Companion.validateObjectHeader(parcel);
                int i7 = 1;
                int i8 = 1;
                long j = -1;
                long j2 = -1;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i9 = parcel.readInt();
                    char c4 = (char) i9;
                    if (c4 == 1) {
                        i7 = Protocol.Companion.readInt(parcel, i9);
                    } else if (c4 == 2) {
                        i8 = Protocol.Companion.readInt(parcel, i9);
                    } else if (c4 == 3) {
                        j = Protocol.Companion.readLong(parcel, i9);
                    } else if (c4 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i9);
                    } else {
                        j2 = Protocol.Companion.readLong(parcel, i9);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader5);
                return new zzbo(j, i7, i8, j2);
            case 5:
                int iValidateObjectHeader6 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString = "";
                ArrayList arrayListCreateStringList = null;
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i10 = parcel.readInt();
                    char c5 = (char) i10;
                    if (c5 == 1) {
                        arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i10);
                    } else if (c5 == 2) {
                        pendingIntent = (PendingIntent) Protocol.Companion.createParcelable(parcel, i10, PendingIntent.CREATOR);
                    } else if (c5 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i10);
                    } else {
                        strCreateString = Protocol.Companion.createString(parcel, i10);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader6);
                return new zzbq(arrayListCreateStringList, pendingIntent, strCreateString);
            case 6:
                int iValidateObjectHeader7 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList2 = null;
                int i11 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader7) {
                    int i12 = parcel.readInt();
                    char c6 = (char) i12;
                    if (c6 == 1) {
                        arrayListCreateTypedList2 = Protocol.Companion.createTypedList(parcel, i12, zzbx.CREATOR);
                    } else if (c6 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i12);
                    } else {
                        i11 = Protocol.Companion.readInt(parcel, i12);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader7);
                return new SleepSegmentRequest(arrayListCreateTypedList2, i11);
            case 7:
                int iValidateObjectHeader8 = Protocol.Companion.validateObjectHeader(parcel);
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader8) {
                    int i17 = parcel.readInt();
                    char c7 = (char) i17;
                    if (c7 == 1) {
                        i13 = Protocol.Companion.readInt(parcel, i17);
                    } else if (c7 == 2) {
                        i14 = Protocol.Companion.readInt(parcel, i17);
                    } else if (c7 == 3) {
                        i15 = Protocol.Companion.readInt(parcel, i17);
                    } else if (c7 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i17);
                    } else {
                        i16 = Protocol.Companion.readInt(parcel, i17);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader8);
                return new zzbx(i13, i14, i15, i16);
            case 8:
                int iValidateObjectHeader9 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateTypedList3 = null;
                String strCreateString2 = null;
                ArrayList arrayListCreateTypedList4 = null;
                String strCreateString3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader9) {
                    int i18 = parcel.readInt();
                    char c8 = (char) i18;
                    if (c8 == 1) {
                        arrayListCreateTypedList3 = Protocol.Companion.createTypedList(parcel, i18, ActivityTransition.CREATOR);
                    } else if (c8 == 2) {
                        strCreateString2 = Protocol.Companion.createString(parcel, i18);
                    } else if (c8 == 3) {
                        arrayListCreateTypedList4 = Protocol.Companion.createTypedList(parcel, i18, ClientIdentity.CREATOR);
                    } else if (c8 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i18);
                    } else {
                        strCreateString3 = Protocol.Companion.createString(parcel, i18);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader9);
                return new ActivityTransitionRequest(arrayListCreateTypedList3, strCreateString2, arrayListCreateTypedList4, strCreateString3);
            case 9:
                int iValidateObjectHeader10 = Protocol.Companion.validateObjectHeader(parcel);
                boolean z9 = true;
                long j3 = 50;
                float f = 0.0f;
                long j4 = Long.MAX_VALUE;
                int i19 = Integer.MAX_VALUE;
                while (parcel.dataPosition() < iValidateObjectHeader10) {
                    int i20 = parcel.readInt();
                    char c9 = (char) i20;
                    if (c9 == 1) {
                        z9 = Protocol.Companion.readBoolean(parcel, i20);
                    } else if (c9 == 2) {
                        j3 = Protocol.Companion.readLong(parcel, i20);
                    } else if (c9 == 3) {
                        f = Protocol.Companion.readFloat(parcel, i20);
                    } else if (c9 == 4) {
                        j4 = Protocol.Companion.readLong(parcel, i20);
                    } else if (c9 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i20);
                    } else {
                        i19 = Protocol.Companion.readInt(parcel, i20);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader10);
                return new zzs(z9, j3, f, j4, i19);
            case 10:
                int iValidateObjectHeader11 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString4 = null;
                while (parcel.dataPosition() < iValidateObjectHeader11) {
                    int i21 = parcel.readInt();
                    if (((char) i21) != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i21);
                    } else {
                        strCreateString4 = Protocol.Companion.createString(parcel, i21);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader11);
                return new com.google.android.gms.safetynet.zza(strCreateString4);
            case 11:
                int iValidateObjectHeader12 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString5 = null;
                int i22 = 0;
                byte[] bArrCreateByteArray = null;
                while (parcel.dataPosition() < iValidateObjectHeader12) {
                    int i23 = parcel.readInt();
                    char c10 = (char) i23;
                    if (c10 == 2) {
                        strCreateString5 = Protocol.Companion.createString(parcel, i23);
                    } else if (c10 == 3) {
                        bArrCreateByteArray = Protocol.Companion.createByteArray(parcel, i23);
                    } else if (c10 != 4) {
                        Protocol.Companion.skipUnknownField(parcel, i23);
                    } else {
                        i22 = Protocol.Companion.readInt(parcel, i23);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader12);
                return new HarmfulAppsData(strCreateString5, bArrCreateByteArray, i22);
            case 12:
                int iValidateObjectHeader13 = Protocol.Companion.validateObjectHeader(parcel);
                long j5 = 0;
                HarmfulAppsData[] harmfulAppsDataArr = null;
                int i24 = 0;
                boolean z10 = false;
                while (parcel.dataPosition() < iValidateObjectHeader13) {
                    int i25 = parcel.readInt();
                    char c11 = (char) i25;
                    if (c11 == 2) {
                        j5 = Protocol.Companion.readLong(parcel, i25);
                    } else if (c11 == 3) {
                        harmfulAppsDataArr = (HarmfulAppsData[]) Protocol.Companion.createTypedArray(parcel, i25, HarmfulAppsData.CREATOR);
                    } else if (c11 == 4) {
                        i24 = Protocol.Companion.readInt(parcel, i25);
                    } else if (c11 != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i25);
                    } else {
                        z10 = Protocol.Companion.readBoolean(parcel, i25);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader13);
                return new zzd(j5, harmfulAppsDataArr, i24, z10);
            case 13:
                int iValidateObjectHeader14 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString6 = null;
                while (parcel.dataPosition() < iValidateObjectHeader14) {
                    int i26 = parcel.readInt();
                    if (((char) i26) != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i26);
                    } else {
                        strCreateString6 = Protocol.Companion.createString(parcel, i26);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader14);
                return new zzf(strCreateString6);
            case 14:
                int iValidateObjectHeader15 = Protocol.Companion.validateObjectHeader(parcel);
                int i27 = 0;
                boolean z11 = false;
                while (parcel.dataPosition() < iValidateObjectHeader15) {
                    int i28 = parcel.readInt();
                    char c12 = (char) i28;
                    if (c12 == 2) {
                        i27 = Protocol.Companion.readInt(parcel, i28);
                    } else if (c12 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i28);
                    } else {
                        z11 = Protocol.Companion.readBoolean(parcel, i28);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader15);
                return new zzh(i27, z11);
            case 15:
                int iValidateObjectHeader16 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString7 = null;
                byte[] bArrCreateByteArray2 = null;
                long j6 = 0;
                DataHolder dataHolder = null;
                ParcelFileDescriptor parcelFileDescriptor = null;
                while (parcel.dataPosition() < iValidateObjectHeader16) {
                    int i29 = parcel.readInt();
                    char c13 = (char) i29;
                    if (c13 == 2) {
                        strCreateString7 = Protocol.Companion.createString(parcel, i29);
                    } else if (c13 == 3) {
                        dataHolder = (DataHolder) Protocol.Companion.createParcelable(parcel, i29, DataHolder.CREATOR);
                    } else if (c13 == 4) {
                        parcelFileDescriptor = (ParcelFileDescriptor) Protocol.Companion.createParcelable(parcel, i29, ParcelFileDescriptor.CREATOR);
                    } else if (c13 == 5) {
                        j6 = Protocol.Companion.readLong(parcel, i29);
                    } else if (c13 != 6) {
                        Protocol.Companion.skipUnknownField(parcel, i29);
                    } else {
                        bArrCreateByteArray2 = Protocol.Companion.createByteArray(parcel, i29);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader16);
                SafeBrowsingData safeBrowsingData = new SafeBrowsingData();
                safeBrowsingData.zzm = strCreateString7;
                safeBrowsingData.zzn = dataHolder;
                safeBrowsingData.zzo = parcelFileDescriptor;
                safeBrowsingData.zzp = j6;
                safeBrowsingData.zzq = bArrCreateByteArray2;
                return safeBrowsingData;
            case 16:
                int iValidateObjectHeader17 = Protocol.Companion.validateObjectHeader(parcel);
                Intent intent = null;
                int i30 = 0;
                int i31 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader17) {
                    int i32 = parcel.readInt();
                    char c14 = (char) i32;
                    if (c14 == 1) {
                        i30 = Protocol.Companion.readInt(parcel, i32);
                    } else if (c14 == 2) {
                        i31 = Protocol.Companion.readInt(parcel, i32);
                    } else if (c14 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i32);
                    } else {
                        intent = (Intent) Protocol.Companion.createParcelable(parcel, i32, Intent.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader17);
                return new zaa(i30, i31, intent);
            case 17:
                int iValidateObjectHeader18 = Protocol.Companion.validateObjectHeader(parcel);
                ArrayList arrayListCreateStringList2 = null;
                String strCreateString8 = null;
                while (parcel.dataPosition() < iValidateObjectHeader18) {
                    int i33 = parcel.readInt();
                    char c15 = (char) i33;
                    if (c15 == 1) {
                        arrayListCreateStringList2 = Protocol.Companion.createStringList(parcel, i33);
                    } else if (c15 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i33);
                    } else {
                        strCreateString8 = Protocol.Companion.createString(parcel, i33);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader18);
                return new zag(arrayListCreateStringList2, strCreateString8);
            case 18:
                int iValidateObjectHeader19 = Protocol.Companion.validateObjectHeader(parcel);
                zat zatVar = null;
                int i34 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader19) {
                    int i35 = parcel.readInt();
                    char c16 = (char) i35;
                    if (c16 == 1) {
                        i34 = Protocol.Companion.readInt(parcel, i35);
                    } else if (c16 != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i35);
                    } else {
                        zatVar = (zat) Protocol.Companion.createParcelable(parcel, i35, zat.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader19);
                return new zai(i34, zatVar);
            default:
                int iValidateObjectHeader20 = Protocol.Companion.validateObjectHeader(parcel);
                ConnectionResult connectionResult = null;
                int i36 = 0;
                zav zavVar = null;
                while (parcel.dataPosition() < iValidateObjectHeader20) {
                    int i37 = parcel.readInt();
                    char c17 = (char) i37;
                    if (c17 == 1) {
                        i36 = Protocol.Companion.readInt(parcel, i37);
                    } else if (c17 == 2) {
                        connectionResult = (ConnectionResult) Protocol.Companion.createParcelable(parcel, i37, ConnectionResult.CREATOR);
                    } else if (c17 != 3) {
                        Protocol.Companion.skipUnknownField(parcel, i37);
                    } else {
                        zavVar = (zav) Protocol.Companion.createParcelable(parcel, i37, zav.CREATOR);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader20);
                return new zak(i36, connectionResult, zavVar);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new ActivityTransition[i];
            case 1:
                return new LocationSettingsRequest[i];
            case 2:
                return new LocationSettingsResult[i];
            case 3:
                return new LocationSettingsStates[i];
            case 4:
                return new zzbo[i];
            case 5:
                return new zzbq[i];
            case 6:
                return new SleepSegmentRequest[i];
            case 7:
                return new zzbx[i];
            case 8:
                return new ActivityTransitionRequest[i];
            case 9:
                return new zzs[i];
            case 10:
                return new com.google.android.gms.safetynet.zza[i];
            case 11:
                return new HarmfulAppsData[i];
            case 12:
                return new zzd[i];
            case 13:
                return new zzf[i];
            case 14:
                return new zzh[i];
            case 15:
                return new SafeBrowsingData[i];
            case 16:
                return new zaa[i];
            case 17:
                return new zag[i];
            case 18:
                return new zai[i];
            default:
                return new zak[i];
        }
    }
}
