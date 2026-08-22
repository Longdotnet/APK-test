package com.google.android.gms.games.internal.v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {
    public static zzb zza() {
        return new zzb();
    }

    public static final Task zzb(Activity activity, PendingIntent pendingIntent) {
        zza zzaVar = new zza();
        Intent intent = new Intent(activity, (Class<?>) GamesResolutionActivity.class);
        intent.putExtra(BaseGmsClient.KEY_PENDING_INTENT, pendingIntent);
        intent.putExtra("resultReceiver", zzaVar);
        activity.startActivity(intent);
        return zzaVar.zza();
    }
}
