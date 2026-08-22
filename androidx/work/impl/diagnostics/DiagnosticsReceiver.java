package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger$LogcatLogger;
import com.pairip.VMRunner;

/* JADX INFO: loaded from: classes2.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("PZxZ0ti8GktPX74b", new Object[]{this, context, intent});
    }
}
