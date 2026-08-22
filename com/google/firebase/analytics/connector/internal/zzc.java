package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    private static final Set zza = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
    private static final List zzb = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final List zzc = Arrays.asList("auto", "app", "am");
    private static final List zzd = Arrays.asList("_r", "_dbg");
    private static final List zze;
    private static final List zzf;

    static {
        String[][] strArr = {com.google.android.gms.measurement.internal.zzg.zza$2, com.google.android.gms.measurement.internal.zzg.zzb$2};
        int length = 0;
        for (int i = 0; i < 2; i++) {
            length += strArr[i].length;
        }
        Object[] objArrCopyOf = Arrays.copyOf(strArr[0], length);
        int length2 = strArr[0].length;
        String[] strArr2 = strArr[1];
        System.arraycopy(strArr2, 0, objArrCopyOf, length2, strArr2.length);
        zze = Arrays.asList((String[]) objArrCopyOf);
        zzf = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static Bundle zza(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.origin;
        if (str != null) {
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str);
        }
        String str2 = conditionalUserProperty.name;
        if (str2 != null) {
            bundle.putString("name", str2);
        }
        Object obj = conditionalUserProperty.value;
        if (obj != null) {
            com.google.android.gms.measurement.internal.zzg.zzb(bundle, obj);
        }
        String str3 = conditionalUserProperty.triggerEventName;
        if (str3 != null) {
            bundle.putString("trigger_event_name", str3);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
        String str4 = conditionalUserProperty.timedOutEventName;
        if (str4 != null) {
            bundle.putString("timed_out_event_name", str4);
        }
        Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str5 = conditionalUserProperty.triggeredEventName;
        if (str5 != null) {
            bundle.putString("triggered_event_name", str5);
        }
        Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
        String str6 = conditionalUserProperty.expiredEventName;
        if (str6 != null) {
            bundle.putString("expired_event_name", str6);
        }
        Bundle bundle4 = conditionalUserProperty.expiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.active);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
        return bundle;
    }

    public static AnalyticsConnector.ConditionalUserProperty zzb(Bundle bundle) {
        zzah.checkNotNull(bundle);
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        String str = (String) com.google.android.gms.measurement.internal.zzg.zza(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        zzah.checkNotNull(str);
        conditionalUserProperty.origin = str;
        String str2 = (String) com.google.android.gms.measurement.internal.zzg.zza(bundle, "name", String.class, null);
        zzah.checkNotNull(str2);
        conditionalUserProperty.name = str2;
        conditionalUserProperty.value = com.google.android.gms.measurement.internal.zzg.zza(bundle, FirebaseAnalytics.Param.VALUE, Object.class, null);
        conditionalUserProperty.triggerEventName = (String) com.google.android.gms.measurement.internal.zzg.zza(bundle, "trigger_event_name", String.class, null);
        conditionalUserProperty.triggerTimeout = ((Long) com.google.android.gms.measurement.internal.zzg.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
        conditionalUserProperty.timedOutEventName = (String) com.google.android.gms.measurement.internal.zzg.zza(bundle, "timed_out_event_name", String.class, null);
        conditionalUserProperty.timedOutEventParams = (Bundle) com.google.android.gms.measurement.internal.zzg.zza(bundle, "timed_out_event_params", Bundle.class, null);
        conditionalUserProperty.triggeredEventName = (String) com.google.android.gms.measurement.internal.zzg.zza(bundle, "triggered_event_name", String.class, null);
        conditionalUserProperty.triggeredEventParams = (Bundle) com.google.android.gms.measurement.internal.zzg.zza(bundle, "triggered_event_params", Bundle.class, null);
        conditionalUserProperty.timeToLive = ((Long) com.google.android.gms.measurement.internal.zzg.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
        conditionalUserProperty.expiredEventName = (String) com.google.android.gms.measurement.internal.zzg.zza(bundle, "expired_event_name", String.class, null);
        conditionalUserProperty.expiredEventParams = (Bundle) com.google.android.gms.measurement.internal.zzg.zza(bundle, "expired_event_params", Bundle.class, null);
        conditionalUserProperty.active = ((Boolean) com.google.android.gms.measurement.internal.zzg.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
        conditionalUserProperty.creationTimestamp = ((Long) com.google.android.gms.measurement.internal.zzg.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
        conditionalUserProperty.triggeredTimestamp = ((Long) com.google.android.gms.measurement.internal.zzg.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        return conditionalUserProperty;
    }

    public static String zzc(String str) {
        String strZzb = com.google.android.gms.measurement.internal.zzg.zzb(str, com.google.android.gms.measurement.internal.zzg.zzc, com.google.android.gms.measurement.internal.zzg.f3zza);
        return strZzb != null ? strZzb : str;
    }

    public static String zzd(String str) {
        String strZzb = com.google.android.gms.measurement.internal.zzg.zzb(str, com.google.android.gms.measurement.internal.zzg.f3zza, com.google.android.gms.measurement.internal.zzg.zzc);
        return strZzb != null ? strZzb : str;
    }

    public static void zze(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean zzf(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int iCodePointAt = str.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            return false;
        }
        int length = str.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public static boolean zzg(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int iCodePointAt = str.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            return false;
        }
        int length = str.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    public static boolean zzh(String str, String str2, Bundle bundle) {
        byte b;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzl(str) || bundle == null) {
            return false;
        }
        Iterator it = zzd.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey((String) it.next())) {
                return false;
            }
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 101200) {
            if (iHashCode != 101230) {
                if (iHashCode == 3142703 && str.equals("fiam")) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (str.equals("fdl")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str.equals("fcm")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        if (b == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        if (b != 2) {
            return false;
        }
        bundle.putString("_cis", "fiam_integration");
        return true;
    }

    public static boolean zzi(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        Throwable th;
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.origin) == null || str.isEmpty()) {
            return false;
        }
        Object obj = conditionalUserProperty.value;
        if (obj != null) {
            Object obj2 = null;
            try {
                if (obj != null) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeObject(obj);
                            objectOutputStream.flush();
                            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                            try {
                                Object object = objectInputStream.readObject();
                                objectOutputStream.close();
                                objectInputStream.close();
                                obj2 = object;
                            } catch (Throwable th2) {
                                th = th2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (objectInputStream == null) {
                                    throw th;
                                }
                                objectInputStream.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        objectInputStream = null;
                        objectOutputStream = null;
                    }
                }
            } catch (IOException | ClassNotFoundException unused) {
            }
            if (obj2 == null) {
                return false;
            }
        }
        if (!zzl(str) || !zzm(str, conditionalUserProperty.name)) {
            return false;
        }
        String str2 = conditionalUserProperty.expiredEventName;
        if (str2 != null && (!zzj(str2, conditionalUserProperty.expiredEventParams) || !zzh(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
            return false;
        }
        String str3 = conditionalUserProperty.triggeredEventName;
        if (str3 != null && (!zzj(str3, conditionalUserProperty.triggeredEventParams) || !zzh(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
            return false;
        }
        String str4 = conditionalUserProperty.timedOutEventName;
        if (str4 != null) {
            return zzj(str4, conditionalUserProperty.timedOutEventParams) && zzh(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams);
        }
        return true;
    }

    public static boolean zzj(String str, Bundle bundle) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        Iterator it = zzd.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean zzk(String str) {
        return !zza.contains(str);
    }

    public static boolean zzl(String str) {
        return !zzc.contains(str);
    }

    public static boolean zzm(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (zze.contains(str2)) {
            return false;
        }
        Iterator it = zzf.iterator();
        while (it.hasNext()) {
            if (str2.matches((String) it.next())) {
                return false;
            }
        }
        return true;
    }
}
