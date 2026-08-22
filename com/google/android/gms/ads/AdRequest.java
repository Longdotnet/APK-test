package com.google.android.gms.ads;

import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.app.NotificationCompat$Style;
import com.google.android.gms.ads.internal.client.zzek;

/* JADX INFO: loaded from: classes.dex */
public class AdRequest {
    public final zzek zza;

    public AdRequest(NotificationCompat$Style notificationCompat$Style) {
        this.zza = new zzek((AppCompatTextHelper) notificationCompat$Style.mBuilder);
    }

    public final class Builder extends NotificationCompat$Style {
        @Override // androidx.core.app.NotificationCompat$Style
        public final NotificationCompat$Style self() {
            return this;
        }
    }
}
