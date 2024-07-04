package edu.practice.svc.config.security;

public class SecurityScope {
    public static final String PRE_AUTHORIZE_CAN_CONSULT = "hasAnyAuthority('SCOPE_practice-svc.consult','SCOPE_practice-svc.manage')";
    public static final String PRE_AUTHORIZE_CAN_MANAGE = "hasAuthority('SCOPE_practice-svc.manage')";
}
