package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ProfileCache;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    public final List zza = new ArrayList();
    public final zzag zzb;
    public final String zzc;
    public final com.google.firebase.auth.zze zzd;
    public final zzx zze;

    public zzae(List list, zzag zzagVar, String str, com.google.firebase.auth.zze zzeVar, zzx zzxVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                this.zza.add((PhoneMultiFactorInfo) multiFactorInfo);
            }
        }
        com.google.android.gms.common.internal.zzah.checkNotNull(zzagVar);
        this.zzb = zzagVar;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zzc = str;
        this.zzd = zzeVar;
        this.zze = zzxVar;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add((PhoneMultiFactorInfo) it.next());
        }
        return arrayList;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final Task resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        Task taskZzh = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzh(multiFactorAssertion, this.zzb, this.zze);
        ProfileCache profileCache = new ProfileCache(this, 29);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) taskZzh;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, profileCache);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 1, this.zza, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i, false);
        CloseableKt.writeParcelable(parcel, 5, this.zze, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
