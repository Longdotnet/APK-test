package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;
import com.facebook.CustomTabActivity;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends BroadcastReceiver {
    public static zzq singleton;
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzq(Object obj, int i) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    public static final /* synthetic */ zzq access$getSingleton$cp() {
        if (CrashShieldHandler.isObjectCrashing(zzq.class)) {
            return null;
        }
        try {
            return singleton;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(zzq.class, th);
            return null;
        }
    }

    public void finalize() throws Throwable {
        switch (this.$r8$classId) {
            case 1:
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance((Context) this.zza);
                                Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
                                localBroadcastManager.unregisterReceiver(this);
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(this, th);
                                return;
                            }
                            break;
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(this, th2);
                        return;
                    }
                }
                break;
            default:
                super.finalize();
                break;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.$r8$classId) {
            case 0:
                boolean zEquals = Objects.equals(intent.getAction(), "android.intent.action.USER_PRESENT");
                zzs zzsVar = (zzs) this.zza;
                if (zEquals) {
                    zzsVar.zzf = true;
                    return;
                } else {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        zzsVar.zzf = false;
                        return;
                    }
                    return;
                }
            case 1:
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    Set<String> setKeySet = null;
                    AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, (String) null);
                    String strStringPlus = Intrinsics.stringPlus(intent == null ? null : intent.getStringExtra("event_name"), "bf_");
                    Bundle bundleExtra = intent == null ? null : intent.getBundleExtra("event_args");
                    Bundle bundle = new Bundle();
                    if (bundleExtra != null) {
                        setKeySet = bundleExtra.keySet();
                    }
                    if (setKeySet != null) {
                        for (String key : setKeySet) {
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            Pattern patternCompile = Pattern.compile("[^0-9a-zA-Z _-]");
                            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                            String strReplaceAll = patternCompile.matcher(key).replaceAll("-");
                            Intrinsics.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
                            Pattern patternCompile2 = Pattern.compile("^[ -]*");
                            Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(pattern)");
                            String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll("");
                            Intrinsics.checkNotNullExpressionValue(strReplaceAll2, "nativePattern.matcher(in…).replaceAll(replacement)");
                            Pattern patternCompile3 = Pattern.compile("[ -]*$");
                            Intrinsics.checkNotNullExpressionValue(patternCompile3, "compile(pattern)");
                            String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll("");
                            Intrinsics.checkNotNullExpressionValue(strReplaceAll3, "nativePattern.matcher(in…).replaceAll(replacement)");
                            bundle.putString(strReplaceAll3, (String) bundleExtra.get(key));
                        }
                    }
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                        appEventsLoggerImpl.logEvent(strStringPlus, bundle);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(this, th);
                    return;
                }
            case 2:
                ((BaseMenuWrapper) this.zza).onChange();
                return;
            case 3:
                if (intent != null) {
                    ((BroadcastReceiverConstraintTracker) this.zza).onBroadcastReceive(intent);
                    return;
                }
                return;
            case 4:
                if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    return;
                }
                Logger$LogcatLogger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = (NetworkStateTracker) this.zza;
                networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
                return;
            case 5:
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                ((CustomTabActivity) this.zza).finish();
                return;
            case 6:
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                CustomTabMainActivity customTabMainActivity = (CustomTabMainActivity) this.zza;
                Intent intent2 = new Intent(customTabMainActivity, (Class<?>) CustomTabMainActivity.class);
                intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                String str = CustomTabMainActivity.EXTRA_URL;
                intent2.putExtra(str, intent.getStringExtra(str));
                intent2.addFlags(603979776);
                customTabMainActivity.startActivity(intent2);
                return;
            default:
                zzci zzciVar = (zzci) this.zza;
                synchronized (zzciVar) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry entry : ((WeakHashMap) zzciVar.zzb).entrySet()) {
                            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                                arrayList.add((BroadcastReceiver) entry.getKey());
                            }
                        }
                        int size = arrayList.size();
                        for (int i = 0; i < size; i++) {
                            ((BroadcastReceiver) arrayList.get(i)).onReceive(context, intent);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
        }
    }

    public zzq(zzci zzciVar) {
        this.$r8$classId = 7;
        Objects.requireNonNull(zzciVar);
        this.zza = zzciVar;
    }

    public /* synthetic */ zzq(zzs zzsVar) {
        this.$r8$classId = 0;
        Objects.requireNonNull(zzsVar);
        this.zza = zzsVar;
    }

    public zzq(Context context) {
        this.$r8$classId = 1;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.zza = applicationContext;
    }
}
