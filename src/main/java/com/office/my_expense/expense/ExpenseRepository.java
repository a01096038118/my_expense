package com.office.my_expense.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    // 목록 : 지출 날짜 최신순, 같은 날짜면 ID 최신순
    List<ExpenseEntity> findAllByOrderByExpenseDateDescIdDesc();

    // 월별 합계 : 시작일, 다음 달 시작일 범위 합산, 없으면 0
    @Query("""
            SELECT COALESCE(SUM(e.amount),0)
            FROM ExpenseEntity e
            WHERE e.expenseDate >= :start
                AND e.expenseDate < :end
            """)
    Long sumAmountBetween(@Param("start") LocalDate start,
                          @Param("end") LocalDate end);

}
