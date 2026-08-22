package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class GoogleServices {
    public static final Object zza = new Object();
    public static GoogleServices zzb;
    public final String zzc;
    public final Status zzd;
    public final boolean zze;
    public final boolean zzf;

    public GoogleServices(String str, boolean z) {
        this.zzc = str;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = z;
        this.zzf = !z;
    }

    public static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (zza) {
            try {
                googleServices = zzb;
                if (googleServices == null) {
                    throw new IllegalStateException("Initialize must be called before " + str + ".");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleServices;
    }

    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzc;
    }

    public static Status initialize(Context context) {
        Status status;
        zzah.checkNotNull(context, "Context must not be null.");
        synchronized (zza) {
            try {
                if (zzb == null) {
                    zzb = new GoogleServices(context);
                }
                status = zzb.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return status;
    }

    public static boolean isMeasurementEnabled() {
        GoogleServices googleServicesCheckInitialized = checkInitialized("isMeasurementEnabled");
        return googleServicesCheckInitialized.zzd.isSuccess() && googleServicesCheckInitialized.zze;
    }

    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzf;
    }

    public GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z2 = integer == 0;
            z = integer != 0;
            this.zzf = z2;
        } else {
            this.zzf = false;
        }
        this.zze = z;
        zzah.zzc(context);
        String string = zzah.zzc;
        if (string == null) {
            Resources resources2 = context.getResources();
            int identifier2 = resources2.getIdentifier("google_app_id", "string", resources2.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
            string = identifier2 == 0 ? null : resources2.getString(identifier2);
        }
        if (TextUtils.isEmpty(string)) {
            this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzc = null;
        } else {
            this.zzc = string;
            this.zzd = Status.RESULT_SUCCESS;
        }
    }

    @ResultIgnorabilityUnspecified
    public static Status initialize(Context context, String str, boolean z) {
        Status status;
        zzah.checkNotNull(context, "Context must not be null.");
        zzah.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (zza) {
            try {
                GoogleServices googleServices = zzb;
                if (googleServices != null) {
                    String str2 = googleServices.zzc;
                    if (str2 == null || str2.equals(str)) {
                        status = Status.RESULT_SUCCESS;
                    } else {
                        status = new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + str2 + "'.");
                    }
                    return status;
                }
                GoogleServices googleServices2 = new GoogleServices(str, z);
                zzb = googleServices2;
                return googleServices2.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
