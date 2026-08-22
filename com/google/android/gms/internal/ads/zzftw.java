package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
final class zzftw {
    public static final /* synthetic */ int zzb = 0;
    private static final zzfuo zzc = new zzfuo("OverlayDisplayService");
    private static final Intent zzd = new Intent(jIKWv.VMFwSMtadxkcZ).setPackage("com.android.vending");
    final zzfun zza;
    private final String zze;

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzfts] */
    public zzftw(Context context) {
        if (zzfuq.zza(context)) {
            this.zza = new zzfun(context.getApplicationContext(), zzc, "OverlayDisplayService", zzd, new Object() { // from class: com.google.android.gms.internal.ads.zzfts
            });
        } else {
            this.zza = null;
        }
        this.zze = context.getPackageName();
    }

    public static /* synthetic */ void zza(zzftw zzftwVar, zzfud zzfudVar, int i, zzfub zzfubVar) {
        try {
            zzfun zzfunVar = zzftwVar.zza;
            if (zzfunVar == null) {
                throw null;
            }
            zzfsn zzfsnVar = (zzfsn) zzfunVar.zzc();
            if (zzfsnVar == null) {
                return;
            }
            String str = zzftwVar.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            bundle.putInt("displayMode", i);
            zzi(zzfudVar.zzb(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzfth
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i2 = zzftw.zzb;
                    bundle.putString("sessionToken", (String) obj);
                }
            });
            zzi(zzfudVar.zza(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzftn
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i2 = zzftw.zzb;
                    bundle.putString("appId", (String) obj);
                }
            });
            zzfsnVar.zzg(bundle, new zzftv(zzftwVar, zzfubVar));
        } catch (RemoteException e) {
            zzc.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i), zzftwVar.zze);
        }
    }

    public static /* synthetic */ void zzb(zzftw zzftwVar, zzftd zzftdVar, zzfub zzfubVar) {
        try {
            zzfun zzfunVar = zzftwVar.zza;
            if (zzfunVar == null) {
                throw null;
            }
            zzfsn zzfsnVar = (zzfsn) zzfunVar.zzc();
            if (zzfsnVar == null) {
                return;
            }
            String str = zzftwVar.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            zzi(zzftdVar.zzb(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzftp
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("sessionToken", (String) obj);
                }
            });
            zzi(zzftdVar.zza(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzftq
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("appId", (String) obj);
                }
            });
            zzfsnVar.zze(bundle, new zzftv(zzftwVar, zzfubVar));
        } catch (RemoteException e) {
            zzc.zzb(e, "dismiss overlay display from: %s", zzftwVar.zze);
        }
    }

    public static /* synthetic */ void zzc(zzftw zzftwVar, zzfty zzftyVar, zzfub zzfubVar) {
        try {
            zzfun zzfunVar = zzftwVar.zza;
            if (zzfunVar == null) {
                throw null;
            }
            zzfsn zzfsnVar = (zzfsn) zzfunVar.zzc();
            if (zzfsnVar == null) {
                return;
            }
            String str = zzftwVar.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            bundle.putBinder("windowToken", zzftyVar.zzf());
            zzi(zzftyVar.zzg(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzftu
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("adFieldEnifd", (String) obj);
                }
            });
            bundle.putInt("layoutGravity", zzftyVar.zzc());
            bundle.putFloat("layoutVerticalMargin", zzftyVar.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("triggerMode", 0);
            bundle.putInt("windowWidthPx", zzftyVar.zze());
            zzi(null, new Consumer() { // from class: com.google.android.gms.internal.ads.zzfti
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("deeplinkUrl", (String) obj);
                }
            });
            zzi(null, new Consumer() { // from class: com.google.android.gms.internal.ads.zzftj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("sessionToken", (String) obj);
                }
            });
            zzi(zzftyVar.zzh(), new Consumer() { // from class: com.google.android.gms.internal.ads.zzftk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("appId", (String) obj);
                }
            });
            zzi(null, new Consumer() { // from class: com.google.android.gms.internal.ads.zzftl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i = zzftw.zzb;
                    bundle.putString("thirdPartyAuthCallerId", (String) obj);
                }
            });
            bundle.putBoolean("stableSessionToken", true);
            zzfsnVar.zzf(str, bundle, new zzftv(zzftwVar, zzfubVar));
        } catch (RemoteException e) {
            zzc.zzb(e, "show overlay display from: %s", zzftwVar.zze);
        }
    }

    public static /* synthetic */ boolean zzh(String str) {
        return !zzk(str);
    }

    private static void zzi(String str, Consumer consumer) {
        if (zzk(str)) {
            return;
        }
        str.getClass();
        consumer.accept(str.trim());
    }

    private static boolean zzj(zzfub zzfubVar, String str, List list) {
        if (list.stream().anyMatch(new Predicate() { // from class: com.google.android.gms.internal.ads.zzftt
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return zzftw.zzh((String) obj);
            }
        })) {
            return true;
        }
        zzc.zza(str, new Object[0]);
        zzftz zzftzVarZzc = zzfua.zzc();
        zzftzVarZzc.zzb(8160);
        zzfubVar.zza(zzftzVarZzc.zzc());
        return false;
    }

    private static boolean zzk(String str) {
        return zzfwg.zzc(str).trim().isEmpty();
    }

    public final void zzd() {
        zzfun zzfunVar = this.zza;
        if (zzfunVar == null) {
            return;
        }
        zzc.zzc("unbind LMD display overlay service", new Object[0]);
        zzfunVar.zzn();
    }

    public final void zzf(final zzfty zzftyVar, final zzfub zzfubVar) {
        zzfun zzfunVar = this.zza;
        if (zzfunVar == null) {
            zzc.zza("error: %s", "Play Store not found.");
        } else if (zzj(zzfubVar, "Failed to apply OverlayDisplayShowRequest: missing appId and sessionToken.", Arrays.asList(null, zzftyVar.zzh()))) {
            zzfunVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzftr
                @Override // java.lang.Runnable
                public final void run() {
                    zzftw.zzc(this.zza, zzftyVar, zzfubVar);
                }
            });
        }
    }

    public final void zzg(final zzfud zzfudVar, final zzfub zzfubVar, final int i) {
        zzfun zzfunVar = this.zza;
        if (zzfunVar == null) {
            zzc.zza("error: %s", "Play Store not found.");
        } else if (zzj(zzfubVar, "Failed to apply OverlayDisplayUpdateRequest: missing appId and sessionToken.", Arrays.asList(zzfudVar.zzb(), zzfudVar.zza()))) {
            zzfunVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfto
                @Override // java.lang.Runnable
                public final void run() {
                    zzftw.zza(this.zza, zzfudVar, i, zzfubVar);
                }
            });
        }
    }

    public final void zze(final zzftd zzftdVar, final zzfub zzfubVar) {
        zzfun zzfunVar = this.zza;
        if (zzfunVar == null) {
            zzc.zza("error: %s", bUqMCsuPSX.tnRFMG);
        } else if (zzj(zzfubVar, "Failed to apply OverlayDisplayDismissRequest: missing appId and sessionToken.", Arrays.asList(zzftdVar.zzb(), zzftdVar.zza()))) {
            zzfunVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzftm
                @Override // java.lang.Runnable
                public final void run() {
                    zzftw.zzb(this.zza, zzftdVar, zzfubVar);
                }
            });
        }
    }
}
