package ru.pk.testpg1.copy.so;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pk.testpg1.model.modeldsc.ServiceOrderPg;
import ru.pk.testpg1.model.modelsrc.ServiceOrderOra;
import ru.pk.testpg1.repository.reposdsc.ServiceOrderPgRepository;

@Service
public class ServiceOrderWriteDst {

    @Transactional(value = "secondaryTm", readOnly = false)
    public List<Long> writeAll(List<ServiceOrderOra> source) {
        List<Long> result = new ArrayList<>();

        for (ServiceOrderOra soOld: source) {
            ServiceOrderPg soNew = new ServiceOrderPg();
            soNew.setId(soOld.getId());
            soNew.setComOrderId(soOld.getComOrderId());
            soNew.setServiceTypeId(soOld.getServiceTypeId());
            soNew.setStatusId(soOld.getStatusId());
            soNew.setCreatedAt(soOld.getCreatedAt());
            soNew.setMssEwoId(soOld.getMssEwoId());
            soNew.setSelector(soOld.getSelector());
            soNew.setActivityType(soOld.getActivityType());

            serviceOrderPgRepository.save(soNew);
            result.add(soNew.getId());
        }

        return result;
    }

    private final ServiceOrderPgRepository serviceOrderPgRepository;

    public ServiceOrderWriteDst(ServiceOrderPgRepository serviceOrderPgRepository) {
        this.serviceOrderPgRepository = serviceOrderPgRepository;
    }
}
