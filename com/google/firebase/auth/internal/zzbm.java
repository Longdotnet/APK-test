package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbm {
    public static final zzbm zza = new zzbm();
    public final zzbd zzb;
    public final zzax zzc;

    public zzbm() {
        zzbd zzbdVarZzc = zzbd.zzc();
        zzax zzaxVarZza = zzax.zza();
        this.zzb = zzbdVarZzc;
        this.zzc = zzaxVarZza;
    }

    public static zzbm zzc() {
        return zza;
    }

    public final Task zza() {
        return this.zzb.zza();
    }

    public final Task zzb() {
        return this.zzb.zzb();
    }

    public final void zzd(Context context) {
        this.zzb.zzd(context);
    }

    public final void zze(FirebaseAuth firebaseAuth) {
        this.zzb.zze(firebaseAuth);
    }

    public final void zzf(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.getStatusCode());
        editorEdit.putString("statusMessage", status.getStatusMessage());
        editorEdit.putLong("timestamp", System.currentTimeMillis());
        editorEdit.commit();
    }

    public final void zzh(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseAuth);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.putString("firebaseUserUid", firebaseUser.getUid());
        editorEdit.commit();
    }

    public final boolean zzi(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.zzc.zzf(activity, taskCompletionSource, firebaseAuth, null);
    }

    public final boolean zzj(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.zzc.zzf(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }

    public final void zzg(Context context, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(bUqMCsuPSX.FWoPKgJcvafS, 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.commit();
    }
}
