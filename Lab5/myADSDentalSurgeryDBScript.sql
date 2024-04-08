INSERT INTO `advdentalsurgeries`.`dentists` (`id`, `firstname`, `lastname`, `phonenumber`, `email`, `specilization`) VALUES
(1, 'John', 'Smith', 1234567890, 'john@example.com', 'Orthodontics'),
(2, 'Emily', 'Johnson', 9876543210, 'emily@example.com', 'Endodontics'),
(3, 'David', 'Brown', 4567890123, 'david@example.com', 'Periodontics');

INSERT INTO `advdentalsurgeries`.`patients` (`id`, `firstname`, `lastname`, `phonenumber`, `email`, `dob`) VALUES
(101, 'Alice', 'White', 1112223333, 'alice@example.com', '1990-05-15'),
(102, 'Bob', 'Green', 4445556666, 'bob@example.com', '1985-08-20'),
(103, 'Carol', 'Black', 7778889999, 'carol@example.com', '1976-12-10');

INSERT INTO `advdentalsurgeries`.`surgery` (`id`, `name`, `phonenumber`, `dentists_id`) VALUES
(1, 'Surgery Center A', 1234567890, 1),
(2, 'Surgery Center B', 9876543210, 2),
(3, 'Surgery Center C', 4567890123, 3);

INSERT INTO `advdentalsurgeries`.`address` (`id`, `location`, `zipcode`) VALUES
(1, '123 Main St', 12345),
(2, '456 Elm St', 54321),
(3, '789 Oak St', 67890);

INSERT INTO `advdentalsurgeries`.`officemanager` (`id`, `firstname`, `lastname`, `phonenumber`, `email`) VALUES
(1, 'Michael', 'Clark', 1112223333, 'michael@example.com'),
(2, 'Jennifer', 'Anderson', 4445556666, 'jennifer@example.com'),
(3, 'Robert', 'Taylor', 7778889999, 'robert@example.com');

INSERT INTO `advdentalsurgeries`.`appointment` (`id`, `date`, `time`, `patients_id`, `surgery_id`, `address_id`, `officemanager_id`) VALUES
(1, '2024-04-10', '2024-04-10 08:00:00', 101, 1, 1, 1),
(2, '2024-04-11', '2024-04-11 09:00:00', 102, 2, 2, 2),
(3, '2024-04-12', '2024-04-12 10:00:00', 103, 3, 3, 3);

 SELECT * FROM advdentalsurgeries.dentists ORDER BY lastname ASC;
 
 SELECT appointment.id AS appointment_id, appointment.date, appointment.time,
       patients.id AS patient_id, patients.firstname AS patient_firstname, patients.lastname AS patient_lastname,
       patients.phonenumber AS patient_phonenumber, patients.email AS patient_email, patients.dob AS patient_dob
FROM advdentalsurgeries.appointment
JOIN advdentalsurgeries.patients ON appointment.patients_id = patients.id
JOIN advdentalsurgeries.surgery ON appointment.surgery_id = surgery.id
WHERE surgery.dentists_id = 2;

SELECT a.id AS appointment_id, a.date, a.time,
       p.firstname AS patient_firstname, p.lastname AS patient_lastname,
       s.name AS surgery_location
FROM advdentalsurgeries.appointment AS a
JOIN advdentalsurgeries.patients AS p ON a.patients_id = p.id
JOIN advdentalsurgeries.surgery AS s ON a.surgery_id = s.id;

SELECT appointment.id AS appointment_id, appointment.date, appointment.time,
       patients.id AS patient_id, patients.firstname AS patient_firstname, patients.lastname AS patient_lastname,
       surgery.name AS surgery_location, address.id AS address_id
FROM advdentalsurgeries.appointment
JOIN advdentalsurgeries.patients ON appointment.patients_id = patients.id
JOIN advdentalsurgeries.surgery ON appointment.surgery_id = surgery.id
JOIN advdentalsurgeries.address ON appointment.address_id = address.id
WHERE address.location = '123 Main St';

SELECT appointment.id AS appointment_id, appointment.date, appointment.time,
       patients.id AS patient_id, patients.firstname AS patient_firstname, patients.lastname AS patient_lastname
FROM advdentalsurgeries.appointment
JOIN advdentalsurgeries.patients ON appointment.patients_id = patients.id
WHERE patients.firstname = 'Alice' 
  AND patients.lastname = 'White' 
  AND appointment.date = '2024-04-10';

SELECT appointment.id AS appointment_id, appointment.date, appointment.time,
       patients.id AS patient_id, patients.firstname AS patient_firstname, patients.lastname AS patient_lastname
FROM advdentalsurgeries.appointment
JOIN advdentalsurgeries.patients ON appointment.patients_id = patients.id
WHERE patients.firstname = 'Bob' 
  AND patients.lastname = 'Green' 
  AND appointment.date = '2024-04-11';