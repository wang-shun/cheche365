package com.cheche365.cheche.core.repository;

import com.cheche365.cheche.core.model.UserSource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunhuazhong on 2015/10/27.
 */
@Repository
public interface UserSourceRepository extends PagingAndSortingRepository<UserSource, Long> {
    UserSource findFirstByName(String name);
}
