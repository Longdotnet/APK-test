package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((Message) obj).toBuilder().buildPartial();
    }
}
