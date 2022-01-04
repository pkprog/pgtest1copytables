package ru.pk.testpg1.repository.repossrc;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pk.testpg1.model.modelsrc.ServiceOrderOra;

public interface ServiceOrderOraRepository extends JpaRepository<ServiceOrderOra, Long>, ServiceOrderOraRepositoryCustom {

}
