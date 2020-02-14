package org.rent.cr.dao.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import org.rent.cr.dao.repo.car.CarRepository;
import org.rent.cr.entity.User;
import org.rent.cr.entity.car.Car;
import org.rent.cr.entity.car.Color;
import org.rent.cr.entity.car.Model;
import org.rent.cr.entity.car.Option;
import org.rent.cr.service.CarService;
import org.rent.cr.service.impl.car.CarServiceImpl;
import org.rent.cr.util.SpringContext;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class GenericRsqlSpecification<T> implements Specification<T> {

    private String property;
    private ComparisonOperator operator;
    private List<String> arguments;

    public GenericRsqlSpecification(final String property, final ComparisonOperator operator, final List<String> arguments) {
        this.property = property;
        this.operator = operator;
        this.arguments = arguments;
    }

    @Override
    public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        checkField(root);
        final List<Object> args = castArguments(root);
        final Object argument = args.get(0);
        final Class<? extends Object> type = root.get(property).getJavaType();
        final Class<? extends Object> modalType = root.getModel().getJavaType();

        CarRepository carRepository = SpringContext.getBean(CarRepository.class);

        switch (RsqlSearchOperation.getSimpleOperator(operator)) {
            case EQUAL: {
                if (type.equals(String.class)) {
                    return builder.like(root.get(property), argument.toString().replace('*', '%'));

                } else if (type.equals(LocalDateTime.class)) {
                    return builder.equal(root.get(property), (LocalDateTime) argument);

                } else if (type.isEnum()) {
                    return builder.equal(root.get(property), (Enum) argument);

                } else if (type.equals(Model.class)) {
                    return builder.equal(root.get(property).get("name"), argument);

                } else if (type.equals(Color.class)) {
                    return builder.equal(root.get(property).get("name"), argument);

                } else if (type.equals(List.class)) {
                    return builder.equal(root.join(property).get("name"), argument);

                } else if (argument == null) {
                    return builder.isNull(root.get(property));

                } else {
                    return builder.equal(root.<Float>get(property), argument);
                }
            }
            case NOT_EQUAL: {
                if (type.equals(String.class)) {
                    return builder.notLike(root.get(property), argument.toString().replace('*', '%'));

                } else if (type.equals(LocalDateTime.class)) {
                    return builder.notEqual(root.get(property), (LocalDateTime) argument);

                } else if (type.isEnum()) {
                    return builder.notEqual(root.get(property), (Enum) argument);

                } else if (type.equals(Model.class)) {
                    return builder.notEqual(root.join(property).get("name"), argument);

                } else if (type.equals(Color.class)) {
                    return builder.notEqual(root.join(property).get("name"), argument);

                } else if (type.equals(Option.class)) {
                    return builder.notEqual(root.join(property).get("name"), argument);

                } else if (type.equals(List.class)) {
                    return builder.equal(root.join(property).get("name"), argument);

                } else if (argument == null) {
                    return builder.isNull(root.get(property));

                } else {
                    return builder.notEqual(root.get(property), argument);
                }
            }
            case GREATER_THAN: {
                if (type.equals(LocalDateTime.class)) {
                    return builder.greaterThan(root.get(property), (LocalDateTime) argument);
                } else {
                    return builder.greaterThan(root.get(property), argument.toString());
                }
            }
            case GREATER_THAN_OR_EQUAL: {
                if (type.equals(LocalDateTime.class)) {
                    return builder.greaterThanOrEqualTo(root.get(property), (LocalDateTime) argument);
                } else {
                    return builder.greaterThanOrEqualTo(root.get(property), argument.toString());
                }
            }
            case LESS_THAN: {
                if (type.equals(LocalDateTime.class)) {
                    return builder.lessThan(root.get(property), (LocalDateTime) argument);
                } else if (type.equals(List.class)) {
                    if (modalType.equals(Car.class))
                    try {
                        query.distinct(true);
                        return builder.not(root.get("id").in(carRepository.getCarIdFromDate((LocalDateTime) argument)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                } else {
                    return builder.lessThan(root.get(property), argument.toString());
                }
            }
            case LESS_THAN_OR_EQUAL: {
                if (type.equals(LocalDateTime.class)) {
                    return builder.lessThanOrEqualTo(root.get(property), (LocalDateTime) argument);
                } else {
                    return builder.lessThanOrEqualTo(root.get(property), argument.toString());
                }
            }
            case IN:
                if (type.equals(Model.class)) {
                    return root.get(property).get("name").in(args);
                } else if (type.equals(List.class)) {
                    return root.join(property).get("name").in(args);
                } else {
                    return root.get(property).in(args);
                }
            case NOT_IN:
                if (type.equals(Model.class)) {
                    return builder.not(root.get(property).get("name").in(args));
                } else if (type.equals(List.class)) {
                    return builder.not(root.join(property).get("name").in(args));
                } else {
                    return builder.not(root.get(property).in(args));
                }
        }
        return null;
    }


    //for blocking some fields of filter
    private void checkField(final Root<T> root) throws IllegalArgumentException {
        final Class<? extends Object> type = root.getModel().getJavaType();
        if (type.equals(User.class)) {
            if (property.equals("password")) {
                throw new IllegalArgumentException("Unable to filter Attribute  with the the given name [" + property + "] on this ManagedType [" + type.getName() + "]");
            }
        }
    }

    private List<Object> castArguments(final Root<T> root) {

        final Class<? extends Object> type = root.get(property).getJavaType();

        final List<Object> args = arguments.stream().map(arg -> {
            if (type.equals(Integer.class)) {
                return Integer.parseInt(arg);
            } else if (type.equals(Long.class)) {
                return Long.parseLong(arg);
            } else if (type.equals(Float.class)) {
                return Float.parseFloat(arg);
            } else if (type.equals(LocalDateTime.class)) {
                return LocalDateTime.parse(arg);
            } else if (type.isEnum()) {
                Object[] enums = type.getEnumConstants();
                for (Object enumerate : enums) {
                    if (((Enum) enumerate).name().equals(arg)) {
                        return ((Enum) enumerate);
                    }
                }
                return null;
            } else if (type.equals(List.class)) {
                if (property.contentEquals("orders")){
                    return LocalDateTime.parse(arg);
                } else {
                    return arg;
                }
            } else {
                return arg;
            }
        }).collect(Collectors.toList());

        return args;
    }

}
