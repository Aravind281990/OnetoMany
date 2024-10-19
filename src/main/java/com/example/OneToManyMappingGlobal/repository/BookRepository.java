package com.example.OneToManyMappingGlobal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.OneToManyMappingGlobal.model.*;

public interface BookRepository extends JpaRepository<Book, Long> {
}