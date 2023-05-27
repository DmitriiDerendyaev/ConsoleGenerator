package org.example.repository;

import org.example.models.InteractionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteractionHistoryRepository extends JpaRepository<InteractionHistory, Long> {
    // Дополнительные методы репозитория, если необходимо
}