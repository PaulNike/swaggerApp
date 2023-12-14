package com.semana7.swagger.dao;

import com.semana7.swagger.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorDAO extends JpaRepository<EditorEntity,Long> {
}
