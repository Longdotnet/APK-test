package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class NewInstanceSchemaLite implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).newMutableInstance();
    }
}
