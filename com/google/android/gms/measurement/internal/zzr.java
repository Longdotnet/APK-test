package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import kotlin.io.CloseableKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzr implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzr(int i) {
        this.$r8$classId = i;
    }

    public static void zza(zzaw zzawVar, Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, zzawVar.zza, false);
        CloseableKt.writeParcelable(parcel, 3, zzawVar.zzb, i, false);
        CloseableKt.writeString(parcel, 4, zzawVar.zzc, false);
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(zzawVar.zzd);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString = "";
                String strCreateString2 = strCreateString;
                String strCreateString3 = null;
                String strCreateString4 = null;
                String strCreateString5 = null;
                String strCreateString6 = null;
                String strCreateString7 = null;
                String strCreateString8 = null;
                String strCreateString9 = null;
                Boolean booleanObject = null;
                ArrayList arrayListCreateStringList = null;
                String strCreateString10 = null;
                String strCreateString11 = null;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                boolean z = true;
                boolean z2 = true;
                boolean z3 = false;
                int i2 = 0;
                boolean z4 = false;
                long j6 = -2147483648L;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i3 = parcel.readInt();
                    switch ((char) i3) {
                        case 2:
                            strCreateString3 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 3:
                            strCreateString4 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 4:
                            strCreateString5 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 5:
                            strCreateString6 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 6:
                            j = Protocol.Companion.readLong(parcel, i3);
                            break;
                        case 7:
                            j2 = Protocol.Companion.readLong(parcel, i3);
                            break;
                        case '\b':
                            strCreateString7 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case '\t':
                            z = Protocol.Companion.readBoolean(parcel, i3);
                            break;
                        case '\n':
                            z3 = Protocol.Companion.readBoolean(parcel, i3);
                            break;
                        case 11:
                            j6 = Protocol.Companion.readLong(parcel, i3);
                            break;
                        case '\f':
                            strCreateString8 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case '\r':
                            j3 = Protocol.Companion.readLong(parcel, i3);
                            break;
                        case 14:
                            j4 = Protocol.Companion.readLong(parcel, i3);
                            break;
                        case 15:
                            i2 = Protocol.Companion.readInt(parcel, i3);
                            break;
                        case 16:
                            z2 = Protocol.Companion.readBoolean(parcel, i3);
                            break;
                        case 17:
                        case 20:
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i3);
                            break;
                        case 18:
                            z4 = Protocol.Companion.readBoolean(parcel, i3);
                            break;
                        case 19:
                            strCreateString9 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 21:
                            booleanObject = Protocol.Companion.readBooleanObject(parcel, i3);
                            break;
                        case 22:
                            j5 = Protocol.Companion.readLong(parcel, i3);
                            break;
                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                            arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i3);
                            break;
                        case 24:
                            strCreateString10 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 25:
                            strCreateString = Protocol.Companion.createString(parcel, i3);
                            break;
                        case 26:
                            strCreateString2 = Protocol.Companion.createString(parcel, i3);
                            break;
                        case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                            strCreateString11 = Protocol.Companion.createString(parcel, i3);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
                return new zzq(strCreateString3, strCreateString4, strCreateString5, strCreateString6, j, j2, strCreateString7, z, z3, j6, strCreateString8, j3, j4, i2, z2, z4, strCreateString9, booleanObject, j5, arrayListCreateStringList, strCreateString10, strCreateString, strCreateString2, strCreateString11);
            case 1:
                int iValidateObjectHeader2 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString12 = null;
                String strCreateString13 = null;
                zzkw zzkwVar = null;
                String strCreateString14 = null;
                zzaw zzawVar = null;
                zzaw zzawVar2 = null;
                zzaw zzawVar3 = null;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                boolean z5 = false;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i4 = parcel.readInt();
                    switch ((char) i4) {
                        case 2:
                            strCreateString12 = Protocol.Companion.createString(parcel, i4);
                            break;
                        case 3:
                            strCreateString13 = Protocol.Companion.createString(parcel, i4);
                            break;
                        case 4:
                            zzkwVar = (zzkw) Protocol.Companion.createParcelable(parcel, i4, zzkw.CREATOR);
                            break;
                        case 5:
                            j7 = Protocol.Companion.readLong(parcel, i4);
                            break;
                        case 6:
                            z5 = Protocol.Companion.readBoolean(parcel, i4);
                            break;
                        case 7:
                            strCreateString14 = Protocol.Companion.createString(parcel, i4);
                            break;
                        case '\b':
                            zzawVar = (zzaw) Protocol.Companion.createParcelable(parcel, i4, zzaw.CREATOR);
                            break;
                        case '\t':
                            j8 = Protocol.Companion.readLong(parcel, i4);
                            break;
                        case '\n':
                            zzawVar2 = (zzaw) Protocol.Companion.createParcelable(parcel, i4, zzaw.CREATOR);
                            break;
                        case 11:
                            j9 = Protocol.Companion.readLong(parcel, i4);
                            break;
                        case '\f':
                            zzawVar3 = (zzaw) Protocol.Companion.createParcelable(parcel, i4, zzaw.CREATOR);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(parcel, i4);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader2);
                return new zzac(strCreateString12, strCreateString13, zzkwVar, j7, z5, strCreateString14, zzawVar, j8, zzawVar2, j9, zzawVar3);
            case 2:
                int iValidateObjectHeader3 = Protocol.Companion.validateObjectHeader(parcel);
                Bundle bundleCreateBundle = null;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i5 = parcel.readInt();
                    if (((char) i5) != 2) {
                        Protocol.Companion.skipUnknownField(parcel, i5);
                    } else {
                        bundleCreateBundle = Protocol.Companion.createBundle(parcel, i5);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new zzau(bundleCreateBundle);
            case 3:
                int iValidateObjectHeader4 = Protocol.Companion.validateObjectHeader(parcel);
                String strCreateString15 = null;
                zzau zzauVar = null;
                String strCreateString16 = null;
                long j10 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i6 = parcel.readInt();
                    char c = (char) i6;
                    if (c == 2) {
                        strCreateString15 = Protocol.Companion.createString(parcel, i6);
                    } else if (c == 3) {
                        zzauVar = (zzau) Protocol.Companion.createParcelable(parcel, i6, zzau.CREATOR);
                    } else if (c == 4) {
                        strCreateString16 = Protocol.Companion.createString(parcel, i6);
                    } else if (c != 5) {
                        Protocol.Companion.skipUnknownField(parcel, i6);
                    } else {
                        j10 = Protocol.Companion.readLong(parcel, i6);
                    }
                }
                Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader4);
                return new zzaw(strCreateString15, zzauVar, strCreateString16, j10);
            default:
                int iValidateObjectHeader5 = Protocol.Companion.validateObjectHeader(parcel);
                long j11 = 0;
                int i7 = 0;
                String strCreateString17 = null;
                Long longObject = null;
                Float fValueOf = null;
                String strCreateString18 = null;
                String strCreateString19 = null;
                Double dValueOf = null;
                while (true) {
                    long j12 = j11;
                    while (true) {
                        if (parcel.dataPosition() >= iValidateObjectHeader5) {
                            Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader5);
                            return new zzkw(i7, strCreateString17, j12, longObject, fValueOf, strCreateString18, strCreateString19, dValueOf);
                        }
                        i = parcel.readInt();
                        switch ((char) i) {
                            case 1:
                                i7 = Protocol.Companion.readInt(parcel, i);
                                break;
                            case 2:
                                strCreateString17 = Protocol.Companion.createString(parcel, i);
                                break;
                            case 3:
                                break;
                            case 4:
                                longObject = Protocol.Companion.readLongObject(parcel, i);
                                break;
                            case 5:
                                int size = Protocol.Companion.readSize(parcel, i);
                                if (size != 0) {
                                    Protocol.Companion.zza(parcel, size, 4);
                                    fValueOf = Float.valueOf(parcel.readFloat());
                                } else {
                                    fValueOf = null;
                                }
                                break;
                            case 6:
                                strCreateString18 = Protocol.Companion.createString(parcel, i);
                                break;
                            case 7:
                                strCreateString19 = Protocol.Companion.createString(parcel, i);
                                break;
                            case '\b':
                                int size2 = Protocol.Companion.readSize(parcel, i);
                                if (size2 != 0) {
                                    Protocol.Companion.zza(parcel, size2, 8);
                                    dValueOf = Double.valueOf(parcel.readDouble());
                                } else {
                                    dValueOf = null;
                                }
                                break;
                            default:
                                Protocol.Companion.skipUnknownField(parcel, i);
                                break;
                        }
                    }
                    j11 = Protocol.Companion.readLong(parcel, i);
                }
                break;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new zzq[i];
            case 1:
                return new zzac[i];
            case 2:
                return new zzau[i];
            case 3:
                return new zzaw[i];
            default:
                return new zzkw[i];
        }
    }

    public static void zza(zzkw zzkwVar, Parcel parcel) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int i = zzkwVar.zza;
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i);
        CloseableKt.writeString(parcel, 2, zzkwVar.zzb, false);
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(zzkwVar.zzc);
        CloseableKt.writeLongObject(parcel, 4, zzkwVar.zzd);
        CloseableKt.writeString(parcel, 6, zzkwVar.zze, false);
        CloseableKt.writeString(parcel, 7, zzkwVar.zzf, false);
        Double d = zzkwVar.zzg;
        if (d != null) {
            CloseableKt.zzc(parcel, 8, 8);
            parcel.writeDouble(d.doubleValue());
        }
        CloseableKt.zzb(parcel, iZza);
    }
}
