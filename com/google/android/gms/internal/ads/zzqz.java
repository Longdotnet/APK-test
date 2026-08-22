package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes.dex */
final class zzqz {
    public static void zza(AudioTrack audioTrack, zzpp zzppVar) {
        audioTrack.setPreferredDevice(zzppVar == null ? null : zzppVar.zza);
    }
}
