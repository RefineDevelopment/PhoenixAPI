package xyz.refinedev.phoenix.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface IScope {
    Pattern SCOPE_REGEX = Pattern.compile("g:[A-Za-z0-9-_]+|s:[A-Za-z0-9-_]+|global");

    /**
     * Is the scope valid?
     *
     * @param scope {@link String} Scope
     * @return {@link Boolean} Valid
     */
    static boolean isValid(String scope) {
        return SCOPE_REGEX.matcher(scope).matches();
    }

    /**
     * Get a list of formatted Scopes
     *
     * @param scopes {@link List <Scope>} Scopes
     * @return {@link List<String>} Formatted Scopes
     */
    static List<String> toNiceScopes(List<IScope> scopes) {
        List<String> niceScopes = new ArrayList<>();

        for (IScope scope : scopes) {
            niceScopes.add(scope.getDisplayName());
        }

        return niceScopes;
    }

    /**
     * Is the multiple scope string valid?
     *
     * @param scopes {@link String} Scopes
     * @return {@link Boolean} Valid
     */
    static boolean isValidMultiple(String scopes) {
        String[] args = scopes.split(";");
        if (args.length == 0) return false;

        for (String arg : args) {
            if (!SCOPE_REGEX.matcher(arg).matches()) return false;
        }

        return true;
    }

    /**
     * Get the {@link IScope} Display Name
     *
     * @return {@link String} Display Name
     */
    String getDisplayName();

    /**
     * Is the {@link IScope} a Global Scope?
     *
     * @return {@link Boolean} Global
     */
    boolean isGlobal();

    /**
     * Is the {@link IScope} a Server Scope?
     *
     * @return {@link Boolean} Server
     */
    boolean isServer();

    /**
     * Is the {@link IScope} a Group Scope?
     *
     * @return {@link Boolean} Group
     */
    boolean isGroup();

    /**
     * Get the {@link IScope} Server Name
     *
     * @return {@link String} Server Name
     */
    String getServerName();

    /**
     * Get the {@link IScope} Group Name
     *
     * @return {@link String} Group Name
     */
    String getGroupName();

    @Override
    int hashCode();

    @Override
    boolean equals(Object o);

    String getScope();
}
