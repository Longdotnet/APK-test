package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public interface BlockingService {
    Message callBlockingMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor methodDescriptor);

    Message getResponsePrototype(Descriptors.MethodDescriptor methodDescriptor);
}
