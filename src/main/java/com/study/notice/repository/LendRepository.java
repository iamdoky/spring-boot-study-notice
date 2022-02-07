package com.study.notice.repository;

import com.study.notice.model.Book;
import com.study.notice.model.Lend;
import com.study.notice.model.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status );
}
