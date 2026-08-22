package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonObject extends JsonElement {
    public final LinkedTreeMap members = new LinkedTreeMap();

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public final int hashCode() {
        return this.members.hashCode();
    }
}
