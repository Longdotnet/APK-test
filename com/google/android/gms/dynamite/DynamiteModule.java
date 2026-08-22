package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;
import com.facebook.GraphRequest;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.ads.zzbla$$ExternalSyntheticApiModelOutline2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamiteModule {
    public static Boolean zzb = null;
    public static String zzc = null;
    public static boolean zzd = false;
    public static int zze = -1;
    public static Boolean zzf;
    public static zzq zzk;
    public static zzr zzl;
    public final Context zzj;
    public static final ThreadLocal zzg = new ThreadLocal();
    public static final zzd zzh = new zzd(0);
    public static final GraphRequest.Companion zzi = new GraphRequest.Companion(29);
    public static final com.google.firebase.auth.zzr PREFER_REMOTE = new com.google.firebase.auth.zzr(1);
    public static final com.google.firebase.auth.zzr PREFER_HIGHEST_OR_LOCAL_VERSION = new com.google.firebase.auth.zzr(2);
    public static final com.google.firebase.auth.zzr PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.google.firebase.auth.zzr(3);

    /* JADX INFO: loaded from: classes.dex */
    public class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: loaded from: classes.dex */
    public final class LoadingException extends Exception {
    }

    public DynamiteModule(Context context) {
        this.zzj = context;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0212 A[Catch: all -> 0x0210, TRY_ENTER, TryCatch #1 {, blocks: (B:30:0x00b6, B:32:0x00bc, B:33:0x00be, B:101:0x0212, B:102:0x0219), top: B:153:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0271  */
    /* JADX WARN: Code duplicated, block: B:121:0x0279  */
    /* JADX WARN: Code duplicated, block: B:124:0x0283  */
    /* JADX WARN: Code duplicated, block: B:132:0x029c A[Catch: all -> 0x029a, TryCatch #6 {all -> 0x029a, blocks: (B:132:0x029c, B:133:0x02b3, B:128:0x0292, B:129:0x0299, B:134:0x02b4, B:135:0x02e0, B:27:0x00b1, B:105:0x021c, B:106:0x0226, B:109:0x0229, B:110:0x022a, B:111:0x0231), top: B:158:0x007c, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x009d A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #9 {all -> 0x008d, blocks: (B:9:0x0053, B:13:0x0081, B:21:0x0097, B:24:0x009d, B:27:0x00b1, B:105:0x021c, B:106:0x0226, B:109:0x0229, B:110:0x022a, B:111:0x0231, B:112:0x0232, B:114:0x0250, B:116:0x025d), top: B:161:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc A[Catch: all -> 0x0210, TryCatch #1 {, blocks: (B:30:0x00b6, B:32:0x00bc, B:33:0x00be, B:101:0x0212, B:102:0x0219), top: B:153:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TRY_ENTER, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c8 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00e9 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TRY_ENTER, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0168 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0173 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0192 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01a5 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01ad A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01be A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x01c8 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01d9 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01ef A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01f8 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0200 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0208 A[Catch: all -> 0x0127, LoadingException -> 0x012a, RemoteException -> 0x012d, TryCatch #10 {RemoteException -> 0x012d, LoadingException -> 0x012a, all -> 0x0127, blocks: (B:29:0x00b5, B:35:0x00c1, B:37:0x00c8, B:38:0x00e3, B:42:0x00e9, B:44:0x00f1, B:46:0x00f5, B:47:0x0103, B:54:0x0111, B:62:0x0145, B:64:0x014d, B:66:0x0155, B:67:0x015c, B:61:0x0130, B:70:0x015f, B:71:0x0160, B:72:0x0167, B:73:0x0168, B:74:0x016f, B:77:0x0172, B:78:0x0173, B:80:0x0192, B:82:0x01a5, B:84:0x01ad, B:90:0x01e9, B:92:0x01ef, B:93:0x01f8, B:94:0x01ff, B:85:0x01be, B:86:0x01c5, B:88:0x01c8, B:89:0x01d9, B:95:0x0200, B:96:0x0207, B:97:0x0208, B:98:0x020f, B:104:0x021b), top: B:163:0x00b5 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:132:0x029c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00c8, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:78:0x0173, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.dynamite.zzn] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static DynamiteModule load(Context context, com.google.firebase.auth.zzr zzrVar, String str) throws Throwable {
        ?? r1;
        ?? r10;
        DynamiteModule dynamiteModule;
        int i;
        Boolean bool;
        zzq zzqVarZzg;
        int i2;
        IObjectWrapper iObjectWrapperZzh;
        Object objUnwrap;
        DynamiteModule dynamiteModule2;
        zzn zznVar;
        zzr zzrVar2;
        zzn zznVar2;
        boolean z;
        IObjectWrapper iObjectWrapperZze;
        Cursor cursor;
        int i3;
        Context context2 = context;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new LoadingException("null application Context");
        }
        ThreadLocal threadLocal = zzg;
        zzn zznVar3 = (zzn) threadLocal.get();
        zzn zznVar4 = new zzn();
        threadLocal.set(zznVar4);
        zzd zzdVar = zzh;
        Long l = (Long) zzdVar.get();
        long jLongValue = l.longValue();
        try {
            zzdVar.set(Long.valueOf(SystemClock.elapsedRealtime()));
            DynamiteModule$VersionPolicy$SelectionResult dynamiteModule$VersionPolicy$SelectionResultSelectModule = zzrVar.selectModule(context2, str, zzi);
            int i4 = dynamiteModule$VersionPolicy$SelectionResultSelectModule.localVersion;
            try {
                int i5 = dynamiteModule$VersionPolicy$SelectionResultSelectModule.remoteVersion;
                try {
                    Log.i("DynamiteModule", "Considering local module " + str + ":" + i4 + " and remote module " + str + ":" + i5);
                    int i6 = dynamiteModule$VersionPolicy$SelectionResultSelectModule.selection;
                    try {
                        if (i6 != 0) {
                            if (i6 != -1) {
                                i5 = i5;
                                if (i6 == 1 || (i3 = dynamiteModule$VersionPolicy$SelectionResultSelectModule.remoteVersion) != 0) {
                                    if (i6 == -1) {
                                        Log.i("DynamiteModule", "Selected local version of ".concat(str));
                                        dynamiteModule = new DynamiteModule(applicationContext);
                                    } else {
                                        if (i6 == 1) {
                                            throw new LoadingException("VersionPolicy returned invalid code:" + i6);
                                        }
                                        try {
                                            i = dynamiteModule$VersionPolicy$SelectionResultSelectModule.remoteVersion;
                                            try {
                                                synchronized (DynamiteModule.class) {
                                                    if (zzf(context)) {
                                                        throw new LoadingException("Remote loading disabled");
                                                    }
                                                    bool = zzb;
                                                }
                                                if (bool != null) {
                                                    throw new LoadingException("Failed to determine which loading route to use.");
                                                }
                                                if (bool.booleanValue()) {
                                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                                    synchronized (DynamiteModule.class) {
                                                        zzrVar2 = zzl;
                                                    }
                                                    if (zzrVar2 != null) {
                                                        throw new LoadingException("DynamiteLoaderV2 was not cached.");
                                                    }
                                                    zznVar2 = (zzn) threadLocal.get();
                                                    if (zznVar2 != null || zznVar2.zza == null) {
                                                        throw new LoadingException("No result cursor");
                                                    }
                                                    Context applicationContext2 = context.getApplicationContext();
                                                    Cursor cursor2 = zznVar2.zza;
                                                    new ObjectWrapper(null);
                                                    synchronized (DynamiteModule.class) {
                                                        z = zze >= 2;
                                                    }
                                                    if (z) {
                                                        Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                        iObjectWrapperZze = zzrVar2.zzf(new ObjectWrapper(applicationContext2), str, i, new ObjectWrapper(cursor2));
                                                    } else {
                                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                        iObjectWrapperZze = zzrVar2.zze(new ObjectWrapper(applicationContext2), str, i, new ObjectWrapper(cursor2));
                                                    }
                                                    Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapperZze);
                                                    if (context3 == null) {
                                                        throw new LoadingException("Failed to get module context");
                                                    }
                                                    dynamiteModule2 = new DynamiteModule(context3);
                                                } else {
                                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                                    zzqVarZzg = zzg(context);
                                                    if (zzqVarZzg != null) {
                                                        throw new LoadingException("Failed to create IDynamiteLoader.");
                                                    }
                                                    Parcel parcelZzB = zzqVarZzg.zzB(6, zzqVarZzg.zza());
                                                    i2 = parcelZzB.readInt();
                                                    parcelZzB.recycle();
                                                    if (i2 >= 3) {
                                                        zznVar = (zzn) threadLocal.get();
                                                        if (zznVar != null) {
                                                            throw new LoadingException("No cached result cursor holder");
                                                        }
                                                        iObjectWrapperZzh = zzqVarZzg.zzi(new ObjectWrapper(context2), str, i, new ObjectWrapper(zznVar.zza));
                                                    } else if (i2 == 2) {
                                                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                        iObjectWrapperZzh = zzqVarZzg.zzj(new ObjectWrapper(context2), str, i);
                                                    } else {
                                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                        iObjectWrapperZzh = zzqVarZzg.zzh(new ObjectWrapper(context2), str, i);
                                                    }
                                                    objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                                    if (objUnwrap != null) {
                                                        throw new LoadingException("Failed to load remote module.");
                                                    }
                                                    dynamiteModule2 = new DynamiteModule((Context) objUnwrap);
                                                }
                                                dynamiteModule = dynamiteModule2;
                                            } catch (RemoteException e) {
                                                throw new LoadingException("Failed to load remote module.", e);
                                            } catch (LoadingException e2) {
                                                throw e2;
                                            } catch (Throwable th) {
                                                Hex.addDynamiteErrorToDropBox(context2, th);
                                                throw new LoadingException("Failed to load remote module.", th);
                                            }
                                        } catch (LoadingException e3) {
                                            Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                                            int i7 = dynamiteModule$VersionPolicy$SelectionResultSelectModule.localVersion;
                                            if (i7 == 0 || zzrVar.selectModule(context2, str, new Logger$LogcatLogger(i7)).selection != -1) {
                                                throw new LoadingException("Remote load failed. No local fallback found.", e3);
                                            }
                                            Log.i("DynamiteModule", "Selected local version of ".concat(str));
                                            dynamiteModule = new DynamiteModule(applicationContext);
                                        }
                                    }
                                    if (jLongValue == 0) {
                                        zzh.remove();
                                    } else {
                                        zzh.set(l);
                                    }
                                    cursor = zznVar4.zza;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    zzg.set(zznVar3);
                                    return dynamiteModule;
                                }
                            } else if (dynamiteModule$VersionPolicy$SelectionResultSelectModule.localVersion != 0) {
                                i6 = -1;
                                i5 = i5;
                                if (i6 == 1) {
                                }
                                if (i6 == -1) {
                                    Log.i("DynamiteModule", "Selected local version of ".concat(str));
                                    dynamiteModule = new DynamiteModule(applicationContext);
                                } else {
                                    if (i6 == 1) {
                                        throw new LoadingException("VersionPolicy returned invalid code:" + i6);
                                    }
                                    i = dynamiteModule$VersionPolicy$SelectionResultSelectModule.remoteVersion;
                                    synchronized (DynamiteModule.class) {
                                        if (zzf(context)) {
                                            throw new LoadingException("Remote loading disabled");
                                        }
                                        bool = zzb;
                                        if (bool != null) {
                                            throw new LoadingException("Failed to determine which loading route to use.");
                                        }
                                        if (bool.booleanValue()) {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                            synchronized (DynamiteModule.class) {
                                                zzrVar2 = zzl;
                                                if (zzrVar2 != null) {
                                                    throw new LoadingException("DynamiteLoaderV2 was not cached.");
                                                }
                                                zznVar2 = (zzn) threadLocal.get();
                                                if (zznVar2 != null) {
                                                }
                                                throw new LoadingException("No result cursor");
                                            }
                                        }
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                        zzqVarZzg = zzg(context);
                                        if (zzqVarZzg != null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.");
                                        }
                                        Parcel parcelZzB2 = zzqVarZzg.zzB(6, zzqVarZzg.zza());
                                        i2 = parcelZzB2.readInt();
                                        parcelZzB2.recycle();
                                        if (i2 >= 3) {
                                            zznVar = (zzn) threadLocal.get();
                                            if (zznVar != null) {
                                                throw new LoadingException("No cached result cursor holder");
                                            }
                                            iObjectWrapperZzh = zzqVarZzg.zzi(new ObjectWrapper(context2), str, i, new ObjectWrapper(zznVar.zza));
                                        } else if (i2 == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            iObjectWrapperZzh = zzqVarZzg.zzj(new ObjectWrapper(context2), str, i);
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            iObjectWrapperZzh = zzqVarZzg.zzh(new ObjectWrapper(context2), str, i);
                                        }
                                        objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                        if (objUnwrap != null) {
                                            throw new LoadingException("Failed to load remote module.");
                                        }
                                        dynamiteModule2 = new DynamiteModule((Context) objUnwrap);
                                        dynamiteModule = dynamiteModule2;
                                    }
                                }
                                if (jLongValue == 0) {
                                    zzh.remove();
                                } else {
                                    zzh.set(l);
                                }
                                cursor = zznVar4.zza;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                zzg.set(zznVar3);
                                return dynamiteModule;
                            }
                        }
                        i5 = i3;
                        throw new LoadingException("No acceptable module " + str + " found. Local version is " + dynamiteModule$VersionPolicy$SelectionResultSelectModule.localVersion + " and remote version is " + dynamiteModule$VersionPolicy$SelectionResultSelectModule.remoteVersion + ".");
                    } catch (Throwable th2) {
                        th = th2;
                        r1 = context2;
                        r10 = i5;
                        if (jLongValue == 0) {
                            zzh.remove();
                        } else {
                            zzh.set(l);
                        }
                        Cursor cursor3 = r1.zza;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        zzg.set(r10);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r10 = zznVar3;
                    r1 = zznVar4;
                }
            } catch (Throwable th4) {
                th = th4;
                r1 = zznVar4;
                r10 = zznVar3;
            }
        } catch (Throwable th5) {
            th = th5;
            r1 = zznVar4;
            r10 = zznVar3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x018e  */
    /* JADX WARN: Code duplicated, block: B:50:0x00af A[Catch: all -> 0x0037, TryCatch #8 {all -> 0x0037, blocks: (B:9:0x0027, B:11:0x0033, B:51:0x00b8, B:16:0x003c, B:18:0x0043, B:20:0x0049, B:25:0x004f, B:27:0x0053, B:30:0x005c, B:32:0x0064, B:35:0x006b, B:42:0x0097, B:43:0x009f, B:38:0x0072, B:40:0x0078, B:41:0x0089, B:46:0x00a2, B:49:0x00a5, B:50:0x00af, B:17:0x003f), top: B:141:0x0027, inners: #11 }] */
    public static int zza(Context context, String str, boolean z) {
        Throwable th;
        RemoteException e;
        int i;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                boolean z2 = true;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else if (classLoader != null) {
                                    try {
                                        zzd(classLoader);
                                    } catch (LoadingException unused) {
                                    }
                                    bool = Boolean.TRUE;
                                } else {
                                    if (!zzf(context)) {
                                        return 0;
                                    }
                                    if (zzd) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        Boolean bool2 = Boolean.TRUE;
                                        if (bool2.equals(null)) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        } else {
                                            try {
                                                int iZzb = zzb(context, str, z, true);
                                                String str2 = zzc;
                                                if (str2 != null && !str2.isEmpty()) {
                                                    ClassLoader classLoaderZza = TextStreamsKt.zza();
                                                    if (classLoaderZza == null) {
                                                        if (Build.VERSION.SDK_INT >= 29) {
                                                            zzbla$$ExternalSyntheticApiModelOutline2.m();
                                                            String str3 = zzc;
                                                            zzah.checkNotNull(str3);
                                                            classLoaderZza = zzbla$$ExternalSyntheticApiModelOutline2.m(ClassLoader.getSystemClassLoader(), str3);
                                                        } else {
                                                            String str4 = zzc;
                                                            zzah.checkNotNull(str4);
                                                            classLoaderZza = new zzc(str4, ClassLoader.getSystemClassLoader());
                                                        }
                                                    }
                                                    zzd(classLoaderZza);
                                                    declaredField.set(null, classLoaderZza);
                                                    zzb = bool2;
                                                    return iZzb;
                                                }
                                                return iZzb;
                                            } catch (LoadingException unused2) {
                                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                bool = Boolean.FALSE;
                                            }
                                        }
                                    }
                                }
                                zzb = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e3) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e3.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarZzg = zzg(context);
                try {
                    if (zzqVarZzg == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelZzB = zzqVarZzg.zzB(6, zzqVarZzg.zza());
                        int i2 = parcelZzB.readInt();
                        parcelZzB.recycle();
                        if (i2 >= 3) {
                            ThreadLocal threadLocal = zzg;
                            zzn zznVar = (zzn) threadLocal.get();
                            if (zznVar != null && (cursor = zznVar.zza) != null) {
                                return cursor.getInt(0);
                            }
                            ObjectWrapper objectWrapper = new ObjectWrapper(context);
                            long jLongValue = ((Long) zzh.get()).longValue();
                            Parcel parcelZza = zzqVarZzg.zza();
                            com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
                            parcelZza.writeString(str);
                            parcelZza.writeInt(z ? 1 : 0);
                            parcelZza.writeLong(jLongValue);
                            Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzqVarZzg.zzB(7, parcelZza)));
                            if (cursor3 != null) {
                                try {
                                    if (cursor3.moveToFirst()) {
                                        i = cursor3.getInt(0);
                                        if (i > 0) {
                                            zzn zznVar2 = (zzn) threadLocal.get();
                                            if (zznVar2 == null || zznVar2.zza != null) {
                                                z2 = false;
                                            } else {
                                                zznVar2.zza = cursor3;
                                            }
                                            cursor2 = z2 ? null : cursor3;
                                        }
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e4) {
                                    e = e4;
                                    cursor2 = cursor3;
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e.getMessage());
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor2 = cursor3;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor3 == null) {
                                return 0;
                            }
                            cursor3.close();
                            return 0;
                        }
                        if (i2 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            ObjectWrapper objectWrapper2 = new ObjectWrapper(context);
                            Parcel parcelZza2 = zzqVarZzg.zza();
                            com.google.android.gms.internal.common.zzc.zze(parcelZza2, objectWrapper2);
                            parcelZza2.writeString(str);
                            parcelZza2.writeInt(z ? 1 : 0);
                            Parcel parcelZzB2 = zzqVarZzg.zzB(5, parcelZza2);
                            i = parcelZzB2.readInt();
                            parcelZzB2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            ObjectWrapper objectWrapper3 = new ObjectWrapper(context);
                            Parcel parcelZza3 = zzqVarZzg.zza();
                            com.google.android.gms.internal.common.zzc.zze(parcelZza3, objectWrapper3);
                            parcelZza3.writeString(str);
                            parcelZza3.writeInt(z ? 1 : 0);
                            Parcel parcelZzB3 = zzqVarZzg.zzB(3, parcelZza3);
                            i = parcelZzB3.readInt();
                            parcelZzB3.recycle();
                        }
                        return i;
                    } catch (RemoteException e5) {
                        e = e5;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            Hex.addDynamiteErrorToDropBox(context, th5);
            throw th5;
        }
    }

    public static int zzb(Context context, String str, boolean z, boolean z2) throws Throwable {
        boolean z3;
        Cursor cursor = null;
        try {
            try {
                boolean z4 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").path(true != z ? PZmDzEagKNdW.VVgzuEjkPhLa : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) zzh.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z5 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    try {
                                        zzc = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            zze = cursorQuery.getInt(columnIndex);
                                        }
                                        int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            z3 = cursorQuery.getInt(columnIndex2) != 0;
                                            zzd = z3;
                                        } else {
                                            z3 = false;
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                zzn zznVar = (zzn) zzg.get();
                                if (zznVar == null || zznVar.zza != null) {
                                    z4 = false;
                                } else {
                                    zznVar.zza = cursorQuery;
                                }
                                cursor = z4 ? null : cursorQuery;
                                z5 = z3;
                            } else {
                                cursor = cursorQuery;
                            }
                            if (z2 && z5) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl");
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                            if (e instanceof LoadingException) {
                                throw e;
                            }
                            throw new LoadingException("V2 version check failed: " + e.getMessage(), e);
                        }
                    } catch (Exception e) {
                        e = e;
                    } catch (Throwable th2) {
                        cursor = cursorQuery;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.");
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void zzd(ClassLoader classLoader) throws LoadingException {
        try {
            zzr zzrVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException e) {
            e = e;
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        }
    }

    public static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            zzf = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(str), e);
        }
    }

    public static int getLocalVersion(Context context, String str) {
        String str2 = kBfGXgdfpo.PLxaq;
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass(str2 + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField(dLDI.DCrWAWT);
            if (zzah.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass(oKjScaD.sEyoYajja).newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }
}
