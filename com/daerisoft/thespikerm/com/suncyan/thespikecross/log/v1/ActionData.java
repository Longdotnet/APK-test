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
import com.google.protobuf.Internal;
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
public final class ActionData extends GeneratedMessage implements ActionDataOrBuilder {
    public static final int BLOCKING_FIELD_NUMBER = 2;
    private static final ActionData DEFAULT_INSTANCE;
    private static final Parser<ActionData> PARSER;
    public static final int RECEIVE_FIELD_NUMBER = 5;
    public static final int SERVE_FIELD_NUMBER = 4;
    public static final int SLIDING_FIELD_NUMBER = 3;
    public static final int SPIKE_FIELD_NUMBER = 1;
    public static final int TOSS_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int actionDetailCase_;
    private Object actionDetail_;
    private byte memoizedIsInitialized;

    /* JADX INFO: loaded from: classes2.dex */
    public enum ActionDetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        SPIKE(1),
        BLOCKING(2),
        SLIDING(3),
        SERVE(4),
        RECEIVE(5),
        TOSS(6),
        ACTIONDETAIL_NOT_SET(0);

        private final int value;

        ActionDetailCase(int i) {
            this.value = i;
        }

        public static ActionDetailCase forNumber(int i) {
            switch (i) {
                case 0:
                    return ACTIONDETAIL_NOT_SET;
                case 1:
                    return SPIKE;
                case 2:
                    return BLOCKING;
                case 3:
                    return SLIDING;
                case 4:
                    return SERVE;
                case 5:
                    return RECEIVE;
                case 6:
                    return TOSS;
                default:
                    return null;
            }
        }

        @Override // com.google.protobuf.Internal.EnumLite, com.google.protobuf.AbstractMessageLite.InternalOneOfEnum
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ActionDetailCase valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", ActionData.class.getName());
        DEFAULT_INSTANCE = new ActionData();
        PARSER = new AbstractParser<ActionData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionData.1
            @Override // com.google.protobuf.Parser
            public ActionData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = ActionData.newBuilder();
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

