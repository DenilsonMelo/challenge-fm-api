ALTER TABLE paymentType RENAME TO payment;

ALTER TABLE payment ADD COLUMN amount TEXT;