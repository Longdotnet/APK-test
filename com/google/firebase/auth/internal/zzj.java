package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class zzj {
    public static final zzj zza = new zzj();

    public static zzj zzb() {
        return zza;
    }

    public static void zzf(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<String> it = sharedPreferences.getAll().keySet().iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.apply();
    }

    public static final SharedPreferences zzg(Context context, String str) {
        return context.getSharedPreferences("com.google.firebase.auth.internal.browserSignInSessionStore." + str, 0);
    }

    public final synchronized zzi zza(Context context, String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        SharedPreferences sharedPreferencesZzg = zzg(context, str);
        String str3 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".SESSION_ID";
        String str4 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION";
        String str5 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".PROVIDER_ID";
        String str6 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME";
        String string = sharedPreferencesZzg.getString(str3, null);
        String string2 = sharedPreferencesZzg.getString(str4, null);
        String string3 = sharedPreferencesZzg.getString(str5, null);
        String string4 = sharedPreferencesZzg.getString("com.google.firebase.auth.api.gms.config.tenant.id", null);
        String string5 = sharedPreferencesZzg.getString(str6, null);
        SharedPreferences.Editor editorEdit = sharedPreferencesZzg.edit();
        editorEdit.remove(str3);
        editorEdit.remove(str4);
        editorEdit.remove(str5);
        editorEdit.remove(str6);
        editorEdit.apply();
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        return new zzi(string, string2, string3, string4, string5);
    }

    public final synchronized String zzc(Context context, String str, String str2) {
        String string;
        String string2;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        SharedPreferences sharedPreferencesZzg = zzg(context, str);
        String str3 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION";
        string = sharedPreferencesZzg.getString(str3, null);
        String str4 = "com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME";
        string2 = sharedPreferencesZzg.getString(str4, null);
        SharedPreferences.Editor editorEdit = sharedPreferencesZzg.edit();
        editorEdit.remove(str3);
        editorEdit.remove(str4);
        editorEdit.apply();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string2;
    }

    public final synchronized void zze(Context context, String str, String str2, String str3, String str4) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        SharedPreferences sharedPreferencesZzg = zzg(context, str);
        zzf(sharedPreferencesZzg);
        SharedPreferences.Editor editorEdit = sharedPreferencesZzg.edit();
        editorEdit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        editorEdit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME", str4);
        editorEdit.apply();
    }

    public final synchronized void zzd(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str3);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str7);
        SharedPreferences sharedPreferencesZzg = zzg(context, str);
        zzf(sharedPreferencesZzg);
        SharedPreferences.Editor editorEdit = sharedPreferencesZzg.edit();
        editorEdit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".SESSION_ID", str3);
        editorEdit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".OPERATION", str4);
        editorEdit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + YcVWhnLsj.jYpXMgGCw, str5);
        editorEdit.putString("com.google.firebase.auth.internal.EVENT_ID." + str2 + ".FIREBASE_APP_NAME", str7);
        editorEdit.putString("com.google.firebase.auth.api.gms.config.tenant.id", str6);
        editorEdit.apply();
    }
}
