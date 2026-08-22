package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class AdView extends BaseAdView {
    public AdView(Context context) {
        super(context);
        zzah.checkNotNull(context, "Context cannot be null");
    }
}
