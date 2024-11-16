ALTER TABLE freight
DROP CONSTRAINT fk_paymentType;

ALTER TABLE freight
RENAME COLUMN paymentType_id TO payment_id;

ALTER TABLE freight
ADD CONSTRAINT fk_payment FOREIGN KEY (payment_id) REFERENCES payment(id);