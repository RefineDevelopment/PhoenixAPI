package xyz.refinedev.phoenix.handler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.phoenix.profile.punishment.IProof;
import xyz.refinedev.phoenix.profile.punishment.IPunishment;
import xyz.refinedev.phoenix.profile.punishment.ProofType;
import xyz.refinedev.phoenix.profile.punishment.PunishmentType;
import xyz.refinedev.phoenix.repository.IPunishmentRepository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * This Project is the property of Refine Development © 2023
 * Redistribution of this Project is not allowed
 *
 * @author Creaxx
 * Created At: 27/12/2022
 * Project: Phoenix
 */

public interface IPunishmentHandler {
    /**
     * Execute a Punishment
     *
     * @param punishment {@link IPunishment} Punishment
     */
    void executePunishment(IPunishment punishment);

    /**
     * Execute a Punishment Revoke
     *
     * @param punishment {@link IPunishment} Punishment
     */
    void executeRevokePunishment(IPunishment punishment);

    /**
     * Get all Punishments from the Database Async
     *
     * @return Punishments
     */
    @NotNull CompletableFuture<List<IPunishment>> getAllPunishments();

    /**
     * Get the Punishments for a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link List<IPunishment>}
     */
    @NotNull List<IPunishment> getPunishments(UUID uuid);

    /**
     * Get the Punishments for a Profile from the Database
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link List<IPunishment>}
     */
    @NotNull List<IPunishment> getDatabasePunishmentsSync(UUID uuid);

    /**
     * Get the Punishments for a Profile from the Database Async
     *
     * @param uuid {@link UUID} Profile UUID
     * @return Punishments
     */
    @NotNull CompletableFuture<List<IPunishment>> getDatabasePunishments(UUID uuid);

    /**
     * Update the Punishments for a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     */
    void updatePunishments(UUID uuid);

    /**
     * Update the Punishments for a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     */
    void updatePunishments(UUID uuid, boolean cache);

    /**
     * Update the Punishments for a Profile Async
     *
     * @param uuid {@link UUID} Profile UUID
     */
    @NotNull CompletableFuture<List<IPunishment>> updatePunishmentsAsync(UUID uuid);

    /**
     * Get the Punishments for a Profile
     * with a specific type
     *
     * @param uuid {@link UUID} Profile UUID
     * @param type {@link PunishmentType} Punishment Type
     * @return {@link List<IPunishment>}
     */
    @NotNull List<IPunishment> getPunishments(UUID uuid, PunishmentType type);

    /**
     * Get the sorted Punishments for a Profile
     * with a specific type
     *
     * @param uuid {@link UUID} Profile UUID
     * @param type {@link PunishmentType} Punishment Type
     * @return {@link List<IPunishment>}
     */
    @NotNull List<IPunishment> getSortedPunishments(UUID uuid, PunishmentType type);

    /**
     * Get the active Punishments for a Profile
     *
     * @param uuid {@link UUID} Profile UUID
     * @return {@link List<IPunishment>}
     */
    @NotNull List<IPunishment> getActivePunishments(UUID uuid);

    /**
     * Does the Profile have an active {@link IPunishment}
     * with that specific type?
     *
     * @param uuid {@link UUID} Profile UUID
     * @param type {@link PunishmentType} Punishment Type
     * @return {@link Boolean} has Active Punishment
     */
    boolean hasActivePunishment(UUID uuid, PunishmentType type);

    /**
     * Get an active {@link IPunishment} for a
     * Profile with a specific type
     *
     * @param uuid {@link UUID} Profile UUID
     * @param type {@link PunishmentType} Punishment Type
     * @return {@link IPunishment}
     */
    @Nullable IPunishment getActivePunishment(UUID uuid, PunishmentType type);

    /**
     * Get an active IP {@link IPunishment} for a
     * Profile with a specific type
     *
     * @param uuid {@link UUID} Profile UUID
     * @param type {@link PunishmentType} Punishment Type
     * @return {@link IPunishment}
     */
    @Nullable IPunishment getActiveIPPunishment(UUID uuid, PunishmentType type);

    /**
     * Get the Issued Punishments for a Profile Async
     *
     * @param uuid {@link UUID} Profile UUID
     * @return Punishments
     */
    @NotNull CompletableFuture<List<IPunishment>> findByIssuedBy(UUID uuid);

    /**
     * Get the Removed Punishments for a Profile Async
     *
     * @param uuid {@link UUID} Profile UUID
     * @return Punishments
     */
    @NotNull CompletableFuture<List<IPunishment>> findByRemovedBy(UUID uuid);

    /**
     * Get a {@link IPunishment} by its punishmentID
     *
     * @param id {@link String} Punishment ID
     * @return Punishments
     */
    @Nullable IPunishment findByPunishmentID(String id);

    @NotNull IPunishment createEmptyPunishment();

    @NotNull IProof createProof(ProofType type, String proof, UUID addedBy);

    IPunishmentRepository getRepository();
}
