package xyz.refinedev.phoenix.server;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface IServerData {
    public void update(IServerData serverData);

    /**
     * Is the {@link IServerData} whitelisted?
     *
     * @return {@link Boolean} Whitelisted
     */
    public boolean isWhitelisted();

    /**
     * Is the {@link IServerData} online?
     *
     * @return {@link Boolean} Online
     */
    public boolean isOnline();

    @Override
    public int hashCode();

    @Override
    public boolean equals(Object o);

    public String getServerName();

    public String getDisplayName();

    public Set<String> getServerGroups();

    public String getRegion();

    public String getVersion();

    public long getStartedAt();

    public int getPort();

    public long getLastTick();

    public double getTps();

    public int getMaxPlayers();

    public IWhitelistInfo getWhitelistInfo();

    public boolean isCountPlayers();

    public List<UUID> getOnlinePlayers();

    public Map<String, String> getMetaData();

    public void setDisplayName(String displayName);

    public void setServerGroups(Set<String> serverGroups);

    public void setRegion(String region);

    public void setVersion(String version);

    public void setStartedAt(long startedAt);

    public void setPort(int port);

    public void setLastTick(long lastTick);

    public void setTps(double tps);

    public void setMaxPlayers(int maxPlayers);

    public void setWhitelistInfo(IWhitelistInfo whitelistInfo);

    public void setCountPlayers(boolean countPlayers);

    public void setOnlinePlayers(List<UUID> onlinePlayers);

    public void setMetaData(Map<String, String> metaData);
}
