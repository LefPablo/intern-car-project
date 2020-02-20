package org.rent.cr.dao.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import org.rent.cr.dao.repo.car.CarRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.car.*;
import org.rent.cr.util.EntityUtils;
import org.rent.cr.util.SpringContext;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        Class<? extends Object> type = null;
        final Class<? extends Object> modalType = root.getModel().getJavaType();
        try {
            type = root.get(property).getJavaType();
        } catch (Exception e) {
            if (modalType.equals(Car.class)) {
                if (property.contentEquals("brand")) {
                    type = Brand.class;
                }
            }
        }


        CarRepository carRepository = SpringContext.getBean(CarRepository.class);
        switch (RsqlSearchOperation.getSimpleOperator(operator)) {
            case EQUAL: {
                if (type.equals(String.class)) {
                    return builder.like(builder.lower(root.get(property)), argument.toString().replace('*', '%').toLowerCase());

                } else if (type.equals(LocalDateTime.class)) {
                    return builder.equal(root.get(property), (LocalDateTime) argument);

                } else if (type.isEnum()) {
                    return builder.equal(root.get(property), (Enum) argument);

                } else if (type.equals(Model.class)) {
                    return builder.equal(root.get(property).get("name"), argument);

                } else if (type.equals(Color.class)) {
                    return builder.equal(root.get(property).get("name"), argument);

                } else if (type.equals(List.class)) {
                    return builder.equal(builder.lower(root.get(property).get("name")), argument.toString().toLowerCase());

                }else if (modalType.equals(Car.class)) {
                    if (type.equals(Brand.class)) {
                        return builder.equal(builder.lower(root.get("model").get("brand").get("name")), argument.toString().toLowerCase());
                    }
                    return builder.equal(root.<Float>get(property), argument);
                } else if (argument == null) {
                    return builder.isNull(root.get(property));

                } else {
                    return builder.equal(root.<Float>get(property), argument);
                }
            }
            case NOT_EQUAL: {
                if (type.equals(String.class)) {
                    return builder.notLike(builder.lower(root.get(property)), argument.toString().replace('*', '%').toLowerCase());

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
                    if (modalType.equals(Car.class)) {
                        if (type.equals(Brand.class)) {
                            return builder.notEqual(builder.lower(root.get("model").get("brand").get("name")), argument.toString().toLowerCase());
                        }
                    }
                    return builder.notEqual(builder.lower(root.get(property).get("name")), argument.toString().toLowerCase());

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
                        return builder.not(root.get("id").in(carRepository.getCarIdFromDate((LocalDateTime) argument)));
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
            case IN: {
                if (type.equals(Model.class)) {
                    return root.get(property).get("name").in(args);
                } else if (type.equals(List.class)) {
                    return root.join(property).get("name").in(args);
                } else {
                    return root.get(property).in(args);
                }
            }
            case NOT_IN: {
                if (type.equals(Model.class)) {
                    return builder.not(root.get(property).get("name").in(args));
                } else if (type.equals(List.class)) {
                    return builder.not(root.join(property).get("name").in(args));
                } else {
                    return builder.not(root.get(property).in(args));
                }
            }
        }
        return null;
    }


    //for blocking some fields of filter
    private void checkField(final Root<T> root) throws IllegalArgumentException {
        final Class<? extends Object> type = root.getModel().getJavaType();
        if (type.equals(Employee.class)) {
            if (property.equals("password")) {
                throw new IllegalArgumentException("Denied access for this field");
            }
        }
    }

    private List<Object> castArguments(final Root<T> root) {
        try {
            Class<? extends Object> type = root.get(property).getJavaType();

            final List<Object> args = arguments.stream().map(arg -> {
                if (type.equals(Integer.class)) {
                    return Integer.parseInt(arg);
                } else if (type.equals(Long.class)) {
                    return Long.parseLong(arg);
                } else if (type.equals(Float.class)) {
                    return Float.parseFloat(arg);
                } else if (type.equals(LocalDateTime.class)) {
                    return EntityUtils.parseTimeToLocalDateTime(arg);
                } else if (type.isEnum()) {
                    Object[] enums = type.getEnumConstants();
                    for (Object enumerate : enums) {
                        if (((Enum) enumerate).name().equals(arg)) {
                            return ((Enum) enumerate);
                        }
                    }
                    return null;
                } else if (type.equals(List.class)) {
                    if (property.contentEquals("orders")) {
                        return EntityUtils.parseTimeToLocalDateTime(arg);
                    } else {
                        return arg;
                    }
                } else {
                    return arg;
                }
            }).collect(Collectors.toList());
            return args;
        } catch (Exception e) {
            return new ArrayList<>(arguments);
        }
    }

}
