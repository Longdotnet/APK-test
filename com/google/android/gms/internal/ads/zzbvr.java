package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        Bundle bundleCreateBundle = null;
        VersionInfoParcel versionInfoParcel = null;
        ApplicationInfo applicationInfo = null;
        String strCreateString = null;
        ArrayList arrayListCreateStringList = null;
        PackageInfo packageInfo = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzfeq zzfeqVar = null;
        String strCreateString4 = null;
        Bundle bundleCreateBundle2 = null;
        Bundle bundleCreateBundle3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i2 = parcel.readInt();
            switch ((char) i2) {
                case 1:
                    bundleCreateBundle = Protocol.Companion.createBundle(parcel, i2);
                    break;
                case 2:
                    versionInfoParcel = (VersionInfoParcel) Protocol.Companion.createParcelable(parcel, i2, VersionInfoParcel.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) Protocol.Companion.createParcelable(parcel, i2, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    strCreateString = Protocol.Companion.createString(parcel, i2);
                    break;
                case 5:
                    arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i2);
                    break;
                case 6:
                    packageInfo = (PackageInfo) Protocol.Companion.createParcelable(parcel, i2, PackageInfo.CREATOR);
                    break;
                case 7:
                    strCreateString2 = Protocol.Companion.createString(parcel, i2);
                    break;
                case '\b':
                default:
                    Protocol.Companion.skipUnknownField(parcel, i2);
                    break;
                case '\t':
                    strCreateString3 = Protocol.Companion.createString(parcel, i2);
                    break;
                case '\n':
                    zzfeqVar = (zzfeq) Protocol.Companion.createParcelable(parcel, i2, zzfeq.CREATOR);
                    break;
                case 11:
                    strCreateString4 = Protocol.Companion.createString(parcel, i2);
                    break;
                case '\f':
                    z = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case '\r':
                    z2 = Protocol.Companion.readBoolean(parcel, i2);
                    break;
                case 14:
                    bundleCreateBundle2 = Protocol.Companion.createBundle(parcel, i2);
                    break;
                case 15:
                    bundleCreateBundle3 = Protocol.Companion.createBundle(parcel, i2);
                    break;
                case 16:
                    i = Protocol.Companion.readInt(parcel, i2);
                    break;
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbvq(bundleCreateBundle, versionInfoParcel, applicationInfo, strCreateString, arrayListCreateStringList, packageInfo, strCreateString2, strCreateString3, zzfeqVar, strCreateString4, z, z2, bundleCreateBundle2, bundleCreateBundle3, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbvq[i];
    }
}
