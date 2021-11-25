package ar.edu.unq.solotravel.backend.api.specifications;

import ar.edu.unq.solotravel.backend.api.models.Trip;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Expression;
import java.sql.Date;

@Component
public class TripSpecsBuilder implements SpecBuilder<Trip, String>{

    @Override
    public Specification<Trip> buildCriteriaSpecs(String name) {
        return Specification
                .where(this.withName(name))
                .and(this.withStartDate());
    }

    private Specification<Trip> withStartDate() {
        return (root, query, cb) -> {
            Expression<Date> currentDate = cb.currentDate();

             return cb.greaterThan(root.get("startDate"), currentDate);
        };
    }

    private Specification<Trip> withName(String name) {
        return (root, query, cb) -> name == null ? null :
                cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

}
