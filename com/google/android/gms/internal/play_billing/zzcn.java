package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzcn;
import com.google.android.gms.internal.play_billing.zzcs;

/* JADX INFO: loaded from: classes.dex */
public class zzcn<MessageType extends zzcs<MessageType, BuilderType>, BuilderType extends zzcn<MessageType, BuilderType>> extends zzax<MessageType, BuilderType> {
    protected zzcs zza;
    private final zzcs zzb;

    public zzcn(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzw()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzl();
    }

    private static void zzl(Object obj, Object obj2) {
        zzel.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzax
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzcn clone() {
        zzcn zzcnVar = (zzcn) this.zzb.zzx(5, null, null);
        zzcnVar.zza = zzg();
        return zzcnVar;
    }

    public final zzcn zzc(zzcs zzcsVar) {
        if (!this.zzb.equals(zzcsVar)) {
            if (!this.zza.zzw()) {
                zzj();
            }
            zzl(this.zza, zzcsVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeb
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final MessageType zzf() {
        MessageType messagetype = (MessageType) zzg();
        if (messagetype.zzk()) {
            return messagetype;
        }
        throw new zzfe(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeb
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public MessageType zzg() {
        if (!this.zza.zzw()) {
            return (MessageType) this.zza;
        }
        this.zza.zzr();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final /* bridge */ /* synthetic */ zzec zzh() {
        throw null;
    }

    public final void zzi() {
        if (this.zza.zzw()) {
            return;
        }
        zzj();
    }

    public void zzj() {
        zzcs zzcsVarZzl = this.zzb.zzl();
        zzl(zzcsVarZzl, this.zza);
        this.zza = zzcsVarZzl;
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final boolean zzk() {
        return zzcs.zzv(this.zza, false);
    }
}
