package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    public zzzy zza;
    public zzt zzb;
    public final String zzc;
    public String zzd;
    public List zze;
    public List zzf;
    public String zzg;
    public Boolean zzh;
    public zzz zzi;
    public boolean zzj;
    public com.google.firebase.auth.zze zzk;
    public zzbb zzl;

    public zzx(FirebaseApp firebaseApp, List list) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zzc(list);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzxVar = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzxVar2 = (zzx) firebaseUser;
            zzxVar.zzg = zzxVar2.zzg;
            zzxVar.zzd = zzxVar2.zzd;
            zzxVar.zzi = zzxVar2.zzi;
        } else {
            zzxVar.zzi = null;
        }
        if (firebaseUser.zzd() != null) {
            zzxVar.zzh(firebaseUser.zzd());
        }
        if (!firebaseUser.isAnonymous()) {
            zzxVar.zzm();
        }
        return zzxVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getTenantId() {
        Map map;
        zzzy zzzyVar = this.zza;
        if (zzzyVar == null || zzzyVar.zze() == null || (map = (Map) zzay.zza(zzzyVar.zze()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zzb.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isAnonymous() {
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzzy zzzyVar = this.zza;
            String signInProvider = zzzyVar != null ? zzay.zza(zzzyVar.zze()).getSignInProvider() : "";
            boolean z = false;
            if (this.zze.size() <= 1 && (signInProvider == null || !signInProvider.equals("custom"))) {
                z = true;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeTypedList(parcel, 5, this.zze, false);
        CloseableKt.writeStringList(parcel, 6, this.zzf);
        CloseableKt.writeString(parcel, 7, this.zzg, false);
        CloseableKt.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()));
        CloseableKt.writeParcelable(parcel, 9, this.zzi, i, false);
        boolean z = this.zzj;
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeParcelable(parcel, 11, this.zzk, i, false);
        CloseableKt.writeParcelable(parcel, 12, this.zzl, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ FirebaseUser zzb() {
        zzm();
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final synchronized FirebaseUser zzc(List list) {
        try {
            com.google.android.gms.common.internal.zzah.checkNotNull(list);
            this.zze = new ArrayList(list.size());
            this.zzf = new ArrayList(list.size());
            for (int i = 0; i < list.size(); i++) {
                UserInfo userInfo = (UserInfo) list.get(i);
                if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                    this.zzb = (zzt) userInfo;
                } else {
                    this.zzf.add(userInfo.getProviderId());
                }
                this.zze.add((zzt) userInfo);
            }
            if (this.zzb == null) {
                this.zzb = (zzt) this.zze.get(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzzy zzd() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zze() {
        return this.zza.zze();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzf() {
        return this.zza.zzh();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List zzg() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzh(zzzy zzzyVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzzyVar);
        this.zza = zzzyVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzi(List list) {
        Parcelable.Creator<zzbb> creator = zzbb.CREATOR;
        zzbb zzbbVar = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbbVar = new zzbb(arrayList);
        }
        this.zzl = zzbbVar;
    }

    public final com.google.firebase.auth.zze zzj() {
        return this.zzk;
    }

    public final zzx zzl(String str) {
        this.zzg = str;
        return this;
    }

    public final zzx zzm() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    public final List zzn() {
        zzbb zzbbVar = this.zzl;
        return zzbbVar != null ? zzbbVar.zza() : new ArrayList();
    }

    public final List zzo() {
        return this.zze;
    }

    public final void zzp(com.google.firebase.auth.zze zzeVar) {
        this.zzk = zzeVar;
    }

    public final void zzq(boolean z) {
        this.zzj = z;
    }

    public final void zzr(zzz zzzVar) {
        this.zzi = zzzVar;
    }

    public final boolean zzs() {
        return this.zzj;
    }

    public zzx(zzzy zzzyVar, zzt zztVar, String str, String str2, List list, List list2, String str3, Boolean bool, zzz zzzVar, boolean z, com.google.firebase.auth.zze zzeVar, zzbb zzbbVar) {
        this.zza = zzzyVar;
        this.zzb = zztVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzzVar;
        this.zzj = z;
        this.zzk = zzeVar;
        this.zzl = zzbbVar;
    }
}
