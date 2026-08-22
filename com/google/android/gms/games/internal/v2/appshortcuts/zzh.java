package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.pm.ShortcutInfo;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = Protocol.Companion.validateObjectHeader(parcel);
        ArrayList arrayListCreateStringList = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList arrayListCreateStringList2 = null;
        ArrayList arrayListCreateStringList3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListCreateStringList = Protocol.Companion.createStringList(parcel, i);
            } else if (c == 2) {
                arrayListCreateTypedList = Protocol.Companion.createTypedList(parcel, i, ShortcutInfo.CREATOR);
            } else if (c == 3) {
                arrayListCreateStringList2 = Protocol.Companion.createStringList(parcel, i);
            } else if (c != 4) {
                Protocol.Companion.skipUnknownField(parcel, i);
            } else {
                arrayListCreateStringList3 = Protocol.Companion.createStringList(parcel, i);
            }
        }
        Protocol.Companion.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzg(arrayListCreateStringList, arrayListCreateTypedList, arrayListCreateStringList2, arrayListCreateStringList3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzg[i];
    }
}
