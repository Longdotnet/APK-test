package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes.dex */
public final class zzs {
    public final zzfr zza;

    public /* synthetic */ zzs(zzfr zzfrVar) {
        this.zza = zzfrVar;
    }

    public void zza(String str, Bundle bundle) {
        String string;
        zzfr zzfrVar = this.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (zzfrVar.zzJ()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        zzewVar.zzq.zzb(string);
        zzfr.zzP(zzewVar);
        zzfrVar.zzr.getClass();
        zzewVar.zzr.zzb(System.currentTimeMillis());
    }

    public boolean zzd() {
        zzew zzewVar = this.zza.zzl;
        zzfr.zzP(zzewVar);
        return zzewVar.zzr.zza() > 0;
    }

    public boolean zze() {
        if (!zzd()) {
            return false;
        }
        zzfr zzfrVar = this.zza;
        zzfrVar.zzr.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        return jCurrentTimeMillis - zzewVar.zzr.zza() > zzfrVar.zzk.zzi(null, zzdu.zzQ);
    }

    public zzs(zzkt zzktVar) {
        this.zza = zzktVar.zzn;
    }

    public boolean zza() {
        zzfr zzfrVar = this.zza;
        try {
            WorkDatabase.AnonymousClass1 anonymousClass1PackageManager = Wrappers.packageManager(zzfrVar.zze);
            if (anonymousClass1PackageManager != null) {
                return anonymousClass1PackageManager.getPackageInfo(128, "com.android.vending").versionCode >= 80837300;
            }
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzl.zzb(e, "Failed to retrieve Play Store version for Install Referrer");
            return false;
        }
    }
}
