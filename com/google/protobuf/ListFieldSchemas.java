package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ListFieldSchemas {
    private static final ListFieldSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final ListFieldSchema LITE_SCHEMA = new ListFieldSchemaLite();

    private ListFieldSchemas() {
    }

    public static ListFieldSchema full() {
        return FULL_SCHEMA;
    }

    public static ListFieldSchema lite() {
        return LITE_SCHEMA;
    }

    private static ListFieldSchema loadSchemaForFullRuntime() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            int i = ListFieldSchemaFull.$r8$clinit;
            return (ListFieldSchema) ListFieldSchemaFull.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
