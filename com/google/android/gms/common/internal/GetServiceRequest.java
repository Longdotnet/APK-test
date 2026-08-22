package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes2.dex */
public final class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new com.google.android.gms.drive.zza(11);
    public static final Scope[] zza = new Scope[0];
    public static final Feature[] zzb = new Feature[0];
    public final int zzc;
    public final int zzd;
    public final int zze;
    public String zzf;
    public IBinder zzg;
    public Scope[] zzh;
    public Bundle zzi;
    public Account zzj;
    public Feature[] zzk;
    public Feature[] zzl;
    public final boolean zzm;
    public final int zzn;
    public boolean zzo;
    public final String zzp;

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4, boolean z2, String str2) {
        Account account2;
        Scope[] scopeArr2 = scopeArr == null ? zza : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = zzb;
        Feature[] featureArr4 = featureArr == null ? featureArr3 : featureArr;
        featureArr3 = featureArr2 != null ? featureArr2 : featureArr3;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzf = "com.google.android.gms";
        } else {
            this.zzf = str;
        }
        if (i < 2) {
            account2 = null;
            if (iBinder != null) {
                int i5 = AccountAccessor.$r8$clinit;
                String str3 = oKjScaD.fHwIoFiVRUsKXZk;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str3);
                IInterface zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new zzw(iBinder, str3);
                if (zzwVar != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            zzw zzwVar2 = (zzw) zzwVar;
                            Parcel parcelZzB = zzwVar2.zzB(2, zzwVar2.zza());
                            Account account3 = (Account) zzc.zza(parcelZzB, Account.CREATOR);
                            parcelZzB.recycle();
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                            account2 = account3;
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
        } else {
            this.zzg = iBinder;
            account2 = account;
        }
        this.zzj = account2;
        this.zzh = scopeArr2;
        this.zzi = bundle2;
        this.zzk = featureArr4;
        this.zzl = featureArr3;
        this.zzm = z;
        this.zzn = i4;
        this.zzo = z2;
        this.zzp = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.drive.zza.zza(this, parcel, i);
    }
}
