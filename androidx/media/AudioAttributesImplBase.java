package androidx.media;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    public int mUsage = 0;
    public int mContentType = 0;
    public int mFlags = 0;
    public int mLegacyStream = -1;

    public final boolean equals(Object obj) {
        int i;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.mContentType == audioAttributesImplBase.mContentType) {
            int i2 = this.mFlags;
            int i3 = audioAttributesImplBase.mFlags;
            int i4 = audioAttributesImplBase.mLegacyStream;
            if (i4 == -1) {
                int i5 = audioAttributesImplBase.mUsage;
                int i6 = AudioAttributesCompat.$r8$clinit;
                if ((i3 & 1) != 1) {
                    if ((i3 & 4) != 4) {
                        switch (i5) {
                            case 2:
                                i = 0;
                                break;
                            case 3:
                                i = 8;
                                break;
                            case 4:
                                i = 4;
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i = 5;
                                break;
                            case 6:
                                i = 2;
                                break;
                            case 11:
                                i = 10;
                                break;
                            case 12:
                            default:
                                i = 3;
                                break;
                            case 13:
                                i = 1;
                                break;
                        }
                    } else {
                        i = 6;
                    }
                } else {
                    i = 7;
                }
            } else {
                i = i4;
            }
            if (i == 6) {
                i3 |= 4;
            } else if (i == 7) {
                i3 |= 1;
            }
            if (i2 == (i3 & 273) && this.mUsage == audioAttributesImplBase.mUsage && this.mLegacyStream == i4) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    public final String toString() {
        String strM;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream != -1) {
            sb.append(" stream=");
            sb.append(this.mLegacyStream);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i = this.mUsage;
        int i2 = AudioAttributesCompat.$r8$clinit;
        switch (i) {
            case 0:
                strM = "USAGE_UNKNOWN";
                break;
            case 1:
                strM = "USAGE_MEDIA";
                break;
            case 2:
                strM = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strM = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strM = "USAGE_ALARM";
                break;
            case 5:
                strM = "USAGE_NOTIFICATION";
                break;
            case 6:
                strM = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strM = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strM = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strM = CyjpdoedCdLTIO.CyhRGunI;
                break;
            case 10:
                strM = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strM = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strM = ZRqOdXiy.nihEduYRSbnF;
                break;
            case 13:
                strM = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strM = "USAGE_GAME";
                break;
            case 15:
            default:
                strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "unknown usage ");
                break;
            case 16:
                strM = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strM);
        sb.append(" content=");
        sb.append(this.mContentType);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.mFlags).toUpperCase());
        return sb.toString();
    }
}
