package com.daerisoft.thespikerm;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidVibrate {
    public RunnerActivity activity;
    public AudioAttributes attributes;
    public Vibrator vibrator;

    public double GetSupported() {
        Vibrator vibrator;
        return (Build.VERSION.SDK_INT < 26 || (vibrator = this.vibrator) == null || !vibrator.hasVibrator() || !this.vibrator.hasAmplitudeControl()) ? 0.0d : 1.0d;
    }

    public double Haptic(double d, double d2) {
        Vibrator vibrator;
        if (Build.VERSION.SDK_INT < 26 || (vibrator = this.vibrator) == null || !vibrator.hasVibrator() || d <= 0.0d) {
            return 0.0d;
        }
        this.vibrator.vibrate(VibrationEffect.createOneShot((long) (Math.max(0.01d, d2) * 1000.0d), (int) ((Math.max(0.0d, Math.min(1.0d, d)) * 254.0d) + 1.0d)), this.attributes);
        return 1.0d;
    }

    public void Init() {
        Log.i(GooglePlayBillingService.TAG, "Android Vibrate Init");
        RunnerActivity runnerActivity = RunnerActivity.CurrentActivity;
        this.activity = runnerActivity;
        runnerActivity.getApplicationContext();
        this.vibrator = (Vibrator) runnerActivity.getSystemService("vibrator");
        AudioAttributes.Builder contentType = new AudioAttributes.Builder().setUsage(14).setContentType(0);
        if (Build.VERSION.SDK_INT >= 29) {
            contentType.setHapticChannelsMuted(false);
        }
        this.attributes = contentType.build();
    }
}
