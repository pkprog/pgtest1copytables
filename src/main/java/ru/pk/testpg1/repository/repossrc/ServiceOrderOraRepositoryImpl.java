package ru.pk.testpg1.repository.repossrc;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import ru.pk.testpg1.model.modelsrc.ServiceOrderOra;

@Repository
public class ServiceOrderOraRepositoryImpl implements ServiceOrderOraRepositoryCustom {

    @Override
    public Page<ServiceOrderOra> getPage(PageRequest request) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        //Записи
        CriteriaQuery<ServiceOrderOra> cr = cb.createQuery(ServiceOrderOra.class);
        Root<ServiceOrderOra> so = cr.from(ServiceOrderOra.class);
        cr.orderBy(cb.asc(so.get("id")));

        //Total rows count
        CriteriaQuery<Long> crTotal = cb.createQuery(Long.class);
        Root<ServiceOrderOra> historyTotal = crTotal.from(ServiceOrderOra.class);
        crTotal.select(cb.count(historyTotal));
        Long total = em.createQuery(crTotal).getSingleResult();

        List<ServiceOrderOra> results;
        if (total > 0) {
            TypedQuery<ServiceOrderOra> tq = em.createQuery(cr);
            tq.setFirstResult((int)request.getOffset());
            tq.setMaxResults(request.getPageSize());
            //
            results = tq.getResultList();
        } else {
            results = Collections.emptyList();
        }

        return new PageImpl<>(results, request, total);
    }


    @PersistenceContext(name = "primaryEm")
    private EntityManager em;

}
