package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzck {
    private final zzfyq zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private boolean zzd;

    public zzck(zzfyq zzfyqVar) {
        this.zza = zzfyqVar;
        zzcl zzclVar = zzcl.zza;
        this.zzd = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z;
        do {
            z = false;
            for (int i = 0; i <= zzi(); i++) {
                if (!this.zzc[i].hasRemaining()) {
                    List list = this.zzb;
                    zzcn zzcnVar = (zzcn) list.get(i);
                    if (!zzcnVar.zzh()) {
                        ByteBuffer byteBuffer2 = i > 0 ? this.zzc[i - 1] : byteBuffer.hasRemaining() ? byteBuffer : zzcn.zza;
                        long jRemaining = byteBuffer2.remaining();
                        zzcnVar.zze(byteBuffer2);
                        this.zzc[i] = zzcnVar.zzb();
                        boolean z2 = true;
                        if (jRemaining - ((long) byteBuffer2.remaining()) <= 0 && !this.zzc[i].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.zzc[i].hasRemaining() && i < zzi()) {
                        ((zzcn) list.get(i + 1)).zzd();
                    }
                }
            }
        } while (z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzck)) {
            return false;
        }
        zzfyq zzfyqVar = this.zza;
        int size = zzfyqVar.size();
        zzfyq zzfyqVar2 = ((zzck) obj).zza;
        if (size != zzfyqVar2.size()) {
            return false;
        }
        for (int i = 0; i < zzfyqVar.size(); i++) {
            if (zzfyqVar.get(i) != zzfyqVar2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzcl zza(zzcl zzclVar) {
        zzcl zzclVar2 = zzcl.zza;
        if (zzclVar.equals(zzclVar2)) {
            throw new zzcm("Unhandled input format:", zzclVar);
        }
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                return zzclVar;
            }
            zzcn zzcnVar = (zzcn) zzfyqVar.get(i);
            zzcl zzclVarZza = zzcnVar.zza(zzclVar);
            if (zzcnVar.zzg()) {
                zzdd.zzf(!zzclVarZza.equals(zzclVar2));
                zzclVar = zzclVarZza;
            }
            i++;
        }
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzcn.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzcn.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        List list = this.zzb;
        list.clear();
        this.zzd = false;
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                break;
            }
            zzcn zzcnVar = (zzcn) zzfyqVar.get(i);
            zzcnVar.zzc();
            if (zzcnVar.zzg()) {
                list.add(zzcnVar);
            }
            i++;
        }
        this.zzc = new ByteBuffer[list.size()];
        for (int i2 = 0; i2 <= zzi(); i2++) {
            this.zzc[i2] = ((zzcn) list.get(i2)).zzb();
        }
    }

    public final void zzd() {
        if (!zzh() || this.zzd) {
            return;
        }
        this.zzd = true;
        ((zzcn) this.zzb.get(0)).zzd();
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (!zzh() || this.zzd) {
            return;
        }
        zzj(byteBuffer);
    }

    public final void zzf() {
        int i = 0;
        while (true) {
            zzfyq zzfyqVar = this.zza;
            if (i >= zzfyqVar.size()) {
                this.zzc = new ByteBuffer[0];
                zzcl zzclVar = zzcl.zza;
                this.zzd = false;
                return;
            } else {
                zzcn zzcnVar = (zzcn) zzfyqVar.get(i);
                zzcnVar.zzc();
                zzcnVar.zzf();
                i++;
            }
        }
    }

    public final boolean zzg() {
        return this.zzd && ((zzcn) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
