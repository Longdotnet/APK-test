package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzz implements OnCompleteListener {
    public final /* synthetic */ PlayGamesAppShortcutsActivity zza;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final /* synthetic */ void onComplete(Task task) {
        boolean zIsSuccessful = task.isSuccessful();
        PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity = this.zza;
        if (zIsSuccessful) {
            playGamesAppShortcutsActivity.startActivityForResult((Intent) task.getResult(), 1005000000);
        } else {
            Log.e("PGShortcutsActivity", "Failed to access intent.", task.getException());
            playGamesAppShortcutsActivity.finish();
        }
    }
}
