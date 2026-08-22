package com.google.android.gms.games.internal.v2.appshortcuts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.dynamite.yXvB.MJoJJyFaOH;
import com.google.android.gms.internal.games_v2.zzfr;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class PlayGamesAppShortcutsActivity extends Activity {
    public Intent zza;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1005000000) {
            return;
        }
        if (i2 != -1) {
            finish();
        } else {
            new zzfr(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.google.android.gms.games.internal.v2.appshortcuts.zzy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity = this.zza;
                    playGamesAppShortcutsActivity.startActivityForResult(playGamesAppShortcutsActivity.zza, 1005000001);
                    playGamesAppShortcutsActivity.finish();
                    System.exit(0);
                }
            }, 50L);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        MJoJJyFaOH.SQgo.invoke(null, this, bundle);
    }
}
