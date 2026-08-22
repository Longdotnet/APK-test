package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat$BigPictureStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.loader.app.gv.DYYbQc;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzecl extends zzbti {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdsj zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzeca zze;
    private String zzf;
    private String zzg;

    public zzecl(Context context, zzeca zzecaVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzdsj zzdsjVar) {
        this.zzb = context;
        this.zzc = zzdsjVar;
        this.zzd = zzuVar;
        this.zze = zzecaVar;
    }

    public static /* synthetic */ void zzc(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzd(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "rtsdc", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static void zzk(zzecl zzeclVar, Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzeclVar.zzw(zzeclVar.zzf, "rtsdc", map);
        activity.startActivity(com.google.android.gms.ads.internal.zzv.zza.zzg.zzf(activity));
        zzeclVar.zzx();
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzl(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzeclVar.zzw(zzeclVar.zzf, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    public static /* synthetic */ void zzm(zzecl zzeclVar, Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzeclVar.zzw(zzeclVar.zzf, "dialog_click", map);
        zzeclVar.zzy(activity, zzmVar);
    }

    public static void zzo(Context context, zzdsj zzdsjVar, zzeca zzecaVar, String str, String str2) {
        zzp(context, zzdsjVar, zzecaVar, str, str2, new HashMap());
    }

    public static void zzp(Context context, zzdsj zzdsjVar, zzeca zzecaVar, String str, String str2, Map map) {
        String strZze;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        String str3 = true != zzvVar.zzi.zzA(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (zzdsjVar != null) {
            zzdsi zzdsiVarZza = zzdsjVar.zza();
            zzdsiVarZza.zzb("gqi", str);
            zzdsiVarZza.zzb("action", str2);
            zzdsiVarZza.zzb("device_connectivity", str3);
            zzvVar.zzl.getClass();
            zzdsiVarZza.zzb("event_timestamp", String.valueOf(System.currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzdsiVarZza.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            strZze = zzdsiVarZza.zze();
        } else {
            strZze = "";
        }
        String str4 = strZze;
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        zzecaVar.zzd(new zzecc(System.currentTimeMillis(), str, str4, 2));
    }

    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, "com.google.android.gms.ads.AdService");
            return zzfsk.zzb(context, 0, intent, 1140850688, 0);
        }
        intent.setClassName(context, "com.google.android.gms.ads.NotificationHandlerActivity");
        return zzfsk.zza(context, 0, intent, 201326592);
    }

    private final AlertDialog zzs(Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        AlertDialog.Builder onCancelListener = com.google.android.gms.ads.internal.util.zzs.zzL(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzecd
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzm zzmVar2 = zzmVar;
                if (zzmVar2 != null) {
                    zzmVar2.zzb();
                }
            }
        });
        XmlResourceParser xmlResourceParserZzt = zzt(R.layout.offline_ads_dialog);
        if (xmlResourceParserZzt == null) {
            onCancelListener.setMessage(zzv(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            return onCancelListener.create();
        }
        try {
            View viewInflate = activity.getLayoutInflater().inflate(xmlResourceParserZzt, (ViewGroup) null);
            onCancelListener.setView(viewInflate);
            String strZzu = zzu();
            if (!TextUtils.isEmpty(strZzu)) {
                TextView textView = (TextView) viewInflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(strZzu);
            }
            zzebs zzebsVar = (zzebs) this.zza.get(this.zzf);
            Drawable drawableZza = zzebsVar != null ? zzebsVar.zza() : null;
            if (drawableZza != null) {
                ((ImageView) viewInflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawableZza);
            }
            AlertDialog alertDialogCreate = onCancelListener.create();
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            return alertDialogCreate;
        } catch (Resources.NotFoundException unused) {
            onCancelListener.setMessage(zzv(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            return onCancelListener.create();
        }
    }

    private static XmlResourceParser zzt(int i) {
        Resources resourcesZze = com.google.android.gms.ads.internal.zzv.zza.zzi.zze();
        if (resourcesZze == null) {
            return null;
        }
        try {
            return resourcesZze.getLayout(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private final String zzu() {
        zzebs zzebsVar = (zzebs) this.zza.get(this.zzf);
        return zzebsVar == null ? "" : zzebsVar.zzb();
    }

    private static String zzv(int i, String str) {
        Resources resourcesZze = com.google.android.gms.ads.internal.zzv.zza.zzi.zze();
        if (resourcesZze == null) {
            return str;
        }
        try {
            return resourcesZze.getString(i);
        } catch (Resources.NotFoundException unused) {
            return str;
        }
    }

    private final void zzw(String str, String str2, Map map) {
        zzp(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    private final void zzx() {
        boolean zZzg;
        boolean zZzf;
        try {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            Context context = this.zzb;
            com.google.android.gms.ads.internal.util.zzbr zzbrVarZzA = com.google.android.gms.ads.internal.util.zzs.zzA(context);
            ObjectWrapper objectWrapper = new ObjectWrapper(context);
            String str = this.zzg;
            String str2 = this.zzf;
            zzebs zzebsVar = (zzebs) this.zza.get(str2);
            zZzg = zzbrVarZzA.zzg(objectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, zzebsVar == null ? "" : zzebsVar.zzc()));
            if (zZzg) {
                zZzf = true;
            } else {
                try {
                    zZzf = zzbrVarZzA.zzf(new ObjectWrapper(context), this.zzg, this.zzf);
                } catch (RemoteException e) {
                    e = e;
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to schedule offline notification poster.", e);
                    zZzf = zZzg;
                }
            }
        } catch (RemoteException e2) {
            e = e2;
            zZzg = false;
        }
        if (zZzf) {
            return;
        }
        this.zze.zzc(this.zzf);
        zzw(this.zzf, "offline_notification_worker_not_scheduled", zzfyt.zzd());
    }

    private final void zzy(final Activity activity, final com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zzvVar.zzd;
        if (new NotificationManagerCompat(activity).areNotificationsEnabled()) {
            zzx();
            zzz(activity, zzmVar);
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzw(this.zzf, "asnpdi", zzfyt.zzd());
                return;
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar2 = zzvVar.zzd;
            AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.util.zzs.zzL(activity);
            builderZzL.setTitle(zzv(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzv(R.string.notifications_permission_confirm, "Allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzece
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    zzecl.zzk(this.zza, activity, zzmVar, dialogInterface, i);
                }
            }).setNegativeButton(zzv(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzecf
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    zzecl.zzc(this.zza, zzmVar, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzecg
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    zzecl.zzd(this.zza, zzmVar, dialogInterface);
                }
            });
            builderZzL.create().show();
            zzw(this.zzf, "rtsdi", zzfyt.zzd());
        }
    }

    private final void zzz(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        AlertDialog alertDialogZzs = zzs(activity, zzmVar);
        alertDialogZzs.show();
        Timer timer = new Timer();
        timer.schedule(new zzeck(this, alertDialogZzs, timer, zzmVar), 3000L);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(iafHZUfOuHNwvy.xhgmZTDHcE)) {
                zzecn zzecnVar = (zzecn) ObjectWrapper.unwrap(iObjectWrapper);
                Activity activityZza = zzecnVar.zza();
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzecnVar.zzb();
                HashMap map = new HashMap();
                if (iArr[i] == 0) {
                    map.put("dialog_action", "confirm");
                    zzx();
                    zzz(activityZza, zzmVarZzb);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (zzmVarZzb != null) {
                        zzmVarZzb.zzb();
                    }
                }
                zzw(this.zzf, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzecn zzecnVar = (zzecn) ObjectWrapper.unwrap(iObjectWrapper);
        final Activity activityZza = zzecnVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzm zzmVarZzb = zzecnVar.zzb();
        this.zzf = zzecnVar.zzc();
        this.zzg = zzecnVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziQ)).booleanValue()) {
            zzy(activityZza, zzmVarZzb);
            return;
        }
        zzw(this.zzf, "dialog_impression", zzfyt.zzd());
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.util.zzs.zzL(activityZza);
        builderZzL.setTitle(zzv(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzv(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzv(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzech
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                zzecl.zzm(this.zza, activityZza, zzmVarZzb, dialogInterface, i);
            }
        }).setNegativeButton(zzv(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeci
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                zzecl.zzl(this.zza, zzmVarZzb, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzecj
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                zzecl.zzn(this.zza, zzmVarZzb, dialogInterface);
            }
        });
        builderZzL.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzh() {
        final com.google.android.gms.ads.internal.util.client.zzu zzuVar = this.zzd;
        this.zze.zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzebt
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                zzeca.zzb(zzuVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new com.google.android.gms.ads.internal.offline.buffering.zza(str, str2, ""));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x00a8  */
    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Bitmap bitmapDecodeStream;
        String str;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str2 = zzaVar.zza;
        String strZzu = zzu();
        com.google.android.gms.ads.internal.zzv.zza.zzg.zzh(context);
        String str3 = zzaVar.zzb;
        PendingIntent pendingIntentZzr = zzr(context, "offline_notification_clicked", str3, str2);
        PendingIntent pendingIntentZzr2 = zzr(context, "offline_notification_dismissed", str3, str2);
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, "offline_notification_channel");
        Notification notification = notificationCompat$Builder.mNotification;
        if (TextUtils.isEmpty(strZzu)) {
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(zzv(R.string.offline_notification_title, "You are back online! Let's pick up where we left off"));
        } else {
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(String.format(zzv(R.string.offline_notification_title_with_advertiser, "You are back online! Continue learning about %s"), strZzu));
        }
        notification.flags |= 16;
        notification.deleteIntent = pendingIntentZzr2;
        notificationCompat$Builder.mContentIntent = pendingIntentZzr;
        notification.icon = context.getApplicationInfo().icon;
        zzbcv zzbcvVar = zzbde.zziR;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        notificationCompat$Builder.mPriority = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zziT)).booleanValue()) {
            String str4 = zzaVar.zzc;
            if (str4.isEmpty()) {
                bitmapDecodeStream = null;
            } else {
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str4).openConnection().getInputStream());
                } catch (IOException unused) {
                    bitmapDecodeStream = null;
                }
            }
        } else {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream != null) {
            try {
                notificationCompat$Builder.setLargeIcon(bitmapDecodeStream);
                NotificationCompat$BigPictureStyle notificationCompat$BigPictureStyle = new NotificationCompat$BigPictureStyle();
                IconCompat iconCompat = new IconCompat(1);
                iconCompat.mObj1 = bitmapDecodeStream;
                notificationCompat$BigPictureStyle.mPictureIcon = iconCompat;
                notificationCompat$BigPictureStyle.mBigLargeIcon = null;
                notificationCompat$BigPictureStyle.mBigLargeIconSet = true;
                notificationCompat$Builder.setStyle(notificationCompat$BigPictureStyle);
            } catch (Resources.NotFoundException unused2) {
            }
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap map = new HashMap();
        try {
            notificationManager.notify(str3, 54321, notificationCompat$Builder.build());
            str = "offline_notification_impression";
        } catch (IllegalArgumentException e) {
            map.put("notification_not_shown_reason", e.getMessage());
            str = "offline_notification_failed";
        }
        zzw(str3, str, map);
    }

    public final void zzq(String str, zzdit zzditVar) {
        String strZzx = zzditVar.zzx();
        String strZzB = zzditVar.zzB();
        String string = "";
        if (TextUtils.isEmpty(strZzx)) {
            strZzx = strZzB != null ? strZzB : "";
        }
        zzbgp zzbgpVarZzm = zzditVar.zzm();
        if (zzbgpVarZzm != null) {
            try {
                string = zzbgpVarZzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbgp zzbgpVarZzn = zzditVar.zzn();
        Drawable drawable = null;
        if (zzbgpVarZzn != null) {
            try {
                IObjectWrapper iObjectWrapperZzf = zzbgpVarZzn.zzf();
                if (iObjectWrapperZzf != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzf);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzebo(strZzx, string, drawable));
    }

    public static /* synthetic */ void zzn(zzecl zzeclVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, DialogInterface dialogInterface) {
        zzeclVar.zze.zzc(zzeclVar.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", DYYbQc.uAzRCoiXF);
        zzeclVar.zzw(zzeclVar.zzf, "dialog_click", map);
        if (zzmVar != null) {
            zzmVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra != null) {
            String str = oKjScaD.zutHFCiBJ;
            if (stringExtra.equals(str) || stringExtra.equals("offline_notification_dismissed")) {
                String stringExtra2 = intent.getStringExtra("gws_query_id");
                String stringExtra3 = intent.getStringExtra("uri");
                Context context = this.zzb;
                boolean zZzA = com.google.android.gms.ads.internal.zzv.zza.zzi.zzA(context);
                HashMap map = new HashMap();
                char c = 2;
                if (stringExtra.equals(str)) {
                    map.put("offline_notification_action", str);
                    c = true == zZzA ? (char) 1 : (char) 2;
                    map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                    map.put(GsPcpBmONXh.PZuY, String.valueOf(stringExtra3.startsWith("http")));
                    try {
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                        if (launchIntentForPackage == null) {
                            launchIntentForPackage = new Intent("android.intent.action.VIEW");
                            launchIntentForPackage.setData(Uri.parse(stringExtra3));
                        }
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        map.put("olaa", "olas");
                    } catch (ActivityNotFoundException unused) {
                        map.put("olaa", "olaf");
                    }
                } else {
                    map.put("offline_notification_action", "offline_notification_dismissed");
                }
                zzw(stringExtra2, "offline_notification_action", map);
                try {
                    SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                    if (c == 1) {
                        this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                    } else {
                        zzeca.zzi(writableDatabase, stringExtra2);
                    }
                } catch (SQLiteException e) {
                    String strConcat = "Failed to get writable offline buffering database: ".concat(e.toString());
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(strConcat);
                }
            }
        }
    }
}
