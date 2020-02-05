package org.rent.cr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaRepositoryAndJpaSpecificationExecutor<T, I> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
