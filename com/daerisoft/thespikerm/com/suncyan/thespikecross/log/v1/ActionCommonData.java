package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ActionCommonData extends GeneratedMessage implements ActionCommonDataOrBuilder {
    public static final int AFTER_LOG_FIELD_NUMBER = 3;
    private static final ActionCommonData DEFAULT_INSTANCE;
    private static final Parser<ActionCommonData> PARSER;
    public static final int PREVIOUS_LOG_FIELD_NUMBER = 2;
    public static final int TRIGGER_TOUCH_COUNT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private AfterLog afterLog_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private PreviousLog previousLog_;
    private int triggerTouchCount_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", ActionCommonData.class.getName());
        DEFAULT_INSTANCE = new ActionCommonData();
        PARSER = new AbstractParser<ActionCommonData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonData.1
            @Override // com.google.protobuf.Parser
            public ActionCommonData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = ActionCommonData.newBuilder();
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

    public static /* synthetic */ int access$776(ActionCommonData actionCommonData, int i) {
        int i2 = i | actionCommonData.bitField0_;
        actionCommonData.bitField0_ = i2;
        return i2;
    }

    public static ActionCommonData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionCommonData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ActionCommonData parseDelimitedFrom(InputStream inputStream) {
        return (ActionCommonData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ActionCommonData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ActionCommonData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionCommonData)) {
            return super.equals(obj);
        }
        ActionCommonData actionCommonData = (ActionCommonData) obj;
        if (getTriggerTouchCount() != actionCommonData.getTriggerTouchCount() || hasPreviousLog() != actionCommonData.hasPreviousLog()) {
            return false;
        }
        if ((!hasPreviousLog() || getPreviousLog().equals(actionCommonData.getPreviousLog())) && hasAfterLog() == actionCommonData.hasAfterLog()) {
            return (!hasAfterLog() || getAfterLog().equals(actionCommonData.getAfterLog())) && getUnknownFields().equals(actionCommonData.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public AfterLog getAfterLog() {
        AfterLog afterLog = this.afterLog_;
        return afterLog == null ? AfterLog.getDefaultInstance() : afterLog;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public AfterLogOrBuilder getAfterLogOrBuilder() {
        AfterLog afterLog = this.afterLog_;
        return afterLog == null ? AfterLog.getDefaultInstance() : afterLog;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ActionCommonData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public PreviousLog getPreviousLog() {
        PreviousLog previousLog = this.previousLog_;
        return previousLog == null ? PreviousLog.getDefaultInstance() : previousLog;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public PreviousLogOrBuilder getPreviousLogOrBuilder() {
        PreviousLog previousLog = this.previousLog_;
        return previousLog == null ? PreviousLog.getDefaultInstance() : previousLog;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.triggerTouchCount_;
        int iComputeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
        if ((1 & this.bitField0_) != 0) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, getPreviousLog());
        }
        if ((this.bitField0_ & 2) != 0) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, getAfterLog());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeInt32Size;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public int getTriggerTouchCount() {
        return this.triggerTouchCount_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public boolean hasAfterLog() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
    public boolean hasPreviousLog() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int triggerTouchCount = getTriggerTouchCount() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53);
        if (hasPreviousLog()) {
            triggerTouchCount = getPreviousLog().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(triggerTouchCount, 37, 2, 53);
        }
        if (hasAfterLog()) {
            triggerTouchCount = getAfterLog().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(triggerTouchCount, 37, 3, 53);
        }
        int iHashCode = getUnknownFields().hashCode() + (triggerTouchCount * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionCommonData_fieldAccessorTable.ensureFieldAccessorsInitialized(ActionCommonData.class, Builder.class);
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
        int i = this.triggerTouchCount_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(2, getPreviousLog());
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeMessage(3, getAfterLog());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActionCommonDataOrBuilder {
        private SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> afterLogBuilder_;
        private AfterLog afterLog_;
        private int bitField0_;
        private SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> previousLogBuilder_;
        private PreviousLog previousLog_;
        private int triggerTouchCount_;

        private void buildPartial0(ActionCommonData actionCommonData) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                actionCommonData.triggerTouchCount_ = this.triggerTouchCount_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
                actionCommonData.previousLog_ = singleFieldBuilder == null ? this.previousLog_ : (PreviousLog) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder2 = this.afterLogBuilder_;
                actionCommonData.afterLog_ = singleFieldBuilder2 == null ? this.afterLog_ : (AfterLog) singleFieldBuilder2.build();
                i |= 2;
            }
            ActionCommonData.access$776(actionCommonData, i);
        }

        private SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> getAfterLogFieldBuilder() {
            if (this.afterLogBuilder_ == null) {
                this.afterLogBuilder_ = new SingleFieldBuilder<>(getAfterLog(), getParentForChildren(), isClean());
                this.afterLog_ = null;
            }
            return this.afterLogBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionCommonData_descriptor;
        }

        private SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> getPreviousLogFieldBuilder() {
            if (this.previousLogBuilder_ == null) {
                this.previousLogBuilder_ = new SingleFieldBuilder<>(getPreviousLog(), getParentForChildren(), isClean());
                this.previousLog_ = null;
            }
            return this.previousLogBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getPreviousLogFieldBuilder();
                getAfterLogFieldBuilder();
            }
        }

        public Builder clearAfterLog() {
            this.bitField0_ &= -5;
            this.afterLog_ = null;
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder = this.afterLogBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.afterLogBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearPreviousLog() {
            this.bitField0_ &= -3;
            this.previousLog_ = null;
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.previousLogBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearTriggerTouchCount() {
            this.bitField0_ &= -2;
            this.triggerTouchCount_ = 0;
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public AfterLog getAfterLog() {
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder = this.afterLogBuilder_;
            if (singleFieldBuilder != null) {
                return (AfterLog) singleFieldBuilder.getMessage();
            }
            AfterLog afterLog = this.afterLog_;
            return afterLog == null ? AfterLog.getDefaultInstance() : afterLog;
        }

        public AfterLog.Builder getAfterLogBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (AfterLog.Builder) getAfterLogFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public AfterLogOrBuilder getAfterLogOrBuilder() {
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder = this.afterLogBuilder_;
            if (singleFieldBuilder != null) {
                return (AfterLogOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            AfterLog afterLog = this.afterLog_;
            return afterLog == null ? AfterLog.getDefaultInstance() : afterLog;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionCommonData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public PreviousLog getPreviousLog() {
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder != null) {
                return (PreviousLog) singleFieldBuilder.getMessage();
            }
            PreviousLog previousLog = this.previousLog_;
            return previousLog == null ? PreviousLog.getDefaultInstance() : previousLog;
        }

        public PreviousLog.Builder getPreviousLogBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (PreviousLog.Builder) getPreviousLogFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public PreviousLogOrBuilder getPreviousLogOrBuilder() {
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder != null) {
                return (PreviousLogOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PreviousLog previousLog = this.previousLog_;
            return previousLog == null ? PreviousLog.getDefaultInstance() : previousLog;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public int getTriggerTouchCount() {
            return this.triggerTouchCount_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public boolean hasAfterLog() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionCommonDataOrBuilder
        public boolean hasPreviousLog() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionCommonData_fieldAccessorTable.ensureFieldAccessorsInitialized(ActionCommonData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAfterLog(AfterLog afterLog) {
            AfterLog afterLog2;
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder = this.afterLogBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(afterLog);
            } else if ((this.bitField0_ & 4) == 0 || (afterLog2 = this.afterLog_) == null || afterLog2 == AfterLog.getDefaultInstance()) {
                this.afterLog_ = afterLog;
            } else {
                getAfterLogBuilder().mergeFrom(afterLog);
            }
            if (this.afterLog_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder mergePreviousLog(PreviousLog previousLog) {
            PreviousLog previousLog2;
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(previousLog);
            } else if ((this.bitField0_ & 2) == 0 || (previousLog2 = this.previousLog_) == null || previousLog2 == PreviousLog.getDefaultInstance()) {
                this.previousLog_ = previousLog;
            } else {
                getPreviousLogBuilder().mergeFrom(previousLog);
            }
            if (this.previousLog_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder setAfterLog(AfterLog afterLog) {
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder = this.afterLogBuilder_;
            if (singleFieldBuilder == null) {
                afterLog.getClass();
                this.afterLog_ = afterLog;
            } else {
                singleFieldBuilder.setMessage(afterLog);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPreviousLog(PreviousLog previousLog) {
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder == null) {
                previousLog.getClass();
                this.previousLog_ = previousLog;
            } else {
                singleFieldBuilder.setMessage(previousLog);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setTriggerTouchCount(int i) {
            this.triggerTouchCount_ = i;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActionCommonData build() {
            ActionCommonData actionCommonDataBuildPartial = buildPartial();
            if (actionCommonDataBuildPartial.isInitialized()) {
                return actionCommonDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) actionCommonDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActionCommonData buildPartial() {
            ActionCommonData actionCommonData = new ActionCommonData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(actionCommonData);
            }
            onBuilt();
            return actionCommonData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActionCommonData getDefaultInstanceForType() {
            return ActionCommonData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.triggerTouchCount_ = 0;
            this.previousLog_ = null;
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.previousLogBuilder_ = null;
            }
            this.afterLog_ = null;
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder2 = this.afterLogBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.afterLogBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ActionCommonData) {
                return mergeFrom((ActionCommonData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setAfterLog(AfterLog.Builder builder) {
            SingleFieldBuilder<AfterLog, AfterLog.Builder, AfterLogOrBuilder> singleFieldBuilder = this.afterLogBuilder_;
            if (singleFieldBuilder == null) {
                this.afterLog_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPreviousLog(PreviousLog.Builder builder) {
            SingleFieldBuilder<PreviousLog, PreviousLog.Builder, PreviousLogOrBuilder> singleFieldBuilder = this.previousLogBuilder_;
            if (singleFieldBuilder == null) {
                this.previousLog_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeFrom(ActionCommonData actionCommonData) {
            if (actionCommonData == ActionCommonData.getDefaultInstance()) {
                return this;
            }
            if (actionCommonData.getTriggerTouchCount() != 0) {
                setTriggerTouchCount(actionCommonData.getTriggerTouchCount());
            }
            if (actionCommonData.hasPreviousLog()) {
                mergePreviousLog(actionCommonData.getPreviousLog());
            }
            if (actionCommonData.hasAfterLog()) {
                mergeAfterLog(actionCommonData.getAfterLog());
            }
            mergeUnknownFields(actionCommonData.getUnknownFields());
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
                                this.triggerTouchCount_ = codedInputStream.readInt32();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                codedInputStream.readMessage(getPreviousLogFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 2;
                            } else if (tag != 26) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getAfterLogFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 4;
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

    private ActionCommonData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.triggerTouchCount_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(ActionCommonData actionCommonData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(actionCommonData);
    }

    public static ActionCommonData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ActionCommonData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionCommonData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActionCommonData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ActionCommonData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static ActionCommonData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ActionCommonData() {
        this.triggerTouchCount_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ActionCommonData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static ActionCommonData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ActionCommonData parseFrom(InputStream inputStream) {
        return (ActionCommonData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ActionCommonData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionCommonData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActionCommonData parseFrom(CodedInputStream codedInputStream) {
        return (ActionCommonData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ActionCommonData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionCommonData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
