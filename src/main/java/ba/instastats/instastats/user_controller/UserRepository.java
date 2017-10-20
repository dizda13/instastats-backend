package ba.instastats.instastats.user_controller;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {

    UserModel findUserModelByUsername(String username);
}