    public static ActionData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ActionData parseDelimitedFrom(InputStream inputStream) {
        return (ActionData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ActionData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ActionData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionData)) {
            return super.equals(obj);
        }
        ActionData actionData = (ActionData) obj;
        if (!getActionDetailCase().equals(actionData.getActionDetailCase())) {
            return false;
        }
        switch (this.actionDetailCase_) {
            case 1:
                if (!getSpike().equals(actionData.getSpike())) {
                    return false;
                }
                break;
            case 2:
                if (!getBlocking().equals(actionData.getBlocking())) {
                    return false;
                }
                break;
            case 3:
                if (!getSliding().equals(actionData.getSliding())) {
                    return false;
                }
                break;
            case 4:
                if (!getServe().equals(actionData.getServe())) {
                    return false;
                }
                break;
            case 5:
                if (!getReceive().equals(actionData.getReceive())) {
                    return false;
                }
                break;
            case 6:
                if (!getToss().equals(actionData.getToss())) {
                    return false;
                }
                break;
        }
        return getUnknownFields().equals(actionData.getUnknownFields());
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public ActionDetailCase getActionDetailCase() {
        return ActionDetailCase.forNumber(this.actionDetailCase_);
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public Blocking getBlocking() {
        return this.actionDetailCase_ == 2 ? (Blocking) this.actionDetail_ : Blocking.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public BlockingOrBuilder getBlockingOrBuilder() {
        return this.actionDetailCase_ == 2 ? (Blocking) this.actionDetail_ : Blocking.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ActionData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public Receive getReceive() {
        return this.actionDetailCase_ == 5 ? (Receive) this.actionDetail_ : Receive.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public ReceiveOrBuilder getReceiveOrBuilder() {
        return this.actionDetailCase_ == 5 ? (Receive) this.actionDetail_ : Receive.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = this.actionDetailCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (Spike) this.actionDetail_) : 0;
        if (this.actionDetailCase_ == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, (Blocking) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 3) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, (Sliding) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 4) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, (Serve) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 5) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, (Receive) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 6) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(6, (Toss) this.actionDetail_);
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeMessageSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public Serve getServe() {
        return this.actionDetailCase_ == 4 ? (Serve) this.actionDetail_ : Serve.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public ServeOrBuilder getServeOrBuilder() {
        return this.actionDetailCase_ == 4 ? (Serve) this.actionDetail_ : Serve.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public Sliding getSliding() {
        return this.actionDetailCase_ == 3 ? (Sliding) this.actionDetail_ : Sliding.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public SlidingOrBuilder getSlidingOrBuilder() {
        return this.actionDetailCase_ == 3 ? (Sliding) this.actionDetail_ : Sliding.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public Spike getSpike() {
        return this.actionDetailCase_ == 1 ? (Spike) this.actionDetail_ : Spike.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public SpikeOrBuilder getSpikeOrBuilder() {
        return this.actionDetailCase_ == 1 ? (Spike) this.actionDetail_ : Spike.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public Toss getToss() {
        return this.actionDetailCase_ == 6 ? (Toss) this.actionDetail_ : Toss.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public TossOrBuilder getTossOrBuilder() {
        return this.actionDetailCase_ == 6 ? (Toss) this.actionDetail_ : Toss.getDefaultInstance();
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public boolean hasBlocking() {
        return this.actionDetailCase_ == 2;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public boolean hasReceive() {
        return this.actionDetailCase_ == 5;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public boolean hasServe() {
        return this.actionDetailCase_ == 4;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public boolean hasSliding() {
        return this.actionDetailCase_ == 3;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public boolean hasSpike() {
        return this.actionDetailCase_ == 1;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
    public boolean hasToss() {
        return this.actionDetailCase_ == 6;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int iM;
        int iHashCode;
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode2 = getDescriptor().hashCode() + 779;
        switch (this.actionDetailCase_) {
            case 1:
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 37, 1, 53);
                iHashCode = getSpike().hashCode();
                break;
            case 2:
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 37, 2, 53);
                iHashCode = getBlocking().hashCode();
                break;
            case 3:
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 37, 3, 53);
                iHashCode = getSliding().hashCode();
                break;
            case 4:
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 37, 4, 53);
                iHashCode = getServe().hashCode();
                break;
            case 5:
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 37, 5, 53);
                iHashCode = getReceive().hashCode();
                break;
            case 6:
                iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iHashCode2, 37, 6, 53);
                iHashCode = getToss().hashCode();
                break;
            default:
                int iHashCode3 = getUnknownFields().hashCode() + (iHashCode2 * 29);
                this.memoizedHashCode = iHashCode3;
                return iHashCode3;
        }
        iHashCode2 = iM + iHashCode;
        int iHashCode4 = getUnknownFields().hashCode() + (iHashCode2 * 29);
        this.memoizedHashCode = iHashCode4;
        return iHashCode4;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionData_fieldAccessorTable.ensureFieldAccessorsInitialized(ActionData.class, Builder.class);
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
        if (this.actionDetailCase_ == 1) {
            codedOutputStream.writeMessage(1, (Spike) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 2) {
            codedOutputStream.writeMessage(2, (Blocking) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 3) {
            codedOutputStream.writeMessage(3, (Sliding) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 4) {
            codedOutputStream.writeMessage(4, (Serve) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 5) {
            codedOutputStream.writeMessage(5, (Receive) this.actionDetail_);
        }
        if (this.actionDetailCase_ == 6) {
            codedOutputStream.writeMessage(6, (Toss) this.actionDetail_);
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ActionDataOrBuilder {
        private int actionDetailCase_;
        private Object actionDetail_;
        private int bitField0_;
        private SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> blockingBuilder_;
        private SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> receiveBuilder_;
        private SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> serveBuilder_;
        private SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> slidingBuilder_;
        private SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> spikeBuilder_;
        private SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> tossBuilder_;

        private void buildPartial0(ActionData actionData) {
        }

        private void buildPartialOneofs(ActionData actionData) {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder;
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder2;
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder3;
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder4;
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder5;
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder6;
            actionData.actionDetailCase_ = this.actionDetailCase_;
            actionData.actionDetail_ = this.actionDetail_;
            if (this.actionDetailCase_ == 1 && (singleFieldBuilder6 = this.spikeBuilder_) != null) {
                actionData.actionDetail_ = singleFieldBuilder6.build();
            }
            if (this.actionDetailCase_ == 2 && (singleFieldBuilder5 = this.blockingBuilder_) != null) {
                actionData.actionDetail_ = singleFieldBuilder5.build();
            }
            if (this.actionDetailCase_ == 3 && (singleFieldBuilder4 = this.slidingBuilder_) != null) {
                actionData.actionDetail_ = singleFieldBuilder4.build();
            }
            if (this.actionDetailCase_ == 4 && (singleFieldBuilder3 = this.serveBuilder_) != null) {
                actionData.actionDetail_ = singleFieldBuilder3.build();
            }
            if (this.actionDetailCase_ == 5 && (singleFieldBuilder2 = this.receiveBuilder_) != null) {
                actionData.actionDetail_ = singleFieldBuilder2.build();
            }
            if (this.actionDetailCase_ != 6 || (singleFieldBuilder = this.tossBuilder_) == null) {
                return;
            }
            actionData.actionDetail_ = singleFieldBuilder.build();
        }

        private SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> getBlockingFieldBuilder() {
            if (this.blockingBuilder_ == null) {
                if (this.actionDetailCase_ != 2) {
                    this.actionDetail_ = Blocking.getDefaultInstance();
                }
                this.blockingBuilder_ = new SingleFieldBuilder<>((Blocking) this.actionDetail_, getParentForChildren(), isClean());
                this.actionDetail_ = null;
            }
            this.actionDetailCase_ = 2;
            onChanged();
            return this.blockingBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionData_descriptor;
        }

        private SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> getReceiveFieldBuilder() {
            if (this.receiveBuilder_ == null) {
                if (this.actionDetailCase_ != 5) {
                    this.actionDetail_ = Receive.getDefaultInstance();
                }
                this.receiveBuilder_ = new SingleFieldBuilder<>((Receive) this.actionDetail_, getParentForChildren(), isClean());
                this.actionDetail_ = null;
            }
            this.actionDetailCase_ = 5;
            onChanged();
            return this.receiveBuilder_;
        }

        private SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> getServeFieldBuilder() {
            if (this.serveBuilder_ == null) {
                if (this.actionDetailCase_ != 4) {
                    this.actionDetail_ = Serve.getDefaultInstance();
                }
                this.serveBuilder_ = new SingleFieldBuilder<>((Serve) this.actionDetail_, getParentForChildren(), isClean());
                this.actionDetail_ = null;
            }
            this.actionDetailCase_ = 4;
            onChanged();
            return this.serveBuilder_;
        }

        private SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> getSlidingFieldBuilder() {
            if (this.slidingBuilder_ == null) {
                if (this.actionDetailCase_ != 3) {
                    this.actionDetail_ = Sliding.getDefaultInstance();
                }
                this.slidingBuilder_ = new SingleFieldBuilder<>((Sliding) this.actionDetail_, getParentForChildren(), isClean());
                this.actionDetail_ = null;
            }
            this.actionDetailCase_ = 3;
            onChanged();
            return this.slidingBuilder_;
        }

        private SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> getSpikeFieldBuilder() {
            if (this.spikeBuilder_ == null) {
                if (this.actionDetailCase_ != 1) {
                    this.actionDetail_ = Spike.getDefaultInstance();
                }
                this.spikeBuilder_ = new SingleFieldBuilder<>((Spike) this.actionDetail_, getParentForChildren(), isClean());
                this.actionDetail_ = null;
            }
            this.actionDetailCase_ = 1;
            onChanged();
            return this.spikeBuilder_;
        }

        private SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> getTossFieldBuilder() {
            if (this.tossBuilder_ == null) {
                if (this.actionDetailCase_ != 6) {
                    this.actionDetail_ = Toss.getDefaultInstance();
                }
                this.tossBuilder_ = new SingleFieldBuilder<>((Toss) this.actionDetail_, getParentForChildren(), isClean());
                this.actionDetail_ = null;
            }
            this.actionDetailCase_ = 6;
            onChanged();
            return this.tossBuilder_;
        }

        public Builder clearActionDetail() {
            this.actionDetailCase_ = 0;
            this.actionDetail_ = null;
            onChanged();
            return this;
        }

        public Builder clearBlocking() {
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder = this.blockingBuilder_;
            if (singleFieldBuilder != null) {
                if (this.actionDetailCase_ == 2) {
                    this.actionDetailCase_ = 0;
                    this.actionDetail_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.actionDetailCase_ == 2) {
                this.actionDetailCase_ = 0;
                this.actionDetail_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearReceive() {
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder = this.receiveBuilder_;
            if (singleFieldBuilder != null) {
                if (this.actionDetailCase_ == 5) {
                    this.actionDetailCase_ = 0;
                    this.actionDetail_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.actionDetailCase_ == 5) {
                this.actionDetailCase_ = 0;
                this.actionDetail_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearServe() {
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder = this.serveBuilder_;
            if (singleFieldBuilder != null) {
                if (this.actionDetailCase_ == 4) {
                    this.actionDetailCase_ = 0;
                    this.actionDetail_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.actionDetailCase_ == 4) {
                this.actionDetailCase_ = 0;
                this.actionDetail_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearSliding() {
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder = this.slidingBuilder_;
            if (singleFieldBuilder != null) {
                if (this.actionDetailCase_ == 3) {
                    this.actionDetailCase_ = 0;
                    this.actionDetail_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.actionDetailCase_ == 3) {
                this.actionDetailCase_ = 0;
                this.actionDetail_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearSpike() {
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder = this.spikeBuilder_;
            if (singleFieldBuilder != null) {
                if (this.actionDetailCase_ == 1) {
                    this.actionDetailCase_ = 0;
                    this.actionDetail_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.actionDetailCase_ == 1) {
                this.actionDetailCase_ = 0;
                this.actionDetail_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearToss() {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder = this.tossBuilder_;
            if (singleFieldBuilder != null) {
                if (this.actionDetailCase_ == 6) {
                    this.actionDetailCase_ = 0;
                    this.actionDetail_ = null;
                }
                singleFieldBuilder.clear();
            } else if (this.actionDetailCase_ == 6) {
                this.actionDetailCase_ = 0;
                this.actionDetail_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public ActionDetailCase getActionDetailCase() {
            return ActionDetailCase.forNumber(this.actionDetailCase_);
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public Blocking getBlocking() {
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder = this.blockingBuilder_;
            if (singleFieldBuilder == null) {
                return this.actionDetailCase_ == 2 ? (Blocking) this.actionDetail_ : Blocking.getDefaultInstance();
            }
            return this.actionDetailCase_ == 2 ? (Blocking) singleFieldBuilder.getMessage() : Blocking.getDefaultInstance();
        }

        public Blocking.Builder getBlockingBuilder() {
            return (Blocking.Builder) getBlockingFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public BlockingOrBuilder getBlockingOrBuilder() {
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder;
            int i = this.actionDetailCase_;
            if (i != 2 || (singleFieldBuilder = this.blockingBuilder_) == null) {
                return i == 2 ? (Blocking) this.actionDetail_ : Blocking.getDefaultInstance();
            }
            return (BlockingOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public Receive getReceive() {
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder = this.receiveBuilder_;
            if (singleFieldBuilder == null) {
                return this.actionDetailCase_ == 5 ? (Receive) this.actionDetail_ : Receive.getDefaultInstance();
            }
            return this.actionDetailCase_ == 5 ? (Receive) singleFieldBuilder.getMessage() : Receive.getDefaultInstance();
        }

        public Receive.Builder getReceiveBuilder() {
            return (Receive.Builder) getReceiveFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public ReceiveOrBuilder getReceiveOrBuilder() {
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder;
            int i = this.actionDetailCase_;
            if (i != 5 || (singleFieldBuilder = this.receiveBuilder_) == null) {
                return i == 5 ? (Receive) this.actionDetail_ : Receive.getDefaultInstance();
            }
            return (ReceiveOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public Serve getServe() {
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder = this.serveBuilder_;
            if (singleFieldBuilder == null) {
                return this.actionDetailCase_ == 4 ? (Serve) this.actionDetail_ : Serve.getDefaultInstance();
            }
            return this.actionDetailCase_ == 4 ? (Serve) singleFieldBuilder.getMessage() : Serve.getDefaultInstance();
        }

        public Serve.Builder getServeBuilder() {
            return (Serve.Builder) getServeFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public ServeOrBuilder getServeOrBuilder() {
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder;
            int i = this.actionDetailCase_;
            if (i != 4 || (singleFieldBuilder = this.serveBuilder_) == null) {
                return i == 4 ? (Serve) this.actionDetail_ : Serve.getDefaultInstance();
            }
            return (ServeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public Sliding getSliding() {
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder = this.slidingBuilder_;
            if (singleFieldBuilder == null) {
                return this.actionDetailCase_ == 3 ? (Sliding) this.actionDetail_ : Sliding.getDefaultInstance();
            }
            return this.actionDetailCase_ == 3 ? (Sliding) singleFieldBuilder.getMessage() : Sliding.getDefaultInstance();
        }

        public Sliding.Builder getSlidingBuilder() {
            return (Sliding.Builder) getSlidingFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public SlidingOrBuilder getSlidingOrBuilder() {
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder;
            int i = this.actionDetailCase_;
            if (i != 3 || (singleFieldBuilder = this.slidingBuilder_) == null) {
                return i == 3 ? (Sliding) this.actionDetail_ : Sliding.getDefaultInstance();
            }
            return (SlidingOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public Spike getSpike() {
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder = this.spikeBuilder_;
            if (singleFieldBuilder == null) {
                return this.actionDetailCase_ == 1 ? (Spike) this.actionDetail_ : Spike.getDefaultInstance();
            }
            return this.actionDetailCase_ == 1 ? (Spike) singleFieldBuilder.getMessage() : Spike.getDefaultInstance();
        }

        public Spike.Builder getSpikeBuilder() {
            return (Spike.Builder) getSpikeFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public SpikeOrBuilder getSpikeOrBuilder() {
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder;
            int i = this.actionDetailCase_;
            if (i != 1 || (singleFieldBuilder = this.spikeBuilder_) == null) {
                return i == 1 ? (Spike) this.actionDetail_ : Spike.getDefaultInstance();
            }
            return (SpikeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public Toss getToss() {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder = this.tossBuilder_;
            if (singleFieldBuilder == null) {
                return this.actionDetailCase_ == 6 ? (Toss) this.actionDetail_ : Toss.getDefaultInstance();
            }
            return this.actionDetailCase_ == 6 ? (Toss) singleFieldBuilder.getMessage() : Toss.getDefaultInstance();
        }

        public Toss.Builder getTossBuilder() {
            return (Toss.Builder) getTossFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public TossOrBuilder getTossOrBuilder() {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder;
            int i = this.actionDetailCase_;
            if (i != 6 || (singleFieldBuilder = this.tossBuilder_) == null) {
                return i == 6 ? (Toss) this.actionDetail_ : Toss.getDefaultInstance();
            }
            return (TossOrBuilder) singleFieldBuilder.getMessageOrBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public boolean hasBlocking() {
            return this.actionDetailCase_ == 2;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public boolean hasReceive() {
            return this.actionDetailCase_ == 5;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public boolean hasServe() {
            return this.actionDetailCase_ == 4;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public boolean hasSliding() {
            return this.actionDetailCase_ == 3;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public boolean hasSpike() {
            return this.actionDetailCase_ == 1;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.ActionDataOrBuilder
        public boolean hasToss() {
            return this.actionDetailCase_ == 6;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_ActionData_fieldAccessorTable.ensureFieldAccessorsInitialized(ActionData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeBlocking(Blocking blocking) {
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder = this.blockingBuilder_;
            if (singleFieldBuilder == null) {
                if (this.actionDetailCase_ != 2 || this.actionDetail_ == Blocking.getDefaultInstance()) {
                    this.actionDetail_ = blocking;
                } else {
                    this.actionDetail_ = Blocking.newBuilder((Blocking) this.actionDetail_).mergeFrom(blocking).buildPartial();
                }
                onChanged();
            } else if (this.actionDetailCase_ == 2) {
                singleFieldBuilder.mergeFrom(blocking);
            } else {
                singleFieldBuilder.setMessage(blocking);
            }
            this.actionDetailCase_ = 2;
            return this;
        }

        public Builder mergeReceive(Receive receive) {
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder = this.receiveBuilder_;
            if (singleFieldBuilder == null) {
                if (this.actionDetailCase_ != 5 || this.actionDetail_ == Receive.getDefaultInstance()) {
                    this.actionDetail_ = receive;
                } else {
                    this.actionDetail_ = Receive.newBuilder((Receive) this.actionDetail_).mergeFrom(receive).buildPartial();
                }
                onChanged();
            } else if (this.actionDetailCase_ == 5) {
                singleFieldBuilder.mergeFrom(receive);
            } else {
                singleFieldBuilder.setMessage(receive);
            }
            this.actionDetailCase_ = 5;
            return this;
        }

        public Builder mergeServe(Serve serve) {
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder = this.serveBuilder_;
            if (singleFieldBuilder == null) {
                if (this.actionDetailCase_ != 4 || this.actionDetail_ == Serve.getDefaultInstance()) {
                    this.actionDetail_ = serve;
                } else {
                    this.actionDetail_ = Serve.newBuilder((Serve) this.actionDetail_).mergeFrom(serve).buildPartial();
                }
                onChanged();
            } else if (this.actionDetailCase_ == 4) {
                singleFieldBuilder.mergeFrom(serve);
            } else {
                singleFieldBuilder.setMessage(serve);
            }
            this.actionDetailCase_ = 4;
            return this;
        }

        public Builder mergeSliding(Sliding sliding) {
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder = this.slidingBuilder_;
            if (singleFieldBuilder == null) {
                if (this.actionDetailCase_ != 3 || this.actionDetail_ == Sliding.getDefaultInstance()) {
                    this.actionDetail_ = sliding;
                } else {
                    this.actionDetail_ = Sliding.newBuilder((Sliding) this.actionDetail_).mergeFrom(sliding).buildPartial();
                }
                onChanged();
            } else if (this.actionDetailCase_ == 3) {
                singleFieldBuilder.mergeFrom(sliding);
            } else {
                singleFieldBuilder.setMessage(sliding);
            }
            this.actionDetailCase_ = 3;
            return this;
        }

        public Builder mergeSpike(Spike spike) {
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder = this.spikeBuilder_;
            if (singleFieldBuilder == null) {
                if (this.actionDetailCase_ != 1 || this.actionDetail_ == Spike.getDefaultInstance()) {
                    this.actionDetail_ = spike;
                } else {
                    this.actionDetail_ = Spike.newBuilder((Spike) this.actionDetail_).mergeFrom(spike).buildPartial();
                }
                onChanged();
            } else if (this.actionDetailCase_ == 1) {
                singleFieldBuilder.mergeFrom(spike);
            } else {
                singleFieldBuilder.setMessage(spike);
            }
            this.actionDetailCase_ = 1;
            return this;
        }

        public Builder mergeToss(Toss toss) {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder = this.tossBuilder_;
            if (singleFieldBuilder == null) {
                if (this.actionDetailCase_ != 6 || this.actionDetail_ == Toss.getDefaultInstance()) {
                    this.actionDetail_ = toss;
                } else {
                    this.actionDetail_ = Toss.newBuilder((Toss) this.actionDetail_).mergeFrom(toss).buildPartial();
                }
                onChanged();
            } else if (this.actionDetailCase_ == 6) {
                singleFieldBuilder.mergeFrom(toss);
            } else {
                singleFieldBuilder.setMessage(toss);
            }
            this.actionDetailCase_ = 6;
            return this;
        }

        public Builder setBlocking(Blocking blocking) {
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder = this.blockingBuilder_;
            if (singleFieldBuilder == null) {
                blocking.getClass();
                this.actionDetail_ = blocking;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(blocking);
            }
            this.actionDetailCase_ = 2;
            return this;
        }

        public Builder setReceive(Receive receive) {
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder = this.receiveBuilder_;
            if (singleFieldBuilder == null) {
                receive.getClass();
                this.actionDetail_ = receive;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(receive);
            }
            this.actionDetailCase_ = 5;
            return this;
        }

        public Builder setServe(Serve serve) {
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder = this.serveBuilder_;
            if (singleFieldBuilder == null) {
                serve.getClass();
                this.actionDetail_ = serve;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(serve);
            }
            this.actionDetailCase_ = 4;
            return this;
        }

        public Builder setSliding(Sliding sliding) {
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder = this.slidingBuilder_;
            if (singleFieldBuilder == null) {
                sliding.getClass();
                this.actionDetail_ = sliding;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(sliding);
            }
            this.actionDetailCase_ = 3;
            return this;
        }

        public Builder setSpike(Spike spike) {
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder = this.spikeBuilder_;
            if (singleFieldBuilder == null) {
                spike.getClass();
                this.actionDetail_ = spike;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(spike);
            }
            this.actionDetailCase_ = 1;
            return this;
        }

        public Builder setToss(Toss toss) {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder = this.tossBuilder_;
            if (singleFieldBuilder == null) {
                toss.getClass();
                this.actionDetail_ = toss;
                onChanged();
            } else {
                singleFieldBuilder.setMessage(toss);
            }
            this.actionDetailCase_ = 6;
            return this;
        }

        private Builder() {
            this.actionDetailCase_ = 0;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActionData build() {
            ActionData actionDataBuildPartial = buildPartial();
            if (actionDataBuildPartial.isInitialized()) {
                return actionDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) actionDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActionData buildPartial() {
            ActionData actionData = new ActionData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(actionData);
            }
            buildPartialOneofs(actionData);
            onBuilt();
            return actionData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActionData getDefaultInstanceForType() {
            return ActionData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.actionDetailCase_ = 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder = this.spikeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.clear();
            }
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder2 = this.blockingBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.clear();
            }
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder3 = this.slidingBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.clear();
            }
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder4 = this.serveBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.clear();
            }
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder5 = this.receiveBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.clear();
            }
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder6 = this.tossBuilder_;
            if (singleFieldBuilder6 != null) {
                singleFieldBuilder6.clear();
            }
            this.actionDetailCase_ = 0;
            this.actionDetail_ = null;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ActionData) {
                return mergeFrom((ActionData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setBlocking(Blocking.Builder builder) {
            SingleFieldBuilder<Blocking, Blocking.Builder, BlockingOrBuilder> singleFieldBuilder = this.blockingBuilder_;
            if (singleFieldBuilder == null) {
                this.actionDetail_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.actionDetailCase_ = 2;
            return this;
        }

        public Builder setReceive(Receive.Builder builder) {
            SingleFieldBuilder<Receive, Receive.Builder, ReceiveOrBuilder> singleFieldBuilder = this.receiveBuilder_;
            if (singleFieldBuilder == null) {
                this.actionDetail_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.actionDetailCase_ = 5;
            return this;
        }

        public Builder setServe(Serve.Builder builder) {
            SingleFieldBuilder<Serve, Serve.Builder, ServeOrBuilder> singleFieldBuilder = this.serveBuilder_;
            if (singleFieldBuilder == null) {
                this.actionDetail_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.actionDetailCase_ = 4;
            return this;
        }

        public Builder setSliding(Sliding.Builder builder) {
            SingleFieldBuilder<Sliding, Sliding.Builder, SlidingOrBuilder> singleFieldBuilder = this.slidingBuilder_;
            if (singleFieldBuilder == null) {
                this.actionDetail_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.actionDetailCase_ = 3;
            return this;
        }

        public Builder setSpike(Spike.Builder builder) {
            SingleFieldBuilder<Spike, Spike.Builder, SpikeOrBuilder> singleFieldBuilder = this.spikeBuilder_;
            if (singleFieldBuilder == null) {
                this.actionDetail_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.actionDetailCase_ = 1;
            return this;
        }

        public Builder setToss(Toss.Builder builder) {
            SingleFieldBuilder<Toss, Toss.Builder, TossOrBuilder> singleFieldBuilder = this.tossBuilder_;
            if (singleFieldBuilder == null) {
                this.actionDetail_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.actionDetailCase_ = 6;
            return this;
        }

        public Builder mergeFrom(ActionData actionData) {
            if (actionData == ActionData.getDefaultInstance()) {
                return this;
            }
            int iOrdinal = actionData.getActionDetailCase().ordinal();
            if (iOrdinal == 0) {
                mergeSpike(actionData.getSpike());
            } else if (iOrdinal == 1) {
                mergeBlocking(actionData.getBlocking());
            } else if (iOrdinal == 2) {
                mergeSliding(actionData.getSliding());
            } else if (iOrdinal == 3) {
                mergeServe(actionData.getServe());
            } else if (iOrdinal == 4) {
                mergeReceive(actionData.getReceive());
            } else if (iOrdinal == 5) {
                mergeToss(actionData.getToss());
            }
            mergeUnknownFields(actionData.getUnknownFields());
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
                                codedInputStream.readMessage(getSpikeFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.actionDetailCase_ = 1;
                            } else if (tag == 18) {
                                codedInputStream.readMessage(getBlockingFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.actionDetailCase_ = 2;
                            } else if (tag == 26) {
                                codedInputStream.readMessage(getSlidingFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.actionDetailCase_ = 3;
                            } else if (tag == 34) {
                                codedInputStream.readMessage(getServeFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.actionDetailCase_ = 4;
                            } else if (tag == 42) {
                                codedInputStream.readMessage(getReceiveFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.actionDetailCase_ = 5;
                            } else if (tag != 50) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getTossFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.actionDetailCase_ = 6;
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

    private ActionData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.actionDetailCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(ActionData actionData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(actionData);
    }

    public static ActionData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ActionData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActionData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ActionData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static ActionData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private ActionData() {
        this.actionDetailCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ActionData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static ActionData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ActionData parseFrom(InputStream inputStream) {
        return (ActionData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ActionData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActionData parseFrom(CodedInputStream codedInputStream) {
        return (ActionData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ActionData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActionData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
