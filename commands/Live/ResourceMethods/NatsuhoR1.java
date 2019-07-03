package me.Shogatsu.commands.Live.ResourceMethods;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;

import java.util.List;

public class NatsuhoR1 {
    private String roles, members;
    private Role tempRoles;
    private Member tempMembers;

    public String getMembers(List membersList) {
        members = "";
        if (!membersList.isEmpty()) {
            tempMembers = (Member) membersList.get(0);
            members = tempMembers.getEffectiveName();
            for (int i = 1; i < membersList.size(); i++) {
                tempMembers = (Member) membersList.get(i);
                members += ", " + tempMembers.getEffectiveName();
            }
        }
        return members;
    }

    public String getRoles(List rolesList) {
        roles = "";
        if (!rolesList.isEmpty()) {
            tempRoles = (Role) rolesList.get(0);
            roles = tempRoles.getName();
            for (int i = 1; i < rolesList.size(); i++) {
                tempRoles = (Role) rolesList.get(i);
                roles += ", " + tempRoles.getName();
            }
        } else {
            roles = "No Roles";
        }
        return roles;
    }
}
