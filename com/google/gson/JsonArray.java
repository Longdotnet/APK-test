package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonArray extends JsonElement implements Iterable {
    public final ArrayList elements = new ArrayList();

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements));
    }

    @Override // com.google.gson.JsonElement
    public final String getAsString() {
        ArrayList arrayList = this.elements;
        if (arrayList.size() == 1) {
            return ((JsonElement) arrayList.get(0)).getAsString();
        }
        throw new IllegalStateException();
    }

    public final int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.elements.iterator();
    }
}
