package xyz.refinedev.phoenix.rank.scopeable;

import org.jetbrains.annotations.NotNull;
import xyz.refinedev.phoenix.scope.IScope;

import java.util.List;
import java.util.Set;

public interface IScopeable {
    /**
     * Is the {@link IScope} Global?
     *
     * @return {@link Boolean} Global
     */
    boolean isGlobal();

    /**
     * Is the {@link IScope} Active on a specific Server or Group?
     *
     * @return {@link Boolean} Active
     */
    boolean isScope(String server, Set<String> groups);

    /**
     * Is the {@link IScope} available on the current {@link IScope}?
     *
     * @return {@link Boolean} Available
     */
    boolean isScope();

    /**
     * Is the {@link IScope} specifically available on that Group?
     *
     * @return {@link Boolean} Available
     */
    boolean hasGroup(String group);

    /**
     * Is the {@link IScope} specifically available on that Server?
     *
     * @return {@link Boolean} Available
     */
    boolean hasServer(String server);

    /**
     * Is the {@link IScope} specifically available on that Scope?
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

    List<IScope> getScopes();

    void setScopes(List<IScope> scopes);
}
