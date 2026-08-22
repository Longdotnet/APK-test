package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.inject.PVS.jIKWv;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbkr implements zzbkf {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdsj zzb;
    private final zzbso zzd;
    private final zzeca zze;
    private final zzcmq zzf;
    private com.google.android.gms.ads.internal.util.client.zzu zzc = null;
    private com.google.android.gms.ads.internal.overlay.zzaa zzg = null;
    private final zzgdy zzh = zzcaf.zzg;

    public zzbkr(com.google.android.gms.ads.internal.zzb zzbVar, zzbso zzbsoVar, zzeca zzecaVar, zzdsj zzdsjVar, zzcmq zzcmqVar) {
        this.zza = zzbVar;
        this.zzd = zzbsoVar;
        this.zze = zzecaVar;
        this.zzb = zzdsjVar;
        this.zzf = zzcmqVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    public static Uri zzc(Context context, zzavu zzavuVar, Uri uri, View view, Activity activity, zzfda zzfdaVar) {
        if (zzavuVar == null) {
            return uri;
        }
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzmu)).booleanValue() || zzfdaVar == null) {
                if (zzavuVar.zze(uri)) {
                    uri = zzavuVar.zza(uri, context, view, activity);
                }
            } else if (zzavuVar.zze(uri)) {
                uri = zzfdaVar.zza(uri, context, view, activity);
            }
        } catch (zzavv unused) {
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
        }
        return uri;
    }

    public static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String strValueOf = String.valueOf(uri.toString());
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error adding click uptime parameter to url: ".concat(strValueOf), e);
        }
        return uri;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0165  */
    /* JADX WARN: Code duplicated, block: B:9:0x0087  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010c, code lost:
    
        if (com.google.android.gms.internal.ads.zzbkq.zzc(r2, r12, r13, r14, r15) == null) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r21, java.util.Map r22, boolean r23, java.lang.String r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkr.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbso zzbsoVar = this.zzd;
        if (zzbsoVar != null) {
            zzbsoVar.zzb(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(com.google.android.gms.internal.ads.zzbde.zziU)).booleanValue() != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(com.google.android.gms.internal.ads.zzbde.zziP)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(com.google.android.gms.internal.ads.zzbde.zziO)).booleanValue()) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r10, android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkr.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        zzdsj zzdsjVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeS)).booleanValue() || (zzdsjVar = this.zzb) == null) {
            return;
        }
        zzdsi zzdsiVarZza = zzdsjVar.zza();
        zzdsiVarZza.zzb("action", "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdsiVarZza.zzb("cct_open_status", str);
        zzdsiVarZza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcmq zzcmqVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcfg zzcfgVar = (zzcfg) zzaVar;
        if (zzcfgVar.zzD() != null) {
            map2 = zzcfgVar.zzD().zzaw;
        }
        String strZzc = zzbyq.zzc(str, zzcfgVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            zzgdn.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkx)).booleanValue() && (zzcmqVar = this.zzf) != null && zzcmq.zzj(strZzc)) ? zzcmqVar.zze(strZzc, com.google.android.gms.ads.internal.client.zzbb.zzb.zzg) : zzgdn.zzh(strZzc), new zzbkn(this, map, zzaVar, str2), this.zzh);
        } else {
            zzbVar.zzb(strZzc);
        }
    }

    public static boolean zzf(Map map) {
        return ZRqOdXiy.RMAmectpFc.equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:119:0x02f5  */
    public final void zzh(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean zZzb;
        HashMap map2;
        boolean z;
        String string;
        zzcfg zzcfgVar = (zzcfg) zzaVar;
        zzfca zzfcaVarZzD = zzcfgVar.zzD();
        zzfcd zzfcdVarZzR = zzcfgVar.zzR();
        boolean zZzg = false;
        if (zzfcaVarZzD == null || zzfcdVarZzR == null) {
            str3 = "";
            zZzb = false;
        } else {
            String str4 = zzfcdVarZzR.zzb;
            zZzb = zzfcaVarZzD.zzb();
            str3 = str4;
        }
        zzbcv zzbcvVar = zzbde.zzlg;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        boolean z2 = (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) ? false : true;
        zzbcv zzbcvVar2 = zzbde.zzng;
        zzbdc zzbdcVar = zzbdVar.zzd;
        boolean zBooleanValue = ((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue();
        String str5 = ygoi.meDHKIKHnsKt;
        boolean z3 = zBooleanValue && map.containsKey("ig_cl") && ((String) map.get("ig_cl")).equals(str5);
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcfgVar.zzaF()) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(jIKWv.VZQsTLmvqTLpy);
                return;
            } else {
                zzk(false);
                ((zzcgq) zzaVar).zzaL(zzf(map), zzb(map), z2);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzk(false);
            boolean z4 = ((Boolean) zzbdcVar.zzb(zzbde.zzmq)).booleanValue() && Objects.equals(map.get("is_allowed_for_lock_screen"), "1");
            if (str != null) {
                ((zzcgq) zzaVar).zzaN(zzf(map), zzb(map), str, z2, z4);
                return;
            } else {
                ((zzcgq) zzaVar).zzaM(zzf(map), zzb(map), (String) map.get("html"), (String) map.get("baseurl"), z2);
                return;
            }
        }
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzcfgVar.getContext();
            if (((Boolean) zzbdcVar.zzb(zzbde.zzeY)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                zzm(10);
            } else {
                if (((Boolean) zzbdcVar.zzb(zzbde.zzeT)).booleanValue()) {
                    String packageName = CustomTabsClient.getPackageName(context);
                    if (packageName != null && !context.getPackageName().equals(packageName)) {
                        zZzg = true;
                    }
                } else {
                    zZzg = zzbef.zzg(context);
                }
                if (zZzg) {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri uriZzd = zzd(zzc(zzcfgVar.getContext(), zzcfgVar.zzI(), Uri.parse(str), zzcfgVar.zzF(), zzcfgVar.zzi(), zzcfgVar.zzS()));
                    if (zZzb && this.zze != null && zzl(zzaVar, zzcfgVar.getContext(), uriZzd.toString(), str3)) {
                        return;
                    }
                    this.zzg = new zzbko(this);
                    ((zzcgq) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(null, uriZzd.toString(), null, null, null, null, null, null, new ObjectWrapper(this.zzg).asBinder(), true), z2, z3, str3);
                    return;
                }
                zzm(4);
            }
            map.put("use_first_package", str5);
            map.put("use_running_process", str5);
            zzj(zzaVar, map, zZzb, str3, z2, z3);
            return;
        }
        if ("app".equalsIgnoreCase(str2) && str5.equalsIgnoreCase((String) map.get("system_browser"))) {
            zzj(zzaVar, map, zZzb, str3, z2, z3);
            return;
        }
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) zzbdcVar.zzb(zzbde.zziE)).booleanValue()) {
                zzk(true);
                String str6 = (String) map.get("p");
                if (str6 == null) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Package name missing from open app action.");
                    return;
                }
                if (zZzb && this.zze != null && zzl(zzaVar, zzcfgVar.getContext(), str6, str3)) {
                    return;
                }
                PackageManager packageManager = zzcfgVar.getContext().getPackageManager();
                if (packageManager == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot get package manager from open app action.");
                    return;
                } else {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str6);
                    if (launchIntentForPackage != null) {
                        ((zzcgq) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzg), z2, z3, str3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        zzk(true);
        String str7 = (String) map.get("intent_url");
        Intent uri = null;
        if (!TextUtils.isEmpty(str7)) {
            try {
                uri = Intent.parseUri(str7, 0);
            } catch (URISyntaxException e) {
                String strValueOf = String.valueOf(str7);
                int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the url: ".concat(strValueOf), e);
            }
        }
        Intent intent = uri;
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri uriZzd2 = zzd(zzc(zzcfgVar.getContext(), zzcfgVar.zzI(), data, zzcfgVar.zzF(), zzcfgVar.zzi(), zzcfgVar.zzS()));
                if (TextUtils.isEmpty(intent.getType())) {
                    intent.setData(uriZzd2);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziF)).booleanValue()) {
                        intent.setDataAndType(uriZzd2, intent.getType());
                    } else {
                        intent.setData(uriZzd2);
                    }
                }
            }
        }
        boolean z5 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzja)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id");
        HashMap map3 = new HashMap();
        if (z5) {
            map2 = map3;
            this.zzg = new zzbkp(this, z2, zzaVar, map3, map);
            z = false;
        } else {
            map2 = map3;
            z = z2;
        }
        if (intent != null) {
            if (!zZzb || this.zze == null || !zzl(zzaVar, zzcfgVar.getContext(), intent.getData().toString(), str3)) {
                ((zzcgq) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(intent, this.zzg), z, z3, str3);
                return;
            } else {
                if (z5) {
                    map2.put((String) map.get("event_id"), Boolean.TRUE);
                    ((zzbna) zzaVar).zzd("openIntentAsync", map2);
                    return;
                }
                return;
            }
        }
        boolean z6 = z3;
        if (TextUtils.isEmpty(str)) {
            string = str;
        } else {
            string = zzd(zzc(zzcfgVar.getContext(), zzcfgVar.zzI(), Uri.parse(str), zzcfgVar.zzF(), zzcfgVar.zzi(), zzcfgVar.zzS())).toString();
        }
        if (!zZzb || this.zze == null || !zzl(zzaVar, zzcfgVar.getContext(), string, str3)) {
            ((zzcgq) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get(CyjpdoedCdLTIO.EjBnXGCVDwhH), string, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e"), this.zzg), z, z6, str3);
        } else if (z5) {
            map2.put((String) map.get(r5), Boolean.TRUE);
            ((zzbna) zzaVar).zzd("openIntentAsync", map2);
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzeca zzecaVar = this.zze;
        zzecaVar.zzc(str);
        zzdsj zzdsjVar = this.zzb;
        if (zzdsjVar != null) {
            zzecl.zzp(context, zzdsjVar, zzecaVar, str, "dialog_not_shown", zzfyt.zze(GsPcpBmONXh.zTnEF, str2));
        }
    }
}
