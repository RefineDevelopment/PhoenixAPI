package xyz.refinedev.phoenix.profile.grant;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.phoenix.profile.log.ILogable;
import xyz.refinedev.phoenix.rank.IRank;
import xyz.refinedev.phoenix.scope.IScope;
import xyz.refinedev.phoenix.utils.Exclude;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * This Project is the property of Refine Development © 2023
 * Redistribution of this Project is not allowed
 *
 * @author Creaxx
 * Created At: 06/12/2022
 * Project: Phoenix
 */

public interface IGrant extends ILogable {
    @Exclude
    GrantComparator COMPARATOR = new GrantComparator();

    /**
     * Is a {@link IGrant} Active on any {@link IScope}?
     *
     * @return {@link Boolean} Active
     */
    @Override
    boolean isActive();

    /**
     * Is the {@link IGrant} Active on the current {@link IScope}?
     *
     * @return {@link Boolean} Active
     */
    boolean isActiveOnOneScope();

    /**
     * Is the {@link IGrant} Active on a specific Server or Group?
     *
     * @return {@link Boolean} Active
     */
    boolean isScope(String server, Set<String> groups);

    /**
     * Is the {@link IGrant} available on the current {@link IScope}?
     *
     * @return {@link Boolean} Available
     */
    boolean isScope();

    /**
     * Is the {@link IGrant} Global?
     *
     * @return {@link Boolean} Global
     */
    boolean isGlobal();

    /**
     * Is the {@link IGrant} specifically available on that Group?
     *
     * @return {@link Boolean} Available
     */
    boolean hasGroup(String group);

    /**
     * Is the {@link IGrant} specifically available on that Server?
     *
     * @return {@link Boolean} Available
     */
    boolean hasServer(String server);

    /**
     * Get the Active formatted Scopes
     *
     * @return {@link List<String>} Scopes
     */
    @NotNull
    List<String> getNiceActiveScopes();

    /**
     * Get the Current Scopes that are currently Active
     *
     * @return {@link List<IScope>}
     */
    @NotNull
    List<IScope> getActiveScopes();

    /**
     * Is the {@link IGrant} specifically available on that Scope?
     *
     * @return {@link Boolean} Available
     */
    boolean hasScope(IScope toCheck);

    /**
     * Get the formatted Scopes
     *
     * @return {@link List<IScope>}
     */
    @NotNull
    List<String> getNiceScopes();

    /**
     * Get the Remaining Duration of the {@link IGrant}
     *
     * @return {@link Long} Remaining
     */
    long getRemainingDuration();

    /**
     * Get the {@link IRank} of the {@link IGrant}
     *
     * @return {@link IRank}
     */
    @Nullable
    IRank getRank();

    UUID getRankId();

    List<IScope> getScopes();

    void setRankId(UUID rankId);

    void setScopes(List<IScope> scopes);
}
