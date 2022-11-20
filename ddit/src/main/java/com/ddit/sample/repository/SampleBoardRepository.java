package com.ddit.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddit.entity.SampleBoard;

@Repository
public interface SampleBoardRepository extends JpaRepository<SampleBoard, Long>{

}
