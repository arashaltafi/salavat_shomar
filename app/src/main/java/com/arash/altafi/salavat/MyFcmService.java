package com.arash.altafi.salavat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.pushpole.sdk.PushPole;

public class MyFcmService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (PushPole.getFcmHandler(this).onMessageReceived(remoteMessage)) {
            // Message belongs to PushPole, no further action needed
            return;
        }

        // Message does not belong to PushPole, process message...
    }

    @Override
    public void onNewToken(String s) {
        PushPole.getFcmHandler(this).onNewToken(s);
    }

    @Override
    public void onMessageSent(String s) {
        PushPole.getFcmHandler(this).onMessageSent(s);
    }

    @Override
    public void onSendError(String s, Exception e) {
        PushPole.getFcmHandler(this).onSendError(s, e);
    }

    @Override
    public void onDeletedMessages() {
        PushPole.getFcmHandler(this).onDeletedMessages();
    }
}