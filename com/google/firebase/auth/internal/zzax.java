package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import kotlin.io.TextStreamsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzax {
    public static zzax zza;
    public boolean zzb = false;
    public BroadcastReceiver zzc;

    public static zzax zza() {
        if (zza == null) {
            zza = new zzax();
        }
        return zza;
    }

    public static void zzb(zzax zzaxVar, Intent intent, TaskCompletionSource taskCompletionSource, FirebaseUser firebaseUser, Context context) {
        Task taskLinkWithCredential = firebaseUser.linkWithCredential(zzi(intent));
        zzap zzapVar = new zzap(taskCompletionSource, context, 3);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskLinkWithCredential;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, zzapVar);
        zzwVar.addOnFailureListener(new zzap(taskCompletionSource, context, 2));
    }

    public static void zzc(zzax zzaxVar, Intent intent, TaskCompletionSource taskCompletionSource, FirebaseUser firebaseUser, Context context) {
        Task taskReauthenticateAndRetrieveData = firebaseUser.reauthenticateAndRetrieveData(zzi(intent));
        zzap zzapVar = new zzap(taskCompletionSource, context, 5);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskReauthenticateAndRetrieveData;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, zzapVar);
        zzwVar.addOnFailureListener(new zzap(taskCompletionSource, context, 4));
    }

    public static void zzd(zzax zzaxVar, Intent intent, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, Context context) {
        Task taskSignInWithCredential = firebaseAuth.signInWithCredential(zzi(intent));
        zzap zzapVar = new zzap(taskCompletionSource, context, 1);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskSignInWithCredential;
        zzwVar.getClass();
        zzwVar.addOnSuccessListener(TaskExecutors.MAIN_THREAD, zzapVar);
        zzwVar.addOnFailureListener(new zzap(taskCompletionSource, context, 0));
    }

    public static void zze(Context context) {
        zzax zzaxVar = zza;
        zzaxVar.zzb = false;
        if (zzaxVar.zzc != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(zza.zzc);
        }
        zza.zzc = null;
    }

    private final void zzh(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.zzc = broadcastReceiver;
        LocalBroadcastManager.getInstance(activity).registerReceiver(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    public static final AuthCredential zzi(Intent intent) {
        com.google.android.gms.common.internal.zzah.checkNotNull(intent);
        Parcelable.Creator<zzaay> creator = zzaay.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
        zzaay zzaayVar = (zzaay) (byteArrayExtra == null ? null : TextStreamsKt.deserializeFromBytes(byteArrayExtra, creator));
        zzaayVar.zze(true);
        return com.google.firebase.auth.zze.zzb(zzaayVar);
    }

    public final boolean zzf(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (this.zzb) {
            return false;
        }
        zzh(activity, new zzav(this, activity, taskCompletionSource, firebaseAuth, firebaseUser));
        this.zzb = true;
        return true;
    }

    public final boolean zzg(Activity activity, TaskCompletionSource taskCompletionSource) {
        if (this.zzb) {
            return false;
        }
        zzh(activity, new zzaw(activity, taskCompletionSource));
        this.zzb = true;
        return true;
    }
}
