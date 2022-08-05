package repository;

import model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<SignUp, Long> {
    SignUp findByName(String name);

    void deleteByName(String name);
}
