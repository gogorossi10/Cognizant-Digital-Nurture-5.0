SET SERVEROUTPUT ON;

---------------------------------------------------------
-- Scenario 1
-- Apply a 1% discount to loan interest rates
-- for customers above 60 years old
---------------------------------------------------------

DECLARE
BEGIN
    FOR cust IN (
        SELECT c.CustomerID,
               c.Age,
               l.LoanID,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF cust.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = cust.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied to Customer ID: ' || cust.CustomerID
            );

        END IF;
    END LOOP;

    COMMIT;
END;
/

---------------------------------------------------------
-- Scenario 2
-- Promote customers with balance > 10000 to VIP
---------------------------------------------------------

DECLARE
BEGIN
    FOR cust IN (
        SELECT CustomerID,
               Balance
        FROM Customers
    )
    LOOP
        IF cust.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ID ' || cust.CustomerID || ' promoted to VIP.'
            );

        END IF;
    END LOOP;

    COMMIT;
END;
/

---------------------------------------------------------
-- Scenario 3
-- Print reminders for loans due within 30 days
---------------------------------------------------------

BEGIN
    FOR loan_rec IN (
        SELECT c.Name,
               l.LoanID,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate <= SYSDATE + 30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || loan_rec.LoanID ||
            ' for customer ' || loan_rec.Name ||
            ' is due on ' ||
            TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );

    END LOOP;
END;
/