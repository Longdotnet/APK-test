package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class MostRecentGameInfoEntity extends com.google.android.gms.games.internal.zzg implements zza {
    public static final Parcelable.Creator<MostRecentGameInfoEntity> CREATOR = new zzb();
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Uri zzd;
    public final Uri zze;
    public final Uri zzf;

    public MostRecentGameInfoEntity(zza zzaVar) {
        this.zza = zzaVar.zza();
        this.zzb = zzaVar.zzb();
        this.zzc = zzaVar.zzc();
        this.zzd = zzaVar.zzd();
        this.zze = zzaVar.zze();
        this.zzf = zzaVar.zzf();
    }

    public static boolean zzh(zza zzaVar, Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (zzaVar == obj) {
            return true;
        }
        zza zzaVar2 = (zza) obj;
        return zzah.equal(zzaVar2.zza(), zzaVar.zza()) && zzah.equal(zzaVar2.zzb(), zzaVar.zzb()) && zzah.equal(Long.valueOf(zzaVar2.zzc()), Long.valueOf(zzaVar.zzc())) && zzah.equal(zzaVar2.zzd(), zzaVar.zzd()) && zzah.equal(zzaVar2.zze(), zzaVar.zze()) && zzah.equal(zzaVar2.zzf(), zzaVar.zzf());
    }

    public static String zzi(zza zzaVar) {
        zzz zzzVar = new zzz(zzaVar);
        zzzVar.add(zzaVar.zza(), "GameId");
        zzzVar.add(zzaVar.zzb(), "GameName");
        zzzVar.add(Long.valueOf(zzaVar.zzc()), "ActivityTimestampMillis");
        zzzVar.add(zzaVar.zzd(), "GameIconUri");
        zzzVar.add(zzaVar.zze(), "GameHiResUri");
        zzzVar.add(zzaVar.zzf(), "GameFeaturedUri");
        return zzzVar.toString();
    }

    public final boolean equals(Object obj) {
        return zzh(this, obj);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zza(), zzb(), Long.valueOf(zzc()), zzd(), zze(), zzf()});
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzi(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzf() {
        return this.zzf;
    }

    public MostRecentGameInfoEntity(String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = uri;
        this.zze = uri2;
        this.zzf = uri3;
    }
}
