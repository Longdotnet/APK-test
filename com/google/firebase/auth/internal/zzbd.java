package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.Base64;
import androidx.work.WorkContinuation;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbd {
    public static final List zza = new ArrayList(Arrays.asList("firebaseAppName", "firebaseUserUid", "operation", "tenantId", kBfGXgdfpo.caNBfz, "statusCode", "statusMessage", "timestamp"));
    public static final zzbd zzb = new zzbd();
    public Task zzc;
    public Task zzd;
    public long zze = 0;

    public static zzbd zzc() {
        return zzb;
    }

    public static final void zzf(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.commit();
    }

    public final Task zza() {
        if (System.currentTimeMillis() - this.zze < 3600000) {
            return this.zzc;
        }
        return null;
    }

    public final Task zzb() {
        if (System.currentTimeMillis() - this.zze < 3600000) {
            return this.zzd;
        }
        return null;
    }

    public final void zzd(Context context) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        zzf(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzc = null;
        this.zze = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a0  */
    public final void zze(FirebaseAuth firebaseAuth) {
        byte[] bArrDecode;
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseAuth);
        byte b = 0;
        SharedPreferences sharedPreferences = firebaseAuth.getApp().getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (!firebaseAuth.getApp().getName().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            return;
        }
        if (sharedPreferences.contains("verifyAssertionRequest")) {
            String string = sharedPreferences.getString("verifyAssertionRequest", "");
            Parcelable.Creator<zzaay> creator = zzaay.CREATOR;
            if (string == null) {
                bArrDecode = null;
            } else {
                bArrDecode = Base64.decode(string, 10);
            }
            zzaay zzaayVar = (zzaay) TextStreamsKt.deserializeFromBytes(bArrDecode, creator);
            String string2 = sharedPreferences.getString("operation", "");
            String string3 = sharedPreferences.getString(dLDI.RZKpy, null);
            String string4 = sharedPreferences.getString("firebaseUserUid", "");
            this.zze = sharedPreferences.getLong("timestamp", 0L);
            if (string3 != null) {
                firebaseAuth.setTenantId(string3);
                zzaayVar.zzf(string3);
            }
            int iHashCode = string2.hashCode();
            if (iHashCode != -98509410) {
                if (iHashCode != 175006864) {
                    if (iHashCode != 1450464913 || !string2.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN")) {
                        b = -1;
                    }
                } else if (string2.equals("com.google.firebase.auth.internal.NONGMSCORE_LINK")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (string2.equals("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b == 2 && firebaseAuth.getCurrentUser().getUid().equals(string4)) {
                        this.zzc = firebaseAuth.zzf(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zze.zzb(zzaayVar));
                    } else {
                        this.zzc = null;
                    }
                } else if (firebaseAuth.getCurrentUser().getUid().equals(string4)) {
                    this.zzc = firebaseAuth.zzd(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zze.zzb(zzaayVar));
                } else {
                    this.zzc = null;
                }
            } else {
                this.zzc = firebaseAuth.signInWithCredential(com.google.firebase.auth.zze.zzb(zzaayVar));
            }
            zzf(sharedPreferences);
            return;
        }
        if (sharedPreferences.contains("recaptchaToken")) {
            String string5 = sharedPreferences.getString("recaptchaToken", "");
            String string6 = sharedPreferences.getString("operation", "");
            this.zze = sharedPreferences.getLong("timestamp", 0L);
            if (string6.hashCode() == -214796028 && string6.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA")) {
                this.zzd = WorkContinuation.forResult(string5);
            } else {
                this.zzd = null;
            }
            zzf(sharedPreferences);
            return;
        }
        if (sharedPreferences.contains("statusCode")) {
            Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
            this.zze = sharedPreferences.getLong("timestamp", 0L);
            zzf(sharedPreferences);
            this.zzc = WorkContinuation.forException(zzxc.zza(status));
        }
    }
}
