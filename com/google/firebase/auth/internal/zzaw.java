package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzaw extends BroadcastReceiver {
    public final WeakReference zzb;
    public final TaskCompletionSource zzc;

    public zzaw(Activity activity, TaskCompletionSource taskCompletionSource) {
        this.zzb = new WeakReference(activity);
        this.zzc = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Activity activity = (Activity) this.zzb.get();
        TaskCompletionSource taskCompletionSource = this.zzc;
        if (activity == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            taskCompletionSource.setException(zzxc.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zze(context);
            return;
        }
        if (!intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            if (zzbl.zzd(intent)) {
                taskCompletionSource.setException(zzxc.zza(zzbl.zza(intent)));
                zzax.zze(context);
                return;
            } else {
                if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                    taskCompletionSource.setException(zzxc.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
                    zzax.zze(context);
                    return;
                }
                return;
            }
        }
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
        if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
            taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
            zzax.zze(context);
        } else {
            taskCompletionSource.setException(zzxc.zza(zzai.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        }
    }
}
