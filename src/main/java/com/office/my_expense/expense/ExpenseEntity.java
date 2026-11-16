package com.office.my_expense.expense;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExpenseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long id;                    // 지출 식별자

    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;      // 지출 날짜

    @Column(nullable = false)
    private Integer amount;             // 지출 금액

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(nullable = false, length = 30)
    private ExpenseCategory category;   // 카테고리

    @Column(length = 200)
    private String description;         // 지출 내용

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;     // 등록 일시

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;     // 수정 일시

    public ExpenseEntity(LocalDate expenseDate, Integer amount,
                   ExpenseCategory category, String description) {
        this.expenseDate = expenseDate;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public void update(LocalDate expenseDate, Integer amount,
                       ExpenseCategory category, String description) {
        this.expenseDate = expenseDate;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

}
