package deploy.deploytest.service;


import deploy.deploytest.model.entities.UserEntity;
import deploy.deploytest.model.service.UserRegistrationServiceModel;

public interface UserService {

  void seedUsers();

  void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

  boolean userNameExists(String username);

  UserEntity getUserByUsername(String username);
}
