package org.example;

import java.util.*;

public class NotificationManager {
    private final Map<String, Notifier> channels = new HashMap<>();
    private final List<String> history = new ArrayList<>();

    public boolean addEmail(String alias, String address) {
        String normalizeAlias = normalizedAlias(alias);

        if (normalizeAlias.isEmpty() || channels.containsKey(normalizeAlias) || address.trim().isEmpty()) {
            return false;
        }

        EmailNotifier emailNotifier = new EmailNotifier(address);
        channels.put(normalizeAlias, emailNotifier);
        return true;
    }

    public boolean addSms(String alias, String phoneNumber) {
        String normalizeAlias = normalizedAlias(alias);

        if (normalizeAlias.isEmpty() || channels.containsKey(normalizeAlias) || phoneNumber.replace(" ", "").isEmpty()) {
            return false;
        }

        SmsNotifier smsNotifier = new SmsNotifier(phoneNumber);
        channels.put(normalizeAlias, smsNotifier);
        return true;
    }

    public boolean removeChannel(String alias) {
        String normalizeAlias = normalizedAlias(alias);

        Notifier remove = channels.remove(normalizeAlias);
        return remove != null;
    }

    public Map<String, Notifier> getChannels() {
        return channels;
    }

    public boolean sendByAlias(String alias, String message) {
        String normalizeAlias = normalizedAlias(alias);

        Notifier notifier = channels.get(normalizeAlias);

        if (notifier == null || message == null || message.trim().isEmpty()) {
            return false;
        }
        notifier.send(message);
        history.add(notifier.getRecipientKey() + " " + message);
        return true;
    }

    public void sendToAll(String message) {
        if (message == null || message.trim().isEmpty()) {
            return;
        }

        Set<String> sentRecipients = new HashSet<>();

        for (Notifier notifier : channels.values()) {
            if (sentRecipients.add(notifier.getRecipientKey())) {
                notifier.send(message);
                history.add(notifier.getRecipientKey() + " " + message);
            }
        }
    }

    public List<String> getHistory(){
        return history;
    }

    public int getChannelCount() {
        return channels.size();
    }

    private String normalizedAlias(String alias) {
        return alias.trim().toLowerCase();
    }
}