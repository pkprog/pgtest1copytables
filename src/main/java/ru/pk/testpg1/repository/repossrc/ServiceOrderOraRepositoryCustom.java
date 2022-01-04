package ru.pk.testpg1.repository.repossrc;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.pk.testpg1.model.modelsrc.ServiceOrderOra;

public interface ServiceOrderOraRepositoryCustom {

    Page<ServiceOrderOra> getPage(PageRequest request);

}
