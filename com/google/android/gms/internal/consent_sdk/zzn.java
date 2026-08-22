package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import com.google.common.base.Splitter;

/* JADX INFO: loaded from: classes.dex */
final class zzn {
    private final Application zza;
    private final zzaq zzb;

    public zzn(Application application, zzaq zzaqVar) {
        this.zza = application;
        this.zzb = zzaqVar;
    }

    public final zzcj zzc(Activity activity, ConsentRequestParameters consentRequestParameters) {
        ConsentDebugSettings consentDebugSettingsBuild = consentRequestParameters.zzc;
        if (consentDebugSettingsBuild == null) {
            consentDebugSettingsBuild = new Splitter(this.zza).build();
        }
        return zzp.zza(new zzp(this, activity, consentDebugSettingsBuild, consentRequestParameters, null));
    }
}
