package com.forgeessentials.api.permissions;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;

import com.forgeessentials.api.permissions.types.Group;

@SuppressWarnings("rawtypes")
public interface IPermissionsHelper {
	// Javadocs please
	/**
	 * Check if a permission is allowed.
	 * 
	 * @param player
	 * @param node
	 * @return true if allowed, false if not.
	 */

	boolean checkPermAllowed(EntityPlayer player, String node);

	boolean checkPermAllowed(EntityPlayer player, String node, Object areasel);

	boolean checkPermAllowed(Object areasel, String node);

	String checkPermResult(EntityPlayer p, String node);

	String checkPermResult(EntityPlayer p, String node, Object areasel);

	String checkPermResult(EntityPlayer p, String node, boolean checkForward);

	String checkPermResult(EntityPlayer p, String node, boolean checkForward,
			Object areasel);

	/**
	 * Create a group within a zone
	 * 
	 * @param groupName
	 *            Name of the group
	 * @param zoneName
	 *            Name of the zone the group is under
	 * @param prefix
	 *            Chat prefix
	 * @param suffix
	 *            Chat suffix
	 * @param parent
	 *            Parent group
	 * @param priority
	 *            Priority that the group should be checked in
	 * @return Group created
	 */
	Group createGroupInZone(String groupName, String zoneName, String prefix,
			String suffix, String parent, int priority);

	/**
	 * Set a permission for a player
	 * 
	 * @param username
	 *            The player's username
	 * @param permission
	 *            The permission node name
	 * @param allow
	 *            Is the permission allowed or denied
	 * @param zoneID
	 *            The zone in which the permission takes effect
	 * @return
	 */
	String setPlayerPermission(String username, String permission,
			boolean allow, String zoneID);

	/**
	 * Set a permission for a group
	 * 
	 * @param username
	 *            The group name
	 * @param permission
	 *            The permission node name
	 * @param allow
	 *            Is the permission allowed or denied
	 * @param zoneID
	 *            The zone in which the permission takes effect
	 * @return
	 */
	String setGroupPermission(String group, String permission, boolean allow,
			String zoneID);

	/**
	 * Set a permission prop for a player
	 * 
	 * @param username
	 *            The player's username
	 * @param permission
	 *            The permission node name
	 * @param value
	 *            Value of the permission prop
	 * @param zoneID
	 *            The zone in which the permission takes effect
	 * @return
	 */
	String setPlayerPermissionProp(String username, String permission,
			String value, String zoneID);

	/**
	 * Set a permission for a player
	 * 
	 * @param username
	 *            The player's username
	 * @param permission
	 *            The permission node name
	 * @param value
	 *            Value of the permission prop
	 * @param zoneID
	 *            The zone in which the permission takes effect
	 * @return
	 */
	String setGroupPermissionProp(String group, String permission,
			String value, String zoneID);

	ArrayList<Group> getApplicableGroups(EntityPlayer player,
			boolean includeDefaults);

	ArrayList<Group> getApplicableGroups(String player,
			boolean includeDefaults, String zoneID);

	Group getGroupForName(String name);

	Group getHighestGroup(EntityPlayer player);

	ArrayList<String> getPlayersInGroup(String group, String zone);

	String setPlayerGroup(String group, String player, String zone);

	String addPlayerToGroup(String group, String player, String zone);

	String clearPlayerGroup(String group, String player, String zone);

	String clearPlayerPermission(String player, String node, String zone);

	String clearPlayerPermissionProp(String player, String node, String zone);

	void deleteGroupInZone(String group, String zone);

	boolean updateGroup(Group group);

	String clearGroupPermission(String name, String node, String zone);

	String clearGroupPermissionProp(String name, String node, String zone);

	ArrayList<Group> getGroupsInZone(String zoneName);

	String getPermissionForGroup(String target, String zone, String perm);

	String getPermissionPropForGroup(String target, String zone, String perm);

	String getPermissionForPlayer(String target, String zone, String perm);

	String getPermissionPropForPlayer(String target, String zone, String perm);

	ArrayList getPlayerPermissions(String target, String zone);

	ArrayList getPlayerPermissionProps(String target, String zone);

	ArrayList getGroupPermissions(String target, String zone);

	ArrayList getGroupPermissionProps(String target, String zone);

	String getEPPrefix();

	void setEPPrefix(String ePPrefix);

	String getEPSuffix();

	void setEPSuffix(String ePSuffix);

	Group getDEFAULT();

	String getEntryPlayer();

	/**
	 * This should be done for large ammounts of permissions, where they should
	 * not be exported as defaults but instead only be saved as posible
	 * permitions.
	 * 
	 * @param permission
	 *            Qualified permission node
	 */
	public void registerPermission(String permission);

	/**
	 * This method will register the permission and its default level. This
	 * should be done with ALL permissions as well. If a group is registered
	 * with a given permission, all higher groups will be allowed the
	 * permission, while all lower groups will be denied it.
	 * 
	 * @param permission
	 *            Qualified permission node
	 * @param group
	 *            NULL will deny the permission for everyone.
	 */
	public void registerPermissionLevel(String permission, RegGroup group);

	/**
	 * This method will register the permission and its default level. This
	 * should be done with ALL permissions
	 * 
	 * @param permission
	 *            Qualified permission node
	 * @param group
	 *            NULL will deny the permission for everyone.
	 * @Param alone will only set this permission to this group. Other groups
	 *        will be unaffected.
	 */
	public void registerPermissionLevel(String permission, RegGroup group,
			boolean alone);

	/**
	 * Registers a PermissionProperty for use with a default value.
	 * PermissionProperties not registered will be ignored.
	 * 
	 * @param permission
	 *            permission node to save the property under.
	 * @param globalDefault
	 *            the value saved.
	 */
	public void registerPermissionProp(String permission, String globalDefault);

	/**
	 * Registers a PermissionProperty for use with a default value.
	 * PermissionProperties not registered will be ignored.
	 * 
	 * @param permission
	 *            permission node to save the property under.
	 * @param globalDefault
	 *            the value saved.
	 */
	public void registerPermissionProp(String permission, int globalDefault);

	/**
	 * Registers a PermissionProperty for use with a default value.
	 * PermissionProperties not registered will be ignored.
	 * 
	 * @param permission
	 *            permission node to save the property under.
	 * @param globalDefault
	 *            the value saved.
	 */
	public void registerPermissionProp(String permission, float globalDefault);

	/**
	 * Sets a PermissionProperty for the provided group.
	 * 
	 * @param permission
	 * @param value
	 * @param group
	 */
	public void registerGroupPermissionprop(String permission, String value,
			RegGroup group);

	/**
	 * Sets a PermissionProperty for the provided group.
	 * 
	 * @param permission
	 * @param value
	 * @param group
	 */
	public void registerGroupPermissionprop(String permission, int value,
			RegGroup group);

	/**
	 * Sets a PermissionProperty for the provided group.
	 * 
	 * @param permission
	 * @param value
	 * @param group
	 */
	public void registerGroupPermissionprop(String permission, float value,
			RegGroup group);

}
