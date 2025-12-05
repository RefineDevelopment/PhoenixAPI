package xyz.refinedev.phoenix.handler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.phoenix.CommonPlatform;
import xyz.refinedev.phoenix.server.IServerData;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface INetworkHandler {
    /**
     * Load {@link CommonPlatform} Metadata from {@link File}
     */
    void loadMetadata();

    /**
     * Save {@link CommonPlatform} Metadata from {@link File}
     */
    void saveMetadata();

    /**
     * Fetch servers from redis and cache.
     */
    void fetchServers();

    /**
     * Fetch proxies from redis and cache.
     */
    void fetchProxies();

    /**
     * Delete a Server from Redis and the Cache
     *
     * @param serverData {@link IServerData} Server
     */
    void deleteServer(IServerData serverData);

    /**
     * Delete a Proxy from Redis and the Cache
     *
     * @param serverData {@link IServerData} Proxy
     */
    void deleteProxy(IServerData serverData);

    /**
     * Get the current Server of a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link IServerData} Server
     */
    @Nullable
    IServerData getPresence(UUID uuid);

    /**
     * Get the current formatted Server of a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link String} Server Name
     */
    String getNicePresence(UUID uuid);

    /**
     * Get the current Proxy of a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link IServerData} Proxy
     */
    IServerData getProxy(UUID uuid);

    /**
     * Get the current formatted Proxy of a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link String} Proxy Name
     */
    String getNiceProxy(UUID uuid);

    /**
     * Is a server online?
     *
     * @param name {@link String} Server Name
     * @return {@link Boolean} Server Online
     */
    boolean isServerOnline(String name);

    /**
     * Is a profile online?
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link Boolean} Online
     */
    boolean isOnline(UUID uuid);

    /**
     * Is a profile online?
     *
     * @param uuid  {@link UUID} Profile UUID
     * @param proxy {@link Boolean} Check on the Proxy only
     * @return {@link Boolean} Online
     */
    boolean isOnline(UUID uuid, boolean proxy);

    /**
     * Get or Create a Server
     *
     * @param name {@link String} Name
     * @return {@link IServerData} Server
     */
    @NotNull
    IServerData getOrAddServer(String name);

    /**
     * Get or Create a Proxy
     *
     * @param name {@link String} Name
     * @return {@link IServerData} Proxy
     */
    @NotNull
    IServerData getOrAddProxyServer(String name);

    /**
     * Get a Server from its Name
     *
     * @param name {@link String} Name
     * @return {@link IServerData} Server
     */
    @Nullable
    IServerData getServerByName(String name);

    /**
     * Get a Proxy from its Name
     *
     * @param name {@link String} Name
     * @return {@link IServerData} Proxy
     */
    @Nullable
    IServerData getProxyByName(String name);

    /**
     * Get all Groups
     *
     * @return {@link List<String>} Groups
     */
    @NotNull
    List<String> getGroups();

    /**
     * Get all Proxy Groups
     *
     * @return {@link List<String>} Proxy Groups
     */
    @NotNull
    List<String> getProxyGroups();

    /**
     * Get the Servers in a Group
     *
     * @param group {@link String} Group
     * @return {@link Set< IServerData>} Servers
     */
    @NotNull
    Set<IServerData> getServersInGroup(String group);

    /**
     * Get the Proxies in a Group
     *
     * @param group {@link String} Group
     * @return {@link Set< IServerData>} Proxies
     */
    @NotNull
    Set<IServerData> getProxiesInGroup(String group);

    /**
     * Get the Server Names in a Group
     *
     * @param group {@link String} Group
     * @return {@link List<String>} Server Names
     */
    @NotNull
    List<String> getServersByGroup(String group);

    /**
     * Does a Group exist?
     *
     * @param group {@link String} Group
     * @return {@link Boolean} Exists
     */
    boolean doesGroupExist(String group);

    /**
     * Get the UUIDs of all Profiles currently online
     *
     * @return {@link Set<UUID>} UUIDs
     */
    @NotNull
    Set<UUID> getAllUuids();

    /**
     * Get the UUIDs of all Profiles currently online
     * on servers with {@link IServerData#isCountPlayers()}
     *
     * @return {@link Set<UUID>} UUIDs
     */
    @NotNull
    Set<UUID> getAllUuidsOnCount();

    /**
     * Get the Online Profile UUIDs of a Server
     *
     * @param serverData {@link IServerData} Server
     * @return {@link List<UUID>} UUIDs
     */
    @NotNull
    List<UUID> getOnlinePlayers(IServerData serverData);

    /**
     * Get the Online Profile UUIDs of a Server
     * that are currently vanished
     *
     * @param serverData {@link IServerData} Server
     * @return {@link List<UUID>} UUIDs
     */
    @NotNull
    List<UUID> getOnlyVanishedOnlinePlayers(IServerData serverData);

    /**
     * Get the Online Profile UUIDs of a Server
     * that are not currently vanished
     *
     * @param serverData {@link IServerData} Server
     * @return {@link List<UUID>} UUIDs
     */
    List<UUID> getNonVanishedOnlinePlayers(IServerData serverData);

    /**
     * Get the max player count
     *
     * @return {@link Integer} Max
     */
    int getMax();

    /**
     * Get the current amount of non-vanished online players
     *
     * @return {@link Integer} Online
     */
    int getOnline();

    /**
     * Get the current amount online
     * including vanished players
     *
     * @return {@link Integer} Online
     */
    int getAllOnline();

    Set<IServerData> getServers();

    Set<IServerData> getProxies();

    String getServerName();

    String getDisplayName();

    Set<String> getServerGroups();

    String getRegion();

    String getWebsite();

    String getStore();

    String getDiscord();

    String getTeamspeak();

    String getTwitter();

    String getIp();

    boolean isServerJoinable();

    void setServerJoinable(boolean serverJoinable);
}

