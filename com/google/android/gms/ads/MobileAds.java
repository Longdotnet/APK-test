package com.google.android.gms.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda17;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.client.zzey;
import com.google.android.gms.ads.internal.client.zzfx;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbpm;

/* JADX INFO: loaded from: classes.dex */
public class MobileAds {
    /* JADX WARN: Code duplicated, block: B:38:0x00a3 A[Catch: all -> 0x0066, TryCatch #2 {, blocks: (B:20:0x0032, B:22:0x0050, B:33:0x006f, B:35:0x0080, B:37:0x0092, B:44:0x00d7, B:45:0x00e9, B:38:0x00a3, B:40:0x00b1, B:42:0x00c3, B:43:0x00cf, B:24:0x0054, B:27:0x0060, B:32:0x006a), top: B:54:0x0032, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1 A[Catch: all -> 0x0066, TryCatch #2 {, blocks: (B:20:0x0032, B:22:0x0050, B:33:0x006f, B:35:0x0080, B:37:0x0092, B:44:0x00d7, B:45:0x00e9, B:38:0x00a3, B:40:0x00b1, B:42:0x00c3, B:43:0x00cf, B:24:0x0054, B:27:0x0060, B:32:0x006a), top: B:54:0x0032, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c3 A[Catch: all -> 0x0066, TryCatch #2 {, blocks: (B:20:0x0032, B:22:0x0050, B:33:0x006f, B:35:0x0080, B:37:0x0092, B:44:0x00d7, B:45:0x00e9, B:38:0x00a3, B:40:0x00b1, B:42:0x00c3, B:43:0x00cf, B:24:0x0054, B:27:0x0060, B:32:0x006a), top: B:54:0x0032, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00cf A[Catch: all -> 0x0066, TryCatch #2 {, blocks: (B:20:0x0032, B:22:0x0050, B:33:0x006f, B:35:0x0080, B:37:0x0092, B:44:0x00d7, B:45:0x00e9, B:38:0x00a3, B:40:0x00b1, B:42:0x00c3, B:43:0x00cf, B:24:0x0054, B:27:0x0060, B:32:0x006a), top: B:54:0x0032, inners: #3 }] */
    public static void initialize(Activity activity, GoogleMobileAdsGM$$ExternalSyntheticLambda17 googleMobileAdsGM$$ExternalSyntheticLambda17) {
        final zzey zzeyVarZzf = zzey.zzf();
        synchronized (zzeyVarZzf.zzf) {
            try {
                if (zzeyVarZzf.zzi) {
                    zzeyVarZzf.zzh.add(googleMobileAdsGM$$ExternalSyntheticLambda17);
                    return;
                }
                if (zzeyVarZzf.zzj) {
                    googleMobileAdsGM$$ExternalSyntheticLambda17.f$0.lambda$AdMob_Initialize$0(zzeyVarZzf.zze());
                    return;
                }
                zzeyVarZzf.zzi = true;
                zzeyVarZzf.zzh.add(googleMobileAdsGM$$ExternalSyntheticLambda17);
                synchronized (zzeyVarZzf.zzk) {
                    try {
                        zzeyVarZzf.zzC(activity);
                        zzeyVarZzf.zzl.zzs(new zzew(zzeyVarZzf));
                        zzeyVarZzf.zzl.zzo(new zzbpm());
                        RequestConfiguration requestConfiguration = zzeyVarZzf.zzn;
                        if (requestConfiguration.zzb != -1 || requestConfiguration.zzc != -1) {
                            try {
                                zzeyVarZzf.zzl.zzu(new zzfx(requestConfiguration));
                            } catch (RemoteException e) {
                                zzo.zzh("Unable to set request configuration parcel.", e);
                            }
                        }
                    } catch (RemoteException e2) {
                        zzo.zzk("MobileAdsSettingManager initialization failed", e2);
                    }
                    zzbde.zza(activity);
                    if (((Boolean) zzbfc.zza.zze()).booleanValue()) {
                        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlD)).booleanValue()) {
                            zzo.zze("Initializing on bg thread");
                            final int i = 0;
                            com.google.android.gms.ads.internal.util.client.zzb.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzer
                                private final void run$com$google$android$gms$ads$internal$client$zzer() {
                                    zzey zzeyVar = zzeyVarZzf;
                                    synchronized (zzeyVar.zzk) {
                                        zzeyVar.zzB();
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i) {
                                        case 0:
                                            run$com$google$android$gms$ads$internal$client$zzer();
                                            return;
                                        default:
                                            zzey zzeyVar = zzeyVarZzf;
                                            synchronized (zzeyVar.zzk) {
                                                zzeyVar.zzB();
                                                break;
                                            }
                                            return;
                                    }
                                }
                            });
                        } else if (((Boolean) zzbfc.zzb.zze()).booleanValue()) {
                            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlD)).booleanValue()) {
                                final int i2 = 1;
                                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzer
                                    private final void run$com$google$android$gms$ads$internal$client$zzer() {
                                        zzey zzeyVar = zzeyVarZzf;
                                        synchronized (zzeyVar.zzk) {
                                            zzeyVar.zzB();
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i2) {
                                            case 0:
                                                run$com$google$android$gms$ads$internal$client$zzer();
                                                return;
                                            default:
                                                zzey zzeyVar = zzeyVarZzf;
                                                synchronized (zzeyVar.zzk) {
                                                    zzeyVar.zzB();
                                                    break;
                                                }
                                                return;
                                        }
                                    }
                                });
                            } else {
                                zzo.zze("Initializing on calling thread");
                                zzeyVarZzf.zzB();
                            }
                        } else {
                            zzo.zze("Initializing on calling thread");
                            zzeyVarZzf.zzB();
                        }
                    } else if (((Boolean) zzbfc.zzb.zze()).booleanValue()) {
                        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlD)).booleanValue()) {
                            final int i3 = 1;
                            com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzer
                                private final void run$com$google$android$gms$ads$internal$client$zzer() {
                                    zzey zzeyVar = zzeyVarZzf;
                                    synchronized (zzeyVar.zzk) {
                                        zzeyVar.zzB();
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i3) {
                                        case 0:
                                            run$com$google$android$gms$ads$internal$client$zzer();
                                            return;
                                        default:
                                            zzey zzeyVar = zzeyVarZzf;
                                            synchronized (zzeyVar.zzk) {
                                                zzeyVar.zzB();
                                                break;
                                            }
                                            return;
                                    }
                                }
                            });
                        } else {
                            zzo.zze("Initializing on calling thread");
                            zzeyVarZzf.zzB();
                        }
                    } else {
                        zzo.zze("Initializing on calling thread");
                        zzeyVarZzf.zzB();
                    }
                    zzb.zza(activity);
                    activity.getApplicationContext();
                    zzb.zza(activity);
                    activity.getApplicationContext();
                    zzb.zza(activity);
                    activity.getApplicationContext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void setPlugin(String str) {
        zzey zzeyVarZzf = zzey.zzf();
        synchronized (zzeyVarZzf.zzk) {
            zzah.checkState(zzeyVarZzf.zzl != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                zzeyVarZzf.zzl.zzt(str);
            } catch (RemoteException e) {
                zzo.zzh("Unable to set plugin.", e);
            }
        }
    }
}
