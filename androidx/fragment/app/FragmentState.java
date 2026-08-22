package androidx.fragment.app;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.IResultReceiver$Stub$Proxy;
import android.support.v4.os.ResultReceiver;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentState;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.versionedparcelable.ParcelImpl;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.AuthenticationTokenHeader;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.DeviceAuthMethodHandler;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new AnonymousClass1(0);
    public final Bundle mArguments;
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final boolean mHidden;
    public final int mMaxLifecycleState;
    public final boolean mRemoving;
    public final boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    public final String mTag;
    public final String mWho;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentState$1 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class AnonymousClass1 implements Parcelable.Creator {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentState[i];
                case 1:
                    return new MediaBrowserCompat$MediaItem[i];
                case 2:
                    return new MediaDescriptionCompat[i];
                case 3:
                    return new MediaMetadataCompat[i];
                case 4:
                    return new RatingCompat[i];
                case 5:
                    return new MediaSessionCompat$QueueItem[i];
                case 6:
                    return new MediaSessionCompat$ResultReceiverWrapper[i];
                case 7:
                    return new MediaSessionCompat$Token[i];
                case 8:
                    return new ParcelableVolumeInfo[i];
                case 9:
                    return new PlaybackStateCompat[i];
                case 10:
                    return new ResultReceiver[i];
                case 11:
                    return new ActivityResult[i];
                case 12:
                    return new IntentSenderRequest[i];
                case 13:
                    return new AppCompatSpinner.SavedState[i];
                case 14:
                    return new NestedScrollView.SavedState[i];
                case 15:
                    return new BackStackRecordState[i];
                case 16:
                    return new BackStackState[i];
                case 17:
                    return new FragmentManager.LaunchedFragmentInfo[i];
                case 18:
                    return new FragmentManagerState[i];
                case 19:
                    return new ParcelImpl[i];
                case 20:
                    return new AccessToken[i];
                case 21:
                    return new AuthenticationToken[i];
                case 22:
                    return new AuthenticationTokenClaims[i];
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    return new AuthenticationTokenHeader[i];
                case 24:
                    return new FacebookRequestError[i];
                case 25:
                    return new GraphRequest.ParcelableResourceWithMimeType[i];
                case 26:
                    return new Profile[i];
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    return new CustomTabLoginMethodHandler[i];
                case 28:
                    return new DeviceAuthDialog.RequestState[i];
                default:
                    return new DeviceAuthMethodHandler[i];
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(final Parcel parcel) {
            Uri mediaUri;
            Bundle bundle;
            IResultReceiver iResultReceiver = null;
            String str = YcVWhnLsj.SCCRKzdpkvFAmE;
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentState(parcel);
                case 1:
                    return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                        public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new FragmentState.AnonymousClass1(1);
                        public final MediaDescriptionCompat mDescription;
                        public final int mFlags;

                        {
                            this.mFlags = parcel.readInt();
                            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        }

                        @Override // android.os.Parcelable
                        public final int describeContents() {
                            return 0;
                        }

                        public final String toString() {
                            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
                        }

                        @Override // android.os.Parcelable
                        public final void writeToParcel(Parcel parcel2, int i) {
                            parcel2.writeInt(this.mFlags);
                            this.mDescription.writeToParcel(parcel2, i);
                        }
                    };
                case 2:
                    Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                    if (objCreateFromParcel == null) {
                        return null;
                    }
                    MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                    String mediaId = mediaDescription.getMediaId();
                    CharSequence title = mediaDescription.getTitle();
                    CharSequence subtitle = mediaDescription.getSubtitle();
                    CharSequence description = mediaDescription.getDescription();
                    Bitmap iconBitmap = mediaDescription.getIconBitmap();
                    Uri iconUri = mediaDescription.getIconUri();
                    Bundle extras = mediaDescription.getExtras();
                    if (extras != null) {
                        extras.setClassLoader(ExceptionsKt.class.getClassLoader());
                        mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                    } else {
                        mediaUri = null;
                    }
                    if (mediaUri == null) {
                        bundle = extras;
                    } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                        bundle = null;
                    } else {
                        extras.remove("android.support.v4.media.description.MEDIA_URI");
                        extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                        bundle = extras;
                    }
                    if (mediaUri == null) {
                        mediaUri = mediaDescription.getMediaUri();
                    }
                    MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                    mediaDescriptionCompat.mDescriptionObj = objCreateFromParcel;
                    return mediaDescriptionCompat;
                case 3:
                    return new MediaMetadataCompat(parcel);
                case 4:
                    return new RatingCompat(parcel.readInt(), parcel.readFloat());
                case 5:
                    return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                        public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new FragmentState.AnonymousClass1(5);
                        public final MediaDescriptionCompat mDescription;
                        public final long mId;

                        {
                            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                            this.mId = parcel.readLong();
                        }

                        @Override // android.os.Parcelable
                        public final int describeContents() {
                            return 0;
                        }

                        public final String toString() {
                            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
                        }

                        @Override // android.os.Parcelable
                        public final void writeToParcel(Parcel parcel2, int i) {
                            this.mDescription.writeToParcel(parcel2, i);
                            parcel2.writeLong(this.mId);
                        }
                    };
                case 6:
                    MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                    mediaSessionCompat$ResultReceiverWrapper.mResultReceiver = (android.os.ResultReceiver) android.os.ResultReceiver.CREATOR.createFromParcel(parcel);
                    return mediaSessionCompat$ResultReceiverWrapper;
                case 7:
                    final Parcelable parcelable = parcel.readParcelable(null);
                    return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                        public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new FragmentState.AnonymousClass1(7);
                        public final Parcelable mInner;

                        {
                            this.mInner = parcelable;
                        }

                        @Override // android.os.Parcelable
                        public final int describeContents() {
                            return 0;
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof MediaSessionCompat$Token)) {
                                return false;
                            }
                            MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
                            Parcelable parcelable2 = this.mInner;
                            if (parcelable2 == null) {
                                return mediaSessionCompat$Token.mInner == null;
                            }
                            Parcelable parcelable3 = mediaSessionCompat$Token.mInner;
                            if (parcelable3 == null) {
                                return false;
                            }
                            return parcelable2.equals(parcelable3);
                        }

                        public final int hashCode() {
                            Parcelable parcelable2 = this.mInner;
                            if (parcelable2 == null) {
                                return 0;
                            }
                            return parcelable2.hashCode();
                        }

                        @Override // android.os.Parcelable
                        public final void writeToParcel(Parcel parcel2, int i) {
                            parcel2.writeParcelable(this.mInner, i);
                        }
                    };
                case 8:
                    ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                    parcelableVolumeInfo.volumeType = parcel.readInt();
                    parcelableVolumeInfo.controlType = parcel.readInt();
                    parcelableVolumeInfo.maxVolume = parcel.readInt();
                    parcelableVolumeInfo.currentVolume = parcel.readInt();
                    parcelableVolumeInfo.audioStream = parcel.readInt();
                    return parcelableVolumeInfo;
                case 9:
                    return new PlaybackStateCompat(parcel);
                case 10:
                    ResultReceiver resultReceiver = new ResultReceiver();
                    IBinder strongBinder = parcel.readStrongBinder();
                    int i = ResultReceiver.MyResultReceiver.$r8$clinit;
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(IResultReceiver.DESCRIPTOR);
                        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IResultReceiver)) {
                            IResultReceiver$Stub$Proxy iResultReceiver$Stub$Proxy = new IResultReceiver$Stub$Proxy();
                            iResultReceiver$Stub$Proxy.mRemote = strongBinder;
                            iResultReceiver = iResultReceiver$Stub$Proxy;
                        } else {
                            iResultReceiver = (IResultReceiver) iInterfaceQueryLocalInterface;
                        }
                    }
                    resultReceiver.mReceiver = iResultReceiver;
                    return resultReceiver;
                case 11:
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ActivityResult(parcel.readInt(), parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
                case 12:
                    Intrinsics.checkNotNullParameter(parcel, "inParcel");
                    Parcelable parcelable2 = parcel.readParcelable(IntentSender.class.getClassLoader());
                    Intrinsics.checkNotNull(parcelable2);
                    return new IntentSenderRequest((IntentSender) parcelable2, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
                case 13:
                    AppCompatSpinner.SavedState savedState = new AppCompatSpinner.SavedState(parcel);
                    savedState.mShowDropdown = parcel.readByte() != 0;
                    return savedState;
                case 14:
                    NestedScrollView.SavedState savedState2 = new NestedScrollView.SavedState(parcel);
                    savedState2.scrollPosition = parcel.readInt();
                    return savedState2;
                case 15:
                    return new BackStackRecordState(parcel);
                case 16:
                    return new BackStackState(parcel);
                case 17:
                    FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = new FragmentManager.LaunchedFragmentInfo();
                    launchedFragmentInfo.mWho = parcel.readString();
                    launchedFragmentInfo.mRequestCode = parcel.readInt();
                    return launchedFragmentInfo;
                case 18:
                    FragmentManagerState fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.mPrimaryNavActiveWho = null;
                    fragmentManagerState.mBackStackStateKeys = new ArrayList();
                    fragmentManagerState.mBackStackStates = new ArrayList();
                    fragmentManagerState.mActive = parcel.createStringArrayList();
                    fragmentManagerState.mAdded = parcel.createStringArrayList();
                    fragmentManagerState.mBackStack = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
                    fragmentManagerState.mBackStackIndex = parcel.readInt();
                    fragmentManagerState.mPrimaryNavActiveWho = parcel.readString();
                    fragmentManagerState.mBackStackStateKeys = parcel.createStringArrayList();
                    fragmentManagerState.mBackStackStates = parcel.createTypedArrayList(BackStackState.CREATOR);
                    fragmentManagerState.mLaunchedFragments = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
                    return fragmentManagerState;
                case 19:
                    return new ParcelImpl(parcel);
                case 20:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new AccessToken(parcel);
                case 21:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new AuthenticationToken(parcel);
                case 22:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new AuthenticationTokenClaims(parcel);
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new AuthenticationTokenHeader(parcel);
                case 24:
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new FacebookRequestError(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, false);
                case 25:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new GraphRequest.ParcelableResourceWithMimeType(parcel);
                case 26:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new Profile(parcel);
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new CustomTabLoginMethodHandler(parcel);
                case 28:
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    DeviceAuthDialog.RequestState requestState = new DeviceAuthDialog.RequestState();
                    requestState.authorizationUri = parcel.readString();
                    requestState.userCode = parcel.readString();
                    requestState.requestCode = parcel.readString();
                    requestState.interval = parcel.readLong();
                    requestState.lastPoll = parcel.readLong();
                    return requestState;
                default:
                    Intrinsics.checkNotNullParameter(parcel, str);
                    return new DeviceAuthMethodHandler(parcel);
            }
        }
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mWho = fragment.mWho;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mRemoving = fragment.mRemoving;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
        this.mMaxLifecycleState = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.mClassName);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")}:");
        if (this.mFromLayout) {
            sb.append(" fromLayout");
        }
        int i = this.mContainerId;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.mTag;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.mRetainInstance) {
            sb.append(" retainInstance");
        }
        if (this.mRemoving) {
            sb.append(" removing");
        }
        if (this.mDetached) {
            sb.append(" detached");
        }
        if (this.mHidden) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClassName);
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mRemoving ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeBundle(this.mSavedFragmentState);
        parcel.writeInt(this.mMaxLifecycleState);
    }

    public FragmentState(Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mWho = parcel.readString();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mRemoving = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mHidden = parcel.readInt() != 0;
        this.mSavedFragmentState = parcel.readBundle();
        this.mMaxLifecycleState = parcel.readInt();
    }
}
