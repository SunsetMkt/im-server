package cn.wildfirechat.sdk.messagecontent;

import cn.wildfirechat.pojos.MessagePayload;

abstract public class MediaMessageContent extends MessageContent {
    private String remoteMediaUrl;

    public String getRemoteMediaUrl() {
        return remoteMediaUrl;
    }

    public void setRemoteMediaUrl(String remoteMediaUrl) {
        this.remoteMediaUrl = remoteMediaUrl;
    }

    @Override
    public MessagePayload encode() {
        MessagePayload payload = super.encode();
        payload.setRemoteMediaUrl(remoteMediaUrl);
        payload.setMediaType(getMediaType());
        return payload;
    }

    @Override
    public void decode(MessagePayload payload) {
        super.decode(payload);
        remoteMediaUrl = payload.getRemoteMediaUrl();
    }

    protected abstract int getMediaType();
}
