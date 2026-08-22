package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zaa implements Comparator {
    public static final /* synthetic */ zaa zaa = new zaa(0);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zaa(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
    }
}
