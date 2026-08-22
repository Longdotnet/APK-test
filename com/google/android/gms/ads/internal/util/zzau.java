package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzfrw;
import com.google.android.gms.internal.ads.zzgdy;
import com.yoyogames.runner.RunnerJNILib;
import com.yoyogames.runner.RunnerJNILib$5$1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzau {
    public final Context zza;
    public final zzdvi zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public final int zzh;
    public PointF zzi;
    public PointF zzj;
    public final zzfrw zzk;
    public int zzg = 0;
    public final zzae zzl = new zzae(this, 1);

    public zzau(Context context) {
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar.zzu.zzb();
        this.zzk = (zzfrw) zzvVar.zzu.zzb;
        this.zzb = zzvVar.zzp.zzg;
    }

    public static final int zzu(ArrayList arrayList, String str, boolean z) {
        if (!z) {
            return -1;
        }
        arrayList.add(str);
        return arrayList.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.zzd, "}");
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i == -1) {
            return;
        }
        zzae zzaeVar = this.zzl;
        zzfrw zzfrwVar = this.zzk;
        if (i == 0) {
            if (actionMasked == 5) {
                this.zzg = 5;
                this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                zzfrwVar.postDelayed(zzaeVar, ((Long) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfg)).longValue());
                return;
            }
            return;
        }
        if (i == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z = false;
                for (int i2 = 0; i2 < historySize; i2++) {
                    z |= !zzt(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                }
                if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                    return;
                }
            }
            this.zzg = -1;
            zzfrwVar.removeCallbacks(zzaeVar);
        }
    }

    public final void zzr() {
        String str;
        try {
            Context context = this.zza;
            if (!(context instanceof Activity)) {
                int i = zze.$r8$clinit;
                zzo.zzi("Can not create dialog without Activity Context");
                return;
            }
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzay zzayVar = zzvVar.zzp;
            synchronized (zzayVar.zzb) {
                str = zzayVar.zzd;
            }
            String str2 = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(str)) {
                str2 = "Creative preview";
            }
            String str3 = true != zzvVar.zzp.zzm() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iZzu = zzu(arrayList, "Ad information", true);
            final int iZzu2 = zzu(arrayList, str2, true);
            final int iZzu3 = zzu(arrayList, str3, true);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjE)).booleanValue();
            final int iZzu4 = zzu(arrayList, "Open ad inspector", zBooleanValue);
            final int iZzu5 = zzu(arrayList, "Ad inspector settings", zBooleanValue);
            AlertDialog.Builder builderZzL = zzs.zzL(context);
            builderZzL.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzam
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    final int i3 = 0;
                    int i4 = 2;
                    int i5 = iZzu;
                    final zzau zzauVar = this.zza;
                    if (i2 != i5) {
                        if (i2 == iZzu2) {
                            int i6 = zze.$r8$clinit;
                            zzo.zze("Debug mode [Creative Preview] selected.");
                            zzcaf.zza.execute(new zzae(zzauVar, i4));
                            return;
                        }
                        if (i2 == iZzu3) {
                            int i7 = zze.$r8$clinit;
                            zzo.zze("Debug mode [Troubleshooting] selected.");
                            zzcaf.zza.execute(new zzae(zzauVar, 6));
                            return;
                        }
                        if (i2 == iZzu4) {
                            zzdvi zzdviVar = zzauVar.zzb;
                            final zzgdy zzgdyVar = zzcaf.zzf;
                            zzgdy zzgdyVar2 = zzcaf.zza;
                            if (zzdviVar.zzq()) {
                                zzgdyVar.execute(new zzae(zzauVar, 5));
                                return;
                            } else {
                                final int i8 = 1;
                                zzgdyVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzal
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i8) {
                                            case 0:
                                                com.google.android.gms.ads.internal.zzv zzvVar2 = com.google.android.gms.ads.internal.zzv.zza;
                                                zzay zzayVar2 = zzvVar2.zzp;
                                                zzau zzauVar2 = zzauVar;
                                                Context context2 = zzauVar2.zza;
                                                if (!zzayVar2.zzj(context2, zzauVar2.zzd, zzauVar2.zze)) {
                                                    zzvVar2.zzp.zzd(context2, zzauVar2.zzd, zzauVar2.zze);
                                                } else {
                                                    zzgdyVar.execute(new zzae(zzauVar2, 4));
                                                }
                                                break;
                                            default:
                                                com.google.android.gms.ads.internal.zzv zzvVar3 = com.google.android.gms.ads.internal.zzv.zza;
                                                zzay zzayVar3 = zzvVar3.zzp;
                                                zzau zzauVar3 = zzauVar;
                                                Context context3 = zzauVar3.zza;
                                                if (!zzayVar3.zzj(context3, zzauVar3.zzd, zzauVar3.zze)) {
                                                    zzvVar3.zzp.zzd(context3, zzauVar3.zzd, zzauVar3.zze);
                                                } else {
                                                    zzgdyVar.execute(new zzae(zzauVar3, 3));
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        if (i2 == iZzu5) {
                            zzdvi zzdviVar2 = zzauVar.zzb;
                            final zzgdy zzgdyVar3 = zzcaf.zzf;
                            zzgdy zzgdyVar4 = zzcaf.zza;
                            if (zzdviVar2.zzq()) {
                                zzgdyVar3.execute(new zzae(zzauVar, i3));
                                return;
                            } else {
                                zzgdyVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzal
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i3) {
                                            case 0:
                                                com.google.android.gms.ads.internal.zzv zzvVar2 = com.google.android.gms.ads.internal.zzv.zza;
                                                zzay zzayVar2 = zzvVar2.zzp;
                                                zzau zzauVar2 = zzauVar;
                                                Context context2 = zzauVar2.zza;
                                                if (!zzayVar2.zzj(context2, zzauVar2.zzd, zzauVar2.zze)) {
                                                    zzvVar2.zzp.zzd(context2, zzauVar2.zzd, zzauVar2.zze);
                                                } else {
                                                    zzgdyVar3.execute(new zzae(zzauVar2, 4));
                                                }
                                                break;
                                            default:
                                                com.google.android.gms.ads.internal.zzv zzvVar3 = com.google.android.gms.ads.internal.zzv.zza;
                                                zzay zzayVar3 = zzvVar3.zzp;
                                                zzau zzauVar3 = zzauVar;
                                                Context context3 = zzauVar3.zza;
                                                if (!zzayVar3.zzj(context3, zzauVar3.zzd, zzauVar3.zze)) {
                                                    zzvVar3.zzp.zzd(context3, zzauVar3.zzd, zzauVar3.zze);
                                                } else {
                                                    zzgdyVar3.execute(new zzae(zzauVar3, 3));
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        return;
                    }
                    Context context2 = zzauVar.zza;
                    if (!(context2 instanceof Activity)) {
                        int i9 = zze.$r8$clinit;
                        zzo.zzi("Can not create dialog without Activity Context");
                        return;
                    }
                    String str4 = zzauVar.zzc;
                    String str5 = "No debug information";
                    if (!TextUtils.isEmpty(str4)) {
                        Uri uriBuild = new Uri.Builder().encodedQuery(str4.replaceAll(UUFMQdNK.MPoMDDfDmZKHj, "%20")).build();
                        StringBuilder sb = new StringBuilder();
                        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                        HashMap mapZzQ = zzs.zzQ(uriBuild);
                        for (String str6 : mapZzQ.keySet()) {
                            sb.append(str6);
                            sb.append(" = ");
                            sb.append((String) mapZzQ.get(str6));
                            sb.append("\n\n");
                        }
                        String strTrim = sb.toString().trim();
                        if (!TextUtils.isEmpty(strTrim)) {
                            str5 = strTrim;
                        }
                    }
                    zzs zzsVar2 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    AlertDialog.Builder builderZzL2 = zzs.zzL(context2);
                    builderZzL2.setMessage(str5);
                    builderZzL2.setTitle("Ad Information");
                    builderZzL2.setPositiveButton("Share", new RunnerJNILib$5$1(zzauVar, str5));
                    builderZzL2.setNegativeButton("Close", new RunnerJNILib.AnonymousClass2.AnonymousClass1(2));
                    builderZzL2.create().show();
                }
            });
            builderZzL.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public final void zzs(Context context) {
        final int i;
        ArrayList arrayList = new ArrayList();
        int iZzu = zzu(arrayList, "None", true);
        final int iZzu2 = zzu(arrayList, "Shake", true);
        final int iZzu3 = zzu(arrayList, "Flick", true);
        int iOrdinal = this.zzb.zza().ordinal();
        if (iOrdinal != 1) {
            i = iOrdinal != 2 ? iZzu : iZzu3;
        } else {
            i = iZzu2;
        }
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        AlertDialog.Builder builderZzL = zzs.zzL(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i);
        builderZzL.setTitle("Setup gesture");
        builderZzL.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new RunnerJNILib.AnonymousClass2.DialogInterfaceOnClickListenerC00072(atomicInteger, 1));
        builderZzL.setNegativeButton("Dismiss", new RunnerJNILib.AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, 2));
        builderZzL.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AtomicInteger atomicInteger2 = atomicInteger;
                int i3 = atomicInteger2.get();
                zzau zzauVar = this.zza;
                if (i3 != i) {
                    if (atomicInteger2.get() == iZzu2) {
                        zzauVar.zzb.zzm(zzdve.SHAKE);
                    } else if (atomicInteger2.get() == iZzu3) {
                        zzauVar.zzb.zzm(zzdve.FLICK);
                    } else {
                        zzauVar.zzb.zzm(zzdve.NONE);
                    }
                }
                zzauVar.zzr();
            }
        });
        builderZzL.setOnCancelListener(new DialogFragment.AnonymousClass2(this, 1));
        builderZzL.create().show();
    }

    public final boolean zzt(float f, float f2, float f3, float f4) {
        float fAbs = Math.abs(this.zzi.x - f);
        int i = this.zzh;
        return fAbs < ((float) i) && Math.abs(this.zzi.y - f2) < ((float) i) && Math.abs(this.zzj.x - f3) < ((float) i) && Math.abs(this.zzj.y - f4) < ((float) i);
    }
}
