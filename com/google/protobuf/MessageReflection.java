package com.google.protobuf;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
class MessageReflection {

    /* JADX INFO: renamed from: com.google.protobuf.MessageReflection$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class BuilderAdapter implements MergeTarget {
        private final Message.Builder builder;
        private boolean hasNestedBuilders = true;

        public BuilderAdapter(Message.Builder builder) {
            this.builder = builder;
        }

        private Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!this.hasNestedBuilders) {
                return null;
            }
            try {
                return this.builder.getFieldBuilder(fieldDescriptor);
            } catch (UnsupportedOperationException unused) {
                this.hasNestedBuilders = false;
                return null;
            }
        }

        private Message.Builder newMessageFieldInstance(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            return message != null ? message.newBuilderForType() : this.builder.newBuilderForField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (obj instanceof MessageLite.Builder) {
                obj = ((MessageLite.Builder) obj).buildPartial();
            }
            this.builder.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            this.builder.clearField(fieldDescriptor);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            this.builder.clearOneof(oneofDescriptor);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str) {
            return extensionRegistry.findImmutableExtensionByName(str);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i) {
            return extensionRegistry.findImmutableExtensionByNumber(descriptor, i);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            return this.builder;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            return this.builder.getDescriptorForType();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.builder.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            return this.builder.getOneofFieldDescriptor(oneofDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return (fieldDescriptor.isRepeated() || !(this.builder instanceof GeneratedMessage.Builder)) ? WireFormat.Utf8Validation.LOOSE : WireFormat.Utf8Validation.LAZY;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.builder.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return this.builder.hasOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message.Builder builderNewMessageFieldInstance;
            if (fieldDescriptor.isRepeated()) {
                Message.Builder builderNewMessageFieldInstance2 = newMessageFieldInstance(fieldDescriptor, message);
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewMessageFieldInstance2, extensionRegistryLite);
                addRepeatedField(fieldDescriptor, builderNewMessageFieldInstance2.buildPartial());
                return;
            }
            if (hasField(fieldDescriptor)) {
                Message.Builder fieldBuilder = getFieldBuilder(fieldDescriptor);
                if (fieldBuilder != null) {
                    codedInputStream.readGroup(fieldDescriptor.getNumber(), fieldBuilder, extensionRegistryLite);
                    return;
                } else {
                    builderNewMessageFieldInstance = newMessageFieldInstance(fieldDescriptor, message);
                    builderNewMessageFieldInstance.mergeFrom((Message) getField(fieldDescriptor));
                }
            } else {
                builderNewMessageFieldInstance = newMessageFieldInstance(fieldDescriptor, message);
            }
            codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewMessageFieldInstance, extensionRegistryLite);
            setField(fieldDescriptor, builderNewMessageFieldInstance.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message.Builder builderNewMessageFieldInstance;
            if (fieldDescriptor.isRepeated()) {
                Message.Builder builderNewMessageFieldInstance2 = newMessageFieldInstance(fieldDescriptor, message);
                codedInputStream.readMessage(builderNewMessageFieldInstance2, extensionRegistryLite);
                addRepeatedField(fieldDescriptor, builderNewMessageFieldInstance2.buildPartial());
                return;
            }
            if (hasField(fieldDescriptor)) {
                Message.Builder fieldBuilder = getFieldBuilder(fieldDescriptor);
                if (fieldBuilder != null) {
                    codedInputStream.readMessage(fieldBuilder, extensionRegistryLite);
                    return;
                } else {
                    builderNewMessageFieldInstance = newMessageFieldInstance(fieldDescriptor, message);
                    builderNewMessageFieldInstance.mergeFrom((Message) getField(fieldDescriptor));
                }
            } else {
                builderNewMessageFieldInstance = newMessageFieldInstance(fieldDescriptor, message);
            }
            codedInputStream.readMessage(builderNewMessageFieldInstance, extensionRegistryLite);
            setField(fieldDescriptor, builderNewMessageFieldInstance.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            return new BuilderAdapter(message != null ? message.newBuilderForType() : this.builder.newBuilderForField(fieldDescriptor));
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder fieldBuilder;
            if (!fieldDescriptor.isRepeated() && hasField(fieldDescriptor) && (fieldBuilder = getFieldBuilder(fieldDescriptor)) != null) {
                return new BuilderAdapter(fieldBuilder);
            }
            Message.Builder builderNewMessageFieldInstance = newMessageFieldInstance(fieldDescriptor, message);
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewMessageFieldInstance.mergeFrom(message2);
            }
            return new BuilderAdapter(builderNewMessageFieldInstance);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message != null ? message.newBuilderForType() : this.builder.newBuilderForField(fieldDescriptor);
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message != null ? message.newBuilderForType() : this.builder.newBuilderForField(fieldDescriptor);
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readMessage(builderNewBuilderForType, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message != null ? message.newBuilderForType() : this.builder.newBuilderForField(fieldDescriptor);
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            builderNewBuilderForType.mergeFrom(byteString, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.isRepeated() || !(obj instanceof MessageLite.Builder)) {
                this.builder.setField(fieldDescriptor, obj);
                return this;
            }
            if (obj != getFieldBuilder(fieldDescriptor)) {
                this.builder.setField(fieldDescriptor, ((MessageLite.Builder) obj).buildPartial());
            }
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            if (obj instanceof MessageLite.Builder) {
                obj = ((MessageLite.Builder) obj).buildPartial();
            }
            this.builder.setRepeatedField(fieldDescriptor, i, obj);
            return this;
        }
    }

    public static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        public ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> fieldSet) {
            this.extensions = fieldSet;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.extensions.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            this.extensions.clearField(fieldDescriptor);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str) {
            return extensionRegistry.findImmutableExtensionByName(str);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i) {
            return extensionRegistry.findImmutableExtensionByNumber(descriptor, i);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.extensions.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor) {
            return fieldDescriptor.needsUtf8Check() ? WireFormat.Utf8Validation.STRICT : WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.extensions.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            if (fieldDescriptor.isRepeated()) {
                Message.Builder builderNewBuilderForType = message.newBuilderForType();
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType, extensionRegistryLite);
                addRepeatedField(fieldDescriptor, builderNewBuilderForType.buildPartial());
            } else if (hasField(fieldDescriptor)) {
                MessageLite.Builder builder = ((MessageLite) getField(fieldDescriptor)).toBuilder();
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builder, extensionRegistryLite);
                setField(fieldDescriptor, builder.buildPartial());
            } else {
                Message.Builder builderNewBuilderForType2 = message.newBuilderForType();
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType2, extensionRegistryLite);
                setField(fieldDescriptor, builderNewBuilderForType2.buildPartial());
            }
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            if (fieldDescriptor.isRepeated()) {
                Message.Builder builderNewBuilderForType = message.newBuilderForType();
                codedInputStream.readMessage(builderNewBuilderForType, extensionRegistryLite);
                addRepeatedField(fieldDescriptor, builderNewBuilderForType.buildPartial());
            } else if (hasField(fieldDescriptor)) {
                MessageLite.Builder builder = ((MessageLite) getField(fieldDescriptor)).toBuilder();
                codedInputStream.readMessage(builder, extensionRegistryLite);
                setField(fieldDescriptor, builder.buildPartial());
            } else {
                Message.Builder builderNewBuilderForType2 = message.newBuilderForType();
                codedInputStream.readMessage(builderNewBuilderForType2, extensionRegistryLite);
                setField(fieldDescriptor, builderNewBuilderForType2.buildPartial());
            }
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readMessage(builderNewBuilderForType, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            builderNewBuilderForType.mergeFrom(byteString, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.extensions.setField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            this.extensions.setRepeatedField(fieldDescriptor, i, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException(YcVWhnLsj.uPUkRDXsxkUIiAR);
        }
    }

    public static class ExtensionBuilderAdapter implements MergeTarget {
        private final FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        public ExtensionBuilderAdapter(FieldSet.Builder<Descriptors.FieldDescriptor> builder) {
            this.extensions = builder;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.extensions.addRepeatedField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            this.extensions.clearField(fieldDescriptor);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str) {
            return extensionRegistry.findImmutableExtensionByName(str);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i) {
            return extensionRegistry.findImmutableExtensionByNumber(descriptor, i);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.extensions.getField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor) {
            return fieldDescriptor.needsUtf8Check() ? WireFormat.Utf8Validation.STRICT : WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.extensions.hasField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return false;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            MessageLite.Builder builder;
            if (fieldDescriptor.isRepeated()) {
                Message.Builder builderNewBuilderForType = message.newBuilderForType();
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType, extensionRegistryLite);
                addRepeatedField(fieldDescriptor, builderNewBuilderForType.buildPartial());
            } else if (!hasField(fieldDescriptor)) {
                Message.Builder builderNewBuilderForType2 = message.newBuilderForType();
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType2, extensionRegistryLite);
                setField(fieldDescriptor, builderNewBuilderForType2);
            } else {
                Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(fieldDescriptor);
                if (fieldAllowBuilders instanceof MessageLite.Builder) {
                    builder = (MessageLite.Builder) fieldAllowBuilders;
                } else {
                    builder = ((MessageLite) fieldAllowBuilders).toBuilder();
                    this.extensions.setField(fieldDescriptor, builder);
                }
                codedInputStream.readGroup(fieldDescriptor.getNumber(), builder, extensionRegistryLite);
            }
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            MessageLite.Builder builder;
            if (fieldDescriptor.isRepeated()) {
                Message.Builder builderNewBuilderForType = message.newBuilderForType();
                codedInputStream.readMessage(builderNewBuilderForType, extensionRegistryLite);
                addRepeatedField(fieldDescriptor, builderNewBuilderForType.buildPartial());
            } else if (!hasField(fieldDescriptor)) {
                Message.Builder builderNewBuilderForType2 = message.newBuilderForType();
                codedInputStream.readMessage(builderNewBuilderForType2, extensionRegistryLite);
                setField(fieldDescriptor, builderNewBuilderForType2);
            } else {
                Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(fieldDescriptor);
                if (fieldAllowBuilders instanceof MessageLite.Builder) {
                    builder = (MessageLite.Builder) fieldAllowBuilders;
                } else {
                    builder = ((MessageLite) fieldAllowBuilders).toBuilder();
                    this.extensions.setField(fieldDescriptor, builder);
                }
                codedInputStream.readMessage(builder, extensionRegistryLite);
            }
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readGroup(fieldDescriptor.getNumber(), builderNewBuilderForType, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            codedInputStream.readMessage(builderNewBuilderForType, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) {
            Message message2;
            Message.Builder builderNewBuilderForType = message.newBuilderForType();
            if (!fieldDescriptor.isRepeated() && (message2 = (Message) getField(fieldDescriptor)) != null) {
                builderNewBuilderForType.mergeFrom(message2);
            }
            builderNewBuilderForType.mergeFrom(byteString, extensionRegistryLite);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.extensions.setField(fieldDescriptor, obj);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            this.extensions.setRepeatedField(fieldDescriptor, i, obj);
            return this;
        }
    }

    public interface MergeTarget {

        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        MergeTarget clearField(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget clearOneof(Descriptors.OneofDescriptor oneofDescriptor);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry extensionRegistry, String str);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor fieldDescriptor);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneofDescriptor);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);

        boolean hasOneof(Descriptors.OneofDescriptor oneofDescriptor);

        void mergeGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message);

        void mergeMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message);

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor fieldDescriptor, Message message);

        Object parseGroup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message);

        Object parseMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message);

        Object parseMessageFromBytes(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message);

        MergeTarget setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj);
    }

    public static String delimitWithCommas(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, ExtensionRegistry.ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, MergeTarget mergeTarget) {
        Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
        mergeTarget.setField(fieldDescriptor, mergeTarget.parseMessage(codedInputStream, extensionRegistryLite, fieldDescriptor, extensionInfo.defaultInstance));
    }

    private static void findMissingFields(MessageOrBuilder messageOrBuilder, String str, List<String> list) {
        for (Descriptors.FieldDescriptor fieldDescriptor : messageOrBuilder.getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !messageOrBuilder.hasField(fieldDescriptor)) {
                list.add(str + fieldDescriptor.getName());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : messageOrBuilder.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (key.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) value).iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        findMissingFields((MessageOrBuilder) it.next(), subMessagePrefix(str, key, i), list);
                        i++;
                    }
                } else if (messageOrBuilder.hasField(key)) {
                    findMissingFields((MessageOrBuilder) value, subMessagePrefix(str, key, -1), list);
                }
            }
        }
    }

    public static int getSerializedSize(Message message, Map<Descriptors.FieldDescriptor, Object> map) {
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        int iComputeMessageSetExtensionSize = 0;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            iComputeMessageSetExtensionSize = (messageSetWireFormat && key.isExtension() && key.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) ? CodedOutputStream.computeMessageSetExtensionSize(key.getNumber(), (Message) value) + iComputeMessageSetExtensionSize : iComputeMessageSetExtensionSize + FieldSet.computeFieldSize(key, value);
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        return (messageSetWireFormat ? unknownFields.getSerializedSizeAsMessageSet() : unknownFields.getSerializedSize()) + iComputeMessageSetExtensionSize;
    }

    public static boolean isInitialized(MessageOrBuilder messageOrBuilder) {
        for (Descriptors.FieldDescriptor fieldDescriptor : messageOrBuilder.getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !messageOrBuilder.hasField(fieldDescriptor)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : messageOrBuilder.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            if (key.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x006b  */
    public static boolean mergeFieldFrom(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, Descriptors.Descriptor descriptor, MergeTarget mergeTarget, int i) {
        Message message;
        boolean z;
        Object objFindValueByNumberCreatingIfUnknown;
        ExtensionRegistry.ExtensionInfo extensionInfoFindExtensionByNumber;
        if (descriptor.getOptions().getMessageSetWireFormat() && i == WireFormat.MESSAGE_SET_ITEM_TAG) {
            mergeMessageSetExtensionFromCodedStream(codedInputStream, builder, extensionRegistryLite, descriptor, mergeTarget);
            return true;
        }
        int tagWireType = WireFormat.getTagWireType(i);
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = null;
        if (descriptor.isExtensionNumber(tagFieldNumber)) {
            if (!(extensionRegistryLite instanceof ExtensionRegistry) || (extensionInfoFindExtensionByNumber = mergeTarget.findExtensionByNumber((ExtensionRegistry) extensionRegistryLite, descriptor, tagFieldNumber)) == null) {
                message = null;
            } else {
                fieldDescriptorFindFieldByNumber = extensionInfoFindExtensionByNumber.descriptor;
                message = extensionInfoFindExtensionByNumber.defaultInstance;
                if (message == null && fieldDescriptorFindFieldByNumber.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new IllegalStateException("Message-typed extension lacked default instance: " + fieldDescriptorFindFieldByNumber.getFullName());
                }
            }
        } else if (mergeTarget.getContainerType() == MergeTarget.ContainerType.MESSAGE) {
            fieldDescriptorFindFieldByNumber = descriptor.findFieldByNumber(tagFieldNumber);
            message = null;
        } else {
            message = null;
        }
        boolean z2 = false;
        if (fieldDescriptorFindFieldByNumber == null) {
            z = false;
            z2 = true;
        } else if (tagWireType == FieldSet.getWireFormatForFieldType(fieldDescriptorFindFieldByNumber.getLiteType(), false)) {
            z = false;
        } else if (fieldDescriptorFindFieldByNumber.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(fieldDescriptorFindFieldByNumber.getLiteType(), true)) {
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (z2) {
            return builder != null ? builder.mergeFieldFrom(i, codedInputStream) : codedInputStream.skipField(i);
        }
        if (z) {
            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
            if (fieldDescriptorFindFieldByNumber.getLiteType() == WireFormat.FieldType.ENUM) {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    int i2 = codedInputStream.readEnum();
                    if (fieldDescriptorFindFieldByNumber.legacyEnumFieldTreatedAsClosed()) {
                        Descriptors.EnumValueDescriptor enumValueDescriptorFindValueByNumber = fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumber(i2);
                        if (enumValueDescriptorFindValueByNumber != null) {
                            mergeTarget.addRepeatedField(fieldDescriptorFindFieldByNumber, enumValueDescriptorFindValueByNumber);
                        } else if (builder != null) {
                            builder.mergeVarintField(tagFieldNumber, i2);
                        }
                    } else {
                        mergeTarget.addRepeatedField(fieldDescriptorFindFieldByNumber, fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumberCreatingIfUnknown(i2));
                    }
                }
            } else {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    mergeTarget.addRepeatedField(fieldDescriptorFindFieldByNumber, WireFormat.readPrimitiveField(codedInputStream, fieldDescriptorFindFieldByNumber.getLiteType(), mergeTarget.getUtf8Validation(fieldDescriptorFindFieldByNumber)));
                }
            }
            codedInputStream.popLimit(iPushLimit);
        } else {
            int i3 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptorFindFieldByNumber.getType().ordinal()];
            if (i3 == 1) {
                mergeTarget.mergeGroup(codedInputStream, extensionRegistryLite, fieldDescriptorFindFieldByNumber, message);
                return true;
            }
            if (i3 == 2) {
                mergeTarget.mergeMessage(codedInputStream, extensionRegistryLite, fieldDescriptorFindFieldByNumber, message);
                return true;
            }
            if (i3 != 3) {
                objFindValueByNumberCreatingIfUnknown = WireFormat.readPrimitiveField(codedInputStream, fieldDescriptorFindFieldByNumber.getLiteType(), mergeTarget.getUtf8Validation(fieldDescriptorFindFieldByNumber));
            } else {
                int i4 = codedInputStream.readEnum();
                if (fieldDescriptorFindFieldByNumber.legacyEnumFieldTreatedAsClosed()) {
                    Descriptors.EnumValueDescriptor enumValueDescriptorFindValueByNumber2 = fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumber(i4);
                    if (enumValueDescriptorFindValueByNumber2 == null) {
                        if (builder != null) {
                            builder.mergeVarintField(tagFieldNumber, i4);
                        }
                        return true;
                    }
                    objFindValueByNumberCreatingIfUnknown = enumValueDescriptorFindValueByNumber2;
                } else {
                    objFindValueByNumberCreatingIfUnknown = fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumberCreatingIfUnknown(i4);
                }
            }
            if (fieldDescriptorFindFieldByNumber.isRepeated()) {
                mergeTarget.addRepeatedField(fieldDescriptorFindFieldByNumber, objFindValueByNumberCreatingIfUnknown);
            } else {
                mergeTarget.setField(fieldDescriptorFindFieldByNumber, objFindValueByNumberCreatingIfUnknown);
            }
        }
        return true;
    }

    public static void mergeMessageFrom(Message.Builder builder, UnknownFieldSet.Builder builder2, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        int tag;
        BuilderAdapter builderAdapter = new BuilderAdapter(builder);
        Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
        do {
            tag = codedInputStream.readTag();
            if (tag == 0) {
                return;
            }
        } while (mergeFieldFrom(codedInputStream, builder2, extensionRegistryLite, descriptorForType, builderAdapter, tag));
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistry.ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, MergeTarget mergeTarget) {
        Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
        if (mergeTarget.hasField(fieldDescriptor) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            mergeTarget.setField(fieldDescriptor, mergeTarget.parseMessageFromBytes(byteString, extensionRegistryLite, fieldDescriptor, extensionInfo.defaultInstance));
        } else {
            mergeTarget.setField(fieldDescriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString));
        }
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, Descriptors.Descriptor descriptor, MergeTarget mergeTarget) {
        int uInt32 = 0;
        ByteString bytes = null;
        ExtensionRegistry.ExtensionInfo extensionInfoFindExtensionByNumber = null;
        while (true) {
            int tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = codedInputStream.readUInt32();
                if (uInt32 != 0 && (extensionRegistryLite instanceof ExtensionRegistry)) {
                    extensionInfoFindExtensionByNumber = mergeTarget.findExtensionByNumber((ExtensionRegistry) extensionRegistryLite, descriptor, uInt32);
                }
            } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (uInt32 == 0 || extensionInfoFindExtensionByNumber == null || !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    bytes = codedInputStream.readBytes();
                } else {
                    eagerlyMergeMessageSetExtension(codedInputStream, extensionInfoFindExtensionByNumber, extensionRegistryLite, mergeTarget);
                    bytes = null;
                }
            } else if (!codedInputStream.skipField(tag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (bytes == null || uInt32 == 0) {
            return;
        }
        if (extensionInfoFindExtensionByNumber != null) {
            mergeMessageSetExtensionFromBytes(bytes, extensionInfoFindExtensionByNumber, extensionRegistryLite, mergeTarget);
        } else if (builder != null) {
            builder.mergeField(uInt32, UnknownFieldSet.Field.newBuilder().addLengthDelimited(bytes).build());
        }
    }

    private static String subMessagePrefix(String str, Descriptors.FieldDescriptor fieldDescriptor, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (fieldDescriptor.isExtension()) {
            sb.append('(');
            sb.append(fieldDescriptor.getFullName());
            sb.append(')');
        } else {
            sb.append(fieldDescriptor.getName());
        }
        if (i != -1) {
            sb.append('[');
            sb.append(i);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    public static void writeMessageTo(Message message, Map<Descriptors.FieldDescriptor, Object> map, CodedOutputStream codedOutputStream, boolean z) {
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (z) {
            TreeMap treeMap = new TreeMap(map);
            for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
                if (fieldDescriptor.isRequired() && !treeMap.containsKey(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, message.getField(fieldDescriptor));
                }
            }
            map = treeMap;
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.isExtension() && key.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                codedOutputStream.writeMessageSetExtension(key.getNumber(), (Message) value);
            } else {
                FieldSet.writeField(key, value, codedOutputStream);
            }
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.writeAsMessageSetTo(codedOutputStream);
        } else {
            unknownFields.writeTo(codedOutputStream);
        }
    }

    public static List<String> findMissingFields(MessageOrBuilder messageOrBuilder) {
        ArrayList arrayList = new ArrayList();
        findMissingFields(messageOrBuilder, "", arrayList);
        return arrayList;
    }
}
