package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;

/* JADX INFO: loaded from: classes2.dex */
public class zzth extends zzhq {
    public final int zza;

    public zzth(Throwable th, zzti zztiVar) {
        int errorCode;
        super(iafHZUfOuHNwvy.dcCJXsD.concat(String.valueOf(zztiVar == null ? null : zztiVar.zza)), th);
        if (th instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) th;
            codecException.getDiagnosticInfo();
            errorCode = codecException.getErrorCode();
        } else {
            errorCode = 0;
        }
        this.zza = errorCode;
    }
}
