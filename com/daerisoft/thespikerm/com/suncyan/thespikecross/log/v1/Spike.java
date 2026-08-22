package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class Spike extends GeneratedMessage implements SpikeOrBuilder {
    private static final Spike DEFAULT_INSTANCE;
    public static final int IS_FEINT_FIELD_NUMBER = 1;
    public static final int IS_SERVE_FIELD_NUMBER = 2;
    private static final Parser<Spike> PARSER;
    private static final long serialVersionUID = 0;
    private boolean isFeint_;
    private boolean isServe_;
    private byte memoizedIsInitialized;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", Spike.class.getName());
        DEFAULT_INSTANCE = new Spike();
        PARSER = new AbstractParser<Spike>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.Spike.1
            @Override // com.google.protobuf.Parser
            public Spike parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = Spike.newBuilder();
                try {
                    builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return builderNewBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (UninitializedMessageException e2) {
                    throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
                }
            }
        };
    }

    public static Spike getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Spike_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Spike parseDelimitedFrom(InputStream inputStream) {
        return (Spike) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Spike parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Spike> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Spike)) {
            return super.equals(obj);
        }
        Spike spike = (Spike) obj;
        return getIsFeint() == spike.getIsFeint() && getIsServe() == spike.getIsServe() && getUnknownFields().equals(spike.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.SpikeOrBuilder
    public boolean getIsFeint() {
        return this.isFeint_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.SpikeOrBuilder
    public boolean getIsServe() {
        return this.isServe_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Spike> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        boolean z = this.isFeint_;
        int iComputeBoolSize = z ? CodedOutputStream.computeBoolSize(1, z) : 0;
        boolean z2 = this.isServe_;
        if (z2) {
            iComputeBoolSize += CodedOutputStream.computeBoolSize(2, z2);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeBoolSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getUnknownFields().hashCode() + ((Internal.hashBoolean(getIsServe()) + ((((Internal.hashBoolean(getIsFeint()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Spike_fieldAccessorTable.ensureFieldAccessorsInitialized(Spike.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        boolean z = this.isFeint_;
        if (z) {
            codedOutputStream.writeBool(1, z);
        }
        boolean z2 = this.isServe_;
        if (z2) {
            codedOutputStream.writeBool(2, z2);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements SpikeOrBuilder {
        private int bitField0_;
        private boolean isFeint_;
        private boolean isServe_;

        private void buildPartial0(Spike spike) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                spike.isFeint_ = this.isFeint_;
            }
            if ((i & 2) != 0) {
                spike.isServe_ = this.isServe_;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Spike_descriptor;
        }

        public Builder clearIsFeint() {
            this.bitField0_ &= -2;
            this.isFeint_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsServe() {
            this.bitField0_ &= -3;
            this.isServe_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Spike_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.SpikeOrBuilder
        public boolean getIsFeint() {
            return this.isFeint_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.SpikeOrBuilder
        public boolean getIsServe() {
            return this.isServe_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_Spike_fieldAccessorTable.ensureFieldAccessorsInitialized(Spike.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setIsFeint(boolean z) {
            this.isFeint_ = z;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setIsServe(boolean z) {
            this.isServe_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        private Builder() {
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Spike build() {
            Spike spikeBuildPartial = buildPartial();
            if (spikeBuildPartial.isInitialized()) {
                return spikeBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) spikeBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Spike buildPartial() {
            Spike spike = new Spike(this);
            if (this.bitField0_ != 0) {
                buildPartial0(spike);
            }
            onBuilt();
            return spike;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Spike getDefaultInstanceForType() {
            return Spike.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.isFeint_ = false;
            this.isServe_ = false;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof Spike) {
                return mergeFrom((Spike) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Spike spike) {
            if (spike == Spike.getDefaultInstance()) {
                return this;
            }
            if (spike.getIsFeint()) {
                setIsFeint(spike.getIsFeint());
            }
            if (spike.getIsServe()) {
                setIsServe(spike.getIsServe());
            }
            mergeUnknownFields(spike.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.isFeint_ = codedInputStream.readBool();
                                this.bitField0_ |= 1;
                            } else if (tag != 16) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.isServe_ = codedInputStream.readBool();
                                this.bitField0_ |= 2;
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    onChanged();
                    throw th;
                }
            }
            onChanged();
            return this;
        }
    }

    private Spike(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.isFeint_ = false;
        this.isServe_ = false;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(Spike spike) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(spike);
    }

    public static Spike parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Spike parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Spike) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Spike parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Spike getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static Spike parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Spike parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    private Spike() {
        this.isFeint_ = false;
        this.isServe_ = false;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Spike parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Spike parseFrom(InputStream inputStream) {
        return (Spike) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Spike parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Spike) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Spike parseFrom(CodedInputStream codedInputStream) {
        return (Spike) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Spike parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Spike) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
