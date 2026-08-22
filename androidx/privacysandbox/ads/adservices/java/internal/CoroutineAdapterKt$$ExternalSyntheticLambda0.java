package androidx.privacysandbox.ads.adservices.java.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TheSpikeCrossLog;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzea;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.android.gms.tasks.Task;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class CoroutineAdapterKt$$ExternalSyntheticLambda0 {
    public static final boolean _isFinished(int i) {
        return i == 3 || i == 4 || i == 6;
    }

    public static int m(int i, int i2, int i3, int i4) {
        return ((i * i2) + i3) * i4;
    }

    public static String m$1(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ String stringValueOf$1(int i) {
        switch (i) {
            case 1:
                return "NOT_REQUIRED";
            case 2:
                return "CONNECTED";
            case 3:
                return "UNMETERED";
            case 4:
                return "NOT_ROAMING";
            case 5:
                return "METERED";
            case 6:
                return "TEMPORARILY_UNMETERED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String stringValueOf$3(int i) {
        switch (i) {
            case 1:
                return "ENQUEUED";
            case 2:
                return "RUNNING";
            case 3:
                return "SUCCEEDED";
            case 4:
                return "FAILED";
            case 5:
                return GsPcpBmONXh.pCGdlNKp;
            case 6:
                return "CANCELLED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String stringValueOf$4(int i) {
        switch (i) {
            case 1:
                return "Startup";
            case 2:
                return "Splash";
            case 3:
                return "Splash2";
            case 4:
                return "APKExpansionDownload";
            case 5:
                return "InitRunner";
            case 6:
                return "WaitForDoStartup";
            case 7:
                return "WaitOnTimer";
            case 8:
                return "DoStartup";
            case 9:
                return "Process";
            default:
                return "null";
        }
    }

    public static int m(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    public static IObjectWrapper m(Parcel parcel) {
        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapperAsInterface;
    }

    public static String m$1(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static Object m(int i) {
        return TheSpikeCrossLog.getDescriptor().getMessageTypes().get(i);
    }

    public static String m(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    public static int m$1(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static String m(int i, String str) {
        return str + i;
    }

    public static String m(int i, String str, double d, Task task) {
        RunnerJNILib.DsMapAddDouble(i, str, d);
        return task.getException().getMessage();
    }

    public static String m(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String m(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder m(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: m */
    public static StringBuilder m21m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: m */
    public static StringBuilder m22m(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    /* JADX INFO: renamed from: m */
    public static void m23m(int i, String str, String str2) {
        zzea.zzf(str2, str + i);
    }

    public static void m(DefaultClock defaultClock, Bundle bundle, String str) {
        defaultClock.getClass();
        bundle.putLong(str, System.currentTimeMillis());
    }
}
