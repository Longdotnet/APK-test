package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkStateTracker extends ConstraintTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("NetworkStateTracker");
    public final zzq mBroadcastReceiver;
    public final ConnectivityManager mConnectivityManager;
    public final NetworkStateCallback mNetworkCallback;

    public NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.mConnectivityManager = (ConnectivityManager) this.mAppContext.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 24) {
            this.mNetworkCallback = new NetworkStateCallback();
        } else {
            this.mBroadcastReceiver = new zzq(this, 4);
        }
    }

    public final NetworkState getActiveNetworkState() {
        boolean z;
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z2 = false;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            z = networkCapabilities != null && networkCapabilities.hasCapability(16);
        } catch (SecurityException e) {
            Logger$LogcatLogger.get().error(TAG, "Unable to validate active network", e);
        }
        boolean zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z2 = true;
        }
        NetworkState networkState = new NetworkState();
        networkState.mIsConnected = z3;
        networkState.mIsValidated = z;
        networkState.mIsMetered = zIsActiveNetworkMetered;
        networkState.mIsNotRoaming = z2;
        return networkState;
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object getInitialState() {
        return getActiveNetworkState();
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void startTracking() {
        boolean z = Build.VERSION.SDK_INT >= 24;
        String str = TAG;
        if (!z) {
            Logger$LogcatLogger.get().debug(str, "Registering broadcast receiver", new Throwable[0]);
            this.mAppContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            Logger$LogcatLogger.get().debug(str, "Registering network callback", new Throwable[0]);
            this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException e) {
            Logger$LogcatLogger.get().error(str, "Received exception while registering network callback", e);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final void stopTracking() {
        boolean z = Build.VERSION.SDK_INT >= 24;
        String str = TAG;
        if (!z) {
            Logger$LogcatLogger.get().debug(str, "Unregistering broadcast receiver", new Throwable[0]);
            this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
            return;
        }
        try {
            Logger$LogcatLogger.get().debug(str, "Unregistering network callback", new Throwable[0]);
            this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException e) {
            Logger$LogcatLogger.get().error(str, "Received exception while unregistering network callback", e);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        public NetworkStateCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Logger$LogcatLogger.get().debug(NetworkStateTracker.TAG, "Network capabilities changed: " + networkCapabilities, new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            Logger$LogcatLogger.get().debug(NetworkStateTracker.TAG, PZmDzEagKNdW.JJPpaDsJ, new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }
    }
}
