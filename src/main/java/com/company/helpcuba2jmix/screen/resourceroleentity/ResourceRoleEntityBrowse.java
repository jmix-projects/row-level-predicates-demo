package com.company.helpcuba2jmix.screen.resourceroleentity;

import io.jmix.ui.screen.*;
import io.jmix.securitydata.entity.ResourceRoleEntity;

@UiController("sec_ResourceRoleEntity.browse")
@UiDescriptor("resource-role-entity-browse.xml")
@LookupComponent("resourceRoleEntitiesTable")
public class ResourceRoleEntityBrowse extends StandardLookup<ResourceRoleEntity> {
}