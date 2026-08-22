package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes2.dex */
class MediaBrowserCompat$ItemReceiver extends ResultReceiver {
    @Override // android.support.v4.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(ExceptionsKt.class.getClassLoader());
        }
        if (i != 0 || bundle == null) {
            throw null;
        }
        String str = ZRqOdXiy.YaaKK;
        if (!bundle.containsKey(str)) {
            throw null;
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
            throw null;
        }
        throw null;
    }
}
