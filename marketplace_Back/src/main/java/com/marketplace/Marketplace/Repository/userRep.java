package com.marketplace.Marketplace.Repository;

import com.marketplace.Marketplace.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface userRep extends JpaRepository<User,Long>{
}
