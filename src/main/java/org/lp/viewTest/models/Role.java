package org.lp.viewTest.models;

import java.util.Map;

public class Role {
    public static Role ROLE_USER = new Role("ROLE_USER");
    public static Role ROLE_ADMIN = new Role("ROLE_ADMIN");
    private static Map<String, Role> rolesMap = Map.of("ROLE_USER", ROLE_USER, "ROLE_ADMIN", ROLE_ADMIN);

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public static Role get(String key) {
        return rolesMap.getOrDefault(key, null);
    }

    public String getShort() {
        return this.role.replace("ROLE_", "");
    }

    @Override
    public String toString() {
        return this.role;
    }

}