package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzed;

/* JADX INFO: loaded from: classes.dex */
public final class VideoController {
    public final Object zza = new Object();
    public zzed zzb;

    public abstract class VideoLifecycleCallbacks {
        public abstract void onVideoEnd();

        public void onVideoMute(boolean z) {
        }

        public abstract void onVideoPause();

        public void onVideoPlay() {
        }

        public abstract void onVideoStart();
    }

    public final void zzb(zzed zzedVar) {
        synchronized (this.zza) {
            this.zzb = zzedVar;
        }
    }
}
