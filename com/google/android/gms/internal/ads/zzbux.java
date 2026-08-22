package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbux implements Parcelable.Creator {
    public static final zzbuw zza(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        float f = 0.0f;
        float f2 = 0.0f;
        long j = 0;
        long j2 = 0;
        int i = 0;
        Bundle bundleCreateBundle = null;
        com.google.android.gms.ads.internal.client.zzm zzmVar = null;
        com.google.android.gms.ads.internal.client.zzr zzrVar = null;
        String strCreateString = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundleCreateBundle2 = null;
        int i2 = 0;
        ArrayList arrayListCreateStringList = null;
        Bundle bundleCreateBundle3 = null;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String strCreateString5 = null;
        String strCreateString6 = null;
        ArrayList arrayListCreateStringList2 = null;
        String strCreateString7 = null;
        zzbge zzbgeVar = null;
        ArrayList arrayListCreateStringList3 = null;
        String strCreateString8 = null;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        String strCreateString9 = null;
        String strCreateString10 = null;
        boolean z4 = false;
        int i7 = 0;
        Bundle bundleCreateBundle4 = null;
        String strCreateString11 = null;
        com.google.android.gms.ads.internal.client.zzeh zzehVar = null;
        boolean z5 = false;
        Bundle bundleCreateBundle5 = null;
        String strCreateString12 = null;
        String strCreateString13 = null;
        String strCreateString14 = null;
        boolean z6 = false;
        ArrayList arrayList = null;
        String strCreateString15 = null;
        ArrayList arrayListCreateStringList4 = null;
        int i8 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        ArrayList arrayListCreateStringList5 = null;
        String strCreateString16 = null;
        zzbmp zzbmpVar = null;
        String strCreateString17 = null;
        Bundle bundleCreateBundle6 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    i = Protocol.Companion.readInt(parcel, i9);
                    break;
                case 2:
                    bundleCreateBundle = Protocol.Companion.createBundle(parcel, i9);
                    break;
                case 3:
                    zzmVar = (com.google.android.gms.ads.internal.client.zzm) Protocol.Companion.createParcelable(parcel, i9, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    break;
                case 4:
                    zzrVar = (com.google.android.gms.ads.internal.client.zzr) Protocol.Companion.createParcelable(parcel, i9, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    break;
                case 5:
                    strCreateString = Protocol.Companion.createString(parcel, i9);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) Protocol.Companion.createParcelable(parcel, i9, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) Protocol.Companion.createParcelable(parcel, i9, PackageInfo.CREATOR);
                    break;
                case '\b':
                    strCreateString2 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '\t':
                    strCreateString3 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '\n':
                    strCreateString4 = Protocol.Companion.createString(parcel, i9);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) Protocol.Companion.createParcelable(parcel, i9, VersionInfoParcel.CREATOR);
                    break;
                case '\f':
                    bundleCreateBundle2 = Protocol.Companion.createBundle(parcel, i9);
                    break;
                case '\r':
                    i2 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case 14:
                    arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i9);
                    break;
                case 15:
                    bundleCreateBundle3 = Protocol.Companion.createBundle(parcel, i9);
                    break;
                case 16:
                    z = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case 17:
                case 22:
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                case 24:
                case ' ':
                case '&':
                case '>':
                default:
                    Protocol.Companion.skipUnknownField(parcel, i9);
                    break;
                case 18:
                    i3 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case 19:
                    i4 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case 20:
                    f = Protocol.Companion.readFloat(parcel, i9);
                    break;
                case 21:
                    strCreateString5 = Protocol.Companion.createString(parcel, i9);
                    break;
                case 25:
                    j = Protocol.Companion.readLong(parcel, i9);
                    break;
                case 26:
                    strCreateString6 = Protocol.Companion.createString(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    arrayListCreateStringList2 = Protocol.Companion.createStringList(parcel, i9);
                    break;
                case 28:
                    strCreateString7 = Protocol.Companion.createString(parcel, i9);
                    break;
                case 29:
                    zzbgeVar = (zzbge) Protocol.Companion.createParcelable(parcel, i9, zzbge.CREATOR);
                    break;
                case 30:
                    arrayListCreateStringList3 = Protocol.Companion.createStringList(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    j2 = Protocol.Companion.readLong(parcel, i9);
                    break;
                case '!':
                    strCreateString8 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '\"':
                    f2 = Protocol.Companion.readFloat(parcel, i9);
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    i5 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    i6 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    z3 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    strCreateString9 = Protocol.Companion.createString(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    z2 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    strCreateString10 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '*':
                    z4 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case '+':
                    i7 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    bundleCreateBundle4 = Protocol.Companion.createBundle(parcel, i9);
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    strCreateString11 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '.':
                    zzehVar = (com.google.android.gms.ads.internal.client.zzeh) Protocol.Companion.createParcelable(parcel, i9, com.google.android.gms.ads.internal.client.zzeh.CREATOR);
                    break;
                case '/':
                    z5 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case '0':
                    bundleCreateBundle5 = Protocol.Companion.createBundle(parcel, i9);
                    break;
                case '1':
                    strCreateString12 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '2':
                    strCreateString13 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '3':
                    strCreateString14 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '4':
                    z6 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case '5':
                    int size = Protocol.Companion.readSize(parcel, i9);
                    int iDataPosition = parcel.dataPosition();
                    if (size == 0) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        int i10 = parcel.readInt();
                        for (int i11 = 0; i11 < i10; i11++) {
                            arrayList2.add(Integer.valueOf(parcel.readInt()));
                        }
                        parcel.setDataPosition(iDataPosition + size);
                        arrayList = arrayList2;
                    }
                    break;
                case '6':
                    strCreateString15 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '7':
                    arrayListCreateStringList4 = Protocol.Companion.createStringList(parcel, i9);
                    break;
                case '8':
                    i8 = Protocol.Companion.readInt(parcel, i9);
                    break;
                case '9':
                    z7 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case ':':
                    z8 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case ';':
                    z9 = Protocol.Companion.readBoolean(parcel, i9);
                    break;
                case '<':
                    arrayListCreateStringList5 = Protocol.Companion.createStringList(parcel, i9);
                    break;
                case '=':
                    strCreateString16 = Protocol.Companion.createString(parcel, i9);
                    break;
                case '?':
                    zzbmpVar = (zzbmp) Protocol.Companion.createParcelable(parcel, i9, zzbmp.CREATOR);
                    break;
                case '@':
                    strCreateString17 = Protocol.Companion.createString(parcel, i9);
                    break;
                case 'A':
                    bundleCreateBundle6 = Protocol.Companion.createBundle(parcel, i9);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbuw(i, bundleCreateBundle, zzmVar, zzrVar, strCreateString, applicationInfo, packageInfo, strCreateString2, strCreateString3, strCreateString4, versionInfoParcel, bundleCreateBundle2, i2, arrayListCreateStringList, bundleCreateBundle3, z, i3, i4, f, strCreateString5, j, strCreateString6, arrayListCreateStringList2, strCreateString7, zzbgeVar, arrayListCreateStringList3, j2, strCreateString8, f2, z2, i5, i6, z3, strCreateString9, strCreateString10, z4, i7, bundleCreateBundle4, strCreateString11, zzehVar, z5, bundleCreateBundle5, strCreateString12, strCreateString13, strCreateString14, z6, arrayList, strCreateString15, arrayListCreateStringList4, i8, z7, z8, z9, arrayListCreateStringList5, strCreateString16, zzbmpVar, strCreateString17, bundleCreateBundle6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbuw[i];
    }
}
