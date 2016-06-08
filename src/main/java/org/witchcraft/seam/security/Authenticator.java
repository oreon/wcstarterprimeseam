package org.witchcraft.seam.security;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.permission.RuleBasedPermissionResolver;
import org.witchcraft.seam.action.UserUtilAction;

import com.td.bbwp.core.domain.users.AppRole;
import com.td.bbwp.core.domain.users.AppUser;

@Name("authenticator")
public class Authenticator {

	@Logger
	Log log;

	@In
	EntityManager entityManager;

	@In
	Credentials credentials;

	@In(required = false)
	Actor actor;

	@In
	Identity identity;
	
	@In
	protected StatusMessages statusMessages;


	public boolean authenticate() {

		try {
			//Session session = (Session) entityManager.getDelegate();

			//session.disableFilter("tenantFilterDef");

			AppUser user = (AppUser) entityManager
					.createQuery(
							"from AppUser where userName = :username and password = :password")
					.setParameter("username", credentials.getUsername())
					.setParameter("password", credentials.getPassword())
					.getSingleResult();
			
			
			

			if (user.getAppRoles() != null) {
				List<AppRole> roles = user.getAppRoles();
				for (AppRole role : roles) {
					if(role != null )
						identity.addRole(role.getName());
				}
			} else {
				log.warn("no role found for user " + user.getUserName());
			}
			updateActor(user);
			UserUtilAction userUtilAction = (UserUtilAction) Component
					.getInstance("userUtilAction");

			RuleBasedPermissionResolver resolver = RuleBasedPermissionResolver
					.instance();
			if (resolver != null) {
				//resolver.getSecurityContext().insert(user);
			}

			userUtilAction.setCurrentUser(user);
			//userUtilAction.setCurrentFacility(currentFacility);
			/*
			 * user.setLastLogin(new Date()); UserAction userAction =
			 * (UserAction) Component.getInstance("userAction");
			 * userAction.setInstance(user); userAction.save();
			 */
			
			//session.enableFilter("tenantFilterDef").setParameter("tenantId",user.getTenant());

			return true;
		}

		catch (NoResultException ex) {

			return false;

		}finally{
			
		}

	}

	private void updateActor(AppUser user) {
		if (actor == null)
			return;
		actor.setId(user.getUserName());
		List<AppRole> roles = user.getAppRoles();
		for (AppRole role : roles) {
			actor.getGroupActorIds().add(role.getName());
		}
	}
	
	protected void addErrorMessage(String message, Object... params) {
		statusMessages.add(Severity.ERROR, message, params);
	}

}