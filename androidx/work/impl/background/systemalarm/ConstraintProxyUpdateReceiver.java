package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger$LogcatLogger;
import com.pairip.VMRunner;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("vrSu3b3xtEIC06dv", new Object[]{this, context, intent});
    }
}
