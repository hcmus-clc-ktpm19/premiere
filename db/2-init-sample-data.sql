SET SEARCH_PATH TO premiere;

INSERT INTO "user"(first_name, last_name, dob, gender, email, phone, pan_number, address, avatar)
VALUES ('Nam', 'Nguyen Duc', '01/01/2001', 'MALE', 'keke@gmail.com', '0987654321', 'pan_number',
        'address', 'avatar');
INSERT INTO "user"(first_name, last_name, dob, gender, email, phone, pan_number, address, avatar)
VALUES ('Giap', 'Hoang Huu', '01/01/2001', 'FEMALE', 'hehe@gmail.com', '0987654322',
        'pan_number', 'address', 'avatar');
INSERT INTO "user"(first_name, last_name, dob, gender, email, phone, pan_number, address, avatar)
VALUES ('Nhat', 'Le Ngoc Minh', '01/01/2001', 'MALE', 'hihi@gmail.com', '0987654323',
        'pan_number', 'address', 'avatar');


INSERT INTO "bank"(bank_name)
VALUES ('Premierebank');
INSERT INTO "bank"(bank_name)
VALUES ('Vietcombank');
INSERT INTO "bank"(bank_name)
VALUES ('Vietinbank');
INSERT INTO "bank"(bank_name)
VALUES ('Techcombank');

INSERT INTO "credit_card"(user_id, balance, open_day, card_number)
VALUES (2, 100000, CURRENT_TIMESTAMP, '1234567890123456');

INSERT INTO "credit_card"(user_id, balance, open_day, card_number)
VALUES (1, 11111111111111, CURRENT_TIMESTAMP, '1234567890123457');

INSERT INTO "loan_reminder"(loan_balance, sender_credit_card_id, receiver_credit_card_id, status, time, loan_remark)
VALUES (100000, 1, 2, 'APPROVED', CURRENT_TIMESTAMP, 'hehe');

INSERT INTO "loan_reminder"(loan_balance, sender_credit_card_id, receiver_credit_card_id, status, time, loan_remark)
VALUES (120000, 2, 1, 'PENDING', CURRENT_TIMESTAMP, 'tra tien cho toi');

INSERT INTO "receiver"(card_number, nickname, full_name, user_id, bank_id)
VALUES ('1234567890123456', 'Nam', 'Nguyen Duc Nam', 2, 1);
INSERT INTO "receiver"(card_number, nickname, full_name, user_id, bank_id)
VALUES ('1234567890123457', 'Giap', 'Hoang Huu Giap', 1, 2);
INSERT INTO "receiver"(card_number, nickname, full_name, user_id, bank_id)
VALUES ('1234567890123456', 'Nhat', 'Le Ngoc Minh Nhat', 1, 3);