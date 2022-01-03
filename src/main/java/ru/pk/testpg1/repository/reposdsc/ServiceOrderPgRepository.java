package ru.pk.testpg1.repository.reposdsc;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pk.testpg1.model.modeldsc.ServiceOrderPg;

public interface ServiceOrderPgRepository extends JpaRepository<ServiceOrderPg, Long> {
}
