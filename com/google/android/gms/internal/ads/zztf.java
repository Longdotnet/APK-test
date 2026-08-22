package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface zztf {
    int zza();

    int zzb(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzc();

    ByteBuffer zzf(int i);

    ByteBuffer zzg(int i);

    void zzi();

    void zzj();

    void zzk(int i, int i2, int i3, long j, int i4);

    void zzl(int i, int i2, zzhp zzhpVar, long j, int i3);

    void zzm();

    void zzn(int i, long j);

    void zzo(int i, boolean z);

    void zzp(Surface surface);

    void zzq(Bundle bundle);

    void zzr(int i);

    boolean zzs(zzte zzteVar);
}
