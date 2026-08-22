package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzedi {
    private MeasurementManagerFutures zza;
    private final Context zzb;

    public zzedi(Context context) {
        this.zzb = context;
    }

    public final ListenableFuture zza() {
        try {
            MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImplFrom = MeasurementManagerFutures.from(this.zzb);
            this.zza = api33Ext5JavaImplFrom;
            return api33Ext5JavaImplFrom == null ? zzgdn.zzg(new IllegalStateException("MeasurementManagerFutures is null")) : api33Ext5JavaImplFrom.getMeasurementApiStatusAsync();
        } catch (Exception e) {
            return zzgdn.zzg(e);
        }
    }

    public final ListenableFuture zzb(Uri uri, InputEvent inputEvent) {
        try {
            MeasurementManagerFutures measurementManagerFutures = this.zza;
            Objects.requireNonNull(measurementManagerFutures);
            return measurementManagerFutures.registerSourceAsync(uri, inputEvent);
        } catch (Exception e) {
            return zzgdn.zzg(e);
        }
    }
}
