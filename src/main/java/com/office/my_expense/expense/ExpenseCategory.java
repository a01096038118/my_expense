package com.office.my_expense.expense;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenseCategory {

    FOOD("식비"),
    TRANSPORT("교통"),
    SHOPPING("쇼핑"),
    LIVING("생활"),
    ETC("기타");

    private final String displayName;
}
