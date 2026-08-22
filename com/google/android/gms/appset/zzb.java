package com.google.android.gms.appset;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.Utility;
import com.facebook.login.GetTokenLoginMethodHandler;
import com.facebook.login.InstagramAppLoginMethodHandler;
import com.facebook.login.KatanaProxyLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import com.facebook.login.WebViewLoginMethodHandler;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.ads.internal.client.zzfd;
import com.google.android.gms.ads.internal.client.zzfv;
import com.google.android.gms.ads.internal.client.zzfx;
import com.google.android.gms.ads.internal.client.zzfz;
import com.google.android.gms.ads.internal.client.zzgc;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.zzl;
import com.google.gson.yWTz.kBfGXgdfpo;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzb(int i) {
        this.$r8$classId = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new zza[i];
            case 1:
                return new GetTokenLoginMethodHandler[i];
            case 2:
                return new InstagramAppLoginMethodHandler[i];
            case 3:
                return new KatanaProxyLoginMethodHandler[i];
            case 4:
                return new LoginClient[i];
            case 5:
                return new LoginClient.Request[i];
            case 6:
                return new LoginClient.Result[i];
            case 7:
                return new WebViewLoginMethodHandler[i];
            case 8:
                return new AdManagerAdViewOptions[i];
            case 9:
                return new PublisherAdViewOptions[i];
            case 10:
                return new com.google.android.gms.ads.internal.client.zzc[i];
            case 11:
                return new zzeh[i];
            case 12:
                return new com.google.android.gms.ads.internal.client.zze[i];
            case 13:
                return new zzfd[i];
            case 14:
                return new zzfv[i];
            case 15:
                return new zzfx[i];
            case 16:
                return new zzfz[i];
            case 17:
                return new zzgc[i];
            case 18:
                return new zzm[i];
            case 19:
                return new zzr[i];
            case 20:
                return new zzt[i];
            case 21:
                return new zzv[i];
            case 22:
                return new zzx[i];
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                return new com.google.android.gms.ads.internal.offline.buffering.zza[i];
            case 24:
                return new com.google.android.gms.ads.internal.overlay.zzc[i];
            case 25:
                return new AdOverlayInfoParcel[i];
            case 26:
                return new VersionInfoParcel[i];
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                return new zzbb[i];
            case 28:
                return new zzl[i];
            default:
                return new zzc[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel source) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(source);
                String strCreateString = null;
                String strCreateString2 = null;
                while (source.dataPosition() < iValidateObjectHeader) {
                    int i = source.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        strCreateString = Protocol.Companion.createString(source, i);
                    } else if (c != 2) {
                        Protocol.Companion.skipUnknownField(source, i);
                    } else {
                        strCreateString2 = Protocol.Companion.createString(source, i);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader);
                return new zza(strCreateString, strCreateString2);
            case 1:
                Intrinsics.checkNotNullParameter(source, "source");
                return new GetTokenLoginMethodHandler(source);
            case 2:
                Intrinsics.checkNotNullParameter(source, "source");
                return new InstagramAppLoginMethodHandler(source);
            case 3:
                Intrinsics.checkNotNullParameter(source, kBfGXgdfpo.YNVzYAzWhIyBtF);
                return new KatanaProxyLoginMethodHandler(source);
            case 4:
                Intrinsics.checkNotNullParameter(source, kBfGXgdfpo.YMfAQQqDHJ);
                LoginClient loginClient = new LoginClient();
                loginClient.currentHandler = -1;
                Parcelable[] parcelableArray = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
                if (parcelableArray == null) {
                    parcelableArray = new Parcelable[0];
                }
                ArrayList arrayList = new ArrayList();
                int length = parcelableArray.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        loginClient.handlersToTry = (LoginMethodHandler[]) array;
                        loginClient.currentHandler = source.readInt();
                        loginClient.pendingRequest = (LoginClient.Request) source.readParcelable(LoginClient.Request.class.getClassLoader());
                        HashMap nonnullStringMapFromParcel = Utility.readNonnullStringMapFromParcel(source);
                        loginClient.loggingExtras = nonnullStringMapFromParcel == null ? null : MapsKt__MapsKt.toMutableMap(nonnullStringMapFromParcel);
                        HashMap nonnullStringMapFromParcel2 = Utility.readNonnullStringMapFromParcel(source);
                        loginClient.extraData = nonnullStringMapFromParcel2 != null ? MapsKt__MapsKt.toMutableMap(nonnullStringMapFromParcel2) : null;
                        return loginClient;
                    }
                    Parcelable parcelable = parcelableArray[i2];
                    LoginMethodHandler loginMethodHandler = parcelable instanceof LoginMethodHandler ? (LoginMethodHandler) parcelable : null;
                    if (loginMethodHandler != null) {
                        loginMethodHandler.loginClient = loginClient;
                    }
                    if (loginMethodHandler != null) {
                        arrayList.add(loginMethodHandler);
                    }
                    i2++;
                }
                break;
            case 5:
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Request(source);
            case 6:
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Result(source);
            case 7:
                Intrinsics.checkNotNullParameter(source, "source");
                return new WebViewLoginMethodHandler(source);
            case 8:
                int iValidateObjectHeader2 = Protocol.Companion.validateObjectHeader(source);
                boolean z = false;
                while (source.dataPosition() < iValidateObjectHeader2) {
                    int i3 = source.readInt();
                    if (((char) i3) != 1) {
                        Protocol.Companion.skipUnknownField(source, i3);
                    } else {
                        z = Protocol.Companion.readBoolean(source, i3);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader2);
                return new AdManagerAdViewOptions(z);
            case 9:
                int iValidateObjectHeader3 = Protocol.Companion.validateObjectHeader(source);
                IBinder iBinder = null;
                boolean z2 = false;
                IBinder iBinder2 = null;
                while (source.dataPosition() < iValidateObjectHeader3) {
                    int i4 = source.readInt();
                    char c2 = (char) i4;
                    if (c2 == 1) {
                        z2 = Protocol.Companion.readBoolean(source, i4);
                    } else if (c2 == 2) {
                        iBinder = Protocol.Companion.readIBinder(source, i4);
                    } else if (c2 != 3) {
                        Protocol.Companion.skipUnknownField(source, i4);
                    } else {
                        iBinder2 = Protocol.Companion.readIBinder(source, i4);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader3);
                return new PublisherAdViewOptions(z2, iBinder, iBinder2);
            case 10:
                int iValidateObjectHeader4 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString3 = null;
                String strCreateString4 = null;
                while (source.dataPosition() < iValidateObjectHeader4) {
                    int i5 = source.readInt();
                    char c3 = (char) i5;
                    if (c3 == 1) {
                        strCreateString3 = Protocol.Companion.createString(source, i5);
                    } else if (c3 != 2) {
                        Protocol.Companion.skipUnknownField(source, i5);
                    } else {
                        strCreateString4 = Protocol.Companion.createString(source, i5);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader4);
                return new com.google.android.gms.ads.internal.client.zzc(strCreateString3, strCreateString4);
            case 11:
                int iValidateObjectHeader5 = Protocol.Companion.validateObjectHeader(source);
                int i6 = 0;
                while (source.dataPosition() < iValidateObjectHeader5) {
                    int i7 = source.readInt();
                    if (((char) i7) != 2) {
                        Protocol.Companion.skipUnknownField(source, i7);
                    } else {
                        i6 = Protocol.Companion.readInt(source, i7);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader5);
                return new zzeh(i6);
            case 12:
                int iValidateObjectHeader6 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString5 = null;
                String strCreateString6 = null;
                com.google.android.gms.ads.internal.client.zze zzeVar = null;
                IBinder iBinder3 = null;
                int i8 = 0;
                while (source.dataPosition() < iValidateObjectHeader6) {
                    int i9 = source.readInt();
                    char c4 = (char) i9;
                    if (c4 == 1) {
                        i8 = Protocol.Companion.readInt(source, i9);
                    } else if (c4 == 2) {
                        strCreateString5 = Protocol.Companion.createString(source, i9);
                    } else if (c4 == 3) {
                        strCreateString6 = Protocol.Companion.createString(source, i9);
                    } else if (c4 == 4) {
                        zzeVar = (com.google.android.gms.ads.internal.client.zze) Protocol.Companion.createParcelable(source, i9, com.google.android.gms.ads.internal.client.zze.CREATOR);
                    } else if (c4 != 5) {
                        Protocol.Companion.skipUnknownField(source, i9);
                    } else {
                        iBinder3 = Protocol.Companion.readIBinder(source, i9);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader6);
                return new com.google.android.gms.ads.internal.client.zze(i8, strCreateString5, strCreateString6, zzeVar, iBinder3);
            case 13:
                int iValidateObjectHeader7 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString7 = null;
                int i10 = 0;
                int i11 = 0;
                while (source.dataPosition() < iValidateObjectHeader7) {
                    int i12 = source.readInt();
                    char c5 = (char) i12;
                    if (c5 == 1) {
                        i10 = Protocol.Companion.readInt(source, i12);
                    } else if (c5 == 2) {
                        i11 = Protocol.Companion.readInt(source, i12);
                    } else if (c5 != 3) {
                        Protocol.Companion.skipUnknownField(source, i12);
                    } else {
                        strCreateString7 = Protocol.Companion.createString(source, i12);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader7);
                return new zzfd(i10, i11, strCreateString7);
            case 14:
                int iValidateObjectHeader8 = Protocol.Companion.validateObjectHeader(source);
                int i13 = 0;
                String strCreateString8 = null;
                zzm zzmVar = null;
                int i14 = 0;
                while (source.dataPosition() < iValidateObjectHeader8) {
                    int i15 = source.readInt();
                    char c6 = (char) i15;
                    if (c6 == 1) {
                        strCreateString8 = Protocol.Companion.createString(source, i15);
                    } else if (c6 == 2) {
                        i13 = Protocol.Companion.readInt(source, i15);
                    } else if (c6 == 3) {
                        zzmVar = (zzm) Protocol.Companion.createParcelable(source, i15, zzm.CREATOR);
                    } else if (c6 != 4) {
                        Protocol.Companion.skipUnknownField(source, i15);
                    } else {
                        i14 = Protocol.Companion.readInt(source, i15);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader8);
                return new zzfv(strCreateString8, i13, zzmVar, i14);
            case 15:
                int iValidateObjectHeader9 = Protocol.Companion.validateObjectHeader(source);
                int i16 = 0;
                int i17 = 0;
                while (source.dataPosition() < iValidateObjectHeader9) {
                    int i18 = source.readInt();
                    char c7 = (char) i18;
                    if (c7 == 1) {
                        i16 = Protocol.Companion.readInt(source, i18);
                    } else if (c7 != 2) {
                        Protocol.Companion.skipUnknownField(source, i18);
                    } else {
                        i17 = Protocol.Companion.readInt(source, i18);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader9);
                return new zzfx(i16, i17);
            case 16:
                int iValidateObjectHeader10 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString9 = null;
                while (source.dataPosition() < iValidateObjectHeader10) {
                    int i19 = source.readInt();
                    if (((char) i19) != 15) {
                        Protocol.Companion.skipUnknownField(source, i19);
                    } else {
                        strCreateString9 = Protocol.Companion.createString(source, i19);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader10);
                return new zzfz(strCreateString9);
            case 17:
                int iValidateObjectHeader11 = Protocol.Companion.validateObjectHeader(source);
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                while (source.dataPosition() < iValidateObjectHeader11) {
                    int i20 = source.readInt();
                    char c8 = (char) i20;
                    if (c8 == 2) {
                        z3 = Protocol.Companion.readBoolean(source, i20);
                    } else if (c8 == 3) {
                        z4 = Protocol.Companion.readBoolean(source, i20);
                    } else if (c8 != 4) {
                        Protocol.Companion.skipUnknownField(source, i20);
                    } else {
                        z5 = Protocol.Companion.readBoolean(source, i20);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader11);
                return new zzgc(z3, z4, z5);
            case 18:
                int iValidateObjectHeader12 = Protocol.Companion.validateObjectHeader(source);
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                int i21 = 0;
                int i22 = 0;
                boolean z6 = false;
                int i23 = 0;
                boolean z7 = false;
                boolean z8 = false;
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                Bundle bundleCreateBundle = null;
                ArrayList arrayListCreateStringList = null;
                String strCreateString10 = null;
                zzfz zzfzVar = null;
                Location location = null;
                String strCreateString11 = null;
                Bundle bundleCreateBundle2 = null;
                Bundle bundleCreateBundle3 = null;
                ArrayList arrayListCreateStringList2 = null;
                String strCreateString12 = null;
                String strCreateString13 = null;
                com.google.android.gms.ads.internal.client.zzc zzcVar = null;
                String strCreateString14 = null;
                ArrayList arrayListCreateStringList3 = null;
                String strCreateString15 = null;
                while (source.dataPosition() < iValidateObjectHeader12) {
                    int i27 = source.readInt();
                    switch ((char) i27) {
                        case 1:
                            i21 = Protocol.Companion.readInt(source, i27);
                            break;
                        case 2:
                            j = Protocol.Companion.readLong(source, i27);
                            break;
                        case 3:
                            bundleCreateBundle = Protocol.Companion.createBundle(source, i27);
                            break;
                        case 4:
                            i22 = Protocol.Companion.readInt(source, i27);
                            break;
                        case 5:
                            arrayListCreateStringList = Protocol.Companion.createStringList(source, i27);
                            break;
                        case 6:
                            z6 = Protocol.Companion.readBoolean(source, i27);
                            break;
                        case 7:
                            i23 = Protocol.Companion.readInt(source, i27);
                            break;
                        case '\b':
                            z7 = Protocol.Companion.readBoolean(source, i27);
                            break;
                        case '\t':
                            strCreateString10 = Protocol.Companion.createString(source, i27);
                            break;
                        case '\n':
                            zzfzVar = (zzfz) Protocol.Companion.createParcelable(source, i27, zzfz.CREATOR);
                            break;
                        case 11:
                            location = (Location) Protocol.Companion.createParcelable(source, i27, Location.CREATOR);
                            break;
                        case '\f':
                            strCreateString11 = Protocol.Companion.createString(source, i27);
                            break;
                        case '\r':
                            bundleCreateBundle2 = Protocol.Companion.createBundle(source, i27);
                            break;
                        case 14:
                            bundleCreateBundle3 = Protocol.Companion.createBundle(source, i27);
                            break;
                        case 15:
                            arrayListCreateStringList2 = Protocol.Companion.createStringList(source, i27);
                            break;
                        case 16:
                            strCreateString12 = Protocol.Companion.createString(source, i27);
                            break;
                        case 17:
                            strCreateString13 = Protocol.Companion.createString(source, i27);
                            break;
                        case 18:
                            z8 = Protocol.Companion.readBoolean(source, i27);
                            break;
                        case 19:
                            zzcVar = (com.google.android.gms.ads.internal.client.zzc) Protocol.Companion.createParcelable(source, i27, com.google.android.gms.ads.internal.client.zzc.CREATOR);
                            break;
                        case 20:
                            i24 = Protocol.Companion.readInt(source, i27);
                            break;
                        case 21:
                            strCreateString14 = Protocol.Companion.createString(source, i27);
                            break;
                        case 22:
                            arrayListCreateStringList3 = Protocol.Companion.createStringList(source, i27);
                            break;
                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                            i25 = Protocol.Companion.readInt(source, i27);
                            break;
                        case 24:
                            strCreateString15 = Protocol.Companion.createString(source, i27);
                            break;
                        case 25:
                            i26 = Protocol.Companion.readInt(source, i27);
                            break;
                        case 26:
                            j2 = Protocol.Companion.readLong(source, i27);
                            break;
                        case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                            j3 = Protocol.Companion.readLong(source, i27);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(source, i27);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader12);
                return new zzm(i21, j, bundleCreateBundle, i22, arrayListCreateStringList, z6, i23, z7, strCreateString10, zzfzVar, location, strCreateString11, bundleCreateBundle2, bundleCreateBundle3, arrayListCreateStringList2, strCreateString12, strCreateString13, z8, zzcVar, i24, strCreateString14, arrayListCreateStringList3, i25, strCreateString15, i26, j2, j3);
            case 19:
                int iValidateObjectHeader13 = Protocol.Companion.validateObjectHeader(source);
                int i28 = 0;
                int i29 = 0;
                boolean z9 = false;
                int i30 = 0;
                int i31 = 0;
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                boolean z15 = false;
                boolean z16 = false;
                boolean z17 = false;
                String strCreateString16 = null;
                zzr[] zzrVarArr = null;
                while (source.dataPosition() < iValidateObjectHeader13) {
                    int i32 = source.readInt();
                    switch ((char) i32) {
                        case 2:
                            strCreateString16 = Protocol.Companion.createString(source, i32);
                            break;
                        case 3:
                            i28 = Protocol.Companion.readInt(source, i32);
                            break;
                        case 4:
                            i29 = Protocol.Companion.readInt(source, i32);
                            break;
                        case 5:
                            z9 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case 6:
                            i30 = Protocol.Companion.readInt(source, i32);
                            break;
                        case 7:
                            i31 = Protocol.Companion.readInt(source, i32);
                            break;
                        case '\b':
                            zzrVarArr = (zzr[]) Protocol.Companion.createTypedArray(source, i32, zzr.CREATOR);
                            break;
                        case '\t':
                            z10 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case '\n':
                            z11 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case 11:
                            z12 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case '\f':
                            z13 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case '\r':
                            z14 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case 14:
                            z15 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case 15:
                            z16 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        case 16:
                            z17 = Protocol.Companion.readBoolean(source, i32);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(source, i32);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader13);
                return new zzr(strCreateString16, i28, i29, z9, i30, i31, zzrVarArr, z10, z11, z12, z13, z14, z15, z16, z17);
            case 20:
                int iValidateObjectHeader14 = Protocol.Companion.validateObjectHeader(source);
                long j4 = 0;
                String strCreateString17 = null;
                int i33 = 0;
                int i34 = 0;
                while (source.dataPosition() < iValidateObjectHeader14) {
                    int i35 = source.readInt();
                    char c9 = (char) i35;
                    if (c9 == 1) {
                        i33 = Protocol.Companion.readInt(source, i35);
                    } else if (c9 == 2) {
                        i34 = Protocol.Companion.readInt(source, i35);
                    } else if (c9 == 3) {
                        strCreateString17 = Protocol.Companion.createString(source, i35);
                    } else if (c9 != 4) {
                        Protocol.Companion.skipUnknownField(source, i35);
                    } else {
                        j4 = Protocol.Companion.readLong(source, i35);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader14);
                return new zzt(i33, i34, j4, strCreateString17);
            case 21:
                int iValidateObjectHeader15 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString18 = null;
                com.google.android.gms.ads.internal.client.zze zzeVar2 = null;
                Bundle bundleCreateBundle4 = null;
                String strCreateString19 = null;
                String strCreateString20 = null;
                String strCreateString21 = null;
                String strCreateString22 = null;
                long j5 = 0;
                while (source.dataPosition() < iValidateObjectHeader15) {
                    int i36 = source.readInt();
                    switch ((char) i36) {
                        case 1:
                            strCreateString18 = Protocol.Companion.createString(source, i36);
                            break;
                        case 2:
                            j5 = Protocol.Companion.readLong(source, i36);
                            break;
                        case 3:
                            zzeVar2 = (com.google.android.gms.ads.internal.client.zze) Protocol.Companion.createParcelable(source, i36, com.google.android.gms.ads.internal.client.zze.CREATOR);
                            break;
                        case 4:
                            bundleCreateBundle4 = Protocol.Companion.createBundle(source, i36);
                            break;
                        case 5:
                            strCreateString19 = Protocol.Companion.createString(source, i36);
                            break;
                        case 6:
                            strCreateString20 = Protocol.Companion.createString(source, i36);
                            break;
                        case 7:
                            strCreateString21 = Protocol.Companion.createString(source, i36);
                            break;
                        case '\b':
                            strCreateString22 = Protocol.Companion.createString(source, i36);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(source, i36);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader15);
                return new zzv(strCreateString18, j5, zzeVar2, bundleCreateBundle4, strCreateString19, strCreateString20, strCreateString21, strCreateString22);
            case 22:
                int iValidateObjectHeader16 = Protocol.Companion.validateObjectHeader(source);
                int i37 = 0;
                while (source.dataPosition() < iValidateObjectHeader16) {
                    int i38 = source.readInt();
                    if (((char) i38) != 2) {
                        Protocol.Companion.skipUnknownField(source, i38);
                    } else {
                        i37 = Protocol.Companion.readInt(source, i38);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader16);
                return new zzx(i37);
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                int iValidateObjectHeader17 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString23 = null;
                String strCreateString24 = null;
                String strCreateString25 = null;
                while (source.dataPosition() < iValidateObjectHeader17) {
                    int i39 = source.readInt();
                    char c10 = (char) i39;
                    if (c10 == 1) {
                        strCreateString23 = Protocol.Companion.createString(source, i39);
                    } else if (c10 == 2) {
                        strCreateString24 = Protocol.Companion.createString(source, i39);
                    } else if (c10 != 3) {
                        Protocol.Companion.skipUnknownField(source, i39);
                    } else {
                        strCreateString25 = Protocol.Companion.createString(source, i39);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader17);
                return new com.google.android.gms.ads.internal.offline.buffering.zza(strCreateString23, strCreateString24, strCreateString25);
            case 24:
                int iValidateObjectHeader18 = Protocol.Companion.validateObjectHeader(source);
                boolean z18 = false;
                String strCreateString26 = null;
                String strCreateString27 = null;
                String strCreateString28 = null;
                String strCreateString29 = null;
                String strCreateString30 = null;
                String strCreateString31 = null;
                String strCreateString32 = null;
                Intent intent = null;
                IBinder iBinder4 = null;
                while (source.dataPosition() < iValidateObjectHeader18) {
                    int i40 = source.readInt();
                    switch ((char) i40) {
                        case 2:
                            strCreateString26 = Protocol.Companion.createString(source, i40);
                            break;
                        case 3:
                            strCreateString27 = Protocol.Companion.createString(source, i40);
                            break;
                        case 4:
                            strCreateString28 = Protocol.Companion.createString(source, i40);
                            break;
                        case 5:
                            strCreateString29 = Protocol.Companion.createString(source, i40);
                            break;
                        case 6:
                            strCreateString30 = Protocol.Companion.createString(source, i40);
                            break;
                        case 7:
                            strCreateString31 = Protocol.Companion.createString(source, i40);
                            break;
                        case '\b':
                            strCreateString32 = Protocol.Companion.createString(source, i40);
                            break;
                        case '\t':
                            intent = (Intent) Protocol.Companion.createParcelable(source, i40, Intent.CREATOR);
                            break;
                        case '\n':
                            iBinder4 = Protocol.Companion.readIBinder(source, i40);
                            break;
                        case 11:
                            z18 = Protocol.Companion.readBoolean(source, i40);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(source, i40);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader18);
                return new com.google.android.gms.ads.internal.overlay.zzc(strCreateString26, strCreateString27, strCreateString28, strCreateString29, strCreateString30, strCreateString31, strCreateString32, intent, iBinder4, z18);
            case 25:
                int iValidateObjectHeader19 = Protocol.Companion.validateObjectHeader(source);
                long j6 = 0;
                boolean z19 = false;
                int i41 = 0;
                int i42 = 0;
                boolean z20 = false;
                com.google.android.gms.ads.internal.overlay.zzc zzcVar2 = null;
                IBinder iBinder5 = null;
                IBinder iBinder6 = null;
                IBinder iBinder7 = null;
                IBinder iBinder8 = null;
                String strCreateString33 = null;
                String strCreateString34 = null;
                IBinder iBinder9 = null;
                String strCreateString35 = null;
                VersionInfoParcel versionInfoParcel = null;
                String strCreateString36 = null;
                zzl zzlVar = null;
                IBinder iBinder10 = null;
                String strCreateString37 = null;
                String strCreateString38 = null;
                String strCreateString39 = null;
                IBinder iBinder11 = null;
                IBinder iBinder12 = null;
                IBinder iBinder13 = null;
                while (source.dataPosition() < iValidateObjectHeader19) {
                    int i43 = source.readInt();
                    switch ((char) i43) {
                        case 2:
                            zzcVar2 = (com.google.android.gms.ads.internal.overlay.zzc) Protocol.Companion.createParcelable(source, i43, com.google.android.gms.ads.internal.overlay.zzc.CREATOR);
                            break;
                        case 3:
                            iBinder5 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 4:
                            iBinder6 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 5:
                            iBinder7 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 6:
                            iBinder8 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 7:
                            strCreateString33 = Protocol.Companion.createString(source, i43);
                            break;
                        case '\b':
                            z19 = Protocol.Companion.readBoolean(source, i43);
                            break;
                        case '\t':
                            strCreateString34 = Protocol.Companion.createString(source, i43);
                            break;
                        case '\n':
                            iBinder9 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 11:
                            i41 = Protocol.Companion.readInt(source, i43);
                            break;
                        case '\f':
                            i42 = Protocol.Companion.readInt(source, i43);
                            break;
                        case '\r':
                            strCreateString35 = Protocol.Companion.createString(source, i43);
                            break;
                        case 14:
                            versionInfoParcel = (VersionInfoParcel) Protocol.Companion.createParcelable(source, i43, VersionInfoParcel.CREATOR);
                            break;
                        case 15:
                        case 20:
                        case 21:
                        case 22:
                        case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                        default:
                            Protocol.Companion.skipUnknownField(source, i43);
                            break;
                        case 16:
                            strCreateString36 = Protocol.Companion.createString(source, i43);
                            break;
                        case 17:
                            zzlVar = (zzl) Protocol.Companion.createParcelable(source, i43, zzl.CREATOR);
                            break;
                        case 18:
                            iBinder10 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 19:
                            strCreateString37 = Protocol.Companion.createString(source, i43);
                            break;
                        case 24:
                            strCreateString38 = Protocol.Companion.createString(source, i43);
                            break;
                        case 25:
                            strCreateString39 = Protocol.Companion.createString(source, i43);
                            break;
                        case 26:
                            iBinder11 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                            iBinder12 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 28:
                            iBinder13 = Protocol.Companion.readIBinder(source, i43);
                            break;
                        case 29:
                            z20 = Protocol.Companion.readBoolean(source, i43);
                            break;
                        case 30:
                            j6 = Protocol.Companion.readLong(source, i43);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader19);
                return new AdOverlayInfoParcel(zzcVar2, iBinder5, iBinder6, iBinder7, iBinder8, strCreateString33, z19, strCreateString34, iBinder9, i41, i42, strCreateString35, versionInfoParcel, strCreateString36, zzlVar, iBinder10, strCreateString37, strCreateString38, strCreateString39, iBinder11, iBinder12, iBinder13, z20, j6);
            case 26:
                int iValidateObjectHeader20 = Protocol.Companion.validateObjectHeader(source);
                int i44 = 0;
                int i45 = 0;
                boolean z21 = false;
                boolean z22 = false;
                String strCreateString40 = null;
                while (source.dataPosition() < iValidateObjectHeader20) {
                    int i46 = source.readInt();
                    char c11 = (char) i46;
                    if (c11 == 2) {
                        strCreateString40 = Protocol.Companion.createString(source, i46);
                    } else if (c11 == 3) {
                        i44 = Protocol.Companion.readInt(source, i46);
                    } else if (c11 == 4) {
                        i45 = Protocol.Companion.readInt(source, i46);
                    } else if (c11 == 5) {
                        z21 = Protocol.Companion.readBoolean(source, i46);
                    } else if (c11 != 6) {
                        Protocol.Companion.skipUnknownField(source, i46);
                    } else {
                        z22 = Protocol.Companion.readBoolean(source, i46);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader20);
                return new VersionInfoParcel(strCreateString40, i44, i45, z21, z22);
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                int iValidateObjectHeader21 = Protocol.Companion.validateObjectHeader(source);
                int i47 = 0;
                String strCreateString41 = null;
                while (source.dataPosition() < iValidateObjectHeader21) {
                    int i48 = source.readInt();
                    char c12 = (char) i48;
                    if (c12 == 1) {
                        strCreateString41 = Protocol.Companion.createString(source, i48);
                    } else if (c12 != 2) {
                        Protocol.Companion.skipUnknownField(source, i48);
                    } else {
                        i47 = Protocol.Companion.readInt(source, i48);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader21);
                return new zzbb(strCreateString41, i47);
            case 28:
                int iValidateObjectHeader22 = Protocol.Companion.validateObjectHeader(source);
                boolean z23 = false;
                boolean z24 = false;
                boolean z25 = false;
                int i49 = 0;
                boolean z26 = false;
                boolean z27 = false;
                boolean z28 = false;
                float f = 0.0f;
                String strCreateString42 = null;
                while (source.dataPosition() < iValidateObjectHeader22) {
                    int i50 = source.readInt();
                    switch ((char) i50) {
                        case 2:
                            z23 = Protocol.Companion.readBoolean(source, i50);
                            break;
                        case 3:
                            z24 = Protocol.Companion.readBoolean(source, i50);
                            break;
                        case 4:
                            strCreateString42 = Protocol.Companion.createString(source, i50);
                            break;
                        case 5:
                            z25 = Protocol.Companion.readBoolean(source, i50);
                            break;
                        case 6:
                            f = Protocol.Companion.readFloat(source, i50);
                            break;
                        case 7:
                            i49 = Protocol.Companion.readInt(source, i50);
                            break;
                        case '\b':
                            z26 = Protocol.Companion.readBoolean(source, i50);
                            break;
                        case '\t':
                            z27 = Protocol.Companion.readBoolean(source, i50);
                            break;
                        case '\n':
                            z28 = Protocol.Companion.readBoolean(source, i50);
                            break;
                        default:
                            Protocol.Companion.skipUnknownField(source, i50);
                            break;
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader22);
                return new zzl(z23, z24, strCreateString42, z25, f, i49, z26, z27, z28);
            default:
                int iValidateObjectHeader23 = Protocol.Companion.validateObjectHeader(source);
                String strCreateString43 = null;
                int i51 = 0;
                while (source.dataPosition() < iValidateObjectHeader23) {
                    int i52 = source.readInt();
                    char c13 = (char) i52;
                    if (c13 == 1) {
                        strCreateString43 = Protocol.Companion.createString(source, i52);
                    } else if (c13 != 2) {
                        Protocol.Companion.skipUnknownField(source, i52);
                    } else {
                        i51 = Protocol.Companion.readInt(source, i52);
                    }
                }
                Protocol.Companion.ensureAtEnd(source, iValidateObjectHeader23);
                return new zzc(strCreateString43, i51);
        }
    }
}
