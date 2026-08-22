package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ViewIndexingTrigger implements SensorEventListener {
    public CodelessManager$$ExternalSyntheticLambda0 onShakeListener;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(sensor, "sensor");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            CodelessManager$$ExternalSyntheticLambda0 codelessManager$$ExternalSyntheticLambda0 = this.onShakeListener;
            if (codelessManager$$ExternalSyntheticLambda0 == null) {
                return;
            }
            float[] fArr = event.values;
            double d = fArr[0] / 9.80665f;
            double d2 = fArr[1] / 9.80665f;
            double d3 = fArr[2] / 9.80665f;
            if (Math.sqrt((d3 * d3) + (d2 * d2) + (d * d)) > 2.3d) {
                codelessManager$$ExternalSyntheticLambda0.onShake();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }
}
