package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.instrument.anrreport.eBpy.lxnc;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.android.gms.dynamite.yXvB.MJoJJyFaOH;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION = Intrinsics.stringPlus(".action_customTabRedirect", "CustomTabActivity");
    public static final String DESTROY_ACTION = Intrinsics.stringPlus(".action_destroy", "CustomTabActivity");
    public zzq closeReceiver;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            zzq zzqVar = new zzq(this, 5);
            LocalBroadcastManager.getInstance(this).registerReceiver(zzqVar, new IntentFilter(DESTROY_ACTION));
            this.closeReceiver = zzqVar;
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        lxnc.zgRbkOoeEEXObW.invoke(null, this, bundle);
    }

    @Override // android.app.Activity
    public final void onDestroy() throws IllegalAccessException, InvocationTargetException {
        MJoJJyFaOH.PtEDJo.invoke(null, this);
    }
}
