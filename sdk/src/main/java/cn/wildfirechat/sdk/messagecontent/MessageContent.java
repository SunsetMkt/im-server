package cn.wildfirechat.sdk.messagecontent;

import cn.wildfirechat.pojos.MessagePayload;

import java.util.List;

public abstract class MessageContent {
    private int mentionedType;
    private List<String> mentionedTargets;
    private String extra;
    public MessageContent mentionedType(int mentionedType) {
        this.mentionedType = mentionedType;
        return this;
    }
    public MessageContent mentionedTargets(List<String> mentionedTargets) {
        this.mentionedTargets = mentionedTargets;
        return this;
    }

    public MessageContent extra(String extra) {
        this.extra = extra;
        return this;
    }

    public MessagePayload encode() {
        MessagePayload payload = new MessagePayload();
        payload.setType(getContentType());
        payload.setPersistFlag(getPersistFlag());
        payload.setMentionedType(mentionedType);
        payload.setMentionedTarget(mentionedTargets);
        payload.setExtra(extra);
        return payload;
    }

    protected void decode(MessagePayload payload) {
        this.mentionedType = payload.getMentionedType();
        this.mentionedTargets = payload.getMentionedTarget();
        this.extra = payload.getExtra();
    }
    abstract public int getContentType();
    abstract public int getPersistFlag();
}
