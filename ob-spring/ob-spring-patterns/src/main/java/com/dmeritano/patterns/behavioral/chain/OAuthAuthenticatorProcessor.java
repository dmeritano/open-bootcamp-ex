package com.dmeritano.patterns.behavioral.chain;

public class OAuthAuthenticatorProcessor extends AuthenticationProcessor{

	public OAuthAuthenticatorProcessor(AuthenticationProcessor next) {
		super(next);
	}

	@Override
	public boolean isAuthorized(AuthenticationProvider provider) {
		return false;
	}

}
