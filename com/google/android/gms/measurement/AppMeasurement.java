package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzg;
import com.google.android.gms.measurement.internal.zzhy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class AppMeasurement {
    public static volatile AppMeasurement zza;
    public final zzd zzb;

    /* JADX INFO: loaded from: classes.dex */
    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;
    }

    public AppMeasurement(zzfr zzfrVar) {
        this.zzb = new zza(zzfrVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    zzhy zzhyVar = (zzhy) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (zzhyVar != null) {
                        zza = new AppMeasurement(zzhyVar);
                    } else {
                        zza = new AppMeasurement(zzfr.zzp(context, new zzcl(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return zza;
    }

    public void beginAdUnitExposure(String str) {
        this.zzb.zzp(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzb.zzq(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.zzb.zzr(str);
    }

    public long generateEventId() {
        return this.zzb.zzb();
    }

    public String getAppInstanceId() {
        return this.zzb.zzh();
    }

    public String getCurrentScreenClass() {
        return this.zzb.zzi();
    }

    public String getCurrentScreenName() {
        return this.zzb.zzj();
    }

    public String getGmpAppId() {
        return this.zzb.zzk();
    }

    public int getMaxUserProperties(String str) {
        return this.zzb.zza(str);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzb.zzo(str, str2, z);
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzb.zzs(str, str2, bundle);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        zzah.checkNotNull(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzg.zzb(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        this.zzb.zzv(bundle);
    }

    public AppMeasurement(zzhy zzhyVar) {
        this.zzb = new zzb(zzhyVar);
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> listZzm = this.zzb.zzm(str, str2);
        ArrayList arrayList = new ArrayList(listZzm == null ? 0 : listZzm.size());
        for (Bundle bundle : listZzm) {
            ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
            zzah.checkNotNull(bundle);
            conditionalUserProperty.mAppId = (String) zzg.zza(bundle, "app_id", String.class, null);
            conditionalUserProperty.mOrigin = (String) zzg.zza(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
            conditionalUserProperty.mName = (String) zzg.zza(bundle, "name", String.class, null);
            conditionalUserProperty.mValue = zzg.zza(bundle, FirebaseAnalytics.Param.VALUE, Object.class, null);
            conditionalUserProperty.mTriggerEventName = (String) zzg.zza(bundle, gZrKCJ.bgSVsBdxaF, String.class, null);
            conditionalUserProperty.mTriggerTimeout = ((Long) zzg.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            conditionalUserProperty.mTimedOutEventName = (String) zzg.zza(bundle, "timed_out_event_name", String.class, null);
            conditionalUserProperty.mTimedOutEventParams = (Bundle) zzg.zza(bundle, "timed_out_event_params", Bundle.class, null);
            conditionalUserProperty.mTriggeredEventName = (String) zzg.zza(bundle, "triggered_event_name", String.class, null);
            conditionalUserProperty.mTriggeredEventParams = (Bundle) zzg.zza(bundle, "triggered_event_params", Bundle.class, null);
            conditionalUserProperty.mTimeToLive = ((Long) zzg.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
            conditionalUserProperty.mExpiredEventName = (String) zzg.zza(bundle, YcVWhnLsj.ZvXdtvNSfm, String.class, null);
            conditionalUserProperty.mExpiredEventParams = (Bundle) zzg.zza(bundle, "expired_event_params", Bundle.class, null);
            conditionalUserProperty.mActive = ((Boolean) zzg.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.mCreationTimestamp = ((Long) zzg.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            conditionalUserProperty.mTriggeredTimestamp = ((Long) zzg.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }
}
