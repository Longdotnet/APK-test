package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class GeneratedMessageV3 extends GeneratedMessage.ExtendableMessage<GeneratedMessageV3> {
    private static final long serialVersionUID = 1;

    @Deprecated
    public static abstract class Builder<BuilderT extends Builder<BuilderT>> extends GeneratedMessage.ExtendableBuilder<GeneratedMessageV3, BuilderT> {
        private Builder<BuilderT>.BuilderParentImpl meAsParent;

        @Deprecated
        public class BuilderParentImpl implements BuilderParent {
            private BuilderParentImpl() {
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                Builder.this.onChanged();
            }
        }

        @Deprecated
        public Builder() {
            super(null);
        }

        @Deprecated
        public Builder(BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        @Deprecated
        public BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new BuilderParentImpl();
            }
            return this.meAsParent;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        @Deprecated
        public FieldAccessorTable internalGetFieldAccessorTable() {
            throw new UnsupportedOperationException("Should be overridden in gencode.");
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (BuilderT) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (BuilderT) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (BuilderT) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (BuilderT) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (BuilderT) super.mergeUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (BuilderT) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (BuilderT) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clear() {
            return (BuilderT) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        @Deprecated
        /* JADX INFO: renamed from: clone */
        public BuilderT mo106clone() {
            return (BuilderT) super.mo106clone();
        }
    }

    @Deprecated
    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    @Deprecated
    public static abstract class ExtendableBuilder<MessageT extends ExtendableMessage<MessageT>, BuilderT extends ExtendableBuilder<MessageT, BuilderT>> extends Builder<BuilderT> implements ExtendableMessageOrBuilder<MessageT> {
        @Deprecated
        public ExtendableBuilder() {
        }

        @Deprecated
        public <T> BuilderT addExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension, T t) {
            return addExtension((ExtensionLite) generatedExtension, (Object) t);
        }

        @Deprecated
        public <T> BuilderT clearExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension) {
            return clearExtension((ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension) {
            return (T) getExtension((ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension) {
            return getExtensionCount((ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension) {
            return hasExtension((ExtensionLite) generatedExtension);
        }

        @Deprecated
        public final void mergeExtensionFields(ExtendableMessage<?> extendableMessage) {
            super.mergeExtensionFields((GeneratedMessage.ExtendableMessage<?>) extendableMessage);
        }

        @Deprecated
        public <T> BuilderT setExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension, T t) {
            return setExtension((ExtensionLite) generatedExtension, (Object) t);
        }

        @Deprecated
        public ExtendableBuilder(BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension, int i) {
            return (T) getExtension((ExtensionLite) generatedExtension, i);
        }

        @Deprecated
        public <T> BuilderT setExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension, int i, T t) {
            return setExtension((ExtensionLite) generatedExtension, i, (Object) t);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (BuilderT) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (BuilderT) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (BuilderT) super.clearOneof(oneofDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (BuilderT) super.setField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        @Deprecated
        public BuilderT setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (BuilderT) super.setRepeatedField(fieldDescriptor, i, obj);
        }
    }

    @Deprecated
    public static abstract class ExtendableMessage<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessageV3 implements ExtendableMessageOrBuilder<MessageT> {

        @Deprecated
        public class ExtensionWriter extends GeneratedMessage.ExtendableMessage.ExtensionWriter {
            private ExtensionWriter(boolean z) {
                super(ExtendableMessage.this, z);
            }
        }

        @Deprecated
        public ExtendableMessage() {
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension) {
            return (T) getExtension((ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension) {
            return getExtensionCount((ExtensionLite) generatedExtension);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension) {
            return hasExtension((ExtensionLite) generatedExtension);
        }

        @Deprecated
        public ExtendableMessage(ExtendableBuilder<MessageT, ?> extendableBuilder) {
            super(extendableBuilder);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.ExtendableMessageOrBuilder
        @Deprecated
        public final <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension, int i) {
            return (T) getExtension((ExtensionLite) generatedExtension, i);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        @Deprecated
        public FieldAccessorTable internalGetFieldAccessorTable() {
            throw new UnsupportedOperationException("Should be overridden in gencode.");
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage
        @Deprecated
        public GeneratedMessage.ExtendableMessage<GeneratedMessageV3>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage
        @Deprecated
        public GeneratedMessage.ExtendableMessage<GeneratedMessageV3>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }
    }

    @Deprecated
    public interface ExtendableMessageOrBuilder<MessageT extends ExtendableMessage<MessageT>> extends GeneratedMessage.ExtendableMessageOrBuilder<GeneratedMessageV3> {
        @Deprecated
        <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension);

        @Deprecated
        <T> T getExtension(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension, int i);

        @Deprecated
        <T> int getExtensionCount(GeneratedMessage.GeneratedExtension<MessageT, List<T>> generatedExtension);

        @Deprecated
        <T> boolean hasExtension(GeneratedMessage.GeneratedExtension<MessageT, T> generatedExtension);
    }

    @Deprecated
    public static final class FieldAccessorTable extends GeneratedMessage.FieldAccessorTable {
        @Deprecated
        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] strArr, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder<?>> cls2) {
            super(descriptor, strArr, cls, cls2);
        }

        @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable
        @Deprecated
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable ensureFieldAccessorsInitialized(Class cls, Class cls2) {
            return ensureFieldAccessorsInitialized((Class<? extends GeneratedMessage>) cls, (Class<? extends GeneratedMessage.Builder<?>>) cls2);
        }

        @Deprecated
        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] strArr) {
            super(descriptor, strArr);
        }

        @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable
        @Deprecated
        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> cls, Class<? extends GeneratedMessage.Builder<?>> cls2) {
            return (FieldAccessorTable) super.ensureFieldAccessorsInitialized(cls, cls2);
        }
    }

    @Deprecated
    public static final class UnusedPrivateParameter {
        static final UnusedPrivateParameter INSTANCE = new UnusedPrivateParameter();

        private UnusedPrivateParameter() {
        }
    }

    @Deprecated
    public GeneratedMessageV3() {
    }

    @Deprecated
    public static Internal.IntList mutableCopy(Internal.IntList intList) {
        return (Internal.IntList) GeneratedMessage.makeMutableCopy(intList);
    }

    @Override // com.google.protobuf.AbstractMessage
    @Deprecated
    public Message.Builder newBuilderForType(final AbstractMessage.BuilderParent builderParent) {
        return newBuilderForType(new BuilderParent() { // from class: com.google.protobuf.GeneratedMessageV3.1
            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                builderParent.markDirty();
            }
        });
    }

    @Deprecated
    public abstract Message.Builder newBuilderForType(BuilderParent builderParent);

    @Deprecated
    public Object newInstance(UnusedPrivateParameter unusedPrivateParameter) {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    @Deprecated
    public GeneratedMessageV3(Builder<?> builder) {
        super(builder);
    }

    @Deprecated
    public static Internal.LongList mutableCopy(Internal.LongList longList) {
        return (Internal.LongList) GeneratedMessage.makeMutableCopy(longList);
    }

    @Override // com.google.protobuf.GeneratedMessage
    @Deprecated
    public FieldAccessorTable internalGetFieldAccessorTable() {
        throw new UnsupportedOperationException("Should be overridden in gencode.");
    }

    @Deprecated
    public static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        return (Internal.FloatList) GeneratedMessage.makeMutableCopy(floatList);
    }

    @Deprecated
    public static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        return (Internal.DoubleList) GeneratedMessage.makeMutableCopy(doubleList);
    }

    @Deprecated
    public static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        return (Internal.BooleanList) GeneratedMessage.makeMutableCopy(booleanList);
    }
}
