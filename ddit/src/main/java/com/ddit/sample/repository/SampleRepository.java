package com.ddit.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddit.entity.Board;

@Repository
public interface SampleRepository extends JpaRepository<Board, Long>{

}
