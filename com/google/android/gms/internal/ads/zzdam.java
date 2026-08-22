package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: loaded from: classes.dex */
public final class zzdam implements AppEventListener, OnAdMetadataChangedListener, zzcvy, com.google.android.gms.ads.internal.client.zza, zzcyk, zzcws, zzcxx, com.google.android.gms.ads.internal.overlay.zzr, zzcwo, zzded {
    private final zzdaj zza = new zzdaj(this, null);
    private zzeky zzb;
    private zzelc zzc;
    private zzexy zzd;
    private zzfbd zze;

    private static void zzn(Object obj, zzdak zzdakVar) {
        if (obj != null) {
            zzdakVar.zza(obj);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczc
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).onAdClicked();
            }
        });
        zzn(this.zzc, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczd
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzelc) obj).onAdClicked();
            }
        });
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczi
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczo
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).onAppEvent(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zza() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdah
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zza();
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdai
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zza();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzb() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdaa
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzb();
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdab
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzc() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczj
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzc();
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczk
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczv
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczp
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzdH();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczx
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzdf();
            }
        });
        zzn(this.zzc, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdac
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzelc) obj).zzdf();
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdad
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzdf();
            }
        });
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdae
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzdf();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczh
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczu
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzds();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczq
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzdt();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzdu(final zzbwc zzbwcVar, final String str, final String str2) {
        zzn(this.zzb, new zzdak(zzbwcVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzczl
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczn
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzdu(zzbwcVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczw
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzdv();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(final int i) {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczy
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzdw(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zze() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczb
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczm
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvy
    public final void zzf() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzcze
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczf
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxx
    public final void zzg() {
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczz
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcyk
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczr
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzh(zztVar);
            }
        });
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczs
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzh(zztVar);
            }
        });
        zzn(this.zzd, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczt
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzexy) obj).zzh(zztVar);
            }
        });
    }

    public final zzdaj zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcwo
    public final void zzs(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzn(this.zze, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdaf
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzfbd) obj).zzs(zzeVar);
            }
        });
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzdag
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzs(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        zzn(this.zzb, new zzdak() { // from class: com.google.android.gms.internal.ads.zzczg
            @Override // com.google.android.gms.internal.ads.zzdak
            public final void zza(Object obj) {
                ((zzeky) obj).zzt();
            }
        });
    }
}
