package ru.pk.testpg1.copy.so;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pk.testpg1.model.modelsrc.ServiceOrderOra;
import ru.pk.testpg1.repository.repossrc.ServiceOrderOraRepository;

@Service
public class ServiceOrderReadSrc {

    @Transactional(value = "primaryTm", readOnly = true)
    public Page<ServiceOrderOra> readPage(PageRequest request) {
        Page<ServiceOrderOra> res = serviceOrderOraRepository.getPage(request);

        for (ServiceOrderOra so: res.getContent()) {
            Hibernate.initialize(so);
        }

        return res;
    }


    private final ServiceOrderOraRepository serviceOrderOraRepository;

    public ServiceOrderReadSrc(ServiceOrderOraRepository serviceOrderOraRepository) {
        this.serviceOrderOraRepository = serviceOrderOraRepository;
    }

}
