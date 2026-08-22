package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzid {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public long zzk;
    public int zzl;

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        int i4 = this.zzd;
        int i5 = this.zze;
        int i6 = this.zzf;
        int i7 = this.zzg;
        int i8 = this.zzh;
        int i9 = this.zzi;
        int i10 = this.zzj;
        long j = this.zzk;
        int i11 = this.zzl;
        String str = zzex.zza;
        Locale locale = Locale.US;
        StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("DecoderCounters {\n decoderInits=", i, ",\n decoderReleases=", i2, "\n queuedInputBuffers=");
        sbM.append(i3);
        sbM.append("\n skippedInputBuffers=");
        sbM.append(i4);
        sbM.append("\n renderedOutputBuffers=");
        sbM.append(i5);
        sbM.append("\n skippedOutputBuffers=");
        sbM.append(i6);
        sbM.append("\n droppedBuffers=");
        sbM.append(i7);
        sbM.append("\n droppedInputBuffers=");
        sbM.append(i8);
        sbM.append("\n maxConsecutiveDroppedBuffers=");
        sbM.append(i9);
        sbM.append("\n droppedToKeyframeEvents=");
        sbM.append(i10);
        sbM.append("\n totalVideoFrameProcessingOffsetUs=");
        sbM.append(j);
        sbM.append("\n videoFrameProcessingOffsetCount=");
        sbM.append(i11);
        sbM.append("\n}");
        return sbM.toString();
    }

    public final synchronized void zza() {
    }
}
