package com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
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
public final class ActionLog extends GeneratedMessage implements ActionLogOrBuilder {
    public static final int ACTION_COMMON_FIELD_NUMBER = 3;
    public static final int ACTION_DATA_FIELD_NUMBER = 2;
    public static final int ACTION_LOG_TYPE_FIELD_NUMBER = 1;
    private static final ActionLog DEFAULT_INSTANCE;
    private static final Parser<ActionLog> PARSER;
    private static final long serialVersionUID = 0;
    private ActionCommonData actionCommon_;
    private ActionData actionData_;
    private volatile Object actionLogType_;
    private int bitField0_;
    private byte memoizedIsInitialized;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", ActionLog.class.getName());
        DEFAULT_INSTANCE = new ActionLog();
        PARSER = new AbstractParser<ActionLog>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLog.1
            @Override // com.google.protobuf.Parser
            public ActionLog parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = ActionLog.newBuilder();
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

    public static /* synthetic */ int access$776(ActionLog actionLog, int i) {
        int i2 = i | actionLog.bitField0_;
        actionLog.bitField0_ = i2;
        return i2;
    }

    public static ActionLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionLog_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ActionLog parseDelimitedFrom(InputStream inputStream) {
        return (ActionLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ActionLog parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ActionLog> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionLog)) {
            return super.equals(obj);
        }
        ActionLog actionLog = (ActionLog) obj;
        if (!getActionLogType().equals(actionLog.getActionLogType()) || hasActionData() != actionLog.hasActionData()) {
            return false;
        }
        if ((!hasActionData() || getActionData().equals(actionLog.getActionData())) && hasActionCommon() == actionLog.hasActionCommon()) {
            return (!hasActionCommon() || getActionCommon().equals(actionLog.getActionCommon())) && getUnknownFields().equals(actionLog.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public ActionCommonData getActionCommon() {
        ActionCommonData actionCommonData = this.actionCommon_;
        return actionCommonData == null ? ActionCommonData.getDefaultInstance() : actionCommonData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public ActionCommonDataOrBuilder getActionCommonOrBuilder() {
        ActionCommonData actionCommonData = this.actionCommon_;
        return actionCommonData == null ? ActionCommonData.getDefaultInstance() : actionCommonData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public ActionData getActionData() {
        ActionData actionData = this.actionData_;
        return actionData == null ? ActionData.getDefaultInstance() : actionData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public ActionDataOrBuilder getActionDataOrBuilder() {
        ActionData actionData = this.actionData_;
        return actionData == null ? ActionData.getDefaultInstance() : actionData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public String getActionLogType() {
        Object obj = this.actionLogType_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.actionLogType_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public ByteString getActionLogTypeBytes() {
        Object obj = this.actionLogType_;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.actionLogType_ = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ActionLog> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.actionLogType_) ? GeneratedMessage.computeStringSize(1, this.actionLogType_) : 0;
        if ((1 & this.bitField0_) != 0) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(2, getActionData());
        }
        if ((this.bitField0_ & 2) != 0) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(3, getActionCommon());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeStringSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public boolean hasActionCommon() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
    public boolean hasActionData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = getActionLogType().hashCode() + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53);
        if (hasActionData()) {
            iHashCode = getActionData().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 2, 53);
        }
        if (hasActionCommon()) {
            iHashCode = getActionCommon().hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode, 37, 3, 53);
        }
        int iHashCode2 = getUnknownFields().hashCode() + (iHashCode * 29);
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionLog_fieldAccessorTable.ensureFieldAccessorsInitialized(ActionLog.class, Builder.class);
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
        if (!GeneratedMessage.isStringEmpty(this.actionLogType_)) {
            GeneratedMessage.writeString(codedOutputStream, 1, this.actionLogType_);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(2, getActionData());
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeMessage(3, getActionCommon());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActionLogOrBuilder {
        private SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> actionCommonBuilder_;
        private ActionCommonData actionCommon_;
        private SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> actionDataBuilder_;
        private ActionData actionData_;
        private Object actionLogType_;
        private int bitField0_;

        private void buildPartial0(ActionLog actionLog) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                actionLog.actionLogType_ = this.actionLogType_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
                actionLog.actionData_ = singleFieldBuilder == null ? this.actionData_ : (ActionData) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder2 = this.actionCommonBuilder_;
                actionLog.actionCommon_ = singleFieldBuilder2 == null ? this.actionCommon_ : (ActionCommonData) singleFieldBuilder2.build();
                i |= 2;
            }
            ActionLog.access$776(actionLog, i);
        }

        private SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> getActionCommonFieldBuilder() {
            if (this.actionCommonBuilder_ == null) {
                this.actionCommonBuilder_ = new SingleFieldBuilder<>(getActionCommon(), getParentForChildren(), isClean());
                this.actionCommon_ = null;
            }
            return this.actionCommonBuilder_;
        }

        private SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> getActionDataFieldBuilder() {
            if (this.actionDataBuilder_ == null) {
                this.actionDataBuilder_ = new SingleFieldBuilder<>(getActionData(), getParentForChildren(), isClean());
                this.actionData_ = null;
            }
            return this.actionDataBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionLog_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getActionDataFieldBuilder();
                getActionCommonFieldBuilder();
            }
        }

        public Builder clearActionCommon() {
            this.bitField0_ &= -5;
            this.actionCommon_ = null;
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder = this.actionCommonBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.actionCommonBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearActionData() {
            this.bitField0_ &= -3;
            this.actionData_ = null;
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.actionDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearActionLogType() {
            this.actionLogType_ = ActionLog.getDefaultInstance().getActionLogType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public ActionCommonData getActionCommon() {
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder = this.actionCommonBuilder_;
            if (singleFieldBuilder != null) {
                return (ActionCommonData) singleFieldBuilder.getMessage();
            }
            ActionCommonData actionCommonData = this.actionCommon_;
            return actionCommonData == null ? ActionCommonData.getDefaultInstance() : actionCommonData;
        }

        public ActionCommonData.Builder getActionCommonBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (ActionCommonData.Builder) getActionCommonFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public ActionCommonDataOrBuilder getActionCommonOrBuilder() {
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder = this.actionCommonBuilder_;
            if (singleFieldBuilder != null) {
                return (ActionCommonDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            ActionCommonData actionCommonData = this.actionCommon_;
            return actionCommonData == null ? ActionCommonData.getDefaultInstance() : actionCommonData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public ActionData getActionData() {
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder != null) {
                return (ActionData) singleFieldBuilder.getMessage();
            }
            ActionData actionData = this.actionData_;
            return actionData == null ? ActionData.getDefaultInstance() : actionData;
        }

        public ActionData.Builder getActionDataBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (ActionData.Builder) getActionDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public ActionDataOrBuilder getActionDataOrBuilder() {
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder != null) {
                return (ActionDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            ActionData actionData = this.actionData_;
            return actionData == null ? ActionData.getDefaultInstance() : actionData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public String getActionLogType() {
            Object obj = this.actionLogType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.actionLogType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public ByteString getActionLogTypeBytes() {
            Object obj = this.actionLogType_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.actionLogType_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionLog_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public boolean hasActionCommon() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionLogOrBuilder
        public boolean hasActionData() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionLog_fieldAccessorTable.ensureFieldAccessorsInitialized(ActionLog.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeActionCommon(ActionCommonData actionCommonData) {
            ActionCommonData actionCommonData2;
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder = this.actionCommonBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(actionCommonData);
            } else if ((this.bitField0_ & 4) == 0 || (actionCommonData2 = this.actionCommon_) == null || actionCommonData2 == ActionCommonData.getDefaultInstance()) {
                this.actionCommon_ = actionCommonData;
            } else {
                getActionCommonBuilder().mergeFrom(actionCommonData);
            }
            if (this.actionCommon_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder mergeActionData(ActionData actionData) {
            ActionData actionData2;
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(actionData);
            } else if ((this.bitField0_ & 2) == 0 || (actionData2 = this.actionData_) == null || actionData2 == ActionData.getDefaultInstance()) {
                this.actionData_ = actionData;
            } else {
                getActionDataBuilder().mergeFrom(actionData);
            }
            if (this.actionData_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder setActionCommon(ActionCommonData actionCommonData) {
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder = this.actionCommonBuilder_;
            if (singleFieldBuilder == null) {
                actionCommonData.getClass();
                this.actionCommon_ = actionCommonData;
            } else {
                singleFieldBuilder.setMessage(actionCommonData);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setActionData(ActionData actionData) {
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder == null) {
                actionData.getClass();
                this.actionData_ = actionData;
            } else {
                singleFieldBuilder.setMessage(actionData);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setActionLogType(String str) {
            str.getClass();
            this.actionLogType_ = str;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setActionLogTypeBytes(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.actionLogType_ = byteString;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private Builder() {
            this.actionLogType_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActionLog build() {
            ActionLog actionLogBuildPartial = buildPartial();
            if (actionLogBuildPartial.isInitialized()) {
                return actionLogBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) actionLogBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActionLog buildPartial() {
            ActionLog actionLog = new ActionLog(this);
            if (this.bitField0_ != 0) {
                buildPartial0(actionLog);
            }
            onBuilt();
            return actionLog;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActionLog getDefaultInstanceForType() {
            return ActionLog.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.actionLogType_ = "";
            this.actionData_ = null;
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.actionDataBuilder_ = null;
            }
            this.actionCommon_ = null;
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder2 = this.actionCommonBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.actionCommonBuilder_ = null;
            }
            return this;
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.actionLogType_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ActionLog) {
                return mergeFrom((ActionLog) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setActionCommon(ActionCommonData.Builder builder) {
            SingleFieldBuilder<ActionCommonData, ActionCommonData.Builder, ActionCommonDataOrBuilder> singleFieldBuilder = this.actionCommonBuilder_;
            if (singleFieldBuilder == null) {
                this.actionCommon_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setActionData(ActionData.Builder builder) {
            SingleFieldBuilder<ActionData, ActionData.Builder, ActionDataOrBuilder> singleFieldBuilder = this.actionDataBuilder_;
            if (singleFieldBuilder == null) {
                this.actionData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeFrom(ActionLog actionLog) {
            if (actionLog == ActionLog.getDefaultInstance()) {
                return this;
            }
            if (!actionLog.getActionLogType().isEmpty()) {
                this.actionLogType_ = actionLog.actionLogType_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (actionLog.hasActionData()) {
                mergeActionData(actionLog.getActionData());
            }
            if (actionLog.hasActionCommon()) {
                mergeActionCommon(actionLog.getActionCommon());
            }
            mergeUnknownFields(actionLog.getUnknownFields());
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
                            if (tag == 10) {
                                this.actionLogType_ = codedInputStream.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                codedInputStream.readMessage(getActionDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 2;
                            } else if (tag != 26) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getActionCommonFieldBuilder().getBuilder(), extensionRegistryLite);
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

    private ActionLog(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.actionLogType_ = "";
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(ActionLog actionLog) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(actionLog);
    }

    public static ActionLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ActionLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionLog) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActionLog parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ActionLog getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static ActionLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ActionLog() {
        this.actionLogType_ = "";
        this.memoizedIsInitialized = (byte) -1;
        this.actionLogType_ = "";
    }

    public static ActionLog parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static ActionLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ActionLog parseFrom(InputStream inputStream) {
        return (ActionLog) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ActionLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionLog) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActionLog parseFrom(CodedInputStream codedInputStream) {
        return (ActionLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ActionLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionLog) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
