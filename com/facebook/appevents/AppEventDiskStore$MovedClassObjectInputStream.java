package com.facebook.appevents;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AppEventDiskStore$MovedClassObjectInputStream extends ObjectInputStream {
    @Override // java.io.ObjectInputStream
    public final ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
        ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
        if (Intrinsics.areEqual(resultClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
            resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
        } else if (Intrinsics.areEqual(resultClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
            resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
        }
        Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
        return resultClassDescriptor;
    }
}
