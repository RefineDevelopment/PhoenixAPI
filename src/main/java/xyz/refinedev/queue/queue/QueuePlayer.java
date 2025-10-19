package xyz.refinedev.queue.queue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class QueuePlayer implements Comparable<QueuePlayer> {

    private final UUID uuid;
    private final int priority;
    private final long inserted;
    private boolean removed = false;

    @Override
    public int compareTo(QueuePlayer other) {
        throw new UnsupportedOperationException("Install the plugin.");
    }
}
