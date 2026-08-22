package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Data;
import androidx.work.InputMergerFactory$1;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class WorkManagerUtil extends zzayu implements zzbr {
    public WorkManagerUtil() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public static void zzb$1(Context context) {
        try {
            WorkManagerImpl.initialize(context.getApplicationContext(), new Configuration(new InputMergerFactory$1(20)));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            String string2 = parcel.readString();
            zzayv.zzd(parcel);
            boolean zZzf = zzf(iObjectWrapperAsInterface, string, string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZzf ? 1 : 0);
        } else if (i == 2) {
            IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zze(iObjectWrapperAsInterface2);
            parcel2.writeNoException();
        } else {
            if (i != 3) {
                return false;
            }
            IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
            zza zzaVar = (zza) zzayv.zza(parcel, zza.CREATOR);
            zzayv.zzd(parcel);
            boolean zZzg = zzg(iObjectWrapperAsInterface3, zzaVar);
            parcel2.writeNoException();
            parcel2.writeInt(zZzg ? 1 : 0);
        }
        return true;
    }

    @Override // com.google.android.gms.ads.internal.util.zzbr
    public final void zze(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb$1(context);
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            workManagerImpl.mWorkTaskExecutor.executeOnBackgroundThread(new CancelWorkRunnable.AnonymousClass2(workManagerImpl, 0));
            ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
            Constraints constraints = new Constraints();
            constraints.mRequiredNetworkType = 1;
            constraints.mTriggerContentUpdateDelay = -1L;
            constraints.mTriggerMaxContentDelay = -1L;
            constraints.mContentUriTriggers = new ContentUriTriggers();
            constraints.mRequiresCharging = false;
            int i = Build.VERSION.SDK_INT;
            constraints.mRequiresDeviceIdle = false;
            constraints.mRequiredNetworkType = 2;
            constraints.mRequiresBatteryNotLow = false;
            constraints.mRequiresStorageNotLow = false;
            if (i >= 24) {
                constraints.mContentUriTriggers = contentUriTriggers;
                constraints.mTriggerContentUpdateDelay = -1L;
                constraints.mTriggerMaxContentDelay = -1L;
            }
            com.google.firebase.auth.zzaa zzaaVar = new com.google.firebase.auth.zzaa(OfflinePingSender.class);
            ((WorkSpec) zzaaVar.zzb).constraints = constraints;
            ((HashSet) zzaaVar.zzc).add("offline_ping_sender_work");
            workManagerImpl.enqueue(zzaaVar.build());
        } catch (IllegalStateException e) {
            zzo.zzk("Failed to instantiate WorkManager.", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbr
    public final boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        return zzg(iObjectWrapper, new zza(str, str2, ""));
    }

    @Override // com.google.android.gms.ads.internal.util.zzbr
    public final boolean zzg(IObjectWrapper iObjectWrapper, zza zzaVar) throws Throwable {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb$1(context);
        ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
        Constraints constraints = new Constraints();
        constraints.mRequiredNetworkType = 1;
        constraints.mTriggerContentUpdateDelay = -1L;
        constraints.mTriggerMaxContentDelay = -1L;
        constraints.mContentUriTriggers = new ContentUriTriggers();
        constraints.mRequiresCharging = false;
        int i = Build.VERSION.SDK_INT;
        constraints.mRequiresDeviceIdle = false;
        constraints.mRequiredNetworkType = 2;
        constraints.mRequiresBatteryNotLow = false;
        constraints.mRequiresStorageNotLow = false;
        if (i >= 24) {
            constraints.mContentUriTriggers = contentUriTriggers;
            constraints.mTriggerContentUpdateDelay = -1L;
            constraints.mTriggerMaxContentDelay = -1L;
        }
        HashMap map = new HashMap();
        map.put("uri", zzaVar.zza);
        map.put("gws_query_id", zzaVar.zzb);
        map.put("image_url", zzaVar.zzc);
        Data data = new Data(map);
        Data.toByteArrayInternal(data);
        com.google.firebase.auth.zzaa zzaaVar = new com.google.firebase.auth.zzaa(OfflineNotificationPoster.class);
        WorkSpec workSpec = (WorkSpec) zzaaVar.zzb;
        workSpec.constraints = constraints;
        workSpec.input = data;
        ((HashSet) zzaaVar.zzc).add("offline_notification_work");
        try {
            WorkManagerImpl.getInstance(context).enqueue(zzaaVar.build());
            return true;
        } catch (IllegalStateException e) {
            zzo.zzk("Failed to instantiate WorkManager.", e);
            return false;
        }
    }
}
