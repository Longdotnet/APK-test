package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$ArrayIterator;
import androidx.collection.MapCollections$KeySet;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AvailabilityException extends Exception {
    public final ArrayMap zaa;

    public AvailabilityException(ArrayMap arrayMap) {
        this.zaa = arrayMap;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<O> apiKey = googleApi.getApiKey();
        ArrayMap arrayMap = this.zaa;
        Object orDefault = arrayMap.getOrDefault(apiKey, null);
        zzah.checkArgument(orDefault != null, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("The given API (", apiKey.zaa(), ") was not part of the availability request."));
        ConnectionResult connectionResult = (ConnectionResult) arrayMap.getOrDefault(apiKey, null);
        zzah.checkNotNull(connectionResult);
        return connectionResult;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = this.zaa;
        Iterator it = ((MapCollections$KeySet) arrayMap.keySet()).iterator();
        boolean z = true;
        while (true) {
            MapCollections$ArrayIterator mapCollections$ArrayIterator = (MapCollections$ArrayIterator) it;
            if (!mapCollections$ArrayIterator.hasNext()) {
                break;
            }
            ApiKey apiKey = (ApiKey) mapCollections$ArrayIterator.next();
            ConnectionResult connectionResult = (ConnectionResult) arrayMap.getOrDefault(apiKey, null);
            zzah.checkNotNull(connectionResult);
            z &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zaa() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<O> apiKey = hasApiKey.getApiKey();
        ArrayMap arrayMap = this.zaa;
        Object orDefault = arrayMap.getOrDefault(apiKey, null);
        zzah.checkArgument(orDefault != null, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("The given API (", apiKey.zaa(), ") was not part of the availability request."));
        ConnectionResult connectionResult = (ConnectionResult) arrayMap.getOrDefault(apiKey, null);
        zzah.checkNotNull(connectionResult);
        return connectionResult;
    }
}
