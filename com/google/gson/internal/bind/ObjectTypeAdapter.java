package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectTypeAdapter extends TypeAdapter {
    public static final TypeAdapters.AnonymousClass28 DOUBLE_FACTORY = new TypeAdapters.AnonymousClass28(3);
    public final Gson gson;

    public ObjectTypeAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Class<?> cls = obj.getClass();
        Gson gson = this.gson;
        gson.getClass();
        TypeAdapter adapter = gson.getAdapter(new TypeToken(cls));
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(jsonWriter, obj);
        } else {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        }
    }
}
