package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ClientSettings {
    public final Account zaa;
    public final Set zab;
    public final Set zac;
    public final Map zad;
    public final int zae;
    public final View zaf;
    public final String zag;
    public final String zah;
    public final SignInOptions zai;
    public Integer zaj;

    public final class Builder {
        public Account zaa;
        public ArraySet zab;
        public String zac;
        public String zad;
    }

    public ClientSettings(Account account, Set set, ArrayMap arrayMap, int i, View view, String str, String str2, SignInOptions signInOptions) {
        this.zaa = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zab = setEmptySet;
        Map mapEmptyMap = arrayMap == null ? Collections.emptyMap() : arrayMap;
        this.zad = mapEmptyMap;
        this.zaf = view;
        this.zae = i;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = mapEmptyMap.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((zab) it.next()).zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
