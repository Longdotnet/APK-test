package com.facebook.internal.gatekeeper;

import com.google.gson.yWTz.kBfGXgdfpo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class GateKeeper {
    public final String name;
    public final boolean value;

    public GateKeeper(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.value = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GateKeeper)) {
            return false;
        }
        GateKeeper gateKeeper = (GateKeeper) obj;
        return Intrinsics.areEqual(this.name, gateKeeper.name) && this.value == gateKeeper.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        boolean z = this.value;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final String toString() {
        return "GateKeeper(name=" + this.name + kBfGXgdfpo.KXFXTHpZ + this.value + ')';
    }
}
