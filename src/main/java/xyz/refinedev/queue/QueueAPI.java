package xyz.refinedev.queue;

import org.bukkit.plugin.IllegalPluginAccessException;
import xyz.refinedev.queue.queue.QueuePlayer;
import xyz.refinedev.queue.queue.impl.Queue;

import java.util.UUID;

/**
 * This Project is the property of Phoenix Development © 2022
 * Redistribution of this Project is not allowed
 *
 * @author Creaxx
 * @since 8/24/2022
 * Project: pxQueue
 */
public class QueueAPI {

    public static QueueAPI INSTANCE;

    public QueueAPI() {
        INSTANCE = this;
    }

    public void addPlayerToQueue(UUID uuid, String queueName) {
        throw new IllegalPluginAccessException("You need to install the plugin.");
    }

    public void removePlayerFromQueue(UUID uuid) {
        throw new IllegalPluginAccessException("You need to install the plugin.");
    }

    public boolean isInQueue(UUID uuid) {
        throw new IllegalPluginAccessException("You need to install the plugin.");
    }

    public Queue getPlayerQueue(UUID uuid) {
        throw new IllegalPluginAccessException("You need to install the plugin.");
    }

    public Queue getByName(String name) {
        throw new IllegalPluginAccessException("You need to install the plugin.");
    }
}
