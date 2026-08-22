package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class EventEntity extends zzg implements Event {
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final Uri zzd;
    public final String zze;
    public final PlayerEntity zzf;
    public final long zzg;
    public final String zzh;
    public final boolean zzi;

    public EventEntity(Event event) {
        this.zza = event.getEventId();
        this.zzb = event.getName();
        this.zzc = event.getDescription();
        this.zzd = event.getIconImageUri();
        this.zze = event.getIconImageUrl();
        this.zzf = (PlayerEntity) event.getPlayer().freeze();
        this.zzg = event.getValue();
        this.zzh = event.getFormattedValue();
        this.zzi = event.isVisible();
    }

    public static int zza(Event event) {
        return Arrays.hashCode(new Object[]{event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible())});
    }

    public static boolean zzb(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzah.equal(event2.getEventId(), event.getEventId()) && zzah.equal(event2.getName(), event.getName()) && zzah.equal(event2.getDescription(), event.getDescription()) && zzah.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzah.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzah.equal(event2.getPlayer(), event.getPlayer()) && zzah.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzah.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzah.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    public static String zzc(Event event) {
        zzz zzzVar = new zzz(event);
        zzzVar.add(event.getEventId(), "Id");
        zzzVar.add(event.getName(), "Name");
        zzzVar.add(event.getDescription(), "Description");
        zzzVar.add(event.getIconImageUri(), "IconImageUri");
        zzzVar.add(event.getIconImageUrl(), "IconImageUrl");
        zzzVar.add(event.getPlayer(), "Player");
        zzzVar.add(Long.valueOf(event.getValue()), "Value");
        zzzVar.add(event.getFormattedValue(), "FormattedValue");
        zzzVar.add(Boolean.valueOf(event.isVisible()), "isVisible");
        return zzzVar.toString();
    }

    public boolean equals(Object obj) {
        return zzb(this, obj);
    }

    @Override // com.google.android.gms.games.event.Event
    public Event freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getDescription() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getEventId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getFormattedValue() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.event.Event
    public Uri getIconImageUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getIconImageUrl() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.event.Event
    public String getName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.event.Event
    public Player getPlayer() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.event.Event
    public long getValue() {
        return this.zzg;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.event.Event
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.event.Event
    public boolean isVisible() {
        return this.zzi;
    }

    public String toString() {
        return zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getEventId(), false);
        CloseableKt.writeString(parcel, 2, getName(), false);
        CloseableKt.writeString(parcel, 3, getDescription(), false);
        CloseableKt.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        CloseableKt.writeString(parcel, 5, getIconImageUrl(), false);
        CloseableKt.writeParcelable(parcel, 6, getPlayer(), i, false);
        long value = getValue();
        CloseableKt.zzc(parcel, 7, 8);
        parcel.writeLong(value);
        CloseableKt.writeString(parcel, 8, getFormattedValue(), false);
        boolean zIsVisible = isVisible();
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(zIsVisible ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.event.Event
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzh, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public void getName(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    public EventEntity(String str, String str2, String str3, Uri uri, String str4, PlayerEntity playerEntity, long j, String str5, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = uri;
        this.zze = str4;
        this.zzf = new PlayerEntity(playerEntity);
        this.zzg = j;
        this.zzh = str5;
        this.zzi = z;
    }
}
