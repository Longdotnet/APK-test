package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbsz extends NativeAd {
    private final zzbij zza;
    private final zzbsy zzc;
    private final NativeAd.AdChoicesInfo zzd;
    private final List zzb = new ArrayList();
    private final List zze = new ArrayList();
    private final AtomicLong zzf = new AtomicLong();

    public zzbsz(zzbij zzbijVar) {
        zzbsy zzbsyVar;
        this.zza = zzbijVar;
        zzbsw zzbswVar = null;
        try {
            List listZzv = zzbijVar.zzv();
            if (listZzv != null) {
                for (Object obj : listZzv) {
                    zzbgp zzbgpVarZzh = obj instanceof IBinder ? zzbgo.zzh((IBinder) obj) : null;
                    if (zzbgpVarZzh != null) {
                        this.zzb.add(new zzbsy(zzbgpVarZzh));
                    }
                }
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        try {
            List listZzw = this.zza.zzw();
            if (listZzw != null) {
                for (Object obj2 : listZzw) {
                    com.google.android.gms.ads.internal.client.zzdj zzdjVarZzb = obj2 instanceof IBinder ? com.google.android.gms.ads.internal.client.zzfa.zzb((IBinder) obj2) : null;
                    if (zzdjVarZzb != null) {
                        this.zze.add(new com.google.android.gms.ads.internal.client.zzdk(zzdjVarZzb));
                    }
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
        try {
            zzbgp zzbgpVarZzl = this.zza.zzl();
            zzbsyVar = zzbgpVarZzl != null ? new zzbsy(zzbgpVarZzl) : null;
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e3);
        }
        this.zzc = zzbsyVar;
        try {
            if (this.zza.zzj() != null) {
                zzbswVar = new zzbsw(this.zza.zzj());
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e4);
        }
        this.zzd = zzbswVar;
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzx();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.zza.zzy();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzE();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzd;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getBody() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle bundleZzg = this.zza.zzg();
            if (bundleZzg != null) {
                return bundleZzg;
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getHeadline() {
        try {
            return this.zza.zzr();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final MediaContent getMediaContent() {
        try {
            zzbij zzbijVar = this.zza;
            if (zzbijVar.zzk() != null) {
                return new com.google.android.gms.ads.internal.client.zzff(zzbijVar.zzk(), null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        return null;
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zze;
    }

    public final long getPlacementId() {
        long j;
        AtomicLong atomicLong = this.zzf;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                try {
                    long jZzf = this.zza.zzf();
                    AtomicLong atomicLong2 = this.zzf;
                    atomicLong2.set(jZzf);
                    j = atomicLong2.get();
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to getPlacementId", e);
                    return 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public final String getPrice() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzh;
        try {
            zzeaVarZzh = this.zza.zzh();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            zzeaVarZzh = null;
        }
        if (zzeaVarZzh != null) {
            return new ResponseInfo(zzeaVarZzh);
        }
        return null;
    }

    public final Double getStarRating() {
        try {
            double dZze = this.zza.zze();
            if (dZze == -1.0d) {
                return null;
            }
            return Double.valueOf(dZze);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zza.zzu();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzJ();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzK();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            try {
                if (this.zza.zzK()) {
                    if (muteThisAdReason == null) {
                        this.zza.zzz(null);
                        return;
                    } else if (muteThisAdReason instanceof com.google.android.gms.ads.internal.client.zzdk) {
                        this.zza.zzz(((com.google.android.gms.ads.internal.client.zzdk) muteThisAdReason).zzb);
                        return;
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                        return;
                    }
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad is not custom mute enabled");
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzA(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzB();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void recordEvent(Bundle bundle) {
        try {
            this.zza.zzC(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to record native event", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzL(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzD(bundle);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zza.zzF(new com.google.android.gms.ads.internal.client.zzdg("com.google.android.gms.ads.internal.client.IMuteThisAdListener"));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzG(new com.google.android.gms.ads.internal.client.zzfu(onPaidEventListener));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzI(new zzbtg(unconfirmedClickListener));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to setUnconfirmedClickListener", e);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final /* bridge */ /* synthetic */ Object zza() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final void setPlacementId(long j) {
        try {
            this.zza.zzH(j);
            this.zzf.set(j);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh(DYYbQc.DTNuN, e);
        }
    }
}
