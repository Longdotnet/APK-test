package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzdl;
import com.google.android.gms.internal.auth.zzdm;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzdl<MessageType extends zzdm<MessageType, BuilderType>, BuilderType extends zzdl<MessageType, BuilderType>> implements zzfp {
    @Override // 
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public abstract BuilderType zzb(MessageType messagetype);

    @Override // com.google.android.gms.internal.auth.zzfp
    public final /* bridge */ /* synthetic */ zzfp zzc(zzfq zzfqVar) {
        if (zzh().getClass().isInstance(zzfqVar)) {
            return zzb((zzdm) zzfqVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
