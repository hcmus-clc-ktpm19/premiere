package org.hcmus.premiere.service.impl;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.hcmus.premiere.model.enums.PremiereRole;
import org.hcmus.premiere.service.KeycloakService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

  private final RealmResource realmResource;

  @Override
  public UserRepresentation getCurrentUser() {
    KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return realmResource
        .users()
        .get(principal.getName())
        .toRepresentation();
  }

  @Override
  public RoleRepresentation getCurrentUserRole() {
    KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Set<String> allRoleNames = EnumSet.allOf(PremiereRole.class).stream().map(Enum::name).collect(Collectors.toSet());

    return realmResource
        .users()
        .get(principal.getName())
        .roles()
        .realmLevel()
        .listAll()
        .stream()
        .filter(roleRepresentation -> allRoleNames.contains(roleRepresentation.getName()))
        .findFirst()
        .orElse(null);
  }
}
