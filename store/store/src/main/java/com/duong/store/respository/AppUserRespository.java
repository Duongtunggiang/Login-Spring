package com.duong.store.respository;

import com.duong.store.models.AppUer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRespository extends JpaRepository<AppUer, Long> {
    public AppUer findByEmail(String email);
}
