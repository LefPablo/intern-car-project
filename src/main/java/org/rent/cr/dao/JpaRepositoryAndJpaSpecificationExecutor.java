package org.rent.cr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //unit interfaces for use it in my Entity Service class as extends for generic(you can extends only one class or interface)
public interface JpaRepositoryAndJpaSpecificationExecutor<T, I> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
