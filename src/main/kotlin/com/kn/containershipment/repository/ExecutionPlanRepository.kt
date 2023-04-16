package com.kn.containershipment.repository

import com.kn.containershipment.model.ExecutionPlan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExecutionPlanRepository : JpaRepository<ExecutionPlan, Long> {
}