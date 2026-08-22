package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: classes2.dex */
public final class zzlb extends zzgl {
    public static final String[] zza = {"firebase_", "google_", "ga_"};
    public static final String[] zzb = {"_err"};
    public SecureRandom zzc;
    public final AtomicLong zzd;
    public int zze;
    public Integer zzf;

    public zzlb(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzf = null;
        this.zzd = new AtomicLong(0L);
    }

    public static String zzD(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static MessageDigest zzF() {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static void zzN(zzla zzlaVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzao(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzlaVar.zza(str, bundle);
    }

    public static boolean zzaf(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean zzah(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzai(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean zzaj(Context context) {
        ActivityInfo receiverInfo;
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zzak(Context context) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzat(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzat(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzam(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            com.google.android.gms.common.internal.zzah.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return !TextUtils.isEmpty(str4);
            }
            return !str3.equals(str4);
        }
        if (zIsEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static byte[] zzan(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static final boolean zzao(int i, Bundle bundle) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean zzas(String str, String[] strArr) {
        com.google.android.gms.common.internal.zzah.checkNotNull(strArr);
        for (Object obj : strArr) {
            if (str == obj) {
                return true;
            }
            if (str != null && str.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzat(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static long zzp(byte[] bArr) {
        com.google.android.gms.common.internal.zzah.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        com.google.android.gms.common.internal.zzah.checkState$1(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
        }
        return j;
    }

    public final Object zzA(Object obj, String str) {
        boolean zEquals = "_ev".equals(str);
        int i = 256;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zEquals) {
            zzfrVar.getClass();
            return zzar(256, obj, true, true);
        }
        if (zzah(str)) {
            zzfrVar.getClass();
        } else {
            zzfrVar.getClass();
            i = 100;
        }
        return zzar(i, obj, false, true);
    }

    public final Object zzB(Object obj, String str) {
        return "_ldl".equals(str) ? zzar(zzaq(str), obj, true, false) : zzar(zzaq(str), obj, false, false);
    }

    public final SecureRandom zzG() {
        zzg();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public final void zzI(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(Long.valueOf(j2), "Params already contained engagement");
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzJ(Bundle bundle, int i, String str, Object obj) {
        if (zzao(i, bundle)) {
            ((zzfr) this.mBuilder).getClass();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzlb zzlbVar = ((zzfr) this.mBuilder).zzp;
                zzfr.zzP(zzlbVar);
                zzlbVar.zzO(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void zzM(RealConnectionPool realConnectionPool, int i) {
        Bundle bundle = (Bundle) realConnectionPool.connections;
        int i2 = 0;
        for (String str : new TreeSet(bundle.keySet())) {
            if (zzai(str) && (i2 = i2 + 1) > i) {
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i, "Event can't contain more than ", " params");
                zzfr zzfrVar = (zzfr) this.mBuilder;
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                String string = sbM.toString();
                String str2 = (String) realConnectionPool.cleanupQueue;
                zzec zzecVar = zzfrVar.zzq;
                zzehVar.zzf.zzc(zzecVar.zzd(str2), string, zzecVar.zzb(bundle));
                zzao(5, bundle);
                bundle.remove(str);
            }
        }
    }

    public final void zzO(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            zzfr zzfrVar = (zzfr) this.mBuilder;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzi.zzc(zzfrVar.zzq.zze(str), "Not putting event parameter. Invalid value type. name, type", simpleName);
        }
    }

    public final void zzP(zzcf zzcfVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning boolean value to wrapper");
        }
    }

    public final void zzQ(zzcf zzcfVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning bundle list to wrapper");
        }
    }

    public final void zzR(zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning bundle value to wrapper");
        }
    }

    public final void zzS(zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning byte array to wrapper");
        }
    }

    public final void zzT(zzcf zzcfVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning int value to wrapper");
        }
    }

    public final void zzU(zzcf zzcfVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning long value to wrapper");
        }
    }

    public final void zzV(String str, zzcf zzcfVar) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcfVar.zze(bundle);
        } catch (RemoteException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error returning string value to wrapper");
        }
    }

    public final void zzW(String str, String str2, Bundle bundle, List list, boolean z) {
        int iZzj;
        int iZza;
        if (bundle == null) {
            return;
        }
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzfrVar.getClass();
        int i = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str3)) {
                iZzj = !z ? zzj(str3) : 0;
                if (iZzj == 0) {
                    iZzj = zzi(str3);
                }
            } else {
                iZzj = 0;
            }
            if (iZzj != 0) {
                zzJ(bundle, iZzj, str3, iZzj == 3 ? str3 : null);
                bundle.remove(str3);
            } else {
                boolean zZzaf = zzaf(bundle.get(str3));
                zzeh zzehVar = zzfrVar.zzm;
                if (zZzaf) {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str3);
                    iZza = 22;
                } else {
                    iZza = zza(str, str3, bundle.get(str3), bundle, list, z, false);
                }
                if (iZza != 0 && !"_ev".equals(str3)) {
                    zzJ(bundle, iZza, str3, bundle.get(str3));
                    bundle.remove(str3);
                } else if (zzai(str3) && !zzas(str3, zzg.zzd$1) && (i = i + 1) > 0) {
                    zzfr.zzR(zzehVar);
                    zzec zzecVar = zzfrVar.zzq;
                    zzehVar.zzf.zzc(zzecVar.zzd(str), "Item cannot contain custom parameters", zzecVar.zzb(bundle));
                    zzao(23, bundle);
                    bundle.remove(str3);
                }
            }
        }
    }

    public final boolean zzX(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (!zIsEmpty) {
            com.google.android.gms.common.internal.zzah.checkNotNull(str);
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (TextUtils.isEmpty(zzfrVar.zzf)) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzf.zzb(zzeh.zzn(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(zzfrVar.zzf)) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzf.zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(str2);
        if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        zzeh zzehVar3 = zzfrVar.zzm;
        zzfr.zzR(zzehVar3);
        zzehVar3.zzf.zzb(zzeh.zzn(str2), "Invalid admob_app_id. Analytics disabled.");
        return false;
    }

    public final boolean zzZ(String str, String[] strArr, String[] strArr2, String str2) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        String[] strArr3 = zza;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzf.zzc(str, "Name starts with reserved prefix. Type, name", str2);
                return false;
            }
        }
        if (strArr == null || !zzas(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzas(str2, strArr2)) {
            return true;
        }
        zzeh zzehVar3 = zzfrVar.zzm;
        zzfr.zzR(zzehVar3);
        zzehVar3.zzf.zzc(str, "Name is reserved. Type, name", str2);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    public final int zza(String str, String str2, Object obj, Bundle bundle, List list, boolean z, boolean z2) {
        int i;
        int i2;
        int size;
        zzg();
        boolean zZzaf = zzaf(obj);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (!zZzaf) {
            i = 0;
        } else {
            if (!z2) {
                return 21;
            }
            if (!zzas(str2, zzg.zzc$1)) {
                return 20;
            }
            zzjm zzjmVarZzt = zzfrVar.zzt();
            zzjmVarZzt.zzg();
            zzjmVarZzt.zza();
            if (zzjmVarZzt.zzN()) {
                zzlb zzlbVar = ((zzfr) zzjmVarZzt.mBuilder).zzp;
                zzfr.zzP(zzlbVar);
                if (zzlbVar.zzm() < 200900) {
                    return 25;
                }
            }
            boolean z3 = obj instanceof Parcelable[];
            if (z3) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            } else {
                i = 0;
            }
            if (size > 200) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzi.zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str2, Integer.valueOf(size));
                if (z3) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str2, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str2, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i = 17;
            } else {
                i = 0;
            }
        }
        if (zzah(str) || zzah(str2)) {
            zzfrVar.getClass();
            i2 = 256;
        } else {
            zzfrVar.getClass();
            i2 = 100;
        }
        if (zzaa("param", str2, i2, obj)) {
            return i;
        }
        if (!z2) {
            return 4;
        }
        if (obj instanceof Bundle) {
            zzW(str, str2, (Bundle) obj, list, z);
        } else if (obj instanceof Parcelable[]) {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzi.zzc(parcelable.getClass(), "All Parcelable[] elements must be of type Bundle. Value type, name", str2);
                    return 4;
                }
                zzW(str, str2, (Bundle) parcelable, list, z);
            }
        } else {
            if (!(obj instanceof ArrayList)) {
                return 4;
            }
            ArrayList arrayList2 = (ArrayList) obj;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Object obj2 = arrayList2.get(i3);
                if (!(obj2 instanceof Bundle)) {
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzi.zzc(obj2 != null ? obj2.getClass() : "null", "All ArrayList elements must be of type Bundle. Value type, name", str2);
                    return 4;
                }
                zzW(str, str2, (Bundle) obj2, list, z);
            }
        }
        return i;
    }

    public final boolean zzaa(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i) {
                zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzi.zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean zzab(String str, String str2) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzf.zzb(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                zzeh zzehVar3 = zzfrVar.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzf.zzc(str, "Name must start with a letter or _ (underscore). Type, name", str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzeh zzehVar4 = zzfrVar.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzf.zzc(str, "Name must consist of letters, digits or _ (underscores). Type, name", str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzac(String str, String str2) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzf.zzb(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzf.zzc(str, "Name must start with a letter. Type, name", str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzeh zzehVar4 = zzfrVar.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzf.zzc(str, "Name must consist of letters, digits or _ (underscores). Type, name", str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzad(String str) {
        zzg();
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (Wrappers.packageManager(zzfrVar.zze).val$context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zzb(str, "Permission not granted");
        return false;
    }

    public final boolean zzag(Context context, String str) {
        Signature[] signatureArr;
        zzfr zzfrVar = (zzfr) this.mBuilder;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(64, str);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(e, "Package name not found");
            return true;
        } catch (CertificateException e2) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e2, "Error obtaining certificate");
            return true;
        }
    }

    public final int zzaq(String str) {
        boolean zEquals = "_ldl".equals(str);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (zEquals) {
            zzfrVar.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            zzfrVar.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            zzfrVar.getClass();
            return 100;
        }
        zzfrVar.getClass();
        return 36;
    }

    public final Object zzar(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zzD(obj.toString(), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleZzt = zzt((Bundle) parcelable);
                if (!bundleZzt.isEmpty()) {
                    arrayList.add(bundleZzt);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int zzd(Object obj, String str) {
        return "_ldl".equals(str) ? zzaa("user property referrer", str, zzaq(str), obj) : zzaa("user property", str, zzaq(str), obj) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return true;
    }

    public final int zzh(String str) {
        if (!zzab("event", str)) {
            return 2;
        }
        if (!zzZ("event", zzg.f3zza, zzg.zzb, str)) {
            return 13;
        }
        ((zzfr) this.mBuilder).getClass();
        return !zzY(40, "event", str) ? 2 : 0;
    }

    public final int zzi(String str) {
        if (!zzab("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        ((zzfr) this.mBuilder).getClass();
        return !zzY(40, "event param", str) ? 3 : 0;
    }

    public final int zzj(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        ((zzfr) this.mBuilder).getClass();
        return !zzY(40, "event param", str) ? 3 : 0;
    }

    public final int zzl(String str) {
        if (!zzab("user property", str)) {
            return 6;
        }
        if (!zzZ("user property", zzg.zza$2, null, str)) {
            return 15;
        }
        ((zzfr) this.mBuilder).getClass();
        return !zzY(24, "user property", str) ? 6 : 0;
    }

    public final int zzm() {
        if (this.zzf == null) {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
            Context context = ((zzfr) this.mBuilder).zze;
            googleApiAvailabilityLight.getClass();
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getApkVersion(context) / 1000);
        }
        return this.zzf.intValue();
    }

    public final long zzq() {
        long andIncrement;
        long j;
        if (this.zzd.get() != 0) {
            synchronized (this.zzd) {
                this.zzd.compareAndSet(-1L, 1L);
                andIncrement = this.zzd.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.zzd) {
            long jNanoTime = System.nanoTime();
            ((zzfr) this.mBuilder).zzr.getClass();
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.zze + 1;
            this.zze = i;
            j = jNextLong + ((long) i);
        }
        return j;
    }

    public final Bundle zzs(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                    queryParameter5 = uri.getQueryParameter("utm_id");
                    queryParameter6 = uri.getQueryParameter("dclid");
                    queryParameter7 = uri.getQueryParameter("srsltid");
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                    queryParameter5 = null;
                    queryParameter6 = null;
                    queryParameter7 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.SOURCE, queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.MEDIUM, queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                String queryParameter8 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter8);
                }
                String queryParameter9 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter9);
                }
                String queryParameter10 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter10)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter10);
                }
                String queryParameter11 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter11)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter11);
                }
                String queryParameter12 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter12)) {
                    bundle.putString("anid", queryParameter12);
                }
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("campaign_id", queryParameter5);
                }
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("dclid", queryParameter6);
                }
                String queryParameter13 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter13)) {
                    bundle.putString("source_platform", queryParameter13);
                }
                String queryParameter14 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter14)) {
                    bundle.putString("creative_format", queryParameter14);
                }
                String queryParameter15 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter15)) {
                    bundle.putString("marketing_tactic", queryParameter15);
                }
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("srsltid", queryParameter7);
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(e, "Install referrer url isn't a hierarchical URI");
            }
        }
        return null;
    }

    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objZzA = zzA(bundle.get(str), str);
                if (objZzA == null) {
                    zzfr zzfrVar = (zzfr) this.mBuilder;
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zzb(zzfrVar.zzq.zze(str), "Param value can't be null");
                } else {
                    zzO(bundle2, str, objZzA);
                }
            }
        }
        return bundle2;
    }

    public final Bundle zzy(String str, Bundle bundle, List list, boolean z) {
        int iZzj;
        int i;
        boolean zZzas = zzas(str, zzg.zzd);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        int iZzc = zzfrVar.zzk.zzc();
        int i2 = 0;
        for (String str2 : new TreeSet(bundle.keySet())) {
            if (list == 0 || !list.contains(str2)) {
                iZzj = !z ? zzj(str2) : 0;
                if (iZzj == 0) {
                    iZzj = zzi(str2);
                }
            } else {
                iZzj = 0;
            }
            if (iZzj != 0) {
                zzJ(bundle2, iZzj, str2, iZzj == 3 ? str2 : null);
                bundle2.remove(str2);
                i = iZzc;
            } else {
                i = iZzc;
                int iZza = zza(str, str2, bundle.get(str2), bundle2, list, z, zZzas);
                if (iZza == 17) {
                    zzJ(bundle2, 17, str2, Boolean.FALSE);
                } else if (iZza != 0 && !"_ev".equals(str2)) {
                    zzJ(bundle2, iZza, iZza == 21 ? str : str2, bundle.get(str2));
                    bundle2.remove(str2);
                }
                if (zzai(str2)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i, "Event can't contain more than ", " params");
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        String string = sbM.toString();
                        zzec zzecVar = zzfrVar.zzq;
                        zzehVar.zzf.zzc(zzecVar.zzd(str), string, zzecVar.zzb(bundle));
                        zzao(5, bundle2);
                        bundle2.remove(str2);
                    }
                    i2 = i3;
                }
            }
            iZzc = i;
        }
        return bundle2;
    }

    public final zzaw zzz(String str, Bundle bundle, String str2, long j, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzh(str) != 0) {
            zzfr zzfrVar = (zzfr) this.mBuilder;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(zzfrVar.zzq.zzf(str), "Invalid conditional property event name");
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleZzy = zzy(str, bundle2, Collections.singletonList("_o"), true);
        if (z) {
            bundleZzy = zzt(bundleZzy);
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(bundleZzy);
        return new zzaw(str, new zzau(bundleZzy), str2, j);
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.zza);
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, zzacVar.zzb);
            bundle.putLong("creation_timestamp", zzacVar.zzd);
            bundle.putString("name", zzacVar.zzc.zzb);
            Object objZza = zzacVar.zzc.zza();
            com.google.android.gms.common.internal.zzah.checkNotNull(objZza);
            zzg.zzb(bundle, objZza);
            bundle.putBoolean("active", zzacVar.zze);
            String str = zzacVar.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaw zzawVar = zzacVar.zzg;
            if (zzawVar != null) {
                bundle.putString("timed_out_event_name", zzawVar.zza);
                zzau zzauVar = zzawVar.zzb;
                if (zzauVar != null) {
                    bundle.putBundle("timed_out_event_params", zzauVar.zzc());
                }
            }
            bundle.putLong("trigger_timeout", zzacVar.zzh);
            zzaw zzawVar2 = zzacVar.zzi;
            if (zzawVar2 != null) {
                bundle.putString("triggered_event_name", zzawVar2.zza);
                zzau zzauVar2 = zzawVar2.zzb;
                if (zzauVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzauVar2.zzc());
                }
            }
            bundle.putLong(sgtsHsWT.kTQ, zzacVar.zzc.zzc);
            bundle.putLong("time_to_live", zzacVar.zzj);
            zzaw zzawVar3 = zzacVar.zzk;
            if (zzawVar3 != null) {
                bundle.putString("expired_event_name", zzawVar3.zza);
                zzau zzauVar3 = zzawVar3.zzb;
                if (zzauVar3 != null) {
                    bundle.putBundle("expired_event_params", zzauVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void zzK(zzie zzieVar, Bundle bundle, boolean z) {
        String str = gZrKCJ.ixbMdKi;
        if (bundle != null && zzieVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str2 = zzieVar.zza;
                if (str2 != null) {
                    bundle.putString(str, str2);
                } else {
                    bundle.remove(str);
                }
                String str3 = zzieVar.zzb;
                if (str3 != null) {
                    bundle.putString("_sc", str3);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzieVar.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzieVar == null && z) {
            bundle.remove(str);
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final boolean zzY(int i, String str, String str2) {
        zzfr zzfrVar = (zzfr) this.mBuilder;
        if (str2 == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzf.zzb(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar2);
        zzehVar2.zzf.zzd(oKjScaD.gSkoWGQ, str, Integer.valueOf(i), str2);
        return false;
    }
}
