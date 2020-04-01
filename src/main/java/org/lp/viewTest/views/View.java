package org.lp.viewTest.views;

import org.lp.viewTest.models.Role;

import java.util.HashMap;
import java.util.Map;

public class View {
    //public static final Map<Role, Class> MAPPING = new HashMap<>();

    //static {
    //    MAPPING.put(Role.ROLE_ADMIN, Admin.class);
    //    MAPPING.put(Role.ROLE_USER, AuthenticatedUser.class);
    //}

    public interface GuestUser {}
    public interface AuthenticatedUser extends GuestUser {}
    public interface Admin extends AuthenticatedUser {}
}