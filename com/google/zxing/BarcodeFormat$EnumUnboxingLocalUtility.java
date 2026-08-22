package com.google.zxing;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.internal.ads.zzea;
import com.google.android.gms.internal.ads.zzgym;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzjm;
import com.google.android.gms.internal.p002firebaseauthapi.zzacn;
import com.google.android.gms.internal.play_billing.zzby;
import com.google.protobuf.DescriptorProtos;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class BarcodeFormat$EnumUnboxingLocalUtility {
    public static int m(int i, int i2, int i3) {
        return zzgym.zzD(i) + i2 + i3;
    }

    public static int m$1(int i, int i2, int i3) {
        return zzacn.zzE(i) + i2 + i3;
    }

    public static int m$2(int i, int i2, int i3) {
        return zzjm.zzA(i) + i2 + i3;
    }

    public static int m$3(int i, int i2, int i3) {
        return zzby.zzw(i) + i2 + i3;
    }

    public static /* synthetic */ String stringValueOf(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String stringValueOf$1(int i) {
        switch (i) {
            case 1:
                return "AZTEC";
            case 2:
                return "CODABAR";
            case 3:
                return "CODE_39";
            case 4:
                return "CODE_93";
            case 5:
                return "CODE_128";
            case 6:
                return "DATA_MATRIX";
            case 7:
                return "EAN_8";
            case 8:
                return "EAN_13";
            case 9:
                return "ITF";
            case 10:
                return "MAXICODE";
            case 11:
                return "PDF_417";
            case 12:
                return "QR_CODE";
            case 13:
                return "RSS_14";
            case 14:
                return "RSS_EXPANDED";
            case 15:
                return "UPC_A";
            case 16:
                return "UPC_E";
            case 17:
                return gZrKCJ.VszsdMD;
            default:
                return "null";
        }
    }

    public static int m(int i, int i2, int i3, int i4) {
        return zzacn.zzE(i) + i2 + i3 + i4;
    }

    public static int m$1(int i, int i2, int i3, int i4) {
        return zzjm.zzA(i) + i2 + i3 + i4;
    }

    public static Object m(int i) {
        return DescriptorProtos.getDescriptor().getMessageTypes().get(i);
    }

    public static Object m(zzbl zzblVar, int i, List list, int i2) {
        zzh.zzh(zzblVar.name(), i, list);
        return list.get(i2);
    }

    public static String m(long j, String str) {
        return str + j;
    }

    public static void m(int i, HashMap map, String str, int i2, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
    }

    public static /* synthetic */ void m(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void m(String str, String str2, String str3) {
        zzea.zzf(str3, str2.concat(String.valueOf(str)));
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ void m110m(int i) {
        if (i != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        Intrinsics.sanitizeStackTrace(nullPointerException, Intrinsics.class.getName());
        throw nullPointerException;
    }

    public static /* synthetic */ void m(int i, String str) {
        if (i == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = Intrinsics.class.getName();
            int i2 = 0;
            while (!stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            while (stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
            sbM22m.append(str);
            NullPointerException nullPointerException = new NullPointerException(sbM22m.toString());
            Intrinsics.sanitizeStackTrace(nullPointerException, Intrinsics.class.getName());
            throw nullPointerException;
        }
    }
}
