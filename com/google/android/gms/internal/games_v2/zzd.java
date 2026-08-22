package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.Scope;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzd extends zze {
    public zzd() {
        super(null);
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final /* bridge */ /* synthetic */ List getImpliedScopes(Object obj) {
        return zzhd.zzj(new Scope("https://www.googleapis.com/auth/games"));
    }
}
