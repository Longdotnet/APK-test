package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelParcel;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.mAudioAttributes = (AudioAttributes) versionedParcel.readParcelable(audioAttributesImplApi21.mAudioAttributes, 1);
        audioAttributesImplApi21.mLegacyStreamType = versionedParcel.readInt(audioAttributesImplApi21.mLegacyStreamType, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.mAudioAttributes;
        versionedParcel.setOutputField(1);
        ((VersionedParcelParcel) versionedParcel).mParcel.writeParcelable(audioAttributes, 0);
        versionedParcel.writeInt(audioAttributesImplApi21.mLegacyStreamType, 2);
    }
}
