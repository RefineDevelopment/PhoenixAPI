package xyz.refinedev.phoenix.handler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.phoenix.profile.IProfile;
import xyz.refinedev.phoenix.rank.IRank;
import xyz.refinedev.phoenix.repository.IRankRepository;
import xyz.refinedev.phoenix.scope.IScope;

import java.util.List;
import java.util.UUID;

/**
 * This Project is the property of Refine Development © 2023
 * Redistribution of this Project is not allowed
 *
 * @author Creaxx
 * Created At: 07/12/2022
 * Project: Phoenix
 */

public interface IRankHandler {
    /**
     * Get a Rank by its Name
     *
     * @param name {@link String} Name
     * @return {@link IRank}
     */
    @Nullable IRank getRank(String name);

    /**
     * Get a Rank by its UUID
     *
     * @param uuid {@link UUID} UUID
     * @return {@link IRank}
     */
    @Nullable IRank getRank(UUID uuid);

    /**
     * Get the highest Default {@link IRank}
     *
     * @return {@link IRank}
     */
    @Nullable IRank getDefaultRank();

    /**
     * Get a list of Default Ranks
     *
     * @return {@link List<IRank>}
     */
    @NotNull List<IRank> getDefaultRanks();

    /**
     * Delete a {@link IRank}
     *
     * @param rank {@link IRank} Rank
     */
    void deleteRank(IRank rank);

    /**
     * Update a {@link IRank}
     *
     * @param rank {@link IRank} Rank
     */
    void updateRank(IRank rank);

    /**
     * Update a {@link IRank}
     *
     * @param rank       {@link IRank} Rank
     * @param withUpdate {@link Boolean} Should we update the permissions of the players?
     */
    void updateRank(IRank rank, boolean withUpdate);

    /**
     * Create a {@link IRank}
     *
     * @param name       {@link String} Name
     *
     * @return {@link IRank}
     */
    IRank createRank(String name);

    IScope createScope(String scope) throws IllegalArgumentException;

    IScope getGlobalScope();

    /**
     * Force every server to recalculate all permissions for players with the rank
     */
    void requestPermissionsUpdate(IRank rank);

    /**
     * Get all Sorted Ranks
     *
     * @return {@link List<IRank>}
     */
    @NotNull List<IRank> getSortedRanks();

    /**
     * Get all Sorted Ranks in reversed order
     *
     * @return {@link List<IRank>}
     */
    @NotNull List<IRank> getSortedRanksReversed();

    /**
     * Create a Default Rank
     */
    void createDefaultRank();

    /**
     * Can the granter grant the specified Rank?
     *
     * @param granter {@link IProfile} Granter
     * @param rank    {@link IRank} Rank
     * @return {@link Boolean} Can Grant
     */
    boolean canGrant(IProfile granter, IRank rank);

    IRankRepository getRepository();
}
