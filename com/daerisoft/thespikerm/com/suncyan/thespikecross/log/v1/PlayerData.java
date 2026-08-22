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
public final class PlayerData extends GeneratedMessage implements PlayerDataOrBuilder {
    private static final PlayerData DEFAULT_INSTANCE;
    public static final int IS_EPD_FIELD_NUMBER = 1;
    public static final int IS_ON_FLOOR_FIELD_NUMBER = 5;
    public static final int IS_SLIDE_FIELD_NUMBER = 2;
    private static final Parser<PlayerData> PARSER;
    public static final int PLAYER_ID_FIELD_NUMBER = 4;
    public static final int PLAYER_PHYS_DATA_FIELD_NUMBER = 8;
    public static final int PLAYER_STATUS_DATA_FIELD_NUMBER = 7;
    public static final int PLAYER_TEAM_FIELD_NUMBER = 6;
    public static final int USER_PLAYER_ID_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private boolean isEpd_;
    private boolean isOnFloor_;
    private boolean isSlide_;
    private byte memoizedIsInitialized;
    private int playerId_;
    private PlayerPhysData playerPhysData_;
    private PlayerStatusData playerStatusData_;
    private int playerTeam_;
    private int userPlayerId_;

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 29, 5, "", PlayerData.class.getName());
        DEFAULT_INSTANCE = new PlayerData();
        PARSER = new AbstractParser<PlayerData>() { // from class: com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerData.1
            @Override // com.google.protobuf.Parser
            public PlayerData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = PlayerData.newBuilder();
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

    public static /* synthetic */ int access$1276(PlayerData playerData, int i) {
        int i2 = i | playerData.bitField0_;
        playerData.bitField0_ = i2;
        return i2;
    }

    public static PlayerData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PlayerData parseDelimitedFrom(InputStream inputStream) {
        return (PlayerData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlayerData parseFrom(ByteBuffer byteBuffer) {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<PlayerData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlayerData)) {
            return super.equals(obj);
        }
        PlayerData playerData = (PlayerData) obj;
        if (getIsEpd() != playerData.getIsEpd() || getIsSlide() != playerData.getIsSlide() || getUserPlayerId() != playerData.getUserPlayerId() || getPlayerId() != playerData.getPlayerId() || getIsOnFloor() != playerData.getIsOnFloor() || getPlayerTeam() != playerData.getPlayerTeam() || hasPlayerStatusData() != playerData.hasPlayerStatusData()) {
            return false;
        }
        if ((!hasPlayerStatusData() || getPlayerStatusData().equals(playerData.getPlayerStatusData())) && hasPlayerPhysData() == playerData.hasPlayerPhysData()) {
            return (!hasPlayerPhysData() || getPlayerPhysData().equals(playerData.getPlayerPhysData())) && getUnknownFields().equals(playerData.getUnknownFields());
        }
        return false;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public boolean getIsEpd() {
        return this.isEpd_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public boolean getIsOnFloor() {
        return this.isOnFloor_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public boolean getIsSlide() {
        return this.isSlide_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlayerData> getParserForType() {
        return PARSER;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public int getPlayerId() {
        return this.playerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public PlayerPhysData getPlayerPhysData() {
        PlayerPhysData playerPhysData = this.playerPhysData_;
        return playerPhysData == null ? PlayerPhysData.getDefaultInstance() : playerPhysData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public PlayerPhysDataOrBuilder getPlayerPhysDataOrBuilder() {
        PlayerPhysData playerPhysData = this.playerPhysData_;
        return playerPhysData == null ? PlayerPhysData.getDefaultInstance() : playerPhysData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public PlayerStatusData getPlayerStatusData() {
        PlayerStatusData playerStatusData = this.playerStatusData_;
        return playerStatusData == null ? PlayerStatusData.getDefaultInstance() : playerStatusData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public PlayerStatusDataOrBuilder getPlayerStatusDataOrBuilder() {
        PlayerStatusData playerStatusData = this.playerStatusData_;
        return playerStatusData == null ? PlayerStatusData.getDefaultInstance() : playerStatusData;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public int getPlayerTeam() {
        return this.playerTeam_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        boolean z = this.isEpd_;
        int iComputeBoolSize = z ? CodedOutputStream.computeBoolSize(1, z) : 0;
        boolean z2 = this.isSlide_;
        if (z2) {
            iComputeBoolSize += CodedOutputStream.computeBoolSize(2, z2);
        }
        int i2 = this.userPlayerId_;
        if (i2 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(3, i2);
        }
        int i3 = this.playerId_;
        if (i3 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(4, i3);
        }
        boolean z3 = this.isOnFloor_;
        if (z3) {
            iComputeBoolSize += CodedOutputStream.computeBoolSize(5, z3);
        }
        int i4 = this.playerTeam_;
        if (i4 != 0) {
            iComputeBoolSize += CodedOutputStream.computeInt32Size(6, i4);
        }
        if ((1 & this.bitField0_) != 0) {
            iComputeBoolSize += CodedOutputStream.computeMessageSize(7, getPlayerStatusData());
        }
        if ((this.bitField0_ & 2) != 0) {
            iComputeBoolSize += CodedOutputStream.computeMessageSize(8, getPlayerPhysData());
        }
        int serializedSize = getUnknownFields().getSerializedSize() + iComputeBoolSize;
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public int getUserPlayerId() {
        return this.userPlayerId_;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public boolean hasPlayerPhysData() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
    public boolean hasPlayerStatusData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int playerTeam = getPlayerTeam() + ((((Internal.hashBoolean(getIsOnFloor()) + ((((getPlayerId() + ((((getUserPlayerId() + ((((Internal.hashBoolean(getIsSlide()) + ((((Internal.hashBoolean(getIsEpd()) + ((((getDescriptor().hashCode() + 779) * 37) + 1) * 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53);
        if (hasPlayerStatusData()) {
            playerTeam = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(playerTeam, 37, 7, 53) + getPlayerStatusData().hashCode();
        }
        if (hasPlayerPhysData()) {
            playerTeam = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(playerTeam, 37, 8, 53) + getPlayerPhysData().hashCode();
        }
        int iHashCode = getUnknownFields().hashCode() + (playerTeam * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerData.class, Builder.class);
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
        boolean z = this.isEpd_;
        if (z) {
            codedOutputStream.writeBool(1, z);
        }
        boolean z2 = this.isSlide_;
        if (z2) {
            codedOutputStream.writeBool(2, z2);
        }
        int i = this.userPlayerId_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        int i2 = this.playerId_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
        boolean z3 = this.isOnFloor_;
        if (z3) {
            codedOutputStream.writeBool(5, z3);
        }
        int i3 = this.playerTeam_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(6, i3);
        }
        if ((this.bitField0_ & 1) != 0) {
            codedOutputStream.writeMessage(7, getPlayerStatusData());
        }
        if ((this.bitField0_ & 2) != 0) {
            codedOutputStream.writeMessage(8, getPlayerPhysData());
        }
        getUnknownFields().writeTo(codedOutputStream);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerDataOrBuilder {
        private int bitField0_;
        private boolean isEpd_;
        private boolean isOnFloor_;
        private boolean isSlide_;
        private int playerId_;
        private SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> playerPhysDataBuilder_;
        private PlayerPhysData playerPhysData_;
        private SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> playerStatusDataBuilder_;
        private PlayerStatusData playerStatusData_;
        private int playerTeam_;
        private int userPlayerId_;

        private void buildPartial0(PlayerData playerData) {
            int i;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                playerData.isEpd_ = this.isEpd_;
            }
            if ((i2 & 2) != 0) {
                playerData.isSlide_ = this.isSlide_;
            }
            if ((i2 & 4) != 0) {
                playerData.userPlayerId_ = this.userPlayerId_;
            }
            if ((i2 & 8) != 0) {
                playerData.playerId_ = this.playerId_;
            }
            if ((i2 & 16) != 0) {
                playerData.isOnFloor_ = this.isOnFloor_;
            }
            if ((i2 & 32) != 0) {
                playerData.playerTeam_ = this.playerTeam_;
            }
            if ((i2 & 64) != 0) {
                SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
                playerData.playerStatusData_ = singleFieldBuilder == null ? this.playerStatusData_ : (PlayerStatusData) singleFieldBuilder.build();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder2 = this.playerPhysDataBuilder_;
                playerData.playerPhysData_ = singleFieldBuilder2 == null ? this.playerPhysData_ : (PlayerPhysData) singleFieldBuilder2.build();
                i |= 2;
            }
            PlayerData.access$1276(playerData, i);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerData_descriptor;
        }

        private SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> getPlayerPhysDataFieldBuilder() {
            if (this.playerPhysDataBuilder_ == null) {
                this.playerPhysDataBuilder_ = new SingleFieldBuilder<>(getPlayerPhysData(), getParentForChildren(), isClean());
                this.playerPhysData_ = null;
            }
            return this.playerPhysDataBuilder_;
        }

        private SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> getPlayerStatusDataFieldBuilder() {
            if (this.playerStatusDataBuilder_ == null) {
                this.playerStatusDataBuilder_ = new SingleFieldBuilder<>(getPlayerStatusData(), getParentForChildren(), isClean());
                this.playerStatusData_ = null;
            }
            return this.playerStatusDataBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getPlayerStatusDataFieldBuilder();
                getPlayerPhysDataFieldBuilder();
            }
        }

        public Builder clearIsEpd() {
            this.bitField0_ &= -2;
            this.isEpd_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsOnFloor() {
            this.bitField0_ &= -17;
            this.isOnFloor_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsSlide() {
            this.bitField0_ &= -3;
            this.isSlide_ = false;
            onChanged();
            return this;
        }

        public Builder clearPlayerId() {
            this.bitField0_ &= -9;
            this.playerId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPlayerPhysData() {
            this.bitField0_ &= -129;
            this.playerPhysData_ = null;
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder = this.playerPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.playerPhysDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearPlayerStatusData() {
            this.bitField0_ &= -65;
            this.playerStatusData_ = null;
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.playerStatusDataBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder clearPlayerTeam() {
            this.bitField0_ &= -33;
            this.playerTeam_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUserPlayerId() {
            this.bitField0_ &= -5;
            this.userPlayerId_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerData_descriptor;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public boolean getIsEpd() {
            return this.isEpd_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public boolean getIsOnFloor() {
            return this.isOnFloor_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public boolean getIsSlide() {
            return this.isSlide_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public int getPlayerId() {
            return this.playerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public PlayerPhysData getPlayerPhysData() {
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder = this.playerPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerPhysData) singleFieldBuilder.getMessage();
            }
            PlayerPhysData playerPhysData = this.playerPhysData_;
            return playerPhysData == null ? PlayerPhysData.getDefaultInstance() : playerPhysData;
        }

        public PlayerPhysData.Builder getPlayerPhysDataBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (PlayerPhysData.Builder) getPlayerPhysDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public PlayerPhysDataOrBuilder getPlayerPhysDataOrBuilder() {
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder = this.playerPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerPhysDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlayerPhysData playerPhysData = this.playerPhysData_;
            return playerPhysData == null ? PlayerPhysData.getDefaultInstance() : playerPhysData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public PlayerStatusData getPlayerStatusData() {
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerStatusData) singleFieldBuilder.getMessage();
            }
            PlayerStatusData playerStatusData = this.playerStatusData_;
            return playerStatusData == null ? PlayerStatusData.getDefaultInstance() : playerStatusData;
        }

        public PlayerStatusData.Builder getPlayerStatusDataBuilder() {
            this.bitField0_ |= 64;
            onChanged();
            return (PlayerStatusData.Builder) getPlayerStatusDataFieldBuilder().getBuilder();
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public PlayerStatusDataOrBuilder getPlayerStatusDataOrBuilder() {
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder != null) {
                return (PlayerStatusDataOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlayerStatusData playerStatusData = this.playerStatusData_;
            return playerStatusData == null ? PlayerStatusData.getDefaultInstance() : playerStatusData;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public int getPlayerTeam() {
            return this.playerTeam_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public int getUserPlayerId() {
            return this.userPlayerId_;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public boolean hasPlayerPhysData() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.PlayerDataOrBuilder
        public boolean hasPlayerStatusData() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TheSpikeCrossLog.internal_static_com_suncyan_thespikecross_log_v1_PlayerData_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergePlayerPhysData(PlayerPhysData playerPhysData) {
            PlayerPhysData playerPhysData2;
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder = this.playerPhysDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(playerPhysData);
            } else if ((this.bitField0_ & 128) == 0 || (playerPhysData2 = this.playerPhysData_) == null || playerPhysData2 == PlayerPhysData.getDefaultInstance()) {
                this.playerPhysData_ = playerPhysData;
            } else {
                getPlayerPhysDataBuilder().mergeFrom(playerPhysData);
            }
            if (this.playerPhysData_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder mergePlayerStatusData(PlayerStatusData playerStatusData) {
            PlayerStatusData playerStatusData2;
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.mergeFrom(playerStatusData);
            } else if ((this.bitField0_ & 64) == 0 || (playerStatusData2 = this.playerStatusData_) == null || playerStatusData2 == PlayerStatusData.getDefaultInstance()) {
                this.playerStatusData_ = playerStatusData;
            } else {
                getPlayerStatusDataBuilder().mergeFrom(playerStatusData);
            }
            if (this.playerStatusData_ != null) {
                this.bitField0_ |= 64;
                onChanged();
            }
            return this;
        }

        public Builder setIsEpd(boolean z) {
            this.isEpd_ = z;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setIsOnFloor(boolean z) {
            this.isOnFloor_ = z;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setIsSlide(boolean z) {
            this.isSlide_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setPlayerId(int i) {
            this.playerId_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setPlayerPhysData(PlayerPhysData playerPhysData) {
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder = this.playerPhysDataBuilder_;
            if (singleFieldBuilder == null) {
                playerPhysData.getClass();
                this.playerPhysData_ = playerPhysData;
            } else {
                singleFieldBuilder.setMessage(playerPhysData);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setPlayerStatusData(PlayerStatusData playerStatusData) {
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder == null) {
                playerStatusData.getClass();
                this.playerStatusData_ = playerStatusData;
            } else {
                singleFieldBuilder.setMessage(playerStatusData);
            }
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setPlayerTeam(int i) {
            this.playerTeam_ = i;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setUserPlayerId(int i) {
            this.userPlayerId_ = i;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerData build() {
            PlayerData playerDataBuildPartial = buildPartial();
            if (playerDataBuildPartial.isInitialized()) {
                return playerDataBuildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) playerDataBuildPartial);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerData buildPartial() {
            PlayerData playerData = new PlayerData(this);
            if (this.bitField0_ != 0) {
                buildPartial0(playerData);
            }
            onBuilt();
            return playerData;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerData getDefaultInstanceForType() {
            return PlayerData.getDefaultInstance();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.isEpd_ = false;
            this.isSlide_ = false;
            this.userPlayerId_ = 0;
            this.playerId_ = 0;
            this.isOnFloor_ = false;
            this.playerTeam_ = 0;
            this.playerStatusData_ = null;
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.playerStatusDataBuilder_ = null;
            }
            this.playerPhysData_ = null;
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder2 = this.playerPhysDataBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.playerPhysDataBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PlayerData) {
                return mergeFrom((PlayerData) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setPlayerPhysData(PlayerPhysData.Builder builder) {
            SingleFieldBuilder<PlayerPhysData, PlayerPhysData.Builder, PlayerPhysDataOrBuilder> singleFieldBuilder = this.playerPhysDataBuilder_;
            if (singleFieldBuilder == null) {
                this.playerPhysData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setPlayerStatusData(PlayerStatusData.Builder builder) {
            SingleFieldBuilder<PlayerStatusData, PlayerStatusData.Builder, PlayerStatusDataOrBuilder> singleFieldBuilder = this.playerStatusDataBuilder_;
            if (singleFieldBuilder == null) {
                this.playerStatusData_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder mergeFrom(PlayerData playerData) {
            if (playerData == PlayerData.getDefaultInstance()) {
                return this;
            }
            if (playerData.getIsEpd()) {
                setIsEpd(playerData.getIsEpd());
            }
            if (playerData.getIsSlide()) {
                setIsSlide(playerData.getIsSlide());
            }
            if (playerData.getUserPlayerId() != 0) {
                setUserPlayerId(playerData.getUserPlayerId());
            }
            if (playerData.getPlayerId() != 0) {
                setPlayerId(playerData.getPlayerId());
            }
            if (playerData.getIsOnFloor()) {
                setIsOnFloor(playerData.getIsOnFloor());
            }
            if (playerData.getPlayerTeam() != 0) {
                setPlayerTeam(playerData.getPlayerTeam());
            }
            if (playerData.hasPlayerStatusData()) {
                mergePlayerStatusData(playerData.getPlayerStatusData());
            }
            if (playerData.hasPlayerPhysData()) {
                mergePlayerPhysData(playerData.getPlayerPhysData());
            }
            mergeUnknownFields(playerData.getUnknownFields());
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
                                this.isEpd_ = codedInputStream.readBool();
                                this.bitField0_ |= 1;
                            } else if (tag == 16) {
                                this.isSlide_ = codedInputStream.readBool();
                                this.bitField0_ |= 2;
                            } else if (tag == 24) {
                                this.userPlayerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 4;
                            } else if (tag == 32) {
                                this.playerId_ = codedInputStream.readInt32();
                                this.bitField0_ |= 8;
                            } else if (tag == 40) {
                                this.isOnFloor_ = codedInputStream.readBool();
                                this.bitField0_ |= 16;
                            } else if (tag == 48) {
                                this.playerTeam_ = codedInputStream.readInt32();
                                this.bitField0_ |= 32;
                            } else if (tag == 58) {
                                codedInputStream.readMessage(getPlayerStatusDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 64;
                            } else if (tag != 66) {
                                if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                                }
                            } else {
                                codedInputStream.readMessage(getPlayerPhysDataFieldBuilder().getBuilder(), extensionRegistryLite);
                                this.bitField0_ |= 128;
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

    private PlayerData(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.isEpd_ = false;
        this.isSlide_ = false;
        this.userPlayerId_ = 0;
        this.playerId_ = 0;
        this.isOnFloor_ = false;
        this.playerTeam_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Builder newBuilder(PlayerData playerData) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(playerData);
    }

    public static PlayerData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlayerData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerData) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerData parseFrom(ByteString byteString) {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlayerData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public static PlayerData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static PlayerData parseFrom(byte[] bArr) {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static PlayerData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlayerData parseFrom(InputStream inputStream) {
        return (PlayerData) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlayerData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerData) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private PlayerData() {
        this.isEpd_ = false;
        this.isSlide_ = false;
        this.userPlayerId_ = 0;
        this.playerId_ = 0;
        this.isOnFloor_ = false;
        this.playerTeam_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PlayerData parseFrom(CodedInputStream codedInputStream) {
        return (PlayerData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlayerData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PlayerData) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
