package repository;

import model.Activity;
import model.Camper;
import model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CamperRepository extends JpaRepository<Camper, Long> {
    Camper findByName(String name);

    void deleteByName(String name);
}

public class ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findByName(String name);

    void deleteByName(String name);
}

public class SignUpRepository extends JpaRepository<SignUp, Long> {
    SignUp findByName(String name);

    void deleteByName(String name);
}
